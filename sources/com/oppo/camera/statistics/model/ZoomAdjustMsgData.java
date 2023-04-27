package com.oppo.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.camera.aps.constant.ApsConstant;

public class ZoomAdjustMsgData extends DcsMsgData {
    public static final int CIRCLE_ZOOM_CLICK_TYPE = 7;
    public static final int DOUBLE_FINGER_TYPE = 4;
    private static final String EVENT_ZOOM_ADJUST = "zoom_adjust";
    public static final int INERTIAL_ZOOM_END_TYPE = 5;
    public static final int INERTIAL_ZOOM_TYPE = 6;
    private static final String KEY_INERTIAL_RATE_VALUE = "rate_value";
    private static final String KEY_IS_RECORDING = "is_recording";
    private static final String KEY_ZOOM_TYPE = "zoom_type";
    private static final String TAG = "ZoomAdjustMsgData";
    public static final int VOLUME_BUTTON_TYPE = 3;
    public static final int ZOOM_BUTTON_TYPE = 1;
    public static final int ZOOM_SEEKBAR_TYPE = 2;
    public String mRateValue = "";
    public int mZoomType = 1;
    public String mZoomValue = "";
    public boolean mbVideoRecording = false;

    public ZoomAdjustMsgData(Context context) {
        super(context, EVENT_ZOOM_ADJUST, false);
    }

    public void report() {
        if (!TextUtils.isEmpty(this.mCaptureMode) && ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        if (1 == this.mCaptureType) {
            checkNoAnyCondition(KEY_IS_RECORDING, String.valueOf(this.mbVideoRecording));
        }
        checkEmptyCondition("zoom_value", this.mZoomValue);
        checkNoAnyCondition(KEY_ZOOM_TYPE, String.valueOf(this.mZoomType));
        checkEmptyCondition(KEY_INERTIAL_RATE_VALUE, this.mRateValue);
        super.report();
    }
}
