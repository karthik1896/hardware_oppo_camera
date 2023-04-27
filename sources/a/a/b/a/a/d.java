package a.a.b.a.a;

import a.a.b.a.ab;
import a.a.b.a.ac;
import a.a.b.a.au;
import a.a.b.a.bh;
import a.a.b.a.bn;
import a.a.b.a.c;
import a.a.b.a.j;
import a.a.b.a.u;
import a.a.b.a.x;
import a.a.b.a.y;
import a.a.b.b.g;
import a.a.b.e.s;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class d extends a {
    public Queue<a> n = new ConcurrentLinkedQueue();
    public List<a> o = new ArrayList();
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 2;
    public int[] t = new int[1];
    public int[] u = new int[this.s];
    public int v = 0;

    public d(Context context, Resources resources) {
        super(context, resources);
    }

    public void a(int i, int i2) {
        this.p = i;
        this.q = i2;
        x();
        d(i, i2);
    }

    public void a(a aVar) {
        this.n.add(aVar);
    }

    public void a(Context context) {
        this.f2a = context;
    }

    public boolean a(a aVar, boolean z) {
        aVar.f2a = this.f2a;
        if (this.f2a.isLutRender && ((aVar instanceof bn) || (aVar instanceof ac) || (aVar instanceof bh) || (aVar instanceof j) || (aVar instanceof c) || (aVar instanceof au) || (aVar instanceof y) || (aVar instanceof ab) || (aVar instanceof x) || (aVar instanceof u))) {
            return false;
        }
        if (!z && (aVar instanceof b) && ((b) aVar).k()) {
            return false;
        }
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u[this.v % 2], 0);
        int i = this.v;
        aVar.a(i == 0 ? b() : this.u[(i - 1) % 2]);
        aVar.a(this.j);
        aVar.draw();
        this.v++;
        return true;
    }

    public boolean b(a aVar) {
        return a(aVar, false);
    }

    public void c() {
    }

    public void c(int i, int i2) {
        int[] iArr = this.u;
        iArr[0] = i;
        iArr[1] = i2;
    }

    public final void d(int i, int i2) {
        this.p = i;
        this.q = i2;
        y();
        GLES20.glBindFramebuffer(36160, this.t[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u[0], 0);
        w();
    }

    public void draw() {
        v();
        n();
        o();
    }

    public void f() {
        l();
    }

    public final void k() {
        GLES20.glBindFramebuffer(36160, this.t[0]);
        GLES20.glViewport(0, 0, this.p, this.q);
    }

    public final void l() {
        m();
        GLES20.glGenFramebuffers(1, this.t, 0);
        g.a(this.t[0]);
        GLES20.glGenTextures(this.s, this.u, 0);
        for (int c : this.u) {
            g.c(c);
        }
        for (int i = 0; i < this.s; i++) {
            GLES20.glBindTexture(3553, this.u[i]);
            s.b();
        }
    }

    public void m() {
        GLES20.glDeleteFramebuffers(1, this.t, 0);
        GLES20.glDeleteTextures(this.s, this.u, 0);
        g.d(this.t[0]);
        for (int e : this.u) {
            g.e(e);
        }
        GLES20.glFlush();
    }

    public void n() {
        if (this.r > 0) {
            boolean z = false;
            for (int i = 0; i < this.o.size(); i++) {
                z = z || b(this.o.get(i));
            }
            if (!z) {
                a(this.o.get(0), true);
            }
        }
    }

    public void o() {
        w();
    }

    public List<a> p() {
        return this.o;
    }

    public int q() {
        int i = this.v;
        return i == 0 ? b() : this.u[(i - 1) % 2];
    }

    public void r() {
        w();
    }

    public void s() {
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u[this.v % 2], 0);
        this.v++;
    }

    public void t() {
        m();
    }

    public void u() {
        k();
    }

    public void v() {
        x();
        this.v = 0;
        k();
    }

    public final void w() {
        GLES20.glBindRenderbuffer(36161, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public final void x() {
        while (true) {
            a poll = this.n.poll();
            if (poll != null) {
                poll.a();
                poll.b(this.p, this.q);
                this.o.add(poll);
                this.r++;
            } else {
                return;
            }
        }
    }

    public final void y() {
        for (int i = 0; i < this.s; i++) {
            GLES20.glBindTexture(3553, this.u[i]);
            GLES20.glTexImage2D(3553, 0, 6408, this.p, this.q, 0, 6408, 5121, (Buffer) null);
        }
    }
}
