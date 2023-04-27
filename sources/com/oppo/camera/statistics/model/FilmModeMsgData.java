package com.oppo.camera.statistics.model;

import android.content.Context;

public class FilmModeMsgData extends DcsMsgData {
    public static final String EVENT_FUNCTION_MENU_CLICK = "funcValue_click";
    public static final String EVENT_FUNCTION_PARAMS_SELECT = "funcValue_select";
    public static final String EVENT_FUNCTION_VIDEO_RECORD = "videoRecord";
    public static final String FUNC_KEY_ID_EIS = "38";
    public static final String FUNC_KEY_ID_EV = "43";
    public static final String FUNC_KEY_ID_FLASH = "3";
    public static final String FUNC_KEY_ID_FOCUS = "42";
    public static final String FUNC_KEY_ID_GRID = "37";
    public static final String FUNC_KEY_ID_HISTOGRAM = "58";
    public static final String FUNC_KEY_ID_ISO = "44";
    public static final String FUNC_KEY_ID_LOG = "57";
    public static final String FUNC_KEY_ID_MENU_RESOLUTION = "60";
    public static final String FUNC_KEY_ID_MENU_SWITCH = "59";
    public static final String FUNC_KEY_ID_SHUTTER = "40";
    public static final String FUNC_KEY_ID_SUBMENU = "26";
    public static final String FUNC_KEY_ID_SWITCH_CAMERA = "39";
    public static final String FUNC_KEY_ID_WB = "41";
    public static final String FUNC_KEY_RESULT_OFF = "2";
    public static final String FUNC_KEY_RESULT_ON = "1";
    private static final String KEY_FUNC_KEY_ID = "funcKey_id";
    private static final String KEY_FUNC_KEY_RESULT = "funcKey_result";
    private static final String KEY_FUNC_KEY_VALUE = "funckey_value";
    private static final String KEY_MOVIE_CAMERA_ID = "movie_camera_id";
    public String mFuncKeyId = "";
    public String mFuncKeyResult = "";
    public String mFuncKeyValue = "";
    public String mIsAssistantLine = "";
    public String mMovieCameraId = "";

    public void buildEventId(String str) {
        this.mEventId = str;
    }

    public FilmModeMsgData(Context context) {
        super(context, "202", "", false);
    }

    public void report() {
        if (EVENT_FUNCTION_MENU_CLICK.equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition(KEY_FUNC_KEY_RESULT, this.mFuncKeyResult);
        }
        if ("funcValue_select".equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition(KEY_MOVIE_CAMERA_ID, this.mMovieCameraId);
            checkEmptyCondition(KEY_FUNC_KEY_VALUE, this.mFuncKeyValue);
        }
        super.report();
    }
}
