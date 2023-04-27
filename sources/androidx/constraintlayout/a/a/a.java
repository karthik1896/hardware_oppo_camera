package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Analyzer */
public class a {
    public static void a(g gVar) {
        if ((gVar.J() & 32) != 32) {
            b(gVar);
            return;
        }
        gVar.ax = true;
        gVar.as = false;
        gVar.at = false;
        gVar.au = false;
        ArrayList<f> arrayList = gVar.az;
        List<h> list = gVar.ar;
        boolean z = gVar.F() == f.a.WRAP_CONTENT;
        boolean z2 = gVar.G() == f.a.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (f fVar : arrayList) {
            fVar.r = null;
            fVar.Y = false;
            fVar.b();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.r == null && !a(fVar2, list, z3)) {
                b(gVar);
                gVar.ax = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (h next : list) {
            i = Math.max(i, a(next, 0));
            i2 = Math.max(i2, a(next, 1));
        }
        if (z) {
            gVar.a(f.a.FIXED);
            gVar.j(i);
            gVar.as = true;
            gVar.at = true;
            gVar.av = i;
        }
        if (z2) {
            gVar.b(f.a.FIXED);
            gVar.k(i2);
            gVar.as = true;
            gVar.au = true;
            gVar.aw = i2;
        }
        a(list, 0, gVar.p());
        a(list, 1, gVar.r());
    }

    private static boolean a(f fVar, List<h> list, boolean z) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return a(fVar, hVar, list, z);
    }

