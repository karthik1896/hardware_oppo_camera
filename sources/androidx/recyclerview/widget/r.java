package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SimpleItemAnimator */
public abstract class r extends RecyclerView.f {
    boolean h = true;

    public abstract boolean a(RecyclerView.w wVar);

    public abstract boolean a(RecyclerView.w wVar, int i, int i2, int i3, int i4);

    public abstract boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(RecyclerView.w wVar);

    public void c(RecyclerView.w wVar, boolean z) {
    }

    public void d(RecyclerView.w wVar, boolean z) {
    }

    public void o(RecyclerView.w wVar) {
    }

    public void p(RecyclerView.w wVar) {
    }

    public void q(RecyclerView.w wVar) {
    }

    public void r(RecyclerView.w wVar) {
    }

    public void s(RecyclerView.w wVar) {
    }

    public void t(RecyclerView.w wVar) {
    }

    public boolean h(RecyclerView.w wVar) {
        return !this.h || wVar.isInvalid();
    }

    public boolean a(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i = cVar.f1056a;
        int i2 = cVar.f1057b;
        View view = wVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f1056a;
        int top = cVar2 == null ? view.getTop() : cVar2.f1057b;
        if (wVar.isRemoved() || (i == left && i2 == top)) {
            return a(wVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(wVar, i, i2, left, top);
    }

    public boolean b(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar == null || (cVar.f1056a == cVar2.f1056a && cVar.f1057b == cVar2.f1057b)) {
            return b(wVar);
        }
        return a(wVar, cVar.f1056a, cVar.f1057b, cVar2.f1056a, cVar2.f1057b);
    }

    public boolean c(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar.f1056a == cVar2.f1056a && cVar.f1057b == cVar2.f1057b) {
            j(wVar);
            return false;
        }
        return a(wVar, cVar.f1056a, cVar.f1057b, cVar2.f1056a, cVar2.f1057b);
    }

    public boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f1056a;
        int i4 = cVar.f1057b;
        if (wVar2.shouldIgnore()) {
            int i5 = cVar.f1056a;
            i = cVar.f1057b;
            i2 = i5;
        } else {
            i2 = cVar2.f1056a;
            i = cVar2.f1057b;
        }
        return a(wVar, wVar2, i3, i4, i2, i);
    }

    public final void i(RecyclerView.w wVar) {
        p(wVar);
        f(wVar);
    }

    public final void j(RecyclerView.w wVar) {
        t(wVar);
        f(wVar);
    }

    public final void k(RecyclerView.w wVar) {
        r(wVar);
        f(wVar);
    }

    public final void a(RecyclerView.w wVar, boolean z) {
        d(wVar, z);
        f(wVar);
    }

    public final void l(RecyclerView.w wVar) {
        o(wVar);
    }

    public final void m(RecyclerView.w wVar) {
        s(wVar);
    }

    public final void n(RecyclerView.w wVar) {
        q(wVar);
    }

    public final void b(RecyclerView.w wVar, boolean z) {
        c(wVar, z);
    }
}
