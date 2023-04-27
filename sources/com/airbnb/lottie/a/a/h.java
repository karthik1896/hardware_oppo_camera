package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.c.b.d;
import com.airbnb.lottie.c.b.f;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent */
public class h implements e, k, a.C0053a {

    /* renamed from: a  reason: collision with root package name */
    private final String f1625a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1626b;
    private final com.airbnb.lottie.c.c.a c;
    private final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    private final Path f = new Path();
    private final Paint g = new com.airbnb.lottie.a.a(1);
    private final RectF h = new RectF();
    private final List<m> i = new ArrayList();
    private final f j;
    private final a<c, c> k;
    private final a<Integer, Integer> l;
    private final a<PointF, PointF> m;
    private final a<PointF, PointF> n;
    private a<ColorFilter, ColorFilter> o;
    private p p;
    private final com.airbnb.lottie.f q;
    private final int r;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, d dVar) {
        this.c = aVar;
        this.f1625a = dVar.a();
        this.f1626b = dVar.h();
        this.q = fVar;
        this.j = dVar.b();
        this.f.setFillType(dVar.c());
        this.r = (int) (fVar.s().e() / 32.0f);
        this.k = dVar.d().a();
        this.k.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.k);
        this.l = dVar.e().a();
        this.l.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.l);
        this.m = dVar.f().a();
        this.m.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.m);
        this.n = dVar.g().a();
        this.n.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.n);
    }

    public void a() {
        this.q.invalidateSelf();
    }

    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.i.add((m) cVar);
            }
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        if (!this.f1626b) {
            com.airbnb.lottie.c.a("GradientFillContent#draw");
            this.f.reset();
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                this.f.addPath(this.i.get(i3).e(), matrix);
            }
            this.f.computeBounds(this.h, false);
            if (this.j == f.LINEAR) {
                shader = c();
            } else {
                shader = d();
            }
            shader.setLocalMatrix(matrix);
            this.g.setShader(shader);
            a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.g.setColorFilter(aVar.g());
            }
            this.g.setAlpha(g.a((int) ((((((float) i2) / 255.0f) * ((float) this.l.g().intValue())) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.f, this.g);
            com.airbnb.lottie.c.b("GradientFillContent#draw");
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(this.i.get(i2).e(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public String b() {
        return this.f1625a;
    }

    private LinearGradient c() {
        long e2 = (long) e();
        LinearGradient linearGradient = this.d.get(e2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF g2 = this.m.g();
        PointF g3 = this.n.g();
        c g4 = this.k.g();
        LinearGradient linearGradient2 = new LinearGradient(g2.x, g2.y, g3.x, g3.y, a(g4.b()), g4.a(), Shader.TileMode.CLAMP);
        this.d.put(e2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long e2 = (long) e();
        RadialGradient radialGradient = this.e.get(e2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF g2 = this.m.g();
        PointF g3 = this.n.g();
        c g4 = this.k.g();
        int[] a2 = a(g4.b());
        float[] a3 = g4.a();
        float f2 = g2.x;
        float f3 = g2.y;
        float hypot = (float) Math.hypot((double) (g3.x - f2), (double) (g3.y - f3));
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, hypot, a2, a3, Shader.TileMode.CLAMP);
        this.e.put(e2, radialGradient2);
        return radialGradient2;
    }

    private int e() {
        int round = Math.round(this.m.h() * ((float) this.r));
        int round2 = Math.round(this.n.h() * ((float) this.r));
        int round3 = Math.round(this.k.h() * ((float) this.r));
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private int[] a(int[] iArr) {
        p pVar = this.p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.g();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    public void a(e eVar, int i2, List<e> list, e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == k.d) {
            this.l.a(cVar);
        } else if (t == k.C) {
            a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.c.b((a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.o = null;
                return;
            }
            this.o = new p(cVar);
            this.o.a((a.C0053a) this);
            this.c.a((a<?, ?>) this.o);
        } else if (t == k.D) {
            p pVar = this.p;
            if (pVar != null) {
                this.c.b((a<?, ?>) pVar);
            }
            if (cVar == null) {
                this.p = null;
                return;
            }
            this.p = new p(cVar);
            this.p.a((a.C0053a) this);
            this.c.a((a<?, ?>) this.p);
        }
    }
}
