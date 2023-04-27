package com.coloros.anim.a.b;

import android.graphics.PointF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.g.c;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation */
public class m extends a<PointF, PointF> {
    private final PointF c = new PointF();
    private final a<Float, Float> d;
    private final a<Float, Float> e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.d = aVar;
        this.e = aVar2;
        a(h());
    }

    public void a(float f) {
        this.d.a(f);
        this.e.a(f);
        this.c.set(this.d.g().floatValue(), this.e.g().floatValue());
        for (int i = 0; i < this.f2321a.size(); i++) {
            ((a.C0061a) this.f2321a.get(i)).a();
        }
    }

    /* renamed from: i */
    public PointF g() {
        return a((c<PointF>) null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PointF a(c<PointF> cVar, float f) {
        return this.c;
    }
}
