package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;

@Keep
public class VideoRecordPerformance {
    private static final String TAG = "VideoRecordPerformance";
    private static long sStartVideoRecordEndTime;
    private static long sStartVideoRecordStartTime;

    @Keep
    public static class VideoRecordPerformanceData {
        private long mStartVideoRecordTime;

        public VideoRecordPerformanceData(long j) {
            this.mStartVideoRecordTime = j;
        }
    }

    public static void setStartVideoRecordStartTime(long j) {
        sStartVideoRecordStartTime = j;
    }

    public static void setStartVideoRecordEndTime(long j) {
        sStartVideoRecordEndTime = j;
        onEnd();
    }

    private static void onEnd() {
        long j = sStartVideoRecordEndTime;
        long j2 = sStartVideoRecordStartTime;
        long j3 = j - j2;
        if (j3 <= 0 || j2 <= 0 || j <= 0) {
            e.a(TAG, "onEnd, not valid");
        } else {
            Performance.add(new VideoRecordPerformanceData(j3));
        }
        clear();
    }

    private static void clear() {
        sStartVideoRecordStartTime = -1;
        sStartVideoRecordEndTime = -1;
    }
}
