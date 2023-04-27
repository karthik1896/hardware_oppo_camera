package androidx.constraintlayout.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.h;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem */
public class e {
    public static f g = null;
    private static int h = 1000;

    /* renamed from: a  reason: collision with root package name */
    int f539a = 0;

    /* renamed from: b  reason: collision with root package name */
    b[] f540b;
    public boolean c;
    int d;
    int e;
    final c f;
    private HashMap<String, h> i = null;
    private a j;
    private int k = 32;
    private int l;
    private boolean[] m;
    private int n;
    private h[] o;
    private int p;
    private b[] q;
    private final a r;

    /* compiled from: LinearSystem */
    interface a {
        h a(e eVar, boolean[] zArr);

        void a(a aVar);

        void d(h hVar);

        void f();

        h g();
    }

    public e() {
        int i2 = this.k;
        this.l = i2;
        this.f540b = null;
        this.c = false;
        this.m = new boolean[i2];
        this.d = 1;
        this.e = 0;
        this.n = i2;
        this.o = new h[h];
        this.p = 0;
        this.q = new b[i2];
        this.f540b = new b[i2];
        i();
        this.f = new c();
        this.j = new d(this.f);
        this.r = new b(this.f);
    }

    public static f a() {
        return g;
    }

    private void h() {
        this.k *= 2;
        this.f540b = (b[]) Arrays.copyOf(this.f540b, this.k);
        c cVar = this.f;
        cVar.c = (h[]) Arrays.copyOf(cVar.c, this.k);
        int i2 = this.k;
        this.m = new boolean[i2];
        this.l = i2;
        this.n = i2;
        f fVar = g;
        if (fVar != null) {
            fVar.d++;
            f fVar2 = g;
            fVar2.p = Math.max(fVar2.p, (long) this.k);
            f fVar3 = g;
            fVar3.D = fVar3.p;
        }
    }

