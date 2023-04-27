package com.airbnb.lottie.e;

import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f1757a = c.a.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static c.a f1758b = c.a.a("fc", "sc", "sw", "t");

    public static k a(c cVar, d dVar) throws IOException {
        cVar.c();
        k kVar = null;
        while (cVar.e()) {
            if (cVar.a(f1757a) != 0) {
                cVar.h();
                cVar.m();
            } else {
                kVar = b(cVar, dVar);
            }
        }
        cVar.d();
        return kVar == null ? new k((a) null, (a) null, (com.airbnb.lottie.c.a.b) null, (com.airbnb.lottie.c.a.b) null) : kVar;
    }

    private static k b(c cVar, d dVar) throws IOException {
        cVar.c();
        a aVar = null;
        a aVar2 = null;
        com.airbnb.lottie.c.a.b bVar = null;
        com.airbnb.lottie.c.a.b bVar2 = null;
        while (cVar.e()) {
            int a2 = cVar.a(f1758b);
            if (a2 == 0) {
                aVar = d.g(cVar, dVar);
            } else if (a2 == 1) {
                aVar2 = d.g(cVar, dVar);
            } else if (a2 == 2) {
                bVar = d.a(cVar, dVar);
            } else if (a2 != 3) {
                cVar.h();
                cVar.m();
            } else {
                bVar2 = d.a(cVar, dVar);
            }
        }
        cVar.d();
        return new k(aVar, aVar2, bVar, bVar2);
    }
}
