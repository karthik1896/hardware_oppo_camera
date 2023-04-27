package com.color.support.b.a;

import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewNative */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1855a = (Build.VERSION.SDK_INT >= 29 || (Build.VERSION.SDK_INT == 28 && "Q".equals(Build.VERSION.CODENAME)));

    public static void a(View view, int i) {
        try {
            if (f1855a) {
                Class.forName("com.color.inner.view.ViewWrapper").getDeclaredMethod("setScrollYForColor", new Class[]{View.class, Integer.TYPE}).invoke((Object) null, new Object[]{view, Integer.valueOf(i)});
                return;
            }
            Field declaredField = View.class.getDeclaredField("mScrollY");
            declaredField.setAccessible(true);
            declaredField.setInt(view, i);
        } catch (Throwable th) {
            Log.d("ViewNative", th.toString());
        }
    }

    public static void b(View view, int i) {
        try {
            if (f1855a) {
                Class.forName("com.color.inner.view.ViewWrapper").getDeclaredMethod("setScrollXForColor", new Class[]{View.class, Integer.TYPE}).invoke((Object) null, new Object[]{view, Integer.valueOf(i)});
                return;
            }
            Field declaredField = View.class.getDeclaredField("mScrollX");
            declaredField.setAccessible(true);
            declaredField.setInt(view, i);
        } catch (Throwable th) {
            Log.d("ViewNative", th.toString());
        }
    }
}
