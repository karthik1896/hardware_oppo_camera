package com.oppo.camera.v;

import com.oppo.camera.e;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CameraThreadExector */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4634a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b  reason: collision with root package name */
    private static final int f4635b = Math.max(2, Math.min(f4634a - 1, 4));
    private static final int c = ((f4634a * 2) + 1);
    private static volatile c f;
    private a d = new a();
    private final ThreadPoolExecutor e = new ThreadPoolExecutor(f4635b, c, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), this.d);

    public static c a() {
        if (f == null) {
            synchronized (c.class) {
                if (f == null) {
                    f = new c();
                }
            }
        }
        return f;
    }

    private c() {
        this.e.allowCoreThreadTimeOut(true);
    }

    public void a(Runnable runnable, String str) {
        this.d.a(str);
        this.e.execute(runnable);
    }

    public void b() {
        this.e.shutdown();
    }

    /* compiled from: CameraThreadExector */
    private class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        String f4636a;

        private a() {
            this.f4636a = null;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            e.a("CameraThreadExector", "thread name: " + str);
            this.f4636a = str;
        }

        public Thread newThread(Runnable runnable) {
            if (this.f4636a == null) {
                e.e("CameraThreadExector", "thread name is null");
                this.f4636a = "CameraThreadExector";
            }
            Thread thread = new Thread(runnable, this.f4636a);
            thread.setPriority(5);
            return thread;
        }
    }
}
