package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import java.util.List;

/* compiled from: FloatKeyframeAnimation */
public class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Float a(a<Float> aVar, float f) {
        return Float.valueOf(c(aVar, f));
    }

    /* access modifiers changed from: package-private */
    public float c(a<Float> aVar, float f) {
        if (aVar.f1829a == null || aVar.f1830b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.c != null) {
            Float f2 = (Float) this.c.a(aVar.d, aVar.e.floatValue(), aVar.f1829a, aVar.f1830b, f, d(), h());
            if (f2 != null) {
                return f2.floatValue();
            }
        }
        return g.a(aVar.f(), aVar.g(), f);
    }

    public float i() {
        return c(c(), e());
    }
}
