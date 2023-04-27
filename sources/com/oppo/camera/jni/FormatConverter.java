package com.oppo.camera.jni;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;

public class FormatConverter {
    public static final int CHANNEL_NUMS_GRAY = 1;
    public static final int CHANNEL_NUMS_GRB565 = 2;
    public static final int CHANNEL_NUMS_RGB888 = 3;
    public static final int CHANNEL_NUMS_RGBA8888 = 4;
    public static final int CHANNEL_NUMS_RGBAF16 = 8;
    public static final int FORMAT_ABGR8888 = 1;
    public static final int FORMAT_GRAY = 4;
    public static final int FORMAT_GRB565 = 2;
    public static final int FORMAT_RGB888 = 3;
    public static final int FORMAT_RGBA8888 = 0;
    public static final int FORMAT_RGBAF16 = 5;
    public static final int INTERP_TYPE_CUBIC = 3;
    public static final int INTERP_TYPE_CUBICS = 4;
    public static final int INTERP_TYPE_LANCZOS = 2;
    public static final int INTERP_TYPE_LINEAR = 1;
    public static final int INTERP_TYPE_NEAREST = 0;
    public static final int PRECISION_LEVEL_HIGH = 0;
    public static final int PRECISION_LEVEL_LOW = 2;
    public static final int PRECISION_LEVEL_MEDIUM = 1;
    public static final int ROTATION_ANGLE_0 = 0;
    public static final int ROTATION_ANGLE_180 = 2;
    public static final int ROTATION_ANGLE_90 = 1;
    public static final int ROTATION_ANGLE_N_90 = 3;
    public static final int YUV_STANDARD_ANDROID_NV21 = 0;
    public static final int YUV_STANDARD_BT2020 = 3;
    public static final int YUV_STANDARD_BT601 = 1;
    public static final int YUV_STANDARD_BT709 = 2;

    public static native void rotateAndMirrorYUV(byte[] bArr, byte[] bArr2, int i, int[] iArr, int[] iArr2, int i2, int i3, int i4, boolean z);

    public native int argbToNv21(Bitmap bitmap, byte[] bArr, byte[] bArr2, int i);

    public native void glReadPixelsToBitmap(Bitmap bitmap, int i, int i2, int i3, int i4);

    public native int hardwareBufferToBitmapProcess(long j, HardwareBuffer hardwareBuffer, int i, Bitmap bitmap, int i2);

    public native long nv21ToBitmapInit(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, int i11, int i12);

    public native long nv21ToBitmapInitWithHardwareBuffer(HardwareBuffer hardwareBuffer, int i, int i2, int i3, int i4, float f, int i5, int i6, int i7, int i8, int i9);

    public native int nv21ToBitmapProcess(long j, byte[] bArr, int i, Bitmap bitmap, int i2);

    public native int nv21ToBitmapUnInit(long j);

    public native void scaleArea(Bitmap bitmap, int i, int i2, int i3, Bitmap bitmap2, int i4, int i5, int i6, int i7);

    public native void statisticsHistogramRGB(byte[] bArr, float[] fArr, int i, int i2, int i3, float[] fArr2, float[] fArr3, float[] fArr4);

    static {
        System.loadLibrary("FormatConverter");
    }
}
