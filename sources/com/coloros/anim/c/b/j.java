package com.coloros.anim.c.b;

import android.graphics.PointF;
import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.o;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.f;
import com.coloros.anim.c.a.m;
import com.coloros.anim.c.c.a;

/* compiled from: RectangleShape */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2384a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f2385b;
    private final f c;
    private final b d;
    private final boolean e;

    public j(String str, m<PointF, PointF> mVar, f fVar, b bVar, boolean z) {
        this.f2384a = str;
        this.f2385b = mVar;
        this.c = fVar;
        this.d = bVar;
        this.e = z;
    }

    public String a() {
        return this.f2384a;
    }

    public b b() {
        return this.d;
    }

    public f c() {
        return this.c;
    }

    public m<PointF, PointF> d() {
        return this.f2385b;
    }

    public boolean e() {
        return this.e;
    }

    public c a(com.coloros.anim.b bVar, a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("RectangleShape to RectangleContent, layer = " + aVar);
        }
        return new o(bVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.f2385b + ", size=" + this.c + '}';
    }
}
