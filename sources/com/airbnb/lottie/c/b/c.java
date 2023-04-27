package com.airbnb.lottie.c.b;

import com.airbnb.lottie.f.b;
import com.airbnb.lottie.f.g;

/* compiled from: GradientColor */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1671a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1672b;

    public c(float[] fArr, int[] iArr) {
        this.f1671a = fArr;
        this.f1672b = iArr;
    }

    public float[] a() {
        return this.f1671a;
    }

    public int[] b() {
        return this.f1672b;
    }

    public int c() {
        return this.f1672b.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.f1672b.length == cVar2.f1672b.length) {
            for (int i = 0; i < cVar.f1672b.length; i++) {
                this.f1671a[i] = g.a(cVar.f1671a[i], cVar2.f1671a[i], f);
                this.f1672b[i] = b.a(f, cVar.f1672b[i], cVar2.f1672b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f1672b.length + " vs " + cVar2.f1672b.length + ")");
    }
}
