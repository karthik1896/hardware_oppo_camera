package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.Point;
import com.oppo.camera.e;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.i;
import com.oppo.camera.gl.s;
import com.oppo.camera.tiltshift.TiltShiftParam;
import com.oppo.camera.tiltshift.TiltShiftPreview;

/* compiled from: TiltShiftTexturePreview */
public class v extends s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f4431a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private int f4432b = 0;
    private int c = 0;
    private int i = 0;
    private s j = null;
    private s k = null;
    private boolean l = false;
    private boolean m = false;
    /* access modifiers changed from: private */
    public TiltShiftPreview n = null;
    /* access modifiers changed from: private */
    public u o = null;
    /* access modifiers changed from: private */
    public boolean p = false;
    private boolean q = false;

    /* compiled from: TiltShiftTexturePreview */
    enum a {
        BLUR_LEVEL,
        WIDTH_SCALE,
        HEIGHT_SCALE,
        MIN_AREA_SIZE,
        EROSION_VALUE,
        ROTATION_ANGLE
    }

    private int a(int i2, boolean z) {
        if (z) {
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

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public int d() {
        return 512;
    }

    public boolean h() {
        return false;
    }

    public v(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        if (r2.q != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        com.oppo.camera.e.a("TiltShiftTexturePreview", "canProcess, texture is not inited");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r3) {
        /*
            r2 = this;
            boolean r3 = r2.c_(r3)
            r0 = 0
            if (r3 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.lang.Object r3 = r2.f4431a
            monitor-enter(r3)
            com.oppo.camera.ui.preview.a.u r1 = r2.o     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return r0
        L_0x0011:
            com.oppo.camera.ui.preview.a.u r1 = r2.o     // Catch:{ all -> 0x002a }
            boolean r1 = r1.c()     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x001b
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return r0
        L_0x001b:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            boolean r3 = r2.q
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = "TiltShiftTexturePreview"
            java.lang.String r1 = "canProcess, texture is not inited"
            com.oppo.camera.e.a(r3, r1)
            return r0
        L_0x0028:
            r3 = 1
            return r3
        L_0x002a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.v.a(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        r12 = r12.c;
        r4 = r12.g();
        r3 = r12.h();
        r7 = r11.e;
        r10 = r11.f4431a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r11.l == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (p() != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        com.oppo.camera.e.a("TiltShiftTexturePreview", "process, inTextureWidth: " + r3 + ", inTextureHeight: " + r4);
        a(r3, r4, r7);
        r11.l = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r2 = r11;
        r0 = a(r3, r4, r12.d(), new int[]{r11.j.d()}, r7, a(r11.i, r7), r11.o.B());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007e, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        if (r0 != 0) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0081, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        r11.m = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        if (r0 != 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.oppo.camera.ui.preview.a.s.a r12) {
        /*
            r11 = this;
            com.oppo.camera.ui.preview.a.u r0 = r11.o
            r1 = 0
            if (r0 == 0) goto L_0x0091
            if (r12 == 0) goto L_0x0091
            com.oppo.camera.gl.s r0 = r12.c
            if (r0 == 0) goto L_0x0091
            com.oppo.camera.gl.s r0 = r11.j
            if (r0 != 0) goto L_0x0011
            goto L_0x0091
        L_0x0011:
            java.lang.Object r0 = r11.f4431a
            monitor-enter(r0)
            boolean r2 = r11.p     // Catch:{ all -> 0x008e }
            if (r2 != 0) goto L_0x0021
            java.lang.String r12 = "TiltShiftTexturePreview"
            java.lang.String r2 = "process, not create, so return!"
            com.oppo.camera.e.a(r12, r2)     // Catch:{ all -> 0x008e }
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return r1
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            com.oppo.camera.gl.s r12 = r12.c
            int r4 = r12.g()
            int r3 = r12.h()
            boolean r7 = r11.e
            java.lang.Object r10 = r11.f4431a
            monitor-enter(r10)
            boolean r0 = r11.l     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x005e
            boolean r0 = r11.p()     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x005e
            java.lang.String r0 = "TiltShiftTexturePreview"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r2.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r5 = "process, inTextureWidth: "
            r2.append(r5)     // Catch:{ all -> 0x008b }
            r2.append(r3)     // Catch:{ all -> 0x008b }
            java.lang.String r5 = ", inTextureHeight: "
            r2.append(r5)     // Catch:{ all -> 0x008b }
            r2.append(r4)     // Catch:{ all -> 0x008b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008b }
            com.oppo.camera.e.a(r0, r2)     // Catch:{ all -> 0x008b }
            r11.a(r3, r4, r7)     // Catch:{ all -> 0x008b }
            r11.l = r1     // Catch:{ all -> 0x008b }
        L_0x005e:
            int r0 = r11.i     // Catch:{ all -> 0x008b }
            int r8 = r11.a((int) r0, (boolean) r7)     // Catch:{ all -> 0x008b }
            int r5 = r12.d()     // Catch:{ all -> 0x008b }
            r12 = 1
            int[] r6 = new int[r12]     // Catch:{ all -> 0x008b }
            com.oppo.camera.gl.s r0 = r11.j     // Catch:{ all -> 0x008b }
            int r0 = r0.d()     // Catch:{ all -> 0x008b }
            r6[r1] = r0     // Catch:{ all -> 0x008b }
            com.oppo.camera.ui.preview.a.u r0 = r11.o     // Catch:{ all -> 0x008b }
            android.graphics.Point r9 = r0.B()     // Catch:{ all -> 0x008b }
            r2 = r11
            int r0 = r2.a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008b }
            monitor-exit(r10)     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0083
            r2 = r12
            goto L_0x0084
        L_0x0083:
            r2 = r1
        L_0x0084:
            r11.m = r2
            if (r0 != 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r12 = r1
        L_0x008a:
            return r12
        L_0x008b:
            r12 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x008b }
            throw r12
        L_0x008e:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            throw r12
        L_0x0091:
            java.lang.String r12 = "TiltShiftTexturePreview"
            java.lang.String r0 = "process, false"
            com.oppo.camera.e.a(r12, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.v.a(com.oppo.camera.ui.preview.a.s$a):boolean");
    }

    public boolean o() {
        return this.m;
    }

    public void a(final u uVar) {
        e.a("TiltShiftTexturePreview", "createEngine");
        this.f.a((Runnable) new Runnable() {
            public void run() {
                synchronized (v.this.f4431a) {
                    if (v.this.p()) {
                        TiltShiftPreview unused = v.this.n = new TiltShiftPreview();
                    }
                    boolean unused2 = v.this.p = true;
                    u unused3 = v.this.o = uVar;
                    e.a("TiltShiftTexturePreview", "createEngine X");
                }
            }
        });
    }

    public void e() {
        e.a("TiltShiftTexturePreview", "destroyEngine");
        this.f.a((Runnable) new Runnable() {
            public void run() {
                synchronized (v.this.f4431a) {
                    if (v.this.n != null) {
                        v.this.f.g();
                        v.this.n.destory();
                        TiltShiftPreview unused = v.this.n = null;
                    }
                    u unused2 = v.this.o = null;
                    boolean unused3 = v.this.p = false;
                    e.a("TiltShiftTexturePreview", "destroyEngine X");
                }
            }
        });
    }

    public s f() {
        return this.k;
    }

    public s g() {
        return this.j;
    }

    public void i() {
        e.a("TiltShiftTexturePreview", "newTextures");
        this.k = new s(this.f4432b, this.c, true);
        this.j = new s(this.f4432b, this.c, true);
        this.q = true;
    }

    public void a(h hVar) {
        s sVar = this.k;
        if (sVar != null && !sVar.k()) {
            this.k.c(hVar);
            e.a("TiltShiftTexturePreview", "prepareTextures, mInputTiltShiftTexture.getId: " + this.k.d());
        }
        s sVar2 = this.j;
        if (sVar2 != null && !sVar2.k()) {
            this.j.c(hVar);
            e.a("TiltShiftTexturePreview", "prepareTextures, mOutputTiltShiftTexture.getId: " + this.j.d());
        }
    }

    public void j() {
        e.a("TiltShiftTexturePreview", "recycleTextures");
        if (this.q) {
            s sVar = this.k;
            if (sVar != null) {
                sVar.l();
                this.k = null;
            }
            s sVar2 = this.j;
            if (sVar2 != null) {
                sVar2.l();
                this.j = null;
            }
            this.q = false;
        }
    }

    public void a(int i2, int i3) {
        e.a("TiltShiftTexturePreview", "setSize, height: " + i2 + ", width: " + i3);
        this.f4432b = i3;
        this.c = i2;
    }

    public void a(boolean z) {
        synchronized (this.f4431a) {
            this.l = z;
        }
    }

    public void b(int i2) {
        this.i = i2;
    }

    private void a(int i2, int i3, boolean z) {
        if (!p()) {
            e.a("TiltShiftTexturePreview", "initTiltShift, width: " + i2 + ", height: " + i3 + ", isFrontCamera: " + z);
            int init = this.n.init(i3, i2, 1, 1);
            StringBuilder sb = new StringBuilder();
            sb.append("initTiltShift, X, initResult: ");
            sb.append(init);
            e.a("TiltShiftTexturePreview", sb.toString());
        }
    }

    private int a(int i2, int i3, int i4, int[] iArr, boolean z, int i5, Point point) {
        int[] iArr2 = iArr;
        u uVar = this.o;
        if (uVar == null) {
            return -1;
        }
        TiltShiftParam d = uVar.d();
        if (p() || iArr2 == null || d == null) {
            return -1;
        }
        System.currentTimeMillis();
        int[] iArr3 = new int[1];
        this.n.setDebugMask(d.isAdjusting());
        this.n.setParam(a.BLUR_LEVEL.ordinal(), this.o.e());
        this.n.setParam(a.ROTATION_ANGLE.ordinal(), (float) i5);
        this.n.getMaskTexture(i2, i3, d.getCenterX(), d.getCenterY(), d.getInnerDistance(), d.getAngle(), d.isCircle(), iArr3);
        int process = this.n.process(i4, iArr3[0], iArr2);
        i.i();
        return process;
    }

    /* access modifiers changed from: private */
    public boolean p() {
        return this.n == null;
    }
}
