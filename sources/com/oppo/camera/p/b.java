package com.oppo.camera.p;

import android.graphics.RectF;

/* compiled from: QrCodeResult */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f3463a = "";

    /* renamed from: b  reason: collision with root package name */
    private a f3464b = null;
    private String c = "";
    private RectF d = null;
    private int e = 0;
    private int f = 0;
    private boolean g = false;

    /* compiled from: QrCodeResult */
    public enum a {
        HTTP,
        INSTANT,
        WIFI,
        NONE
    }

    public b(String str, a aVar, String str2, RectF rectF, int i, int i2) {
        this.f3463a = str;
        this.f3464b = aVar;
        this.c = str2;
        this.d = rectF;
        this.e = i;
        this.f = i2;
    }

    public String a() {
        return this.f3463a;
    }

    public String b() {
        return this.c;
    }

    public a c() {
        return this.f3464b;
    }

    public RectF d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public synchronized boolean g() {
        return this.g;
    }

    public synchronized void a(boolean z) {
        this.g = z;
    }

    public String toString() {
        return "QrCodeResult{mContent='" + this.f3463a + '\'' + ", mType=" + this.f3464b + ", mScanStatus='" + this.c + '\'' + '}';
    }
}
