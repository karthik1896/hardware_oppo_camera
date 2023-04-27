package com.airbnb.lottie.e;

import android.graphics.PointF;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.b.j;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: RectangleShapeParser */
class aa {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f1746a = c.a.a("nm", "p", "s", "r", "hd");

    static j a(c cVar, d dVar) throws IOException {
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        b bVar = null;
        boolean z = false;
        while (cVar.e()) {
            int a2 = cVar.a(f1746a);
            if (a2 == 0) {
                str = cVar.i();
            } else if (a2 == 1) {
                mVar = a.b(cVar, dVar);
            } else if (a2 == 2) {
                fVar = d.c(cVar, dVar);
            } else if (a2 == 3) {
                bVar = d.a(cVar, dVar);
            } else if (a2 != 4) {
                cVar.m();
            } else {
                z = cVar.j();
            }
        }
        return new j(str, mVar, fVar, bVar, z);
    }
}
