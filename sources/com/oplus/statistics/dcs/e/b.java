package com.oplus.statistics.dcs.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: ApkInfoUtil */
public class b {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
            return "0";
        }
    }

    public static String b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
            return "0";
        }
    }

    public static String c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null || packageInfo.versionName == null) {
                return "0";
            }
            String str = packageInfo.versionName;
            d.b("versionName=" + str);
            return str;
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
            return "0";
        }
    }

    public static int d(Context context) {
        int i = 0;
        try {
            i = context.getPackageManager().getApplicationInfo(a(context), 128).metaData.getInt("AppCode");
            if (i == 0) {
                d.c("NearMeStatistics", "AppCode not set. please read the document of NearMeStatistics SDK.");
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
        return i;
    }
}
