package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;

/* compiled from: CircleShape */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1669a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f1670b;
    private final f c;
    private final boolean d;
    private final boolean e;

    public a(String str, m<PointF, PointF> mVar, f fVar, boolean z, boolean z2) {
        this.f1669a = str;
        this.f1670b = mVar;
        this.c = fVar;
        this.d = z;
        this.e = z2;
    }

    public c a(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new com.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String a() {
        return this.f1669a;
    }

    public m<PointF, PointF> b() {
        return this.f1670b;
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
