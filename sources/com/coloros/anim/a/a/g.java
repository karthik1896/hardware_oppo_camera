package com.coloros.anim.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.p;
import com.coloros.anim.b;
import com.coloros.anim.c.b.m;
import com.coloros.anim.d;
import com.coloros.anim.f.f;
import com.coloros.anim.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent */
public class g implements e, k, a.C0061a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f2301a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f2302b = new com.coloros.anim.a.a(1);
    private final com.coloros.anim.c.c.a c;
    private final String d;
    private final boolean e;
    private final List<m> f = new ArrayList();
    private final a<Integer, Integer> g;
    private final a<Integer, Integer> h;
    private final b i;
    private a<ColorFilter, ColorFilter> j;

    public g(b bVar, com.coloros.anim.c.c.a aVar, m mVar) {
        this.c = aVar;
        this.d = mVar.a();
        this.e = mVar.e();
        this.i = bVar;
        if (mVar.b() == null || mVar.c() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        this.f2301a.setFillType(mVar.d());
        this.g = mVar.b().a();
        this.g.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.g);
        this.h = mVar.c().a();
        this.h.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.h);
    }

    public void a() {
        this.i.invalidateSelf();
    }

    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f.add((m) cVar);
            }
        }
    }

    public String b() {
        return this.d;
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (!this.e) {
            k.c("FillContent#draw");
            this.f2302b.setColor(((com.coloros.anim.a.b.b) this.g).i());
            this.f2302b.setAlpha(f.a((int) ((((((float) i2) / 255.0f) * ((float) this.h.g().intValue())) / 100.0f) * 255.0f), 0, 255));
            a<ColorFilter, ColorFilter> aVar = this.j;
            if (aVar != null) {
                this.f2302b.setColorFilter(aVar.g());
            }
            this.f2301a.reset();
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                this.f2301a.addPath(this.f.get(i3).e(), matrix);
            }
            canvas.drawPath(this.f2301a, this.f2302b);
            k.d("FillContent#draw");
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f2301a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.f2301a.addPath(this.f.get(i2).e(), matrix);
        }
        this.f2301a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void a(com.coloros.anim.c.f fVar, int i2, List<com.coloros.anim.c.f> list, com.coloros.anim.c.f fVar2) {
        f.a(fVar, i2, list, fVar2, this);
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        if (t == d.f2426a) {
            this.g.a(bVar);
        } else if (t == d.d) {
            this.h.a(bVar);
        } else if (t != d.z) {
        } else {
            if (bVar == null) {
                this.j = null;
                return;
            }
            this.j = new p(bVar);
            this.j.a((a.C0061a) this);
            this.c.a((a<?, ?>) this.j);
        }
    }
}
