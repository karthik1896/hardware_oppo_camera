package com.coloros.statistics.dcs.e;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: VersionUtil */
public class f {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.nearme.statistics.rom", 1).versionCode >= 5118000) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
