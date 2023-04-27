package com.oppo.camera.panorama;

import android.content.Context;
import com.oppo.camera.R;

/* compiled from: ClockwiseDirection */
public class b extends c {
    public float b(float f) {
        return f;
    }

    public float c(float f) {
        return f;
    }

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public float[] a(int i, int i2) {
        c();
        this.g[0] = this.k;
        this.g[1] = this.j;
        float f = (float) i;
        this.g[2] = f - this.k;
        this.g[3] = 0.0f;
        this.g[4] = f - this.k;
        float f2 = (float) i2;
        this.g[5] = f2;
        this.g[6] = this.k;
        this.g[7] = f2 - this.j;
        return this.g;
    }

    public String a(Context context) {
        return context.getResources().getString(R.string.camera_panorama_front_left_rotato);
    }

    public void a(float f) {
        if (Float.compare(1.0f, f) == 0) {
            this.f3474b = this.c;
            this.l = true;
            this.j = this.h;
            this.k = this.i;
            return;
        }
        this.f3474b = this.c * f;
        this.k = this.i * f;
        this.j = this.h * f;
    }
}
