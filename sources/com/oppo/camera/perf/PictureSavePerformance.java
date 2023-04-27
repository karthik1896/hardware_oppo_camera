package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;

@Keep
public class PictureSavePerformance {
    private static final String TAG = "PictureSavePerformance";
    private static long sPictureSaveEndTime;
    private static long sPictureSaveStartTime;

    @Keep
    public static class PictureSavePerformanceData {
        private long mPictureSaveTime = 0;

        public PictureSavePerformanceData(long j) {
            this.mPictureSaveTime = j;
        }

        public long getPictureSaveTime() {
            return this.mPictureSaveTime;
        }
    }

    public static void setPictureSaveStartTime(long j) {
        sPictureSaveStartTime = j;
    }

    public static void setPictureSaveEndTime(long j) {
        sPictureSaveEndTime = j;
        onEnd();
    }

    private static void onEnd() {
        long j = sPictureSaveEndTime;
        long j2 = sPictureSaveStartTime;
        long j3 = j - j2;
        if (j3 <= 0 || j2 <= 0 || j <= 0) {
            e.a(TAG, "onEnd, not valid");
        } else {
            Performance.add(new PictureSavePerformanceData(j3));
        }
        clear();
    }

    private static void clear() {
        sPictureSaveStartTime = -1;
        sPictureSaveEndTime = -1;
    }
}
