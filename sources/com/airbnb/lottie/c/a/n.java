package com.airbnb.lottie.c.a;

import com.airbnb.lottie.g.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue */
abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<a<V>> f1666a;

    n(V v) {
        this(Collections.singletonList(new a(v)));
    }

    n(List<a<V>> list) {
        this.f1666a = list;
    }

    public List<a<V>> c() {
        return this.f1666a;
    }

    public boolean b() {
        return this.f1666a.isEmpty() || (this.f1666a.size() == 1 && this.f1666a.get(0).e());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f1666a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f1666a.toArray()));
        }
        return sb.toString();
    }
}
