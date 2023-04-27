package com.airbnb.lottie.c.b;

import android.graphics.Path;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.g;
import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.f;

/* compiled from: ShapeFill */
public class m implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1689a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f1690b;
    private final String c;
    private final a d;
    private final d e;
    private final boolean f;

    public m(String str, boolean z, Path.FillType fillType, a aVar, d dVar, boolean z2) {
        this.c = str;
        this.f1689a = z;
        this.f1690b = fillType;
        this.d = aVar;
        this.e = dVar;
        this.f = z2;
    }

    public String a() {
        return this.c;
    }

    public a b() {
        return this.d;
    }

    public d c() {
        return this.e;
    }

    public Path.FillType d() {
        return this.f1690b;
    }

    public boolean e() {
        return this.f;
    }

    public c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new g(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f1689a + '}';
    }
}
