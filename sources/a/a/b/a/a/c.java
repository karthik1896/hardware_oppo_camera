package a.a.b.a.a;

import a.a.b.b.g;
import a.a.b.e.o;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c extends a {
    public static final LruCache<String, c> n = new LruCache<>(5);
    public final List<Integer> o = Collections.synchronizedList(new ArrayList());
    public a p;
    public int q = 0;
    public int r = 0;
    public int s;
    public boolean t;
    public boolean u;
    public int[] v = new int[1];

    public c(Context context, a aVar, boolean z) {
        super(context, (Resources) null);
        this.p = aVar;
        this.u = false;
        this.t = !z;
    }

    public static c a(Context context) {
        c cVar;
        synchronized (n) {
            cVar = n.get(Thread.currentThread().getName());
            if (cVar == null) {
                cVar = new c(context, (a) null, false);
                cVar.a();
                n.put(Thread.currentThread().getName(), cVar);
            }
            cVar.a(o.a());
        }
        return cVar;
    }

    public static c k() {
        c cVar;
        synchronized (n) {
            cVar = n.get(Thread.currentThread().getName());
            if (cVar == null) {
                cVar = new c((Context) null, (a) null, false);
                cVar.a();
                n.put(Thread.currentThread().getName(), cVar);
            }
            cVar.a(o.a());
        }
        return cVar;
    }

    public static void l() {
        n.evictAll();
    }

    public void a(int i, int i2) {
        this.q = i;
        this.r = i2;
        s();
    }

    public void a(a aVar) {
        this.p = aVar;
    }

    public void b(int i) {
        this.s = i;
    }

    public void c() {
    }

    public void draw() {
        p();
        this.p.a(b());
        this.p.draw();
        m();
    }

    public void e() {
        if (!this.u) {
            super.e();
        }
    }

    public void f() {
        GLES20.glGenFramebuffers(1, this.v, 0);
        g.a(this.v[0]);
        this.o.add(Integer.valueOf(this.v[0]));
        n();
    }

    public void finalize() {
        o();
        super.finalize();
    }

    public void m() {
        r();
    }

    public final boolean n() {
        GLES20.glBindFramebuffer(36160, this.v[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.s, 0);
        r();
        return false;
    }

    public void o() {
        GLES20.glDeleteFramebuffers(1, this.v, 0);
    }

    public void p() {
        s();
        GLES20.glBindFramebuffer(36160, this.v[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.s, 0);
        GLES20.glViewport(0, 0, this.q, this.r);
    }

    public void q() {
        List<Integer> list = this.o;
        if (list != null) {
            int[] iArr = new int[list.size()];
            int i = 0;
            for (Integer intValue : this.o) {
                iArr[i] = intValue.intValue();
                i++;
            }
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        }
    }

    public final void r() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    public final void s() {
        if (!this.t) {
            this.p.a();
            this.p.b(this.q, this.r);
            this.t = true;
        }
    }
}
