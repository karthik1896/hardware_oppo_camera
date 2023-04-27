package com.oppo.camera.gl;

import com.oppo.camera.e;

/* compiled from: RawTexture */
public class s extends c {
    private final boolean h;
    private boolean i;

    public int j() {
        return 3553;
    }

    public void m() {
    }

    public s(int i2, int i3, boolean z) {
        this.h = z;
        a(i2, i3);
    }

    public boolean n() {
        return this.h;
    }

    public boolean c() {
        return this.i;
    }

    public void c(h hVar) {
        this.c = hVar.a().b();
        hVar.a((c) this, 6408, 5121);
        hVar.b(this);
        this.d = 1;
        a(hVar);
    }

    public void a(h hVar, int i2) {
        this.c = i2;
        hVar.a((c) this, 6408, 5121);
        hVar.b(this);
        this.d = 1;
        a(hVar);
    }

    public void a(h hVar, int i2, int i3, int i4) {
        this.c = i2;
        a(i3, i4);
        this.d = 1;
    }

    /* access modifiers changed from: protected */
    public boolean b(h hVar) {
        if (k()) {
            return true;
        }
        e.d("RawTexture", "onBind, lost the content due to context change");
        return false;
    }
}
