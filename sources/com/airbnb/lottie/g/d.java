package com.airbnb.lottie.g;

/* compiled from: ScaleXY */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f1835a;

    /* renamed from: b  reason: collision with root package name */
    private float f1836b;

    public d(float f, float f2) {
        this.f1835a = f;
        this.f1836b = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float a() {
        return this.f1835a;
    }

    public float b() {
        return this.f1836b;
    }

    public void a(float f, float f2) {
        this.f1835a = f;
        this.f1836b = f2;
    }

    public boolean b(float f, float f2) {
        return this.f1835a == f && this.f1836b == f2;
    }

    public String toString() {
        return a() + "x" + b();
    }
}
