package com.coloros.anim.c.b;

import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.s;
import com.coloros.anim.c.a.b;

/* compiled from: ShapeTrimPath */
public class q implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2400a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2401b;
    private final b c;
    private final b d;
    private final b e;
    private final boolean f;

    public q(String str, a aVar, b bVar, b bVar2, b bVar3, boolean z) {
        this.f2400a = str;
        this.f2401b = aVar;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar3;
        this.f = z;
    }

    public String a() {
        return this.f2400a;
    }

    public a b() {
        return this.f2401b;
    }

    public b c() {
        return this.d;
    }

    public b d() {
        return this.c;
    }

    public b e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public c a(com.coloros.anim.b bVar, com.coloros.anim.c.c.a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("ShapeTrimPath to TrimPathContent, layer = " + aVar);
        }
        return new s(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }

    /* compiled from: ShapeTrimPath */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }
}
