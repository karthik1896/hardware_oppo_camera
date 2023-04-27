package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import com.airbnb.lottie.g.d;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation */
public class k extends f<d> {
    private final d d = new d();

    public k(List<a<d>> list) {
        super(list);
    }

    /* renamed from: b */
    public d a(a<d> aVar, float f) {
        if (aVar.f1829a == null || aVar.f1830b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar = (d) aVar.f1829a;
        d dVar2 = (d) aVar.f1830b;
        if (this.c != null) {
            d dVar3 = (d) this.c.a(aVar.d, aVar.e.floatValue(), dVar, dVar2, f, d(), h());
            if (dVar3 != null) {
                return dVar3;
            }
        }
        this.d.a(g.a(dVar.a(), dVar2.a(), f), g.a(dVar.b(), dVar2.b(), f));
        return this.d;
    }
}
