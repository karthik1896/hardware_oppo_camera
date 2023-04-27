package com.coloros.anim.a.b;

import com.coloros.anim.f.f;
import com.coloros.anim.g.c;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation */
public class e extends f<Integer> {
    public e(List<c<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Integer a(c<Integer> cVar, float f) {
        return Integer.valueOf(c(cVar, f));
    }

    /* access modifiers changed from: package-private */
    public int c(c<Integer> cVar, float f) {
        if (cVar.f2479a == null || cVar.d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f2322b != null) {
            Integer num = (Integer) this.f2322b.a(cVar.c, cVar.e.floatValue(), cVar.f2479a, cVar.d, f, d(), h());
            if (num != null) {
                return num.intValue();
            }
        }
        return f.a(cVar.h(), cVar.i(), f);
    }

    public int i() {
        return c(c(), e());
    }
}
