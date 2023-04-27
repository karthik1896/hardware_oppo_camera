package com.oppo.camera.ui.menu.levelcontrol;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.oppo.camera.e;
import com.oppo.camera.gl.i;
import java.nio.ByteBuffer;

/* compiled from: WrapperTexture */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private int f4159a;

    /* renamed from: b  reason: collision with root package name */
    private int f4160b;
    private int c;
    private int d;
    private int e;

    public int g() {
        return 3553;
    }

    public m() {
        this(-1);
    }

    public m(int i) {
        this(-1, -1, i);
    }

    public m(int i, int i2, int i3) {
        this.f4159a = 0;
        this.f4160b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.c = i3;
        this.d = i;
        this.e = i2;
    }

    public void a(Bitmap bitmap) {
        try {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.f4160b = iArr[0];
            GLES20.glBindTexture(3553, c());
            i.i();
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            i.i();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e.a("WrapperTexture", "prepare, textureId: " + c() + ", mState: " + this.f4159a);
        this.f4159a = 1;
    }

    public void b(Bitmap bitmap) {
        GLES20.glBindTexture(3553, c());
        i.i();
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        i.i();
    }

    public void a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f4160b = iArr[0];
        int g = g();
        GLES20.glBindTexture(g, c());
        i.i();
        int i = g;
        GLES20.glTexImage2D(i, 0, 6408, this.d, this.e, 0, 6408, 5121, ByteBuffer.allocate(this.d * this.e * 4));
        i.i();
        GLES20.glBindTexture(g, c());
        i.i();
        GLES20.glTexParameteri(g, 10242, 33071);
        i.i();
        GLES20.glTexParameteri(g, 10243, 33071);
        i.i();
        GLES20.glTexParameterf(g, 10241, 9729.0f);
        i.i();
        GLES20.glTexParameterf(g, 10240, 9729.0f);
        i.i();
        e.a("WrapperTexture", "prepare, textureId: " + c() + ", mState: " + this.f4159a + ", width: " + this.d + ", height: " + this.e);
        this.f4159a = 1;
    }

    public void b() {
        e.a("WrapperTexture", "recycle, textureId: " + c() + ", mState: " + this.f4159a);
        if (h()) {
            GLES20.glDeleteTextures(1, new int[]{this.f4160b}, 0);
            i.i();
        }
        this.f4159a = 0;
    }

    public int c() {
        return this.f4160b;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public boolean h() {
        return this.f4159a == 1;
    }
}
