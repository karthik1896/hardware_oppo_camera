package com.oppo.camera.professional;

import android.content.Context;
import android.os.Handler;
import android.util.Size;
import com.oppo.camera.R;
import com.oppo.camera.e.b;
import com.oppo.camera.f.j;
import com.oppo.camera.professional.g;
import java.util.List;

/* compiled from: NightPanelContainer */
public class d extends g {
    public d(Context context, b bVar) {
        super(context, bVar);
    }

    public void a(j jVar, Handler handler, g.a aVar) {
        long j;
        long j2;
        a(jVar.u(), jVar.v(), jVar.w(), handler);
        if (aVar == null || aVar.f3532a <= 0) {
            j = jVar.x();
        } else {
            j = aVar.f3532a;
        }
        long j3 = j;
        if (aVar == null || aVar.f3533b <= 0) {
            j2 = jVar.y();
        } else {
            j2 = aVar.f3533b;
        }
        a(j3, j2, jVar.a(256), handler);
        a(jVar.B(), handler);
        a(jVar.n(), jVar.m(), handler);
        e();
    }

    /* access modifiers changed from: protected */
    public void a(n nVar, long j, long j2, List<Size> list) {
        nVar.c().clear();
        nVar.f(R.array.night_pro_exposure_time_names);
        super.a(nVar, j, j2, list);
    }
}
