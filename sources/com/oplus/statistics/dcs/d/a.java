package com.oplus.statistics.dcs.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.oplus.statistics.dcs.e.b;

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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.statistics.dcs.d.a.b(android.content.Context, java.lang.String, long):long");
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.statistics.dcs.d.a.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String b(Context context) {
        SharedPreferences a2 = a(context);
        if (a2 != null) {
            return a2.getString("ssoid", "0");
        }
        return "0";
    }
}
