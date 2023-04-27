package com.coloros.anim.c;

import android.graphics.PointF;

/* compiled from: CubicCurveData */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f2358a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f2359b;
    private final PointF c;

    public a() {
        this.f2358a = new PointF();
        this.f2359b = new PointF();
        this.c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f2358a = pointF;
        this.f2359b = pointF2;
        this.c = pointF3;
    }

    public void a(float f, float f2) {
        this.f2358a.set(f, f2);
    }

    public PointF a() {
        return this.f2358a;
    }

    public void b(float f, float f2) {
        this.f2359b.set(f, f2);
    }

    public PointF b() {
        return this.f2359b;
    }

    public void c(float f, float f2) {
        this.c.set(f, f2);
    }

    public PointF c() {
        return this.c;
    }
}
