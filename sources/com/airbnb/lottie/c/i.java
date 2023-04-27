package com.airbnb.lottie.c;

import androidx.core.f.d;

/* compiled from: MutablePair */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    T f1722a;

    /* renamed from: b  reason: collision with root package name */
    T f1723b;

    public void a(T t, T t2) {
        this.f1722a = t;
        this.f1723b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!b(dVar.f676a, this.f1722a) || !b(dVar.f677b, this.f1723b)) {
            return false;
        }
        return true;
    }

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.f1722a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f1723b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1722a) + " " + String.valueOf(this.f1723b) + "}";
    }
}
