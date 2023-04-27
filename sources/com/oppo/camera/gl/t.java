package com.oppo.camera.gl;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.opengl.Matrix;
import android.os.Handler;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.gl.b.f;
import com.oppo.camera.gl.b.h;
import com.oppo.camera.jni.PreviewShow;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.ui.preview.e;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: SurfaceTextureScreenNail */
public abstract class t implements SurfaceTexture.OnFrameAvailableListener {
    protected static final float[] e = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    protected static final float[] f = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    protected static final float[] g = {0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    protected int A;
    /* access modifiers changed from: protected */
    public boolean B;
    protected boolean C;
    protected ImageReader D;
    protected ImageReader E;
    /* access modifiers changed from: protected */
    public f F;
    protected h G;
    private final Object H;
    private SurfaceTexture I;
    private final float[] J;
    private volatile boolean K;
    private boolean L;
    private float M;
    private int N;
    private int O;
    private List<ApsResult.ImageBuffer> P;
    private ApsResult.ImageBuffer Q;
    private final Object R;
    private long S;
    private Image T;
    private Image U;
    private float[] V;
    private int W;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f3321a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f3322b;
    protected boolean c;
    protected boolean d;
    /* access modifiers changed from: protected */
    public final Object h;
    protected final Object i;
    protected ArrayList<g> j;
    protected s k;
    protected s l;
    /* access modifiers changed from: protected */
    public p m;
    protected Handler n;
    /* access modifiers changed from: protected */
    public e.b o;
    protected HashMap<String, a> p;
    protected n q;
    protected GLRootView r;
    protected int s;
    protected int t;
    protected boolean u;
    protected long v;
    protected long w;
    protected int x;
    protected boolean y;
    protected float[] z;

    /* compiled from: SurfaceTextureScreenNail */
    public static class a {
        public static String c = "capture_blur";
        public static String d = "capture_thumbnail";
        public static String e = "capture_exit";
        public boolean f = false;
        public boolean g = false;

        public void a(Bitmap bitmap) {
        }

        public void a(Bitmap bitmap, long j) {
        }

        public boolean a() {
            return false;
        }

        public int b() {
            return 0;
        }
    }

    public abstract int a(int i2, int i3, int i4);

    public abstract void h();

    public void l() {
    }

    public abstract void onFrameAvailable(SurfaceTexture surfaceTexture);

    public void a(int i2) {
        synchronized (this) {
            this.x = i2;
        }
    }

    public void a(a aVar, boolean z2, boolean z3, String str) {
        synchronized (this) {
            com.oppo.camera.e.a("SurfaceTextureScreenNail", "setCaptureOnePreviewCallback, cb: " + aVar + ", isEffect: " + z2 + ", needCheckTimestamp: " + z3 + ", type: " + str);
            aVar.f = z3;
            aVar.g = z2;
            synchronized (this.H) {
                this.p.put(str, aVar);
            }
            if (a.c.equals(str)) {
                a(1);
                this.o.ab();
            } else if (a.e.equals(str)) {
                this.o.ab();
            }
        }
    }

    public void a(String str) {
        synchronized (this.H) {
            if (this.p != null && this.p.containsKey(str)) {
                this.p.remove(str);
            }
        }
    }

    public t() {
        this.f3321a = false;
        this.f3322b = false;
        this.c = false;
        this.d = false;
        this.h = new Object();
        this.i = new Object();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = new Handler();
        this.o = null;
        this.p = new HashMap<>();
        this.q = null;
        this.r = null;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = new float[16];
        this.A = 90;
        this.B = false;
        this.C = false;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = new h();
        this.H = new Object();
        this.I = null;
        this.J = new float[16];
        this.K = false;
        this.L = false;
        this.M = 0.0f;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.Q = null;
        this.R = new Object();
        this.S = 0;
        this.T = null;
        this.U = null;
        this.V = new float[16];
        this.W = 1;
        this.W = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PREVIEW_BUFFER_CACHE_SUPPORT) ? 1 : 0;
    }

    public void a(n nVar) {
        this.q = nVar;
    }

    public void a(GLRootView gLRootView) {
        this.r = gLRootView;
        n nVar = this.q;
        if (nVar != null) {
            nVar.a(this.r);
        }
    }

    public void a(boolean z2) {
        synchronized (this) {
            this.L = z2;
        }
    }

    public float a() {
        n nVar = this.q;
        if (nVar == null || !nVar.l()) {
            return 1.0f;
        }
        return this.q.m();
    }

    public void b(boolean z2) {
        com.oppo.camera.e.a("SurfaceTextureScreenNail", "acquireSurfaceTexture");
        if (this.j == null) {
            g gVar = new g(36197);
            g gVar2 = new g(36197);
            g gVar3 = new g(36197);
            this.j = new ArrayList<>();
            this.j.add(gVar);
            this.j.add(gVar2);
            this.j.add(gVar3);
        }
        Iterator<g> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(this.s, this.t);
        }
        if (this.k == null) {
            this.k = new s(this.s, this.t, true);
        }
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            this.I = new SurfaceTexture(this.j.get(2).d());
            this.I.setOnFrameAvailableListener(this, this.n);
            try {
                this.I.detachFromGLContext();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        n nVar = this.q;
        if (nVar != null) {
            nVar.a(this);
            this.q.a(true);
        }
        synchronized (this) {
            this.K = true;
            c(z2);
        }
        long j2 = 0;
        this.w = 0;
        if (3 == AlgoSwitchConfig.getApsVersion()) {
            j2 = PreviewShow.init();
        }
        this.S = j2;
    }

    public void c(boolean z2) {
        char c2 = (z2 || Util.al()) ? (char) 4 : 5;
        synchronized (this.J) {
            Matrix.setIdentityM(this.J, 0);
            if ((c2 & 1) != 0) {
                Matrix.multiplyMM(this.J, 0, this.J, 0, e, 0);
            }
            if ((c2 & 4) != 0) {
                Matrix.multiplyMM(this.J, 0, this.J, 0, g, 0);
            }
            Matrix.multiplyMM(this.J, 0, f, 0, this.J, 0);
        }
    }

    public void b(int i2) {
        synchronized (this) {
            this.A = i2;
        }
        com.oppo.camera.e.a("SurfaceTextureScreenNail", "setDisplayOrientation, orientation: " + i2);
    }

    public SurfaceTexture b() {
        return this.I;
    }

