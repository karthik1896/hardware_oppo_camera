package a.a.b.d;

import a.a.b.b.g;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.TextureView;
import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class d extends Thread implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    public Object f35a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f36b;
    public a c;
    public boolean d;
    public boolean e = true;
    public g f;
    public Queue<Runnable> g = new LinkedBlockingQueue();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f37a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f38b;

        public a(int i, int i2) {
            this.f37a = i;
            this.f38b = i2;
        }

        public void run() {
            d.this.f.onSurfaceCreated((GL10) null, (EGLConfig) null);
            d.this.f.onSurfaceChanged((GL10) null, this.f37a, this.f38b);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f39a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f40b;

        public b(int i, int i2) {
            this.f39a = i;
            this.f40b = i2;
        }

        public void run() {
            d.this.f.onSurfaceChanged((GL10) null, this.f39a, this.f40b);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            d.this.f.l();
        }
    }

    public d() {
        super("PPE TextureViewGL Renderer");
    }

    public final void a() {
        Vector vector = new Vector();
        while (true) {
            Runnable poll = this.g.poll();
            if (poll == null) {
                break;
            }
            vector.add(poll);
        }
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public void a(g gVar) {
        this.f = gVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r6.f.m() != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r7.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        a();
        r4 = ((long) (1000 / a.a.b.b.g.c)) - (java.lang.System.currentTimeMillis() - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r4 <= 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        java.lang.Thread.sleep(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        r0 = java.lang.System.currentTimeMillis();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a.a.b.d.c r7) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.Object r0 = r6.f35a
            monitor-enter(r0)
            android.graphics.SurfaceTexture r1 = r6.f36b     // Catch:{ all -> 0x003e }
            if (r1 != 0) goto L_0x0010
            java.lang.String r7 = "RenderThread"
            java.lang.String r1 = "doAnimation exiting"
            android.util.Log.d(r7, r1)     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            long r0 = java.lang.System.currentTimeMillis()
            a.a.b.b.g r2 = r6.f
            boolean r2 = r2.m()
            if (r2 != 0) goto L_0x0020
            r7.c()
        L_0x0020:
            r6.a()
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, float:1.401E-42)
            int r5 = a.a.b.b.g.c
            int r4 = r4 / r5
            long r4 = (long) r4
            long r2 = r2 - r0
            long r4 = r4 - r2
            r0 = 0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0000
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x0039 }
            goto L_0x0000
        L_0x0039:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0000
        L_0x003e:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.d.d.a(a.a.b.d.c):void");
    }

    public void a(Runnable runnable) {
        this.g.add(runnable);
    }

    public void b() {
        synchronized (this.f35a) {
            this.d = true;
            this.f35a.notify();
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d("RenderThread", "onSurfaceTextureAvailable(" + i + "x" + i2 + ")");
        synchronized (this.f35a) {
            this.f36b = surfaceTexture;
            this.f35a.notify();
        }
        a((Runnable) new a(i, i2));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.d("RenderThread", "onSurfaceTextureDestroyed");
        synchronized (this.f35a) {
            this.f36b = null;
        }
        a((Runnable) new c());
        if (this.e) {
            Log.i("RenderThread", "Allowing TextureView to release SurfaceTexture");
        }
        return this.e;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d("RenderThread", "onSurfaceTextureSizeChanged(" + i + "x" + i2 + ")");
        a((Runnable) new b(i, i2));
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        android.util.Log.d("RenderThread", "Got surfaceTexture=" + r2);
        r4.c = new a.a.b.d.a((android.opengl.EGLContext) null, 2);
        r0 = new a.a.b.d.c(r4.c, r4.f36b);
        r0.a();
        a(r0);
        r0.d();
        r4.c.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        if (r4.e != false) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        android.util.Log.i("RenderThread", "Releasing SurfaceTexture in renderer thread");
        r2.release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
        L_0x0000:
            java.lang.Object r0 = r4.f35a
            monitor-enter(r0)
            r1 = 0
            r2 = r1
        L_0x0005:
            boolean r3 = r4.d     // Catch:{ all -> 0x006c }
            if (r3 != 0) goto L_0x001a
            android.graphics.SurfaceTexture r2 = r4.f36b     // Catch:{ all -> 0x006c }
            if (r2 != 0) goto L_0x001a
            java.lang.Object r3 = r4.f35a     // Catch:{ InterruptedException -> 0x0013 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0013 }
            goto L_0x0005
        L_0x0013:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x006c }
            r2.<init>(r1)     // Catch:{ all -> 0x006c }
            throw r2     // Catch:{ all -> 0x006c }
        L_0x001a:
            boolean r3 = r4.d     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0027
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            java.lang.String r0 = "RenderThread"
            java.lang.String r1 = "Renderer thread exiting"
            android.util.Log.d(r0, r1)
            return
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Got surfaceTexture="
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "RenderThread"
            android.util.Log.d(r3, r0)
            a.a.b.d.a r0 = new a.a.b.d.a
            r3 = 2
            r0.<init>(r1, r3)
            r4.c = r0
            a.a.b.d.c r0 = new a.a.b.d.c
            a.a.b.d.a r1 = r4.c
            android.graphics.SurfaceTexture r3 = r4.f36b
            r0.<init>(r1, r3)
            r0.a()
            r4.a((a.a.b.d.c) r0)
            r0.d()
            a.a.b.d.a r0 = r4.c
            r0.a()
            boolean r0 = r4.e
            if (r0 != 0) goto L_0x0000
            java.lang.String r0 = "RenderThread"
            java.lang.String r1 = "Releasing SurfaceTexture in renderer thread"
            android.util.Log.i(r0, r1)
            r2.release()
            goto L_0x0000
        L_0x006c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.d.d.run():void");
    }

    public void start() {
        synchronized (this) {
            super.start();
        }
    }
}
