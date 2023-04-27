package com.oppo.camera.aps.algorithm;

import android.graphics.Bitmap;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import android.os.HandlerThread;
import com.aps.APSClient;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureParam;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsPreviewDecisionParam;
import com.oppo.camera.aps.adapter.ApsUtils;
import com.oppo.camera.aps.adapter.ApsWatermarkParam;
import com.oppo.camera.aps.algorithm.ApsInterface;
import com.oppo.camera.aps.algorithm.NoneApsImpl;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PreviewApsImpl extends FullApsImpl {
    private static final String TAG = "PreviewApsImpl";
    private Queue<NoneApsImpl.CaptureFrame> mCaptureFrameQueue = new LinkedBlockingQueue();
    private final Object mCaptureQueueLock = new Object();
    private NoneApsImpl.ProcessHandler mProcessHandler = null;

    public int beforeCapture(ApsParameters apsParameters) {
        return -1;
    }

    public Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, ApsParameters apsParameters) {
        return bitmap;
    }

    public PreviewApsImpl(ApsInterface.ApsListener apsListener, boolean z) {
        super(apsListener, z);
    }

    public boolean connect() {
        ApsAdapterLog.v(TAG, "connect");
        if (this.mProcessHandler == null) {
            HandlerThread handlerThread = new HandlerThread("PreviewApsImpl Process Thread");
            handlerThread.start();
            this.mProcessHandler = new NoneApsImpl.ProcessHandler(handlerThread.getLooper());
        }
        return super.connect();
    }

    public void disconnect() {
        NoneApsImpl.ProcessHandler processHandler = this.mProcessHandler;
        if (processHandler != null) {
            processHandler.getLooper().quitSafely();
            this.mProcessHandler = null;
        }
        super.disconnect();
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
        NoneApsImpl.CaptureFrame captureFrame = new NoneApsImpl.CaptureFrame();
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
            NoneApsImpl.CaptureFrame poll = this.mCaptureFrameQueue.poll();
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
}
