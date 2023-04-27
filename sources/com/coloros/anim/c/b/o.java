package com.coloros.anim.c.b;

import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.q;
import com.coloros.anim.b;
import com.coloros.anim.c.a.h;
import com.coloros.anim.c.c.a;

/* compiled from: ShapePath */
public class o implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2394a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2395b;
    private final h c;
    private final boolean d;

    public o(String str, int i, h hVar, boolean z) {
        this.f2394a = str;
        this.f2395b = i;
        this.c = hVar;
        this.d = z;
    }

    public String a() {
        return this.f2394a;
    }

    public h b() {
        return this.c;
    }

    public c a(b bVar, a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("ShapePath to ShapeContent, layer = " + aVar);
        }
        return new q(bVar, aVar, this);
    }

    public boolean c() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f2394a + ", index=" + this.f2395b + '}';
    }
}
