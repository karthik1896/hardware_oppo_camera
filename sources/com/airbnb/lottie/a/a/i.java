package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.c.b.e;
import com.airbnb.lottie.c.b.f;
import com.airbnb.lottie.k;

/* compiled from: GradientStrokeContent */
public class i extends a {
    private final String c;
    private final boolean d;
    private final LongSparseArray<LinearGradient> e = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> f = new LongSparseArray<>();
    private final RectF g = new RectF();
    private final f h;
    private final int i;
    private final a<c, c> j;
    private final a<PointF, PointF> k;
    private final a<PointF, PointF> l;
    private p m;

    public i(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, e eVar) {
        super(fVar, aVar, eVar.h().toPaintCap(), eVar.i().toPaintJoin(), eVar.l(), eVar.d(), eVar.g(), eVar.j(), eVar.k());
        this.c = eVar.a();
        this.h = eVar.b();
        this.d = eVar.m();
        this.i = (int) (fVar.s().e() / 32.0f);
        this.j = eVar.c().a();
        this.j.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.j);
        this.k = eVar.e().a();
        this.k.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.k);
        this.l = eVar.f().a();
        this.l.a((a.C0053a) this);
        aVar.a((a<?, ?>) this.l);
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        if (!this.d) {
            a(this.g, matrix, false);
            if (this.h == f.LINEAR) {
                shader = c();
            } else {
                shader = d();
            }
            shader.setLocalMatrix(matrix);
            this.f1615b.setShader(shader);
            super.a(canvas, matrix, i2);
        }
    }

    public String b() {
        return this.c;
    }

    private LinearGradient c() {
        long e2 = (long) e();
        LinearGradient linearGradient = this.e.get(e2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF g2 = this.k.g();
        PointF g3 = this.l.g();
        c g4 = this.j.g();
        LinearGradient linearGradient2 = new LinearGradient(g2.x, g2.y, g3.x, g3.y, a(g4.b()), g4.a(), Shader.TileMode.CLAMP);
        this.e.put(e2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long e2 = (long) e();
        RadialGradient radialGradient = this.f.get(e2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF g2 = this.k.g();
        PointF g3 = this.l.g();
        c g4 = this.j.g();
        int[] a2 = a(g4.b());
        float[] a3 = g4.a();
        float f2 = g2.x;
        float f3 = g2.y;
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, (float) Math.hypot((double) (g3.x - f2), (double) (g3.y - f3)), a2, a3, Shader.TileMode.CLAMP);
        this.f.put(e2, radialGradient2);
        return radialGradient2;
    }

    private int e() {
        int round = Math.round(this.k.h() * ((float) this.i));
        int round2 = Math.round(this.l.h() * ((float) this.i));
        int round3 = Math.round(this.j.h() * ((float) this.i));
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private int[] a(int[] iArr) {
        p pVar = this.m;
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

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t == k.D) {
            if (this.m != null) {
                this.f1614a.b((a<?, ?>) this.m);
            }
            if (cVar == null) {
                this.m = null;
                return;
            }
            this.m = new p(cVar);
            this.m.a((a.C0053a) this);
            this.f1614a.a((a<?, ?>) this.m);
        }
    }
}
