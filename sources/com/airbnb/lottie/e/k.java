package com.airbnb.lottie.e;

import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: FontParser */
class k {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f1769a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    static com.airbnb.lottie.c.c a(c cVar) throws IOException {
        cVar.c();
        String str = null;
        String str2 = null;
        float f = 0.0f;
        String str3 = null;
        while (cVar.e()) {
            int a2 = cVar.a(f1769a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                str3 = cVar.i();
            } else if (a2 == 2) {
                str2 = cVar.i();
            } else if (a2 != 3) {
                cVar.h();
                cVar.m();
            } else {
                f = (float) cVar.k();
            }
        }
        cVar.d();
        return new com.airbnb.lottie.c.c(str, str3, str2, f);
    }
}
