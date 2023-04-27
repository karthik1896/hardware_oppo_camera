package com.airbnb.lottie.e;

import com.airbnb.lottie.c.b.h;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: MergePathsParser */
class v {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f1785a = c.a.a("nm", "mm", "hd");

    static h a(c cVar) throws IOException {
        String str = null;
        boolean z = false;
        h.a aVar = null;
        while (cVar.e()) {
            int a2 = cVar.a(f1785a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                aVar = h.a.forId(cVar.l());
            } else if (a2 != 2) {
                cVar.h();
                cVar.m();
            } else {
                z = cVar.j();
            }
        }
        return new h(str, aVar, z);
    }
}
