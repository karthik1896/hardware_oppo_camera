package com.coloros.anim.a.b;

import android.graphics.Path;
import com.coloros.anim.c.b.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<l, Path>> f2323a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f2324b;
    private final List<com.coloros.anim.c.b.g> c;

    public g(List<com.coloros.anim.c.b.g> list) {
        this.c = list;
        this.f2323a = new ArrayList(list.size());
        this.f2324b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f2323a.add(list.get(i).b().a());
            this.f2324b.add(list.get(i).c().a());
        }
    }

    public List<com.coloros.anim.c.b.g> a() {
        return this.c;
    }

    public List<a<l, Path>> b() {
        return this.f2323a;
    }

    public List<a<Integer, Integer>> c() {
        return this.f2324b;
    }
}
