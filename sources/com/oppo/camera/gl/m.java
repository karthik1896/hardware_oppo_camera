package com.oppo.camera.gl;

import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.Choreographer;
import android.view.SurfaceHolder;
import com.sensetime.blur.BlurFilterLibrary;
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

/* compiled from: GLProducer */
public class m<T> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final j f3293b = new j();

    /* renamed from: a  reason: collision with root package name */
    Choreographer.FrameCallback f3294a = new Choreographer.FrameCallback() {
        public void doFrame(long j) {
            m.this.d();
            if (m.this.c() == 1) {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    };
    private final WeakReference<m> c = new WeakReference<>(this);
    private i d;
    /* access modifiers changed from: private */
    public C0085m e;
    private T f;
    /* access modifiers changed from: private */
    public e g;
    /* access modifiers changed from: private */
    public f h;
    /* access modifiers changed from: private */
    public g i;
    /* access modifiers changed from: private */
    public k j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public boolean m;

    /* compiled from: GLProducer */
    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLProducer */
    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLProducer */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: GLProducer */
    public interface k {
        GL a(GL gl);
    }

    /* renamed from: com.oppo.camera.gl.m$m  reason: collision with other inner class name */
    /* compiled from: GLProducer */
    public interface C0085m {
        void a(GL10 gl10);

        void a(GL10 gl10, int i, int i2);

        void a(GL10 gl10, EGLConfig eGLConfig);
    }

    public m(T t) {
        this.f = t;
    }

    public T a() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.d != null) {
                this.d.h();
            }
        } finally {
            super.finalize();
        }
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(C0085m mVar) {
        i();
        if (this.g == null) {
            this.g = new n(true);
        }
        if (this.h == null) {
            this.h = new c();
        }
        if (this.i == null) {
            this.i = new d();
        }
        this.e = mVar;
        this.d = new i(this.c);
        this.d.start();
    }

    public void a(e eVar) {
        i();
        this.g = eVar;
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        a((e) new b(i2, i3, i4, i5, i6, i7));
    }

    public void a(int i2) {
        i();
        this.l = i2;
    }

    public void b(int i2) {
        this.d.a(i2);
    }

    public void b() {
        Choreographer.getInstance().removeFrameCallback(this.f3294a);
        Choreographer.getInstance().postFrameCallback(this.f3294a);
    }

    public int c() {
        return this.d.b();
    }

    public void d() {
        this.d.c();
    }

    public void a(SurfaceHolder surfaceHolder) {
        this.d.d();
    }

    public void b(SurfaceHolder surfaceHolder) {
        this.d.e();
    }

    public void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.d.a(i3, i4);
    }

    public void e() {
        Log.d("GLProducer", "requestExitAndWait");
        i iVar = this.d;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void f() {
        this.d.f();
        Choreographer.getInstance().removeFrameCallback(this.f3294a);
    }

    public void g() {
        this.d.g();
    }

    public void a(Runnable runnable) {
        this.d.a(runnable);
    }

    /* compiled from: GLProducer */
    private class c implements f {

        /* renamed from: b  reason: collision with root package name */
        private int f3299b;

        private c() {
            this.f3299b = 12440;
        }

        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f3299b, m.this.l, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (m.this.l == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: GLProducer */
    private static class d implements g {
        private d() {
        }

        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e) {
                Log.e("GLProducer", "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLProducer */
    private abstract class a implements e {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f3296a;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.f3296a = a(iArr);
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f3296a, (EGLConfig[]) null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f3296a, eGLConfigArr, i, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] a(int[] iArr) {
            if (m.this.l != 2 && m.this.l != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (m.this.l == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* compiled from: GLProducer */
    private class b extends m<T>.a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j = new int[1];

        public b(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int a2 = a(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int a3 = a(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (a2 >= this.g && a3 >= this.h) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int a4 = a(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int a5 = a(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int a6 = a(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int a7 = a(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (a4 == this.c && a5 == this.d && a6 == this.e && a7 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.j) ? this.j[0] : i3;
        }
    }

    /* compiled from: GLProducer */
    private class n extends m<T>.b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* compiled from: GLProducer */
    private static class h {

        /* renamed from: a  reason: collision with root package name */
        EGL10 f3300a;

        /* renamed from: b  reason: collision with root package name */
        EGLDisplay f3301b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<m> f;

        public h(WeakReference<m> weakReference) {
            this.f = weakReference;
        }

        public void a() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            this.f3300a = (EGL10) EGLContext.getEGL();
            this.f3301b = this.f3300a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f3301b != EGL10.EGL_NO_DISPLAY) {
                if (this.f3300a.eglInitialize(this.f3301b, new int[2])) {
                    m mVar = (m) this.f.get();
                    if (mVar == null) {
                        this.d = null;
                        this.e = null;
                    } else {
                        this.d = mVar.g.a(this.f3300a, this.f3301b);
                        this.e = mVar.h.a(this.f3300a, this.f3301b, this.d);
                    }
                    if (this.e == null || EGL10.EGL_NO_CONTEXT == this.e) {
                        this.e = null;
                        a("createContext");
                    }
                    Log.v("GLProducer", "createContext, mEglContext: " + this.e + " tid: " + Thread.currentThread().getId());
                    this.c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            EGLSurface eGLSurface;
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f3300a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.f3301b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.d != null) {
                g();
                m mVar = (m) this.f.get();
                if (mVar != null) {
                    this.c = mVar.i.a(this.f3300a, this.f3301b, this.d, mVar.a());
                } else {
                    this.c = null;
                }
                if (this.c == null || EGL10.EGL_NO_SURFACE == (eGLSurface = this.c)) {
                    if (this.f3300a.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.f3300a.eglMakeCurrent(this.f3301b, eGLSurface, eGLSurface, this.e)) {
                    return true;
                } else {
                    a("EGLHelper", "eglMakeCurrent", this.f3300a.eglGetError());
                    return false;
                }
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public GL c() {
            GL gl = this.e.getGL();
            m mVar = (m) this.f.get();
            if (mVar == null) {
                return gl;
            }
            if (mVar.j != null) {
                gl = mVar.j.a(gl);
            }
            if ((mVar.k & 3) == 0) {
                return gl;
            }
            int i = 0;
            l lVar = null;
            if ((mVar.k & 1) != 0) {
                i = 1;
            }
            if ((mVar.k & 2) != 0) {
                lVar = new l();
            }
            return GLDebugHelper.wrap(gl, i, lVar);
        }

        public int d() {
            if (!this.f3300a.eglSwapBuffers(this.f3301b, this.c)) {
                return this.f3300a.eglGetError();
            }
            return 12288;
        }

        public void e() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            g();
        }

        private void g() {
            EGLSurface eGLSurface = this.c;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.f3300a.eglMakeCurrent(this.f3301b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                m mVar = (m) this.f.get();
                if (mVar != null) {
                    mVar.i.a(this.f3300a, this.f3301b, this.c);
                }
                this.c = null;
            }
        }

        public void f() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.e != null) {
                m mVar = (m) this.f.get();
                if (mVar != null) {
                    Log.v("GLProducer", "finish, destroyContext mEglContext: " + this.e);
                    mVar.h.a(this.f3300a, this.f3301b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.f3301b;
            if (eGLDisplay != null) {
                this.f3300a.eglTerminate(eGLDisplay);
                this.f3301b = null;
            }
        }

        private void a(String str) {
            a(str, this.f3300a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + m.e(i);
        }
    }

    private static String d(int i2) {
        return "0x" + Integer.toHexString(i2);
    }

    /* access modifiers changed from: private */
    public static String e(int i2) {
        switch (i2) {
            case 12288:
                return "EGL_SUCCESS";
            case BlurFilterLibrary.ST_BLUR_PARAM_TYPE_EFFECT_TYPE /*12289*/:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return d(i2);
        }
    }

    /* compiled from: GLProducer */
    static class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3302a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f3303b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l = 0;
        private int m = 0;
        private int n = 1;
        private boolean o = true;
        private boolean p = false;
        private boolean q;
        private ArrayList<Runnable> r = new ArrayList<>();
        private boolean s = true;
        private h t;
        private WeakReference<m> u;

        i(WeakReference<m> weakReference) {
            this.u = weakReference;
        }

        public void run() {
            setName("GLProducer " + getId());
            try {
                k();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                m.f3293b.a(this);
                throw th;
            }
            m.f3293b.a(this);
        }

        private void i() {
            if (this.i) {
                this.i = false;
                this.t.e();
            }
        }

        private void j() {
            if (this.h) {
                this.t.f();
                this.h = false;
                m.f3293b.b(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
            r1.j = true;
            com.oppo.camera.gl.m.h().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0273, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0274, code lost:
            r12 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0279, code lost:
            r7 = com.oppo.camera.gl.m.h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x027d, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
            r1.j = true;
            r1.f = true;
            com.oppo.camera.gl.m.h().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x028a, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x028b, code lost:
            r0 = r2;
            r7 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x0293, code lost:
            if (r13 == false) goto L_0x02a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0295, code lost:
            r7 = (javax.microedition.khronos.opengles.GL10) r1.t.c();
            r13 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x02a0, code lost:
            r7 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x02a2, code lost:
            if (r11 == false) goto L_0x02cc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x02a4, code lost:
            r0 = (com.oppo.camera.gl.m) r1.u.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ac, code lost:
            if (r0 == null) goto L_0x02cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
            com.oppo.camera.e.a("onSurfaceCreated");
            com.oppo.camera.gl.m.h(r0).a(r7, r1.t.d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
            com.oppo.camera.e.b("onSurfaceCreated");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x02cb, code lost:
            r11 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x02cc, code lost:
            if (r6 == false) goto L_0x02f2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x02ce, code lost:
            r0 = (com.oppo.camera.gl.m) r1.u.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x02d6, code lost:
            if (r0 == null) goto L_0x02f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
            com.oppo.camera.e.a("onSurfaceChanged");
            com.oppo.camera.gl.m.h(r0).a(r7, r9, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
            com.oppo.camera.e.b("onSurfaceChanged");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x02f1, code lost:
            r6 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x02f2, code lost:
            r0 = (com.oppo.camera.gl.m) r1.u.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x02fa, code lost:
            if (r0 == null) goto L_0x0315;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
            com.oppo.camera.e.a("onDrawFrame");
            com.oppo.camera.gl.m.h(r0).a(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:?, code lost:
            com.oppo.camera.e.b("onDrawFrame");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0315, code lost:
            r0 = r1.t.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x031d, code lost:
            if (r0 == 12288) goto L_0x035a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0321, code lost:
            if (r0 == 12302) goto L_0x033e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0323, code lost:
            com.oppo.camera.gl.m.h.a("GLThread", "eglSwapBuffers", r0);
            r2 = com.oppo.camera.gl.m.h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x032e, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
            r1.f = true;
            com.oppo.camera.gl.m.h().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0339, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x033e, code lost:
            android.util.Log.i("GLThread", "egl context lost tid=" + getId());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x0359, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x035a, code lost:
            if (r8 == false) goto L_0x035e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x035c, code lost:
            r4 = true;
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x035e, code lost:
            r1 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0249, code lost:
            if (r14 == null) goto L_0x0253;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0253, code lost:
            if (r12 == false) goto L_0x0293;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0255, code lost:
            android.util.Log.w("GLThread", "egl createSurface");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0262, code lost:
            if (r1.t.b() == false) goto L_0x0279;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0264, code lost:
            r7 = com.oppo.camera.gl.m.h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0268, code lost:
            monitor-enter(r7);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void k() throws java.lang.InterruptedException {
            /*
                r19 = this;
                r1 = r19
                com.oppo.camera.gl.m$h r0 = new com.oppo.camera.gl.m$h
                java.lang.ref.WeakReference<com.oppo.camera.gl.m> r2 = r1.u
                r0.<init>(r2)
                r1.t = r0
                r0 = 0
                r1.h = r0
                r1.i = r0
                r1.p = r0
                r3 = r0
                r4 = r3
                r5 = r4
                r6 = r5
                r8 = r6
                r9 = r8
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r7 = 0
            L_0x001d:
                r14 = 0
            L_0x001e:
                com.oppo.camera.gl.m$j r15 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0377 }
                monitor-enter(r15)     // Catch:{ all -> 0x0377 }
            L_0x0023:
                boolean r2 = r1.f3302a     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x0038
                monitor-exit(r15)     // Catch:{ all -> 0x0374 }
                com.oppo.camera.gl.m$j r2 = com.oppo.camera.gl.m.f3293b
                monitor-enter(r2)
                r19.i()     // Catch:{ all -> 0x0035 }
                r19.j()     // Catch:{ all -> 0x0035 }
                monitor-exit(r2)     // Catch:{ all -> 0x0035 }
                return
            L_0x0035:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0035 }
                throw r0
            L_0x0038:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.r     // Catch:{ all -> 0x0374 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0374 }
                if (r2 != 0) goto L_0x004f
                java.util.ArrayList<java.lang.Runnable> r2 = r1.r     // Catch:{ all -> 0x0374 }
                r14 = 0
                java.lang.Object r2 = r2.remove(r14)     // Catch:{ all -> 0x0374 }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x0374 }
                r14 = r2
                r17 = r7
                r2 = 0
                goto L_0x0248
            L_0x004f:
                boolean r2 = r1.d     // Catch:{ all -> 0x0374 }
                boolean r0 = r1.c     // Catch:{ all -> 0x0374 }
                if (r2 == r0) goto L_0x008d
                boolean r0 = r1.c     // Catch:{ all -> 0x0374 }
                boolean r2 = r1.c     // Catch:{ all -> 0x0374 }
                r1.d = r2     // Catch:{ all -> 0x0374 }
                com.oppo.camera.gl.m$j r2 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0374 }
                r2.notifyAll()     // Catch:{ all -> 0x0374 }
                java.lang.String r2 = "GLThread"
                r16 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r0.<init>()     // Catch:{ all -> 0x0374 }
                r17 = r5
                java.lang.String r5 = "mPaused is now "
                r0.append(r5)     // Catch:{ all -> 0x0374 }
                boolean r5 = r1.d     // Catch:{ all -> 0x0374 }
                r0.append(r5)     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = " tid: "
                r0.append(r5)     // Catch:{ all -> 0x0374 }
                r18 = r6
                long r5 = r19.getId()     // Catch:{ all -> 0x0374 }
                r0.append(r5)     // Catch:{ all -> 0x0374 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r2, r0)     // Catch:{ all -> 0x0374 }
                goto L_0x0093
            L_0x008d:
                r17 = r5
                r18 = r6
                r16 = 0
            L_0x0093:
                boolean r0 = r1.k     // Catch:{ all -> 0x0374 }
                if (r0 == 0) goto L_0x00bc
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r2.<init>()     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = "0 releasing EGL context because asked to tid: "
                r2.append(r5)     // Catch:{ all -> 0x0374 }
                long r5 = r19.getId()     // Catch:{ all -> 0x0374 }
                r2.append(r5)     // Catch:{ all -> 0x0374 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0374 }
                r19.i()     // Catch:{ all -> 0x0374 }
                r19.j()     // Catch:{ all -> 0x0374 }
                r0 = 0
                r1.k = r0     // Catch:{ all -> 0x0374 }
                r0 = 1
                goto L_0x00be
            L_0x00bc:
                r0 = r17
            L_0x00be:
                if (r3 == 0) goto L_0x00e1
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r3.<init>()     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = "1 releasing EGL surface because paused tid: "
                r3.append(r5)     // Catch:{ all -> 0x0374 }
                long r5 = r19.getId()     // Catch:{ all -> 0x0374 }
                r3.append(r5)     // Catch:{ all -> 0x0374 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x0374 }
                r19.i()     // Catch:{ all -> 0x0374 }
                r19.j()     // Catch:{ all -> 0x0374 }
                r3 = 0
            L_0x00e1:
                if (r16 == 0) goto L_0x0107
                boolean r2 = r1.i     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x0107
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r5.<init>()     // Catch:{ all -> 0x0374 }
                java.lang.String r6 = "xxxx releasing EGL surface because paused tid: "
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                r17 = r7
                long r6 = r19.getId()     // Catch:{ all -> 0x0374 }
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0374 }
                r19.i()     // Catch:{ all -> 0x0374 }
                goto L_0x0109
            L_0x0107:
                r17 = r7
            L_0x0109:
                if (r16 == 0) goto L_0x013e
                boolean r2 = r1.h     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x013e
                java.lang.ref.WeakReference<com.oppo.camera.gl.m> r2 = r1.u     // Catch:{ all -> 0x0374 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0374 }
                com.oppo.camera.gl.m r2 = (com.oppo.camera.gl.m) r2     // Catch:{ all -> 0x0374 }
                if (r2 != 0) goto L_0x011b
                r2 = 0
                goto L_0x011f
            L_0x011b:
                boolean r2 = r2.m     // Catch:{ all -> 0x0374 }
            L_0x011f:
                if (r2 != 0) goto L_0x013e
                r19.j()     // Catch:{ all -> 0x0374 }
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r5.<init>()     // Catch:{ all -> 0x0374 }
                java.lang.String r6 = "releasing EGL context because paused tid="
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                long r6 = r19.getId()     // Catch:{ all -> 0x0374 }
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0374 }
            L_0x013e:
                boolean r2 = r1.e     // Catch:{ all -> 0x0374 }
                if (r2 != 0) goto L_0x0174
                boolean r2 = r1.g     // Catch:{ all -> 0x0374 }
                if (r2 != 0) goto L_0x0174
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r5.<init>()     // Catch:{ all -> 0x0374 }
                java.lang.String r6 = "noticed surfaceView surface lost tid="
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                long r6 = r19.getId()     // Catch:{ all -> 0x0374 }
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0374 }
                boolean r2 = r1.i     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x0167
                r19.i()     // Catch:{ all -> 0x0374 }
            L_0x0167:
                r2 = 1
                r1.g = r2     // Catch:{ all -> 0x0374 }
                r2 = 0
                r1.f = r2     // Catch:{ all -> 0x0374 }
                com.oppo.camera.gl.m$j r2 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0374 }
                r2.notifyAll()     // Catch:{ all -> 0x0374 }
            L_0x0174:
                boolean r2 = r1.e     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x01a0
                boolean r2 = r1.g     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x01a0
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r5.<init>()     // Catch:{ all -> 0x0374 }
                java.lang.String r6 = "noticed surfaceView surface acquired tid="
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                long r6 = r19.getId()     // Catch:{ all -> 0x0374 }
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0374 }
                r2 = 0
                r1.g = r2     // Catch:{ all -> 0x0374 }
                com.oppo.camera.gl.m$j r2 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0374 }
                r2.notifyAll()     // Catch:{ all -> 0x0374 }
            L_0x01a0:
                if (r4 == 0) goto L_0x01ca
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r4.<init>()     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = "sending render notification tid="
                r4.append(r5)     // Catch:{ all -> 0x0374 }
                long r5 = r19.getId()     // Catch:{ all -> 0x0374 }
                r4.append(r5)     // Catch:{ all -> 0x0374 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r2, r4)     // Catch:{ all -> 0x0374 }
                r2 = 0
                r1.p = r2     // Catch:{ all -> 0x0374 }
                r2 = 1
                r1.q = r2     // Catch:{ all -> 0x0374 }
                com.oppo.camera.gl.m$j r2 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0374 }
                r2.notifyAll()     // Catch:{ all -> 0x0374 }
                r4 = 0
            L_0x01ca:
                boolean r2 = r19.l()     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x0363
                boolean r2 = r1.h     // Catch:{ all -> 0x0374 }
                if (r2 != 0) goto L_0x01f2
                if (r0 == 0) goto L_0x01d8
                r0 = 0
                goto L_0x01f2
            L_0x01d8:
                com.oppo.camera.gl.m$h r2 = r1.t     // Catch:{ RuntimeException -> 0x01e9 }
                r2.a()     // Catch:{ RuntimeException -> 0x01e9 }
                r2 = 1
                r1.h = r2     // Catch:{ all -> 0x0374 }
                com.oppo.camera.gl.m$j r2 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0374 }
                r2.notifyAll()     // Catch:{ all -> 0x0374 }
                r11 = 1
                goto L_0x01f2
            L_0x01e9:
                r0 = move-exception
                com.oppo.camera.gl.m$j r2 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0374 }
                r2.b(r1)     // Catch:{ all -> 0x0374 }
                throw r0     // Catch:{ all -> 0x0374 }
            L_0x01f2:
                boolean r2 = r1.h     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x0201
                boolean r2 = r1.i     // Catch:{ all -> 0x0374 }
                if (r2 != 0) goto L_0x0201
                r2 = 1
                r1.i = r2     // Catch:{ all -> 0x0374 }
                r12 = 1
                r13 = 1
                r18 = 1
            L_0x0201:
                boolean r2 = r1.i     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x0363
                boolean r2 = r1.s     // Catch:{ all -> 0x0374 }
                if (r2 == 0) goto L_0x0232
                int r9 = r1.l     // Catch:{ all -> 0x0374 }
                int r10 = r1.m     // Catch:{ all -> 0x0374 }
                r2 = 1
                r1.p = r2     // Catch:{ all -> 0x0374 }
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
                r5.<init>()     // Catch:{ all -> 0x0374 }
                java.lang.String r6 = "noticing that we want render notification tid="
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                long r6 = r19.getId()     // Catch:{ all -> 0x0374 }
                r5.append(r6)     // Catch:{ all -> 0x0374 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0374 }
                android.util.Log.i(r2, r5)     // Catch:{ all -> 0x0374 }
                r2 = 0
                r1.s = r2     // Catch:{ all -> 0x0374 }
                r2 = 0
                r12 = 1
                r18 = 1
                goto L_0x0233
            L_0x0232:
                r2 = 0
            L_0x0233:
                r1.o = r2     // Catch:{ all -> 0x0374 }
                com.oppo.camera.gl.m$j r5 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0374 }
                r5.notifyAll()     // Catch:{ all -> 0x0374 }
                boolean r5 = r1.p     // Catch:{ all -> 0x0374 }
                if (r5 == 0) goto L_0x0245
                r5 = r0
                r6 = r18
                r8 = 1
                goto L_0x0248
            L_0x0245:
                r5 = r0
                r6 = r18
            L_0x0248:
                monitor-exit(r15)     // Catch:{ all -> 0x0374 }
                if (r14 == 0) goto L_0x0253
                r14.run()     // Catch:{ all -> 0x0377 }
                r0 = r2
                r7 = r17
                goto L_0x001d
            L_0x0253:
                if (r12 == 0) goto L_0x0293
                java.lang.String r0 = "GLThread"
                java.lang.String r7 = "egl createSurface"
                android.util.Log.w(r0, r7)     // Catch:{ all -> 0x0377 }
                com.oppo.camera.gl.m$h r0 = r1.t     // Catch:{ all -> 0x0377 }
                boolean r0 = r0.b()     // Catch:{ all -> 0x0377 }
                if (r0 == 0) goto L_0x0279
                com.oppo.camera.gl.m$j r7 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0377 }
                monitor-enter(r7)     // Catch:{ all -> 0x0377 }
                r0 = 1
                r1.j = r0     // Catch:{ all -> 0x0276 }
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0276 }
                r0.notifyAll()     // Catch:{ all -> 0x0276 }
                monitor-exit(r7)     // Catch:{ all -> 0x0276 }
                r12 = r2
                goto L_0x0293
            L_0x0276:
                r0 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0276 }
                throw r0     // Catch:{ all -> 0x0377 }
            L_0x0279:
                com.oppo.camera.gl.m$j r7 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0377 }
                monitor-enter(r7)     // Catch:{ all -> 0x0377 }
                r0 = 1
                r1.j = r0     // Catch:{ all -> 0x0290 }
                r1.f = r0     // Catch:{ all -> 0x0290 }
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0290 }
                r0.notifyAll()     // Catch:{ all -> 0x0290 }
                monitor-exit(r7)     // Catch:{ all -> 0x0290 }
                r0 = r2
                r7 = r17
                goto L_0x001e
            L_0x0290:
                r0 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0290 }
                throw r0     // Catch:{ all -> 0x0377 }
            L_0x0293:
                if (r13 == 0) goto L_0x02a0
                com.oppo.camera.gl.m$h r0 = r1.t     // Catch:{ all -> 0x0377 }
                javax.microedition.khronos.opengles.GL r0 = r0.c()     // Catch:{ all -> 0x0377 }
                javax.microedition.khronos.opengles.GL10 r0 = (javax.microedition.khronos.opengles.GL10) r0     // Catch:{ all -> 0x0377 }
                r7 = r0
                r13 = r2
                goto L_0x02a2
            L_0x02a0:
                r7 = r17
            L_0x02a2:
                if (r11 == 0) goto L_0x02cc
                java.lang.ref.WeakReference<com.oppo.camera.gl.m> r0 = r1.u     // Catch:{ all -> 0x0377 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0377 }
                com.oppo.camera.gl.m r0 = (com.oppo.camera.gl.m) r0     // Catch:{ all -> 0x0377 }
                if (r0 == 0) goto L_0x02cb
                java.lang.String r11 = "onSurfaceCreated"
                com.oppo.camera.e.a((java.lang.String) r11)     // Catch:{ all -> 0x02c4 }
                com.oppo.camera.gl.m$m r0 = r0.e     // Catch:{ all -> 0x02c4 }
                com.oppo.camera.gl.m$h r11 = r1.t     // Catch:{ all -> 0x02c4 }
                javax.microedition.khronos.egl.EGLConfig r11 = r11.d     // Catch:{ all -> 0x02c4 }
                r0.a(r7, r11)     // Catch:{ all -> 0x02c4 }
                java.lang.String r0 = "onSurfaceCreated"
                com.oppo.camera.e.b(r0)     // Catch:{ all -> 0x0377 }
                goto L_0x02cb
            L_0x02c4:
                r0 = move-exception
                java.lang.String r2 = "onSurfaceCreated"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0377 }
                throw r0     // Catch:{ all -> 0x0377 }
            L_0x02cb:
                r11 = r2
            L_0x02cc:
                if (r6 == 0) goto L_0x02f2
                java.lang.ref.WeakReference<com.oppo.camera.gl.m> r0 = r1.u     // Catch:{ all -> 0x0377 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0377 }
                com.oppo.camera.gl.m r0 = (com.oppo.camera.gl.m) r0     // Catch:{ all -> 0x0377 }
                if (r0 == 0) goto L_0x02f1
                java.lang.String r6 = "onSurfaceChanged"
                com.oppo.camera.e.a((java.lang.String) r6)     // Catch:{ all -> 0x02ea }
                com.oppo.camera.gl.m$m r0 = r0.e     // Catch:{ all -> 0x02ea }
                r0.a(r7, r9, r10)     // Catch:{ all -> 0x02ea }
                java.lang.String r0 = "onSurfaceChanged"
                com.oppo.camera.e.b(r0)     // Catch:{ all -> 0x0377 }
                goto L_0x02f1
            L_0x02ea:
                r0 = move-exception
                java.lang.String r2 = "onSurfaceChanged"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0377 }
                throw r0     // Catch:{ all -> 0x0377 }
            L_0x02f1:
                r6 = r2
            L_0x02f2:
                java.lang.ref.WeakReference<com.oppo.camera.gl.m> r0 = r1.u     // Catch:{ all -> 0x0377 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0377 }
                com.oppo.camera.gl.m r0 = (com.oppo.camera.gl.m) r0     // Catch:{ all -> 0x0377 }
                if (r0 == 0) goto L_0x0315
                java.lang.String r15 = "onDrawFrame"
                com.oppo.camera.e.a((java.lang.String) r15)     // Catch:{ all -> 0x030e }
                com.oppo.camera.gl.m$m r0 = r0.e     // Catch:{ all -> 0x030e }
                r0.a(r7)     // Catch:{ all -> 0x030e }
                java.lang.String r0 = "onDrawFrame"
                com.oppo.camera.e.b(r0)     // Catch:{ all -> 0x0377 }
                goto L_0x0315
            L_0x030e:
                r0 = move-exception
                java.lang.String r2 = "onDrawFrame"
                com.oppo.camera.e.b(r2)     // Catch:{ all -> 0x0377 }
                throw r0     // Catch:{ all -> 0x0377 }
            L_0x0315:
                com.oppo.camera.gl.m$h r0 = r1.t     // Catch:{ all -> 0x0377 }
                int r0 = r0.d()     // Catch:{ all -> 0x0377 }
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r0 == r15) goto L_0x035a
                r15 = 12302(0x300e, float:1.7239E-41)
                if (r0 == r15) goto L_0x033e
                java.lang.String r15 = "GLThread"
                java.lang.String r2 = "eglSwapBuffers"
                com.oppo.camera.gl.m.h.a(r15, r2, r0)     // Catch:{ all -> 0x0377 }
                com.oppo.camera.gl.m$j r2 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0377 }
                monitor-enter(r2)     // Catch:{ all -> 0x0377 }
                r0 = 1
                r1.f = r0     // Catch:{ all -> 0x033b }
                com.oppo.camera.gl.m$j r15 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x033b }
                r15.notifyAll()     // Catch:{ all -> 0x033b }
                monitor-exit(r2)     // Catch:{ all -> 0x033b }
                goto L_0x035a
            L_0x033b:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x033b }
                throw r0     // Catch:{ all -> 0x0377 }
            L_0x033e:
                r0 = 1
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0377 }
                r3.<init>()     // Catch:{ all -> 0x0377 }
                java.lang.String r15 = "egl context lost tid="
                r3.append(r15)     // Catch:{ all -> 0x0377 }
                long r0 = r19.getId()     // Catch:{ all -> 0x0377 }
                r3.append(r0)     // Catch:{ all -> 0x0377 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0377 }
                android.util.Log.i(r2, r0)     // Catch:{ all -> 0x0377 }
                r3 = 1
            L_0x035a:
                if (r8 == 0) goto L_0x035e
                r4 = 1
                r8 = 0
            L_0x035e:
                r0 = 0
                r1 = r19
                goto L_0x001e
            L_0x0363:
                r5 = r0
                r6 = r18
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0374 }
                r0.wait()     // Catch:{ all -> 0x0374 }
                r0 = 0
                r1 = r19
                r7 = r17
                goto L_0x0023
            L_0x0374:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0374 }
                throw r0     // Catch:{ all -> 0x0377 }
            L_0x0377:
                r0 = move-exception
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b
                monitor-enter(r1)
                r19.i()     // Catch:{ all -> 0x0385 }
                r19.j()     // Catch:{ all -> 0x0385 }
                monitor-exit(r1)     // Catch:{ all -> 0x0385 }
                throw r0
            L_0x0385:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0385 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.m.i.k():void");
        }

        public boolean a() {
            return this.h && this.i && l();
        }

        private boolean l() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && this.o;
        }

        public void a(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (m.f3293b) {
                this.n = i2;
                m.f3293b.notifyAll();
            }
        }

        public int b() {
            int i2;
            synchronized (m.f3293b) {
                i2 = this.n;
            }
            return i2;
        }

        public void c() {
            synchronized (m.f3293b) {
                this.o = true;
                m.f3293b.notifyAll();
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
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b
                monitor-enter(r0)
                r1 = 1
                r2.e = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.j = r1     // Catch:{ all -> 0x0030 }
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.g     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.j     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.f3303b     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ InterruptedException -> 0x0026 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.m.i.d():void");
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
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b
                monitor-enter(r0)
                r1 = 0
                r2.e = r1     // Catch:{ all -> 0x0029 }
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.g     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.f3303b     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ InterruptedException -> 0x001f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.m.i.e():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:9|10|11|12|13|23|19|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0029, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0040 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f() {
            /*
                r5 = this;
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b
                monitor-enter(r0)
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
                r2.<init>()     // Catch:{ all -> 0x004a }
                java.lang.String r3 = "onPause tid="
                r2.append(r3)     // Catch:{ all -> 0x004a }
                long r3 = r5.getId()     // Catch:{ all -> 0x004a }
                r2.append(r3)     // Catch:{ all -> 0x004a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004a }
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x004a }
                r1 = 1
                r5.c = r1     // Catch:{ all -> 0x004a }
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x004a }
                r1.notifyAll()     // Catch:{ all -> 0x004a }
            L_0x0029:
                boolean r1 = r5.f3303b     // Catch:{ all -> 0x004a }
                if (r1 != 0) goto L_0x0048
                boolean r1 = r5.d     // Catch:{ all -> 0x004a }
                if (r1 != 0) goto L_0x0048
                java.lang.String r1 = "Main thread"
                java.lang.String r2 = "onPause waiting for mPaused."
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x004a }
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ InterruptedException -> 0x0040 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0040 }
                goto L_0x0029
            L_0x0040:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x004a }
                r1.interrupt()     // Catch:{ all -> 0x004a }
                goto L_0x0029
            L_0x0048:
                monitor-exit(r0)     // Catch:{ all -> 0x004a }
                return
            L_0x004a:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.m.i.f():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|13|14|15|26|21|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x002e, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0049 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r5 = this;
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b
                monitor-enter(r0)
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
                r2.<init>()     // Catch:{ all -> 0x0053 }
                java.lang.String r3 = "onResume tid="
                r2.append(r3)     // Catch:{ all -> 0x0053 }
                long r3 = r5.getId()     // Catch:{ all -> 0x0053 }
                r2.append(r3)     // Catch:{ all -> 0x0053 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0053 }
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0053 }
                r1 = 0
                r5.c = r1     // Catch:{ all -> 0x0053 }
                r2 = 1
                r5.o = r2     // Catch:{ all -> 0x0053 }
                r5.q = r1     // Catch:{ all -> 0x0053 }
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0053 }
                r1.notifyAll()     // Catch:{ all -> 0x0053 }
            L_0x002e:
                boolean r1 = r5.f3303b     // Catch:{ all -> 0x0053 }
                if (r1 != 0) goto L_0x0051
                boolean r1 = r5.d     // Catch:{ all -> 0x0053 }
                if (r1 == 0) goto L_0x0051
                boolean r1 = r5.q     // Catch:{ all -> 0x0053 }
                if (r1 != 0) goto L_0x0051
                java.lang.String r1 = "Main thread"
                java.lang.String r2 = "onResume waiting for !mPaused."
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0053 }
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ InterruptedException -> 0x0049 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0049 }
                goto L_0x002e
            L_0x0049:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0053 }
                r1.interrupt()     // Catch:{ all -> 0x0053 }
                goto L_0x002e
            L_0x0051:
                monitor-exit(r0)     // Catch:{ all -> 0x0053 }
                return
            L_0x0053:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0053 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.m.i.g():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:16|17|18|19|20|32|26|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0020, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r4, int r5) {
            /*
                r3 = this;
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b
                monitor-enter(r0)
                r3.l = r4     // Catch:{ all -> 0x005e }
                r3.m = r5     // Catch:{ all -> 0x005e }
                r4 = 1
                r3.s = r4     // Catch:{ all -> 0x005e }
                r3.o = r4     // Catch:{ all -> 0x005e }
                r4 = 0
                r3.q = r4     // Catch:{ all -> 0x005e }
                java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x005e }
                if (r4 != r3) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x005e }
                return
            L_0x0019:
                com.oppo.camera.gl.m$j r4 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x005e }
                r4.notifyAll()     // Catch:{ all -> 0x005e }
            L_0x0020:
                boolean r4 = r3.f3303b     // Catch:{ all -> 0x005e }
                if (r4 != 0) goto L_0x005c
                boolean r4 = r3.d     // Catch:{ all -> 0x005e }
                if (r4 != 0) goto L_0x005c
                boolean r4 = r3.q     // Catch:{ all -> 0x005e }
                if (r4 != 0) goto L_0x005c
                boolean r4 = r3.a()     // Catch:{ all -> 0x005e }
                if (r4 == 0) goto L_0x005c
                java.lang.String r4 = "Main thread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
                r5.<init>()     // Catch:{ all -> 0x005e }
                java.lang.String r1 = "onWindowResize waiting for render complete from tid="
                r5.append(r1)     // Catch:{ all -> 0x005e }
                long r1 = r3.getId()     // Catch:{ all -> 0x005e }
                r5.append(r1)     // Catch:{ all -> 0x005e }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x005e }
                android.util.Log.i(r4, r5)     // Catch:{ all -> 0x005e }
                com.oppo.camera.gl.m$j r4 = com.oppo.camera.gl.m.f3293b     // Catch:{ InterruptedException -> 0x0054 }
                r4.wait()     // Catch:{ InterruptedException -> 0x0054 }
                goto L_0x0020
            L_0x0054:
                java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x005e }
                r4.interrupt()     // Catch:{ all -> 0x005e }
                goto L_0x0020
            L_0x005c:
                monitor-exit(r0)     // Catch:{ all -> 0x005e }
                return
            L_0x005e:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x005e }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.m.i.a(int, int):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h() {
            /*
                r2 = this;
                com.oppo.camera.gl.m$j r0 = com.oppo.camera.gl.m.f3293b
                monitor-enter(r0)
                r1 = 1
                r2.f3302a = r1     // Catch:{ all -> 0x0025 }
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.f3303b     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.oppo.camera.gl.m$j r1 = com.oppo.camera.gl.m.f3293b     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.m.i.h():void");
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (m.f3293b) {
                    this.r.add(runnable);
                    m.f3293b.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* compiled from: GLProducer */
    static class l extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f3305a = new StringBuilder();

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
                    this.f3305a.append(c);
                }
            }
        }

        private void a() {
            if (this.f3305a.length() > 0) {
                Log.v("GLSurfaceView", this.f3305a.toString());
                StringBuilder sb = this.f3305a;
                sb.delete(0, sb.length());
            }
        }
    }

    private void i() {
        if (this.d != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* compiled from: GLProducer */
    private static class j {

        /* renamed from: a  reason: collision with root package name */
        private static String f3304a = "GLThreadManager";

        private j() {
        }

        public synchronized void a(i iVar) {
            boolean unused = iVar.f3303b = true;
            notifyAll();
        }

        public void b(i iVar) {
            notifyAll();
        }
    }
}
