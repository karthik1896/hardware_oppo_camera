package com.oplus.statistics.dcs;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.oplus.statistics.dcs.a.d;
import com.oplus.statistics.dcs.b.c;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: NearMeStatistics */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2680a = Pattern.compile("^[a-zA-Z0-9\\_\\-]{1,64}$");

    /* renamed from: b  reason: collision with root package name */
    private static Context f2681b;
    private static d c = new d();
    private static ExecutorService d = Executors.newSingleThreadExecutor();

    public static void a(Context context) {
        if (context == null) {
            com.oplus.statistics.dcs.e.d.b("NearMeStatistics", "SDK init failed! context is null.");
            return;
        }
        f2681b = context.getApplicationContext();
        ((Application) f2681b).registerActivityLifecycleCallbacks(com.oplus.statistics.dcs.c.a.a());
    }

    public static void a(Context context, String str, String str2, String str3, Map<String, String> map) {
        c cVar = new c();
        cVar.c(str);
        cVar.b(str2);
        cVar.a(str3);
        cVar.a(map);
        a(context, cVar, 1);
    }

    public static void a(final Context context, final c cVar, int i) {
        try {
            com.oplus.statistics.dcs.e.d.a("NearMeStatistics", "onCommon logTag is " + cVar.f() + ",eventID:" + cVar.a() + ",logmap:" + cVar.g() + ",flagSendTo:" + i);
            if (!TextUtils.isEmpty(cVar.f())) {
                if ((i & 1) == 1) {
                    d.execute(new Runnable() {
                        public void run() {
                            com.oplus.statistics.dcs.a.c.a(context, cVar);
                        }
                    });
                }
                if ((i & 2) == 2) {
                    d.execute(new Runnable() {
                        public void run() {
                            com.oplus.statistics.dcs.a.a.a(context, cVar);
                        }
                    });
                    return;
                }
                return;
            }
            com.oplus.statistics.dcs.e.d.c("Send data failed! logTag is null.");
        } catch (Exception e) {
            com.oplus.statistics.dcs.e.d.a("NearMeStatistics", (Throwable) e);
        }
    }
}
