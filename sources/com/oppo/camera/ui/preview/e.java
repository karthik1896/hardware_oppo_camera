package com.oppo.camera.ui.preview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.os.Looper;
import android.util.Size;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.gl.b.f;
import com.oppo.camera.gl.d;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.p;
import com.oppo.camera.gl.s;
import com.oppo.camera.gl.t;
import com.oppo.camera.ui.menu.levelcontrol.g;
import com.oppo.camera.util.Util;

/* compiled from: CameraScreenNail */
public class e extends t {
    private final float[] H = new float[16];
    private int I;
    private float J;
    private float K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private Context R;
    private u S;
    private b T;
    private s U;
    private s V;
    private s W;
    private d X;
    /* access modifiers changed from: private */
    public c Y;
    /* access modifiers changed from: private */
    public a Z;
    /* access modifiers changed from: private */
    public com.oppo.camera.gl.a.b aa;
    /* access modifiers changed from: private */
    public com.oppo.camera.gl.a.a ab;
    private int ac;
    private int ad;
    private long ae;
    private int af;
    private Size ag;
    private Runnable ah;

    /* compiled from: CameraScreenNail */
    public interface a {
        void a();
    }

    /* compiled from: CameraScreenNail */
    public interface b {
        void ab();

        void ac();

        void ad();

        void ae();
    }

    /* compiled from: CameraScreenNail */
    public interface c {
        int a(int i);

        void a();

        void b();

        void c();

        void d();
    }

    public e(Context context, b bVar, boolean z) {
        boolean z2 = false;
        this.I = 0;
        this.J = 0.0f;
        this.K = 0.0f;
        this.M = false;
        this.N = false;
        this.O = true;
        this.P = false;
        this.Q = false;
        this.R = null;
        this.S = new u();
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.ac = 0;
        this.ad = 0;
        this.ae = 0;
        this.af = 0;
        this.ag = null;
        this.ah = new Runnable() {
            public void run() {
                e.this.o.ad();
            }
        };
        synchronized (this.h) {
            this.R = context;
            this.o = bVar;
            this.T = new s();
            this.M = !z ? true : z2;
            this.G.a(Util.E());
            this.G.b(Util.C());
            this.G.c(Util.u());
        }
    }

    public void m() {
        synchronized (this.h) {
            this.y = false;
        }
    }

    public void b(boolean z) {
        synchronized (this.h) {
            this.N = false;
            super.b(z);
            this.U = new s(e(), f(), true);
            this.V = new s(e(), f(), true);
        }
    }

    public void a(int i, int i2) {
        super.a(i, i2);
    }

    public void c() {
        synchronized (this.h) {
            super.c();
            y();
            c(0);
        }
    }

    public void n() {
        this.q.h();
        this.Z = null;
        this.r.a((Runnable) new Runnable() {
            public void run() {
                if (e.this.m != null) {
                    e.this.m.a();
                }
                if (e.this.aa != null) {
                    e.this.aa.c();
                    com.oppo.camera.gl.a.b unused = e.this.aa = null;
                }
                if (e.this.ab != null) {
                    e.this.ab.b();
                    com.oppo.camera.gl.a.a unused2 = e.this.ab = null;
                }
                synchronized (this) {
                    if (e.this.F != null) {
                        e.this.F.b();
                        f unused3 = e.this.F = null;
                    }
                }
            }
        });
    }

