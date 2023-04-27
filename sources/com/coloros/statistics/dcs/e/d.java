package com.coloros.statistics.dcs.e;

import android.os.SystemProperties;
import android.util.Log;

/* compiled from: LogUtil */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2557a = SystemProperties.getBoolean("persist.sys.assert.panic", false);

    /* renamed from: b  reason: collision with root package name */
    private static String f2558b = "NearmeStatistics-local";
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = true;
    private static boolean g = true;
    private static String h = "-->";
    private static boolean i = false;

    public static void a(String str, Throwable th) {
        if (i && g) {
            Log.e(str, th.toString());
        }
    }

    public static void a(String str, String str2) {
        if (i && d) {
            Log.d(str, f2558b + h + str2);
        }
    }

    public static void b(String str, String str2) {
        if (i && e) {
            Log.i(str, f2558b + h + str2);
        }
    }

    public static void c(String str, String str2) {
        if (i && f) {
            Log.w(str, f2558b + h + str2);
        }
    }

    public static void d(String str, String str2) {
        if (i && g) {
            Log.e(str, f2558b + h + str2);
        }
    }

    public static void a(String str) {
        if (i && d) {
            Log.d("com.coloros.statistics--", f2558b + h + str);
        }
    }

    public static void b(String str) {
        if (i && e) {
            Log.i("com.coloros.statistics--", f2558b + h + str);
        }
    }

    public static void c(String str) {
        if (i && g) {
            Log.e("com.coloros.statistics--", f2558b + h + str);
        }
    }

    public static void a(boolean z) {
        i = z;
        if (!i || !f2557a) {
            c = false;
            d = false;
            e = false;
            f = false;
            g = false;
            return;
        }
        c = true;
        d = true;
        e = true;
        f = true;
        g = true;
    }
}
