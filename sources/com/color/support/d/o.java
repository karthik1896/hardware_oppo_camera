package com.color.support.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Environment;
import android.util.Log;
import android.util.SparseIntArray;
import color.support.v7.appcompat.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: ColorThemeOverlay */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static volatile o f1876a;

    /* renamed from: b  reason: collision with root package name */
    private SparseIntArray f1877b = new SparseIntArray();
    private HashMap<String, WeakReference<Boolean>> c = new HashMap<>();

    public static o a() {
        if (f1876a == null) {
            synchronized (o.class) {
                if (f1876a == null) {
                    f1876a = new o();
                }
            }
        }
        return f1876a;
    }

    public void a(Context context) {
        b();
        c(context);
        for (int i = 0; i < this.f1877b.size(); i++) {
            context.setTheme(this.f1877b.valueAt(i));
        }
    }

    public boolean b(Context context) {
        return a(context.getResources().getConfiguration()) > 0;
    }

    public void a(int i, int i2) {
        this.f1877b.put(i, i2);
    }

    public void b() {
        this.f1877b.clear();
    }

    private void c(Context context) {
        int i;
        int i2;
        if (context != null) {
            long a2 = a(context.getResources().getConfiguration());
            int i3 = (int) (65535 & a2);
            int i4 = (int) (196608 & a2);
            if (a2 != 0 && (a2 & 1048576) != 1048576 && i4 != 131072) {
                if (!(i3 == 0 && i4 == 0) && !d(context)) {
                    int integer = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorThemeIdentifier}).getInteger(0, 0);
                    if (i4 == 0) {
                        if (i3 == 1) {
                            i2 = R.array.color_theme_arrays_first;
                        } else if (i3 == 2) {
                            i2 = R.array.color_theme_arrays_second;
                        } else if (i3 != 3) {
                            i2 = i3 != 4 ? 0 : R.array.color_theme_arrays_fourth;
                        } else {
                            i2 = R.array.color_theme_arrays_third;
                        }
                        int i5 = i2;
                        i3 = integer - 1;
                        i = i5;
                    } else if (i4 == 65536) {
                        i = R.array.color_theme_arrays_single;
                    } else {
                        i3 = -1;
                        i = 0;
                    }
                    if (i != 0 && i3 != -1) {
                        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i);
                        for (int i6 = 0; i6 < obtainTypedArray.length(); i6++) {
                            if (i6 == i3) {
                                a(R.id.color_global_theme, obtainTypedArray.getResourceId(i6, 0));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public long a(Configuration configuration) {
        try {
            Class<?> cls = Class.forName("com.color.inner.content.res.ConfigurationWrapper");
            if (cls.newInstance() == null) {
                return 0;
            }
            return ((Long) cls.getMethod("getMaterialColor", new Class[]{Configuration.class}).invoke((Object) null, new Object[]{configuration})).longValue();
        } catch (Exception e) {
            Log.e("ColorThemeOverlay", "getColorTheme e: " + e);
            return 0;
        }
    }

    private boolean d(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null) {
            return false;
        }
        long j = 0;
        File file = null;
        try {
            Class<?> cls = Class.forName("com.color.inner.content.res.ConfigurationWrapper");
            if (cls.newInstance() != null) {
                j = ((Long) cls.getMethod("getThemeChangedFlags", new Class[]{Configuration.class}).invoke((Object) null, new Object[]{configuration})).longValue();
            }
            file = new File(Environment.getDataDirectory().getAbsolutePath() + File.separator + "theme" + File.separator + context.getPackageName());
        } catch (Exception e) {
            Log.e("ColorThemeOverlay", "isRejectTheme e: " + e);
        }
        if ((j & 1) != 1 || file == null || !file.exists() || (configuration.uiMode & 48) == 32) {
            return false;
        }
        return true;
    }
}
