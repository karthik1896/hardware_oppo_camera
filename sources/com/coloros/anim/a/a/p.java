package com.coloros.anim.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.o;
import com.coloros.anim.b;
import com.coloros.anim.c.b.k;
import com.coloros.anim.d;
import com.coloros.anim.f.f;
import java.util.List;

/* compiled from: RepeaterContent */
public class p implements e, j, k, m, a.C0061a {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f2314a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f2315b = new Path();
    private final b c;
    private final com.coloros.anim.c.c.a d;
    private final String e;
    private final boolean f;
    private final a<Float, Float> g;
    private final a<Float, Float> h;
    private final o i;
    private d j;

    public p(b bVar, com.coloros.anim.c.c.a aVar, k kVar) {
        this.c = bVar;
        this.d = aVar;
        this.e = kVar.a();
        this.f = kVar.e();
        this.g = kVar.b().a();
        aVar.a((a<?, ?>) this.g);
        this.g.a((a.C0061a) this);
        this.h = kVar.c().a();
        aVar.a((a<?, ?>) this.h);
        this.h.a((a.C0061a) this);
        this.i = kVar.d().j();
        this.i.a(aVar);
        this.i.a((a.C0061a) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.ListIterator<com.coloros.anim.a.a.c> r9) {
        /*
            r8 = this;
            com.coloros.anim.a.a.d r0 = r8.j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r9.previous()
            if (r0 == r8) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0017:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r9.previous()
            r6.add(r0)
            r9.remove()
            goto L_0x0017
        L_0x0028:
            java.util.Collections.reverse(r6)
            com.coloros.anim.a.a.d r9 = new com.coloros.anim.a.a.d
            com.coloros.anim.b r2 = r8.c
            com.coloros.anim.c.c.a r3 = r8.d
            boolean r5 = r8.f
            r7 = 0
            java.lang.String r4 = "Repeater"
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.j = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.a.a.p.a(java.util.ListIterator):void");
    }

    public String b() {
        return this.e;
    }

    public void a(List<c> list, List<c> list2) {
        this.j.a(list, list2);
    }

    public Path e() {
        Path e2 = this.j.e();
        this.f2315b.reset();
        float floatValue = this.g.g().floatValue();
        float floatValue2 = this.h.g().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f2314a.set(this.i.b(((float) i2) + floatValue2));
            this.f2315b.addPath(e2, this.f2314a);
        }
        return this.f2315b;
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.g.g().floatValue();
        float floatValue2 = this.h.g().floatValue();
        float floatValue3 = this.i.b().g().floatValue() / 100.0f;
        float floatValue4 = this.i.c().g().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f2314a.set(matrix);
            float f2 = (float) i3;
            this.f2314a.preConcat(this.i.b(f2 + floatValue2));
            this.j.a(canvas, this.f2314a, (int) (((float) i2) * f.a(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.j.a(rectF, matrix, z);
    }

    public void a() {
        this.c.invalidateSelf();
    }

    public void a(com.coloros.anim.c.f fVar, int i2, List<com.coloros.anim.c.f> list, com.coloros.anim.c.f fVar2) {
        f.a(fVar, i2, list, fVar2, this);
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        if (!this.i.a(t, bVar)) {
            if (t == d.o) {
                this.g.a(bVar);
            } else if (t == d.p) {
                this.h.a(bVar);
            }
        }
    }
}
