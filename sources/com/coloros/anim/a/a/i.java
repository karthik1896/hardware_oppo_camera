package com.coloros.anim.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.coloros.anim.a.b.a;
import com.coloros.anim.b;
import com.coloros.anim.c.b.c;
import com.coloros.anim.c.b.e;
import com.coloros.anim.c.b.f;

/* compiled from: GradientStrokeContent */
public class i extends a {

    /* renamed from: b  reason: collision with root package name */
    private final String f2305b;
    private final boolean c;
    private final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    private final RectF f = new RectF();
    private final f g;
    private final int h;
    private final a<c, c> i;
    private final a<PointF, PointF> j;
    private final a<PointF, PointF> k;

    public i(b bVar, com.coloros.anim.c.c.a aVar, e eVar) {
        super(bVar, aVar, eVar.h().toPaintCap(), eVar.i().toPaintJoin(), eVar.l(), eVar.d(), eVar.g(), eVar.j(), eVar.k());
        this.f2305b = eVar.a();
        this.g = eVar.b();
        this.c = eVar.m();
        this.h = (int) (bVar.r().e() / 32.0f);
        this.i = eVar.c().a();
        this.i.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.i);
        this.j = eVar.e().a();
        this.j.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.j);
        this.k = eVar.f().a();
        this.k.a((a.C0061a) this);
        aVar.a((a<?, ?>) this.k);
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (!this.c) {
            a(this.f, matrix, false);
            if (this.g == f.LINEAR) {
                this.f2292a.setShader(c());
            } else {
                this.f2292a.setShader(d());
            }
            super.a(canvas, matrix, i2);
        }
    }

    public String b() {
        return this.f2305b;
    }

    private LinearGradient c() {
        long e2 = (long) e();
        LinearGradient linearGradient = this.d.get(e2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF g2 = this.j.g();
        PointF g3 = this.k.g();
        c g4 = this.i.g();
        LinearGradient linearGradient2 = new LinearGradient((float) ((int) (this.f.left + (this.f.width() / 2.0f) + g2.x)), (float) ((int) (this.f.top + (this.f.height() / 2.0f) + g2.y)), (float) ((int) (this.f.left + (this.f.width() / 2.0f) + g3.x)), (float) ((int) (this.f.top + (this.f.height() / 2.0f) + g3.y)), g4.b(), g4.a(), Shader.TileMode.CLAMP);
        this.d.put(e2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long e2 = (long) e();
        RadialGradient radialGradient = this.e.get(e2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF g2 = this.j.g();
        PointF g3 = this.k.g();
        c g4 = this.i.g();
        int[] b2 = g4.b();
        float[] a2 = g4.a();
        int width = (int) (this.f.left + (this.f.width() / 2.0f) + g2.x);
        int height = (int) (this.f.top + (this.f.height() / 2.0f) + g2.y);
        RadialGradient radialGradient2 = new RadialGradient((float) width, (float) height, (float) Math.hypot((double) (((int) ((this.f.left + (this.f.width() / 2.0f)) + g3.x)) - width), (double) (((int) ((this.f.top + (this.f.height() / 2.0f)) + g3.y)) - height)), b2, a2, Shader.TileMode.CLAMP);
        this.e.put(e2, radialGradient2);
        return radialGradient2;
    }

    private int e() {
        int round = Math.round(this.j.h() * ((float) this.h));
        int round2 = Math.round(this.k.h() * ((float) this.h));
        int round3 = Math.round(this.i.h() * ((float) this.h));
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }
}
