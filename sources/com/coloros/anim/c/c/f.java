package com.coloros.anim.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.d;
import com.coloros.anim.b;
import com.coloros.anim.c.b.n;
import com.coloros.anim.k;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer */
public class f extends a {
    private final d e;

    f(b bVar, d dVar) {
        super(bVar, dVar);
        n nVar = new n("__container", dVar.n(), false);
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("ShapeLayer::shapeGroup = " + nVar.toString());
        }
        this.e = new d(bVar, this, nVar);
        this.e.a((List<c>) Collections.emptyList(), (List<c>) Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i) {
        k.c("ShapeLayer#draw");
        this.e.a(canvas, matrix, i);
        k.d("ShapeLayer#draw");
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.e.a(rectF, this.f2404a, z);
    }

    /* access modifiers changed from: protected */
    public void b(com.coloros.anim.c.f fVar, int i, List<com.coloros.anim.c.f> list, com.coloros.anim.c.f fVar2) {
        this.e.a(fVar, i, list, fVar2);
    }
}
