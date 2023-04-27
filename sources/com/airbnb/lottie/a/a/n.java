package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.i;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.k;
import java.util.List;

/* compiled from: PolystarContent */
public class n implements k, m, a.C0053a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f1630a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f1631b;
    private final f c;
    private final i.a d;
    private final boolean e;
    private final a<?, Float> f;
    private final a<?, PointF> g;
    private final a<?, Float> h;
    private final a<?, Float> i;
    private final a<?, Float> j;
    private final a<?, Float> k;
    private final a<?, Float> l;
    private b m = new b();
    private boolean n;

    public n(f fVar, com.airbnb.lottie.c.c.a aVar, i iVar) {
        this.c = fVar;
        this.f1631b = iVar.a();
        this.d = iVar.b();
        this.e = iVar.j();
        this.f = iVar.c().a();
        this.g = iVar.d().a();
        this.h = iVar.e().a();
        this.j = iVar.g().a();
        this.l = iVar.i().a();
        if (this.d == i.a.STAR) {
            this.i = iVar.f().a();
            this.k = iVar.h().a();
        } else {
            this.i = null;
            this.k = null;
        }
        aVar.a((a<?, ?>) this.f);
        aVar.a((a<?, ?>) this.g);
        aVar.a((a<?, ?>) this.h);
        aVar.a((a<?, ?>) this.j);
        aVar.a((a<?, ?>) this.l);
        if (this.d == i.a.STAR) {
            aVar.a((a<?, ?>) this.i);
            aVar.a((a<?, ?>) this.k);
        }
        this.f.a((a.C0053a) this);
        this.g.a((a.C0053a) this);
        this.h.a((a.C0053a) this);
        this.j.a((a.C0053a) this);
        this.l.a((a.C0053a) this);
        if (this.d == i.a.STAR) {
            this.i.a((a.C0053a) this);
            this.k.a((a.C0053a) this);
        }
    }

    public void a() {
        c();
    }

    private void c() {
        this.n = false;
        this.c.invalidateSelf();
    }

    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c() == q.a.SIMULTANEOUSLY) {
                    this.m.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    public Path e() {
        if (this.n) {
            return this.f1630a;
        }
        this.f1630a.reset();
        if (this.e) {
            this.n = true;
            return this.f1630a;
        }
        int i2 = AnonymousClass1.f1632a[this.d.ordinal()];
        if (i2 == 1) {
            d();
        } else if (i2 == 2) {
            f();
        }
        this.f1630a.close();
        this.m.a(this.f1630a);
        this.n = true;
        return this.f1630a;
    }

    /* renamed from: com.airbnb.lottie.a.a.n$1  reason: invalid class name */
    /* compiled from: PolystarContent */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1632a = new int[i.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.airbnb.lottie.c.b.i$a[] r0 = com.airbnb.lottie.c.b.i.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1632a = r0
                int[] r0 = f1632a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.i$a r1 = com.airbnb.lottie.c.b.i.a.STAR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1632a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.i$a r1 = com.airbnb.lottie.c.b.i.a.POLYGON     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.n.AnonymousClass1.<clinit>():void");
        }
    }

    public String b() {
        return this.f1631b;
    }

    private void d() {
        double d2;
        int i2;
        float f2;
        float f3;
        float f4;
        double d3;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float floatValue = this.f.g().floatValue();
        a<?, Float> aVar = this.h;
        double radians = Math.toRadians((aVar == null ? 0.0d : (double) aVar.g().floatValue()) - 90.0d);
        double d4 = (double) floatValue;
        float f14 = (float) (6.283185307179586d / d4);
        float f15 = f14 / 2.0f;
        float f16 = floatValue - ((float) ((int) floatValue));
        int i3 = (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (double) ((1.0f - f16) * f15);
        }
        float floatValue2 = this.j.g().floatValue();
        float floatValue3 = this.i.g().floatValue();
        a<?, Float> aVar2 = this.k;
        float floatValue4 = aVar2 != null ? aVar2.g().floatValue() / 100.0f : 0.0f;
        a<?, Float> aVar3 = this.l;
        float floatValue5 = aVar3 != null ? aVar3.g().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f2 = ((floatValue2 - floatValue3) * f16) + floatValue3;
            i2 = i3;
            double d5 = (double) f2;
            d2 = d4;
            f4 = (float) (d5 * Math.cos(radians));
            f3 = (float) (d5 * Math.sin(radians));
            this.f1630a.moveTo(f4, f3);
            d3 = radians + ((double) ((f14 * f16) / 2.0f));
        } else {
            d2 = d4;
            i2 = i3;
            double d6 = (double) floatValue2;
            float cos = (float) (Math.cos(radians) * d6);
            float sin = (float) (d6 * Math.sin(radians));
            this.f1630a.moveTo(cos, sin);
            d3 = radians + ((double) f15);
            f4 = cos;
            f3 = sin;
            f2 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        boolean z = false;
        double d7 = d3;
        float f17 = f15;
        int i4 = 0;
        while (true) {
            double d8 = (double) i4;
            if (d8 < ceil) {
                float f18 = z ? floatValue2 : floatValue3;
                int i5 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i5 == 0 || d8 != ceil - 2.0d) {
                    f5 = f17;
                } else {
                    f5 = f17;
                    f17 = (f14 * f16) / 2.0f;
                }
                if (i5 == 0 || d8 != ceil - 1.0d) {
                    f7 = f14;
                    f6 = floatValue3;
                    f9 = f18;
                    f8 = floatValue2;
                } else {
                    f7 = f14;
                    f8 = floatValue2;
                    f6 = floatValue3;
                    f9 = f2;
                }
                double d9 = (double) f9;
                float f19 = f17;
                float cos2 = (float) (d9 * Math.cos(d7));
                float sin2 = (float) (d9 * Math.sin(d7));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f1630a.lineTo(cos2, sin2);
                    f13 = sin2;
                    f10 = floatValue4;
                    f11 = floatValue5;
                    f12 = f2;
                } else {
                    f10 = floatValue4;
                    f11 = floatValue5;
                    double atan2 = (double) ((float) (Math.atan2((double) f3, (double) f4) - 1.5707963267948966d));
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f12 = f2;
                    f13 = sin2;
                    float f20 = f4;
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f21 = z ? f10 : f11;
                    float f22 = z ? f11 : f10;
                    float f23 = (z ? f6 : f8) * f21 * 0.47829f;
                    float f24 = cos3 * f23;
                    float f25 = f23 * sin3;
                    float f26 = (z ? f8 : f6) * f22 * 0.47829f;
                    float f27 = cos4 * f26;
                    float f28 = f26 * sin4;
                    if (i2 != 0) {
                        if (i4 == 0) {
                            f24 *= f16;
                            f25 *= f16;
                        } else if (d8 == ceil - 1.0d) {
                            f27 *= f16;
                            f28 *= f16;
                        }
                    }
                    this.f1630a.cubicTo(f20 - f24, f3 - f25, cos2 + f27, f13 + f28, cos2, f13);
                }
                d7 += (double) f19;
                z = !z;
                i4++;
                f4 = cos2;
                f2 = f12;
                floatValue2 = f8;
                f14 = f7;
                f17 = f5;
                floatValue3 = f6;
                floatValue4 = f10;
                floatValue5 = f11;
                f3 = f13;
            } else {
                PointF g2 = this.g.g();
                this.f1630a.offset(g2.x, g2.y);
                this.f1630a.close();
                return;
            }
        }
    }

    private void f() {
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor((double) this.f.g().floatValue());
        a<?, Float> aVar = this.h;
        double radians = Math.toRadians((aVar == null ? 0.0d : (double) aVar.g().floatValue()) - 90.0d);
        double d5 = (double) floor;
        float floatValue = this.l.g().floatValue() / 100.0f;
        float floatValue2 = this.j.g().floatValue();
        double d6 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d6);
        float sin = (float) (Math.sin(radians) * d6);
        this.f1630a.moveTo(cos, sin);
        double d7 = (double) ((float) (6.283185307179586d / d5));
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (((double) i3) < ceil) {
            float cos2 = (float) (Math.cos(d8) * d6);
            double d9 = ceil;
            float sin2 = (float) (d6 * Math.sin(d8));
            if (floatValue != 0.0f) {
                d4 = d6;
                i2 = i3;
                d3 = d8;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d2 = d7;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f2 = floatValue2 * floatValue * 0.25f;
                this.f1630a.cubicTo(cos - (cos3 * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d3 = d8;
                d4 = d6;
                d2 = d7;
                i2 = i3;
                this.f1630a.lineTo(cos2, sin2);
            }
            d8 = d3 + d2;
            i3 = i2 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d9;
            d6 = d4;
            d7 = d2;
        }
        PointF g2 = this.g.g();
        this.f1630a.offset(g2.x, g2.y);
        this.f1630a.close();
    }

    public void a(e eVar, int i2, List<e> list, e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, c<T> cVar) {
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == k.s) {
            this.f.a(cVar);
        } else if (t == k.t) {
            this.h.a(cVar);
        } else if (t == k.j) {
            this.g.a(cVar);
        } else if (t == k.u && (aVar2 = this.i) != null) {
            aVar2.a((c<Float>) cVar);
        } else if (t == k.v) {
            this.j.a(cVar);
        } else if (t == k.w && (aVar = this.k) != null) {
            aVar.a((c<Float>) cVar);
        } else if (t == k.x) {
            this.l.a(cVar);
        }
    }
}
