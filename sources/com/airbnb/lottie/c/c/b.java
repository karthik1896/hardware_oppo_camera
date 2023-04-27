package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositionLayer */
public class b extends a {
    private a<Float, Float> e;
    private final List<a> f = new ArrayList();
    private final RectF g = new RectF();
    private final RectF h = new RectF();
    private Paint i = new Paint();

    public b(f fVar, d dVar, List<d> list, d dVar2) {
        super(fVar, dVar);
        int i2;
        a aVar;
        com.airbnb.lottie.c.a.b u = dVar.u();
        if (u != null) {
            this.e = u.a();
            a((a<?, ?>) this.e);
            this.e.a((a.C0053a) this);
        } else {
            this.e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar2.i().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar3 = list.get(size);
            a a2 = a.a(dVar3, fVar, dVar2);
            if (a2 != null) {
                longSparseArray.put(a2.c().e(), a2);
                if (aVar2 != null) {
                    aVar2.a(a2);
                    aVar2 = null;
                } else {
                    this.f.add(0, a2);
                    int i3 = AnonymousClass1.f1708a[dVar3.l().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        aVar2 = a2;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            a aVar3 = (a) longSparseArray.get(longSparseArray.keyAt(i2));
            if (!(aVar3 == null || (aVar = (a) longSparseArray.get(aVar3.c().m())) == null)) {
                aVar3.b(aVar);
            }
        }
    }

    /* renamed from: com.airbnb.lottie.c.c.b$1  reason: invalid class name */
    /* compiled from: CompositionLayer */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1708a = new int[d.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.airbnb.lottie.c.c.d$b[] r0 = com.airbnb.lottie.c.c.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1708a = r0
                int[] r0 = f1708a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.c.d$b r1 = com.airbnb.lottie.c.c.d.b.ADD     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1708a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.c.d$b r1 = com.airbnb.lottie.c.c.d.b.INVERT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.b.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i2) {
        c.a("CompositionLayer#draw");
        this.h.set(0.0f, 0.0f, (float) this.c.h(), (float) this.c.i());
        matrix.mapRect(this.h);
        boolean z = this.f1704b.d() && this.f.size() > 1 && i2 != 255;
        if (z) {
            this.i.setAlpha(i2);
            h.a(canvas, this.h, this.i);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            if (!this.h.isEmpty() ? canvas.clipRect(this.h) : true) {
                this.f.get(size).a(canvas, matrix, i2);
            }
        }
        canvas.restore();
        c.b("CompositionLayer#draw");
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            this.g.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f.get(size).a(this.g, this.f1703a, true);
            rectF.union(this.g);
        }
    }

    public void a(float f2) {
        super.a(f2);
        if (this.e != null) {
            f2 = ((this.e.g().floatValue() * this.c.a().h()) - this.c.a().f()) / (this.f1704b.s().m() + 0.01f);
        }
        if (this.e == null) {
            f2 -= this.c.c();
        }
        if (this.c.b() != 0.0f) {
            f2 /= this.c.b();
        }
        for (int size = this.f.size() - 1; size >= 0; size--) {
            this.f.get(size).a(f2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(e eVar, int i2, List<e> list, e eVar2) {
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            this.f.get(i3).a(eVar, i2, list, eVar2);
        }
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t != k.A) {
            return;
        }
        if (cVar == null) {
            a<Float, Float> aVar = this.e;
            if (aVar != null) {
                aVar.a((com.airbnb.lottie.g.c<Float>) null);
                return;
            }
            return;
        }
        this.e = new p(cVar);
        this.e.a((a.C0053a) this);
        a((a<?, ?>) this.e);
    }
}
