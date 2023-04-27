package com.coloros.anim.c;

import android.util.Pair;

/* compiled from: MutablePair */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    T f2424a;

    /* renamed from: b  reason: collision with root package name */
    T f2425b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f2424a = t;
        this.f2425b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!b(pair.first, this.f2424a) || !b(pair.second, this.f2425b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.f2424a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f2425b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f2424a) + " " + String.valueOf(this.f2425b) + "}";
    }
}
