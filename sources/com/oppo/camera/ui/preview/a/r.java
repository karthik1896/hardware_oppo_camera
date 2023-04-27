package com.oppo.camera.ui.preview.a;

import android.content.Context;
import com.oppo.camera.e;
import com.oppo.camera.gl.g;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.s;
import com.oppo.camera.t;
import com.oppo.camera.t.a;
import com.oppo.camera.ui.preview.a.s;

/* compiled from: SuperTextTexturePreview */
public class r extends s {

    /* renamed from: a  reason: collision with root package name */
    private Context f4425a = null;

    /* renamed from: b  reason: collision with root package name */
    private u f4426b;
    private s c = null;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 1;
    private final Object n = new Object();
    private long o = 0;

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public int d() {
        return 64;
    }

    public void e() {
    }

    public s f() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public r(Context context) {
        super(context);
        this.f4425a = context;
    }

    public void a(u uVar) {
        this.f4426b = uVar;
    }

    public void a(int i2, int i3) {
        e.a("SuperTextTexturePreview", "setSize, height: " + i3 + ", width: " + i2);
        this.j = i2;
        this.k = i3;
    }

    public s g() {
        return this.c;
    }

    public void i() {
        this.c = new s(this.j, this.k, true);
        this.i = true;
    }

    public void a(h hVar) {
        s sVar = this.c;
        if (sVar != null && !sVar.k()) {
            this.c.c(hVar);
            e.a("SuperTextTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.c.d());
        }
    }

    public void j() {
        e.a("SuperTextTexturePreview", "recycleTextures");
        if (this.i) {
            s sVar = this.c;
            if (sVar != null) {
                sVar.l();
                this.c = null;
            }
            this.i = false;
        }
    }

    public boolean a(int i2) {
        u uVar;
        if (c_(i2) && this.i && (uVar = this.f4426b) != null && uVar.k()) {
            return true;
        }
        return false;
    }

    public boolean a(s.a aVar) {
        if (this.f4426b == null) {
            return false;
        }
        g gVar = aVar.f4428b;
        if (this.c == null) {
            return false;
        }
        synchronized (this.n) {
            int i2 = this.m;
            this.m = i2 + 1;
            if (i2 % 3 != 0 || t.b()) {
                if (t.b()) {
                    this.g.a((a) null);
                }
            } else if (this.l % 180 == 0) {
                this.g.a(gVar.d(), gVar.h(), gVar.g(), this.c.d(), this.l, true, this.o);
            } else {
                this.g.a(gVar.d(), gVar.g(), gVar.h(), this.c.d(), this.l, true, this.o);
            }
        }
        return false;
    }

    public void b(int i2) {
        synchronized (this.n) {
            this.l = i2;
        }
    }

    public void a(long j2) {
        super.a(j2);
        synchronized (this.n) {
            this.o = j2;
        }
    }
}
