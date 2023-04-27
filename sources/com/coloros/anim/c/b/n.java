package com.coloros.anim.c.b;

import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.d;
import com.coloros.anim.b;
import com.coloros.anim.c.c.a;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup */
public class n implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2392a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f2393b;
    private final boolean c;

    public n(String str, List<b> list, boolean z) {
        this.f2392a = str;
        this.f2393b = list;
        this.c = z;
    }

    public String a() {
        return this.f2392a;
    }

    public List<b> b() {
        return this.f2393b;
    }

    public boolean c() {
        return this.c;
    }

    public c a(b bVar, a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("ShapeGroup to ContentGroup, layer = " + aVar);
        }
        return new d(bVar, aVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f2392a + "' Shapes: " + Arrays.toString(this.f2393b.toArray()) + '}';
    }
}