    private void i() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f540b;
            if (i2 < bVarArr.length) {
                b bVar = bVarArr[i2];
                if (bVar != null) {
                    this.f.f537a.a(bVar);
                }
                this.f540b[i2] = null;
                i2++;
            } else {
                return;
            }
        }
    }

    public void b() {
        for (h hVar : this.f.c) {
            if (hVar != null) {
                hVar.b();
            }
        }
        this.f.f538b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.f.c, (Object) null);
        HashMap<String, h> hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f539a = 0;
        this.j.f();
        this.d = 1;
        for (int i2 = 0; i2 < this.e; i2++) {
            this.f540b[i2].c = false;
        }
        i();
        this.e = 0;
    }

    public h a(Object obj) {
        h hVar = null;
        if (obj == null) {
            return null;
        }
        if (this.d + 1 >= this.l) {
            h();
        }
        if (obj instanceof androidx.constraintlayout.a.a.e) {
            androidx.constraintlayout.a.a.e eVar = (androidx.constraintlayout.a.a.e) obj;
            hVar = eVar.b();
            if (hVar == null) {
                eVar.a(this.f);
                hVar = eVar.b();
            }
            if (hVar.f545a == -1 || hVar.f545a > this.f539a || this.f.c[hVar.f545a] == null) {
                if (hVar.f545a != -1) {
                    hVar.b();
                }
                this.f539a++;
                this.d++;
                hVar.f545a = this.f539a;
                hVar.f = h.a.UNRESTRICTED;
                this.f.c[this.f539a] = hVar;
            }
        }
        return hVar;
    }

    public b c() {
        b a2 = this.f.f537a.a();
        if (a2 == null) {
            a2 = new b(this.f);
        } else {
            a2.c();
        }
        h.a();
        return a2;
    }

    public h d() {
        f fVar = g;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.SLACK, (String) null);
        this.f539a++;
        this.d++;
        a2.f545a = this.f539a;
        this.f.c[this.f539a] = a2;
        return a2;
    }

    public h e() {
        f fVar = g;
        if (fVar != null) {
            fVar.o++;
        }
        if (this.d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.SLACK, (String) null);
        this.f539a++;
        this.d++;
        a2.f545a = this.f539a;
        this.f.c[this.f539a] = a2;
        return a2;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, int i2, int i3) {
        bVar.c(a(i3, (String) null), i2);
    }

    public h a(int i2, String str) {
        f fVar = g;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.ERROR, str);
        this.f539a++;
        this.d++;
        a2.f545a = this.f539a;
        a2.c = i2;
        this.f.c[this.f539a] = a2;
        this.j.d(a2);
        return a2;
    }

    private h a(h.a aVar, String str) {
        h a2 = this.f.f538b.a();
        if (a2 == null) {
            a2 = new h(aVar, str);
            a2.a(aVar, str);
        } else {
            a2.b();
            a2.a(aVar, str);
        }
        int i2 = this.p;
        int i3 = h;
        if (i2 >= i3) {
            h = i3 * 2;
            this.o = (h[]) Arrays.copyOf(this.o, h);
        }
        h[] hVarArr = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        hVarArr[i4] = a2;
        return a2;
    }

    public int b(Object obj) {
        h b2 = ((androidx.constraintlayout.a.a.e) obj).b();
        if (b2 != null) {
            return (int) (b2.d + 0.5f);
        }
        return 0;
    }

    public void f() throws Exception {
        f fVar = g;
        if (fVar != null) {
            fVar.e++;
        }
        if (this.c) {
            f fVar2 = g;
            if (fVar2 != null) {
                fVar2.r++;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.e) {
                    z = true;
                    break;
                } else if (!this.f540b[i2].e) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                a(this.j);
                return;
            }
            f fVar3 = g;
            if (fVar3 != null) {
                fVar3.q++;
            }
            j();
            return;
        }
        a(this.j);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) throws Exception {
        f fVar = g;
        if (fVar != null) {
            fVar.t++;
            f fVar2 = g;
            fVar2.u = Math.max(fVar2.u, (long) this.d);
            f fVar3 = g;
            fVar3.v = Math.max(fVar3.v, (long) this.e);
        }
        c((b) aVar);
        b(aVar);
        a(aVar, false);
        j();
    }

    private final void c(b bVar) {
        if (this.e > 0) {
            bVar.d.a(bVar, this.f540b);
            if (bVar.d.f513a == 0) {
                bVar.e = true;
            }
        }
    }

    public void a(b bVar) {
        h b2;
        if (bVar != null) {
            f fVar = g;
            if (fVar != null) {
                fVar.f++;
                if (bVar.e) {
                    g.g++;
                }
            }
            if (this.e + 1 >= this.n || this.d + 1 >= this.l) {
                h();
            }
            boolean z = false;
            if (!bVar.e) {
                c(bVar);
                if (!bVar.e()) {
                    bVar.d();
                    if (bVar.a(this)) {
                        h e2 = e();
                        bVar.f535a = e2;
                        d(bVar);
                        this.r.a(bVar);
                        a(this.r, true);
                        if (e2.f546b == -1) {
                            if (bVar.f535a == e2 && (b2 = bVar.b(e2)) != null) {
                                f fVar2 = g;
                                if (fVar2 != null) {
                                    fVar2.j++;
                                }
                                bVar.c(b2);
                            }
                            if (!bVar.e) {
                                bVar.f535a.c(bVar);
                            }
                            this.e--;
                        }
                        z = true;
                    }
                    if (!bVar.a()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z) {
                d(bVar);
            }
        }
    }

    private final void d(b bVar) {
        if (this.f540b[this.e] != null) {
            this.f.f537a.a(this.f540b[this.e]);
        }
        this.f540b[this.e] = bVar;
        h hVar = bVar.f535a;
        int i2 = this.e;
        hVar.f546b = i2;
        this.e = i2 + 1;
        bVar.f535a.c(bVar);
    }

    private final int a(a aVar, boolean z) {
        f fVar = g;
        if (fVar != null) {
            fVar.h++;
        }
        for (int i2 = 0; i2 < this.d; i2++) {
            this.m[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar2 = g;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i3++;
            if (i3 >= this.d * 2) {
                return i3;
            }
            if (aVar.g() != null) {
                this.m[aVar.g().f545a] = true;
            }
            h a2 = aVar.a(this, this.m);
            if (a2 != null) {
                if (this.m[a2.f545a]) {
                    return i3;
                }
                this.m[a2.f545a] = true;
            }
            if (a2 != null) {
                float f2 = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.e; i5++) {
                    b bVar = this.f540b[i5];
                    if (bVar.f535a.f != h.a.UNRESTRICTED && !bVar.e && bVar.a(a2)) {
                        float b2 = bVar.d.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-bVar.f536b) / b2;
                            if (f3 < f2) {
                                i4 = i5;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b bVar2 = this.f540b[i4];
                    bVar2.f535a.f546b = -1;
                    f fVar3 = g;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.c(a2);
                    bVar2.f535a.f546b = i4;
                    bVar2.f535a.c(bVar2);
                }
            }
            z2 = true;
        }
        return i3;
    }

    private int b(a aVar) throws Exception {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.e) {
                z = false;
                break;
            } else if (this.f540b[i2].f535a.f != h.a.UNRESTRICTED && this.f540b[i2].f536b < 0.0f) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar = g;
            if (fVar != null) {
                fVar.k++;
            }
            i3++;
            float f3 = Float.MAX_VALUE;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.e) {
                b bVar = this.f540b[i6];
                if (bVar.f535a.f != h.a.UNRESTRICTED && !bVar.e && bVar.f536b < f2) {
                    int i8 = 1;
                    while (i8 < this.d) {
                        h hVar = this.f.c[i8];
                        float b2 = bVar.d.b(hVar);
                        if (b2 > f2) {
                            int i9 = i7;
                            float f4 = f3;
                            int i10 = i5;
                            int i11 = i4;
                            for (int i12 = 0; i12 < 7; i12++) {
                                float f5 = hVar.e[i12] / b2;
                                if ((f5 < f4 && i12 == i9) || i12 > i9) {
                                    i10 = i8;
                                    i11 = i6;
                                    f4 = f5;
                                    i9 = i12;
                                }
                            }
                            i4 = i11;
                            i5 = i10;
                            f3 = f4;
                            i7 = i9;
                        }
                        i8++;
                        f2 = 0.0f;
                    }
                }
                i6++;
                f2 = 0.0f;
            }
            if (i4 != -1) {
                b bVar2 = this.f540b[i4];
                bVar2.f535a.f546b = -1;
                f fVar2 = g;
                if (fVar2 != null) {
                    fVar2.j++;
                }
                bVar2.c(this.f.c[i5]);
                bVar2.f535a.f546b = i4;
                bVar2.f535a.c(bVar2);
            } else {
                z2 = true;
            }
            if (i3 > this.d / 2) {
                z2 = true;
            }
            f2 = 0.0f;
        }
        return i3;
    }

    private void j() {
        for (int i2 = 0; i2 < this.e; i2++) {
            b bVar = this.f540b[i2];
            bVar.f535a.d = bVar.f536b;
        }
    }

    public c g() {
        return this.f;
    }

    public void a(h hVar, h hVar2, int i2, int i3) {
        b c2 = c();
        h d2 = d();
        d2.c = 0;
        c2.a(hVar, hVar2, d2, i2);
        if (i3 != 6) {
            a(c2, (int) (c2.d.b(d2) * -1.0f), i3);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, boolean z) {
        b c2 = c();
        h d2 = d();
        d2.c = 0;
        c2.a(hVar, hVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.d.b(d2) * -1.0f), 1);
        }
        a(c2);
    }

    public void b(h hVar, h hVar2, int i2, int i3) {
        b c2 = c();
        h d2 = d();
        d2.c = 0;
        c2.b(hVar, hVar2, d2, i2);
        if (i3 != 6) {
            a(c2, (int) (c2.d.b(d2) * -1.0f), i3);
        }
        a(c2);
    }

    public void b(h hVar, h hVar2, boolean z) {
        b c2 = c();
        h d2 = d();
        d2.c = 0;
        c2.b(hVar, hVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.d.b(d2) * -1.0f), 1);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, int i2, float f2, h hVar3, h hVar4, int i3, int i4) {
        int i5 = i4;
        b c2 = c();
        c2.a(hVar, hVar2, i2, f2, hVar3, hVar4, i3);
        if (i5 != 6) {
            c2.a(this, i5);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, h hVar3, h hVar4, float f2, int i2) {
        b c2 = c();
        c2.a(hVar, hVar2, hVar3, hVar4, f2);
        if (i2 != 6) {
            c2.a(this, i2);
        }
        a(c2);
    }

    public b c(h hVar, h hVar2, int i2, int i3) {
        b c2 = c();
        c2.a(hVar, hVar2, i2);
        if (i3 != 6) {
            c2.a(this, i3);
        }
        a(c2);
        return c2;
    }

    public void a(h hVar, int i2) {
        int i3 = hVar.f546b;
        if (hVar.f546b != -1) {
            b bVar = this.f540b[i3];
            if (bVar.e) {
                bVar.f536b = (float) i2;
            } else if (bVar.d.f513a == 0) {
                bVar.e = true;
                bVar.f536b = (float) i2;
            } else {
                b c2 = c();
                c2.b(hVar, i2);
                a(c2);
            }
        } else {
            b c3 = c();
            c3.a(hVar, i2);
            a(c3);
        }
    }

    public static b a(e eVar, h hVar, h hVar2, h hVar3, float f2, boolean z) {
        b c2 = eVar.c();
        if (z) {
            eVar.b(c2);
        }
        return c2.a(hVar, hVar2, hVar3, f2);
    }

    public void a(f fVar, f fVar2, float f2, int i2) {
        f fVar3 = fVar;
        f fVar4 = fVar2;
        h a2 = a((Object) fVar3.a(e.c.LEFT));
        h a3 = a((Object) fVar3.a(e.c.TOP));
        h a4 = a((Object) fVar3.a(e.c.RIGHT));
        h a5 = a((Object) fVar3.a(e.c.BOTTOM));
        h a6 = a((Object) fVar4.a(e.c.LEFT));
        h a7 = a((Object) fVar4.a(e.c.TOP));
        h a8 = a((Object) fVar4.a(e.c.RIGHT));
        h a9 = a((Object) fVar4.a(e.c.BOTTOM));
        b c2 = c();
        double d2 = (double) f2;
        h hVar = a4;
        double d3 = (double) i2;
        c2.b(a3, a5, a7, a9, (float) (Math.sin(d2) * d3));
        a(c2);
        b c3 = c();
        c3.b(a2, hVar, a6, a8, (float) (Math.cos(d2) * d3));
        a(c3);
    }
}
