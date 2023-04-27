package com.oppo.camera.aps.adapter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsAdapterInterface;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.algorithm.ApsInterface;
import com.oppo.camera.aps.service.ApsAdapterListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

class ApsPreviewAdapterImpl {
    private static final boolean DEBUG = false;
    private static final int MAX_INFLIGHT_IMAGE_NUMBER = 6;
    private static final int MSG_APS_ADD_PREVIEW_FRAME = 2;
    public static final String TAG = "ApsPreviewAdapterImpl";
    private final Object mApsInitLock = new Object();
    /* access modifiers changed from: private */
    public ApsInterface mApsInterface = null;
    protected ApsAdapterListener.ApsServiceListener mApsServiceListener = null;
    private List<CaptureRequest> mCaptureRequestList = new CopyOnWriteArrayList();
    private ImageCategory.MetaItemInfo mCurMetaItemInfo = null;
    private Handler mDecisionHandler = null;
    /* access modifiers changed from: private */
    public long mFrameNumber = -1;
    private ApsAdapterInterface.ImageProcessListener mImageProcessListener = null;
    private ApsInitParameter mInitParameter = null;
    private final Object mPermitLock = new Object();
    private ProcessHandler mProcessHandler = null;
    private LinkedHashMap<Long, ImageCategory> mProcessMap = new LinkedHashMap<>();
    private final Object mQueueLock = new Object();
    private Boolean mbPermit = true;

    protected ApsPreviewAdapterImpl(ApsInterface apsInterface, ApsAdapterInterface.ImageProcessListener imageProcessListener) {
        this.mApsInterface = apsInterface;
        this.mImageProcessListener = imageProcessListener;
        createProcessThread();
        createDecisionThread();
    }

