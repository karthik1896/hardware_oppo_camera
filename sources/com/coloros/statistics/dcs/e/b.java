package com.coloros.statistics.dcs.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* compiled from: ApkInfoUtil */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f2555a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f2556b = "";
    private static String c = "";
    private static int d;
    private static int e;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f2555a)) {
            return f2555a;
        }
        try {
            f2555a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e2) {
            d.a("NearMeStatistics", (Throwable) e2);
        }
        return TextUtils.isEmpty(f2555a) ? "0" : f2555a;
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f2556b)) {
            return f2556b;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            f2556b = packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e2) {
            d.a("NearMeStatistics", (Throwable) e2);
        }
        return TextUtils.isEmpty(f2556b) ? "0" : f2556b;
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (!(packageInfo == null || packageInfo.versionName == null)) {
                c = packageInfo.versionName;
                d.b("versionName=" + c);
            }
        } catch (Exception e2) {
            d.a("NearMeStatistics", (Throwable) e2);
        }
        return TextUtils.isEmpty(c) ? "0" : c;
    }

    public static int d(Context context) {
        int i = e;
        if (i != 0) {
            return i;
        }
        try {
            e = context.getPackageManager().getApplicationInfo(a(context), 128).metaData.getInt("AppCode");
            if (e == 0) {
                d.d("NearMeStatistics", "AppCode not set. please read the document of NearMeStatistics SDK.");
            }
        } catch (Exception e2) {
            d.a("NearMeStatistics", (Throwable) e2);
        }
        return e;
    }
}
