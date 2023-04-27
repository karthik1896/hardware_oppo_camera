package com.oppo.camera.aps.algorithm;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import com.aps.APSClient;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureParam;
import com.oppo.camera.aps.adapter.ApsCaptureRequestParam;
import com.oppo.camera.aps.adapter.ApsExifData;
import com.oppo.camera.aps.adapter.ApsInitParameter;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsPreviewDecisionParam;
import com.oppo.camera.aps.adapter.ApsPreviewParam;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsUtils;
import com.oppo.camera.aps.adapter.ApsWatermarkParam;
import com.oppo.camera.aps.algorithm.ApsInterface;
import java.util.Arrays;

public class FullApsImpl implements APSClient.BufferCallback, APSClient.HeifCodecCallback, ApsInterface {
    private static final String TAG = "FullApsImpl";
    private APSClient mApsClient = null;
    protected ApsInterface.ApsListener mApsListener = null;
    private long mFrameLogInterval = 0;
    private String[] mInitCaptureAlgo = null;
    private String[] mInitCaptureParameter = null;
    private boolean mbApsPreviewInit = false;
    private boolean mbConnected = false;

    public void onServiceDied() {
    }

    public FullApsImpl(ApsInterface.ApsListener apsListener, boolean z) {
        this.mApsListener = apsListener;
        this.mApsClient = new APSClient(z);
        this.mApsClient.setDataCallback(this);
        this.mApsClient.setHeifCodecCallback(this);
    }

    public boolean connect() {
        ApsAdapterLog.v(TAG, "connect, mbConnected: " + this.mbConnected);
        if (this.mbConnected) {
            return true;
        }
        if (this.mApsClient.connect() != 0) {
            return false;
        }
        this.mbConnected = true;
        return true;
    }

    public void initAlgo(ApsInitParameter apsInitParameter) {
        ApsAdapterLog.v(TAG, "initAlgo, initParameter: " + apsInitParameter + ", mInitParameter: " + Arrays.toString(this.mInitCaptureParameter) + ", mInitAlgo: " + Arrays.toString(this.mInitCaptureAlgo));
        if (2 == apsInitParameter.mApsModule) {
            this.mApsClient.algoInit(apsInitParameter);
            unInitAlgo(apsInitParameter.mApsModule);
        } else {
            unInitAlgo(apsInitParameter.mApsModule);
            this.mApsClient.algoInit(apsInitParameter);
        }
        if (1 == apsInitParameter.mApsModule || 2 == apsInitParameter.mApsModule) {
            this.mInitCaptureParameter = apsInitParameter.mParameters;
            this.mInitCaptureAlgo = apsInitParameter.mInitAlgo;
        }
        if (1 == apsInitParameter.mApsModule || 3 == apsInitParameter.mApsModule) {
            this.mbApsPreviewInit = true;
        }
        ApsAdapterLog.v(TAG, "initAlgo, initParameter end");
    }

    public int beforeCapture(ApsParameters apsParameters) {
        return this.mApsClient.beforeCapture(apsParameters);
    }

    public int addFrameBuff(ApsCaptureParam apsCaptureParam) {
        return this.mApsClient.addFrameBuff(apsCaptureParam);
    }

    public ApsAdapterDecision.DecisionResult previewDecision(ApsPreviewDecisionParam apsPreviewDecisionParam) {
        return this.mApsClient.previewDecision(apsPreviewDecisionParam);
    }

    public int processImages(String[] strArr, String[] strArr2, ApsWatermarkParam apsWatermarkParam) {
        ApsAdapterLog.v(TAG, "processImages, processParameters: " + Arrays.toString(strArr) + ", algoFlags: " + Arrays.toString(strArr2));
        return this.mApsClient.processImages(strArr, strArr2, apsWatermarkParam);
    }

