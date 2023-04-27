package com.coloros.statistics.dcs.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.coloros.statistics.dcs.b.a;
import com.coloros.statistics.dcs.b.c;
import com.coloros.statistics.dcs.b.e;
import com.coloros.statistics.dcs.b.f;
import com.coloros.statistics.dcs.b.g;
import com.coloros.statistics.dcs.b.k;
import com.coloros.statistics.dcs.b.l;
import com.coloros.statistics.dcs.b.m;
import com.coloros.statistics.dcs.b.n;
import com.coloros.statistics.dcs.e.d;
import com.crunchfish.touchless_a3d.TouchlessA3D;
import com.oppo.camera.aps.BuildConfig;

/* compiled from: RecordHandler */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2551a = "b";

    public static void a(Context context, m mVar) {
        if (mVar == null || context == null) {
            d.a("RecordHandler add Task error -- bean or context is null--" + mVar + "," + context);
            return;
        }
        try {
            switch (mVar.c()) {
                case 1:
                    Intent a2 = a(context);
                    a2.putExtra("loginTime", ((com.coloros.statistics.dcs.b.b) mVar).a());
                    a2.putExtra("dataType", 1000);
                    a(context, a2);
                    return;
                case 2:
                    n nVar = (n) mVar;
                    Intent a3 = a(context);
                    a3.putExtra("actionAmount", nVar.d());
                    a3.putExtra("actionCode", nVar.a());
                    a3.putExtra("actionTime", nVar.b());
                    a3.putExtra("dataType", 1001);
                    a(context, a3);
                    return;
                case 3:
                    g gVar = (g) mVar;
                    Intent a4 = a(context);
                    a4.putExtra("time", gVar.a());
                    a4.putExtra("duration", gVar.b());
                    a4.putExtra("activities", gVar.d());
                    a4.putExtra("dataType", 1003);
                    a(context, a4);
                    return;
                case 4:
                    a aVar = (a) mVar;
                    Intent a5 = a(context);
                    a5.putExtra("eventBody", aVar.b());
                    a5.putExtra("eventType", aVar.a());
                    a5.putExtra("dataType", TouchlessA3D.Parameters.EXTENDED_RANGE);
                    a(context, a5);
                    return;
                case 5:
                    f fVar = (f) mVar;
                    Intent a6 = a(context);
                    a6.putExtra("exception", fVar.b());
                    a6.putExtra("count", fVar.d());
                    a6.putExtra("time", fVar.a());
                    a6.putExtra("dataType", 1004);
                    a(context, a6);
                    return;
                case 7:
                    k kVar = (k) mVar;
                    Intent a7 = a(kVar.b(), context);
                    a7.putExtra("loginTime", kVar.a());
                    a7.putExtra("dataType", 1000);
                    a(context, a7);
                    return;
                case 9:
                    d.a("NearMeStatistics", "bean:" + mVar.toString());
                    Intent a8 = a((c) mVar, context);
                    a8.putExtra("dataType", 1006);
                    a(context, a8);
                    return;
                case 10:
                    e eVar = (e) mVar;
                    Intent a9 = a(context);
                    a9.putExtra("eventBody", eVar.b());
                    a9.putExtra("uploadMode", eVar.a());
                    a9.putExtra("dataType", 1007);
                    a(context, a9);
                    return;
                case 11:
                    l lVar = (l) mVar;
                    Intent a10 = a(context);
                    a10.putExtra("eventBody", lVar.b());
                    a10.putExtra("uploadMode", lVar.a());
                    a10.putExtra("dataType", 1008);
                    a(context, a10);
                    return;
                case 12:
                    Intent a11 = a(context);
                    a11.putExtra("dataType", 1009);
                    a11.putExtra(BuildConfig.BUILD_TYPE, ((com.coloros.statistics.dcs.b.d) mVar).a());
                    a(context, a11);
                    return;
                case 13:
                    d.a("NearMeStatistics", "bean:" + mVar.toString());
                    Intent a12 = a((c) mVar, context);
                    if (com.coloros.statistics.dcs.e.f.a(context)) {
                        a12.putExtra("dataType", 1019);
                    } else {
                        a12.putExtra("dataType", 1006);
                    }
                    a(context, a12);
                    return;
                case 14:
                    d.a("NearMeStatistics", "bean:" + mVar.toString());
                    Intent a13 = a((c) mVar, context);
                    if (com.coloros.statistics.dcs.e.f.a(context)) {
                        a13.putExtra("dataType", 1020);
                        a(context, a13);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            d.a(f2551a, (Throwable) e);
        }
        d.a(f2551a, (Throwable) e);
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
        intent.putExtra("appId", com.coloros.statistics.dcs.e.b.d(context));
        intent.putExtra("appVersion", com.coloros.statistics.dcs.e.b.c(context));
        intent.putExtra("appPackage", com.coloros.statistics.dcs.e.b.a(context));
        intent.putExtra("appName", com.coloros.statistics.dcs.e.b.b(context));
        intent.putExtra("ssoid", com.coloros.statistics.dcs.e.a.a(context));
        intent.putExtra("statSId", c.a().a(context));
        return intent;
    }

    private static Intent a(c cVar, Context context) {
        int i;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
        if (!TextUtils.isEmpty(cVar.i())) {
            try {
                i = Integer.valueOf(cVar.i()).intValue();
            } catch (NumberFormatException unused) {
                d.c("input appId is NumberFormatException, use appId in manifest.");
                i = com.coloros.statistics.dcs.e.b.d(context);
            }
        } else {
            i = com.coloros.statistics.dcs.e.b.d(context);
        }
        intent.putExtra("appId", i);
        if (TextUtils.isEmpty(cVar.d())) {
            intent.putExtra("appVersion", com.coloros.statistics.dcs.e.b.c(context));
        } else {
            intent.putExtra("appVersion", cVar.d());
        }
        if (TextUtils.isEmpty(cVar.b())) {
            intent.putExtra("appPackage", com.coloros.statistics.dcs.e.b.a(context));
        } else {
            intent.putExtra("appPackage", cVar.b());
        }
        if (TextUtils.isEmpty(cVar.e())) {
            intent.putExtra("appName", com.coloros.statistics.dcs.e.b.b(context));
        } else {
            intent.putExtra("appName", cVar.e());
        }
        intent.putExtra("ssoid", com.coloros.statistics.dcs.e.a.a(context));
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
        intent.putExtra("appVersion", com.coloros.statistics.dcs.e.b.c(context));
        intent.putExtra("appPackage", com.coloros.statistics.dcs.e.b.a(context));
        intent.putExtra("appName", com.coloros.statistics.dcs.e.b.b(context));
        intent.putExtra("ssoid", com.coloros.statistics.dcs.e.a.a(context));
        intent.putExtra("statSId", c.a().a(context));
        return intent;
    }
}
