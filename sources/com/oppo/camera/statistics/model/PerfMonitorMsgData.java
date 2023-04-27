package com.oppo.camera.statistics.model;

import android.content.Context;
import com.google.gson.Gson;
import com.oppo.camera.perf.CameraExitPerformance;
import com.oppo.camera.perf.CapturePerformance;
import com.oppo.camera.perf.ContinuousCapturePerformance;
import com.oppo.camera.perf.LaunchPerformance;
import com.oppo.camera.perf.PictureSavePerformance;
import com.oppo.camera.perf.SwitchCameraPerformance;
import com.oppo.camera.perf.SwitchModePerformance;
import com.oppo.camera.perf.VideoRecordPerformance;
import com.oppo.camera.perf.VideoSavePerformance;

public class PerfMonitorMsgData extends DcsMsgData {
    private static final String EVENT_PERFORMANCE = "performance";
    private static final String KEY_CAMERA_EXIT = "cameraExit";
    private static final String KEY_CAPTURE = "capture";
    private static final String KEY_CONTINUOUS_CAPTURE = "continuousCapture";
    private static final String KEY_LAUNCH = "launch";
    private static final String KEY_PICTURE_SAVE = "pictureSave";
    private static final String KEY_START_VIDEO_RECORD = "startVideoRecord";
    private static final String KEY_SWITCH_CAMERA = "switchCamera";
    private static final String KEY_SWITCH_MODE = "switchMode";
    private static final String KEY_VIDEO_SAVE = "videoSave";
    private static final String LOG_TAG_PERFORMANCE = "204";
    private static final String TAG = "PerformanceMsgData";
    private static Gson sGson = new Gson();
    private String mCameraExit = "";
    private String mCapture = "";
    private String mContinuousCapture = "";
    private String mLaunch = "";
    private String mPictureSave = "";
    private String mStartVideoRecord = "";
    private String mSwitchCamera = "";
    private String mSwitchMode = "";
    private String mVideoSave = "";

    public PerfMonitorMsgData(Context context) {
        super(context, LOG_TAG_PERFORMANCE, EVENT_PERFORMANCE, false);
    }

    public static void reportLaunch(Context context, LaunchPerformance.LaunchPerformanceData launchPerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mLaunch = sGson.toJson((Object) launchPerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public static void reportCapture(Context context, CapturePerformance.CapturePerformanceData capturePerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mCapture = sGson.toJson((Object) capturePerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public static void reportSwitchCamera(Context context, SwitchCameraPerformance.SwitchCameraPerformanceData switchCameraPerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mSwitchCamera = sGson.toJson((Object) switchCameraPerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public static void reportSwitchMode(Context context, SwitchModePerformance.SwitchModePerformanceData switchModePerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mSwitchMode = sGson.toJson((Object) switchModePerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public static void reportStartVideoRecord(Context context, VideoRecordPerformance.VideoRecordPerformanceData videoRecordPerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mStartVideoRecord = sGson.toJson((Object) videoRecordPerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public static void reportVideoSave(Context context, VideoSavePerformance.VideoSavePerformanceData videoSavePerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mVideoSave = sGson.toJson((Object) videoSavePerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public static void reportPictureSave(Context context, PictureSavePerformance.PictureSavePerformanceData pictureSavePerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mPictureSave = sGson.toJson((Object) pictureSavePerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public static void reportCameraExit(Context context, CameraExitPerformance.CameraExitPerformanceData cameraExitPerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mCameraExit = sGson.toJson((Object) cameraExitPerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public static void reportContinuousCapture(Context context, ContinuousCapturePerformance.ContinuousCapturePerformanceData continuousCapturePerformanceData) {
        if (context != null) {
            PerfMonitorMsgData perfMonitorMsgData = new PerfMonitorMsgData(context);
            perfMonitorMsgData.mContinuousCapture = sGson.toJson((Object) continuousCapturePerformanceData);
            perfMonitorMsgData.report();
        }
    }

    public void report() {
        checkEmptyCondition(KEY_LAUNCH, this.mLaunch);
        checkEmptyCondition(KEY_CAPTURE, this.mCapture);
        checkEmptyCondition(KEY_SWITCH_CAMERA, this.mSwitchCamera);
        checkEmptyCondition(KEY_SWITCH_MODE, this.mSwitchMode);
        checkEmptyCondition(KEY_START_VIDEO_RECORD, this.mStartVideoRecord);
        checkEmptyCondition(KEY_VIDEO_SAVE, this.mVideoSave);
        checkEmptyCondition(KEY_PICTURE_SAVE, this.mPictureSave);
        checkEmptyCondition(KEY_CAMERA_EXIT, this.mCameraExit);
        checkEmptyCondition(KEY_CONTINUOUS_CAPTURE, this.mContinuousCapture);
        super.report();
    }
}
