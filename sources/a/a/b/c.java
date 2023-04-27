package a.a.b;

import a.a.b.a.a.a;
import a.a.b.a.h;
import a.a.b.b.d;
import a.a.b.e.o;
import a.a.b.e.s;
import android.content.res.Resources;
import co.polarr.renderer.entities.Context;

public class c implements AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public a.a.b.a.a.c f21a;

    /* renamed from: b  reason: collision with root package name */
    public h f22b;
    public d[] c = null;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;

    public c(Resources resources, Context context) {
        this.f21a = a.a.b.a.a.c.a(context);
        this.f22b = new h(resources, context);
        this.f22b.a();
    }

    public d a(d dVar, int i, int i2) {
        a(dVar.f12b, dVar.c, i, i2);
        d[] dVarArr = this.c;
        int length = dVarArr.length;
        int i3 = 0;
        while (i3 < length) {
            d dVar2 = dVarArr[i3];
            this.f22b.c(dVar.f12b, dVar.c);
            a((a) this.f22b, dVar, dVar2);
            i3++;
            dVar = dVar2;
        }
        return dVar;
    }

    public final void a() {
        d[] dVarArr = this.c;
        if (dVarArr != null) {
            for (d a2 : dVarArr) {
                a.a(a2);
            }
            this.c = null;
            this.g = 0;
            this.f = 0;
            this.e = 0;
            this.d = 0;
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (!(this.c == null || (this.d == i && this.e == i2 && this.f == i3 && this.g == i4))) {
            a();
        }
        if (this.c == null) {
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            int i5 = this.d;
            int i6 = this.e;
            int i7 = 0;
            while (i5 > i3) {
                i5 >>= 1;
                if (i5 <= i3) {
                    break;
                }
                i7++;
            }
            if (i7 == 0) {
                i7 = 1;
            }
            int i8 = this.d;
            this.c = new d[i7];
            int i9 = i6;
            for (int i10 = 0; i10 < i7; i10++) {
                i8 >>= 1;
                i9 >>= 1;
                int[] iArr = new int[1];
                s.a(iArr.length, iArr, 0, 6408, i8, i9);
                this.c[i10] = s.b(iArr[0], 6408, i8, i9);
            }
        }
    }

    public final void a(a aVar, d dVar, d dVar2) {
        this.f21a.a(dVar.f11a);
        this.f21a.b(dVar2.f11a);
        this.f21a.a(o.a());
        this.f21a.b(dVar2.f12b, dVar2.c);
        this.f21a.a(aVar);
        this.f21a.draw();
    }

    public void close() {
        a();
        this.f21a = null;
        this.f22b = null;
    }
}