    public Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, ApsParameters apsParameters) {
        return this.mApsClient.processBitmap(bitmap, captureResult, apsParameters);
    }

    public void unInitAlgo(int i) {
        String[] strArr;
        String[] strArr2;
        ApsAdapterLog.v(TAG, "unInitAlgo, module: " + i + ", mInitParameter: " + Arrays.toString(this.mInitCaptureParameter) + ", mInitCaptureAlgo: " + Arrays.toString(this.mInitCaptureAlgo) + ", mbApsPreviewInit: " + this.mbApsPreviewInit);
        if (!((1 != i && 2 != i) || (strArr = this.mInitCaptureParameter) == null || (strArr2 = this.mInitCaptureAlgo) == null)) {
            this.mApsClient.unint(2, strArr, strArr2);
            this.mInitCaptureParameter = null;
            this.mInitCaptureAlgo = null;
        }
        if ((1 == i || 3 == i) && this.mbApsPreviewInit) {
            this.mApsClient.unint(3, (String[]) null, (String[]) null);
            this.mbApsPreviewInit = false;
        }
    }

    public int clear() {
        ApsAdapterLog.v(TAG, "clear");
        return this.mApsClient.clear();
    }

    public int releaseBuffer(String str, HardwareBuffer hardwareBuffer) {
        return this.mApsClient.releaseBuffer(str, hardwareBuffer);
    }

    public APSClient.APSRuntimeInfo getRuntimeInfo() {
        return this.mApsClient.getRuntimeInfo();
    }

    public void disconnect() {
        this.mApsClient.destroy();
        this.mbConnected = false;
    }

    public void onCaptureCallback(ApsResult apsResult) {
        ApsAdapterLog.v(TAG, "onDataCallback, result: " + apsResult);
        if (apsResult != null) {
            ApsInterface.ApsListener apsListener = this.mApsListener;
            if (apsListener != null) {
                apsListener.onCaptureReceived(apsResult);
            }
            apsResult.mCopyBuffer = null;
        }
    }

    public void onPreviewCallback(ApsResult apsResult) {
        if (apsResult == null) {
            ApsAdapterLog.w(TAG, "onPreviewCallback, apsResult is null, so return");
            return;
        }
        ApsInterface.ApsListener apsListener = this.mApsListener;
        if (apsListener != null) {
            apsListener.onPreviewReceived(apsResult);
        }
        apsResult.mCopyBuffer = null;
    }

    public int addPreviewFrameBuff(ApsPreviewParam apsPreviewParam, ApsWatermarkParam apsWatermarkParam) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mFrameLogInterval > 3000) {
            ApsAdapterLog.v(TAG, "addPreviewFrameBuff, time: " + apsPreviewParam.getTimeStamp() + ", roles: " + Arrays.toString(apsPreviewParam.getRole()));
            this.mFrameLogInterval = currentTimeMillis;
        }
        ApsResult.ImageBuffer[] imageBufferArray = apsPreviewParam.getImageBufferArray();
        if (apsPreviewParam.getIsDetached() && imageBufferArray != null) {
            for (int i = 0; i < imageBufferArray.length; i++) {
                ApsUtils.detachImage(imageBufferArray[i].getImageReader(), imageBufferArray[i].getImage());
            }
        }
        int addPreviewFrameBuff = this.mApsClient.addPreviewFrameBuff(apsPreviewParam, apsWatermarkParam);
        if (apsPreviewParam.getIsDetached() && imageBufferArray != null) {
            for (ApsResult.ImageBuffer image : imageBufferArray) {
                image.getImage().close();
            }
        }
        return addPreviewFrameBuff;
    }

    public int setEnableAPSPipeline(String str, boolean z) {
        return this.mApsClient.setEnableAPSPipeline(str, z);
    }

    public int setEnableAPSAlgoNode(String str, boolean z) {
        return this.mApsClient.setEnableAPSAlgoNode(str, z);
    }

    public Rect[] roiTranslate(Rect[] rectArr) {
        return this.mApsClient.roiTranslate(rectArr);
    }

    public void setRequestMetadata(ApsCaptureRequestParam apsCaptureRequestParam) {
        this.mApsClient.setRequestMetadata(apsCaptureRequestParam);
    }

    public void initHeifCodec(long j) {
        this.mApsListener.initHeifCodec(j);
    }

    public void processHeifCodec(long j, HardwareBuffer hardwareBuffer, ApsExifData apsExifData, int i, int i2) {
        this.mApsListener.processHeifCodec(j, hardwareBuffer, apsExifData, i, i2);
    }

    public void uninitHeifCodec(long j) {
        this.mApsListener.uninitHeifCodec(j);
    }

    public void setHeicProcessInApp(boolean z) {
        this.mApsListener.setHeicProcessInApp(z);
    }

    public void updateThumbnailMap(ApsResult apsResult) {
        this.mApsClient.updateThumbnailMap(apsResult);
    }

    public int forceStop(int i) {
        return this.mApsClient.stop(i);
    }

    public boolean isApsPreviewInit() {
        return this.mbApsPreviewInit;
    }
}
