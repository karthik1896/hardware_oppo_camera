package com.coloros.statistics.dcs.c;

import android.content.Context;
import java.util.UUID;

/* compiled from: StatIdManager */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f2552a;

    /* renamed from: b  reason: collision with root package name */
    private long f2553b;

    /* compiled from: StatIdManager */
    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f2554a = new c();
    }

    private c() {
        this.f2552a = null;
        this.f2553b = 0;
    }

    public static c a() {
        return a.f2554a;
    }

    public String a(Context context) {
        if (this.f2552a == null) {
            c(context);
        }
        return this.f2552a;
    }

    public void b(Context context) {
        this.f2553b = System.currentTimeMillis();
        a(context, this.f2553b);
    }

    public void c(Context context) {
        if (!e(context)) {
            d(context);
        } else {
            this.f2552a = g(context);
        }
    }

    public void d(Context context) {
        this.f2552a = b();
        a(context, this.f2552a);
    }

    private String b() {
        return UUID.randomUUID().toString();
    }

    private boolean e(Context context) {
        if (this.f2553b == 0) {
            this.f2553b = f(context);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f2553b;
        return currentTimeMillis > 0 && currentTimeMillis < 30000;
    }

    private void a(Context context, long j) {
        com.coloros.statistics.dcs.d.a.a(context, "AppExitTime", j);
    }

    private long f(Context context) {
        return com.coloros.statistics.dcs.d.a.b(context, "AppExitTime", 0);
    }

    private void a(Context context, String str) {
        com.coloros.statistics.dcs.d.a.a(context, "AppSessionId", str);
    }

    private String g(Context context) {
        return com.coloros.statistics.dcs.d.a.b(context, "AppSessionId", "");
    }
}
