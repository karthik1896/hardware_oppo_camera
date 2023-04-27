package com.heytap.shield.b;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings;

/* compiled from: DebugUtils */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f2647a = null;
    private static boolean c = true;
    /* access modifiers changed from: private */
    public static boolean d = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2648b = false;
    private Context e;

    private c() {
    }

    public void a(Context context) {
        if (!this.f2648b) {
            this.f2648b = true;
            c = SystemProperties.getBoolean("ro.build.release_type", true);
            if (!c) {
                this.e = context;
                d = d();
                context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("oplus_appplatform_debug"), false, new a());
                d.b("Current MODE is debug mode : " + d);
            }
        }
    }

    /* compiled from: DebugUtils */
    private class a extends ContentObserver {
        private a() {
            super((Handler) null);
        }

        public void onChange(boolean z, Uri uri) {
            boolean unused = c.d = c.this.d();
            d.a("Change MODE to debug mode : " + c.d);
        }
    }

    /* access modifiers changed from: private */
    public boolean d() {
        return Settings.Secure.getInt(this.e.getContentResolver(), "oplus_appplatform_debug", 0) == 1;
    }

    public boolean a() {
        return !c && d;
    }

    public static c b() {
        if (f2647a == null) {
            synchronized (c.class) {
                if (f2647a == null) {
                    f2647a = new c();
                }
            }
        }
        return f2647a;
    }
}
