package androidx.constraintlayout.a;

import androidx.constraintlayout.a.e;
import androidx.constraintlayout.a.h;

/* compiled from: ArrayRow */
public class b implements e.a {

    /* renamed from: a  reason: collision with root package name */
    h f535a = null;

    /* renamed from: b  reason: collision with root package name */
    float f536b = 0.0f;
    boolean c = false;
    public final a d;
    boolean e = false;

    public b(c cVar) {
        this.d = new a(this, cVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        h hVar = this.f535a;
        return hVar != null && (hVar.f == h.a.UNRESTRICTED || this.f536b >= 0.0f);
    }

    public String toString() {
        return b();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b() {
        /*
            r10 = this;
            androidx.constraintlayout.a.h r0 = r10.f535a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.a.h r1 = r10.f535a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f536b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f536b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L_0x0057
        L_0x0056:
            r1 = r3
        L_0x0057:
            androidx.constraintlayout.a.a r5 = r10.d
            int r5 = r5.f513a
        L_0x005b:
            if (r3 >= r5) goto L_0x00e9
            androidx.constraintlayout.a.a r6 = r10.d
            androidx.constraintlayout.a.h r6 = r6.a((int) r3)
            if (r6 != 0) goto L_0x0067
            goto L_0x00e5
        L_0x0067:
            androidx.constraintlayout.a.a r7 = r10.d
            float r7 = r7.b((int) r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0073
            goto L_0x00e5
        L_0x0073:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0091
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b6
        L_0x0091:
            if (r8 <= 0) goto L_0x00a5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b7
        L_0x00a5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b6:
            float r7 = r7 * r9
        L_0x00b7:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00cd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e4
        L_0x00cd:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e4:
            r1 = r4
        L_0x00e5:
            int r3 = r3 + 1
            goto L_0x005b
        L_0x00e9:
            if (r1 != 0) goto L_0x00fc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00fc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.b.b():java.lang.String");
    }

    public void c() {
        this.f535a = null;
        this.d.a();
        this.f536b = 0.0f;
        this.e = false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(h hVar) {
        return this.d.a(hVar);
    }

    /* access modifiers changed from: package-private */
    public b a(h hVar, int i) {
        this.f535a = hVar;
        float f = (float) i;
        hVar.d = f;
        this.f536b = f;
        this.e = true;
        return this;
    }

    public b b(h hVar, int i) {
        if (i < 0) {
            this.f536b = (float) (i * -1);
            this.d.a(hVar, 1.0f);
        } else {
            this.f536b = (float) i;
            this.d.a(hVar, -1.0f);
        }
        return this;
    }

    public b a(h hVar, h hVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f536b = (float) i;
        }
        if (!z) {
            this.d.a(hVar, -1.0f);
            this.d.a(hVar2, 1.0f);
        } else {
            this.d.a(hVar, 1.0f);
            this.d.a(hVar2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public b c(h hVar, int i) {
        this.d.a(hVar, (float) i);
        return this;
    }

    public b a(h hVar, h hVar2, h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f536b = (float) i;
        }
        if (!z) {
            this.d.a(hVar, -1.0f);
            this.d.a(hVar2, 1.0f);
            this.d.a(hVar3, 1.0f);
        } else {
            this.d.a(hVar, 1.0f);
            this.d.a(hVar2, -1.0f);
            this.d.a(hVar3, -1.0f);
        }
        return this;
    }

    public b b(h hVar, h hVar2, h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f536b = (float) i;
        }
        if (!z) {
            this.d.a(hVar, -1.0f);
            this.d.a(hVar2, 1.0f);
            this.d.a(hVar3, -1.0f);
        } else {
            this.d.a(hVar, 1.0f);
            this.d.a(hVar2, -1.0f);
            this.d.a(hVar3, 1.0f);
        }
        return this;
    }

    public b a(float f, float f2, float f3, h hVar, h hVar2, h hVar3, h hVar4) {
        this.f536b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.d.a(hVar, 1.0f);
            this.d.a(hVar2, -1.0f);
            this.d.a(hVar4, 1.0f);
            this.d.a(hVar3, -1.0f);
        } else if (f == 0.0f) {
            this.d.a(hVar, 1.0f);
            this.d.a(hVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.d.a(hVar3, 1.0f);
            this.d.a(hVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.d.a(hVar, 1.0f);
            this.d.a(hVar2, -1.0f);
            this.d.a(hVar4, f4);
            this.d.a(hVar3, -f4);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(h hVar, h hVar2, int i, float f, h hVar3, h hVar4, int i2) {
        if (hVar2 == hVar3) {
            this.d.a(hVar, 1.0f);
            this.d.a(hVar4, 1.0f);
            this.d.a(hVar2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.d.a(hVar, 1.0f);
            this.d.a(hVar2, -1.0f);
            this.d.a(hVar3, -1.0f);
            this.d.a(hVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f536b = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            this.d.a(hVar, -1.0f);
            this.d.a(hVar2, 1.0f);
            this.f536b = (float) i;
        } else if (f >= 1.0f) {
            this.d.a(hVar3, -1.0f);
            this.d.a(hVar4, 1.0f);
            this.f536b = (float) i2;
        } else {
            float f2 = 1.0f - f;
            this.d.a(hVar, f2 * 1.0f);
            this.d.a(hVar2, f2 * -1.0f);
            this.d.a(hVar3, -1.0f * f);
            this.d.a(hVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f536b = (((float) (-i)) * f2) + (((float) i2) * f);
            }
        }
        return this;
    }

    public b a(e eVar, int i) {
        this.d.a(eVar.a(i, "ep"), 1.0f);
        this.d.a(eVar.a(i, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(h hVar, h hVar2, h hVar3, float f) {
        this.d.a(hVar, -1.0f);
        this.d.a(hVar2, 1.0f - f);
        this.d.a(hVar3, f);
        return this;
    }

    public b a(h hVar, h hVar2, h hVar3, h hVar4, float f) {
        this.d.a(hVar, -1.0f);
        this.d.a(hVar2, 1.0f);
        this.d.a(hVar3, f);
        this.d.a(hVar4, -f);
        return this;
    }

    public b b(h hVar, h hVar2, h hVar3, h hVar4, float f) {
        this.d.a(hVar3, 0.5f);
        this.d.a(hVar4, 0.5f);
        this.d.a(hVar, -0.5f);
        this.d.a(hVar2, -0.5f);
        this.f536b = -f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        float f = this.f536b;
        if (f < 0.0f) {
            this.f536b = f * -1.0f;
            this.d.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(e eVar) {
        boolean z;
        h a2 = this.d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            c(a2);
            z = false;
        }
        if (this.d.f513a == 0) {
            this.e = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public h b(h hVar) {
        return this.d.a((boolean[]) null, hVar);
    }

    /* access modifiers changed from: package-private */
    public void c(h hVar) {
        h hVar2 = this.f535a;
        if (hVar2 != null) {
            this.d.a(hVar2, -1.0f);
            this.f535a = null;
        }
        float a2 = this.d.a(hVar, true) * -1.0f;
        this.f535a = hVar;
        if (a2 != 1.0f) {
            this.f536b /= a2;
            this.d.a(a2);
        }
    }

    public boolean e() {
        return this.f535a == null && this.f536b == 0.0f && this.d.f513a == 0;
    }

    public h a(e eVar, boolean[] zArr) {
        return this.d.a(zArr, (h) null);
    }

    public void f() {
        this.d.a();
        this.f535a = null;
        this.f536b = 0.0f;
    }

    public void a(e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f535a = null;
            this.d.a();
            for (int i = 0; i < bVar.d.f513a; i++) {
                this.d.a(bVar.d.a(i), bVar.d.b(i), true);
            }
        }
    }

    public void d(h hVar) {
        float f = 1.0f;
        if (hVar.c != 1) {
            if (hVar.c == 2) {
                f = 1000.0f;
            } else if (hVar.c == 3) {
                f = 1000000.0f;
            } else if (hVar.c == 4) {
                f = 1.0E9f;
            } else if (hVar.c == 5) {
                f = 1.0E12f;
            }
        }
        this.d.a(hVar, f);
    }

    public h g() {
        return this.f535a;
    }
}
