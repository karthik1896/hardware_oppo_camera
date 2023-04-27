package com.oppo.camera.statistics.model;

import android.content.Context;

public class SwitchCameraMsgData extends DcsMsgData {
    private static final String EVENT_SWITCH_CAMERA = "switch_cameraId";
    private static final String KEY_OPER_TYPE = "oper_type";
    private static final String KEY_TO_CAPTURE_MODE = "to_capture_mode";
    public static final String OPER_TYPE_SWITCH_CAMERA = "0";
    public static final String OPER_TYPE_SWITCH_MODE = "1";
    private static final String TAG = "SwitchCameraMsgData";
    public String mOperType;
    public String mToCaptureMode = "";

    public SwitchCameraMsgData(Context context) {
        super(context, EVENT_SWITCH_CAMERA, false);
    }

    public void report() {
        prepareLogTagByCaptureType();
        checkEmptyCondition(KEY_TO_CAPTURE_MODE, this.mToCaptureMode);
        checkEmptyCondition(KEY_OPER_TYPE, this.mOperType);
        super.report();
    }
}
