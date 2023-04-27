package com.sensetime.blur;

import android.graphics.Rect;
import com.oppo.camera.util.Util;

public class BlurFilterLibrary {
    public static final int ST_BLUR_PARAM_TYPE_CAMERA_DIRECTION = 8193;
    public static final int ST_BLUR_PARAM_TYPE_EFFECT_TYPE = 12289;
    public static final int ST_BLUR_PARAM_TYPE_KERNEL = 4102;
    public static final int ST_BLUR_PARAM_TYPE_LEVEL = 4097;
    public static final int ST_BLUR_PARAM_TYPE_MASK_EROSION_VALUE = 4101;
    public static final int ST_BLUR_PARAM_TYPE_MASK_MIN_AREA_SIZE = 4100;
    public static final int ST_BLUR_PARAM_TYPE_RECT_HEIGHT_SCALE = 4099;
    public static final int ST_BLUR_PARAM_TYPE_RECT_WIDTH_SCALE = 4098;
    public static final int ST_CAMERA_DIRECTION_BACK = 20482;
    public static final int ST_CAMERA_DIRECTION_FRONT = 20481;
    public static final int ST_EFFECT_TYPE_BLUR = 0;
    public static final int ST_EFFECT_TYPE_BLUR_GRAY = 2;
    public static final int ST_EFFECT_TYPE_GRAY = 1;

    public static native int OESTo2DTexture(int i, int[] iArr);

    public static native int ResizeTexture(int i, int i2, int i3, int i4);

    public static native int copy2DTexture(int i, int[] iArr);

    public static native int destroy();

    public static native int getMaskTextureByFace(Rect[] rectArr, boolean z, float[] fArr, int i, int i2, int i3, boolean z2);

    public static native String getVersion();

    public static native int init(int i, int i2);

    public static native int processMaskBuffer(byte[] bArr, int i, int i2, boolean z, int[] iArr);

    public static native int processMaskTexture(int i, int i2, int i3, int[] iArr);

    public static native int processOESTexture(int i, Rect[] rectArr, boolean z, float[] fArr, int i2, int i3, int i4, boolean z2, int[] iArr);

    public static native int processOESTextureByMask(int i, int i2, int i3, int i4, boolean z, int[] iArr);

    public static native int processOESTexureByMaskGradual(int i, int i2, int i3, int i4, boolean z, int i5, float[] fArr, int[] iArr);

    public static native int processTexture(int i, Rect[] rectArr, boolean z, float[] fArr, int i2, int i3, int i4, boolean z2, int[] iArr);

    public static native int processTextureByMask(int i, int i2, int i3, int i4, boolean z, int[] iArr);

    public static native int processTexureByMaskGradual(int i, int i2, int i3, int i4, boolean z, int i5, float[] fArr, int[] iArr);

    public static native int rotateGradualTexture(int i, boolean z, boolean z2);

    public static native int rotateMaskTexture(int i, boolean z, boolean z2);

    public static native int setDebug(boolean z);

    public static native int setDebugMask(boolean z);

    public static native int setParam(int i, float f);

    static {
        System.loadLibrary(Util.p() ? "jnistblur_api.qti" : "jnistblur_api.trustonic");
    }
}
