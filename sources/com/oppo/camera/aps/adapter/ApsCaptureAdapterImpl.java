package com.oppo.camera.aps.adapter;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import android.os.ConditionVariable;
import android.os.Handler;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.adapter.ApsAdapterInterface;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.algorithm.ApsInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ApsCaptureAdapterImpl {
    public static final String TAG = "ApsCaptureAdapterImpl";
    private ConditionVariable mAddFrameConditionVariable = new ConditionVariable();
    private ConcurrentHashMap<Long, Integer> mAddFrameFinishMap = new ConcurrentHashMap<>();
    private final Object mAddFrameLock = new Object();
    private List<ImageCategory.MetaItemInfo> mAddFrameMetadataList = new ArrayList();
    private ApsInterface mApsInterface = null;
    private ConcurrentHashMap<Long, BurstShotParameter> mBurstShotCountMap = new ConcurrentHashMap<>();
    private final Object mBurstShotLock = new Object();
    private int mBurstShotRequestNum = 0;
    private final Object mHeicReceivedLock = new Object();
    private Map<Long, ApsResult> mHeifImageMap = new ConcurrentHashMap();
    private ArrayList<Long> mHeifThumbnailList = new ArrayList<>();
    private Handler mImageProcessHandler = null;
    private ApsAdapterInterface.ImageProcessListener mImageProcessListener = null;
    private ConcurrentHashMap<Long, ImageCategory> mImageProcessMap = new ConcurrentHashMap<>();
    private final Object mImageQueueLock = new Object();
    private ImageCategory mRawImageCategory = null;
    private final Object mRawImageCategoryLock = new Object();
    private boolean mbCaptureFail = false;
    private boolean mbHeicProcessInApp = false;

    private static class BurstShotParameter {
        public int mCShotRequestNum;
        public int mCount;
        public String mCshotPath;
        public int mImageCount;

        private BurstShotParameter() {
            this.mCount = 0;
            this.mImageCount = 0;
            this.mCShotRequestNum = 0;
            this.mCshotPath = null;
        }
    }

    protected ApsCaptureAdapterImpl(ApsInterface apsInterface, ApsAdapterInterface.ImageProcessListener imageProcessListener, Handler handler) {
        this.mApsInterface = apsInterface;
        this.mImageProcessListener = imageProcessListener;
        this.mImageProcessHandler = handler;
    }

    /* access modifiers changed from: protected */
    public int beforeCapture(ImageCategory.MetaItemInfo metaItemInfo) {
        ApsParameters apsParameters = new ApsParameters();
        for (Map.Entry entry : metaItemInfo.mParameterMap.entrySet()) {
            if (1 == ((ApsParameters.Key) entry.getKey()).getCategory()) {
                if (((ApsParameters.ValueWrapper) entry.getValue()).getValue().get() instanceof Object[]) {
                    apsParameters.set(((ApsParameters.Key) entry.getKey()).getName(), Arrays.toString((Object[]) ((ApsParameters.ValueWrapper) entry.getValue()).getValue().get()));
                } else {
                    apsParameters.set(((ApsParameters.Key) entry.getKey()).getName(), String.valueOf(((ApsParameters.ValueWrapper) entry.getValue()).getValue().get()));
                }
            }
        }
        ApsInterface apsInterface = this.mApsInterface;
        if (apsInterface != null) {
            return apsInterface.beforeCapture(apsParameters);
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addImage(com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mImageQueueLock
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP     // Catch:{ all -> 0x00b6 }
            java.lang.Object r1 = r7.get(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x00b6 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r4.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = "addImage, timeStamp: "
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            r4.append(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b6 }
            com.oppo.camera.aps.ApsAdapterLog.d(r3, r4)     // Catch:{ all -> 0x00b6 }
            r3 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r4 = r6.mImageProcessMap     // Catch:{ all -> 0x00b6 }
            if (r4 == 0) goto L_0x005b
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r3 = r6.mImageProcessMap     // Catch:{ all -> 0x00b6 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b6 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ all -> 0x00b6 }
            if (r3 == 0) goto L_0x0048
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r3 = r6.mImageProcessMap     // Catch:{ all -> 0x00b6 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00b6 }
            com.oppo.camera.aps.adapter.ImageCategory r3 = (com.oppo.camera.aps.adapter.ImageCategory) r3     // Catch:{ all -> 0x00b6 }
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r4 = r3.mImageItemList     // Catch:{ all -> 0x00b6 }
            r4.add(r7)     // Catch:{ all -> 0x00b6 }
            goto L_0x005b
        L_0x0048:
            com.oppo.camera.aps.adapter.CaptureImageCategory r3 = new com.oppo.camera.aps.adapter.CaptureImageCategory     // Catch:{ all -> 0x00b6 }
            r3.<init>()     // Catch:{ all -> 0x00b6 }
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r4 = r3.mImageItemList     // Catch:{ all -> 0x00b6 }
            r4.add(r7)     // Catch:{ all -> 0x00b6 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r7 = r6.mImageProcessMap     // Catch:{ all -> 0x00b6 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b6 }
            r7.put(r4, r3)     // Catch:{ all -> 0x00b6 }
        L_0x005b:
            if (r3 != 0) goto L_0x007a
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r3.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = "addImage, timeStamp: "
            r3.append(r4)     // Catch:{ all -> 0x00b6 }
            r3.append(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = " category null."
            r3.append(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00b6 }
            com.oppo.camera.aps.ApsAdapterLog.d(r7, r1)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            return
        L_0x007a:
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r4.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = "addImage, isValid: "
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            boolean r5 = r3.isValid()     // Catch:{ all -> 0x00b6 }
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = ", currentCategory: "
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x00b6 }
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b6 }
            com.oppo.camera.aps.ApsAdapterLog.d(r7, r4)     // Catch:{ all -> 0x00b6 }
            boolean r7 = r3.isValid()     // Catch:{ all -> 0x00b6 }
            if (r7 == 0) goto L_0x00b4
            android.os.Handler r7 = r6.mImageProcessHandler     // Catch:{ all -> 0x00b6 }
            r3 = 3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b6 }
            android.os.Message r7 = r7.obtainMessage(r3, r1)     // Catch:{ all -> 0x00b6 }
            r7.sendToTarget()     // Catch:{ all -> 0x00b6 }
        L_0x00b4:
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            return
        L_0x00b6:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsCaptureAdapterImpl.addImage(com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00af, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addMetadata(com.oppo.camera.aps.adapter.ImageCategory.MetaItemInfo r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mImageQueueLock
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = r7.get(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x00b0 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r4.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = "addMetadata, timeStamp: "
            r4.append(r5)     // Catch:{ all -> 0x00b0 }
            r4.append(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b0 }
            com.oppo.camera.aps.ApsAdapterLog.d(r3, r4)     // Catch:{ all -> 0x00b0 }
            r3 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r4 = r6.mImageProcessMap     // Catch:{ all -> 0x00b0 }
            if (r4 == 0) goto L_0x0055
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r3 = r6.mImageProcessMap     // Catch:{ all -> 0x00b0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b0 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0045
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r3 = r6.mImageProcessMap     // Catch:{ all -> 0x00b0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00b0 }
            com.oppo.camera.aps.adapter.ImageCategory r3 = (com.oppo.camera.aps.adapter.ImageCategory) r3     // Catch:{ all -> 0x00b0 }
            r3.mMetaItem = r7     // Catch:{ all -> 0x00b0 }
            goto L_0x0055
        L_0x0045:
            com.oppo.camera.aps.adapter.CaptureImageCategory r3 = new com.oppo.camera.aps.adapter.CaptureImageCategory     // Catch:{ all -> 0x00b0 }
            r3.<init>()     // Catch:{ all -> 0x00b0 }
            r3.mMetaItem = r7     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r7 = r6.mImageProcessMap     // Catch:{ all -> 0x00b0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b0 }
            r7.put(r4, r3)     // Catch:{ all -> 0x00b0 }
        L_0x0055:
            if (r3 != 0) goto L_0x0074
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r3.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = "addMetaInfo, timeStamp: "
            r3.append(r4)     // Catch:{ all -> 0x00b0 }
            r3.append(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = " category null."
            r3.append(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00b0 }
            com.oppo.camera.aps.ApsAdapterLog.d(r7, r1)     // Catch:{ all -> 0x00b0 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return
        L_0x0074:
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r4.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = "addMetaInfo, isValid: "
            r4.append(r5)     // Catch:{ all -> 0x00b0 }
            boolean r5 = r3.isValid()     // Catch:{ all -> 0x00b0 }
            r4.append(r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = ", currentCategory: "
            r4.append(r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x00b0 }
            r4.append(r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b0 }
            com.oppo.camera.aps.ApsAdapterLog.d(r7, r4)     // Catch:{ all -> 0x00b0 }
            boolean r7 = r3.isValid()     // Catch:{ all -> 0x00b0 }
            if (r7 == 0) goto L_0x00ae
            android.os.Handler r7 = r6.mImageProcessHandler     // Catch:{ all -> 0x00b0 }
            r3 = 3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b0 }
            android.os.Message r7 = r7.obtainMessage(r3, r1)     // Catch:{ all -> 0x00b0 }
            r7.sendToTarget()     // Catch:{ all -> 0x00b0 }
        L_0x00ae:
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return
        L_0x00b0:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsCaptureAdapterImpl.addMetadata(com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addTuningItem(com.oppo.camera.aps.adapter.ImageCategory.TuningItemInfo r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mImageQueueLock
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP     // Catch:{ all -> 0x00b6 }
            java.lang.Object r1 = r7.get(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x00b6 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r4.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = "addTuningItem, timeStamp: "
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            r4.append(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b6 }
            com.oppo.camera.aps.ApsAdapterLog.d(r3, r4)     // Catch:{ all -> 0x00b6 }
            r3 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r4 = r6.mImageProcessMap     // Catch:{ all -> 0x00b6 }
            if (r4 == 0) goto L_0x005b
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r3 = r6.mImageProcessMap     // Catch:{ all -> 0x00b6 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b6 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ all -> 0x00b6 }
            if (r3 == 0) goto L_0x0048
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r3 = r6.mImageProcessMap     // Catch:{ all -> 0x00b6 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00b6 }
            com.oppo.camera.aps.adapter.ImageCategory r3 = (com.oppo.camera.aps.adapter.ImageCategory) r3     // Catch:{ all -> 0x00b6 }
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$TuningItemInfo> r4 = r3.mTuningItemList     // Catch:{ all -> 0x00b6 }
            r4.add(r7)     // Catch:{ all -> 0x00b6 }
            goto L_0x005b
        L_0x0048:
            com.oppo.camera.aps.adapter.CaptureImageCategory r3 = new com.oppo.camera.aps.adapter.CaptureImageCategory     // Catch:{ all -> 0x00b6 }
            r3.<init>()     // Catch:{ all -> 0x00b6 }
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$TuningItemInfo> r4 = r3.mTuningItemList     // Catch:{ all -> 0x00b6 }
            r4.add(r7)     // Catch:{ all -> 0x00b6 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r7 = r6.mImageProcessMap     // Catch:{ all -> 0x00b6 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b6 }
            r7.put(r4, r3)     // Catch:{ all -> 0x00b6 }
        L_0x005b:
            if (r3 != 0) goto L_0x007a
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r3.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = "addTuningItem, timeStamp: "
            r3.append(r4)     // Catch:{ all -> 0x00b6 }
            r3.append(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = " category null."
            r3.append(r1)     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00b6 }
            com.oppo.camera.aps.ApsAdapterLog.d(r7, r1)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            return
        L_0x007a:
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r4.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = "addTuningItem, isValid: "
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            boolean r5 = r3.isValid()     // Catch:{ all -> 0x00b6 }
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = ", currentCategory: "
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x00b6 }
            r4.append(r5)     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b6 }
            com.oppo.camera.aps.ApsAdapterLog.d(r7, r4)     // Catch:{ all -> 0x00b6 }
            boolean r7 = r3.isValid()     // Catch:{ all -> 0x00b6 }
            if (r7 == 0) goto L_0x00b4
            android.os.Handler r7 = r6.mImageProcessHandler     // Catch:{ all -> 0x00b6 }
            r3 = 3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00b6 }
            android.os.Message r7 = r7.obtainMessage(r3, r1)     // Catch:{ all -> 0x00b6 }
            r7.sendToTarget()     // Catch:{ all -> 0x00b6 }
        L_0x00b4:
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            return
        L_0x00b6:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsCaptureAdapterImpl.addTuningItem(com.oppo.camera.aps.adapter.ImageCategory$TuningItemInfo):void");
    }

    public Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, ImageCategory.MetaItemInfo metaItemInfo) {
        ApsParameters apsParameters = new ApsParameters();
        for (Map.Entry entry : metaItemInfo.mParameterMap.entrySet()) {
            if (1 == ((ApsParameters.Key) entry.getKey()).getCategory()) {
                if (((ApsParameters.ValueWrapper) entry.getValue()).getValue().get() instanceof Object[]) {
                    apsParameters.set(((ApsParameters.Key) entry.getKey()).getName(), Arrays.toString((Object[]) ((ApsParameters.ValueWrapper) entry.getValue()).getValue().get()));
                } else {
                    apsParameters.set(((ApsParameters.Key) entry.getKey()).getName(), String.valueOf(((ApsParameters.ValueWrapper) entry.getValue()).getValue().get()));
                }
            }
        }
        ApsInterface apsInterface = this.mApsInterface;
        return apsInterface != null ? apsInterface.processBitmap(bitmap, captureResult, apsParameters) : bitmap;
    }

    /* access modifiers changed from: protected */
    public void waitAddFrameFinish() {
        ConcurrentHashMap<Long, ImageCategory> concurrentHashMap;
        ConcurrentHashMap<Long, ImageCategory> concurrentHashMap2 = this.mImageProcessMap;
        if (concurrentHashMap2 != null && !concurrentHashMap2.isEmpty()) {
            ApsAdapterLog.v(TAG, "waitAddFrameFinish, block");
            this.mAddFrameConditionVariable.block();
        }
        ConcurrentHashMap<Long, Integer> concurrentHashMap3 = this.mAddFrameFinishMap;
        if (concurrentHashMap3 != null && !concurrentHashMap3.isEmpty() && (concurrentHashMap = this.mImageProcessMap) != null && concurrentHashMap.isEmpty()) {
            ApsAdapterLog.e(TAG, "waitAddFrameFinish, the images may be not all arrived, so clear all the hashMap");
            ApsInterface apsInterface = this.mApsInterface;
            if (apsInterface != null) {
                apsInterface.clear();
            }
            this.mAddFrameFinishMap.clear();
            synchronized (this.mAddFrameLock) {
                this.mAddFrameMetadataList.clear();
            }
        }
        resetRawImageCategoryInfo();
    }

    /* access modifiers changed from: protected */
    public void resetRawImageCategoryInfo() {
        synchronized (this.mRawImageCategoryLock) {
            if (this.mRawImageCategory != null) {
                this.mRawImageCategory.releaseImageItemList();
                this.mRawImageCategory = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void countBurstShot(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo) {
        synchronized (this.mBurstShotLock) {
            BurstShotParameter burstShotParameter = this.mBurstShotCountMap.get(imageItemInfo.get(ApsParameters.KEY_BURST_SHOT_FLAG_ID));
            if (burstShotParameter == null) {
                burstShotParameter = new BurstShotParameter();
            }
            burstShotParameter.mCount++;
            burstShotParameter.mCshotPath = (String) imageItemInfo.get(ApsParameters.KEY_CSHOT_PATH);
            if (((Boolean) imageItemInfo.get(ApsParameters.KEY_VALID_BURST_SHOT_IMAGE)).booleanValue()) {
                burstShotParameter.mImageCount++;
            }
            burstShotParameter.mCShotRequestNum = Math.max(burstShotParameter.mCShotRequestNum, ((Integer) metaItemInfo.get(ApsParameters.KEY_CSHOT_REQUEST_NUMER)).intValue());
            ApsAdapterLog.v(TAG, "countBurstShot, mCount: " + burstShotParameter.mCount + ", mCshotPath: " + burstShotParameter.mCshotPath + ", mBurstShotFlagId: " + imageItemInfo.get(ApsParameters.KEY_BURST_SHOT_FLAG_ID) + ", map size: " + this.mBurstShotCountMap.size() + ", metaItemInfo.mCShotRequestNum: " + metaItemInfo.get(ApsParameters.KEY_CSHOT_REQUEST_NUMER) + ", parameter.mCShotRequestNum: " + burstShotParameter.mCShotRequestNum);
            if (burstShotParameter.mCount >= burstShotParameter.mCShotRequestNum) {
                if (this.mImageProcessListener != null) {
                    imageItemInfo.setParameter(ApsParameters.KEY_BURST_COUNT, Integer.valueOf(burstShotParameter.mImageCount));
                    this.mImageProcessListener.onBurstShotEnd(imageItemInfo, metaItemInfo);
                }
                this.mBurstShotCountMap.remove(imageItemInfo.get(ApsParameters.KEY_BURST_SHOT_FLAG_ID));
            } else {
                this.mBurstShotCountMap.put(imageItemInfo.get(ApsParameters.KEY_BURST_SHOT_FLAG_ID), burstShotParameter);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: android.hardware.camera2.CameraMetadata} */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    protected void addFrameAndProcessImage(long r30) {
        /*
            r29 = this;
            r8 = r29
            com.oppo.camera.aps.algorithm.ApsInterface r0 = r8.mApsInterface
            if (r0 != 0) goto L_0x000e
            java.lang.String r0 = TAG
            java.lang.String r1 = "addFrameAndProcessImage, mApsInterface is null"
            com.oppo.camera.aps.ApsAdapterLog.e(r0, r1)
            return
        L_0x000e:
            java.lang.Object r1 = r8.mImageQueueLock
            monitor-enter(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r0 = r8.mImageProcessMap     // Catch:{ all -> 0x04a6 }
            java.lang.Long r2 = java.lang.Long.valueOf(r30)     // Catch:{ all -> 0x04a6 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x04a6 }
            com.oppo.camera.aps.adapter.ImageCategory r0 = (com.oppo.camera.aps.adapter.ImageCategory) r0     // Catch:{ all -> 0x04a6 }
            monitor-exit(r1)     // Catch:{ all -> 0x04a6 }
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "addFrameAndProcessImage, timestamp: "
            r2.append(r3)
            r9 = r30
            r2.append(r9)
            java.lang.String r3 = ", imageCategory: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.oppo.camera.aps.ApsAdapterLog.v(r1, r2)
            r12 = 1
            if (r0 == 0) goto L_0x0463
            boolean r1 = r0.isValid()
            if (r1 == 0) goto L_0x0463
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r1 = r0.mImageItemList
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r13 = r0.mMetaItem
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$TuningItemInfo> r2 = r0.mTuningItemList
            java.lang.Object r3 = r8.mImageQueueLock
            monitor-enter(r3)
            java.util.Iterator r4 = r1.iterator()     // Catch:{ all -> 0x0460 }
            r14 = 0
        L_0x0055:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0460 }
            r6 = 2
            r15 = 0
            if (r5 == 0) goto L_0x0190
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo r5 = (com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo) r5     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_BURST_SHOT     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0460 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0460 }
            if (r7 == 0) goto L_0x0094
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_REC_BURST_NUMBER     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0460 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0460 }
            if (r7 != r12) goto L_0x0094
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r7 = r8.mImageProcessListener     // Catch:{ all -> 0x0460 }
            if (r7 == 0) goto L_0x0094
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r7 = r8.mImageProcessListener     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r14 = com.oppo.camera.aps.adapter.ApsParameters.KEY_BURST_SHOT_FLAG_ID     // Catch:{ all -> 0x0460 }
            java.lang.Object r14 = r5.get(r14)     // Catch:{ all -> 0x0460 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x0460 }
            long r11 = r14.longValue()     // Catch:{ all -> 0x0460 }
            r7.onBurstShotStart(r11)     // Catch:{ all -> 0x0460 }
        L_0x0094:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_BURST_SHOT     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0460 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0460 }
            if (r7 == 0) goto L_0x00b6
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_VALID_BURST_SHOT_IMAGE     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0460 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0460 }
            if (r7 != 0) goto L_0x00b6
            r8.countBurstShot(r5, r13)     // Catch:{ all -> 0x0460 }
            r14 = 0
            goto L_0x018d
        L_0x00b6:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_BURST_SHOT     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0460 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0460 }
            if (r7 == 0) goto L_0x00cd
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_ROLE     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0460 }
            goto L_0x00d5
        L_0x00cd:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_ROLE     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r5.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0460 }
        L_0x00d5:
            int r21 = r7.intValue()     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_FRAME_NUMBER     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0460 }
            long r18 = r7.longValue()     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r5 = r5.mImageBuffer     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<androidx.collection.ArrayMap<java.lang.String, android.hardware.camera2.CameraMetadata>> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_META_MAP     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x0460 }
            androidx.collection.ArrayMap r7 = (androidx.collection.ArrayMap) r7     // Catch:{ all -> 0x0460 }
            if (r7 == 0) goto L_0x0114
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r11 = com.oppo.camera.aps.adapter.ApsParameters.KEY_LOGIC_CAMERA_ID     // Catch:{ all -> 0x0460 }
            java.lang.Object r11 = r13.get(r11)     // Catch:{ all -> 0x0460 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0460 }
            boolean r11 = r7.containsKey(r11)     // Catch:{ all -> 0x0460 }
            if (r11 == 0) goto L_0x0114
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r11 = com.oppo.camera.aps.adapter.ApsParameters.KEY_LOGIC_CAMERA_ID     // Catch:{ all -> 0x0460 }
            java.lang.Object r11 = r13.get(r11)     // Catch:{ all -> 0x0460 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0460 }
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x0460 }
            android.hardware.camera2.CameraMetadata r11 = (android.hardware.camera2.CameraMetadata) r11     // Catch:{ all -> 0x0460 }
            r22 = r11
            goto L_0x0116
        L_0x0114:
            r22 = r15
        L_0x0116:
            if (r7 == 0) goto L_0x012d
            java.lang.String r11 = java.lang.Integer.toString(r21)     // Catch:{ all -> 0x0460 }
            boolean r11 = r7.containsKey(r11)     // Catch:{ all -> 0x0460 }
            if (r11 == 0) goto L_0x012d
            java.lang.String r11 = java.lang.Integer.toString(r21)     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x0460 }
            r15 = r7
            android.hardware.camera2.CameraMetadata r15 = (android.hardware.camera2.CameraMetadata) r15     // Catch:{ all -> 0x0460 }
        L_0x012d:
            r23 = r15
            com.oppo.camera.aps.adapter.ApsParameters$Key<int[]> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_INPUT_SIZE     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x0460 }
            r24 = r7
            int[] r24 = (int[]) r24     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_REPROCESS_META_DATA     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0460 }
            boolean r25 = r7.booleanValue()     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_MAX_HOLD_IMAGES     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0460 }
            int r26 = r7.intValue()     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_PREFER_ADD_FRAME_TYPE     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0460 }
            int r27 = r7.intValue()     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r7 = com.oppo.camera.aps.adapter.ApsParameters.KEY_VIDEO_SNAPSHOT     // Catch:{ all -> 0x0460 }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x0460 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0460 }
            boolean r28 = r7.booleanValue()     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.algorithm.ApsInterface r7 = r8.mApsInterface     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsCaptureParam r11 = new com.oppo.camera.aps.adapter.ApsCaptureParam     // Catch:{ all -> 0x0460 }
            r17 = r11
            r20 = r5
            r17.<init>(r18, r20, r21, r22, r23, r24, r25, r26, r27, r28)     // Catch:{ all -> 0x0460 }
            int r7 = r7.addFrameBuff(r11)     // Catch:{ all -> 0x0460 }
            r11 = 1
            if (r11 != r7) goto L_0x0187
            android.media.ImageReader r6 = r5.getImageReader()     // Catch:{ all -> 0x0460 }
            android.media.Image r5 = r5.getImage()     // Catch:{ all -> 0x0460 }
            com.oppo.camera.aps.adapter.ApsUtils.detachImage(r6, r5)     // Catch:{ all -> 0x0460 }
            goto L_0x018c
        L_0x0187:
            if (r6 != r7) goto L_0x018c
            r5.addRef()     // Catch:{ all -> 0x0460 }
        L_0x018c:
            r14 = 1
        L_0x018d:
            r12 = 1
            goto L_0x0055
        L_0x0190:
            monitor-exit(r3)     // Catch:{ all -> 0x0460 }
            if (r14 == 0) goto L_0x0246
            java.util.Iterator r2 = r2.iterator()
        L_0x0197:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0246
            java.lang.Object r3 = r2.next()
            com.oppo.camera.aps.adapter.ImageCategory$TuningItemInfo r3 = (com.oppo.camera.aps.adapter.ImageCategory.TuningItemInfo) r3
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_ROLE
            java.lang.Object r4 = r3.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r21 = r4.intValue()
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_FRAME_NUMBER
            java.lang.Object r4 = r13.get(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r18 = r4.longValue()
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r3 = r3.mTuningBuffer
            com.oppo.camera.aps.adapter.ApsParameters$Key<androidx.collection.ArrayMap<java.lang.String, android.hardware.camera2.CameraMetadata>> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_META_MAP
            java.lang.Object r4 = r13.get(r4)
            androidx.collection.ArrayMap r4 = (androidx.collection.ArrayMap) r4
            if (r4 == 0) goto L_0x01ea
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r5 = com.oppo.camera.aps.adapter.ApsParameters.KEY_LOGIC_CAMERA_ID
            java.lang.Object r5 = r13.get(r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = r4.containsKey(r5)
            if (r5 == 0) goto L_0x01ea
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r5 = com.oppo.camera.aps.adapter.ApsParameters.KEY_LOGIC_CAMERA_ID
            java.lang.Object r5 = r13.get(r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.Object r4 = r4.get(r5)
            android.hardware.camera2.CameraMetadata r4 = (android.hardware.camera2.CameraMetadata) r4
            r22 = r4
            goto L_0x01ec
        L_0x01ea:
            r22 = r15
        L_0x01ec:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_REPROCESS_META_DATA
            java.lang.Object r4 = r13.get(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r25 = r4.booleanValue()
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_MAX_HOLD_IMAGES
            java.lang.Object r4 = r13.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r26 = r4.intValue()
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_PREFER_ADD_FRAME_TYPE
            java.lang.Object r4 = r13.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r27 = r4.intValue()
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_VIDEO_SNAPSHOT
            java.lang.Object r4 = r13.get(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r28 = r4.booleanValue()
            com.oppo.camera.aps.algorithm.ApsInterface r4 = r8.mApsInterface
            com.oppo.camera.aps.adapter.ApsCaptureParam r5 = new com.oppo.camera.aps.adapter.ApsCaptureParam
            r23 = 0
            r24 = 0
            r17 = r5
            r20 = r3
            r17.<init>(r18, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            int r4 = r4.addFrameBuff(r5)
            r5 = 1
            if (r5 != r4) goto L_0x023f
            android.media.ImageReader r4 = r3.getImageReader()
            android.media.Image r3 = r3.getImage()
            com.oppo.camera.aps.adapter.ApsUtils.detachImage(r4, r3)
            goto L_0x0197
        L_0x023f:
            if (r6 != r4) goto L_0x0197
            r3.addRef()
            goto L_0x0197
        L_0x0246:
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "addFrameAndProcessImage, isNeedProcessImage: "
            r3.append(r4)
            r3.append(r14)
            java.lang.String r4 = ", imageCategory: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.oppo.camera.aps.ApsAdapterLog.v(r2, r3)
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_REPROCESS_META_DATA
            java.lang.Object r2 = r13.get(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r11 = 32
            if (r2 == 0) goto L_0x0295
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r2 = r0.mImageItemList
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo r2 = (com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo) r2
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r3 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_FORMAT
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != r11) goto L_0x0295
            java.lang.Object r2 = r8.mRawImageCategoryLock
            monitor-enter(r2)
            r8.mRawImageCategory = r0     // Catch:{ all -> 0x0292 }
            monitor-exit(r2)     // Catch:{ all -> 0x0292 }
            goto L_0x0295
        L_0x0292:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0292 }
            throw r0
        L_0x0295:
            java.lang.Object r2 = r8.mAddFrameLock
            monitor-enter(r2)
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo> r3 = r8.mAddFrameMetadataList     // Catch:{ all -> 0x045d }
            r3.add(r13)     // Catch:{ all -> 0x045d }
            monitor-exit(r2)     // Catch:{ all -> 0x045d }
            java.lang.Object r3 = r8.mImageQueueLock
            monitor-enter(r3)
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r2 = r0.mImageItemList     // Catch:{ all -> 0x045a }
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x045a }
            r12 = r2
            com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo r12 = (com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo) r12     // Catch:{ all -> 0x045a }
            monitor-exit(r3)     // Catch:{ all -> 0x045a }
            com.oppo.camera.aps.adapter.ApsParameters$Key<com.oppo.camera.aps.ApsCameraRequestTag> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAMERA_REQUEST_TAG
            java.lang.Object r2 = r13.get(r2)
            com.oppo.camera.aps.ApsCameraRequestTag r2 = (com.oppo.camera.aps.ApsCameraRequestTag) r2
            boolean r2 = r2.mbQcom
            if (r2 == 0) goto L_0x02cb
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_MAX_BURST_SHOT_NUM
            java.lang.Object r2 = r13.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r8.mBurstShotRequestNum
            int r2 = java.lang.Math.max(r2, r3)
            goto L_0x02dd
        L_0x02cb:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CSHOT_REQUEST_NUMER
            java.lang.Object r2 = r13.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r8.mBurstShotRequestNum
            int r2 = java.lang.Math.max(r2, r3)
        L_0x02dd:
            r8.mBurstShotRequestNum = r2
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "addFrameAndProcessImage, mBurstShotRequestNum: "
            r3.append(r4)
            int r4 = r8.mBurstShotRequestNum
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.oppo.camera.aps.ApsAdapterLog.d(r2, r3)
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r2 = r8.mImageProcessListener
            if (r2 == 0) goto L_0x0322
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_BURST_SHOT
            java.lang.Object r2 = r12.get(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0322
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_REC_BURST_NUMBER
            java.lang.Object r2 = r12.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r8.mBurstShotRequestNum
            if (r2 < r3) goto L_0x0322
            r7 = 0
            r8.mBurstShotRequestNum = r7
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r2 = r8.mImageProcessListener
            r2.afterAddFrame(r12, r13)
            goto L_0x0323
        L_0x0322:
            r7 = 0
        L_0x0323:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_MERGE_IDENTITY
            java.lang.Object r2 = r13.get(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            int r4 = r1.size()
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_MERGE_NUMBER
            java.lang.Object r1 = r13.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r5 = r1.intValue()
            r6 = 0
            r1 = r29
            r16 = r7
            r7 = r12
            boolean r1 = r1.countAddFrame(r2, r4, r5, r6, r7)
            if (r1 == 0) goto L_0x041a
            if (r14 == 0) goto L_0x041a
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r1 = r8.mImageProcessListener
            if (r1 == 0) goto L_0x038c
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_BURST_SHOT
            java.lang.Object r1 = r12.get(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x038c
            com.oppo.camera.aps.adapter.ApsParameters$Key<com.oppo.camera.aps.ApsCameraRequestTag> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAMERA_REQUEST_TAG
            java.lang.Object r1 = r13.get(r1)
            com.oppo.camera.aps.ApsCameraRequestTag r1 = (com.oppo.camera.aps.ApsCameraRequestTag) r1
            boolean r1 = r1.mbQcom
            if (r1 == 0) goto L_0x0387
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_FORMAT
            java.lang.Object r1 = r12.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r11) goto L_0x0387
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.String> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_SUPER_RAW_ENABLE
            java.lang.Object r1 = r13.get(r1)
            java.lang.String r2 = "1"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x038c
        L_0x0387:
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r1 = r8.mImageProcessListener
            r1.afterAddFrame(r12, r13)
        L_0x038c:
            com.oppo.camera.aps.adapter.ApsParameters r1 = new com.oppo.camera.aps.adapter.ApsParameters
            r1.<init>()
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r2 = r8.mImageProcessListener
            if (r2 == 0) goto L_0x039e
            r3 = 1
            java.util.HashMap r2 = r2.fillApsParameters(r0, r3)
            r1.setAll(r2)
            goto L_0x039f
        L_0x039e:
            r3 = 1
        L_0x039f:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_REPROCESS_META_DATA
            java.lang.Object r2 = r13.get(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x03bf
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_FORMAT
            java.lang.Object r2 = r12.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 == r11) goto L_0x03bc
            goto L_0x03bf
        L_0x03bc:
            r11 = r16
            goto L_0x03d2
        L_0x03bf:
            java.lang.Object r2 = r8.mImageQueueLock
            monitor-enter(r2)
            r0.releaseImageItemList()     // Catch:{ all -> 0x0417 }
            r12.mImageBuffer = r15     // Catch:{ all -> 0x0417 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r0 = r8.mImageProcessMap     // Catch:{ all -> 0x0417 }
            java.lang.Long r4 = java.lang.Long.valueOf(r30)     // Catch:{ all -> 0x0417 }
            r0.remove(r4)     // Catch:{ all -> 0x0417 }
            monitor-exit(r2)     // Catch:{ all -> 0x0417 }
            r11 = r3
        L_0x03d2:
            com.oppo.camera.aps.adapter.ApsParameters$Key<com.oppo.camera.aps.adapter.ApsWatermarkParam> r0 = com.oppo.camera.aps.adapter.ApsParameters.KEY_APS_WATERMARK_PARAM
            java.lang.Object r0 = r13.get(r0)
            com.oppo.camera.aps.adapter.ApsWatermarkParam r0 = (com.oppo.camera.aps.adapter.ApsWatermarkParam) r0
            com.oppo.camera.aps.algorithm.ApsInterface r2 = r8.mApsInterface
            java.lang.String[] r1 = r1.getParameters()
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.String[]> r3 = com.oppo.camera.aps.adapter.ApsParameters.KEY_APS_PROCESS_ALGO_TYPE
            java.lang.Object r3 = r13.get(r3)
            java.lang.String[] r3 = (java.lang.String[]) r3
            int r0 = r2.processImages(r1, r3, r0)
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "addFrameAndProcessImage, processImages result: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.oppo.camera.aps.ApsAdapterLog.d(r1, r2)
            java.lang.Object r1 = r8.mAddFrameLock
            monitor-enter(r1)
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo> r2 = r8.mAddFrameMetadataList     // Catch:{ all -> 0x0414 }
            r2.clear()     // Catch:{ all -> 0x0414 }
            monitor-exit(r1)     // Catch:{ all -> 0x0414 }
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r1 = r8.mImageProcessListener
            if (r1 == 0) goto L_0x0412
            r1.afterProcessImage(r0, r12, r13)
        L_0x0412:
            r3 = r11
            goto L_0x0467
        L_0x0414:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0414 }
            throw r0
        L_0x0417:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0417 }
            throw r0
        L_0x041a:
            r3 = 1
            if (r14 != 0) goto L_0x042a
            java.lang.Object r1 = r8.mAddFrameLock
            monitor-enter(r1)
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo> r2 = r8.mAddFrameMetadataList     // Catch:{ all -> 0x0427 }
            r2.clear()     // Catch:{ all -> 0x0427 }
            monitor-exit(r1)     // Catch:{ all -> 0x0427 }
            goto L_0x042a
        L_0x0427:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0427 }
            throw r0
        L_0x042a:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_REPROCESS_META_DATA
            java.lang.Object r1 = r13.get(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0446
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_FORMAT
            java.lang.Object r1 = r12.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 == r11) goto L_0x0465
        L_0x0446:
            java.lang.Object r1 = r8.mImageQueueLock
            monitor-enter(r1)
            r0.releaseImageItemList()     // Catch:{ all -> 0x0457 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r0 = r8.mImageProcessMap     // Catch:{ all -> 0x0457 }
            java.lang.Long r2 = java.lang.Long.valueOf(r30)     // Catch:{ all -> 0x0457 }
            r0.remove(r2)     // Catch:{ all -> 0x0457 }
            monitor-exit(r1)     // Catch:{ all -> 0x0457 }
            goto L_0x0467
        L_0x0457:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0457 }
            throw r0
        L_0x045a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x045a }
            throw r0
        L_0x045d:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x045d }
            throw r0
        L_0x0460:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0460 }
            throw r0
        L_0x0463:
            r16 = 0
        L_0x0465:
            r3 = r16
        L_0x0467:
            java.lang.Object r2 = r8.mImageQueueLock
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0475
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r0 = r8.mImageProcessMap     // Catch:{ all -> 0x04a3 }
            java.lang.Long r1 = java.lang.Long.valueOf(r30)     // Catch:{ all -> 0x04a3 }
            r0.remove(r1)     // Catch:{ all -> 0x04a3 }
        L_0x0475:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r0 = r8.mImageProcessMap     // Catch:{ all -> 0x04a3 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x04a3 }
            if (r0 == 0) goto L_0x048b
            android.os.ConditionVariable r0 = r8.mAddFrameConditionVariable     // Catch:{ all -> 0x04a3 }
            r0.open()     // Catch:{ all -> 0x04a3 }
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r0 = r8.mImageProcessListener     // Catch:{ all -> 0x04a3 }
            if (r0 == 0) goto L_0x048b
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r0 = r8.mImageProcessListener     // Catch:{ all -> 0x04a3 }
            r0.onProcessQueueEmpty()     // Catch:{ all -> 0x04a3 }
        L_0x048b:
            monitor-exit(r2)     // Catch:{ all -> 0x04a3 }
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "addFrameAndProcessImage X, haveRelease: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.oppo.camera.aps.ApsAdapterLog.v(r0, r1)
            return
        L_0x04a3:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x04a3 }
            throw r0
        L_0x04a6:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x04a6 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsCaptureAdapterImpl.addFrameAndProcessImage(long):void");
    }

    /* access modifiers changed from: protected */
    public boolean countAddFrame(long j, int i, int i2, boolean z, ImageCategory.ImageItemInfo imageItemInfo) {
        Integer num;
        synchronized (this.mAddFrameLock) {
            if (i2 == i) {
                ApsAdapterLog.v(TAG, "countAddFrame, identity: " + j + ", isCaptureFailed: " + z + ", mApsInterface: " + this.mApsInterface);
                if (z) {
                    handleCaptureFailed(imageItemInfo, i, i2);
                    return false;
                }
                this.mbCaptureFail = false;
                return true;
            }
            Integer num2 = this.mAddFrameFinishMap.get(Long.valueOf(j));
            if (num2 == null) {
                num = Integer.valueOf(i);
                this.mbCaptureFail = z;
            } else {
                num = Integer.valueOf(num2.intValue() + i);
                this.mbCaptureFail |= z;
            }
            ApsAdapterLog.v(TAG, "countAddFrame, mMergeIdentity: " + j + ", count: " + num + ", mMergeNum: " + i2 + ", isCaptureFailed: " + z + ", mbCaptureFail: " + this.mbCaptureFail);
            if (num.intValue() >= i2) {
                this.mAddFrameFinishMap.remove(Long.valueOf(j));
                if (!this.mbCaptureFail) {
                    return true;
                }
                handleCaptureFailed(imageItemInfo, i, i2);
                return false;
            }
            this.mAddFrameFinishMap.put(Long.valueOf(j), num);
            return false;
        }
    }

    private void handleCaptureFailed(ImageCategory.ImageItemInfo imageItemInfo, int i, int i2) {
        if (this.mApsInterface != null && this.mImageProcessListener != null) {
            synchronized (this.mImageQueueLock) {
                if (!this.mImageProcessMap.isEmpty()) {
                    ApsAdapterLog.v(TAG, "handleCaptureFailed, clear mImageProcessMap");
                    for (Long next : this.mImageProcessMap.keySet()) {
                        ImageCategory imageCategory = this.mImageProcessMap.get(next);
                        if (!imageCategory.isValid()) {
                            imageCategory.releaseImageItemList();
                            this.mImageProcessMap.remove(next);
                        }
                    }
                }
            }
            if (i2 > i) {
                this.mApsInterface.clear();
            }
            ApsAdapterInterface.ImageProcessListener imageProcessListener = this.mImageProcessListener;
            if (imageProcessListener != null) {
                imageProcessListener.afterAddFrame(imageItemInfo, (ImageCategory.MetaItemInfo) null);
            }
            this.mbCaptureFail = false;
        }
    }

    private String[] parserAlgoFlags(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return null;
        }
        int length = iArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = String.valueOf(iArr[i]);
        }
        return strArr;
    }

    /* access modifiers changed from: protected */
    public void closeCamera() {
        ImageCategory.MetaItemInfo metaItemInfo;
        synchronized (this.mAddFrameLock) {
            metaItemInfo = this.mAddFrameMetadataList.size() > 0 ? this.mAddFrameMetadataList.get(0) : null;
        }
        synchronized (this.mImageQueueLock) {
            for (Long next : this.mImageProcessMap.keySet()) {
                ImageCategory imageCategory = this.mImageProcessMap.get(next);
                if (!imageCategory.isValid()) {
                    ApsAdapterLog.v(TAG, "closeCamera, key: " + next);
                    boolean z = true;
                    if (metaItemInfo != null && ((Boolean) metaItemInfo.get(ApsParameters.KEY_USE_TUNING_DATA)).booleanValue()) {
                        if (imageCategory.mTuningItemList == null || imageCategory.mTuningItemList.size() <= 0) {
                            z = false;
                        }
                    }
                    if (metaItemInfo == null || imageCategory.mMetaItem != null || !z || imageCategory.mImageItemList == null || imageCategory.mImageItemList.size() != ((Integer) metaItemInfo.get(ApsParameters.KEY_CAPTURE_STREAM_NUMBER)).intValue()) {
                        ApsAdapterLog.v(TAG, "closeCamera, the imageCategory is removed");
                        this.mImageProcessMap.remove(next);
                    } else {
                        metaItemInfo.setParameter(ApsParameters.KEY_TIME_STAMP, imageCategory.mImageItemList.get(0).get(ApsParameters.KEY_TIME_STAMP));
                        imageCategory.mMetaItem = metaItemInfo.copy();
                        this.mImageProcessMap.put(next, imageCategory);
                        if (imageCategory.isValid()) {
                            this.mImageProcessHandler.obtainMessage(3, next).sendToTarget();
                            ApsAdapterLog.v(TAG, "closeCamera, send message to add frame");
                        } else {
                            ApsAdapterLog.e(TAG, "closeCamera, fail to send aps process");
                        }
                    }
                    ApsAdapterLog.v(TAG, "closeCamera, imageCategory: " + imageCategory.toString());
                }
            }
            if (!this.mImageProcessMap.isEmpty()) {
                ApsAdapterLog.v(TAG, "closeCamera, mAddFrameConditionVariable close");
                this.mAddFrameConditionVariable.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onJpegReceived(ApsResult apsResult) {
        String str = TAG;
        ApsAdapterLog.v(str, "onJpegReceived, result: " + apsResult.toString());
        ApsAdapterInterface.ImageProcessListener imageProcessListener = this.mImageProcessListener;
        if (imageProcessListener != null) {
            imageProcessListener.onJpegReceived(apsResult);
        }
    }

    /* access modifiers changed from: protected */
    public void onRawReceived(ApsResult apsResult) {
        String str = TAG;
        ApsAdapterLog.v(str, "onRawReceived, result: " + apsResult);
        if (this.mImageProcessListener != null) {
            synchronized (this.mRawImageCategoryLock) {
                if (this.mRawImageCategory != null && apsResult.mIdentity == ((Long) this.mRawImageCategory.mMetaItem.get(ApsParameters.KEY_MERGE_IDENTITY)).longValue()) {
                    this.mImageProcessListener.onReprocess(this.mRawImageCategory, apsResult);
                    this.mRawImageCategory = null;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onHeicReceived(ApsResult apsResult) {
        String str = TAG;
        ApsAdapterLog.v(str, "onHeicReceived, result: " + apsResult.toString());
        if (apsResult.mbHeifProcessInAps || !this.mbHeicProcessInApp) {
            ApsAdapterInterface.ImageProcessListener imageProcessListener = this.mImageProcessListener;
            if (imageProcessListener != null) {
                imageProcessListener.onHeicReceived(apsResult);
            }
        } else {
            synchronized (this.mHeicReceivedLock) {
                if (this.mHeifThumbnailList.contains(Long.valueOf(apsResult.mIdentity))) {
                    String str2 = TAG;
                    ApsAdapterLog.v(str2, "onHeicReceived, callback buffer, timestamp: " + apsResult.mIdentity);
                    this.mHeifThumbnailList.remove(Long.valueOf(apsResult.mIdentity));
                    if (this.mImageProcessListener != null) {
                        this.mImageProcessListener.onHeicReceived(apsResult);
                    }
                } else if (this.mHeifImageMap != null) {
                    String str3 = TAG;
                    ApsAdapterLog.v(str3, "onHeicReceived, wait for thumbnail uri, timestamp: " + apsResult.mIdentity);
                    this.mHeifImageMap.put(Long.valueOf(apsResult.mIdentity), copyApsResult(apsResult));
                }
            }
        }
        ApsAdapterLog.v(TAG, "onHeicReceived, X.");
    }

    private ApsResult copyApsResult(ApsResult apsResult) {
        if (apsResult == null) {
            return null;
        }
        ApsResult apsResult2 = new ApsResult();
        apsResult2.mIdentity = apsResult.mIdentity;
        apsResult2.mBufferType = apsResult.mBufferType;
        apsResult2.mCopyBuffer = apsResult.mCopyBuffer;
        apsResult2.mExifData = apsResult.mExifData;
        apsResult2.mWidth = apsResult.mWidth;
        apsResult2.mHeight = apsResult.mHeight;
        apsResult2.mScanline = apsResult.mScanline;
        apsResult2.mStride = apsResult.mStride;
        apsResult2.mSTHeight = apsResult.mSTHeight;
        apsResult2.mSTWidth = apsResult.mSTWidth;
        apsResult2.mbHasSTResult = apsResult.mbHasSTResult;
        return apsResult2;
    }

    public void initHeifCodec(long j) {
        ApsAdapterInterface.ImageProcessListener imageProcessListener = this.mImageProcessListener;
        if (imageProcessListener != null) {
            imageProcessListener.initHeifCodec(j);
        }
    }

    public void processHeifCodec(long j, HardwareBuffer hardwareBuffer, ApsExifData apsExifData, int i, int i2) {
        ApsAdapterInterface.ImageProcessListener imageProcessListener = this.mImageProcessListener;
        if (imageProcessListener != null) {
            imageProcessListener.processHeifCodec(j, hardwareBuffer, apsExifData, i, i2);
        }
    }

    public void uninitHeifCodec(long j) {
        ApsAdapterInterface.ImageProcessListener imageProcessListener = this.mImageProcessListener;
        if (imageProcessListener != null) {
            imageProcessListener.uninitHeifCodec(j);
        }
    }

    public void setHeicProcessInApp(boolean z) {
        String str = TAG;
        ApsAdapterLog.v(str, "setHeicProcessInApp: " + z);
        this.mbHeicProcessInApp = z;
    }

    public void updateThumbnailMap(long j) {
        if (!this.mbHeicProcessInApp) {
            ApsAdapterLog.v(TAG, "updateThumbnailMap, return because heic process in aps or not need to update thumbnail");
            return;
        }
        String str = TAG;
        ApsAdapterLog.v(str, "updateThumbnailMap, timestamp: " + j);
        synchronized (this.mHeicReceivedLock) {
            if (this.mHeifImageMap != null && this.mHeifImageMap.containsKey(Long.valueOf(j))) {
                ApsResult remove = this.mHeifImageMap.remove(Long.valueOf(j));
                if (this.mHeifThumbnailList != null) {
                    this.mHeifThumbnailList.add(Long.valueOf(j));
                }
                if (this.mApsInterface != null) {
                    this.mApsInterface.updateThumbnailMap(remove);
                }
            } else if (this.mHeifThumbnailList != null) {
                String str2 = TAG;
                ApsAdapterLog.v(str2, "updateThumbnailMap, wait for heic callback, timestamp: " + j);
                this.mHeifThumbnailList.add(Long.valueOf(j));
            }
        }
        ApsAdapterLog.v(TAG, "updateThumbnailMap, X");
    }
}
