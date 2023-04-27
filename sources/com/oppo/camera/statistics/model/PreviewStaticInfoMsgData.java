package com.oppo.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.camera.aps.constant.ApsConstant;

public class PreviewStaticInfoMsgData extends DcsMsgData {
    private static final String EVENT_STATIC_INFO = "static_info";
    private static final String EVENT_STICKER_COUNT = "sticker_count";
    public static final int STICKER_COUNT_INIT = -1;
    public int mStickerCount = -1;

    public PreviewStaticInfoMsgData(Context context) {
        super(context, "200", EVENT_STATIC_INFO, false);
    }

    public void report() {
        if (!TextUtils.isEmpty(this.mCaptureMode) && ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        checkGreatCondition(EVENT_STICKER_COUNT, this.mStickerCount, -1);
        super.report();
    }
}
