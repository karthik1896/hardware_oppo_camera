package com.airbnb.lottie.f;

/* compiled from: MeanCalculator */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private float f1822a;

    /* renamed from: b  reason: collision with root package name */
    private int f1823b;

    public void a(float f) {
        this.f1822a += f;
        this.f1823b++;
        int i = this.f1823b;
        if (i == Integer.MAX_VALUE) {
            this.f1822a /= 2.0f;
            this.f1823b = i / 2;
        }
    }
}
