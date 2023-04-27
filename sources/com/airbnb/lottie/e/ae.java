package com.airbnb.lottie.e;

import android.graphics.Path;
import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.b.m;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: ShapeFillParser */
class ae {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f1751a = c.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    static m a(c cVar, d dVar) throws IOException {
        boolean z = false;
        boolean z2 = false;
        int i = 1;
        String str = null;
        a aVar = null;
        com.airbnb.lottie.c.a.d dVar2 = null;
        while (cVar.e()) {
            int a2 = cVar.a(f1751a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                aVar = d.g(cVar, dVar);
            } else if (a2 == 2) {
                dVar2 = d.b(cVar, dVar);
            } else if (a2 == 3) {
                z = cVar.j();
            } else if (a2 == 4) {
                i = cVar.l();
            } else if (a2 != 5) {
                cVar.h();
                cVar.m();
            } else {
                z2 = cVar.j();
            }
        }
        return new m(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2, z2);
    }
}
