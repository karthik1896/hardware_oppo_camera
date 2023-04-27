package a.a.b.d;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f31a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f32b = EGL14.EGL_NO_CONTEXT;
    public EGLConfig c = null;

    public a(EGLContext eGLContext, int i) {
        EGLConfig a2;
        if (this.f31a == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            this.f31a = EGL14.eglGetDisplay(0);
            EGLDisplay eGLDisplay = this.f31a;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eGLDisplay, iArr, 0, iArr, 1)) {
                    if (!((i & 2) == 0 || (a2 = a(i, 3)) == null)) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f31a, a2, eGLContext, new int[]{12440, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.c = a2;
                            this.f32b = eglCreateContext;
                        }
                    }
                    if (this.f32b == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig a3 = a(i, 2);
                        if (a3 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f31a, a3, eGLContext, new int[]{12440, 2, 12344}, 0);
                            a("eglCreateContext");
                            this.c = a3;
                            this.f32b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f31a, this.f32b, 12440, iArr2, 0);
                    Log.d("EglCore", "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.f31a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    public final EGLConfig a(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[iArr.length - 3] = 12610;
            iArr[iArr.length - 2] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f31a, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("EglCore", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    public EGLSurface a(Object obj) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f31a, this.c, obj, new int[]{12344}, 0);
            a("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        throw new RuntimeException("invalid surface: " + obj);
    }

    public void a() {
        EGLDisplay eGLDisplay = this.f31a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f31a, this.f32b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f31a);
        }
        this.f31a = EGL14.EGL_NO_DISPLAY;
        this.f32b = EGL14.EGL_NO_CONTEXT;
        this.c = null;
    }

    public void a(EGLSurface eGLSurface) {
        if (this.f31a == EGL14.EGL_NO_DISPLAY) {
            Log.d("EglCore", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f31a, eGLSurface, eGLSurface, this.f32b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public void b(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f31a, eGLSurface);
    }

    public boolean c(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f31a, eGLSurface);
    }

    public void finalize() {
        try {
            if (this.f31a != EGL14.EGL_NO_DISPLAY) {
                Log.w("EglCore", "WARNING: EglCore was not explicitly released -- state may be leaked");
                a();
            }
        } finally {
            super.finalize();
        }
    }
}
