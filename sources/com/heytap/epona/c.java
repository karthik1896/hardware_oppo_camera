package com.heytap.epona;

import android.app.Application;
import android.content.Context;
import com.heytap.epona.internal.a;
import com.heytap.epona.internal.b;
import com.heytap.epona.internal.d;
import com.heytap.epona.internal.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Epona */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2586a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static c f2587b;
    private static AtomicBoolean c = new AtomicBoolean(false);
    private final List<f> d = new ArrayList();
    private i e = new i();
    private h f = new com.heytap.epona.internal.c();
    private Application g;
    private a h = new a();
    private f i = new b();
    private Context j;

    private static void d() {
    }

    private c() {
    }

    public static void a(Context context) {
        if (!c.getAndSet(true)) {
            e().b(context);
            com.heytap.epona.e.a.a(context);
            com.heytap.shield.b.b().a(context);
            com.heytap.epona.d.c.a().a(context);
            d();
        }
    }

    public static List<f> a() {
        return e().d;
    }

    public static d a(Request request) {
        return e().e.a(request);
    }

    public static b a(String str) {
        return e().f.a(str);
    }

    public static com.heytap.epona.c.a b(String str) {
        return e().f.b(str);
    }

    public static Application b() {
        return e().g;
    }

    public static Context c() {
        return e().j;
    }

    private void b(Context context) {
        this.j = context;
        if (context instanceof Application) {
            this.g = (Application) context;
        } else {
            this.g = (Application) context.getApplicationContext();
        }
        this.h.a(this.g);
    }

    private static c e() {
        synchronized (f2586a) {
            if (f2587b == null) {
                f2587b = new c();
            }
        }
        return f2587b;
    }
}
