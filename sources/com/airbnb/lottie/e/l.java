package com.airbnb.lottie.e;

import android.graphics.Color;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser */
public class l implements aj<c> {

    /* renamed from: a  reason: collision with root package name */
    private int f1770a;

    public l(int i) {
        this.f1770a = i;
    }

    /* renamed from: a */
    public c b(com.airbnb.lottie.e.a.c cVar, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = cVar.f() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.a();
        }
        while (cVar.e()) {
            arrayList.add(Float.valueOf((float) cVar.k()));
        }
        if (z) {
            cVar.b();
        }
        if (this.f1770a == -1) {
            this.f1770a = arrayList.size() / 4;
        }
        int i = this.f1770a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1770a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = (double) ((Float) arrayList.get(i4)).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        com.airbnb.lottie.c.b.c cVar2 = new com.airbnb.lottie.c.b.c(fArr, iArr);
        a(cVar2, (List<Float>) arrayList);
        return cVar2;
    }

    private void a(com.airbnb.lottie.c.b.c cVar, List<Float> list) {
        int i = this.f1770a * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = (double) list.get(i).floatValue();
                } else {
                    dArr2[i2] = (double) list.get(i).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < cVar.c(); i3++) {
                int i4 = cVar.b()[i3];
                cVar.b()[i3] = Color.argb(a((double) cVar.a()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    private int a(double d, double[] dArr, double[] dArr2) {
        double d2;
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int i = 1;
        while (true) {
            if (i >= dArr3.length) {
                d2 = dArr4[dArr4.length - 1];
                break;
            }
            int i2 = i - 1;
            double d3 = dArr3[i2];
            double d4 = dArr3[i];
            if (dArr3[i] >= d) {
                d2 = g.a(dArr4[i2], dArr4[i], (d - d3) / (d4 - d3));
                break;
            }
            i++;
        }
        return (int) (d2 * 255.0d);
    }
}
