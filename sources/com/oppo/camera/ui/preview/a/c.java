package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.Color;
import android.util.Size;
import com.arcsoft.arcsoftjni.ArcSoftAvatarEngine;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.f.a;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.s;
import com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.g;
import com.oppo.camera.util.Util;
import java.io.File;

/* compiled from: AnimojiTexturePreview */
public class c extends s {
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private ArcSoftAvatarEngine D = null;
    private ArcSoftOffscreen E = null;
    private ArcSoftOffscreen F = null;
    private ArcSoftOffscreen G = null;

    /* renamed from: a  reason: collision with root package name */
    Runnable f4368a = new Runnable() {
        public void run() {
            synchronized (c.this.i) {
                if (!c.this.x) {
                    c.this.p();
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    Runnable f4369b = new Runnable() {
        public void run() {
            c cVar = c.this;
            long unused = cVar.a(cVar.h, c.this.j, c.this.k);
        }
    };
    Runnable c = new Runnable() {
        public void run() {
            c.this.x();
        }
    };
    /* access modifiers changed from: private */
    public final Object i = new Object();
    /* access modifiers changed from: private */
    public int j = 0;
    /* access modifiers changed from: private */
    public int k = 0;
    private int l = 0;
    private float[] m = new float[3];
    private s n = null;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private Size s = null;
    private u t = null;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    /* access modifiers changed from: private */
    public boolean x = false;
    private String y = null;
    private String z = null;

    public void a(h hVar) {
    }

    public void b() {
    }

    public void c() {
    }

    public int d() {
        return 16;
    }

    public s f() {
        return null;
    }

    public boolean a() {
        boolean z2;
        synchronized (this.i) {
            z2 = this.B;
        }
        return z2;
    }

    public c(Context context) {
        super(context);
    }

    public void a(byte[] bArr, int i2, int i3) {
        int i4;
        if (this.u) {
            synchronized (this.i) {
                if (!(this.E != null && i2 == this.E.getWidth() && i3 == this.E.getHeight())) {
                    if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER_USE_NV12)) {
                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PREVIEW_YUV_FORMAT_NV12)) {
                            i4 = 2050;
                            this.E = new ArcSoftOffscreen(i2, i3, i4);
                            e.a("AnimojiTexturePreview", "onPreviewCallback, new ArcSoftOffscreen, width: " + i2 + ", height: " + i3);
                        }
                    }
                    i4 = 2049;
                    this.E = new ArcSoftOffscreen(i2, i3, i4);
                    e.a("AnimojiTexturePreview", "onPreviewCallback, new ArcSoftOffscreen, width: " + i2 + ", height: " + i3);
                }
                if (!(this.E == null || this.t == null || bArr == null)) {
                    this.E.setData(bArr);
                }
            }
        }
    }

