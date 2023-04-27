package com.oppo.camera.aps.adapter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import androidx.collection.ArrayMap;
import com.aps.APSClient;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.service.ApsAdapterListener;
import java.util.HashMap;

public interface ApsAdapterInterface {

    public interface ImageProcessListener {
        void afterAddFrame(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo);

        void afterProcessImage(int i, ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo);

        HashMap<String, String> fillApsParameters(ApsInitParameter apsInitParameter);

        HashMap<String, String> fillApsParameters(ImageCategory imageCategory, int i);

        ApsInitParameter getApsInitParameter(ApsInitParameter apsInitParameter, ApsInitParameter apsInitParameter2);

        void initHeifCodec(long j);

        void onBurstShotEnd(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo);

        void onBurstShotStart(long j);

        void onHeicReceived(ApsResult apsResult);

        void onJpegReceived(ApsResult apsResult);

        void onPreviewFrameProcessStarted(long j, Long l);

        void onPreviewReceived(ApsResult apsResult, ImageCategory.ImageItemInfo imageItemInfo);

        void onProcessQueueEmpty();

        void onReprocess(ImageCategory imageCategory, ApsResult apsResult);

        void processHeifCodec(long j, HardwareBuffer hardwareBuffer, ApsExifData apsExifData, int i, int i2);

        void uninitHeifCodec(long j);
    }

    void addImage(ImageCategory.ImageItemInfo imageItemInfo);

    void addMetadata(ImageCategory.MetaItemInfo metaItemInfo);

    void addPreviewImage(ImageCategory.ImageItemInfo imageItemInfo);

    void addPreviewMetadata(ImageCategory.MetaItemInfo metaItemInfo);

    void addTuningItem(ImageCategory.TuningItemInfo tuningItemInfo);

    void addVideoImage(ImageCategory.ImageItemInfo imageItemInfo);

    int beforeCapture(ImageCategory.MetaItemInfo metaItemInfo);

    void closeCamera();

    void connectAps(boolean z);

    void countBurstShot(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo);

    void disconnectAps();

    int forceStop();

    APSClient.APSRuntimeInfo getRuntimeInfo();

    void init(ApsInitParameter apsInitParameter);

    void onBeforeOpenCamera();

    boolean onCaptureFailed(long j, int i, int i2, boolean z, ImageCategory.ImageItemInfo imageItemInfo);

    void onDecisionControlData(ApsAdapterDecision.DecisionControlData decisionControlData);

    void onDestroy();

    boolean onPreviewFailed(long j);

    Bitmap processBitmap(Bitmap bitmap, CaptureResult captureResult, ImageCategory.MetaItemInfo metaItemInfo);

    Rect[] roiTranslate(Rect[] rectArr);

    void sessionClosed(boolean z);

    int setEnableAPSAlgoNode(String str, boolean z);

    int setEnableAPSPipeline(String str, boolean z);

    void setPermitProcess(ImageCategory.ItemInfoType itemInfoType, boolean z);

    void setRequestMetadata(String str, ArrayMap<String, Long> arrayMap, int i, int i2);

    void unInitApsAlgo(int i);

    void updateThumbnailMap(long j);

    void videoSnapshot(ApsAdapterListener.CaptureCallback captureCallback, ApsCameraRequestTag apsCameraRequestTag);

    void waitAddFrameFinish(boolean z);
}
