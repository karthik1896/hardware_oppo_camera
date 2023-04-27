package com.coloros.anim.a.b;

import com.coloros.anim.c.b.c;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation */
public class d extends f<c> {
    private final c c;

    public d(List<com.coloros.anim.g.c<c>> list) {
        super(list);
        int i = 0;
        c cVar = (c) list.get(0).f2479a;
        i = cVar != null ? cVar.c() : i;
        this.c = new c(new float[i], new int[i]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public c a(com.coloros.anim.g.c<c> cVar, float f) {
        this.c.a((c) cVar.f2479a, (c) cVar.d, f);
        return this.c;
    }
}
