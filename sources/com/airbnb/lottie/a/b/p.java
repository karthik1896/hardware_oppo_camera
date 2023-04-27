package com.airbnb.lottie.a.b;

import com.airbnb.lottie.g.a;
import com.airbnb.lottie.g.b;
import com.airbnb.lottie.g.c;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation */
public class p<K, A> extends a<K, A> {
    private final b<A> d;
    private final A e;

    /* access modifiers changed from: package-private */
    public float f() {
        return 1.0f;
    }

    public p(c<A> cVar) {
        this(cVar, (Object) null);
    }

    public p(c<A> cVar, A a2) {
        super(Collections.emptyList());
        this.d = new b<>();
        a(cVar);
        this.e = a2;
    }

    public void a(float f) {
        this.f1642b = f;
    }

    public void b() {
        if (this.c != null) {
            super.b();
        }
    }

    public A g() {
        c cVar = this.c;
        A a2 = this.e;
        return cVar.a(0.0f, 0.0f, a2, a2, h(), h(), h());
    }

    /* access modifiers changed from: package-private */
    public A a(a<K> aVar, float f) {
        return g();
    }
}
