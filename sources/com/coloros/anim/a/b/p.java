package com.coloros.anim.a.b;

import com.coloros.anim.g.a;
import com.coloros.anim.g.b;
import com.coloros.anim.g.c;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation */
public class p<K, A> extends a<K, A> {
    private final a<A> c;
    private final A d;

    /* access modifiers changed from: package-private */
    public float f() {
        return 1.0f;
    }

    public p(b<A> bVar) {
        this(bVar, (Object) null);
    }

    public p(b<A> bVar, A a2) {
        super(Collections.emptyList());
        this.c = new a<>();
        a(bVar);
        this.d = a2;
    }

    public void b() {
        if (this.f2322b != null) {
            super.b();
        }
    }

    public A g() {
        b bVar = this.f2322b;
        A a2 = this.d;
        return bVar.a(0.0f, 0.0f, a2, a2, h(), h(), h());
    }

    /* access modifiers changed from: package-private */
    public A a(c<K> cVar, float f) {
        return g();
    }
}