    public void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2, boolean z) {
        synchronized (this.i) {
            this.v = j;
            if (!Util.p() && z) {
                this.o.ab();
            }
            com.oppo.camera.e.b("CameraScreenNail", "onCaptureStarted: mCaptureTimestamp: " + this.v + ", isGLNeedRequestRender " + z);
        }
    }

    public void a(long j) {
        com.oppo.camera.e.a("CameraScreenNail", "setCaptureTimestamp, time: " + j);
        synchronized (this.i) {
            this.v = j;
        }
    }

    public long o() {
        long j;
        synchronized (this.i) {
            j = this.v;
        }
        return j;
    }

    public void a(c cVar) {
        this.Y = cVar;
    }

    public void a(a aVar) {
        this.Z = aVar;
    }

    public void a(Size size, Size size2) {
        if (this.aa != null) {
            if (!v()) {
                this.aa.a(size, size2);
                this.ag = size;
            } else {
                Size size3 = this.ag;
                if (size3 != null) {
                    this.aa.a(size3, size2);
                }
            }
            synchronized (this.h) {
                if (this.I == 0) {
                    this.o.ab();
                    c(13);
                }
            }
        }
    }

    public void a(Bitmap bitmap, int i) {
        com.oppo.camera.e.a("CameraScreenNail", "setGaussianBlurBitmap");
        this.ac = i;
        if (bitmap == null || bitmap.isRecycled()) {
            c(0);
            this.Y.d();
            return;
        }
        this.X = new d(bitmap);
        synchronized (this.h) {
            this.o.ab();
            c(5);
        }
    }

    public int a(int i, int i2, int i3) {
        this.ab.b(i2, i3);
        this.ab.a(i2, i3);
        this.ab.a(10);
        return this.ab.a(i, com.oppo.camera.util.d.a(com.oppo.camera.gl.a.c.f3261a), com.oppo.camera.util.d.a(com.oppo.camera.gl.a.c.f3262b));
    }

    public void h() {
        this.ab.a();
    }

    private void y() {
        s sVar = this.W;
        if (sVar != null) {
            sVar.l();
            this.W = null;
        }
        com.oppo.camera.gl.a.b bVar = this.aa;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void p() {
        if (this.q != null) {
            this.q.a();
        }
        if (this.aa == null) {
            this.aa = new com.oppo.camera.gl.a.b();
        }
        if (this.ab == null) {
            this.ab = new com.oppo.camera.gl.a.a();
        }
        this.m = new p();
        if (this.F == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            this.F = new f();
        }
        if (this.F != null) {
            this.F.a();
        }
    }

    public void b(int i, int i2) {
        if (this.q != null) {
            this.q.a(i, i2);
        }
    }

    public void g(boolean z) {
        this.B = z;
    }

    public void q() {
        com.oppo.camera.e.a("CameraScreenNail", "animateOpenEnd");
        this.J = 0.0f;
        synchronized (this.h) {
            c(0);
        }
    }

    public void r() {
        synchronized (this.h) {
            c(0);
        }
    }

    public void c(int i) {
        synchronized (this.h) {
            com.oppo.camera.e.a("CameraScreenNail", "setAnimState, state: " + this.I + "->" + i);
            this.I = i;
        }
    }

    public void a(h hVar, int i, int i2, int i3, int i4) {
        super.a(hVar, (g) null, i, i2, i3, i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:155:0x033c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0343, code lost:
        if (r13 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0345, code lost:
        super.a(r23, r24, r25, r26, r27, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c7, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.oppo.camera.gl.h r23, com.oppo.camera.ui.menu.levelcontrol.g r24, int r25, int r26, int r27, int r28) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            r9 = r27
            r10 = r28
            java.lang.Object r11 = r1.h
            monitor-enter(r11)
            boolean r2 = r1.L     // Catch:{ all -> 0x034a }
            r12 = 1
            if (r2 != 0) goto L_0x002a
            r1.L = r12     // Catch:{ all -> 0x034a }
            java.lang.String r2 = "CameraScreenNail"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x034a }
            r3.<init>()     // Catch:{ all -> 0x034a }
            java.lang.String r4 = "draw, mbVisible: "
            r3.append(r4)     // Catch:{ all -> 0x034a }
            boolean r4 = r1.L     // Catch:{ all -> 0x034a }
            r3.append(r4)     // Catch:{ all -> 0x034a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x034a }
            com.oppo.camera.e.a(r2, r3)     // Catch:{ all -> 0x034a }
        L_0x002a:
            java.util.ArrayList r2 = r1.j     // Catch:{ all -> 0x034a }
            r13 = 0
            if (r2 == 0) goto L_0x0033
            boolean r2 = r1.N     // Catch:{ all -> 0x034a }
            if (r2 != 0) goto L_0x0039
        L_0x0033:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            if (r2 != 0) goto L_0x0039
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            return r13
        L_0x0039:
            if (r24 == 0) goto L_0x0040
            super.a((com.oppo.camera.gl.h) r23, (com.oppo.camera.ui.menu.levelcontrol.g) r24, (int) r25, (int) r26, (int) r27, (int) r28)     // Catch:{ all -> 0x034a }
            goto L_0x0340
        L_0x0040:
            if (r0 == 0) goto L_0x0340
            r2 = 11
            int r3 = r1.I     // Catch:{ all -> 0x034a }
            r4 = 1050253722(0x3e99999a, float:0.3)
            if (r2 != r3) goto L_0x007d
            float r2 = r1.J     // Catch:{ all -> 0x034a }
            float r3 = r1.K     // Catch:{ all -> 0x034a }
            float r2 = r2 + r3
            r1.J = r2     // Catch:{ all -> 0x034a }
            r23.c()     // Catch:{ all -> 0x034a }
            float r2 = r1.J     // Catch:{ all -> 0x034a }
            double r2 = (double) r2     // Catch:{ all -> 0x034a }
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 > 0) goto L_0x0069
            r0.a((float) r4)     // Catch:{ all -> 0x034a }
            super.a((com.oppo.camera.gl.h) r23, (com.oppo.camera.ui.menu.levelcontrol.g) r24, (int) r25, (int) r26, (int) r27, (int) r28)     // Catch:{ all -> 0x034a }
            r23.f()     // Catch:{ all -> 0x034a }
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            return r12
        L_0x0069:
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.J = r2     // Catch:{ all -> 0x034a }
            float r2 = r1.J     // Catch:{ all -> 0x034a }
            r0.a((float) r2)     // Catch:{ all -> 0x034a }
            super.a((com.oppo.camera.gl.h) r23, (com.oppo.camera.ui.menu.levelcontrol.g) r24, (int) r25, (int) r26, (int) r27, (int) r28)     // Catch:{ all -> 0x034a }
            r22.q()     // Catch:{ all -> 0x034a }
            r23.f()     // Catch:{ all -> 0x034a }
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            return r12
        L_0x007d:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            r3 = 12
            if (r2 != r3) goto L_0x0091
            r23.c()     // Catch:{ all -> 0x034a }
            r0.a((float) r4)     // Catch:{ all -> 0x034a }
            super.a((com.oppo.camera.gl.h) r23, (com.oppo.camera.ui.menu.levelcontrol.g) r24, (int) r25, (int) r26, (int) r27, (int) r28)     // Catch:{ all -> 0x034a }
            r23.f()     // Catch:{ all -> 0x034a }
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            return r12
        L_0x0091:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            if (r2 != 0) goto L_0x00c8
            boolean r0 = super.a((com.oppo.camera.gl.h) r23, (com.oppo.camera.ui.menu.levelcontrol.g) r24, (int) r25, (int) r26, (int) r27, (int) r28)     // Catch:{ all -> 0x034a }
            if (r0 == 0) goto L_0x00c6
            boolean r0 = r1.y     // Catch:{ all -> 0x034a }
            if (r0 != 0) goto L_0x00c6
            r1.y = r12     // Catch:{ all -> 0x034a }
            java.lang.String r0 = "CameraStartupPerformance.onFirstFrameDrawed"
            com.oppo.camera.e.a((java.lang.String) r0)     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.e$b r0 = r1.o     // Catch:{ all -> 0x034a }
            r0.ae()     // Catch:{ all -> 0x034a }
            java.lang.String r0 = "CameraStartupPerformance.onFirstFrameDrawed"
            com.oppo.camera.e.b(r0)     // Catch:{ all -> 0x034a }
            java.lang.String r0 = "launch_first_frame_draw"
            com.oppo.camera.perf.a.c(r0)     // Catch:{ all -> 0x034a }
            java.lang.String r0 = "switch_mode"
            com.oppo.camera.perf.a.b(r0)     // Catch:{ all -> 0x034a }
            java.lang.String r0 = "switch_camera"
            com.oppo.camera.perf.a.b(r0)     // Catch:{ all -> 0x034a }
            java.lang.String r0 = "CameraScreenNail"
            java.lang.String r2 = "CameraTest First Frame Draw"
            com.oppo.camera.e.e(r0, r2)     // Catch:{ all -> 0x034a }
        L_0x00c6:
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            return r12
        L_0x00c8:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            r14 = 14
            r15 = 9
            r8 = 4
            r7 = 3
            if (r2 == r12) goto L_0x0228
            r3 = 2
            if (r2 == r3) goto L_0x0217
            r3 = 5
            r6 = 8
            r4 = 6
            if (r2 == r3) goto L_0x01a9
            if (r2 == r4) goto L_0x01b9
            r3 = 7
            if (r2 == r3) goto L_0x01b9
            if (r2 == r6) goto L_0x01a7
            r3 = 13
            if (r2 == r3) goto L_0x00ed
        L_0x00e6:
            r12 = r25
            r14 = r8
        L_0x00e9:
            r8 = r26
            goto L_0x0234
        L_0x00ed:
            boolean r2 = r1.Q     // Catch:{ all -> 0x034a }
            if (r2 != 0) goto L_0x0198
            int r2 = r1.s     // Catch:{ all -> 0x034a }
            int r2 = r2 / 10
            int r3 = r1.t     // Catch:{ all -> 0x034a }
            int r3 = r3 / 10
            com.oppo.camera.gl.s r4 = r1.l     // Catch:{ all -> 0x034a }
            if (r4 != 0) goto L_0x0105
            com.oppo.camera.gl.s r4 = new com.oppo.camera.gl.s     // Catch:{ all -> 0x034a }
            r4.<init>(r2, r3, r12)     // Catch:{ all -> 0x034a }
            r1.l = r4     // Catch:{ all -> 0x034a }
            goto L_0x0121
        L_0x0105:
            com.oppo.camera.gl.s r4 = r1.l     // Catch:{ all -> 0x034a }
            int r4 = r4.f()     // Catch:{ all -> 0x034a }
            if (r4 != r3) goto L_0x0115
            com.oppo.camera.gl.s r4 = r1.l     // Catch:{ all -> 0x034a }
            int r4 = r4.e()     // Catch:{ all -> 0x034a }
            if (r4 == r2) goto L_0x0121
        L_0x0115:
            com.oppo.camera.gl.s r4 = r1.l     // Catch:{ all -> 0x034a }
            r4.l()     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r4 = new com.oppo.camera.gl.s     // Catch:{ all -> 0x034a }
            r4.<init>(r2, r3, r12)     // Catch:{ all -> 0x034a }
            r1.l = r4     // Catch:{ all -> 0x034a }
        L_0x0121:
            java.lang.String r2 = "CameraScreenNail"
            java.lang.String r3 = "draw, mModeChangeBlurTexture init"
            com.oppo.camera.e.a(r2, r3)     // Catch:{ all -> 0x034a }
            java.util.ArrayList r2 = r1.j     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x0193
            float[] r2 = r1.z     // Catch:{ all -> 0x034a }
            r1.a((float[]) r2)     // Catch:{ all -> 0x034a }
            monitor-enter(r22)     // Catch:{ all -> 0x034a }
            int r2 = r1.A     // Catch:{ all -> 0x0190 }
            r3 = 90
            if (r2 == r3) goto L_0x0159
            int r2 = r1.A     // Catch:{ all -> 0x0190 }
            int r2 = r2 - r3
            int r2 = r2 + 360
            int r2 = r2 % 360
            int r2 = r2 / r3
            r3 = r13
        L_0x0141:
            if (r3 >= r2) goto L_0x0159
            float[] r4 = r1.z     // Catch:{ all -> 0x0190 }
            r17 = 0
            float[] r5 = r1.z     // Catch:{ all -> 0x0190 }
            r19 = 0
            float[] r20 = g     // Catch:{ all -> 0x0190 }
            r21 = 0
            r16 = r4
            r18 = r5
            android.opengl.Matrix.multiplyMM(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0190 }
            int r3 = r3 + 1
            goto L_0x0141
        L_0x0159:
            monitor-exit(r22)     // Catch:{ all -> 0x0190 }
            boolean r2 = r1.C     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x017b
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x017b
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r2 = r2.f()     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x017b
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r2 = r2.f()     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r3 = r1.l     // Catch:{ all -> 0x034a }
            r1.a((com.oppo.camera.gl.h) r0, (com.oppo.camera.gl.s) r2, (com.oppo.camera.gl.s) r3)     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.a.b r2 = r1.aa     // Catch:{ all -> 0x034a }
            r2.a((boolean) r12)     // Catch:{ all -> 0x034a }
            goto L_0x0193
        L_0x017b:
            java.util.ArrayList r2 = r1.j     // Catch:{ all -> 0x034a }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.g r2 = (com.oppo.camera.gl.g) r2     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r3 = r1.l     // Catch:{ all -> 0x034a }
            float[] r4 = r1.z     // Catch:{ all -> 0x034a }
            r1.a((com.oppo.camera.gl.h) r0, (com.oppo.camera.gl.g) r2, (com.oppo.camera.gl.s) r3, (float[]) r4)     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.a.b r2 = r1.aa     // Catch:{ all -> 0x034a }
            r2.a((boolean) r13)     // Catch:{ all -> 0x034a }
            goto L_0x0193
        L_0x0190:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0190 }
            throw r0     // Catch:{ all -> 0x034a }
        L_0x0193:
            com.oppo.camera.gl.a.b r2 = r1.aa     // Catch:{ all -> 0x034a }
            r2.d()     // Catch:{ all -> 0x034a }
        L_0x0198:
            r1.f3321a = r13     // Catch:{ all -> 0x034a }
            r1.f3322b = r13     // Catch:{ all -> 0x034a }
            r1.c = r13     // Catch:{ all -> 0x034a }
            r1.d = r13     // Catch:{ all -> 0x034a }
            r1.Q = r12     // Catch:{ all -> 0x034a }
            r1.c((int) r14)     // Catch:{ all -> 0x034a }
            goto L_0x00e6
        L_0x01a7:
            r14 = r8
            goto L_0x01dd
        L_0x01a9:
            r22.a((com.oppo.camera.gl.h) r23)     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.b r2 = r1.T     // Catch:{ all -> 0x034a }
            r2.a((int) r9, (int) r10)     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.e$b r2 = r1.o     // Catch:{ all -> 0x034a }
            r2.ac()     // Catch:{ all -> 0x034a }
            r1.c((int) r4)     // Catch:{ all -> 0x034a }
        L_0x01b9:
            boolean r2 = r1.P     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x01bf
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            return r12
        L_0x01bf:
            com.oppo.camera.ui.preview.b r2 = r1.T     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r5 = r1.U     // Catch:{ all -> 0x034a }
            r3 = r23
            r4 = r25
            r16 = r5
            r5 = r26
            r12 = r6
            r6 = r27
            r14 = r7
            r7 = r28
            r14 = r8
            r8 = r16
            r2.b(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x034a }
            super.a((com.oppo.camera.gl.h) r23, (com.oppo.camera.ui.menu.levelcontrol.g) r24, (int) r25, (int) r26, (int) r27, (int) r28)     // Catch:{ all -> 0x034a }
            r1.c((int) r12)     // Catch:{ all -> 0x034a }
        L_0x01dd:
            com.oppo.camera.ui.preview.b r2 = r1.T     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.e$c r3 = r1.Y     // Catch:{ all -> 0x034a }
            int r4 = r1.ac     // Catch:{ all -> 0x034a }
            int r3 = r3.a(r4)     // Catch:{ all -> 0x034a }
            r2.a(r3)     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.b r2 = r1.T     // Catch:{ all -> 0x034a }
            android.content.Context r3 = r1.R     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.e$c r4 = r1.Y     // Catch:{ all -> 0x034a }
            r2.a((android.content.Context) r3, (com.oppo.camera.ui.preview.e.c) r4)     // Catch:{ all -> 0x034a }
            android.content.Context r2 = r1.R     // Catch:{ all -> 0x034a }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.e$2 r3 = new com.oppo.camera.ui.preview.e$2     // Catch:{ all -> 0x034a }
            r3.<init>()     // Catch:{ all -> 0x034a }
            r2.runOnUiThread(r3)     // Catch:{ all -> 0x034a }
            r1.f3321a = r13     // Catch:{ all -> 0x034a }
            r1.f3322b = r13     // Catch:{ all -> 0x034a }
            r1.c = r13     // Catch:{ all -> 0x034a }
            r1.d = r13     // Catch:{ all -> 0x034a }
            r1.c((int) r15)     // Catch:{ all -> 0x034a }
            boolean r2 = r1.M     // Catch:{ all -> 0x034a }
            if (r2 != 0) goto L_0x0210
            r2 = 1
            goto L_0x0211
        L_0x0210:
            r2 = r13
        L_0x0211:
            r1.M = r2     // Catch:{ all -> 0x034a }
            r12 = r25
            goto L_0x00e9
        L_0x0217:
            r14 = r8
            r22.a((com.oppo.camera.gl.h) r23)     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.u r2 = r1.S     // Catch:{ all -> 0x034a }
            r12 = r25
            r8 = r26
            r2.a(r12, r8, r9, r10)     // Catch:{ all -> 0x034a }
            r1.c((int) r14)     // Catch:{ all -> 0x034a }
            goto L_0x0234
        L_0x0228:
            r12 = r25
            r14 = r8
            r8 = r26
            r22.a((com.oppo.camera.gl.h) r23)     // Catch:{ all -> 0x034a }
            r2 = 3
            r1.c((int) r2)     // Catch:{ all -> 0x034a }
        L_0x0234:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            r3 = 14
            if (r2 != r3) goto L_0x02ba
            com.oppo.camera.gl.a.b r2 = r1.aa     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x02ba
            com.oppo.camera.gl.s r2 = r1.l     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x02ba
            int r2 = r9 / 10
            int r3 = r10 / 10
            com.oppo.camera.gl.a.b r4 = r1.aa     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r5 = r1.l     // Catch:{ all -> 0x034a }
            int r5 = r5.d()     // Catch:{ all -> 0x034a }
            int r4 = r4.a(r5, r9, r10)     // Catch:{ all -> 0x034a }
            r1.ad = r4     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.i.i()     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r4 = r1.W     // Catch:{ all -> 0x034a }
            if (r4 != 0) goto L_0x0263
            com.oppo.camera.gl.s r4 = new com.oppo.camera.gl.s     // Catch:{ all -> 0x034a }
            r5 = 1
            r4.<init>(r2, r3, r5)     // Catch:{ all -> 0x034a }
            r1.W = r4     // Catch:{ all -> 0x034a }
        L_0x0263:
            com.oppo.camera.gl.s r4 = r1.W     // Catch:{ all -> 0x034a }
            r4.a(r2, r3)     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r2 = r1.W     // Catch:{ all -> 0x034a }
            int r3 = r1.ad     // Catch:{ all -> 0x034a }
            r2.a(r0, r3)     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r3 = r1.W     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.a.b r2 = r1.aa     // Catch:{ all -> 0x034a }
            float[] r4 = r2.a()     // Catch:{ all -> 0x034a }
            r2 = r23
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r2.a((com.oppo.camera.gl.c) r3, (float[]) r4, (int) r5, (int) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.i.i()     // Catch:{ all -> 0x034a }
            boolean r0 = r1.f3321a     // Catch:{ all -> 0x034a }
            if (r0 == 0) goto L_0x02b2
            boolean r0 = r1.Q     // Catch:{ all -> 0x034a }
            if (r0 != 0) goto L_0x02b2
            android.content.Context r0 = r1.R     // Catch:{ all -> 0x034a }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.e$3 r2 = new com.oppo.camera.ui.preview.e$3     // Catch:{ all -> 0x034a }
            r2.<init>()     // Catch:{ all -> 0x034a }
            r0.runOnUiThread(r2)     // Catch:{ all -> 0x034a }
            r0 = 36160(0x8d40, float:5.0671E-41)
            android.opengl.GLES20.glBindFramebuffer(r0, r13)     // Catch:{ all -> 0x034a }
            r0 = 3553(0xde1, float:4.979E-42)
            android.opengl.GLES20.glBindTexture(r0, r13)     // Catch:{ all -> 0x034a }
            super.i()     // Catch:{ all -> 0x034a }
            r22.y()     // Catch:{ all -> 0x034a }
            r1.c((int) r13)     // Catch:{ all -> 0x034a }
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            r0 = 1
            return r0
        L_0x02b2:
            com.oppo.camera.ui.preview.e$b r0 = r1.o     // Catch:{ all -> 0x034a }
            r0.ab()     // Catch:{ all -> 0x034a }
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            r0 = 1
            return r0
        L_0x02ba:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            r3 = 3
            if (r2 == r3) goto L_0x02c7
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            if (r2 == r14) goto L_0x02c7
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            if (r2 != r15) goto L_0x0342
        L_0x02c7:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            r3 = 3
            if (r2 != r3) goto L_0x02cd
            goto L_0x02f2
        L_0x02cd:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            if (r2 != r14) goto L_0x02da
            com.oppo.camera.ui.preview.u r2 = r1.S     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.s r3 = r1.U     // Catch:{ all -> 0x034a }
            boolean r2 = r2.a(r0, r1, r3)     // Catch:{ all -> 0x034a }
            goto L_0x02f3
        L_0x02da:
            com.oppo.camera.gl.d r2 = r1.X     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x02f2
            com.oppo.camera.ui.preview.b r2 = r1.T     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.d r14 = r1.X     // Catch:{ all -> 0x034a }
            r3 = r23
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r14
            boolean r2 = r2.a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x034a }
            goto L_0x02f3
        L_0x02f2:
            r2 = r13
        L_0x02f3:
            if (r2 == 0) goto L_0x02fb
            com.oppo.camera.ui.preview.e$b r2 = r1.o     // Catch:{ all -> 0x034a }
            r2.ab()     // Catch:{ all -> 0x034a }
            goto L_0x0342
        L_0x02fb:
            int r2 = r1.I     // Catch:{ all -> 0x034a }
            if (r2 != r15) goto L_0x033e
            boolean r2 = r1.f3321a     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x0312
            android.content.Context r2 = r1.R     // Catch:{ all -> 0x034a }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x034a }
            com.oppo.camera.ui.preview.e$4 r3 = new com.oppo.camera.ui.preview.e$4     // Catch:{ all -> 0x034a }
            r3.<init>()     // Catch:{ all -> 0x034a }
            r2.runOnUiThread(r3)     // Catch:{ all -> 0x034a }
            r1.c((int) r13)     // Catch:{ all -> 0x034a }
        L_0x0312:
            com.oppo.camera.gl.d r2 = r1.X     // Catch:{ all -> 0x034a }
            if (r2 == 0) goto L_0x033e
            com.oppo.camera.ui.preview.b r2 = r1.T     // Catch:{ all -> 0x034a }
            float r2 = r2.a()     // Catch:{ all -> 0x034a }
            r0.a((float) r2)     // Catch:{ all -> 0x034a }
            com.oppo.camera.gl.d r3 = r1.X     // Catch:{ all -> 0x034a }
            r2 = r23
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r2.a((com.oppo.camera.gl.c) r3, (int) r4, (int) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x034a }
            boolean r0 = r1.f3321a     // Catch:{ all -> 0x034a }
            if (r0 != 0) goto L_0x0338
            com.oppo.camera.ui.preview.e$b r0 = r1.o     // Catch:{ all -> 0x034a }
            r0.ab()     // Catch:{ all -> 0x034a }
            goto L_0x033b
        L_0x0338:
            super.i()     // Catch:{ all -> 0x034a }
        L_0x033b:
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            r0 = 1
            return r0
        L_0x033e:
            r13 = 1
            goto L_0x0342
        L_0x0340:
            r12 = r25
        L_0x0342:
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            if (r13 == 0) goto L_0x0348
            super.a((com.oppo.camera.gl.h) r23, (com.oppo.camera.ui.menu.levelcontrol.g) r24, (int) r25, (int) r26, (int) r27, (int) r28)
        L_0x0348:
            r0 = 1
            return r0
        L_0x034a:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x034a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.e.a(com.oppo.camera.gl.h, com.oppo.camera.ui.menu.levelcontrol.g, int, int, int, int):boolean");
    }

    private void a(h hVar, s sVar, s sVar2) {
        hVar.a(sVar2);
        hVar.a((com.oppo.camera.gl.c) sVar, 0, 0, sVar2.e(), sVar2.f());
        hVar.h();
    }

    private void a(h hVar) {
        if (this.j != null) {
            a(this.z);
            a(hVar, (com.oppo.camera.gl.g) this.j.get(0), this.U, this.z);
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        com.oppo.camera.e.a("CameraScreenNail.onFrameAvailable");
        z();
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            synchronized (this.h) {
                if (surfaceTexture != null) {
                    if (b() == surfaceTexture) {
                        this.w = surfaceTexture.getTimestamp();
                    }
                }
                com.oppo.camera.e.e("CameraScreenNail", "onFrameAvailable, surfaceTexture does not correspond.");
                com.oppo.camera.e.b("CameraScreenNail.onFrameAvailable");
                return;
            }
        }
        if (!this.L) {
            this.L = true;
        }
        if (!this.N) {
            com.oppo.camera.e.a("CameraStartupPerformance.onFirstFrameAvailable");
            this.N = true;
            com.oppo.camera.e.b("CameraStartupPerformance.onFirstFrameAvailable");
            com.oppo.camera.perf.a.c("launch_first_frame_available");
            com.oppo.camera.e.e("CameraScreenNail", "CameraTest First Frame available");
        }
        if (this.L) {
            int i = this.I;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.n.post(this.ah);
            } else {
                this.ah.run();
            }
            if (this.O) {
                this.o.ab();
            }
        }
        com.oppo.camera.e.b("CameraScreenNail.onFrameAvailable");
    }

    public void c(int i, int i2) {
        synchronized (this.h) {
            this.T.b(i, i2);
        }
    }

    public void l() {
        synchronized (this.h) {
            this.f3321a = true;
        }
    }

    public boolean s() {
        boolean z;
        synchronized (this.h) {
            z = this.f3321a && this.I == 0;
        }
        return z;
    }

    public boolean t() {
        boolean z;
        synchronized (this.h) {
            z = this.f3322b;
        }
        return z;
    }

    public void h(boolean z) {
        synchronized (this.h) {
            this.f3322b = z;
        }
    }

    public void i(boolean z) {
        synchronized (this.h) {
            this.c = z;
        }
    }

    public void j(boolean z) {
        synchronized (this.h) {
            this.d = z;
        }
    }

    public void u() {
        synchronized (this.h) {
            com.oppo.camera.e.a("CameraScreenNail", "noModeChangeTask");
            this.Q = false;
        }
    }

    public boolean v() {
        boolean z;
        synchronized (this.h) {
            z = this.Q;
        }
        return z;
    }

    public void w() {
        com.oppo.camera.e.a("CameraScreenNail", "forceRequestRender");
        Context context = this.R;
        if (context != null) {
            ((Activity) context).runOnUiThread(new Runnable() {
                public void run() {
                    synchronized (e.this.h) {
                        e.this.o.ab();
                    }
                }
            });
        }
    }

    public void k(boolean z) {
        synchronized (this.h) {
            if (!this.O && z) {
                this.O = z;
                if (this.O && this.L) {
                    this.o.ab();
                }
            }
            this.O = z;
            com.oppo.camera.e.b("CameraScreenNail", "setDrawFrame, mbDrawFrame: " + this.O);
        }
    }

    public void d(int i) {
        com.oppo.camera.e.b("CameraScreenNail", "setMultiVideoType, type: " + i);
        this.G.f(i);
    }

    public void l(boolean z) {
        com.oppo.camera.e.b("CameraScreenNail", "setMainOneCameraImplDraw, mainOneCameraImplDraw: " + z);
        this.G.a(z);
    }

    public void d(int i, int i2) {
        com.oppo.camera.e.b("CameraScreenNail", "setSmallSurfaceSize, width: " + i + ", height: " + i2);
        this.G.a(i, i2);
    }

    public Rect x() {
        return this.G.n();
    }

    public void e(int i, int i2) {
        com.oppo.camera.e.b("CameraScreenNail", "setSmallSurfacePosition, x: " + i + ", y: " + i2);
        this.G.d(i);
        this.G.e(i2);
    }

    private void z() {
        long nanoTime = System.nanoTime();
        long j = this.ae;
        if (j == 0) {
            this.ae = nanoTime;
        } else if (nanoTime - j > 1000000000) {
            com.oppo.camera.e.d("CameraScreenNail", "onFrameAvailableFps, fps: " + ((((double) this.af) * 1.0E9d) / ((double) (nanoTime - this.ae))));
            this.ae = nanoTime;
            this.af = 0;
        }
        this.af++;
    }

    public void e(int i) {
        synchronized (this.h) {
            if (1 == i) {
                if (this.D != null) {
                    com.oppo.camera.e.b("CameraScreenNail", "closeMultiImage cameraRole: " + i);
                    Image acquireLatestImage = this.D.acquireLatestImage();
                    if (acquireLatestImage != null) {
                        acquireLatestImage.close();
                    }
                    this.D = null;
                }
            } else if (this.E != null) {
                com.oppo.camera.e.b("CameraScreenNail", "closeMultiImage cameraRole: " + i);
                Image acquireLatestImage2 = this.E.acquireLatestImage();
                if (acquireLatestImage2 != null) {
                    acquireLatestImage2.close();
                }
                this.E = null;
            }
        }
    }
}
