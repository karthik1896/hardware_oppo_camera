package com.coloros.anim.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.b;
import com.coloros.anim.c.b.q;
import com.coloros.anim.d;
import java.util.List;

/* compiled from: EllipseContent */
public class f implements k, m, a.C0061a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f2299a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f2300b;
    private final b c;
    private final a<?, PointF> d;
    private final a<?, PointF> e;
    private final com.coloros.anim.c.b.a f;
    private b g = new b();
    private boolean h;

    public f(b bVar, com.coloros.anim.c.c.a aVar, com.coloros.anim.c.b.a aVar2) {
        this.f2300b = aVar2.a();
        this.c = bVar;
        this.d = aVar2.c().a();
        this.e = aVar2.b().a();
        this.f = aVar2;
        aVar.a((a<?, ?>) this.d);
        aVar.a((a<?, ?>) this.e);
        this.d.a((a.C0061a) this);
        this.e.a((a.C0061a) this);
    }

    public void a() {
        c();
    }

    private void c() {
        this.h = false;
        this.c.invalidateSelf();
    }

    public void a(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c() == q.a.SIMULTANEOUSLY) {
                    this.g.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    public String b() {
        return this.f2300b;
    }

    public Path e() {
        if (this.h) {
            return this.f2299a;
        }
        this.f2299a.reset();
        if (this.f.e()) {
            this.h = true;
            return this.f2299a;
        }
        PointF g2 = this.d.g();
        float f2 = g2.x / 2.0f;
        float f3 = g2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.f2299a.reset();
        if (this.f.d()) {
            float f6 = -f3;
            this.f2299a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.f2299a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            float f11 = f6;
            this.f2299a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f12 = f4 + 0.0f;
            this.f2299a.cubicTo(f12, f3, f2, f10, f2, 0.0f);
            this.f2299a.cubicTo(f2, f9, f12, f11, 0.0f, f11);
        } else {
            float f13 = -f3;
            this.f2299a.moveTo(0.0f, f13);
            float f14 = f4 + 0.0f;
            float f15 = 0.0f - f5;
            this.f2299a.cubicTo(f14, f13, f2, f15, f2, 0.0f);
            float f16 = f5 + 0.0f;
            this.f2299a.cubicTo(f2, f16, f14, f3, 0.0f, f3);
            float f17 = 0.0f - f4;
            float f18 = -f2;
            this.f2299a.cubicTo(f17, f3, f18, f16, f18, 0.0f);
            float f19 = f13;
            this.f2299a.cubicTo(f18, f15, f17, f19, 0.0f, f19);
        }
        PointF g3 = this.e.g();
        this.f2299a.offset(g3.x, g3.y);
        this.f2299a.close();
        this.g.a(this.f2299a);
        this.h = true;
        return this.f2299a;
    }

    public void a(com.coloros.anim.c.f fVar, int i, List<com.coloros.anim.c.f> list, com.coloros.anim.c.f fVar2) {
        com.coloros.anim.f.f.a(fVar, i, list, fVar2, this);
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        if (t == d.g) {
            this.d.a(bVar);
        } else if (t == d.h) {
            this.e.a(bVar);
        }
    }
}
