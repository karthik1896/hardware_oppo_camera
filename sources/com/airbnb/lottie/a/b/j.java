package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.g.a;
import java.util.List;

/* compiled from: PointKeyframeAnimation */
public class j extends f<PointF> {
    private final PointF d = new PointF();

    public j(List<a<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF a(a<PointF> aVar, float f) {
        if (aVar.f1829a == null || aVar.f1830b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) aVar.f1829a;
        PointF pointF2 = (PointF) aVar.f1830b;
        if (this.c != null) {
            PointF pointF3 = (PointF) this.c.a(aVar.d, aVar.e.floatValue(), pointF, pointF2, f, d(), h());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        this.d.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
        return this.d;
    }
}
