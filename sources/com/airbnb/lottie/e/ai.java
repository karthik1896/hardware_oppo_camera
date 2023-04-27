package com.airbnb.lottie.e;

import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser */
class ai {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f1756a = c.a.a("s", "e", "o", "nm", "m", "hd");

    static q a(c cVar, d dVar) throws IOException {
        boolean z = false;
        String str = null;
        q.a aVar = null;
        b bVar = null;
        b bVar2 = null;
        b bVar3 = null;
        while (cVar.e()) {
            int a2 = cVar.a(f1756a);
            if (a2 == 0) {
                bVar = d.a(cVar, dVar, false);
            } else if (a2 == 1) {
                bVar2 = d.a(cVar, dVar, false);
            } else if (a2 == 2) {
                bVar3 = d.a(cVar, dVar, false);
            } else if (a2 == 3) {
                str = cVar.i();
            } else if (a2 == 4) {
                aVar = q.a.forId(cVar.l());
            } else if (a2 != 5) {
                cVar.m();
            } else {
                z = cVar.j();
            }
        }
        return new q(str, aVar, bVar, bVar2, bVar3, z);
    }
}
