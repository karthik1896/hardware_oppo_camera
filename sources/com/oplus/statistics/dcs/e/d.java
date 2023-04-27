package com.oplus.statistics.dcs.e;

import android.util.Log;

/* compiled from: LogUtil */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f2713a = "NearmeStatistics-local";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2714b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = true;
    private static boolean f = true;
    private static String g = "-->";
    private static boolean h = false;

    public static void a(String str, Throwable th) {
        if (h && f) {
            Log.e(str, th.toString());
        }
    }

    public static void a(String str, String str2) {
        if (h && c) {
            Log.d(str, f2713a + g + str2);
        }
    }

    public static void b(String str, String str2) {
        if (h && e) {
            Log.w(str, f2713a + g + str2);
        }
    }

    public static void c(String str, String str2) {
        if (h && f) {
            Log.e(str, f2713a + g + str2);
        }
    }

    public static void a(String str) {
        if (h && c) {
            Log.d("DCS_OS_SDK--", f2713a + g + str);
        }
    }

    public static void b(String str) {
        if (h && d) {
            Log.i("DCS_OS_SDK--", f2713a + g + str);
        }
    }

    public static void c(String str) {
        if (h && f) {
            Log.e("DCS_OS_SDK--", f2713a + g + str);
        }
    }
}
