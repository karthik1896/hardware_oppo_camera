package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.g.d;
import com.airbnb.lottie.k;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f1649a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f1650b;
    private final Matrix c;
    private final Matrix d;
    private final float[] e;
    private a<PointF, PointF> f;
    private a<?, PointF> g;
    private a<d, d> h;
    private a<Float, Float> i;
    private a<Integer, Integer> j;
    private c k;
    private c l;
    private a<?, Float> m;
    private a<?, Float> n;

    public o(l lVar) {
        this.f = lVar.a() == null ? null : lVar.a().a();
        this.g = lVar.b() == null ? null : lVar.b().a();
        this.h = lVar.c() == null ? null : lVar.c().a();
        this.i = lVar.d() == null ? null : lVar.d().a();
        this.k = lVar.h() == null ? null : (c) lVar.h().a();
        if (this.k != null) {
            this.f1650b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.f1650b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.l = lVar.i() == null ? null : (c) lVar.i().a();
        if (lVar.e() != null) {
            this.j = lVar.e().a();
        }
        if (lVar.f() != null) {
            this.m = lVar.f().a();
        } else {
            this.m = null;
        }
        if (lVar.g() != null) {
            this.n = lVar.g().a();
        } else {
            this.n = null;
        }
    }

    public void a(a aVar) {
        aVar.a((a<?, ?>) this.j);
        aVar.a((a<?, ?>) this.m);
        aVar.a((a<?, ?>) this.n);
        aVar.a((a<?, ?>) this.f);
        aVar.a((a<?, ?>) this.g);
        aVar.a((a<?, ?>) this.h);
        aVar.a((a<?, ?>) this.i);
        aVar.a((a<?, ?>) this.k);
        aVar.a((a<?, ?>) this.l);
    }

    public void a(a.C0053a aVar) {
        a<Integer, Integer> aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(aVar);
        }
        a<?, Float> aVar4 = this.n;
        if (aVar4 != null) {
            aVar4.a(aVar);
        }
        a<PointF, PointF> aVar5 = this.f;
        if (aVar5 != null) {
            aVar5.a(aVar);
        }
        a<?, PointF> aVar6 = this.g;
        if (aVar6 != null) {
            aVar6.a(aVar);
        }
        a<d, d> aVar7 = this.h;
        if (aVar7 != null) {
            aVar7.a(aVar);
        }
        a<Float, Float> aVar8 = this.i;
        if (aVar8 != null) {
            aVar8.a(aVar);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(aVar);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a(aVar);
        }
    }

    public void a(float f2) {
        a<Integer, Integer> aVar = this.j;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(f2);
        }
        a<PointF, PointF> aVar4 = this.f;
        if (aVar4 != null) {
            aVar4.a(f2);
        }
        a<?, PointF> aVar5 = this.g;
        if (aVar5 != null) {
            aVar5.a(f2);
        }
        a<d, d> aVar6 = this.h;
        if (aVar6 != null) {
            aVar6.a(f2);
        }
        a<Float, Float> aVar7 = this.i;
        if (aVar7 != null) {
            aVar7.a(f2);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(f2);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a(f2);
        }
    }

    public a<?, Integer> a() {
        return this.j;
    }

    public a<?, Float> b() {
        return this.m;
    }

    public a<?, Float> c() {
        return this.n;
    }

    public Matrix d() {
        float f2;
        this.f1649a.reset();
        a<?, PointF> aVar = this.g;
        if (aVar != null) {
            PointF g2 = aVar.g();
            if (!(g2.x == 0.0f && g2.y == 0.0f)) {
                this.f1649a.preTranslate(g2.x, g2.y);
            }
        }
        a<Float, Float> aVar2 = this.i;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                f2 = aVar2.g().floatValue();
            } else {
                f2 = ((c) aVar2).i();
            }
            if (f2 != 0.0f) {
                this.f1649a.preRotate(f2);
            }
        }
        if (this.k != null) {
            c cVar = this.l;
            float cos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((double) ((-cVar.i()) + 90.0f)));
            c cVar2 = this.l;
            float sin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((double) ((-cVar2.i()) + 90.0f)));
            e();
            float[] fArr = this.e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f3 = -sin;
            fArr[3] = f3;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f1650b.setValues(fArr);
            e();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians((double) this.k.i()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            e();
            float[] fArr3 = this.e;
            fArr3[0] = cos;
            fArr3[1] = f3;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.f1650b);
            this.d.preConcat(this.c);
            this.f1649a.preConcat(this.d);
        }
        a<d, d> aVar3 = this.h;
        if (aVar3 != null) {
            d g3 = aVar3.g();
            if (!(g3.a() == 1.0f && g3.b() == 1.0f)) {
                this.f1649a.preScale(g3.a(), g3.b());
            }
        }
        a<PointF, PointF> aVar4 = this.f;
        if (aVar4 != null) {
            PointF g4 = aVar4.g();
            if (!(g4.x == 0.0f && g4.y == 0.0f)) {
                this.f1649a.preTranslate(-g4.x, -g4.y);
            }
        }
        return this.f1649a;
    }

    private void e() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.e[i2] = 0.0f;
        }
    }

    public Matrix b(float f2) {
        a<?, PointF> aVar = this.g;
        PointF pointF = null;
        PointF g2 = aVar == null ? null : aVar.g();
        a<d, d> aVar2 = this.h;
        d g3 = aVar2 == null ? null : aVar2.g();
        this.f1649a.reset();
        if (g2 != null) {
            this.f1649a.preTranslate(g2.x * f2, g2.y * f2);
        }
        if (g3 != null) {
            double d2 = (double) f2;
            this.f1649a.preScale((float) Math.pow((double) g3.a(), d2), (float) Math.pow((double) g3.b(), d2));
        }
        a<Float, Float> aVar3 = this.i;
        if (aVar3 != null) {
            float floatValue = aVar3.g().floatValue();
            a<PointF, PointF> aVar4 = this.f;
            if (aVar4 != null) {
                pointF = aVar4.g();
            }
            Matrix matrix = this.f1649a;
            float f3 = floatValue * f2;
            float f4 = 0.0f;
            float f5 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f4 = pointF.y;
            }
            matrix.preRotate(f3, f5, f4);
        }
        return this.f1649a;
    }

    public <T> boolean a(T t, c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == k.e) {
            a<PointF, PointF> aVar3 = this.f;
            if (aVar3 == null) {
                this.f = new p(cVar, new PointF());
                return true;
            }
            aVar3.a((c<PointF>) cVar);
            return true;
        } else if (t == k.f) {
            a<?, PointF> aVar4 = this.g;
            if (aVar4 == null) {
                this.g = new p(cVar, new PointF());
                return true;
            }
            aVar4.a((c<PointF>) cVar);
            return true;
        } else if (t == k.k) {
            a<d, d> aVar5 = this.h;
            if (aVar5 == null) {
                this.h = new p(cVar, new d());
                return true;
            }
            aVar5.a((c<d>) cVar);
            return true;
        } else if (t == k.l) {
            a<Float, Float> aVar6 = this.i;
            if (aVar6 == null) {
                this.i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.a((c<Float>) cVar);
            return true;
        } else if (t == k.c) {
            a<Integer, Integer> aVar7 = this.j;
            if (aVar7 == null) {
                this.j = new p(cVar, 100);
                return true;
            }
            aVar7.a((c<Integer>) cVar);
            return true;
        } else if (t != k.y || (aVar2 = this.m) == null) {
            if (t != k.z || (aVar = this.n) == null) {
                if (t == k.m && (cVar3 = this.k) != null) {
                    if (cVar3 == null) {
                        this.k = new c(Collections.singletonList(new com.airbnb.lottie.g.a(Float.valueOf(0.0f))));
                    }
                    this.k.a(cVar);
                    return true;
                } else if (t != k.n || (cVar2 = this.l) == null) {
                    return false;
                } else {
                    if (cVar2 == null) {
                        this.l = new c(Collections.singletonList(new com.airbnb.lottie.g.a(Float.valueOf(0.0f))));
                    }
                    this.l.a(cVar);
                    return true;
                }
            } else if (aVar == null) {
                this.n = new p(cVar, 100);
                return true;
            } else {
                aVar.a((c<Float>) cVar);
                return true;
            }
        } else if (aVar2 == null) {
            this.m = new p(cVar, 100);
            return true;
        } else {
            aVar2.a((c<Float>) cVar);
            return true;
        }
    }
}
