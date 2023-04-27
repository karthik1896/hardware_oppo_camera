package com.coloros.anim.g;

/* compiled from: ScaleXY */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f2481a;

    /* renamed from: b  reason: collision with root package name */
    private float f2482b;

    public d(float f, float f2) {
        this.f2481a = f;
        this.f2482b = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float a() {
        return this.f2481a;
    }

    public float b() {
        return this.f2482b;
    }

    public void a(float f, float f2) {
        this.f2481a = f;
        this.f2482b = f2;
    }

    public boolean b(float f, float f2) {
        return this.f2481a == f && this.f2482b == f2;
    }

    public String toString() {
        return a() + "x" + b();
    }
}
