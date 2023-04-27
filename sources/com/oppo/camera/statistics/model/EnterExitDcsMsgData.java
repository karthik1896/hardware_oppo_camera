package com.oppo.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;

public class EnterExitDcsMsgData extends DcsMsgData {
    public static final String EVENT_AGREEMENT = "agreement";
    public static final String EVENT_ENTER = "enter";
    public static final String EVENT_EXIT = "exit";
    public static final String EVENT_PERMISSION = "permission";
    public static final String EVENT_PERMISSION_STATUS = "permission_status";
    public static final String EVENT_STATEMENT = "statement";
    private static final String KEY_ENTER_CALLER_PACKAGE = "enter_caller_package";
    private static final String KEY_ENTER_CAMERA_ENTER_TIME_GAP = "camera_enter_time_gap";
    private static final String KEY_EXIT_CALLER_PACKAGE = "exit_caller_package";
    private static final String KEY_EXIT_RESUME_PAUSE_DURATION_TIME = "resume_pause_time";
    private static final String KEY_EXIT_RESUME_PAUSE_VIDEO_TIME = "resume_pause_video_time";
    private static final String KEY_EXIT_TO_GALLERY = "to_gallery";
    private static final String KEY_IS_CAMERA = "is_camera";
    private static final String KEY_IS_IMEI = "is_imei";
    private static final String KEY_IS_LOCATION = "is_location";
    private static final String KEY_IS_RECORDER = "is_recorder";
    private static final String KEY_IS_STORAGE = "is_storage";
    private static final String KEY_RESULT = "result";
    private static final String KEY_STATEMENT_TYPE = "statement_type";
    private static final String KEY_TIMING = "timing";
    private static final String LOCK_SUB_FIX = "LOCK";
    private static final String LOGTAG_ENTER = "201";
    public static final String PERMISSION_DISAGREE = "disagree_stop_ask";
    public static final String PERMISSION_NA = "na";
    public static final String PERMISSION_OFF = "off";
    public static final String PERMISSION_ON = "on";
    public static final String RESULT_AGREE = "agree";
    public static final String RESULT_CANCEL = "cancel";
    public static final String RESULT_EXIT = "exit";
    public static final String RESULT_SETTING = "setting";
    private static final String SEPARATOR = "_";
    public static final String STATEMENT_TYPE_NETWORK = "network";
    public static final String STATEMENT_TYPE_PRIVACY = "privacy";
    private static final String TAG = "EnterExitDcsMsgData";
    public static final String TIMING_OPEN_CAMERA = "start_oppo_camera";
    public static final String TIMING_SETTING_LOCATION = "setting_location";
    public static final String TIMING_SETTING_LOCATION_SLOGAN = "setting_location_slogan";
    public static final String TIMING_VIDEO_RECORD = "video_record";
    public long mCameraEnterTimeGap = 0;
    public String mCameraGranted = null;
    public String mCameraPermission = PERMISSION_NA;
    public String mEnterCallPackage = "";
    public String mExitCallPackage = "";
    public String mImeiGranted = null;
    public String mImeiPermission = PERMISSION_NA;
    public String mLocationGranted = null;
    public String mLocationPermission = PERMISSION_NA;
    public String mRecorderGranted = null;
    public String mRecorderPermission = PERMISSION_NA;
    public String mResult = "";
    public long mResumePauseTime = 0;
    public long mResumePauseVideoTime = 0;
    public String mShortcutType = "";
    public String mStatementType = "";
    public String mStorageGranted = null;
    public String mStoragePermission = PERMISSION_NA;
    public String mTiming = "";
    public boolean mbCamera = false;
    public boolean mbFromLock = false;
    public boolean mbImei = false;
    public boolean mbLocation = false;
    public boolean mbRecorder = false;
    public boolean mbStorage = false;
    public boolean mbToGallery = false;

    public EnterExitDcsMsgData(Context context, String str) {
        super(context, LOGTAG_ENTER, str, true);
    }

    public void report() {
        if (!TextUtils.isEmpty(this.mEnterCallPackage)) {
            String str = this.mEnterCallPackage;
            if (this.mbFromLock) {
                str = str + "_LOCK";
            } else if (!TextUtils.isEmpty(this.mShortcutType)) {
                str = str + SEPARATOR + this.mShortcutType;
            }
            this.mEventMap.put(KEY_ENTER_CALLER_PACKAGE, str);
        }
        if (!TextUtils.isEmpty(this.mExitCallPackage)) {
            String str2 = this.mExitCallPackage;
            if (this.mbFromLock) {
                str2 = str2 + "_LOCK";
            } else if (!TextUtils.isEmpty(this.mShortcutType)) {
                str2 = str2 + SEPARATOR + this.mShortcutType;
            }
            this.mEventMap.put(KEY_EXIT_CALLER_PACKAGE, str2);
        }
        if (this.mCameraEnterTimeGap > 0 && "enter".equals(this.mEventId)) {
            this.mEventMap.put("camera_enter_time_gap", String.valueOf(this.mCameraEnterTimeGap));
        }
        if (this.mResumePauseTime > 0 && "exit".equals(this.mEventId)) {
            this.mEventMap.put("resume_pause_time", String.valueOf(this.mResumePauseTime));
        }
        if (this.mResumePauseVideoTime > 0 && "exit".equals(this.mEventId)) {
            this.mEventMap.put("resume_pause_video_time", String.valueOf(this.mResumePauseVideoTime));
        }
        if ("exit".equals(this.mEventId)) {
            this.mEventMap.put("to_gallery", String.valueOf(this.mbToGallery));
        }
        if (EVENT_STATEMENT.equals(this.mEventId)) {
            checkEmptyCondition(KEY_STATEMENT_TYPE, this.mStatementType);
            checkEmptyCondition(KEY_RESULT, this.mResult);
        }
        if (EVENT_PERMISSION.equals(this.mEventId)) {
            checkEmptyCondition(KEY_IS_LOCATION, this.mLocationPermission);
            checkEmptyCondition(KEY_IS_CAMERA, this.mCameraPermission);
            checkEmptyCondition(KEY_IS_IMEI, this.mImeiPermission);
            checkEmptyCondition(KEY_IS_STORAGE, this.mStoragePermission);
            checkEmptyCondition(KEY_IS_RECORDER, this.mRecorderPermission);
            checkEmptyCondition(KEY_TIMING, this.mTiming);
        }
        if (EVENT_AGREEMENT.equals(this.mEventId)) {
            checkEmptyCondition(KEY_IS_LOCATION, String.valueOf(this.mbLocation));
            checkEmptyCondition(KEY_IS_CAMERA, String.valueOf(this.mbCamera));
            checkEmptyCondition(KEY_IS_IMEI, String.valueOf(this.mbImei));
            checkEmptyCondition(KEY_IS_STORAGE, String.valueOf(this.mbStorage));
            checkEmptyCondition(KEY_IS_RECORDER, String.valueOf(this.mbRecorder));
            checkEmptyCondition(KEY_RESULT, this.mResult);
            checkEmptyCondition(KEY_TIMING, this.mTiming);
        }
        if (EVENT_PERMISSION_STATUS.equals(this.mEventId)) {
            checkEmptyCondition(KEY_IS_LOCATION, this.mLocationGranted);
            checkEmptyCondition(KEY_IS_CAMERA, this.mCameraGranted);
            checkEmptyCondition(KEY_IS_IMEI, this.mImeiGranted);
            checkEmptyCondition(KEY_IS_STORAGE, this.mStorageGranted);
            checkEmptyCondition(KEY_IS_RECORDER, this.mRecorderGranted);
        }
        super.report();
    }
}
