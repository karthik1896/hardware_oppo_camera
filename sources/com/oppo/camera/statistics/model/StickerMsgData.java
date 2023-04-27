package com.oppo.camera.statistics.model;

import android.content.Context;

public class StickerMsgData extends DcsMsgData {
    public static final int CONDITION_NAGATIVE_ONE = -1;
    private static final int CONDITION_ZERO = 0;
    private static final String EVENT_STICKER = "sticker";
    public static final String EVENT_STICKER_DELETE = "sticker_delete";
    public static final String EVENT_STICKER_DOWNLOAD = "sticker_download";
    public static final String EVENT_STICKER_SELECT = "sticker_select";
    private static final String KEY_DOWNLOAD_COST_TIME = "sticker_download_cost_time";
    private static final String KEY_DOWNLOAD_RESULT = "sticker_download_result";
    private static final String KEY_IS_MY_DOWNLOAD = "is_my_download";
    private static final String KEY_IS_SELECT_ALL = "is_select_all";
    private static final String KEY_OPER_TYPE = "oper_type";
    private static final String KEY_PROTOCOL_VERSION = "protocol_version";
    private static final String KEY_SELECT_COUNT = "select_count";
    private static final String KEY_STICKER_NAME = "sticker_name";
    private static final String KEY_STICKER_TYPE = "sticker_type";
    private static final String KEY_STICKER_UUID = "sticker_uuid";
    public static final String STICKER_DOWNLOAD_FAIL = "1";
    public static final String STICKER_DOWNLOAD_SUCCESS = "0";
    public static final String STICKER_OPER_CANCEL = "cancel";
    public static final String STICKER_OPER_DELETE = "delete";
    public static final String STICKER_OPER_DOWNLOAD = "download";
    public static final String STICKER_OPER_SELECT = "select";
    public String mDownloadResult = "";
    public String mMyDownload = "";
    public String mOperType = "";
    public String mProtocolVersion = "";
    public String mSelectAll = "";
    public int mSelectCount = 0;
    public long mStickerDownloadCostTime = -1;
    public String mStickerName = "";
    public String mStickerType = "";
    public String mStickerUuid = "";

    public StickerMsgData(Context context) {
        super(context, "205", "sticker", false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildEvent(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = -1917470146(0xffffffff8db5ba3e, float:-1.1199822E-30)
            java.lang.String r2 = "sticker_delete"
            java.lang.String r3 = "sticker_download"
            java.lang.String r4 = "sticker_select"
            r5 = 2
            r6 = 1
            if (r0 == r1) goto L_0x002c
            r1 = 88409418(0x545054a, float:9.263867E-36)
            if (r0 == r1) goto L_0x0024
            r1 = 1948060397(0x741d0aed, float:4.976881E31)
            if (r0 == r1) goto L_0x001c
            goto L_0x0034
        L_0x001c:
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0034
            r8 = r5
            goto L_0x0035
        L_0x0024:
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0034
            r8 = r6
            goto L_0x0035
        L_0x002c:
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0034
            r8 = 0
            goto L_0x0035
        L_0x0034:
            r8 = -1
        L_0x0035:
            if (r8 == 0) goto L_0x0046
            if (r8 == r6) goto L_0x0043
            if (r8 == r5) goto L_0x0040
            java.lang.String r8 = ""
            r7.mEventId = r8
            goto L_0x0048
        L_0x0040:
            r7.mEventId = r2
            goto L_0x0048
        L_0x0043:
            r7.mEventId = r3
            goto L_0x0048
        L_0x0046:
            r7.mEventId = r4
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.statistics.model.StickerMsgData.buildEvent(java.lang.String):void");
    }

    public void report() {
        if (this.mEventId.equals("sticker_download")) {
            checkGreatCondition("sticker_download_cost_time", this.mStickerDownloadCostTime, -1);
            checkEmptyCondition("sticker_download_result", this.mDownloadResult);
            checkEmptyCondition(KEY_OPER_TYPE, this.mOperType);
            checkEmptyCondition(KEY_PROTOCOL_VERSION, this.mProtocolVersion);
            checkEmptyCondition("sticker_name", this.mStickerName);
            checkEmptyCondition("sticker_type", this.mStickerType);
            checkEmptyCondition("sticker_uuid", this.mStickerUuid);
            checkEmptyCondition("zoom_value", this.mZoomValue);
        } else if (this.mEventId.equals(EVENT_STICKER_SELECT)) {
            checkEmptyCondition(KEY_IS_MY_DOWNLOAD, this.mMyDownload);
            checkEmptyCondition(KEY_OPER_TYPE, this.mOperType);
            checkEmptyCondition(KEY_PROTOCOL_VERSION, this.mProtocolVersion);
            checkEmptyCondition("sticker_name", this.mStickerName);
            checkEmptyCondition("sticker_type", this.mStickerType);
            checkEmptyCondition("sticker_uuid", this.mStickerUuid);
        } else if (this.mEventId.equals(EVENT_STICKER_DELETE)) {
            checkEmptyCondition(KEY_IS_SELECT_ALL, this.mSelectAll);
            checkEmptyCondition(KEY_OPER_TYPE, this.mOperType);
            checkGreatCondition(KEY_SELECT_COUNT, this.mSelectCount, 0);
        }
        super.report();
    }
}
