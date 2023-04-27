package com.airbnb.lottie.e;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionMoshiParser */
public class t {

    /* renamed from: a  reason: collision with root package name */
    static c.a f1783a = c.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f1784b = c.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    private static final c.a c = c.a.a("list");
    private static final c.a d = c.a.a("cm", "tm", "dr");

    public static d a(c cVar) throws IOException {
        ArrayList arrayList;
        HashMap hashMap;
        c cVar2 = cVar;
        float a2 = h.a();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        d dVar = new d();
        cVar.c();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = 0;
        int i2 = 0;
        while (cVar.e()) {
            switch (cVar2.a(f1784b)) {
                case 0:
                    HashMap hashMap5 = hashMap4;
                    ArrayList arrayList4 = arrayList3;
                    i = cVar.l();
                    continue;
                case 1:
                    HashMap hashMap6 = hashMap4;
                    ArrayList arrayList5 = arrayList3;
                    i2 = cVar.l();
                    continue;
                case 2:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f = (float) cVar.k();
                    break;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f2 = ((float) cVar.k()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = (float) cVar.k();
                    break;
                case 5:
                    String[] split = cVar.i().split("\\.");
                    if (!h.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        dVar.a("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    }
                    break;
                case 6:
                    a(cVar2, dVar, (List<com.airbnb.lottie.c.c.d>) arrayList2, (LongSparseArray<com.airbnb.lottie.c.c.d>) longSparseArray);
                    break;
                case 7:
                    a(cVar2, dVar, (Map<String, List<com.airbnb.lottie.c.c.d>>) hashMap2, (Map<String, g>) hashMap3);
                    break;
                case 8:
                    a(cVar2, hashMap4);
                    break;
                case 9:
                    a(cVar2, dVar, (SparseArrayCompat<com.airbnb.lottie.c.d>) sparseArrayCompat);
                    break;
                case 10:
                    a(cVar2, dVar, (List<com.airbnb.lottie.c.h>) arrayList3);
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    cVar.h();
                    cVar.m();
                    break;
            }
            hashMap = hashMap4;
            arrayList = arrayList3;
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            cVar2 = cVar;
        }
        HashMap hashMap7 = hashMap4;
        ArrayList arrayList6 = arrayList3;
        dVar.a(new Rect(0, 0, (int) (((float) i) * a2), (int) (((float) i2) * a2)), f, f2, f3, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return dVar;
    }

    private static void a(c cVar, d dVar, List<com.airbnb.lottie.c.c.d> list, LongSparseArray<com.airbnb.lottie.c.c.d> longSparseArray) throws IOException {
        cVar.a();
        int i = 0;
        while (cVar.e()) {
            com.airbnb.lottie.c.c.d a2 = s.a(cVar, dVar);
            if (a2.k() == d.a.IMAGE) {
                i++;
            }
            list.add(a2);
            longSparseArray.put(a2.e(), a2);
            if (i > 4) {
                com.airbnb.lottie.f.d.b("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.b();
    }

    private static void a(c cVar, com.airbnb.lottie.d dVar, Map<String, List<com.airbnb.lottie.c.c.d>> map, Map<String, g> map2) throws IOException {
        cVar.a();
        while (cVar.e()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            cVar.c();
            int i = 0;
            int i2 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (cVar.e()) {
                int a2 = cVar.a(f1783a);
                if (a2 == 0) {
                    str = cVar.i();
                } else if (a2 == 1) {
                    cVar.a();
                    while (cVar.e()) {
                        com.airbnb.lottie.c.c.d a3 = s.a(cVar, dVar);
                        longSparseArray.put(a3.e(), a3);
                        arrayList.add(a3);
                    }
                    cVar.b();
                } else if (a2 == 2) {
                    i = cVar.l();
                } else if (a2 == 3) {
                    i2 = cVar.l();
                } else if (a2 == 4) {
                    str2 = cVar.i();
                } else if (a2 != 5) {
                    cVar.h();
                    cVar.m();
                } else {
                    str3 = cVar.i();
                }
            }
            cVar.d();
            if (str2 != null) {
                g gVar = new g(i, i2, str, str2, str3);
                map2.put(gVar.c(), gVar);
            } else {
                map.put(str, arrayList);
            }
        }
        cVar.b();
    }

    private static void a(c cVar, Map<String, com.airbnb.lottie.c.c> map) throws IOException {
        cVar.c();
        while (cVar.e()) {
            if (cVar.a(c) != 0) {
                cVar.h();
                cVar.m();
            } else {
                cVar.a();
                while (cVar.e()) {
                    com.airbnb.lottie.c.c a2 = k.a(cVar);
                    map.put(a2.b(), a2);
                }
                cVar.b();
            }
        }
        cVar.d();
    }

    private static void a(c cVar, com.airbnb.lottie.d dVar, SparseArrayCompat<com.airbnb.lottie.c.d> sparseArrayCompat) throws IOException {
        cVar.a();
        while (cVar.e()) {
            com.airbnb.lottie.c.d a2 = j.a(cVar, dVar);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        cVar.b();
    }

    private static void a(c cVar, com.airbnb.lottie.d dVar, List<com.airbnb.lottie.c.h> list) throws IOException {
        cVar.a();
        while (cVar.e()) {
            String str = null;
            cVar.c();
            float f = 0.0f;
            float f2 = 0.0f;
            while (cVar.e()) {
                int a2 = cVar.a(d);
                if (a2 == 0) {
                    str = cVar.i();
                } else if (a2 == 1) {
                    f = (float) cVar.k();
                } else if (a2 != 2) {
                    cVar.h();
                    cVar.m();
                } else {
                    f2 = (float) cVar.k();
                }
            }
            cVar.d();
            list.add(new com.airbnb.lottie.c.h(str, f, f2));
        }
        cVar.b();
    }
}
