package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.Point;
import com.anc.humansdk.HumanEffectBokehApi;
import com.anc.humansdk.HumanEffectBokehConfig;
import com.anc.humansdk.NNRuntime;
import com.oppo.camera.e;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.i;
import com.oppo.camera.gl.s;
import com.oppo.camera.util.Util;
import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: VideoBlurTexturePreview */
public class w extends s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f4436a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private int f4437b = 0;
    private int c = 0;
    private int i = 0;
    private s j = null;
    private s k = null;
    private boolean l = false;
    private boolean m = false;
    /* access modifiers changed from: private */
    public HumanEffectBokehApi n = null;
    /* access modifiers changed from: private */
    public u o = null;
    /* access modifiers changed from: private */
    public boolean p = false;
    private boolean q = false;

    private int a(int i2, boolean z) {
        if (!z) {
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
        return 32;
    }

    public boolean h() {
        return false;
    }

    public w(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        if (r2.q != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        com.oppo.camera.e.a("VideoBlurTexturePreview", "canProcess, texture is not inited");
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
            java.lang.Object r3 = r2.f4436a
            monitor-enter(r3)
            com.oppo.camera.ui.preview.a.u r1 = r2.o     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return r0
        L_0x0011:
            com.oppo.camera.ui.preview.a.u r1 = r2.o     // Catch:{ all -> 0x002a }
            boolean r1 = r1.b()     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x001b
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return r0
        L_0x001b:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            boolean r3 = r2.q
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = "VideoBlurTexturePreview"
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
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.w.a(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        r12 = r12.c;
        r0 = r12.g();
        r2 = r12.h();
        r6 = r11.e;
        r10 = r11.f4436a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r11.l == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (w() != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        com.oppo.camera.e.a("VideoBlurTexturePreview", "process, inTextureWidth: " + r2 + ", inTextureHeight: " + r0);
        a(r2, r0, r6);
        r11.l = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r8 = a(r11.i, r6);
        r3 = r11;
        r0 = a(r12.d(), new int[]{r11.j.d()}, r6, r11.o.f(), r8, r11.o.B());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        if (r0 != 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
        r11.m = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        if (r0 == 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        if (4 == r0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0092, code lost:
        if (5 == r0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (6 != r0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.oppo.camera.ui.preview.a.s.a r12) {
        /*
            r11 = this;
            com.oppo.camera.ui.preview.a.u r0 = r11.o
            r1 = 0
            if (r0 == 0) goto L_0x00a0
            if (r12 == 0) goto L_0x00a0
            com.oppo.camera.gl.s r0 = r12.c
            if (r0 == 0) goto L_0x00a0
            com.oppo.camera.gl.s r0 = r11.j
            if (r0 != 0) goto L_0x0011
            goto L_0x00a0
        L_0x0011:
            java.lang.Object r0 = r11.f4436a
            monitor-enter(r0)
            boolean r2 = r11.p     // Catch:{ all -> 0x009d }
            if (r2 != 0) goto L_0x0021
            java.lang.String r12 = "VideoBlurTexturePreview"
            java.lang.String r2 = "process, not create, so return!"
            com.oppo.camera.e.a(r12, r2)     // Catch:{ all -> 0x009d }
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            return r1
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            com.oppo.camera.gl.s r12 = r12.c
            int r0 = r12.g()
            int r2 = r12.h()
            boolean r6 = r11.e
            java.lang.Object r10 = r11.f4436a
            monitor-enter(r10)
            boolean r3 = r11.l     // Catch:{ all -> 0x009a }
            if (r3 == 0) goto L_0x005e
            boolean r3 = r11.w()     // Catch:{ all -> 0x009a }
            if (r3 != 0) goto L_0x005e
            java.lang.String r3 = "VideoBlurTexturePreview"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r4.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r5 = "process, inTextureWidth: "
            r4.append(r5)     // Catch:{ all -> 0x009a }
            r4.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r5 = ", inTextureHeight: "
            r4.append(r5)     // Catch:{ all -> 0x009a }
            r4.append(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x009a }
            com.oppo.camera.e.a(r3, r4)     // Catch:{ all -> 0x009a }
            r11.a(r2, r0, r6)     // Catch:{ all -> 0x009a }
            r11.l = r1     // Catch:{ all -> 0x009a }
        L_0x005e:
            int r0 = r11.i     // Catch:{ all -> 0x009a }
            int r8 = r11.a((int) r0, (boolean) r6)     // Catch:{ all -> 0x009a }
            com.oppo.camera.ui.preview.a.u r0 = r11.o     // Catch:{ all -> 0x009a }
            float r7 = r0.f()     // Catch:{ all -> 0x009a }
            int r4 = r12.d()     // Catch:{ all -> 0x009a }
            r12 = 1
            int[] r5 = new int[r12]     // Catch:{ all -> 0x009a }
            com.oppo.camera.gl.s r0 = r11.j     // Catch:{ all -> 0x009a }
            int r0 = r0.d()     // Catch:{ all -> 0x009a }
            r5[r1] = r0     // Catch:{ all -> 0x009a }
            com.oppo.camera.ui.preview.a.u r0 = r11.o     // Catch:{ all -> 0x009a }
            android.graphics.Point r9 = r0.B()     // Catch:{ all -> 0x009a }
            r3 = r11
            int r0 = r3.a(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x009a }
            monitor-exit(r10)     // Catch:{ all -> 0x009a }
            if (r0 != 0) goto L_0x0089
            r2 = r12
            goto L_0x008a
        L_0x0089:
            r2 = r1
        L_0x008a:
            r11.m = r2
            if (r0 == 0) goto L_0x0099
            r2 = 4
            if (r2 == r0) goto L_0x0099
            r2 = 5
            if (r2 == r0) goto L_0x0099
            r2 = 6
            if (r2 != r0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r12 = r1
        L_0x0099:
            return r12
        L_0x009a:
            r12 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x009a }
            throw r12
        L_0x009d:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            throw r12
        L_0x00a0:
            java.lang.String r12 = "VideoBlurTexturePreview"
            java.lang.String r0 = "process, false"
            com.oppo.camera.e.a(r12, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.w.a(com.oppo.camera.ui.preview.a.s$a):boolean");
    }

    public boolean o() {
        return this.m;
    }

    public void a(final u uVar) {
        e.a("VideoBlurTexturePreview", "createEngine");
        this.f.a((Runnable) new Runnable() {
            public void run() {
                synchronized (w.this.f4436a) {
                    if (w.this.w()) {
                        HumanEffectBokehApi unused = w.this.n = HumanEffectBokehApi.getInstance();
                    }
                    boolean unused2 = w.this.p = true;
                    u unused3 = w.this.o = uVar;
                    e.a("VideoBlurTexturePreview", "createEngine X");
                }
            }
        });
    }

    public void e() {
        e.a("VideoBlurTexturePreview", "destroyEngine");
        this.f.a((Runnable) new Runnable() {
            public void run() {
                synchronized (w.this.f4436a) {
                    if (w.this.n != null) {
                        w.this.f.g();
                        w.this.n.release();
                        HumanEffectBokehApi unused = w.this.n = null;
                    }
                    u unused2 = w.this.o = null;
                    boolean unused3 = w.this.p = false;
                    e.a("VideoBlurTexturePreview", "destroyEngine X");
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
        e.a("VideoBlurTexturePreview", "newTextures");
        this.k = new s(this.f4437b, this.c, true);
        this.j = new s(this.f4437b, this.c, true);
        this.q = true;
    }

    public void a(h hVar) {
        s sVar = this.k;
        if (sVar != null && !sVar.k()) {
            this.k.c(hVar);
            e.a("VideoBlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.k.d());
        }
        s sVar2 = this.j;
        if (sVar2 != null && !sVar2.k()) {
            this.j.c(hVar);
            e.a("VideoBlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.j.d());
        }
    }

    public void j() {
        e.a("VideoBlurTexturePreview", "recycleTextures");
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
        e.a("VideoBlurTexturePreview", "setSize, height: " + i2 + ", width: " + i3);
        this.f4437b = i3;
        this.c = i2;
    }

    public void a(boolean z) {
        synchronized (this.f4436a) {
            this.l = z;
        }
    }

    public void b(int i2) {
        this.i = i2;
    }

    private void a(int i2, int i3, boolean z) {
        if (!w()) {
            e.a("VideoBlurTexturePreview", "initVideoBlur, width: " + i2 + ", height: " + i3 + ", isFrontCamera: " + z);
            StringBuilder sb = new StringBuilder();
            sb.append(this.h.getApplicationContext().getCacheDir());
            sb.append(File.separator);
            sb.append("anc_cache");
            String sb2 = sb.toString();
            try {
                File file = new File(sb2);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            HumanEffectBokehConfig humanEffectBokehConfig = new HumanEffectBokehConfig();
            humanEffectBokehConfig.setRealTime(true);
            humanEffectBokehConfig.setCachePath(sb2);
            humanEffectBokehConfig.setModelPath("odm/etc/camera/megvii/merged_model");
            humanEffectBokehConfig.setNativeLibPath("/odm/lib64;/odm/lib/rfsa/adsp");
            humanEffectBokehConfig.setRuntime((Util.p() ? NNRuntime.RUNTIME_SNPE : NNRuntime.RUNTIME_AIA).value());
            e.a("VideoBlurTexturePreview", "initVideoBlur, config: " + humanEffectBokehConfig);
            p();
            int initByConfig = this.n.initByConfig(humanEffectBokehConfig);
            this.n.setLogLevel(e.a() ? 4 : 0);
            i.i();
            e.a("VideoBlurTexturePreview", "initVideoBlur, X, initResult: " + initByConfig);
        }
    }

    private void p() {
        try {
            e.a("VideoBlurTexturePreview", "load AncHumBokeh-jni");
            if (Util.p()) {
                System.loadLibrary("AncHumBokeh-jni.qti");
            } else {
                System.loadLibrary("AncHumBokeh-jni.trustonic");
            }
            Field declaredField = HumanEffectBokehApi.class.getDeclaredField("isSoLoaded");
            declaredField.setAccessible(true);
            declaredField.set(HumanEffectBokehApi.class, new AtomicBoolean(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int a(int i2, int[] iArr, boolean z, float f, int i3, Point point) {
        int i4;
        Point point2 = point;
        if (w() || iArr == null) {
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (point2 != null) {
            float f2 = (float) point2.y;
            int i5 = this.f4437b;
            i4 = this.n.process(i2, iArr[0], -1, (int[]) null, (int[]) null, f, i3, z ? 1 : 0, (float) point2.x, f2, i5, this.c);
        } else {
            HumanEffectBokehApi humanEffectBokehApi = this.n;
            int i6 = iArr[0];
            int i7 = this.f4437b;
            int i8 = this.c;
            i4 = humanEffectBokehApi.process(i2, i6, -1, (int[]) null, (int[]) null, f, i3, z ? 1 : 0, 0.0f, 0.0f, i7, i8);
        }
        e.a("VideoBlurTexturePreview", "processVideoBlur, result: " + i4 + ", costTime: " + (System.currentTimeMillis() - currentTimeMillis));
        i.i();
        return i4;
    }

    /* access modifiers changed from: private */
    public boolean w() {
        return this.n == null;
    }
}
