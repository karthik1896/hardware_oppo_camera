package com.oppo.camera.tiltshift;

public class TiltShiftPreview {
    public native int destory();

    public native int getMaskTexture(int i, int i2, float f, float f2, float f3, float f4, boolean z, int[] iArr);

    public native int init(int i, int i2, int i3, int i4);

    public native int process(int i, int i2, int[] iArr);

    public native int setDebugMask(boolean z);

    public native int setParam(int i, float f);

    static {
        System.loadLibrary("ApsTiltShifPreviewJni");
    }
}
