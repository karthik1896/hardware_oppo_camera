package com.airbnb.lottie.e;

import android.graphics.Color;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: ColorParser */
public class f implements aj<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f1762a = new f();

    private f() {
    }

    /* renamed from: a */
    public Integer b(c cVar, float f) throws IOException {
        boolean z = cVar.f() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.a();
        }
        double k = cVar.k();
        double k2 = cVar.k();
        double k3 = cVar.k();
        double k4 = cVar.k();
        if (z) {
            cVar.b();
        }
        if (k <= 1.0d && k2 <= 1.0d && k3 <= 1.0d) {
            k *= 255.0d;
            k2 *= 255.0d;
            k3 *= 255.0d;
            if (k4 <= 1.0d) {
                k4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) k4, (int) k, (int) k2, (int) k3));
    }
}
