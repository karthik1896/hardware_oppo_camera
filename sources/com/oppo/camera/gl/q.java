package com.oppo.camera.gl;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: OppoGLSurfaceView */
public class q extends SurfaceView implements SurfaceHolder.Callback {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static j f3310a = new j();

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<q> f3311b = new WeakReference<>(this);
    /* access modifiers changed from: private */
    public Surface c = null;
    /* access modifiers changed from: private */
    public r d = null;
    /* access modifiers changed from: private */
    public boolean e = false;
    /* access modifiers changed from: private */
    public i f = null;
    /* access modifiers changed from: private */
    public m g = null;
    private boolean h = false;
    private e i = null;
    /* access modifiers changed from: private */
    public f j = null;
    /* access modifiers changed from: private */
    public g k = null;
    /* access modifiers changed from: private */
    public k l = null;
    /* access modifiers changed from: private */
    public int m = 0;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public boolean o = true;

    /* compiled from: OppoGLSurfaceView */
    public interface e {
    }

    /* compiled from: OppoGLSurfaceView */
    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: OppoGLSurfaceView */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: OppoGLSurfaceView */
    public interface k {
        GL a(GL gl);
    }

    /* compiled from: OppoGLSurfaceView */
    public interface m {
        void a(GL10 gl10, int i, int i2);

        void a(GL10 gl10, EGLConfig eGLConfig);

        void b(GL10 gl10);
    }

