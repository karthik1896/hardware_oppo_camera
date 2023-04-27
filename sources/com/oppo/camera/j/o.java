package com.oppo.camera.j;

import java.util.ArrayList;

/* compiled from: FilmSubMenuItem */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private String f3384a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f3385b = -1;
    private int c = -1;
    private ArrayList<p> d = null;
    private a e = null;

    /* compiled from: FilmSubMenuItem */
    public interface a {
        void a(int i);
    }

    public int a() {
        return this.c;
    }

    public o a(int i) {
        this.c = i;
        return this;
    }

    public String b() {
        return this.f3384a;
    }

    public o a(String str) {
        this.f3384a = str;
        return this;
    }

    public o b(int i) {
        this.f3385b = i;
        return this;
    }

    public int c() {
        return this.f3385b;
    }

    public ArrayList<p> d() {
        return this.d;
    }

    public o a(ArrayList<p> arrayList) {
        this.d = arrayList;
        return this;
    }

    public a e() {
        return this.e;
    }

    public o a(a aVar) {
        this.e = aVar;
        return this;
    }
}
