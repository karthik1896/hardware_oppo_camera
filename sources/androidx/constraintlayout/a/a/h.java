package androidx.constraintlayout.a.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: ConstraintWidgetGroup */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<f> f524a;

    /* renamed from: b  reason: collision with root package name */
    int f525b = -1;
    int c = -1;
    public boolean d = false;
    public final int[] e = {this.f525b, this.c};
    List<f> f = new ArrayList();
    List<f> g = new ArrayList();
    HashSet<f> h = new HashSet<>();
    HashSet<f> i = new HashSet<>();
    List<f> j = new ArrayList();
    List<f> k = new ArrayList();

    h(List<f> list) {
        this.f524a = list;
    }

    h(List<f> list, boolean z) {
        this.f524a = list;
        this.d = z;
    }

    public List<f> a(int i2) {
        if (i2 == 0) {
            return this.f;
        }
        if (i2 == 1) {
            return this.g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Set<f> b(int i2) {
        if (i2 == 0) {
            return this.h;
        }
        if (i2 == 1) {
            return this.i;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar, int i2) {
        if (i2 == 0) {
            this.h.add(fVar);
        } else if (i2 == 1) {
            this.i.add(fVar);
        }
    }

    /* access modifiers changed from: package-private */
    public List<f> a() {
        if (!this.j.isEmpty()) {
            return this.j;
        }
        int size = this.f524a.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.f524a.get(i2);
            if (!fVar.W) {
                a((ArrayList<f>) (ArrayList) this.j, fVar);
            }
        }
        this.k.clear();
        this.k.addAll(this.f524a);
        this.k.removeAll(this.j);
        return this.j;
    }

    private void a(ArrayList<f> arrayList, f fVar) {
        if (!fVar.Y) {
            arrayList.add(fVar);
            fVar.Y = true;
            if (!fVar.h()) {
                if (fVar instanceof j) {
                    j jVar = (j) fVar;
                    int i2 = jVar.aj;
                    for (int i3 = 0; i3 < i2; i3++) {
                        a(arrayList, jVar.ai[i3]);
                    }
                }
                for (e eVar : fVar.A) {
                    e eVar2 = eVar.c;
                    if (eVar2 != null) {
                        f fVar2 = eVar2.f517a;
                        if (!(eVar2 == null || fVar2 == fVar.k())) {
                            a(arrayList, fVar2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int size = this.k.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.k.get(i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.constraintlayout.a.a.f r7) {
        /*
            r6 = this;
            boolean r0 = r7.W
            if (r0 == 0) goto L_0x00f1
            boolean r0 = r7.h()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            androidx.constraintlayout.a.a.e r0 = r7.u
            androidx.constraintlayout.a.a.e r0 = r0.c
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = r2
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x001d
            androidx.constraintlayout.a.a.e r3 = r7.u
            androidx.constraintlayout.a.a.e r3 = r3.c
            goto L_0x0021
        L_0x001d:
            androidx.constraintlayout.a.a.e r3 = r7.s
            androidx.constraintlayout.a.a.e r3 = r3.c
        L_0x0021:
            if (r3 == 0) goto L_0x004b
            androidx.constraintlayout.a.a.f r4 = r3.f517a
            boolean r4 = r4.X
            if (r4 != 0) goto L_0x002e
            androidx.constraintlayout.a.a.f r4 = r3.f517a
            r6.a((androidx.constraintlayout.a.a.f) r4)
        L_0x002e:
            androidx.constraintlayout.a.a.e$c r4 = r3.f518b
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.a.a.e.c.RIGHT
            if (r4 != r5) goto L_0x0040
            androidx.constraintlayout.a.a.f r4 = r3.f517a
            int r4 = r4.I
            androidx.constraintlayout.a.a.f r3 = r3.f517a
            int r3 = r3.p()
            int r3 = r3 + r4
            goto L_0x004c
        L_0x0040:
            androidx.constraintlayout.a.a.e$c r4 = r3.f518b
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.a.a.e.c.LEFT
            if (r4 != r5) goto L_0x004b
            androidx.constraintlayout.a.a.f r3 = r3.f517a
            int r3 = r3.I
            goto L_0x004c
        L_0x004b:
            r3 = r1
        L_0x004c:
            if (r0 == 0) goto L_0x0056
            androidx.constraintlayout.a.a.e r0 = r7.u
            int r0 = r0.e()
            int r3 = r3 - r0
            goto L_0x0062
        L_0x0056:
            androidx.constraintlayout.a.a.e r0 = r7.s
            int r0 = r0.e()
            int r4 = r7.p()
            int r0 = r0 + r4
            int r3 = r3 + r0
        L_0x0062:
            int r0 = r7.p()
            int r0 = r3 - r0
            r7.c(r0, r3)
            androidx.constraintlayout.a.a.e r0 = r7.w
            androidx.constraintlayout.a.a.e r0 = r0.c
            if (r0 == 0) goto L_0x0095
            androidx.constraintlayout.a.a.e r0 = r7.w
            androidx.constraintlayout.a.a.e r0 = r0.c
            androidx.constraintlayout.a.a.f r1 = r0.f517a
            boolean r1 = r1.X
            if (r1 != 0) goto L_0x0080
            androidx.constraintlayout.a.a.f r1 = r0.f517a
            r6.a((androidx.constraintlayout.a.a.f) r1)
        L_0x0080:
            androidx.constraintlayout.a.a.f r1 = r0.f517a
            int r1 = r1.J
            androidx.constraintlayout.a.a.f r0 = r0.f517a
            int r0 = r0.O
            int r1 = r1 + r0
            int r0 = r7.O
            int r1 = r1 - r0
            int r0 = r7.F
            int r0 = r0 + r1
            r7.d(r1, r0)
            r7.X = r2
            return
        L_0x0095:
            androidx.constraintlayout.a.a.e r0 = r7.v
            androidx.constraintlayout.a.a.e r0 = r0.c
            if (r0 == 0) goto L_0x009c
            r1 = r2
        L_0x009c:
            if (r1 == 0) goto L_0x00a3
            androidx.constraintlayout.a.a.e r0 = r7.v
            androidx.constraintlayout.a.a.e r0 = r0.c
            goto L_0x00a7
        L_0x00a3:
            androidx.constraintlayout.a.a.e r0 = r7.t
            androidx.constraintlayout.a.a.e r0 = r0.c
        L_0x00a7:
            if (r0 == 0) goto L_0x00d0
            androidx.constraintlayout.a.a.f r4 = r0.f517a
            boolean r4 = r4.X
            if (r4 != 0) goto L_0x00b4
            androidx.constraintlayout.a.a.f r4 = r0.f517a
            r6.a((androidx.constraintlayout.a.a.f) r4)
        L_0x00b4:
            androidx.constraintlayout.a.a.e$c r4 = r0.f518b
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.a.a.e.c.BOTTOM
            if (r4 != r5) goto L_0x00c6
            androidx.constraintlayout.a.a.f r3 = r0.f517a
            int r3 = r3.J
            androidx.constraintlayout.a.a.f r0 = r0.f517a
            int r0 = r0.r()
            int r3 = r3 + r0
            goto L_0x00d0
        L_0x00c6:
            androidx.constraintlayout.a.a.e$c r4 = r0.f518b
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.a.a.e.c.TOP
            if (r4 != r5) goto L_0x00d0
            androidx.constraintlayout.a.a.f r0 = r0.f517a
            int r3 = r0.J
        L_0x00d0:
            if (r1 == 0) goto L_0x00da
            androidx.constraintlayout.a.a.e r0 = r7.v
            int r0 = r0.e()
            int r3 = r3 - r0
            goto L_0x00e6
        L_0x00da:
            androidx.constraintlayout.a.a.e r0 = r7.t
            int r0 = r0.e()
            int r1 = r7.r()
            int r0 = r0 + r1
            int r3 = r3 + r0
        L_0x00e6:
            int r0 = r7.r()
            int r0 = r3 - r0
            r7.d(r0, r3)
            r7.X = r2
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.h.a(androidx.constraintlayout.a.a.f):void");
    }
}