    private void createProcessThread() {
        HandlerThread handlerThread;
        if (this.mProcessHandler == null) {
            handlerThread = new HandlerThread("PreviewProcessThread");
            handlerThread.start();
            this.mProcessHandler = new ProcessHandler(handlerThread.getLooper());
        } else {
            handlerThread = null;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("createProcessThread, thread id: ");
        sb.append(handlerThread == null ? 0 : handlerThread.getThreadId());
        ApsAdapterLog.v(str, sb.toString());
    }

    private void createDecisionThread() {
        HandlerThread handlerThread;
        if (this.mDecisionHandler == null) {
            handlerThread = new HandlerThread("PreviewDecisionThread");
            handlerThread.start();
            this.mDecisionHandler = new Handler(handlerThread.getLooper());
        } else {
            handlerThread = null;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("createDecisionThread, thread id: ");
        sb.append(handlerThread == null ? 0 : handlerThread.getThreadId());
        ApsAdapterLog.v(str, sb.toString());
    }

    private void sendImageAndMetaToAps(ImageCategory imageCategory) {
        imageCategory.mbAlreadySendAps = true;
        Message obtainMessage = this.mProcessHandler.obtainMessage(2);
        obtainMessage.obj = imageCategory;
        obtainMessage.sendToTarget();
    }

    public void setPermitProcess(boolean z) {
        synchronized (this.mPermitLock) {
            String str = TAG;
            ApsAdapterLog.d(str, "setPermitProcess, mbPermit: " + this.mbPermit + " => " + z);
            this.mbPermit = Boolean.valueOf(z);
        }
    }

    /* access modifiers changed from: protected */
    public void addImage(ImageCategory.ImageItemInfo imageItemInfo) {
        ImageCategory imageCategory;
        synchronized (this.mQueueLock) {
            long longValue = ((Long) imageItemInfo.get(ApsParameters.KEY_TIME_STAMP)).longValue();
            if (this.mProcessMap.containsKey(Long.valueOf(longValue))) {
                imageCategory = this.mProcessMap.get(Long.valueOf(longValue));
                imageCategory.mImageItemList.add(imageItemInfo);
            } else {
                imageCategory = new ImageCategory();
                imageCategory.mImageItemList.add(imageItemInfo);
                this.mProcessMap.put(Long.valueOf(longValue), imageCategory);
            }
            boolean isValid = imageCategory.isValid();
            if (isValid || (!((Boolean) imageItemInfo.get(ApsParameters.KEY_NEED_MATCH_TIME_STAMP)).booleanValue() && this.mCurMetaItemInfo != null && imageCategory.mMetaItem == null && ((Integer) imageItemInfo.get(ApsParameters.KEY_PREVIEW_STREAM_NUMBER)).intValue() == imageCategory.mImageItemList.size())) {
                checkImageOverflow(Long.valueOf(longValue));
                if (isValid) {
                    this.mProcessMap.remove(Long.valueOf(longValue));
                } else {
                    imageCategory.mMetaItem = this.mCurMetaItemInfo.copy();
                    imageCategory.mMetaItem.setParameter(ApsParameters.KEY_TIME_STAMP, Long.valueOf(longValue));
                }
                sendImageAndMetaToAps(imageCategory);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addMetadata(com.oppo.camera.aps.adapter.ImageCategory.MetaItemInfo r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mQueueLock
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r1 = r5.mCurMetaItemInfo     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0025
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r1 = r5.mCurMetaItemInfo     // Catch:{ all -> 0x0088 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_FRAME_NUMBER     // Catch:{ all -> 0x0088 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0088 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0088 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x0088 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r3 = com.oppo.camera.aps.adapter.ApsParameters.KEY_FRAME_NUMBER     // Catch:{ all -> 0x0088 }
            java.lang.Object r3 = r6.get(r3)     // Catch:{ all -> 0x0088 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0088 }
            long r3 = r3.longValue()     // Catch:{ all -> 0x0088 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0027
        L_0x0025:
            r5.mCurMetaItemInfo = r6     // Catch:{ all -> 0x0088 }
        L_0x0027:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r1 = com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP     // Catch:{ all -> 0x0088 }
            java.lang.Object r1 = r6.get(r1)     // Catch:{ all -> 0x0088 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0088 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x0088 }
            java.util.LinkedHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r3 = r5.mProcessMap     // Catch:{ all -> 0x0088 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0088 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x005d
            java.util.LinkedHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r3 = r5.mProcessMap     // Catch:{ all -> 0x0088 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0088 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0088 }
            com.oppo.camera.aps.adapter.ImageCategory r3 = (com.oppo.camera.aps.adapter.ImageCategory) r3     // Catch:{ all -> 0x0088 }
            boolean r4 = r3.mbAlreadySendAps     // Catch:{ all -> 0x0088 }
            if (r4 == 0) goto L_0x005a
            java.util.LinkedHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r6 = r5.mProcessMap     // Catch:{ all -> 0x0088 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0088 }
            r6.remove(r1)     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x005a:
            r3.mMetaItem = r6     // Catch:{ all -> 0x0088 }
            goto L_0x006d
        L_0x005d:
            com.oppo.camera.aps.adapter.ImageCategory r3 = new com.oppo.camera.aps.adapter.ImageCategory     // Catch:{ all -> 0x0088 }
            r3.<init>()     // Catch:{ all -> 0x0088 }
            r3.mMetaItem = r6     // Catch:{ all -> 0x0088 }
            java.util.LinkedHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r6 = r5.mProcessMap     // Catch:{ all -> 0x0088 }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0088 }
            r6.put(r4, r3)     // Catch:{ all -> 0x0088 }
        L_0x006d:
            boolean r6 = r3.isValid()     // Catch:{ all -> 0x0088 }
            if (r6 == 0) goto L_0x0086
            java.lang.Long r6 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0088 }
            r5.checkImageOverflow(r6)     // Catch:{ all -> 0x0088 }
            java.util.LinkedHashMap<java.lang.Long, com.oppo.camera.aps.adapter.ImageCategory> r6 = r5.mProcessMap     // Catch:{ all -> 0x0088 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0088 }
            r6.remove(r1)     // Catch:{ all -> 0x0088 }
            r5.sendImageAndMetaToAps(r3)     // Catch:{ all -> 0x0088 }
        L_0x0086:
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0088:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsPreviewAdapterImpl.addMetadata(com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo):void");
    }

    /* access modifiers changed from: protected */
    public boolean dropFrame(long j) {
        synchronized (this.mQueueLock) {
            if (!this.mProcessMap.isEmpty()) {
                Optional findFirst = this.mProcessMap.keySet().stream().sorted().findFirst();
                if (findFirst.isPresent()) {
                    Long l = (Long) findFirst.get();
                    ((ImageCategory) this.mProcessMap.remove(l)).releaseImageItemList();
                    String str = TAG;
                    ApsAdapterLog.i(str, "dropFrame, frameNumber: " + j + ", timestamp: " + l);
                }
            }
        }
        return true;
    }

    public void videoSnapshot(ApsAdapterListener.CaptureCallback captureCallback, ApsCameraRequestTag apsCameraRequestTag) {
        this.mCaptureRequestList.add(new CaptureRequest(captureCallback, apsCameraRequestTag));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        java.lang.System.currentTimeMillis();
        r2 = r0.mImageItemList.get(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r0.mMetaItem == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r5 = r0.mMetaItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r5 = new com.oppo.camera.aps.adapter.ImageCategory.MetaItemInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        r6 = new com.oppo.camera.aps.adapter.ApsParameters();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r1.mImageProcessListener == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        r6.setAll(r1.mImageProcessListener.fillApsParameters(r0, 2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        r0 = r0.mImageItemList;
        r14 = new com.oppo.camera.aps.adapter.ApsResult.ImageBuffer[r0.size()];
        r7 = new int[r0.size()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r22 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r4 >= r0.size()) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        r8 = r0.get(r4);
        r14[r4] = r8.mImageBuffer;
        r7[r4] = ((java.lang.Integer) r8.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_ROLE)).intValue();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r5.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT) == null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        r8 = ((android.hardware.camera2.CaptureResult) r5.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT)).getFrameNumber();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        r12 = r8;
        r9 = r12;
        r23 = r12;
        r8 = new com.oppo.camera.aps.adapter.ApsPreviewParam(r9, r6.getParameters(), ((java.lang.Long) r2.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP)).longValue(), r14, (android.hardware.camera2.CaptureResult) r5.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT), (androidx.collection.ArrayMap) r5.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_META_MAP), r7, ((java.lang.Boolean) r2.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_NEED_META_DATA)).booleanValue(), false, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cd, code lost:
        if (r1.mImageProcessListener == null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cf, code lost:
        r1.mImageProcessListener.onPreviewFrameProcessStarted(r23, (java.lang.Long) r2.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00de, code lost:
        r22 = r1.mApsInterface.addPreviewFrameBuff(r8, (com.oppo.camera.aps.adapter.ApsWatermarkParam) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        com.oppo.camera.aps.ApsAdapterLog.e(TAG, "addPreviewFrameBuff error.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r3 = r1.mQueueLock;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int addPreviewFrameBuff(com.oppo.camera.aps.adapter.ImageCategory r26) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            java.lang.Object r2 = r1.mPermitLock
            monitor-enter(r2)
            java.lang.Boolean r3 = r1.mbPermit     // Catch:{ all -> 0x00f3 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x00f3 }
            r4 = 0
            if (r3 != 0) goto L_0x0015
            r26.releaseImageItemList()     // Catch:{ all -> 0x00f3 }
            monitor-exit(r2)     // Catch:{ all -> 0x00f3 }
            return r4
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x00f3 }
            java.lang.Object r3 = r1.mQueueLock
            monitor-enter(r3)
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f0 }
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r2 = r0.mImageItemList     // Catch:{ all -> 0x00f0 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x00f0 }
            com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo r2 = (com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo) r2     // Catch:{ all -> 0x00f0 }
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r5 = r0.mMetaItem     // Catch:{ all -> 0x00f0 }
            if (r5 == 0) goto L_0x002b
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r5 = r0.mMetaItem     // Catch:{ all -> 0x00f0 }
            goto L_0x0030
        L_0x002b:
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r5 = new com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo     // Catch:{ all -> 0x00f0 }
            r5.<init>()     // Catch:{ all -> 0x00f0 }
        L_0x0030:
            com.oppo.camera.aps.adapter.ApsParameters r6 = new com.oppo.camera.aps.adapter.ApsParameters     // Catch:{ all -> 0x00f0 }
            r6.<init>()     // Catch:{ all -> 0x00f0 }
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r7 = r1.mImageProcessListener     // Catch:{ all -> 0x00f0 }
            if (r7 == 0) goto L_0x0043
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r7 = r1.mImageProcessListener     // Catch:{ all -> 0x00f0 }
            r8 = 2
            java.util.HashMap r7 = r7.fillApsParameters(r0, r8)     // Catch:{ all -> 0x00f0 }
            r6.setAll(r7)     // Catch:{ all -> 0x00f0 }
        L_0x0043:
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r0 = r0.mImageItemList     // Catch:{ all -> 0x00f0 }
            int r7 = r0.size()     // Catch:{ all -> 0x00f0 }
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer[] r14 = new com.oppo.camera.aps.adapter.ApsResult.ImageBuffer[r7]     // Catch:{ all -> 0x00f0 }
            int r7 = r0.size()     // Catch:{ all -> 0x00f0 }
            int[] r7 = new int[r7]     // Catch:{ all -> 0x00f0 }
            r22 = -1
        L_0x0053:
            int r8 = r0.size()     // Catch:{ Exception -> 0x00e6 }
            if (r4 >= r8) goto L_0x0074
            java.lang.Object r8 = r0.get(r4)     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo r8 = (com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo) r8     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r9 = r8.mImageBuffer     // Catch:{ Exception -> 0x00e6 }
            r14[r4] = r9     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r9 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_ROLE     // Catch:{ Exception -> 0x00e6 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x00e6 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x00e6 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x00e6 }
            r7[r4] = r8     // Catch:{ Exception -> 0x00e6 }
            int r4 = r4 + 1
            goto L_0x0053
        L_0x0074:
            com.oppo.camera.aps.adapter.ApsParameters$Key<android.hardware.camera2.CaptureResult> r0 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT     // Catch:{ Exception -> 0x00e6 }
            java.lang.Object r0 = r5.get(r0)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x0089
            com.oppo.camera.aps.adapter.ApsParameters$Key<android.hardware.camera2.CaptureResult> r0 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT     // Catch:{ Exception -> 0x00e6 }
            java.lang.Object r0 = r5.get(r0)     // Catch:{ Exception -> 0x00e6 }
            android.hardware.camera2.CaptureResult r0 = (android.hardware.camera2.CaptureResult) r0     // Catch:{ Exception -> 0x00e6 }
            long r8 = r0.getFrameNumber()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x008b
        L_0x0089:
            r8 = -1
        L_0x008b:
            r12 = r8
            com.oppo.camera.aps.adapter.ApsPreviewParam r0 = new com.oppo.camera.aps.adapter.ApsPreviewParam     // Catch:{ Exception -> 0x00e6 }
            java.lang.String[] r11 = r6.getParameters()     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP     // Catch:{ Exception -> 0x00e6 }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x00e6 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x00e6 }
            long r15 = r4.longValue()     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<android.hardware.camera2.CaptureResult> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT     // Catch:{ Exception -> 0x00e6 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x00e6 }
            android.hardware.camera2.CaptureResult r4 = (android.hardware.camera2.CaptureResult) r4     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<androidx.collection.ArrayMap<java.lang.String, android.hardware.camera2.CameraMetadata>> r6 = com.oppo.camera.aps.adapter.ApsParameters.KEY_META_MAP     // Catch:{ Exception -> 0x00e6 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ Exception -> 0x00e6 }
            androidx.collection.ArrayMap r5 = (androidx.collection.ArrayMap) r5     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r6 = com.oppo.camera.aps.adapter.ApsParameters.KEY_NEED_META_DATA     // Catch:{ Exception -> 0x00e6 }
            java.lang.Object r6 = r2.get(r6)     // Catch:{ Exception -> 0x00e6 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ Exception -> 0x00e6 }
            boolean r18 = r6.booleanValue()     // Catch:{ Exception -> 0x00e6 }
            r19 = 0
            r20 = 0
            r8 = r0
            r9 = r12
            r23 = r12
            r12 = r15
            r15 = r4
            r16 = r5
            r17 = r7
            r8.<init>(r9, r11, r12, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r4 = r1.mImageProcessListener     // Catch:{ Exception -> 0x00e6 }
            if (r4 == 0) goto L_0x00de
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r4 = r1.mImageProcessListener     // Catch:{ Exception -> 0x00e6 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r5 = com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP     // Catch:{ Exception -> 0x00e6 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ Exception -> 0x00e6 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ Exception -> 0x00e6 }
            r8 = r23
            r4.onPreviewFrameProcessStarted(r8, r2)     // Catch:{ Exception -> 0x00e6 }
        L_0x00de:
            com.oppo.camera.aps.algorithm.ApsInterface r2 = r1.mApsInterface     // Catch:{ Exception -> 0x00e6 }
            r4 = 0
            int r22 = r2.addPreviewFrameBuff(r0, r4)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ee
        L_0x00e6:
            r0 = move-exception
            java.lang.String r2 = TAG     // Catch:{ all -> 0x00f0 }
            java.lang.String r4 = "addPreviewFrameBuff error."
            com.oppo.camera.aps.ApsAdapterLog.e(r2, r4, r0)     // Catch:{ all -> 0x00f0 }
        L_0x00ee:
            monitor-exit(r3)     // Catch:{ all -> 0x00f0 }
            return r22
        L_0x00f0:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00f0 }
            throw r0
        L_0x00f3:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00f3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsPreviewAdapterImpl.addPreviewFrameBuff(com.oppo.camera.aps.adapter.ImageCategory):int");
    }

    /* access modifiers changed from: protected */
    public void onDecisionControlData(final ApsAdapterDecision.DecisionControlData decisionControlData) {
        if (this.mDecisionHandler != null && this.mApsInterface != null && decisionControlData.mDecisionCallback != null) {
            this.mDecisionHandler.removeCallbacksAndMessages((Object) null);
            this.mDecisionHandler.post(new Runnable() {
                public void run() {
                    ApsPreviewDecisionParam apsPreviewDecisionParam = r1;
                    ApsPreviewDecisionParam apsPreviewDecisionParam2 = new ApsPreviewDecisionParam(decisionControlData.mZoomValue, decisionControlData.mCaptureResult, decisionControlData.mLogicCameraType, decisionControlData.mCameraId, Integer.parseInt(decisionControlData.mLogicCameraId), decisionControlData.mPiEnable, decisionControlData.mTripodEnable, decisionControlData.mUltraHighResolutionEnable, decisionControlData.mFilterEnable, decisionControlData.mCaptureMode, decisionControlData.mNeonEnable, decisionControlData.mSCPEnable, decisionControlData.mFaceBeautyEnable, decisionControlData.mSuperRawEnable, decisionControlData.mStreamerEnable, decisionControlData.mRecordingCapture);
                    decisionControlData.mDecisionCallback.onDecisionResult(ApsPreviewAdapterImpl.this.mApsInterface.previewDecision(apsPreviewDecisionParam));
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(com.oppo.camera.aps.adapter.ApsInitParameter r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.mApsInitLock
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r1 = r8.mImageProcessListener     // Catch:{ all -> 0x00c3 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            return
        L_0x0009:
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r1 = r8.mImageProcessListener     // Catch:{ all -> 0x00c3 }
            com.oppo.camera.aps.adapter.ApsInitParameter r2 = r8.mInitParameter     // Catch:{ all -> 0x00c3 }
            com.oppo.camera.aps.adapter.ApsInitParameter r1 = r1.getApsInitParameter(r9, r2)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x00c1
            com.oppo.camera.aps.adapter.ApsPreviewAdapterImpl$ProcessHandler r2 = r8.mProcessHandler     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x00c1
            com.oppo.camera.aps.adapter.ApsPreviewAdapterImpl$ProcessHandler r2 = r8.mProcessHandler     // Catch:{ all -> 0x00c3 }
            android.os.Looper r2 = r2.getLooper()     // Catch:{ all -> 0x00c3 }
            java.lang.Thread r2 = r2.getThread()     // Catch:{ all -> 0x00c3 }
            boolean r2 = r2.isAlive()     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x00c1
            java.lang.String r2 = TAG     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r3.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = "init, mInitParameter: "
            r3.append(r4)     // Catch:{ all -> 0x00c3 }
            com.oppo.camera.aps.adapter.ApsInitParameter r4 = r8.mInitParameter     // Catch:{ all -> 0x00c3 }
            r3.append(r4)     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = ", parameter: "
            r3.append(r4)     // Catch:{ all -> 0x00c3 }
            r3.append(r9)     // Catch:{ all -> 0x00c3 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c3 }
            com.oppo.camera.aps.ApsAdapterLog.v(r2, r3)     // Catch:{ all -> 0x00c3 }
            r8.mInitParameter = r1     // Catch:{ all -> 0x00c3 }
            com.oppo.camera.aps.adapter.ApsParameters r2 = new com.oppo.camera.aps.adapter.ApsParameters     // Catch:{ all -> 0x00c3 }
            r2.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String r3 = "package_name"
            java.lang.String r4 = com.oppo.camera.aps.config.AlgoSwitchConfig.getPackageName()     // Catch:{ all -> 0x00c3 }
            r2.set(r3, r4)     // Catch:{ all -> 0x00c3 }
            java.lang.String r3 = "total_memory"
            long r4 = com.oppo.camera.aps.config.AlgoSwitchConfig.getTotalMemory()     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00c3 }
            r2.set(r3, r4)     // Catch:{ all -> 0x00c3 }
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r3 = r8.mImageProcessListener     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x0071
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r3 = r8.mImageProcessListener     // Catch:{ all -> 0x00c3 }
            java.util.HashMap r3 = r3.fillApsParameters(r9)     // Catch:{ all -> 0x00c3 }
            r2.setAll(r3)     // Catch:{ all -> 0x00c3 }
        L_0x0071:
            com.oppo.camera.aps.adapter.ApsInitParameter r3 = new com.oppo.camera.aps.adapter.ApsInitParameter     // Catch:{ all -> 0x00c3 }
            r3.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String[] r2 = r2.getParameters()     // Catch:{ all -> 0x00c3 }
            r3.mParameters = r2     // Catch:{ all -> 0x00c3 }
            java.lang.String[] r2 = r9.mVendorTags     // Catch:{ all -> 0x00c3 }
            r3.mVendorTags = r2     // Catch:{ all -> 0x00c3 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<android.hardware.camera2.CameraCharacteristics> r2 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAMERA_CHARACTERISTICS     // Catch:{ all -> 0x00c3 }
            java.lang.Object r2 = r9.get(r2)     // Catch:{ all -> 0x00c3 }
            android.hardware.camera2.CameraMetadata r2 = (android.hardware.camera2.CameraMetadata) r2     // Catch:{ all -> 0x00c3 }
            r3.mMetadata = r2     // Catch:{ all -> 0x00c3 }
            int r2 = r9.mApsModule     // Catch:{ all -> 0x00c3 }
            r3.mApsModule = r2     // Catch:{ all -> 0x00c3 }
            java.lang.String[] r2 = r1.mInitAlgo     // Catch:{ all -> 0x00c3 }
            int r2 = r2.length     // Catch:{ all -> 0x00c3 }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ all -> 0x00c3 }
            r3.mInitAlgo = r2     // Catch:{ all -> 0x00c3 }
            com.oppo.camera.aps.config.AlgoSwitchConfig$PreviewConfig r2 = r9.mPreviewConfig     // Catch:{ all -> 0x00c3 }
            r3.mPreviewConfig = r2     // Catch:{ all -> 0x00c3 }
            android.view.Surface r2 = r9.mVideoSurface     // Catch:{ all -> 0x00c3 }
            r3.mVideoSurface = r2     // Catch:{ all -> 0x00c3 }
            boolean r9 = r9.mbHeicProcessInApp     // Catch:{ all -> 0x00c3 }
            r3.mbHeicProcessInApp = r9     // Catch:{ all -> 0x00c3 }
            java.lang.String[] r9 = r1.mInitAlgo     // Catch:{ all -> 0x00c3 }
            int r1 = r9.length     // Catch:{ all -> 0x00c3 }
            r2 = 0
            r4 = r2
        L_0x00a6:
            if (r2 >= r1) goto L_0x00b4
            r5 = r9[r2]     // Catch:{ all -> 0x00c3 }
            java.lang.String[] r6 = r3.mInitAlgo     // Catch:{ all -> 0x00c3 }
            int r7 = r4 + 1
            r6[r4] = r5     // Catch:{ all -> 0x00c3 }
            int r2 = r2 + 1
            r4 = r7
            goto L_0x00a6
        L_0x00b4:
            com.oppo.camera.aps.algorithm.ApsInterface r9 = r8.mApsInterface     // Catch:{ all -> 0x00c3 }
            if (r9 == 0) goto L_0x00c1
            com.oppo.camera.aps.algorithm.ApsInterface r9 = r8.mApsInterface     // Catch:{ all -> 0x00c3 }
            r9.initAlgo(r3)     // Catch:{ all -> 0x00c3 }
            r1 = -1
            r8.mFrameNumber = r1     // Catch:{ all -> 0x00c3 }
        L_0x00c1:
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            return
        L_0x00c3:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c3 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsPreviewAdapterImpl.init(com.oppo.camera.aps.adapter.ApsInitParameter):void");
    }

    /* access modifiers changed from: protected */
    public void unInit(int i) {
        synchronized (this.mApsInitLock) {
            String str = TAG;
            ApsAdapterLog.v(str, "unInit, module: " + i);
            if (this.mApsInterface != null) {
                this.mApsInterface.unInitAlgo(i);
            }
            if (1 == i) {
                this.mInitParameter = null;
            } else if (3 == i && this.mInitParameter != null) {
                this.mInitParameter.remove(ApsParameters.KEY_PREVIEW_SIZE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPreviewReceived(ApsResult apsResult) {
        if (this.mApsServiceListener != null) {
            ApsResult.ImageBuffer imageBuffer = apsResult.getImageBuffer();
            ApsTotalResult apsTotalResult = new ApsTotalResult(apsResult.mMetadata);
            if (imageBuffer != null) {
                imageBuffer.setApsInterface(this.mApsInterface);
                if (!this.mCaptureRequestList.isEmpty()) {
                    imageBuffer.addRef();
                    CaptureRequest remove = this.mCaptureRequestList.remove(0);
                    String str = TAG;
                    ApsAdapterLog.v(str, "onPreviewReceived, captureRequest: " + remove);
                    if (remove != null) {
                        remove.mCaptureCallback.onApsCaptureStarted(apsResult.mIdentity);
                        remove.mCaptureCallback.onApsCaptureCompleted(apsResult, apsTotalResult, remove.mRequestTag);
                    }
                }
            }
            this.mApsServiceListener.onPreviewReceived(apsResult, apsTotalResult);
        }
    }

    /* access modifiers changed from: protected */
    public void flushImage() {
        synchronized (this.mQueueLock) {
            Iterator<Map.Entry<Long, ImageCategory>> it = this.mProcessMap.entrySet().iterator();
            while (it.hasNext()) {
                ImageCategory imageCategory = (ImageCategory) it.next().getValue();
                if (imageCategory != null && !imageCategory.mbAlreadySendAps) {
                    imageCategory.releaseImageItemList();
                }
                it.remove();
            }
            this.mCurMetaItemInfo = null;
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        ProcessHandler processHandler = this.mProcessHandler;
        if (processHandler != null) {
            processHandler.getLooper().quitSafely();
            this.mProcessHandler = null;
        }
        Handler handler = this.mDecisionHandler;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.mDecisionHandler = null;
        }
    }

    private void checkImageOverflow(Long l) {
        if (this.mProcessMap.size() - 6 > 0) {
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator<Map.Entry<Long, ImageCategory>> it = this.mProcessMap.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Map.Entry next = it.next();
                if (l.longValue() > ((Long) next.getKey()).longValue()) {
                    arrayList.add(next.getKey());
                }
            }
            for (Long longValue : arrayList) {
                long longValue2 = longValue.longValue();
                ImageCategory imageCategory = (ImageCategory) this.mProcessMap.remove(Long.valueOf(longValue2));
                String str = TAG;
                ApsAdapterLog.v(str, "checkImageOverflow, time: " + longValue2 + ", category: " + imageCategory);
                if (imageCategory != null && !imageCategory.mbAlreadySendAps) {
                    imageCategory.releaseImageItemList();
                }
            }
            arrayList.clear();
        }
    }

    private class ProcessHandler extends Handler {
        private ProcessHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 2) {
                String str = ApsPreviewAdapterImpl.TAG;
                ApsAdapterLog.e(str, "handleMessage, msg: " + message.what + " is not defined.");
            } else if (message.obj == null || !(message.obj instanceof ImageCategory)) {
                String str2 = ApsPreviewAdapterImpl.TAG;
                ApsAdapterLog.e(str2, "handleMessage, error msg: " + message.obj);
            } else {
                ImageCategory imageCategory = (ImageCategory) message.obj;
                if (!ApsPreviewAdapterImpl.this.mApsInterface.isApsPreviewInit() || (imageCategory.mMetaItem != null && ((Long) imageCategory.mMetaItem.get(ApsParameters.KEY_FRAME_NUMBER)).longValue() < ApsPreviewAdapterImpl.this.mFrameNumber)) {
                    imageCategory.releaseImageItemList();
                    ApsAdapterLog.w(ApsPreviewAdapterImpl.TAG, "handleMessage, drop this frame because of wrong frame order.");
                    return;
                }
                int unused = ApsPreviewAdapterImpl.this.addPreviewFrameBuff(imageCategory);
                long unused2 = ApsPreviewAdapterImpl.this.mFrameNumber = imageCategory.mMetaItem != null ? ((Long) imageCategory.mMetaItem.get(ApsParameters.KEY_FRAME_NUMBER)).longValue() : ApsPreviewAdapterImpl.this.mFrameNumber;
            }
        }
    }

    private class CaptureRequest {
        /* access modifiers changed from: private */
        public ApsAdapterListener.CaptureCallback mCaptureCallback;
        /* access modifiers changed from: private */
        public ApsCameraRequestTag mRequestTag;

        private CaptureRequest(ApsAdapterListener.CaptureCallback captureCallback, ApsCameraRequestTag apsCameraRequestTag) {
            this.mCaptureCallback = null;
            this.mRequestTag = null;
            this.mCaptureCallback = captureCallback;
            this.mRequestTag = apsCameraRequestTag;
        }
    }
}
