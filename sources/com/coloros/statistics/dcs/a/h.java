package com.coloros.statistics.dcs.a;

import android.content.Context;
import android.text.TextUtils;
import com.coloros.statistics.dcs.b.g;
import com.coloros.statistics.dcs.b.m;
import com.coloros.statistics.dcs.c.b;
import com.coloros.statistics.dcs.e.d;
import com.coloros.statistics.dcs.e.e;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: PageVisitAgent */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f2524a = Executors.newSingleThreadExecutor();

    public void a(Context context) {
        if (context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String c = c(context);
            d.b("NearMeStatistics", "onPause: " + c);
            this.f2524a.execute(new a(context, c, currentTimeMillis, 1));
            return;
        }
        d.d("NearMeStatistics", "onPause() called without context.");
    }

    public void b(Context context) {
        if (context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String c = c(context);
            d.b("NearMeStatistics", "onResume: " + c);
            this.f2524a.execute(new a(context, c, currentTimeMillis, 0));
            return;
        }
        d.d("NearMeStatistics", "onPause() called without context.");
    }

    private static String c(Context context) {
        return context != null ? context.getClass().getSimpleName() : "";
    }

    private static void d(Context context) {
        String c = com.coloros.statistics.dcs.d.a.c(context);
        int g = com.coloros.statistics.dcs.d.a.g(context);
        if (!TextUtils.isEmpty(c)) {
            g gVar = new g();
            gVar.b(c);
            gVar.a((long) g);
            gVar.a(e.a());
            b.a(context, (m) gVar);
        }
        com.coloros.statistics.dcs.d.a.a(context, 0);
        com.coloros.statistics.dcs.d.a.a(context, "");
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, long j) {
        JSONArray jSONArray;
        long d = com.coloros.statistics.dcs.d.a.d(context);
        int i = (int) ((j - d) / 1000);
        if (str.equals(com.coloros.statistics.dcs.d.a.f(context)) && i >= 0 && -1 != d) {
            try {
                String c = com.coloros.statistics.dcs.d.a.c(context);
                int g = com.coloros.statistics.dcs.d.a.g(context);
                if (!TextUtils.isEmpty(c)) {
                    jSONArray = new JSONArray(c);
                    if (jSONArray.length() >= 10) {
                        d(context);
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(str);
                jSONArray2.put(i);
                jSONArray.put(jSONArray2);
                com.coloros.statistics.dcs.d.a.a(context, g + i);
                com.coloros.statistics.dcs.d.a.a(context, jSONArray.toString());
            } catch (JSONException e) {
                d.a("NearMeStatistics", (Throwable) e);
            } catch (Exception e2) {
                d.a("NearMeStatistics", (Throwable) e2);
                com.coloros.statistics.dcs.d.a.a(context, "");
                com.coloros.statistics.dcs.d.a.a(context, 0);
            }
        }
        com.coloros.statistics.dcs.d.a.b(context, j);
    }

    /* access modifiers changed from: private */
    public static void d(Context context, String str, long j) {
        long e = com.coloros.statistics.dcs.d.a.e(context);
        long d = com.coloros.statistics.dcs.d.a.d(context);
        long j2 = ((long) com.coloros.statistics.dcs.d.a.j(context)) * 1000;
        if (j - d >= j2 && (-1 == e || e >= j || j - e >= j2)) {
            a.a(context);
            com.coloros.statistics.dcs.d.a.c(context, System.currentTimeMillis());
            d(context);
        }
        com.coloros.statistics.dcs.d.a.a(context, j);
        com.coloros.statistics.dcs.d.a.b(context, str);
    }

    /* compiled from: PageVisitAgent */
    private final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Context f2526b;
        private String c;
        private long d;
        private int e;

        public a(Context context, String str, long j, int i) {
            this.f2526b = context;
            this.c = str;
            this.d = j;
            this.e = i;
        }

        public void run() {
            int i = this.e;
            if (i == 0) {
                h.d(this.f2526b, this.c, this.d);
            } else if (i == 1) {
                h.c(this.f2526b, this.c, this.d);
            }
        }
    }
}
