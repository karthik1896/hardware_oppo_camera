package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.f.d;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask */
public class m<T> {

    /* renamed from: a  reason: collision with root package name */
    public static Executor f1841a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private final Set<h<T>> f1842b;
    private final Set<h<Throwable>> c;
    private final Handler d;
    /* access modifiers changed from: private */
    public volatile l<T> e;

    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    m(Callable<l<T>> callable, boolean z) {
        this.f1842b = new LinkedHashSet(1);
        this.c = new LinkedHashSet(1);
        this.d = new Handler(Looper.getMainLooper());
        this.e = null;
        if (z) {
            try {
                a(callable.call());
            } catch (Throwable th) {
                a(new l(th));
            }
        } else {
            f1841a.execute(new a(callable));
        }
    }

    /* access modifiers changed from: private */
    public void a(l<T> lVar) {
        if (this.e == null) {
            this.e = lVar;
            a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized m<T> a(h<T> hVar) {
        if (!(this.e == null || this.e.a() == null)) {
            hVar.a(this.e.a());
        }
        this.f1842b.add(hVar);
        return this;
    }

    public synchronized m<T> b(h<T> hVar) {
        this.f1842b.remove(hVar);
        return this;
    }

    public synchronized m<T> c(h<Throwable> hVar) {
        if (!(this.e == null || this.e.b() == null)) {
            hVar.a(this.e.b());
        }
        this.c.add(hVar);
        return this;
    }

    public synchronized m<T> d(h<Throwable> hVar) {
        this.c.remove(hVar);
        return this;
    }

    private void a() {
        this.d.post(new Runnable() {
            public void run() {
                if (m.this.e != null) {
                    l a2 = m.this.e;
                    if (a2.a() != null) {
                        m.this.a(a2.a());
                    } else {
                        m.this.a(a2.b());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void a(T t) {
        for (h a2 : new ArrayList(this.f1842b)) {
            a2.a(t);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(Throwable th) {
        ArrayList<h> arrayList = new ArrayList<>(this.c);
        if (arrayList.isEmpty()) {
            d.a("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (h a2 : arrayList) {
            a2.a(th);
        }
    }

    /* compiled from: LottieTask */
    private class a extends FutureTask<l<T>> {
        a(Callable<l<T>> callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            if (!isCancelled()) {
                try {
                    m.this.a((l) get());
                } catch (InterruptedException | ExecutionException e) {
                    m.this.a(new l(e));
                }
            }
        }
    }
}
