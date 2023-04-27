package com.airbnb.lottie.e;

import com.airbnb.lottie.c.b.b;
import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser */
class af {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f1752a = c.a.a("nm", "hd", "it");

    static n a(c cVar, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (cVar.e()) {
            int a2 = cVar.a(f1752a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                z = cVar.j();
            } else if (a2 != 2) {
                cVar.m();
            } else {
                cVar.a();
                while (cVar.e()) {
                    b a3 = g.a(cVar, dVar);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
                cVar.b();
            }
        }
        return new n(str, arrayList, z);
    }
}
