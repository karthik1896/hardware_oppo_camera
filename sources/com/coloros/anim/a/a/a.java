package com.coloros.anim.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.c;
import com.coloros.anim.a.b.e;
import com.coloros.anim.a.b.p;
import com.coloros.anim.b;
import com.coloros.anim.c.a.d;
import com.coloros.anim.c.b.q;
import com.coloros.anim.f.f;
import com.coloros.anim.f.g;
import com.coloros.anim.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent */
public abstract class a implements e, k, a.C0061a {

    /* renamed from: a  reason: collision with root package name */
    final Paint f2292a = new com.coloros.anim.a.a(1);

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f2293b = new PathMeasure();
    private final Path c = new Path();
    private final Path d = new Path();
    private final RectF e = new RectF();
    private final b f;
    private final com.coloros.anim.c.c.a g;
    private final List<C0060a> h = new ArrayList();
    private final float[] i;
    private final com.coloros.anim.a.b.a<?, Float> j;
    private final com.coloros.anim.a.b.a<?, Integer> k;
    private final List<com.coloros.anim.a.b.a<?, Float>> l;
    private final com.coloros.anim.a.b.a<?, Float> m;
    private com.coloros.anim.a.b.a<ColorFilter, ColorFilter> n;

    a(b bVar, com.coloros.anim.c.c.a aVar, Paint.Cap cap, Paint.Join join, float f2, d dVar, com.coloros.anim.c.a.b bVar2, List<com.coloros.anim.c.a.b> list, com.coloros.anim.c.a.b bVar3) {
        this.f = bVar;
        this.g = aVar;
        this.f2292a.setStyle(Paint.Style.STROKE);
        this.f2292a.setStrokeCap(cap);
        this.f2292a.setStrokeJoin(join);
        this.f2292a.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar2.a();
        if (bVar3 == null) {
            this.m = null;
        } else {
            this.m = bVar3.a();
        }
        this.l = new ArrayList(list.size());
        this.i = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(list.get(i2).a());
        }
        aVar.a((com.coloros.anim.a.b.a<?, ?>) this.k);
        aVar.a((com.coloros.anim.a.b.a<?, ?>) this.j);
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            aVar.a((com.coloros.anim.a.b.a<?, ?>) this.l.get(i3));
        }
        com.coloros.anim.a.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.a((com.coloros.anim.a.b.a<?, ?>) aVar2);
        }
        this.k.a((a.C0061a) this);
        this.j.a((a.C0061a) this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.get(i4).a((a.C0061a) this);
        }
        com.coloros.anim.a.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a((a.C0061a) this);
        }
    }

    public void a() {
        this.f.invalidateSelf();
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
        C0060a aVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.c() == q.a.INDIVIDUALLY) {
                    if (aVar != null) {
                        this.h.add(aVar);
                    }
                    aVar = new C0060a(sVar3);
                    sVar3.a(this);
                }
            }
            if (cVar2 instanceof m) {
                if (aVar == null) {
                    aVar = new C0060a(sVar);
                }
                aVar.f2294a.add((m) cVar2);
            }
        }
        if (aVar != null) {
            this.h.add(aVar);
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        k.c("StrokeContent#draw");
        this.f2292a.setAlpha(f.a((int) ((((((float) i2) / 255.0f) * ((float) ((e) this.k).i())) / 100.0f) * 255.0f), 0, 255));
        this.f2292a.setStrokeWidth(((c) this.j).i() * g.a(matrix));
        if (this.f2292a.getStrokeWidth() <= 0.0f) {
            k.d("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.coloros.anim.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f2292a.setColorFilter(aVar.g());
        }
        for (int i3 = 0; i3 < this.h.size(); i3++) {
            C0060a aVar2 = this.h.get(i3);
            if (aVar2.f2295b != null) {
                a(canvas, aVar2, matrix);
            } else {
                k.c("StrokeContent#buildPath");
                this.c.reset();
                for (int size = aVar2.f2294a.size() - 1; size >= 0; size--) {
                    this.c.addPath(((m) aVar2.f2294a.get(size)).e(), matrix);
                }
                k.d("StrokeContent#buildPath");
                k.c("StrokeContent#drawPath");
                canvas.drawPath(this.c, this.f2292a);
                k.d("StrokeContent#drawPath");
            }
        }
        k.d("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0060a aVar, Matrix matrix) {
        k.c("StrokeContent#applyTrimPath");
        if (aVar.f2295b == null) {
            k.d("StrokeContent#applyTrimPath");
            return;
        }
        this.c.reset();
        for (int size = aVar.f2294a.size() - 1; size >= 0; size--) {
            this.c.addPath(((m) aVar.f2294a.get(size)).e(), matrix);
        }
        this.f2293b.setPath(this.c, false);
        float length = this.f2293b.getLength();
        while (this.f2293b.nextContour()) {
            length += this.f2293b.getLength();
        }
        float floatValue = (aVar.f2295b.f().g().floatValue() * length) / 360.0f;
        float floatValue2 = ((aVar.f2295b.d().g().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((aVar.f2295b.e().g().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = aVar.f2294a.size() - 1; size2 >= 0; size2--) {
            this.d.set(((m) aVar.f2294a.get(size2)).e());
            this.d.transform(matrix);
            this.f2293b.setPath(this.d, false);
            float length2 = this.f2293b.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                float f4 = floatValue3 - length;
                if (f4 < f2 + length2 && f2 < f4) {
                    g.a(this.d, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f4 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.d, this.f2292a);
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
                    g.a(this.d, f6, f3, 0.0f);
                    canvas.drawPath(this.d, this.f2292a);
                } else {
                    canvas.drawPath(this.d, this.f2292a);
                }
            }
            f2 += length2;
        }
        k.d("StrokeContent#applyTrimPath");
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        k.c("StrokeContent#getBounds");
        this.c.reset();
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            C0060a aVar = this.h.get(i2);
            for (int i3 = 0; i3 < aVar.f2294a.size(); i3++) {
                this.c.addPath(((m) aVar.f2294a.get(i3)).e(), matrix);
            }
        }
        this.c.computeBounds(this.e, false);
        float i4 = ((c) this.j).i();
        RectF rectF2 = this.e;
        float f2 = i4 / 2.0f;
        rectF2.set(rectF2.left - f2, this.e.top - f2, this.e.right + f2, this.e.bottom + f2);
        rectF.set(this.e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        k.d("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        k.c("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            k.d("StrokeContent#applyDashPattern");
            return;
        }
        float a2 = g.a(matrix);
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
        com.coloros.anim.a.b.a<?, Float> aVar = this.m;
        this.f2292a.setPathEffect(new DashPathEffect(this.i, aVar == null ? 0.0f : aVar.g().floatValue()));
        k.d("StrokeContent#applyDashPattern");
    }

    public void a(com.coloros.anim.c.f fVar, int i2, List<com.coloros.anim.c.f> list, com.coloros.anim.c.f fVar2) {
        f.a(fVar, i2, list, fVar2, this);
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        if (t == com.coloros.anim.d.d) {
            this.k.a(bVar);
        } else if (t == com.coloros.anim.d.m) {
            this.j.a(bVar);
        } else if (t != com.coloros.anim.d.z) {
        } else {
            if (bVar == null) {
                this.n = null;
                return;
            }
            this.n = new p(bVar);
            this.n.a((a.C0061a) this);
            this.g.a((com.coloros.anim.a.b.a<?, ?>) this.n);
        }
    }

    /* renamed from: com.coloros.anim.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: BaseStrokeContent */
    private static final class C0060a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<m> f2294a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final s f2295b;

        private C0060a(s sVar) {
            this.f2294a = new ArrayList();
            this.f2295b = sVar;
        }
    }
}
