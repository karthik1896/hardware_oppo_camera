package com.coloros.anim.a.b;

import com.coloros.anim.f.f;
import java.util.List;

/* compiled from: FloatKeyframeAnimation */
public class c extends f<Float> {
    public c(List<com.coloros.anim.g.c<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Float a(com.coloros.anim.g.c<Float> cVar, float f) {
        return Float.valueOf(c(cVar, f));
    }

    /* access modifiers changed from: package-private */
    public float c(com.coloros.anim.g.c<Float> cVar, float f) {
        if (cVar.f2479a == null || cVar.d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f2322b != null) {
            Float f2 = (Float) this.f2322b.a(cVar.c, cVar.e.floatValue(), cVar.f2479a, cVar.d, f, d(), h());
            if (f2 != null) {
                return f2.floatValue();
            }
        }
        return f.a(cVar.f(), cVar.g(), f);
    }

    public float i() {
        return c(c(), e());
    }
}