    public q(Context context) {
        super(context);
        b();
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.f != null) {
                this.f.h();
            }
        } finally {
            super.finalize();
        }
    }

    private void b() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.l = kVar;
    }

    public void setDebugFlags(int i2) {
        this.m = i2;
    }

    public int getDebugFlags() {
        return this.m;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.o = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.o;
    }

    public void setRenderer(m mVar) {
        e();
        if (this.i == null) {
            this.i = new n(true);
        }
        if (this.j == null) {
            this.j = new c();
        }
        if (this.k == null) {
            this.k = new d();
        }
        this.g = mVar;
        this.f = new i(this.f3311b);
        this.f.start();
    }

    public void setEGLContextFactory(f fVar) {
        e();
        this.j = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        e();
        this.k = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        e();
        this.i = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((e) new n(z));
    }

    public void setEGLContextClientVersion(int i2) {
        e();
        this.n = i2;
    }

    public void setRenderMode(int i2) {
        this.f.a(i2);
    }

    public int getRenderMode() {
        return this.f.b();
    }

    public void a() {
        this.f.c();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f.d();
        com.oppo.camera.e.a("GLSurfaceView", "surfaceCreated");
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f.e();
        com.oppo.camera.e.a("GLSurfaceView", "surfaceDestroyed");
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.f.a(i3, i4);
        com.oppo.camera.e.a("GLSurfaceView", "surfaceChanged, w: " + i3 + ", h: " + i4);
    }

    public void d() {
        this.f.f();
    }

    public void c() {
        this.f.g();
    }

    public void a(Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        i iVar = this.f;
        if (currentThread == iVar) {
            runnable.run();
        } else {
            iVar.a(runnable);
        }
    }

    public void g() {
        i iVar = this.f;
        if (iVar != null && iVar.u != null && this.f.u.e != null) {
            this.f.u.a(this.f.u.e);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && this.g != null) {
            i iVar = this.f;
            int b2 = iVar != null ? iVar.b() : 1;
            this.f = new i(this.f3311b);
            if (b2 != 1) {
                this.f.a(b2);
            }
            this.f.start();
        }
        this.h = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        i iVar = this.f;
        if (iVar != null) {
            iVar.h();
        }
        this.h = true;
        super.onDetachedFromWindow();
    }

    /* compiled from: OppoGLSurfaceView */
    private class c implements f {
        private c() {
        }

        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, q.this.n, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (q.this.n == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                com.oppo.camera.e.e("GLSurfaceView", "destroyContext, display: " + eGLDisplay + " context: " + eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: OppoGLSurfaceView */
    private static class d implements g {
        private d() {
        }

        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e) {
                com.oppo.camera.e.d("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: OppoGLSurfaceView */
    private abstract class a implements e {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f3313a = null;

        public a(int[] iArr) {
            this.f3313a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (q.this.n != 2 && q.this.n != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (q.this.n == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* compiled from: OppoGLSurfaceView */
    private class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public b(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.j = null;
            this.j = new int[1];
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
        }
    }

    /* compiled from: OppoGLSurfaceView */
    private class n extends b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* compiled from: OppoGLSurfaceView */
    private static class h {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f3316a = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<q> f3317b = null;
        private EGL10 c = null;
        private EGLDisplay d = null;
        /* access modifiers changed from: private */
        public EGLSurface e = null;
        /* access modifiers changed from: private */
        public EGLSurface f = null;
        /* access modifiers changed from: private */
        public EGLConfig g = null;
        private EGLContext h = null;

        public h(WeakReference<q> weakReference) {
            this.f3317b = weakReference;
        }

        public void a() {
            this.c = (EGL10) EGLContext.getEGL();
            this.d = this.c.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.d != EGL10.EGL_NO_DISPLAY) {
                if (this.c.eglInitialize(this.d, new int[2])) {
                    q qVar = (q) this.f3317b.get();
                    if (qVar == null) {
                        this.g = null;
                        this.h = null;
                    } else {
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        EGLConfig[] eGLConfigArr2 = eGLConfigArr;
                        this.c.eglChooseConfig(this.d, f3316a, eGLConfigArr2, eGLConfigArr.length, new int[1]);
                        this.g = eGLConfigArr[0];
                        this.h = qVar.j.a(this.c, this.d, this.g);
                    }
                    EGLContext eGLContext = this.h;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.h = null;
                        a("createContext");
                    }
                    com.oppo.camera.e.a("GLSurfaceView", "start, createContext: " + this.h + ", tid: " + Thread.currentThread().getId());
                    this.e = null;
                    this.f = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            if (this.c == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.d == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.g != null) {
                i();
                q qVar = (q) this.f3317b.get();
                if (qVar != null) {
                    this.e = qVar.k.a(this.c, this.d, this.g, qVar.getHolder());
                } else {
                    this.e = null;
                }
                EGLSurface eGLSurface = this.e;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.c.eglGetError() == 12299) {
                        com.oppo.camera.e.e("GLSurfaceView", "createSurface, createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                EGL10 egl10 = this.c;
                EGLDisplay eGLDisplay = this.d;
                EGLSurface eGLSurface2 = this.e;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.h)) {
                    return true;
                }
                a("GLSurfaceView", "eglMakeCurrent", this.c.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        public boolean c() {
            com.oppo.camera.e.a("GLSurfaceView", "createOutputEGLSurface");
            if (this.c == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.d == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.g != null) {
                j();
                q qVar = (q) this.f3317b.get();
                if (qVar != null) {
                    this.f = qVar.k.a(this.c, this.d, this.g, qVar.c);
                } else {
                    this.f = null;
                }
                EGLSurface eGLSurface = this.f;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.c.eglGetError() == 12299) {
                        com.oppo.camera.e.e("GLSurfaceView", "createOutputEGLSurface, createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                EGL10 egl10 = this.c;
                EGLDisplay eGLDisplay = this.d;
                EGLSurface eGLSurface2 = this.f;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.h)) {
                    return true;
                }
                a("GLSurfaceView", "eglMakeCurrent", this.c.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: private */
        public GL h() {
            GL gl = this.h.getGL();
            q qVar = (q) this.f3317b.get();
            if (qVar == null) {
                return gl;
            }
            if (qVar.l != null) {
                gl = qVar.l.a(gl);
            }
            if ((qVar.m & 3) == 0) {
                return gl;
            }
            int i = 0;
            l lVar = null;
            if ((qVar.m & 1) != 0) {
                i = 1;
            }
            if ((qVar.m & 2) != 0) {
                lVar = new l();
            }
            return GLDebugHelper.wrap(gl, i, lVar);
        }

        public int d() {
            if (!this.c.eglSwapBuffers(this.d, this.e)) {
                return this.c.eglGetError();
            }
            return 12288;
        }

        public int e() {
            if (!this.c.eglSwapBuffers(this.d, this.f)) {
                return this.c.eglGetError();
            }
            return 12288;
        }

        public void f() {
            i();
            j();
        }

        private void i() {
            EGLSurface eGLSurface = this.e;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.c.eglMakeCurrent(this.d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                q qVar = (q) this.f3317b.get();
                if (qVar != null) {
                    qVar.k.a(this.c, this.d, this.e);
                }
                this.e = null;
            }
        }

        /* access modifiers changed from: private */
        public void j() {
            EGLSurface eGLSurface = this.f;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.c.eglMakeCurrent(this.d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                q qVar = (q) this.f3317b.get();
                if (qVar != null) {
                    qVar.k.a(this.c, this.d, this.f);
                }
                com.oppo.camera.e.d("GLSurfaceView", "destroyOutputEGLSurfaceImp, error: " + this.c.eglGetError());
                this.f = null;
            }
        }

        public void g() {
            if (this.h != null) {
                q qVar = (q) this.f3317b.get();
                if (qVar != null) {
                    com.oppo.camera.e.a("GLSurfaceView", "finish, destroyContext mEglContext: " + this.h);
                    qVar.j.a(this.c, this.d, this.h);
                }
                this.h = null;
            }
            EGLDisplay eGLDisplay = this.d;
            if (eGLDisplay != null) {
                this.c.eglTerminate(eGLDisplay);
                this.d = null;
            }
        }

        private void a(String str) {
            a(str, this.c.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException("error: " + i);
        }

        public static void a(String str, String str2, int i) {
            com.oppo.camera.e.d(str, "logEglErrorAsWarning, function: " + str2 + ", error: " + i);
        }

        public boolean a(EGLSurface eGLSurface) {
            if (this.c.eglMakeCurrent(this.d, eGLSurface, eGLSurface, this.h)) {
                return true;
            }
            a("GLSurfaceView", "eglMakeCurrent", this.c.eglGetError());
            return false;
        }
    }

    /* compiled from: OppoGLSurfaceView */
    static class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3318a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f3319b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l;
        private int m;
        private int n;
        private boolean o;
        private boolean p;
        private boolean q;
        private ArrayList<Runnable> r;
        private boolean s;
        private Runnable t;
        /* access modifiers changed from: private */
        public h u;
        private WeakReference<q> v;

        i(WeakReference<q> weakReference) {
            this.f3318a = false;
            this.f3319b = false;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = new ArrayList<>();
            this.s = true;
            this.t = null;
            this.u = null;
            this.v = null;
            this.l = 0;
            this.m = 0;
            this.o = true;
            this.n = 1;
            this.p = false;
            this.v = weakReference;
        }

        public void run() {
            setName("OppoGLThread " + getId());
            try {
                k();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                q.f3310a.a(this);
                throw th;
            }
            q.f3310a.a(this);
        }

        private void i() {
            if (this.i) {
                this.i = false;
                this.u.f();
            }
        }

        private void j() {
            com.oppo.camera.e.a("GLSurfaceView", "stopEglContextLocked");
            if (this.h) {
                this.u.g();
                this.h = false;
                q.f3310a.b(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
            r1.j = true;
            com.oppo.camera.gl.q.k().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x016b, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x016c, code lost:
            r14 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0171, code lost:
            r2 = com.oppo.camera.gl.q.k();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0175, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
            r1.j = true;
            r1.f = true;
            com.oppo.camera.gl.q.k().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x0182, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x0183, code lost:
            r6 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x018a, code lost:
            if (r7 == false) goto L_0x0196;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x018c, code lost:
            r8 = (javax.microedition.khronos.opengles.GL10) com.oppo.camera.gl.q.h.b(r1.u);
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0196, code lost:
            if (r13 == false) goto L_0x01c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x0198, code lost:
            r2 = (com.oppo.camera.gl.q) r1.v.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x01a0, code lost:
            if (r2 == null) goto L_0x01c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
            com.oppo.camera.e.a("onSurfaceCreated");
            com.oppo.camera.gl.q.h(r2).a(r8, com.oppo.camera.gl.q.h.c(r1.u));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
            com.oppo.camera.e.b("onSurfaceCreated");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x01c1, code lost:
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x01c2, code lost:
            if (r9 == false) goto L_0x01e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x01c4, code lost:
            r2 = (com.oppo.camera.gl.q) r1.v.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x01cc, code lost:
            if (r2 == null) goto L_0x01e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
            com.oppo.camera.e.a("onSurfaceChanged");
            com.oppo.camera.gl.q.h(r2).a(r8, r10, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
            com.oppo.camera.e.b("onSurfaceChanged");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x01e7, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x01e8, code lost:
            r1.u.a(com.oppo.camera.gl.q.h.a(r1.u));
            r2 = (com.oppo.camera.gl.q) r1.v.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x01fb, code lost:
            if (r2 == null) goto L_0x021c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
            com.oppo.camera.e.a("onDrawFrame");
            com.oppo.camera.gl.q.h(r2).b(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x0209, code lost:
            if (r0 == null) goto L_0x020f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x020b, code lost:
            r0.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x020e, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
            com.oppo.camera.e.b("onDrawFrame");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x021c, code lost:
            r6 = r0;
            r0 = r1.u.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0225, code lost:
            if (r0 == 12288) goto L_0x024b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0229, code lost:
            if (r0 == 12302) goto L_0x0248;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x022b, code lost:
            r18 = r3;
            com.oppo.camera.gl.q.h.a("GLSurfaceView", "eglSwapBuffers", r0);
            r2 = com.oppo.camera.gl.q.k();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0238, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
            r1.f = true;
            com.oppo.camera.gl.q.k().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0243, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0248, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x024b, code lost:
            r18 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x024e, code lost:
            r3 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x025c, code lost:
            if (com.oppo.camera.gl.q.d((com.oppo.camera.gl.q) r1.v.get()) == null) goto L_0x02e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x026e, code lost:
            if (com.oppo.camera.gl.q.d((com.oppo.camera.gl.q) r1.v.get()).isValid() == false) goto L_0x02e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x027c, code lost:
            if (com.oppo.camera.gl.q.i((com.oppo.camera.gl.q) r1.v.get()) != false) goto L_0x02e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0284, code lost:
            if (com.oppo.camera.gl.q.h.d(r1.u) != null) goto L_0x028b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0286, code lost:
            r1.u.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x028b, code lost:
            r1.u.a(com.oppo.camera.gl.q.h.d(r1.u));
            r0 = (com.oppo.camera.gl.q) r1.v.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x02a2, code lost:
            if (com.oppo.camera.gl.q.j(r0) == null) goto L_0x02ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x02a4, code lost:
            com.oppo.camera.gl.q.j(r0).a(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x02ab, code lost:
            r2 = new java.lang.StringBuilder();
            r16 = r3;
            r2.append("guardedRun, OutputSurfaceDraw swap start tid: ");
            r18 = r4;
            r2.append(getId());
            com.oppo.camera.e.a("GLSurfaceView", r2.toString());
            r1.u.e();
            com.oppo.camera.e.a("GLSurfaceView", "guardedRun, OutputSurfaceDraw swap end tid: " + getId());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x02e9, code lost:
            r16 = r3;
            r18 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x02f3, code lost:
            if (com.oppo.camera.gl.q.h.d(r1.u) == null) goto L_0x02fa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x02f5, code lost:
            com.oppo.camera.gl.q.h.e(r1.u);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x02fa, code lost:
            if (r15 == false) goto L_0x02ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x02fc, code lost:
            r4 = true;
            r15 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x02ff, code lost:
            r4 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x0301, code lost:
            r3 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0145, code lost:
            if (r12 == null) goto L_0x0152;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
            r12.run();
            r12 = null;
            r19 = r6;
            r6 = r0;
            r0 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0152, code lost:
            if (r14 == false) goto L_0x018a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x015a, code lost:
            if (r1.u.b() == false) goto L_0x0171;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x015c, code lost:
            r2 = com.oppo.camera.gl.q.k();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0160, code lost:
            monitor-enter(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void k() throws java.lang.InterruptedException {
            /*
                r20 = this;
                r1 = r20
                com.oppo.camera.gl.q$h r0 = new com.oppo.camera.gl.q$h
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r2 = r1.v
                r0.<init>(r2)
                r1.u = r0
                r0 = 0
                r1.h = r0
                r1.i = r0
                r1.p = r0
                r3 = r0
                r4 = r3
                r5 = r4
                r7 = r5
                r9 = r7
                r10 = r9
                r11 = r10
                r13 = r11
                r14 = r13
                r15 = r14
                r6 = 0
                r8 = 0
                r12 = 0
            L_0x001f:
                com.oppo.camera.gl.q$j r16 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0321 }
                monitor-enter(r16)     // Catch:{ all -> 0x0321 }
            L_0x0024:
                boolean r2 = r1.f3318a     // Catch:{ all -> 0x031e }
                if (r2 == 0) goto L_0x0039
                monitor-exit(r16)     // Catch:{ all -> 0x031e }
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a
                monitor-enter(r2)
                r20.i()     // Catch:{ all -> 0x0036 }
                r20.j()     // Catch:{ all -> 0x0036 }
                monitor-exit(r2)     // Catch:{ all -> 0x0036 }
                return
            L_0x0036:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0036 }
                throw r0
            L_0x0039:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.r     // Catch:{ all -> 0x031e }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x031e }
                if (r2 != 0) goto L_0x004f
                java.util.ArrayList<java.lang.Runnable> r2 = r1.r     // Catch:{ all -> 0x031e }
                r12 = 0
                java.lang.Object r2 = r2.remove(r12)     // Catch:{ all -> 0x031e }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x031e }
                r12 = r2
                r0 = r6
                r6 = 0
                goto L_0x0144
            L_0x004f:
                boolean r2 = r1.d     // Catch:{ all -> 0x031e }
                boolean r0 = r1.c     // Catch:{ all -> 0x031e }
                if (r2 == r0) goto L_0x0063
                boolean r0 = r1.c     // Catch:{ all -> 0x031e }
                boolean r2 = r1.c     // Catch:{ all -> 0x031e }
                r1.d = r2     // Catch:{ all -> 0x031e }
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x031e }
                r2.notifyAll()     // Catch:{ all -> 0x031e }
                goto L_0x0064
            L_0x0063:
                r0 = 0
            L_0x0064:
                boolean r2 = r1.k     // Catch:{ all -> 0x031e }
                if (r2 == 0) goto L_0x0072
                r20.i()     // Catch:{ all -> 0x031e }
                r20.j()     // Catch:{ all -> 0x031e }
                r2 = 0
                r1.k = r2     // Catch:{ all -> 0x031e }
                r5 = 1
            L_0x0072:
                if (r3 == 0) goto L_0x007b
                r20.i()     // Catch:{ all -> 0x031e }
                r20.j()     // Catch:{ all -> 0x031e }
                r3 = 0
            L_0x007b:
                if (r0 == 0) goto L_0x0084
                boolean r2 = r1.i     // Catch:{ all -> 0x031e }
                if (r2 == 0) goto L_0x0084
                r20.i()     // Catch:{ all -> 0x031e }
            L_0x0084:
                if (r0 == 0) goto L_0x009f
                boolean r0 = r1.h     // Catch:{ all -> 0x031e }
                if (r0 == 0) goto L_0x009f
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r0 = r1.v     // Catch:{ all -> 0x031e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x031e }
                com.oppo.camera.gl.q r0 = (com.oppo.camera.gl.q) r0     // Catch:{ all -> 0x031e }
                if (r0 != 0) goto L_0x0096
                r0 = 0
                goto L_0x009a
            L_0x0096:
                boolean r0 = r0.o     // Catch:{ all -> 0x031e }
            L_0x009a:
                if (r0 != 0) goto L_0x009f
                r20.j()     // Catch:{ all -> 0x031e }
            L_0x009f:
                boolean r0 = r1.e     // Catch:{ all -> 0x031e }
                if (r0 != 0) goto L_0x00bb
                boolean r0 = r1.g     // Catch:{ all -> 0x031e }
                if (r0 != 0) goto L_0x00bb
                boolean r0 = r1.i     // Catch:{ all -> 0x031e }
                if (r0 == 0) goto L_0x00ae
                r20.i()     // Catch:{ all -> 0x031e }
            L_0x00ae:
                r0 = 1
                r1.g = r0     // Catch:{ all -> 0x031e }
                r0 = 0
                r1.f = r0     // Catch:{ all -> 0x031e }
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x031e }
                r0.notifyAll()     // Catch:{ all -> 0x031e }
            L_0x00bb:
                boolean r0 = r1.e     // Catch:{ all -> 0x031e }
                if (r0 == 0) goto L_0x00cd
                boolean r0 = r1.g     // Catch:{ all -> 0x031e }
                if (r0 == 0) goto L_0x00cd
                r0 = 0
                r1.g = r0     // Catch:{ all -> 0x031e }
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x031e }
                r0.notifyAll()     // Catch:{ all -> 0x031e }
            L_0x00cd:
                if (r4 == 0) goto L_0x00dd
                r0 = 0
                r1.p = r0     // Catch:{ all -> 0x031e }
                r0 = 1
                r1.q = r0     // Catch:{ all -> 0x031e }
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x031e }
                r0.notifyAll()     // Catch:{ all -> 0x031e }
                r4 = 0
            L_0x00dd:
                java.lang.Runnable r0 = r1.t     // Catch:{ all -> 0x031e }
                if (r0 == 0) goto L_0x00e7
                java.lang.Runnable r0 = r1.t     // Catch:{ all -> 0x031e }
                r2 = 0
                r1.t = r2     // Catch:{ all -> 0x031e }
                goto L_0x00e9
            L_0x00e7:
                r2 = 0
                r0 = r6
            L_0x00e9:
                boolean r6 = r20.l()     // Catch:{ all -> 0x031e }
                if (r6 == 0) goto L_0x0305
                boolean r6 = r1.h     // Catch:{ all -> 0x031e }
                if (r6 != 0) goto L_0x0111
                if (r5 == 0) goto L_0x00f7
                r5 = 0
                goto L_0x0111
            L_0x00f7:
                com.oppo.camera.gl.q$h r6 = r1.u     // Catch:{ RuntimeException -> 0x0108 }
                r6.a()     // Catch:{ RuntimeException -> 0x0108 }
                r6 = 1
                r1.h = r6     // Catch:{ all -> 0x031e }
                com.oppo.camera.gl.q$j r6 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x031e }
                r6.notifyAll()     // Catch:{ all -> 0x031e }
                r13 = 1
                goto L_0x0111
            L_0x0108:
                r0 = move-exception
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x031e }
                r2.b(r1)     // Catch:{ all -> 0x031e }
                throw r0     // Catch:{ all -> 0x031e }
            L_0x0111:
                boolean r6 = r1.h     // Catch:{ all -> 0x031e }
                if (r6 == 0) goto L_0x011f
                boolean r6 = r1.i     // Catch:{ all -> 0x031e }
                if (r6 != 0) goto L_0x011f
                r6 = 1
                r1.i = r6     // Catch:{ all -> 0x031e }
                r7 = 1
                r9 = 1
                r14 = 1
            L_0x011f:
                boolean r6 = r1.i     // Catch:{ all -> 0x031e }
                if (r6 == 0) goto L_0x0313
                boolean r6 = r1.s     // Catch:{ all -> 0x031e }
                if (r6 == 0) goto L_0x0135
                int r10 = r1.l     // Catch:{ all -> 0x031e }
                int r11 = r1.m     // Catch:{ all -> 0x031e }
                r6 = 1
                r1.p = r6     // Catch:{ all -> 0x031e }
                r6 = 0
                r1.s = r6     // Catch:{ all -> 0x031e }
                r6 = 0
                r9 = 1
                r14 = 1
                goto L_0x0136
            L_0x0135:
                r6 = 0
            L_0x0136:
                r1.o = r6     // Catch:{ all -> 0x031e }
                com.oppo.camera.gl.q$j r17 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x031e }
                r17.notifyAll()     // Catch:{ all -> 0x031e }
                boolean r2 = r1.p     // Catch:{ all -> 0x031e }
                if (r2 == 0) goto L_0x0144
                r15 = 1
            L_0x0144:
                monitor-exit(r16)     // Catch:{ all -> 0x031e }
                if (r12 == 0) goto L_0x0152
                r12.run()     // Catch:{ all -> 0x0321 }
                r12 = 0
                r19 = r6
                r6 = r0
                r0 = r19
                goto L_0x001f
            L_0x0152:
                if (r14 == 0) goto L_0x018a
                com.oppo.camera.gl.q$h r2 = r1.u     // Catch:{ all -> 0x0321 }
                boolean r2 = r2.b()     // Catch:{ all -> 0x0321 }
                if (r2 == 0) goto L_0x0171
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0321 }
                monitor-enter(r2)     // Catch:{ all -> 0x0321 }
                r14 = 1
                r1.j = r14     // Catch:{ all -> 0x016e }
                com.oppo.camera.gl.q$j r14 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x016e }
                r14.notifyAll()     // Catch:{ all -> 0x016e }
                monitor-exit(r2)     // Catch:{ all -> 0x016e }
                r14 = r6
                goto L_0x018a
            L_0x016e:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x016e }
                throw r0     // Catch:{ all -> 0x0321 }
            L_0x0171:
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0321 }
                monitor-enter(r2)     // Catch:{ all -> 0x0321 }
                r6 = 1
                r1.j = r6     // Catch:{ all -> 0x0187 }
                r1.f = r6     // Catch:{ all -> 0x0187 }
                com.oppo.camera.gl.q$j r6 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0187 }
                r6.notifyAll()     // Catch:{ all -> 0x0187 }
                monitor-exit(r2)     // Catch:{ all -> 0x0187 }
                r6 = r0
            L_0x0184:
                r0 = 0
                goto L_0x001f
            L_0x0187:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0187 }
                throw r0     // Catch:{ all -> 0x0321 }
            L_0x018a:
                if (r7 == 0) goto L_0x0196
                com.oppo.camera.gl.q$h r2 = r1.u     // Catch:{ all -> 0x0321 }
                javax.microedition.khronos.opengles.GL r2 = r2.h()     // Catch:{ all -> 0x0321 }
                javax.microedition.khronos.opengles.GL10 r2 = (javax.microedition.khronos.opengles.GL10) r2     // Catch:{ all -> 0x0321 }
                r8 = r2
                r7 = 0
            L_0x0196:
                if (r13 == 0) goto L_0x01c2
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r2 = r1.v     // Catch:{ all -> 0x0321 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q r2 = (com.oppo.camera.gl.q) r2     // Catch:{ all -> 0x0321 }
                if (r2 == 0) goto L_0x01c1
                java.lang.String r6 = "onSurfaceCreated"
                com.oppo.camera.e.a((java.lang.String) r6)     // Catch:{ all -> 0x01ba }
                com.oppo.camera.gl.q$m r2 = r2.g     // Catch:{ all -> 0x01ba }
                com.oppo.camera.gl.q$h r6 = r1.u     // Catch:{ all -> 0x01ba }
                javax.microedition.khronos.egl.EGLConfig r6 = r6.g     // Catch:{ all -> 0x01ba }
                r2.a(r8, r6)     // Catch:{ all -> 0x01ba }
                java.lang.String r2 = "onSurfaceCreated"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0321 }
                goto L_0x01c1
            L_0x01ba:
                r0 = move-exception
                java.lang.String r2 = "onSurfaceCreated"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0321 }
                throw r0     // Catch:{ all -> 0x0321 }
            L_0x01c1:
                r13 = 0
            L_0x01c2:
                if (r9 == 0) goto L_0x01e8
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r2 = r1.v     // Catch:{ all -> 0x0321 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q r2 = (com.oppo.camera.gl.q) r2     // Catch:{ all -> 0x0321 }
                if (r2 == 0) goto L_0x01e7
                java.lang.String r6 = "onSurfaceChanged"
                com.oppo.camera.e.a((java.lang.String) r6)     // Catch:{ all -> 0x01e0 }
                com.oppo.camera.gl.q$m r2 = r2.g     // Catch:{ all -> 0x01e0 }
                r2.a(r8, r10, r11)     // Catch:{ all -> 0x01e0 }
                java.lang.String r2 = "onSurfaceChanged"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0321 }
                goto L_0x01e7
            L_0x01e0:
                r0 = move-exception
                java.lang.String r2 = "onSurfaceChanged"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0321 }
                throw r0     // Catch:{ all -> 0x0321 }
            L_0x01e7:
                r9 = 0
            L_0x01e8:
                com.oppo.camera.gl.q$h r2 = r1.u     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q$h r6 = r1.u     // Catch:{ all -> 0x0321 }
                javax.microedition.khronos.egl.EGLSurface r6 = r6.e     // Catch:{ all -> 0x0321 }
                r2.a((javax.microedition.khronos.egl.EGLSurface) r6)     // Catch:{ all -> 0x0321 }
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r2 = r1.v     // Catch:{ all -> 0x0321 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q r2 = (com.oppo.camera.gl.q) r2     // Catch:{ all -> 0x0321 }
                if (r2 == 0) goto L_0x021c
                java.lang.String r6 = "onDrawFrame"
                com.oppo.camera.e.a((java.lang.String) r6)     // Catch:{ all -> 0x0215 }
                com.oppo.camera.gl.q$m r2 = r2.g     // Catch:{ all -> 0x0215 }
                r2.b(r8)     // Catch:{ all -> 0x0215 }
                if (r0 == 0) goto L_0x020f
                r0.run()     // Catch:{ all -> 0x0215 }
                r0 = 0
            L_0x020f:
                java.lang.String r2 = "onDrawFrame"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0321 }
                goto L_0x021c
            L_0x0215:
                r0 = move-exception
                java.lang.String r2 = "onDrawFrame"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0321 }
                throw r0     // Catch:{ all -> 0x0321 }
            L_0x021c:
                r6 = r0
                com.oppo.camera.gl.q$h r0 = r1.u     // Catch:{ all -> 0x0321 }
                int r0 = r0.d()     // Catch:{ all -> 0x0321 }
                r2 = 12288(0x3000, float:1.7219E-41)
                if (r0 == r2) goto L_0x024b
                r2 = 12302(0x300e, float:1.7239E-41)
                if (r0 == r2) goto L_0x0248
                java.lang.String r2 = "GLSurfaceView"
                r18 = r3
                java.lang.String r3 = "eglSwapBuffers"
                com.oppo.camera.gl.q.h.a(r2, r3, r0)     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0321 }
                monitor-enter(r2)     // Catch:{ all -> 0x0321 }
                r0 = 1
                r1.f = r0     // Catch:{ all -> 0x0245 }
                com.oppo.camera.gl.q$j r3 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0245 }
                r3.notifyAll()     // Catch:{ all -> 0x0245 }
                monitor-exit(r2)     // Catch:{ all -> 0x0245 }
                goto L_0x024e
            L_0x0245:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0245 }
                throw r0     // Catch:{ all -> 0x0321 }
            L_0x0248:
                r0 = 1
                r3 = r0
                goto L_0x0250
            L_0x024b:
                r18 = r3
                r0 = 1
            L_0x024e:
                r3 = r18
            L_0x0250:
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r2 = r1.v     // Catch:{ all -> 0x0321 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q r2 = (com.oppo.camera.gl.q) r2     // Catch:{ all -> 0x0321 }
                android.view.Surface r2 = r2.c     // Catch:{ all -> 0x0321 }
                if (r2 == 0) goto L_0x02e9
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r2 = r1.v     // Catch:{ all -> 0x0321 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q r2 = (com.oppo.camera.gl.q) r2     // Catch:{ all -> 0x0321 }
                android.view.Surface r2 = r2.c     // Catch:{ all -> 0x0321 }
                boolean r2 = r2.isValid()     // Catch:{ all -> 0x0321 }
                if (r2 == 0) goto L_0x02e9
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r2 = r1.v     // Catch:{ all -> 0x0321 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q r2 = (com.oppo.camera.gl.q) r2     // Catch:{ all -> 0x0321 }
                boolean r2 = r2.e     // Catch:{ all -> 0x0321 }
                if (r2 != 0) goto L_0x02e9
                com.oppo.camera.gl.q$h r2 = r1.u     // Catch:{ all -> 0x0321 }
                javax.microedition.khronos.egl.EGLSurface r2 = r2.f     // Catch:{ all -> 0x0321 }
                if (r2 != 0) goto L_0x028b
                com.oppo.camera.gl.q$h r2 = r1.u     // Catch:{ all -> 0x0321 }
                r2.c()     // Catch:{ all -> 0x0321 }
            L_0x028b:
                com.oppo.camera.gl.q$h r2 = r1.u     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q$h r0 = r1.u     // Catch:{ all -> 0x0321 }
                javax.microedition.khronos.egl.EGLSurface r0 = r0.f     // Catch:{ all -> 0x0321 }
                r2.a((javax.microedition.khronos.egl.EGLSurface) r0)     // Catch:{ all -> 0x0321 }
                java.lang.ref.WeakReference<com.oppo.camera.gl.q> r0 = r1.v     // Catch:{ all -> 0x0321 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q r0 = (com.oppo.camera.gl.q) r0     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.r r2 = r0.d     // Catch:{ all -> 0x0321 }
                if (r2 == 0) goto L_0x02ab
                com.oppo.camera.gl.r r0 = r0.d     // Catch:{ all -> 0x0321 }
                r0.a(r8)     // Catch:{ all -> 0x0321 }
            L_0x02ab:
                java.lang.String r0 = "GLSurfaceView"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0321 }
                r2.<init>()     // Catch:{ all -> 0x0321 }
                r16 = r3
                java.lang.String r3 = "guardedRun, OutputSurfaceDraw swap start tid: "
                r2.append(r3)     // Catch:{ all -> 0x0321 }
                r18 = r4
                long r3 = r20.getId()     // Catch:{ all -> 0x0321 }
                r2.append(r3)     // Catch:{ all -> 0x0321 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.e.a(r0, r2)     // Catch:{ all -> 0x0321 }
                com.oppo.camera.gl.q$h r0 = r1.u     // Catch:{ all -> 0x0321 }
                r0.e()     // Catch:{ all -> 0x0321 }
                java.lang.String r0 = "GLSurfaceView"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0321 }
                r2.<init>()     // Catch:{ all -> 0x0321 }
                java.lang.String r3 = "guardedRun, OutputSurfaceDraw swap end tid: "
                r2.append(r3)     // Catch:{ all -> 0x0321 }
                long r3 = r20.getId()     // Catch:{ all -> 0x0321 }
                r2.append(r3)     // Catch:{ all -> 0x0321 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0321 }
                com.oppo.camera.e.a(r0, r2)     // Catch:{ all -> 0x0321 }
                goto L_0x02fa
            L_0x02e9:
                r16 = r3
                r18 = r4
                com.oppo.camera.gl.q$h r0 = r1.u     // Catch:{ all -> 0x0321 }
                javax.microedition.khronos.egl.EGLSurface r0 = r0.f     // Catch:{ all -> 0x0321 }
                if (r0 == 0) goto L_0x02fa
                com.oppo.camera.gl.q$h r0 = r1.u     // Catch:{ all -> 0x0321 }
                r0.j()     // Catch:{ all -> 0x0321 }
            L_0x02fa:
                if (r15 == 0) goto L_0x02ff
                r4 = 1
                r15 = 0
                goto L_0x0301
            L_0x02ff:
                r4 = r18
            L_0x0301:
                r3 = r16
                goto L_0x0184
            L_0x0305:
                if (r0 == 0) goto L_0x0313
                java.lang.String r2 = "GLSurfaceView"
                java.lang.String r6 = "guardedRun, Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished."
                com.oppo.camera.e.d(r2, r6)     // Catch:{ all -> 0x031e }
                r0.run()     // Catch:{ all -> 0x031e }
                r6 = 0
                goto L_0x0314
            L_0x0313:
                r6 = r0
            L_0x0314:
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x031e }
                r0.wait()     // Catch:{ all -> 0x031e }
                r0 = 0
                goto L_0x0024
            L_0x031e:
                r0 = move-exception
                monitor-exit(r16)     // Catch:{ all -> 0x031e }
                throw r0     // Catch:{ all -> 0x0321 }
            L_0x0321:
                r0 = move-exception
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a
                monitor-enter(r2)
                r20.i()     // Catch:{ all -> 0x032f }
                r20.j()     // Catch:{ all -> 0x032f }
                monitor-exit(r2)     // Catch:{ all -> 0x032f }
                throw r0
            L_0x032f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x032f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.q.i.k():void");
        }

        public boolean a() {
            return this.h && this.i && l();
        }

        private boolean l() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public void a(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (q.f3310a) {
                this.n = i2;
                q.f3310a.notifyAll();
            }
        }

        public int b() {
            int i2;
            synchronized (q.f3310a) {
                i2 = this.n;
            }
            return i2;
        }

        public void c() {
            synchronized (q.f3310a) {
                this.o = true;
                q.f3310a.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0012, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r2 = this;
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a
                monitor-enter(r0)
                r1 = 1
                r2.e = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.j = r1     // Catch:{ all -> 0x0030 }
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.g     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.j     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.f3319b     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ InterruptedException -> 0x0026 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0026 }
                goto L_0x0012
            L_0x0026:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
                r1.interrupt()     // Catch:{ all -> 0x0030 }
                goto L_0x0012
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.q.i.d():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r2 = this;
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a
                monitor-enter(r0)
                r1 = 0
                r2.e = r1     // Catch:{ all -> 0x0029 }
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.g     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.f3319b     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.q.i.e():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:9|10|11|12|13|23|19|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f() {
            /*
                r3 = this;
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a
                monitor-enter(r0)
                r1 = 1
                r3.c = r1     // Catch:{ all -> 0x0030 }
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x000f:
                boolean r1 = r3.f3319b     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r3.d     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                java.lang.String r1 = "GLSurfaceView"
                java.lang.String r2 = "onPause, sGLThreadManager.wait"
                com.oppo.camera.e.a(r1, r2)     // Catch:{ InterruptedException -> 0x0026 }
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ InterruptedException -> 0x0026 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0026 }
                goto L_0x000f
            L_0x0026:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
                r1.interrupt()     // Catch:{ all -> 0x0030 }
                goto L_0x000f
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.q.i.f():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r3 = this;
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a
                monitor-enter(r0)
                r1 = 0
                r3.c = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.o = r2     // Catch:{ all -> 0x0032 }
                r3.q = r1     // Catch:{ all -> 0x0032 }
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.f3319b     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.d     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.q     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ InterruptedException -> 0x0028 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
                r1.interrupt()     // Catch:{ all -> 0x0032 }
                goto L_0x0014
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.q.i.g():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|31|25|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0020, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r2, int r3) {
            /*
                r1 = this;
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a
                monitor-enter(r0)
                r1.l = r2     // Catch:{ all -> 0x0044 }
                r1.m = r3     // Catch:{ all -> 0x0044 }
                r2 = 1
                r1.s = r2     // Catch:{ all -> 0x0044 }
                r1.o = r2     // Catch:{ all -> 0x0044 }
                r2 = 0
                r1.q = r2     // Catch:{ all -> 0x0044 }
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
                if (r2 != r1) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                return
            L_0x0019:
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x0044 }
                r2.notifyAll()     // Catch:{ all -> 0x0044 }
            L_0x0020:
                boolean r2 = r1.f3319b     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.d     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.q     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.a()     // Catch:{ all -> 0x0044 }
                if (r2 == 0) goto L_0x0042
                com.oppo.camera.gl.q$j r2 = com.oppo.camera.gl.q.f3310a     // Catch:{ InterruptedException -> 0x003a }
                r2.wait()     // Catch:{ InterruptedException -> 0x003a }
                goto L_0x0020
            L_0x003a:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
                r2.interrupt()     // Catch:{ all -> 0x0044 }
                goto L_0x0020
            L_0x0042:
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                return
            L_0x0044:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.q.i.a(int, int):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0016, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h() {
            /*
                r3 = this;
                com.oppo.camera.gl.q$j r0 = com.oppo.camera.gl.q.f3310a
                monitor-enter(r0)
                java.lang.String r1 = "GLSurfaceView"
                java.lang.String r2 = "requestExitAndWait"
                com.oppo.camera.e.a(r1, r2)     // Catch:{ all -> 0x002c }
                r1 = 1
                r3.f3318a = r1     // Catch:{ all -> 0x002c }
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ all -> 0x002c }
                r1.notifyAll()     // Catch:{ all -> 0x002c }
            L_0x0016:
                boolean r1 = r3.f3319b     // Catch:{ all -> 0x002c }
                if (r1 != 0) goto L_0x002a
                com.oppo.camera.gl.q$j r1 = com.oppo.camera.gl.q.f3310a     // Catch:{ InterruptedException -> 0x0022 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0022 }
                goto L_0x0016
            L_0x0022:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002c }
                r1.interrupt()     // Catch:{ all -> 0x002c }
                goto L_0x0016
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                return
            L_0x002c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.q.i.h():void");
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (q.f3310a) {
                    this.r.add(runnable);
                    q.f3310a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* compiled from: OppoGLSurfaceView */
    static class l extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f3320a = new StringBuilder();

        l() {
        }

        public void close() {
            a();
        }

        public void flush() {
            a();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    a();
                } else {
                    this.f3320a.append(c);
                }
            }
        }

        private void a() {
            if (this.f3320a.length() > 0) {
                com.oppo.camera.e.a("GLSurfaceView", "flushBuilder, mBuilder: " + this.f3320a.toString());
                StringBuilder sb = this.f3320a;
                sb.delete(0, sb.length());
            }
        }
    }

    private void e() {
        if (this.f != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void h() {
        a((Runnable) new Runnable() {
            public void run() {
                q.this.f.u.j();
                if (q.this.c != null) {
                    q.this.c.release();
                    Surface unused = q.this.c = null;
                }
            }
        });
    }

    public void setOutputRender(r rVar) {
        this.d = rVar;
    }

    public void i() {
        this.e = true;
    }

    public void j() {
        this.e = false;
    }

    public void setOutput(Surface surface) {
        this.c = surface;
    }

    public Surface getOutputSurface() {
        return this.c;
    }

    /* compiled from: OppoGLSurfaceView */
    private static class j {
        private j() {
        }

        public synchronized void a(i iVar) {
            boolean unused = iVar.f3319b = true;
            notifyAll();
        }

        public void b(i iVar) {
            notifyAll();
        }
    }
}
