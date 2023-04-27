package a.a.b.a.a;

import a.a.b.a.ah;
import a.a.b.e.o;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.util.Arrays;

public abstract class a {
    public static final int KEY_IN = 258;
    public static final int KEY_INDEX = 513;
    public static final int KEY_OUT = 257;
    public static final String fragmentHeader = "precision highp float;\n";
    public static final float[] m = o.a();
    public static final String needReplaceHeader = "#extension GL_OES_standard_derivatives : enable";
    public static final String vertexHeader = "uniform mat4 u_ModelViewProjectionMatrix;\nattribute vec4 a_Vertex;\nattribute vec4 a_TexCoord;\nattribute vec4 a_Distortion;\nattribute vec4 a_Delta;\n";

    /* renamed from: a  reason: collision with root package name */
    public Context f2a;

    /* renamed from: b  reason: collision with root package name */
    public int f3b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Resources i;
    public float[] j = Arrays.copyOf(m, 16);
    public int k = 0;
    public int l = 0;

    public a(Context context, Resources resources) {
        this.i = resources;
        this.f2a = context;
        c();
    }

    public static int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        a(1, (Object) "Could not compile shader:" + i2);
        a(1, (Object) "GLES20 Error:" + GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static String a(String str) {
        return str.contains(needReplaceHeader) ? str.replace(fragmentHeader, "").replace(needReplaceHeader, "#extension GL_OES_standard_derivatives : enable\nprecision highp float;\n") : str;
    }

    public static void a(int i2, Object obj) {
        a.a.b.a.a("base glError");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 35633(0x8b31, float:4.9932E-41)
            int r5 = a((int) r0, (java.lang.String) r5)
            r0 = 0
            if (r5 != 0) goto L_0x000b
            return r0
        L_0x000b:
            r1 = 35632(0x8b30, float:4.9931E-41)
            java.lang.String r6 = a((java.lang.String) r6)
            int r6 = a((int) r1, (java.lang.String) r6)
            if (r6 != 0) goto L_0x001e
            java.lang.String r5 = "hh"
            a.a.b.a.a((java.lang.String) r5)
            return r0
        L_0x001e:
            int r1 = android.opengl.GLES20.glCreateProgram()
            if (r1 == 0) goto L_0x0056
            android.opengl.GLES20.glAttachShader(r1, r5)
            android.opengl.GLES20.glAttachShader(r1, r6)
            android.opengl.GLES20.glLinkProgram(r1)
            r2 = 1
            int[] r3 = new int[r2]
            r4 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r1, r4, r3, r0)
            r3 = r3[r0]
            if (r3 == r2) goto L_0x0056
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Could not link program:"
            r3.append(r4)
            java.lang.String r4 = android.opengl.GLES20.glGetProgramInfoLog(r1)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            a((int) r2, (java.lang.Object) r3)
            android.opengl.GLES20.glDeleteProgram(r1)
            goto L_0x0057
        L_0x0056:
            r0 = r1
        L_0x0057:
            if (r0 == 0) goto L_0x005c
            a.a.b.b.g.b((int) r0)
        L_0x005c:
            android.opengl.GLES20.glDeleteShader(r5)
            android.opengl.GLES20.glDeleteShader(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.a.a.a.c(java.lang.String, java.lang.String):int");
    }

    public final void a() {
        f();
    }

    public final void a(int i2) {
        this.l = i2;
    }

    public abstract void a(int i2, int i3);

    public final void a(String str, String str2) {
        String str3;
        if (!this.f2a.isOES || !(this instanceof ah) || str2 == null) {
            str3 = "";
        } else {
            str2 = str2.replace("uniform sampler2D texture;", "uniform samplerExternalOES texture;");
            str3 = "#extension GL_OES_EGL_image_external : require\n";
        }
        this.f3b = c(vertexHeader + str, str3 + fragmentHeader + str2);
        this.c = GLES20.glGetAttribLocation(this.f3b, "a_Vertex");
        this.d = GLES20.glGetAttribLocation(this.f3b, "a_TexCoord");
        this.e = GLES20.glGetAttribLocation(this.f3b, "a_Distortion");
        this.f = GLES20.glGetAttribLocation(this.f3b, "a_Delta");
        this.g = GLES20.glGetUniformLocation(this.f3b, "u_ModelViewProjectionMatrix");
        this.h = GLES20.glGetUniformLocation(this.f3b, "texture");
    }

    public void a(float[] fArr) {
        this.j = fArr;
    }

    public final int b() {
        return this.l;
    }

    public final void b(int i2, int i3) {
        a(i2, i3);
    }

    public final void b(String str, String str2) {
        a(this.f2a.shaderUtil.a(this.i, str), this.f2a.shaderUtil.a(this.i, str2));
        a.a.b.a.a("create program");
    }

    public void c() {
    }

    public void d() {
        GLES20.glActiveTexture(this.k + 33984);
        GLES20.glBindTexture((!this.f2a.isOES || !(this instanceof ah)) ? 3553 : 36197, b());
        GLES20.glUniform1i(this.h, this.k);
    }

    public void draw() {
        e();
        j();
        i();
        d();
        g();
    }

    public void e() {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16384);
    }

    public abstract void f();

    public void g() {
        int i2 = this.c;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 0, this.f2a.mesh.mVerBuffer);
        }
        int i3 = this.d;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, this.f2a.mesh.mTexBuffer);
        }
        int i4 = this.e;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, this.f2a.mesh.mDistortionBuffer);
        }
        int i5 = this.f;
        if (i5 >= 0) {
            GLES20.glEnableVertexAttribArray(i5);
            GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, this.f2a.mesh.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.f2a.mesh.trianglesBuffer.capacity(), 5123, this.f2a.mesh.trianglesBuffer);
        int i6 = this.c;
        if (i6 >= 0) {
            GLES20.glDisableVertexAttribArray(i6);
        }
        int i7 = this.d;
        if (i7 >= 0) {
            GLES20.glDisableVertexAttribArray(i7);
        }
        int i8 = this.e;
        if (i8 >= 0) {
            GLES20.glDisableVertexAttribArray(i8);
        }
        int i9 = this.f;
        if (i9 >= 0) {
            GLES20.glDisableVertexAttribArray(i9);
        }
        a.a.b.a.a("draw program");
        h();
    }

    public float[] getMatrix() {
        return this.j;
    }

    public void h() {
    }

    public void i() {
        GLES20.glUniformMatrix4fv(this.g, 1, false, this.j, 0);
    }

    public void j() {
        GLES20.glUseProgram(this.f3b);
    }
}
