package com.coloros.statistics.dcs.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.coloros.statistics.dcs.e.b;

/* compiled from: PreferenceHandler */
public class a {
    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("nearme_setting_" + b.a(context), 0);
    }

    public static void a(Context context, String str, long j) {
        SharedPreferences a2;
        if (context != null && !TextUtils.isEmpty(str) && (a2 = a(context)) != null) {
            SharedPreferences.Editor edit = a2.edit();
            edit.putLong(str, j);
            edit.apply();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r1 = a(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long b(android.content.Context r1, java.lang.String r2, long r3) {
        /*
            if (r1 == 0) goto L_0x0013
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0009
            goto L_0x0013
        L_0x0009:
            android.content.SharedPreferences r1 = a(r1)
            if (r1 == 0) goto L_0x0013
            long r3 = r1.getLong(r2, r3)
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.statistics.dcs.d.a.b(android.content.Context, java.lang.String, long):long");
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences a2;
        if (context != null && !TextUtils.isEmpty(str) && (a2 = a(context)) != null) {
            SharedPreferences.Editor edit = a2.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r1 = a(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r1, java.lang.String r2, java.lang.String r3) {
        /*
            if (r1 == 0) goto L_0x0013
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0009
            goto L_0x0013
        L_0x0009:
            android.content.SharedPreferences r1 = a(r1)
            if (r1 == 0) goto L_0x0013
            java.lang.String r3 = r1.getString(r2, r3)
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.statistics.dcs.d.a.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static SharedPreferences b(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("nearme_func_" + b.a(context), 0);
    }

    public static String c(Context context) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            return b2.getString("pagevisit.routes", "");
        }
        return "";
    }

    public static void a(Context context, String str) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            SharedPreferences.Editor edit = b2.edit();
            edit.putString("pagevisit.routes", str);
            edit.commit();
        }
    }

    public static long d(Context context) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            return b2.getLong("activity.start.time", -1);
        }
        return -1;
    }

    public static void a(Context context, long j) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            SharedPreferences.Editor edit = b2.edit();
            edit.putLong("activity.start.time", j);
            edit.commit();
        }
    }

    public static long e(Context context) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            return b2.getLong("activity.end.time", -1);
        }
        return -1;
    }

    public static void b(Context context, long j) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            SharedPreferences.Editor edit = b2.edit();
            edit.putLong("activity.end.time", j);
            edit.commit();
        }
    }

    public static String f(Context context) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            return b2.getString("current.activity", "");
        }
        return "";
    }

    public static void b(Context context, String str) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            SharedPreferences.Editor edit = b2.edit();
            edit.putString("current.activity", str);
            edit.commit();
        }
    }

    public static long c(Context context, String str, String str2) {
        SharedPreferences b2 = b(context);
        if (b2 == null) {
            return 0;
        }
        return b2.getLong("event.start" + str + "_" + str2, 0);
    }

    public static void a(Context context, String str, String str2, long j) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            SharedPreferences.Editor edit = b2.edit();
            edit.putLong("event.start" + str + "_" + str2, j);
            edit.commit();
        }
    }

    public static String d(Context context, String str, String str2) {
        SharedPreferences b2 = b(context);
        if (b2 == null) {
            return "";
        }
        return b2.getString("kv.start" + str + "_" + str2, "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            SharedPreferences.Editor edit = b2.edit();
            edit.putString("kv.start" + str + "_" + str3, str2);
            edit.commit();
        }
    }

    public static int g(Context context) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            return b2.getInt("pagevisit.duration", 0);
        }
        return -1;
    }

    public static void a(Context context, int i) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            SharedPreferences.Editor edit = b2.edit();
            edit.putInt("pagevisit.duration", i);
            edit.commit();
        }
    }

    public static void c(Context context, long j) {
        SharedPreferences b2 = b(context);
        if (b2 != null) {
            SharedPreferences.Editor edit = b2.edit();
            edit.putLong("pagevisit.start.time", j);
            edit.commit();
        }
    }

    public static String h(Context context) {
        SharedPreferences a2 = a(context);
        if (a2 != null) {
            return a2.getString("ssoid", "0");
        }
        return "0";
    }

    public static void c(Context context, String str) {
        SharedPreferences a2 = a(context);
        if (a2 != null) {
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("ssoid", str);
            edit.commit();
        }
    }

    public static void i(Context context) {
        SharedPreferences a2 = a(context);
        if (a2 != null) {
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("ssoid", "0");
            edit.commit();
        }
    }

    public static void b(Context context, int i) {
        SharedPreferences a2 = a(context);
        if (a2 != null) {
            SharedPreferences.Editor edit = a2.edit();
            edit.putInt("session.timeout", i);
            edit.commit();
        }
    }

    public static int j(Context context) {
        SharedPreferences a2 = a(context);
        if (a2 != null) {
            return a2.getInt("session.timeout", 30);
        }
        return 30;
    }
}