    private static boolean a(f fVar, h hVar, List<h> list, boolean z) {
        if (fVar == null) {
            return true;
        }
        fVar.X = false;
        g gVar = (g) fVar.k();
        if (fVar.r == null) {
            fVar.W = true;
            hVar.f524a.add(fVar);
            fVar.r = hVar;
            if (fVar.s.c == null && fVar.u.c == null && fVar.t.c == null && fVar.v.c == null && fVar.w.c == null && fVar.z.c == null) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (!(fVar.t.c == null || fVar.v.c == null)) {
                f.a G = gVar.G();
                f.a aVar = f.a.WRAP_CONTENT;
                if (z) {
                    a(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.t.c.f517a == fVar.k() && fVar.v.c.f517a == fVar.k())) {
                    a(gVar, fVar, hVar);
                }
            }
            if (!(fVar.s.c == null || fVar.u.c == null)) {
                f.a F = gVar.F();
                f.a aVar2 = f.a.WRAP_CONTENT;
                if (z) {
                    a(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.s.c.f517a == fVar.k() && fVar.u.c.f517a == fVar.k())) {
                    a(gVar, fVar, hVar);
                }
            }
            if (((fVar.F() == f.a.MATCH_CONSTRAINT) ^ (fVar.G() == f.a.MATCH_CONSTRAINT)) && fVar.G != 0.0f) {
                a(fVar);
            } else if (fVar.F() == f.a.MATCH_CONSTRAINT || fVar.G() == f.a.MATCH_CONSTRAINT) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (((fVar.s.c == null && fVar.u.c == null) || ((fVar.s.c != null && fVar.s.c.f517a == fVar.D && fVar.u.c == null) || ((fVar.u.c != null && fVar.u.c.f517a == fVar.D && fVar.s.c == null) || (fVar.s.c != null && fVar.s.c.f517a == fVar.D && fVar.u.c != null && fVar.u.c.f517a == fVar.D)))) && fVar.z.c == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.f.add(fVar);
            }
            if (((fVar.t.c == null && fVar.v.c == null) || ((fVar.t.c != null && fVar.t.c.f517a == fVar.D && fVar.v.c == null) || ((fVar.v.c != null && fVar.v.c.f517a == fVar.D && fVar.t.c == null) || (fVar.t.c != null && fVar.t.c.f517a == fVar.D && fVar.v.c != null && fVar.v.c.f517a == fVar.D)))) && fVar.z.c == null && fVar.w.c == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.g.add(fVar);
            }
            if (fVar instanceof j) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
                j jVar = (j) fVar;
                for (int i = 0; i < jVar.aj; i++) {
                    if (!a(jVar.ai[i], hVar, list, z)) {
                        return false;
                    }
                }
            }
            for (e eVar : fVar.A) {
                if (!(eVar.c == null || eVar.c.f517a == fVar.k())) {
                    if (eVar.f518b == e.c.CENTER) {
                        a(gVar, fVar, hVar);
                        if (z) {
                            return false;
                        }
                    } else {
                        a(eVar);
                    }
                    if (!a(eVar.c.f517a, hVar, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (fVar.r != hVar) {
            hVar.f524a.addAll(fVar.r.f524a);
            hVar.f.addAll(fVar.r.f);
            hVar.g.addAll(fVar.r.g);
            if (!fVar.r.d) {
                hVar.d = false;
            }
            list.remove(fVar.r);
            for (f fVar2 : fVar.r.f524a) {
                fVar2.r = hVar;
            }
        }
        return true;
    }

    private static void a(g gVar, f fVar, h hVar) {
        hVar.d = false;
        gVar.ax = false;
        fVar.W = false;
    }

    private static int a(h hVar, int i) {
        int i2 = i * 2;
        List<f> a2 = hVar.a(i);
        int size = a2.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            f fVar = a2.get(i4);
            int i5 = i2 + 1;
            i3 = Math.max(i3, a(fVar, i, fVar.A[i5].c == null || !(fVar.A[i2].c == null || fVar.A[i5].c == null), 0));
        }
        hVar.e[i] = i3;
        return i3;
    }

    private static int a(f fVar, int i, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int p;
        int i9;
        int i10;
        f k;
        int i11;
        f fVar2 = fVar;
        int i12 = i;
        boolean z2 = z;
        int i13 = 0;
        if (!fVar2.W) {
            return 0;
        }
        boolean z3 = fVar2.w.c != null && i12 == 1;
        if (z2) {
            i6 = fVar.A();
            i5 = fVar.r() - fVar.A();
            i4 = i12 * 2;
            i3 = i4 + 1;
        } else {
            i6 = fVar.r() - fVar.A();
            i5 = fVar.A();
            i3 = i12 * 2;
            i4 = i3 + 1;
        }
        if (fVar2.A[i3].c == null || fVar2.A[i4].c != null) {
            i7 = i3;
            i8 = 1;
        } else {
            i7 = i4;
            i4 = i3;
            i8 = -1;
        }
        int i14 = z3 ? i2 - i6 : i2;
        int e = (fVar2.A[i4].e() * i8) + a(fVar, i);
        int i15 = i14 + e;
        int p2 = (i12 == 0 ? fVar.p() : fVar.r()) * i8;
        Iterator it = fVar2.A[i4].a().h.iterator();
        while (it.hasNext()) {
            i13 = Math.max(i13, a(((m) ((o) it.next())).f528a.f517a, i12, z2, i15));
        }
        int i16 = 0;
        for (Iterator it2 = fVar2.A[i7].a().h.iterator(); it2.hasNext(); it2 = it2) {
            i16 = Math.max(i16, a(((m) ((o) it2.next())).f528a.f517a, i12, z2, p2 + i15));
        }
        if (z3) {
            i13 -= i6;
            p = i16 + i5;
        } else {
            p = i16 + ((i12 == 0 ? fVar.p() : fVar.r()) * i8);
        }
        int i17 = 1;
        if (i12 == 1) {
            Iterator it3 = fVar2.w.a().h.iterator();
            int i18 = 0;
            while (it3.hasNext()) {
                Iterator it4 = it3;
                m mVar = (m) ((o) it3.next());
                if (i8 == i17) {
                    i18 = Math.max(i18, a(mVar.f528a.f517a, i12, z2, i6 + i15));
                    i11 = i7;
                } else {
                    i11 = i7;
                    i18 = Math.max(i18, a(mVar.f528a.f517a, i12, z2, (i5 * i8) + i15));
                }
                it3 = it4;
                i7 = i11;
                i17 = 1;
            }
            i9 = i7;
            int i19 = i18;
            i10 = (fVar2.w.a().h.size() <= 0 || z3) ? i19 : i8 == 1 ? i19 + i6 : i19 - i5;
        } else {
            i9 = i7;
            i10 = 0;
        }
        int max = e + Math.max(i13, Math.max(p, i10));
        int i20 = i15 + p2;
        if (i8 == -1) {
            int i21 = i15;
            i15 = i20;
            i20 = i21;
        }
        if (z2) {
            k.a(fVar2, i12, i15);
            fVar2.a(i15, i20, i12);
        } else {
            fVar2.r.a(fVar2, i12);
            fVar2.e(i15, i12);
        }
        if (fVar.t(i) == f.a.MATCH_CONSTRAINT && fVar2.G != 0.0f) {
            fVar2.r.a(fVar2, i12);
        }
        if (fVar2.A[i4].c != null && fVar2.A[i9].c != null && fVar2.A[i4].c.f517a == (k = fVar.k()) && fVar2.A[i9].c.f517a == k) {
            fVar2.r.a(fVar2, i12);
        }
        return max;
    }

    private static void a(e eVar) {
        m a2 = eVar.a();
        if (eVar.c != null && eVar.c.c != eVar) {
            eVar.c.a().a(a2);
        }
    }

    private static void b(g gVar) {
        gVar.ar.clear();
        gVar.ar.add(0, new h(gVar.az));
    }

    public static void a(List<h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (f next : list.get(i3).b(i)) {
                if (next.W) {
                    a(next, i, i2);
                }
            }
        }
    }

    private static void a(f fVar, int i, int i2) {
        int i3 = i * 2;
        e eVar = fVar.A[i3];
        e eVar2 = fVar.A[i3 + 1];
        if ((eVar.c == null || eVar2.c == null) ? false : true) {
            k.a(fVar, i, a(fVar, i) + eVar.e());
        } else if (fVar.G == 0.0f || fVar.t(i) != f.a.MATCH_CONSTRAINT) {
            int p = i2 - fVar.p(i);
            int f = p - fVar.f(i);
            fVar.a(f, p, i);
            k.a(fVar, i, f);
        } else {
            int a2 = a(fVar);
            int i4 = (int) fVar.A[i3].a().f;
            eVar2.a().e = eVar.a();
            eVar2.a().f = (float) a2;
            eVar2.a().i = 1;
            fVar.a(i4, i4 + a2, i);
        }
    }

    private static int a(f fVar, int i) {
        int i2 = i * 2;
        e eVar = fVar.A[i2];
        e eVar2 = fVar.A[i2 + 1];
        if (eVar.c == null || eVar.c.f517a != fVar.D || eVar2.c == null || eVar2.c.f517a != fVar.D) {
            return 0;
        }
        return (int) (((float) (((fVar.D.f(i) - eVar.e()) - eVar2.e()) - fVar.f(i))) * (i == 0 ? fVar.S : fVar.T));
    }

    private static int a(f fVar) {
        float f;
        float f2;
        if (fVar.F() == f.a.MATCH_CONSTRAINT) {
            if (fVar.H == 0) {
                f2 = ((float) fVar.r()) * fVar.G;
            } else {
                f2 = ((float) fVar.r()) / fVar.G;
            }
            int i = (int) f2;
            fVar.j(i);
            return i;
        } else if (fVar.G() != f.a.MATCH_CONSTRAINT) {
            return -1;
        } else {
            if (fVar.H == 1) {
                f = ((float) fVar.p()) * fVar.G;
            } else {
                f = ((float) fVar.p()) / fVar.G;
            }
            int i2 = (int) f;
            fVar.k(i2);
            return i2;
        }
    }
}
