package com.oppo.camera;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.util.LogPrinter;
import com.heytap.compat.d.a.a;
import com.heytap.compat.os.b;
import com.heytap.compat.os.c;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.sticker.c.d;

/* compiled from: CameraLog */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Long f2826a = 1L;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2827b = true;
    private static boolean c = true;

    private static String c(String str) {
        return str == null ? "OppoCamera" : str;
    }

    public static void a(Context context) {
        try {
            f2827b = b.a("persist.sys.assert.panic", false);
        } catch (a e) {
            e.printStackTrace();
        }
        c = d.e(context);
        ApsAdapterLog.initLog(f2827b, c);
    }

    public static void a(String str, String str2) {
        if (f2827b) {
            Log.v(c(str), str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f2827b) {
            Log.v(c(str), str2, th);
        }
    }

    public static void b(String str, String str2) {
        if (f2827b) {
            Log.d(c(str), str2);
        }
    }

    public static void c(String str, String str2) {
        if (f2827b) {
            Log.i(c(str), str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f2827b) {
            Log.i(c(str), str2, th);
        }
    }

    public static void a(String str) {
        if (c) {
            Log.e("OppoCamera_TRACE", "traceBeginSection, msg: " + str);
            try {
                c.a(f2826a.longValue(), str);
            } catch (a e) {
                e.printStackTrace();
            } catch (Throwable unused) {
                e("OppoCamera", "reflect error");
            }
        }
    }

    public static void b(String str) {
        if (c) {
            Log.e("OppoCamera_TRACE", "traceEndSection, msg: " + str);
            try {
                c.a(f2826a.longValue());
            } catch (a e) {
                e.printStackTrace();
            } catch (Throwable unused) {
                e("OppoCamera", "reflect error");
            }
        }
    }

    public static void a(String str, Handler handler, String str2) {
        if (!f2827b) {
            return;
        }
        if (handler == null) {
            Log.e(c(str), "dumpHandlerMsg, handler is null!");
        } else {
            handler.dump(new LogPrinter(6, "handler info"), str2);
        }
    }

    public static void d(String str, String str2) {
        Log.w(c(str), str2);
    }

    public static void c(String str, String str2, Throwable th) {
        Log.w(c(str), str2, th);
    }

    public static void e(String str, String str2) {
        Log.e(c(str), str2);
    }

    public static void d(String str, String str2, Throwable th) {
        Log.e(c(str), str2, th);
    }

    public static boolean a() {
        return f2827b;
    }
}
