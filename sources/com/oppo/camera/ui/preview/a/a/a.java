package com.oppo.camera.ui.preview.a.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.renderscript.Matrix4f;
import com.oppo.camera.R;
import com.oppo.camera.doubleexposure.b;
import com.oppo.camera.doubleexposure.d;
import com.oppo.camera.doubleexposure.g;
import com.oppo.camera.e;
import com.oppo.camera.gl.c;
import com.oppo.camera.gl.h;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.ui.preview.a.u;

/* compiled from: DoubleExposureTexturePreview */
public class a extends s implements u.a {
    private Matrix4f A = new Matrix4f();
    private b B = null;
    private boolean C = false;
    private boolean D = false;
    private int E = 0;
    private ConditionVariable F = new ConditionVariable();
    private final Object G = new Object();
    private g.a H = null;
    private com.oppo.camera.doubleexposure.a I = null;
    private boolean J = false;
    /* access modifiers changed from: private */
    public boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private float[] N = null;
    private long O = 0;
    private long P = 0;
    private int Q = 0;
    private d R = null;
    private b S = null;
    private boolean T = true;
    private boolean U = false;

    /* renamed from: a  reason: collision with root package name */
    private Context f4354a = null;

    /* renamed from: b  reason: collision with root package name */
    private u f4355b = null;
    private int c = 0;
    private int i = 0;
    private com.oppo.camera.gl.s j = null;
    private com.oppo.camera.gl.s k = null;
    private com.oppo.camera.gl.s l = null;
    private com.oppo.camera.gl.s m = null;
    private com.oppo.camera.gl.s n = null;
    private com.oppo.camera.gl.s o = null;
    private com.oppo.camera.gl.s p = null;
    private com.oppo.camera.gl.g q = null;
    private boolean r = false;
    private d s = null;
    private HandlerThread t = null;
    private Handler u = null;
    private c v = null;
    private SurfaceTexture w = null;
    private boolean x = false;
    private boolean y = false;
    private float[] z = new float[16];

    private int a(int i2, boolean z2) {
        if (!z2) {
            if (i2 != 0) {
                if (i2 != 90) {
                    if (i2 != 180) {
                        return 0;
                    }
                }
                return 180;
            }
            return 270;
        } else if (i2 != 0) {
            if (i2 != 90) {
                if (i2 != 180) {
                    return 0;
                }
                return 270;
            }
            return 180;
        }
        return 90;
    }

    private boolean f(int i2) {
        return i2 == 0 || i2 == 4 || i2 == 5 || i2 == 6;
    }

    public boolean a() {
        return false;
    }

    public void c() {
    }

    public int d() {
        return 1024;
    }

    public boolean h() {
        return false;
    }

    public void v() {
    }

    public a(Context context) {
        super(context);
        this.f4354a = context;
    }

    public void a(u uVar) {
        if (this.N == null) {
            this.N = new Matrix4f().getArray();
        }
        if (this.t == null) {
            this.t = new HandlerThread("decode video");
            this.t.start();
        }
        if (this.u == null) {
            this.u = new Handler(this.t.getLooper());
        }
        this.f4355b = uVar;
        this.f4355b.a((u.a) this);
        if (this.s == null) {
            this.s = new d(this.f4354a);
            int a2 = this.s.a();
            this.s.a(this.f4355b.C());
            this.x = true;
            e.a("DoubleExposureTexturePreview", "process, initResult: " + a2);
        }
        if (this.v != null) {
            this.F.open();
        }
        synchronized (this.G) {
            this.U = this.e;
        }
        this.M = true;
    }

    public void e() {
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        com.oppo.camera.gl.s sVar = this.n;
        if (sVar != null) {
            sVar.l();
            this.n = null;
        }
        D();
        this.J = false;
        this.f.a((Runnable) new Runnable() {
            public void run() {
                a.this.o();
            }
        });
        this.M = false;
    }

