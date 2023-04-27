package com.airbnb.lottie.e;

import com.airbnb.lottie.c.b;
import com.airbnb.lottie.e.a.c;
import java.io.IOException;

/* compiled from: DocumentDataParser */
public class h implements aj<b> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f1764a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f1765b = c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    /* renamed from: a */
    public b b(c cVar, float f) throws IOException {
        b.a aVar = b.a.CENTER;
        cVar.c();
        b.a aVar2 = aVar;
        String str = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        boolean z = true;
        while (cVar.e()) {
            switch (cVar.a(f1765b)) {
                case 0:
                    str = cVar.i();
                    break;
                case 1:
                    str2 = cVar.i();
                    break;
                case 2:
                    f2 = (float) cVar.k();
                    break;
                case 3:
                    int l = cVar.l();
                    if (l <= b.a.CENTER.ordinal() && l >= 0) {
                        aVar2 = b.a.values()[l];
                        break;
                    } else {
                        aVar2 = b.a.CENTER;
                        break;
                    }
                case 4:
                    i = cVar.l();
                    break;
                case 5:
                    f3 = (float) cVar.k();
                    break;
                case 6:
                    f4 = (float) cVar.k();
                    break;
                case 7:
                    i2 = p.a(cVar);
                    break;
                case 8:
                    i3 = p.a(cVar);
                    break;
                case 9:
                    f5 = (float) cVar.k();
                    break;
                case 10:
                    z = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        c cVar2 = cVar;
        cVar.d();
        return new b(str, str2, f2, aVar2, i, f3, f4, i2, i3, f5, z);
    }
}
