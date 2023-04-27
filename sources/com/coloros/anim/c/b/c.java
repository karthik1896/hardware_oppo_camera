package com.coloros.anim.c.b;

import com.coloros.anim.f.d;
import com.coloros.anim.f.f;

/* compiled from: GradientColor */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f2372a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f2373b;

    public c(float[] fArr, int[] iArr) {
        this.f2372a = fArr;
        this.f2373b = iArr;
    }

    public float[] a() {
        return this.f2372a;
    }

    public int[] b() {
        return this.f2373b;
    }

    public int c() {
        return this.f2373b.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.f2373b.length == cVar2.f2373b.length) {
            for (int i = 0; i < cVar.f2373b.length; i++) {
                this.f2372a[i] = f.a(cVar.f2372a[i], cVar2.f2372a[i], f);
                this.f2373b[i] = d.a(f, cVar.f2373b[i], cVar2.f2373b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f2373b.length + " vs " + cVar2.f2373b.length + ")");
    }
}
