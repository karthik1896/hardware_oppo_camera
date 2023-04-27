package com.heytap.epona;

import com.heytap.epona.internal.d;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Route */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f2600a = 64;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f2601b = a();
    private ArrayDeque<d.a> c = new ArrayDeque<>();
    private ArrayDeque<d.a> d = new ArrayDeque<>();

    public void a(d dVar) {
    }

    public void b(d dVar) {
    }

    /* access modifiers changed from: package-private */
    public d a(Request request) {
        return d.a(this, request);
    }

    public synchronized void a(d.a aVar) {
        if (this.d.size() < 64) {
            this.d.add(aVar);
            this.f2601b.execute(aVar);
        } else {
            this.c.add(aVar);
        }
    }

    public void a(d.a aVar, boolean z) {
        synchronized (this) {
            this.d.remove(aVar);
            if (!z) {
                this.c.add(aVar);
            }
        }
        b();
    }

    private synchronized ExecutorService a() {
        if (this.f2601b == null) {
            this.f2601b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), a("Epona Route", (Boolean) false));
        }
        return this.f2601b;
    }

    private ThreadFactory a(String str, Boolean bool) {
        return new ThreadFactory(str, bool) {
            private final /* synthetic */ String f$0;
            private final /* synthetic */ Boolean f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Thread newThread(Runnable runnable) {
                return i.a(this.f$0, this.f$1, runnable);
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread a(String str, Boolean bool, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(bool.booleanValue());
        return thread;
    }

    private synchronized void b() {
        if (this.d.size() < 64) {
            if (!this.c.isEmpty()) {
                Iterator<d.a> it = this.c.iterator();
                while (it.hasNext()) {
                    d.a next = it.next();
                    this.d.add(next);
                    this.f2601b.execute(next);
                    this.c.remove(next);
                    if (this.d.size() >= 64) {
                        return;
                    }
                }
            }
        }
    }
}
