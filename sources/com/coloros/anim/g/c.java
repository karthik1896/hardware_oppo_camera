package com.coloros.anim.g;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.coloros.anim.a;

/* compiled from: Keyframe */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f2479a;

    /* renamed from: b  reason: collision with root package name */
    public final Interpolator f2480b;
    public final float c;
    public T d;
    public Float e;
    public PointF f;
    public PointF g;
    private final a h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;

    public c(a aVar, T t, T t2, Interpolator interpolator, float f2, Float f3) {
        this.f = null;
        this.g = null;
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.h = aVar;
        this.f2479a = t;
        this.d = t2;
        this.f2480b = interpolator;
        this.c = f2;
        this.e = f3;
    }

    public c(T t) {
        this.f = null;
        this.g = null;
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.h = null;
        this.f2479a = t;
        this.d = t;
        this.f2480b = null;
        this.c = Float.MIN_VALUE;
        this.e = Float.valueOf(Float.MAX_VALUE);
    }

    public float c() {
        a aVar = this.h;
        if (aVar == null) {
            return 0.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            this.m = (this.c - aVar.f()) / this.h.m();
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
                this.n = c() + ((this.e.floatValue() - this.c) / this.h.m());
            }
        }
        return this.n;
    }

    public boolean e() {
        return this.f2480b == null;
    }

    public boolean a(float f2) {
        return f2 >= c() && f2 < d();
    }

    public float f() {
        if (this.i == -3987645.8f) {
            this.i = ((Float) this.f2479a).floatValue();
        }
        return this.i;
    }

    public float g() {
        if (this.j == -3987645.8f) {
            this.j = ((Float) this.d).floatValue();
        }
        return this.j;
    }

    public int h() {
        if (this.k == 784923401) {
            this.k = ((Integer) this.f2479a).intValue();
        }
        return this.k;
    }

    public int i() {
        if (this.l == 784923401) {
            this.l = ((Integer) this.d).intValue();
        }
        return this.l;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f2479a + ", endValue=" + this.d + ", startFrame=" + this.c + ", endFrame=" + this.e + ", interpolator=" + this.f2480b + '}';
    }
}
