package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent */
public class s implements c, a.C0053a {

    /* renamed from: a  reason: collision with root package name */
    private final String f1639a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1640b;
    private final List<a.C0053a> c = new ArrayList();
    private final q.a d;
    private final a<?, Float> e;
    private final a<?, Float> f;
    private final a<?, Float> g;

    public void a(List<c> list, List<c> list2) {
    }

    public s(com.airbnb.lottie.c.c.a aVar, q qVar) {
        this.f1639a = qVar.a();
        this.f1640b = qVar.f();
        this.d = qVar.b();
        this.e = qVar.d().a();
        this.f = qVar.c().a();
        this.g = qVar.e().a();
        aVar.a((a<?, ?>) this.e);
        aVar.a((a<?, ?>) this.f);
        aVar.a((a<?, ?>) this.g);
        this.e.a((a.C0053a) this);
        this.f.a((a.C0053a) this);
        this.g.a((a.C0053a) this);
    }

    public void a() {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).a();
        }
    }

    public String b() {
        return this.f1639a;
    }

    /* access modifiers changed from: package-private */
    public void a(a.C0053a aVar) {
        this.c.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public q.a c() {
        return this.d;
    }

    public a<?, Float> d() {
        return this.e;
    }

    public a<?, Float> e() {
        return this.f;
    }

    public a<?, Float> f() {
        return this.g;
    }

    public boolean g() {
        return this.f1640b;
    }
}
