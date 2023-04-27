package com.heytap.epona.e;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;

/* compiled from: Logger */
public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2597a = SystemProperties.getBoolean("persist.sys.assert.panic", false);

    /* renamed from: com.heytap.epona.e.a$a  reason: collision with other inner class name */
    /* compiled from: Logger */
    private static class C0070a extends ContentObserver {
        private C0070a(Handler handler) {
            super((Handler) null);
        }

        public void onChange(boolean z, Uri uri) {
            boolean unused = a.f2597a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }
    }

    public static void a(Context context) {
        if (context != null && context.getContentResolver() != null && "com.heytap.appplatform".equals(context.getPackageName())) {
            context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), false, new C0070a((Handler) null));
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (f2597a) {
            Log.d("Epona->" + str, a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (f2597a) {
            Log.e("Epona->" + str, a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (f2597a) {
            Log.w("Epona->" + str, a(str2, objArr));
        }
    }

    private static String a(String str, Object[] objArr) {
        return (str == null || objArr == null || objArr.length <= 0) ? "" : String.format(str, objArr);
    }
}
