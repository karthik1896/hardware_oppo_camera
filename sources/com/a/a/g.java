package com.a.a;

/* compiled from: SpringConfig */
public class g {
    public static g c = a(40.0d, 7.0d);

    /* renamed from: a  reason: collision with root package name */
    public double f1603a;

    /* renamed from: b  reason: collision with root package name */
    public double f1604b;

    public g(double d, double d2) {
        this.f1604b = d;
        this.f1603a = d2;
    }

    public static g a(double d, double d2) {
        return new g(d.a(d), d.b(d2));
    }

    public static g b(double d, double d2) {
        c cVar = new c(d2, d);
        return a(cVar.a(), cVar.b());
    }
}
