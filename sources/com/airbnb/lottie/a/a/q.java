package com.airbnb.lottie.a.a;

import android.graphics.Path;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.o;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.f;
import java.util.List;

/* compiled from: ShapeContent */
public class q implements m, a.C0053a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f1637a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f1638b;
    private final boolean c;
    private final f d;
    private final a<?, Path> e;
    private boolean f;
    private b g = new b();

    public q(f fVar, com.airbnb.lottie.c.c.a aVar, o oVar) {
        this.f1638b = oVar.a();
        this.c = oVar.c();
        this.d = fVar;
        this.e = oVar.b().a();
        aVar.a((a<?, ?>) this.e);
        this.e.a((a.C0053a) this);
    }

    public void a() {
        c();
    }

    private void c() {
        this.f = false;
        this.d.invalidateSelf();
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

    public Path e() {
        if (this.f) {
            return this.f1637a;
        }
        this.f1637a.reset();
        if (this.c) {
            this.f = true;
            return this.f1637a;
        }
        this.f1637a.set(this.e.g());
        this.f1637a.setFillType(Path.FillType.EVEN_ODD);
        this.g.a(this.f1637a);
        this.f = true;
        return this.f1637a;
    }

    public String b() {
        return this.f1638b;
    }
}
