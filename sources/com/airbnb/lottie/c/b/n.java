package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.d;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup */
public class n implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1691a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f1692b;
    private final boolean c;

    public n(String str, List<b> list, boolean z) {
        this.f1691a = str;
        this.f1692b = list;
        this.c = z;
    }

    public String a() {
        return this.f1691a;
    }

    public List<b> b() {
        return this.f1692b;
    }

    public boolean c() {
        return this.c;
    }

    public c a(f fVar, a aVar) {
        return new d(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f1691a + "' Shapes: " + Arrays.toString(this.f1692b.toArray()) + '}';
    }
}
