package a.a.b.e;

import a.a.b.a.ad;
import a.a.b.a.ae;
import a.a.b.a.ag;
import a.a.b.a.al;
import a.a.b.a.ar;
import a.a.b.a.as;
import a.a.b.a.k;
import a.a.b.a.n;
import a.a.b.a.z;
import a.a.b.b.g;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import android.util.Log;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.MagicEraserHistoryItem;
import co.polarr.renderer.entities.MagicEraserPath;
import co.polarr.renderer.entities.Mesh;
import co.polarr.renderer.filters.Basic;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import java.util.ArrayList;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public Resources f54a;

    /* renamed from: b  reason: collision with root package name */
    public Context f55b;
    public int c = 0;
    public a.a.b.b.d d;
    public a.a.b.b.d[] e;
    public float[][] f;
    public int g;
    public MagicEraserHistoryItem h;
    public boolean i;
    public int j;
    public a.a.b.b.d k;
    public a.a.b.b.d l;
    public a.a.b.b.d m;
    public a.a.b.b.d n;
    public boolean o;
    public int p;
    public float[] q;
    public n r;

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public a.a.b.b.d f56a;

        /* renamed from: b  reason: collision with root package name */
        public d f57b;
        public List<c> c;
        public RectF d;
        public a.a.b.b.d e;
        public a.a.b.b.d f;

        public b(h hVar) {
            this.c = new ArrayList();
        }
    }

    public static class c extends a.a.b.b.d {
        public int e;
        public int f;
        public float[] g;

        public static c a(a.a.b.b.d dVar) {
            c cVar = new c();
            cVar.f11a = dVar.f11a;
            cVar.f12b = dVar.f12b;
            cVar.c = dVar.c;
            cVar.d = dVar.d;
            return cVar;
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        public c f58a;

        /* renamed from: b  reason: collision with root package name */
        public a.a.b.b.d f59b;
        public a.a.b.b.d c;

        public d(h hVar, c cVar, a.a.b.b.d dVar, a.a.b.b.d dVar2) {
            this.f58a = cVar;
            this.f59b = dVar;
            this.c = dVar2;
        }
    }

    public h(Resources resources, t tVar) {
        int i2 = this.c;
        this.e = new a.a.b.b.d[i2];
        this.f = new float[i2][];
        this.f54a = resources;
        this.f55b = new Context();
        this.f55b.mesh = Mesh.plane(new Mesh.Options(true, false, false, 1));
        this.f55b.shaderUtil = tVar;
        this.g = 0;
        int[] iArr = new int[3];
        s.a(3, iArr, 0, 6408, 1, 1);
        this.d = s.b(iArr[0], 6408, 1, 1);
        this.l = s.b(iArr[1], 6408, 1, 1);
        this.m = s.b(iArr[2], 6408, 1, 1);
        this.k = a(1, 1);
        this.n = a(1, 1);
    }

    public static float[] a(RectF rectF, float f2, float f3, float f4) {
        float f5 = f4 * 2.0f;
        float min = Math.min(Math.max(((float) Math.round(rectF.width() * f2)) + f5, 0.0f), f2) / f2;
        float min2 = Math.min(Math.max(((float) Math.round(rectF.height() * f3)) + f5, 0.0f), f3) / f3;
        float min3 = Math.min(Math.max(((float) Math.round(rectF.left * f2)) - f4, 0.0f), f2 - min) / f2;
        float min4 = Math.min(Math.max(((float) Math.round(rectF.top * f3)) - f4, 0.0f), f3 - min2) / f3;
        float f6 = 1.0f / min;
        float f7 = 1.0f / min2;
        float[] a2 = o.a();
        Matrix.translateM(a2, 0, -1.0f - ((min3 * 2.0f) * f6), (min4 * 2.0f * f7) + 1.0f, 0.0f);
        Matrix.scaleM(a2, 0, f6, f7, 1.0f);
        Matrix.translateM(a2, 0, 1.0f, -1.0f, 0.0f);
        return a2;
    }

    public final int a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public final a.a.b.b.d a(int i2, int i3) {
        a.a.b.b.d a2 = a(6408, 5131, i2, i3);
        GLES20.glBindTexture(3553, a2.f11a);
        s.c(33071, 33071, 9728, 9728);
        GLES20.glBindTexture(3553, 0);
        return a2;
    }

    public final a.a.b.b.d a(int i2, int i3, int i4, int i5) {
        int[] iArr = new int[1];
        s.a(iArr.length, iArr, 0, i2, i3, i4, i5);
        return s.b(iArr[0], i2, i4, i5);
    }

    public final a.a.b.b.d a(a.a.b.b.d dVar, int i2) {
        a.a.b.b.d b2 = b(dVar.f12b, dVar.c);
        as a2 = as.a(this.f54a, this.f55b);
        a2.a(dVar.f11a);
        a2.r = i2;
        a((a.a.b.a.a.a) a2, b2);
        return b2;
    }

    public final a.a.b.b.d a(b bVar, int i2) {
        int i3 = i2 + 1;
        int min = Math.min(6, i3);
        a.a.b.b.d dVar = bVar.f57b.f59b;
        int i4 = 1;
        while (i4 <= i3) {
            a(bVar, bVar.f57b, min);
            a(bVar, bVar.f57b, (c) ((i2 < 1 || i4 != i3) ? bVar.c.get(i2) : bVar.c.get(i2 - 1)), dVar);
            i4++;
        }
        if (this.o) {
            GLES30.glFinish();
        }
        return dVar;
    }

    public final a.a.b.b.d a(c cVar) {
        a.a.b.b.d b2 = b(cVar.f12b, cVar.c);
        ad a2 = ad.a(this.f54a, this.f55b);
        a2.r = cVar.f11a;
        a((a.a.b.a.a.a) a2, b2);
        a((a.a.b.b.d) cVar, b2);
        s.b(b2, cVar.e, cVar.f);
        Basic a3 = Basic.a(this.f54a, this.f55b);
        a3.a(cVar.f11a);
        a3.a(cVar.g);
        a((a.a.b.a.a.a) a3, b2);
        return b2;
    }

    public final d a(b bVar, a.a.b.b.d dVar, a.a.b.b.d dVar2, c cVar) {
        int i2;
        s.a(dVar, 34842, 5131, cVar.e, cVar.f);
        al a2 = al.a(this.f54a, this.f55b);
        a2.v = cVar.g;
        a2.r = cVar.f11a;
        a2.s = new float[]{(float) cVar.f12b, (float) cVar.c};
        a.a.b.b.d dVar3 = bVar.f56a;
        a2.t = new float[]{(float) dVar3.f12b, (float) dVar3.c};
        if (!this.i || this.h.randomLists.size() <= (i2 = this.j)) {
            a2.u = (float) Math.random();
            this.h.randomLists.add(Float.valueOf(a2.u));
        } else {
            List<Float> list = this.h.randomLists;
            this.j = i2 + 1;
            a2.u = list.get(i2).floatValue();
        }
        a2.a(cVar.g);
        a((a.a.b.a.a.a) a2, dVar);
        return new d(this, cVar, dVar2, dVar);
    }

    public final d a(b bVar, d dVar, a.a.b.b.d dVar2, c cVar) {
        a.a.b.b.d dVar3 = dVar.c;
        a.a.b.b.d dVar4 = bVar.f;
        s.a(dVar4, 34842, 5131, cVar.e, cVar.f);
        k a2 = k.a(this.f54a, this.f55b);
        float[] fArr = cVar.g;
        a2.x = fArr;
        a2.s = cVar.f11a;
        a2.r = dVar2.f11a;
        a2.t = dVar3.f11a;
        a2.u = new float[]{(float) cVar.f12b, (float) cVar.c};
        a2.v = new float[]{(float) dVar2.f12b, (float) dVar2.c};
        a.a.b.b.d dVar5 = bVar.f56a;
        a2.w = new float[]{(float) dVar5.f12b, (float) dVar5.c};
        a2.a(fArr);
        a((a.a.b.a.a.a) a2, dVar4);
        a(dVar3, dVar4);
        return new d(this, cVar, dVar2, dVar3);
    }

    public List<Float> a(List<PointF> list, float f2) {
        ArrayList arrayList = new ArrayList();
        this.q = null;
        for (PointF a2 : list) {
            a((List<Float>) arrayList, a2, f2);
        }
        return arrayList;
    }

    public void a() {
        c(-1, -1);
        a.a.b.b.d dVar = this.d;
        if (dVar != null) {
            g.a(dVar);
            g.e(this.d.f11a);
        }
        a.a.b.b.d dVar2 = this.m;
        if (dVar2 != null) {
            g.a(dVar2);
            g.e(this.m.f11a);
        }
        a.a.b.b.d dVar3 = this.l;
        if (dVar3 != null) {
            g.a(dVar3);
            g.e(this.l.f11a);
        }
        a.a.b.b.d dVar4 = this.k;
        if (dVar4 != null) {
            a(dVar4);
            this.k = null;
        }
        a.a.b.b.d dVar5 = this.n;
        if (dVar5 != null) {
            a(dVar5);
            this.n = null;
        }
    }

    public final void a(int i2) {
        if (this.c > 0) {
            Basic a2 = Basic.a(this.f54a, this.f55b);
            a2.setNeedClear(false);
            a.a.b.a.a.c k2 = a.a.b.a.a.c.k();
            k2.b(i2);
            a.a.b.b.d dVar = this.d;
            k2.b(dVar.f12b, dVar.c);
            k2.p();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            a2.a(this.d.f11a);
            a2.draw();
            for (int i3 = 0; i3 < this.g; i3++) {
                a.a.b.b.d dVar2 = this.e[i3];
                Matrix.invertM(a2.getMatrix(), 0, this.f[i3], 0);
                a2.a(dVar2.f11a);
                a2.draw();
            }
            k2.m();
        }
    }

    public void a(int i2, int i3, Rect rect) {
        s.b(i3, rect.width(), rect.height());
        s.a(i2, i3, rect);
    }

    public void a(int i2, MagicEraserPath magicEraserPath) {
        int i3;
        int i4 = i2;
        MagicEraserPath magicEraserPath2 = magicEraserPath;
        a.a.b.b.d dVar = this.d;
        if (dVar != null) {
            int i5 = dVar.f12b;
            int i6 = dVar.c;
            float f2 = 1.0f;
            float f3 = 1.0f;
            float f4 = 1.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (PointF next : magicEraserPath2.points) {
                float f7 = next.x;
                float f8 = next.y;
                f3 = Math.min(f3, f7);
                f5 = Math.max(f5, f7);
                f4 = Math.min(f4, f8);
                f6 = Math.max(f6, f8);
            }
            float f9 = magicEraserPath2.radius * 2.0f;
            int i7 = 0;
            int i8 = 1;
            float[] fArr = {f9 / ((float) i5), f9 / ((float) i6)};
            float f10 = f3 - fArr[0];
            float f11 = f4 - fArr[1];
            float f12 = f5 + fArr[0];
            float f13 = f6 + fArr[1];
            if (f10 <= 0.0f) {
                f12 += fArr[0] * 2.0f;
            }
            if (f11 <= 0.0f) {
                f13 += fArr[1] * 2.0f;
            }
            if (f12 >= 1.0f) {
                f10 -= fArr[0] * 2.0f;
            }
            if (f13 >= 1.0f) {
                f11 -= fArr[1] * 2.0f;
            }
            RectF rectF = new RectF(f10, f11, f12, f13);
            z zVar = new z(this.f55b, this.f54a);
            zVar.o = (float) r.a(1.0d);
            zVar.p = 1.0f;
            zVar.q = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
            a.a.b.b.d dVar2 = this.l;
            a.a.b.b.d dVar3 = this.d;
            s.b(dVar2, dVar3.f12b, dVar3.c);
            a.a.b.a.a.c k2 = a.a.b.a.a.c.k();
            k2.b(this.l.f11a);
            a.a.b.b.d dVar4 = this.l;
            k2.b(dVar4.f12b, dVar4.c);
            k2.p();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            List<PointF> list = magicEraserPath2.points;
            if (list != null && !list.isEmpty()) {
                float f14 = magicEraserPath2.radius * 2.0f;
                zVar.n = f14;
                zVar.a(a(magicEraserPath2.points, f14), false);
            }
            k2.m();
            float f15 = (float) 1;
            float width = rectF.width() / f15;
            float height = rectF.height() / f15;
            int i9 = 0;
            while (i9 < i8) {
                int i10 = i7;
                while (i10 < i8) {
                    if (!this.i) {
                        this.h = new MagicEraserHistoryItem();
                        this.h.path = magicEraserPath2;
                    }
                    float f16 = rectF.left;
                    float f17 = (float) i10;
                    float f18 = rectF.top;
                    int i11 = i10 + 1;
                    RectF rectF2 = new RectF((((float) i9) * width) + f16, (f17 * height) + f18, (((float) (i9 + 1)) * width) + f16, (((float) i11) * height) + f18);
                    rectF2.left = Math.min(Math.max(0.0f, rectF2.left), f2);
                    rectF2.top = Math.min(Math.max(0.0f, rectF2.top), f2);
                    rectF2.right = Math.min(Math.max(0.0f, rectF2.right), f2);
                    rectF2.bottom = Math.min(Math.max(0.0f, rectF2.bottom), f2);
                    float f19 = rectF2.left;
                    a.a.b.b.d dVar5 = this.d;
                    float f20 = (float) dVar5.f12b;
                    float f21 = rectF2.top;
                    float f22 = (float) dVar5.c;
                    Rect rect = new Rect((int) (f19 * f20), (int) (f21 * f22), (int) (rectF2.right * f20), (int) (rectF2.bottom * f22));
                    if (rect.width() < 6) {
                        int i12 = rect.right;
                        int i13 = rect.left;
                        rect.right = i12 + (6 - (i12 - i13));
                        int i14 = rect.right;
                        int i15 = this.d.f12b;
                        int i16 = i14 - i15;
                        if (i16 > 0) {
                            rect.right = i15;
                            rect.left = i13 - i16;
                            rect.left = Math.max(0, rect.left);
                        }
                    }
                    if (rect.height() < 6) {
                        int i17 = rect.bottom;
                        int i18 = rect.top;
                        rect.bottom = i17 + (6 - (i17 - i18));
                        int i19 = rect.bottom;
                        int i20 = this.d.c;
                        int i21 = i19 - i20;
                        if (i21 > 0) {
                            rect.bottom = i20;
                            rect.top = i18 - i21;
                            i3 = 0;
                            rect.top = Math.max(0, rect.top);
                            this.m.f12b = rect.width();
                            this.m.c = rect.height();
                            this.l.f12b = rect.width();
                            this.l.c = rect.height();
                            a(this.l.f11a, this.m.f11a, rect);
                            a(i4, this.l.f11a, rect);
                            s.b(i4, rect.width(), rect.height());
                            int i22 = i11;
                            a(c.a(this.l), this.m, 2, new RectF(0.0f, 0.0f, 1.0f, 1.0f), i2);
                            b(this.d.f11a, i4, rect);
                            a.a.b.b.d dVar6 = this.d;
                            s.b(i4, dVar6.f12b, dVar6.c);
                            a.a.b.b.d dVar7 = this.d;
                            s.a(dVar7.f11a, i4, dVar7.f12b, dVar7.c);
                            GLES20.glFinish();
                            i10 = i22;
                            i9 = i9;
                            i8 = 1;
                            i7 = i3;
                            f2 = 1.0f;
                        }
                    }
                    i3 = 0;
                    this.m.f12b = rect.width();
                    this.m.c = rect.height();
                    this.l.f12b = rect.width();
                    this.l.c = rect.height();
                    a(this.l.f11a, this.m.f11a, rect);
                    a(i4, this.l.f11a, rect);
                    s.b(i4, rect.width(), rect.height());
                    int i222 = i11;
                    a(c.a(this.l), this.m, 2, new RectF(0.0f, 0.0f, 1.0f, 1.0f), i2);
                    b(this.d.f11a, i4, rect);
                    a.a.b.b.d dVar62 = this.d;
                    s.b(i4, dVar62.f12b, dVar62.c);
                    a.a.b.b.d dVar72 = this.d;
                    s.a(dVar72.f11a, i4, dVar72.f12b, dVar72.c);
                    GLES20.glFinish();
                    i10 = i222;
                    i9 = i9;
                    i8 = 1;
                    i7 = i3;
                    f2 = 1.0f;
                }
                int i23 = i7;
                float f23 = f2;
                int i24 = i23;
                i9++;
                i8 = 1;
                float f24 = f23;
                i7 = i24;
                f2 = f24;
            }
        }
    }

    public final void a(a.a.b.a.a.a aVar, a.a.b.b.d dVar) {
        a.a.b.a.a.c k2 = a.a.b.a.a.c.k();
        k2.b(dVar.f11a);
        k2.a(o.a());
        k2.b(dVar.f12b, dVar.c);
        k2.a(aVar);
        k2.p();
        aVar.draw();
        k2.m();
    }

    public final void a(a.a.b.b.d dVar) {
        int i2 = dVar.f11a;
        if (i2 > 0) {
            s.a(i2);
            g.e(dVar.f11a);
        }
        dVar.f11a = 0;
    }

    public void a(a.a.b.b.d dVar, int i2, MagicEraserPath magicEraserPath, int i3, int i4, float f2, float f3, float f4) {
        a.a.b.b.d dVar2 = dVar;
        MagicEraserPath magicEraserPath2 = magicEraserPath;
        a.a.b.b.d dVar3 = this.d;
        s.b(dVar, dVar3.f12b, dVar3.c);
        z zVar = new z(this.f55b, this.f54a);
        zVar.o = (float) r.a(1.0d);
        zVar.p = 1.0f;
        zVar.q = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        a.a.b.a.a.c k2 = a.a.b.a.a.c.k();
        k2.b(dVar2.f11a);
        k2.b(dVar2.f12b, dVar2.c);
        k2.p();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        List<PointF> list = magicEraserPath2.points;
        if (list != null && !list.isEmpty()) {
            float f5 = magicEraserPath2.radius * 2.0f;
            zVar.n = f5;
            zVar.a(a(magicEraserPath2.points, f5), false);
        }
        k2.m();
        int i5 = i3;
        GLES20.glViewport(0, 0, i3, i4);
        Basic a2 = Basic.a(this.f54a, this.f55b);
        Matrix.scaleM(a2.getMatrix(), 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(a2.getMatrix(), 0, f2, f3, 0.0f);
        float f6 = f4;
        Matrix.scaleM(a2.getMatrix(), 0, f6, f6, 1.0f);
        int i6 = i2;
        a2.a(i2);
        a2.draw();
        if (this.r == null) {
            this.r = new n(this.f54a, this.f55b);
            this.r.a();
        }
        this.f55b.overlayMask = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        n nVar = this.r;
        nVar.r = 0.5f;
        nVar.a(dVar2.f11a);
        Matrix.setIdentityM(this.r.getMatrix(), 0);
        Matrix.scaleM(this.r.getMatrix(), 0, 1.0f, -1.0f, 1.0f);
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        this.r.draw();
        GLES20.glDisable(3042);
    }

    public final void a(a.a.b.b.d dVar, a.a.b.b.d dVar2) {
        int i2 = dVar2.f11a;
        dVar2.f11a = dVar.f11a;
        dVar.f11a = i2;
        int i3 = dVar2.f12b;
        dVar2.f12b = dVar.f12b;
        dVar.f12b = i3;
        int i4 = dVar2.c;
        dVar2.c = dVar.c;
        dVar.c = i4;
    }

    public final void a(b bVar, d dVar, int i2) {
        int i3;
        b bVar2 = bVar;
        d dVar2 = dVar;
        c cVar = dVar2.f58a;
        a.a.b.b.d dVar3 = dVar2.f59b;
        a.a.b.b.d dVar4 = dVar2.c;
        int i4 = dVar4.f12b;
        int i5 = dVar4.c;
        a.a.b.b.d dVar5 = bVar2.f;
        int i6 = 8;
        int i7 = 0;
        int i8 = i2;
        while (i7 < i8) {
            ar a2 = ar.a(this.f54a, this.f55b);
            while (i6 > 0) {
                s.a(dVar5, 34842, 5131, i4, i5);
                float[] fArr = cVar.g;
                a2.z = fArr;
                a2.s = cVar.f11a;
                a2.r = dVar3.f11a;
                a2.t = dVar4.f11a;
                a2.u = new float[]{(float) cVar.f12b, (float) cVar.c};
                a2.v = new float[]{(float) dVar3.f12b, (float) dVar3.c};
                a2.w = new float[]{(float) dVar4.f12b, (float) dVar4.c};
                a.a.b.b.d dVar6 = bVar2.f56a;
                a2.x = new float[]{(float) dVar6.f12b, (float) dVar6.c};
                a2.y = (float) i6;
                a2.a(fArr);
                a((a.a.b.a.a.a) a2, dVar5);
                a(dVar2.c, dVar5);
                i6 >>= 1;
                i4 = i4;
            }
            int i9 = i4;
            if (this.o) {
                GLES20.glFinish();
            }
            ag a3 = ag.a(this.f54a, this.f55b);
            a3.y = cVar.g;
            a3.s = cVar.f11a;
            a3.r = dVar3.f11a;
            a3.t = dVar4.f11a;
            a3.u = new float[]{(float) cVar.f12b, (float) cVar.c};
            a3.v = new float[]{(float) dVar3.f12b, (float) dVar3.c};
            a.a.b.b.d dVar7 = bVar2.f56a;
            a3.w = new float[]{(float) dVar7.f12b, (float) dVar7.c};
            if (!this.i || this.h.randomLists.size() <= (i3 = this.j)) {
                a3.x = (float) Math.random();
                this.h.randomLists.add(Float.valueOf(a3.x));
            } else {
                List<Float> list = this.h.randomLists;
                this.j = i3 + 1;
                a3.x = list.get(i3).floatValue();
            }
            a3.a(cVar.g);
            a((a.a.b.a.a.a) a3, dVar5);
            a(dVar2.c, dVar5);
            i7++;
            i4 = i9;
        }
    }

    public final void a(b bVar, d dVar, c cVar, a.a.b.b.d dVar2) {
        a.a.b.b.d dVar3 = bVar.e;
        a.a.b.b.d dVar4 = dVar.c;
        s.b(dVar3, cVar.e, cVar.f);
        ae a2 = ae.a(this.f54a, this.f55b);
        float[] fArr = cVar.g;
        a2.w = fArr;
        a2.t = dVar4.f11a;
        a2.s = cVar.f11a;
        a2.r = dVar2.f11a;
        a2.u = new float[]{(float) dVar2.f12b, (float) dVar2.c};
        a.a.b.b.d dVar5 = bVar.f56a;
        a2.v = new float[]{(float) dVar5.f12b, (float) dVar5.c};
        a2.a(fArr);
        a((a.a.b.a.a.a) a2, dVar3);
        a(dVar2, dVar3);
    }

    public final void a(c cVar, a.a.b.b.d dVar, int i2, RectF rectF, int i3) {
        d dVar2;
        GLES30.glGetError();
        a.a.b.b.d dVar3 = null;
        b bVar = new b();
        bVar.f56a = cVar;
        bVar.d = rectF;
        bVar.f57b = null;
        bVar.c = new ArrayList();
        int i4 = 1;
        bVar.e = b(1, 1);
        bVar.f = this.k;
        this.o = false;
        float min = Math.min(bVar.d.width(), 1.0f);
        float min2 = Math.min(bVar.d.height(), 1.0f);
        a.a.b.b.d dVar4 = this.l;
        float f2 = min * min2 * ((float) dVar4.c) * ((float) dVar4.f12b);
        Log.d("POLARR_SDK", "pixels:" + Math.round(f2));
        if (f2 > 1.0E7f) {
            this.o = true;
            i4 = 3;
        } else if (f2 > 2000000.0f) {
            this.o = true;
            i4 = 2;
        } else if (f2 > 1000000.0f) {
            this.o = true;
        } else {
            if (f2 > 500000.0f) {
                this.o = true;
            }
            i4 = 0;
        }
        if (this.o) {
            this.p = Math.min(this.p, 3);
            this.p = Math.max(this.p, 0);
            i4 += this.p;
        }
        c a2 = c.a(a((a.a.b.b.d) cVar, dVar.f11a));
        bVar.c.add(a2);
        int i5 = i2 * 2;
        a2.e = a(Math.round(((float) a2.f12b) * bVar.d.width()) + i5, 0, a2.f12b);
        a2.f = a(Math.round(((float) a2.c) * bVar.d.height()) + i5, 0, a2.c);
        float f3 = (float) i2;
        a2.g = a(bVar.d, (float) a2.f12b, (float) a2.c, f3);
        while (a2.e > i2 && a2.f > i2) {
            a2 = c.a(b(a2));
            a2.e = a(Math.round(((float) a2.f12b) * bVar.d.width()) + i5, 0, a2.f12b);
            a2.f = a(Math.round(((float) a2.c) * bVar.d.height()) + i5, 0, a2.c);
            a2.g = a(bVar.d, (float) a2.f12b, (float) a2.c, f3);
            bVar.c.add(a2);
        }
        int size = bVar.c.size() - 3;
        for (int i6 = size; i6 >= i4; i6--) {
            c cVar2 = bVar.c.get(i6);
            if (i6 == size) {
                dVar2 = a(bVar, this.n, a(cVar2), cVar2);
            } else {
                dVar2 = a(bVar, bVar.f57b, dVar3, cVar2);
            }
            bVar.f57b = dVar2;
            dVar3 = a(bVar, i6);
            GLES20.glFinish();
            if (i6 == i4) {
                Basic a3 = Basic.a(this.f54a, this.f55b);
                a3.setNeedClear(false);
                a.a.b.a.a.c k2 = a.a.b.a.a.c.k();
                k2.b(i3);
                k2.b(cVar.f12b, cVar.c);
                k2.p();
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                a3.a(cVar2.f11a);
                a3.draw();
                Matrix.invertM(a3.getMatrix(), 0, cVar2.g, 0);
                a3.a(dVar3.f11a);
                a3.draw();
                k2.m();
                a(bVar.e);
                for (c a4 : bVar.c) {
                    a((a.a.b.b.d) a4);
                }
            }
        }
        GLES30.glFlush();
        GLES30.glGetError();
    }

    public void a(List<Float> list, PointF pointF, float f2) {
        float[] fArr = new float[4];
        a.a.b.b.d dVar = this.d;
        float f3 = (float) dVar.f12b;
        float f4 = (float) dVar.c;
        float[] fArr2 = {1.0f / f3, 1.0f / f4};
        float[] fArr3 = {pointF.x * f3, (1.0f - pointF.y) * f4, 0.5f};
        if (this.q == null) {
            this.q = new float[]{fArr3[0], fArr3[1], fArr3[2]};
            fArr3[0] = fArr3[0] * fArr2[0];
            fArr3[1] = fArr3[1] * fArr2[1];
            list.add(Float.valueOf(fArr3[0]));
            list.add(Float.valueOf(fArr3[1]));
            list.add(Float.valueOf(fArr3[2]));
            return;
        }
        int i2 = (int) (f2 * 0.3f * fArr3[2]);
        if (i2 < 1) {
            i2 = 1;
        }
        float a2 = o.a(fArr3, this.q);
        if (a2 >= ((float) i2)) {
            ArrayList arrayList = new ArrayList();
            int i3 = i2;
            while (true) {
                float f5 = (float) i3;
                if (f5 > a2) {
                    break;
                }
                try {
                    o.a(this.q, fArr3, f5 / a2, fArr);
                    arrayList.add(Float.valueOf(fArr[0]));
                    arrayList.add(Float.valueOf(fArr[1]));
                    arrayList.add(Float.valueOf(fArr[2]));
                    i3 += i2;
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            int size = arrayList.size();
            int i4 = size - 3;
            this.q = new float[]{((Float) arrayList.get(i4)).floatValue(), ((Float) arrayList.get(i4 + 1)).floatValue(), ((Float) arrayList.get(i4 + 2)).floatValue()};
            for (int i5 = 0; i5 < size; i5 += 3) {
                arrayList.set(i5, Float.valueOf(((Float) arrayList.get(i5)).floatValue() * fArr2[0]));
                int i6 = i5 + 1;
                arrayList.set(i6, Float.valueOf(((Float) arrayList.get(i6)).floatValue() * fArr2[1]));
            }
            list.addAll(arrayList);
        }
    }

    public final a.a.b.b.d b(int i2, int i3) {
        int[] iArr = new int[1];
        s.a(iArr.length, iArr, 0, 6408, i2, i3);
        return s.b(iArr[0], 6408, i2, i3);
    }

    public final a.a.b.b.d b(a.a.b.b.d dVar) {
        a.a.b.b.d b2 = b(dVar.f12b >> 1, dVar.c >> 1);
        Basic a2 = Basic.a(this.f54a, this.f55b);
        a2.a(dVar.f11a);
        a((a.a.b.a.a.a) a2, b2);
        return b2;
    }

    public void b() {
        as.l();
        ad.l();
        ae.l();
        ar.l();
        ag.l();
        k.l();
        al.l();
    }

    public void b(int i2, int i3, int i4, int i5) {
        this.p = i5;
        s.b(this.d, i3, i4);
        c(i2, -1);
    }

    public void b(int i2, int i3, Rect rect) {
        s.b(i2, i3, rect);
    }

    public void c(int i2, int i3) {
        if (i2 > 0) {
            Basic a2 = Basic.a(this.f54a, this.f55b);
            a2.a(i2);
            a((a.a.b.a.a.a) a2, this.d);
        }
        if (i3 > 0) {
            this.g = -1;
            a(i3);
        }
        for (a.a.b.b.d dVar : this.e) {
            if (dVar != null) {
                a(dVar);
            }
        }
        for (int i4 = 0; i4 < this.c; i4++) {
            this.e[i4] = null;
            this.f[i4] = null;
        }
        this.g = 0;
    }
}
