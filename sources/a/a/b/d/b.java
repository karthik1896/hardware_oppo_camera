package a.a.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f33a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f34b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f33a = aVar;
    }

    public void a() {
        this.f33a.a(this.f34b);
    }

    public void a(Object obj) {
        if (this.f34b == EGL14.EGL_NO_SURFACE) {
            this.f34b = this.f33a.a(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f33a.b(this.f34b);
        this.f34b = EGL14.EGL_NO_SURFACE;
    }

    public boolean c() {
        boolean c = this.f33a.c(this.f34b);
        if (!c) {
            Log.d("EglSurfaceBase", "WARNING: swapBuffers() failed");
        }
        return c;
    }
}
