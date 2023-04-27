package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.g.a;
import java.util.List;

/* compiled from: PathKeyframeAnimation */
public class i extends f<PointF> {
    private final PointF d = new PointF();
    private final float[] e = new float[2];
    private h f;
    private PathMeasure g = new PathMeasure();

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF a(a<PointF> aVar, float f2) {
        h hVar = (h) aVar;
        Path b2 = hVar.b();
        if (b2 == null) {
            return (PointF) aVar.f1829a;
        }
        if (this.c != null) {
            PointF pointF = (PointF) this.c.a(hVar.d, hVar.e.floatValue(), hVar.f1829a, hVar.f1830b, d(), f2, h());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f != hVar) {
            this.g.setPath(b2, false);
            this.f = hVar;
        }
        PathMeasure pathMeasure = this.g;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.e, (float[]) null);
        PointF pointF2 = this.d;
        float[] fArr = this.e;
        pointF2.set(fArr[0], fArr[1]);
        return this.d;
    }
}
