package a.a.b;

import a.a.b.b.g;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f4a = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    public FloatBuffer f5b = ByteBuffer.allocateDirect(this.f4a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    public float[] c = new float[16];
    public float[] d = new float[16];
    public int e;
    public int f = -12345;
    public int g;
    public int h;
    public int i;
    public int j;

    public b() {
        this.f5b.put(this.f4a).position(0);
        Matrix.setIdentityM(this.d, 0);
    }

    public final int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        a("glCreateShader type=" + i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("TextureRender", "Could not compile shader " + i2 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e("TextureRender", sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public final int a(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        int i2 = 0;
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("TextureRender", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("TextureRender", "Could not link program: ");
            Log.e("TextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
        } else {
            i2 = glCreateProgram;
        }
        if (i2 != 0) {
            g.b(i2);
        }
        return i2;
    }

    public void a() {
        this.e = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        int i2 = this.e;
        if (i2 != 0) {
            this.i = GLES20.glGetAttribLocation(i2, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.i != -1) {
                this.j = GLES20.glGetAttribLocation(this.e, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.j != -1) {
                    this.g = GLES20.glGetUniformLocation(this.e, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.g != -1) {
                        this.h = GLES20.glGetUniformLocation(this.e, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.h != -1) {
                            Matrix.setIdentityM(this.c, 0);
                            Matrix.scaleM(this.c, 0, -1.0f, -1.0f, 1.0f);
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }

    public void a(int i2) {
        this.f = i2;
    }

    public void a(SurfaceTexture surfaceTexture, float[] fArr) {
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(this.d);
        }
        GLES20.glUseProgram(this.e);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f);
        this.f5b.position(0);
        GLES20.glVertexAttribPointer(this.i, 3, 5126, false, 20, this.f5b);
        GLES20.glEnableVertexAttribArray(this.i);
        this.f5b.position(3);
        GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 20, this.f5b);
        GLES20.glEnableVertexAttribArray(this.j);
        if (fArr != null) {
            Matrix.setIdentityM(this.c, 0);
            Matrix.scaleM(this.c, 0, -1.0f, -1.0f, 1.0f);
            float[] fArr2 = this.c;
            Matrix.multiplyMM(fArr2, 0, fArr2, 0, fArr, 0);
        }
        GLES20.glUniformMatrix4fv(this.g, 1, false, this.c, 0);
        GLES20.glUniformMatrix4fv(this.h, 1, false, this.d, 0);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void a(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Log.e("TextureRender", str + ": glError " + glGetError);
            } else {
                return;
            }
        }
    }
}
