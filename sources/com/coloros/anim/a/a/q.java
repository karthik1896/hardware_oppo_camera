package com.coloros.anim.a.a;

import android.graphics.Path;
import com.coloros.anim.a.b.a;
import com.coloros.anim.b;
import com.coloros.anim.c.b.o;
import com.coloros.anim.c.b.q;
import java.util.List;

/* compiled from: ShapeContent */
public class q implements m, a.C0061a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f2316a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f2317b;
    private final boolean c;
    private final b d;
    private final a<?, Path> e;
    private boolean f;
    private b g = new b();

    public q(b bVar, com.coloros.anim.c.c.a aVar, o oVar) {
        this.f2317b = oVar.a();
        this.c = oVar.c();
        this.d = bVar;
        this.e = oVar.b().a();
        aVar.a((a<?, ?>) this.e);
        this.e.a((a.C0061a) this);
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
            return this.f2316a;
        }
        this.f2316a.reset();
        if (this.c) {
            this.f = true;
            return this.f2316a;
        }
        this.f2316a.set(this.e.g());
        this.f2316a.setFillType(Path.FillType.EVEN_ODD);
        this.g.a(this.f2316a);
        this.f = true;
        return this.f2316a;
    }

    public String b() {
        return this.f2317b;
    }
}
