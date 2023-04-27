package com.airbnb.lottie.a.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation */
public abstract class a<K, A> {

    /* renamed from: a  reason: collision with root package name */
    final List<C0053a> f1641a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    protected float f1642b = 0.0f;
    protected com.airbnb.lottie.g.c<A> c;
    private boolean d = false;
    private final c<K> e;
    private A f = null;
    private float g = -1.0f;
    private float h = -1.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* compiled from: BaseKeyframeAnimation */
    public interface C0053a {
        void a();
    }

    /* compiled from: BaseKeyframeAnimation */
    private interface c<T> {
        boolean a();

        boolean a(float f);

        com.airbnb.lottie.g.a<T> b();

        boolean b(float f);

        float c();

        float d();
    }

    /* access modifiers changed from: package-private */
    public abstract A a(com.airbnb.lottie.g.a<K> aVar, float f2);

    a(List<? extends com.airbnb.lottie.g.a<K>> list) {
        this.e = a(list);
    }

    public void a() {
        this.d = true;
    }

    public void a(C0053a aVar) {
        this.f1641a.add(aVar);
    }

    public void a(float f2) {
        if (!this.e.a()) {
            if (f2 < i()) {
                f2 = i();
            } else if (f2 > f()) {
                f2 = f();
            }
            if (f2 != this.f1642b) {
                this.f1642b = f2;
                if (this.e.a(f2)) {
                    b();
                }
            }
        }
    }

    public void b() {
        for (int i = 0; i < this.f1641a.size(); i++) {
            this.f1641a.get(i).a();
        }
    }

    /* access modifiers changed from: protected */
    public com.airbnb.lottie.g.a<K> c() {
        com.airbnb.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.g.a<K> b2 = this.e.b();
        com.airbnb.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b2;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        if (this.d) {
            return 0.0f;
        }
        com.airbnb.lottie.g.a c2 = c();
        if (c2.e()) {
            return 0.0f;
        }
        return (this.f1642b - c2.c()) / (c2.d() - c2.c());
    }

    /* access modifiers changed from: protected */
    public float e() {
        com.airbnb.lottie.g.a c2 = c();
        if (c2.e()) {
            return 0.0f;
        }
        return c2.c.getInterpolation(d());
    }

    private float i() {
        if (this.g == -1.0f) {
            this.g = this.e.c();
        }
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        if (this.h == -1.0f) {
            this.h = this.e.d();
        }
        return this.h;
    }

    public A g() {
        float e2 = e();
        if (this.c == null && this.e.b(e2)) {
            return this.f;
        }
        A a2 = a(c(), e2);
        this.f = a2;
        return a2;
    }

    public float h() {
        return this.f1642b;
    }

    public void a(com.airbnb.lottie.g.c<A> cVar) {
        com.airbnb.lottie.g.c<A> cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.a((a<?, ?>) null);
        }
        this.c = cVar;
        if (cVar != null) {
            cVar.a((a<?, ?>) this);
        }
    }

    private static <T> c<T> a(List<? extends com.airbnb.lottie.g.a<T>> list) {
        if (list.isEmpty()) {
            return new b();
        }
        if (list.size() == 1) {
            return new e(list);
        }
        return new d(list);
    }

    /* compiled from: BaseKeyframeAnimation */
    private static final class b<T> implements c<T> {
        public boolean a() {
            return true;
        }

        public boolean a(float f) {
            return false;
        }

        public float c() {
            return 0.0f;
        }

        public float d() {
            return 1.0f;
        }

        private b() {
        }

        public com.airbnb.lottie.g.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        public boolean b(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* compiled from: BaseKeyframeAnimation */
    private static final class e<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final com.airbnb.lottie.g.a<T> f1645a;

        /* renamed from: b  reason: collision with root package name */
        private float f1646b = -1.0f;

        public boolean a() {
            return false;
        }

        e(List<? extends com.airbnb.lottie.g.a<T>> list) {
            this.f1645a = (com.airbnb.lottie.g.a) list.get(0);
        }

        public boolean a(float f) {
            return !this.f1645a.e();
        }

        public com.airbnb.lottie.g.a<T> b() {
            return this.f1645a;
        }

        public float c() {
            return this.f1645a.c();
        }

        public float d() {
            return this.f1645a.d();
        }

        public boolean b(float f) {
            if (this.f1646b == f) {
                return true;
            }
            this.f1646b = f;
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation */
    private static final class d<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<? extends com.airbnb.lottie.g.a<T>> f1643a;

        /* renamed from: b  reason: collision with root package name */
        private com.airbnb.lottie.g.a<T> f1644b;
        private com.airbnb.lottie.g.a<T> c = null;
        private float d = -1.0f;

        public boolean a() {
            return false;
        }

        d(List<? extends com.airbnb.lottie.g.a<T>> list) {
            this.f1643a = list;
            this.f1644b = c(0.0f);
        }

        public boolean a(float f) {
            if (this.f1644b.a(f)) {
                return !this.f1644b.e();
            }
            this.f1644b = c(f);
            return true;
        }

        private com.airbnb.lottie.g.a<T> c(float f) {
            List<? extends com.airbnb.lottie.g.a<T>> list = this.f1643a;
            com.airbnb.lottie.g.a<T> aVar = (com.airbnb.lottie.g.a) list.get(list.size() - 1);
            if (f >= aVar.c()) {
                return aVar;
            }
            for (int size = this.f1643a.size() - 2; size >= 1; size--) {
                com.airbnb.lottie.g.a<T> aVar2 = (com.airbnb.lottie.g.a) this.f1643a.get(size);
                if (this.f1644b != aVar2 && aVar2.a(f)) {
                    return aVar2;
                }
            }
            return (com.airbnb.lottie.g.a) this.f1643a.get(0);
        }

        public com.airbnb.lottie.g.a<T> b() {
            return this.f1644b;
        }

        public float c() {
            return ((com.airbnb.lottie.g.a) this.f1643a.get(0)).c();
        }

        public float d() {
            List<? extends com.airbnb.lottie.g.a<T>> list = this.f1643a;
            return ((com.airbnb.lottie.g.a) list.get(list.size() - 1)).d();
        }

        public boolean b(float f) {
            if (this.c == this.f1644b && this.d == f) {
                return true;
            }
            this.c = this.f1644b;
            this.d = f;
            return false;
        }
    }
}
