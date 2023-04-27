package com.oppo.camera.sticker.ui;

import android.graphics.drawable.Drawable;

/* compiled from: ImageTagInfo */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private b f3699a = null;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f3700b = null;
    private String c = null;
    private boolean d = false;
    private boolean e = false;
    private int f = 0;

    public b a() {
        return this.f3699a;
    }

    public void a(b bVar) {
        this.f3699a = bVar;
    }

    public Drawable b() {
        return this.f3700b;
    }

    public String c() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public boolean d() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean e() {
        return this.e;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public int f() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb, "mDrawable", this.f3700b);
        a(sb, "mStickerUUID", this.c);
        a(sb, "mbStickerNew", Boolean.valueOf(this.d));
        a(sb, "mbHasMusic", Boolean.valueOf(this.e));
        a(sb, "mState", Integer.valueOf(this.f));
        return sb.toString();
    }

    private void a(StringBuilder sb, String str, Object obj) {
        if (sb != null) {
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(", ");
        }
    }
}
