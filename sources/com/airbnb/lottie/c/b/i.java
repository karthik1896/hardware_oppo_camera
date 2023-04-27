package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.f;

/* compiled from: PolystarShape */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1681a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1682b;
    private final b c;
    private final m<PointF, PointF> d;
    private final b e;
    private final b f;
    private final b g;
    private final b h;
    private final b i;
    private final boolean j;

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

    public i(String str, a aVar, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z) {
        this.f1681a = str;
        this.f1682b = aVar;
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
        return this.f1681a;
    }

    public a b() {
        return this.f1682b;
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

    public c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new n(fVar, aVar, this);
    }
}
