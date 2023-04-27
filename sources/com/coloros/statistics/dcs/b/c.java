package com.coloros.statistics.dcs.b;

import java.util.Map;

/* compiled from: CommonBean */
public class c implements m {

    /* renamed from: a  reason: collision with root package name */
    private String f2532a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f2533b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private boolean h = false;

    public int c() {
        return 9;
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.f2533b;
    }

    public void b(String str) {
        this.f2533b = str;
    }

    public String g() {
        return this.d;
    }

    public void a(Map<String, String> map) {
        this.d = com.coloros.statistics.dcs.e.c.a(map).toString();
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean h() {
        return this.h;
    }

    public String i() {
        return this.f2532a;
    }

    public void d(String str) {
        this.f2532a = str;
    }

    public String toString() {
        return " type is :" + c() + "," + " uploadNow is :" + h() + "," + " tag is :" + f() + "," + " eventID is :" + a() + "," + " map is :" + g();
    }
}
