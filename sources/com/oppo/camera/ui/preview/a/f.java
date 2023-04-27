package com.oppo.camera.ui.preview.a;

import android.content.Context;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.facebeauty.OppoFaceBeautyPreview;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.i;
import com.oppo.camera.gl.s;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.util.Util;

/* compiled from: FaceSlenderTexturePreview */
public class f extends s {

    /* renamed from: a  reason: collision with root package name */
    private s f4382a;

    /* renamed from: b  reason: collision with root package name */
    private s f4383b;
    /* access modifiers changed from: private */
    public u c;
    /* access modifiers changed from: private */
    public OppoFaceBeautyPreview i;
    private boolean j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private float q;
    /* access modifiers changed from: private */
    public final Object r;

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public int d() {
        return 4;
    }

    public boolean h() {
        return false;
    }

    public f(Context context) {
        super(context);
        this.f4382a = null;
        this.f4383b = null;
        this.c = null;
        this.i = null;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = 1;
        this.q = 1.0f;
        this.r = new Object();
        this.o = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE);
        if (e.a()) {
            this.p = 2;
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        synchronized (this.r) {
            if (!(this.i == null || bArr == null)) {
                this.i.updataMetaParams(bArr);
            }
        }
    }

    public boolean a(s.a aVar) {
        if (this.c == null || aVar == null || aVar.c == null) {
            e.a("FaceSlenderTexturePreview", "process, mRequest: " + this.c + ", frameInfo: " + aVar);
            return false;
        }
        if (this.j) {
            b(aVar.c.g(), aVar.c.h());
            this.j = false;
        }
        if (this.i == null) {
            return false;
        }
        e.a("FaceSlenderTexturePreview.process");
        this.i.updataPreviewParams(this.c.p());
        this.i.process(aVar.c.d(), new int[]{this.f4383b.d()}, (int[]) null, this.c.l());
        e.b("FaceSlenderTexturePreview.process");
        float zoomScale = this.i.getZoomScale();
        if (!(this.c.A() == null || Float.compare(zoomScale, this.q) == 0)) {
            e.a("FaceSlenderTexturePreview", "process, zoomScale: " + zoomScale);
            this.q = zoomScale;
            this.c.A().a(zoomScale);
        }
        return true;
    }

    public int k() {
        OppoFaceBeautyPreview oppoFaceBeautyPreview = this.i;
        if (oppoFaceBeautyPreview != null) {
            return oppoFaceBeautyPreview.reset();
        }
        return -1;
    }

    public boolean a(int i2) {
        int i3;
        boolean z = false;
        if (!c_(i2)) {
            return false;
        }
        if (this.f4383b == null || this.f4382a == null) {
            e.d("FaceSlenderTexturePreview", "canProcess, mOutputTexture or mInputTexture is null, mOutputTexture: " + this.f4383b + ", mInputTexture: " + this.f4382a);
            return false;
        } else if (!this.m) {
            e.d("FaceSlenderTexturePreview", "canProcess, texture is not inited");
            return false;
        } else if (this.c == null) {
            e.d("FaceSlenderTexturePreview", "canProcess, mRequest is null");
            return false;
        } else {
            try {
                if (!Util.p() && this.c.v() == 0 && this.c.A() != null && !this.c.A().a() && !this.e) {
                    return false;
                }
                i3 = this.c.h();
                if (i3 != 0) {
                    z = true;
                }
                if (!this.n && z) {
                    k();
                }
                this.n = z;
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                i3 = 0;
            }
        }
    }

    private void b(int i2, int i3) {
        boolean z;
        e.a("FaceSlenderTexturePreview", "initOppoFaceBeautyPreview, textureWidth: " + i2 + ", textureHeight: " + i3 + ", facebeauty version: " + this.o);
        e.a("initOppoFaceBeautyPreview");
        boolean a2 = this.c.A() != null ? this.c.A().a() : false;
        synchronized (this.r) {
            if (this.i != null) {
                this.i.destroy();
            }
            this.i = new OppoFaceBeautyPreview();
            OppoFaceBeautyPreview oppoFaceBeautyPreview = this.i;
            int i4 = this.o;
            int i5 = this.p;
            String Y = Util.Y();
            String Z = Util.Z();
            String aa = Util.aa();
            if (!a2) {
                if (!this.e) {
                    z = false;
                    oppoFaceBeautyPreview.init(i2, i3, i4, i5, Y, Z, aa, z, true, this.c.o(), this.c.u());
                }
            }
            z = true;
            oppoFaceBeautyPreview.init(i2, i3, i4, i5, Y, Z, aa, z, true, this.c.o(), this.c.u());
        }
        e.b("initOppoFaceBeautyPreview");
        e.a("FaceSlenderTexturePreview", "initOppoFaceBeautyPreview, X");
    }

    public void a(boolean z) {
        e.a("FaceSlenderTexturePreview", "setTextureSizeChanged, sizeChanged: " + z);
        this.j = z;
    }

    public void a(u uVar) {
        e.a("FaceSlenderTexturePreview", "createEngine");
        this.c = uVar;
    }

    public void e() {
        this.f.a((Runnable) new Runnable() {
            public void run() {
                e.a("FaceSlenderTexturePreview", "destroyEngine");
                if (f.this.c == null || f.this.f == null) {
                    e.e("FaceSlenderTexturePreview", "destroyEngine, mRequest: " + f.this.c + ", mGLRootView: " + f.this.f);
                    u unused = f.this.c = null;
                    return;
                }
                synchronized (f.this.r) {
                    e.a("FaceSlenderTexturePreview", "destroyEngine, mOppoFaceBeautyPreview: " + f.this.i);
                    if (f.this.i != null) {
                        f.this.i.destroy();
                        i.i();
                        OppoFaceBeautyPreview unused2 = f.this.i = null;
                    }
                }
                u unused3 = f.this.c = null;
                e.a("FaceSlenderTexturePreview", "destroyEngine X");
            }
        });
    }

    public void i() {
        e.a("FaceSlenderTexturePreview", "newTextures");
        this.f4382a = new com.oppo.camera.gl.s(this.k, this.l, true);
        this.f4383b = new com.oppo.camera.gl.s(this.k, this.l, true);
        this.m = true;
    }

    public com.oppo.camera.gl.s f() {
        return this.f4382a;
    }

    public com.oppo.camera.gl.s g() {
        return this.f4383b;
    }

    public void a(h hVar) {
        com.oppo.camera.gl.s sVar = this.f4382a;
        if (sVar != null && !sVar.k()) {
            this.f4382a.c(hVar);
            e.a("FaceSlenderTexturePreview", "prepareTextures, texture id: " + this.f4382a.d());
        }
        com.oppo.camera.gl.s sVar2 = this.f4383b;
        if (sVar2 != null && !sVar2.k()) {
            this.f4383b.c(hVar);
            e.a("FaceSlenderTexturePreview", "prepareTextures, texture id: " + this.f4383b.d());
        }
    }

    public void j() {
        if (this.m) {
            if (this.f4382a != null) {
                e.a("FaceSlenderTexturePreview", "recycleTextures, texture id: " + this.f4382a.d());
                this.f4382a.l();
                this.f4382a = null;
            }
            if (this.f4383b != null) {
                e.a("FaceSlenderTexturePreview", "recycleTextures, texture id: " + this.f4383b.d());
                this.f4383b.l();
                this.f4383b = null;
            }
            this.m = false;
        }
    }

    public void a(int i2, int i3) {
        e.a("FaceSlenderTexturePreview", "setSize, height: " + i2 + ", width: " + i3);
        this.k = i3;
        this.l = i2;
    }
}
