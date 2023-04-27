package com.oppo.camera.statistics.model;

import android.content.Context;
import android.hardware.camera2.params.Face;
import android.text.TextUtils;

public class CaptureMsgData extends DcsMsgData {
    private static final String EVENT_CAPTURE = "portrait";
    private static final String KEY_AEC_SETTLE = "aecSettle";
    private static final String KEY_AE_AF_LOCK = "ae_af_lock";
    private static final String KEY_AIS_MOTION_TYPE = "aisMotionType";
    private static final String KEY_AI_SCENE = "ai_scene";
    private static final String KEY_BETWEEN_CLICK_BUTTON_COST_TIME = "between_click_btn_cost_time";
    private static final String KEY_BOKEH_CODE = "bokeh_code";
    private static final String KEY_BURST_COUNT = "burst_count";
    private static final String KEY_CCT = "cct_value";
    private static final String KEY_DELAYTIME = "delay_time";
    private static final String KEY_DRC_GAIN = "drcGain";
    private static final String KEY_EXP = "exp_value";
    private static final String KEY_FACE_CODE = "face_code";
    public static final String KEY_FACE_CODE_MORE_FACE = "more_face";
    public static final String KEY_FACE_CODE_NO_FACE = "no_face";
    private static final String KEY_FACE_COORDINATE = "face_coordinate";
    private static final String KEY_FACE_COUNT = "face_count";
    private static final String KEY_FACE_SIZE = "face_size";
    private static final String KEY_FILE_PATH = "file_path";
    private static final String KEY_FILTER_MENU_STATE = "filter_menu_state";
    private static final String KEY_FINAL_AWB_DECISION_BG = "finalAWBDecision_bg";
    private static final String KEY_FINAL_AWB_DECISION_RG = "finalAWBDecision_rg";
    private static final String KEY_FLASH_TYPE = "flash_type";
    private static final String KEY_FLICKER_DETECT_RESULT = "flickerDetectResult";
    private static final String KEY_FOCAL_LENGTH = "focal_length";
    private static final String KEY_FOCUS_DISTANCE = "focus_distance";
    private static final String KEY_FOCUS_METHOD_TYPE = "focusMethodType";
    private static final String KEY_FOCUS_REGION = "focusRegion";
    private static final String KEY_FOCUS_ROI_TYPE = "focusROIType";
    private static final String KEY_FOCUS_STATE = "focusState";
    private static final String KEY_FOCUS_TIME_COST = "focusTimeCost";
    private static final String KEY_GYRO_SQRT = "gyroSqrt";
    private static final String KEY_HDR_EV_LIST = "hdrEVList";
    private static final String KEY_HDR_MODE = "hdr_mode";
    private static final String KEY_HDR_SCOPE = "hdrScope";
    private static final String KEY_HDR_TRIGGER = "hdr_trigger";
    private static final String KEY_IMAGE_HEIGHT = "height";
    private static final String KEY_IMAGE_WIDTH = "width";
    private static final String KEY_ISO = "iso_value";
    private static final String KEY_IS_AIS_NEED = "isAisNeed";
    private static final String KEY_IS_AI_CLEAR_PHOTO = "is_ai_clear_photo";
    private static final String KEY_IS_AI_SCENE = "is_ai_scene";
    private static final String KEY_IS_ASSISTANT_LINE = "is_assistant_line";
    private static final String KEY_IS_FACE_RECTIFY = "is_face_rectify";
    private static final String KEY_IS_GESTURE_CAPTURE_TYPE = "is_gesture_capture_type";
    private static final String KEY_IS_LASER_DIRTY = "isLaserDirty";
    private static final String KEY_IS_LOCATION_SLOGAN = "is_location_slogan";
    private static final String KEY_IS_MODEL_SLOGAN = "is_model_slogan";
    private static final String KEY_IS_RECORD_LOCATION = "is_record_location";
    private static final String KEY_IS_SD_CARD = "is_sd";
    private static final String KEY_IS_SELFIE_LIGHT = "is_selfie_light";
    private static final String KEY_IS_SHUTTER_VOICE = "is_shutter_voice";
    private static final String KEY_IS_SLOGAN = "is_slogan";
    private static final String KEY_IS_TAP_CAPTURE_TYPE = "is_tap_capture_type";
    private static final String KEY_IS_TIME_SLOGAN = "is_time_slogan";
    private static final String KEY_IS_WIDE_ANGLE = "is_wide_angle";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_LOST_FRAME_NUM = "lostFrameNum";
    private static final String KEY_LUX = "lux_value";
    private static final String KEY_MACRO_MODE = "is_macro";
    private static final String KEY_MEMORY_VALUE = "memory_value";
    private static final String KEY_MULTI_FRAME_NUM = "multiFrameNum";
    private static final String KEY_NEW_STYLE_MENU_STATE = "portrait_new_style_menu_state";
    private static final String KEY_NIGHT_STATE = "night_state";
    private static final String KEY_PANORAMA_DIRECTION = "panorama_direction";
    private static final String KEY_PHOTO_FORMAT = "photo_format";
    private static final String KEY_PICSIZETYPE = "pic_size_type";
    private static final String KEY_PICTURE_FPS = "picture_fps";
    private static final String KEY_PI_EFFECT = "pi_effect";
    private static final String KEY_PREVIEW_CAPTURE_COST_TIME = "preview_capture_cost_time";
    private static final String KEY_PROFESSION_CAMERA_ID = "profession_camera_id";
    private static final String KEY_PROFESSION_EXPOSURE_COMPENSATION = "profession_ev_value";
    private static final String KEY_PROFESSION_EXPOSURE_TIME = "profession_exp_time";
    private static final String KEY_PROFESSION_FOCUS_VALUE = "profession_focus_value";
    private static final String KEY_PROFESSION_HIGH_RESOLUTION = "profession_high_resolution";
    private static final String KEY_PROFESSION_ISO_VALUE = "profession_ISO_value";
    private static final String KEY_PROFESSION_RAW_CONTROL = "raw_format";
    private static final String KEY_PROFESSION_WHITE_BALANCE = "profession_wb_value";
    private static final String KEY_PROTOCOL_VERSION = "protocol_version";
    private static final String KEY_SELFIE_LIGHT_TRIGGER = "selfie_light_trigger";
    private static final String KEY_SENSOR_CCT = "sensorCCT";
    private static final String KEY_SGW_BG_RATIO = "sgwBGRatio";
    private static final String KEY_SGW_RG_RATIO = "sgwRGRatio";
    private static final String KEY_SHARPNESS_STD = "sharpnessStd";
    private static final String KEY_SHUTTER_TYPE = "capture_type";
    private static final String KEY_SLOGAN_TYPE = "slogan_type";
    private static final String KEY_SPIRIT_LEVEL = "spirit_level";
    private static final String KEY_STICKER_NAME = "sticker_name";
    private static final String KEY_STICKER_TYPE = "sticker_type";
    private static final String KEY_STICKER_UUID = "sticker_uuid";
    private static final String KEY_TEXT_SIZE = "text_size";
    private static final String KEY_TIMER_COORDINATE = "timer_coordinate";
    private static final String KEY_TIMER_SIZE = "timer_size";
    private static final String KEY_TOUCH_EXPOSURE_COMPENSATION = "touch_ev";
    private static final String KEY_TOUCH_XY = "touchxy_value";
    private static final String KEY_TO_CAPTURE_MODE = "to_capture_mode";
    private static final String KEY_TRIPOD_MODE = "tripod_mode";
    private static final String KEY_VOLUME_FUNCTION = "volume_function";
    public static final String PROCESS_DURATION = "process_duration";
    private static final String TAG = "CaptureMsgData";
    public String mAeAfLock = "";
    public String mAecSettle = "";
    public int mAiScene = 0;
    public String mAisMotionType = "";
    public long mBetweenClickBtnCostTime = 0;
    public int mBokehCode = -1;
    public int mBurstCount = -1;
    public String mCCT = "";
    public String mDelayTime = "";
    public String mDrcGain = "";
    public long mEXP = 0;
    public String mFaceCode = "";
    public String mFaceCoordinate = "";
    public int mFaceCount = 0;
    public String mFaceSize = "";
    public String mFilePath = "";
    public String mFinalAWBDecision_bg = "";
    public String mFinalAWBDecision_rg = "";
    public String mFlashType = "";
    public String mFlickerDetectResult = "";
    public String mFocalLength = "";
    public String mFocusDistance = "";
    public String mFocusMethodType = "";
    public String mFocusROIType = "";
    public String mFocusRegion = "";
    public String mFocusState = "";
    public String mFocusTimeCost = "";
    public String mGyroSqrt = "";
    public String mHdrEVList = "";
    public String mHdrMode = "";
    public String mHdrScope = "";
    public String mHeight = "";
    public int mISO = 0;
    public String mIsAiScene = "";
    public String mIsAisNeed = "";
    public String mIsAssistantLine = "";
    public String mIsFaceRectify = "";
    public String mIsGestureCaptureType = "";
    public String mIsLaserDirty = "";
    public String mIsLocationSlogan = "";
    public String mIsMacro = "";
    public String mIsModelSlogan = "";
    public String mIsPi = "";
    public String mIsRecordLocation = "";
    public String mIsSDCard = "";
    public String mIsShutterVoice = "";
    public String mIsSlogan = "";
    public String mIsTapCaptureType = "";
    public String mIsTimeSlogan = "";
    public String mIsTripodMode = "";
    public String mIsWideAngle = "";
    public String mLocation = "";
    public String mLostFrameNum = "";
    public String mLux = "";
    public String mMemoryValue = "";
    public String mMultiFrameNum = "";
    public int mNightState = -1;
    public int mPanoramaDirection = 0;
    public String mPhotoFormat = "";
    public String mPicSizeType = "";
    public String mPictureFps = "";
    public long mPreviewCaptureCostTime = -1;
    public String mProcessDuration = "";
    public String mProfessionCameraId = "";
    public String mProfessionEvValue = "";
    public String mProfessionExpValue = "";
    public String mProfessionFocusValue = "";
    public String mProfessionHighResolution = "";
    public String mProfessionISOValue = "";
    public String mProfessionRawControl = "";
    public String mProfessionWbValue = "";
    public String mProtocolVersion = "";
    public String mSCPEnable = "";
    public String mSelfieLight = "";
    public String mSelfieLightTrigger = "";
    public String mSensorCCT = "";
    public String mSgwBGRatio = "";
    public String mSgwRGRatio = "";
    public String mSharpnessStd = "";
    public String mShutterType = "";
    public int mSloganType = 0;
    public String mSpiritLevel = "";
    public String mStickerName = "";
    public String mStickerType = "";
    public String mStickerUuid = "";
    public String mTextSize = "";
    public String mTimerCoordinate = "";
    public String mTimerSize = "";
    public String mToCaptureMode = "";
    public int mTouchEVValue = 0;
    public String mTouchXYValue = "";
    public String mVolumeFunction = "";
    public String mWidth = "";
    public String mbHdrTrigger = "";

