package com.oppo.camera.statistics.model;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.camera.e;
import java.util.ArrayList;
import java.util.HashMap;

public class PerformanceMsgData extends DcsMsgData {
    public static final String CAMERA_FOCUS_TIME = "camera_focus_time";
    public static final String CAMERA_MODE_SWITCH_TIME = "camera_mode_switch_time";
    public static final String CAMERA_SHUTTER_BUTTON_CLICKABLE_TIME = "camera_shutter_button_clickable_time";
    public static final String CAMERA_START_TIME = "camera_start_time";
    public static final String CAMERA_SWITCH_TIME = "camera_switch_time";
    public static final String CAMERA_VIDEO_FOCUS_TIME = "camera_video_focus_time";
    public static final String CAMERA_VIDEO_SAVE_TIME = "camera_video_save_time";
    public static final String CAMERA_VIDEO_START_TIME = "camera_video_start_time";
    private static final String EVENT_PERFORMANCE = "performance";
    private static final String LOG_TAG_PERFORMANCE = "204";
    private static final int MAX_LENGTH = 10;
    public static final String MINI_PIC_SAVE_TIME = "mini_pic_save_time";
    private static final int REAL_TIME_BASE = 1000;
    private static final String SCREEN_FPS = "screen_fps";
    private static final String TAG = "PerformanceMsgData";
    private static ArrayList<Long> sFocusCosts = new ArrayList<>();
    private static int sFrameRateIndex = 0;
    private static long[] sFrameRateList = new long[10];
    private static long sRealTimeFrameStart = 0;
    private static HashMap<String, String> sStartPointMap = new HashMap<>();

    public PerformanceMsgData(Context context) {
        super(context, LOG_TAG_PERFORMANCE, EVENT_PERFORMANCE, false);
    }

    public static void startPointTime(String str) {
        sStartPointMap.put(str, String.valueOf(System.currentTimeMillis()));
        if (CAMERA_START_TIME.equals(str)) {
            sFrameRateList = new long[10];
        }
    }

    public static long getPointTime(String str) {
        String str2 = sStartPointMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        sStartPointMap.put(str, "");
        return System.currentTimeMillis() - Long.valueOf(str2).longValue();
    }

    public static void getRealtimeFrameRate() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = sRealTimeFrameStart;
        if (!(j == 0 || j == currentTimeMillis)) {
            long[] jArr = sFrameRateList;
            int i = sFrameRateIndex;
            jArr[i] = 1000 / (currentTimeMillis - j);
            sFrameRateIndex = (i + 1) % 10;
        }
        sRealTimeFrameStart = currentTimeMillis;
    }

    public static void buildPerformanceData(Context context, String str, String str2, int i, String str3) {
        String str4 = sStartPointMap.get(str);
        if (!TextUtils.isEmpty(str4)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - Long.valueOf(str4).longValue();
                sStartPointMap.put(str, "");
                if (!CAMERA_FOCUS_TIME.equals(str) || sFocusCosts.size() >= 10) {
                    PerformanceMsgData performanceMsgData = new PerformanceMsgData(context);
                    performanceMsgData.mCameraEnterType = str2;
                    performanceMsgData.mCameraId = i;
                    performanceMsgData.mCaptureMode = str3;
                    performanceMsgData.mEventMap.put(SCREEN_FPS, getAverageFrameRate());
                    if (CAMERA_FOCUS_TIME.equals(str)) {
                        performanceMsgData.mEventMap.put(str, String.valueOf(getAverageFocusCost()));
                        sFocusCosts.clear();
                    } else {
                        performanceMsgData.mEventMap.put(str, String.valueOf(currentTimeMillis));
                    }
                    performanceMsgData.report();
                    return;
                }
                sFocusCosts.add(Long.valueOf(currentTimeMillis));
            } catch (Exception e) {
                e.printStackTrace();
                e.e(TAG, e.getMessage());
            }
        }
    }

    public static String getAverageFrameRate() {
        long[] jArr = sFrameRateList;
        if (jArr == null) {
            return "-1";
        }
        long j = 0;
        for (long j2 : jArr) {
            if (0 != j2) {
                j += j2;
            }
        }
        return String.valueOf(j / ((long) sFrameRateList.length));
    }

    private static String getAverageFocusCost() {
        ArrayList<Long> arrayList = sFocusCosts;
        if (arrayList == null || arrayList.size() == 0) {
            return "-1";
        }
        long j = 0;
        for (int i = 0; i < sFocusCosts.size(); i++) {
            if (sFocusCosts.get(i) != null) {
                j += sFocusCosts.get(i).longValue();
            }
        }
        return String.valueOf(j / ((long) sFocusCosts.size()));
    }
}
