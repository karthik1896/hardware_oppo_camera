package com.oppo.camera.doubleexposure;

import android.text.TextUtils;

/* compiled from: ClipVideoInfo */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f2809a = "";

    /* renamed from: b  reason: collision with root package name */
    private long f2810b = -1;
    private long c = -1;
    private boolean d = false;
    private int e = 0;
    private String f = "";

    public b(String str) {
        this.f2809a = str;
        this.f2810b = -1;
        this.c = -1;
        this.d = false;
    }

    public b(String str, long j, long j2, boolean z) {
        this.f2809a = str;
        this.f2810b = j;
        this.c = j2;
        this.d = z;
    }

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public String b() {
        return this.f;
    }

    public void a(String str) {
        this.f = str;
    }

    public String c() {
        return this.f2809a;
    }

    public long d() {
        return this.f2810b;
    }

    public long e() {
        return this.c;
    }

    public boolean f() {
        return this.d;
    }

    public void a(long j) {
        this.f2810b = j;
    }

    public void b(long j) {
        this.c = j;
    }

    public boolean g() {
        return f();
    }

    public boolean h() {
        return -1 == this.f2810b || -1 == this.c || this.e == 0 || TextUtils.isEmpty(this.f);
    }

    public String toString() {
        return "ClipVideoInfo{mPath='" + this.f2809a + '\'' + ", mClipStartTime=" + this.f2810b + ", mClipEndTime=" + this.c + ", mbClipped=" + this.d + '}';
    }
}
