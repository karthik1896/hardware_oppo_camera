package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Rect;
import com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI;
import com.oppo.camera.e;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.i;
import com.oppo.camera.ui.preview.a.s;

/* compiled from: ArcsoftBlurTexturePreview */
public class d extends s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f4375a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private int f4376b = 0;
    private int c = 0;
    private int i = 0;
    private s.b j = null;
    private com.oppo.camera.gl.s k = null;
    private com.oppo.camera.gl.s l = null;
    private boolean m = false;
    private boolean n = false;
    /* access modifiers changed from: private */
    public boolean o = false;
    /* access modifiers changed from: private */
    public SingleCameraBokehJNI p;
    /* access modifiers changed from: private */
    public u q = null;
    private boolean r = false;
    private Context s = null;
    private Rect[] t = null;

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public int d() {
        return 1;
    }

    public boolean h() {
        return false;
    }

    static {
        System.loadLibrary("single_camera_bokeh_native");
    }

    public d(Context context) {
        super(context);
        this.s = context;
    }

    public void a(s.b bVar) {
        synchronized (this.f4375a) {
            this.j = bVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        if (r3.r != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0037, code lost:
        com.oppo.camera.e.e("ArcsoftBlurTexturePreview", "canProcess, texture is not inited");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r4) {
        /*
            r3 = this;
            boolean r4 = r3.c_(r4)
            r0 = 0
            if (r4 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.lang.Object r4 = r3.f4375a
            monitor-enter(r4)
            com.oppo.camera.ui.preview.a.u r1 = r3.q     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r4)     // Catch:{ all -> 0x0041 }
            return r0
        L_0x0011:
            com.oppo.camera.ui.preview.a.u r1 = r3.q     // Catch:{ all -> 0x0041 }
            int r1 = r1.v()     // Catch:{ all -> 0x0041 }
            if (r1 > 0) goto L_0x0021
            boolean r1 = r3.n     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x001f
            r3.n = r0     // Catch:{ all -> 0x0041 }
        L_0x001f:
            monitor-exit(r4)     // Catch:{ all -> 0x0041 }
            return r0
        L_0x0021:
            com.oppo.camera.ui.preview.a.u r1 = r3.q     // Catch:{ all -> 0x0041 }
            boolean r1 = r1.m()     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x0032
            java.lang.String r1 = "ArcsoftBlurTexturePreview"
            java.lang.String r2 = "canProcess, not open effect"
            com.oppo.camera.e.e(r1, r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r4)     // Catch:{ all -> 0x0041 }
            return r0
        L_0x0032:
            monitor-exit(r4)     // Catch:{ all -> 0x0041 }
            boolean r4 = r3.r
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "ArcsoftBlurTexturePreview"
            java.lang.String r1 = "canProcess, texture is not inited"
            com.oppo.camera.e.e(r4, r1)
            return r0
        L_0x003f:
            r4 = 1
            return r4
        L_0x0041:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0041 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.d.a(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0120, code lost:
        android.opengl.GLES20.glViewport(0, 0, r0.f4427a.d(), r0.f4427a.e());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012f, code lost:
        if (r3 == -1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.oppo.camera.ui.preview.a.s.a r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = 0
            if (r0 == 0) goto L_0x0136
            com.oppo.camera.gl.s r3 = r0.c
            if (r3 == 0) goto L_0x0136
            com.oppo.camera.gl.s r3 = r1.k
            if (r3 != 0) goto L_0x0011
            goto L_0x0136
        L_0x0011:
            com.oppo.camera.gl.s r3 = r0.c
            int r4 = r3.g()
            int r5 = r3.h()
            java.lang.Object r6 = r1.f4375a
            monitor-enter(r6)
            com.oppo.camera.ui.preview.a.u r7 = r1.q     // Catch:{ all -> 0x0133 }
            if (r7 != 0) goto L_0x0024
            monitor-exit(r6)     // Catch:{ all -> 0x0133 }
            return r2
        L_0x0024:
            boolean r7 = r1.m     // Catch:{ all -> 0x0133 }
            if (r7 == 0) goto L_0x0031
            com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI r7 = r1.p     // Catch:{ all -> 0x0133 }
            if (r7 == 0) goto L_0x0031
            r1.b(r4, r5)     // Catch:{ all -> 0x0133 }
            r1.m = r2     // Catch:{ all -> 0x0133 }
        L_0x0031:
            boolean r7 = r1.o     // Catch:{ all -> 0x0133 }
            if (r7 != 0) goto L_0x0037
            monitor-exit(r6)     // Catch:{ all -> 0x0133 }
            return r2
        L_0x0037:
            android.opengl.GLES20.glViewport(r2, r2, r4, r5)     // Catch:{ all -> 0x0133 }
            com.oppo.camera.ui.preview.a.s$b r7 = r1.j     // Catch:{ all -> 0x0133 }
            if (r7 == 0) goto L_0x0046
            com.oppo.camera.ui.preview.a.s$b r7 = r1.j     // Catch:{ all -> 0x0133 }
            android.graphics.Rect[] r7 = r7.b()     // Catch:{ all -> 0x0133 }
            r1.t = r7     // Catch:{ all -> 0x0133 }
        L_0x0046:
            com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI r7 = r1.p     // Catch:{ all -> 0x0133 }
            r8 = -1
            r9 = 1
            if (r7 == 0) goto L_0x011e
            android.graphics.Rect[] r7 = r1.t     // Catch:{ all -> 0x0133 }
            if (r7 == 0) goto L_0x011e
            android.graphics.Rect[] r7 = r1.t     // Catch:{ all -> 0x0133 }
            int r7 = r7.length     // Catch:{ all -> 0x0133 }
            if (r7 <= 0) goto L_0x011e
            android.graphics.Rect[] r7 = r1.t     // Catch:{ all -> 0x0133 }
            int r13 = r7.length     // Catch:{ all -> 0x0133 }
            int r7 = r13 * 4
            int[] r14 = new int[r7]     // Catch:{ all -> 0x0133 }
            r7 = r2
            r10 = r7
        L_0x005e:
            if (r7 >= r13) goto L_0x00a1
            android.graphics.Rect[] r11 = r1.t     // Catch:{ all -> 0x0133 }
            r11 = r11[r7]     // Catch:{ all -> 0x0133 }
            if (r11 != 0) goto L_0x006e
            java.lang.String r4 = "ArcsoftBlurTexturePreview"
            java.lang.String r5 = "process, faceRects is null"
            com.oppo.camera.e.e(r4, r5)     // Catch:{ all -> 0x0133 }
            goto L_0x00a1
        L_0x006e:
            android.graphics.Rect[] r11 = r1.t     // Catch:{ all -> 0x0133 }
            r11 = r11[r7]     // Catch:{ all -> 0x0133 }
            int r11 = r11.bottom     // Catch:{ all -> 0x0133 }
            int r11 = r4 - r11
            r14[r10] = r11     // Catch:{ all -> 0x0133 }
            int r10 = r10 + 1
            android.graphics.Rect[] r11 = r1.t     // Catch:{ all -> 0x0133 }
            r11 = r11[r7]     // Catch:{ all -> 0x0133 }
            int r11 = r11.right     // Catch:{ all -> 0x0133 }
            int r11 = r5 - r11
            r14[r10] = r11     // Catch:{ all -> 0x0133 }
            int r10 = r10 + 1
            android.graphics.Rect[] r11 = r1.t     // Catch:{ all -> 0x0133 }
            r11 = r11[r7]     // Catch:{ all -> 0x0133 }
            int r11 = r11.top     // Catch:{ all -> 0x0133 }
            int r11 = r4 - r11
            r14[r10] = r11     // Catch:{ all -> 0x0133 }
            int r10 = r10 + 1
            android.graphics.Rect[] r11 = r1.t     // Catch:{ all -> 0x0133 }
            r11 = r11[r7]     // Catch:{ all -> 0x0133 }
            int r11 = r11.left     // Catch:{ all -> 0x0133 }
            int r11 = r5 - r11
            r14[r10] = r11     // Catch:{ all -> 0x0133 }
            int r10 = r10 + 1
            int r7 = r7 + 1
            goto L_0x005e
        L_0x00a1:
            r4 = 4
            int[] r15 = new int[r4]     // Catch:{ all -> 0x0133 }
            r5 = 10
            r15[r2] = r5     // Catch:{ all -> 0x0133 }
            r5 = 11
            r15[r9] = r5     // Catch:{ all -> 0x0133 }
            r5 = 12
            r7 = 2
            r15[r7] = r5     // Catch:{ all -> 0x0133 }
            r5 = 13
            r10 = 3
            r15[r10] = r5     // Catch:{ all -> 0x0133 }
            int r5 = r1.i     // Catch:{ all -> 0x0133 }
            if (r5 == 0) goto L_0x00d2
            r10 = 90
            if (r5 == r10) goto L_0x00cf
            r4 = 180(0xb4, float:2.52E-43)
            if (r5 == r4) goto L_0x00cc
            r4 = 270(0x10e, float:3.78E-43)
            if (r5 == r4) goto L_0x00c9
            r17 = r2
            goto L_0x00d4
        L_0x00c9:
            r17 = r9
            goto L_0x00d4
        L_0x00cc:
            r17 = r7
            goto L_0x00d4
        L_0x00cf:
            r17 = r4
            goto L_0x00d4
        L_0x00d2:
            r17 = r10
        L_0x00d4:
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0133 }
            boolean r4 = r1.n     // Catch:{ all -> 0x0133 }
            if (r4 != 0) goto L_0x00fa
            com.oppo.camera.ui.preview.a.u r4 = r1.q     // Catch:{ all -> 0x0133 }
            int r4 = r4.v()     // Catch:{ all -> 0x0133 }
            if (r4 <= 0) goto L_0x00fa
            r1.n = r9     // Catch:{ all -> 0x0133 }
            com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI r4 = r1.p     // Catch:{ all -> 0x0133 }
            boolean r5 = com.oppo.camera.util.Util.p()     // Catch:{ all -> 0x0133 }
            if (r5 == 0) goto L_0x00ef
            r5 = r2
            goto L_0x00f0
        L_0x00ef:
            r5 = r9
        L_0x00f0:
            r4.forceUpdateFrame(r5)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = "ArcsoftBlurTexturePreview"
            java.lang.String r5 = "process, forceUpdateFrame"
            com.oppo.camera.e.e(r4, r5)     // Catch:{ all -> 0x0133 }
        L_0x00fa:
            com.oppo.camera.ui.preview.a.u r4 = r1.q     // Catch:{ all -> 0x0133 }
            float r4 = r4.a()     // Catch:{ all -> 0x0133 }
            r5 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 * r5
            int r4 = (int) r4     // Catch:{ all -> 0x0133 }
            com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI r10 = r1.p     // Catch:{ all -> 0x0133 }
            int r11 = r3.d()     // Catch:{ all -> 0x0133 }
            int[] r12 = new int[r9]     // Catch:{ all -> 0x0133 }
            com.oppo.camera.gl.s r3 = r1.k     // Catch:{ all -> 0x0133 }
            int r3 = r3.d()     // Catch:{ all -> 0x0133 }
            r12[r2] = r3     // Catch:{ all -> 0x0133 }
            r16 = r4
            int r3 = r10.process(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0133 }
            com.oppo.camera.gl.i.i()     // Catch:{ all -> 0x0133 }
            goto L_0x011f
        L_0x011e:
            r3 = r8
        L_0x011f:
            monitor-exit(r6)     // Catch:{ all -> 0x0133 }
            com.oppo.camera.gl.h r4 = r0.f4427a
            int r4 = r4.d()
            com.oppo.camera.gl.h r0 = r0.f4427a
            int r0 = r0.e()
            android.opengl.GLES20.glViewport(r2, r2, r4, r0)
            if (r3 == r8) goto L_0x0132
            r2 = r9
        L_0x0132:
            return r2
        L_0x0133:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0133 }
            throw r0
        L_0x0136:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.d.a(com.oppo.camera.ui.preview.a.s$a):boolean");
    }

    public void a(u uVar) {
        e.a("ArcsoftBlurTexturePreview", "createEngine,  request: " + uVar);
        synchronized (this.f4375a) {
            if (this.p == null) {
                this.p = new SingleCameraBokehJNI();
                String version = this.p.getVersion();
                e.a("ArcsoftBlurTexturePreview", "createEngine, native version: " + version);
            }
            this.q = uVar;
        }
    }

    public void e() {
        if (this.f != null) {
            e.a("ArcsoftBlurTexturePreview", "destroyEngine");
            this.f.a((Runnable) new Runnable() {
                public void run() {
                    synchronized (d.this.f4375a) {
                        if (d.this.p != null && d.this.o) {
                            int release = d.this.p.release();
                            boolean unused = d.this.o = false;
                            e.a("ArcsoftBlurTexturePreview", "destroyEngine, X ret: " + release);
                        }
                        SingleCameraBokehJNI unused2 = d.this.p = null;
                        u unused3 = d.this.q = null;
                    }
                }
            });
        }
    }

    public com.oppo.camera.gl.s f() {
        return this.l;
    }

    public com.oppo.camera.gl.s g() {
        return this.k;
    }

    public void i() {
        e.a("ArcsoftBlurTexturePreview", "newTextures");
        this.l = new com.oppo.camera.gl.s(this.f4376b, this.c, true);
        this.k = new com.oppo.camera.gl.s(this.f4376b, this.c, true);
        this.r = true;
    }

    public void a(h hVar) {
        com.oppo.camera.gl.s sVar = this.l;
        if (sVar != null && !sVar.k()) {
            this.l.c(hVar);
            e.a("ArcsoftBlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.l.d());
        }
        com.oppo.camera.gl.s sVar2 = this.k;
        if (sVar2 != null && !sVar2.k()) {
            this.k.c(hVar);
            e.a("ArcsoftBlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.k.d());
        }
    }

    public void j() {
        e.a("ArcsoftBlurTexturePreview", "recycleTextures");
        if (this.r) {
            com.oppo.camera.gl.s sVar = this.l;
            if (sVar != null) {
                sVar.l();
                this.l = null;
            }
            com.oppo.camera.gl.s sVar2 = this.k;
            if (sVar2 != null) {
                sVar2.l();
                this.k = null;
            }
            this.r = false;
        }
    }

    public void a(int i2, int i3) {
        e.a("ArcsoftBlurTexturePreview", "setSize, height: " + i2 + ", width: " + i3);
        this.f4376b = i3;
        this.c = i2;
    }

    public void a(boolean z) {
        e.a("ArcsoftBlurTexturePreview", "setTextureSizeChanged, sizeChanged: " + z);
        synchronized (this.f4375a) {
            this.m = z;
        }
    }

    public void b(int i2) {
        this.i = i2;
    }

    private boolean b(int i2, int i3) {
        boolean z = false;
        if (this.o) {
            int release = this.p.release();
            this.o = false;
            e.e("ArcsoftBlurTexturePreview", "initSingleBokeh, release X ret: " + release);
        }
        e.a("ArcsoftBlurTexturePreview", "initSingleBokeh, srcWidth: " + i2 + ", srcHeight: " + i3 + ", outWidth: " + i2 + ", outHeight: " + i3 + ", format: " + 10 + ", mCameraId: " + this.d);
        int init = this.p.init(i2, i3, i2, i3, 10, this.d, (AssetManager) null);
        i.i();
        StringBuilder sb = new StringBuilder();
        sb.append("initSingleBokeh, X ret: ");
        sb.append(init);
        e.a("ArcsoftBlurTexturePreview", sb.toString());
        if (init == 0) {
            z = true;
        }
        this.o = z;
        return this.o;
    }
}
