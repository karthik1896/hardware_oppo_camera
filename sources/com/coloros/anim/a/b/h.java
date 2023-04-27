package com.coloros.anim.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.coloros.anim.a;
import com.coloros.anim.f.g;
import com.coloros.anim.g.c;

/* compiled from: PathKeyframe */
public class h extends c<PointF> {
    private final c<PointF> h;
    private Path i;

    public h(a aVar, c<PointF> cVar) {
        super(aVar, cVar.f2479a, cVar.d, cVar.f2480b, cVar.c, cVar.e);
        this.h = cVar;
        a();
    }

    public void a() {
        boolean z = (this.d == null || this.f2479a == null || !((PointF) this.f2479a).equals(((PointF) this.d).x, ((PointF) this.d).y)) ? false : true;
        if (this.d != null && this.f2479a != null && !z) {
            this.i = g.a((PointF) this.f2479a, (PointF) this.d, this.h.f, this.h.g);
        }
    }

    /* access modifiers changed from: package-private */
    public Path b() {
        return this.i;
    }
}
