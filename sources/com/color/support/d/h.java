package com.color.support.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;

/* compiled from: ColorOrientationUtil */
public class h {
    public static boolean a(int i) {
        return i == 1;
    }

    public static boolean a(Context context) {
        return b(context) == 1;
    }

    public static int b(Context context) {
        Point c = c(context);
        return (c.x <= c.y || d(context)) ? 1 : 2;
    }

    public static Point c(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point;
    }

    public static boolean d(Context context) {
        if (!(context instanceof Activity) || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return ((Activity) context).isInMultiWindowMode();
    }
}
