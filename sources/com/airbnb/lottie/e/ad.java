package com.airbnb.lottie.e;

import android.graphics.PointF;
import com.airbnb.lottie.c.a;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser */
public class ad implements aj<l> {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f1749a = new ad();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f1750b = c.a.a("c", "v", "i", "o");

    private ad() {
    }

    /* renamed from: a */
    public l b(c cVar, float f) throws IOException {
        if (cVar.f() == c.b.BEGIN_ARRAY) {
            cVar.a();
        }
        cVar.c();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (cVar.e()) {
            int a2 = cVar.a(f1750b);
            if (a2 == 0) {
                z = cVar.j();
            } else if (a2 == 1) {
                list = p.a(cVar, f);
            } else if (a2 == 2) {
                list2 = p.a(cVar, f);
            } else if (a2 != 3) {
                cVar.h();
                cVar.m();
            } else {
                list3 = p.a(cVar, f);
            }
        }
        cVar.d();
        if (cVar.f() == c.b.END_ARRAY) {
            cVar.b();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new l(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new a(g.a(list.get(i2), list3.get(i2)), g.a(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new a(g.a(list.get(i3), list3.get(i3)), g.a(pointF3, list2.get(0)), pointF3));
            }
            return new l(pointF, z, arrayList);
        }
    }
}
