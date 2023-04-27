package com.coloros.anim.f;

import android.graphics.Path;
import android.graphics.PointF;
import com.coloros.anim.a.a.k;
import com.coloros.anim.c.a;
import com.coloros.anim.c.b.l;
import com.coloros.anim.c.g;
import java.util.List;

/* compiled from: MiscUtils */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static PointF f2458a = new PointF();

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
        f2458a.set(a2.x, a2.y);
        for (int i = 0; i < lVar.c().size(); i++) {
            a aVar = lVar.c().get(i);
            PointF a3 = aVar.a();
            PointF b2 = aVar.b();
            PointF c = aVar.c();
            if (!a3.equals(f2458a) || !b2.equals(c)) {
                path.cubicTo(a3.x, a3.y, b2.x, b2.y, c.x, c.y);
            } else {
                path.lineTo(c.x, c.y);
            }
            f2458a.set(c.x, c.y);
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

    public static void a(com.coloros.anim.c.f fVar, int i, List<com.coloros.anim.c.f> list, com.coloros.anim.c.f fVar2, k kVar) {
        if (fVar.c(kVar.b(), i)) {
            com.coloros.anim.c.f a2 = fVar2.a(kVar.b());
            if (b.c) {
                b.b("MiscUtils::resolveKeyPath():currentPartialKeyPath = " + a2.toString() + "; content:" + kVar.b());
            }
            list.add(a2.a((g) kVar));
        }
    }
}
