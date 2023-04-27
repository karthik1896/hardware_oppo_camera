package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STHumanAction;

public class STMobileHumanActionNative {
    public static final long ST_MOBILE_BODY_ACTION1 = 4294967296L;
    public static final long ST_MOBILE_BODY_ACTION2 = 8589934592L;
    public static final long ST_MOBILE_BODY_ACTION3 = 17179869184L;
    public static final long ST_MOBILE_BODY_ACTION4 = 34359738368L;
    public static final long ST_MOBILE_BODY_ACTION5 = 68719476736L;
    public static final int ST_MOBILE_BODY_DETECT_FULL = 402653184;
    public static final long ST_MOBILE_BODY_KEYPOINTS = 134217728;
    public static final long ST_MOBILE_BROW_JUMP = 32;
    public static final long ST_MOBILE_DETECT_EXTRA_FACE_POINTS = 16777216;
    public static final long ST_MOBILE_DETECT_EYEBALL_CENTER = 33554432;
    public static final long ST_MOBILE_DETECT_EYEBALL_CONTOUR = 67108864;
    public static final int ST_MOBILE_DETECT_MODE_IMAGE = 262144;
    public static final int ST_MOBILE_DETECT_MODE_VIDEO = 131072;
    public static final int ST_MOBILE_ENABLE_BODY_CONTOUR = 16384;
    public static final int ST_MOBILE_ENABLE_BODY_KEYPOINTS = 4096;
    public static final int ST_MOBILE_ENABLE_EYEBALL_CENTER_DETECT = 1024;
    public static final int ST_MOBILE_ENABLE_EYEBALL_CONTOUR_DETECT = 2048;
    public static final int ST_MOBILE_ENABLE_FACE_DETECT = 64;
    public static final int ST_MOBILE_ENABLE_FACE_EXTRA_DETECT = 512;
    public static final int ST_MOBILE_ENABLE_HAIR_SEGMENT = 32768;
    public static final int ST_MOBILE_ENABLE_HAND_DETECT = 128;
    public static final int ST_MOBILE_ENABLE_INPUT_CUSTOM = 524288;
    public static final int ST_MOBILE_ENABLE_SEGMENT_DETECT = 256;
    public static final long ST_MOBILE_EYE_BLINK = 2;
    public static final long ST_MOBILE_FACE_DETECT = 1;
    public static final int ST_MOBILE_FACE_DETECT_FULL = 63;
    public static final long ST_MOBILE_HAND_CONGRATULATE = 131072;
    public static final int ST_MOBILE_HAND_DETECT_FULL = 2031360;
    public static final long ST_MOBILE_HAND_FINGER_HEART = 262144;
    public static final long ST_MOBILE_HAND_FINGER_INDEX = 1048576;
    public static final long ST_MOBILE_HAND_FIST = 2097152;
    public static final long ST_MOBILE_HAND_GOOD = 2048;
    public static final long ST_MOBILE_HAND_HOLDUP = 32768;
    public static final long ST_MOBILE_HAND_LOVE = 16384;
    public static final long ST_MOBILE_HAND_OK = 512;
    public static final long ST_MOBILE_HAND_PALM = 4096;
    public static final long ST_MOBILE_HAND_PISTOL = 8192;
    public static final long ST_MOBILE_HAND_SCISSOR = 1024;
    public static final long ST_MOBILE_HEAD_PITCH = 16;
    public static final long ST_MOBILE_HEAD_YAW = 8;
    public static final long ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_DETECT = 101177407;
    public static final int ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_IMAGE = 852416;
    public static final int ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_VIDEO = 131568;
    public static final long ST_MOBILE_MOUTH_AH = 4;
    public static final long ST_MOBILE_SEG_BACKGROUND = 65536;
    private static final String TAG = "STMobileHumanActionNative";
    private long nativeHumanActionHandle;
    private long nativeHumanActionImageHandle;

    public static native boolean[] getExpression(STHumanAction sTHumanAction, int i, boolean z);

    public static native void setExpressionThreshold(int i, float f);

