package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.a;
import java.util.List;

/* compiled from: ColorKeyframeAnimation */
public class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Integer a(a<Integer> aVar, float f) {
        return Integer.valueOf(c(aVar, f));
    }

    public int c(a<Integer> aVar, float f) {
        if (aVar.f1829a == null || aVar.f1830b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) aVar.f1829a).intValue();
        int intValue2 = ((Integer) aVar.f1830b).intValue();
        if (this.c != null) {
            Integer num = (Integer) this.c.a(aVar.d, aVar.e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, d(), h());
            if (num != null) {
                return num.intValue();
            }
        }
        return com.airbnb.lottie.f.b.a(g.b(f, 0.0f, 1.0f), intValue, intValue2);
    }

    public int i() {
        return c(c(), e());
    }
}
