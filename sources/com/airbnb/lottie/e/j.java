package com.airbnb.lottie.e;

import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.c.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FontCharacterParser */
class j {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f1767a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f1768b = c.a.a("shapes");

    static d a(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        char c = 0;
        while (cVar.e()) {
            int a2 = cVar.a(f1767a);
            if (a2 == 0) {
                c = cVar.i().charAt(0);
            } else if (a2 == 1) {
                d = cVar.k();
            } else if (a2 == 2) {
                d2 = cVar.k();
            } else if (a2 == 3) {
                str = cVar.i();
            } else if (a2 == 4) {
                str2 = cVar.i();
            } else if (a2 != 5) {
                cVar.h();
                cVar.m();
            } else {
                cVar.c();
                while (cVar.e()) {
                    if (cVar.a(f1768b) != 0) {
                        cVar.h();
                        cVar.m();
                    } else {
                        cVar.a();
                        while (cVar.e()) {
                            arrayList.add((n) g.a(cVar, dVar));
                        }
                        cVar.b();
                    }
                }
                cVar.d();
            }
        }
        cVar.d();
        return new d(arrayList, c, d, d2, str, str2);
    }
}
