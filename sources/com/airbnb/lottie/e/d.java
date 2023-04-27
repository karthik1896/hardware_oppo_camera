package com.airbnb.lottie.e;

import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.g;
import com.airbnb.lottie.c.a.j;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g.a;
import java.io.IOException;
import java.util.List;

/* compiled from: AnimatableValueParser */
public class d {
    public static b a(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        return a(cVar, dVar, true);
    }

    public static b a(c cVar, com.airbnb.lottie.d dVar, boolean z) throws IOException {
        return new b(a(cVar, z ? h.a() : 1.0f, dVar, i.f1766a));
    }

    static com.airbnb.lottie.c.a.d b(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.c.a.d(a(cVar, dVar, o.f1775a));
    }

    static f c(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        return new f(a(cVar, h.a(), dVar, y.f1787a));
    }

    static g d(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        return new g((List<a<com.airbnb.lottie.g.d>>) a(cVar, dVar, ac.f1748a));
    }

    static com.airbnb.lottie.c.a.h e(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.c.a.h(a(cVar, h.a(), dVar, ad.f1749a));
    }

    static j f(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        return new j(a(cVar, dVar, h.f1764a));
    }

    static com.airbnb.lottie.c.a.a g(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.c.a.a(a(cVar, dVar, f.f1762a));
    }

    static com.airbnb.lottie.c.a.c a(c cVar, com.airbnb.lottie.d dVar, int i) throws IOException {
        return new com.airbnb.lottie.c.a.c(a(cVar, dVar, new l(i)));
    }

    private static <T> List<a<T>> a(c cVar, com.airbnb.lottie.d dVar, aj<T> ajVar) throws IOException {
        return r.a(cVar, dVar, 1.0f, ajVar);
    }

    private static <T> List<a<T>> a(c cVar, float f, com.airbnb.lottie.d dVar, aj<T> ajVar) throws IOException {
        return r.a(cVar, dVar, f, ajVar);
    }
}
