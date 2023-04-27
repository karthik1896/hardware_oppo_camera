package com.coloros.anim.a.b;

import com.coloros.anim.g.b;
import com.coloros.anim.g.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation */
public abstract class a<K, A> {

    /* renamed from: a  reason: collision with root package name */
    final List<C0061a> f2321a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    protected b<A> f2322b;
    private final List<? extends c<K>> c;
    private boolean d = false;
    private float e = 0.0f;
    private c<K> f;
    private c<K> g;
    private float h = -1.0f;
    private A i = null;
    private float j = -1.0f;
    private float k = -1.0f;

    /* renamed from: com.coloros.anim.a.b.a$a  reason: collision with other inner class name */
    /* compiled from: BaseKeyframeAnimation */
    public interface C0061a {
        void a();
    }

    /* access modifiers changed from: package-private */
    public abstract A a(c<K> cVar, float f2);

    a(List<? extends c<K>> list) {
        this.c = list;
    }

    public void a() {
        this.d = true;
    }

    public void a(C0061a aVar) {
        this.f2321a.add(aVar);
    }

    public void b() {
        for (int i2 = 0; i2 < this.f2321a.size(); i2++) {
            this.f2321a.get(i2).a();
        }
    }

    /* access modifiers changed from: protected */
    public c<K> c() {
        c<K> cVar = this.f;
        if (cVar != null && cVar.a(this.e)) {
            return this.f;
        }
        List<? extends c<K>> list = this.c;
        c<K> cVar2 = (c) list.get(list.size() - 1);
        if (this.e < cVar2.c()) {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                cVar2 = (c) this.c.get(size);
                if (cVar2.a(this.e)) {
                    break;
                }
            }
        }
        this.f = cVar2;
        return cVar2;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        if (this.d) {
            return 0.0f;
        }
        c c2 = c();
        if (c2.e()) {
            return 0.0f;
        }
        return (this.e - c2.c()) / (c2.d() - c2.c());
    }

    /* access modifiers changed from: protected */
    public float e() {
        c c2 = c();
        if (c2.e()) {
            return 0.0f;
        }
        return c2.f2480b.getInterpolation(d());
    }

    private float i() {
        if (this.j == -1.0f) {
            this.j = this.c.isEmpty() ? 0.0f : ((c) this.c.get(0)).c();
        }
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        float f2;
        if (this.k == -1.0f) {
            if (this.c.isEmpty()) {
                f2 = 1.0f;
            } else {
                List<? extends c<K>> list = this.c;
                f2 = ((c) list.get(list.size() - 1)).d();
            }
            this.k = f2;
        }
        return this.k;
    }

    public A g() {
        c<K> c2 = c();
        float e2 = e();
        if (this.f2322b == null && c2 == this.g && this.h == e2) {
            return this.i;
        }
        this.g = c2;
        this.h = e2;
        A a2 = a(c2, e2);
        this.i = a2;
        return a2;
    }

    public float h() {
        return this.e;
    }

    public void a(float f2) {
        if (!this.c.isEmpty()) {
            c c2 = c();
            if (f2 < i()) {
                f2 = i();
            } else if (f2 > f()) {
                f2 = f();
            }
            if (f2 != this.e) {
                this.e = f2;
                c c3 = c();
                if (c2 != c3 || !c3.e()) {
                    b();
                }
            }
        }
    }

    public void a(b<A> bVar) {
        b<A> bVar2 = this.f2322b;
        if (bVar2 != null) {
            bVar2.a((a<?, ?>) null);
        }
        this.f2322b = bVar;
        if (bVar != null) {
            bVar.a((a<?, ?>) this);
        }
    }
}