    public native int addSubModel(String str);

    public native int addSubModelFromAssetFile(String str, AssetManager assetManager);

    public native int createInstance(String str, int i);

    public native int createInstanceFromAssetFile(String str, int i, AssetManager assetManager);

    public native int createInstanceImage(String str, int i, AssetManager assetManager);

    public native int createInstanceWithSubModels(String[] strArr, int i, int i2);

    public native void destroyInstance();

    public native void destroyInstanceImage();

    public native STHumanAction humanActionDetect(byte[] bArr, int i, long j, int i2, int i3, int i4);

    public native STHumanAction humanActionDetectImage(byte[] bArr, int i, long j, int i2, int i3, int i4, STHumanAction sTHumanAction);

    public native int removeSubModelByConfig(int i);

    public native void reset();

    public native int setParam(int i, float f);

    public native int setParamImage(int i, float f);

    public enum STMobileExpression {
        ST_MOBILE_EXPRESSION_EYE_BLINK(1),
        ST_MOBILE_EXPRESSION_MOUTH_AH(2),
        ST_MOBILE_EXPRESSION_HEAD_YAW(3),
        ST_MOBILE_EXPRESSION_HEAD_PITCH(4),
        ST_MOBILE_EXPRESSION_BROW_JUMP(5),
        ST_MOBILE_EXPRESSION_HAND_OK(9),
        ST_MOBILE_EXPRESSION_HAND_SCISSOR(10),
        ST_MOBILE_EXPRESSION_HAND_GOOD(11),
        ST_MOBILE_EXPRESSION_HAND_PALM(12),
        ST_MOBILE_EXPRESSION_HAND_PISTOL(13),
        ST_MOBILE_EXPRESSION_HAND_LOVE(14),
        ST_MOBILE_EXPRESSION_HAND_HOLDUP(15),
        ST_MOBILE_EXPRESSION_HAND_CONGRATULATE(17),
        ST_MOBILE_EXPRESSION_HAND_FINGER_HEART(18),
        ST_MOBILE_EXPRESSION_HAND_FINGER_INDEX(20),
        ST_MOBILE_EXPRESSION_HEAD_NORMAL(65),
        ST_MOBILE_EXPRESSION_SIDE_FACE_LEFT(66),
        ST_MOBILE_EXPRESSION_SIDE_FACE_RIGHT(67),
        ST_MOBILE_EXPRESSION_TILTED_FACE_LEFT(68),
        ST_MOBILE_EXPRESSION_TILTED_FACE_RIGHT(69),
        ST_MOBILE_EXPRESSION_HEAD_RISE(70),
        ST_MOBILE_EXPRESSION_HEAD_LOWER(71),
        ST_MOBILE_EXPRESSION_TWO_EYE_CLOSE(85),
        ST_MOBILE_EXPRESSION_TWO_EYE_OPEN(86),
        ST_MOBILE_EXPRESSION_LEFTEYE_OPEN_RIGHTEYE_CLOSE(87),
        ST_MOBILE_EXPRESSION_LEFTEYE_CLOSE_RIGHTEYE_OPEN(88),
        ST_MOBILE_EXPRESSION_MOUTH_OPEN(105),
        ST_MOBILE_EXPRESSION_MOUTH_CLOSE(106),
        ST_MOBILE_EXPRESSION_FACE_LIPS_UPWARD(107),
        ST_MOBILE_EXPRESSION_FACE_LIPS_POUTED(108),
        ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_LEFT(109),
        ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_RIGHT(110),
        ST_MOBILE_EXPRESSION_COUNT(128),
        ST_MOBILE_EXPRESSION_FACE_ALL(257),
        ST_MOBILE_EXPRESSION_HAND_ALL(258);
        
        private final int expressionCode;

        private STMobileExpression(int i) {
            this.expressionCode = i;
        }

        public int getExpressionCode() {
            return this.expressionCode;
        }
    }

    static {
        System.loadLibrary("st_sticker");
        System.loadLibrary("st_sticker_jni");
    }
}
