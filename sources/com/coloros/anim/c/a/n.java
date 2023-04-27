package com.coloros.anim.c.a;

import com.coloros.anim.g.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue */
abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<c<V>> f2367a;

    n(V v) {
        this(Collections.singletonList(new c(v)));
    }

    n(List<c<V>> list) {
        this.f2367a = list;
    }

    public List<c<V>> c() {
        return this.f2367a;
    }

    public boolean b() {
        return this.f2367a.isEmpty() || (this.f2367a.size() == 1 && this.f2367a.get(0).e());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f2367a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f2367a.toArray()));
        }
        return sb.toString();
    }
}
