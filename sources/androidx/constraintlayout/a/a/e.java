package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;

/* compiled from: ConstraintAnchor */
public class e {

    /* renamed from: a  reason: collision with root package name */
    final f f517a;

    /* renamed from: b  reason: collision with root package name */
    final c f518b;
    e c;
    public int d = 0;
    int e = -1;
    h f;
    private m g = new m(this);
    private b h = b.NONE;
    private a i = a.RELAXED;
    private int j = 0;

    /* compiled from: ConstraintAnchor */
    public enum a {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor */
    public enum b {
        NONE,
        STRONG,
        WEAK
    }

    /* compiled from: ConstraintAnchor */
    public enum c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public m a() {
        return this.g;
    }

    public e(f fVar, c cVar) {
        this.f517a = fVar;
        this.f518b = cVar;
    }

    public h b() {
        return this.f;
    }

    public void a(androidx.constraintlayout.a.c cVar) {
        h hVar = this.f;
        if (hVar == null) {
            this.f = new h(h.a.UNRESTRICTED, (String) null);
        } else {
            hVar.b();
        }
    }

    public f c() {
        return this.f517a;
    }

    public c d() {
        return this.f518b;
    }

    public int e() {
        e eVar;
        if (this.f517a.l() == 8) {
            return 0;
        }
        if (this.e <= -1 || (eVar = this.c) == null || eVar.f517a.l() != 8) {
            return this.d;
        }
        return this.e;
    }

    public b f() {
        return this.h;
    }

    public e g() {
        return this.c;
    }

    public int h() {
        return this.j;
    }

    public void i() {
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.h = b.STRONG;
        this.j = 0;
        this.i = a.RELAXED;
        this.g.b();
    }

    public boolean a(e eVar, int i2, b bVar, int i3) {
        return a(eVar, i2, -1, bVar, i3, false);
    }

    public boolean a(e eVar, int i2, int i3, b bVar, int i4, boolean z) {
        if (eVar == null) {
            this.c = null;
            this.d = 0;
            this.e = -1;
            this.h = b.NONE;
            this.j = 2;
            return true;
        } else if (!z && !a(eVar)) {
            return false;
        } else {
            this.c = eVar;
            if (i2 > 0) {
                this.d = i2;
            } else {
                this.d = 0;
            }
            this.e = i3;
            this.h = bVar;
            this.j = i4;
            return true;
        }
    }

    public boolean j() {
        return this.c != null;
    }

    public boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        c d2 = eVar.d();
        c cVar = this.f518b;
        if (d2 != cVar) {
            switch (this.f518b) {
                case CENTER:
                    if (d2 == c.BASELINE || d2 == c.CENTER_X || d2 == c.CENTER_Y) {
                        return false;
                    }
                    return true;
                case LEFT:
                case RIGHT:
                    boolean z = d2 == c.LEFT || d2 == c.RIGHT;
                    if (eVar.c() instanceof i) {
                        return z || d2 == c.CENTER_X;
                    }
                    return z;
                case TOP:
                case BOTTOM:
                    boolean z2 = d2 == c.TOP || d2 == c.BOTTOM;
                    if (eVar.c() instanceof i) {
                        return z2 || d2 == c.CENTER_Y;
                    }
                    return z2;
                case BASELINE:
                case CENTER_X:
                case CENTER_Y:
                case NONE:
                    return false;
                default:
                    throw new AssertionError(this.f518b.name());
            }
        } else if (cVar != c.BASELINE || (eVar.c().z() && c().z())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.f517a.m() + ":" + this.f518b.toString();
    }
}
