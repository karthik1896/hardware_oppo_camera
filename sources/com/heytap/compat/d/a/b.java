package com.heytap.compat.d.a;

import android.os.Build;

/* compiled from: VersionUtils */
public final class b {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
