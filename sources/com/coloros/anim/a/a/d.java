package com.coloros.anim.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.o;
import com.coloros.anim.b;
import com.coloros.anim.c.a.l;
import com.coloros.anim.c.b.n;
import com.coloros.anim.c.f;
import com.coloros.anim.c.g;
import com.coloros.anim.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup */
public class d implements e, m, a.C0061a, g {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f2297a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f2298b;
    private final RectF c;
    private final String d;
    private final boolean e;
    private final List<c> f;
    private final b g;
    private List<m> h;
    private o i;

    public d(b bVar, com.coloros.anim.c.c.a aVar, n nVar) {
        this(bVar, aVar, nVar.a(), nVar.c(), a(bVar, aVar, nVar.b()), a(nVar.b()));
    }

    d(b bVar, com.coloros.anim.c.c.a aVar, String str, boolean z, List<c> list, l lVar) {
        this.f2297a = new Matrix();
        this.f2298b = new Path();
        this.c = new RectF();
        this.d = str;
        this.g = bVar;
        this.e = z;
        this.f = list;
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("ContentGroup::name = " + str + this);
        }
        if (lVar != null) {
            this.i = lVar.j();
            this.i.a(aVar);
            this.i.a((a.C0061a) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    private static List<c> a(b bVar, com.coloros.anim.c.c.a aVar, List<com.coloros.anim.c.b.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("ContentGroup::contentsFromModels()::contentModels.size() = " + list.size());
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            c a2 = list.get(i2).a(bVar, aVar);
            if (com.coloros.anim.f.b.d) {
                com.coloros.anim.f.b.b("ContentGroup::contentsFromModels()::content + " + i2);
            }
            if (a2 != null) {
                if (com.coloros.anim.f.b.d) {
                    com.coloros.anim.f.b.b("ContentGroup::contentsFromModels()::content = " + a2.toString());
                }
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    static l a(List<com.coloros.anim.c.b.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.coloros.anim.c.b.b bVar = list.get(i2);
            if (bVar instanceof l) {
                if (com.coloros.anim.f.b.d) {
                    com.coloros.anim.f.b.b("ContentGroup::findTransform()::contentModel = " + bVar);
                }
                return (l) bVar;
            }
        }
        return null;
    }

    public void a() {
        this.g.invalidateSelf();
    }

    public String b() {
        return this.d;
    }

    public void a(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f.size());
        arrayList.addAll(list);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            c cVar = this.f.get(size);
            cVar.a(arrayList, this.f.subList(0, size));
            arrayList.add(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public List<m> c() {
        if (this.h == null) {
            this.h = new ArrayList();
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                c cVar = this.f.get(i2);
                if (cVar instanceof m) {
                    this.h.add((m) cVar);
                }
            }
        }
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public Matrix d() {
        o oVar = this.i;
        if (oVar != null) {
            return oVar.d();
        }
        this.f2297a.reset();
        return this.f2297a;
    }

    public Path e() {
        this.f2297a.reset();
        o oVar = this.i;
        if (oVar != null) {
            this.f2297a.set(oVar.d());
        }
        this.f2298b.reset();
        if (this.e) {
            return this.f2298b;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            c cVar = this.f.get(size);
            if (cVar instanceof m) {
                this.f2298b.addPath(((m) cVar).e(), this.f2297a);
            }
        }
        return this.f2298b;
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (!this.e) {
            k.c("ContentGroup#draw");
            this.f2297a.set(matrix);
            o oVar = this.i;
            if (oVar != null) {
                this.f2297a.preConcat(oVar.d());
                i2 = (int) ((((((float) (this.i.a() == null ? 100 : this.i.a().g().intValue())) / 100.0f) * ((float) i2)) / 255.0f) * 255.0f);
            }
            for (int size = this.f.size() - 1; size >= 0; size--) {
                c cVar = this.f.get(size);
                if (cVar instanceof e) {
                    if (com.coloros.anim.f.b.f2452a) {
                        com.coloros.anim.f.b.b("ContentGroup::draw() content = " + ((e) cVar).b());
                    }
                    ((e) cVar).a(canvas, this.f2297a, i2);
                }
            }
            k.d("ContentGroup#draw");
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f2297a.set(matrix);
        o oVar = this.i;
        if (oVar != null) {
            this.f2297a.preConcat(oVar.d());
        }
        this.c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            c cVar = this.f.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.c, this.f2297a, z);
                rectF.union(this.c);
            }
        }
    }

    public void a(f fVar, int i2, List<f> list, f fVar2) {
        if (com.coloros.anim.f.b.c) {
            com.coloros.anim.f.b.b("ContentGroup::resolveChildKeyPath()");
        }
        if (fVar.a(b(), i2)) {
            if (!"__container".equals(b())) {
                fVar2 = fVar2.a(b());
                if (fVar.c(b(), i2)) {
                    if (com.coloros.anim.f.b.c) {
                        com.coloros.anim.f.b.b("ContentGroup::resolveChildKeyPath():name = " + b());
                    }
                    list.add(fVar2.a((g) this));
                }
            }
            if (fVar.d(b(), i2)) {
                int b2 = i2 + fVar.b(b(), i2);
                for (int i3 = 0; i3 < this.f.size(); i3++) {
                    c cVar = this.f.get(i3);
                    if (com.coloros.anim.f.b.c) {
                        com.coloros.anim.f.b.b("ContentGroup::resolveChildKeyPath()");
                    }
                    if (cVar instanceof g) {
                        g gVar = (g) cVar;
                        if (com.coloros.anim.f.b.c) {
                            com.coloros.anim.f.b.b("ContentGroup::resolveChildKeyPath()");
                        }
                        gVar.a(fVar, b2, list, fVar2);
                    }
                }
            }
        }
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        o oVar = this.i;
        if (oVar != null) {
            oVar.a(t, bVar);
        }
    }
}
