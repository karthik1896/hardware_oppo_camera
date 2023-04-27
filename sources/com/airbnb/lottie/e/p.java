package com.airbnb.lottie.e;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils */
class p {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f1776a = c.a.a("x", "y");

    static int a(c cVar) throws IOException {
        cVar.a();
        int k = (int) (cVar.k() * 255.0d);
        int k2 = (int) (cVar.k() * 255.0d);
        int k3 = (int) (cVar.k() * 255.0d);
        while (cVar.e()) {
            cVar.m();
        }
        cVar.b();
        return Color.argb(255, k, k2, k3);
    }

    static List<PointF> a(c cVar, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.a();
        while (cVar.f() == c.b.BEGIN_ARRAY) {
            cVar.a();
            arrayList.add(b(cVar, f));
            cVar.b();
        }
        cVar.b();
        return arrayList;
    }

    /* renamed from: com.airbnb.lottie.e.p$1  reason: invalid class name */
    /* compiled from: JsonUtils */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1777a = new int[c.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.airbnb.lottie.e.a.c$b[] r0 = com.airbnb.lottie.e.a.c.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1777a = r0
                int[] r0 = f1777a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.e.a.c$b r1 = com.airbnb.lottie.e.a.c.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1777a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.e.a.c$b r1 = com.airbnb.lottie.e.a.c.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1777a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.e.a.c$b r1 = com.airbnb.lottie.e.a.c.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e.p.AnonymousClass1.<clinit>():void");
        }
    }

    static PointF b(c cVar, float f) throws IOException {
        int i = AnonymousClass1.f1777a[cVar.f().ordinal()];
        if (i == 1) {
            return c(cVar, f);
        }
        if (i == 2) {
            return d(cVar, f);
        }
        if (i == 3) {
            return e(cVar, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.f());
    }

    private static PointF c(c cVar, float f) throws IOException {
        float k = (float) cVar.k();
        float k2 = (float) cVar.k();
        while (cVar.e()) {
            cVar.m();
        }
        return new PointF(k * f, k2 * f);
    }

    private static PointF d(c cVar, float f) throws IOException {
        cVar.a();
        float k = (float) cVar.k();
        float k2 = (float) cVar.k();
        while (cVar.f() != c.b.END_ARRAY) {
            cVar.m();
        }
        cVar.b();
        return new PointF(k * f, k2 * f);
    }

    private static PointF e(c cVar, float f) throws IOException {
        cVar.c();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (cVar.e()) {
            int a2 = cVar.a(f1776a);
            if (a2 == 0) {
                f2 = b(cVar);
            } else if (a2 != 1) {
                cVar.h();
                cVar.m();
            } else {
                f3 = b(cVar);
            }
        }
        cVar.d();
        return new PointF(f2 * f, f3 * f);
    }

    static float b(c cVar) throws IOException {
        c.b f = cVar.f();
        int i = AnonymousClass1.f1777a[f.ordinal()];
        if (i == 1) {
            return (float) cVar.k();
        }
        if (i == 2) {
            cVar.a();
            float k = (float) cVar.k();
            while (cVar.e()) {
                cVar.m();
            }
            cVar.b();
            return k;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + f);
    }
}
