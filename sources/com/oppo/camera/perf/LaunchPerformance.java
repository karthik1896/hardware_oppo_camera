package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;

@Keep
public class LaunchPerformance {
    private static final String TAG = "LaunchPerformance";
    private static long sCameraOpenedTime;
    private static long sCreateSessionTime;
    private static long sFirstFrameAvailableTime;
    private static long sFirstFrameDrawTime;
    private static long sOnCreateTime;
    private static long sOpenCameraTime;
    private static long sRequestRepeatingTime;
    private static long sSessionConfiguredTime;

    @Keep
    public static class LaunchPerformanceData {
        /* access modifiers changed from: private */
        public long mDurationS1 = 0;
        /* access modifiers changed from: private */
        public long mDurationS2 = 0;
        /* access modifiers changed from: private */
        public long mDurationS3 = 0;
        /* access modifiers changed from: private */
        public long mDurationS4 = 0;
        /* access modifiers changed from: private */
        public long mDurationS5 = 0;
        /* access modifiers changed from: private */
        public long mDurationS6 = 0;
        /* access modifiers changed from: private */
        public long mDurationS7 = 0;

        /* access modifiers changed from: private */
        public boolean isValid() {
            return this.mDurationS1 > 0 && this.mDurationS2 > 0 && this.mDurationS3 > 0 && this.mDurationS4 > 0 && this.mDurationS5 > 0 && this.mDurationS6 > 0 && this.mDurationS7 > 0;
        }

        public long launchTime() {
            if (isValid()) {
                return this.mDurationS1 + this.mDurationS2 + this.mDurationS3 + this.mDurationS4 + this.mDurationS5 + this.mDurationS6 + this.mDurationS7;
            }
            return -1;
        }
    }

    public static void setOnCreateTime(long j) {
        sOnCreateTime = j;
    }

    public static void setOpenCameraTime(long j) {
        sOpenCameraTime = j;
    }

    public static void setCameraOpenedTime(long j) {
        sCameraOpenedTime = j;
    }

    public static void setCreateSessionTime(long j) {
        sCreateSessionTime = j;
    }

    public static void setSessionConfiguredTime(long j) {
        sSessionConfiguredTime = j;
    }

    public static void setRequestRepeatingTime(long j) {
        sRequestRepeatingTime = j;
    }

    public static void setFirstFrameAvailableTime(long j) {
        sFirstFrameAvailableTime = j;
    }

    public static void setFirstFrameDrawTime(long j) {
        sFirstFrameDrawTime = j;
        onEnd();
    }

    private static void onEnd() {
        LaunchPerformanceData launchPerformanceData = new LaunchPerformanceData();
        long unused = launchPerformanceData.mDurationS1 = sOpenCameraTime - sOnCreateTime;
        long unused2 = launchPerformanceData.mDurationS2 = sCameraOpenedTime - sOpenCameraTime;
        long unused3 = launchPerformanceData.mDurationS3 = sCreateSessionTime - sCameraOpenedTime;
        long unused4 = launchPerformanceData.mDurationS4 = sSessionConfiguredTime - sCreateSessionTime;
        long unused5 = launchPerformanceData.mDurationS5 = sRequestRepeatingTime - sSessionConfiguredTime;
        long unused6 = launchPerformanceData.mDurationS6 = sFirstFrameAvailableTime - sRequestRepeatingTime;
        long unused7 = launchPerformanceData.mDurationS7 = sFirstFrameDrawTime - sFirstFrameAvailableTime;
        e.e(TAG, "onEnd, launch time, s1: " + launchPerformanceData.mDurationS1 + ", s2: " + launchPerformanceData.mDurationS2 + ", s3: " + launchPerformanceData.mDurationS3 + ", s4: " + launchPerformanceData.mDurationS4 + ", s5: " + launchPerformanceData.mDurationS5 + ", s6: " + launchPerformanceData.mDurationS6 + ", s7: " + launchPerformanceData.mDurationS7);
        if (!launchPerformanceData.isValid() || sOnCreateTime <= 0 || sOpenCameraTime <= 0 || sCameraOpenedTime <= 0 || sCreateSessionTime <= 0 || sSessionConfiguredTime <= 0 || sRequestRepeatingTime <= 0 || sFirstFrameAvailableTime <= 0 || sFirstFrameDrawTime <= 0) {
            e.a(TAG, "onEnd, not valid");
        } else {
            Performance.add(launchPerformanceData);
        }
        clear();
    }

    private static void clear() {
        sOnCreateTime = -1;
        sOpenCameraTime = -1;
        sCameraOpenedTime = -1;
        sCreateSessionTime = -1;
        sSessionConfiguredTime = -1;
        sRequestRepeatingTime = -1;
        sFirstFrameAvailableTime = -1;
        sFirstFrameDrawTime = -1;
    }
}
