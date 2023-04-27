package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.e;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent */
public abstract class a implements e, k, a.C0053a {

    /* renamed from: a  reason: collision with root package name */
    protected final com.airbnb.lottie.c.c.a f1614a;

    /* renamed from: b  reason: collision with root package name */
    final Paint f1615b = new com.airbnb.lottie.a.a(1);
    private final PathMeasure c = new PathMeasure();
    private final Path d = new Path();
    private final Path e = new Path();
    private final RectF f = new RectF();
    private final f g;
    private final List<C0052a> h = new ArrayList();
    private final float[] i;
    private final com.airbnb.lottie.a.b.a<?, Float> j;
    private final com.airbnb.lottie.a.b.a<?, Integer> k;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> l;
    private final com.airbnb.lottie.a.b.a<?, Float> m;
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> n;

    a(f fVar, com.airbnb.lottie.c.c.a aVar, Paint.Cap cap, Paint.Join join, float f2, d dVar, b bVar, List<b> list, b bVar2) {
        this.g = fVar;
        this.f1614a = aVar;
        this.f1615b.setStyle(Paint.Style.STROKE);
        this.f1615b.setStrokeCap(cap);
        this.f1615b.setStrokeJoin(join);
        this.f1615b.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.l = new ArrayList(list.size());
        this.i = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(list.get(i2).a());
        }
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.k);
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.j);
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.l.get(i3));
        }
        com.airbnb.lottie.a.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.a((com.airbnb.lottie.a.b.a<?, ?>) aVar2);
        }
        this.k.a((a.C0053a) this);
        this.j.a((a.C0053a) this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.get(i4).a((a.C0053a) this);
        }
        com.airbnb.lottie.a.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a((a.C0053a) this);
        }
    }

    public void a() {
        this.g.invalidateSelf();
    }

    public void a(List<c> list, List<c> list2) {
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.c() == q.a.INDIVIDUALLY) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.a(this);
        }
        C0052a aVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.c() == q.a.INDIVIDUALLY) {
                    if (aVar != null) {
                        this.h.add(aVar);
                    }
                    aVar = new C0052a(sVar3);
                    sVar3.a(this);
                }
            }
            if (cVar2 instanceof m) {
                if (aVar == null) {
                    aVar = new C0052a(sVar);
                }
                aVar.f1616a.add((m) cVar2);
            }
        }
        if (aVar != null) {
            this.h.add(aVar);
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        c.a("StrokeContent#draw");
        if (h.b(matrix)) {
            c.b("StrokeContent#draw");
            return;
        }
        this.f1615b.setAlpha(g.a((int) ((((((float) i2) / 255.0f) * ((float) ((e) this.k).i())) / 100.0f) * 255.0f), 0, 255));
        this.f1615b.setStrokeWidth(((com.airbnb.lottie.a.b.c) this.j).i() * h.a(matrix));
        if (this.f1615b.getStrokeWidth() <= 0.0f) {
            c.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f1615b.setColorFilter(aVar.g());
        }
        for (int i3 = 0; i3 < this.h.size(); i3++) {
            C0052a aVar2 = this.h.get(i3);
            if (aVar2.f1617b != null) {
                a(canvas, aVar2, matrix);
            } else {
                c.a("StrokeContent#buildPath");
                this.d.reset();
                for (int size = aVar2.f1616a.size() - 1; size >= 0; size--) {
                    this.d.addPath(((m) aVar2.f1616a.get(size)).e(), matrix);
                }
                c.b("StrokeContent#buildPath");
                c.a("StrokeContent#drawPath");
                canvas.drawPath(this.d, this.f1615b);
                c.b("StrokeContent#drawPath");
            }
        }
        c.b("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0052a aVar, Matrix matrix) {
        c.a("StrokeContent#applyTrimPath");
        if (aVar.f1617b == null) {
            c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.d.reset();
        for (int size = aVar.f1616a.size() - 1; size >= 0; size--) {
            this.d.addPath(((m) aVar.f1616a.get(size)).e(), matrix);
        }
        this.c.setPath(this.d, false);
        float length = this.c.getLength();
        while (this.c.nextContour()) {
            length += this.c.getLength();
        }
        float floatValue = (aVar.f1617b.f().g().floatValue() * length) / 360.0f;
        float floatValue2 = ((aVar.f1617b.d().g().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((aVar.f1617b.e().g().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = aVar.f1616a.size() - 1; size2 >= 0; size2--) {
            this.e.set(((m) aVar.f1616a.get(size2)).e());
            this.e.transform(matrix);
            this.c.setPath(this.e, false);
            float length2 = this.c.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                float f4 = floatValue3 - length;
                if (f4 < f2 + length2 && f2 < f4) {
                    h.a(this.e, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f4 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.e, this.f1615b);
                    f2 += length2;
                }
            }
            float f5 = f2 + length2;
            if (f5 >= floatValue2 && f2 <= floatValue3) {
                if (f5 > floatValue3 || floatValue2 >= f2) {
                    float f6 = floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2;
                    if (floatValue3 <= f5) {
                        f3 = (floatValue3 - f2) / length2;
                    }
                    h.a(this.e, f6, f3, 0.0f);
                    canvas.drawPath(this.e, this.f1615b);
                } else {
                    canvas.drawPath(this.e, this.f1615b);
                }
            }
            f2 += length2;
        }
        c.b("StrokeContent#applyTrimPath");
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        c.a("StrokeContent#getBounds");
        this.d.reset();
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            C0052a aVar = this.h.get(i2);
            for (int i3 = 0; i3 < aVar.f1616a.size(); i3++) {
                this.d.addPath(((m) aVar.f1616a.get(i3)).e(), matrix);
            }
        }
        this.d.computeBounds(this.f, false);
        float i4 = ((com.airbnb.lottie.a.b.c) this.j).i();
        RectF rectF2 = this.f;
        float f2 = i4 / 2.0f;
        rectF2.set(rectF2.left - f2, this.f.top - f2, this.f.right + f2, this.f.bottom + f2);
        rectF.set(this.f);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        c.b("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        c.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            c.b("StrokeContent#applyDashPattern");
            return;
        }
        float a2 = h.a(matrix);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            this.i[i2] = ((Float) this.l.get(i2).g()).floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.i;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.i;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.i;
            fArr3[i2] = fArr3[i2] * a2;
        }
        com.airbnb.lottie.a.b.a<?, Float> aVar = this.m;
        this.f1615b.setPathEffect(new DashPathEffect(this.i, aVar == null ? 0.0f : a2 * aVar.g().floatValue()));
        c.b("StrokeContent#applyDashPattern");
    }

    public void a(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == k.d) {
            this.k.a(cVar);
        } else if (t == k.o) {
            this.j.a(cVar);
        } else if (t == k.C) {
            com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f1614a.b((com.airbnb.lottie.a.b.a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.n = null;
                return;
            }
            this.n = new p(cVar);
            this.n.a((a.C0053a) this);
            this.f1614a.a((com.airbnb.lottie.a.b.a<?, ?>) this.n);
        }
    }

    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: BaseStrokeContent */
    private static final class C0052a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<m> f1616a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final s f1617b;

        private C0052a(s sVar) {
            this.f1616a = new ArrayList();
            this.f1617b = sVar;
        }
    }
}
