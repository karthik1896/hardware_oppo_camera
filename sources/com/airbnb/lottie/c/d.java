package com.airbnb.lottie.c;

import com.airbnb.lottie.c.b.n;
import java.util.List;

/* compiled from: FontCharacter */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<n> f1714a;

    /* renamed from: b  reason: collision with root package name */
    private final char f1715b;
    private final double c;
    private final double d;
    private final String e;
    private final String f;

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.f1714a = list;
        this.f1715b = c2;
        this.c = d2;
        this.d = d3;
        this.e = str;
        this.f = str2;
    }

    public List<n> a() {
        return this.f1714a;
    }

    public double b() {
        return this.d;
    }

    public int hashCode() {
        return a(this.f1715b, this.f, this.e);
    }
}
