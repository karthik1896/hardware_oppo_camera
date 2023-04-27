package com.coloros.anim.f;

/* compiled from: MeanCalculator */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private float f2456a;

    /* renamed from: b  reason: collision with root package name */
    private int f2457b;

    public void a(float f) {
        this.f2456a += f;
        this.f2457b++;
        int i = this.f2457b;
        if (i == Integer.MAX_VALUE) {
            this.f2456a /= 2.0f;
            this.f2457b = i / 2;
        }
    }
}
