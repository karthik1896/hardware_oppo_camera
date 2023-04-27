package com.heytap.tingle.ipc.d;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Logger */
public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2661a;

    /* renamed from: b  reason: collision with root package name */
    private static AtomicBoolean f2662b = new AtomicBoolean(false);

    /* renamed from: com.heytap.tingle.ipc.d.a$a  reason: collision with other inner class name */
    /* compiled from: Logger */
    private static class C0074a extends ContentObserver {
        private C0074a(Handler handler) {
            super((Handler) null);
        }

        public void onChange(boolean z, Uri uri) {
            boolean unused = a.f2661a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }
    }

    public static void a(Context context) {
        if (!f2662b.getAndSet(true)) {
            if (context == null || context.getContentResolver() == null) {
                f2661a = false;
                return;
            }
            if ("com.heytap.appplatform".equals(context.getPackageName())) {
                context.getContentResolver().registerContentObserver(Settings.System.getUriFor("log_switch_type"), false, new C0074a((Handler) null));
            }
            f2661a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        Log.e("Tingle->" + str, a(str2, objArr));
    }

    private static String a(String str, Object[] objArr) {
        return (str == null || objArr == null || objArr.length <= 0) ? str : String.format(str, objArr);
    }
}
