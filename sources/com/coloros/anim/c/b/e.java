package com.coloros.anim.c.b;

import com.coloros.anim.a.a.i;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.c;
import com.coloros.anim.c.a.d;
import com.coloros.anim.c.a.f;
import com.coloros.anim.c.b.p;
import com.coloros.anim.c.c.a;
import java.util.List;

/* compiled from: GradientStroke */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2376a;

    /* renamed from: b  reason: collision with root package name */
    private final f f2377b;
    private final c c;
    private final d d;
    private final f e;
    private final f f;
    private final b g;
    private final p.a h;
    private final p.b i;
    private final float j;
    private final List<b> k;
    private final b l;
    private final boolean m;

    public e(String str, f fVar, c cVar, d dVar, f fVar2, f fVar3, b bVar, p.a aVar, p.b bVar2, float f2, List<b> list, b bVar3, boolean z) {
        this.f2376a = str;
        this.f2377b = fVar;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar2;
        this.f = fVar3;
        this.g = bVar;
        this.h = aVar;
        this.i = bVar2;
        this.j = f2;
        this.k = list;
        this.l = bVar3;
        this.m = z;
    }

    public String a() {
        return this.f2376a;
    }

    public f b() {
        return this.f2377b;
    }

    public c c() {
        return this.c;
    }

    public d d() {
        return this.d;
    }

    public f e() {
        return this.e;
    }

    public f f() {
        return this.f;
    }

    public b g() {
        return this.g;
    }

    public p.a h() {
        return this.h;
    }

    public p.b i() {
        return this.i;
    }

    public List<b> j() {
        return this.k;
    }

    public b k() {
        return this.l;
    }

    public float l() {
        return this.j;
    }

    public boolean m() {
        return this.m;
    }

    public com.coloros.anim.a.a.c a(com.coloros.anim.b bVar, a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("GradientStroke to GradientStrokeContent, layer = " + aVar);
        }
        return new i(bVar, aVar, this);
    }
}
