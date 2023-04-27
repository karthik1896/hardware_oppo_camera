package a.a.b.b;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public EGL10 f9a;

    /* renamed from: b  reason: collision with root package name */
    public EGLDisplay f10b;
    public EGLConfig c;
    public EGLSurface d;
    public EGLContext e;
    public int f = 1;
    public Object g;
    public int h = 8;
    public int i = 8;
    public int j = 8;
    public int k = 8;
    public int l = 0;
    public int m = 4;
    public EGLContext n = EGL10.EGL_NO_CONTEXT;

    public int a(int i2, int i3) {
        int[] iArr = {12324, this.h, 12323, this.i, 12322, this.j, 12321, this.k, 12325, this.l, 12352, this.m, 12344};
        this.f9a = (EGL10) EGLContext.getEGL();
        this.f10b = this.f9a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f9a.eglInitialize(this.f10b, new int[2]);
        int[] iArr2 = new int[1];
        this.f9a.eglChooseConfig(this.f10b, iArr, (EGLConfig[]) null, 0, iArr2);
        if (iArr2[0] == 0) {
            return -1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[iArr2[0]];
        this.f9a.eglChooseConfig(this.f10b, iArr, eGLConfigArr, iArr2[0], iArr2);
        this.c = eGLConfigArr[0];
        this.d = a(new int[]{12375, i2, 12374, i3, 12344});
        this.e = this.f9a.eglCreateContext(this.f10b, this.c, this.n, new int[]{12440, 2, 12344});
        b();
        return this.f9a.eglGetError();
    }

    public final EGLSurface a(int[] iArr) {
        int i2 = this.f;
        return i2 != 2 ? i2 != 3 ? this.f9a.eglCreatePbufferSurface(this.f10b, this.c, iArr) : this.f9a.eglCreateWindowSurface(this.f10b, this.c, this.g, iArr) : this.f9a.eglCreatePixmapSurface(this.f10b, this.c, this.g, iArr);
    }

    public void a() {
        EGL10 egl10 = this.f9a;
        EGLDisplay eGLDisplay = this.f10b;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.f9a.eglDestroySurface(this.f10b, this.d);
        this.f9a.eglDestroyContext(this.f10b, this.e);
        this.f9a.eglTerminate(this.f10b);
    }

    public void b() {
        EGL10 egl10 = this.f9a;
        EGLDisplay eGLDisplay = this.f10b;
        EGLSurface eGLSurface = this.d;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.e);
        GL10 gl10 = (GL10) this.e.getGL();
    }
}
