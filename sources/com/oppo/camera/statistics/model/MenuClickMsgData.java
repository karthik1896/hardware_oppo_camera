package com.oppo.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.entry.b;
import com.oppo.camera.k;

public class MenuClickMsgData extends DcsMsgData {
    private static final String EVENT_FUNCTION_ITEM_CLICK = "funcValue_select";
    private static final String EVENT_FUNCTION_KEY_CLICK = "funcKey_click";
    private static final String EVENT_FUNCTION_MENU_CLICK = "funcMenu_select";
    public static final int FUNC_KEY_ANC_FILTER = 64;
    public static final int FUNC_KEY_BLUR = 9;
    public static final int FUNC_KEY_EDIT = 47;
    public static final int FUNC_KEY_FILTER = 4;
    public static final int FUNC_KEY_FLASH = 3;
    public static final int FUNC_KEY_GOOGLE_LENS = 53;
    public static final int FUNC_KEY_HDR = 8;
    public static final int FUNC_KEY_HYPER_LAPSE = 36;
    public static final int FUNC_KEY_MODE_PANEL = 1;
    public static final int FUNC_KEY_MULTI_VIDEO = 54;
    public static final int FUNC_KEY_NEW_STYLE_TYPE = 10;
    public static final int FUNC_KEY_NIGHT_FILTER = 50;
    public static final int FUNC_KEY_PANORAMA_DIRECTION = 19;
    public static final int FUNC_KEY_PHOTO_RATIO = 29;
    public static final int FUNC_KEY_PHOTO_RATIO_MP = 31;
    private static final String[] FUNC_KEY_PHOTO_RATIO_VALUE = {"standard", "square", "full", "16_9", "standard_high"};
    public static final int FUNC_KEY_PI = 7;
    public static final int FUNC_KEY_PROFESSION_EXPOSURE_COMPENSATION = 15;
    public static final int FUNC_KEY_PROFESSION_FOCUS = 14;
    public static final int FUNC_KEY_PROFESSION_ISO = 28;
    public static final int FUNC_KEY_PROFESSION_SHUTTER = 27;
    public static final int FUNC_KEY_PROFESSION_SWITCH_CAMERA = 22;
    public static final int FUNC_KEY_PROFESSION_WB = 13;
    public static final int FUNC_KEY_QUICK_SHARE_SHOW = 45;
    public static final int FUNC_KEY_RAW_CONTROL = 33;
    public static final int FUNC_KEY_SETTING = 5;
    public static final int FUNC_KEY_SHARE = 46;
    public static final int FUNC_KEY_SLOW_VIDEO_FPS = 51;
    public static final int FUNC_KEY_SLOW_VIDEO_MOVEMENT_DETECT = 35;
    public static final int FUNC_KEY_SLOW_VIDEO_RATIO = 21;
    public static final int FUNC_KEY_SMOOTH = 2;
    public static final int FUNC_KEY_SOLOOP = 55;
    public static final int FUNC_KEY_STICKER = 34;
    public static final int FUNC_KEY_SUB_SETTING = 26;
    public static final int FUNC_KEY_TIMER = 30;
    private static final String[] FUNC_KEY_TIMER_VALUE = {VideoRecordMsgData.END_TYPE_NORMAL, "3", FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE};
    public static final int FUNC_KEY_TO_GALLERY = 6;
    public static final int FUNC_KEY_TRIPOD_MODE = 32;
    public static final int FUNC_KEY_VIDEO_AI_ENHANCE = 52;
    public static final int FUNC_KEY_VIDEO_BLUR = 23;
    public static final int FUNC_KEY_VIDEO_FILTER = 24;
    public static final int FUNC_KEY_VIDEO_RATIO = 20;
    public static final int FUNC_KEY_VIDEO_SUPER_EIS = 25;
    public static final int FUNC_KEY_VIDEO_ULTRA_NIGHT = 50;
    private static final String KEY_AI_SCENE = "ai_scene";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_BUILD_IMAGE = "composition";
    public static final String[] KEY_COMMON_CUSTOM_BEAUTY = {DcsMsgData.KEY_SMOOTH_DERMABRASION, DcsMsgData.KEY_SMOOTH_FACE_LEAN, DcsMsgData.KEY_SMOOTH_EYE_BIG, DcsMsgData.KEY_SMOOTH_NOSE_LEAN, DcsMsgData.KEY_SMOOTH_FACE_JAW, DcsMsgData.KEY_SMOOTH_FACE_SMALL, DcsMsgData.KEY_SMOOTH_FRESHEN_UP, DcsMsgData.KEY_SMOOTH_CUBE};
    private static final String KEY_CUSTOMIZE = "author";
    private static final String KEY_DELAYTIME = "delay_time";
    private static final String KEY_FACE_RECTIFY = "face_rectify";
    private static final String KEY_FUNC_KEY_ID = "funcKey_id";
    private static final String KEY_FUNC_KEY_ITEM = "funcKey_item";
    private static final String KEY_FUNC_KEY_RESULT = "funcKey_result";
    private static final String KEY_FUNC_KEY_VALUE = "funcKey_value";
    private static final String KEY_FUNC_SLOGAN_CONTENT = "slogan_content";
    private static final String KEY_HELP_AND_FEEDBACK = "help_and_feedback";
    private static final String KEY_HIGH_GRADE = "high_grade";
    private static final String KEY_IS_AI_CLEAR_PHOTO = "is_ai_clear_photo";
    private static final String KEY_IS_ASSISTANT_LINE = "is_assistant_line";
    private static final String KEY_IS_GESTURE_CAPTURE_TYPE = "is_gesture_capture_type";
    private static final String KEY_IS_LOCATION_SLOGAN = "is_location_slogan";
    private static final String KEY_IS_MIRROR = "is_mirror";
    private static final String KEY_IS_MODEL_SLOGAN = "is_model_slogan";
    private static final String KEY_IS_QUICK_LAUNCH = "always_on_shot";
    private static final String KEY_IS_RECORDING = "is_recording";
    private static final String KEY_IS_RECORD_LOCATION = "is_record_location";
    private static final String KEY_IS_SCAN_CODE = "is_scan_code";
    private static final String KEY_IS_SHUTTER_VOICE = "is_shutter_voice";
    private static final String KEY_IS_SLOGAN = "is_slogan";
    private static final String KEY_IS_SMOOTH_ZOOM = "is_smooth_zoom";
    private static final String KEY_IS_TAP_CAPTURE_TYPE = "is_tap_capture_type";
    private static final String KEY_IS_TIME_SLOGAN = "is_time_slogan";
    private static final String KEY_LENS_DIRTY_DETECTION = "lens_dirty_detection";
    public static final String KEY_NONE_SMOOTH = "self_smooth_clear";
    private static final String KEY_PHOTO_FORMAT = "photo_format";
    private static final String KEY_PICSIZETYPE = "pic_size_type";
    public static final String KEY_PROFESSION_EXPOSURE_COMPENSATION = "profession_ev_value";
    public static final String KEY_PROFESSION_EXPOSURE_TIME = "profession_exp_time";
    public static final String KEY_PROFESSION_FOCUS_VALUE = "profession_focus_value";
    public static final String KEY_PROFESSION_HIGH_RESOLUTION = "profession_high_resolution";
    public static final String KEY_PROFESSION_ISO_VALUE = "profession_ISO_value";
    public static final String KEY_PROFESSION_WHITE_BALANCE = "profession_wb_value";
    private static final String KEY_RAW_CONTROL = "video_raw_control";
    public static final String KEY_RESET_SMOOTH = "self_smooth_reset";
    public static final int KEY_RESET_SMOOTH_CANCEL = 1;
    public static final int KEY_RESET_SMOOTH_DONE = 0;
    private static final String KEY_RESTORE_DEFAULT = "restore_default";
    public static final int KEY_RESULT_HIDE = 2;
    public static final int KEY_RESULT_SHOW = 1;
    private static final String KEY_SD_CARD_FIRST = "save_SDcard_first";
    private static final String KEY_SELFIE_LIGHT = "selfie_light";
    private static final String KEY_SHARE_AND_EDIT = "share_and_edit";
    private static final String KEY_SHOOT_FORMAT = "shoot_format";
    private static final String KEY_SHUTTER_ASSIST = "shutter_assist";
    private static final String KEY_SLOW_VIDEO_REC_MODE = "slowVideo_rec_mode";
    private static final String KEY_SPIRIT_LEVEL = "spirit_level";
    private static final String KEY_TOOLBAR_TYPE = "toolbar_type";
    private static final String KEY_VIDEO_ASSISTANT_LINE = "video_assistant_line";
    private static final String KEY_VIDEO_CODEC = "video_codec";
    private static final String KEY_VIDEO_FPS = "video_fps";
    private static final String KEY_VIDEO_RECORDER_SOUND = "video_recorder_sound";
    private static final String KEY_VIDEO_REC_MODE = "video_rec_mode";
    private static final String KEY_VOLUME_FUNCTION = "volume_function";
    public static final String QR_CODE_OFF = "off";
    public static final String QR_CODE_ON = "on";
    private static final String TAG = "MenuClickMsgData";
    public static final String ULTRA_ITEM = "ultra_stablized";
    public static final String ULTRA_OFF = "ultra_off";
    public static final String ULTRA_ON = "ultra_on";
    public static final String VALUE_PROFESSION_AUTO = "auto";
    public static final String VALUE_PROFESSION_AUTO_OFF = "auto_off";
    public static final String VALUE_SLOGAN_CONTENT_EXIST = "1";
    public static final String VALUE_SLOGAN_CONTENT_NOT_EXIST = "0";
    public static final String VALUE_TOOLBAR_CLICK = "1";
    public static final String VALUE_TOOLBAR_CLICK_SLIDE = "3";
    public static final String VALUE_TOOLBAR_SLIDE = "2";
    public static final String WNR_OFF = "wnr_off";
    public static final String WNR_ON = "wnr_on";
    public int mFuncKeyId = -1;
    public int mFuncKeyResult = -1;
    public String mItem = "";
    public String mItemValue = "";
    public String mToolbarType = "";
    public boolean mbVideoRecording = false;

