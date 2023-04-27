package a.a.b.b;

import a.a.b.a.a.c;
import a.a.b.e.s;
import android.content.res.Resources;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.filters.Basic;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f6a = new Context();

    static {
        new Context();
    }

    public static int a(byte b2) {
        return b2 & 255;
    }

    public static int a(Resources resources, int i, int i2, int i3) {
        int[] iArr = new int[1];
        s.a(iArr.length, iArr, 0, 6408, i2, i3);
        int i4 = iArr[0];
        c a2 = c.a((Context) null);
        a2.a((a.a.b.a.a.a) Basic.getInstance(resources));
        a2.a(i);
        a2.b(i4);
        a2.b(i2, i3);
        a2.draw();
        return i4;
    }

    public static int[] a(int i, int i2, int i3) {
        byte[] array = s.a(i, i2, i3).array();
        int[] iArr = new int[array.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = array[i4] & 255;
        }
        return iArr;
    }

    public static int[] a(Resources resources, d dVar, int i, int i2) {
        int i3;
        if (dVar == null || (i3 = dVar.f11a) < 0) {
            return null;
        }
        if (i == dVar.f12b && i2 == dVar.c) {
            return a(i3, i, i2);
        }
        if (resources == null) {
            return null;
        }
        int a2 = a(resources, i3, i, i2);
        int[] a3 = a(a2, i, i2);
        s.a(a2);
        g.e(a2);
        return a3;
    }

    public static byte[] b(int i, int i2, int i3) {
        return s.a(i, i2, i3).array();
    }

    public static byte[] b(Resources resources, d dVar, int i, int i2) {
        int i3;
        if (dVar == null || (i3 = dVar.f11a) < 0) {
            return null;
        }
        if (i == dVar.f12b && i2 == dVar.c) {
            return b(i3, i, i2);
        }
        if (resources == null) {
            return null;
        }
        int a2 = a(resources, i3, i, i2);
        byte[] b2 = b(a2, i, i2);
        s.a(a2);
        g.e(a2);
        return b2;
    }
}
