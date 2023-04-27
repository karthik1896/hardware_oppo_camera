package com.airbnb.lottie;

import java.util.Arrays;

/* compiled from: LottieResult */
public final class l<V> {

    /* renamed from: a  reason: collision with root package name */
    private final V f1839a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f1840b;

    public l(V v) {
        this.f1839a = v;
        this.f1840b = null;
    }

    public l(Throwable th) {
        this.f1840b = th;
        this.f1839a = null;
    }

    public V a() {
        return this.f1839a;
    }

    public Throwable b() {
        return this.f1840b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (a() != null && a().equals(lVar.a())) {
            return true;
        }
        if (b() == null || lVar.b() == null) {
            return false;
        }
        return b().toString().equals(b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), b()});
    }
}
