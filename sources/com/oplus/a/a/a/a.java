package com.oplus.a.a.a;

import android.os.SystemProperties;
import android.util.Log;

/* compiled from: LogUtils */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2669a = SystemProperties.getBoolean("persist.sys.assert.panic", false);

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2670b = false;
    private static final int c;

    static {
        if (f2669a) {
            c = 3;
        } else {
            c = 6;
        }
    }

    public static void a(String str, String str2) {
        a(2, str, str2);
    }

    public static void b(String str, String str2) {
        a(3, str, str2);
    }

    public static void c(String str, String str2) {
        a(5, str, str2);
    }

    public static void d(String str, String str2) {
        a(6, str, str2);
    }

    private static void a(int i, String str, String str2) {
        if (i >= c) {
            String str3 = "Download." + str;
            if (f2670b) {
                str2 = "[" + Thread.currentThread().getName() + "]" + str2;
            }
            if (i == 2) {
                Log.v(str3, str2);
            } else if (i == 3) {
                Log.d(str3, str2);
            } else if (i == 4) {
                Log.i(str3, str2);
            } else if (i == 5) {
                Log.w(str3, str2);
            } else if (i == 6) {
                Log.e(str3, str2);
            }
        }
    }
}
