package com.coloros.anim.a.b;

import android.graphics.PointF;
import com.coloros.anim.g.c;
import java.util.List;

/* compiled from: PointKeyframeAnimation */
public class j extends f<PointF> {
    private final PointF c = new PointF();

    public j(List<c<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF a(c<PointF> cVar, float f) {
        if (cVar.f2479a == null || cVar.d == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) cVar.f2479a;
        PointF pointF2 = (PointF) cVar.d;
        if (this.f2322b != null) {
            PointF pointF3 = (PointF) this.f2322b.a(cVar.c, cVar.e.floatValue(), pointF, pointF2, f, d(), h());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        this.c.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
        return this.c;
    }
}
