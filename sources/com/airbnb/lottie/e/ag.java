package com.airbnb.lottie.e;

import com.airbnb.lottie.c.a.h;
import com.airbnb.lottie.c.b.o;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: ShapePathParser */
class ag {

    /* renamed from: a  reason: collision with root package name */
    static c.a f1753a = c.a.a("nm", "ind", "ks", "hd");

    static o a(c cVar, d dVar) throws IOException {
        int i = 0;
        String str = null;
        boolean z = false;
        h hVar = null;
        while (cVar.e()) {
            int a2 = cVar.a(f1753a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                i = cVar.l();
            } else if (a2 == 2) {
                hVar = d.e(cVar, dVar);
            } else if (a2 != 3) {
                cVar.m();
            } else {
                z = cVar.j();
            }
        }
        return new o(str, i, hVar, z);
    }
}
