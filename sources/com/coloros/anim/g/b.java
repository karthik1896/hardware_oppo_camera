package com.coloros.anim.g;

import com.coloros.anim.a.b.a;

/* compiled from: EffectiveValueCallback */
public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T f2477a = null;

    /* renamed from: b  reason: collision with root package name */
    private final a<T> f2478b = new a<>();
    private a<?, ?> c;

    public b() {
    }

    public b(T t) {
        this.f2477a = t;
    }

    public T a(a<T> aVar) {
        return this.f2477a;
    }

    public final T a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.f2478b.a(f, f2, t, t2, f3, f4, f5));
    }

    public final void a(a<?, ?> aVar) {
        this.c = aVar;
    }
}