    public MenuClickMsgData(Context context) {
        super(context, "200", "", false);
    }

    public void report() {
        if (!TextUtils.isEmpty(this.mCaptureMode) && ApsConstant.CAPTURE_MODE_STICKER.equals(this.mCaptureMode)) {
            this.mCaptureType = 2;
        }
        prepareLogTagByCaptureType();
        checkGreatCondition("funcKey_id", this.mFuncKeyId, 0);
        checkEmptyCondition(KEY_TOOLBAR_TYPE, this.mToolbarType);
        if (this.mEventId.equals("funcKey_click")) {
            checkGreatCondition(KEY_FUNC_KEY_RESULT, this.mFuncKeyResult, 0);
        }
        if (this.mEventId.equals("funcValue_select")) {
            checkEmptyCondition("funcKey_item", this.mItem);
            checkEmptyCondition("funcKey_value", this.mItemValue);
        }
        if (this.mEventId.equals(EVENT_FUNCTION_MENU_CLICK)) {
            checkEmptyCondition("funcKey_value", this.mItem);
        }
        if (this.mCaptureType == 1) {
            checkNoAnyCondition(KEY_IS_RECORDING, String.valueOf(this.mbVideoRecording));
        }
        if (this.mFuncKeyId == 5) {
            if (KEY_RESTORE_DEFAULT.equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
                checkNoAnyCondition("funcKey_value", this.mItemValue);
            }
            if (KEY_SLOW_VIDEO_REC_MODE.equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
                checkNoAnyCondition("funcKey_value", this.mItemValue);
            }
            if ("video_rec_mode".equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
                checkNoAnyCondition("funcKey_value", this.mItemValue);
            }
            if (KEY_IS_SLOGAN.equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
                checkNoAnyCondition("funcKey_value", this.mItemValue);
            }
            if ("author".equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
                checkNoAnyCondition("funcKey_value", this.mItemValue);
            }
            if (KEY_IS_SCAN_CODE.equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
                checkEmptyCondition("funcKey_item", KEY_IS_SCAN_CODE);
                checkNoAnyCondition("funcKey_value", Boolean.valueOf(this.mItemValue).booleanValue() ? "on" : "off");
            }
        }
        if (KEY_IS_MODEL_SLOGAN.equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
            checkNoAnyCondition("funcKey_value", this.mItemValue);
        }
        if (KEY_IS_TIME_SLOGAN.equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
            checkNoAnyCondition("funcKey_value", this.mItemValue);
        }
        if (KEY_IS_LOCATION_SLOGAN.equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
            checkNoAnyCondition("funcKey_value", this.mItemValue);
        }
        if ("author".equals(this.mItem) && !TextUtils.isEmpty(this.mItemValue)) {
            checkEmptyCondition("funcKey_item", KEY_IS_MODEL_SLOGAN);
            checkNoAnyCondition("funcKey_value", this.mItem);
            checkNoAnyCondition(KEY_FUNC_SLOGAN_CONTENT, this.mItemValue);
        }
        super.report();
    }

