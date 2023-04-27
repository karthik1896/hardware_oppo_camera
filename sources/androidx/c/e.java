package androidx.c;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.FloatBuffer;

/* compiled from: Texture2dProgram */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f502a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f503b = new float[16];
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    static {
        Matrix.setIdentityM(f502a, 0);
        Matrix.setIdentityM(f503b, 0);
        Matrix.translateM(f503b, 0, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(f503b, 0, 1.0f, -1.0f, 1.0f);
    }

    public e(int i2) {
        this.c = i2;
        if (i2 == 0) {
            this.i = 3553;
            this.d = a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else if (i2 == 1) {
            this.i = 36197;
            this.d = a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            throw new RuntimeException("Unhandled type " + i2);
        }
        int i3 = this.d;
        if (i3 != 0) {
            this.g = GLES20.glGetAttribLocation(i3, "aPosition");
            b(this.g, "aPosition");
            this.h = GLES20.glGetAttribLocation(this.d, "aTextureCoord");
            b(this.h, "aTextureCoord");
            this.e = GLES20.glGetUniformLocation(this.d, "uMVPMatrix");
            b(this.e, "uMVPMatrix");
            this.f = GLES20.glGetUniformLocation(this.d, "uTexMatrix");
            b(this.f, "uTexMatrix");
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public void a() {
        Log.d("Texture2dProgram", "deleting program " + this.d);
        GLES20.glDeleteProgram(this.d);
        this.d = -1;
    }

    public int b() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a("glGenTextures");
        int i2 = iArr[0];
        GLES20.glBindTexture(this.i, i2);
        a("glBindTexture " + i2);
        float f2 = 9728.0f;
        GLES20.glTexParameterf(this.i, 10241, 9728.0f);
        int i3 = this.i;
        if (i3 != 3553) {
            f2 = 9729.0f;
        }
        GLES20.glTexParameterf(i3, 10240, f2);
        GLES20.glTexParameteri(this.i, 10242, 33071);
        GLES20.glTexParameteri(this.i, 10243, 33071);
        a("glTexParameter");
        return i2;
    }

    public void a(int i2, Bitmap bitmap) {
        GLES20.glBindTexture(this.i, i2);
        GLUtils.texImage2D(this.i, 0, bitmap, 0);
    }

    public void a(float[] fArr, FloatBuffer floatBuffer, int i2, int i3, int i4, int i5, float[] fArr2, FloatBuffer floatBuffer2, int i6, int i7) {
        a("draw start");
        GLES20.glUseProgram(this.d);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.i, i6);
        float[] fArr3 = fArr;
        GLES20.glUniformMatrix4fv(this.e, 1, false, fArr, 0);
        a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f, 1, false, fArr2, 0);
        a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.g);
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.g, i4, 5126, false, i5, floatBuffer);
        a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.h);
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.h, 2, 5126, false, i7, floatBuffer2);
        a("glVertexAttribPointer");
        int i8 = i2;
        int i9 = i3;
        GLES20.glDrawArrays(5, i2, i3);
        a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glDisableVertexAttribArray(this.h);
        GLES20.glBindTexture(this.i, 0);
        GLES20.glUseProgram(0);
    }

    public static int a(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("Texture2dProgram", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        Log.e("Texture2dProgram", "Could not link program: ");
        Log.e("Texture2dProgram", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public static int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        a("glCreateShader type=" + i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("Texture2dProgram", "Could not compile shader " + i2 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e("Texture2dProgram", sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static void b(int i2, String str) {
        if (i2 < 0) {
            throw new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 1285) {
            Log.i("Texture2dProgram", str + " GL_OUT_OF_MEMORY");
        }
        if (glGetError != 0 && glGetError != 1285) {
            String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
            Log.e("Texture2dProgram", str2);
            throw new RuntimeException(str2);
        }
    }
}
