package com.coloros.anim.c.b;

import android.graphics.PointF;
import com.coloros.anim.a.a.c;
import com.coloros.anim.b;
import com.coloros.anim.c.a.f;
import com.coloros.anim.c.a.m;

/* compiled from: CircleShape */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2370a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f2371b;
    private final f c;
    private final boolean d;
    private final boolean e;

    public a(String str, m<PointF, PointF> mVar, f fVar, boolean z, boolean z2) {
        this.f2370a = str;
        this.f2371b = mVar;
        this.c = fVar;
        this.d = z;
        this.e = z2;
    }

    public c a(b bVar, com.coloros.anim.c.c.a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("CircleShape::toContent layer = " + aVar);
        }
        return new com.coloros.anim.a.a.f(bVar, aVar, this);
    }

    public String a() {
        return this.f2370a;
    }

    public m<PointF, PointF> b() {
        return this.f2371b;
    }

    public f c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }
}