    public void c() {
        com.oppo.camera.e.a("SurfaceTextureScreenNail", "releaseTextures");
        synchronized (this) {
            this.K = false;
            if (this.j != null) {
                Iterator<g> it = this.j.iterator();
                while (it.hasNext()) {
                    it.next().l();
                }
                this.j = null;
            }
            if (this.q != null) {
                this.q.a(false);
                this.q.g();
            }
            if (this.k != null) {
                this.k.l();
                this.k = null;
            }
            if (this.l != null) {
                this.l.l();
                this.l = null;
            }
            synchronized (this.R) {
                for (ApsResult.ImageBuffer next : this.P) {
                    if (next != null) {
                        next.close();
                    }
                }
                this.P.clear();
            }
            if (this.Q != null) {
                this.Q.close();
                this.Q = null;
            }
        }
        this.w = 0;
        long j2 = this.S;
        if (0 != j2) {
            PreviewShow.release(j2);
            this.S = 0;
        }
        n nVar = this.q;
        if (nVar != null) {
            nVar.a((t) null);
        }
    }

    public void d() {
        ArrayList<g> arrayList = this.j;
        if (arrayList != null) {
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this.s, this.t);
            }
        }
    }

    public void a(int i2, int i3) {
        com.oppo.camera.e.a("SurfaceTextureScreenNail", "setSize(), height: " + i3 + ", width: " + i2);
        this.s = i2;
        this.t = i3;
        synchronized (this.h) {
            if (this.k != null) {
                this.k.l();
                this.k = null;
            }
            this.k = new s(this.s, this.t, true);
        }
        n nVar = this.q;
        if (nVar != null) {
            nVar.b(i2, i3);
        }
    }

    public int e() {
        return this.s;
    }

    public int f() {
        return this.t;
    }

    public void a(h hVar, g gVar, s sVar, float[] fArr) {
        if (sVar != null) {
            int e2 = sVar.e();
            int f2 = sVar.f();
            hVar.a(sVar);
            hVar.a(0.0f, (float) f2);
            hVar.a(1.0f, -1.0f, 1.0f);
            hVar.a((c) gVar, fArr, 0, 0, e2, f2);
            hVar.h();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0119, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.oppo.camera.gl.h r14, int r15, int r16, int r17, int r18, int r19) {
        /*
            r13 = this;
            r1 = r13
            r0 = r14
            r10 = r17
            r11 = r18
            r2 = r19
            monitor-enter(r13)
            boolean r3 = r1.K     // Catch:{ all -> 0x011c }
            if (r3 == 0) goto L_0x011a
            int r3 = com.oppo.camera.aps.config.AlgoSwitchConfig.getApsVersion()     // Catch:{ all -> 0x011c }
            r4 = 2
            if (r3 != r4) goto L_0x001a
            android.graphics.SurfaceTexture r3 = r1.I     // Catch:{ all -> 0x011c }
            if (r3 != 0) goto L_0x001a
            goto L_0x011a
        L_0x001a:
            android.graphics.SurfaceTexture r3 = r1.I     // Catch:{ all -> 0x011c }
            r12 = 0
            if (r3 == 0) goto L_0x0030
            android.graphics.SurfaceTexture r3 = r1.I     // Catch:{ all -> 0x011c }
            java.util.ArrayList<com.oppo.camera.gl.g> r5 = r1.j     // Catch:{ all -> 0x011c }
            java.lang.Object r5 = r5.get(r12)     // Catch:{ all -> 0x011c }
            com.oppo.camera.gl.g r5 = (com.oppo.camera.gl.g) r5     // Catch:{ all -> 0x011c }
            int r5 = r5.d()     // Catch:{ all -> 0x011c }
            r3.attachToGLContext(r5)     // Catch:{ all -> 0x011c }
        L_0x0030:
            r14.a((int) r4)     // Catch:{ all -> 0x011c }
            int r3 = r14.d()     // Catch:{ all -> 0x011c }
            r1.N = r3     // Catch:{ all -> 0x011c }
            int r3 = r14.e()     // Catch:{ all -> 0x011c }
            r1.O = r3     // Catch:{ all -> 0x011c }
            r14.a((int) r10, (int) r11)     // Catch:{ all -> 0x011c }
            int r3 = r10 / 2
            int r3 = r3 + r15
            int r5 = r11 / 2
            int r5 = r16 + r5
            float r6 = (float) r3     // Catch:{ all -> 0x011c }
            float r7 = (float) r5     // Catch:{ all -> 0x011c }
            r14.a((float) r6, (float) r7)     // Catch:{ all -> 0x011c }
            boolean r6 = r1.L     // Catch:{ all -> 0x011c }
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x0072
            float r6 = r1.M     // Catch:{ all -> 0x011c }
            r9 = 0
            float r6 = r6 - r9
            r9 = 981668463(0x3a83126f, float:0.001)
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x0069
            java.lang.String r6 = "com.oplus.tunning.video.eis.preview.scale"
            float r6 = com.oppo.camera.aps.config.CameraConfig.getConfigFloatValue(r6)     // Catch:{ all -> 0x011c }
            r1.M = r6     // Catch:{ all -> 0x011c }
        L_0x0069:
            float r6 = r1.M     // Catch:{ all -> 0x011c }
            float r9 = r1.M     // Catch:{ all -> 0x011c }
            float r9 = -r9
            r14.a((float) r6, (float) r9, (float) r8)     // Catch:{ all -> 0x011c }
            goto L_0x0075
        L_0x0072:
            r14.a((float) r8, (float) r7, (float) r8)     // Catch:{ all -> 0x011c }
        L_0x0075:
            r6 = 1
            if (r2 != r6) goto L_0x007c
            r14.a((float) r7, (float) r8, (float) r8)     // Catch:{ all -> 0x011c }
            goto L_0x0081
        L_0x007c:
            if (r2 != r4) goto L_0x0081
            r14.a((float) r8, (float) r7, (float) r8)     // Catch:{ all -> 0x011c }
        L_0x0081:
            int r2 = -r3
            float r2 = (float) r2     // Catch:{ all -> 0x011c }
            int r3 = -r5
            float r3 = (float) r3     // Catch:{ all -> 0x011c }
            r14.a((float) r2, (float) r3)     // Catch:{ all -> 0x011c }
            android.graphics.SurfaceTexture r2 = r1.I     // Catch:{ all -> 0x011c }
            if (r2 == 0) goto L_0x0091
            android.graphics.SurfaceTexture r2 = r1.I     // Catch:{ all -> 0x011c }
            r2.updateTexImage()     // Catch:{ all -> 0x011c }
        L_0x0091:
            float[] r2 = r1.z     // Catch:{ all -> 0x011c }
            r13.a((float[]) r2)     // Catch:{ all -> 0x011c }
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x011c }
            float[] r3 = r1.z     // Catch:{ all -> 0x011c }
            r2.a((float[]) r3)     // Catch:{ all -> 0x011c }
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x011c }
            if (r2 == 0) goto L_0x00d6
            boolean r2 = r1.B     // Catch:{ all -> 0x011c }
            if (r2 == 0) goto L_0x00d6
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x011c }
            com.oppo.camera.gl.b.f r4 = r1.F     // Catch:{ all -> 0x011c }
            com.oppo.camera.gl.b.f r3 = r1.F     // Catch:{ all -> 0x011c }
            com.oppo.camera.gl.s r5 = r3.f()     // Catch:{ all -> 0x011c }
            r3 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            boolean r2 = r2.a((com.oppo.camera.gl.h) r3, (com.oppo.camera.gl.b.f) r4, (com.oppo.camera.gl.s) r5, (int) r6, (int) r7, (int) r8, (int) r9)     // Catch:{ all -> 0x011c }
            if (r2 != 0) goto L_0x0105
            float[] r2 = r1.V     // Catch:{ all -> 0x011c }
            android.opengl.Matrix.setIdentityM(r2, r12)     // Catch:{ all -> 0x011c }
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x011c }
            com.oppo.camera.gl.s r3 = r2.f()     // Catch:{ all -> 0x011c }
            float[] r4 = r1.V     // Catch:{ all -> 0x011c }
            r2 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r2.a((com.oppo.camera.gl.c) r3, (float[]) r4, (int) r5, (int) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x011c }
            goto L_0x0105
        L_0x00d6:
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x011c }
            java.util.ArrayList<com.oppo.camera.gl.g> r3 = r1.j     // Catch:{ all -> 0x011c }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ all -> 0x011c }
            r4 = r3
            com.oppo.camera.gl.g r4 = (com.oppo.camera.gl.g) r4     // Catch:{ all -> 0x011c }
            r3 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            boolean r2 = r2.a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x011c }
            if (r2 != 0) goto L_0x0105
            java.util.ArrayList<com.oppo.camera.gl.g> r2 = r1.j     // Catch:{ all -> 0x011c }
            java.lang.Object r2 = r2.get(r12)     // Catch:{ all -> 0x011c }
            r3 = r2
            com.oppo.camera.gl.c r3 = (com.oppo.camera.gl.c) r3     // Catch:{ all -> 0x011c }
            float[] r4 = r1.z     // Catch:{ all -> 0x011c }
            r2 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r2.a((com.oppo.camera.gl.c) r3, (float[]) r4, (int) r5, (int) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x011c }
        L_0x0105:
            int r2 = r1.N     // Catch:{ all -> 0x011c }
            int r3 = r1.O     // Catch:{ all -> 0x011c }
            r14.a((int) r2, (int) r3)     // Catch:{ all -> 0x011c }
            r14.f()     // Catch:{ all -> 0x011c }
            android.graphics.SurfaceTexture r0 = r1.I     // Catch:{ all -> 0x011c }
            if (r0 == 0) goto L_0x0118
            android.graphics.SurfaceTexture r0 = r1.I     // Catch:{ all -> 0x011c }
            r0.detachFromGLContext()     // Catch:{ all -> 0x011c }
        L_0x0118:
            monitor-exit(r13)     // Catch:{ all -> 0x011c }
            return
        L_0x011a:
            monitor-exit(r13)     // Catch:{ all -> 0x011c }
            return
        L_0x011c:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x011c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.t.a(com.oppo.camera.gl.h, int, int, int, int, int):void");
    }

    private boolean m() {
        HashMap<String, a> hashMap;
        boolean z2;
        boolean z3;
        synchronized (this.H) {
            hashMap = this.p;
        }
        if (hashMap.containsKey(a.d)) {
            a aVar = hashMap.get(a.d);
            synchronized (this.i) {
                z3 = this.v > 0 && this.w >= this.v;
                com.oppo.camera.e.e("SurfaceTextureScreenNail", "needCaptureThumb, mPreviewTimestamp: " + this.w + ", mCaptureTimestamp: " + this.v + ", timeStampMatched: " + z3 + ", size: " + hashMap.size());
            }
            if (!aVar.f || z3) {
                z2 = true;
                if (this.k != null || !z2) {
                    return false;
                }
                return true;
            }
        }
        z2 = false;
        if (this.k != null) {
        }
        return false;
    }

    private boolean b(String str) {
        boolean z2;
        synchronized (this.H) {
            z2 = this.k != null && this.p.containsKey(str);
        }
        return z2;
    }

    public boolean g() {
        return this.u;
    }

    public void d(boolean z2) {
        this.u = z2;
    }

    private void a(String str, h hVar) {
        HashMap<String, a> hashMap;
        long j2;
        com.oppo.camera.e.a("CameraCapturePerformance.capturePreview");
        if (!this.k.k()) {
            this.k.c(hVar);
        }
        synchronized (this.H) {
            hashMap = this.p;
        }
        a aVar = hashMap.get(str);
        Bitmap bitmap = null;
        long currentTimeMillis = System.currentTimeMillis();
        int g2 = this.k.g();
        int h2 = this.k.h();
        long j3 = 0;
        if (a.c.equals(str)) {
            a(this.z);
            a(hVar, this.j.get(0), this.k, this.z);
            bitmap = Util.b(this.k.d(), g2, h2);
        } else if (a.d.equals(str)) {
            this.q.a(hVar, this.j.get(0), this.k);
            this.m.a(g2, h2, aVar.b(), aVar.a());
            aVar.a(this.m.a(this.k.d(), g2, h2));
            bitmap = Util.b(this.k.d(), g2, h2);
            synchronized (this.i) {
                j2 = aVar.f ? this.v : 0;
                this.v = 0;
            }
            j3 = j2;
        } else if (a.e.equals(str)) {
            int i2 = g2 / 20;
            int i3 = h2 / 20;
            this.q.a(hVar, this.j.get(0), this.k);
            synchronized (this) {
                if (this.F != null && this.B) {
                    float[] fArr = new float[16];
                    Matrix.setIdentityM(fArr, 0);
                    a(hVar, (c) this.F.f(), this.k, fArr);
                }
            }
            Bitmap b2 = Util.b(a(this.k.d(), i2, i3), i2, i3);
            h();
            aVar.a(b2, 0);
            d(true);
            synchronized (this.H) {
                this.p.remove(a.e);
            }
        } else if (Util.a()) {
            this.q.a(hVar, this.j.get(0), this.k);
            Util.a(this.k.d(), this.k.g(), this.k.h(), AlgoSwitchConfig.APS_PIPELINE_PREVIEW);
        }
        if (!(aVar == null || bitmap == null)) {
            aVar.a(bitmap, j3);
            synchronized (this.H) {
                this.p.remove(str);
            }
        }
        com.oppo.camera.e.a("SurfaceTextureScreenNail", "capturePreview, dump bitmap use time: " + (System.currentTimeMillis() - currentTimeMillis) + ", timeStamp: " + j3);
        com.oppo.camera.e.b("CameraCapturePerformance.capturePreview");
    }

    public void a(ApsResult.ImageBuffer imageBuffer, boolean z2) {
        if (this.w == 0) {
            com.oppo.camera.e.a("SurfaceTextureScreenNail", "addImageBuffer, imageBuffer: " + imageBuffer);
        }
        synchronized (this.R) {
            if (z2) {
                for (ApsResult.ImageBuffer next : this.P) {
                    if (next != null) {
                        next.close();
                    }
                }
                this.P.clear();
            }
            if (this.P.size() > this.W) {
                ApsResult.ImageBuffer imageBuffer2 = this.P.get(0);
                if (this.v != imageBuffer2.getTimestamp()) {
                    com.oppo.camera.e.e("SurfaceTextureScreenNail", "addImage, remove image: " + imageBuffer2.getTimestamp());
                    this.P.remove(0);
                    imageBuffer2.close();
                }
            }
            this.P.add(imageBuffer);
        }
        onFrameAvailable((SurfaceTexture) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a7, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03ab, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.oppo.camera.gl.h r21, com.oppo.camera.ui.menu.levelcontrol.g r22, int r23, int r24, int r25, int r26) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            int r3 = com.oppo.camera.aps.config.AlgoSwitchConfig.getApsVersion()
            r11 = 0
            r12 = 0
            r4 = 3
            if (r4 != r3) goto L_0x0043
            if (r2 != 0) goto L_0x0043
            java.lang.Object r3 = r1.R
            monitor-enter(r3)
            java.util.List<com.oppo.camera.aps.adapter.ApsResult$ImageBuffer> r4 = r1.P     // Catch:{ all -> 0x0040 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0040 }
            if (r4 != 0) goto L_0x002b
            java.util.List<com.oppo.camera.aps.adapter.ApsResult$ImageBuffer> r4 = r1.P     // Catch:{ all -> 0x0040 }
            java.lang.Object r4 = r4.remove(r12)     // Catch:{ all -> 0x0040 }
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r4 = (com.oppo.camera.aps.adapter.ApsResult.ImageBuffer) r4     // Catch:{ all -> 0x0040 }
            long r5 = r4.getTimestamp()     // Catch:{ all -> 0x0040 }
            r1.w = r5     // Catch:{ all -> 0x0040 }
            goto L_0x002c
        L_0x002b:
            r4 = r11
        L_0x002c:
            monitor-exit(r3)     // Catch:{ all -> 0x0040 }
            monitor-enter(r20)
            if (r4 == 0) goto L_0x003b
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r3 = r1.Q     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x0039
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r3 = r1.Q     // Catch:{ all -> 0x003d }
            r3.close()     // Catch:{ all -> 0x003d }
        L_0x0039:
            r1.Q = r4     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r20)     // Catch:{ all -> 0x003d }
            goto L_0x0043
        L_0x003d:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x003d }
            throw r0
        L_0x0040:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0040 }
            throw r0
        L_0x0043:
            monitor-enter(r20)
            java.util.ArrayList<com.oppo.camera.gl.g> r3 = r1.j     // Catch:{ all -> 0x03ac }
            if (r3 != 0) goto L_0x004a
            monitor-exit(r20)     // Catch:{ all -> 0x03ac }
            return r12
        L_0x004a:
            com.oppo.camera.statistics.model.PerformanceMsgData.getRealtimeFrameRate()     // Catch:{ all -> 0x03ac }
            boolean r3 = r1.K     // Catch:{ all -> 0x03ac }
            if (r3 != 0) goto L_0x0053
            monitor-exit(r20)     // Catch:{ all -> 0x03ac }
            return r12
        L_0x0053:
            r3 = 36197(0x8d65, float:5.0723E-41)
            r13 = 1
            if (r2 == 0) goto L_0x00b6
            android.graphics.SurfaceTexture r0 = r1.I     // Catch:{ all -> 0x03ac }
            if (r0 == 0) goto L_0x006e
            android.graphics.SurfaceTexture r0 = r1.I     // Catch:{ all -> 0x03ac }
            java.util.ArrayList<com.oppo.camera.gl.g> r4 = r1.j     // Catch:{ all -> 0x03ac }
            java.lang.Object r4 = r4.get(r13)     // Catch:{ all -> 0x03ac }
            com.oppo.camera.gl.g r4 = (com.oppo.camera.gl.g) r4     // Catch:{ all -> 0x03ac }
            int r4 = r4.d()     // Catch:{ all -> 0x03ac }
            r0.attachToGLContext(r4)     // Catch:{ all -> 0x03ac }
        L_0x006e:
            java.lang.Object r4 = r1.h     // Catch:{ all -> 0x03ac }
            monitor-enter(r4)     // Catch:{ all -> 0x03ac }
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r0 = r1.Q     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0098
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r0 = r1.Q     // Catch:{ all -> 0x00b3 }
            android.hardware.HardwareBuffer r0 = r0.getHardwareBuffer()     // Catch:{ all -> 0x00b3 }
            boolean r0 = r0.isClosed()     // Catch:{ all -> 0x00b3 }
            if (r0 != 0) goto L_0x0098
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r0 = r1.Q     // Catch:{ all -> 0x00b3 }
            android.hardware.HardwareBuffer r0 = r0.getHardwareBuffer()     // Catch:{ all -> 0x00b3 }
            java.util.ArrayList<com.oppo.camera.gl.g> r5 = r1.j     // Catch:{ all -> 0x00b3 }
            java.lang.Object r5 = r5.get(r13)     // Catch:{ all -> 0x00b3 }
            com.oppo.camera.gl.g r5 = (com.oppo.camera.gl.g) r5     // Catch:{ all -> 0x00b3 }
            int r5 = r5.d()     // Catch:{ all -> 0x00b3 }
            long r6 = r1.S     // Catch:{ all -> 0x00b3 }
            com.oppo.camera.jni.PreviewShow.process(r0, r3, r5, r6)     // Catch:{ all -> 0x00b3 }
        L_0x0098:
            java.util.ArrayList<com.oppo.camera.gl.g> r0 = r1.j     // Catch:{ all -> 0x00b3 }
            java.lang.Object r0 = r0.get(r13)     // Catch:{ all -> 0x00b3 }
            com.oppo.camera.gl.g r0 = (com.oppo.camera.gl.g) r0     // Catch:{ all -> 0x00b3 }
            int r0 = r0.d()     // Catch:{ all -> 0x00b3 }
            r2.b((int) r0)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r4)     // Catch:{ all -> 0x00b3 }
            android.graphics.SurfaceTexture r0 = r1.I     // Catch:{ all -> 0x03ac }
            if (r0 == 0) goto L_0x03aa
            android.graphics.SurfaceTexture r0 = r1.I     // Catch:{ all -> 0x03ac }
            r0.detachFromGLContext()     // Catch:{ all -> 0x03ac }
            goto L_0x03aa
        L_0x00b3:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b3 }
            throw r0     // Catch:{ all -> 0x03ac }
        L_0x00b6:
            if (r0 == 0) goto L_0x03aa
            java.lang.String r2 = "Surfacetexture.draw"
            com.oppo.camera.e.a((java.lang.String) r2)     // Catch:{ all -> 0x03ac }
            android.graphics.SurfaceTexture r2 = r1.I     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x00d2
            android.graphics.SurfaceTexture r2 = r1.I     // Catch:{ all -> 0x03ac }
            java.util.ArrayList<com.oppo.camera.gl.g> r4 = r1.j     // Catch:{ all -> 0x03ac }
            java.lang.Object r4 = r4.get(r12)     // Catch:{ all -> 0x03ac }
            com.oppo.camera.gl.g r4 = (com.oppo.camera.gl.g) r4     // Catch:{ all -> 0x03ac }
            int r4 = r4.d()     // Catch:{ all -> 0x03ac }
            r2.attachToGLContext(r4)     // Catch:{ all -> 0x03ac }
        L_0x00d2:
            r2 = 2
            r0.a((int) r2)     // Catch:{ all -> 0x03ac }
            int r4 = r25 / 2
            int r4 = r23 + r4
            int r5 = r26 / 2
            int r5 = r24 + r5
            float r6 = (float) r4     // Catch:{ all -> 0x03ac }
            float r7 = (float) r5     // Catch:{ all -> 0x03ac }
            r0.a((float) r6, (float) r7)     // Catch:{ all -> 0x03ac }
            boolean r6 = r1.L     // Catch:{ all -> 0x03ac }
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x0105
            float r6 = r1.M     // Catch:{ all -> 0x03ac }
            float r6 = r6 - r7
            r9 = 981668463(0x3a83126f, float:0.001)
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x00fc
            java.lang.String r6 = "com.oplus.tunning.video.eis.preview.scale"
            float r6 = com.oppo.camera.aps.config.CameraConfig.getConfigFloatValue(r6)     // Catch:{ all -> 0x03ac }
            r1.M = r6     // Catch:{ all -> 0x03ac }
        L_0x00fc:
            float r6 = r1.M     // Catch:{ all -> 0x03ac }
            float r9 = r1.M     // Catch:{ all -> 0x03ac }
            float r9 = -r9
            r0.a((float) r6, (float) r9, (float) r8)     // Catch:{ all -> 0x03ac }
            goto L_0x0123
        L_0x0105:
            com.oppo.camera.ui.preview.a.n r6 = r1.q     // Catch:{ all -> 0x03ac }
            boolean r6 = r6.l()     // Catch:{ all -> 0x03ac }
            if (r6 == 0) goto L_0x011e
            com.oppo.camera.ui.preview.a.n r6 = r1.q     // Catch:{ all -> 0x03ac }
            float r6 = r6.m()     // Catch:{ all -> 0x03ac }
            com.oppo.camera.ui.preview.a.n r9 = r1.q     // Catch:{ all -> 0x03ac }
            float r9 = r9.n()     // Catch:{ all -> 0x03ac }
            float r9 = -r9
            r0.a((float) r6, (float) r9, (float) r8)     // Catch:{ all -> 0x03ac }
            goto L_0x0123
        L_0x011e:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0.a((float) r8, (float) r6, (float) r8)     // Catch:{ all -> 0x03ac }
        L_0x0123:
            int r6 = r1.A     // Catch:{ all -> 0x03ac }
            r9 = 90
            if (r6 == r9) goto L_0x0134
            int r6 = r1.A     // Catch:{ all -> 0x03ac }
            int r6 = r6 - r9
            int r6 = r6 + 360
            int r6 = r6 % 360
            float r6 = (float) r6     // Catch:{ all -> 0x03ac }
            r0.a(r6, r7, r7, r8)     // Catch:{ all -> 0x03ac }
        L_0x0134:
            int r4 = -r4
            float r4 = (float) r4     // Catch:{ all -> 0x03ac }
            int r5 = -r5
            float r5 = (float) r5     // Catch:{ all -> 0x03ac }
            r0.a((float) r4, (float) r5)     // Catch:{ all -> 0x03ac }
            android.graphics.SurfaceTexture r4 = r1.I     // Catch:{ all -> 0x03ac }
            if (r4 == 0) goto L_0x0144
            android.graphics.SurfaceTexture r4 = r1.I     // Catch:{ all -> 0x03ac }
            r4.updateTexImage()     // Catch:{ all -> 0x03ac }
        L_0x0144:
            float[] r4 = r1.z     // Catch:{ all -> 0x03ac }
            r1.a((float[]) r4)     // Catch:{ all -> 0x03ac }
            int r4 = com.oppo.camera.aps.config.AlgoSwitchConfig.getApsVersion()     // Catch:{ all -> 0x03ac }
            if (r2 != r4) goto L_0x0157
            android.graphics.SurfaceTexture r2 = r1.I     // Catch:{ all -> 0x03ac }
            long r4 = r2.getTimestamp()     // Catch:{ all -> 0x03ac }
            r1.w = r4     // Catch:{ all -> 0x03ac }
        L_0x0157:
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x03ac }
            long r4 = r1.w     // Catch:{ all -> 0x03ac }
            r2.b((long) r4)     // Catch:{ all -> 0x03ac }
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x03ac }
            float[] r4 = r1.z     // Catch:{ all -> 0x03ac }
            r2.a((float[]) r4)     // Catch:{ all -> 0x03ac }
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x02ce
            boolean r2 = r1.B     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x02ce
            java.lang.Object r14 = r1.h     // Catch:{ all -> 0x03ac }
            monitor-enter(r14)     // Catch:{ all -> 0x03ac }
            android.media.ImageReader r2 = r1.D     // Catch:{ all -> 0x02cb }
            r4 = 16
            if (r2 == 0) goto L_0x02a8
            android.media.ImageReader r2 = r1.E     // Catch:{ all -> 0x02cb }
            if (r2 == 0) goto L_0x02a8
            android.media.ImageReader r2 = r1.D     // Catch:{ all -> 0x02cb }
            android.media.Image r15 = r2.acquireLatestImage()     // Catch:{ all -> 0x02cb }
            android.media.ImageReader r2 = r1.E     // Catch:{ all -> 0x02cb }
            android.media.Image r10 = r2.acquireLatestImage()     // Catch:{ all -> 0x02cb }
            boolean r2 = r1.B     // Catch:{ all -> 0x02cb }
            r1.f(r2)     // Catch:{ all -> 0x02cb }
            if (r15 == 0) goto L_0x0198
            android.media.Image r2 = r1.T     // Catch:{ all -> 0x02cb }
            if (r2 == 0) goto L_0x0196
            android.media.Image r2 = r1.T     // Catch:{ all -> 0x02cb }
            r2.close()     // Catch:{ all -> 0x02cb }
        L_0x0196:
            r1.T = r15     // Catch:{ all -> 0x02cb }
        L_0x0198:
            if (r10 == 0) goto L_0x01a5
            android.media.Image r2 = r1.U     // Catch:{ all -> 0x02cb }
            if (r2 == 0) goto L_0x01a3
            android.media.Image r2 = r1.U     // Catch:{ all -> 0x02cb }
            r2.close()     // Catch:{ all -> 0x02cb }
        L_0x01a3:
            r1.U = r10     // Catch:{ all -> 0x02cb }
        L_0x01a5:
            if (r15 == 0) goto L_0x0275
            if (r10 != 0) goto L_0x01ab
            goto L_0x0275
        L_0x01ab:
            android.hardware.HardwareBuffer r2 = r15.getHardwareBuffer()     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r4 = r1.F     // Catch:{ all -> 0x02cb }
            int r4 = r4.c()     // Catch:{ all -> 0x02cb }
            long r5 = r1.S     // Catch:{ all -> 0x02cb }
            com.oppo.camera.jni.PreviewShow.process(r2, r3, r4, r5)     // Catch:{ all -> 0x02cb }
            android.hardware.HardwareBuffer r2 = r10.getHardwareBuffer()     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r4 = r1.F     // Catch:{ all -> 0x02cb }
            int r4 = r4.d()     // Catch:{ all -> 0x02cb }
            long r5 = r1.S     // Catch:{ all -> 0x02cb }
            com.oppo.camera.jni.PreviewShow.process(r2, r3, r4, r5)     // Catch:{ all -> 0x02cb }
            android.util.Size r9 = new android.util.Size     // Catch:{ all -> 0x02cb }
            android.media.ImageReader r2 = r1.E     // Catch:{ all -> 0x02cb }
            int r2 = r2.getWidth()     // Catch:{ all -> 0x02cb }
            android.media.ImageReader r3 = r1.E     // Catch:{ all -> 0x02cb }
            int r3 = r3.getHeight()     // Catch:{ all -> 0x02cb }
            r9.<init>(r2, r3)     // Catch:{ all -> 0x02cb }
            android.util.Size r8 = new android.util.Size     // Catch:{ all -> 0x02cb }
            android.media.ImageReader r2 = r1.D     // Catch:{ all -> 0x02cb }
            int r2 = r2.getWidth()     // Catch:{ all -> 0x02cb }
            android.media.ImageReader r3 = r1.D     // Catch:{ all -> 0x02cb }
            int r3 = r3.getHeight()     // Catch:{ all -> 0x02cb }
            r8.<init>(r2, r3)     // Catch:{ all -> 0x02cb }
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x02cb }
            long r3 = r10.getTimestamp()     // Catch:{ all -> 0x02cb }
            r2.b((long) r3)     // Catch:{ all -> 0x02cb }
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r3 = r1.F     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.g r4 = r3.e()     // Catch:{ all -> 0x02cb }
            int r7 = r1.x     // Catch:{ all -> 0x02cb }
            r3 = r21
            r5 = r23
            r6 = r24
            r16 = r7
            r7 = r25
            r17 = r8
            r8 = r26
            r18 = r9
            r9 = r16
            boolean r2 = r2.a((com.oppo.camera.gl.h) r3, (com.oppo.camera.gl.g) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9)     // Catch:{ all -> 0x02cb }
            if (r2 == 0) goto L_0x0246
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x02cb }
            r3 = 4
            com.oppo.camera.ui.preview.a.s r2 = r2.i((int) r3)     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.s r2 = r2.g()     // Catch:{ all -> 0x02cb }
            int r4 = r2.d()     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r3 = r1.F     // Catch:{ all -> 0x02cb }
            int r5 = r3.c()     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.h r3 = r1.G     // Catch:{ all -> 0x02cb }
            int r8 = r3.l()     // Catch:{ all -> 0x02cb }
            r9 = 1
            com.oppo.camera.gl.b.h r7 = r1.G     // Catch:{ all -> 0x02cb }
            r3 = r21
            r6 = r18
            r16 = r7
            r7 = r17
            r19 = r10
            r10 = r16
            r2.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x02cb }
            goto L_0x0268
        L_0x0246:
            r19 = r10
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r3 = r1.F     // Catch:{ all -> 0x02cb }
            int r4 = r3.d()     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r3 = r1.F     // Catch:{ all -> 0x02cb }
            int r5 = r3.c()     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.h r3 = r1.G     // Catch:{ all -> 0x02cb }
            int r8 = r3.l()     // Catch:{ all -> 0x02cb }
            r9 = 0
            com.oppo.camera.gl.b.h r10 = r1.G     // Catch:{ all -> 0x02cb }
            r3 = r21
            r6 = r18
            r7 = r17
            r2.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x02cb }
        L_0x0268:
            r15.close()     // Catch:{ all -> 0x02cb }
            r19.close()     // Catch:{ all -> 0x02cb }
            r1.D = r11     // Catch:{ all -> 0x02cb }
            r1.E = r11     // Catch:{ all -> 0x02cb }
            r1.f3322b = r13     // Catch:{ all -> 0x02cb }
            goto L_0x02c8
        L_0x0275:
            r19 = r10
            if (r15 == 0) goto L_0x027c
            r15.close()     // Catch:{ all -> 0x02cb }
        L_0x027c:
            if (r19 == 0) goto L_0x0281
            r19.close()     // Catch:{ all -> 0x02cb }
        L_0x0281:
            r1.D = r11     // Catch:{ all -> 0x02cb }
            r1.E = r11     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.s r2 = r2.f()     // Catch:{ all -> 0x02cb }
            if (r2 == 0) goto L_0x02a5
            float[] r4 = new float[r4]     // Catch:{ all -> 0x02cb }
            android.opengl.Matrix.setIdentityM(r4, r12)     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.s r3 = r2.f()     // Catch:{ all -> 0x02cb }
            r2 = r21
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r2.a((com.oppo.camera.gl.c) r3, (float[]) r4, (int) r5, (int) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x02cb }
        L_0x02a5:
            monitor-exit(r14)     // Catch:{ all -> 0x02cb }
            monitor-exit(r20)     // Catch:{ all -> 0x03ac }
            return r12
        L_0x02a8:
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.s r2 = r2.f()     // Catch:{ all -> 0x02cb }
            if (r2 == 0) goto L_0x02c8
            float[] r4 = new float[r4]     // Catch:{ all -> 0x02cb }
            android.opengl.Matrix.setIdentityM(r4, r12)     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.b.f r2 = r1.F     // Catch:{ all -> 0x02cb }
            com.oppo.camera.gl.s r3 = r2.f()     // Catch:{ all -> 0x02cb }
            r2 = r21
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r2.a((com.oppo.camera.gl.c) r3, (float[]) r4, (int) r5, (int) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x02cb }
        L_0x02c8:
            monitor-exit(r14)     // Catch:{ all -> 0x02cb }
            goto L_0x034b
        L_0x02cb:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x02cb }
            throw r0     // Catch:{ all -> 0x03ac }
        L_0x02ce:
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r2 = r1.Q     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x02f5
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r2 = r1.Q     // Catch:{ all -> 0x03ac }
            android.hardware.HardwareBuffer r2 = r2.getHardwareBuffer()     // Catch:{ all -> 0x03ac }
            boolean r2 = r2.isClosed()     // Catch:{ all -> 0x03ac }
            if (r2 != 0) goto L_0x02f5
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r2 = r1.Q     // Catch:{ all -> 0x03ac }
            android.hardware.HardwareBuffer r2 = r2.getHardwareBuffer()     // Catch:{ all -> 0x03ac }
            java.util.ArrayList<com.oppo.camera.gl.g> r4 = r1.j     // Catch:{ all -> 0x03ac }
            java.lang.Object r4 = r4.get(r12)     // Catch:{ all -> 0x03ac }
            com.oppo.camera.gl.g r4 = (com.oppo.camera.gl.g) r4     // Catch:{ all -> 0x03ac }
            int r4 = r4.d()     // Catch:{ all -> 0x03ac }
            long r5 = r1.S     // Catch:{ all -> 0x03ac }
            com.oppo.camera.jni.PreviewShow.process(r2, r3, r4, r5)     // Catch:{ all -> 0x03ac }
        L_0x02f5:
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x03ac }
            java.util.ArrayList<com.oppo.camera.gl.g> r3 = r1.j     // Catch:{ all -> 0x03ac }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ all -> 0x03ac }
            r4 = r3
            com.oppo.camera.gl.g r4 = (com.oppo.camera.gl.g) r4     // Catch:{ all -> 0x03ac }
            int r9 = r1.x     // Catch:{ all -> 0x03ac }
            com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r10 = r1.Q     // Catch:{ all -> 0x03ac }
            r3 = r21
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            boolean r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x0324
            boolean r2 = r1.y     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x034b
            boolean r2 = r20.m()     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x034b
            java.lang.String r2 = com.oppo.camera.gl.t.a.d     // Catch:{ all -> 0x03ac }
            r1.a((java.lang.String) r2, (com.oppo.camera.gl.h) r0)     // Catch:{ all -> 0x03ac }
            goto L_0x034b
        L_0x0324:
            boolean r2 = r1.y     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x0333
            boolean r2 = r20.m()     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x0333
            java.lang.String r2 = com.oppo.camera.gl.t.a.d     // Catch:{ all -> 0x03ac }
            r1.a((java.lang.String) r2, (com.oppo.camera.gl.h) r0)     // Catch:{ all -> 0x03ac }
        L_0x0333:
            java.util.ArrayList<com.oppo.camera.gl.g> r2 = r1.j     // Catch:{ all -> 0x03ac }
            java.lang.Object r2 = r2.get(r12)     // Catch:{ all -> 0x03ac }
            r3 = r2
            com.oppo.camera.gl.c r3 = (com.oppo.camera.gl.c) r3     // Catch:{ all -> 0x03ac }
            float[] r4 = r1.z     // Catch:{ all -> 0x03ac }
            r2 = r21
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r2.a((com.oppo.camera.gl.c) r3, (float[]) r4, (int) r5, (int) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x03ac }
        L_0x034b:
            r1.a((int) r12)     // Catch:{ all -> 0x03ac }
            boolean r2 = r1.y     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x035a
            boolean r2 = com.oppo.camera.util.Util.a()     // Catch:{ all -> 0x03ac }
            if (r2 == 0) goto L_0x035a
            r2 = r13
            goto L_0x035b
        L_0x035a:
            r2 = r12
        L_0x035b:
            boolean r3 = r1.y     // Catch:{ all -> 0x03ac }
            if (r3 == 0) goto L_0x0369
            java.lang.String r3 = com.oppo.camera.gl.t.a.c     // Catch:{ all -> 0x03ac }
            boolean r3 = r1.b((java.lang.String) r3)     // Catch:{ all -> 0x03ac }
            if (r3 == 0) goto L_0x0369
            r3 = r13
            goto L_0x036a
        L_0x0369:
            r3 = r12
        L_0x036a:
            boolean r4 = r1.y     // Catch:{ all -> 0x03ac }
            if (r4 == 0) goto L_0x0377
            java.lang.String r4 = com.oppo.camera.gl.t.a.e     // Catch:{ all -> 0x03ac }
            boolean r4 = r1.b((java.lang.String) r4)     // Catch:{ all -> 0x03ac }
            if (r4 == 0) goto L_0x0377
            r12 = r13
        L_0x0377:
            if (r2 == 0) goto L_0x037c
            r1.a((java.lang.String) r11, (com.oppo.camera.gl.h) r0)     // Catch:{ all -> 0x03ac }
        L_0x037c:
            if (r3 == 0) goto L_0x0383
            java.lang.String r2 = com.oppo.camera.gl.t.a.c     // Catch:{ all -> 0x03ac }
            r1.a((java.lang.String) r2, (com.oppo.camera.gl.h) r0)     // Catch:{ all -> 0x03ac }
        L_0x0383:
            if (r12 == 0) goto L_0x038a
            java.lang.String r2 = com.oppo.camera.gl.t.a.e     // Catch:{ all -> 0x03ac }
            r1.a((java.lang.String) r2, (com.oppo.camera.gl.h) r0)     // Catch:{ all -> 0x03ac }
        L_0x038a:
            r21.f()     // Catch:{ all -> 0x03ac }
            com.oppo.camera.ui.preview.a.n r2 = r1.q     // Catch:{ all -> 0x03ac }
            r3 = r21
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r2.a(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x03ac }
            android.graphics.SurfaceTexture r0 = r1.I     // Catch:{ all -> 0x03ac }
            if (r0 == 0) goto L_0x03a5
            android.graphics.SurfaceTexture r0 = r1.I     // Catch:{ all -> 0x03ac }
            r0.detachFromGLContext()     // Catch:{ all -> 0x03ac }
        L_0x03a5:
            java.lang.String r0 = "Surfacetexture.draw"
            com.oppo.camera.e.b(r0)     // Catch:{ all -> 0x03ac }
        L_0x03aa:
            monitor-exit(r20)     // Catch:{ all -> 0x03ac }
            return r13
        L_0x03ac:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x03ac }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.t.a(com.oppo.camera.gl.h, com.oppo.camera.ui.menu.levelcontrol.g, int, int, int, int):boolean");
    }

    public void i() {
        ArrayList<g> arrayList;
        SurfaceTexture surfaceTexture = this.I;
        if (surfaceTexture != null && (arrayList = this.j) != null) {
            surfaceTexture.attachToGLContext(arrayList.get(0).d());
            this.I.updateTexImage();
            this.I.getTransformMatrix(this.z);
            this.I.detachFromGLContext();
        }
    }

    public void j() {
        SurfaceTexture surfaceTexture = this.I;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    public boolean k() {
        n nVar = this.q;
        if (nVar != null) {
            return nVar.e();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r5.length < r4.J.length) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(float[] r5) {
        /*
            r4 = this;
            android.graphics.SurfaceTexture r0 = r4.I
            if (r0 == 0) goto L_0x0008
            r0.getTransformMatrix(r5)
            goto L_0x0022
        L_0x0008:
            float[] r0 = r4.J
            monitor-enter(r0)
            if (r5 == 0) goto L_0x0013
            int r1 = r5.length     // Catch:{ all -> 0x0023 }
            float[] r2 = r4.J     // Catch:{ all -> 0x0023 }
            int r2 = r2.length     // Catch:{ all -> 0x0023 }
            if (r1 >= r2) goto L_0x0018
        L_0x0013:
            float[] r5 = r4.J     // Catch:{ all -> 0x0023 }
            int r5 = r5.length     // Catch:{ all -> 0x0023 }
            float[] r5 = new float[r5]     // Catch:{ all -> 0x0023 }
        L_0x0018:
            float[] r1 = r4.J     // Catch:{ all -> 0x0023 }
            float[] r2 = r4.J     // Catch:{ all -> 0x0023 }
            int r2 = r2.length     // Catch:{ all -> 0x0023 }
            r3 = 0
            java.lang.System.arraycopy(r1, r3, r5, r3, r2)     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
        L_0x0022:
            return
        L_0x0023:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.t.a(float[]):void");
    }

    public void a(ImageReader imageReader, int i2) {
        Image image;
        synchronized (this.h) {
            if (1 == i2) {
                try {
                    this.D = imageReader;
                } catch (Throwable th) {
                    throw th;
                }
            } else if (2 == i2) {
                this.E = imageReader;
            }
            if (!(this.D == null || this.E == null)) {
                if (!this.c || !this.d) {
                    if (1 == i2) {
                        image = this.D.acquireLatestImage();
                        this.D = null;
                    } else if (2 == i2) {
                        image = this.E.acquireLatestImage();
                        this.E = null;
                    } else {
                        image = null;
                    }
                    if (image != null) {
                        image.close();
                    }
                } else {
                    onFrameAvailable((SurfaceTexture) null);
                    l();
                }
            }
        }
    }

    private void a(h hVar, c cVar, s sVar, float[] fArr) {
        if (sVar != null) {
            int e2 = sVar.e();
            int f2 = sVar.f();
            hVar.a(sVar);
            hVar.a(0.0f, (float) f2);
            hVar.a(1.0f, -1.0f, 1.0f);
            a(this.z);
            if (fArr == null) {
                fArr = this.z;
            }
            hVar.a(cVar, fArr, 0, 0, e2, f2);
            hVar.h();
        }
    }

    public void e(boolean z2) {
        f fVar = this.F;
        if (fVar != null) {
            fVar.a(z2);
        }
    }

    public void f(boolean z2) {
        synchronized (this.h) {
            this.C = z2;
        }
    }
}
