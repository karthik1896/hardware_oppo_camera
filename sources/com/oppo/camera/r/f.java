package com.oppo.camera.r;

import android.app.Activity;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.ui.e;

/* compiled from: SLVModeFactory */
public class f {
    public static String a(int i) {
        if (i == 120) {
            return ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE;
        }
        if (i == 240) {
            return ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE;
        }
        if (i == 480) {
            return ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE;
        }
        if (i != 960) {
            return null;
        }
        return ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE;
    }

    public static String b(int i) {
        String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(a(i));
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[0];
    }

    public static String c(int i) {
        String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(a(i));
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[1];
    }

    public static a a(int i, Activity activity, e eVar) {
        com.oppo.camera.e.a("SLVModeFactory", "getSLVFpsMode fpsMode: " + i);
        if (i == 120) {
            return new b(activity, eVar);
        }
        if (i == 240) {
            return new c(activity, eVar);
        }
        if (i == 480) {
            return new d(activity, eVar);
        }
        if (i == 960) {
            return new e(activity, eVar);
        }
        throw new Error("Invalid fpsMode " + i);
    }
}
