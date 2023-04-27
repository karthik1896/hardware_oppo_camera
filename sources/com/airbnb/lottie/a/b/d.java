package com.airbnb.lottie.a.b;

import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.g.a;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation */
public class d extends f<c> {
    private final c d;

    public d(List<a<c>> list) {
        super(list);
        int i = 0;
        c cVar = (c) list.get(0).f1829a;
        i = cVar != null ? cVar.c() : i;
        this.d = new c(new float[i], new int[i]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public c a(a<c> aVar, float f) {
        this.d.a((c) aVar.f1829a, (c) aVar.f1830b, f);
        return this.d;
    }
}
