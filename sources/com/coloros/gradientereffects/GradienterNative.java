package com.coloros.gradientereffects;

public class GradienterNative {
    public static native void processGravity(float f, float f2, float f3, float[] fArr, int[] iArr, int[] iArr2);

    static {
        System.loadLibrary("GradienterNativeLib");
    }
}
