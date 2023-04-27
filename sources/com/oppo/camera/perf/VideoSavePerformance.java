package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;

@Keep
public class VideoSavePerformance {
    private static final String TAG = "VideoSavePerformance";
    private static long sVideoSaveEndTime;
    private static long sVideoSaveStartTime;

    @Keep
    public static class VideoSavePerformanceData {
        private long mVideoSaveTime = 0;

        public VideoSavePerformanceData(long j) {
            this.mVideoSaveTime = j;
        }

        public long getVideoSaveTime() {
            return this.mVideoSaveTime;
        }
    }

    public static void setVideoSaveStartTime(long j) {
        sVideoSaveStartTime = j;
    }

    public static void setVideoSaveEndTime(long j) {
        sVideoSaveEndTime = j;
        onEnd();
    }

    private static void onEnd() {
        long j = sVideoSaveEndTime;
        long j2 = sVideoSaveStartTime;
        long j3 = j - j2;
        if (j3 <= 0 || j2 <= 0 || j <= 0) {
            e.a(TAG, "onEnd, not valid");
        } else {
            Performance.add(new VideoSavePerformanceData(j3));
        }
        clear();
    }

    private static void clear() {
        sVideoSaveStartTime = -1;
        sVideoSaveEndTime = -1;
    }
}