    public void buildMenuClick(k kVar, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!TextUtils.isEmpty(str) && !z) {
            this.mEventId = "funcKey_click";
            int i = 2;
            this.mFuncKeyResult = z2 ? 2 : 1;
            String string = kVar.getString(str, "off");
            String c = b.c(str);
            if ("pref_camera_flashmode_key".equals(c) || "pref_camera_torch_mode_key".equals(c) || "pref_camera_videoflashmode_key".equals(c)) {
                this.mFuncKeyId = 3;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_camera_hdr_mode_key".equals(c)) {
                this.mFuncKeyId = 8;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
                if (z4) {
                    this.mEventId = "funcValue_select";
                    this.mItemValue = kVar.getString("pref_camera_hdr_mode_key", "off");
                }
            } else if ("key_video_hdr".equals(c)) {
                this.mFuncKeyId = 8;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
                if (z4) {
                    this.mEventId = "funcValue_select";
                    this.mItemValue = kVar.getString("key_video_hdr", "off");
                }
            } else if ("pref_portrait_new_style_menu".equals(c)) {
                this.mFuncKeyId = 10;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_video_filter_menu".equals(c)) {
                this.mFuncKeyId = 24;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_filter_menu".equals(c)) {
                this.mFuncKeyId = z5 ? 64 : 4;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_night_filter_menu".equals(c)) {
                this.mFuncKeyId = 50;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_video_size_key".equals(c)) {
                this.mFuncKeyId = 20;
            } else if ("pref_slow_video_size_key".equals(c)) {
                this.mFuncKeyId = 21;
            } else if ("pref_video_blur_menu".equals(c)) {
                this.mFuncKeyId = 23;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_portrait_blur_menu".equals(c)) {
                this.mFuncKeyId = 9;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_switch_camera_key".equals(c)) {
                this.mFuncKeyId = 22;
                if (!z3) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_night_tripod_mode_key".equals(c)) {
                this.mFuncKeyId = 32;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_camera_pi_ai_mode_key".equals(c)) {
                this.mFuncKeyId = 7;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_camera_pi_mode_key".equals(c)) {
                this.mFuncKeyId = 7;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_video_super_eis_key".equals(c)) {
                this.mFuncKeyId = 25;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_video_hyper_lapse_key".equals(c)) {
                this.mFuncKeyId = 36;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_subsetting_key".equals(c)) {
                this.mFuncKeyId = 26;
                if (!"on".equals(kVar.getString(c, "off"))) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_camera_high_resolution_key".equals(c)) {
                this.mFuncKeyId = 31;
                if (z4) {
                    this.mEventId = "funcValue_select";
                    if (kVar.getBoolean("key_high_picture_size", false)) {
                        i = 1;
                    }
                    this.mItemValue = String.valueOf(i);
                }
            } else if ("pref_camera_photo_ratio_key".equals(c)) {
                this.mFuncKeyId = 29;
                if (z4) {
                    this.mEventId = "funcValue_select";
                    this.mItemValue = kVar.getString("pref_camera_photo_ratio_key", (String) null);
                }
            } else if ("pref_camera_timer_shutter_key".equals(c)) {
                this.mFuncKeyId = 30;
                if (z4) {
                    this.mEventId = "funcValue_select";
                    this.mItemValue = kVar.getString("pref_camera_timer_shutter_key", VideoRecordMsgData.END_TYPE_NORMAL);
                }
            } else if ("pref_raw_control_key".equals(c)) {
                this.mFuncKeyId = 33;
            } else if ("key_slow_video_frame_seek_bar_menu_key".equals(c)) {
                this.mFuncKeyId = 51;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_intelligent_high_frame_selected_key".equals(c)) {
                this.mFuncKeyId = 35;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("key_ultra_night_video".equals(c)) {
                this.mFuncKeyId = 50;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("key_multicamera_type_menu_key".equals(c)) {
                this.mFuncKeyId = 54;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("key_ai_enhancement_video".equals(c)) {
                this.mFuncKeyId = 52;
                if (!"on".equals(string)) {
                    i = 1;
                }
                this.mFuncKeyResult = i;
            } else if ("pref_platform_slow_video_fps_key".equals(c)) {
                this.mFuncKeyId = 51;
            }
        }
    }

    private String getNextValueOfArray(String[] strArr, String str) {
        if (!(strArr == null || strArr.length == 0 || str == null)) {
            for (int i = 0; i < strArr.length; i++) {
                if ("standard_high".equals(str)) {
                    return strArr[1];
                }
                if ("16_9".equals(str) || str.equals(strArr[strArr.length - 1])) {
                    return strArr[0];
                }
                if (str.equals(strArr[i]) && i < strArr.length - 1) {
                    return strArr[i + 1];
                }
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0203  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildMenuItem(java.lang.String r18, com.oppo.camera.k r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            boolean r3 = android.text.TextUtils.isEmpty(r18)
            if (r3 != 0) goto L_0x020b
            if (r1 != 0) goto L_0x0010
            goto L_0x020b
        L_0x0010:
            java.lang.String r3 = com.oppo.camera.entry.b.c(r18)
            java.lang.String r4 = r0.checkBeauty(r3)
            java.lang.String r5 = "pref_camera_flashmode_key"
            boolean r5 = r5.equals(r3)
            java.lang.String r7 = "pref_slow_video_rear_fps_key"
            java.lang.String r8 = "pref_super_eis_wide_key"
            java.lang.String r9 = "key_night_filter_index"
            java.lang.String r10 = "key_video_filter_index"
            java.lang.String r11 = "pref_portrait_blur_menu_index"
            java.lang.String r12 = "pref_video_blur_menu_state"
            java.lang.String r13 = "key_portrait_new_style_index"
            java.lang.String r14 = "key_filter_anc_index"
            java.lang.String r15 = "key_filter_index"
            r16 = 1
            r6 = 0
            if (r5 != 0) goto L_0x0126
            java.lang.String r5 = "pref_camera_torch_mode_key"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x0126
            java.lang.String r5 = "pref_camera_videoflashmode_key"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0047
            goto L_0x0126
        L_0x0047:
            java.lang.String r5 = "pref_camera_timer_shutter_key"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0055
            r4 = 30
            r0.mFuncKeyId = r4
            goto L_0x0129
        L_0x0055:
            java.lang.String r5 = "pref_camera_photo_ratio_key"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0063
            r4 = 29
            r0.mFuncKeyId = r4
            goto L_0x0129
        L_0x0063:
            java.lang.String r5 = "pref_camera_hdr_mode_key"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0071
            r4 = 8
            r0.mFuncKeyId = r4
            goto L_0x0129
        L_0x0071:
            boolean r5 = r11.equals(r3)
            if (r5 == 0) goto L_0x007d
            r4 = 9
            r0.mFuncKeyId = r4
            goto L_0x012b
        L_0x007d:
            java.lang.String r5 = "pref_video_size_key"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x008b
            r4 = 20
            r0.mFuncKeyId = r4
            goto L_0x0129
        L_0x008b:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0098
            r5 = 2
            r0.mFuncKeyId = r5
            r0.mItem = r4
            goto L_0x012b
        L_0x0098:
            boolean r4 = r15.equals(r3)
            if (r4 == 0) goto L_0x00a3
            r4 = 4
            r0.mFuncKeyId = r4
            goto L_0x012b
        L_0x00a3:
            boolean r4 = r14.equals(r3)
            if (r4 == 0) goto L_0x00af
            r4 = 64
            r0.mFuncKeyId = r4
            goto L_0x012b
        L_0x00af:
            boolean r4 = r13.equals(r3)
            if (r4 == 0) goto L_0x00bb
            r4 = 10
            r0.mFuncKeyId = r4
            goto L_0x012b
        L_0x00bb:
            boolean r4 = r9.equals(r3)
            if (r4 == 0) goto L_0x00c6
            r4 = 50
            r0.mFuncKeyId = r4
            goto L_0x012b
        L_0x00c6:
            java.lang.String r4 = "pref_slow_video_size_key"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x00d3
            r4 = 21
            r0.mFuncKeyId = r4
            goto L_0x0129
        L_0x00d3:
            java.lang.String r4 = "pref_switch_camera_key"
            boolean r5 = r4.equals(r3)
            if (r5 == 0) goto L_0x00e8
            r5 = 22
            r0.mFuncKeyId = r5
            java.lang.String r5 = "camera_main"
            java.lang.String r4 = r1.getString(r4, r5)
            r0.mItemValue = r4
            goto L_0x0129
        L_0x00e8:
            java.lang.String r4 = "pref_super_raw_control_key"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x00f5
            r4 = 33
            r0.mFuncKeyId = r4
            goto L_0x0129
        L_0x00f5:
            boolean r4 = r12.equals(r3)
            if (r4 == 0) goto L_0x0100
            r4 = 23
            r0.mFuncKeyId = r4
            goto L_0x012b
        L_0x0100:
            boolean r4 = r10.equals(r3)
            if (r4 == 0) goto L_0x010b
            r4 = 24
            r0.mFuncKeyId = r4
            goto L_0x012b
        L_0x010b:
            boolean r4 = r8.equals(r3)
            if (r4 == 0) goto L_0x011a
            r4 = 25
            r0.mFuncKeyId = r4
            java.lang.String r4 = "ultra_stablized"
            r0.mItem = r4
            goto L_0x012b
        L_0x011a:
            boolean r4 = r7.equals(r3)
            if (r4 == 0) goto L_0x0125
            r4 = 51
            r0.mFuncKeyId = r4
            goto L_0x012b
        L_0x0125:
            return
        L_0x0126:
            r4 = 3
            r0.mFuncKeyId = r4
        L_0x0129:
            r16 = r6
        L_0x012b:
            java.lang.String r4 = "funcValue_select"
            r0.mEventId = r4
            if (r16 == 0) goto L_0x0203
            boolean r4 = r15.equals(r3)
            if (r4 == 0) goto L_0x0143
            int r1 = r1.getInt(r15, r6)
            java.lang.String r1 = com.oppo.camera.ui.preview.a.g.a(r1, r2)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x0143:
            boolean r4 = r14.equals(r3)
            if (r4 == 0) goto L_0x0155
            int r1 = r1.getInt(r14, r6)
            java.lang.String r1 = com.oppo.camera.ui.preview.a.g.a((int) r1)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x0155:
            boolean r4 = r13.equals(r3)
            if (r4 == 0) goto L_0x0167
            int r1 = r1.getInt(r13, r6)
            java.lang.String r1 = com.oppo.camera.ui.preview.a.g.b(r1, r2)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x0167:
            boolean r4 = r12.equals(r3)
            r5 = 60
            if (r4 == 0) goto L_0x018b
            boolean r2 = r1.getBoolean(r12, r6)
            if (r2 != 0) goto L_0x017d
            java.lang.String r1 = java.lang.String.valueOf(r6)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x017d:
            java.lang.String r2 = "pref_video_blur_menu_index"
            int r1 = r1.getInt(r2, r5)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x018b:
            boolean r4 = r11.equals(r3)
            if (r4 == 0) goto L_0x019d
            int r1 = r1.getInt(r11, r5)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x019d:
            boolean r4 = r10.equals(r3)
            if (r4 == 0) goto L_0x01ae
            int r1 = r1.getInt(r10, r6)
            java.lang.String r1 = com.oppo.camera.ui.preview.a.g.c(r1, r2)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x01ae:
            boolean r4 = r9.equals(r3)
            if (r4 == 0) goto L_0x01bf
            int r1 = r1.getInt(r9, r6)
            java.lang.String r1 = com.oppo.camera.ui.preview.a.g.d(r1, r2)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x01bf:
            boolean r2 = r8.equals(r3)
            if (r2 == 0) goto L_0x01d5
            boolean r1 = r1.getBoolean(r8, r6)
            if (r1 == 0) goto L_0x01d0
            java.lang.String r1 = "ultra_on"
            r0.mItemValue = r1
            goto L_0x020b
        L_0x01d0:
            java.lang.String r1 = "ultra_off"
            r0.mItemValue = r1
            goto L_0x020b
        L_0x01d5:
            boolean r2 = r7.equals(r3)
            if (r2 == 0) goto L_0x01f7
            r2 = 51
            r0.mFuncKeyId = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r1 = r1.getInt(r7, r6)
            r2.append(r1)
            java.lang.String r1 = "fps"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.mItemValue = r1
            goto L_0x020b
        L_0x01f7:
            r2 = -1
            int r1 = r1.getInt(r3, r2)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.mItemValue = r1
            goto L_0x020b
        L_0x0203:
            java.lang.String r2 = ""
            java.lang.String r1 = r1.getString(r3, r2)
            r0.mItemValue = r1
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.statistics.model.MenuClickMsgData.buildMenuItem(java.lang.String, com.oppo.camera.k, int):void");
    }

    public void buildSettingJumpItem(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mFuncKeyId = 5;
            this.mEventId = EVENT_FUNCTION_MENU_CLICK;
            String c = b.c(str);
            char c2 = 65535;
            switch (c.hashCode()) {
                case -1760868457:
                    if (c.equals("pref_advance_setting_key")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -731027105:
                    if (c.equals("pref_build_image_setting_key")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -299354421:
                    if (c.equals("pref_camera_code_key")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 193590031:
                    if (c.equals("pref_shutter_help_key")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 249158521:
                    if (c.equals("pref_watermark_setting_key")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.mItem = KEY_SHUTTER_ASSIST;
            } else if (c2 == 1) {
                this.mItem = KEY_HIGH_GRADE;
            } else if (c2 == 2) {
                this.mItem = KEY_IS_SLOGAN;
            } else if (c2 == 3) {
                this.mItem = KEY_SHOOT_FORMAT;
            } else if (c2 != 4) {
                this.mItem = "";
            } else {
                this.mItem = KEY_BUILD_IMAGE;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00aa, code lost:
        if (r3.equals("pref_camera_line_photo") != false) goto L_0x0209;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildSettingMenuItem(java.lang.String r3, java.lang.Object r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 5
            r2.mFuncKeyId = r0
            java.lang.String r1 = "funcValue_select"
            r2.mEventId = r1
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r2.mItemValue = r4
            java.lang.String r3 = com.oppo.camera.entry.b.c(r3)
            r4 = -1
            int r1 = r3.hashCode()
            switch(r1) {
                case -2113768511: goto L_0x01fe;
                case -1990886238: goto L_0x01f3;
                case -1982388778: goto L_0x01e8;
                case -1921339331: goto L_0x01dd;
                case -1842410947: goto L_0x01d2;
                case -1789212585: goto L_0x01c8;
                case -1594132768: goto L_0x01be;
                case -1560573258: goto L_0x01b3;
                case -1462460857: goto L_0x01a8;
                case -1449790675: goto L_0x019c;
                case -1374931663: goto L_0x0190;
                case -1325782763: goto L_0x0185;
                case -1245077475: goto L_0x0179;
                case -1221935740: goto L_0x016d;
                case -1206234757: goto L_0x0161;
                case -1135915663: goto L_0x0155;
                case -1103096754: goto L_0x0149;
                case -962166798: goto L_0x013d;
                case -958952174: goto L_0x0131;
                case -702558194: goto L_0x0125;
                case -642405802: goto L_0x0119;
                case -622376663: goto L_0x010d;
                case -513186997: goto L_0x0101;
                case -216705769: goto L_0x00f5;
                case -185556839: goto L_0x00ea;
                case -57708678: goto L_0x00de;
                case 108861775: goto L_0x00d2;
                case 110329299: goto L_0x00c6;
                case 228067918: goto L_0x00ba;
                case 388209371: goto L_0x00ae;
                case 822316133: goto L_0x00a4;
                case 827876014: goto L_0x0099;
                case 860391471: goto L_0x008d;
                case 1047985792: goto L_0x0081;
                case 1071568589: goto L_0x0075;
                case 1378084131: goto L_0x0069;
                case 1549575095: goto L_0x005d;
                case 1648242782: goto L_0x0051;
                case 1766125842: goto L_0x0045;
                case 1892282044: goto L_0x0039;
                case 2069752292: goto L_0x002d;
                case 2118868211: goto L_0x0022;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0208
        L_0x0022:
            java.lang.String r0 = "pref_camera_tap_shutter_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 2
            goto L_0x0209
        L_0x002d:
            java.lang.String r0 = "pref_camera_recordlocation_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 9
            goto L_0x0209
        L_0x0039:
            java.lang.String r0 = "pref_camera_slogan_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 14
            goto L_0x0209
        L_0x0045:
            java.lang.String r0 = "pref_slogan_time_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 31
            goto L_0x0209
        L_0x0051:
            java.lang.String r0 = "pref_slogan_customize_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 33
            goto L_0x0209
        L_0x005d:
            java.lang.String r0 = "pref_sound_types_key_front"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 17
            goto L_0x0209
        L_0x0069:
            java.lang.String r0 = "pref_camera_quick_launch_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 36
            goto L_0x0209
        L_0x0075:
            java.lang.String r0 = "pref_photo_codec_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 20
            goto L_0x0209
        L_0x0081:
            java.lang.String r0 = "pref_camera_video_slogan_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 15
            goto L_0x0209
        L_0x008d:
            java.lang.String r0 = "pref_help_and_feedback_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 35
            goto L_0x0209
        L_0x0099:
            java.lang.String r0 = "pref_camera_line_video"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 6
            goto L_0x0209
        L_0x00a4:
            java.lang.String r1 = "pref_camera_line_photo"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0208
            goto L_0x0209
        L_0x00ae:
            java.lang.String r0 = "pref_slogan_device_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 27
            goto L_0x0209
        L_0x00ba:
            java.lang.String r0 = "pref_video_slogan_time_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 32
            goto L_0x0209
        L_0x00c6:
            java.lang.String r0 = "pref_lens_dirty_detection_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 40
            goto L_0x0209
        L_0x00d2:
            java.lang.String r0 = "pref_qr_code_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 41
            goto L_0x0209
        L_0x00de:
            java.lang.String r0 = "pref_slogan_location_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 29
            goto L_0x0209
        L_0x00ea:
            java.lang.String r0 = "pref_camera_gesture_shutter_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 3
            goto L_0x0209
        L_0x00f5:
            java.lang.String r0 = "pref_video_slogan_device_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 28
            goto L_0x0209
        L_0x0101:
            java.lang.String r0 = "pref_video_ratio_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 24
            goto L_0x0209
        L_0x010d:
            java.lang.String r0 = "pref_video_fps_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 21
            goto L_0x0209
        L_0x0119:
            java.lang.String r0 = "pref_sound_types_key_rear"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 16
            goto L_0x0209
        L_0x0125:
            java.lang.String r0 = "pref_share_and_edit_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 39
            goto L_0x0209
        L_0x0131:
            java.lang.String r0 = "pref_restore_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 22
            goto L_0x0209
        L_0x013d:
            java.lang.String r0 = "pref_face_rectify_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 13
            goto L_0x0209
        L_0x0149:
            java.lang.String r0 = "pref_slogan_owner_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 26
            goto L_0x0209
        L_0x0155:
            java.lang.String r0 = "pref_ai_scene_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 11
            goto L_0x0209
        L_0x0161:
            java.lang.String r0 = "pref_mirror_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 10
            goto L_0x0209
        L_0x016d:
            java.lang.String r0 = "pref_inertial_zoom_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 38
            goto L_0x0209
        L_0x0179:
            java.lang.String r0 = "pref_camera_storage_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 37
            goto L_0x0209
        L_0x0185:
            java.lang.String r0 = "pref_camera_timer_shutter_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 1
            goto L_0x0209
        L_0x0190:
            java.lang.String r0 = "pref_camera_sound_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 8
            goto L_0x0209
        L_0x019c:
            java.lang.String r0 = "pref_super_clear_portrait"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 12
            goto L_0x0209
        L_0x01a8:
            java.lang.String r0 = "pref_slow_video_size_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 23
            goto L_0x0209
        L_0x01b3:
            java.lang.String r0 = "pref_video_slogan_location_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 30
            goto L_0x0209
        L_0x01be:
            java.lang.String r0 = "pref_camera_photo_ratio_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 0
            goto L_0x0209
        L_0x01c8:
            java.lang.String r0 = "pref_assist_gradienter"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 7
            goto L_0x0209
        L_0x01d2:
            java.lang.String r0 = "pref_camera_countdown_effect_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 25
            goto L_0x0209
        L_0x01dd:
            java.lang.String r0 = "pref_video_noise_filter_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 18
            goto L_0x0209
        L_0x01e8:
            java.lang.String r0 = "pref_video_codec_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 19
            goto L_0x0209
        L_0x01f3:
            java.lang.String r0 = "pref_video_slogan_customize_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 34
            goto L_0x0209
        L_0x01fe:
            java.lang.String r0 = "pref_volume_key_function_key"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0208
            r0 = 4
            goto L_0x0209
        L_0x0208:
            r0 = r4
        L_0x0209:
            java.lang.String r3 = "author"
            switch(r0) {
                case 0: goto L_0x02ca;
                case 1: goto L_0x02c5;
                case 2: goto L_0x02c0;
                case 3: goto L_0x02bb;
                case 4: goto L_0x02b6;
                case 5: goto L_0x02b1;
                case 6: goto L_0x02ac;
                case 7: goto L_0x02a7;
                case 8: goto L_0x02a2;
                case 9: goto L_0x029d;
                case 10: goto L_0x0298;
                case 11: goto L_0x0293;
                case 12: goto L_0x028e;
                case 13: goto L_0x0289;
                case 14: goto L_0x0284;
                case 15: goto L_0x0284;
                case 16: goto L_0x027f;
                case 17: goto L_0x027f;
                case 18: goto L_0x027f;
                case 19: goto L_0x027a;
                case 20: goto L_0x0275;
                case 21: goto L_0x0270;
                case 22: goto L_0x026a;
                case 23: goto L_0x0264;
                case 24: goto L_0x025e;
                case 25: goto L_0x0258;
                case 26: goto L_0x0254;
                case 27: goto L_0x024e;
                case 28: goto L_0x024e;
                case 29: goto L_0x0248;
                case 30: goto L_0x0248;
                case 31: goto L_0x0242;
                case 32: goto L_0x0242;
                case 33: goto L_0x023e;
                case 34: goto L_0x023e;
                case 35: goto L_0x0238;
                case 36: goto L_0x0232;
                case 37: goto L_0x022c;
                case 38: goto L_0x0226;
                case 39: goto L_0x0220;
                case 40: goto L_0x021a;
                case 41: goto L_0x0214;
                default: goto L_0x020e;
            }
        L_0x020e:
            java.lang.String r3 = ""
            r2.mItem = r3
            goto L_0x02ce
        L_0x0214:
            java.lang.String r3 = "is_scan_code"
            r2.mItem = r3
            goto L_0x02ce
        L_0x021a:
            java.lang.String r3 = "lens_dirty_detection"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0220:
            java.lang.String r3 = "share_and_edit"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0226:
            java.lang.String r3 = "is_smooth_zoom"
            r2.mItem = r3
            goto L_0x02ce
        L_0x022c:
            java.lang.String r3 = "save_SDcard_first"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0232:
            java.lang.String r3 = "always_on_shot"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0238:
            java.lang.String r3 = "help_and_feedback"
            r2.mItem = r3
            goto L_0x02ce
        L_0x023e:
            r2.mItem = r3
            goto L_0x02ce
        L_0x0242:
            java.lang.String r3 = "is_time_slogan"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0248:
            java.lang.String r3 = "is_location_slogan"
            r2.mItem = r3
            goto L_0x02ce
        L_0x024e:
            java.lang.String r3 = "is_model_slogan"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0254:
            r2.mItem = r3
            goto L_0x02ce
        L_0x0258:
            java.lang.String r3 = "selfie_light"
            r2.mItem = r3
            goto L_0x02ce
        L_0x025e:
            java.lang.String r3 = "video_rec_mode"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0264:
            java.lang.String r3 = "slowVideo_rec_mode"
            r2.mItem = r3
            goto L_0x02ce
        L_0x026a:
            java.lang.String r3 = "restore_default"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0270:
            java.lang.String r3 = "video_fps"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0275:
            java.lang.String r3 = "photo_format"
            r2.mItem = r3
            goto L_0x02ce
        L_0x027a:
            java.lang.String r3 = "video_codec"
            r2.mItem = r3
            goto L_0x02ce
        L_0x027f:
            java.lang.String r3 = "video_recorder_sound"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0284:
            java.lang.String r3 = "is_slogan"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0289:
            java.lang.String r3 = "face_rectify"
            r2.mItem = r3
            goto L_0x02ce
        L_0x028e:
            java.lang.String r3 = "is_ai_clear_photo"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0293:
            java.lang.String r3 = "ai_scene"
            r2.mItem = r3
            goto L_0x02ce
        L_0x0298:
            java.lang.String r3 = "is_mirror"
            r2.mItem = r3
            goto L_0x02ce
        L_0x029d:
            java.lang.String r3 = "is_record_location"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02a2:
            java.lang.String r3 = "is_shutter_voice"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02a7:
            java.lang.String r3 = "spirit_level"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02ac:
            java.lang.String r3 = "video_assistant_line"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02b1:
            java.lang.String r3 = "is_assistant_line"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02b6:
            java.lang.String r3 = "volume_function"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02bb:
            java.lang.String r3 = "is_gesture_capture_type"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02c0:
            java.lang.String r3 = "is_tap_capture_type"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02c5:
            java.lang.String r3 = "delay_time"
            r2.mItem = r3
            goto L_0x02ce
        L_0x02ca:
            java.lang.String r3 = "pic_size_type"
            r2.mItem = r3
        L_0x02ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.statistics.model.MenuClickMsgData.buildSettingMenuItem(java.lang.String, java.lang.Object):void");
    }

    public void buildEvent(boolean z) {
        this.mEventId = z ? "funcValue_select" : "funcKey_click";
    }

    public boolean isValid() {
        if (this.mFuncKeyId > 0) {
            return super.isValid();
        }
        e.b(TAG, "isValid, " + toString());
        return false;
    }

    private String checkBeauty(String str) {
        int i = 0;
        String str2 = "";
        if (this.mCaptureType == 1) {
            int i2 = 0;
            while (true) {
                if (i2 < com.oppo.camera.ui.e.d.length) {
                    String str3 = com.oppo.camera.ui.e.d[i2];
                    if (str3 != null && str3.equals(str)) {
                        str2 = KEY_COMMON_CUSTOM_BEAUTY[i2];
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            while (i < com.oppo.camera.ui.e.f.length) {
                String str4 = com.oppo.camera.ui.e.f[i];
                if (str4 != null && str4.equals(str)) {
                    return KEY_COMMON_CUSTOM_BEAUTY[i];
                }
                i++;
            }
            return str2;
        } else if (this.mCaptureType != 0) {
            return str2;
        } else {
            int i3 = 0;
            while (true) {
                if (i3 < com.oppo.camera.ui.e.e_.length) {
                    String str5 = com.oppo.camera.ui.e.e_[i3];
                    if (str5 != null && str5.equals(str)) {
                        str2 = KEY_COMMON_CUSTOM_BEAUTY[i3];
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                int i4 = 0;
                while (true) {
                    if (i4 < com.oppo.camera.ui.e.f_.length) {
                        String str6 = com.oppo.camera.ui.e.f_[i4];
                        if (str6 != null && str6.equals(str)) {
                            str2 = KEY_COMMON_CUSTOM_BEAUTY[i4];
                            break;
                        }
                        i4++;
                    } else {
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                int i5 = 0;
                while (true) {
                    if (i5 < com.oppo.camera.ui.e.d_.length) {
                        String str7 = com.oppo.camera.ui.e.d_[i5];
                        if (str7 != null && str7.equals(str)) {
                            str2 = KEY_COMMON_CUSTOM_BEAUTY[i5];
                            break;
                        }
                        i5++;
                    } else {
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            while (i < com.oppo.camera.ui.e.e.length) {
                String str8 = com.oppo.camera.ui.e.e[i];
                if (str8 != null && str8.equals(str)) {
                    return KEY_COMMON_CUSTOM_BEAUTY[i];
                }
                i++;
            }
            return str2;
        }
    }
}
