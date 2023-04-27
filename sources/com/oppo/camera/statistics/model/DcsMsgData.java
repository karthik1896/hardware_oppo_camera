package com.oppo.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.compat.d.a.a;
import com.oppo.camera.e;
import com.oppo.camera.entry.b;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.util.Util;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class DcsMsgData {
    public static final int CAPTURE_TYPE = 0;
    public static final int CONDITION_FACE_JAW = -51;
    public static final int CONDITION_NAGATIVE_ONE = -1;
    public static final int CONDITION_ZERO = 0;
    private static boolean DEBUG = false;
    public static final String DIVIDER = "|";
    public static final String FRONT = "front";
    public static final int KB_IN_BYTES = 1024;
    private static final String KEY_ANC_FILTER_TYPE = "microscope_type";
    private static final String KEY_BLUR_LEVEL = "blur_level";
    protected static final String KEY_CAMERA_ID = "camera_id";
    protected static final String KEY_CAPTURE_MODE = "capture_mode";
    private static final String KEY_CLIENT_TIMESTAMP = "client_timestamp";
    private static final String KEY_ENTER_TIMESTAMP = "enter_timestamp";
    private static final String KEY_ENTER_TYPE = "enter_type";
    private static final String KEY_FILTER_TYPE = "filter_type";
    private static final String KEY_FLASH_MODE = "flash_mode";
    private static final String KEY_FLASH_TRIGGER = "flash_trigger";
    protected static final String KEY_HIGH_BRIGHTNESS = "screen_highlight";
    private static final String KEY_IS_MIRROR = "is_mirror";
    private static final String KEY_NIGHT_STYLE_TYPE = "night_style_type";
    protected static final String KEY_ORIENTATION = "orientation";
    private static final String KEY_PORTRAIT_NEW_STYLE_TYPE = "portrait_new_style_type";
    private static final String KEY_REAR_FRONT = "rear_front";
    protected static final String KEY_SCREEN_BRIGHTNESS = "screen_brightness";
    public static final String KEY_SMOOTH_CUBE = "self_smooth_cube";
    public static final String KEY_SMOOTH_DERMABRASION = "self_smooth_dermabrasion";
    public static final String KEY_SMOOTH_EYE_BIG = "self_smooth_eye_big";
    public static final String KEY_SMOOTH_FACE_JAW = "self_smooth_face_jaw";
    public static final String KEY_SMOOTH_FACE_LEAN = "self_smooth_face_lean";
    public static final String KEY_SMOOTH_FACE_SMALL = "self_smooth_face_small";
    public static final String KEY_SMOOTH_FRESHEN_UP = "self_smooth_freshen_up";
    public static final String KEY_SMOOTH_NOSE_LEAN = "self_smooth_nose_lean";
    private static final String KEY_SMOOTH_VALUE = "smooth_value";
    protected static final String KEY_SUBSCREEN_VALUE = "subscreen_value";
    private static final String KEY_VERSION_DATE = "version_date";
    protected static final String KEY_ZOOM_VALUE = "zoom_value";
    protected static final String LOGTAG_CAPTURE = "200";
    protected static final String LOGTAG_QRCODE = "206";
    protected static final String LOGTAG_STICKER = "205";
    protected static final String LOGTAG_VIDEO = "202";
    public static final String OFF = "off";
    public static final String ON = "on";
    public static final String REAR = "rear";
    private static final int SESSION_TIME_OUT = 10;
    public static final String SHUTTER_MODE_DONE = "end";
    public static final int STICKER_TYPE = 2;
    protected static final String TAG = "DcsMsgData";
    private static final String VERSION_DATE = "20190823";
    public static final int VIDEO_TYPE = 1;
    public String mAncFilterType = "";
    public int mBlurLevel = 0;
    public String mCameraEnterTimeStamp = String.valueOf(b.i());
    public String mCameraEnterType = String.valueOf(1);
    public int mCameraId = -1;
    public String mCaptureMode = null;
    public int mCaptureType = 0;
    public String mClientTimeStamp = String.valueOf(System.currentTimeMillis());
    private Context mContext;
    protected String mEventId = null;
    protected HashMap<String, String> mEventMap = null;
    public String mFilterType = "";
    public String mFlashMode = "";
    public String mFlashTrigger = "";
    public String mIsMirror = "";
    protected String mLogTag = null;
    public String mNightStyleType = "";
    public int mOrientation = -1;
    public String mPortraitNewStyleType = "";
    private boolean mRealTime = false;
    public String mRearOrFront = "";
    public int mScreenBrightness = -1;
    public String mScreenHighLight = "";
    public int mSmooth = -1;
    public int mSmoothCube = -1;
    public int mSmoothDermabrasion = -1;
    public int mSmoothEyeBig = -1;
    public int mSmoothFaceJaw = -51;
    public int mSmoothFaceLean = -1;
    public int mSmoothFaceSmall = -1;
    public int mSmoothFreshenUp = -1;
    public int mSmoothNoseLean = -1;
    public String mZoomValue = "";

    static {
        try {
            DEBUG = com.heytap.compat.os.b.a("persist.sys.assert.panic", false);
        } catch (a e) {
            e.printStackTrace();
        }
    }

    public DcsMsgData(Context context, String str, String str2, boolean z) {
        this.mContext = context;
        this.mLogTag = str;
        this.mEventId = str2;
        this.mRealTime = z;
        if (DEBUG) {
            this.mEventMap = new LinkedHashMap();
        } else {
            this.mEventMap = new HashMap<>();
        }
    }

    public DcsMsgData(Context context, String str, boolean z) {
        this.mContext = context;
        this.mEventId = str;
        this.mRealTime = z;
        if (DEBUG) {
            this.mEventMap = new LinkedHashMap();
        } else {
            this.mEventMap = new HashMap<>();
        }
    }

    public static void init(Context context) {
        CameraStatisticsUtil.onError(context);
        CameraStatisticsUtil.onDebug(DEBUG);
        CameraStatisticsUtil.setSessionTimeOut(context, 10);
    }

    public void parseFaceBeauty(int[] iArr) {
        if (iArr != null) {
            try {
                this.mSmoothDermabrasion = iArr[0];
                this.mSmoothFaceLean = iArr[1];
                this.mSmoothEyeBig = iArr[2];
                this.mSmoothNoseLean = iArr[3];
                this.mSmoothFaceJaw = iArr[4];
                this.mSmoothFaceSmall = iArr[5];
                this.mSmoothFreshenUp = iArr[6];
                this.mSmoothCube = iArr[7];
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public void report() {
        if (isValid()) {
            checkGreatCondition(KEY_BLUR_LEVEL, this.mBlurLevel, 0);
            checkGreatCondition("camera_id", com.oppo.camera.f.a.f(this.mCameraId), -1);
            checkEmptyCondition("capture_mode", this.mCaptureMode);
            checkEmptyCondition(KEY_CLIENT_TIMESTAMP, this.mClientTimeStamp);
            checkEmptyCondition(KEY_ENTER_TIMESTAMP, this.mCameraEnterTimeStamp);
            checkEmptyCondition(KEY_ENTER_TYPE, this.mCameraEnterType);
            checkEmptyCondition("filter_type", this.mFilterType);
            checkEmptyCondition(KEY_ANC_FILTER_TYPE, this.mAncFilterType);
            checkEmptyCondition(KEY_FLASH_MODE, this.mFlashMode);
            checkEmptyCondition(KEY_FLASH_TRIGGER, this.mFlashTrigger);
            checkEmptyCondition(KEY_IS_MIRROR, this.mIsMirror);
            checkGreatCondition("orientation", this.mOrientation, -1);
            checkEmptyCondition("portrait_new_style_type", this.mPortraitNewStyleType);
            checkEmptyCondition(KEY_NIGHT_STYLE_TYPE, this.mNightStyleType);
            checkGreatCondition("screen_brightness", this.mScreenBrightness, 0);
            checkGreatCondition(KEY_SMOOTH_VALUE, this.mSmooth, -1);
            checkEmptyCondition(KEY_VERSION_DATE, VERSION_DATE);
            checkEmptyCondition(KEY_ZOOM_VALUE, this.mZoomValue);
            checkEmptyCondition(KEY_REAR_FRONT, this.mRearOrFront);
            checkEmptyCondition(KEY_HIGH_BRIGHTNESS, this.mScreenHighLight);
            if (DEBUG) {
                e.b(TAG, "report, mLogTag: " + this.mLogTag + ", mEventId: " + this.mEventId);
            }
            com.coloros.statistics.dcs.a.onCommon(this.mContext, this.mLogTag, this.mEventId, (Map<String, String>) this.mEventMap, this.mRealTime);
        }
    }

    public boolean isValid() {
        if (Util.M()) {
            e.b(TAG, "isValid, monkey is running do not report");
            return false;
        } else if (!TextUtils.isEmpty(this.mLogTag) || !TextUtils.isEmpty(this.mEventId)) {
            return true;
        } else {
            return false;
        }
    }

    public void checkNoAnyCondition(String str, String str2) {
        this.mEventMap.put(str, str2);
    }

    public void checkEmptyCondition(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.mEventMap.put(str, str2);
        }
    }

    public void checkGreatCondition(String str, int i, int i2) {
        if (i > i2) {
            this.mEventMap.put(str, String.valueOf(i));
        }
    }

    public void checkGreatCondition(String str, long j, int i) {
        if (j > ((long) i)) {
            this.mEventMap.put(str, String.valueOf(j));
        }
    }

    public void checkGreatCondition(String str, float f, float f2) {
        if (Float.compare(f, f2) > 0) {
            this.mEventMap.put(str, String.valueOf(f));
        }
    }

    public void onResume() {
        CameraStatisticsUtil.onResume(this.mContext);
    }

    public void onPause() {
        CameraStatisticsUtil.onPause(this.mContext);
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        this.mContext = null;
    }

    public void put(String str, String str2) {
        this.mEventMap.put(str, str2);
    }

    /* access modifiers changed from: protected */
    public void prepareLogTagByCaptureType() {
        int i = this.mCaptureType;
        if (i == 0) {
            this.mLogTag = LOGTAG_CAPTURE;
        } else if (i == 1) {
            this.mLogTag = LOGTAG_VIDEO;
        } else if (i == 2) {
            this.mLogTag = LOGTAG_STICKER;
        }
    }
}
