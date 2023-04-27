package com.oppo.camera.ui.preview.a.b;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.oppo.camera.e;
import com.oppo.camera.gl.c;
import com.oppo.camera.gl.h;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.ui.preview.a.u;
import java.nio.Buffer;

/* compiled from: VideoWatermarkTexturePreview */
public class b extends s {

    /* renamed from: a  reason: collision with root package name */
    private com.oppo.camera.gl.s f4366a = null;

    /* renamed from: b  reason: collision with root package name */
    private u f4367b = null;
    private a c = null;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int[] o = new int[1];
    private int[] p = new int[1];
    private int[] q = new int[1];

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public int d() {
        return 128;
    }

    public com.oppo.camera.gl.s g() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public b(Context context) {
        super(context);
        e.a("VideoWatermarkTexturePreview", "VideoWatermarkTexturePreview");
    }

    public void a(u uVar) {
        e.a("VideoWatermarkTexturePreview", "createEngine");
        this.f4367b = uVar;
    }

    public void e() {
        this.f.a((Runnable) new Runnable() {
            public final void run() {
                b.this.o();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o() {
        e.a("VideoWatermarkTexturePreview", "destroyEngine");
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
            this.c = null;
        }
        u uVar = this.f4367b;
        if (!(uVar == null || uVar.q() == null || this.f4367b.q().isRecycled())) {
            e.a("VideoWatermarkTexturePreview", "destroyEngine, recycle watermark bitmap.");
            this.f4367b.q().recycle();
        }
        this.f4367b = null;
    }

    public com.oppo.camera.gl.s f() {
        return this.f4366a;
    }

    public void i() {
        e.b("VideoWatermarkTexturePreview", "newTextures, mPreviewTextureWidth: " + this.j + ", mPreviewTextureHeight: " + this.k);
        this.f4366a = new com.oppo.camera.gl.s(this.j, this.k, false);
        this.i = true;
    }

    public void a(h hVar) {
        com.oppo.camera.gl.s sVar = this.f4366a;
        if (sVar != null && !sVar.k()) {
            this.f4366a.c(hVar);
            e.a("VideoWatermarkTexturePreview", "prepareTextures, mInputTexture id: " + this.f4366a.d());
        }
        u uVar = this.f4367b;
        if (uVar != null && uVar.q() != null && !this.f4367b.q().isRecycled() && this.f4367b.t()) {
            this.l = this.f4367b.q().getWidth();
            this.m = this.f4367b.q().getHeight();
            if (GLES20.glIsTexture(this.o[0])) {
                GLES20.glDeleteTextures(1, this.o, 0);
                this.o[0] = 0;
            }
            GLES20.glGenTextures(1, this.o, 0);
            GLES20.glBindTexture(3553, this.o[0]);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, this.f4367b.q(), 0);
            this.f4367b.h(false);
            e.b("VideoWatermarkTexturePreview", "prepareTextures, BitmapTexture: " + this.o[0]);
        }
        int[] iArr = this.p;
        if (iArr[0] == 0) {
            GLES20.glGenTextures(1, iArr, 0);
            int[] iArr2 = this.p;
            if (iArr2[0] != 0) {
                GLES20.glBindTexture(3553, iArr2[0]);
                GLES20.glTexParameteri(3553, 10241, 9728);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexImage2D(3553, 0, 6408, this.j, this.k, 0, 6408, 5121, (Buffer) null);
                e.b("VideoWatermarkTexturePreview", "prepareTextures, mOutTextures: " + this.p[0]);
            } else {
                int glGetError = GLES20.glGetError();
                throw new RuntimeException("Could not create a new texture buffer object, glErrorString: " + GLES20.glGetString(glGetError));
            }
        }
        int[] iArr3 = this.q;
        if (iArr3[0] == 0) {
            GLES20.glGenFramebuffers(1, iArr3, 0);
            if (this.q[0] != 0) {
                e.b("VideoWatermarkTexturePreview", "prepareTextures, mFBOs: " + this.q[0]);
            } else {
                int glGetError2 = GLES20.glGetError();
                throw new RuntimeException("Could not create a new frame buffer object, glErrorString: " + GLES20.glGetString(glGetError2));
            }
        }
        if (this.c == null) {
            this.c = new a();
        }
        this.c.a();
    }

    public void j() {
        if (this.f4366a != null) {
            e.a("VideoWatermarkTexturePreview", "recycleTextures, mInputTexture id: " + this.f4366a.d());
            this.f4366a.l();
            this.f4366a = null;
        }
        GLES20.glDeleteFramebuffers(1, this.q, 0);
        GLES20.glDeleteTextures(1, this.o, 0);
        GLES20.glDeleteTextures(1, this.p, 0);
        this.q[0] = 0;
        this.o[0] = 0;
        this.p[0] = 0;
        this.i = false;
        u uVar = this.f4367b;
        if (uVar != null && uVar.q() != null && !this.f4367b.q().isRecycled()) {
            e.a("VideoWatermarkTexturePreview", "recycleTextures, recycle watermark bitmap.");
            this.f4367b.q().recycle();
        }
    }

    public boolean a(int i2) {
        if (!c_(i2)) {
            return false;
        }
        if (!this.i) {
            e.d("VideoWatermarkTexturePreview", "canProcess, texture is not initialized");
            return false;
        }
        u uVar = this.f4367b;
        if (uVar == null) {
            return false;
        }
        return uVar.r();
    }

    public boolean a(s.a aVar) {
        if (aVar == null || aVar.c == null) {
            e.a("VideoWatermarkTexturePreview", "process, frameInfo: " + aVar);
            return false;
        }
        a(this.p, this.q);
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glViewport(0, 0, this.j, this.k);
        aVar.f4427a.a((c) aVar.c, aVar.h, aVar.k, aVar.l, aVar.i, aVar.j);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        int i2 = this.n;
        if (i2 == 90) {
            int i3 = this.j;
            int i4 = this.m;
            GLES20.glViewport(i3 - i4, 0, i4, this.l);
        } else if (i2 == 180) {
            int i5 = this.j;
            int i6 = this.l;
            int i7 = this.k;
            int i8 = this.m;
            GLES20.glViewport(i5 - i6, i7 - i8, i6, i8);
        } else if (i2 != 270) {
            GLES20.glViewport(0, 0, this.l, this.m);
        } else {
            int i9 = this.k;
            int i10 = this.l;
            GLES20.glViewport(0, i9 - i10, this.m, i10);
        }
        this.c.a(this.o[0], false, this.n);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.j, this.k);
        this.c.a(this.p[0], true, this.n);
        GLES20.glDisable(3042);
        return true;
    }

    public void a(int i2, int i3) {
        e.a("VideoWatermarkTexturePreview", "setSize, width: " + i3 + ", height: " + i2);
        this.j = i2;
        this.k = i3;
    }

    private void a(int[] iArr, int[] iArr2) {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            GLES20.glBindFramebuffer(36160, iArr2[i2]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr[i2], 0);
        }
    }

    public void b(int i2) {
        u uVar = this.f4367b;
        if (uVar != null && !uVar.s()) {
            e.b("VideoWatermarkTexturePreview", "setOrientation, orientation: " + i2);
            this.n = i2;
        }
    }
}
