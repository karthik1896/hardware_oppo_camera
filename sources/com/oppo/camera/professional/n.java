package com.oppo.camera.professional;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: SubModeBarData */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3580a;

    /* renamed from: b  reason: collision with root package name */
    private int f3581b = -1;
    private String c;
    private String d;
    private String e;
    private int f = 0;
    private ArrayList<String> g = new ArrayList<>();
    private ArrayList<String> h = new ArrayList<>();
    private String i;

    public n(Context context) {
        this.f3580a = context;
    }

    public n a(int i2) {
        this.e = this.f3580a.getResources().getString(i2);
        return this;
    }

    public n b(int i2) {
        this.f = i2;
        return this;
    }

    public n c(int i2) {
        this.f3581b = i2;
        return this;
    }

    public n a(String str) {
        this.c = str;
        return this;
    }

    public n b(String str) {
        this.d = str;
        return this;
    }

    public n d(int i2) {
        this.i = this.f3580a.getResources().getString(i2);
        return this;
    }

    public n e(int i2) {
        String[] stringArray = this.f3580a.getResources().getStringArray(i2);
        for (String add : stringArray) {
            this.g.add(add);
        }
        return this;
    }

    public n f(int i2) {
        String[] stringArray = this.f3580a.getResources().getStringArray(i2);
        for (String add : stringArray) {
            this.h.add(add);
        }
        return this;
    }

    public String a() {
        return this.d;
    }

    public ArrayList<String> b() {
        return this.g;
    }

    public ArrayList<String> c() {
        return this.h;
    }

    public String d() {
        return this.i;
    }

    public int e() {
        return this.f;
    }
}
