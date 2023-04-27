package com.oppo.camera;

import android.util.Range;
import android.util.Size;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.e.a;
import com.oppo.camera.e.o;
import com.oppo.camera.f;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import java.util.HashMap;

/* compiled from: ModeFacade */
class p {

    /* renamed from: a  reason: collision with root package name */
    private o f3146a = null;

    /* renamed from: b  reason: collision with root package name */
    private f.o f3147b = null;

    protected p(o oVar, f.o oVar2) {
        this.f3146a = oVar;
        this.f3147b = oVar2;
    }

    /* access modifiers changed from: protected */
    public synchronized void a() {
        f.p o = o();
        if (o != null) {
            o.f3084b.aA();
        } else {
            this.f3146a.r();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized String b() {
        f.p j;
        a aVar;
        if (this.f3147b == null || (j = this.f3147b.j()) == null || (aVar = j.f3084b) == null) {
            return null;
        }
        return aVar.a();
    }

    /* access modifiers changed from: protected */
    public synchronized String c() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.b();
        }
        return this.f3146a.n();
    }

    /* access modifiers changed from: protected */
    public synchronized void a(boolean z) {
        f.p o = o();
        if (o != null) {
            o.f3084b.e(z);
        } else {
            this.f3146a.b(z);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized Size a(j jVar) {
        return a(jVar, (String) null);
    }

    /* access modifiers changed from: protected */
    public synchronized Size a(Size size) {
        Size size2;
        f.p o = o();
        if (o != null) {
            size2 = o.f3084b.a(size);
        } else {
            size2 = this.f3146a.a(size);
        }
        return size2;
    }

    /* access modifiers changed from: protected */
    public synchronized Size a(j jVar, String str) {
        Size size;
        f.p o = o();
        if (o != null) {
            size = o.f3084b.a(jVar, str);
        } else {
            size = this.f3146a.a(jVar, str);
        }
        return size;
    }

    /* access modifiers changed from: protected */
    public synchronized int d() {
        int i;
        f.p o = o();
        if (o != null) {
            i = o.f3084b.bt();
        } else {
            i = this.f3146a.P();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public synchronized Range<Integer> e() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.e();
        }
        return this.f3146a.o();
    }

    /* access modifiers changed from: protected */
    public synchronized boolean f() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.bw();
        }
        return this.f3146a.bx();
    }

    /* access modifiers changed from: protected */
    public synchronized int g() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.c();
        }
        return this.f3146a.d();
    }

    /* access modifiers changed from: protected */
    public synchronized Size b(j jVar) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.g(jVar);
        }
        return this.f3146a.b(jVar);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean a(String str) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.r(str);
        }
        return this.f3146a.l(str);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean h() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.ec();
        }
        return this.f3146a.aZ();
    }

    /* access modifiers changed from: protected */
    public synchronized void a(HashMap<String, f.C0084f> hashMap) {
        f.p o = o();
        if (o != null) {
            o.f3084b.a(hashMap);
        } else if (this.f3146a != null) {
            this.f3146a.a(hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized Size c(j jVar) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.d(jVar);
        } else if (this.f3146a == null) {
            return null;
        } else {
            return this.f3146a.c(jVar);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized Size d(j jVar) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.f(jVar);
        } else if (this.f3146a == null) {
            return null;
        } else {
            return this.f3146a.d(jVar);
        }
    }

    /* access modifiers changed from: protected */
    public String i() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.eq();
        }
        o oVar = this.f3146a;
        if (oVar != null) {
            return oVar.bJ();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public synchronized Size a(String str, j jVar) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.a(str, jVar);
        }
        return this.f3146a.a(str, jVar);
    }

    public int[] e(j jVar) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.b(jVar);
        }
        return this.f3146a.e(jVar);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean j() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.eo();
        }
        return this.f3146a.cB();
    }

    /* access modifiers changed from: protected */
    public synchronized int k() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.aS();
        }
        return this.f3146a.W();
    }

    /* access modifiers changed from: protected */
    public synchronized void l() {
        f.p o = o();
        if (o != null) {
            o.f3084b.ed();
        } else {
            this.f3146a.bc();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void a(ApsTotalResult apsTotalResult) {
        f.p o = o();
        if (o != null) {
            o.f3084b.a(apsTotalResult);
        } else {
            this.f3146a.a(apsTotalResult);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized boolean m() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.Z();
        }
        return this.f3146a.be();
    }

    /* access modifiers changed from: protected */
    public synchronized boolean n() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.Y();
        }
        return this.f3146a.bf();
    }

    /* access modifiers changed from: protected */
    public synchronized boolean b(String str) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.f(str);
        }
        return this.f3146a.i(str);
    }

    /* access modifiers changed from: protected */
    public synchronized f.p o() {
        f.p i;
        if (this.f3147b == null || (i = this.f3147b.i()) == null || i.f3084b == null) {
            return null;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public synchronized a p() {
        f.p o = o();
        if (o != null) {
            return o.f3084b;
        }
        return this.f3146a.a(this.f3146a.l());
    }

    /* access modifiers changed from: protected */
    public synchronized String q() {
        f.p o = o();
        if (o != null) {
            return o.c;
        }
        return this.f3146a.l();
    }

    /* access modifiers changed from: protected */
    public synchronized int r() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.m();
        }
        return this.f3146a.cy();
    }

    /* access modifiers changed from: protected */
    public synchronized long s() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.eU();
        }
        return this.f3146a.cx();
    }

    /* access modifiers changed from: protected */
    public synchronized int c(String str) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.y(str);
        }
        return this.f3146a.r(str);
    }

    /* access modifiers changed from: protected */
    public synchronized int d(String str) {
        f.p o = o();
        if (o != null) {
            return o.f3084b.x(str);
        }
        return this.f3146a.s(str);
    }

    /* access modifiers changed from: protected */
    public synchronized int t() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.D();
        }
        return this.f3146a.p();
    }

    public synchronized long u() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.m2do();
        }
        return this.f3146a.cI();
    }

    public synchronized boolean v() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.cM();
        }
        return this.f3146a.cU();
    }

    public synchronized boolean w() {
        f.p o = o();
        if (o != null) {
            return o.f3084b.er();
        }
        return this.f3146a.cV();
    }

    public synchronized void x() {
        f.p o = o();
        if (o != null) {
            o.f3084b.an();
        } else {
            this.f3146a.ab();
        }
    }
}
