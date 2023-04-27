package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;

@Keep
public class ContinuousCapturePerformance {
    private static final int AVERAGE_COUNT = 19;
    private static final String TAG = "ContinuousCapturePerformance";
    private static long sContinuousCaptureEndTime;
    private static long sContinuousCaptureStartTime;

    @Keep
    public static class ContinuousCapturePerformanceData {
        private long mContinuousCaptureTime = 0;

        public ContinuousCapturePerformanceData(long j) {
            this.mContinuousCaptureTime = j;
        }
    }

    public static void setContinuousCaptureStartTime(long j) {
        sContinuousCaptureStartTime = j;
    }

    public static void setContinuousCaptureEndTime(long j) {
        sContinuousCaptureEndTime = j;
        onEnd();
    }

    private static void onEnd() {
        long j = sContinuousCaptureEndTime;
        long j2 = sContinuousCaptureStartTime;
        long j3 = j - j2;
        if (j3 <= 0 || j2 <= 0 || j <= 0) {
            e.a(TAG, "onEnd, not valid");
        } else {
            Performance.add(new ContinuousCapturePerformanceData(j3 / 19));
        }
        clear();
    }

    private static void clear() {
        sContinuousCaptureStartTime = -1;
        sContinuousCaptureEndTime = -1;
    }
}