    /* access modifiers changed from: private */
    public void o() {
        d dVar = this.s;
        if (dVar != null && this.x) {
            dVar.c();
            this.s = null;
            this.x = false;
            this.y = false;
        }
    }

    private void p() {
        HandlerThread handlerThread = this.t;
        if (handlerThread != null) {
            handlerThread.quit();
            this.t = null;
        }
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.u = null;
        }
    }

    public void a(int i2, int i3) {
        super.a(i2, i3);
        this.c = i2;
        this.i = i3;
    }

    public com.oppo.camera.gl.s f() {
        return this.k;
    }

    public com.oppo.camera.gl.s g() {
        return this.j;
    }

    public void i() {
        this.k = new com.oppo.camera.gl.s(this.c, this.i, true);
        this.j = new com.oppo.camera.gl.s(this.i, this.c, true);
        this.r = true;
    }

    public void a(h hVar) {
        com.oppo.camera.gl.s sVar = this.k;
        if (sVar != null && !sVar.k()) {
            this.k.c(hVar);
            e.a("DoubleExposureTexturePreview", "prepareTextures, mInputTexture.getId: " + this.k.d());
        }
        com.oppo.camera.gl.s sVar2 = this.j;
        if (sVar2 != null && !sVar2.k()) {
            this.j.c(hVar);
            e.a("DoubleExposureTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.j.d());
        }
        com.oppo.camera.gl.s sVar3 = this.l;
        if (sVar3 != null && !sVar3.k()) {
            this.l.c(hVar);
        }
    }

    public void j() {
        if (this.r) {
            com.oppo.camera.gl.s sVar = this.k;
            if (sVar != null) {
                sVar.l();
                this.k = null;
            }
            com.oppo.camera.gl.s sVar2 = this.j;
            if (sVar2 != null) {
                sVar2.l();
                this.j = null;
            }
            this.r = false;
        }
    }

    public boolean a(int i2) {
        if (!c_(i2)) {
            e.a("DoubleExposureTexturePreview", "canProcess, not support");
            return false;
        } else if (this.r && this.f4355b != null) {
            return true;
        } else {
            return false;
        }
    }

    private void w() {
        d dVar;
        if (this.x && !this.y && (dVar = this.s) != null) {
            dVar.b();
            this.y = true;
        }
    }

    private void x() {
        if (this.J) {
            g.a aVar = this.H;
            if (aVar != null) {
                aVar.onVideoClipDone();
            }
            com.oppo.camera.doubleexposure.a aVar2 = this.I;
            if (aVar2 != null) {
                aVar2.a();
            }
            this.J = false;
            this.H = null;
            this.I = null;
        }
    }

    public boolean a(s.a aVar) {
        int a2;
        b bVar;
        s.a aVar2 = aVar;
        w();
        x();
        if (this.q == null && this.C && (bVar = this.B) != null) {
            a(bVar);
            this.C = false;
        }
        if (this.v != null && this.T) {
            this.F.open();
        }
        c cVar = this.v;
        if (cVar != null && cVar.f()) {
            this.v.e();
        }
        try {
            if (A() && this.x && this.q != null) {
                y();
                if (this.l == null) {
                    this.l = new com.oppo.camera.gl.s(this.q.f3282a, this.q.f3283b, true);
                    if (!this.l.k()) {
                        this.l.c(aVar2.f4427a);
                    }
                }
                if (this.m == null) {
                    this.m = new com.oppo.camera.gl.s(this.q.f3282a, this.q.f3283b, true);
                    if (!this.m.k()) {
                        this.m.c(aVar2.f4427a);
                    }
                }
                if (this.w != null) {
                    this.w.updateTexImage();
                    this.w.getTransformMatrix(this.z);
                }
                a(aVar2.f4427a, this.q, this.l, this.z);
                if (this.D) {
                    this.p = a(aVar2.f4427a, this.l, this.m, this.A.getArray(), E()) ? this.m : this.l;
                    aVar2.f = true;
                    aVar2.d = this.p;
                    this.o = this.p;
                    this.n = null;
                    this.J = true;
                    return true;
                }
                Image image = aVar2.e.getImage();
                synchronized (this.G) {
                    a2 = this.s.a(this.l.d(), this.l.f3282a, this.l.f3283b, false, this.v.c(), this.B.g(), image, this.j.d(), a(this.E, this.U), this.U);
                    if (this.M) {
                        this.M = false;
                        a2 = this.s.a(this.l.d(), this.l.f3282a, this.l.f3283b, false, this.v.c(), this.B.g(), image, this.j.d(), a(this.E, this.U), this.U);
                        e.a("DoubleExposureTexturePreview", "process, drop frame");
                    }
                }
                if (!f(a2)) {
                    e.a("DoubleExposureTexturePreview", "process, result: " + a2);
                    return false;
                }
                g(a2);
                this.J = true;
                this.n = this.j;
                this.o = null;
                this.T = true;
                return true;
            } else if (this.K) {
                if (this.n == null) {
                    if (this.o == null) {
                        return false;
                    }
                }
                if (this.n != null) {
                    this.j = this.n;
                    e.a("DoubleExposureTexturePreview", "draw cache");
                } else {
                    this.p = this.o;
                    aVar2.f = true;
                    aVar2.d = this.p;
                    e.a("DoubleExposureTexturePreview", "draw video cache");
                }
                return true;
            } else {
                if (B()) {
                    e.a("DoubleExposureTexturePreview", "process, decoding not ready");
                }
                return false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void y() {
        com.oppo.camera.gl.s sVar = this.l;
        if (!(sVar == null || (sVar.e() == this.q.e() && this.l.f() == this.q.f()))) {
            this.l.l();
            this.l = null;
        }
        com.oppo.camera.gl.s sVar2 = this.m;
        if (sVar2 == null) {
            return;
        }
        if (sVar2.e() != this.q.e() || this.m.f() != this.q.f()) {
            this.m.l();
            this.m = null;
        }
    }

    private void g(int i2) {
        if (this.L) {
            long currentTimeMillis = System.currentTimeMillis();
            if (i2 == 5) {
                if (currentTimeMillis - this.O <= 2000) {
                    this.g.a(R.string.mode_double_exposure_move_closer, 0, true, false, false, false, false, true, 1000);
                }
                this.O = currentTimeMillis;
            } else if (i2 == 4) {
                if (this.Q != 4) {
                    this.P = currentTimeMillis;
                }
                if (currentTimeMillis - this.P >= 2000) {
                    this.g.a(R.string.camera_double_exposure_nobody_hint, 0, true, false, false, false, false, true, 1000);
                }
            }
            this.Q = i2;
        }
    }

    private void z() {
        this.g.a((int) R.string.mode_double_exposure_move_closer);
        this.g.a((int) R.string.camera_double_exposure_nobody_hint);
    }

    private boolean A() {
        c cVar = this.v;
        return cVar != null && cVar.i();
    }

    private boolean B() {
        c cVar = this.v;
        return cVar != null && cVar.j();
    }

    private void a(h hVar, com.oppo.camera.gl.g gVar, com.oppo.camera.gl.s sVar, float[] fArr) {
        if (sVar != null) {
            int e = sVar.e();
            int f = sVar.f();
            hVar.a(sVar);
            hVar.a(0.0f, (float) f);
            hVar.a(1.0f, -1.0f, 1.0f);
            hVar.a((c) gVar, fArr, 0, 0, e, f);
            hVar.h();
        }
    }

    private boolean a(h hVar, c cVar, com.oppo.camera.gl.s sVar, float[] fArr, d dVar) {
        int e = sVar.e();
        int f = sVar.f();
        int c2 = dVar.c();
        if (!((dVar.a() > dVar.b() && dVar.c() % 180 == 0) || (dVar.a() < dVar.b() && dVar.c() % 180 != 0))) {
            return false;
        }
        hVar.a(sVar);
        b bVar = this.B;
        int i2 = 90;
        if (bVar != null && !bVar.g() && c2 == 90) {
            i2 = 270;
        }
        a(hVar, e, f, i2);
        hVar.a(cVar, fArr, 0, 0, f, e);
        hVar.h();
        return true;
    }

    private void a(h hVar, int i2, int i3, int i4) {
        int i5 = i2 / 2;
        int i6 = i3 / 2;
        hVar.a((float) i5, (float) i6);
        hVar.a((float) i4, 0.0f, 0.0f, 1.0f);
        if (i4 % 180 != 0) {
            hVar.a((float) (-i6), (float) (-i5));
        } else {
            hVar.a((float) (-i5), (float) (-i6));
        }
    }

    public void b() {
        p();
    }

    public void a(com.oppo.camera.doubleexposure.c cVar) {
        b a2 = cVar.a();
        e.a("DoubleExposureTexturePreview", "onVideoLoadedDone, clipVideoInfo: " + a2);
        this.L = false;
        z();
        if (this.B == null || !a2.c().equals(this.B.c())) {
            if (this.B != null) {
                this.K = true;
            }
            D();
            this.B = a2;
            this.C = true;
            this.D = cVar.b();
        } else {
            this.C = true;
            this.D = cVar.b();
        }
        if (cVar.c() != null) {
            this.H = cVar.c();
            this.J = false;
        }
        if (cVar.d() != null) {
            this.I = cVar.d();
        }
    }

    public void s() {
        C();
        D();
    }

    private void C() {
        com.oppo.camera.gl.s sVar = this.n;
        if (sVar != null) {
            sVar.l();
            this.n = null;
        }
    }

    public void t() {
        c cVar = this.v;
        if (cVar != null) {
            cVar.h();
        }
        this.L = true;
    }

    public void u() {
        synchronized (this.G) {
            this.M = true;
        }
        c cVar = this.v;
        if (cVar != null) {
            cVar.d();
        }
        C();
    }

    public void c(int i2) {
        d dVar;
        e.a("DoubleExposureTexturePreview", "onDoubleExposureTypeChanged, newType:" + i2);
        if (this.x && (dVar = this.s) != null) {
            dVar.a(i2);
        }
    }

    public void b(int i2) {
        synchronized (this.G) {
            this.E = i2;
        }
    }

    private void D() {
        if (this.v != null) {
            e.a("DoubleExposureTexturePreview", "stopDecode");
            this.v.g();
            Handler handler = this.u;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.v.k();
            this.v = null;
            synchronized (this.G) {
                if (this.q != null) {
                    this.q.l();
                    this.q = null;
                }
            }
        }
        this.C = false;
        this.D = false;
        this.B = null;
        this.M = true;
    }

    private void a(b bVar) {
        if (this.S == null) {
            this.S = new b() {
                public void a() {
                    if (a.this.K) {
                        boolean unused = a.this.K = false;
                    }
                }

                public void b() {
                    a.this.s();
                }
            };
        }
        if (this.v == null) {
            this.q = new com.oppo.camera.gl.g(36197);
            this.w = new SurfaceTexture(this.q.d());
            this.v = new c(bVar, this.w);
            this.v.a(this.G);
            this.v.a(this.F);
            this.v.a(this.S);
            this.q.a(this.v.a(), this.v.b());
            this.u.post(this.v);
        }
    }

    private d E() {
        if (this.R == null) {
            this.R = new d();
        }
        c cVar = this.v;
        if (cVar == null) {
            this.R.a(0);
            this.R.b(0);
            this.R.c(0);
        } else {
            this.R.a(cVar.a());
            this.R.b(this.v.b());
            this.R.c(this.v.c());
        }
        return this.R;
    }
}
