package com.airbnb.lottie.f;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.a.k;
import com.airbnb.lottie.c.a;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.c.f;
import java.util.List;

/* compiled from: MiscUtils */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static PointF f1824a = new PointF();

    public static double a(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int a(int i, int i2, float f) {
        return (int) (((float) i) + (f * ((float) (i2 - i))));
    }

    public static boolean c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(l lVar, Path path) {
        path.reset();
        PointF a2 = lVar.a();
        path.moveTo(a2.x, a2.y);
        f1824a.set(a2.x, a2.y);
        for (int i = 0; i < lVar.c().size(); i++) {
            a aVar = lVar.c().get(i);
            PointF a3 = aVar.a();
            PointF b2 = aVar.b();
            PointF c = aVar.c();
            if (!a3.equals(f1824a) || !b2.equals(c)) {
                path.cubicTo(a3.x, a3.y, b2.x, b2.y, c.x, c.y);
            } else {
                path.lineTo(c.x, c.y);
            }
            f1824a.set(c.x, c.y);
        }
        if (lVar.b()) {
            path.close();
        }
    }

    static int a(float f, float f2) {
        return a((int) f, (int) f2);
    }

    private static int a(int i, int i2) {
        return i - (i2 * b(i, i2));
    }

    private static int b(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static void a(e eVar, int i, List<e> list, e eVar2, k kVar) {
        if (eVar.c(kVar.b(), i)) {
            list.add(eVar2.a(kVar.b()).a((f) kVar));
        }
    }
}
