package com.oppo.camera.gl;

import android.view.animation.Interpolator;

/* compiled from: Animation */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected long f3255a = -2;

    /* renamed from: b  reason: collision with root package name */
    protected long f3256b;
    protected Interpolator c;

    /* access modifiers changed from: protected */
    public abstract void a(float f);

    public void a(long j) {
        this.f3255a = j;
    }

    public boolean b(long j) {
        long j2 = this.f3255a;
        if (j2 == -2) {
            return false;
        }
        if (j2 == -1) {
            this.f3255a = j;
        }
        long j3 = j - this.f3255a;
        float a2 = w.a(((float) j3) / ((float) this.f3256b), 0.0f, 1.0f);
        Interpolator interpolator = this.c;
        if (interpolator != null) {
            a2 = interpolator.getInterpolation(a2);
        }
        a(a2);
        if (j3 >= this.f3256b) {
            this.f3255a = -2;
        }
        if (this.f3255a != -2) {
            return true;
        }
        return false;
    }
}
