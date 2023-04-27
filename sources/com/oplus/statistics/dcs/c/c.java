package com.oplus.statistics.dcs.c;

import android.content.Context;
import java.util.UUID;

/* compiled from: StatIdManager */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f2710a;

    /* renamed from: b  reason: collision with root package name */
    private long f2711b;

    /* compiled from: StatIdManager */
    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f2712a = new c();
    }

    private c() {
        this.f2710a = null;
        this.f2711b = 0;
    }

    public static c a() {
        return a.f2712a;
    }

    public String a(Context context) {
        if (this.f2710a == null) {
            c(context);
        }
        return this.f2710a;
    }

    public void b(Context context) {
        this.f2711b = System.currentTimeMillis();
        a(context, this.f2711b);
    }

    public void c(Context context) {
        if (!e(context)) {
            d(context);
        } else {
            this.f2710a = g(context);
        }
    }

    public void d(Context context) {
        this.f2710a = b();
        a(context, this.f2710a);
    }

    private String b() {
        return UUID.randomUUID().toString();
    }

    private boolean e(Context context) {
        if (this.f2711b == 0) {
            this.f2711b = f(context);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f2711b;
        return currentTimeMillis > 0 && currentTimeMillis < 30000;
    }

    private void a(Context context, long j) {
        com.oplus.statistics.dcs.d.a.a(context, "AppExitTime", j);
    }

    private long f(Context context) {
        return com.oplus.statistics.dcs.d.a.b(context, "AppExitTime", 0);
    }

    private void a(Context context, String str) {
        com.oplus.statistics.dcs.d.a.a(context, "AppSessionId", str);
    }

    private String g(Context context) {
        return com.oplus.statistics.dcs.d.a.b(context, "AppSessionId", "");
    }
}
