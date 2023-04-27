package com.oplus.statistics.dcs.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.oplus.statistics.dcs.b.c;
import com.oplus.statistics.dcs.b.j;
import com.oplus.statistics.dcs.e.b;
import com.oplus.statistics.dcs.e.d;
import java.util.HashMap;

/* compiled from: AtomAgent */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f2686a;

    /* renamed from: b  reason: collision with root package name */
    private static long f2687b;

    public static void a(Context context, c cVar) {
        a(context, (j) cVar);
    }

    private static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coloros.deepthinker", "com.coloros.atom.services.AtomReceiverService"));
        intent.putExtra("appId", b.d(context));
        intent.putExtra("appPackage", b.a(context));
        return intent;
    }

    private static void a(Context context, j jVar) {
        if (jVar == null || context == null) {
            d.a("AtomAgent add Task error -- bean or context is null--" + jVar + "," + context);
            return;
        }
        if (f2686a == 0) {
            f2687b = System.currentTimeMillis();
        }
        f2686a++;
        c cVar = (c) jVar;
        Intent a2 = a(context);
        a2.putExtra("logTag", cVar.f());
        a2.putExtra("eventID", cVar.a());
        a2.putExtra("logMap", cVar.g());
        try {
            a(context, a2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f2687b <= 10000) {
                return;
            }
            if (f2686a > 20) {
                HashMap hashMap = new HashMap();
                hashMap.put("gapTime", String.valueOf(currentTimeMillis - f2687b));
                hashMap.put("call_count", String.valueOf(f2686a));
                hashMap.put("appPackage", b.a(context));
                hashMap.put("logTag", cVar.f());
                hashMap.put("eventID", cVar.a());
                hashMap.put("logMap", cVar.g());
                String jSONObject = com.oplus.statistics.dcs.e.c.a(hashMap).toString();
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
                intent.putExtra("appId", 20185);
                intent.putExtra("appVersion", "1.0.0");
                intent.putExtra("appName", "Atom");
                intent.putExtra("appPackage", "com.coloros.atom");
                intent.putExtra("ssoid", com.oplus.statistics.dcs.e.a.a(context));
                intent.putExtra("uploadNow", false);
                intent.putExtra("dataType", 1006);
                intent.putExtra("logTag", "atomReport");
                intent.putExtra("eventID", "unusual_frequence_info");
                intent.putExtra("logMap", jSONObject);
                a(context, intent);
                f2686a = 0;
                d.c("addTaskForAtom too frequently");
                return;
            }
            f2686a = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(Context context, Intent intent) {
        context.startService(intent);
    }
}
