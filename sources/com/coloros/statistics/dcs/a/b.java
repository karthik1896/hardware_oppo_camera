package com.coloros.statistics.dcs.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.coloros.statistics.dcs.b.c;
import com.coloros.statistics.dcs.b.m;
import com.coloros.statistics.dcs.e.a;
import com.coloros.statistics.dcs.e.d;
import java.util.HashMap;

/* compiled from: AtomAgent */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f2522a;

    /* renamed from: b  reason: collision with root package name */
    private static long f2523b;

    public static void a(Context context, c cVar) {
        a(context, (m) cVar);
    }

    private static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coloros.deepthinker", "com.coloros.atom.services.AtomReceiverService"));
        intent.putExtra("appId", com.coloros.statistics.dcs.e.b.d(context));
        intent.putExtra("appPackage", com.coloros.statistics.dcs.e.b.a(context));
        return intent;
    }

    private static void a(Context context, m mVar) {
        if (mVar == null || context == null) {
            d.a("AtomAgent add Task error -- bean or context is null--" + mVar + "," + context);
            return;
        }
        if (f2522a == 0) {
            f2523b = System.currentTimeMillis();
        }
        f2522a++;
        c cVar = (c) mVar;
        Intent a2 = a(context);
        a2.putExtra("logTag", cVar.f());
        a2.putExtra("eventID", cVar.a());
        a2.putExtra("logMap", cVar.g());
        try {
            a(context, a2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f2523b <= 10000) {
                return;
            }
            if (f2522a > 20) {
                HashMap hashMap = new HashMap();
                hashMap.put("gapTime", String.valueOf(currentTimeMillis - f2523b));
                hashMap.put("call_count", String.valueOf(f2522a));
                hashMap.put("appPackage", com.coloros.statistics.dcs.e.b.a(context));
                hashMap.put("logTag", cVar.f());
                hashMap.put("eventID", cVar.a());
                hashMap.put("logMap", cVar.g());
                String jSONObject = com.coloros.statistics.dcs.e.c.a(hashMap).toString();
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
                intent.putExtra("appId", 20185);
                intent.putExtra("appVersion", "1.0.0");
                intent.putExtra("appName", "Atom");
                intent.putExtra("appPackage", "com.coloros.atom");
                intent.putExtra("ssoid", a.a(context));
                intent.putExtra("uploadNow", false);
                intent.putExtra("dataType", 1006);
                intent.putExtra("logTag", "atomReport");
                intent.putExtra("eventID", "unusual_frequence_info");
                intent.putExtra("logMap", jSONObject);
                a(context, intent);
                f2522a = 0;
                d.c("addTaskForAtom too frequently");
                return;
            }
            f2522a = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(Context context, Intent intent) {
        context.startService(intent);
    }
}
