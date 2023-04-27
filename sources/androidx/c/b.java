package androidx.c;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;

/* compiled from: EglWindowSurface */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private EGLDisplay f482a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: b  reason: collision with root package name */
    private EGLContext f483b = EGL14.EGL_NO_CONTEXT;
    private EGLSurface c = EGL14.EGL_NO_SURFACE;
    private EGLConfig[] d = new EGLConfig[1];
    private Surface e;
    private int f;
    private int g;

    public b(Surface surface) {
        if (surface != null) {
            this.e = surface;
            g();
            return;
        }
        throw new NullPointerException();
    }

    private void g() {
        this.f482a = EGL14.eglGetDisplay(0);
        if (!Objects.equals(this.f482a, EGL14.EGL_NO_DISPLAY)) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.f482a, iArr, 0, iArr, 1)) {
                EGLDisplay eGLDisplay = this.f482a;
                EGLConfig[] eGLConfigArr = this.d;
                if (EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                    this.f483b = EGL14.eglCreateContext(this.f482a, this.d[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    a("eglCreateContext");
                    if (this.f483b != null) {
                        h();
                        this.f = e();
                        this.g = f();
                        return;
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.f482a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    private void h() {
        this.c = EGL14.eglCreateWindowSurface(this.f482a, this.d[0], this.e, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (this.c == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public void a() {
        if (!Objects.equals(this.f482a, EGL14.EGL_NO_DISPLAY)) {
            EGL14.eglDestroySurface(this.f482a, this.c);
            EGL14.eglDestroyContext(this.f482a, this.f483b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f482a);
        }
        this.e.release();
        this.f482a = EGL14.EGL_NO_DISPLAY;
        this.f483b = EGL14.EGL_NO_CONTEXT;
        this.c = EGL14.EGL_NO_SURFACE;
        this.e = null;
    }

    public void b() {
        EGLDisplay eGLDisplay = this.f482a;
        EGLSurface eGLSurface = this.c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f483b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void c() {
        if (!EGL14.eglMakeCurrent(this.f482a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean d() {
        return EGL14.eglSwapBuffers(this.f482a, this.c);
    }

    public int e() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f482a, this.c, 12375, iArr, 0);
        return iArr[0];
    }

    public int f() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f482a, this.c, 12374, iArr, 0);
        return iArr[0];
    }

    public void a(long j) {
        EGLExt.eglPresentationTimeANDROID(this.f482a, this.c, j);
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
