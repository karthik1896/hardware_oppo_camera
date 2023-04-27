package com.oppo.camera.aps.adapter;

import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.collection.ArrayMap;
import com.oppo.camera.aps.ApsCameraMetadataKey;
import java.util.Arrays;

public class ApsCaptureResult {
    public Integer mAwbMode = null;
    public Float mFocalLength = null;
    public long mFrameNumber = 0;
    public Float mLensAperture = null;
    public int[] mMasterPipeline = null;
    private ArrayMap<String, CameraMetadata> mMetaMap = null;
    public Long mSensorExposureTime = null;
    public int[] mSensorMask = null;
    public Integer mSensorSensitivity = null;
    public Long mSensorTimestamp = null;
    private CaptureResult mTotalCaptureResult = null;
    public int[] mUpscaleInputSize = null;
    public int[] mUpscaleOutputSize = null;

    public ApsCaptureResult(TotalCaptureResult totalCaptureResult, String str) {
        this.mFrameNumber = totalCaptureResult.getFrameNumber();
        this.mSensorTimestamp = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        this.mSensorSensitivity = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        this.mSensorExposureTime = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        this.mFocalLength = (Float) totalCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
        this.mLensAperture = (Float) totalCaptureResult.get(CaptureResult.LENS_APERTURE);
        this.mAwbMode = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_MODE);
        this.mSensorMask = (int[]) totalCaptureResult.get(ApsCameraMetadataKey.KEY_SENSOR_MASK);
        this.mMasterPipeline = (int[]) totalCaptureResult.get(ApsCameraMetadataKey.KEY_MASTER_PIPELINE);
        this.mUpscaleInputSize = (int[]) totalCaptureResult.get(ApsCameraMetadataKey.KEY_UPSCALE_INPUT_SIZE);
        this.mUpscaleOutputSize = (int[]) totalCaptureResult.get(ApsCameraMetadataKey.KEY_UPSCALE_OUTPUT_SIZE);
        this.mMetaMap = ApsUtils.assembleMetaMap(totalCaptureResult, str);
        this.mTotalCaptureResult = totalCaptureResult;
    }

    public final CaptureResult getTotalResult() {
        return this.mTotalCaptureResult;
    }

    public final ArrayMap<String, CameraMetadata> getMetaMap() {
        return this.mMetaMap;
    }

    public String toString() {
        return "{" + "mFrameNumber: " + this.mFrameNumber + ", mSensorTimestamp: " + this.mSensorTimestamp + ", mSensorSensitivity: " + this.mSensorSensitivity + ", mSensorExposureTime: " + this.mSensorExposureTime + ", mFocalLength: " + this.mFocalLength + ", mLensAperture: " + this.mLensAperture + ", mAwbMode: " + this.mAwbMode + ", mSensorMask: " + Arrays.toString(this.mSensorMask) + ", mMasterPipeline: " + Arrays.toString(this.mMasterPipeline) + ", mUpscaleInputSize: " + Arrays.toString(this.mUpscaleInputSize) + ", mUpscaleOutputSize: " + Arrays.toString(this.mUpscaleOutputSize) + ", mMetaMap: " + this.mMetaMap + ", mTotalCaptureResult: " + this.mTotalCaptureResult + "}";
    }
}
