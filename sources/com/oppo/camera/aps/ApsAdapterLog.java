package com.oppo.camera.aps;

import android.os.Handler;
import android.util.Log;
import android.util.LogPrinter;
import java.util.HashMap;

public class ApsAdapterLog {
    private static final String TAG_FORMAT = "ApsAdapter, %s";
    private static final String TRACE_TAG = "ApsAdapter_TRACE, %s";
    private static final Long TRACE_TAG_ALWAYS = 1L;
    private static HashMap<String, String> sTagMap = new HashMap<>();
    private static boolean sbLogOn = true;
    private static boolean sbTraceOn = true;

    public static void initLog(boolean z, boolean z2) {
        sbLogOn = z;
        sbTraceOn = z2;
    }

    private static String getTag(String str) {
        if (sTagMap.get(str) == null) {
            sTagMap.put(str, String.format(TAG_FORMAT, new Object[]{str}));
        }
        return sTagMap.get(str);
    }

    public static void v(String str, String str2) {
        if (sbLogOn) {
            Log.v(getTag(str), str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (sbLogOn) {
            Log.v(getTag(str), str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (sbLogOn) {
            Log.d(getTag(str), str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sbLogOn) {
            Log.d(getTag(str), str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (sbLogOn) {
            Log.i(getTag(str), str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (sbLogOn) {
            Log.i(getTag(str), str2, th);
        }
    }

    public static void dumpHandlerMsg(String str, Handler handler, String str2) {
        if (!sbLogOn) {
            return;
        }
        if (handler == null) {
            Log.e(getTag(str), "dumpHandlerMsg, handler is null!");
        } else {
            handler.dump(new LogPrinter(6, "handler info"), str2);
        }
    }

    public static void w(String str, String str2) {
        Log.w(getTag(str), str2);
    }

    public static void w(String str, String str2, Throwable th) {
        Log.w(getTag(str), str2, th);
    }

    public static void w(String str, Throwable th) {
        Log.w(getTag(str), th);
    }

    public static void e(String str, String str2) {
        Log.e(getTag(str), str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(getTag(str), str2, th);
    }

    public static boolean isLogOn() {
        return sbLogOn;
    }
}
