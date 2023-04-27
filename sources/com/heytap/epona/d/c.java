package com.heytap.epona.d;

import android.content.Context;
import com.oplus.statistics.dcs.a;

/* compiled from: Statistics */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f2595a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2596b;

    private c() {
    }

    public static c a() {
        if (f2595a == null) {
            synchronized (c.class) {
                if (f2595a == null) {
                    f2595a = new c();
                }
            }
        }
        return f2595a;
    }

    public void a(Context context) {
        this.f2596b = context.getApplicationContext();
        if (this.f2596b != null) {
            a.a(context);
        }
    }

    public void a(b bVar) {
        a.a(this.f2596b, "30397", bVar.a(), bVar.b(), bVar.c());
    }
}
