package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;

@Keep
public class SwitchCameraPerformance {
    private static final String TAG = "SwitchCameraPerformance";
    private static long sSwitchCameraEndTime;
    private static long sSwitchCameraStartTime;

    @Keep
    public static class SwitchCameraPerformanceData {
        /* access modifiers changed from: private */
        public long mSwitchCameraDuration;

        /* access modifiers changed from: private */
        public boolean isValid() {
            return this.mSwitchCameraDuration > 0;
        }
    }

    public static void setSwitchCameraStartTime(long j) {
        sSwitchCameraStartTime = j;
    }

    public static void setSwitchCameraEndTime(long j) {
        sSwitchCameraEndTime = j;
        onEnd();
    }

    private static void onEnd() {
        SwitchCameraPerformanceData switchCameraPerformanceData = new SwitchCameraPerformanceData();
        long unused = switchCameraPerformanceData.mSwitchCameraDuration = sSwitchCameraEndTime - sSwitchCameraStartTime;
        if (!switchCameraPerformanceData.isValid() || sSwitchCameraStartTime <= 0 || sSwitchCameraEndTime <= 0) {
            e.a(TAG, "onEnd, not valid");
        } else {
            Performance.add(switchCameraPerformanceData);
        }
        clear();
    }

    private static void clear() {
        sSwitchCameraStartTime = -1;
        sSwitchCameraEndTime = -1;
    }
}
