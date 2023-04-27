package com.oplus.statistics.dcs.e;

import android.content.Context;

/* compiled from: AccountUtil */
public class a {
    public static String a(Context context) {
        String b2 = com.oplus.statistics.dcs.d.a.b(context);
        if (b2.equals("0")) {
            d.c("NearMeStatistics", "ssoid not set.");
        }
        return b2;
    }
}
