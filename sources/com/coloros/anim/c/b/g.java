package com.coloros.anim.c.b;

import com.coloros.anim.c.a.d;
import com.coloros.anim.c.a.h;

/* compiled from: Mask */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final a f2378a;

    /* renamed from: b  reason: collision with root package name */
    private final h f2379b;
    private final d c;
    private final boolean d;

    /* compiled from: Mask */
    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT
    }

    public g(a aVar, h hVar, d dVar, boolean z) {
        this.f2378a = aVar;
        this.f2379b = hVar;
        this.c = dVar;
        this.d = z;
    }

    public a a() {
        return this.f2378a;
    }

    public h b() {
        return this.f2379b;
    }

    public d c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