    public boolean a(int i2) {
        u uVar = this.t;
        if (uVar == null) {
            return false;
        }
        if (uVar.v() > 0 && this.A) {
            this.A = false;
        }
        if (c_(i2) && this.v && this.t.m() && this.t.n() && 2 == this.t.j().getMaterialType()) {
            return !this.A;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0150, code lost:
        if (r5 == -1) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.oppo.camera.ui.preview.a.s.a r24) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            com.oppo.camera.ui.preview.a.u r2 = r1.t
            r3 = 0
            if (r2 == 0) goto L_0x0158
            boolean r2 = r1.u
            if (r2 == 0) goto L_0x0158
            com.arcsoft.arcsoftjni.ArcSoftAvatarEngine r2 = r1.D
            if (r2 == 0) goto L_0x0158
            com.oppo.camera.gl.s r2 = r1.n
            if (r2 == 0) goto L_0x0158
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r2 = r1.E
            if (r2 == 0) goto L_0x0158
            byte[] r2 = r2.getData()
            if (r2 == 0) goto L_0x0158
            if (r0 == 0) goto L_0x0158
            int r2 = r0.i
            if (r2 <= 0) goto L_0x0158
            int r2 = r0.j
            if (r2 > 0) goto L_0x002b
            goto L_0x0158
        L_0x002b:
            int r2 = r1.l
            int r4 = r1.d
            int r12 = r0.i
            int r13 = r0.j
            java.lang.Object r14 = r1.i
            monitor-enter(r14)
            com.arcsoft.arcsoftjni.ArcSoftAvatarEngine r5 = r1.D     // Catch:{ all -> 0x0155 }
            if (r5 != 0) goto L_0x003c
            monitor-exit(r14)     // Catch:{ all -> 0x0155 }
            return r3
        L_0x003c:
            boolean r5 = r1.o     // Catch:{ all -> 0x0155 }
            r15 = 1
            if (r5 != 0) goto L_0x0055
            boolean r0 = r1.C     // Catch:{ all -> 0x0155 }
            if (r0 != 0) goto L_0x004c
            java.lang.Runnable r0 = r1.c     // Catch:{ all -> 0x0155 }
            com.oppo.camera.util.Util.a((java.lang.Runnable) r0)     // Catch:{ all -> 0x0155 }
            r1.C = r15     // Catch:{ all -> 0x0155 }
        L_0x004c:
            java.lang.String r0 = "AnimojiTexturePreview"
            java.lang.String r2 = "process, non selected template!"
            com.oppo.camera.e.e(r0, r2)     // Catch:{ all -> 0x0155 }
            monitor-exit(r14)     // Catch:{ all -> 0x0155 }
            return r3
        L_0x0055:
            boolean r9 = r1.e     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftAvatarEngine r5 = r1.D     // Catch:{ all -> 0x0155 }
            r5.setDevicesOrientation(r2)     // Catch:{ all -> 0x0155 }
            int r8 = com.oppo.camera.f.a.b(r4, r2)     // Catch:{ all -> 0x0155 }
            boolean r2 = r1.w     // Catch:{ all -> 0x0155 }
            if (r2 == 0) goto L_0x007c
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r2 = r1.F     // Catch:{ all -> 0x0155 }
            if (r2 == 0) goto L_0x007c
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r2 = r1.F     // Catch:{ all -> 0x0155 }
            byte[] r2 = r2.getData()     // Catch:{ all -> 0x0155 }
            if (r2 == 0) goto L_0x007c
            com.arcsoft.arcsoftjni.ArcSoftAvatarEngine r4 = r1.D     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r5 = r1.E     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r6 = r1.F     // Catch:{ all -> 0x0155 }
            r7 = 90
            r4.process(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0155 }
            goto L_0x0086
        L_0x007c:
            com.arcsoft.arcsoftjni.ArcSoftAvatarEngine r4 = r1.D     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r5 = r1.E     // Catch:{ all -> 0x0155 }
            r6 = 0
            r7 = 90
            r4.process(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0155 }
        L_0x0086:
            float[] r2 = r1.m     // Catch:{ all -> 0x0155 }
            r2 = r2[r3]     // Catch:{ all -> 0x0155 }
            float[] r4 = r1.m     // Catch:{ all -> 0x0155 }
            r4 = r4[r15]     // Catch:{ all -> 0x0155 }
            float[] r5 = r1.m     // Catch:{ all -> 0x0155 }
            r6 = 2
            r11 = r5[r6]     // Catch:{ all -> 0x0155 }
            r10 = 1065353216(0x3f800000, float:1.0)
            android.opengl.GLES20.glClearColor(r2, r4, r11, r10)     // Catch:{ all -> 0x0155 }
            android.opengl.GLES20.glViewport(r3, r3, r12, r13)     // Catch:{ all -> 0x0155 }
            int[] r9 = new int[r15]     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftAvatarEngine r5 = r1.D     // Catch:{ all -> 0x0155 }
            r8 = 0
            r16 = 0
            r17 = 0
            r6 = r12
            r7 = r13
            r18 = r9
            r9 = r16
            r10 = r18
            r20 = r11
            r11 = r17
            long r5 = r5.render(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0155 }
            com.oppo.camera.gl.s r7 = r1.n     // Catch:{ all -> 0x0155 }
            com.oppo.camera.gl.h r0 = r0.f4427a     // Catch:{ all -> 0x0155 }
            r8 = r18[r3]     // Catch:{ all -> 0x0155 }
            r7.a(r0, r8, r12, r13)     // Catch:{ all -> 0x0155 }
            r1.B = r15     // Catch:{ all -> 0x0155 }
            boolean r0 = r1.q     // Catch:{ all -> 0x0155 }
            if (r0 == 0) goto L_0x014b
            java.lang.String r0 = "AnimojiTexturePreview"
            java.lang.String r7 = "process, captureRender start"
            com.oppo.camera.e.b(r0, r7)     // Catch:{ all -> 0x0155 }
            r1.q = r3     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r0 = new com.arcsoft.arcsoftjni.ArcSoftOffscreen     // Catch:{ all -> 0x0155 }
            android.util.Size r7 = r1.s     // Catch:{ all -> 0x0155 }
            int r7 = r7.getWidth()     // Catch:{ all -> 0x0155 }
            android.util.Size r8 = r1.s     // Catch:{ all -> 0x0155 }
            int r8 = r8.getHeight()     // Catch:{ all -> 0x0155 }
            java.lang.String r9 = "com.oplus.sticker.use.nv12"
            boolean r9 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r9)     // Catch:{ all -> 0x0155 }
            if (r9 != 0) goto L_0x00ee
            java.lang.String r9 = "com.oplus.preview.format.nv12"
            boolean r9 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r9)     // Catch:{ all -> 0x0155 }
            if (r9 == 0) goto L_0x00eb
            goto L_0x00ee
        L_0x00eb:
            r9 = 2050(0x802, float:2.873E-42)
            goto L_0x00f0
        L_0x00ee:
            r9 = 2049(0x801, float:2.871E-42)
        L_0x00f0:
            r0.<init>(r7, r8, r9)     // Catch:{ all -> 0x0155 }
            r1.G = r0     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r0 = r1.G     // Catch:{ all -> 0x0155 }
            android.util.Size r7 = r1.s     // Catch:{ all -> 0x0155 }
            int r7 = r7.getWidth()     // Catch:{ all -> 0x0155 }
            android.util.Size r8 = r1.s     // Catch:{ all -> 0x0155 }
            int r8 = r8.getHeight()     // Catch:{ all -> 0x0155 }
            int r7 = r7 * r8
            float r7 = (float) r7     // Catch:{ all -> 0x0155 }
            r8 = 1069547520(0x3fc00000, float:1.5)
            float r7 = r7 * r8
            int r7 = (int) r7     // Catch:{ all -> 0x0155 }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0155 }
            r0.setData(r7)     // Catch:{ all -> 0x0155 }
            r0 = r20
            r7 = 1065353216(0x3f800000, float:1.0)
            android.opengl.GLES20.glClearColor(r2, r4, r0, r7)     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftAvatarEngine r0 = r1.D     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r2 = r1.G     // Catch:{ all -> 0x0155 }
            int r17 = r2.getWidth()     // Catch:{ all -> 0x0155 }
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r2 = r1.G     // Catch:{ all -> 0x0155 }
            int r18 = r2.getHeight()     // Catch:{ all -> 0x0155 }
            r19 = 270(0x10e, float:3.78E-43)
            boolean r2 = r1.r     // Catch:{ all -> 0x0155 }
            r21 = 0
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r4 = r1.G     // Catch:{ all -> 0x0155 }
            r16 = r0
            r20 = r2
            r22 = r4
            long r7 = r16.render(r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = "AnimojiTexturePreview"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
            r2.<init>()     // Catch:{ all -> 0x0155 }
            java.lang.String r4 = "process, captureRender end, captureResult: "
            r2.append(r4)     // Catch:{ all -> 0x0155 }
            r2.append(r7)     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0155 }
            com.oppo.camera.e.b(r0, r2)     // Catch:{ all -> 0x0155 }
        L_0x014b:
            monitor-exit(r14)     // Catch:{ all -> 0x0155 }
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0153
            goto L_0x0154
        L_0x0153:
            r15 = r3
        L_0x0154:
            return r15
        L_0x0155:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0155 }
            throw r0
        L_0x0158:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "process, something wrong, so return! mRequest: "
            r2.append(r4)
            com.oppo.camera.ui.preview.a.u r4 = r1.t
            r2.append(r4)
            java.lang.String r4 = ", mbInitialized: "
            r2.append(r4)
            boolean r4 = r1.u
            r2.append(r4)
            java.lang.String r4 = ", mAvatarEngineRender: "
            r2.append(r4)
            com.arcsoft.arcsoftjni.ArcSoftAvatarEngine r4 = r1.D
            r2.append(r4)
            java.lang.String r4 = ", mOutputAnimojiTexture: "
            r2.append(r4)
            com.oppo.camera.gl.s r4 = r1.n
            r2.append(r4)
            java.lang.String r4 = ", mPreviewOffscreen: "
            r2.append(r4)
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r4 = r1.E
            r2.append(r4)
            java.lang.String r4 = ", mPreviewOffscreen.data: "
            r2.append(r4)
            com.arcsoft.arcsoftjni.ArcSoftOffscreen r4 = r1.E
            if (r4 == 0) goto L_0x019d
            byte[] r4 = r4.getData()
            goto L_0x019e
        L_0x019d:
            r4 = 0
        L_0x019e:
            r2.append(r4)
            java.lang.String r4 = ", frameInfo: "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r4 = ", outTextureWidth: "
            r2.append(r4)
            if (r0 != 0) goto L_0x01b2
            r4 = r3
            goto L_0x01b4
        L_0x01b2:
            int r4 = r0.i
        L_0x01b4:
            r2.append(r4)
            java.lang.String r4 = ", outTextureHeight: "
            r2.append(r4)
            if (r0 != 0) goto L_0x01c0
            r0 = r3
            goto L_0x01c2
        L_0x01c0:
            int r0 = r0.j
        L_0x01c2:
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "AnimojiTexturePreview"
            com.oppo.camera.e.d(r2, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.c.a(com.oppo.camera.ui.preview.a.s$a):boolean");
    }

    public void a(u uVar) {
        e.a("AnimojiTexturePreview", "createEngine, request: " + uVar + ", mbCreateEngine: " + this.x);
        this.t = uVar;
        if (!this.x) {
            e.a("Animoji.createEngine");
            this.x = true;
            this.A = true;
            this.B = false;
            synchronized (this.i) {
                Util.a(this.f4369b);
            }
            synchronized (this.i) {
                Util.a(this.c);
            }
            e.b("Animoji.createEngine");
        }
    }

    public void e() {
        e.a("AnimojiTexturePreview", "destroyEngine, mRequest: " + this.t);
        if (this.x) {
            this.x = false;
            this.A = false;
            if (this.t != null && this.f != null) {
                this.f.a((Runnable) new Runnable() {
                    public void run() {
                        synchronized (c.this.i) {
                            c.this.w();
                            Util.a(c.this.f4368a);
                        }
                    }
                });
            }
        }
    }

    public s g() {
        return this.n;
    }

    private boolean o() {
        Boolean bool;
        a.C0083a a2 = a.a();
        a.C0083a b2 = a.b();
        if (a2 == null || b2 == null || !a2.a() || !b2.a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("setCameraConf, masterCalibParam valid: ");
            Boolean bool2 = null;
            if (a2 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(a2.a());
            }
            sb.append(bool);
            sb.append(", depthCalibParam valid: ");
            if (b2 != null) {
                bool2 = Boolean.valueOf(b2.a());
            }
            sb.append(bool2);
            e.e("AnimojiTexturePreview", sb.toString());
            return false;
        }
        ArcSoftAvatarEngine.AvatarEngineCamera avatarEngineCamera = new ArcSoftAvatarEngine.AvatarEngineCamera();
        avatarEngineCamera.iFrameWidth = a.a().f3183a;
        avatarEngineCamera.iFrameHeight = a.a().f3184b;
        avatarEngineCamera.fCameraFx = a.a().c;
        avatarEngineCamera.fCameraFy = a.a().d;
        avatarEngineCamera.fCameraCx = a.a().e;
        avatarEngineCamera.fCameraCy = a.a().f;
        ArcSoftAvatarEngine.AvatarEngineCamera avatarEngineCamera2 = new ArcSoftAvatarEngine.AvatarEngineCamera();
        avatarEngineCamera2.iFrameWidth = a.b().f3183a;
        avatarEngineCamera2.iFrameHeight = a.b().f3184b;
        avatarEngineCamera2.fCameraFx = a.b().c;
        avatarEngineCamera2.fCameraFy = a.b().d;
        avatarEngineCamera2.fCameraCx = a.b().e;
        avatarEngineCamera2.fCameraCy = a.b().f;
        long j2 = -1;
        ArcSoftAvatarEngine arcSoftAvatarEngine = this.D;
        if (arcSoftAvatarEngine != null) {
            j2 = arcSoftAvatarEngine.setCamera(avatarEngineCamera, avatarEngineCamera2);
            e.a("AnimojiTexturePreview", "setCameraConf, masterCalibParam: " + a2.toString() + ", depthCalibParam: " + b2.toString() + ", result: " + j2);
        }
        if (j2 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public long a(Context context, int i2, int i3) {
        e.b("AnimojiTexturePreview", "initAnimojiEngine, start, mbInitialized: " + this.u + ", width: " + i2 + ", height: " + i3);
        long j2 = -1;
        if (this.h == null) {
            return -1;
        }
        String y2 = y();
        a(this.h, "sticker/material/animoji/data.zip", y2, false);
        synchronized (this.i) {
            if (!this.u && this.D == null) {
                e.a("Animoji.initAnimojiEngine");
                this.D = new ArcSoftAvatarEngine(context);
                j2 = this.D.initialize(y2.concat("/data/track_data.dat"), y2.concat("/data/config.txt"), 1);
                e.b("AnimojiTexturePreview", "initAnimojiEngine, end, mCurrentTemplatePath: " + this.y + ", initResult: " + j2);
                this.w = o();
                this.u = true;
                e.b("Animoji.initAnimojiEngine");
                e.b("AnimojiTexturePreview", "initAnimojiEngine, end, initResult: " + j2 + ", dataPath: " + y2);
            }
        }
        return j2;
    }

    /* access modifiers changed from: private */
    public void p() {
        e.b("AnimojiTexturePreview", "unInitAnimojiEngine, mbInitialized: " + this.u + ", mAvatarEngineRender: " + this.D);
        if (this.u && this.D != null) {
            e.a("Animoji.unInitAnimojiEngine");
            this.D.uninitialize();
            this.D = null;
            this.E = null;
            this.o = false;
            this.C = false;
            this.F = null;
            this.u = false;
            this.w = false;
            e.b("Animoji.unInitAnimojiEngine");
        }
    }

    /* access modifiers changed from: private */
    public void w() {
        e.b("AnimojiTexturePreview", "releaseAnimojiRender, mbInitialized: " + this.u + ", mAvatarEngineRender: " + this.D);
        if (this.u && this.D != null) {
            e.a("Animoji.releaseAnimojiRender");
            this.D.releaseRender();
            ArcSoftOffscreen arcSoftOffscreen = this.E;
            if (arcSoftOffscreen != null) {
                arcSoftOffscreen.setData((byte[]) null);
            }
            ArcSoftOffscreen arcSoftOffscreen2 = this.F;
            if (arcSoftOffscreen2 != null) {
                arcSoftOffscreen2.setData((byte[]) null);
            }
            e.b("Animoji.releaseAnimojiRender");
        }
        e.b("AnimojiTexturePreview", "releaseAnimojiEngine, end");
    }

    public boolean h() {
        synchronized (this.i) {
            Util.b(this.c);
            Util.a(this.c);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void x() {
        StickerItem j2 = this.t.j();
        if (j2 == null) {
            e.e("AnimojiTexturePreview", "initTemplateResource, item is null");
            return;
        }
        e.a("Animoji.initTemplateResource");
        String fileContentUri = j2.getFileContentUri();
        String stickerName = j2.getStickerName();
        AnimojiStickerExtendedInfo b2 = g.b(this.h, j2);
        String backgroundColor = b2 != null ? b2.getBackgroundColor() : "#F5E274";
        String str = y() + File.separator + stickerName;
        if (this.h != null) {
            l.b(this.h);
            boolean a2 = a(l.a(this.h, fileContentUri), str);
            synchronized (this.i) {
                long j3 = -1;
                e.b("AnimojiTexturePreview", "initTemplateResource, stickerName: " + stickerName + ", unZipResult: " + a2);
                boolean z2 = true;
                if (a2) {
                    this.y = a(stickerName);
                    if (backgroundColor != null) {
                        int parseColor = Color.parseColor(backgroundColor);
                        this.m[0] = ((float) Color.red(parseColor)) / 255.0f;
                        this.m[1] = ((float) Color.green(parseColor)) / 255.0f;
                        this.m[2] = ((float) Color.blue(parseColor)) / 255.0f;
                    }
                    if (this.D != null) {
                        j3 = this.D.setTemplate(this.y);
                    }
                }
                e.b("Animoji.initTemplateResource");
                e.b("AnimojiTexturePreview", "initTemplateResource, stickerName: " + stickerName + ", unZipResult: " + a2 + ", templateResult: " + j3);
                if (0 != j3) {
                    z2 = false;
                }
                this.o = z2;
            }
        }
    }

    private String a(String str) {
        File[] listFiles;
        File file = new File(y() + File.separator + str);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return null;
        }
        return listFiles[0].getPath();
    }

    private String y() {
        if (this.z == null && this.h != null) {
            this.z = this.h.getExternalCacheDir().getPath() + "/animoji";
        }
        return this.z;
    }

    public void i() {
        this.n = new s(this.j, this.k, true);
        this.v = true;
        e.a("AnimojiTexturePreview", "newTextures, mOutputAnimojiTexture: " + this.n);
    }

    public void j() {
        e.a("AnimojiTexturePreview", "recycleTextures, mbTextureInited: " + this.v + ", mOutputAnimojiTexture: " + this.n);
        if (this.v) {
            s sVar = this.n;
            if (sVar != null) {
                sVar.l();
                this.n = null;
            }
            this.v = false;
        }
    }

    public void a(int i2, int i3) {
        e.b("AnimojiTexturePreview", "setSize, width: " + i2 + ", height: " + i3 + ", mWidth: " + this.j + ", mHeight: " + this.k);
        this.p = (i2 == this.j && i3 == this.k) ? false : true;
        this.j = i2;
        this.k = i3;
        if (this.p && this.f != null) {
            this.f.a((Runnable) new Runnable() {
                public void run() {
                    synchronized (c.this.i) {
                        c.this.w();
                    }
                }
            });
        }
    }

    public void b(int i2) {
        this.l = i2;
    }

    public void a(Size size, boolean z2) {
        synchronized (this.i) {
            this.q = true;
            this.r = z2;
            this.s = size;
            e.b("AnimojiTexturePreview", "capture, mOutputOffscreen: " + this.G + ", mbMirror: " + this.r);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x001c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.io.File r9, java.lang.String r10) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x000e
            r0.mkdirs()
        L_0x000e:
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile
            r0.<init>(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Enumeration r1 = r0.entries()
        L_0x001c:
            boolean r2 = r1.hasMoreElements()
            if (r2 == 0) goto L_0x00d8
            java.lang.Object r2 = r1.nextElement()
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2
            java.lang.String r3 = r2.getName()
            java.lang.String r4 = "../"
            boolean r4 = r3.contains(r4)
            if (r4 == 0) goto L_0x0035
            goto L_0x001c
        L_0x0035:
            java.io.InputStream r2 = r0.getInputStream(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r10)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = java.io.File.separator
            java.lang.String r5 = "\\*"
            java.lang.String r3 = r3.replaceAll(r5, r4)
            java.io.File r4 = new java.io.File
            r4.<init>(r3)
            r5 = 0
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00bd }
            java.lang.String r7 = java.io.File.separator     // Catch:{ Exception -> 0x00bd }
            int r7 = r3.lastIndexOf(r7)     // Catch:{ Exception -> 0x00bd }
            r8 = 0
            java.lang.String r3 = r3.substring(r8, r7)     // Catch:{ Exception -> 0x00bd }
            r6.<init>(r3)     // Catch:{ Exception -> 0x00bd }
            boolean r3 = r6.exists()     // Catch:{ Exception -> 0x00bd }
            if (r3 != 0) goto L_0x0074
            r6.mkdirs()     // Catch:{ Exception -> 0x00bd }
        L_0x0074:
            boolean r3 = r4.isDirectory()     // Catch:{ Exception -> 0x00bd }
            if (r3 == 0) goto L_0x0080
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0080:
            java.lang.String r3 = r4.getName()     // Catch:{ Exception -> 0x00bd }
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ Exception -> 0x00bd }
            java.lang.String r6 = ".zip"
            boolean r3 = r3.endsWith(r6)     // Catch:{ Exception -> 0x00bd }
            if (r3 == 0) goto L_0x0097
            java.lang.String r3 = r4.getPath()     // Catch:{ Exception -> 0x00bd }
            r9.add(r3)     // Catch:{ Exception -> 0x00bd }
        L_0x0097:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00bd }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00bd }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
        L_0x00a0:
            int r5 = r2.read(r4)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r5 <= 0) goto L_0x00aa
            r3.write(r4, r8, r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x00a0
        L_0x00aa:
            if (r2 == 0) goto L_0x00af
            r2.close()
        L_0x00af:
            r3.close()
            goto L_0x001c
        L_0x00b4:
            r9 = move-exception
            r5 = r3
            goto L_0x00cd
        L_0x00b7:
            r4 = move-exception
            r5 = r3
            r3 = r4
            goto L_0x00be
        L_0x00bb:
            r9 = move-exception
            goto L_0x00cd
        L_0x00bd:
            r3 = move-exception
        L_0x00be:
            r3.printStackTrace()     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x00c6
            r2.close()
        L_0x00c6:
            if (r5 == 0) goto L_0x001c
            r5.close()
            goto L_0x001c
        L_0x00cd:
            if (r2 == 0) goto L_0x00d2
            r2.close()
        L_0x00d2:
            if (r5 == 0) goto L_0x00d7
            r5.close()
        L_0x00d7:
            throw r9
        L_0x00d8:
            r0.close()
            int r10 = r9.size()
            if (r10 <= 0) goto L_0x0105
            java.util.Iterator r9 = r9.iterator()
        L_0x00e5:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0105
            java.lang.Object r10 = r9.next()
            java.lang.String r10 = (java.lang.String) r10
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            java.io.File r10 = r0.getParentFile()
            java.lang.String r10 = r10.getPath()
            a((java.io.File) r0, (java.lang.String) r10)
            r0.delete()
            goto L_0x00e5
        L_0x0105:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.c.a(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052 A[SYNTHETIC, Splitter:B:26:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005b A[SYNTHETIC, Splitter:B:30:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(byte[] r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = ".zip"
            r1 = 0
            if (r6 == 0) goto L_0x0067
            if (r7 != 0) goto L_0x0008
            goto L_0x0067
        L_0x0008:
            java.io.File r2 = new java.io.File
            r2.<init>(r7)
            r3 = 0
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x004c }
            if (r2 != 0) goto L_0x003b
            java.lang.String r7 = r7.concat(r0)     // Catch:{ Exception -> 0x004c }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x004c }
            r2.<init>(r7)     // Catch:{ Exception -> 0x004c }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004c }
            r4.<init>(r2)     // Catch:{ Exception -> 0x004c }
            r4.write(r6)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            int r6 = r7.lastIndexOf(r0)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.lang.String r6 = r7.substring(r1, r6)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            a((java.io.File) r2, (java.lang.String) r6)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r2.delete()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r3 = r4
            goto L_0x003b
        L_0x0035:
            r6 = move-exception
            r3 = r4
            goto L_0x0059
        L_0x0038:
            r6 = move-exception
            r3 = r4
            goto L_0x004d
        L_0x003b:
            r1 = 1
            if (r3 == 0) goto L_0x0058
            r3.flush()     // Catch:{ Exception -> 0x0045 }
            r3.close()     // Catch:{ Exception -> 0x0045 }
            goto L_0x0058
        L_0x0045:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0058
        L_0x004a:
            r6 = move-exception
            goto L_0x0059
        L_0x004c:
            r6 = move-exception
        L_0x004d:
            r6.printStackTrace()     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0058
            r3.flush()     // Catch:{ Exception -> 0x0045 }
            r3.close()     // Catch:{ Exception -> 0x0045 }
        L_0x0058:
            return r1
        L_0x0059:
            if (r3 == 0) goto L_0x0066
            r3.flush()     // Catch:{ Exception -> 0x0062 }
            r3.close()     // Catch:{ Exception -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0066:
            throw r6
        L_0x0067:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.c.a(byte[], java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073 A[SYNTHETIC, Splitter:B:21:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A[Catch:{ Exception -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009a A[SYNTHETIC, Splitter:B:40:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a5 A[Catch:{ Exception -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b1 A[SYNTHETIC, Splitter:B:50:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bc A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.content.Context r6, java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0092, all -> 0x008e }
            r3.<init>(r8)     // Catch:{ Exception -> 0x0092, all -> 0x008e }
            boolean r3 = r3.exists()     // Catch:{ Exception -> 0x0092, all -> 0x008e }
            if (r3 == 0) goto L_0x0014
            if (r9 == 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            r6 = r1
            r9 = r6
            goto L_0x0071
        L_0x0014:
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0092, all -> 0x008e }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0092, all -> 0x008e }
            boolean r3 = r9.exists()     // Catch:{ Exception -> 0x0092, all -> 0x008e }
            if (r3 != 0) goto L_0x0022
            r9.mkdirs()     // Catch:{ Exception -> 0x0092, all -> 0x008e }
        L_0x0022:
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Exception -> 0x0092, all -> 0x008e }
            java.io.InputStream r6 = r6.open(r7)     // Catch:{ Exception -> 0x0092, all -> 0x008e }
            java.lang.String r9 = java.io.File.separator     // Catch:{ Exception -> 0x008c }
            java.lang.String[] r7 = r7.split(r9)     // Catch:{ Exception -> 0x008c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c }
            r9.<init>()     // Catch:{ Exception -> 0x008c }
            r9.append(r8)     // Catch:{ Exception -> 0x008c }
            java.lang.String r8 = java.io.File.separator     // Catch:{ Exception -> 0x008c }
            r9.append(r8)     // Catch:{ Exception -> 0x008c }
            int r8 = r7.length     // Catch:{ Exception -> 0x008c }
            int r8 = r8 - r0
            r7 = r7[r8]     // Catch:{ Exception -> 0x008c }
            r9.append(r7)     // Catch:{ Exception -> 0x008c }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x008c }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x008c }
            r8.<init>(r7)     // Catch:{ Exception -> 0x008c }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008c }
            r9.<init>(r8)     // Catch:{ Exception -> 0x008c }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
        L_0x0056:
            int r3 = r6.read(r1)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r4 = -1
            if (r3 == r4) goto L_0x0061
            r9.write(r1, r2, r3)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            goto L_0x0056
        L_0x0061:
            java.lang.String r1 = ".zip"
            int r1 = r7.lastIndexOf(r1)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            java.lang.String r7 = r7.substring(r2, r1)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            a((java.io.File) r8, (java.lang.String) r7)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r8.delete()     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
        L_0x0071:
            if (r9 == 0) goto L_0x007c
            r9.flush()     // Catch:{ Exception -> 0x007a }
            r9.close()     // Catch:{ Exception -> 0x007a }
            goto L_0x007c
        L_0x007a:
            r6 = move-exception
            goto L_0x0082
        L_0x007c:
            if (r6 == 0) goto L_0x00ad
            r6.close()     // Catch:{ Exception -> 0x007a }
            goto L_0x00ad
        L_0x0082:
            r6.printStackTrace()
            goto L_0x00ad
        L_0x0086:
            r7 = move-exception
            r1 = r9
            goto L_0x00af
        L_0x0089:
            r7 = move-exception
            r1 = r9
            goto L_0x0095
        L_0x008c:
            r7 = move-exception
            goto L_0x0095
        L_0x008e:
            r6 = move-exception
            r7 = r6
            r6 = r1
            goto L_0x00af
        L_0x0092:
            r6 = move-exception
            r7 = r6
            r6 = r1
        L_0x0095:
            r7.printStackTrace()     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x00a3
            r1.flush()     // Catch:{ Exception -> 0x00a1 }
            r1.close()     // Catch:{ Exception -> 0x00a1 }
            goto L_0x00a3
        L_0x00a1:
            r6 = move-exception
            goto L_0x00a9
        L_0x00a3:
            if (r6 == 0) goto L_0x00ac
            r6.close()     // Catch:{ Exception -> 0x00a1 }
            goto L_0x00ac
        L_0x00a9:
            r6.printStackTrace()
        L_0x00ac:
            r0 = r2
        L_0x00ad:
            return r0
        L_0x00ae:
            r7 = move-exception
        L_0x00af:
            if (r1 == 0) goto L_0x00ba
            r1.flush()     // Catch:{ Exception -> 0x00b8 }
            r1.close()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00ba
        L_0x00b8:
            r6 = move-exception
            goto L_0x00c0
        L_0x00ba:
            if (r6 == 0) goto L_0x00c3
            r6.close()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00c3
        L_0x00c0:
            r6.printStackTrace()
        L_0x00c3:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.c.a(android.content.Context, java.lang.String, java.lang.String, boolean):boolean");
    }
}
