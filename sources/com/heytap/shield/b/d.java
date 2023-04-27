package com.heytap.shield.b;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;

/* compiled from: PLog */
public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2650a = false;

    public static void a(Context context) {
        f2650a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), false, new a());
    }

    /* compiled from: PLog */
    private static class a extends ContentObserver {
        private a() {
            super((Handler) null);
        }

        public void onChange(boolean z, Uri uri) {
            boolean unused = d.f2650a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }
    }

    public static void a(String str) {
        if (f2650a) {
            Log.d("AppPlatform.Shield", str);
        }
    }

    public static void b(String str) {
        Log.e("AppPlatform.Shield", str);
    }

    public static void c(String str) {
        if (f2650a) {
            Log.i("AppPlatform.Shield", str);
        }
    }
}
