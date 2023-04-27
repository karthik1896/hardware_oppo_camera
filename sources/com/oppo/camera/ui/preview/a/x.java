package com.oppo.camera.ui.preview.a;

import android.content.Context;
import com.anc.humanvideo.HumanVideoApi;
import com.oppo.camera.e;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.i;
import com.oppo.camera.gl.s;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.util.Util;
import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: VideoRetentionTexturePreview */
public class x extends s {

    /* renamed from: a  reason: collision with root package name */
    private int f4441a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4442b = 0;
    private int c = 0;
    /* access modifiers changed from: private */
    public boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private Context m = null;
    private s n = null;
    private s o = null;
    /* access modifiers changed from: private */
    public HumanVideoApi p = null;
    /* access modifiers changed from: private */
    public u q = null;
    private HumanVideoApi.HumanVideoConfig r = null;
    /* access modifiers changed from: private */
    public Lock s = new ReentrantLock();

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r6 != false) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r6 != false) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(int r5, boolean r6) {
        /*
            r4 = this;
            r0 = 180(0xb4, float:2.52E-43)
            r1 = 0
            r2 = 270(0x10e, float:3.78E-43)
            r3 = 90
            if (r5 == 0) goto L_0x0015
            if (r5 == r3) goto L_0x0018
            if (r5 == r0) goto L_0x000f
            r0 = r1
            goto L_0x0018
        L_0x000f:
            if (r6 == 0) goto L_0x0013
        L_0x0011:
            r0 = r2
            goto L_0x0018
        L_0x0013:
            r0 = r3
            goto L_0x0018
        L_0x0015:
            if (r6 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.x.a(int, boolean):int");
    }

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public int d() {
        return 256;
    }

    public boolean h() {
        return false;
    }

    public x(Context context) {
        super(context);
        this.m = context;
    }

    /* JADX INFO: finally extract failed */
    public boolean a(int i2) {
        if (!c_(i2)) {
            return false;
        }
        this.s.lock();
        try {
            if (this.q == null || !this.q.g()) {
                this.s.unlock();
                return false;
            }
            this.s.unlock();
            if (this.j) {
                return true;
            }
            e.a("VideoRetentionTexturePreview", "canProcess, texture is not init");
            return false;
        } catch (Throwable th) {
            this.s.unlock();
            throw th;
        }
    }

    public boolean a(s.a aVar) {
        this.s.lock();
        try {
            boolean z = false;
            if (!(this.q == null || aVar == null)) {
                if (aVar.c != null) {
                    if (this.n != null) {
                        if (!this.i) {
                            e.a("VideoRetentionTexturePreview", "process, not create, so return!");
                            return false;
                        }
                        this.s.unlock();
                        com.oppo.camera.gl.s sVar = aVar.c;
                        int i2 = -1;
                        int g = sVar.g();
                        int h = sVar.h();
                        boolean z2 = this.e;
                        this.s.lock();
                        try {
                            if (this.k && !y()) {
                                e.a("VideoRetentionTexturePreview", "process, inTextureWidth: " + h + ", inTextureHeight: " + g);
                                a(h, g, z2);
                                this.k = false;
                            }
                            int a2 = a(this.c, z2);
                            if (this.q.g()) {
                                i2 = a(sVar.d(), new int[]{this.n.d()}, z2, a2);
                            }
                            if (i2 == 0 || 4 == i2) {
                                z = true;
                            }
                            this.l = z;
                            return this.l;
                        } finally {
                            this.s.unlock();
                        }
                    }
                }
            }
            e.a("VideoRetentionTexturePreview", "process, false");
            return false;
        } finally {
            this.s.unlock();
        }
    }

    public boolean o() {
        return this.l;
    }

    public void a(final u uVar) {
        e.a("VideoRetentionTexturePreview", "createEngine");
        this.f.a((Runnable) new Runnable() {
            public void run() {
                x.this.s.lock();
                try {
                    if (x.this.y()) {
                        x.this.x();
                    }
                    boolean unused = x.this.i = true;
                    u unused2 = x.this.q = uVar;
                    e.a("VideoRetentionTexturePreview", "createEngine X");
                } finally {
                    x.this.s.unlock();
                }
            }
        });
    }

    public void e() {
        e.a("VideoRetentionTexturePreview", "destroyEngine");
        this.f.a((Runnable) new Runnable() {
            public void run() {
                x.this.s.lock();
                try {
                    if (x.this.p != null) {
                        x.this.f.g();
                        x.this.p.release();
                        HumanVideoApi unused = x.this.p = null;
                    }
                    u unused2 = x.this.q = null;
                    boolean unused3 = x.this.i = false;
                    e.a("VideoRetentionTexturePreview", "destroyEngine X");
                } finally {
                    x.this.s.unlock();
                }
            }
        });
    }

    public com.oppo.camera.gl.s f() {
        return this.o;
    }

    public com.oppo.camera.gl.s g() {
        return this.n;
    }

    public void i() {
        e.a("VideoRetentionTexturePreview", "newTextures");
        this.o = new com.oppo.camera.gl.s(this.f4441a, this.f4442b, true);
        this.n = new com.oppo.camera.gl.s(this.f4441a, this.f4442b, true);
        this.j = true;
    }

    public void a(h hVar) {
        com.oppo.camera.gl.s sVar = this.o;
        if (sVar != null && !sVar.k()) {
            this.o.c(hVar);
            e.a("VideoRetentionTexturePreview", "prepareTextures, mInputTexture.getId: " + this.o.d());
        }
        com.oppo.camera.gl.s sVar2 = this.n;
        if (sVar2 != null && !sVar2.k()) {
            this.n.c(hVar);
            e.a("VideoRetentionTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.n.d());
        }
    }

    public void j() {
        e.a("VideoRetentionTexturePreview", "recycleTextures");
        if (this.j) {
            com.oppo.camera.gl.s sVar = this.o;
            if (sVar != null) {
                sVar.l();
                this.o = null;
            }
            com.oppo.camera.gl.s sVar2 = this.n;
            if (sVar2 != null) {
                sVar2.l();
                this.n = null;
            }
            this.j = false;
        }
    }

    public void a(int i2, int i3) {
        e.a("VideoRetentionTexturePreview", "setSize, height: " + i2 + ", width: " + i3);
        this.f4441a = i3;
        this.f4442b = i2;
    }

    public void a(boolean z) {
        this.s.lock();
        try {
            this.k = z;
        } finally {
            this.s.unlock();
        }
    }

    public void b(int i2) {
        this.c = i2;
    }

    private void a(int i2, int i3, boolean z) {
        if (!y()) {
            e.a("VideoRetentionTexturePreview", "initVideoEffect, width: " + i2 + ", height: " + i3 + ", isFrontCamera: " + z);
            if (this.r == null) {
                this.r = w();
            }
            p();
            this.p.release();
            b(z);
            i.i();
        }
    }

    private void p() {
        try {
            if (Util.p()) {
                System.loadLibrary("AncHumanVideo-jni.qti");
                e.a("VideoRetentionTexturePreview", "load AncHumanVideo-jni.qti");
            } else {
                e.a("VideoRetentionTexturePreview", "load AncHumanVideo-jni.trustonic");
                System.loadLibrary("AncHumanVideo-jni.trustonic");
            }
            Field declaredField = HumanVideoApi.class.getDeclaredField("isSoLoaded");
            declaredField.setAccessible(true);
            declaredField.set(HumanVideoApi.class, new AtomicBoolean(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int a(int i2, int[] iArr, boolean z, int i3) {
        if (y() || iArr == null) {
            return -1;
        }
        e.a("VideoRetentionTexturePreview", "processVideoEffect, textureInput: " + i2 + ", textureOutput[0]: " + iArr[0] + ", isFrontCamera: " + z + ", orientation: " + i3 + ", mWidth: " + this.f4441a + ", mHeight: " + this.f4442b);
        long currentTimeMillis = System.currentTimeMillis();
        int a2 = a(i2, iArr, i3);
        i.i();
        StringBuilder sb = new StringBuilder();
        sb.append("processVideoEffect X, costTime: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        e.a("VideoRetentionTexturePreview", sb.toString());
        return a2;
    }

    private void a(HumanVideoApi.HumanProcessTextureRequest humanProcessTextureRequest, int i2, int i3) {
        humanProcessTextureRequest.humanTexture.height = this.f4442b;
        humanProcessTextureRequest.humanTexture.width = this.f4441a;
        humanProcessTextureRequest.humanTexture.rotation = i3;
        humanProcessTextureRequest.humanTexture.texID = i2;
        humanProcessTextureRequest.humanTexture.isOES = false;
    }

    private void a(HumanVideoApi.HumanProcessTexureResult humanProcessTexureResult, int[] iArr, int i2) {
        humanProcessTexureResult.humanTexture.texID = iArr[0];
        humanProcessTexureResult.humanTexture.rotation = i2;
        humanProcessTexureResult.humanTexture.width = this.f4441a;
        humanProcessTexureResult.humanTexture.height = this.f4442b;
        humanProcessTexureResult.humanTexture.isOES = false;
    }

    private HumanVideoApi.HumanVideoConfig w() {
        String str = this.m.getApplicationContext().getCacheDir() + File.separator + "anc_cache";
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        HumanVideoApi.HumanVideoConfig humanVideoConfig = new HumanVideoApi.HumanVideoConfig();
        humanVideoConfig.sdkCapability = HumanVideoApi.FeatureType.ANCHUM_FEATURE_RETAIN.getValue();
        humanVideoConfig.nativeLibPath = this.m.getApplicationInfo().nativeLibraryDir;
        humanVideoConfig.isRealTime = true;
        humanVideoConfig.cachePath = str;
        humanVideoConfig.modelPath = "odm/etc/camera/megvii/video_retention_model";
        return humanVideoConfig;
    }

    /* access modifiers changed from: private */
    public void x() {
        this.p = HumanVideoApi.getInstance();
        this.p.setLogLevel(4);
    }

    private int a(int i2, int[] iArr, int i3) {
        HumanVideoApi.HumanProcessTextureRequest humanProcessTextureRequest = new HumanVideoApi.HumanProcessTextureRequest();
        HumanVideoApi.HumanProcessTexureResult humanProcessTexureResult = new HumanVideoApi.HumanProcessTexureResult();
        a(humanProcessTextureRequest, i2, i3);
        a(humanProcessTexureResult, iArr, i3);
        int process = this.p.process(humanProcessTextureRequest, humanProcessTexureResult);
        e.a("VideoRetentionTexturePreview", "processVideoEffect, processResult: " + process);
        return process;
    }

    private void b(boolean z) {
        int initHandle = this.p.initHandle(this.r);
        this.p.enableRuntimeFeature(HumanVideoApi.FeatureType.ANCHUM_FEATURE_BOKEH, false);
        this.p.enableRuntimeFeature(HumanVideoApi.FeatureType.ANCHUM_FEATURE_RETAIN, true);
        HumanVideoApi.HumanVideoRetainParams humanVideoRetainParams = new HumanVideoApi.HumanVideoRetainParams();
        humanVideoRetainParams.bgPath = "odm/etc/camera/megvii/videolut_background.png";
        if (z) {
            humanVideoRetainParams.fgPath = "odm/etc/camera/megvii/videolut_portrait_front.png";
        } else {
            humanVideoRetainParams.fgPath = "odm/etc/camera/megvii/videolut_portrait.png";
        }
        int params = this.p.setParams(humanVideoRetainParams);
        e.a("VideoRetentionTexturePreview", "initVideoLut  initResult:" + initHandle + " paraRet:" + params);
    }

    /* access modifiers changed from: private */
    public boolean y() {
        return this.p == null;
    }
}
