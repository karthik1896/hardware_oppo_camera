package com.oppo.camera.aps.algorithm;

import android.graphics.Rect;
import android.os.HandlerThread;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsPreviewParam;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsWatermarkParam;
import com.oppo.camera.aps.algorithm.ApsInterface;
import com.oppo.camera.aps.algorithm.NoneApsImpl;

public class CaptureApsImpl extends FullApsImpl {
    private static final String TAG = "CaptureApsImpl";
    private NoneApsImpl.ProcessHandler mProcessHandler = null;

    public Rect[] roiTranslate(Rect[] rectArr) {
        return null;
    }

    public int setEnableAPSAlgoNode(String str, boolean z) {
        return 0;
    }

    public int setEnableAPSPipeline(String str, boolean z) {
        return 0;
    }

    public CaptureApsImpl(ApsInterface.ApsListener apsListener, boolean z) {
        super(apsListener, z);
    }

    public boolean connect() {
        ApsAdapterLog.v(TAG, "connect");
        if (this.mProcessHandler == null) {
            HandlerThread handlerThread = new HandlerThread("CaptureApsImpl Process Thread");
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

    public int addPreviewFrameBuff(ApsPreviewParam apsPreviewParam, ApsWatermarkParam apsWatermarkParam) {
        int[] role = apsPreviewParam.getRole();
        ApsResult.ImageBuffer[] imageBufferArray = apsPreviewParam.getImageBufferArray();
        NoneApsImpl.PreviewFrame previewFrame = new NoneApsImpl.PreviewFrame();
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
}
