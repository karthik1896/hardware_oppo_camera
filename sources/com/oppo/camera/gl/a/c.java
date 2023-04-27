package com.oppo.camera.gl.a;

import android.opengl.GLES20;
import com.oppo.camera.gl.i;
import com.oppo.camera.util.d;
import java.nio.FloatBuffer;
import java.util.LinkedList;

/* compiled from: GLImageProcessor */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f3261a = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f3262b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private final LinkedList<Runnable> c = new LinkedList<>();
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean h = false;
    private int i = (f3262b.length / 2);
    private int j = -1;
    private int k = -1;
    private int[] l = null;
    private int[] m = null;

    public int b() {
        return 3553;
    }

    c(int i2, int i3, int i4, int i5) {
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = true;
    }

    public int a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i3) {
        if (i2 == -1 || this.l == null || !this.h) {
            return i2;
        }
        GLES20.glViewport(0, 0, this.j, this.k);
        GLES20.glBindFramebuffer(36160, this.l[i3]);
        i.i();
        GLES20.glUseProgram(this.d);
        i.i();
        f();
        i.i();
        a(i2, floatBuffer, floatBuffer2);
        i.i();
        GLES20.glBindFramebuffer(36160, 0);
        i.i();
        return this.m[i3];
    }

    private void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, floatBuffer);
        i.i();
        GLES20.glEnableVertexAttribArray(this.e);
        i.i();
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, floatBuffer2);
        i.i();
        GLES20.glEnableVertexAttribArray(this.f);
        i.i();
        GLES20.glActiveTexture(33984);
        i.i();
        GLES20.glBindTexture(b(), i2);
        i.i();
        GLES20.glUniform1i(this.g, 0);
        i.i();
        a();
        GLES20.glDisableVertexAttribArray(this.e);
        i.i();
        GLES20.glDisableVertexAttribArray(this.f);
        i.i();
        GLES20.glBindTexture(b(), 0);
        i.i();
        GLES20.glUseProgram(0);
    }

    /* access modifiers changed from: protected */
    public void a() {
        GLES20.glDrawArrays(5, 0, this.i);
    }

    public void c() {
        if (this.h) {
            GLES20.glDeleteProgram(this.d);
            this.d = -1;
        }
        d();
    }

    public void a(int i2, int i3, int i4) {
        if (e()) {
            if (!(this.l == null || (this.j == i2 && this.k == i3))) {
                d();
            }
            if (this.l == null) {
                this.j = i2;
                this.k = i3;
                this.l = new int[i4];
                this.m = new int[i4];
                d.a(this.l, this.m, i2, i3);
            }
        }
    }

    public void d() {
        if (this.h) {
            int[] iArr = this.m;
            if (iArr != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
                this.m = null;
            }
            int[] iArr2 = this.l;
            if (iArr2 != null) {
                GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
                this.l = null;
            }
            this.j = -1;
            this.k = -1;
        }
    }

    public boolean e() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, final int i3) {
        a(new Runnable() {
            public void run() {
                GLES20.glUniform1i(i2, i3);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, final float f2) {
        a(new Runnable() {
            public void run() {
                GLES20.glUniform1f(i2, f2);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, final float[] fArr) {
        a(new Runnable() {
            public void run() {
                int i = i2;
                float[] fArr = fArr;
                GLES20.glUniform1fv(i, fArr.length, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.c) {
            this.c.addLast(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        while (!this.c.isEmpty()) {
            this.c.removeFirst().run();
        }
    }
}
