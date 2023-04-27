package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.c.a;

/* compiled from: RectangleShape */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1683a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f1684b;
    private final f c;
    private final b d;
    private final boolean e;

    public j(String str, m<PointF, PointF> mVar, f fVar, b bVar, boolean z) {
        this.f1683a = str;
        this.f1684b = mVar;
        this.c = fVar;
        this.d = bVar;
        this.e = z;
    }

    public String a() {
        return this.f1683a;
    }

    public b b() {
        return this.d;
    }

    public f c() {
        return this.c;
    }

    public m<PointF, PointF> d() {
        return this.f1684b;
    }

    public boolean e() {
        return this.e;
    }

    public c a(com.airbnb.lottie.f fVar, a aVar) {
        return new o(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.f1684b + ", size=" + this.c + '}';
    }
}
