package com.oppo.camera.ui.menu.levelcontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.PolarrRender;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.gl.i;
import com.oppo.camera.gl.m;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.util.Util;
import com.oppo.camera.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLProducerRender */
public class g implements m.C0085m, com.oppo.camera.ui.inverse.a {
    private int A = -1;
    private int B = -1;
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private h.a F = h.a.Polarr;

    /* renamed from: a  reason: collision with root package name */
    private Context f4142a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public d f4143b = null;
    private j c = null;
    private f d = null;
    private ArrayList<m> e = null;
    private ArrayList<m> f = null;
    /* access modifiers changed from: private */
    public m g = null;
    private m h = null;
    private a i = null;
    private b j = null;
    private Interpolator k = new PathInterpolator(0.0f, 0.1f, 0.1f, 1.0f);
    private float[] l = {0.0f, 0.0f, 0.0f, 0.0f};
    private float m = 0.0f;
    private float n = 0.0f;
    private float o = 0.0f;
    private int p = 26;
    private int q = 0;
    private int r = 10;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private int y = -1;
    private int z = -1;

    /* compiled from: GLProducerRender */
    public interface a {
        void a();

        void a(g gVar);
    }

    /* compiled from: GLProducerRender */
    public interface b {
        void a(float f);

        void b(float f);
    }

