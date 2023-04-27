package com.coloros.anim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.coloros.anim.f.b;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: EffectiveAnimationTask */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    public static Executor f2446a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private final Set<c<T>> f2447b;
    private final Set<c<Throwable>> c;
    private final Handler d;
    private volatile e<T> e;

    public f(Callable<e<T>> callable) {
        this(callable, false);
    }

    f(Callable<e<T>> callable, boolean z) {
        this.f2447b = new LinkedHashSet(1);
        this.c = new LinkedHashSet(1);
        this.d = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1001) {
                    f.this.b();
                }
            }
        };
        this.e = null;
        if (z) {
            try {
                a(callable.call());
            } catch (Throwable th) {
                a(new e(th));
            }
        } else {
            f2446a.execute(new a(callable));
        }
    }

    /* access modifiers changed from: private */
    public void a(e<T> eVar) {
        if (this.e == null) {
            this.e = eVar;
            b.b("Load anim composition done,setting result!!!");
            a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized f<T> a(c<T> cVar) {
        if (this.e == null || this.e.a() == null) {
            this.f2447b.add(cVar);
            return this;
        }
        b.b("EffectiveAnimationTask addListener listener.onResult");
        cVar.a(this.e.a());
        return this;
    }

    public synchronized f<T> b(c<T> cVar) {
        this.f2447b.remove(cVar);
        return this;
    }

    public synchronized f<T> c(c<Throwable> cVar) {
        if (this.e == null || this.e.b() == null) {
            this.c.add(cVar);
            return this;
        }
        cVar.a(this.e.b());
        return this;
    }

    public synchronized f<T> d(c<Throwable> cVar) {
        this.c.remove(cVar);
        return this;
    }

    private void a() {
        Message obtainMessage = this.d.obtainMessage(1001);
        obtainMessage.setAsynchronous(true);
        this.d.sendMessageAtFrontOfQueue(obtainMessage);
    }

    /* access modifiers changed from: private */
    public void b() {
        boolean z = Looper.getMainLooper() == Looper.myLooper();
        if (this.e != null && z) {
            e<T> eVar = this.e;
            if (eVar.a() != null) {
                a(eVar.a());
            } else {
                a(eVar.b());
            }
        }
    }

    private synchronized void a(T t) {
        for (c a2 : new ArrayList(this.f2447b)) {
            a2.a(t);
        }
    }

    private synchronized void a(Throwable th) {
        ArrayList<c> arrayList = new ArrayList<>(this.c);
        if (arrayList.isEmpty()) {
            Log.w("EffectiveAnimation", "EffectiveAnimation encountered an error but no failure listener was added.", th);
            return;
        }
        for (c a2 : arrayList) {
            a2.a(th);
        }
    }

    /* compiled from: EffectiveAnimationTask */
    private class a extends FutureTask<e<T>> {
        a(Callable<e<T>> callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            if (!isCancelled()) {
                try {
                    f.this.a((e) get());
                } catch (InterruptedException | ExecutionException e) {
                    f.this.a(new e(e));
                }
            }
        }
    }
}
