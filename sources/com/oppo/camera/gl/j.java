package com.oppo.camera.gl;

import android.opengl.GLES20;
import android.util.Log;
import javax.microedition.khronos.opengles.GL11;

/* compiled from: GLES20IdImpl */
public class j implements k {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f3290a = new int[1];

    public static synchronized void a(int[] iArr) {
        synchronized (j.class) {
            GLES20.glGenTextures(1, iArr, 0);
            a();
        }
    }

    public static void a() {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Throwable th = new Throwable();
            Log.e("GLES20IdImpl", "GL error: " + glGetError, th);
        }
    }

    public int b() {
        GLES20.glGenTextures(1, this.f3290a, 0);
        i.i();
        return this.f3290a[0];
    }

    public void a(int i, int[] iArr, int i2) {
        GLES20.glGenBuffers(i, iArr, i2);
        i.i();
    }

    public void a(GL11 gl11, int i, int[] iArr, int i2) {
        GLES20.glDeleteTextures(i, iArr, i2);
        i.i();
    }

    public void b(GL11 gl11, int i, int[] iArr, int i2) {
        GLES20.glDeleteBuffers(i, iArr, i2);
        i.i();
    }
}
