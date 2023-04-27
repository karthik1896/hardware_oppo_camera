package com.oppo.camera.j;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: FilmModeItemBarData */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private int f3364a = 0;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f3365b = new ArrayList<>();
    private ArrayList<String> c = new ArrayList<>();
    private String d = "";
    private String e = "";
    private boolean f = false;
    private boolean g = false;

    public i a(int i) {
        this.f3364a = i;
        return this;
    }

    public i a(String[] strArr) {
        if (strArr == null) {
            return this;
        }
        for (String add : strArr) {
            this.f3365b.add(add);
        }
        return this;
    }

    public i b(String[] strArr) {
        if (strArr == null) {
            return this;
        }
        for (String add : strArr) {
            this.c.add(add);
        }
        return this;
    }

    public ArrayList<String> a() {
        return this.f3365b;
    }

    public ArrayList<String> b() {
        return this.c;
    }

    public int c() {
        return this.f3364a;
    }

    public String b(int i) {
        return i < this.f3365b.size() ? this.f3365b.get(i) : "";
    }

    public String a(String str) {
        if (!TextUtils.isEmpty(str) && b(str) < this.f3365b.size()) {
            return this.f3365b.get(b(str));
        }
        return "";
    }

    public boolean d() {
        return this.f;
    }

    public i a(boolean z) {
        this.f = z;
        return this;
    }

    public String c(int i) {
        return i < this.c.size() ? this.c.get(i) : "";
    }

    public int b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.c.indexOf(str);
        }
        return 0;
    }

    public String e() {
        return !TextUtils.isEmpty(this.d) ? b(b(this.d)) : "";
    }

    public boolean f() {
        return this.g;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public String g() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String h() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }
}
