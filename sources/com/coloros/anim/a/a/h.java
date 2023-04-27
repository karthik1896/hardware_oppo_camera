package com.coloros.anim.a.a;

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
import android.util.LongSparseArray;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.p;
import com.coloros.anim.b;
import com.coloros.anim.c.b.c;
import com.coloros.anim.c.b.d;
import com.coloros.anim.c.b.f;
import com.coloros.anim.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent */
public class h implements e, k, a.C0061a {

    /* renamed from: a  reason: collision with root package name */
    private final String f2303a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2304b;
    private final com.coloros.anim.c.c.a c;
    private final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    private final Matrix f = new Matrix();
    private final Path g = new Path();
    private final Paint h = new com.coloros.anim.a.a(1);
    private final RectF i = new RectF();
    private final List<m> j = new ArrayList();
    private final f k;
    private final a<c, c> l;
    private final a<Integer, Integer> m;
    private final a<PointF, PointF> n;
    private final a<PointF, PointF> o;
    private final b p;
    private final int q;
    private a<ColorFilter, ColorFilter> r;

    public h(b bVar, com.coloros.anim.c.c.a aVar, d dVar) {
        this.c = aVar;
        this.f2303a = dVar.a();
        this.f2304b = dVar.h();
        this.p = bVar;
        this.k = dVar.b();
        this.g.setFillType(dVar.c());
        this.q = (int) (bVar.r().e() / 32.0f);
        this.l = dVar.d().a();
        this.l.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.l);
        this.m = dVar.e().a();
        this.m.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.m);
        this.n = dVar.f().a();
        this.n.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.n);
        this.o = dVar.g().a();
        this.o.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.o);
    }

    public void a() {
        this.p.invalidateSelf();
    }

    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.j.add((m) cVar);
            }
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        if (!this.f2304b) {
            k.c("GradientFillContent#draw");
            this.g.reset();
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                this.g.addPath(this.j.get(i3).e(), matrix);
            }
            this.g.computeBounds(this.i, false);
            if (this.k == f.LINEAR) {
                shader = c();
            } else {
                shader = d();
            }
            this.f.set(matrix);
            shader.setLocalMatrix(this.f);
            this.h.setShader(shader);
            a<ColorFilter, ColorFilter> aVar = this.r;
            if (aVar != null) {
                this.h.setColorFilter(aVar.g());
            }
            this.h.setAlpha(com.coloros.anim.f.f.a((int) ((((((float) i2) / 255.0f) * ((float) this.m.g().intValue())) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.g, this.h);
            k.d("GradientFillContent#draw");
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.g.reset();
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            this.g.addPath(this.j.get(i2).e(), matrix);
        }
        this.g.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public String b() {
        return this.f2303a;
    }

    private LinearGradient c() {
        long e2 = (long) e();
        LinearGradient linearGradient = this.d.get(e2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF g2 = this.n.g();
        PointF g3 = this.o.g();
        c g4 = this.l.g();
        LinearGradient linearGradient2 = new LinearGradient(g2.x, g2.y, g3.x, g3.y, g4.b(), g4.a(), Shader.TileMode.CLAMP);
        this.d.put(e2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long e2 = (long) e();
        RadialGradient radialGradient = this.e.get(e2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF g2 = this.n.g();
        PointF g3 = this.o.g();
        c g4 = this.l.g();
        int[] b2 = g4.b();
        float[] a2 = g4.a();
        float f2 = g2.x;
        float f3 = g2.y;
        float hypot = (float) Math.hypot((double) (g3.x - f2), (double) (g3.y - f3));
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, hypot, b2, a2, Shader.TileMode.CLAMP);
        this.e.put(e2, radialGradient2);
        return radialGradient2;
    }

    private int e() {
        int round = Math.round(this.n.h() * ((float) this.q));
        int round2 = Math.round(this.o.h() * ((float) this.q));
        int round3 = Math.round(this.l.h() * ((float) this.q));
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    public void a(com.coloros.anim.c.f fVar, int i2, List<com.coloros.anim.c.f> list, com.coloros.anim.c.f fVar2) {
        com.coloros.anim.f.f.a(fVar, i2, list, fVar2, this);
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        if (t != com.coloros.anim.d.z) {
            return;
        }
        if (bVar == null) {
            this.r = null;
            return;
        }
        this.r = new p(bVar);
        this.r.a((a.C0061a) this);
        this.c.a((a<?, ?>) this.r);
    }
}
