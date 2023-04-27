package com.a.a;

/* compiled from: BouncyConversion */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f1597a = (!c.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private final double f1598b;
    private final double c;
    private final double d;
    private final double e;

    private double a(double d2, double d3, double d4) {
        return (d2 - d3) / (d4 - d3);
    }

    private double b(double d2, double d3, double d4) {
        return d3 + (d2 * (d4 - d3));
    }

    private double c(double d2, double d3, double d4) {
        return (d4 * d2) + ((1.0d - d2) * d3);
    }

    public c(double d2, double d3) {
        double d4 = d2;
        double d5 = d3;
        this.d = d4;
        this.e = d5;
        double d6 = d5 / 1.7d;
        double b2 = b(a(d6, 0.0d, 20.0d), 0.0d, 0.8d);
        this.f1598b = b(a(d4 / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.c = d(b2, d(this.f1598b), 0.01d);
    }

    public double a() {
        return this.f1598b;
    }

    public double b() {
        return this.c;
    }

    private double d(double d2, double d3, double d4) {
        return c((2.0d * d2) - (d2 * d2), d3, d4);
    }

    private double a(double d2) {
        return ((Math.pow(d2, 3.0d) * 7.0E-4d) - (Math.pow(d2, 2.0d) * 0.031d)) + (d2 * 0.64d) + 1.28d;
    }

    private double b(double d2) {
        return ((Math.pow(d2, 3.0d) * 4.4E-5d) - (Math.pow(d2, 2.0d) * 0.006d)) + (d2 * 0.36d) + 2.0d;
    }

    private double c(double d2) {
        return ((Math.pow(d2, 3.0d) * 4.5E-7d) - (Math.pow(d2, 2.0d) * 3.32E-4d)) + (d2 * 0.1078d) + 5.84d;
    }

    private double d(double d2) {
        if (d2 <= 18.0d) {
            return a(d2);
        }
        if (d2 > 18.0d && d2 <= 44.0d) {
            return b(d2);
        }
        if (d2 > 44.0d) {
            return c(d2);
        }
        if (f1597a) {
            return 0.0d;
        }
        throw new AssertionError();
    }
}
