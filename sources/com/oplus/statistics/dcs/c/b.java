package com.oplus.statistics.dcs.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.crunchfish.touchless_a3d.TouchlessA3D;
import com.oplus.statistics.dcs.b.a;
import com.oplus.statistics.dcs.b.c;
import com.oplus.statistics.dcs.b.e;
import com.oplus.statistics.dcs.b.f;
import com.oplus.statistics.dcs.b.g;
import com.oplus.statistics.dcs.b.h;
import com.oplus.statistics.dcs.b.i;
import com.oplus.statistics.dcs.b.j;
import com.oplus.statistics.dcs.b.k;
import com.oplus.statistics.dcs.e.d;
import com.oppo.camera.aps.BuildConfig;

/* compiled from: RecordHandler */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2709a = "b";

    public static void a(Context context, j jVar) {
        if (jVar == null || context == null) {
            d.a("RecordHandler add Task error -- bean or context is null--" + jVar + "," + context);
            return;
        }
        try {
            switch (jVar.c()) {
                case 1:
                    Intent a2 = a(context);
                    a2.putExtra("loginTime", ((com.oplus.statistics.dcs.b.b) jVar).a());
                    a2.putExtra("dataType", 1000);
                    a(context, a2);
                    return;
                case 2:
                    k kVar = (k) jVar;
                    Intent a3 = a(context);
                    a3.putExtra("actionAmount", kVar.d());
                    a3.putExtra("actionCode", kVar.a());
                    a3.putExtra("actionTime", kVar.b());
                    a3.putExtra("dataType", 1001);
                    a(context, a3);
                    return;
                case 3:
                    g gVar = (g) jVar;
                    Intent a4 = a(context);
                    a4.putExtra("time", gVar.a());
                    a4.putExtra("duration", gVar.b());
                    a4.putExtra("activities", gVar.d());
                    a4.putExtra("dataType", 1003);
                    a(context, a4);
                    return;
                case 4:
                    a aVar = (a) jVar;
                    Intent a5 = a(context);
                    a5.putExtra("eventBody", aVar.b());
                    a5.putExtra("eventType", aVar.a());
                    a5.putExtra("dataType", TouchlessA3D.Parameters.EXTENDED_RANGE);
                    a(context, a5);
                    return;
                case 5:
                    f fVar = (f) jVar;
                    Intent a6 = a(context);
                    a6.putExtra("exception", fVar.b());
                    a6.putExtra("count", fVar.d());
                    a6.putExtra("time", fVar.a());
                    a6.putExtra("dataType", 1004);
                    a(context, a6);
                    return;
                case 7:
                    h hVar = (h) jVar;
                    Intent a7 = a(hVar.b(), context);
                    a7.putExtra("loginTime", hVar.a());
                    a7.putExtra("dataType", 1000);
                    a(context, a7);
                    return;
                case 9:
                    d.a("NearMeStatistics", "bean:" + jVar.toString());
                    Intent a8 = a((c) jVar, context);
                    a8.putExtra("dataType", 1006);
                    a(context, a8);
                    return;
                case 10:
                    e eVar = (e) jVar;
                    Intent a9 = a(context);
                    a9.putExtra("eventBody", eVar.b());
                    a9.putExtra("uploadMode", eVar.a());
                    a9.putExtra("dataType", 1007);
                    a(context, a9);
                    return;
                case 11:
                    i iVar = (i) jVar;
                    Intent a10 = a(context);
                    a10.putExtra("eventBody", iVar.b());
                    a10.putExtra("uploadMode", iVar.a());
                    a10.putExtra("dataType", 1008);
                    a(context, a10);
                    return;
                case 12:
                    Intent a11 = a(context);
                    a11.putExtra("dataType", 1009);
                    a11.putExtra(BuildConfig.BUILD_TYPE, ((com.oplus.statistics.dcs.b.d) jVar).a());
                    a(context, a11);
                    return;
                case 13:
                    d.a("NearMeStatistics", "bean:" + jVar.toString());
                    Intent a12 = a((c) jVar, context);
                    if (com.oplus.statistics.dcs.e.e.a(context)) {
                        a12.putExtra("dataType", 1019);
                    } else {
                        a12.putExtra("dataType", 1006);
                    }
                    a(context, a12);
                    return;
                case 14:
                    d.a("NearMeStatistics", "bean:" + jVar.toString());
                    Intent a13 = a((c) jVar, context);
                    if (com.oplus.statistics.dcs.e.e.a(context)) {
                        a13.putExtra("dataType", 1020);
                        a(context, a13);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            d.a(f2709a, (Throwable) e);
        }
        d.a(f2709a, (Throwable) e);
    }

    private static void a(Context context, Intent intent) {
        if (context == null) {
            new Exception("DataSendException: context is null.").printStackTrace();
        } else {
            context.startService(intent);
        }
    }

    private static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
        intent.putExtra("appId", com.oplus.statistics.dcs.e.b.d(context));
        intent.putExtra("appVersion", com.oplus.statistics.dcs.e.b.c(context));
        intent.putExtra("appPackage", com.oplus.statistics.dcs.e.b.a(context));
        intent.putExtra("appName", com.oplus.statistics.dcs.e.b.b(context));
        intent.putExtra("ssoid", com.oplus.statistics.dcs.e.a.a(context));
        intent.putExtra("statSId", c.a().a(context));
        return intent;
    }

    private static Intent a(c cVar, Context context) {
        int i;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
        if (!TextUtils.isEmpty(cVar.i())) {
            try {
                i = Integer.parseInt(cVar.i());
            } catch (NumberFormatException unused) {
                d.c("input appId is NumberFormatException, use appId in manifest.");
                i = com.oplus.statistics.dcs.e.b.d(context);
            }
        } else {
            i = com.oplus.statistics.dcs.e.b.d(context);
        }
        intent.putExtra("appId", i);
        if (TextUtils.isEmpty(cVar.d())) {
            intent.putExtra("appVersion", com.oplus.statistics.dcs.e.b.c(context));
        } else {
            intent.putExtra("appVersion", cVar.d());
        }
        if (TextUtils.isEmpty(cVar.b())) {
            intent.putExtra("appPackage", com.oplus.statistics.dcs.e.b.a(context));
        } else {
            intent.putExtra("appPackage", cVar.b());
        }
        if (TextUtils.isEmpty(cVar.e())) {
            intent.putExtra("appName", com.oplus.statistics.dcs.e.b.b(context));
        } else {
            intent.putExtra("appName", cVar.e());
        }
        intent.putExtra("ssoid", com.oplus.statistics.dcs.e.a.a(context));
        intent.putExtra("uploadNow", cVar.h());
        intent.putExtra("logTag", cVar.f());
        intent.putExtra("eventID", cVar.a());
        intent.putExtra("logMap", cVar.g());
        intent.putExtra("statSId", c.a().a(context));
        return intent;
    }

    private static Intent a(int i, Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
        intent.putExtra("appId", i);
        intent.putExtra("appVersion", com.oplus.statistics.dcs.e.b.c(context));
        intent.putExtra("appPackage", com.oplus.statistics.dcs.e.b.a(context));
        intent.putExtra("appName", com.oplus.statistics.dcs.e.b.b(context));
        intent.putExtra("ssoid", com.oplus.statistics.dcs.e.a.a(context));
        intent.putExtra("statSId", c.a().a(context));
        return intent;
    }
}
