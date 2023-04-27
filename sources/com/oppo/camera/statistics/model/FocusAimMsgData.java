package com.oppo.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.camera.aps.constant.ApsConstant;

public class FocusAimMsgData extends DcsMsgData {
    private static final String EVENT_FOCUS_AIM = "focus_aim";
    private static final String KEY_ACT_TYPE = "act_type";
    public static final String KEY_ADJUST_EXPOSURE = "2";
    private static final String KEY_AE_AF_LOCK = "ae_af_lock";
    public static final String KEY_EXPOSURE_LOCK = "3";
    public static final String KEY_HYPER_LAPSE_FOCUS_TYPE = "4";
    public static final String KEY_INTELLIGENCE_VIEW_FOCUS_TYPE = "10";
    private static final String KEY_IS_RECORDING = "is_recording";
    public static final String KEY_MANUAL_FOCUS = "1";
    public static final String KEY_MULTI_VIDEO_DRAG_SCREEN_FOCUS_TYPE = "8";
    public static final String KEY_MULTI_VIDEO_FOCUS_TYPE = "7";
    public static final String KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE = "9";
    private static final String KEY_TOUCH_EV = "touch_ev";
    private static final String KEY_TOUCH_HYPER_LAPSE_FOCUS_VIEW_XY = "hyper_lapse_focus_view";
    public static final String KEY_TOUCH_TAKE_PICTURE = "6";
    private static final String KEY_TOUCH_XY = "touchXY";
    public static final String KEY_TRACKING_FOCUS = "7";
    private static final String TAG = "FocusAimMsgData";
    public String mActType = "";
    public String mAeAfLock = "";
    public String mHyperLapseFocusViewXY = "";
    public String mSubScreenValue = "";
    public String mTouchEV = "";
    public String mTouchXY = "";
    public boolean mbVideoRecording = false;

    public FocusAimMsgData(Context context) {
        super(context, EVENT_FOCUS_AIM, false);
    }

    public void report() {
        if (!TextUtils.isEmpty(this.mCaptureMode) && ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        checkEmptyCondition("ae_af_lock", this.mAeAfLock);
        if (this.mCaptureType == 1) {
            this.mEventMap.put(KEY_IS_RECORDING, String.valueOf(this.mbVideoRecording));
        }
        checkEmptyCondition(KEY_TOUCH_XY, this.mTouchXY);
        checkEmptyCondition("touch_ev", this.mTouchEV);
        checkEmptyCondition(KEY_TOUCH_HYPER_LAPSE_FOCUS_VIEW_XY, this.mHyperLapseFocusViewXY);
        checkEmptyCondition(KEY_ACT_TYPE, this.mActType);
        checkEmptyCondition("subscreen_value", this.mSubScreenValue);
        super.report();
    }
}
