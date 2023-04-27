package com.oppo.camera.gl.b;

import android.util.Size;
import com.oppo.camera.e;
import com.oppo.camera.gl.g;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.s;
import com.oppo.camera.util.Util;

/* compiled from: OesDrawerEngine */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private d f3278a;

    /* renamed from: b  reason: collision with root package name */
    private c f3279b;
    private s c;
    private g d;
    private g e;
    private int f;

    public f() {
        this.f3278a = null;
        this.f3279b = null;
        this.c = null;
        this.d = new g(36197);
        this.e = new g(36197);
        this.f = -1;
        this.f3278a = new g();
        this.f3279b = new b();
        if (this.d == null) {
            this.d = new g(36197);
        }
        if (this.e == null) {
            this.e = new g(36197);
        }
    }

    public void a() {
        this.f3278a.h_();
        this.f3279b.b();
    }

    public void b() {
        e.a("OesDrawerEngine", "release");
        if (this.f3278a != null) {
            e.a("OesDrawerEngine", "recycleTextures, mSqureOesDrawer");
            this.f3278a.b();
            this.f3278a = null;
        }
        if (this.f3279b != null) {
            e.a("OesDrawerEngine", "recycleTextures, mFboDrawer");
            this.f3279b.c();
            this.f3279b = null;
        }
        if (this.d != null) {
            e.a("OesDrawerEngine", "recycleTextures, texture id: " + this.d.d());
            this.d.l();
            this.d = null;
        }
        if (this.e != null) {
            e.a("OesDrawerEngine", "recycleTextures, texture id: " + this.e.d());
            this.e.l();
            this.e = null;
        }
        if (this.c != null) {
            e.a("OesDrawerEngine", "recycleTextures, texture id: " + this.c.d());
            this.c.l();
            this.c = null;
        }
    }

    public int c() {
        return this.d.d();
    }

    public int d() {
        return this.e.d();
    }

    public g e() {
        return this.e;
    }

    public int a(h hVar, int i, int i2, Size size, Size size2, int i3, boolean z, h hVar2) {
        Size size3 = size;
        Size size4 = size2;
        int i4 = i3;
        hVar2.a(size3, size4, i4, hVar2.m());
        if (this.c == null) {
            this.c = new s(hVar2.k(), hVar2.j(), true);
        }
        s sVar = this.c;
        if (sVar != null && !sVar.k()) {
            this.c.c(hVar);
        }
        if (a(size4, size3, i4, hVar2.m())) {
            h hVar3 = hVar2;
            this.f = this.f3278a.a(i, i2, size, size2, i3, hVar2.m(), z, hVar3, this.c);
            this.f3279b.a(this.f, i, i2, size, size2, i3, hVar2.m(), hVar3);
        } else {
            e.e("OesDrawerEngine", "skip the frame, size does not match the type");
        }
        return this.f;
    }

    public s f() {
        return this.c;
    }

    public void a(boolean z) {
        d dVar = this.f3278a;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    private boolean a(Size size, Size size2, int i, boolean z) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2 && (!Util.a(size, 1.7777777777777777d) || !Util.a(size2, 1.7777777777777777d))) {
                    return false;
                }
            } else if (z) {
                if (size2.getHeight() != size2.getWidth()) {
                    return false;
                }
            } else if (size.getHeight() != size.getWidth()) {
                return false;
            }
        } else if (!(size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight())) {
            return false;
        }
        return true;
    }
}
