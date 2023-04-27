package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.b.b;
import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.c.f;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup */
public class d implements e, m, a.C0053a, f {

    /* renamed from: a  reason: collision with root package name */
    private Paint f1619a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f1620b;
    private final Matrix c;
    private final Path d;
    private final RectF e;
    private final String f;
    private final boolean g;
    private final List<c> h;
    private final com.airbnb.lottie.f i;
    private List<m> j;
    private o k;

    private static List<c> a(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            c a2 = list.get(i2).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    static l a(List<b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof l) {
                return (l) bVar;
            }
        }
        return null;
    }

    public d(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, n nVar) {
        this(fVar, aVar, nVar.a(), nVar.c(), a(fVar, aVar, nVar.b()), a(nVar.b()));
    }

    d(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, String str, boolean z, List<c> list, l lVar) {
        this.f1619a = new com.airbnb.lottie.a.a();
        this.f1620b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = fVar;
        this.g = z;
        this.h = list;
        if (lVar != null) {
            this.k = lVar.j();
            this.k.a(aVar);
            this.k.a((a.C0053a) this);
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

    public void a() {
        this.i.invalidateSelf();
    }

    public String b() {
        return this.f;
    }

    public void a(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.h.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            c cVar = this.h.get(size);
            cVar.a(arrayList, this.h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public List<m> c() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                c cVar = this.h.get(i2);
                if (cVar instanceof m) {
                    this.j.add((m) cVar);
                }
            }
        }
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public Matrix d() {
        o oVar = this.k;
        if (oVar != null) {
            return oVar.d();
        }
        this.c.reset();
        return this.c;
    }

    public Path e() {
        this.c.reset();
        o oVar = this.k;
        if (oVar != null) {
            this.c.set(oVar.d());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            c cVar = this.h.get(size);
            if (cVar instanceof m) {
                this.d.addPath(((m) cVar).e(), this.c);
            }
        }
        return this.d;
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (!this.g) {
            this.c.set(matrix);
            o oVar = this.k;
            if (oVar != null) {
                this.c.preConcat(oVar.d());
                i2 = (int) ((((((float) (this.k.a() == null ? 100 : this.k.a().g().intValue())) / 100.0f) * ((float) i2)) / 255.0f) * 255.0f);
            }
            boolean z = this.i.d() && f() && i2 != 255;
            if (z) {
                this.f1620b.set(0.0f, 0.0f, 0.0f, 0.0f);
                a(this.f1620b, this.c, true);
                this.f1619a.setAlpha(i2);
                h.a(canvas, this.f1620b, this.f1619a);
            }
            if (z) {
                i2 = 255;
            }
            for (int size = this.h.size() - 1; size >= 0; size--) {
                c cVar = this.h.get(size);
                if (cVar instanceof e) {
                    ((e) cVar).a(canvas, this.c, i2);
                }
            }
            if (z) {
                canvas.restore();
            }
        }
    }

    private boolean f() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.h.size(); i3++) {
            if ((this.h.get(i3) instanceof e) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.c.set(matrix);
        o oVar = this.k;
        if (oVar != null) {
            this.c.preConcat(oVar.d());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            c cVar = this.h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.e, this.c, z);
                rectF.union(this.e);
            }
        }
    }

    public void a(e eVar, int i2, List<e> list, e eVar2) {
        if (eVar.a(b(), i2)) {
            if (!"__container".equals(b())) {
                eVar2 = eVar2.a(b());
                if (eVar.c(b(), i2)) {
                    list.add(eVar2.a((f) this));
                }
            }
            if (eVar.d(b(), i2)) {
                int b2 = i2 + eVar.b(b(), i2);
                for (int i3 = 0; i3 < this.h.size(); i3++) {
                    c cVar = this.h.get(i3);
                    if (cVar instanceof f) {
                        ((f) cVar).a(eVar, b2, list, eVar2);
                    }
                }
            }
        }
    }

    public <T> void a(T t, c<T> cVar) {
        o oVar = this.k;
        if (oVar != null) {
            oVar.a(t, cVar);
        }
    }
}
