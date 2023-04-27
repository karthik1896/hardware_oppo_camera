package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;

@Keep
public class CameraExitPerformance {
    private static final String TAG = "CameraExitPerformance";
    private static long sOnPauseStartTime;
    private static long sOnStopEndTime;
    private static long sOnStopStartTime;

    @Keep
    public static class CameraExitPerformanceData {
        /* access modifiers changed from: private */
        public long mOnPauseTime = 0;
        /* access modifiers changed from: private */
        public long mOnStopTime = 0;

        /* access modifiers changed from: private */
        public boolean isValid() {
            return this.mOnPauseTime > 0 && this.mOnStopTime > 0;
        }
    }

    public static void setOnPauseStartTime(long j) {
        sOnPauseStartTime = j;
    }

    public static void setOnStopStartTime(long j) {
        sOnStopStartTime = j;
    }

    public static void setsOnStopEndTime(long j) {
        sOnStopEndTime = j;
        onEnd();
    }

    private static void onEnd() {
        CameraExitPerformanceData cameraExitPerformanceData = new CameraExitPerformanceData();
        long unused = cameraExitPerformanceData.mOnPauseTime = sOnStopStartTime - sOnPauseStartTime;
        long unused2 = cameraExitPerformanceData.mOnStopTime = sOnStopEndTime - sOnStopStartTime;
        e.e(TAG, "onEnd, camera exit time, onPauseTime: " + cameraExitPerformanceData.mOnPauseTime + ", onStopTime: " + cameraExitPerformanceData.mOnStopTime);
        if (!cameraExitPerformanceData.isValid() || sOnPauseStartTime <= 0 || sOnStopStartTime <= 0 || sOnStopEndTime <= 0) {
            e.a(TAG, "onEnd, not valid");
        } else {
            Performance.add(cameraExitPerformanceData);
        }
        clear();
    }

    private static void clear() {
        sOnPauseStartTime = -1;
        sOnStopStartTime = -1;
        sOnStopEndTime = -1;
    }
}
