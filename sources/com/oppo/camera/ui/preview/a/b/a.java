package com.oppo.camera.ui.preview.a.b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.oppo.camera.e;
import com.oppo.camera.util.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: VideoWatermarkRenderer */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f4364a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f4365b = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] c = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] d = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static final float[] e = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] f = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private FloatBuffer g;
    private FloatBuffer h;
    private FloatBuffer i;
    private FloatBuffer j;
    private FloatBuffer k;
    private FloatBuffer l;
    private FloatBuffer m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private float[] u;
    private float[] v;
    private float[] w;
    private float[] x;

    public a() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = false;
        this.u = new float[16];
        this.v = new float[16];
        this.w = new float[16];
        this.x = new float[16];
        this.g = a(f4364a);
        this.i = a(f4365b);
        this.j = a(c);
        this.k = a(d);
        this.l = a(e);
        this.m = a(f);
        this.n = f4364a.length / 2;
        Matrix.setIdentityM(this.u, 0);
        Matrix.setIdentityM(this.v, 0);
        Matrix.setIdentityM(this.w, 0);
        Matrix.setIdentityM(this.x, 0);
    }

    public void a() {
        if (!this.t) {
            this.o = d.b("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = aTextureCoord.xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uSampleTexture;\nvoid main() {\n    gl_FragColor = texture2D(uSampleTexture, vTextureCoord);\n}\n");
            this.p = GLES20.glGetUniformLocation(this.o, "uMVPMatrix");
            a(this.p, "uMVPMatrix");
            this.q = GLES20.glGetAttribLocation(this.o, "aPosition");
            a(this.q, "aPosition");
            this.r = GLES20.glGetAttribLocation(this.o, "aTextureCoord");
            a(this.r, "aTextureCoord");
            this.s = GLES20.glGetUniformLocation(this.o, "uSampleTexture");
            a(this.s, "uSampleTexture");
            this.t = true;
            e.b("VideoWatermarkRenderer", "onAttached, mShaderProgram: " + this.o);
        }
    }

    public void b() {
        GLES20.glDeleteProgram(this.o);
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = false;
        e.b("VideoWatermarkRenderer", "onDetached");
    }

    public void a(int i2, boolean z, int i3) {
        GLES20.glUseProgram(this.o);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i2);
        GLES20.glUniform1i(this.s, 0);
        d.a("glUniform1i mSampleTextureLoc");
        GLES20.glUniformMatrix4fv(this.p, 1, false, c(), 0);
        d.a("glUniformMatrix4fv mMVPMatrixLoc");
        GLES20.glEnableVertexAttribArray(this.q);
        GLES20.glVertexAttribPointer(this.q, 2, 5126, false, 8, this.g);
        d.a("glVertexAttribPointer mPositionLoc");
        GLES20.glEnableVertexAttribArray(this.r);
        if (i3 == 90) {
            this.h = this.j;
        } else if (i3 == 180) {
            this.h = this.k;
        } else if (i3 != 270) {
            this.h = this.i;
        } else {
            this.h = this.l;
        }
        GLES20.glVertexAttribPointer(this.r, 2, 5126, false, 8, z ? this.m : this.h);
        d.a("glVertexAttribPointer mTextureCoordLoc");
        GLES20.glDrawArrays(5, 0, this.n);
        GLES20.glDisableVertexAttribArray(this.q);
        GLES20.glDisableVertexAttribArray(this.r);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    private void a(int i2, String str) {
        if (i2 < 0) {
            throw new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    private float[] c() {
        Matrix.multiplyMM(this.x, 0, this.v, 0, this.w, 0);
        float[] fArr = this.x;
        Matrix.multiplyMM(fArr, 0, this.u, 0, fArr, 0);
        return this.x;
    }

    private FloatBuffer a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }
}
