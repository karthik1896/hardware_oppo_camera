package com.airbnb.lottie.e;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.j;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: LayerParser */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f1781a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f1782b = c.a.a("d", "a");
    private static final c.a c = c.a.a("nm");

    public static d a(com.airbnb.lottie.d dVar) {
        Rect d = dVar.d();
        List emptyList = Collections.emptyList();
        d.a aVar = d.a.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        l lVar = r4;
        l lVar2 = new l();
        return new d(emptyList, dVar, "__container", -1, aVar, -1, (String) null, emptyList2, lVar, 0, 0, 0, 0.0f, 0.0f, d.width(), d.height(), (j) null, (k) null, Collections.emptyList(), d.b.NONE, (b) null, false);
    }

    public static d a(c cVar, com.airbnb.lottie.d dVar) throws IOException {
        float f;
        ArrayList arrayList;
        float f2;
        c cVar2 = cVar;
        com.airbnb.lottie.d dVar2 = dVar;
        d.b bVar = d.b.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cVar.c();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        d.b bVar2 = bVar;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        d.a aVar = null;
        String str = null;
        l lVar = null;
        j jVar = null;
        k kVar = null;
        b bVar3 = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        long j = -1;
        float f5 = 1.0f;
        float f6 = 0.0f;
        long j2 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (cVar.e()) {
            switch (cVar2.a(f1781a)) {
                case 0:
                    str3 = cVar.i();
                    break;
                case 1:
                    j2 = (long) cVar.l();
                    break;
                case 2:
                    str = cVar.i();
                    break;
                case 3:
                    int l = cVar.l();
                    if (l >= d.a.UNKNOWN.ordinal()) {
                        aVar = d.a.UNKNOWN;
                        break;
                    } else {
                        aVar = d.a.values()[l];
                        break;
                    }
                case 4:
                    j = (long) cVar.l();
                    break;
                case 5:
                    i = (int) (((float) cVar.l()) * h.a());
                    break;
                case 6:
                    i2 = (int) (((float) cVar.l()) * h.a());
                    break;
                case 7:
                    i3 = Color.parseColor(cVar.i());
                    break;
                case 8:
                    lVar = c.a(cVar, dVar);
                    break;
                case 9:
                    bVar2 = d.b.values()[cVar.l()];
                    dVar2.a(1);
                    break;
                case 10:
                    cVar.a();
                    while (cVar.e()) {
                        arrayList2.add(u.a(cVar, dVar));
                    }
                    dVar2.a(arrayList2.size());
                    cVar.b();
                    break;
                case 11:
                    cVar.a();
                    while (cVar.e()) {
                        com.airbnb.lottie.c.b.b a2 = g.a(cVar, dVar);
                        if (a2 != null) {
                            arrayList3.add(a2);
                        }
                    }
                    cVar.b();
                    break;
                case 12:
                    cVar.c();
                    while (cVar.e()) {
                        int a3 = cVar2.a(f1782b);
                        if (a3 == 0) {
                            jVar = d.f(cVar, dVar);
                        } else if (a3 != 1) {
                            cVar.h();
                            cVar.m();
                        } else {
                            cVar.a();
                            if (cVar.e()) {
                                kVar = b.a(cVar, dVar);
                            }
                            while (cVar.e()) {
                                cVar.m();
                            }
                            cVar.b();
                        }
                    }
                    cVar.d();
                    break;
                case 13:
                    cVar.a();
                    ArrayList arrayList4 = new ArrayList();
                    while (cVar.e()) {
                        cVar.c();
                        while (cVar.e()) {
                            if (cVar2.a(c) != 0) {
                                cVar.h();
                                cVar.m();
                            } else {
                                arrayList4.add(cVar.i());
                            }
                        }
                        cVar.d();
                    }
                    cVar.b();
                    dVar2.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    f5 = (float) cVar.k();
                    break;
                case 15:
                    f4 = (float) cVar.k();
                    break;
                case 16:
                    i4 = (int) (((float) cVar.l()) * h.a());
                    break;
                case 17:
                    i5 = (int) (((float) cVar.l()) * h.a());
                    break;
                case 18:
                    f3 = (float) cVar.k();
                    break;
                case 19:
                    f6 = (float) cVar.k();
                    break;
                case 20:
                    bVar3 = d.a(cVar2, dVar2, false);
                    break;
                case 21:
                    str2 = cVar.i();
                    break;
                case 22:
                    z = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        float f7 = f3 / f5;
        float f8 = f6 / f5;
        ArrayList arrayList5 = new ArrayList();
        if (f7 > 0.0f) {
            a aVar2 = r0;
            f = f5;
            arrayList = arrayList5;
            a aVar3 = new a(dVar, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f7));
            arrayList.add(aVar2);
            f2 = 0.0f;
        } else {
            f = f5;
            arrayList = arrayList5;
            f2 = 0.0f;
        }
        if (f8 <= f2) {
            f8 = dVar.g();
        }
        com.airbnb.lottie.d dVar3 = dVar;
        arrayList.add(new a(dVar3, valueOf, valueOf, (Interpolator) null, f7, Float.valueOf(f8)));
        arrayList.add(new a(dVar3, valueOf2, valueOf2, (Interpolator) null, f8, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            dVar2.a("Convert your Illustrator layers to shape layers.");
        }
        return new d(arrayList3, dVar, str3, j2, aVar, j, str, arrayList2, lVar, i, i2, i3, f, f4, i4, i5, jVar, kVar, arrayList, bVar2, bVar3, z);
    }
}
