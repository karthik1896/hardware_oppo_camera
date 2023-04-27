package com.airbnb.lottie.f;

import android.view.Choreographer;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;

/* compiled from: LottieValueAnimator */
public class e extends a implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f1820a = false;

    /* renamed from: b  reason: collision with root package name */
    private float f1821b = 1.0f;
    private boolean c = false;
    private long d = 0;
    private float e = 0.0f;
    private int f = 0;
    private float g = -2.14748365E9f;
    private float h = 2.14748365E9f;
    private d i;

    public Object getAnimatedValue() {
        return Float.valueOf(d());
    }

    public float d() {
        d dVar = this.i;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.e - dVar.f()) / (this.i.g() - this.i.f());
    }

    public float getAnimatedFraction() {
        float m;
        float n;
        float m2;
        if (this.i == null) {
            return 0.0f;
        }
        if (r()) {
            m = n() - this.e;
            n = n();
            m2 = m();
        } else {
            m = this.e - m();
            n = n();
            m2 = m();
        }
        return m / (n - m2);
    }

    public long getDuration() {
        d dVar = this.i;
        if (dVar == null) {
            return 0;
        }
        return (long) dVar.e();
    }

    public float e() {
        return this.e;
    }

    public boolean isRunning() {
        return this.f1820a;
    }

    public void doFrame(long j) {
        o();
        if (this.i != null && isRunning()) {
            c.a("LottieValueAnimator#doFrame");
            long j2 = this.d;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float q = ((float) j3) / q();
            float f2 = this.e;
            if (r()) {
                q = -q;
            }
            this.e = f2 + q;
            boolean z = !g.c(this.e, m(), n());
            this.e = g.b(this.e, m(), n());
            this.d = j;
            c();
            if (z) {
                if (getRepeatCount() == -1 || this.f < getRepeatCount()) {
                    a();
                    this.f++;
                    if (getRepeatMode() == 2) {
                        this.c = !this.c;
                        g();
                    } else {
                        this.e = r() ? n() : m();
                    }
                    this.d = j;
                } else {
                    this.e = this.f1821b < 0.0f ? m() : n();
                    p();
                    b(r());
                }
            }
            s();
            c.b("LottieValueAnimator#doFrame");
        }
    }

    private float q() {
        d dVar = this.i;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.h()) / Math.abs(this.f1821b);
    }

    public void f() {
        this.i = null;
        this.g = -2.14748365E9f;
        this.h = 2.14748365E9f;
    }

    public void a(d dVar) {
        boolean z = this.i == null;
        this.i = dVar;
        if (z) {
            a((float) ((int) Math.max(this.g, dVar.f())), (float) ((int) Math.min(this.h, dVar.g())));
        } else {
            a((float) ((int) dVar.f()), (float) ((int) dVar.g()));
        }
        float f2 = this.e;
        this.e = 0.0f;
        a((float) ((int) f2));
        c();
    }

    public void a(float f2) {
        if (this.e != f2) {
            this.e = g.b(f2, m(), n());
            this.d = 0;
            c();
        }
    }

    public void a(int i2) {
        a((float) i2, (float) ((int) this.h));
    }

    public void b(float f2) {
        a(this.g, f2);
    }

    public void a(float f2, float f3) {
        if (f2 <= f3) {
            d dVar = this.i;
            float f4 = dVar == null ? -3.4028235E38f : dVar.f();
            d dVar2 = this.i;
            float g2 = dVar2 == null ? Float.MAX_VALUE : dVar2.g();
            this.g = g.b(f2, f4, g2);
            this.h = g.b(f3, f4, g2);
            a((float) ((int) g.b(this.e, f2, f3)));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f2), Float.valueOf(f3)}));
    }

    public void g() {
        c(-h());
    }

    public void c(float f2) {
        this.f1821b = f2;
    }

    public float h() {
        return this.f1821b;
    }

    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 != 2 && this.c) {
            this.c = false;
            g();
        }
    }

    public void i() {
        this.f1820a = true;
        a(r());
        a((float) ((int) (r() ? n() : m())));
        this.d = 0;
        this.f = 0;
        o();
    }

    public void j() {
        p();
        b(r());
    }

    public void k() {
        p();
    }

    public void l() {
        this.f1820a = true;
        o();
        this.d = 0;
        if (r() && e() == m()) {
            this.e = n();
        } else if (!r() && e() == n()) {
            this.e = m();
        }
    }

    public void cancel() {
        b();
        p();
    }

    private boolean r() {
        return h() < 0.0f;
    }

    public float m() {
        d dVar = this.i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.g;
        return f2 == -2.14748365E9f ? dVar.f() : f2;
    }

    public float n() {
        d dVar = this.i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.h;
        return f2 == 2.14748365E9f ? dVar.g() : f2;
    }

    /* access modifiers changed from: protected */
    public void o() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        c(true);
    }

    /* access modifiers changed from: protected */
    public void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f1820a = false;
        }
    }

    private void s() {
        if (this.i != null) {
            float f2 = this.e;
            if (f2 < this.g || f2 > this.h) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.g), Float.valueOf(this.h), Float.valueOf(this.e)}));
            }
        }
    }
}
