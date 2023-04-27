package com.oppo.camera.jni;

import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;

public class OppoSloganJNI {
    public native int setSloganBuffer(byte[] bArr, int i, int i2, int i3, String str);

    public native int sloganFileDelete(String str);

    public native int sloganFileDeleteAll();

    public native int sloganFileExist(String str);

    static {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT)) {
            System.loadLibrary("OppoSloganForHalJni");
        } else {
            System.loadLibrary("OppoSloganJni");
        }
    }
}
