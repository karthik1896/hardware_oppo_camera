package com.airbnb.lottie.c.b;

import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.c.a.h;

/* compiled from: Mask */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final a f1677a;

    /* renamed from: b  reason: collision with root package name */
    private final h f1678b;
    private final d c;
    private final boolean d;

    /* compiled from: Mask */
    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public g(a aVar, h hVar, d dVar, boolean z) {
        this.f1677a = aVar;
        this.f1678b = hVar;
        this.c = dVar;
        this.d = z;
    }

    public a a() {
        return this.f1677a;
    }

    public h b() {
        return this.f1678b;
    }

    public d c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
