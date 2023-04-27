package com.coloros.anim.c.b;

import android.graphics.PointF;
import com.coloros.anim.c.a;
import com.coloros.anim.f.f;
import com.coloros.anim.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f2388a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f2389b;
    private boolean c;

    public l(PointF pointF, boolean z, List<a> list) {
        this.f2389b = pointF;
        this.c = z;
        this.f2388a = new ArrayList(list);
    }

    public l() {
        this.f2388a = new ArrayList();
    }

    private void a(float f, float f2) {
        if (this.f2389b == null) {
            this.f2389b = new PointF();
        }
        this.f2389b.set(f, f2);
    }

    public PointF a() {
        return this.f2389b;
    }

    public boolean b() {
        return this.c;
    }

    public List<a> c() {
        return this.f2388a;
    }

    public void a(l lVar, l lVar2, float f) {
        if (this.f2389b == null) {
            this.f2389b = new PointF();
        }
        this.c = lVar.b() || lVar2.b();
        if (lVar.c().size() != lVar2.c().size()) {
            k.b("Curves must have the same number of control points. Shape 1: " + lVar.c().size() + "\tShape 2: " + lVar2.c().size());
        }
        int min = Math.min(lVar.c().size(), lVar2.c().size());
        if (this.f2388a.size() < min) {
            for (int size = this.f2388a.size(); size < min; size++) {
                this.f2388a.add(new a());
            }
        } else if (this.f2388a.size() > min) {
            for (int size2 = this.f2388a.size() - 1; size2 >= min; size2--) {
                List<a> list = this.f2388a;
                list.remove(list.size() - 1);
            }
        }
        PointF a2 = lVar.a();
        PointF a3 = lVar2.a();
        a(f.a(a2.x, a3.x, f), f.a(a2.y, a3.y, f));
        for (int size3 = this.f2388a.size() - 1; size3 >= 0; size3--) {
            a aVar = lVar.c().get(size3);
            a aVar2 = lVar2.c().get(size3);
            PointF a4 = aVar.a();
            PointF b2 = aVar.b();
            PointF c2 = aVar.c();
            PointF a5 = aVar2.a();
            PointF b3 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f2388a.get(size3).a(f.a(a4.x, a5.x, f), f.a(a4.y, a5.y, f));
            this.f2388a.get(size3).b(f.a(b2.x, b3.x, f), f.a(b2.y, b3.y, f));
            this.f2388a.get(size3).c(f.a(c2.x, c3.x, f), f.a(c2.y, c3.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f2388a.size() + "closed=" + this.c + '}';
    }
}
