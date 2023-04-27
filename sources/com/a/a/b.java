package com.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseSpringSystem */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, f> f1595a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<f> f1596b = new CopyOnWriteArraySet();
    private final i c;
    private final CopyOnWriteArraySet<k> d = new CopyOnWriteArraySet<>();
    private boolean e = true;

    public b(i iVar) {
        if (iVar != null) {
            this.c = iVar;
            this.c.a(this);
            return;
        }
        throw new IllegalArgumentException("springLooper is required");
    }

    public boolean a() {
        return this.e;
    }

    public f b() {
        f fVar = new f(this);
        a(fVar);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("spring is required");
        } else if (!this.f1595a.containsKey(fVar.b())) {
            this.f1595a.put(fVar.b(), fVar);
        } else {
            throw new IllegalArgumentException("spring is already registered");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(f fVar) {
        if (fVar != null) {
            this.f1596b.remove(fVar);
            this.f1595a.remove(fVar.b());
            return;
        }
        throw new IllegalArgumentException("spring is required");
    }

    /* access modifiers changed from: package-private */
    public void a(double d2) {
        for (f next : this.f1596b) {
            if (next.g()) {
                next.d(d2 / 1000.0d);
            } else {
                this.f1596b.remove(next);
            }
        }
    }

    public void b(double d2) {
        Iterator<k> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        a(d2);
        if (this.f1596b.isEmpty()) {
            this.e = true;
        }
        Iterator<k> it2 = this.d.iterator();
        while (it2.hasNext()) {
            it2.next().b(this);
        }
        if (this.e) {
            this.c.c();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        f fVar = this.f1595a.get(str);
        if (fVar != null) {
            this.f1596b.add(fVar);
            if (a()) {
                this.e = false;
                this.c.b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
    }
}
