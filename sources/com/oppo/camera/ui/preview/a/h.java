package com.oppo.camera.ui.preview.a;

import android.content.Context;
import co.polarr.renderer.FilterPackageUtil;
import com.oppo.camera.e;
import com.oppo.camera.gl.s;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.ui.preview.a.u;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FilterTexturePreview */
public class h extends s implements u.c {

    /* renamed from: a  reason: collision with root package name */
    private a f4389a;

    /* renamed from: b  reason: collision with root package name */
    private int f4390b;
    private int c;
    private ArrayList<s> i;
    /* access modifiers changed from: private */
    public u j;
    /* access modifiers changed from: private */
    public a k;
    /* access modifiers changed from: private */
    public a l;
    private boolean m;
    private boolean n;
    private String o;
    private boolean p;
    private String q;

    /* compiled from: FilterTexturePreview */
    public enum a {
        Polarr,
        Anc
    }

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public int d() {
        return 2;
    }

    public boolean h() {
        return false;
    }

    public h(Context context) {
        super(context);
        this.f4389a = a.Polarr;
        this.f4390b = 0;
        this.c = 0;
        this.i = new ArrayList<>();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = FilterPackageUtil.F_DEFAULT;
        this.p = false;
        this.q = "";
        this.k = new m();
        this.l = new b();
    }

    public void a(a aVar) {
        this.f4389a = aVar;
    }

    private a o() {
        if (a.Polarr == this.f4389a) {
            return this.k;
        }
        return this.l;
    }

    public boolean a(s.a aVar) {
        if (this.j == null || aVar == null || aVar.c == null) {
            return false;
        }
        String str = this.q;
        boolean i2 = this.j.i();
        if (FilterPackageUtil.F_DEFAULT.equals(str)) {
            return false;
        }
        o().a(this.h, g().g(), g().h(), this.m);
        e.a("Filter.process");
        o().a(this.i.get(1).d());
        o().b(aVar.c.d());
        if (this.m || !str.equals(this.o)) {
            if (i2) {
                o().a(-0.7f, 0.44f, 0.83f, 0.25f, -0.74f, 0.98f);
            }
            o().a(str);
            this.o = str;
        }
        o().b();
        if (i2) {
            o().c();
        } else {
            o().d();
        }
        this.m = false;
        e.b("Filter.process");
        return true;
    }

    public boolean a(int i2) {
        if (this.j == null || FilterPackageUtil.F_DEFAULT.equals(this.q) || !this.p || "oppo_video_filter_portrait_retention".equals(this.q) || !c_(i2)) {
            return false;
        }
        ArrayList<com.oppo.camera.gl.s> arrayList = this.i;
        if (arrayList == null || arrayList.size() < 2) {
            e.a("FilterTexturePreview", "canProcess, mFilterTextures has not init!");
            return false;
        } else if (this.n) {
            return true;
        } else {
            e.e("FilterTexturePreview", "canProcess, texture is not inited");
            return false;
        }
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(u uVar) {
        e.a("FilterTexturePreview", "createEngine");
        this.j = uVar;
        u uVar2 = this.j;
        if (uVar2 != null) {
            uVar2.a((u.c) this);
        }
    }

    public void e() {
        this.f.a((Runnable) new Runnable() {
            public void run() {
                e.a("FilterTexturePreview", "destroyEngine");
                e.e("FilterTexturePreview", "destroyEngine, mRequest: " + h.this.j + ", mGLRootView: " + h.this.f);
                h.this.k.e();
                h.this.l.e();
                if (h.this.j != null) {
                    h.this.j.z();
                    u unused = h.this.j = null;
                }
                e.a("FilterTexturePreview", "destroyEngine X");
            }
        });
    }

    public com.oppo.camera.gl.s f() {
        ArrayList<com.oppo.camera.gl.s> arrayList = this.i;
        if (arrayList == null || arrayList.size() != 2) {
            return null;
        }
        return this.i.get(0);
    }

    public com.oppo.camera.gl.s g() {
        ArrayList<com.oppo.camera.gl.s> arrayList = this.i;
        if (arrayList == null || arrayList.size() != 2) {
            return null;
        }
        return this.i.get(1);
    }

    public void i() {
        e.a("FilterTexturePreview", "newTextures");
        for (int i2 = 0; i2 < 2; i2++) {
            this.i.add(new com.oppo.camera.gl.s(this.f4390b, this.c, true));
        }
        this.n = true;
    }

    public void a(com.oppo.camera.gl.h hVar) {
        Iterator<com.oppo.camera.gl.s> it = this.i.iterator();
        while (it.hasNext()) {
            com.oppo.camera.gl.s next = it.next();
            if (next != null && !next.k()) {
                next.c(hVar);
                e.a("FilterTexturePreview", "prepareTextures, texture.getId: " + next.d());
            }
        }
    }

    public void j() {
        e.a("FilterTexturePreview", "recycleTextures");
        if (this.n) {
            ArrayList<com.oppo.camera.gl.s> arrayList = this.i;
            if (arrayList != null) {
                Iterator<com.oppo.camera.gl.s> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.oppo.camera.gl.s next = it.next();
                    e.a("FilterTexturePreview", "recycleTextures, texture id: " + next.d());
                    next.l();
                }
                this.i.clear();
            }
            this.n = false;
        }
    }

    public void a(int i2, int i3) {
        e.a("FilterTexturePreview", "setSize, height: " + i2 + ", width: " + i3);
        this.f4390b = i3;
        this.c = i2;
    }

    public void b(boolean z) {
        this.p = z;
    }

    public void a(String str) {
        this.q = str;
    }
}
