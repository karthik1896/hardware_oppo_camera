package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.c.b.p;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.k;

/* compiled from: StrokeContent */
public class r extends a {
    private final a c;
    private final String d;
    private final boolean e;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> f;
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> g;

    public r(f fVar, a aVar, p pVar) {
        super(fVar, aVar, pVar.g().toPaintCap(), pVar.h().toPaintJoin(), pVar.i(), pVar.c(), pVar.d(), pVar.e(), pVar.f());
        this.c = aVar;
        this.d = pVar.a();
        this.e = pVar.j();
        this.f = pVar.b().a();
        this.f.a((a.C0053a) this);
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.f);
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        if (!this.e) {
            this.f1615b.setColor(((b) this.f).i());
            if (this.g != null) {
                this.f1615b.setColorFilter(this.g.g());
            }
            super.a(canvas, matrix, i);
        }
    }

    public String b() {
        return this.d;
    }

    public <T> void a(T t, c<T> cVar) {
        super.a(t, cVar);
        if (t == k.f1838b) {
            this.f.a(cVar);
        } else if (t == k.C) {
            com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.g;
            if (aVar != null) {
                this.c.b((com.airbnb.lottie.a.b.a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.g = null;
                return;
            }
            this.g = new com.airbnb.lottie.a.b.p(cVar);
            this.g.a((a.C0053a) this);
            this.c.a((com.airbnb.lottie.a.b.a<?, ?>) this.f);
        }
    }
}
