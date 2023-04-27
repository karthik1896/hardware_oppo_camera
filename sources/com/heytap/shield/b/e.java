package com.heytap.shield.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* compiled from: PackageUtils */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2651a = "e";

    public static int a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).uid;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String a(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str = "";
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
                try {
                    if (next.pid == i) {
                        if (next.pkgList == null || next.pkgList.length == 0) {
                            str = next.processName;
                            if (str.contains(":")) {
                                str = str.substring(0, str.indexOf(":"));
                            }
                        } else {
                            str = next.pkgList[0];
                        }
                    }
                } catch (Exception e) {
                    d.b("get exception " + e.getMessage());
                }
            }
        }
        return str;
    }

    public static String a(Context context, int i, int i2) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length != 1) {
            return a(context, i2);
        }
        return packagesForUid[0];
    }

    public static String a(Context context, String str, String str2) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            if (bundle == null || !bundle.containsKey(str2)) {
                return "";
            }
            return bundle.getString(str2);
        } catch (PackageManager.NameNotFoundException e) {
            d.b("Unable to fetch metadata from teh manifest " + e.getMessage());
            throw new RuntimeException("Unable to fetch metadata from teh manifest", e);
        }
    }
}
