package com.airbnb.lottie.c;

import android.graphics.PointF;

/* compiled from: CubicCurveData */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f1657a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f1658b;
    private final PointF c;

    public a() {
        this.f1657a = new PointF();
        this.f1658b = new PointF();
        this.c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f1657a = pointF;
        this.f1658b = pointF2;
        this.c = pointF3;
    }

    public void a(float f, float f2) {
        this.f1657a.set(f, f2);
    }

    public PointF a() {
        return this.f1657a;
    }

    public void b(float f, float f2) {
        this.f1658b.set(f, f2);
    }

    public PointF b() {
        return this.f1658b;
    }

    public void c(float f, float f2) {
        this.c.set(f, f2);
    }

    public PointF c() {
        return this.c;
    }
}
