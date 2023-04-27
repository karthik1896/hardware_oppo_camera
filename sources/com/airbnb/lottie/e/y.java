package com.airbnb.lottie.e;

import android.graphics.PointF;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: PointFParser */
public class y implements aj<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f1787a = new y();

    private y() {
    }

    /* renamed from: a */
    public PointF b(c cVar, float f) throws IOException {
        c.b f2 = cVar.f();
        if (f2 == c.b.BEGIN_ARRAY) {
            return p.b(cVar, f);
        }
        if (f2 == c.b.BEGIN_OBJECT) {
            return p.b(cVar, f);
        }
        if (f2 == c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.k()) * f, ((float) cVar.k()) * f);
            while (cVar.e()) {
                cVar.m();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + f2);
    }
}
