package androidx.dynamicanimation.a;

import androidx.dynamicanimation.a.b;

/* compiled from: SpringAnimation */
public final class e extends b<e> {
    private f w = null;
    private float x = Float.MAX_VALUE;
    private boolean y = false;

    public e(d dVar) {
        super(dVar);
    }

    public <K> e(K k, c<K> cVar) {
        super(k, cVar);
    }

    public <K> e(K k, c<K> cVar, float f) {
        super(k, cVar);
        this.w = new f(f);
    }

    public f e() {
        return this.w;
    }

    public e a(f fVar) {
        this.w = fVar;
        return this;
    }

    public void a() {
        f();
        this.w.a((double) d());
        super.a();
    }

    public void e(float f) {
        if (c()) {
            this.x = f;
            return;
        }
        if (this.w == null) {
            this.w = new f(f);
        }
        this.w.c(f);
        a();
    }

    public void b() {
        super.b();
        float f = this.x;
        if (f != Float.MAX_VALUE) {
            f fVar = this.w;
            if (fVar == null) {
                this.w = new f(f);
            } else {
                fVar.c(f);
            }
            this.x = Float.MAX_VALUE;
        }
    }

    private void f() {
        f fVar = this.w;
        if (fVar != null) {
            double a2 = (double) fVar.a();
            if (a2 > ((double) this.u)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (a2 < ((double) this.v)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(long j) {
        if (this.y) {
            float f = this.x;
            if (f != Float.MAX_VALUE) {
                this.w.c(f);
                this.x = Float.MAX_VALUE;
            }
            this.p = this.w.a();
            this.o = 0.0f;
            this.y = false;
            return true;
        }
        if (this.x != Float.MAX_VALUE) {
            long j2 = j / 2;
            b.a a2 = this.w.a((double) this.p, (double) this.o, j2);
            this.w.c(this.x);
            this.x = Float.MAX_VALUE;
            b.a a3 = this.w.a((double) a2.f797a, (double) a2.f798b, j2);
            this.p = a3.f797a;
            this.o = a3.f798b;
        } else {
            b.a a4 = this.w.a((double) this.p, (double) this.o, j);
            this.p = a4.f797a;
            this.o = a4.f798b;
        }
        this.p = Math.max(this.p, this.v);
        this.p = Math.min(this.p, this.u);
        if (!a(this.p, this.o)) {
            return false;
        }
        this.p = this.w.a();
        this.o = 0.0f;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f, float f2) {
        return this.w.a(f, f2);
    }
}
