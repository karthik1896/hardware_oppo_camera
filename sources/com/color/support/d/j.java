package com.color.support.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import color.support.v7.appcompat.R;

/* compiled from: ColorPanelMultiWindowUtils */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static int f1868a;

    /* renamed from: b  reason: collision with root package name */
    private static int f1869b;

    public static int a(Activity activity, Configuration configuration) {
        if (activity == null) {
            return 0;
        }
        if (!b(activity)) {
            return a((Context) activity, configuration);
        }
        Rect a2 = a(activity);
        if (a2 != null) {
            return a2.bottom - a2.top;
        }
        return 0;
    }

    public static int a(Context context, Configuration configuration) {
        int i = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int b2 = b(context);
        int c = c(context);
        if (f.b(context) && a(configuration)) {
            i = f.c(context);
        }
        return (b2 - c) - i;
    }

    public static Rect a(Activity activity) {
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    public static boolean b(Activity activity) {
        return Build.VERSION.SDK_INT >= 24 && activity != null && activity.isInMultiWindowMode();
    }

    public static boolean c(Activity activity) {
        if (activity == null) {
            return true;
        }
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        if (rect.top <= c((Context) activity)) {
            return true;
        }
        return false;
    }

    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        if (defaultDisplay != null) {
            defaultDisplay.getRealSize(point);
        }
        return point.y;
    }

    public static int c(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int b(Context context, Configuration configuration) {
        if (f1868a == 0) {
            f1868a = (int) context.getResources().getDimension(R.dimen.color_panel_normal_padding_top);
        }
        if (f1869b == 0) {
            f1869b = (int) context.getResources().getDimension(R.dimen.color_panel_full_screen_padding_top);
        }
        Activity a2 = a(context);
        if (a2 != null) {
            return a(a2, a(a2, configuration));
        }
        return a(context, configuration) - f1868a;
    }

    public static int a(Activity activity, int i) {
        int i2;
        if (!b(activity) || c(activity)) {
            if (f1868a == 0) {
                f1868a = (int) activity.getResources().getDimension(R.dimen.color_panel_normal_padding_top);
            }
            i2 = f1868a;
        } else {
            if (f1869b == 0) {
                f1869b = (int) activity.getResources().getDimension(R.dimen.color_panel_full_screen_padding_top);
            }
            i2 = f1869b;
        }
        return i - i2;
    }

    public static boolean d(Context context) {
        return a(context.getResources().getConfiguration());
    }

    public static boolean a(Configuration configuration) {
        return configuration.orientation == 1;
    }
}
