package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ConstraintWidgetContainer */
public class g extends q {
    private boolean aA = false;
    private p aB;
    private int aC = 7;
    private boolean aD = false;
    private boolean aE = false;
    protected e ai = new e();
    int aj;
    int ak;
    int al;
    int am;
    int an = 0;
    int ao = 0;
    d[] ap = new d[4];
    d[] aq = new d[4];
    public List<h> ar = new ArrayList();
    public boolean as = false;
    public boolean at = false;
    public boolean au = false;
    public int av = 0;
    public int aw = 0;
    public boolean ax = false;
    int ay = 0;

    public boolean S() {
        return false;
    }

    public void a(int i) {
        this.aC = i;
    }

    public int J() {
        return this.aC;
    }

    public boolean u(int i) {
        return (this.aC & i) == i;
    }

    public void f() {
        this.ai.b();
        this.aj = 0;
        this.al = 0;
        this.ak = 0;
        this.am = 0;
        this.ar.clear();
        this.ax = false;
        super.f();
    }

    public boolean K() {
        return this.aD;
    }

    public boolean L() {
        return this.aE;
    }

    public boolean d(e eVar) {
        a(eVar);
        int size = this.az.size();
        for (int i = 0; i < size; i++) {
            f fVar = (f) this.az.get(i);
            if (fVar instanceof g) {
                f.a aVar = fVar.C[0];
                f.a aVar2 = fVar.C[1];
                if (aVar == f.a.WRAP_CONTENT) {
                    fVar.a(f.a.FIXED);
                }
                if (aVar2 == f.a.WRAP_CONTENT) {
                    fVar.b(f.a.FIXED);
                }
                fVar.a(eVar);
                if (aVar == f.a.WRAP_CONTENT) {
                    fVar.a(aVar);
                }
                if (aVar2 == f.a.WRAP_CONTENT) {
                    fVar.b(aVar2);
                }
            } else {
                k.a(this, eVar, fVar);
                fVar.a(eVar);
            }
        }
        if (this.an > 0) {
            c.a(this, eVar, 0);
        }
        if (this.ao > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    public void a(e eVar, boolean[] zArr) {
        zArr[2] = false;
        c(eVar);
        int size = this.az.size();
        for (int i = 0; i < size; i++) {
            f fVar = (f) this.az.get(i);
            fVar.c(eVar);
            if (fVar.C[0] == f.a.MATCH_CONSTRAINT && fVar.p() < fVar.q()) {
                zArr[2] = true;
            }
            if (fVar.C[1] == f.a.MATCH_CONSTRAINT && fVar.r() < fVar.s()) {
                zArr[2] = true;
            }
        }
    }

    public void a(boolean z) {
        this.aA = z;
    }

    public boolean M() {
        return this.aA;
    }

    public void b(int i) {
        super.b(i);
        int size = this.az.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((f) this.az.get(i2)).b(i);
        }
    }

    /* JADX WARNING: type inference failed for: r8v15, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void N() {
        /*
            r21 = this;
            r1 = r21
            int r2 = r1.I
            int r3 = r1.J
            int r0 = r21.p()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r21.r()
            int r6 = java.lang.Math.max(r4, r0)
            r1.aD = r4
            r1.aE = r4
            androidx.constraintlayout.a.a.f r0 = r1.D
            if (r0 == 0) goto L_0x0046
            androidx.constraintlayout.a.a.p r0 = r1.aB
            if (r0 != 0) goto L_0x002a
            androidx.constraintlayout.a.a.p r0 = new androidx.constraintlayout.a.a.p
            r0.<init>(r1)
            r1.aB = r0
        L_0x002a:
            androidx.constraintlayout.a.a.p r0 = r1.aB
            r0.a(r1)
            int r0 = r1.aj
            r1.h(r0)
            int r0 = r1.ak
            r1.i(r0)
            r21.E()
            androidx.constraintlayout.a.e r0 = r1.ai
            androidx.constraintlayout.a.c r0 = r0.g()
            r1.a(r0)
            goto L_0x004a
        L_0x0046:
            r1.I = r4
            r1.J = r4
        L_0x004a:
            int r0 = r1.aC
            r7 = 32
            r8 = 8
            r9 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r1.u(r8)
            if (r0 != 0) goto L_0x005c
            r21.Q()
        L_0x005c:
            boolean r0 = r1.u(r7)
            if (r0 != 0) goto L_0x0065
            r21.R()
        L_0x0065:
            androidx.constraintlayout.a.e r0 = r1.ai
            r0.c = r9
            goto L_0x006e
        L_0x006a:
            androidx.constraintlayout.a.e r0 = r1.ai
            r0.c = r4
        L_0x006e:
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            r10 = r0[r9]
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            r11 = r0[r4]
            r21.V()
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.ar
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0092
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.ar
            r0.clear()
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.ar
            androidx.constraintlayout.a.a.h r12 = new androidx.constraintlayout.a.a.h
            java.util.ArrayList r13 = r1.az
            r12.<init>(r13)
            r0.add(r4, r12)
        L_0x0092:
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.ar
            int r12 = r0.size()
            java.util.ArrayList r13 = r1.az
            androidx.constraintlayout.a.a.f$a r0 = r21.F()
            androidx.constraintlayout.a.a.f$a r14 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r0 == r14) goto L_0x00ad
            androidx.constraintlayout.a.a.f$a r0 = r21.G()
            androidx.constraintlayout.a.a.f$a r14 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r0 != r14) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r14 = r4
            goto L_0x00ae
        L_0x00ad:
            r14 = r9
        L_0x00ae:
            r0 = r4
            r15 = r0
        L_0x00b0:
            if (r15 >= r12) goto L_0x02f7
            boolean r8 = r1.ax
            if (r8 != 0) goto L_0x02f7
            java.util.List<androidx.constraintlayout.a.a.h> r8 = r1.ar
            java.lang.Object r8 = r8.get(r15)
            androidx.constraintlayout.a.a.h r8 = (androidx.constraintlayout.a.a.h) r8
            boolean r8 = r8.d
            if (r8 == 0) goto L_0x00c6
            r19 = r12
            goto L_0x02eb
        L_0x00c6:
            boolean r8 = r1.u(r7)
            if (r8 == 0) goto L_0x00fb
            androidx.constraintlayout.a.a.f$a r8 = r21.F()
            androidx.constraintlayout.a.a.f$a r7 = androidx.constraintlayout.a.a.f.a.FIXED
            if (r8 != r7) goto L_0x00ed
            androidx.constraintlayout.a.a.f$a r7 = r21.G()
            androidx.constraintlayout.a.a.f$a r8 = androidx.constraintlayout.a.a.f.a.FIXED
            if (r7 != r8) goto L_0x00ed
            java.util.List<androidx.constraintlayout.a.a.h> r7 = r1.ar
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.a.a.h r7 = (androidx.constraintlayout.a.a.h) r7
            java.util.List r7 = r7.a()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.az = r7
            goto L_0x00fb
        L_0x00ed:
            java.util.List<androidx.constraintlayout.a.a.h> r7 = r1.ar
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.a.a.h r7 = (androidx.constraintlayout.a.a.h) r7
            java.util.List<androidx.constraintlayout.a.a.f> r7 = r7.f524a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.az = r7
        L_0x00fb:
            r21.V()
            java.util.ArrayList r7 = r1.az
            int r7 = r7.size()
            r8 = r4
        L_0x0105:
            if (r8 >= r7) goto L_0x011d
            java.util.ArrayList r4 = r1.az
            java.lang.Object r4 = r4.get(r8)
            androidx.constraintlayout.a.a.f r4 = (androidx.constraintlayout.a.a.f) r4
            boolean r9 = r4 instanceof androidx.constraintlayout.a.a.q
            if (r9 == 0) goto L_0x0118
            androidx.constraintlayout.a.a.q r4 = (androidx.constraintlayout.a.a.q) r4
            r4.N()
        L_0x0118:
            int r8 = r8 + 1
            r4 = 0
            r9 = 1
            goto L_0x0105
        L_0x011d:
            r9 = r0
            r0 = 0
            r4 = 1
        L_0x0120:
            if (r4 == 0) goto L_0x02da
            r17 = r4
            r8 = 1
            int r4 = r0 + 1
            androidx.constraintlayout.a.e r0 = r1.ai     // Catch:{ Exception -> 0x0164 }
            r0.b()     // Catch:{ Exception -> 0x0164 }
            r21.V()     // Catch:{ Exception -> 0x0164 }
            androidx.constraintlayout.a.e r0 = r1.ai     // Catch:{ Exception -> 0x0164 }
            r1.b((androidx.constraintlayout.a.e) r0)     // Catch:{ Exception -> 0x0164 }
            r0 = 0
        L_0x0135:
            if (r0 >= r7) goto L_0x014b
            java.util.ArrayList r8 = r1.az     // Catch:{ Exception -> 0x0164 }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ Exception -> 0x0164 }
            androidx.constraintlayout.a.a.f r8 = (androidx.constraintlayout.a.a.f) r8     // Catch:{ Exception -> 0x0164 }
            r18 = r9
            androidx.constraintlayout.a.e r9 = r1.ai     // Catch:{ Exception -> 0x0162 }
            r8.b((androidx.constraintlayout.a.e) r9)     // Catch:{ Exception -> 0x0162 }
            int r0 = r0 + 1
            r9 = r18
            goto L_0x0135
        L_0x014b:
            r18 = r9
            androidx.constraintlayout.a.e r0 = r1.ai     // Catch:{ Exception -> 0x0162 }
            boolean r8 = r1.d((androidx.constraintlayout.a.e) r0)     // Catch:{ Exception -> 0x0162 }
            if (r8 == 0) goto L_0x015d
            androidx.constraintlayout.a.e r0 = r1.ai     // Catch:{ Exception -> 0x015b }
            r0.f()     // Catch:{ Exception -> 0x015b }
            goto L_0x015d
        L_0x015b:
            r0 = move-exception
            goto L_0x0169
        L_0x015d:
            r17 = r8
            r19 = r12
            goto L_0x0186
        L_0x0162:
            r0 = move-exception
            goto L_0x0167
        L_0x0164:
            r0 = move-exception
            r18 = r9
        L_0x0167:
            r8 = r17
        L_0x0169:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r17 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r19 = r12
            java.lang.String r12 = "EXCEPTION : "
            r8.append(r12)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r9.println(r0)
        L_0x0186:
            if (r17 == 0) goto L_0x0191
            androidx.constraintlayout.a.e r8 = r1.ai
            boolean[] r9 = androidx.constraintlayout.a.a.k.f527a
            r1.a((androidx.constraintlayout.a.e) r8, (boolean[]) r9)
        L_0x018f:
            r9 = 2
            goto L_0x01db
        L_0x0191:
            androidx.constraintlayout.a.e r8 = r1.ai
            r1.c((androidx.constraintlayout.a.e) r8)
            r8 = 0
        L_0x0197:
            if (r8 >= r7) goto L_0x018f
            java.util.ArrayList r9 = r1.az
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.a.a.f r9 = (androidx.constraintlayout.a.a.f) r9
            androidx.constraintlayout.a.a.f$a[] r12 = r9.C
            r16 = 0
            r12 = r12[r16]
            androidx.constraintlayout.a.a.f$a r0 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r12 != r0) goto L_0x01bd
            int r0 = r9.p()
            int r12 = r9.q()
            if (r0 >= r12) goto L_0x01bd
            boolean[] r0 = androidx.constraintlayout.a.a.k.f527a
            r8 = 2
            r12 = 1
            r0[r8] = r12
            r9 = r8
            goto L_0x01db
        L_0x01bd:
            r12 = 1
            androidx.constraintlayout.a.a.f$a[] r0 = r9.C
            r0 = r0[r12]
            androidx.constraintlayout.a.a.f$a r12 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r0 != r12) goto L_0x01d7
            int r0 = r9.r()
            int r9 = r9.s()
            if (r0 >= r9) goto L_0x01d7
            boolean[] r0 = androidx.constraintlayout.a.a.k.f527a
            r8 = 1
            r9 = 2
            r0[r9] = r8
            goto L_0x01db
        L_0x01d7:
            r9 = 2
            int r8 = r8 + 1
            goto L_0x0197
        L_0x01db:
            if (r14 == 0) goto L_0x0255
            r8 = 8
            if (r4 >= r8) goto L_0x0255
            boolean[] r0 = androidx.constraintlayout.a.a.k.f527a
            boolean r0 = r0[r9]
            if (r0 == 0) goto L_0x0255
            r0 = 0
            r9 = 0
            r12 = 0
        L_0x01ea:
            if (r0 >= r7) goto L_0x0214
            java.util.ArrayList r8 = r1.az
            java.lang.Object r8 = r8.get(r0)
            androidx.constraintlayout.a.a.f r8 = (androidx.constraintlayout.a.a.f) r8
            r17 = r4
            int r4 = r8.I
            int r20 = r8.p()
            int r4 = r4 + r20
            int r9 = java.lang.Math.max(r9, r4)
            int r4 = r8.J
            int r8 = r8.r()
            int r4 = r4 + r8
            int r12 = java.lang.Math.max(r12, r4)
            int r0 = r0 + 1
            r4 = r17
            r8 = 8
            goto L_0x01ea
        L_0x0214:
            r17 = r4
            int r0 = r1.P
            int r0 = java.lang.Math.max(r0, r9)
            int r4 = r1.Q
            int r4 = java.lang.Math.max(r4, r12)
            androidx.constraintlayout.a.a.f$a r8 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r11 != r8) goto L_0x023a
            int r8 = r21.p()
            if (r8 >= r0) goto L_0x023a
            r1.j(r0)
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            androidx.constraintlayout.a.a.f$a r8 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            r9 = 0
            r0[r9] = r8
            r0 = 1
            r18 = 1
            goto L_0x023b
        L_0x023a:
            r0 = 0
        L_0x023b:
            androidx.constraintlayout.a.a.f$a r8 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r10 != r8) goto L_0x0252
            int r8 = r21.r()
            if (r8 >= r4) goto L_0x0252
            r1.k(r4)
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r9 = 1
            goto L_0x025a
        L_0x0252:
            r9 = r18
            goto L_0x025a
        L_0x0255:
            r17 = r4
            r9 = r18
            r0 = 0
        L_0x025a:
            int r4 = r1.P
            int r8 = r21.p()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.p()
            if (r4 <= r8) goto L_0x0276
            r1.j(r4)
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.a.a.f.a.FIXED
            r8 = 0
            r0[r8] = r4
            r0 = 1
            r9 = 1
        L_0x0276:
            int r4 = r1.Q
            int r8 = r21.r()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.r()
            if (r4 <= r8) goto L_0x0293
            r1.k(r4)
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.a.a.f.a.FIXED
            r8 = 1
            r0[r8] = r4
            r0 = r8
            r9 = r0
            goto L_0x0294
        L_0x0293:
            r8 = 1
        L_0x0294:
            if (r9 != 0) goto L_0x02d3
            androidx.constraintlayout.a.a.f$a[] r4 = r1.C
            r12 = 0
            r4 = r4[r12]
            androidx.constraintlayout.a.a.f$a r12 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r4 != r12) goto L_0x02b5
            if (r5 <= 0) goto L_0x02b5
            int r4 = r21.p()
            if (r4 <= r5) goto L_0x02b5
            r1.aD = r8
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.a.a.f.a.FIXED
            r9 = 0
            r0[r9] = r4
            r1.j(r5)
            r0 = r8
            r9 = r0
        L_0x02b5:
            androidx.constraintlayout.a.a.f$a[] r4 = r1.C
            r4 = r4[r8]
            androidx.constraintlayout.a.a.f$a r12 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r4 != r12) goto L_0x02d3
            if (r6 <= 0) goto L_0x02d3
            int r4 = r21.r()
            if (r4 <= r6) goto L_0x02d3
            r1.aE = r8
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.a.a.f.a.FIXED
            r0[r8] = r4
            r1.k(r6)
            r4 = 1
            r9 = 1
            goto L_0x02d4
        L_0x02d3:
            r4 = r0
        L_0x02d4:
            r0 = r17
            r12 = r19
            goto L_0x0120
        L_0x02da:
            r18 = r9
            r19 = r12
            java.util.List<androidx.constraintlayout.a.a.h> r0 = r1.ar
            java.lang.Object r0 = r0.get(r15)
            androidx.constraintlayout.a.a.h r0 = (androidx.constraintlayout.a.a.h) r0
            r0.b()
            r0 = r18
        L_0x02eb:
            int r15 = r15 + 1
            r12 = r19
            r4 = 0
            r7 = 32
            r8 = 8
            r9 = 1
            goto L_0x00b0
        L_0x02f7:
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            r1.az = r13
            androidx.constraintlayout.a.a.f r4 = r1.D
            if (r4 == 0) goto L_0x032b
            int r2 = r1.P
            int r3 = r21.p()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.Q
            int r4 = r21.r()
            int r3 = java.lang.Math.max(r3, r4)
            androidx.constraintlayout.a.a.p r4 = r1.aB
            r4.b(r1)
            int r4 = r1.aj
            int r2 = r2 + r4
            int r4 = r1.al
            int r2 = r2 + r4
            r1.j(r2)
            int r2 = r1.ak
            int r3 = r3 + r2
            int r2 = r1.am
            int r3 = r3 + r2
            r1.k(r3)
            goto L_0x032f
        L_0x032b:
            r1.I = r2
            r1.J = r3
        L_0x032f:
            if (r0 == 0) goto L_0x033b
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            r2 = 0
            r0[r2] = r11
            androidx.constraintlayout.a.a.f$a[] r0 = r1.C
            r2 = 1
            r0[r2] = r10
        L_0x033b:
            androidx.constraintlayout.a.e r0 = r1.ai
            androidx.constraintlayout.a.c r0 = r0.g()
            r1.a(r0)
            androidx.constraintlayout.a.a.g r0 = r21.T()
            if (r1 != r0) goto L_0x034d
            r21.D()
        L_0x034d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.g.N():void");
    }

    public void O() {
        Q();
        b(this.aC);
    }

    public void P() {
        m a2 = a(e.c.LEFT).a();
        m a3 = a(e.c.TOP).a();
        a2.a((m) null, 0.0f);
        a3.a((m) null, 0.0f);
    }

    public void f(int i, int i2) {
        if (!(this.C[0] == f.a.WRAP_CONTENT || this.c == null)) {
            this.c.a(i);
        }
        if (this.C[1] != f.a.WRAP_CONTENT && this.d != null) {
            this.d.a(i2);
        }
    }

    public void Q() {
        int size = this.az.size();
        b();
        for (int i = 0; i < size; i++) {
            ((f) this.az.get(i)).b();
        }
    }

    public void R() {
        if (!u(8)) {
            b(this.aC);
        }
        P();
    }

    private void V() {
        this.an = 0;
        this.ao = 0;
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar, int i) {
        if (i == 0) {
            d(fVar);
        } else if (i == 1) {
            e(fVar);
        }
    }

    private void d(f fVar) {
        int i = this.an + 1;
        d[] dVarArr = this.aq;
        if (i >= dVarArr.length) {
            this.aq = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.aq[this.an] = new d(fVar, 0, M());
        this.an++;
    }

    private void e(f fVar) {
        int i = this.ao + 1;
        d[] dVarArr = this.ap;
        if (i >= dVarArr.length) {
            this.ap = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.ap[this.ao] = new d(fVar, 1, M());
        this.ao++;
    }
}
