package com.oppo.camera.aps.adapter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.collection.ArrayMap;
import com.aps.APSClient;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsAdapterInterface;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.algorithm.ApsInterface;
import com.oppo.camera.aps.algorithm.CaptureApsImpl;
import com.oppo.camera.aps.algorithm.FullApsImpl;
import com.oppo.camera.aps.algorithm.NoneApsImpl;
import com.oppo.camera.aps.algorithm.PreviewApsImpl;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.service.ApsAdapterListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApsAdapterImpl implements ApsAdapterInterface, ApsInterface.ApsListener {
    private static final long APS_INIT_TIME_OUT_MS = 5000;
    private static final boolean DEBUG = false;
    private static final int HEIC_FORMAT_10_BITS = 2141391882;
    public static final int MSG_APS_ADD_FRAME = 3;
    public static final int MSG_APS_CONNECT = 1;
    public static final int MSG_APS_DISCONNECT = 2;
    private static final String TAG = "ApsAdapterImpl";
    /* access modifiers changed from: private */
    public final ConditionVariable mApsCaptureAlgoInitSig = new ConditionVariable();
    /* access modifiers changed from: private */
    public ApsInterface mApsInterface = null;
    /* access modifiers changed from: private */
    public ApsCaptureAdapterImpl mCaptureImpl = null;
    /* access modifiers changed from: private */
    public ApsAdapterInterface.ImageProcessListener mImageListener = null;
    /* access modifiers changed from: private */
    public ImageProcessHandler mImageProcessHandler = null;
    /* access modifiers changed from: private */
    public final ConditionVariable mInitSig = new ConditionVariable();
    /* access modifiers changed from: private */
    public ApsPreviewAdapterImpl mPreviewImpl = null;
    /* access modifiers changed from: private */
    public ApsVideoAdapterImpl mVideoImpl = null;
    /* access modifiers changed from: private */
    public final AtomicBoolean mbIsApsCaptureAlgoIniting = new AtomicBoolean(true);

    public ApsAdapterImpl(ApsAdapterInterface.ImageProcessListener imageProcessListener) {
        this.mImageListener = imageProcessListener;
        createImageProcessThread();
    }

    private void createImageProcessThread() {
        HandlerThread handlerThread;
        if (this.mImageProcessHandler == null) {
            handlerThread = new HandlerThread("ImageProcessThread");
            handlerThread.start();
            this.mImageProcessHandler = new ImageProcessHandler(handlerThread.getLooper());
        } else {
            handlerThread = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("createProcessThread, thread id: ");
        sb.append(handlerThread == null ? 0 : handlerThread.getThreadId());
        ApsAdapterLog.v(TAG, sb.toString());
    }

    public void connectAps(boolean z) {
        ApsAdapterLog.v(TAG, "connectAps, version: 1.0.97");
        ImageProcessHandler imageProcessHandler = this.mImageProcessHandler;
        if (imageProcessHandler != null) {
            imageProcessHandler.obtainMessage(1, Boolean.valueOf(z)).sendToTarget();
        }
    }

    public int beforeCapture(ImageCategory.MetaItemInfo metaItemInfo) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            return apsCaptureAdapterImpl.beforeCapture(metaItemInfo);
        }
        return -1;
    }

    public void addImage(ImageCategory.ImageItemInfo imageItemInfo) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.addImage(imageItemInfo);
        }
    }

    public void addPreviewImage(ImageCategory.ImageItemInfo imageItemInfo) {
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            apsPreviewAdapterImpl.mApsServiceListener = imageItemInfo.mApsServiceListener;
        }
        ApsVideoAdapterImpl apsVideoAdapterImpl = this.mVideoImpl;
        if (apsVideoAdapterImpl != null) {
            apsVideoAdapterImpl.mApsServiceListener = imageItemInfo.mApsServiceListener;
        }
        ApsPreviewAdapterImpl apsPreviewAdapterImpl2 = this.mPreviewImpl;
        if (apsPreviewAdapterImpl2 != null) {
            apsPreviewAdapterImpl2.addImage(imageItemInfo);
        }
    }

    public void addVideoImage(ImageCategory.ImageItemInfo imageItemInfo) {
        ApsVideoAdapterImpl apsVideoAdapterImpl = this.mVideoImpl;
        if (apsVideoAdapterImpl != null) {
            apsVideoAdapterImpl.addImage(imageItemInfo);
        }
    }

    public void updateThumbnailMap(long j) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.updateThumbnailMap(j);
        }
    }

    public void addMetadata(ImageCategory.MetaItemInfo metaItemInfo) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.addMetadata(metaItemInfo);
        }
    }

    public void addTuningItem(ImageCategory.TuningItemInfo tuningItemInfo) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.addTuningItem(tuningItemInfo);
        }
    }

    public Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, ImageCategory.MetaItemInfo metaItemInfo) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        return apsCaptureAdapterImpl != null ? apsCaptureAdapterImpl.processBitmap(bitmap, captureResult, metaItemInfo) : bitmap;
    }

    public void videoSnapshot(ApsAdapterListener.CaptureCallback captureCallback, ApsCameraRequestTag apsCameraRequestTag) {
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            apsPreviewAdapterImpl.videoSnapshot(captureCallback, apsCameraRequestTag);
        }
    }

    public void addPreviewMetadata(ImageCategory.MetaItemInfo metaItemInfo) {
        ApsVideoAdapterImpl apsVideoAdapterImpl;
        if (metaItemInfo.get(ApsParameters.KEY_ITEM_INFO_TYPE) == ImageCategory.ItemInfoType.VIDEO && (apsVideoAdapterImpl = this.mVideoImpl) != null) {
            apsVideoAdapterImpl.addMetadata(metaItemInfo);
        }
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            apsPreviewAdapterImpl.addMetadata(metaItemInfo);
        }
    }

    public void disconnectAps() {
        ApsAdapterLog.v(TAG, "disconnectAps");
        ImageProcessHandler imageProcessHandler = this.mImageProcessHandler;
        if (imageProcessHandler != null) {
            imageProcessHandler.obtainMessage(2).sendToTarget();
            this.mImageProcessHandler.getLooper().quitSafely();
            this.mImageProcessHandler = null;
        }
    }

    public void onBeforeOpenCamera() {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.resetRawImageCategoryInfo();
        }
    }

    public void init(ApsInitParameter apsInitParameter) {
        this.mInitSig.block();
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            apsPreviewAdapterImpl.init(apsInitParameter);
            this.mPreviewImpl.setPermitProcess(true);
            this.mVideoImpl.setPermitProcess(true);
            if (1 == apsInitParameter.mApsModule || 2 == apsInitParameter.mApsModule) {
                this.mbIsApsCaptureAlgoIniting.set(false);
                this.mApsCaptureAlgoInitSig.open();
            } else if (3 == apsInitParameter.mApsModule) {
                this.mbIsApsCaptureAlgoIniting.set(true);
            }
        }
    }

    public void onDecisionControlData(ApsAdapterDecision.DecisionControlData decisionControlData) {
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            apsPreviewAdapterImpl.onDecisionControlData(decisionControlData);
        }
    }

    public void onCaptureReceived(ApsResult apsResult) {
        if (this.mCaptureImpl != null) {
            int i = apsResult.mBufferType;
            if (i != 17) {
                if (i == 32) {
                    this.mCaptureImpl.onRawReceived(apsResult);
                    return;
                } else if (i == 256) {
                    this.mCaptureImpl.onJpegReceived(apsResult);
                    return;
                } else if (i != HEIC_FORMAT_10_BITS) {
                    return;
                }
            }
            this.mCaptureImpl.onHeicReceived(apsResult);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreviewReceived(com.oppo.camera.aps.adapter.ApsResult r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.mPipelineName
            int r1 = r0.hashCode()
            r2 = -1234210005(0xffffffffb66f732b, float:-3.5680812E-6)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002c
            r2 = -903274338(0xffffffffca29209e, float:-2770983.5)
            if (r1 == r2) goto L_0x0022
            r2 = 628778404(0x257a65a4, float:2.171848E-16)
            if (r1 == r2) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r1 = "pipeline_default"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x0022:
            java.lang.String r1 = "pipeline_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = r3
            goto L_0x0037
        L_0x002c:
            java.lang.String r1 = "pipeline_preview"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = r4
            goto L_0x0037
        L_0x0036:
            r0 = -1
        L_0x0037:
            java.lang.String r1 = "ApsAdapterImpl"
            if (r0 == 0) goto L_0x0069
            if (r0 == r4) goto L_0x0069
            if (r0 == r3) goto L_0x005b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "onPreviewReceived, mPipelineName: "
            r0.append(r2)
            java.lang.String r6 = r6.mPipelineName
            r0.append(r6)
            java.lang.String r6 = " no need to processed."
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.oppo.camera.aps.ApsAdapterLog.e(r1, r6)
            goto L_0x0076
        L_0x005b:
            com.oppo.camera.aps.adapter.ApsVideoAdapterImpl r0 = r5.mVideoImpl
            if (r0 == 0) goto L_0x0063
            r0.onPreviewReceived(r6)
            goto L_0x0076
        L_0x0063:
            java.lang.String r6 = "onPreviewReceived, but mVideoImpl is null."
            com.oppo.camera.aps.ApsAdapterLog.e(r1, r6)
            goto L_0x0076
        L_0x0069:
            com.oppo.camera.aps.adapter.ApsPreviewAdapterImpl r0 = r5.mPreviewImpl
            if (r0 == 0) goto L_0x0071
            r0.onPreviewReceived(r6)
            goto L_0x0076
        L_0x0071:
            java.lang.String r6 = "onPreviewReceived, but mPreviewImpl is null."
            com.oppo.camera.aps.ApsAdapterLog.e(r1, r6)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.adapter.ApsAdapterImpl.onPreviewReceived(com.oppo.camera.aps.adapter.ApsResult):void");
    }

    public void initHeifCodec(long j) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.initHeifCodec(j);
        }
    }

    public void processHeifCodec(long j, HardwareBuffer hardwareBuffer, ApsExifData apsExifData, int i, int i2) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.processHeifCodec(j, hardwareBuffer, apsExifData, i, i2);
        }
    }

    public void uninitHeifCodec(long j) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.uninitHeifCodec(j);
        }
    }

    public void setHeicProcessInApp(boolean z) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.setHeicProcessInApp(z);
        }
    }

    public APSClient.APSRuntimeInfo getRuntimeInfo() {
        ApsInterface apsInterface = this.mApsInterface;
        if (apsInterface != null) {
            return apsInterface.getRuntimeInfo();
        }
        return null;
    }

    public void waitAddFrameFinish(boolean z) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.waitAddFrameFinish();
        }
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null && z) {
            apsPreviewAdapterImpl.unInit(1);
        }
    }

    public void onDestroy() {
        disconnectAps();
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            apsPreviewAdapterImpl.destroy();
            this.mPreviewImpl = null;
        }
        ApsVideoAdapterImpl apsVideoAdapterImpl = this.mVideoImpl;
        if (apsVideoAdapterImpl != null) {
            apsVideoAdapterImpl.destroy();
            this.mVideoImpl = null;
        }
    }

    public void countBurstShot(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.countBurstShot(imageItemInfo, metaItemInfo);
        }
    }

    public void closeCamera() {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            apsCaptureAdapterImpl.closeCamera();
        }
    }

    public boolean onCaptureFailed(long j, int i, int i2, boolean z, ImageCategory.ImageItemInfo imageItemInfo) {
        ApsCaptureAdapterImpl apsCaptureAdapterImpl = this.mCaptureImpl;
        if (apsCaptureAdapterImpl != null) {
            return apsCaptureAdapterImpl.countAddFrame(j, i, i2, z, imageItemInfo);
        }
        return false;
    }

    public boolean onPreviewFailed(long j) {
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            return apsPreviewAdapterImpl.dropFrame(j);
        }
        return false;
    }

    public int setEnableAPSPipeline(String str, boolean z) {
        if (this.mVideoImpl != null && ApsParameters.APS_PIPELINE_NAME_VIDEO.equals(str) && !z) {
            this.mVideoImpl.flushImage();
        }
        return this.mApsInterface.setEnableAPSPipeline(str, z);
    }

    public void setPermitProcess(ImageCategory.ItemInfoType itemInfoType, boolean z) {
        ApsVideoAdapterImpl apsVideoAdapterImpl;
        ApsPreviewAdapterImpl apsPreviewAdapterImpl;
        if (ImageCategory.ItemInfoType.PREVIEW == itemInfoType && (apsPreviewAdapterImpl = this.mPreviewImpl) != null) {
            apsPreviewAdapterImpl.setPermitProcess(z);
        } else if (ImageCategory.ItemInfoType.VIDEO == itemInfoType && (apsVideoAdapterImpl = this.mVideoImpl) != null) {
            apsVideoAdapterImpl.setPermitProcess(z);
        }
    }

    public int forceStop() {
        ApsAdapterLog.d(TAG, "forceStop");
        return this.mApsInterface.forceStop(1);
    }

    public int setEnableAPSAlgoNode(String str, boolean z) {
        return this.mApsInterface.setEnableAPSAlgoNode(str, z);
    }

    public Rect[] roiTranslate(Rect[] rectArr) {
        return this.mApsInterface.roiTranslate(rectArr);
    }

    public void sessionClosed(boolean z) {
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            if (z) {
                apsPreviewAdapterImpl.unInit(3);
            }
            this.mPreviewImpl.flushImage();
        }
        ApsVideoAdapterImpl apsVideoAdapterImpl = this.mVideoImpl;
        if (apsVideoAdapterImpl != null) {
            apsVideoAdapterImpl.flushImage();
        }
    }

    public void unInitApsAlgo(int i) {
        ApsPreviewAdapterImpl apsPreviewAdapterImpl = this.mPreviewImpl;
        if (apsPreviewAdapterImpl != null) {
            apsPreviewAdapterImpl.unInit(i);
        }
    }

    public void setRequestMetadata(String str, ArrayMap<String, Long> arrayMap, int i, int i2) {
        ApsCaptureRequestParam apsCaptureRequestParam = new ApsCaptureRequestParam();
        apsCaptureRequestParam.mLogicalId = Integer.valueOf(str).intValue();
        Long remove = arrayMap.remove(str);
        if (remove != null) {
            apsCaptureRequestParam.mLogicMetadata = remove.longValue();
        }
        apsCaptureRequestParam.mPhysicalMetadatas = arrayMap;
        apsCaptureRequestParam.mMasterCameraId = i;
        apsCaptureRequestParam.mActiveMap = i2;
        this.mApsInterface.setRequestMetadata(apsCaptureRequestParam);
    }

    private class ImageProcessHandler extends Handler {
        private ImageProcessHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            ApsInterface apsInterface;
            ApsAdapterLog.v(ApsAdapterImpl.TAG, "ImageProcessHandler, handleMessage, what: " + message.what);
            int i = message.what;
            if (i == 1) {
                if (ApsAdapterImpl.this.mApsInterface == null) {
                    int apsMode = AlgoSwitchConfig.getApsMode();
                    ApsAdapterImpl apsAdapterImpl = ApsAdapterImpl.this;
                    if (1 == apsMode) {
                        apsInterface = new FullApsImpl(apsAdapterImpl, ((Boolean) message.obj).booleanValue());
                    } else if (2 == apsMode) {
                        apsInterface = new CaptureApsImpl(apsAdapterImpl, ((Boolean) message.obj).booleanValue());
                    } else {
                        apsInterface = 3 == apsMode ? new PreviewApsImpl(apsAdapterImpl, ((Boolean) message.obj).booleanValue()) : new NoneApsImpl(apsAdapterImpl);
                    }
                    ApsInterface unused = apsAdapterImpl.mApsInterface = apsInterface;
                }
                ApsAdapterImpl apsAdapterImpl2 = ApsAdapterImpl.this;
                ApsPreviewAdapterImpl unused2 = apsAdapterImpl2.mPreviewImpl = new ApsPreviewAdapterImpl(apsAdapterImpl2.mApsInterface, ApsAdapterImpl.this.mImageListener);
                ApsAdapterImpl apsAdapterImpl3 = ApsAdapterImpl.this;
                ApsVideoAdapterImpl unused3 = apsAdapterImpl3.mVideoImpl = new ApsVideoAdapterImpl(apsAdapterImpl3.mApsInterface, ApsAdapterImpl.this.mImageListener);
                ApsAdapterImpl apsAdapterImpl4 = ApsAdapterImpl.this;
                ApsCaptureAdapterImpl unused4 = apsAdapterImpl4.mCaptureImpl = new ApsCaptureAdapterImpl(apsAdapterImpl4.mApsInterface, ApsAdapterImpl.this.mImageListener, ApsAdapterImpl.this.mImageProcessHandler);
                boolean connect = ApsAdapterImpl.this.mApsInterface.connect();
                ApsAdapterImpl.this.mInitSig.open();
                ApsAdapterLog.v(ApsAdapterImpl.TAG, "ImageProcessHandler, handleMessage, MSG_APS_CONNECT, result : " + connect);
            } else if (i != 2) {
                if (i == 3) {
                    ApsAdapterLog.d(ApsAdapterImpl.TAG, "ImageProcessHandler, handleMessage, start addFrameAndProcessImage");
                    if (ApsAdapterImpl.this.mbIsApsCaptureAlgoIniting.get()) {
                        ApsAdapterLog.d(ApsAdapterImpl.TAG, "ImageProcessHandler, handleMessage, need block, aps initializing...");
                        ApsAdapterImpl.this.mApsCaptureAlgoInitSig.close();
                        ApsAdapterImpl.this.mApsCaptureAlgoInitSig.block(ApsAdapterImpl.APS_INIT_TIME_OUT_MS);
                    }
                    ApsAdapterImpl.this.mCaptureImpl.addFrameAndProcessImage(((Long) message.obj).longValue());
                }
            } else if (ApsAdapterImpl.this.mApsInterface != null) {
                ApsAdapterImpl.this.mApsInterface.disconnect();
                ApsInterface unused5 = ApsAdapterImpl.this.mApsInterface = null;
            }
            ApsAdapterLog.v(ApsAdapterImpl.TAG, "ImageProcessHandler, handleMessage, what: " + message.what + " X");
        }
    }
}
