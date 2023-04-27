package com.oppo.camera.aps.adapter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.adapter.ApsAdapterInterface;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.algorithm.ApsInterface;
import com.oppo.camera.aps.service.ApsAdapterListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class ApsVideoAdapterImpl {
    private static final boolean DEBUG = false;
    private static final int MSG_APS_ADD_VIDEO_FRAME = 1;
    /* access modifiers changed from: private */
    public static final String TAG = "ApsVideoAdapterImpl";
    private ApsInterface mApsInterface = null;
    protected ApsAdapterListener.ApsServiceListener mApsServiceListener = null;
    private ApsAdapterInterface.ImageProcessListener mImageProcessListener = null;
    private final Object mPermitLock = new Object();
    private ProcessHandler mVideoProcessHandler = null;
    private LinkedHashMap<Long, ImageCategory> mVideoProcessMap = new LinkedHashMap<>();
    private final Object mVideoQueueLock = new Object();
    private Boolean mbPermit = true;

    protected ApsVideoAdapterImpl(ApsInterface apsInterface, ApsAdapterInterface.ImageProcessListener imageProcessListener) {
        this.mApsInterface = apsInterface;
        this.mImageProcessListener = imageProcessListener;
        createProcessThread();
    }

    private void createProcessThread() {
        HandlerThread handlerThread;
        if (this.mVideoProcessHandler == null) {
            handlerThread = new HandlerThread("VideoProcessThread");
            handlerThread.start();
            this.mVideoProcessHandler = new ProcessHandler(handlerThread.getLooper());
        } else {
            handlerThread = null;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("createProcessThread, thread id: ");
        sb.append(handlerThread == null ? 0 : handlerThread.getThreadId());
        ApsAdapterLog.v(str, sb.toString());
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
        synchronized (this.mVideoQueueLock) {
            checkImageOverflow();
            long longValue = ((Long) imageItemInfo.get(ApsParameters.KEY_TIME_STAMP)).longValue();
            if (this.mVideoProcessMap.containsKey(Long.valueOf(longValue))) {
                imageCategory = this.mVideoProcessMap.get(Long.valueOf(longValue));
                imageCategory.mImageItemList.add(imageItemInfo);
            } else {
                imageCategory = new ImageCategory();
                imageCategory.mImageItemList.add(imageItemInfo);
                this.mVideoProcessMap.put(Long.valueOf(longValue), imageCategory);
            }
            if (imageCategory.isValid()) {
                this.mVideoProcessMap.remove(Long.valueOf(longValue));
                Message obtainMessage = this.mVideoProcessHandler.obtainMessage(1);
                obtainMessage.obj = imageCategory;
                obtainMessage.sendToTarget();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addMetadata(ImageCategory.MetaItemInfo metaItemInfo) {
        ImageCategory imageCategory;
        synchronized (this.mVideoQueueLock) {
            long longValue = ((Long) metaItemInfo.get(ApsParameters.KEY_TIME_STAMP)).longValue();
            if (this.mVideoProcessMap.containsKey(Long.valueOf(longValue))) {
                imageCategory = this.mVideoProcessMap.get(Long.valueOf(longValue));
                imageCategory.mMetaItem = metaItemInfo;
            } else {
                imageCategory = new ImageCategory();
                imageCategory.mMetaItem = metaItemInfo;
                this.mVideoProcessMap.put(Long.valueOf(longValue), imageCategory);
            }
            if (imageCategory.isValid()) {
                this.mVideoProcessMap.remove(Long.valueOf(longValue));
                Message obtainMessage = this.mVideoProcessHandler.obtainMessage(1);
                obtainMessage.obj = imageCategory;
                obtainMessage.sendToTarget();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r0.mMetaItem == null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r3 = r0.mMetaItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r3 = new com.oppo.camera.aps.adapter.ImageCategory.MetaItemInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r5 = new com.oppo.camera.aps.adapter.ApsParameters();
        r6 = r1.mImageProcessListener;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        if (r6 == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        r5.setAll(r6.fillApsParameters(r0, 3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = (com.oppo.camera.aps.adapter.ApsWatermarkParam) r3.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_APS_WATERMARK_PARAM);
        r0 = r0.mImageItemList;
        r14 = new com.oppo.camera.aps.adapter.ApsResult.ImageBuffer[r0.size()];
        r7 = new int[r0.size()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r4 >= r0.size()) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r8 = r0.get(r4);
        r14[r4] = r8.mImageBuffer;
        r7[r4] = ((java.lang.Integer) r8.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_ROLE)).intValue();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        if (r3.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT) == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
        r8 = ((android.hardware.camera2.CaptureResult) r3.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT)).getFrameNumber();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r17 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e4, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return r1.mApsInterface.addPreviewFrameBuff(new com.oppo.camera.aps.adapter.ApsPreviewParam(r8, r5.getParameters(), ((java.lang.Long) r2.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP)).longValue(), r14, (android.hardware.camera2.CaptureResult) r3.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT), (androidx.collection.ArrayMap) r3.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_META_MAP), r17, ((java.lang.Boolean) r2.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_NEED_META_DATA)).booleanValue(), ((java.lang.Boolean) r2.get(com.oppo.camera.aps.adapter.ApsParameters.KEY_IS_DETACHED)).booleanValue(), com.oppo.camera.aps.adapter.ApsUtils.getConsumerPtr(r2.mImageBuffer.getImageReader())), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        java.lang.System.currentTimeMillis();
        r2 = r0.mImageItemList.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int addVideoFrameBuff(com.oppo.camera.aps.adapter.ImageCategory r24) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            java.lang.Object r2 = r1.mPermitLock
            monitor-enter(r2)
            java.lang.Boolean r3 = r1.mbPermit     // Catch:{ all -> 0x00e8 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x00e8 }
            r4 = 0
            if (r3 != 0) goto L_0x0015
            r24.releaseImageItemList()     // Catch:{ all -> 0x00e8 }
            monitor-exit(r2)     // Catch:{ all -> 0x00e8 }
            return r4
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x00e8 }
            java.lang.System.currentTimeMillis()
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r2 = r0.mImageItemList
            java.lang.Object r2 = r2.get(r4)
            com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo r2 = (com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo) r2
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r3 = r0.mMetaItem
            if (r3 == 0) goto L_0x0028
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r3 = r0.mMetaItem
            goto L_0x002d
        L_0x0028:
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r3 = new com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo
            r3.<init>()
        L_0x002d:
            com.oppo.camera.aps.adapter.ApsParameters r5 = new com.oppo.camera.aps.adapter.ApsParameters
            r5.<init>()
            com.oppo.camera.aps.adapter.ApsAdapterInterface$ImageProcessListener r6 = r1.mImageProcessListener
            if (r6 == 0) goto L_0x003e
            r7 = 3
            java.util.HashMap r6 = r6.fillApsParameters(r0, r7)
            r5.setAll(r6)
        L_0x003e:
            com.oppo.camera.aps.adapter.ApsParameters$Key<com.oppo.camera.aps.adapter.ApsWatermarkParam> r6 = com.oppo.camera.aps.adapter.ApsParameters.KEY_APS_WATERMARK_PARAM
            java.lang.Object r6 = r3.get(r6)
            com.oppo.camera.aps.adapter.ApsWatermarkParam r6 = (com.oppo.camera.aps.adapter.ApsWatermarkParam) r6
            java.util.List<com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo> r0 = r0.mImageItemList
            int r7 = r0.size()
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer[] r14 = new com.oppo.camera.aps.adapter.ApsResult.ImageBuffer[r7]
            int r7 = r0.size()
            int[] r7 = new int[r7]
            r22 = -1
        L_0x0056:
            int r8 = r0.size()     // Catch:{ Exception -> 0x00e3 }
            if (r4 >= r8) goto L_0x0077
            java.lang.Object r8 = r0.get(r4)     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo r8 = (com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo) r8     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r9 = r8.mImageBuffer     // Catch:{ Exception -> 0x00e3 }
            r14[r4] = r9     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Integer> r9 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IMAGE_ROLE     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x00e3 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x00e3 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x00e3 }
            r7[r4] = r8     // Catch:{ Exception -> 0x00e3 }
            int r4 = r4 + 1
            goto L_0x0056
        L_0x0077:
            com.oppo.camera.aps.adapter.ApsParameters$Key<android.hardware.camera2.CaptureResult> r0 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x00e3 }
            if (r0 == 0) goto L_0x008c
            com.oppo.camera.aps.adapter.ApsParameters$Key<android.hardware.camera2.CaptureResult> r0 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x00e3 }
            android.hardware.camera2.CaptureResult r0 = (android.hardware.camera2.CaptureResult) r0     // Catch:{ Exception -> 0x00e3 }
            long r8 = r0.getFrameNumber()     // Catch:{ Exception -> 0x00e3 }
            goto L_0x008e
        L_0x008c:
            r8 = -1
        L_0x008e:
            r9 = r8
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r0 = r2.mImageBuffer     // Catch:{ Exception -> 0x00e3 }
            android.media.ImageReader r0 = r0.getImageReader()     // Catch:{ Exception -> 0x00e3 }
            long r20 = com.oppo.camera.aps.adapter.ApsUtils.getConsumerPtr(r0)     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ApsPreviewParam r0 = new com.oppo.camera.aps.adapter.ApsPreviewParam     // Catch:{ Exception -> 0x00e3 }
            java.lang.String[] r11 = r5.getParameters()     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Long> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_TIME_STAMP     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x00e3 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x00e3 }
            long r12 = r4.longValue()     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<android.hardware.camera2.CaptureResult> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_CAPTURE_RESULT     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r4 = r3.get(r4)     // Catch:{ Exception -> 0x00e3 }
            r15 = r4
            android.hardware.camera2.CaptureResult r15 = (android.hardware.camera2.CaptureResult) r15     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<androidx.collection.ArrayMap<java.lang.String, android.hardware.camera2.CameraMetadata>> r4 = com.oppo.camera.aps.adapter.ApsParameters.KEY_META_MAP     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x00e3 }
            r16 = r3
            androidx.collection.ArrayMap r16 = (androidx.collection.ArrayMap) r16     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r3 = com.oppo.camera.aps.adapter.ApsParameters.KEY_NEED_META_DATA     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r3 = r2.get(r3)     // Catch:{ Exception -> 0x00e3 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x00e3 }
            boolean r18 = r3.booleanValue()     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.Boolean> r3 = com.oppo.camera.aps.adapter.ApsParameters.KEY_IS_DETACHED     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x00e3 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x00e3 }
            boolean r19 = r2.booleanValue()     // Catch:{ Exception -> 0x00e3 }
            r8 = r0
            r17 = r7
            r8.<init>(r9, r11, r12, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x00e3 }
            com.oppo.camera.aps.algorithm.ApsInterface r2 = r1.mApsInterface     // Catch:{ Exception -> 0x00e3 }
            int r22 = r2.addPreviewFrameBuff(r0, r6)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00e7
        L_0x00e3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e7:
            return r22
        L_0x00e8:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00e8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsVideoAdapterImpl.addVideoFrameBuff(com.oppo.camera.aps.adapter.ImageCategory):int");
    }

    /* access modifiers changed from: protected */
    public void onPreviewReceived(ApsResult apsResult) {
        ApsAdapterListener.ApsServiceListener apsServiceListener = this.mApsServiceListener;
        if (apsServiceListener != null) {
            apsServiceListener.onVideoReceived(apsResult);
        }
    }

    /* access modifiers changed from: protected */
    public void flushImage() {
        synchronized (this.mVideoQueueLock) {
            Iterator<Map.Entry<Long, ImageCategory>> it = this.mVideoProcessMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (next.getValue() != null) {
                    for (ImageCategory.ImageItemInfo next2 : ((ImageCategory) next.getValue()).mImageItemList) {
                        if (!(next2 == null || next2.mImageBuffer == null)) {
                            next2.mImageBuffer.close();
                        }
                    }
                }
                it.remove();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        ProcessHandler processHandler = this.mVideoProcessHandler;
        if (processHandler != null) {
            processHandler.getLooper().quitSafely();
            this.mVideoProcessHandler = null;
        }
    }

    private void checkImageOverflow() {
        ArrayList arrayList = new ArrayList();
        List<Long> arrayList2 = new ArrayList<>();
        for (Map.Entry next : this.mVideoProcessMap.entrySet()) {
            if (!((ImageCategory) next.getValue()).mImageItemList.isEmpty()) {
                arrayList.add(next.getKey());
            }
        }
        if (arrayList.size() > 5) {
            arrayList2 = arrayList.subList(0, arrayList.size() - 5);
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (Long longValue : arrayList2) {
                ImageCategory imageCategory = (ImageCategory) this.mVideoProcessMap.remove(Long.valueOf(longValue.longValue()));
                String str = TAG;
                ApsAdapterLog.e(str, "checkImageOverflow, category: " + imageCategory);
                if (imageCategory != null) {
                    imageCategory.releaseImageItemList();
                }
            }
        }
    }

    private class ProcessHandler extends Handler {
        private ProcessHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                String access$200 = ApsVideoAdapterImpl.TAG;
                ApsAdapterLog.e(access$200, "handleMessage, msg: " + message.what + " is not defined.");
            } else if (message.obj == null || !(message.obj instanceof ImageCategory)) {
                String access$2002 = ApsVideoAdapterImpl.TAG;
                ApsAdapterLog.e(access$2002, "handleMessage, error msg: " + message.obj);
            } else {
                int unused = ApsVideoAdapterImpl.this.addVideoFrameBuff((ImageCategory) message.obj);
            }
        }
    }
}
