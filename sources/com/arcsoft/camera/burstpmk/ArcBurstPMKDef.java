package com.arcsoft.camera.burstpmk;

public final class ArcBurstPMKDef {
    public static final String DEFAUT_JNI_LIB_NAME = "jni_burstpmk";

    public static final class Dircetion {
        public static final int DIRECTION_BOTTOM2TOP = 3;
        public static final int DIRECTION_LEFT2RIGHT = 0;
        public static final int DIRECTION_RIGHT2LEFT = 1;
        public static final int DIRECTION_TOP2BOTTOM = 2;
        public static final int DIRECTION_UNKNOW = -1;
    }

    public static class MAsvlOffScreen {
        public static final int ASVL_PAF_GRAY = 1793;
        public static final int ASVL_PAF_I420 = 1537;
        public static final int ASVL_PAF_I422H = 1539;
        public static final int ASVL_PAF_I422V = 1538;
        public static final int ASVL_PAF_I444 = 1540;
        public static final int ASVL_PAF_LPI422H = 2051;
        public static final int ASVL_PAF_LPI422H2 = 2052;
        public static final int ASVL_PAF_MONO_I420 = 2562;
        public static final int ASVL_PAF_MONO_UYVY = 2561;
        public static final int ASVL_PAF_NEG_I420 = 2306;
        public static final int ASVL_PAF_NEG_UYVY = 2305;
        public static final int ASVL_PAF_NOTSET = 0;
        public static final int ASVL_PAF_NV12 = 2049;
        public static final int ASVL_PAF_NV21 = 2050;
        public static final int ASVL_PAF_P8_YUYV = 2819;
        public static final int ASVL_PAF_RAW_RGGB_10B = 3329;
        public static final int ASVL_PAF_SP16UNIT = 3073;
        public static final int ASVL_PAF_UVY = 1027;
        public static final int ASVL_PAF_UYVY = 1283;
        public static final int ASVL_PAF_UYVY2 = 1287;
        public static final int ASVL_PAF_VUY = 1028;
        public static final int ASVL_PAF_VYUY = 1284;
        public static final int ASVL_PAF_VYUY2 = 1288;
        public static final int ASVL_PAF_YUV = 1025;
        public static final int ASVL_PAF_YUYV = 1281;
        public static final int ASVL_PAF_YUYV2 = 1285;
        public static final int ASVL_PAF_YV12 = 1541;
        public static final int ASVL_PAF_YV16H = 1543;
        public static final int ASVL_PAF_YV16V = 1542;
        public static final int ASVL_PAF_YV24 = 1544;
        public static final int ASVL_PAF_YVU = 1026;
        public static final int ASVL_PAF_YVYU = 1282;
        public static final int ASVL_PAF_YVYU2 = 1286;
        public static final int ASVL_PAF_YYUV = 1289;
    }

    public static final class Msg {
        public static final int BURSTPMK_MSG_CAPTURE_FAILED = 3;
        public static final int BURSTPMK_MSG_CAPTURE_SUCCESS = 2;
        public static final int BURSTPMK_MSG_OUTPUT_RESULT_DATA = 4;
        public static final int BURSTPMK_MSG_TIP = 1;
    }

    public static final class Orientation {
        public static final int ORIENTATION_LANDSCAPE = 0;
        public static final int ORIENTATION_LAND_REV = 2;
        public static final int ORIENTATION_PORTRAIT = 1;
        public static final int ORIENTATION_PORT_REV = 3;
        public static final int ORIENTATION_UNKNOWN = -1;
    }

    public static final class ResultCode {
        public static final int MERR_BASIC_BASE = 1;
        public static final int MERR_INVALID_PARAM = 2;
        public static final int MERR_NONE = 0;
        public static final int MERR_NO_MEMORY = 4;
        public static final int MERR_UNKNOWN = 1;
        public static final int MERR_UNSUPPORTED = 3;
        public static final int MOK = 0;
        public static final int PMK_MERR_360DEGREE = 28681;
        public static final int PMK_MERR_BASE = 28672;
        public static final int PMK_MERR_MAX_FRAME_COUNT = 28680;
        public static final int PMK_MERR_SHAKE_TOO_BIG = 28679;
        public static final int PMK_MERR_STITCH_DIRECTION = 28678;
        public static final int PMK_MERR_TRACE_DIRECTION = 28673;
        public static final int PMK_MERR_TRACE_DIRECTION_BACK = 28689;
        public static final int PMK_MERR_TRACE_LESS_FEATURE = 28675;
        public static final int PMK_MERR_TRACE_NO_FEATURE = 28674;
        public static final int PMK_MERR_TRACE_TOO_QUICK = 28676;
        public static final int PMK_MERR_TRACE_TOO_SLOW = 28677;
        public static final int PMK_MERR_WRONG_DIRECTION = 28682;
        public static final int PMK_MWARN_BASE = 32768;
        public static final int PMK_MWARN_MOVE_SLOPE = 32769;
        public static final int PMK_MWARN_SHAKE_SMALL = 32784;
        public static final int PMK_MWARN_SHAKE_TOO_BIG = 32800;
        public static final int PMK_MWARN_TRACE_LITTLE_QUICK = 32896;
    }
}
