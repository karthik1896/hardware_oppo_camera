package androidx.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f87a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f88b = Executors.newFixedThreadPool(4, new ThreadFactory() {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f90b = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f90b.getAndIncrement())}));
            return thread;
        }
    });
    private volatile Handler c;

    public void a(Runnable runnable) {
        this.f88b.execute(runnable);
    }

    public void b(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.f87a) {
                if (this.c == null) {
                    this.c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
