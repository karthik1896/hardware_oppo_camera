package com.oppo.camera.aps.service;

import android.graphics.Rect;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ImageCategory;

public class ApsAdapterListener {

    public interface ApsServiceListener {
        void onFinishAddFrame(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo);

        void onPreviewReceived(ApsResult apsResult, ApsTotalResult apsTotalResult);

        void onReprocess(Image image, TotalCaptureResult totalCaptureResult, Rect rect, ApsCameraRequestTag apsCameraRequestTag);

        void onVideoReceived(ApsResult apsResult);

        void reportCaptureDataToDcs(Object obj, Object obj2);
    }

    public interface CaptureCallback {
        void onApsCaptureCompleted(ApsResult apsResult, ApsTotalResult apsTotalResult, ApsCameraRequestTag apsCameraRequestTag);

        void onApsCaptureStarted(long j);
    }
}
