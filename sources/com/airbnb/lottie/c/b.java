package com.airbnb.lottie.c;

/* compiled from: DocumentData */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1667a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1668b;
    public final float c;
    public final a d;
    public final int e;
    public final float f;
    public final float g;
    public final int h;
    public final int i;
    public final float j;
    public final boolean k;

    /* compiled from: DocumentData */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, float f2, a aVar, int i2, float f3, float f4, int i3, int i4, float f5, boolean z) {
        this.f1667a = str;
        this.f1668b = str2;
        this.c = f2;
        this.d = aVar;
        this.e = i2;
        this.f = f3;
        this.g = f4;
        this.h = i3;
        this.i = i4;
        this.j = f5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((float) (((this.f1667a.hashCode() * 31) + this.f1668b.hashCode()) * 31)) + this.c)) * 31) + this.d.ordinal()) * 31) + this.e;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.h;
    }
}
