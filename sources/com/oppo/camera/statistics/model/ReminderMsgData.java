package com.oppo.camera.statistics.model;

import android.content.Context;

public class ReminderMsgData extends DcsMsgData {
    public static final String CODE_BATTERY_FLASH = "battery_flash";
    public static final String CODE_BATTERY_VIDEO = "battery_video";
    public static final String CODE_CHARGE_FALSE = "charge_false";
    public static final String CODE_CHARGE_TRUE = "charge_true";
    public static final String CODE_CLEAN_LENS = "clean_lens";
    public static final String CODE_FLASH_ON = "flash_on";
    public static final String CODE_MEMORY_CAPTURE = "memory_capture";
    public static final String CODE_MORE_FACE = "more_face";
    public static final String CODE_MOVE_CLOSER = "move_closer";
    public static final String CODE_NO_FACE = "no_face";
    public static final String CODE_TEMPS_CAM = "temps_cam";
    public static final String CODE_TEMPS_FLASH = "temps_flash";
    public static final String CODE_TEMPS_VIDEO = "temps_video";
    public static final String CODE_TIME_SHORT = "time_short";
    public static final String CODE_VIDEO_SIZE_LIMIT = "size_limit";
    public static final String CODE_VIDEO_UNPARSEABLE = "video_unparseable";
    private static final String EVENT_AI_SCENE_CLICK = "ai_effect_click";
    private static final String EVENT_ID = "reminder";
    private static final String KEY_AI_LABEL_SWITCH = "ai_label_switch";
    public static final String KEY_AI_SCENE = "ai_scene";
    private static final String KEY_IS_RECORDING = "is_recording";
    private static final String KEY_REMINDER_CODE = "reminder_code";
    private static final String KEY_REMINDER_TRIGGER = "reminder_trigger";
    private static final String KEY_REMINDER_TYPE = "reminder_type";
    private static final String TAG = "ReminderMsgData";
    public static final String TYPE_ADVICE = "advice";
    public static final String TYPE_AI_SCENE = "ai_scene";
    public static final String TYPE_BOKEH_CODE = "bokeh_code";
    public static final String TYPE_DISABLE_CODE = "disable_code";
    public String mReminderAILabelSwitch;
    public String mReminderAIScene;
    public String mReminderCodeValue;
    public String mReminderTriggerValue;
    public String mReminderTypeValue;
    public boolean mbRecording;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReminderMsgData(Context context, boolean z) {
        super(context, z ? "200" : "202", EVENT_ID, false);
        this.mReminderTypeValue = "";
        this.mReminderCodeValue = "";
        this.mReminderTriggerValue = "";
        this.mReminderAILabelSwitch = "";
        this.mReminderAIScene = "";
        this.mbRecording = false;
    }

    public void report() {
        checkEmptyCondition(KEY_REMINDER_TYPE, this.mReminderTypeValue);
        checkEmptyCondition(KEY_REMINDER_CODE, this.mReminderCodeValue);
        checkEmptyCondition(KEY_REMINDER_TRIGGER, this.mReminderTriggerValue);
        checkEmptyCondition("ai_scene", this.mReminderAIScene);
        checkEmptyCondition(KEY_AI_LABEL_SWITCH, this.mReminderAILabelSwitch);
        checkNoAnyCondition(KEY_IS_RECORDING, String.valueOf(this.mbRecording));
        super.report();
    }

    public void buildAISceneItem() {
        this.mEventId = EVENT_AI_SCENE_CLICK;
    }
}
