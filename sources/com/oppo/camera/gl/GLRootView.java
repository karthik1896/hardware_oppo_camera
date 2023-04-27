package com.oppo.camera.gl;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.oppo.camera.e;
import com.oppo.camera.gl.n;
import com.oppo.camera.gl.q;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class GLRootView extends q implements n, q.m, r {

    /* renamed from: a  reason: collision with root package name */
    private final e f3249a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<f> f3250b;
    /* access modifiers changed from: private */
    public final ArrayDeque<n.a> c;
    private final IdleRunner d;
    /* access modifiers changed from: private */
    public final ReentrantLock e;
    private final Condition f;
    private int g;
    private long h;
    private int i;
    private GL11 j;
    /* access modifiers changed from: private */
    public h k;
    private GLView l;
    private int m;
    private Matrix n;
    private int o;
    private int p;
    /* access modifiers changed from: private */
    public volatile boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private GLRootViewListener x;
    private boolean y;

    public interface GLRootViewListener {
        void onSurfaceChanged();

        void onSurfaceCreated();
    }

    public GLRootView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GLRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3249a = new e();
        this.f3250b = new ArrayList<>();
        this.c = new ArrayDeque<>();
        this.d = new IdleRunner();
        this.e = new ReentrantLock();
        this.f = this.e.newCondition();
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.n = new Matrix();
        this.p = 2;
        this.q = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = false;
        setEGLContextClientVersion(2);
        this.p |= 1;
        setBackgroundDrawable((Drawable) null);
        setEGLConfigChooser((q.e) this.f3249a);
        setRenderer(this);
        setOutputRender(this);
        getHolder().setFormat(3);
    }

    public void setGLRootViewListener(GLRootViewListener gLRootViewListener) {
        this.x = gLRootViewListener;
    }

    public synchronized boolean getSurfaceState() {
        return this.y;
    }

    public void setContentPane(GLView gLView) {
        GLView gLView2 = this.l;
        if (gLView2 != gLView) {
            if (gLView2 != null) {
                if (this.s) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.l.b(obtain);
                    obtain.recycle();
                    this.s = false;
                }
                this.l.b();
                c.a();
            }
            this.l = gLView;
            if (gLView != null) {
                gLView.a((n) this);
                b();
            }
        }
    }

    public void a() {
        if (this.u) {
            Log.i("GLRootView", "requestRender, Activity.finish(), so return");
        } else if (!this.q) {
            this.q = true;
            super.a();
        }
    }

    public void b() {
        Log.v("GLRootView", "requestLayoutContentPane, mRenderLock.lock()");
        this.e.lock();
        try {
            if (this.l != null) {
                if ((this.p & 2) == 0) {
                    if ((this.p & 1) != 0) {
                        this.p |= 2;
                        a();
                        this.e.unlock();
                        Log.v("GLRootView", "requestLayoutContentPane, mRenderLock.unlock()");
                    }
                }
            }
        } finally {
            this.e.unlock();
            Log.v("GLRootView", "requestLayoutContentPane, mRenderLock.unlock()");
        }
    }

    private void l() {
        this.p &= -3;
        int width = getWidth();
        int height = getHeight();
        if (!(this.m == 0 && width == this.v && height == this.w)) {
            this.m = 0;
            int i2 = this.m;
            if (i2 % 180 != 0) {
                this.n.setRotate((float) i2);
                this.n.preTranslate((float) ((-width) / 2), (float) ((-height) / 2));
                this.n.postTranslate((float) (height / 2), (float) (width / 2));
            } else {
                this.n.setRotate((float) i2, (float) (width / 2), (float) (height / 2));
            }
            this.o = 0;
            this.v = width;
            this.w = height;
        }
        if (this.m % 180 != 0) {
            int i3 = height;
            height = width;
            width = i3;
        }
        Log.i("GLRootView", "layoutContentPane, size: " + width + "x" + height + ", compensation: " + this.m);
        GLView gLView = this.l;
        if (gLView != null && width != 0 && height != 0) {
            gLView.a(0, 0, width, height);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            b();
        }
    }

    /* JADX INFO: finally extract failed */
    public void a(GL10 gl10, EGLConfig eGLConfig) {
        Log.i("GLRootView", "onSurfaceCreated(GL10 gl1, EGLConfig config)");
        GL11 gl11 = (GL11) gl10;
        if (this.j != null) {
            Log.i("GLRootView", "GLObject has changed from " + this.j + " to " + gl11);
        }
        this.e.lock();
        try {
            this.j = gl11;
            this.k = new i();
            c.b();
            this.e.unlock();
            setRenderMode(0);
            GLRootViewListener gLRootViewListener = this.x;
            if (gLRootViewListener != null) {
                gLRootViewListener.onSurfaceCreated();
            }
            GLView gLView = this.l;
            if (gLView != null) {
                gLView.f();
            }
            this.y = true;
            this.u = false;
            Log.v("GLRootView", "onSurfaceCreated mFinsh = false");
        } catch (Throwable th) {
            this.e.unlock();
            throw th;
        }
    }

    public void a(GL10 gl10, int i2, int i3) {
        Log.i("GLRootView", "onSurfaceChanged: " + i2 + "x" + i3 + ", gl10: " + gl10.toString() + ", mGLRootViewListener:" + this.x);
        Process.setThreadPriority(-4);
        w.a(this.j == ((GL11) gl10));
        this.k.a(i2, i3);
        GLRootViewListener gLRootViewListener = this.x;
        if (gLRootViewListener != null) {
            gLRootViewListener.onSurfaceChanged();
        }
        GLView gLView = this.l;
        if (gLView != null) {
            gLView.a(i2, i3);
        }
        this.y = true;
    }

    private void m() {
        long nanoTime = System.nanoTime();
        long j2 = this.h;
        if (j2 == 0) {
            this.h = nanoTime;
        } else if (nanoTime - j2 > 1000000000) {
            Log.w("GLRootView", "outputFps, fps: " + ((((double) this.g) * 1.0E9d) / ((double) (nanoTime - this.h))));
            this.h = nanoTime;
            this.g = 0;
        }
        this.g++;
    }

    public void a(GL10 gl10) {
        GLView gLView = this.l;
        if (gLView != null) {
            gLView.b(this.k);
        }
    }

    /* JADX INFO: finally extract failed */
    public void b(GL10 gl10) {
        b.a();
        this.e.lock();
        while (this.r) {
            this.f.awaitUninterruptibly();
        }
        try {
            c(gl10);
            this.e.unlock();
            if (this.t) {
                this.t = false;
            }
        } catch (Throwable th) {
            this.e.unlock();
            throw th;
        }
    }

    private void c(GL10 gl10) {
        m();
        this.k.g();
        v.o();
        this.q = false;
        if ((this.p & 2) != 0) {
            l();
        }
        this.k.a(-1);
        a(-this.m);
        GLView gLView = this.l;
        if (gLView != null) {
            gLView.a(this.k);
        }
        this.k.f();
        if (!this.f3250b.isEmpty()) {
            long b2 = b.b();
            int size = this.f3250b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3250b.get(i2).a(b2);
            }
            this.f3250b.clear();
        }
        if (v.p()) {
            a();
        }
        synchronized (this.c) {
            if (!this.c.isEmpty()) {
                this.d.enable();
            }
        }
    }

    private void a(int i2) {
        if (i2 != 0) {
            int width = getWidth() / 2;
            int height = getHeight() / 2;
            this.k.a((float) width, (float) height);
            this.k.a((float) i2, 0.0f, 0.0f, 1.0f);
            if (i2 % 180 != 0) {
                this.k.a((float) (-height), (float) (-width));
            } else {
                this.k.a((float) (-width), (float) (-height));
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.s = false;
        } else if (!this.s && action != 0) {
            return false;
        }
        if (this.m != 0) {
            motionEvent.transform(this.n);
        }
        this.e.lock();
        try {
            if (this.l != null && this.l.b(motionEvent)) {
                z = true;
            }
            if (action == 0 && z) {
                this.s = true;
            }
            return z;
        } finally {
            this.e.unlock();
        }
    }

    public void c() {
        super.c();
        this.u = false;
        Log.v("GLRootView", "onResume mFinsh = false");
    }

    public void d() {
        e();
        super.d();
        this.y = false;
        this.x = null;
    }

    public int getDisplayRotation() {
        return this.o;
    }

    public int getCompensation() {
        return this.m;
    }

    public Matrix getCompensationMatrix() {
        return this.n;
    }

    public void e() {
        Log.v("GLRootView", "unfreeze");
        this.e.lock();
        this.r = false;
        this.f.signalAll();
        this.e.unlock();
    }

    public void setLightsOutMode(boolean z) {
        setSystemUiVisibility(z ? 261 : 0);
    }

    public void f() {
        this.u = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        e();
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
        e.a("GLRootView", "surfaceChanged, w: " + i3 + ", h: " + i4);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        e();
        super.surfaceCreated(surfaceHolder);
        e.a("GLRootView", "surfaceCreated");
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        e();
        super.surfaceDestroyed(surfaceHolder);
        e.a("GLRootView", "surfaceDestroyed");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            e();
        } finally {
            super.finalize();
        }
    }

    private class IdleRunner implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3252b;

        private IdleRunner() {
            this.f3252b = false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
            android.util.Log.v("GLRootView", "IdleRunner run, mRenderLock.lock()");
            com.oppo.camera.gl.GLRootView.b(r3.f3251a).lock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            if (r1.a(com.oppo.camera.gl.GLRootView.c(r3.f3251a), com.oppo.camera.gl.GLRootView.d(r3.f3251a)) != false) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
            com.oppo.camera.gl.GLRootView.b(r3.f3251a).unlock();
            android.util.Log.v("GLRootView", "IdleRunner run, mRenderLock.unlock()");
            r0 = com.oppo.camera.gl.GLRootView.a(r3.f3251a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x006e, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            com.oppo.camera.gl.GLRootView.a(r3.f3251a).addLast(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007e, code lost:
            if (com.oppo.camera.gl.GLRootView.d(r3.f3251a) != false) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
            enable();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0083, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0088, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
            com.oppo.camera.gl.GLRootView.b(r3.f3251a).unlock();
            r1 = "GLRootView";
            r2 = "IdleRunner run, mRenderLock.unlock()";
            android.util.Log.v(r1, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                com.oppo.camera.gl.GLRootView r0 = com.oppo.camera.gl.GLRootView.this
                java.util.ArrayDeque r0 = r0.c
                monitor-enter(r0)
                r1 = 0
                r3.f3252b = r1     // Catch:{ all -> 0x009a }
                com.oppo.camera.gl.GLRootView r1 = com.oppo.camera.gl.GLRootView.this     // Catch:{ all -> 0x009a }
                java.util.ArrayDeque r1 = r1.c     // Catch:{ all -> 0x009a }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x009a }
                if (r1 == 0) goto L_0x0018
                monitor-exit(r0)     // Catch:{ all -> 0x009a }
                return
            L_0x0018:
                com.oppo.camera.gl.GLRootView r1 = com.oppo.camera.gl.GLRootView.this     // Catch:{ all -> 0x009a }
                java.util.ArrayDeque r1 = r1.c     // Catch:{ all -> 0x009a }
                java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x009a }
                com.oppo.camera.gl.n$a r1 = (com.oppo.camera.gl.n.a) r1     // Catch:{ all -> 0x009a }
                monitor-exit(r0)     // Catch:{ all -> 0x009a }
                java.lang.String r0 = "GLRootView"
                java.lang.String r2 = "IdleRunner run, mRenderLock.lock()"
                android.util.Log.v(r0, r2)
                com.oppo.camera.gl.GLRootView r0 = com.oppo.camera.gl.GLRootView.this
                java.util.concurrent.locks.ReentrantLock r0 = r0.e
                r0.lock()
                com.oppo.camera.gl.GLRootView r0 = com.oppo.camera.gl.GLRootView.this     // Catch:{ all -> 0x0088 }
                com.oppo.camera.gl.h r0 = r0.k     // Catch:{ all -> 0x0088 }
                com.oppo.camera.gl.GLRootView r2 = com.oppo.camera.gl.GLRootView.this     // Catch:{ all -> 0x0088 }
                boolean r2 = r2.q     // Catch:{ all -> 0x0088 }
                boolean r0 = r1.a(r0, r2)     // Catch:{ all -> 0x0088 }
                if (r0 != 0) goto L_0x0058
                com.oppo.camera.gl.GLRootView r0 = com.oppo.camera.gl.GLRootView.this
                java.util.concurrent.locks.ReentrantLock r0 = r0.e
                r0.unlock()
                java.lang.String r0 = "GLRootView"
                java.lang.String r1 = "IdleRunner run, mRenderLock.unlock()"
                android.util.Log.v(r0, r1)
                return
            L_0x0058:
                com.oppo.camera.gl.GLRootView r0 = com.oppo.camera.gl.GLRootView.this
                java.util.concurrent.locks.ReentrantLock r0 = r0.e
                r0.unlock()
                java.lang.String r0 = "GLRootView"
                java.lang.String r2 = "IdleRunner run, mRenderLock.unlock()"
                android.util.Log.v(r0, r2)
                com.oppo.camera.gl.GLRootView r0 = com.oppo.camera.gl.GLRootView.this
                java.util.ArrayDeque r0 = r0.c
                monitor-enter(r0)
                com.oppo.camera.gl.GLRootView r2 = com.oppo.camera.gl.GLRootView.this     // Catch:{ all -> 0x0085 }
                java.util.ArrayDeque r2 = r2.c     // Catch:{ all -> 0x0085 }
                r2.addLast(r1)     // Catch:{ all -> 0x0085 }
                com.oppo.camera.gl.GLRootView r1 = com.oppo.camera.gl.GLRootView.this     // Catch:{ all -> 0x0085 }
                boolean r1 = r1.q     // Catch:{ all -> 0x0085 }
                if (r1 != 0) goto L_0x0083
                r3.enable()     // Catch:{ all -> 0x0085 }
            L_0x0083:
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x0085:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                throw r1
            L_0x0088:
                r0 = move-exception
                com.oppo.camera.gl.GLRootView r1 = com.oppo.camera.gl.GLRootView.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.e
                r1.unlock()
                java.lang.String r1 = "GLRootView"
                java.lang.String r2 = "IdleRunner run, mRenderLock.unlock()"
                android.util.Log.v(r1, r2)
                throw r0
            L_0x009a:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x009a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.GLRootView.IdleRunner.run():void");
        }

        public void enable() {
            if (!this.f3252b) {
                this.f3252b = true;
                GLRootView.this.a((Runnable) this);
            }
        }
    }
}
