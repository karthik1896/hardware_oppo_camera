package com.coloros.anim.c.b;

import android.graphics.PointF;
import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.n;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.m;

/* compiled from: PolystarShape */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2382a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2383b;
    private final b c;
    private final m<PointF, PointF> d;
    private final b e;
    private final b f;
    private final b g;
    private final b h;
    private final b i;
    private final boolean j;

    public i(String str, a aVar, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z) {
        this.f2382a = str;
        this.f2383b = aVar;
        this.c = bVar;
        this.d = mVar;
        this.e = bVar2;
        this.f = bVar3;
        this.g = bVar4;
        this.h = bVar5;
        this.i = bVar6;
        this.j = z;
    }

    public String a() {
        return this.f2382a;
    }

    public a b() {
        return this.f2383b;
    }

    public b c() {
        return this.c;
    }

    public m<PointF, PointF> d() {
        return this.d;
    }

    public b e() {
        return this.e;
    }

    public b f() {
        return this.f;
    }

    public b g() {
        return this.g;
    }

    public b h() {
        return this.h;
    }

    public b i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public c a(com.coloros.anim.b bVar, com.coloros.anim.c.c.a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("PolystarShape to RepeaterContent, layer = " + aVar);
        }
        return new n(bVar, aVar, this);
    }

    /* compiled from: PolystarShape */
    public enum a {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        private a(int i) {
            this.value = i;
        }

        public static a forValue(int i) {
            for (a aVar : values()) {
                if (aVar.value == i) {
                    return aVar;
                }
            }
            return null;
        }
    }
}
