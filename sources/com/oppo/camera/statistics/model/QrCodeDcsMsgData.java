package com.oppo.camera.statistics.model;

import android.content.Context;

public class QrCodeDcsMsgData extends DcsMsgData {
    public static final String EVENT_FUNCTION_CLICK_QR_CODE = "click_qr_code";
    public static final String EVENT_FUNCTION_SCAN_QR_CODE = "scan_qr_code";
    public static final String KEY_CODE_RESULT = "code_result";
    public static final String KEY_PROTOCOL = "protocol";
    public static final int PARAMS_RESULT_QR_CODE = 1;
    public static final String TAG = "QrCodeDcsMsgData";
    public static final int TYPE_JUMP_HTTP = 1;
    public static final int TYPE_JUMP_INSTANT = 2;
    public static final int TYPE_JUMP_NONE = 4;
    public static final int TYPE_JUMP_WIFI = 3;
    public int mCodeResult = 1;
    public int mProtocol = -1;

    public QrCodeDcsMsgData(Context context) {
        super(context, "206", "", false);
    }

    public void buildEventId(boolean z) {
        this.mEventId = z ? EVENT_FUNCTION_CLICK_QR_CODE : EVENT_FUNCTION_SCAN_QR_CODE;
    }

    public void report() {
        if (EVENT_FUNCTION_SCAN_QR_CODE.equals(this.mEventId)) {
            checkGreatCondition(KEY_CODE_RESULT, this.mCodeResult, -1);
        }
        if (EVENT_FUNCTION_CLICK_QR_CODE.equals(this.mEventId)) {
            checkGreatCondition(KEY_CODE_RESULT, this.mCodeResult, -1);
            checkEmptyCondition(KEY_PROTOCOL, String.valueOf(this.mProtocol));
        }
        super.report();
    }
}
