package com.coloros.anim.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.coloros.anim.g.c;
import java.util.List;

/* compiled from: PathKeyframeAnimation */
public class i extends f<PointF> {
    private final PointF c = new PointF();
    private final float[] d = new float[2];
    private h e;
    private PathMeasure f = new PathMeasure();

    public i(List<? extends c<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF a(c<PointF> cVar, float f2) {
        h hVar = (h) cVar;
        Path b2 = hVar.b();
        if (b2 == null) {
            return (PointF) cVar.f2479a;
        }
        if (this.f2322b != null) {
            PointF pointF = (PointF) this.f2322b.a(hVar.c, hVar.e.floatValue(), hVar.f2479a, hVar.d, d(), f2, h());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.e != hVar) {
            this.f.setPath(b2, false);
            this.e = hVar;
        }
        PathMeasure pathMeasure = this.f;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.d, (float[]) null);
        PointF pointF2 = this.c;
        float[] fArr = this.d;
        pointF2.set(fArr[0], fArr[1]);
        return this.c;
    }
}
