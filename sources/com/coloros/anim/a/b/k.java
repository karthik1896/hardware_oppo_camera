package com.coloros.anim.a.b;

import com.coloros.anim.f.f;
import com.coloros.anim.g.c;
import com.coloros.anim.g.d;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation */
public class k extends f<d> {
    private final d c = new d();

    public k(List<c<d>> list) {
        super(list);
    }

    /* renamed from: b */
    public d a(c<d> cVar, float f) {
        if (cVar.f2479a == null || cVar.d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar = (d) cVar.f2479a;
        d dVar2 = (d) cVar.d;
        if (this.f2322b != null) {
            d dVar3 = (d) this.f2322b.a(cVar.c, cVar.e.floatValue(), dVar, dVar2, f, d(), h());
            if (dVar3 != null) {
                return dVar3;
            }
        }
        this.c.a(f.a(dVar.a(), dVar2.a(), f), f.a(dVar.b(), dVar2.b(), f));
        return this.c;
    }
}
