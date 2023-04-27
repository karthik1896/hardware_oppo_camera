package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.c.a;
import com.airbnb.lottie.f.d;
import com.airbnb.lottie.f.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f1687a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f1688b;
    private boolean c;

    public l(PointF pointF, boolean z, List<a> list) {
        this.f1688b = pointF;
        this.c = z;
        this.f1687a = new ArrayList(list);
    }

    public l() {
        this.f1687a = new ArrayList();
    }

    private void a(float f, float f2) {
        if (this.f1688b == null) {
            this.f1688b = new PointF();
        }
        this.f1688b.set(f, f2);
    }

    public PointF a() {
        return this.f1688b;
    }

    public boolean b() {
        return this.c;
    }

    public List<a> c() {
        return this.f1687a;
    }

    public void a(l lVar, l lVar2, float f) {
        if (this.f1688b == null) {
            this.f1688b = new PointF();
        }
        this.c = lVar.b() || lVar2.b();
        if (lVar.c().size() != lVar2.c().size()) {
            d.b("Curves must have the same number of control points. Shape 1: " + lVar.c().size() + "\tShape 2: " + lVar2.c().size());
        }
        int min = Math.min(lVar.c().size(), lVar2.c().size());
        if (this.f1687a.size() < min) {
            for (int size = this.f1687a.size(); size < min; size++) {
                this.f1687a.add(new a());
            }
        } else if (this.f1687a.size() > min) {
            for (int size2 = this.f1687a.size() - 1; size2 >= min; size2--) {
                List<a> list = this.f1687a;
                list.remove(list.size() - 1);
            }
        }
        PointF a2 = lVar.a();
        PointF a3 = lVar2.a();
        a(g.a(a2.x, a3.x, f), g.a(a2.y, a3.y, f));
        for (int size3 = this.f1687a.size() - 1; size3 >= 0; size3--) {
            a aVar = lVar.c().get(size3);
            a aVar2 = lVar2.c().get(size3);
            PointF a4 = aVar.a();
            PointF b2 = aVar.b();
            PointF c2 = aVar.c();
            PointF a5 = aVar2.a();
            PointF b3 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f1687a.get(size3).a(g.a(a4.x, a5.x, f), g.a(a4.y, a5.y, f));
            this.f1687a.get(size3).b(g.a(b2.x, b3.x, f), g.a(b2.y, b3.y, f));
            this.f1687a.get(size3).c(g.a(c2.x, c3.x, f), g.a(c2.y, c3.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f1687a.size() + "closed=" + this.c + '}';
    }
}
