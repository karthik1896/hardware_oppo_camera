package com.oppo.camera.aps.adapter;

import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class ApsInitParameter extends ApsParameters.ParameterModel {
    public static final int APS_MODULE_BOTH = 1;
    public static final int APS_MODULE_CAPTURE = 2;
    public static final int APS_MODULE_NONE = 0;
    public static final int APS_MODULE_PREVIEW = 3;
    public int mApsModule = 0;
    public String[] mInitAlgo = null;
    public CameraMetadata mMetadata = null;
    public String[] mParameters = null;
    public AlgoSwitchConfig.PreviewConfig mPreviewConfig = null;
    public ConcurrentHashMap<CaptureRequest.Key<?>, Integer> mVendorTagKeyMap = null;
    public String[] mVendorTags = null;
    public Surface mVideoSurface = null;
    public boolean mbHeicProcessInApp = false;

    public <T> void remove(ApsParameters.Key<T> key) {
        this.mParameterMap.remove(key);
    }

    public String toString() {
        return "{" + "mParameters: " + Arrays.toString(this.mParameters) + ", mMetadata: " + this.mMetadata + ", mApsModule: " + this.mApsModule + ", mInitAlgo: " + Arrays.toString(this.mInitAlgo) + ", mPreviewConfig: " + this.mPreviewConfig + ", mbHeicProcessInApp: " + this.mbHeicProcessInApp + "}";
    }
}
