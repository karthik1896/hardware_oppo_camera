package com.heytap.shield.authcode;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.text.TextUtils;
import com.crunchfish.touchless_a3d.TouchlessA3D;
import com.heytap.shield.authcode.a.a;
import com.heytap.shield.authcode.dao.AuthenticationDb;
import com.heytap.shield.authcode.dao.c;
import com.heytap.shield.b.d;
import com.heytap.shield.b.e;
import com.heytap.shield.b.f;
import com.heytap.shield.b.g;
import com.heytap.shield.b.h;
import com.heytap.shield.b.i;
import java.util.Calendar;
import java.util.concurrent.Executors;

/* compiled from: Authentication */
public class b {
    public static a a(Context context, String str) {
        int a2 = e.a(context, str);
        if (TextUtils.isEmpty(str)) {
            d.b("Get target packageName is empty");
            return new a("", 1004, new byte[0]);
        }
        String a3 = e.a(context, str, "AppPlatformKey");
        if (TextUtils.isEmpty(a3)) {
            d.b("Get target application authCode is empty");
            return new a("", 1004, new byte[0]);
        }
        try {
            for (String a4 : h.a(a3, ";")) {
                byte[][] a5 = a(str, a4, context);
                if (a5[0][0] == 1) {
                    byte[] bArr = a5[1];
                    a(context, a3, str, a2, i.a(a5[2]), bArr);
                    d.c("Auth code check ok");
                    return new a(str, 1001, bArr);
                }
            }
            d.b("Signature verify failed, package : " + str);
            return new a(str, TouchlessA3D.Parameters.EXTENDED_RANGE, new byte[0]);
        } catch (Exception e) {
            d.b("Check key get exception " + e.getMessage());
            return new a(str, TouchlessA3D.Parameters.EXTENDED_RANGE, new byte[0]);
        }
    }

    private static byte[][] a(String str, String str2, Context context) {
        byte[][] bArr = {new byte[]{0}};
        try {
            byte[] a2 = com.heytap.shield.b.a.a(str2);
            byte[] a3 = f.a(a2);
            byte[] bArr2 = {8};
            int a4 = h.a(f.b(a2));
            byte[] a5 = f.a(a2, a4);
            byte[] b2 = f.b(a2, a4);
            if (!g.a(context, str, a3, a4, bArr2, b2, a5, f.c(a2, a4))) {
                d.c("Signature verify failed.");
                return bArr;
            }
            return new byte[][]{new byte[]{1}, a5, b2};
        } catch (Exception e) {
            d.b("Check key get exception " + e.getMessage());
            return bArr;
        }
    }

    static a a(Context context, String str, String str2) {
        if (!a(context)) {
            d.a("Not get data from db cause user is locked.");
            return null;
        }
        c a2 = AuthenticationDb.a(context).l().a(e.a(context, str), str, "APP_PLATFORM_CLIENT", str2);
        if (a2 != null) {
            return new a(str, 1001, a2.h());
        }
        return null;
    }

    private static void a(Context context, String str, String str2, int i, Calendar calendar, byte[] bArr) {
        if (!a(context)) {
            d.a("Not save to db cause user is locked.");
        } else if (str2 != null) {
            Executors.newSingleThreadExecutor().execute(new Runnable(str, i, str2, calendar, bArr, context) {
                private final /* synthetic */ String f$0;
                private final /* synthetic */ int f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ Calendar f$3;
                private final /* synthetic */ byte[] f$4;
                private final /* synthetic */ Context f$5;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void run() {
                    AuthenticationDb.a(this.f$5).l().a(new c(this.f$0, true, this.f$1, this.f$2, "APP_PLATFORM_CLIENT", this.f$3.getTimeInMillis(), this.f$4, System.currentTimeMillis(), 0));
                }
            });
        }
    }

    private static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        UserManager userManager = (UserManager) context.getSystemService("user");
        if (Build.VERSION.SDK_INT >= 24) {
            return userManager.isUserUnlocked();
        }
        return false;
    }
}
