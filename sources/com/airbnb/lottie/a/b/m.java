package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation */
public class m extends a<PointF, PointF> {
    private final PointF d = new PointF();
    private final a<Float, Float> e;
    private final a<Float, Float> f;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.e = aVar;
        this.f = aVar2;
        a(h());
    }

    public void a(float f2) {
        this.e.a(f2);
        this.f.a(f2);
        this.d.set(this.e.g().floatValue(), this.f.g().floatValue());
        for (int i = 0; i < this.f1641a.size(); i++) {
            ((a.C0053a) this.f1641a.get(i)).a();
        }
    }

    /* renamed from: i */
    public PointF g() {
        return a((com.airbnb.lottie.g.a<PointF>) null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PointF a(com.airbnb.lottie.g.a<PointF> aVar, float f2) {
        return this.d;
    }
}
