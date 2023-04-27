package com.oppo.camera.gl;

import android.graphics.Bitmap;

/* compiled from: BitmapTexture */
public class d extends v {
    protected Bitmap h;
    private final Object j;
    private int k;

    /* access modifiers changed from: protected */
    public void a(Bitmap bitmap) {
    }

    public d(Bitmap bitmap) {
        this(bitmap, false);
    }

    public d(Bitmap bitmap, boolean z) {
        super(z);
        this.j = new Object();
        this.k = 0;
        synchronized (this.j) {
            this.h = bitmap;
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap g_() {
        Bitmap bitmap;
        synchronized (this.j) {
            bitmap = this.h;
        }
        return bitmap;
    }
}
