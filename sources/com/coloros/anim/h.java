package com.coloros.anim;

import android.graphics.Bitmap;

/* compiled from: EffectiveImageAsset */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final int f2483a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2484b;
    private final String c;
    private final String d;
    private final String e;
    private Bitmap f;

    public h(int i, int i2, String str, String str2, String str3) {
        this.f2483a = i;
        this.f2484b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public Bitmap c() {
        return this.f;
    }

    public void a(Bitmap bitmap) {
        Bitmap bitmap2 = this.f;
        if (bitmap2 != null && bitmap == null) {
            bitmap2.recycle();
        }
        this.f = bitmap;
    }
}
