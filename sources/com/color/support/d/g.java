package com.color.support.d;

import android.os.Build;
import android.util.Log;

/* compiled from: ColorOSVersionUtil */
public class g {
    public static int a() {
        boolean z = Build.VERSION.SDK_INT >= 30;
        try {
            Class<?> cls = Class.forName(z ? "com.oplus.os.OplusBuild" : "com.color.os.ColorBuild");
            if (cls == null) {
                return 0;
            }
            return ((Integer) cls.getDeclaredMethod(z ? "getOplusOSVERSION" : "getColorOSVERSION", new Class[0]).invoke(cls, new Object[0])).intValue();
        } catch (Exception e) {
            Log.e("ColorOSVersionUtil", "getColorOSVersionCode failed. error = " + e.getMessage());
            return 0;
        }
    }
}
