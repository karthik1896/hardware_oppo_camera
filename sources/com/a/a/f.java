package com.a.a;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Spring */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static int f1599a;

    /* renamed from: b  reason: collision with root package name */
    private g f1600b;
    private boolean c;
    private final String d;
    private final a e = new a();
    private final a f = new a();
    private final a g = new a();
    private double h;
    private double i;
    private boolean j = true;
    private double k = 0.005d;
    private double l = 0.005d;
    private CopyOnWriteArraySet<h> m = new CopyOnWriteArraySet<>();
    private double n = 0.0d;
    private final b o;

    /* compiled from: Spring */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        double f1601a;

        /* renamed from: b  reason: collision with root package name */
        double f1602b;

        private a() {
        }
    }

    f(b bVar) {
        if (bVar != null) {
            this.o = bVar;
            StringBuilder sb = new StringBuilder();
            sb.append("spring:");
            int i2 = f1599a;
            f1599a = i2 + 1;
            sb.append(i2);
            this.d = sb.toString();
            a(g.c);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    public void a() {
        this.m.clear();
        this.o.b(this);
    }

    public String b() {
        return this.d;
    }

    public f a(g gVar) {
        if (gVar != null) {
            this.f1600b = gVar;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public f a(double d2) {
        return a(d2, true);
    }

    public f a(double d2, boolean z) {
        this.h = d2;
        this.e.f1601a = d2;
        this.o.a(b());
        Iterator<h> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        if (z) {
            j();
        }
        return this;
    }

    public double c() {
        return this.e.f1601a;
    }

    private double a(a aVar) {
        return Math.abs(this.i - aVar.f1601a);
    }

    public f b(double d2) {
        if (this.i == d2 && i()) {
            return this;
        }
        this.h = c();
        this.i = d2;
        this.o.a(b());
        Iterator<h> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().d(this);
        }
        return this;
    }

    public double d() {
        return this.i;
    }

    public f c(double d2) {
        if (d2 == this.e.f1602b) {
            return this;
        }
        this.e.f1602b = d2;
        this.o.a(b());
        return this;
    }

    public double e() {
        return this.e.f1602b;
    }

    public f a(boolean z) {
        this.c = z;
        return this;
    }

    public boolean f() {
        return this.f1600b.f1604b > 0.0d && ((this.h < this.i && c() > this.i) || (this.h > this.i && c() < this.i));
    }

    /* access modifiers changed from: package-private */
    public void d(double d2) {
        double d3;
        boolean z;
        boolean i2 = i();
        if (!i2 || !this.j) {
            double d4 = 0.064d;
            if (d2 <= 0.064d) {
                d4 = d2;
            }
            this.n += d4;
            double d5 = this.f1600b.f1604b;
            double d6 = this.f1600b.f1603a;
            double d7 = this.e.f1601a;
            double d8 = this.e.f1602b;
            double d9 = this.g.f1601a;
            double d10 = this.g.f1602b;
            while (true) {
                d3 = this.n;
                if (d3 < 0.001d) {
                    break;
                }
                this.n = d3 - 0.001d;
                if (this.n < 0.001d) {
                    a aVar = this.f;
                    aVar.f1601a = d7;
                    aVar.f1602b = d8;
                }
                double d11 = this.i;
                double d12 = ((d11 - d9) * d5) - (d6 * d8);
                double d13 = d8 + (d12 * 0.001d * 0.5d);
                double d14 = ((d11 - (((d8 * 0.001d) * 0.5d) + d7)) * d5) - (d6 * d13);
                double d15 = d8 + (d14 * 0.001d * 0.5d);
                double d16 = ((d11 - (d7 + ((d13 * 0.001d) * 0.5d))) * d5) - (d6 * d15);
                double d17 = d7 + (d15 * 0.001d);
                double d18 = d8 + (d16 * 0.001d);
                d7 += (d8 + ((d13 + d15) * 2.0d) + d18) * 0.16666666666666666d * 0.001d;
                d8 += (d12 + ((d14 + d16) * 2.0d) + (((d11 - d17) * d5) - (d6 * d18))) * 0.16666666666666666d * 0.001d;
                d9 = d17;
                d10 = d18;
            }
            a aVar2 = this.g;
            aVar2.f1601a = d9;
            aVar2.f1602b = d10;
            a aVar3 = this.e;
            aVar3.f1601a = d7;
            aVar3.f1602b = d8;
            if (d3 > 0.0d) {
                e(d3 / 0.001d);
            }
            if (i() || (this.c && f())) {
                if (d5 > 0.0d) {
                    double d19 = this.i;
                    this.h = d19;
                    this.e.f1601a = d19;
                } else {
                    this.i = this.e.f1601a;
                    this.h = this.i;
                }
                c(0.0d);
                i2 = true;
            }
            boolean z2 = false;
            if (this.j) {
                this.j = false;
                z = true;
            } else {
                z = false;
            }
            if (i2) {
                this.j = true;
                z2 = true;
            }
            Iterator<h> it = this.m.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (z) {
                    next.c(this);
                }
                next.a(this);
                if (z2) {
                    next.b(this);
                }
            }
        }
    }

    public boolean g() {
        return !i() || !h();
    }

    public boolean h() {
        return this.j;
    }

    public boolean i() {
        return Math.abs(this.e.f1602b) <= this.k && (a(this.e) <= this.l || this.f1600b.f1604b == 0.0d);
    }

    public f j() {
        this.i = this.e.f1601a;
        this.g.f1601a = this.e.f1601a;
        this.e.f1602b = 0.0d;
        return this;
    }

    private void e(double d2) {
        a aVar = this.e;
        double d3 = 1.0d - d2;
        aVar.f1601a = (aVar.f1601a * d2) + (this.f.f1601a * d3);
        a aVar2 = this.e;
        aVar2.f1602b = (aVar2.f1602b * d2) + (this.f.f1602b * d3);
    }

    public f a(h hVar) {
        if (hVar != null) {
            this.m.add(hVar);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }
}
