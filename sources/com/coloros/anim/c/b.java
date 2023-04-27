package com.coloros.anim.c;

/* compiled from: DocumentData */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f2368a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2369b;
    public final double c;
    public final a d;
    public final int e;
    public final double f;
    public final double g;
    public final int h;
    public final int i;
    public final double j;
    public final boolean k;

    /* compiled from: DocumentData */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, double d2, a aVar, int i2, double d3, double d4, int i3, int i4, double d5, boolean z) {
        this.f2368a = str;
        this.f2369b = str2;
        this.c = d2;
        this.d = aVar;
        this.e = i2;
        this.f = d3;
        this.g = d4;
        this.h = i3;
        this.i = i4;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((double) (((this.f2368a.hashCode() * 31) + this.f2369b.hashCode()) * 31)) + this.c)) * 31) + this.d.ordinal()) * 31) + this.e;
        long doubleToLongBits = Double.doubleToLongBits(this.f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.h;
    }
}
