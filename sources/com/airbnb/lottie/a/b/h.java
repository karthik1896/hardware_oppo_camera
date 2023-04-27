package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g.a;

/* compiled from: PathKeyframe */
public class h extends a<PointF> {
    private Path h;
    private final a<PointF> i;

    public h(d dVar, a<PointF> aVar) {
        super(dVar, aVar.f1829a, aVar.f1830b, aVar.c, aVar.d, aVar.e);
        this.i = aVar;
        a();
    }

    public void a() {
        boolean z = (this.f1830b == null || this.f1829a == null || !((PointF) this.f1829a).equals(((PointF) this.f1830b).x, ((PointF) this.f1830b).y)) ? false : true;
        if (this.f1830b != null && !z) {
            this.h = com.airbnb.lottie.f.h.a((PointF) this.f1829a, (PointF) this.f1830b, this.i.f, this.i.g);
        }
    }

    /* access modifiers changed from: package-private */
    public Path b() {
        return this.h;
    }
}
