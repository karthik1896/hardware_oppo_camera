package com.oppo.camera.statistics;

import android.content.Context;
import com.coloros.statistics.dcs.a;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CameraStatisticsUtil extends a {
    public static final String AES_TOKEN = "token";
    public static final String AE_AF_LOCK = "ae_af_lock";
    public static final String AF_STATUS = "afStatus";
    public static final String AI_CLASS_ONE = "ai_class_one";
    public static final String AI_EXP_TIME = "ai_exp_time";
    public static final String AI_ISO = "ai_iso";
    public static final String AI_SCENE = "ai_scene";
    public static final String AI_SCENE_OPEN = "ai_scene_open";
    public static final String AVAILABLE_STORAGE = "available_storage";
    public static final String BEAUTY3D_CHEEKBONE = "beauty3d_cheekbone_value";
    public static final String BEAUTY3D_CHIN = "beauty3d_chin_value";
    public static final String BEAUTY3D_CHOSE_STYLE = "beauty3d_chose_style";
    public static final String BEAUTY3D_DELETE_CLICK = "beauty3d_delete_click";
    public static final String BEAUTY3D_EYE = "beauty3d_eye_value";
    public static final String BEAUTY3D_FIX_FACE = "beauty3d_fix_face_value";
    public static final String BEAUTY3D_GOOSE = "beauty3d_style_goose";
    public static final String BEAUTY3D_HIGH_NOSE = "beauty3d_high_nose_value";
    public static final String BEAUTY3D_LOLITA = "beauty3d_style_lolita";
    public static final String BEAUTY3D_MODE = "beauty3d_style_mode";
    public static final String BEAUTY3D_NATURAL = "beauty3d_style_natural";
    public static final String BEAUTY3D_SAVE_CLICK = "beauty3d_save_click";
    public static final String BEAUTY3D_SCAN_CLICK = "beauty3d_scan_click";
    public static final String BEAUTY3D_SCAN_TIME = "beauty3d_scan_time";
    public static final String BEAUTY3D_SMALL_FACE = "beauty3d_small_face_value";
    public static final String BEAUTY3D_SMALL_NOSE = "beauty3d_small_nose_value";
    public static final String BEAUTY3D_START_EDIT_CLICK = "beauty3d_start_edit_click";
    public static final String BEAUTY_FACE_COUNT = "beauty_face_count";
    public static final String BETWEEN_CLICK_BUTTON_COST_TIME = "between_click_btn_cost_time";
    public static final String CALLER_PACKAGE = "caller_package";
    public static final String CAMERA_ENTER_TIME_GAP = "camera_enter_time_gap";
    public static final String CAMERA_ID = "camera_id";
    public static final String[] CUSTOM_BEAUTY_CLICK_NUMS = {"beauty_custom_exfoliating_click", "beauty_custom_thin_face_click", "beauty_custom_big_eye_click", "beauty_custom_thin_nasal_click", "beauty_custom_chin_click", "beauty_custom_little_face_click", "beauty_custom_makeup_click", "beauty_custom_3d_click"};
    public static final String ENCODE_TYPE = "enc";
    public static final String ENTRY_TYPE = "entry_type";
    public static final String EVENT_BEAUTY3D = "beauty3d";
    public static final String EVENT_CAPTURE = "portrait";
    public static final String EVENT_ENTER = "enter";
    public static final String EVENT_ENTER_STICKER = "enterSticker";
    public static final String EVENT_EXIT = "exit";
    public static final String EVENT_MENU_CLICK = "menuClick";
    public static final String EVENT_RUS = "RUS";
    public static final String EVENT_STICKER_DOWNLOAD = "sticker_download";
    public static final String EVENT_VIDEO = "videoRecord";
    public static final String EXIT_TO_GALLERY = "to_gallery";
    public static final String FACE_BEAUTY_COMMON_SHOW = "face_beauty_common_show";
    public static final String FACE_BEAUTY_LEVEL = "smooth";
    public static final String FACE_BEAUTY_RESET_CANCEL = "face_beauty_rest_cancel";
    public static final String FACE_BEAUTY_RESET_OK = "face_beauty_rest_ok";
    public static final String FACE_BEAUTY_RESET_SHOW = "face_beauty_rest_show";
    public static final String FILTER_APP_LIST = "filterapplist";
    public static final String FILTER_MENU_STATE = "filter_menu_state";
    public static final String FILTER_TYPE = "filter_type";
    public static final String FLASH = "menu_flash";
    public static final String FLASH_STATUS = "flashMode";
    public static final String FOCAL_LENGTH = "focal_length";
    public static final String FOCUS_DISTANCE = "focus_distance";
    public static final String FUNC_KEY_SETTING = "5";
    public static final String GRADIENTER_STATUS = "gradienter_status";
    public static final String HDR = "menu_hdr";
    public static final String HIGH_RESOLUTION = "high_resolution";
    public static final String IMAGE_HEIGHT = "height";
    public static final String IMAGE_WIDTH = "width";
    public static final String INTELLIGENT_BEAUTY = "intelligent_beauty";
    public static final String KEY_FUNC_KEY_ID = "funcKey_id";
    public static final String KEY_FUNC_KEY_ITEM = "funcKey_item";
    public static final String KEY_FUNC_KEY_VALUE = "funcKey_value";
    private static final String LOGTAG_ENTER = "201";
    private static final String LOGTAG_PORTRAIT = "200";
    private static final String LOGTAG_PREVIEW = "203";
    private static final String LOGTAG_VIDEO = "202";
    public static final String LUX = "lux";
    public static final String MODE_PANEL_STATE = "mode_panel_state";
    public static final String NIGHT_CLOSED_NUM = "close_night_num";
    public static final String NIGHT_STATE = "night_state";
    public static final String OMOJI_HUMAN_CLOTHING = "human_clothing";
    public static final String OMOJI_HUMAN_DELETE = "human_delete";
    public static final String OMOJI_HUMAN_ENTER = "human_enter";
    public static final String OMOJI_HUMAN_FACE_STYLE = "human_face_style";
    public static final String OMOJI_HUMAN_GENDER = "human_gender";
    public static final String OMOJI_HUMAN_GENERATE_GIF = "human_generate_gif";
    public static final String OMOJI_HUMAN_GLASSES = "human_glasses";
    public static final String OMOJI_HUMAN_HAIR_COLOR = "human_hair_color";
    public static final String OMOJI_HUMAN_HAIR_STYLE = "human_hair_style";
    public static final String OMOJI_HUMAN_SAVE_GIF = "human_save_gif";
    public static final String OMOJI_HUMAN_SKIN_COLOR = "human_skin_color";
    public static final String PANORAMA_DIRECTION = "panorama_direction";
    public static final String PI_FLAG = "pi_flag";
    public static final String PORTRAIT_ASSISTANT_LINE = "assistant_line";
    public static final String PORTRAIT_BLUR = "blur";
    public static final String PORTRAIT_BOKEH_CODE = "bokeh_code";
    public static final String PORTRAIT_BURST_COUNT = "burst_count";
    public static final String PORTRAIT_CAPTURE_MODE = "capture_mode";
    public static final String PORTRAIT_CAPTURE_TYPE = "capture_type";
    public static final String PORTRAIT_CCT = "cct";
    public static final String PORTRAIT_DELAYTIME = "delay_time";
    public static final String PORTRAIT_EXP = "exp";
    public static final String PORTRAIT_EXPOSURE_COMPENSATION = "ev";
    public static final String PORTRAIT_FACE_COORDINATE = "face_coordinate";
    public static final String PORTRAIT_FACE_COUNT = "face_count";
    public static final String PORTRAIT_FACE_SIZE = "face_size";
    public static final String PORTRAIT_FOCUS = "focus";
    public static final String PORTRAIT_HALF_BODY = "half_body";
    public static final String PORTRAIT_HDR_STATUS = "hdr";
    public static final String PORTRAIT_ISO = "iso";
    public static final String PORTRAIT_IS_SELF_LIGHT = "is_self_light";
    public static final String PORTRAIT_LOCATION = "location";
    public static final String PORTRAIT_MIRROR = "mirror";
    public static final String PORTRAIT_MOVIE_MODE = "movie_mode";
    public static final String PORTRAIT_NEW_STYLE_MENU_STATE = "portrait_new_style_menu_state";
    public static final String PORTRAIT_NEW_STYLE_TYPE = "portrait_new_style_type";
    public static final String PORTRAIT_ORIENTATION = "orientation";
    public static final String PORTRAIT_PICSIZETYPE = "picSize_type";
    public static final String PORTRAIT_PROFESSION_EXPOSURE_TIME = "profession_exposure_time";
    public static final String PORTRAIT_PROFESSION_ISO = "profession_ISO";
    public static final String PORTRAIT_RECORD_LOCATION = "record_location";
    public static final String PORTRAIT_SD_CARD = "sd";
    public static final String PORTRAIT_SELFIE_LIGHT_TRIGGER = "selfie_light_trigger";
    public static final String PORTRAIT_TOUCH_EXPOSURE_COMPENSATION = "touch_ev";
    public static final String PORTRAIT_TOUCH_XY = "touch_x_y";
    public static final String PORTRAIT_VOLUME_FUNCTION = "volume_function";
    public static final String PORTRAIT_WHITE_BALANCE = "wb";
    public static final String PORTRAIT_ZOOM = "zoom";
    public static final String PREVIEW_CAPTURE_COST_TIME = "preview_capture_cost_time";
    public static final String RESUME_PAUSE_DURATION_TIME = "resume_pause_time";
    public static final String RESUME_PAUSE_VIDEO_TIME = "resume_pause_video_time";
    public static final String RUS_FILE_NAME = "fileName";
    public static final String RUS_FILE_VERSION = "version";
    public static final String SCREEN_BRIGHTNESS = "screen_brightness";
    public static final String SECONDARY_CAMERA_SCENE_MODE = "secondary_cameraScene";
    public static final String SELFIE_LIGHT = "selfie_light";
    public static final String SHORTCUT_ITEM = "shortcut_item";
    public static final String SHORTCUT_TYPE = "shortcut_type";
    public static final String SLOGAN = "slogan";
    public static final String SLOGAN_EXIST = "slogan_exist";
    public static final String SLOGAN_TYPE = "slogan_type";
    public static final String SOUND = "sound";
    public static final String STICKER_DOWNLOAD_COST_TIME = "sticker_download_cost_time";
    public static final String STICKER_DOWNLOAD_RESULT = "sticker_download_result";
    public static final String STICKER_MENU_CATERGORY_CLICK = "sticker_menu_catergory_click";
    public static final String STICKER_MENU_CATERGORY_FLING = "sticker_menu_catergory_fling";
    public static final String STICKER_MENU_ITEM_SELECTED = "sticker_menu_item_selected";
    public static final String STICKER_MENU_ITEM_UNSELECTED = "sticker_menu_item_unselected";
    public static final String STICKER_MENU_ITEM_USETIME = "sticker_menu_item_usetime";
    public static final String STICKER_MODE_CLICK_FILTER_INDEX = "sticker_mode_click_filter_index";
    public static final String STICKER_MODE_CLICK_FILTER_MENU = "sticker_mode_click_filter_menu";
    public static final String STICKER_MODE_CLICK_SMOOTH_LEVEL = "sticker_mode_click_smooth_level";
    public static final String STICKER_MODE_CLICK_SMOOTH_MENU = "sticker_mode_click_smooth_menu";
    public static final String STICKER_MODE_CLICK_STICKER_MENU = "sticker_mode_click_sticker_menu";
    public static final String STICKER_MODE_SWITCH_CAMERA = "sticker_mode_switch_camera";
    public static final String STICKER_MODE_USE_TIME = "sticker_mode_use_time";
    public static final String STICKER_NAME = "sticker_name";
    public static final String STICKER_NETWORK = "sticker_network";
    public static final String STICKER_RECYCLEBIN_CLICK = "sticker_recyclebin_click";
    public static final String STICKER_RECYCLEBIN_DELETEALL = "sticker_recyclebin_deleteall";
    public static final String STICKER_RECYCLEBIN_ITEM_DELETE = "sticker_recyclebin_item_delete";
    public static final String STICKER_TYPE = "sticker_type";
    public static final String STICKER_UUID = "sticker_uuid";
    public static final String SUPER_NIGHT_FLAG = "night_flag";
    private static String TAG = "CameraStatisticsUtil";
    public static final String ULTRA_WIDE_STATE = "ultra_wide_state";
    public static final String USER_DATA = "ud";
    public static final String VIDEO_ASD_TIMESTAMPS = "video_time_stamps";
    public static final String VIDEO_CODEC = "video_codec";
    public static final String VIDEO_FACE_BEAUTY = "video_face_beauty";
    public static final String VIDEO_FPS = "video_fps";
    public static final String VIDEO_MODE = "video_mode";
    public static final String VIDEO_NOISE_FILTER = "video_noise_filter";
    public static final String VIDEO_ORIENTATION = "video_orientation";
    public static final String VIDEO_RECORDER_SOUND = "video_recorder_sound";
    public static final String VIDEO_REC_MODE = "video_rec_mode";
    public static final String VIDEO_TIME = "video_time";
    public static final String VIVID_EFFECT = "vivid_effect";

    public static class Face {
        public String D;
        public String E;
        public String F;
        public String G;
    }

    public static class FaceCoordinate {
        public String L1;
        public String L2;
        public String L3;
        public String L4;
    }

    public static class FaceSize {
        public String N1;
        public String N2;
    }

    public static class MakerNote {
        public String A;
        public String B;
        public ArrayList<Face> C;
        public String H;
        public String I;
        public String J;
        public String K;
        public ArrayList<FaceCoordinate> L;
        public String M;
        public ArrayList<FaceSize> N;
        public String O;
        public String P;
        public String PiFlag;
        public String Q;
        public String R;
        public String S;
        public TouchCenter T;
        public String U;
        public String V;
        public String W;
        public ArrayList<String> asdOut;
        public String expTime;
        public String iso;
        public String nightFlag;
    }

    public static class TouchCenter {
        public String T1;
        public String T2;
    }

    public static void onDebug(boolean z) {
        a.onDebug(z);
    }

    public static void setSessionTimeOut(Context context, int i) {
        a.setSessionTimeOut(context, i);
    }

    public static String format(String str, String str2) {
        return str + ":" + str2 + " ";
    }

    public static void onCommon(Context context, String str, String str2, boolean z) {
        String str3;
        if (Util.M()) {
            e.b(TAG, "onCommon, monkey is running do not report");
            return;
        }
        HashMap<String, String> putEventMap = putEventMap(str2, new HashMap());
        char c = 65535;
        switch (str.hashCode()) {
            case -1552858263:
                if (str.equals(EVENT_MENU_CLICK)) {
                    c = 6;
                    break;
                }
                break;
            case 81520:
                if (str.equals(EVENT_RUS)) {
                    c = 2;
                    break;
                }
                break;
            case 3127582:
                if (str.equals("exit")) {
                    c = 1;
                    break;
                }
                break;
            case 88409418:
                if (str.equals("sticker_download")) {
                    c = 5;
                    break;
                }
                break;
            case 96667352:
                if (str.equals("enter")) {
                    c = 0;
                    break;
                }
                break;
            case 729267099:
                if (str.equals("portrait")) {
                    c = 4;
                    break;
                }
                break;
            case 1000006828:
                if (str.equals("videoRecord")) {
                    c = 3;
                    break;
                }
                break;
            case 1328932877:
                if (str.equals(EVENT_BEAUTY3D)) {
                    c = 7;
                    break;
                }
                break;
            case 1752545093:
                if (str.equals(EVENT_ENTER_STICKER)) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                str3 = LOGTAG_ENTER;
                break;
            case 3:
                str3 = LOGTAG_VIDEO;
                break;
            case 4:
                str3 = LOGTAG_PORTRAIT;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                str3 = LOGTAG_PREVIEW;
                break;
            default:
                str3 = "";
                break;
        }
        a.onCommon(context, str3, str, (Map<String, String>) putEventMap, z);
    }

    private static HashMap<String, String> putEventMap(String str, HashMap<String, String> hashMap) {
        if (str != null) {
            String[] split = str.split("\\s+");
            for (String split2 : split) {
                String[] split3 = split2.split(":");
                if (split3.length == 2 && !"".equals(split3[1])) {
                    hashMap.put(split3[0], split3[1]);
                }
            }
        }
        return hashMap;
    }
}
