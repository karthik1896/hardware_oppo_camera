package com.oppo.camera.p;

import android.graphics.Rect;
import android.util.Size;

/* compiled from: QrCodeRequest */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3460a = null;

    /* renamed from: b  reason: collision with root package name */
    private Rect f3461b = null;
    private Size c = null;
    private int d = 0;
    private int e = 0;

    public a(byte[] bArr, Rect rect, Size size, int i, int i2) {
        this.f3460a = bArr;
        this.f3461b = rect;
        this.c = size;
        this.d = i;
        this.e = i2;
    }

    public byte[] a() {
        return this.f3460a;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }
}
