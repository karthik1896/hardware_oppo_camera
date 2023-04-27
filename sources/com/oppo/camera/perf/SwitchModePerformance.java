package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;

@Keep
public class SwitchModePerformance {
    private static final String TAG = "SwitchModePerformance";
    private static long sSwitchModeEndTime;
    private static long sSwitchModeStartTime;

    @Keep
    public static class SwitchModePerformanceData {
        /* access modifiers changed from: private */
        public long mSwitchModeDuration;

        /* access modifiers changed from: private */
        public boolean isValid() {
            return this.mSwitchModeDuration > 0;
        }
    }

    public static void setSwitchModeStartTime(long j) {
        sSwitchModeStartTime = j;
    }

    public static void setSwitchModeEndTime(long j) {
        sSwitchModeEndTime = j;
        onEnd();
    }

    private static void onEnd() {
        SwitchModePerformanceData switchModePerformanceData = new SwitchModePerformanceData();
        long unused = switchModePerformanceData.mSwitchModeDuration = sSwitchModeEndTime - sSwitchModeStartTime;
        if (!switchModePerformanceData.isValid() || sSwitchModeStartTime <= 0 || sSwitchModeEndTime <= 0) {
            e.a(TAG, "onEnd, not valid");
        } else {
            Performance.add(switchModePerformanceData);
        }
        clear();
    }

    private static void clear() {
        sSwitchModeStartTime = -1;
        sSwitchModeEndTime = -1;
    }
}
