package com.coloros.anim.f;

import android.util.Log;
import android.view.Choreographer;
import com.coloros.anim.a;

/* compiled from: EffectiveValueAnimator */
public class c extends a implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f2454a = false;

    /* renamed from: b  reason: collision with root package name */
    private float f2455b = 1.0f;
    private boolean c = false;
    private long d = 0;
    private float e = 0.0f;
    private int f = 0;
    private float g = -2.14748365E9f;
    private float h = 2.14748365E9f;
    private a i;

    public Object getAnimatedValue() {
        return Float.valueOf(d());
    }

    public float d() {
        a aVar = this.i;
        if (aVar == null) {
            return 0.0f;
        }
        return (this.e - aVar.f()) / (this.i.g() - this.i.f());
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
        a aVar = this.i;
        if (aVar == null) {
            return 0;
        }
        return (long) aVar.e();
    }

    public float e() {
        return this.e;
    }

    public void a(int i2) {
        float f2 = (float) i2;
        if (this.e != f2) {
            this.e = f.b(f2, m(), n());
            this.d = System.nanoTime();
            c();
        }
    }

    public boolean isRunning() {
        return this.f2454a;
    }

    public void doFrame(long j) {
        o();
        if (this.i != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float q = ((float) (nanoTime - this.d)) / q();
            float f2 = this.e;
            if (r()) {
                q = -q;
            }
            this.e = f2 + q;
            boolean z = !f.c(this.e, m(), n());
            this.e = f.b(this.e, m(), n());
            this.d = nanoTime;
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
                    this.d = nanoTime;
                } else {
                    this.e = n();
                    p();
                    b(r());
                }
            }
            s();
        }
    }

    private float q() {
        a aVar = this.i;
        if (aVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / aVar.h()) / Math.abs(this.f2455b);
    }

    public void f() {
        this.i = null;
        this.g = -2.14748365E9f;
        this.h = 2.14748365E9f;
    }

    public void a(a aVar) {
        boolean z = this.i == null;
        this.i = aVar;
        if (z) {
            a((float) ((int) Math.max(this.g, aVar.f())), (float) ((int) Math.min(this.h, aVar.g())));
        } else {
            a((float) ((int) aVar.f()), (float) ((int) aVar.g()));
        }
        float f2 = this.e;
        this.e = 0.0f;
        a((int) f2);
    }

    public void a(float f2, float f3) {
        if (f2 <= f3) {
            a aVar = this.i;
            float f4 = aVar == null ? -3.4028235E38f : aVar.f();
            a aVar2 = this.i;
            float g2 = aVar2 == null ? Float.MAX_VALUE : aVar2.g();
            this.g = f.b(f2, f4, g2);
            this.h = f.b(f3, f4, g2);
            a((int) f.b(this.e, f2, f3));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f2), Float.valueOf(f3)}));
    }

    public void g() {
        a(-h());
    }

    public float h() {
        return this.f2455b;
    }

    public void a(float f2) {
        this.f2455b = f2;
    }

    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 != 2 && this.c) {
            this.c = false;
            g();
        }
    }

    public void i() {
        this.f2454a = true;
        a(r());
        a((int) (r() ? n() : m()));
        this.d = System.nanoTime();
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
        this.f2454a = true;
        o();
        this.d = System.nanoTime();
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
        a aVar = this.i;
        if (aVar == null) {
            return 0.0f;
        }
        float f2 = this.g;
        return f2 == -2.14748365E9f ? aVar.f() : f2;
    }

    public void b(int i2) {
        a((float) i2, (float) ((int) this.h));
    }

    public float n() {
        a aVar = this.i;
        if (aVar == null) {
            return 0.0f;
        }
        float f2 = this.h;
        return f2 == 2.14748365E9f ? aVar.g() : f2;
    }

    public void b(float f2) {
        a(this.g, f2);
    }

    /* access modifiers changed from: protected */
    public void o() {
        if (isRunning()) {
            c(false);
            if (Choreographer.getInstance() == null) {
                Log.d("EffectiveAnimation", "Gets the choreographer is null");
            } else {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        c(true);
    }

    /* access modifiers changed from: protected */
    public void c(boolean z) {
        if (Choreographer.getInstance() == null) {
            Log.d("EffectiveAnimation", "Gets the choreographer is null");
        } else {
            Choreographer.getInstance().removeFrameCallback(this);
        }
        if (z) {
            this.f2454a = false;
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
