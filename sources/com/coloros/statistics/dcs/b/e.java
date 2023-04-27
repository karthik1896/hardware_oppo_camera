package com.coloros.statistics.dcs.b;

/* compiled from: DynamicEventBean */
public class e implements m {

    /* renamed from: a  reason: collision with root package name */
    private String f2535a = "";

    /* renamed from: b  reason: collision with root package name */
    private int f2536b = 0;

    public int c() {
        return 10;
    }

    public e(int i, String str) {
        this.f2536b = i;
        this.f2535a = str;
    }

    public int a() {
        return this.f2536b;
    }

    public String b() {
        return this.f2535a;
    }

    public String toString() {
        return "uploadMode is :" + this.f2536b + "\n" + "body is :" + b() + "\n";
    }
}
