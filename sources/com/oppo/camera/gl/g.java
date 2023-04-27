package com.oppo.camera.gl;

import android.util.Log;

/* compiled from: ExtTexture */
public class g extends c {
    private int[] h = new int[1];
    private int i;

    public void m() {
    }

    public boolean n() {
        return true;
    }

    public g(int i2) {
        Log.v("ExtTexture", "target = " + i2);
        j.a(this.h);
        Log.v("ExtTexture", "sTextureId[0] = " + this.h[0]);
        this.c = this.h[0];
        this.i = i2;
    }

    private void c(h hVar) {
        hVar.b(this);
        a(hVar);
        this.d = 1;
    }

    /* access modifiers changed from: protected */
    public boolean b(h hVar) {
        if (k()) {
            return true;
        }
        c(hVar);
        return true;
    }

    public int j() {
        return this.i;
    }
}
