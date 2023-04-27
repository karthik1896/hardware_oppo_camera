package com.airbnb.lottie.e;

import com.airbnb.lottie.a.b.h;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.g.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser */
class r {

    /* renamed from: a  reason: collision with root package name */
    static c.a f1780a = c.a.a("k");

    static <T> List<a<T>> a(c cVar, d dVar, float f, aj<T> ajVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.f() == c.b.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.c();
        while (cVar.e()) {
            if (cVar.a(f1780a) != 0) {
                cVar.m();
            } else if (cVar.f() == c.b.BEGIN_ARRAY) {
                cVar.a();
                if (cVar.f() == c.b.NUMBER) {
                    arrayList.add(q.a(cVar, dVar, f, ajVar, false));
                } else {
                    while (cVar.e()) {
                        arrayList.add(q.a(cVar, dVar, f, ajVar, true));
                    }
                }
                cVar.b();
            } else {
                arrayList.add(q.a(cVar, dVar, f, ajVar, false));
            }
        }
        cVar.d();
        a(arrayList);
        return arrayList;
    }

    public static <T> void a(List<? extends a<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            a aVar = (a) list.get(i2);
            i2++;
            a aVar2 = (a) list.get(i2);
            aVar.e = Float.valueOf(aVar2.d);
            if (aVar.f1830b == null && aVar2.f1829a != null) {
                aVar.f1830b = aVar2.f1829a;
                if (aVar instanceof h) {
                    ((h) aVar).a();
                }
            }
        }
        a aVar3 = (a) list.get(i);
        if ((aVar3.f1829a == null || aVar3.f1830b == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
