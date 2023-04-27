package com.coloros.anim.c.b;

import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.p;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.l;
import com.coloros.anim.c.c.a;

/* compiled from: Repeater */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2386a;

    /* renamed from: b  reason: collision with root package name */
    private final b f2387b;
    private final b c;
    private final l d;
    private final boolean e;

    public k(String str, b bVar, b bVar2, l lVar, boolean z) {
        this.f2386a = str;
        this.f2387b = bVar;
        this.c = bVar2;
        this.d = lVar;
        this.e = z;
    }

    public String a() {
        return this.f2386a;
    }

    public b b() {
        return this.f2387b;
    }

    public b c() {
        return this.c;
    }

    public l d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public c a(com.coloros.anim.b bVar, a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("Repeater to RepeaterContent, layer = " + aVar);
        }
        return new p(bVar, aVar, this);
    }
}
