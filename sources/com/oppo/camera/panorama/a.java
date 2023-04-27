package com.oppo.camera.panorama;

import android.content.Context;
import com.oppo.camera.R;

/* compiled from: AntiClockwiseDirection */
public class a extends c {
    public float b(float f) {
        return 1.0f;
    }

    public float c(float f) {
        return f + 180.0f;
    }

    public a(Context context) {
        super(context);
        this.m = 1;
    }

    /* access modifiers changed from: protected */
    public float[] a(int i, int i2) {
        c();
        this.g[0] = this.k;
        this.g[1] = 0.0f;
        float f = (float) i;
        this.g[2] = f - this.k;
        this.g[3] = this.j;
        this.g[4] = f - this.k;
        float f2 = (float) i2;
        this.g[5] = f2 - this.j;
        this.g[6] = this.k;
        this.g[7] = f2;
        return this.g;
    }

    public String a(Context context) {
        return context.getResources().getString(R.string.camera_panorama_front_right_rotato);
    }

    public void a(float f) {
        if (Float.compare(1.0f, f) == 0) {
            this.f3474b = this.c;
            this.d = -40.0f;
            this.l = true;
            return;
        }
        this.f3474b = this.c * f;
        this.d = this.e - this.f3474b;
        this.k = this.i * f;
        this.j = this.h * f;
    }

    public void a() {
        super.a();
        this.d = this.e;
    }
}
