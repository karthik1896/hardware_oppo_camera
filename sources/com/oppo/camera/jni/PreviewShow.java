package com.oppo.camera.jni;

import android.hardware.HardwareBuffer;

public class PreviewShow {
    public static native long init();

    public static native void process(HardwareBuffer hardwareBuffer, int i, int i2, long j);

    public static native void release(long j);
}
