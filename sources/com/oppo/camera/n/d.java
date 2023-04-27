package com.oppo.camera.n;

import android.os.Process;
import com.oppo.camera.e;
import com.oppo.camera.z;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ProcessQueueThread */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected ExecutorService f3450a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f3451b = 0;
    private int c = 0;
    private volatile int d = 0;
    private boolean e = false;
    /* access modifiers changed from: private */
    public a f = null;

    /* compiled from: ProcessQueueThread */
    public interface a {
        void a();
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public abstract void b(z.a aVar) throws Exception;

    static /* synthetic */ int a(d dVar) {
        int i = dVar.c;
        dVar.c = i - 1;
        return i;
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.f3451b;
        dVar.f3451b = i - 1;
        return i;
    }

    public void a(a aVar) {
        synchronized (this) {
            this.f = aVar;
        }
    }

    public void d() {
        b();
        if (this.f3450a == null) {
            this.f3450a = Executors.newSingleThreadExecutor();
        }
    }

    public int e() {
        int i;
        e.a("ProcessQueueThread", "getSaveListRawCount");
        synchronized (this) {
            i = this.f3451b;
        }
        return i;
    }

    public synchronized boolean f() {
        return this.c > 50;
    }

    public synchronized boolean g() {
        return this.c == 0;
    }

    public synchronized void h() {
        this.d++;
        e.a("ProcessQueueThread", "afterAddFrame, mCaptureSize: " + this.d);
    }

    public synchronized void i() {
        this.d--;
        e.a("ProcessQueueThread", "onPicReceiveFromAPS, mCaptureSize: " + this.d);
    }

    public synchronized boolean j() {
        e.a("ProcessQueueThread", "imageCaptureListIsEmpty, mCaptureSize: " + this.d);
        return this.d == 0;
    }

    public final void c(final z.a aVar) {
        e.a("ProcessQueueThread", "pictureArrive, width: " + aVar.q + ", height: " + aVar.r + ", orientation: " + aVar.v);
        synchronized (this) {
            this.c++;
            if ("raw".equals(aVar.j)) {
                this.f3451b++;
            }
        }
        this.f3450a.submit(new Runnable() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.oppo.camera.n.d r0 = com.oppo.camera.n.d.this     // Catch:{ Exception -> 0x003d }
                    com.oppo.camera.z$a r1 = r3     // Catch:{ Exception -> 0x003d }
                    r0.b((com.oppo.camera.z.a) r1)     // Catch:{ Exception -> 0x003d }
                    com.oppo.camera.n.d r0 = com.oppo.camera.n.d.this
                    monitor-enter(r0)
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0038 }
                    com.oppo.camera.n.d.a((com.oppo.camera.n.d) r1)     // Catch:{ all -> 0x0038 }
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0038 }
                    com.oppo.camera.n.d$a r1 = r1.f     // Catch:{ all -> 0x0038 }
                    if (r1 == 0) goto L_0x0020
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0038 }
                    com.oppo.camera.n.d$a r1 = r1.f     // Catch:{ all -> 0x0038 }
                    r1.a()     // Catch:{ all -> 0x0038 }
                L_0x0020:
                    java.lang.String r1 = "raw"
                    com.oppo.camera.z$a r2 = r3     // Catch:{ all -> 0x0038 }
                    java.lang.String r2 = r2.j     // Catch:{ all -> 0x0038 }
                    boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0038 }
                    if (r1 == 0) goto L_0x0031
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0038 }
                    com.oppo.camera.n.d.c((com.oppo.camera.n.d) r1)     // Catch:{ all -> 0x0038 }
                L_0x0031:
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0038 }
                    r1.a()     // Catch:{ all -> 0x0038 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0038 }
                    goto L_0x0071
                L_0x0038:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0038 }
                    throw r1
                L_0x003b:
                    r0 = move-exception
                    goto L_0x0075
                L_0x003d:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x003b }
                    com.oppo.camera.n.d r0 = com.oppo.camera.n.d.this
                    monitor-enter(r0)
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0072 }
                    com.oppo.camera.n.d.a((com.oppo.camera.n.d) r1)     // Catch:{ all -> 0x0072 }
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0072 }
                    com.oppo.camera.n.d$a r1 = r1.f     // Catch:{ all -> 0x0072 }
                    if (r1 == 0) goto L_0x005a
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0072 }
                    com.oppo.camera.n.d$a r1 = r1.f     // Catch:{ all -> 0x0072 }
                    r1.a()     // Catch:{ all -> 0x0072 }
                L_0x005a:
                    java.lang.String r1 = "raw"
                    com.oppo.camera.z$a r2 = r3     // Catch:{ all -> 0x0072 }
                    java.lang.String r2 = r2.j     // Catch:{ all -> 0x0072 }
                    boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0072 }
                    if (r1 == 0) goto L_0x006b
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0072 }
                    com.oppo.camera.n.d.c((com.oppo.camera.n.d) r1)     // Catch:{ all -> 0x0072 }
                L_0x006b:
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x0072 }
                    r1.a()     // Catch:{ all -> 0x0072 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0072 }
                L_0x0071:
                    return
                L_0x0072:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0072 }
                    throw r1
                L_0x0075:
                    com.oppo.camera.n.d r1 = com.oppo.camera.n.d.this
                    monitor-enter(r1)
                    com.oppo.camera.n.d r2 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x00a6 }
                    com.oppo.camera.n.d.a((com.oppo.camera.n.d) r2)     // Catch:{ all -> 0x00a6 }
                    com.oppo.camera.n.d r2 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x00a6 }
                    com.oppo.camera.n.d$a r2 = r2.f     // Catch:{ all -> 0x00a6 }
                    if (r2 == 0) goto L_0x008e
                    com.oppo.camera.n.d r2 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x00a6 }
                    com.oppo.camera.n.d$a r2 = r2.f     // Catch:{ all -> 0x00a6 }
                    r2.a()     // Catch:{ all -> 0x00a6 }
                L_0x008e:
                    java.lang.String r2 = "raw"
                    com.oppo.camera.z$a r3 = r3     // Catch:{ all -> 0x00a6 }
                    java.lang.String r3 = r3.j     // Catch:{ all -> 0x00a6 }
                    boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00a6 }
                    if (r2 == 0) goto L_0x009f
                    com.oppo.camera.n.d r2 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x00a6 }
                    com.oppo.camera.n.d.c((com.oppo.camera.n.d) r2)     // Catch:{ all -> 0x00a6 }
                L_0x009f:
                    com.oppo.camera.n.d r2 = com.oppo.camera.n.d.this     // Catch:{ all -> 0x00a6 }
                    r2.a()     // Catch:{ all -> 0x00a6 }
                    monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                    throw r0
                L_0x00a6:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.n.d.AnonymousClass1.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.e && g()) {
            e.e("ProcessQueueThread", "checkAndKillProcess will kill camera process");
            Process.killProcess(Process.myPid());
        }
    }
}
