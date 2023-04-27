package com.airbnb.lottie.g;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.d;

/* compiled from: Keyframe */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f1829a;

    /* renamed from: b  reason: collision with root package name */
    public T f1830b;
    public final Interpolator c;
    public final float d;
    public Float e;
    public PointF f;
    public PointF g;
    private final d h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;

    public a(d dVar, T t, T t2, Interpolator interpolator, float f2, Float f3) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.f = null;
        this.g = null;
        this.h = dVar;
        this.f1829a = t;
        this.f1830b = t2;
        this.c = interpolator;
        this.d = f2;
        this.e = f3;
    }

    public a(T t) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.f = null;
        this.g = null;
        this.h = null;
        this.f1829a = t;
        this.f1830b = t;
        this.c = null;
        this.d = Float.MIN_VALUE;
        this.e = Float.valueOf(Float.MAX_VALUE);
    }

    public float c() {
        d dVar = this.h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            this.m = (this.d - dVar.f()) / this.h.m();
        }
        return this.m;
    }

    public float d() {
        if (this.h == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.e == null) {
                this.n = 1.0f;
            } else {
                this.n = c() + ((this.e.floatValue() - this.d) / this.h.m());
            }
        }
        return this.n;
    }

    public boolean e() {
        return this.c == null;
    }

    public boolean a(float f2) {
        return f2 >= c() && f2 < d();
    }

    public float f() {
        if (this.i == -3987645.8f) {
            this.i = ((Float) this.f1829a).floatValue();
        }
        return this.i;
    }

    public float g() {
        if (this.j == -3987645.8f) {
            this.j = ((Float) this.f1830b).floatValue();
        }
        return this.j;
    }

    public int h() {
        if (this.k == 784923401) {
            this.k = ((Integer) this.f1829a).intValue();
        }
        return this.k;
    }

    public int i() {
        if (this.l == 784923401) {
            this.l = ((Integer) this.f1830b).intValue();
        }
        return this.l;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f1829a + ", endValue=" + this.f1830b + ", startFrame=" + this.d + ", endFrame=" + this.e + ", interpolator=" + this.c + '}';
    }
}
