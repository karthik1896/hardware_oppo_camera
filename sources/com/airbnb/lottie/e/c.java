package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.e;
import com.airbnb.lottie.c.a.g;
import com.airbnb.lottie.c.a.i;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.g.a;
import java.io.IOException;

/* compiled from: AnimatableTransformParser */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f1759a = c.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b  reason: collision with root package name */
    private static c.a f1760b = c.a.a("k");

    public static l a(com.airbnb.lottie.e.a.c cVar, d dVar) throws IOException {
        boolean z;
        com.airbnb.lottie.e.a.c cVar2 = cVar;
        d dVar2 = dVar;
        boolean z2 = false;
        boolean z3 = cVar.f() == c.b.BEGIN_OBJECT;
        if (z3) {
            cVar.c();
        }
        b bVar = null;
        e eVar = null;
        m<PointF, PointF> mVar = null;
        g gVar = null;
        b bVar2 = null;
        b bVar3 = null;
        com.airbnb.lottie.c.a.d dVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        while (cVar.e()) {
            switch (cVar2.a(f1759a)) {
                case 0:
                    boolean z4 = z2;
                    cVar.c();
                    while (cVar.e()) {
                        if (cVar2.a(f1760b) != 0) {
                            cVar.h();
                            cVar.m();
                        } else {
                            eVar = a.a(cVar, dVar);
                        }
                    }
                    cVar.d();
                    z2 = z4;
                    continue;
                case 1:
                    boolean z5 = z2;
                    mVar = a.b(cVar, dVar);
                    continue;
                case 2:
                    boolean z6 = z2;
                    gVar = d.d(cVar, dVar);
                    continue;
                case 3:
                    dVar2.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar3 = d.b(cVar, dVar);
                    continue;
                case 6:
                    bVar4 = d.a(cVar2, dVar2, z2);
                    continue;
                case 7:
                    bVar5 = d.a(cVar2, dVar2, z2);
                    continue;
                case 8:
                    bVar2 = d.a(cVar2, dVar2, z2);
                    continue;
                case 9:
                    bVar3 = d.a(cVar2, dVar2, z2);
                    continue;
                default:
                    boolean z7 = z2;
                    cVar.h();
                    cVar.m();
                    continue;
            }
            b a2 = d.a(cVar2, dVar2, z2);
            if (a2.c().isEmpty()) {
                a aVar = r1;
                a aVar2 = new a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(dVar.g()));
                a2.c().add(aVar);
            } else if (((a) a2.c().get(0)).f1829a == null) {
                z = false;
                a2.c().set(0, new a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(dVar.g())));
                z2 = z;
                bVar = a2;
            }
            z = false;
            z2 = z;
            bVar = a2;
        }
        if (z3) {
            cVar.d();
        }
        e eVar2 = a(eVar) ? null : eVar;
        m<PointF, PointF> mVar2 = a(mVar) ? null : mVar;
        b bVar6 = a(bVar) ? null : bVar;
        if (a(gVar)) {
            gVar = null;
        }
        return new l(eVar2, mVar2, gVar, bVar6, dVar3, bVar4, bVar5, b(bVar2) ? null : bVar2, c(bVar3) ? null : bVar3);
    }

    private static boolean a(e eVar) {
        return eVar == null || (eVar.b() && ((PointF) eVar.c().get(0).f1829a).equals(0.0f, 0.0f));
    }

    private static boolean a(m<PointF, PointF> mVar) {
        if (mVar == null || (!(mVar instanceof i) && mVar.b() && ((PointF) mVar.c().get(0).f1829a).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    private static boolean a(b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((a) bVar.c().get(0)).f1829a).floatValue() == 0.0f);
    }

    private static boolean a(g gVar) {
        return gVar == null || (gVar.b() && ((com.airbnb.lottie.g.d) ((a) gVar.c().get(0)).f1829a).b(1.0f, 1.0f));
    }

    private static boolean b(b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((a) bVar.c().get(0)).f1829a).floatValue() == 0.0f);
    }

    private static boolean c(b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((a) bVar.c().get(0)).f1829a).floatValue() == 0.0f);
    }
}
