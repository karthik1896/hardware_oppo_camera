package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.oppo.camera.a.c;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.i;
import com.oppo.camera.gl.s;
import com.oppo.camera.jni.SecurityLicenseChecker;
import com.oppo.camera.sticker.c.d;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.ui.preview.a.u;
import com.oppo.camera.util.Util;
import com.sensetime.blur.BlurFilterLibrary;
import com.sensetime.blur.STBlurPreview;
import com.sensetime.faceapi.LicenseHelper;
import java.io.File;

/* compiled from: BlurTexturePreview */
public class e extends s implements u.d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4378a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f4379b = new Object();
    private int c = 0;
    private int i = 0;
    private int j = 0;
    /* access modifiers changed from: private */
    public int k = -1;
    /* access modifiers changed from: private */
    public int l = -1;
    private s m = null;
    private s n = null;
    private boolean o = false;
    /* access modifiers changed from: private */
    public boolean p = false;
    private boolean q = true;
    /* access modifiers changed from: private */
    public STBlurPreview r = null;
    /* access modifiers changed from: private */
    public u s = null;
    /* access modifiers changed from: private */
    public boolean t = false;
    private boolean u = false;
    /* access modifiers changed from: private */
    public Handler v = null;
    /* access modifiers changed from: private */
    public HandlerThread w = null;
    private boolean x = false;

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

    public e(Context context) {
        super(context);
        this.x = d.g(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x000f, code lost:
        r6 = r11.e;
        r10 = r11.f4379b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0016, code lost:
        if (r11.r == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001a, code lost:
        if (r11.s == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001c, code lost:
        r11.r.onPreviewCallback(r12, r13, r14, r11.s.v(), r6, true, 1, (com.sensetime.blur.STBlurPreview.Callback) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r12, int r13, int r14) {
        /*
            r11 = this;
            boolean r0 = r11.t
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = r11.f4379b
            monitor-enter(r0)
            boolean r1 = r11.p     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            boolean r6 = r11.e
            java.lang.Object r10 = r11.f4379b
            monitor-enter(r10)
            com.sensetime.blur.STBlurPreview r0 = r11.r     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            com.oppo.camera.ui.preview.a.u r0 = r11.s     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            com.sensetime.blur.STBlurPreview r1 = r11.r     // Catch:{ all -> 0x002f }
            com.oppo.camera.ui.preview.a.u r0 = r11.s     // Catch:{ all -> 0x002f }
            int r5 = r0.v()     // Catch:{ all -> 0x002f }
            r7 = 1
            r8 = 1
            r9 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r1.onPreviewCallback(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r10)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r12 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x002f }
            throw r12
        L_0x0032:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.e.a(byte[], int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        if (r4.u != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        com.oppo.camera.e.e("BlurTexturePreview", "canProcess, texture is not inited");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r5) {
        /*
            r4 = this;
            boolean r5 = r4.c_(r5)
            r0 = 0
            if (r5 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.lang.Object r5 = r4.f4379b
            monitor-enter(r5)
            com.oppo.camera.ui.preview.a.u r1 = r4.s     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "BlurTexturePreview"
            java.lang.String r2 = "canProcess, Engine has not init!"
            com.oppo.camera.e.a(r1, r2)     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)     // Catch:{ all -> 0x0062 }
            return r0
        L_0x0018:
            com.oppo.camera.ui.preview.a.u r1 = r4.s     // Catch:{ all -> 0x0062 }
            int r1 = r1.v()     // Catch:{ all -> 0x0062 }
            if (r1 > 0) goto L_0x0042
            boolean r1 = r4.p     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0042
            java.lang.String r1 = "BlurTexturePreview"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r2.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = "canProcess, facesCount: "
            r2.append(r3)     // Catch:{ all -> 0x0062 }
            com.oppo.camera.ui.preview.a.u r3 = r4.s     // Catch:{ all -> 0x0062 }
            int r3 = r3.v()     // Catch:{ all -> 0x0062 }
            r2.append(r3)     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0062 }
            com.oppo.camera.e.e(r1, r2)     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)     // Catch:{ all -> 0x0062 }
            return r0
        L_0x0042:
            com.oppo.camera.ui.preview.a.u r1 = r4.s     // Catch:{ all -> 0x0062 }
            boolean r1 = r1.m()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = "BlurTexturePreview"
            java.lang.String r2 = "canProcess, not open effect"
            com.oppo.camera.e.e(r1, r2)     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)     // Catch:{ all -> 0x0062 }
            return r0
        L_0x0053:
            monitor-exit(r5)     // Catch:{ all -> 0x0062 }
            boolean r5 = r4.u
            if (r5 != 0) goto L_0x0060
            java.lang.String r5 = "BlurTexturePreview"
            java.lang.String r1 = "canProcess, texture is not inited"
            com.oppo.camera.e.e(r5, r1)
            return r0
        L_0x0060:
            r5 = 1
            return r5
        L_0x0062:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0062 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.e.a(int):boolean");
    }

    public boolean a(s.a aVar) {
        boolean z;
        int i2;
        s.a aVar2 = aVar;
        if (this.s == null || aVar2 == null || aVar2.c == null || this.m == null) {
            return false;
        }
        if (!this.t) {
            com.oppo.camera.e.d("BlurTexturePreview", "process, mSTBlurFilter not create, so return!");
            return false;
        }
        com.oppo.camera.gl.s sVar = aVar2.c;
        int g = sVar.g();
        int h = sVar.h();
        boolean z2 = this.e;
        synchronized (this.f4379b) {
            if (this.r != null) {
                if (this.q) {
                    this.r.resetSegmentThread();
                    this.r.setParam(BlurFilterLibrary.ST_BLUR_PARAM_TYPE_EFFECT_TYPE, this.p ? 1.0f : 0.0f);
                    this.q = false;
                }
                if (this.o) {
                    a(g, h, z2);
                    this.o = false;
                }
                GLES20.glViewport(0, 0, g, h);
                this.r.setParam(4097, a(this.s.a()));
                if (z2) {
                    if (this.x && this.p) {
                        Util.a(sVar.d(), g, h, "dump_retention_before");
                    }
                    if (!this.p) {
                        i2 = this.r.processTexture(sVar.d(), this.k, this.l, new int[]{this.m.d()}, false);
                        z = true;
                    } else {
                        z = true;
                        i2 = this.r.doOnPreviewProcess(sVar.d(), this.k, this.l, g, h, this.s.v(), new int[]{this.m.d()}, z2, false);
                    }
                    if (this.x && this.p) {
                        Util.a(this.m.d(), this.m.g(), this.m.h(), "dump_retention_after");
                    }
                } else {
                    z = true;
                    int i3 = this.j;
                    int i4 = 180;
                    if (i3 != 0) {
                        if (i3 == 90) {
                            i4 = 270;
                        } else if (i3 == 180) {
                            i4 = 0;
                        } else if (i3 == 270) {
                            i4 = 90;
                        }
                    }
                    this.r.rotateGrdualTexture(i4, false, false);
                    i2 = this.r.processTextureGradual(sVar.d(), this.k, this.l, new float[]{1.0f, 0.8f, 0.6f, 0.3f}, new int[]{this.m.d()}, false);
                }
                i.i();
            } else {
                z = true;
                i2 = -1;
            }
        }
        GLES20.glViewport(0, 0, aVar2.f4427a.d(), aVar2.f4427a.e());
        if (i2 != -1) {
            return z;
        }
        return false;
    }

    private float a(float f) {
        if (Float.compare(f, 0.1f) <= 0) {
            return f;
        }
        if (Float.compare(f, 0.3f) < 0) {
            return 0.4f;
        }
        if (Float.compare(f, 0.4f) < 0) {
            return 0.5f;
        }
        if (Float.compare(f, 0.5f) < 0) {
            return 0.6f;
        }
        if (Float.compare(f, 0.6f) < 0) {
            return 0.7f;
        }
        if (Float.compare(f, 0.8f) < 0) {
            return 0.8f;
        }
        return f;
    }

    public void a(u uVar) {
        com.oppo.camera.e.a("BlurTexturePreview", "createEngine, sbBlurLicenseChecked: " + f4378a + ", mBlurPreviewHandlerThread: " + this.w + ", version: " + STBlurPreview.getVersion());
        if (-1 == this.k) {
            this.k = com.oppo.camera.util.d.a(BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_portrait.png"));
            this.l = com.oppo.camera.util.d.a(BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_background.png"));
        }
        if (this.w == null) {
            this.w = new HandlerThread("BlurPreviewHandlerThread");
            this.w.start();
            this.v = new Handler(this.w.getLooper()) {
                public void handleMessage(Message message) {
                    com.oppo.camera.e.b("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, msg: " + message.what);
                    int i = message.what;
                    if (i == 1) {
                        e.this.o();
                    } else if (i == 2) {
                        boolean unused = e.this.t = false;
                        synchronized (e.this.f4379b) {
                            if (e.this.r == null) {
                                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_SINGLE_BLUR_MODEL)) {
                                    STBlurPreview unused2 = e.this.r = new STBlurPreview(e.this.h, true, "/odm/etc/camera/singleblur/portrait_retention_model.bin");
                                } else {
                                    STBlurPreview unused3 = e.this.r = new STBlurPreview(e.this.h, true);
                                }
                                e.this.r.setRetentionOpen(e.this.p);
                            }
                        }
                        boolean unused4 = e.this.t = true;
                    } else if (i == 3) {
                        synchronized (e.this.f4379b) {
                            if (e.this.r != null) {
                                e.this.r.destroy();
                                STBlurPreview unused5 = e.this.r = null;
                            }
                            u unused6 = e.this.s = null;
                        }
                        com.oppo.camera.e.a("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, MSG_DESTROY_BLUR_PREVIEW X");
                    }
                }
            };
        }
        if (!f4378a) {
            this.v.sendEmptyMessage(1);
        }
        synchronized (this.f4379b) {
            if (this.r == null) {
                this.v.sendEmptyMessage(2);
            } else {
                this.t = true;
            }
            this.s = uVar;
            if (this.s != null) {
                this.s.a((u.d) this);
            }
        }
    }

    public void e() {
        this.f.a((Runnable) new Runnable() {
            public void run() {
                com.oppo.camera.e.a("BlurTexturePreview", "destroyEngine");
                boolean unused = e.this.t = false;
                synchronized (e.this.f4379b) {
                    if (e.this.r != null) {
                        com.oppo.camera.e.a("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, destroyRender");
                        e.this.r.destroyRender();
                        i.i();
                        com.oppo.camera.e.a("BlurTexturePreview", "mBlurPreviewHandler, handleMessage, destroyRender X");
                    }
                }
                if (-1 != e.this.k) {
                    com.oppo.camera.util.d.a(e.this.k);
                    com.oppo.camera.util.d.a(e.this.l);
                    int unused2 = e.this.k = -1;
                    int unused3 = e.this.l = -1;
                }
                if (e.this.v != null) {
                    e.this.v.removeCallbacksAndMessages((Object) null);
                    if (e.this.w != null && e.this.w.isAlive()) {
                        e.this.v.sendEmptyMessage(3);
                    }
                }
                if (e.this.w != null) {
                    e.this.w.quitSafely();
                    HandlerThread unused4 = e.this.w = null;
                }
            }
        });
    }

    public com.oppo.camera.gl.s f() {
        return this.n;
    }

    public com.oppo.camera.gl.s g() {
        return this.m;
    }

    public void i() {
        com.oppo.camera.e.a("BlurTexturePreview", "newTextures");
        this.n = new com.oppo.camera.gl.s(this.c, this.i, true);
        this.m = new com.oppo.camera.gl.s(this.c, this.i, true);
        this.u = true;
        synchronized (this.f4379b) {
            this.q = true;
        }
    }

    public void a(h hVar) {
        com.oppo.camera.gl.s sVar = this.n;
        if (sVar != null && !sVar.k()) {
            this.n.c(hVar);
            com.oppo.camera.e.a("BlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.n.d());
        }
        com.oppo.camera.gl.s sVar2 = this.m;
        if (sVar2 != null && !sVar2.k()) {
            this.m.c(hVar);
            com.oppo.camera.e.a("BlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.m.d());
        }
    }

    public void j() {
        com.oppo.camera.e.a("BlurTexturePreview", "recycleTextures");
        if (this.u) {
            com.oppo.camera.gl.s sVar = this.n;
            if (sVar != null) {
                sVar.l();
                this.n = null;
            }
            com.oppo.camera.gl.s sVar2 = this.m;
            if (sVar2 != null) {
                sVar2.l();
                this.m = null;
            }
            this.u = false;
        }
    }

    public void a(int i2, int i3) {
        com.oppo.camera.e.a("BlurTexturePreview", "setSize, height: " + i2 + ", width: " + i3);
        this.c = i3;
        this.i = i2;
    }

    public void a(boolean z) {
        synchronized (this.f4379b) {
            this.o = z;
        }
    }

    public void b(int i2) {
        this.j = i2;
    }

    private void a(int i2, int i3, boolean z) {
        if (this.r != null) {
            com.oppo.camera.e.a("BlurTexturePreview", "initSTBlur, width: " + i2 + ", height: " + i3);
            this.r.initRender(i2, i3, z);
            i.i();
            com.oppo.camera.e.a("BlurTexturePreview", "initSTBlur, X");
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        if (!f4378a) {
            byte[] bArr = null;
            if (new File("/odm/etc/camera/singleblur/license_release.lic").exists()) {
                byte[] a2 = c.a("singleblur/license_release.lic");
                byte[] bArr2 = new byte[(a2.length + 1)];
                System.arraycopy(a2, 0, bArr2, 0, a2.length);
                bArr2[a2.length] = 0;
                bArr = bArr2;
            } else if (new File("/odm/etc/camera/singleblur/license_release.license").exists()) {
                bArr = SecurityLicenseChecker.decodeBuffer(this.h, c.a("singleblur/license_release.license"));
            }
            int initLicense = LicenseHelper.initLicense(bArr);
            if (initLicense != 0) {
                com.oppo.camera.e.e("BlurTexturePreview", "checkLicense failed, resultCode : " + initLicense);
                return;
            }
            f4378a = true;
            com.oppo.camera.e.a("BlurTexturePreview", "checkLicense success");
        }
    }

    public void b(boolean z) {
        synchronized (this.f4379b) {
            if (this.p != z) {
                this.p = z;
                this.q = true;
                if (this.r != null) {
                    this.r.setRetentionOpen(this.p);
                }
            }
        }
    }
}
