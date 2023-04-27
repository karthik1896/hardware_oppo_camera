package com.oppo.camera.jni;

import com.oppo.camera.util.Util;
import java.nio.ByteBuffer;

public class SuperNight {
    public static final int ALGO_MODE_ASN_REAR_RGGB_SDM845_HDR_PLUS = 16;
    public static final int ALGO_MODE_ASN_REAR_RGGB_SDM845_SUPER_NIGHT = 32;
    public static final int ARC_SN_CAMERA_MODE_OPPO_SDM670_12MB_IMX362 = 1073;
    public static final int ARC_SN_CAMERA_MODE_OPPO_SDM670_16MB_IMX519 = 1074;
    public static final int ARC_SN_CAMERA_MODE_OPPO_SDM710_12MB_IMX362 = 1057;
    public static final int ARC_SN_CAMERA_MODE_OPPO_SDM710_16MB_IMX519 = 1058;
    public static final int ARC_SN_CAMERA_MODE_OPPO_SDM845_12MB_IMX362 = 1041;
    public static final int ARC_SN_CAMERA_MODE_OPPO_SDM845_16MB_IMX519 = 1042;
    public static final int ARC_SN_CAMERA_MODE_UNKNOWN = -1;
    public static final int ARC_SN_FRONT_OPPO_P70_GRBG_6MB = 1105;
    public static final int ARC_SN_FRONT_OPPO_P80_GRBG_6MB = 1121;
    public static final int ARC_SN_REAR_OPPO_P70_GRBG_12MB = 1106;
    public static final int ARC_SN_REAR_OPPO_P80_GRBG_12MB = 1122;
    public static final int CAMERA_NIGHT_STATE_LENGTH = 3;
    public static final int CAMERA_NIGHT_STATE_POSITION_CAPTURENUM = 1;
    public static final int CAMERA_NIGHT_STATE_POSITION_MAXEXPOSURETIME = 2;
    public static final int CAMERA_NIGHT_STATE_POSITION_STATE = 0;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_FACE = 3;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_HAND = 2;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_INDOOR = 4;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_TRIPOD = 1;
    public static final int CAMERA_STATE_ARC_SN_CAMERA_STATE_UNKNOWN = 0;
    public static final int SN_STOP_INTERRUPT = 1;
    public static final int SN_STOP_QUIT = 2;

    public native int addFrame(int i, ByteBuffer byteBuffer, int i2, int i3);

    public native int[] getResultImage(ByteBuffer byteBuffer, int i);

    public native int init();

    public native int processImages();

    public native int setGlobalInputParams(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    public native int setInputParams(float f, float f2, float f3, float f4, float f5, float f6, float f7, long j, float f8, int i, int i2, int i3, int i4, int i5, int i6);

    public native int setOneFace(int i, int i2, int i3, int i4, int i5, int i6);

    public native int stop(int i);

    public native int unint();

    static {
        if (Util.p()) {
            System.loadLibrary("superNight");
        } else {
            System.loadLibrary("superNight_mtk");
        }
    }
}
