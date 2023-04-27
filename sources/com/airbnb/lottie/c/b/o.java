package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.c.a.h;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;

/* compiled from: ShapePath */
public class o implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1693a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1694b;
    private final h c;
    private final boolean d;

    public o(String str, int i, h hVar, boolean z) {
        this.f1693a = str;
        this.f1694b = i;
        this.c = hVar;
        this.d = z;
    }

    public String a() {
        return this.f1693a;
    }

    public h b() {
        return this.c;
    }

    public c a(f fVar, a aVar) {
        return new q(fVar, aVar, this);
    }

    public boolean c() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f1693a + ", index=" + this.f1694b + '}';
    }
}
