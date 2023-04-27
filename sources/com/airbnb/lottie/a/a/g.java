package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.b.m;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent */
public class g implements e, k, a.C0053a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f1623a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1624b = new com.airbnb.lottie.a.a(1);
    private final com.airbnb.lottie.c.c.a c;
    private final String d;
    private final boolean e;
    private final List<m> f = new ArrayList();
    private final a<Integer, Integer> g;
    private final a<Integer, Integer> h;
    private a<ColorFilter, ColorFilter> i;
    private final f j;

    public g(f fVar, com.airbnb.lottie.c.c.a aVar, m mVar) {
        this.c = aVar;
        this.d = mVar.a();
        this.e = mVar.e();
        this.j = fVar;
        if (mVar.b() == null || mVar.c() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        this.f1623a.setFillType(mVar.d());
        this.g = mVar.b().a();
        this.g.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.g);
        this.h = mVar.c().a();
        this.h.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.h);
    }

    public void a() {
        this.j.invalidateSelf();
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
            c.a("FillContent#draw");
            this.f1624b.setColor(((b) this.g).i());
            this.f1624b.setAlpha(com.airbnb.lottie.f.g.a((int) ((((((float) i2) / 255.0f) * ((float) this.h.g().intValue())) / 100.0f) * 255.0f), 0, 255));
            a<ColorFilter, ColorFilter> aVar = this.i;
            if (aVar != null) {
                this.f1624b.setColorFilter(aVar.g());
            }
            this.f1623a.reset();
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                this.f1623a.addPath(this.f.get(i3).e(), matrix);
            }
            canvas.drawPath(this.f1623a, this.f1624b);
            c.b("FillContent#draw");
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f1623a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.f1623a.addPath(this.f.get(i2).e(), matrix);
        }
        this.f1623a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void a(e eVar, int i2, List<e> list, e eVar2) {
        com.airbnb.lottie.f.g.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == k.f1837a) {
            this.g.a(cVar);
        } else if (t == k.d) {
            this.h.a(cVar);
        } else if (t == k.C) {
            a<ColorFilter, ColorFilter> aVar = this.i;
            if (aVar != null) {
                this.c.b((a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.i = null;
                return;
            }
            this.i = new p(cVar);
            this.i.a((a.C0053a) this);
            this.c.a((a<?, ?>) this.i);
        }
    }
}
