package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.c.b.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<l, Path>> f1647a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f1648b;
    private final List<com.airbnb.lottie.c.b.g> c;

    public g(List<com.airbnb.lottie.c.b.g> list) {
        this.c = list;
        this.f1647a = new ArrayList(list.size());
        this.f1648b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f1647a.add(list.get(i).b().a());
            this.f1648b.add(list.get(i).c().a());
        }
    }

    public List<com.airbnb.lottie.c.b.g> a() {
        return this.c;
    }

    public List<a<l, Path>> b() {
        return this.f1647a;
    }

    public List<a<Integer, Integer>> c() {
        return this.f1648b;
    }
}
