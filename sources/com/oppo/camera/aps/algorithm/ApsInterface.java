package com.oppo.camera.aps.algorithm;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import com.aps.APSClient;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureParam;
import com.oppo.camera.aps.adapter.ApsCaptureRequestParam;
import com.oppo.camera.aps.adapter.ApsExifData;
import com.oppo.camera.aps.adapter.ApsInitParameter;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsPreviewDecisionParam;
import com.oppo.camera.aps.adapter.ApsPreviewParam;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsWatermarkParam;

public interface ApsInterface {
    public static final int ADD_FRAME_ERROR = -1;
    public static final int ADD_FRAME_WITH_COPY = 0;
    public static final int ADD_FRAME_WITH_DETACH = 1;
    public static final int ADD_FRAME_WITH_HOLD = 2;

    public interface ApsListener {
        void initHeifCodec(long j);

        void onCaptureReceived(ApsResult apsResult);

        void onPreviewReceived(ApsResult apsResult);

        void processHeifCodec(long j, HardwareBuffer hardwareBuffer, ApsExifData apsExifData, int i, int i2);

        void setHeicProcessInApp(boolean z);

        void uninitHeifCodec(long j);
    }

    int addFrameBuff(ApsCaptureParam apsCaptureParam);

    int addPreviewFrameBuff(ApsPreviewParam apsPreviewParam, ApsWatermarkParam apsWatermarkParam);

    int beforeCapture(ApsParameters apsParameters);

    int clear();

    boolean connect();

    void disconnect();

    int forceStop(int i);

    APSClient.APSRuntimeInfo getRuntimeInfo();

    void initAlgo(ApsInitParameter apsInitParameter);

    boolean isApsPreviewInit();

    ApsAdapterDecision.DecisionResult previewDecision(ApsPreviewDecisionParam apsPreviewDecisionParam);

    Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, ApsParameters apsParameters);

    int processImages(String[] strArr, String[] strArr2, ApsWatermarkParam apsWatermarkParam);

    int releaseBuffer(String str, HardwareBuffer hardwareBuffer);

    Rect[] roiTranslate(Rect[] rectArr);

    int setEnableAPSAlgoNode(String str, boolean z);

    int setEnableAPSPipeline(String str, boolean z);

    void setRequestMetadata(ApsCaptureRequestParam apsCaptureRequestParam);

    void unInitAlgo(int i);

    void updateThumbnailMap(ApsResult apsResult);
}
