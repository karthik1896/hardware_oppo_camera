package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.k;
import java.util.List;

/* compiled from: EllipseContent */
public class f implements k, m, a.C0053a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f1621a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f1622b;
    private final com.airbnb.lottie.f c;
    private final a<?, PointF> d;
    private final a<?, PointF> e;
    private final com.airbnb.lottie.c.b.a f;
    private b g = new b();
    private boolean h;

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, com.airbnb.lottie.c.b.a aVar2) {
        this.f1622b = aVar2.a();
        this.c = fVar;
        this.d = aVar2.c().a();
        this.e = aVar2.b().a();
        this.f = aVar2;
        aVar.a((a<?, ?>) this.d);
        aVar.a((a<?, ?>) this.e);
        this.d.a((a.C0053a) this);
        this.e.a((a.C0053a) this);
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
        return this.f1622b;
    }

    public Path e() {
        if (this.h) {
            return this.f1621a;
        }
        this.f1621a.reset();
        if (this.f.e()) {
            this.h = true;
            return this.f1621a;
        }
        PointF g2 = this.d.g();
        float f2 = g2.x / 2.0f;
        float f3 = g2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.f1621a.reset();
        if (this.f.d()) {
            float f6 = -f3;
            this.f1621a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.f1621a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            float f11 = f6;
            this.f1621a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f12 = f4 + 0.0f;
            this.f1621a.cubicTo(f12, f3, f2, f10, f2, 0.0f);
            this.f1621a.cubicTo(f2, f9, f12, f11, 0.0f, f11);
        } else {
            float f13 = -f3;
            this.f1621a.moveTo(0.0f, f13);
            float f14 = f4 + 0.0f;
            float f15 = 0.0f - f5;
            this.f1621a.cubicTo(f14, f13, f2, f15, f2, 0.0f);
            float f16 = f5 + 0.0f;
            this.f1621a.cubicTo(f2, f16, f14, f3, 0.0f, f3);
            float f17 = 0.0f - f4;
            float f18 = -f2;
            this.f1621a.cubicTo(f17, f3, f18, f16, f18, 0.0f);
            float f19 = f13;
            this.f1621a.cubicTo(f18, f15, f17, f19, 0.0f, f19);
        }
        PointF g3 = this.e.g();
        this.f1621a.offset(g3.x, g3.y);
        this.f1621a.close();
        this.g.a(this.f1621a);
        this.h = true;
        return this.f1621a;
    }

    public void a(e eVar, int i, List<e> list, e eVar2) {
        g.a(eVar, i, list, eVar2, this);
    }

    public <T> void a(T t, c<T> cVar) {
        if (t == k.g) {
            this.d.a(cVar);
        } else if (t == k.j) {
            this.e.a(cVar);
        }
    }
}
