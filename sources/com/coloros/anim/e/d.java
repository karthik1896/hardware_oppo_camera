package com.coloros.anim.e;

import android.util.JsonReader;
import com.coloros.anim.a;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.f;
import com.coloros.anim.c.a.h;
import com.coloros.anim.c.a.j;
import com.coloros.anim.f.g;
import com.coloros.anim.g.c;
import java.io.IOException;
import java.util.List;

/* compiled from: AnimatableValueParser */
public class d {
    public static b a(JsonReader jsonReader, a aVar) throws IOException {
        return a(jsonReader, aVar, true);
    }

    public static b a(JsonReader jsonReader, a aVar, boolean z) throws IOException {
        return new b(a(jsonReader, z ? g.a() : 1.0f, aVar, j.f2438a));
    }

    static com.coloros.anim.c.a.d b(JsonReader jsonReader, a aVar) throws IOException {
        return new com.coloros.anim.c.a.d(a(jsonReader, aVar, p.f2440a));
    }

    static f c(JsonReader jsonReader, a aVar) throws IOException {
        return new f(a(jsonReader, g.a(), aVar, y.f2445a));
    }

    static com.coloros.anim.c.a.g d(JsonReader jsonReader, a aVar) throws IOException {
        return new com.coloros.anim.c.a.g((List<c<com.coloros.anim.g.d>>) a(jsonReader, aVar, ac.f2434a));
    }

    static h e(JsonReader jsonReader, a aVar) throws IOException {
        return new h(a(jsonReader, g.a(), aVar, ad.f2435a));
    }

    static j f(JsonReader jsonReader, a aVar) throws IOException {
        return new j(a(jsonReader, aVar, h.f2437a));
    }

    static com.coloros.anim.c.a.a g(JsonReader jsonReader, a aVar) throws IOException {
        return new com.coloros.anim.c.a.a(a(jsonReader, aVar, f.f2436a));
    }

    static com.coloros.anim.c.a.c a(JsonReader jsonReader, a aVar, int i) throws IOException {
        return new com.coloros.anim.c.a.c(a(jsonReader, aVar, new m(i)));
    }

    private static <T> List<c<T>> a(JsonReader jsonReader, a aVar, aj<T> ajVar) throws IOException {
        return s.a(jsonReader, aVar, 1.0f, ajVar);
    }

    private static <T> List<c<T>> a(JsonReader jsonReader, float f, a aVar, aj<T> ajVar) throws IOException {
        return s.a(jsonReader, aVar, f, ajVar);
    }
}
