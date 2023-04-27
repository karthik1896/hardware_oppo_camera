package com.coloros.anim;

import java.util.Arrays;

/* compiled from: EffectiveAnimationResult */
public final class e<V> {

    /* renamed from: a  reason: collision with root package name */
    private final V f2432a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f2433b;

    public e(V v) {
        this.f2432a = v;
        this.f2433b = null;
    }

    public e(Throwable th) {
        this.f2433b = th;
        this.f2432a = null;
    }

    public V a() {
        return this.f2432a;
    }

    public Throwable b() {
        return this.f2433b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (a() != null && a().equals(eVar.a())) {
            return true;
        }
        if (b() == null || eVar.b() == null) {
            return false;
        }
        return b().toString().equals(b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), b()});
    }
}
