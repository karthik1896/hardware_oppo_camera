package com.coloros.anim.c.b;

import android.graphics.Path;
import com.coloros.anim.a.a.h;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.c;
import com.coloros.anim.c.a.f;
import com.coloros.anim.c.c.a;

/* compiled from: GradientFill */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private final f f2374a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f2375b;
    private final c c;
    private final com.coloros.anim.c.a.d d;
    private final f e;
    private final f f;
    private final String g;
    private final b h;
    private final b i;
    private final boolean j;

    public d(String str, f fVar, Path.FillType fillType, c cVar, com.coloros.anim.c.a.d dVar, f fVar2, f fVar3, b bVar, b bVar2, boolean z) {
        this.f2374a = fVar;
        this.f2375b = fillType;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar2;
        this.f = fVar3;
        this.g = str;
        this.h = bVar;
        this.i = bVar2;
        this.j = z;
    }

    public String a() {
        return this.g;
    }

    public f b() {
        return this.f2374a;
    }

    public Path.FillType c() {
        return this.f2375b;
    }

    public c d() {
        return this.c;
    }

    public com.coloros.anim.c.a.d e() {
        return this.d;
    }

    public f f() {
        return this.e;
    }

    public f g() {
        return this.f;
    }

    public boolean h() {
        return this.j;
    }

    public com.coloros.anim.a.a.c a(com.coloros.anim.b bVar, a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("GradientFill to GradientFillContent, layer = " + aVar);
        }
        return new h(bVar, aVar, this);
    }
}
