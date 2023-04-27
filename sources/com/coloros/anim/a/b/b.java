package com.coloros.anim.a.b;

import com.coloros.anim.f.d;
import com.coloros.anim.f.f;
import com.coloros.anim.g.c;
import java.util.List;

/* compiled from: ColorKeyframeAnimation */
public class b extends f<Integer> {
    public b(List<c<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Integer a(c<Integer> cVar, float f) {
        return Integer.valueOf(c(cVar, f));
    }

    public int c(c<Integer> cVar, float f) {
        if (cVar.f2479a == null || cVar.d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) cVar.f2479a).intValue();
        int intValue2 = ((Integer) cVar.d).intValue();
        if (this.f2322b != null) {
            Integer num = (Integer) this.f2322b.a(cVar.c, cVar.e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, d(), h());
            if (num != null) {
                return num.intValue();
            }
        }
        return d.a(f.b(f, 0.0f, 1.0f), intValue, intValue2);
    }

    public int i() {
        return c(c(), e());
    }
}
