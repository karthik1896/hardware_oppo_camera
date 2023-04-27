package com.coloros.anim.c;

import com.coloros.anim.c.b.n;
import java.util.List;

/* compiled from: FontCharacter */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<n> f2418a;

    /* renamed from: b  reason: collision with root package name */
    private final char f2419b;
    private final double c;
    private final double d;
    private final String e;
    private final String f;

    public e(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.f2418a = list;
        this.f2419b = c2;
        this.c = d2;
        this.d = d3;
        this.e = str;
        this.f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<n> a() {
        return this.f2418a;
    }

    public double b() {
        return this.d;
    }

    public int hashCode() {
        return a(this.f2419b, this.f, this.e);
    }
}
