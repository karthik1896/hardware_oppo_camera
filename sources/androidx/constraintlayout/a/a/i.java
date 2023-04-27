package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.h;
import java.util.ArrayList;

/* compiled from: Guideline */
public class i extends f {
    protected float ai = -1.0f;
    protected int aj = -1;
    protected int ak = -1;
    private e al = this.t;
    private int am;
    private boolean an;
    private int ao;
    private l ap;
    private int aq;

    public boolean a() {
        return true;
    }

    public i() {
        this.am = 0;
        this.an = false;
        this.ao = 0;
        this.ap = new l();
        this.aq = 8;
        this.B.clear();
        this.B.add(this.al);
        int length = this.A.length;
        for (int i = 0; i < length; i++) {
            this.A[i] = this.al;
        }
    }

    public void a(int i) {
        if (this.am != i) {
            this.am = i;
            this.B.clear();
            if (this.am == 1) {
                this.al = this.s;
            } else {
                this.al = this.t;
            }
            this.B.add(this.al);
            int length = this.A.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.A[i2] = this.al;
            }
        }
    }

    public int J() {
        return this.am;
    }

    public e a(e.c cVar) {
        switch (cVar) {
            case LEFT:
            case RIGHT:
                if (this.am == 1) {
                    return this.al;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.am == 0) {
                    return this.al;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(cVar.name());
    }

    public ArrayList<e> C() {
        return this.B;
    }

    public void e(float f) {
        if (f > -1.0f) {
            this.ai = f;
            this.aj = -1;
            this.ak = -1;
        }
    }

    public void u(int i) {
        if (i > -1) {
            this.ai = -1.0f;
            this.aj = i;
            this.ak = -1;
        }
    }

    public void v(int i) {
        if (i > -1) {
            this.ai = -1.0f;
            this.aj = -1;
            this.ak = i;
        }
    }

    public void b(int i) {
        f k = k();
        if (k != null) {
            if (J() == 1) {
                this.t.a().a(1, k.t.a(), 0);
                this.v.a().a(1, k.t.a(), 0);
                if (this.aj != -1) {
                    this.s.a().a(1, k.s.a(), this.aj);
                    this.u.a().a(1, k.s.a(), this.aj);
                } else if (this.ak != -1) {
                    this.s.a().a(1, k.u.a(), -this.ak);
                    this.u.a().a(1, k.u.a(), -this.ak);
                } else if (this.ai != -1.0f && k.F() == f.a.FIXED) {
                    int i2 = (int) (((float) k.E) * this.ai);
                    this.s.a().a(1, k.s.a(), i2);
                    this.u.a().a(1, k.s.a(), i2);
                }
            } else {
                this.s.a().a(1, k.s.a(), 0);
                this.u.a().a(1, k.s.a(), 0);
                if (this.aj != -1) {
                    this.t.a().a(1, k.t.a(), this.aj);
                    this.v.a().a(1, k.t.a(), this.aj);
                } else if (this.ak != -1) {
                    this.t.a().a(1, k.v.a(), -this.ak);
                    this.v.a().a(1, k.v.a(), -this.ak);
                } else if (this.ai != -1.0f && k.G() == f.a.FIXED) {
                    int i3 = (int) (((float) k.F) * this.ai);
                    this.t.a().a(1, k.t.a(), i3);
                    this.v.a().a(1, k.t.a(), i3);
                }
            }
        }
    }

    public void a(androidx.constraintlayout.a.e eVar) {
        g gVar = (g) k();
        if (gVar != null) {
            e a2 = gVar.a(e.c.LEFT);
            e a3 = gVar.a(e.c.RIGHT);
            boolean z = this.D != null && this.D.C[0] == f.a.WRAP_CONTENT;
            if (this.am == 0) {
                a2 = gVar.a(e.c.TOP);
                a3 = gVar.a(e.c.BOTTOM);
                z = this.D != null && this.D.C[1] == f.a.WRAP_CONTENT;
            }
            if (this.aj != -1) {
                h a4 = eVar.a((Object) this.al);
                eVar.c(a4, eVar.a((Object) a2), this.aj, 6);
                if (z) {
                    eVar.a(eVar.a((Object) a3), a4, 0, 5);
                }
            } else if (this.ak != -1) {
                h a5 = eVar.a((Object) this.al);
                h a6 = eVar.a((Object) a3);
                eVar.c(a5, a6, -this.ak, 6);
                if (z) {
                    eVar.a(a5, eVar.a((Object) a2), 0, 5);
                    eVar.a(a6, a5, 0, 5);
                }
            } else if (this.ai != -1.0f) {
                eVar.a(androidx.constraintlayout.a.e.a(eVar, eVar.a((Object) this.al), eVar.a((Object) a2), eVar.a((Object) a3), this.ai, this.an));
            }
        }
    }

    public void c(androidx.constraintlayout.a.e eVar) {
        if (k() != null) {
            int b2 = eVar.b((Object) this.al);
            if (this.am == 1) {
                h(b2);
                i(0);
                k(k().r());
                j(0);
                return;
            }
            h(0);
            i(b2);
            j(k().p());
            k(0);
        }
    }
}
