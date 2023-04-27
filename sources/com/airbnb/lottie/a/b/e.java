package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation */
public class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Integer a(a<Integer> aVar, float f) {
        return Integer.valueOf(c(aVar, f));
    }

    /* access modifiers changed from: package-private */
    public int c(a<Integer> aVar, float f) {
        if (aVar.f1829a == null || aVar.f1830b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.c != null) {
            Integer num = (Integer) this.c.a(aVar.d, aVar.e.floatValue(), aVar.f1829a, aVar.f1830b, f, d(), h());
            if (num != null) {
                return num.intValue();
            }
        }
        return g.a(aVar.h(), aVar.i(), f);
    }

    public int i() {
        return c(c(), e());
    }
}
