package com.coloros.anim.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.coloros.anim.a.b.a;
import com.coloros.anim.b;
import com.coloros.anim.c.b.p;
import com.coloros.anim.c.c.a;
import com.coloros.anim.d;

/* compiled from: StrokeContent */
public class r extends a {

    /* renamed from: b  reason: collision with root package name */
    private final a f2318b;
    private final String c;
    private final boolean d;
    private final com.coloros.anim.a.b.a<Integer, Integer> e;
    private com.coloros.anim.a.b.a<ColorFilter, ColorFilter> f;

    public r(b bVar, a aVar, p pVar) {
        super(bVar, aVar, pVar.g().toPaintCap(), pVar.h().toPaintJoin(), pVar.i(), pVar.c(), pVar.d(), pVar.e(), pVar.f());
        this.f2318b = aVar;
        this.c = pVar.a();
        this.d = pVar.j();
        this.e = pVar.b().a();
        this.e.a((a.C0061a) this);
        aVar.a((com.coloros.anim.a.b.a<?, ?>) this.e);
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        if (!this.d) {
            this.f2292a.setColor(((com.coloros.anim.a.b.b) this.e).i());
            if (this.f != null) {
                this.f2292a.setColorFilter(this.f.g());
            }
            super.a(canvas, matrix, i);
        }
    }

    public String b() {
        return this.c;
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        super.a(t, bVar);
        if (t == d.f2427b) {
            this.e.a(bVar);
        } else if (t != d.z) {
        } else {
            if (bVar == null) {
                this.f = null;
                return;
            }
            this.f = new com.coloros.anim.a.b.p(bVar);
            this.f.a((a.C0061a) this);
            this.f2318b.a((com.coloros.anim.a.b.a<?, ?>) this.e);
        }
    }
}
