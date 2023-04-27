package com.oppo.camera.gl;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.util.d;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import javax.microedition.khronos.opengles.GL11;

/* compiled from: GLES20Canvas */
public class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3286a = "i";

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f3287b = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] c = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static final k d = new j();
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private int[] K = new int[1];
    private ArrayList<s> L = new ArrayList<>();
    private final float[] e = new float[4];
    private final o f = new o();
    private final o g = new o();
    private final float[] h = new float[32];
    private final float[] i = new float[4];
    private final RectF j = new RectF();
    private final RectF k = new RectF();
    private final float[] l = new float[16];
    private final int[] m = new int[1];
    private b[] n = {new a("aPosition"), new c("uMatrix"), new c("uColor")};
    private b[] o = {new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha")};
    private b[] p = {new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha")};
    private b[] q = {new a("aPosition"), new c("uMatrix"), new a("aTextureCoordinate"), new c("uTextureSampler"), new c("uAlpha")};
    private float[] r = new float[128];
    private float[] s = new float[8];
    private o t = new o();
    private int u = 0;
    private int v = 0;
    private int w;
    private int x;
    private float[] y = new float[16];
    private int z;

    public i() {
        Matrix.setIdentityM(this.l, 0);
        Matrix.setIdentityM(this.r, this.v);
        this.s[this.u] = 1.0f;
        this.L.add((Object) null);
        this.F = a(b(f3287b));
        int a2 = a(35633, d.a(Util.f(), (int) R.raw.draw_vertex_shader));
        int a3 = a(35633, d.a(Util.f(), (int) R.raw.texture_vertex_shader));
        int a4 = a(35633, d.a(Util.f(), (int) R.raw.mesh_vertex_shader));
        int a5 = a(35632, d.a(Util.f(), (int) R.raw.draw_fragment_shader));
        int a6 = a(35632, d.a(Util.f(), (int) R.raw.texture_fragment_shader));
        int a7 = a(35632, d.a(Util.f(), (int) R.raw.oes_texture_fragment_shader));
        this.B = a(a2, a5, this.n);
        this.C = a(a3, a6, this.o);
        this.D = a(a3, a7, this.p);
        this.E = a(a4, a6, this.q);
        GLES20.glBlendFunc(1, 771);
        i();
    }

    private static FloatBuffer b(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return asFloatBuffer;
    }

    private static int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        i();
        GLES20.glShaderSource(glCreateShader, str);
        i();
        GLES20.glCompileShader(glCreateShader);
        i();
        return glCreateShader;
    }

    private static void a(c cVar, RectF rectF) {
        int e2 = cVar.e();
        int f2 = cVar.f();
        int i2 = 1;
        int i3 = 0;
        if (cVar.i()) {
            e2--;
            f2--;
            i3 = 1;
        } else {
            i2 = 0;
        }
        rectF.set((float) i2, (float) i3, (float) e2, (float) f2);
    }

    private static void a(RectF rectF, RectF rectF2, c cVar) {
        int e2 = cVar.e();
        int f2 = cVar.f();
        int g2 = cVar.g();
        int h2 = cVar.h();
        float f3 = (float) g2;
        rectF.left /= f3;
        rectF.right /= f3;
        float f4 = (float) h2;
        rectF.top /= f4;
        rectF.bottom /= f4;
        float f5 = ((float) e2) / f3;
        if (rectF.right > f5) {
            rectF2.right = rectF2.left + ((rectF2.width() * (f5 - rectF.left)) / rectF.width());
            rectF.right = f5;
        }
        float f6 = ((float) f2) / f4;
        if (rectF.bottom > f6) {
            rectF2.bottom = rectF2.top + ((rectF2.height() * (f6 - rectF.top)) / rectF.height());
            rectF.bottom = f6;
        }
    }

    private static void j() {
        String str;
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            switch (glCheckFramebufferStatus) {
                case 36054:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT";
                    break;
                case 36055:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT";
                    break;
                case 36057:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
                    break;
                case 36061:
                    str = "GL_FRAMEBUFFER_UNSUPPORTED";
                    break;
                default:
                    str = "";
                    break;
            }
            throw new RuntimeException(str + ":" + Integer.toHexString(glCheckFramebufferStatus));
        }
    }

    public static void i() {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Throwable th = new Throwable();
            String str = f3286a;
            e.d(str, "GL error: " + glGetError, th);
        }
    }

    private int a(int i2, int i3, b[] bVarArr) {
        int glCreateProgram = GLES20.glCreateProgram();
        i();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i2);
            i();
            GLES20.glAttachShader(glCreateProgram, i3);
            i();
            GLES20.glLinkProgram(glCreateProgram);
            i();
            int[] iArr = this.m;
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            i();
            if (iArr[0] != 1) {
                e.e(f3286a, "Could not link program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
                i();
                GLES20.glDeleteProgram(glCreateProgram);
                i();
                glCreateProgram = 0;
            }
            for (b a2 : bVarArr) {
                a2.a(glCreateProgram);
            }
            return glCreateProgram;
        }
        throw new RuntimeException("Cannot create GL program: " + GLES20.glGetError());
    }

    public void a(int i2, int i3) {
        this.w = i2;
        this.x = i3;
        GLES20.glViewport(0, 0, this.w, this.x);
        i();
        Matrix.setIdentityM(this.r, this.v);
        float f2 = (float) i3;
        Matrix.orthoM(this.y, 0, 0.0f, (float) i2, 0.0f, f2, -1.0f, 1.0f);
        if (k() == null) {
            this.z = i2;
            this.A = i3;
            Matrix.translateM(this.r, this.v, 0.0f, f2, 0.0f);
            Matrix.scaleM(this.r, this.v, 1.0f, -1.0f, 1.0f);
        }
    }

    public void a(float[] fArr) {
        GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        i();
        GLES20.glClear(16384);
        i();
    }

    public float b() {
        return this.s[this.u];
    }

    public void a(float f2) {
        this.s[this.u] = f2;
    }

    public void a(float f2, float f3) {
        int i2 = this.v;
        float[] fArr = this.r;
        int i3 = i2 + 12;
        fArr[i3] = fArr[i3] + (fArr[i2 + 0] * f2) + (fArr[i2 + 4] * f3);
        int i4 = i2 + 13;
        fArr[i4] = fArr[i4] + (fArr[i2 + 1] * f2) + (fArr[i2 + 5] * f3);
        int i5 = i2 + 14;
        fArr[i5] = fArr[i5] + (fArr[i2 + 2] * f2) + (fArr[i2 + 6] * f3);
        int i6 = i2 + 15;
        fArr[i6] = fArr[i6] + (fArr[i2 + 3] * f2) + (fArr[i2 + 7] * f3);
    }

    public void a(float f2, float f3, float f4) {
        Matrix.scaleM(this.r, this.v, f2, f3, f4);
    }

    public void a(float f2, float f3, float f4, float f5) {
        if (f2 != 0.0f) {
            float[] fArr = this.h;
            float[] fArr2 = fArr;
            Matrix.setRotateM(fArr2, 0, f2, f3, f4, f5);
            float[] fArr3 = this.r;
            int i2 = this.v;
            Matrix.multiplyMM(fArr2, 16, fArr3, i2, fArr, 0);
            System.arraycopy(fArr, 16, fArr3, i2, 16);
        }
    }

    public void c() {
        a(-1);
    }

    public void a(int i2) {
        boolean z2 = false;
        if ((i2 & 1) == 1) {
            float b2 = b();
            this.u++;
            float[] fArr = this.s;
            if (fArr.length <= this.u) {
                this.s = Arrays.copyOf(fArr, fArr.length * 2);
            }
            this.s[this.u] = b2;
        }
        if ((i2 & 2) == 2) {
            z2 = true;
        }
        if (z2) {
            int i3 = this.v;
            this.v = i3 + 16;
            float[] fArr2 = this.r;
            if (fArr2.length <= this.v) {
                this.r = Arrays.copyOf(fArr2, fArr2.length * 2);
            }
            float[] fArr3 = this.r;
            System.arraycopy(fArr3, i3, fArr3, this.v, 16);
        }
        this.t.a(i2);
    }

    public void f() {
        int a2 = this.t.a();
        boolean z2 = false;
        if ((a2 & 1) == 1) {
            this.u--;
        }
        if ((a2 & 2) == 2) {
            z2 = true;
        }
        if (z2) {
            this.v -= 16;
        }
    }

    public void a(float f2, float f3, float f4, float f5, l lVar) {
        a(3, 4, 2, f2, f3, f4 - f2, f5 - f3, lVar);
        this.J++;
    }

    private void a(int i2, int i3, int i4, float f2, float f3, float f4, float f5, l lVar) {
        a(i2, i3, i4, f2, f3, f4, f5, lVar.a(), lVar.b());
    }

    private void a(int i2, int i3, int i4, float f2, float f3, float f4, float f5, int i5, float f6) {
        int i6 = i3;
        a(i3, i5, f6);
        a(this.n, i2, i4, f2, f3, f4, f5);
    }

    private void a(int i2, int i3, float f2) {
        GLES20.glUseProgram(this.B);
        i();
        if (f2 > 0.0f) {
            GLES20.glLineWidth(f2);
            i();
        }
        float[] b2 = b(i3);
        boolean z2 = b2[3] < 1.0f;
        a(z2);
        if (z2) {
            GLES20.glBlendColor(b2[0], b2[1], b2[2], b2[3]);
            i();
        }
        GLES20.glUniform4fv(this.n[2].f3288a, 1, b2, 0);
        a(this.n, i2);
        i();
    }

    private float[] b(int i2) {
        float b2 = (((float) ((i2 >>> 24) & 255)) / 255.0f) * b();
        float[] fArr = this.i;
        fArr[0] = (((float) ((i2 >>> 16) & 255)) / 255.0f) * b2;
        fArr[1] = (((float) ((i2 >>> 8) & 255)) / 255.0f) * b2;
        fArr[2] = (((float) (i2 & 255)) / 255.0f) * b2;
        fArr[3] = b2;
        return fArr;
    }

    private void a(boolean z2) {
        if (z2) {
            GLES20.glEnable(3042);
            i();
            return;
        }
        GLES20.glDisable(3042);
        i();
    }

    private void a(b[] bVarArr, int i2) {
        GLES20.glBindBuffer(34962, this.F);
        i();
        GLES20.glVertexAttribPointer(bVarArr[0].f3288a, 2, 5126, false, 8, i2 * 8);
        i();
        GLES20.glBindBuffer(34962, 0);
        i();
    }

    private void a(b[] bVarArr, int i2, int i3, float f2, float f3, float f4, float f5) {
        a(bVarArr, f2, f3, f4, f5);
        int i4 = bVarArr[0].f3288a;
        GLES20.glEnableVertexAttribArray(i4);
        i();
        GLES20.glDrawArrays(i2, 0, i3);
        i();
        GLES20.glDisableVertexAttribArray(i4);
        i();
    }

    private void a(b[] bVarArr, float f2, float f3, float f4, float f5) {
        Matrix.translateM(this.h, 0, this.r, this.v, f2, f3, 0.0f);
        Matrix.scaleM(this.h, 0, f4, f5, 1.0f);
        float[] fArr = this.h;
        Matrix.multiplyMM(fArr, 16, this.y, 0, fArr, 0);
        GLES20.glUniformMatrix4fv(bVarArr[1].f3288a, 1, false, this.h, 16);
        i();
    }

    public void a(float f2, float f3, float f4, float f5, int i2) {
        a(5, 0, 4, f2, f3, f4, f5, i2, 0.0f);
        this.I++;
    }

    public void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            a(cVar, this.j);
            this.k.set((float) i2, (float) i3, (float) (i2 + i4), (float) (i3 + i5));
            a(this.j, this.k, cVar);
            b(cVar, this.j, this.k);
        }
    }

    public void a(c cVar, RectF rectF, RectF rectF2) {
        if (rectF2.width() > 0.0f && rectF2.height() > 0.0f) {
            this.j.set(rectF);
            this.k.set(rectF2);
            a(this.j, this.k, cVar);
            b(cVar, this.j, this.k);
        }
    }

    public void a(c cVar, float[] fArr, int i2, int i3, int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.k.set((float) i2, (float) i3, (float) (i2 + i4), (float) (i3 + i5));
            a(cVar, fArr, this.k);
        }
    }

    private void b(c cVar, RectF rectF, RectF rectF2) {
        a(rectF);
        a(cVar, this.l, rectF2);
    }

    private void a(RectF rectF) {
        this.l[0] = rectF.width();
        this.l[5] = rectF.height();
        this.l[12] = rectF.left;
        this.l[13] = rectF.top;
    }

    private void a(c cVar, float[] fArr, RectF rectF) {
        if (cVar != null) {
            b[] c2 = c(cVar);
            a(c2, 0);
            GLES20.glUniformMatrix4fv(c2[2].f3288a, 1, false, fArr, 0);
            i();
            if (cVar.c()) {
                a(2);
                a(0.0f, rectF.centerY());
                a(1.0f, -1.0f, 1.0f);
                a(0.0f, -rectF.centerY());
            }
            a(c2, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
            if (cVar.c()) {
                f();
            }
            this.H++;
        }
    }

    private b[] c(c cVar) {
        int i2;
        b[] bVarArr;
        if (cVar.j() == 3553) {
            bVarArr = this.o;
            i2 = this.C;
        } else {
            bVarArr = this.p;
            i2 = this.D;
        }
        a(cVar, i2, bVarArr);
        return bVarArr;
    }

    private void a(c cVar, int i2, b[] bVarArr) {
        GLES20.glViewport(0, 0, this.w, this.x);
        i();
        GLES20.glUseProgram(i2);
        i();
        a(!cVar.n() || b() < 0.95f);
        GLES20.glActiveTexture(33984);
        i();
        cVar.b(this);
        GLES20.glBindTexture(cVar.j(), cVar.d());
        i();
        GLES20.glUniform1i(bVarArr[3].f3288a, 0);
        i();
        GLES20.glUniform1f(bVarArr[4].f3288a, b());
        i();
    }

    public boolean a(c cVar) {
        boolean k2 = cVar.k();
        if (k2) {
            synchronized (this.f) {
                this.f.a(cVar.d());
            }
        }
        return k2;
    }

    public void g() {
        synchronized (this.f) {
            o oVar = this.f;
            if (this.f.b() > 0) {
                d.a((GL11) null, oVar.b(), oVar.c(), 0);
                oVar.d();
            }
            o oVar2 = this.g;
            if (oVar2.b() > 0) {
                d.b((GL11) null, oVar2.b(), oVar2.c(), 0);
                oVar2.d();
            }
        }
    }

    public void h() {
        ArrayList<s> arrayList = this.L;
        a((c) arrayList.remove(arrayList.size() - 1), k());
        f();
    }

    public void a(s sVar) {
        c();
        s k2 = k();
        this.L.add(sVar);
        a((c) k2, sVar);
    }

    private s k() {
        ArrayList<s> arrayList = this.L;
        return arrayList.get(arrayList.size() - 1);
    }

    private void a(c cVar, s sVar) {
        if (cVar == null && sVar != null) {
            GLES20.glGenFramebuffers(1, this.K, 0);
            i();
            GLES20.glBindFramebuffer(36160, this.K[0]);
            i();
        } else if (cVar != null && sVar == null) {
            GLES20.glBindFramebuffer(36160, 0);
            i();
            GLES20.glDeleteFramebuffers(1, this.K, 0);
            i();
        }
        if (sVar == null) {
            a(this.z, this.A);
            return;
        }
        a(sVar.e(), sVar.f());
        if (!sVar.k()) {
            sVar.c(this);
        }
        GLES20.glFramebufferTexture2D(36160, 36064, sVar.j(), sVar.d(), 0);
        i();
        j();
    }

    public void b(c cVar) {
        int j2 = cVar.j();
        GLES20.glBindTexture(j2, cVar.d());
        i();
        GLES20.glTexParameteri(j2, 10242, 33071);
        i();
        GLES20.glTexParameteri(j2, 10243, 33071);
        i();
        GLES20.glTexParameterf(j2, 10241, 9729.0f);
        i();
        GLES20.glTexParameterf(j2, 10240, 9729.0f);
        i();
    }

    public void a(c cVar, int i2, int i3) {
        int j2 = cVar.j();
        GLES20.glBindTexture(j2, cVar.d());
        i();
        GLES20.glTexImage2D(j2, 0, i2, cVar.g(), cVar.h(), 0, i2, i3, (Buffer) null);
        i();
    }

    public void a(c cVar, Bitmap bitmap) {
        int j2 = cVar.j();
        GLES20.glBindTexture(j2, cVar.d());
        i();
        GLUtils.texImage2D(j2, 0, bitmap, 0);
        i();
    }

    public void a(c cVar, int i2, int i3, Bitmap bitmap, int i4, int i5) {
        int j2 = cVar.j();
        GLES20.glBindTexture(j2, cVar.d());
        i();
        GLUtils.texSubImage2D(j2, 0, i2, i3, bitmap, i4, i5);
        i();
    }

    public int a(FloatBuffer floatBuffer) {
        return a((Buffer) floatBuffer, 4);
    }

    private int a(Buffer buffer, int i2) {
        d.a(1, this.m, 0);
        i();
        int i3 = this.m[0];
        GLES20.glBindBuffer(34962, i3);
        i();
        GLES20.glBufferData(34962, buffer.capacity() * i2, buffer, 35044);
        i();
        return i3;
    }

    public k a() {
        return d;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (f2 != 0.0f && Math.abs(f8) >= Float.MIN_VALUE) {
            float[] fArr = this.h;
            Matrix.setRotateM(fArr, 0, f2, f3, f4, f5);
            float[] fArr2 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, (-f6) / f8, (-f7) / f8, 0.0f, -1.0f / f8, 0.0f, 0.0f, 0.0f, 1.0f};
            float[] fArr3 = fArr;
            float[] fArr4 = fArr;
            Matrix.multiplyMM(fArr3, 16, fArr2, 0, fArr4, 0);
            Matrix.multiplyMM(fArr3, 0, this.r, this.v, fArr4, 16);
            System.arraycopy(fArr, 0, this.r, this.v, 16);
        }
    }

    public int d() {
        return this.w;
    }

    public int e() {
        return this.x;
    }

    /* compiled from: GLES20Canvas */
    private static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3288a;

        /* renamed from: b  reason: collision with root package name */
        protected final String f3289b;

        public abstract void a(int i);

        public b(String str) {
            this.f3289b = str;
        }
    }

    /* compiled from: GLES20Canvas */
    private static class c extends b {
        public c(String str) {
            super(str);
        }

        public void a(int i) {
            this.f3288a = GLES20.glGetUniformLocation(i, this.f3289b);
            i.i();
        }
    }

    /* compiled from: GLES20Canvas */
    private static class a extends b {
        public a(String str) {
            super(str);
        }

        public void a(int i) {
            this.f3288a = GLES20.glGetAttribLocation(i, this.f3289b);
            i.i();
        }
    }
}
