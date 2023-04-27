package com.color.support.d;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

/* compiled from: ColorNavigationBarUtil */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f1861a = Settings.Secure.getUriFor("nav_bar_immersive");

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z;
        } catch (Exception e) {
            Log.d("NavigationBarUtils", "fail to get navigation bar status message is " + e.getMessage());
            return z;
        }
    }

    public static boolean b(Context context) {
        if (!a(context)) {
            return false;
        }
        int i = Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0);
        int i2 = Settings.Secure.getInt(context.getContentResolver(), "manual_hide_navigationbar", 0);
        if (i == 0 || (i == 1 && i2 == 0)) {
            return true;
        }
        return false;
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }
}
