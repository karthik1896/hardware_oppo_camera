package com.oppo.camera.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import com.oppo.exif.OppoExifTag;

/* compiled from: StatusBarUtil */
public class f {
    public static void a(Activity activity) {
        a(activity.getWindow(), a(activity.getBaseContext()));
    }

    private static void a(Window window, boolean z) {
        if (window != null) {
            a(window);
            c(window, z);
        }
    }

    public static void b(Activity activity) {
        b(activity.getWindow(), a(activity.getBaseContext()));
    }

    public static void a(Dialog dialog) {
        b(dialog.getWindow(), a(dialog.getContext()));
    }

    private static void b(Window window, boolean z) {
        if (window != null) {
            b(window);
            c(window, z);
        }
    }

    private static boolean a(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static void a(Window window) {
        window.addFlags(67108864);
    }

    private static void b(Window window) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1280);
        window.setStatusBarColor(0);
    }

    private static void c(Window window, boolean z) {
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 23) {
            systemUiVisibility = !z ? systemUiVisibility | OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION : systemUiVisibility & -8193;
        } else if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility = !z ? systemUiVisibility | 16 : systemUiVisibility & -17;
        }
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
    }
}
