package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.s;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.f;

/* compiled from: ShapeTrimPath */
public class q implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1699a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1700b;
    private final b c;
    private final b d;
    private final b e;
    private final boolean f;

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

    public q(String str, a aVar, b bVar, b bVar2, b bVar3, boolean z) {
        this.f1699a = str;
        this.f1700b = aVar;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar3;
        this.f = z;
    }

    public String a() {
        return this.f1699a;
    }

    public a b() {
        return this.f1700b;
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

    public c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new s(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