    public CaptureMsgData(Context context) {
        super(context, "200", "portrait", false);
    }

    public void report() {
        prepareLogTagByCaptureType();
        checkEmptyCondition("ae_af_lock", String.valueOf(this.mAeAfLock));
        checkNoAnyCondition("ai_scene", String.valueOf(this.mAiScene));
        checkEmptyCondition(KEY_IS_AI_CLEAR_PHOTO, this.mSCPEnable);
        checkGreatCondition("between_click_btn_cost_time", this.mBetweenClickBtnCostTime, 0);
        checkGreatCondition("bokeh_code", this.mBokehCode, -1);
        checkGreatCondition("burst_count", this.mBurstCount, 0);
        checkEmptyCondition(KEY_CCT, this.mCCT);
        checkEmptyCondition("delay_time", this.mDelayTime);
        checkNoAnyCondition(KEY_EXP, String.valueOf(this.mEXP));
        checkEmptyCondition("face_coordinate", this.mFaceCoordinate);
        checkNoAnyCondition("face_count", String.valueOf(this.mFaceCount));
        checkEmptyCondition(KEY_FACE_CODE, this.mFaceCode);
        checkEmptyCondition("face_size", this.mFaceSize);
        checkEmptyCondition(KEY_FILE_PATH, this.mFilePath);
        checkNoAnyCondition("focal_length", String.valueOf(this.mFocalLength));
        checkEmptyCondition("focus_distance", this.mFocusDistance);
        checkEmptyCondition(KEY_HDR_MODE, this.mHdrMode);
        checkEmptyCondition(KEY_HDR_TRIGGER, this.mbHdrTrigger);
        checkEmptyCondition("height", this.mHeight);
        checkEmptyCondition("width", this.mWidth);
        checkNoAnyCondition(KEY_ISO, String.valueOf(this.mISO));
        checkEmptyCondition(KEY_IS_AI_SCENE, this.mIsAiScene);
        checkEmptyCondition(KEY_PHOTO_FORMAT, this.mPhotoFormat);
        checkEmptyCondition(KEY_IS_FACE_RECTIFY, this.mIsFaceRectify);
        checkEmptyCondition(KEY_IS_ASSISTANT_LINE, this.mIsAssistantLine);
        checkEmptyCondition(KEY_IS_GESTURE_CAPTURE_TYPE, this.mIsGestureCaptureType);
        checkEmptyCondition(KEY_IS_LOCATION_SLOGAN, this.mIsLocationSlogan);
        checkEmptyCondition(KEY_IS_MODEL_SLOGAN, this.mIsModelSlogan);
        checkEmptyCondition(KEY_IS_RECORD_LOCATION, this.mIsRecordLocation);
        checkEmptyCondition(KEY_IS_SD_CARD, this.mIsSDCard);
        checkEmptyCondition(KEY_IS_SHUTTER_VOICE, this.mIsShutterVoice);
        checkEmptyCondition(KEY_IS_SLOGAN, this.mIsSlogan);
        checkEmptyCondition(KEY_IS_TAP_CAPTURE_TYPE, this.mIsTapCaptureType);
        checkEmptyCondition(KEY_IS_TIME_SLOGAN, this.mIsTimeSlogan);
        checkEmptyCondition("location", this.mLocation);
        checkNoAnyCondition(KEY_LUX, String.valueOf(this.mLux));
        checkEmptyCondition(KEY_MEMORY_VALUE, this.mMemoryValue);
        checkGreatCondition("night_state", this.mNightState, -1);
        checkEmptyCondition(KEY_TRIPOD_MODE, this.mIsTripodMode);
        checkEmptyCondition(KEY_PI_EFFECT, this.mIsPi);
        checkEmptyCondition(KEY_PICSIZETYPE, this.mPicSizeType);
        checkGreatCondition("preview_capture_cost_time", this.mPreviewCaptureCostTime, 0);
        checkGreatCondition("panorama_direction", this.mPanoramaDirection, 0);
        checkEmptyCondition(KEY_PICTURE_FPS, this.mPictureFps);
        checkEmptyCondition(PROCESS_DURATION, this.mProcessDuration);
        checkEmptyCondition(KEY_PROFESSION_CAMERA_ID, this.mProfessionCameraId);
        checkEmptyCondition("profession_ev_value", this.mProfessionEvValue);
        checkEmptyCondition("profession_exp_time", this.mProfessionExpValue);
        checkEmptyCondition("profession_focus_value", this.mProfessionFocusValue);
        checkEmptyCondition("profession_high_resolution", this.mProfessionHighResolution);
        checkEmptyCondition("profession_ISO_value", this.mProfessionISOValue);
        checkEmptyCondition("profession_wb_value", this.mProfessionWbValue);
        checkEmptyCondition(KEY_PROFESSION_RAW_CONTROL, this.mProfessionRawControl);
        checkEmptyCondition("capture_type", this.mShutterType);
        checkEmptyCondition(KEY_IS_SELFIE_LIGHT, this.mSelfieLight);
        checkEmptyCondition("selfie_light_trigger", this.mSelfieLightTrigger);
        checkGreatCondition("slogan_type", this.mSloganType, -1);
        checkEmptyCondition(KEY_TEXT_SIZE, this.mTextSize);
        checkEmptyCondition(KEY_MACRO_MODE, this.mIsMacro);
        if (this.mSmooth == 102) {
            checkGreatCondition(DcsMsgData.KEY_SMOOTH_DERMABRASION, this.mSmoothDermabrasion, -1);
            checkGreatCondition(DcsMsgData.KEY_SMOOTH_FACE_LEAN, this.mSmoothFaceLean, -1);
            checkGreatCondition(DcsMsgData.KEY_SMOOTH_EYE_BIG, this.mSmoothEyeBig, -1);
            checkGreatCondition(DcsMsgData.KEY_SMOOTH_NOSE_LEAN, this.mSmoothNoseLean, -1);
            checkGreatCondition(DcsMsgData.KEY_SMOOTH_FACE_JAW, this.mSmoothFaceJaw, -51);
            checkGreatCondition(DcsMsgData.KEY_SMOOTH_FACE_SMALL, this.mSmoothFaceSmall, -1);
            checkGreatCondition(DcsMsgData.KEY_SMOOTH_FRESHEN_UP, this.mSmoothFreshenUp, -1);
            checkGreatCondition(DcsMsgData.KEY_SMOOTH_CUBE, this.mSmoothCube, -1);
        }
        checkEmptyCondition(KEY_TIMER_SIZE, this.mTimerSize);
        checkEmptyCondition(KEY_TIMER_COORDINATE, this.mTimerCoordinate);
        checkNoAnyCondition("touch_ev", String.valueOf(this.mTouchEVValue));
        checkEmptyCondition(KEY_TOUCH_XY, this.mTouchXYValue);
        checkEmptyCondition("volume_function", this.mVolumeFunction);
        checkEmptyCondition(KEY_IS_WIDE_ANGLE, this.mIsWideAngle);
        checkEmptyCondition("sticker_name", this.mStickerName);
        checkEmptyCondition("sticker_type", this.mStickerType);
        checkEmptyCondition("sticker_uuid", this.mStickerUuid);
        checkEmptyCondition(KEY_PROTOCOL_VERSION, this.mProtocolVersion);
        checkEmptyCondition(KEY_SPIRIT_LEVEL, this.mSpiritLevel);
        checkEmptyCondition(KEY_FLASH_TYPE, this.mFlashType);
        checkEmptyCondition(KEY_TO_CAPTURE_MODE, this.mToCaptureMode);
        if (!TextUtils.isEmpty(this.mIsLaserDirty)) {
            checkEmptyCondition(KEY_SGW_BG_RATIO, this.mSgwBGRatio);
            checkEmptyCondition(KEY_SGW_RG_RATIO, this.mSgwRGRatio);
            checkEmptyCondition(KEY_FINAL_AWB_DECISION_RG, this.mFinalAWBDecision_rg);
            checkEmptyCondition(KEY_FINAL_AWB_DECISION_BG, this.mFinalAWBDecision_bg);
            checkEmptyCondition(KEY_DRC_GAIN, this.mDrcGain);
            checkEmptyCondition(KEY_IS_AIS_NEED, this.mIsAisNeed);
            checkEmptyCondition(KEY_AIS_MOTION_TYPE, this.mAisMotionType);
            checkEmptyCondition(KEY_FOCUS_ROI_TYPE, this.mFocusROIType);
            checkEmptyCondition(KEY_FOCUS_METHOD_TYPE, this.mFocusMethodType);
            checkEmptyCondition(KEY_GYRO_SQRT, this.mGyroSqrt);
            checkEmptyCondition(KEY_FOCUS_REGION, this.mFocusRegion);
            checkEmptyCondition(KEY_FOCUS_STATE, this.mFocusState);
            checkEmptyCondition(KEY_AEC_SETTLE, this.mAecSettle);
            checkEmptyCondition(KEY_FOCUS_TIME_COST, this.mFocusTimeCost);
            checkEmptyCondition(KEY_SHARPNESS_STD, this.mSharpnessStd);
            checkEmptyCondition(KEY_SENSOR_CCT, this.mSensorCCT);
            checkEmptyCondition(KEY_FLICKER_DETECT_RESULT, this.mFlickerDetectResult);
            checkEmptyCondition(KEY_IS_LASER_DIRTY, this.mIsLaserDirty);
            checkEmptyCondition(KEY_MULTI_FRAME_NUM, this.mMultiFrameNum);
            checkEmptyCondition(KEY_LOST_FRAME_NUM, this.mLostFrameNum);
            checkEmptyCondition(KEY_HDR_SCOPE, this.mHdrScope);
            checkEmptyCondition(KEY_HDR_EV_LIST, this.mHdrEVList);
        }
        super.report();
    }

    public void parseFaceInfo(Face[] faceArr) {
        if (faceArr != null) {
            this.mFaceCount = faceArr.length;
            StringBuilder sb = new StringBuilder();
            for (Face face : faceArr) {
                sb.append(face.getBounds().width());
                sb.append("x");
                sb.append(face.getBounds().height());
                sb.append(",");
            }
            this.mFaceSize = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            for (Face face2 : faceArr) {
                sb2.append(face2.getBounds().left);
                sb2.append(",");
                sb2.append(face2.getBounds().top);
                sb2.append(",");
                sb2.append(face2.getBounds().right);
                sb2.append(",");
                sb2.append(face2.getBounds().bottom);
                sb2.append("x");
            }
            String sb3 = sb2.toString();
            if (sb3.endsWith(",")) {
                sb3 = sb3.substring(0, sb3.length() - 1);
            }
            this.mFaceCoordinate = sb3;
        }
    }
}
