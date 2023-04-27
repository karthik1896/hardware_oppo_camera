package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.d;
import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.c.e;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer */
public class f extends a {
    private final d e;

    f(com.airbnb.lottie.f fVar, d dVar) {
        super(fVar, dVar);
        this.e = new d(fVar, this, new n("__container", dVar.n(), false));
        this.e.a((List<c>) Collections.emptyList(), (List<c>) Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i) {
        this.e.a(canvas, matrix, i);
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.e.a(rectF, this.f1703a, z);
    }

    /* access modifiers changed from: protected */
    public void b(e eVar, int i, List<e> list, e eVar2) {
        this.e.a(eVar, i, list, eVar2);
    }
}
