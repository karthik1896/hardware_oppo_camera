package com.coloros.anim.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.p;
import com.coloros.anim.c.c.d;
import com.coloros.anim.c.f;
import com.coloros.anim.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositionLayer */
public class b extends a {
    private final List<a> e = new ArrayList();
    private final RectF f = new RectF();
    private final RectF g = new RectF();
    private a<Float, Float> h;

    public b(com.coloros.anim.b bVar, d dVar, List<d> list, com.coloros.anim.a aVar) {
        super(bVar, dVar);
        int i;
        a aVar2;
        com.coloros.anim.c.a.b u = dVar.u();
        if (u != null) {
            if (com.coloros.anim.f.b.d) {
                com.coloros.anim.f.b.b("CompositionLayer::create timeRemapping animation, this = " + dVar.f());
            }
            this.h = u.a();
            a((a<?, ?>) this.h);
            this.h.a((a.C0061a) this);
        } else {
            this.h = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(aVar.i().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar2 = list.get(size);
            if (com.coloros.anim.f.b.d) {
                com.coloros.anim.f.b.b("CompositionLayer::i = " + size + "; lm.type = " + dVar2.k() + "; lm.name = " + dVar2.f() + "; lm.id = " + dVar2.e());
            }
            a a2 = a.a(dVar2, bVar, aVar);
            if (a2 != null) {
                longSparseArray.put(a2.c().e(), a2);
                if (aVar3 != null) {
                    aVar3.a(a2);
                    aVar3 = null;
                } else {
                    this.e.add(0, a2);
                    int i2 = AnonymousClass1.f2410a[dVar2.l().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar3 = a2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            a aVar4 = (a) longSparseArray.get(longSparseArray.keyAt(i));
            if (!(aVar4 == null || (aVar2 = (a) longSparseArray.get(aVar4.c().m())) == null)) {
                aVar4.b(aVar2);
            }
        }
    }

    /* renamed from: com.coloros.anim.c.c.b$1  reason: invalid class name */
    /* compiled from: CompositionLayer */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2410a = new int[d.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.coloros.anim.c.c.d$b[] r0 = com.coloros.anim.c.c.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2410a = r0
                int[] r0 = f2410a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.coloros.anim.c.c.d$b r1 = com.coloros.anim.c.c.d.b.ADD     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2410a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.coloros.anim.c.c.d$b r1 = com.coloros.anim.c.c.d.b.INVERT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.c.c.b.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i) {
        k.c("CompositionLayer#draw");
        canvas.save();
        this.g.set(0.0f, 0.0f, (float) this.c.h(), (float) this.c.i());
        matrix.mapRect(this.g);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            if (!this.g.isEmpty() ? canvas.clipRect(this.g) : true) {
                this.e.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        k.d("CompositionLayer#draw");
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            this.f.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.e.get(size).a(this.f, this.f2404a, true);
            rectF.union(this.f);
        }
    }

    public void a(float f2) {
        super.a(f2);
        if (this.h != null) {
            f2 = ((float) ((long) (this.h.g().floatValue() * 1000.0f))) / this.f2405b.r().e();
        }
        if (this.c.b() != 0.0f) {
            f2 /= this.c.b();
        }
        float c = f2 - this.c.c();
        for (int size = this.e.size() - 1; size >= 0; size--) {
            this.e.get(size).a(c);
        }
    }

    /* access modifiers changed from: protected */
    public void b(f fVar, int i, List<f> list, f fVar2) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            this.e.get(i2).a(fVar, i, list, fVar2);
        }
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        super.a(t, bVar);
        if (t != com.coloros.anim.d.y) {
            return;
        }
        if (bVar == null) {
            this.h = null;
            return;
        }
        this.h = new p(bVar);
        a((a<?, ?>) this.h);
    }
}
