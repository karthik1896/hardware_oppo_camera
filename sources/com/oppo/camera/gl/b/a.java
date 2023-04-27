package com.oppo.camera.gl.b;

import android.opengl.GLES20;
import android.opengl.GLES32;
import com.oppo.camera.e;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: BaseDrawer */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f3274a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected int f3275b = 0;
    protected int c = 0;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected float[] g = {0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    protected float[] h = {0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    /* access modifiers changed from: protected */
    public int a(int i, String str) {
        int glCreateShader = GLES32.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES32.glShaderSource(glCreateShader, str);
            GLES32.glCompileShader(glCreateShader);
            return glCreateShader;
        }
        throw new RuntimeException("loadShader Failed!" + GLES32.glGetError());
    }

    public static void a() {
        int glGetError = GLES32.glGetError();
        if (glGetError != 0) {
            Throwable th = new Throwable();
            e.d("BaseDrawer", "checkGlError, error: " + glGetError, th);
        }
    }

    /* access modifiers changed from: protected */
    public int a(int i, int i2) {
        int glCreateProgram = GLES32.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES32.glAttachShader(glCreateProgram, i);
            GLES32.glAttachShader(glCreateProgram, i2);
            GLES32.glLinkProgram(glCreateProgram);
            a();
            return glCreateProgram;
        }
        throw new RuntimeException("linkProgram Failed!" + GLES32.glGetError());
    }

    public static void a(int[] iArr, int[] iArr2, int i, int i2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        GLES20.glGenFramebuffers(iArr3.length, iArr, 0);
        for (int i3 = 0; i3 < iArr4.length; i3++) {
            GLES20.glBindTexture(3553, iArr4[i3]);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, (Buffer) null);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, iArr3[i3]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr4[i3], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    /* access modifiers changed from: protected */
    public FloatBuffer a(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return asFloatBuffer;
    }
}
