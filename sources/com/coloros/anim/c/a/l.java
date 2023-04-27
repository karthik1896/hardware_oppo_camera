package com.coloros.anim.c.a;

import android.graphics.PointF;
import com.coloros.anim.a.a.c;
import com.coloros.anim.a.b.o;
import com.coloros.anim.c.b.b;
import com.coloros.anim.c.c.a;

/* compiled from: AnimatableTransform */
public class l implements b {

    /* renamed from: a  reason: collision with root package name */
    private final e f2365a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f2366b;
    private final g c;
    private final b d;
    private final d e;
    private final b f;
    private final b g;
    private final b h;
    private final b i;

    public c a(com.coloros.anim.b bVar, a aVar) {
        return null;
    }

    public l() {
        this((e) null, (m<PointF, PointF>) null, (g) null, (b) null, (d) null, (b) null, (b) null, (b) null, (b) null);
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, b bVar2, b bVar3, b bVar4, b bVar5) {
        this.f2365a = eVar;
        this.f2366b = mVar;
        this.c = gVar;
        this.d = bVar;
        this.e = dVar;
        this.h = bVar2;
        this.i = bVar3;
        this.f = bVar4;
        this.g = bVar5;
    }

    public e a() {
        return this.f2365a;
    }

    public m<PointF, PointF> b() {
        return this.f2366b;
    }

    public g c() {
        return this.c;
    }

    public b d() {
        return this.d;
    }

    public d e() {
        return this.e;
    }

    public b f() {
        return this.h;
    }

    public b g() {
        return this.i;
    }

    public b h() {
        return this.f;
    }

    public b i() {
        return this.g;
    }

    public o j() {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("AnimatableTransform create TransformKeyframeAnimation, " + k());
        }
        return new o(this);
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnimatableTransform:{");
        if (this.f2365a != null) {
            sb.append("anchorPoint = ");
            sb.append(this.f2365a.toString());
        }
        if (this.c != null) {
            sb.append("scale = ");
            sb.append(this.c.toString());
        }
        if (this.d != null) {
            sb.append("rotation = ");
            sb.append(this.d.toString());
        }
        if (this.e != null) {
            sb.append("opacity = ");
            sb.append(this.e.toString());
        }
        if (this.f != null) {
            sb.append("skew = ");
            sb.append(this.f.toString());
        }
        if (this.g != null) {
            sb.append("skewAngle = ");
            sb.append(this.g.toString());
        }
        if (this.h != null) {
            sb.append("startOpacity = ");
            sb.append(this.h.toString());
        }
        if (this.i != null) {
            sb.append("endOpacity = ");
            sb.append(this.i.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}
