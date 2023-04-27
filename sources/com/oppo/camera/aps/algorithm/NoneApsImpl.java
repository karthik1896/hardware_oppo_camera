package com.oppo.camera.aps.algorithm;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.aps.APSClient;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureParam;
import com.oppo.camera.aps.adapter.ApsCaptureRequestParam;
import com.oppo.camera.aps.adapter.ApsInitParameter;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsPreviewDecisionParam;
import com.oppo.camera.aps.adapter.ApsPreviewParam;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsUtils;
import com.oppo.camera.aps.adapter.ApsWatermarkParam;
import com.oppo.camera.aps.algorithm.ApsInterface;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class NoneApsImpl implements ApsInterface {
    public static final int CAPTURE_PROC_DELAY = 20;
    public static final int MSG_APS_CAPTURE = 0;
    public static final int MSG_APS_PREVIEW = 1;
    private static final String TAG = "NoneApsImpl";
    private ApsInterface.ApsListener mApsListener = null;
    private Queue<CaptureFrame> mCaptureFrameQueue = new LinkedBlockingQueue();
    private final Object mCaptureQueueLock = new Object();
    private ProcessHandler mProcessHandler = null;

    public static final class CaptureFrame {
        public ApsInterface.ApsListener mApsListener;
        public byte[] mData = null;
        public int mHeight = 0;
        public long mTimeStamp = -1;
        public int mWidth = 0;
    }

    public static final class PreviewFrame {
        public ApsInterface.ApsListener mApsListener;
        public Image mImage = null;
        public CaptureResult mMetadata = null;
        public String mPipeline = "";
        public Surface mSurface = null;
        public long mTimeStamp = -1;
    }

    public int beforeCapture(ApsParameters apsParameters) {
        return -1;
    }

    public int forceStop(int i) {
        return 0;
    }

    public void initAlgo(ApsInitParameter apsInitParameter) {
    }

    public boolean isApsPreviewInit() {
        return true;
    }

    public Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, ApsParameters apsParameters) {
        return bitmap;
    }

    public int releaseBuffer(String str, HardwareBuffer hardwareBuffer) {
        return 0;
    }

    public Rect[] roiTranslate(Rect[] rectArr) {
        return null;
    }

    public int setEnableAPSAlgoNode(String str, boolean z) {
        return 0;
    }

    public int setEnableAPSPipeline(String str, boolean z) {
        return 0;
    }

    public void setRequestMetadata(ApsCaptureRequestParam apsCaptureRequestParam) {
    }

    public void unInitAlgo(int i) {
    }

    public void updateThumbnailMap(ApsResult apsResult) {
    }

    public NoneApsImpl(ApsInterface.ApsListener apsListener) {
        this.mApsListener = apsListener;
    }

    public boolean connect() {
        ApsAdapterLog.v(TAG, "connect");
        if (this.mProcessHandler != null) {
            return true;
        }
        HandlerThread handlerThread = new HandlerThread("NoneApsImpl Process Thread");
        handlerThread.start();
        this.mProcessHandler = new ProcessHandler(handlerThread.getLooper());
        return true;
    }

    public void disconnect() {
        ProcessHandler processHandler = this.mProcessHandler;
        if (processHandler != null) {
            processHandler.getLooper().quitSafely();
            this.mProcessHandler = null;
        }
    }

    public int clear() {
        synchronized (this.mCaptureQueueLock) {
            this.mCaptureFrameQueue.clear();
        }
        return 0;
    }

    public int addFrameBuff(ApsCaptureParam apsCaptureParam) {
        ApsAdapterLog.d(TAG, "addFrameBuff, frameIdx: " + apsCaptureParam.getFrameNumber());
        Image image = apsCaptureParam.getImageBuffer().getImage();
        ByteBuffer[] buffers = ApsUtils.getBuffers(ApsUtils.getNumPlanesForFormat(image.getFormat()), image, image.getFormat());
        int[] bufferSize = ApsUtils.getBufferSize(buffers);
        CaptureFrame captureFrame = new CaptureFrame();
        captureFrame.mApsListener = this.mApsListener;
        captureFrame.mWidth = apsCaptureParam.getImageBuffer().getHardwareBuffer().getWidth();
        captureFrame.mHeight = apsCaptureParam.getImageBuffer().getHardwareBuffer().getWidth();
        captureFrame.mData = new byte[bufferSize[0]];
        buffers[0].get(captureFrame.mData);
        buffers[0].rewind();
        synchronized (this.mCaptureQueueLock) {
            this.mCaptureFrameQueue.add(captureFrame);
        }
        return 0;
    }

    public int processImages(String[] strArr, String[] strArr2, ApsWatermarkParam apsWatermarkParam) {
        ApsAdapterLog.d(TAG, "processImages");
        synchronized (this.mCaptureQueueLock) {
            if (this.mCaptureFrameQueue.isEmpty()) {
                return -1;
            }
            CaptureFrame poll = this.mCaptureFrameQueue.poll();
            int i = 0;
            while (true) {
                if (i < strArr.length) {
                    if (poll != null && strArr[i].equals(ApsParameters.KEY_PROCESS_IMAGE_IDENTITY)) {
                        poll.mTimeStamp = Long.decode(strArr[i + 1]).longValue();
                        break;
                    }
                    i += 2;
                } else {
                    break;
                }
            }
            this.mProcessHandler.sendMessageDelayed(this.mProcessHandler.obtainMessage(0, poll), 20);
            return 0;
        }
    }

    public APSClient.APSRuntimeInfo getRuntimeInfo() {
        return new APSClient.APSRuntimeInfo();
    }

    public ApsAdapterDecision.DecisionResult previewDecision(ApsPreviewDecisionParam apsPreviewDecisionParam) {
        ApsAdapterDecision.DecisionResult decisionResult = new ApsAdapterDecision.DecisionResult();
        decisionResult.mCameraId = apsPreviewDecisionParam.getCameraId();
        decisionResult.mCaptureMode = apsPreviewDecisionParam.getCaptureMode();
        decisionResult.mRequestFormat = 256;
        return decisionResult;
    }

    public int addPreviewFrameBuff(ApsPreviewParam apsPreviewParam, ApsWatermarkParam apsWatermarkParam) {
        int[] role = apsPreviewParam.getRole();
        ApsResult.ImageBuffer[] imageBufferArray = apsPreviewParam.getImageBufferArray();
        PreviewFrame previewFrame = new PreviewFrame();
        previewFrame.mApsListener = this.mApsListener;
        previewFrame.mTimeStamp = apsPreviewParam.getTimeStamp();
        previewFrame.mMetadata = apsPreviewParam.getMetaObj();
        for (int i = 0; i < imageBufferArray.length; i++) {
            if (role[i] == 0 || 1 == role[i]) {
                previewFrame.mImage = imageBufferArray[i].getImage();
            } else {
                imageBufferArray[i].close();
            }
        }
        String[] processParamters = apsPreviewParam.getProcessParamters();
        int i2 = 0;
        while (true) {
            if (i2 >= processParamters.length) {
                break;
            } else if (processParamters[i2].equals(ApsParameters.KEY_PIPELINE)) {
                previewFrame.mPipeline = processParamters[i2 + 1];
                break;
            } else {
                i2 += 2;
            }
        }
        this.mProcessHandler.sendMessage(this.mProcessHandler.obtainMessage(1, previewFrame));
        return 0;
    }

    public static class ProcessHandler extends Handler {
        public ProcessHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                CaptureFrame captureFrame = (CaptureFrame) message.obj;
                ApsResult apsResult = new ApsResult();
                apsResult.mIdentity = captureFrame.mTimeStamp;
                apsResult.mWidth = captureFrame.mWidth;
                apsResult.mHeight = captureFrame.mHeight;
                apsResult.mCopyBuffer = captureFrame.mData;
                apsResult.mBufferType = 256;
                captureFrame.mApsListener.onCaptureReceived(apsResult);
            } else if (i == 1) {
                PreviewFrame previewFrame = (PreviewFrame) message.obj;
                ApsResult apsResult2 = new ApsResult(previewFrame.mImage);
                apsResult2.mIdentity = previewFrame.mTimeStamp;
                apsResult2.mMetadata = previewFrame.mMetadata;
                apsResult2.mPipelineName = previewFrame.mPipeline;
                previewFrame.mApsListener.onPreviewReceived(apsResult2);
            }
        }
    }
}
