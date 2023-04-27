package com.airbnb.lottie.e;

import android.graphics.Path;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.b.d;
import com.airbnb.lottie.c.b.f;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: GradientFillParser */
class m {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f1771a = c.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f1772b = c.a.a("p", "k");

    static d a(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        f fVar = null;
        com.airbnb.lottie.c.a.c cVar2 = null;
        com.airbnb.lottie.c.a.d dVar2 = null;
        com.airbnb.lottie.c.a.f fVar2 = null;
        com.airbnb.lottie.c.a.f fVar3 = null;
        boolean z = false;
        while (cVar.e()) {
            switch (cVar.a(f1771a)) {
                case 0:
                    str = cVar.i();
                    break;
                case 1:
                    int i = -1;
                    cVar.c();
                    while (cVar.e()) {
                        int a2 = cVar.a(f1772b);
                        if (a2 == 0) {
                            i = cVar.l();
                        } else if (a2 != 1) {
                            cVar.h();
                            cVar.m();
                        } else {
                            cVar2 = d.a(cVar, dVar, i);
                        }
                    }
                    cVar.d();
                    break;
                case 2:
                    dVar2 = d.b(cVar, dVar);
                    break;
                case 3:
                    fVar = cVar.l() == 1 ? f.LINEAR : f.RADIAL;
                    break;
                case 4:
                    fVar2 = d.c(cVar, dVar);
                    break;
                case 5:
                    fVar3 = d.c(cVar, dVar);
                    break;
                case 6:
                    fillType = cVar.l() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        return new d(str, fVar, fillType, cVar2, dVar2, fVar2, fVar3, (b) null, (b) null, z);
    }
}
