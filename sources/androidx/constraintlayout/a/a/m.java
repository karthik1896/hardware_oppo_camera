package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.e;
import androidx.constraintlayout.a.h;

/* compiled from: ResolutionAnchor */
public class m extends o {

    /* renamed from: a  reason: collision with root package name */
    e f528a;

    /* renamed from: b  reason: collision with root package name */
    float f529b;
    m c;
    float d;
    m e;
    float f;
    int g = 0;
    private m j;
    private float k;
    private n l = null;
    private int m = 1;
    private n n = null;
    private int o = 1;

    /* access modifiers changed from: package-private */
    public String a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public m(e eVar) {
        this.f528a = eVar;
    }

    public String toString() {
        if (this.i != 1) {
            return "{ " + this.f528a + " UNRESOLVED} type: " + a(this.g);
        } else if (this.e == this) {
            return "[" + this.f528a + ", RESOLVED: " + this.f + "]  type: " + a(this.g);
        } else {
            return "[" + this.f528a + ", RESOLVED: " + this.e + ":" + this.f + "] type: " + a(this.g);
        }
    }

    public void a(m mVar, float f2) {
        if (this.i == 0 || !(this.e == mVar || this.f == f2)) {
            this.e = mVar;
            this.f = f2;
            if (this.i == 1) {
                e();
            }
            f();
        }
    }

    public void a() {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        float f2;
        float f3;
        float f4;
        float f5;
        m mVar7;
        boolean z = true;
        if (this.i != 1 && this.g != 4) {
            n nVar = this.l;
            if (nVar != null) {
                if (nVar.i == 1) {
                    this.d = ((float) this.m) * this.l.f530a;
                } else {
                    return;
                }
            }
            n nVar2 = this.n;
            if (nVar2 != null) {
                if (nVar2.i == 1) {
                    this.k = ((float) this.o) * this.n.f530a;
                } else {
                    return;
                }
            }
            if (this.g == 1 && ((mVar7 = this.c) == null || mVar7.i == 1)) {
                m mVar8 = this.c;
                if (mVar8 == null) {
                    this.e = this;
                    this.f = this.d;
                } else {
                    this.e = mVar8.e;
                    this.f = mVar8.f + this.d;
                }
                f();
            } else if (this.g == 2 && (mVar4 = this.c) != null && mVar4.i == 1 && (mVar5 = this.j) != null && (mVar6 = mVar5.c) != null && mVar6.i == 1) {
                if (e.a() != null) {
                    e.a().w++;
                }
                this.e = this.c.e;
                m mVar9 = this.j;
                mVar9.e = mVar9.c.e;
                int i = 0;
                if (!(this.f528a.f518b == e.c.RIGHT || this.f528a.f518b == e.c.BOTTOM)) {
                    z = false;
                }
                if (z) {
                    f3 = this.c.f;
                    f2 = this.j.c.f;
                } else {
                    f3 = this.j.c.f;
                    f2 = this.c.f;
                }
                float f6 = f3 - f2;
                if (this.f528a.f518b == e.c.LEFT || this.f528a.f518b == e.c.RIGHT) {
                    f5 = f6 - ((float) this.f528a.f517a.p());
                    f4 = this.f528a.f517a.S;
                } else {
                    f5 = f6 - ((float) this.f528a.f517a.r());
                    f4 = this.f528a.f517a.T;
                }
                int e2 = this.f528a.e();
                int e3 = this.j.f528a.e();
                if (this.f528a.g() == this.j.f528a.g()) {
                    f4 = 0.5f;
                    e3 = 0;
                } else {
                    i = e2;
                }
                float f7 = (float) i;
                float f8 = (float) e3;
                float f9 = (f5 - f7) - f8;
                if (z) {
                    m mVar10 = this.j;
                    mVar10.f = mVar10.c.f + f8 + (f9 * f4);
                    this.f = (this.c.f - f7) - (f9 * (1.0f - f4));
                } else {
                    this.f = this.c.f + f7 + (f9 * f4);
                    m mVar11 = this.j;
                    mVar11.f = (mVar11.c.f - f8) - (f9 * (1.0f - f4));
                }
                f();
                this.j.f();
            } else if (this.g == 3 && (mVar = this.c) != null && mVar.i == 1 && (mVar2 = this.j) != null && (mVar3 = mVar2.c) != null && mVar3.i == 1) {
                if (androidx.constraintlayout.a.e.a() != null) {
                    androidx.constraintlayout.a.e.a().x++;
                }
                m mVar12 = this.c;
                this.e = mVar12.e;
                m mVar13 = this.j;
                m mVar14 = mVar13.c;
                mVar13.e = mVar14.e;
                this.f = mVar12.f + this.d;
                mVar13.f = mVar14.f + mVar13.d;
                f();
                this.j.f();
            } else if (this.g == 5) {
                this.f528a.f517a.c();
            }
        }
    }

    public void b(int i) {
        this.g = i;
    }

    public void b() {
        super.b();
        this.c = null;
        this.d = 0.0f;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.e = null;
        this.f = 0.0f;
        this.f529b = 0.0f;
        this.j = null;
        this.k = 0.0f;
        this.g = 0;
    }

    public void c() {
        e g2 = this.f528a.g();
        if (g2 != null) {
            if (g2.g() == this.f528a) {
                this.g = 4;
                g2.a().g = 4;
            }
            int e2 = this.f528a.e();
            if (this.f528a.f518b == e.c.RIGHT || this.f528a.f518b == e.c.BOTTOM) {
                e2 = -e2;
            }
            a(g2.a(), e2);
        }
    }

    public void a(int i, m mVar, int i2) {
        this.g = i;
        this.c = mVar;
        this.d = (float) i2;
        this.c.a(this);
    }

    public void a(m mVar, int i) {
        this.c = mVar;
        this.d = (float) i;
        this.c.a(this);
    }

    public void a(m mVar, int i, n nVar) {
        this.c = mVar;
        this.c.a(this);
        this.l = nVar;
        this.m = i;
        this.l.a(this);
    }

    public void b(m mVar, float f2) {
        this.j = mVar;
        this.k = f2;
    }

    public void b(m mVar, int i, n nVar) {
        this.j = mVar;
        this.n = nVar;
        this.o = i;
    }

    /* access modifiers changed from: package-private */
    public void a(androidx.constraintlayout.a.e eVar) {
        h b2 = this.f528a.b();
        m mVar = this.e;
        if (mVar == null) {
            eVar.a(b2, (int) (this.f + 0.5f));
        } else {
            eVar.c(b2, eVar.a((Object) mVar.f528a), (int) (this.f + 0.5f), 6);
        }
    }

    public float d() {
        return this.f;
    }
}
