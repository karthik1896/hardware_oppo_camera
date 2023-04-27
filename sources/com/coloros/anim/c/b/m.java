package com.coloros.anim.c.b;

import android.graphics.Path;
import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.g;
import com.coloros.anim.b;
import com.coloros.anim.c.a.a;
import com.coloros.anim.c.a.d;

/* compiled from: ShapeFill */
public class m implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2390a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f2391b;
    private final String c;
    private final a d;
    private final d e;
    private final boolean f;

    public m(String str, boolean z, Path.FillType fillType, a aVar, d dVar, boolean z2) {
        this.c = str;
        this.f2390a = z;
        this.f2391b = fillType;
        this.d = aVar;
        this.e = dVar;
        this.f = z2;
    }

    public String a() {
        return this.c;
    }

    public a b() {
        return this.d;
    }

    public d c() {
        return this.e;
    }

    public Path.FillType d() {
        return this.f2391b;
    }

    public boolean e() {
        return this.f;
    }

    public c a(b bVar, com.coloros.anim.c.c.a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("ShapeFill to FillContent, layer = " + aVar);
        }
        return new g(bVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f2390a + '}';
    }
}
