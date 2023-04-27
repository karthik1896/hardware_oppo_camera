package com.oppo.camera.sticker.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.heytap.compat.os.b;
import com.oppo.camera.util.Util;

/* compiled from: DeviceInfo */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f3640a;

    /* renamed from: b  reason: collision with root package name */
    private String f3641b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private int g = -1;

    public static a a() {
        if (f3640a == null) {
            synchronized (a.class) {
                if (f3640a == null) {
                    f3640a = new a();
                }
            }
        }
        return f3640a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.c)) {
            try {
                this.c = b.a("ro.product.name");
            } catch (com.heytap.compat.d.a.a e2) {
                e2.printStackTrace();
            }
        }
        return this.c;
    }

    public int a(Context context) {
        if (this.g == -1) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (packageInfo != null) {
                this.g = packageInfo.versionCode;
            }
        }
        return this.g;
    }

    public String c() {
        if (TextUtils.isEmpty(this.d)) {
            try {
                this.d = b.a("ro.build.version.opporom");
            } catch (com.heytap.compat.d.a.a e2) {
                e2.printStackTrace();
            }
        }
        return this.d;
    }

    public String d() {
        if (TextUtils.isEmpty(this.e)) {
            try {
                this.e = b.a("ro.build.version.ota");
            } catch (com.heytap.compat.d.a.a e2) {
                e2.printStackTrace();
            }
        }
        return this.e;
    }

    public String e() {
        return Build.VERSION.RELEASE;
    }

    public String f() {
        String Z = Util.Z();
        return Z == null ? "CN" : Z;
    }

    public String b(Context context) {
        if (TextUtils.isEmpty(this.f)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels >= 1080) {
                this.f = "1080P";
            } else {
                this.f = "720P";
            }
        }
        return this.f;
    }
}