    public void a(int i2) {
        this.x = i2;
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public g(Context context) {
        this.f4142a = context;
    }

    public void a(h.a aVar) {
        this.F = aVar;
        d dVar = this.f4143b;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        long currentTimeMillis = System.currentTimeMillis();
        GLES20.glEnable(2929);
        GLES20.glEnable(2884);
        i.i();
        i.a();
        this.i.a();
        this.f4143b = new d(this.f4142a);
        this.f4143b.a(this.F);
        this.c = new j(this.f4142a);
        e.a("GLProducerRender", "onSurfaceCreated, cost: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void a(GL10 gl10, int i2, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        GLES20.glViewport(0, 0, i2, i3);
        i.i();
        this.f4143b.a(i2, i3);
        h.d((float) i3);
        f fVar = this.d;
        if (fVar != null) {
            b(fVar);
        } else {
            e.a("GLProducerRender", "onSurfaceChanged, mGLModelParam has not init.");
        }
        i.a(0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        i.b(0.0f, 6.0f, 10.0f);
        this.s = true;
        e.a("GLProducerRender", "onSurfaceChanged, cost: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void a(GL10 gl10) {
        Bitmap bitmap;
        f fVar = this.d;
        if (fVar == null || fVar.e() <= 0) {
            e.e("GLProducerRender", "onDrawFrame, vertex not ready");
            return;
        }
        f fVar2 = this.d;
        if (fVar2 == null || !fVar2.r() || this.r >= 10) {
            i.i();
            float[] fArr = this.l;
            GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
            GLES20.glClear(16640);
            GLES20.glDisable(3042);
            i.b();
            i.a(0.0f, 0.0f, -10.0f);
            i.i();
            i.b();
            if (Float.compare(this.o, 0.0f) != 0) {
                float f2 = this.o;
                Interpolator interpolator = this.k;
                int i2 = this.q;
                this.q = i2 + 1;
                float interpolation = f2 * interpolator.getInterpolation(((float) i2) / ((float) this.p));
                float interpolation2 = this.o * this.k.getInterpolation(((float) this.q) / ((float) this.p));
                this.m += interpolation2 - interpolation;
                b bVar = this.j;
                if (bVar != null) {
                    bVar.a(this.m);
                } else {
                    e.e("GLProducerRender", "onDrawFrame, mScrollAnimListener == null !");
                }
                if ((Float.compare(this.o, 0.0f) > 0 && Float.compare(interpolation2, this.o) >= 0) || (Float.compare(this.o, 0.0f) < 0 && Float.compare(interpolation2, this.o) <= 0)) {
                    this.m = this.n;
                    this.o = 0.0f;
                    this.q = 0;
                    b bVar2 = this.j;
                    if (bVar2 != null) {
                        bVar2.b(this.m);
                    } else {
                        e.e("GLProducerRender", "onDrawFrame, mScrollAnimListener == null !");
                    }
                }
            }
            i.a(this.m, 0.0f, 1.0f, 0.0f);
            i.i();
            f fVar3 = this.d;
            if (fVar3 == null || !fVar3.r()) {
                if (this.e != null) {
                    for (int i3 = 0; i3 < this.e.size(); i3++) {
                        if (a(i3, this.m) && i3 < this.f4143b.b()) {
                            i.i();
                            i.b();
                            i.i();
                            i.a(0.0f, ((-h.i()) / 2.0f) * 1.0f, 0.0f);
                            this.f4143b.b(this.e.get(i3).c(), i3);
                            i.c();
                            i.i();
                        }
                    }
                }
            } else if (this.s && this.g != null) {
                this.i.a(this);
            }
            i.c();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
            i.i();
            if (!(this.c == null || this.f == null || this.g == null)) {
                if (this.w) {
                    for (int i4 = 0; i4 < this.f.size(); i4++) {
                        if (this.f.get(i4).d() == 0) {
                            m mVar = this.f.get(i4);
                            if (this.v) {
                                bitmap = this.d.d();
                            } else {
                                bitmap = this.d.c();
                            }
                            mVar.b(bitmap);
                        }
                    }
                    this.w = false;
                }
                for (int i5 = 0; i5 < this.f.size(); i5++) {
                    if (this.f.get(i5).c() != -1) {
                        i.b();
                        i.a(0.0f, ((-h.i()) / 2.0f) * 1.0f, 0.0f);
                        this.c.a(this.f.get(i5).c(), i5);
                        i.c();
                    } else {
                        e.e("GLProducerRender", "onDrawFrame, mRingTexs[" + i5 + "] not init.");
                    }
                }
            }
            i.c();
            i.i();
            return;
        }
        e.a("GLProducerRender", "onDrawFrame, mDisableFrameId: " + this.r);
        this.r = this.r + 1;
    }

    public void setInverseColor(boolean z2) {
        this.v = z2;
        this.w = true;
    }

    private boolean a(int i2, float f2) {
        float a2 = (((float) h.a()) / 2.0f) + h.g();
        float f3 = f2 + a2;
        float c2 = c(i2);
        return c2 >= f2 - a2 && c2 <= f3;
    }

    private float c(int i2) {
        return ((float) (-i2)) * h.g();
    }

    public void a(float f2, float f3, int i2, Interpolator interpolator, b bVar) {
        int i3;
        this.m = f2;
        this.n = f2 + f3;
        this.o = f3;
        if (i2 <= 0) {
            e.a("GLProducerRender", "startYAngleAnim, durationFrame must > 0!");
            i2 = 1;
        } else {
            int i4 = this.q;
            if (i4 > 0 && (i3 = this.p) > i4) {
                i2 = i3 - i4;
                this.q = 0;
            }
        }
        this.p = i2;
        if (interpolator != null) {
            this.k = interpolator;
        }
        if (bVar != null) {
            this.j = bVar;
        }
    }

    public void a() {
        this.o = 0.0f;
        this.q = 0;
    }

    public float b() {
        return this.m;
    }

    public void a(m mVar) {
        if (mVar != null) {
            mVar.a((Runnable) new Runnable() {
                public void run() {
                    if (g.this.f4143b != null) {
                        g.this.f4143b.c();
                    }
                    g.this.i();
                }
            });
        }
    }

    public void c() {
        d dVar = this.f4143b;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            mVar.a((Runnable) new Runnable() {
                public void run() {
                    if (g.this.g != null) {
                        PolarrRender.clearTextureHelper(g.this.g.c(), g.this.g.e(), g.this.g.f());
                        g.this.g.b();
                        m unused = g.this.g = null;
                    }
                }
            });
        }
    }

    public boolean d() {
        d dVar = this.f4143b;
        if (dVar != null) {
            return dVar.e();
        }
        return false;
    }

    public void e() {
        d dVar = this.f4143b;
        if (dVar != null) {
            dVar.a(this.f4142a);
            f fVar = this.d;
            if (fVar != null) {
                this.f4143b.f(fVar.g(), this.d.f());
            }
        }
    }

    public void b(int i2) {
        f fVar = this.d;
        if (fVar == null || fVar.e() <= 0) {
            e.e("GLProducerRender", "onDrawFrame, vertex not ready");
            return;
        }
        if (!this.f4143b.e() || this.g == null) {
            for (int i3 = 0; i3 < this.d.e(); i3++) {
                b(i2, i3);
            }
            e.a("GLProducerRender", "onDrawFrame, drawOesTexture.");
            return;
        }
        if (Float.compare(this.o, 0.0f) == 0 || !this.u) {
            this.u = this.f4143b.a(i2, this.g.c(), this.d.a(), this.m);
        }
        this.f4143b.c(this.g.c(), 0);
    }

    private void b(int i2, int i3) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        if (i3 == this.d.a("portrait_retention")) {
            if (-1 == this.y) {
                if (this.d.k()) {
                    bitmap7 = Util.a(BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_portrait_retention_4_3));
                } else {
                    bitmap7 = BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_portrait_retention_4_3);
                }
                this.y = d.a(bitmap7);
            }
            this.f4143b.e(this.y, i3 + 1);
        } else if (i3 == this.d.a("portrait_streamer")) {
            if (-1 == this.A) {
                if (this.d.k()) {
                    bitmap6 = Util.a(BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_portrait_streamer_4_3));
                } else {
                    bitmap6 = BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_portrait_streamer_4_3);
                }
                this.A = d.a(bitmap6);
            }
            this.f4143b.e(this.A, i3 + 1);
        } else if (i3 == this.d.a("neon-2020.cube.rgb.bin")) {
            if (-1 == this.z) {
                if (this.d.k()) {
                    bitmap5 = Util.a(BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_portrait_neon_4_3));
                } else {
                    bitmap5 = BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_portrait_neon_4_3);
                }
                this.z = d.a(bitmap5);
            }
            this.f4143b.e(this.z, i3 + 1);
        } else if (i3 == this.d.a(FilterPackageUtil.SKY_BLUE_2020)) {
            if (-1 == this.C) {
                if (this.d.k()) {
                    bitmap4 = Util.a(BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_filter_video_blue_16_9));
                } else {
                    bitmap4 = BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_filter_video_blue_16_9);
                }
                this.C = d.a(bitmap4);
            }
            this.f4143b.e(this.C, i3 + 1);
        } else if (i3 == this.d.a(FilterPackageUtil.RED_RED_2020)) {
            if (-1 == this.B) {
                if (this.d.k()) {
                    bitmap3 = Util.a(BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_filter_video_red_16_9));
                } else {
                    bitmap3 = BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_filter_video_red_16_9);
                }
                this.B = d.a(bitmap3);
            }
            this.f4143b.e(this.B, i3 + 1);
        } else if (i3 == this.d.a(FilterPackageUtil.TREE_GREEN_2020)) {
            if (-1 == this.D) {
                if (this.d.k()) {
                    bitmap2 = Util.a(BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_filter_video_green_16_9));
                } else {
                    bitmap2 = BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_filter_video_green_16_9);
                }
                this.D = d.a(bitmap2);
            }
            this.f4143b.e(this.D, i3 + 1);
        } else if (i3 == this.d.a("oppo_video_filter_portrait_retention")) {
            if (-1 == this.E) {
                if (this.d.k()) {
                    bitmap = Util.a(BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_filter_video_retention_16_9));
                } else {
                    bitmap = BitmapFactory.decodeResource(this.f4142a.getResources(), R.drawable.icon_filter_video_retention_16_9);
                }
                this.E = d.a(bitmap);
            }
            this.f4143b.e(this.E, i3 + 1);
        } else {
            this.f4143b.d(i2, i3 + 1);
        }
    }

    public void a(int i2, int i3) {
        e.a("GLProducerRender", "notifyPreviewSizeChanged, Size: " + i2 + "x" + i3);
        f fVar = this.d;
        if (fVar != null && fVar.r()) {
            if (this.d.f() != i2 || this.d.g() != i3) {
                if (Math.abs((((double) i2) / ((double) i3)) - (((double) this.d.f()) / ((double) this.d.g()))) >= 0.01d) {
                    this.d.b(i2);
                    this.d.c(i3);
                    this.t = true;
                }
            }
        }
    }

    public void f() {
        f fVar;
        if (this.t && (fVar = this.d) != null && fVar.r()) {
            if (this.d.f() != this.d.h() || this.d.g() != this.d.i()) {
                f fVar2 = this.d;
                fVar2.d(fVar2.f());
                f fVar3 = this.d;
                fVar3.e(fVar3.g());
                f fVar4 = this.d;
                com.oppo.camera.ui.preview.a.g.a(fVar4, fVar4.g(), this.d.f());
                this.r = 0;
                a(this.d, true);
            }
        }
    }

    public void a(float[] fArr) {
        this.l = fArr;
    }

    public int g() {
        f fVar = this.d;
        if (fVar != null) {
            return fVar.e();
        }
        return 0;
    }

    public boolean h() {
        f fVar = this.d;
        if (fVar != null) {
            return fVar.r();
        }
        return false;
    }

    public boolean a(f fVar) {
        f fVar2 = this.d;
        return fVar2 != null && fVar2.a(fVar);
    }

    private void b(f fVar) {
        float f2;
        float f3;
        float f4;
        e.a("GLProducerRender", "updateElementsParam, glModelParam: " + fVar.toString());
        h.e(fVar.m());
        h.b(fVar.n());
        h.c(fVar.o());
        j jVar = this.c;
        int i2 = 0;
        if (!(jVar == null || this.f == null)) {
            jVar.a();
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                if (this.f.get(i3).d() != 0) {
                    f4 = 0.0f;
                    f3 = 0.0f;
                    f2 = 0.0f;
                } else {
                    float a2 = h.a(fVar.p());
                    f2 = (-a2) / 2.0f;
                    f4 = a2;
                    f3 = f4;
                }
                this.c.a(f4, f3, 10.0f, h.p(), f2);
            }
        }
        d dVar = this.f4143b;
        if (dVar != null) {
            dVar.a();
            if (fVar.r()) {
                this.f4143b.a(1.0f, h.b(), h.i(), h.j(), h.a(0), (h.g() * ((float) (fVar.a().size() - 1))) + h.e(), false, fVar);
                while (i2 < fVar.e()) {
                    this.f4143b.a(1.0f, h.b(), h.i(), h.j(), h.a(i2), h.e(), true, fVar);
                    i2++;
                }
            } else {
                while (i2 < fVar.e()) {
                    this.f4143b.a(1.0f, h.b(), h.i(), h.j(), h.a(i2), h.e(), false, fVar);
                    i2++;
                }
            }
        }
        i.a(h.k(), h.l(), h.m(), h.n(), 10.0f, 100.0f);
        this.d = fVar;
    }

    public void a(int i2, String str) {
        f fVar = this.d;
        if (fVar != null && fVar.a() != null && i2 < this.d.a().size() && this.d.a().get(i2) != null) {
            this.d.a().get(i2).filterId = str;
        }
    }

    public void a(f fVar, boolean z2) {
        Bitmap bitmap;
        e.a("GLProducerRender", "createTextures, glModelParam: " + fVar.toString());
        this.t = false;
        this.u = false;
        this.x = fVar.j();
        if (this.v) {
            bitmap = fVar.d();
        } else {
            bitmap = fVar.c();
        }
        a(0, bitmap);
        d dVar = this.f4143b;
        if (dVar != null) {
            dVar.a(fVar.q());
        }
        if (fVar.r()) {
            int width = fVar.a().get(0).rect.width();
            int i2 = fVar.a().get(fVar.a().size() - 1).rect.bottom - fVar.a().get(0).rect.top;
            m mVar = this.g;
            if (mVar == null) {
                this.g = new m(width, i2, -1);
                if (!this.g.h()) {
                    this.g.a();
                }
                if (this.s) {
                    b(fVar);
                }
            } else {
                if (!(width == mVar.e() && i2 == this.g.f())) {
                    this.g.b();
                    this.g = new m(width, i2, -1);
                    if (!this.g.h()) {
                        this.g.a();
                    }
                }
                if (z2) {
                    b(fVar);
                }
            }
        } else if (fVar.b() != null) {
            if (this.e == null) {
                a(fVar.b());
                if (this.s) {
                    b(fVar);
                }
            } else {
                a(fVar.b());
                if (z2) {
                    b(fVar);
                }
            }
        } else {
            return;
        }
        d dVar2 = this.f4143b;
        if (dVar2 != null) {
            dVar2.f(fVar.g(), fVar.f());
        }
    }

    public void a(List<Bitmap> list) {
        e.a("GLProducerRender", "createCylinderSideTexs, bitmaps: " + list);
        if (this.e == null) {
            this.e = new ArrayList<>();
        }
        if (this.e.size() > 0) {
            Iterator<m> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            m mVar = new m();
            if (!mVar.h()) {
                mVar.a(list.get(i2));
            }
            this.e.add(mVar);
        }
    }

    public void a(int i2, Bitmap bitmap) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        Iterator<m> it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            m next = it.next();
            if (next.d() == i2) {
                next.b();
                this.f.remove(next);
                break;
            }
        }
        m mVar = new m(0);
        if (!mVar.h()) {
            mVar.a(bitmap);
        }
        this.f.add(mVar);
        e.a("GLProducerRender", "createRingTexture, length: " + this.f.size() + ", type: " + i2);
    }

    public void i() {
        e.a("GLProducerRender", "releaseResource");
        ArrayList<m> arrayList = this.e;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e.clear();
            this.e = null;
        }
        ArrayList<m> arrayList2 = this.f;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<m> it2 = this.f.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
            this.f.clear();
            this.f = null;
        }
        m mVar = this.g;
        if (mVar != null) {
            PolarrRender.clearTextureHelper(mVar.c(), this.g.e(), this.g.f());
            this.g.b();
            this.g = null;
        }
        m mVar2 = this.h;
        if (mVar2 != null) {
            mVar2.b();
            this.h = null;
        }
        int i2 = this.y;
        if (-1 != i2) {
            d.a(i2);
            this.y = -1;
        }
        int i3 = this.z;
        if (-1 != i3) {
            d.a(i3);
            this.z = -1;
        }
        int i4 = this.A;
        if (-1 != i4) {
            d.a(i4);
            this.A = -1;
        }
        int i5 = this.C;
        if (-1 != i5) {
            d.a(i5);
            this.C = -1;
        }
        int i6 = this.B;
        if (-1 != i6) {
            d.a(i6);
            this.B = -1;
        }
        int i7 = this.D;
        if (-1 != i7) {
            d.a(i7);
            this.D = -1;
        }
        int i8 = this.E;
        if (-1 != i8) {
            d.a(i8);
            this.E = -1;
        }
    }
}
