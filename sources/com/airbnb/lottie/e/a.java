package com.airbnb.lottie.e;

import android.graphics.PointF;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.e;
import com.airbnb.lottie.c.a.i;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.h;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static c.a f1741a = c.a.a("k", "x", "y");

    public static e a(c cVar, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.f() == c.b.BEGIN_ARRAY) {
            cVar.a();
            while (cVar.e()) {
                arrayList.add(w.a(cVar, dVar));
            }
            cVar.b();
            r.a(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.g.a(p.b(cVar, h.a())));
        }
        return new e(arrayList);
    }

    static m<PointF, PointF> b(c cVar, d dVar) throws IOException {
        cVar.c();
        e eVar = null;
        boolean z = false;
        b bVar = null;
        b bVar2 = null;
        while (cVar.f() != c.b.END_OBJECT) {
            int a2 = cVar.a(f1741a);
            if (a2 != 0) {
                if (a2 != 1) {
                    if (a2 != 2) {
                        cVar.h();
                        cVar.m();
                    } else if (cVar.f() == c.b.STRING) {
                        cVar.m();
                    } else {
                        bVar2 = d.a(cVar, dVar);
                    }
                } else if (cVar.f() == c.b.STRING) {
                    cVar.m();
                } else {
                    bVar = d.a(cVar, dVar);
                }
                z = true;
            } else {
                eVar = a(cVar, dVar);
            }
        }
        cVar.d();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        if (eVar != null) {
            return eVar;
        }
        return new i(bVar, bVar2);
    }
}
