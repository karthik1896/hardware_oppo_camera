package com.oppo.camera.statistics.model;

import android.content.Context;

public class DoubleExposureMsgData extends DcsMsgData {
    public static final String EVENT_FUNCTION_PARAMS_CLICK = "funcKey_click";
    public static final String EVENT_FUNCTION_PARAMS_GUIDE_PAGE = "guide_page";
    public static final String EVENT_FUNCTION_PARAMS_SELECT = "funcValue_select";
    public static final String EVENT_FUNCTION_PARAMS_VIDEO_CLIP = "video_clip";
    public static final String EVENT_FUNCTION_PARAMS_VIDEO_PLAYBACK = "video_playback";
    public static final String KEY_FUNC_ID_VALUE = "63";
    public static final String KEY_FUNC_ID_VALUE_TO_GALLERY = "68";
    public static final String KEY_FUNC_ID_VALUE_i = "67";
    public static final String KEY_FUNC_ITEM_VALUE_EFFECT = "db_expo_effect";
    public static final String KEY_FUNC_ITEM_VALUE_EFFECT_MIXED = "mixed";
    public static final String KEY_FUNC_ITEM_VALUE_EFFECT_SILHOUETTE = "silhouette";
    public static final String KEY_FUNC_ITEM_VALUE_PAGE0 = "db_expo_page0";
    public static final String KEY_FUNC_ITEM_VALUE_PAGE1 = "db_expo_page1";
    public static final String KEY_FUNC_ITEM_VALUE_PAGE2 = "db_expo_page2";
    private static final String KEY_FUNC_KEY_ID = "funcKey_id";
    private static final String KEY_FUNC_KEY_ITEM = "funcKey_item";
    private static final String KEY_FUNC_KEY_RESULT = "funcKey_result";
    private static final String KEY_FUNC_KEY_VALUE = "funckey_value";
    public static final String KEY_FUNC_VALUE_CANCEL = "cancel";
    public static final String KEY_FUNC_VALUE_EXIT = "exit";
    public static final String KEY_FUNC_VALUE_SAVE = "save";
    private static final String KEY_VIDEO_DURATION = "duration";
    private static final String KEY_VIDEO_EXIT_TYPE = "exit_type";
    public static final String KEY_VIDEO_EXIT_TYPE_VALUE_CHANGE = "change";
    public static final String KEY_VIDEO_EXIT_TYPE_VALUE_CLICK = "click";
    public static final String KEY_VIDEO_EXIT_TYPE_VALUE_GLIDE = "glide";
    private static final String KEY_VIDEO_FPS = "video_fps";
    private static final String KEY_VIDEO_OPEN_TYPE = "open_type";
    public static final String KEY_VIDEO_OPEN_TYPE_VALUE_DURABLE_GUIDE = "durable_guide";
    public static final String KEY_VIDEO_OPEN_TYPE_VALUE_FIRST_GUIDE = "first_guide";
    private static final String KEY_VIDEO_PAGE_DURATION = "page_duration";
    private static final String KEY_VIDEO_PAGE_ID = "page_id";
    public static final String KEY_VIDEO_PAGE_ID_VALUE_FROM_FIRST_VIDEO = "1";
    public static final String KEY_VIDEO_PAGE_ID_VALUE_FROM_GALLERY = "0";
    public static final String KEY_VIDEO_PAGE_ID_VALUE_FROM_GUIDE_GALLERY = "select_video";
    public static final String KEY_VIDEO_PAGE_ID_VALUE_FROM_PORTRAIT_VIDEO = "portrait_video";
    public static final String KEY_VIDEO_PAGE_ID_VALUE_FROM_SCENE_VIDEO = "scene_video";
    public static final String KEY_VIDEO_PAGE_ID_VALUE_FROM_SECOND_VIDEO = "2";
    public static final String KEY_VIDEO_PAGE_ID_VALUE_FROM_SECOND_VIDEO_RECORDING = "3";
    public static final String KEY_VIDEO_PAGE_ID_VALUE_FROM_VIDEO_OVERLAY = "video_overlay";
    private static final String KEY_VIDEO_SIZE_TYPE = "video_rec_mode";
    private static final String KEY_VIDEO_TIME = "video_time";
    public static final String POSITION_0 = "0";
    public static final String POSITION_1 = "1";
    public static final String POSITION_2 = "2";
    public static final String TAG = "DoubleExposureMsgData";
    public String mDuration = "";
    public String mExitType = "";
    public String mFuncKeyId = "";
    public String mFuncKeyItem = "";
    public String mFuncKeyResult = "";
    public String mFuncKeyValue = "";
    public String mOpenType = "";
    public String mPageDuration = "";
    public String mPageId = "";
    public String mVideoFps = "";
    public String mVideoRecMode = "";
    public String mVideoTime = "";

    public DoubleExposureMsgData(Context context) {
        super(context, "202", "", false);
    }

    public void buildEventId(String str) {
        this.mEventId = str;
    }

    public void report() {
        if ("funcValue_select".equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition("funcKey_item", this.mFuncKeyItem);
            checkEmptyCondition(KEY_FUNC_KEY_VALUE, this.mFuncKeyValue);
        }
        if (EVENT_FUNCTION_PARAMS_CLICK.equals(this.mEventId)) {
            checkEmptyCondition("funcKey_id", this.mFuncKeyId);
            checkEmptyCondition(KEY_FUNC_KEY_RESULT, this.mFuncKeyResult);
        }
        if (EVENT_FUNCTION_PARAMS_VIDEO_CLIP.equals(this.mEventId)) {
            checkEmptyCondition(KEY_VIDEO_PAGE_ID, this.mPageId);
            checkEmptyCondition("video_time", this.mVideoTime);
            checkEmptyCondition("video_rec_mode", this.mVideoRecMode);
            checkEmptyCondition("video_fps", this.mVideoFps);
        }
        if (EVENT_FUNCTION_PARAMS_VIDEO_PLAYBACK.equals(this.mEventId)) {
            checkEmptyCondition(KEY_VIDEO_PAGE_ID, this.mPageId);
            checkEmptyCondition(KEY_VIDEO_DURATION, this.mDuration);
        }
        if (EVENT_FUNCTION_PARAMS_GUIDE_PAGE.equals(this.mEventId)) {
            checkEmptyCondition(KEY_VIDEO_PAGE_ID, this.mPageId);
            checkEmptyCondition(KEY_VIDEO_PAGE_DURATION, this.mPageDuration);
            checkEmptyCondition(KEY_VIDEO_EXIT_TYPE, this.mExitType);
            checkEmptyCondition(KEY_VIDEO_OPEN_TYPE, this.mOpenType);
        }
        super.report();
    }
}
