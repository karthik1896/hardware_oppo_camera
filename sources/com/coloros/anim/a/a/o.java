package com.coloros.anim.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.c;
import com.coloros.anim.b;
import com.coloros.anim.c.b.j;
import com.coloros.anim.c.b.q;
import com.coloros.anim.c.f;
import java.util.List;

/* compiled from: RectangleContent */
public class o implements k, m, a.C0061a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f2312a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f2313b = new RectF();
    private final String c;
    private final boolean d;
    private final b e;
    private final a<?, PointF> f;
    private final a<?, PointF> g;
    private final a<?, Float> h;
    private b i = new b();
    private boolean j;

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
    }

    public o(b bVar, com.coloros.anim.c.c.a aVar, j jVar) {
        this.c = jVar.a();
        this.d = jVar.e();
        this.e = bVar;
        this.f = jVar.d().a();
        this.g = jVar.c().a();
        this.h = jVar.b().a();
        aVar.a((a<?, ?>) this.f);
        aVar.a((a<?, ?>) this.g);
        aVar.a((a<?, ?>) this.h);
        this.f.a((a.C0061a) this);
        this.g.a((a.C0061a) this);
        this.h.a((a.C0061a) this);
    }

    public String b() {
        return this.c;
    }

    public void a() {
        c();
    }

    private void c() {
        this.j = false;
        this.e.invalidateSelf();
    }

    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c() == q.a.SIMULTANEOUSLY) {
                    this.i.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    public Path e() {
        float f2;
        if (this.j) {
            return this.f2312a;
        }
        this.f2312a.reset();
        if (this.d) {
            this.j = true;
            return this.f2312a;
        }
        PointF g2 = this.g.g();
        float f3 = g2.x / 2.0f;
        float f4 = g2.y / 2.0f;
        a<?, Float> aVar = this.h;
        if (aVar == null) {
            f2 = 0.0f;
        } else {
            f2 = ((c) aVar).i();
        }
        float min = Math.min(f3, f4);
        if (f2 > min) {
            f2 = min;
        }
        PointF g3 = this.f.g();
        this.f2312a.moveTo(g3.x + f3, (g3.y - f4) + f2);
        this.f2312a.lineTo(g3.x + f3, (g3.y + f4) - f2);
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 > 0) {
            float f5 = f2 * 2.0f;
            this.f2313b.set((g3.x + f3) - f5, (g3.y + f4) - f5, g3.x + f3, g3.y + f4);
            this.f2312a.arcTo(this.f2313b, 0.0f, 90.0f, false);
        }
        this.f2312a.lineTo((g3.x - f3) + f2, g3.y + f4);
        if (i2 > 0) {
            float f6 = f2 * 2.0f;
            this.f2313b.set(g3.x - f3, (g3.y + f4) - f6, (g3.x - f3) + f6, g3.y + f4);
            this.f2312a.arcTo(this.f2313b, 90.0f, 90.0f, false);
        }
        this.f2312a.lineTo(g3.x - f3, (g3.y - f4) + f2);
        if (i2 > 0) {
            float f7 = f2 * 2.0f;
            this.f2313b.set(g3.x - f3, g3.y - f4, (g3.x - f3) + f7, (g3.y - f4) + f7);
            this.f2312a.arcTo(this.f2313b, 180.0f, 90.0f, false);
        }
        this.f2312a.lineTo((g3.x + f3) - f2, g3.y - f4);
        if (i2 > 0) {
            float f8 = f2 * 2.0f;
            this.f2313b.set((g3.x + f3) - f8, g3.y - f4, g3.x + f3, (g3.y - f4) + f8);
            this.f2312a.arcTo(this.f2313b, 270.0f, 90.0f, false);
        }
        this.f2312a.close();
        this.i.a(this.f2312a);
        this.j = true;
        return this.f2312a;
    }

    public void a(f fVar, int i2, List<f> list, f fVar2) {
        com.coloros.anim.f.f.a(fVar, i2, list, fVar2, this);
    }
}
