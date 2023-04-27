package com.oppo.camera.ui.menu.shareedit;

import android.view.animation.Interpolator;

/* compiled from: SpringInterpolator */
public class b implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private float f4293a = 10.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f4294b = 0.4f;

    public b() {
    }

    public b(float f, float f2) {
        this.f4293a = f;
        this.f4294b = f2;
    }

    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.0d, (double) ((-this.f4293a) * f)) * Math.sin(((9.42477796076938d / ((double) this.f4294b)) * ((double) f)) - 1.5707963267948966d)) + 1.0d);
    }
}
