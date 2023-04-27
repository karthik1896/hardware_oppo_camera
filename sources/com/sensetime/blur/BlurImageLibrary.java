package com.sensetime.blur;

public class BlurImageLibrary {
    public static final int ST_BLUR_PARAM_TYPE_EREA_RATIO = 4097;

    public static native int blurImage(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, float[] fArr, float f, float f2);

    public static native int blurImageGradual(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, float[] fArr, float[] fArr2, float f);

    public static native int blurImageSplit(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, float[] fArr, float f, float f2);

    public static native int createImageBlur(String str);

    public static native int destroyImageBlur();

    public static native String getVersion();

    public static native int initLicense(byte[] bArr);

    public static native int setDebug(boolean z);

    public static native int setParam(int i, float f);

    static {
        System.loadLibrary("jnistblur_capture_api");
        System.loadLibrary("stblur_capture_api");
    }
}
