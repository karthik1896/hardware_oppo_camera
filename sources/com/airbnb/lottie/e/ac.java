package com.airbnb.lottie.e;

import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.g.d;
import java.io.IOException;

/* compiled from: ScaleXYParser */
public class ac implements aj<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final ac f1748a = new ac();

    private ac() {
    }

    /* renamed from: a */
    public d b(c cVar, float f) throws IOException {
        boolean z = cVar.f() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.a();
        }
        float k = (float) cVar.k();
        float k2 = (float) cVar.k();
        while (cVar.e()) {
            cVar.m();
        }
        if (z) {
            cVar.b();
        }
        return new d((k / 100.0f) * f, (k2 / 100.0f) * f);
    }
}
