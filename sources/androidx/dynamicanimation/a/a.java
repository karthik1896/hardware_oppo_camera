package androidx.dynamicanimation.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: AnimationHandler */
class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<a> f785a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f786b = new ArrayList<>();
    long c = 0;
    private final SimpleArrayMap<b, Long> d = new SimpleArrayMap<>();
    private final C0026a e = new C0026a();
    private c f;
    private boolean g = false;

    /* compiled from: AnimationHandler */
    interface b {
        boolean a(long j);
    }

    a() {
    }

    /* renamed from: androidx.dynamicanimation.a.a$a  reason: collision with other inner class name */
    /* compiled from: AnimationHandler */
    class C0026a {
        C0026a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a.this.c = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.a(aVar.c);
            if (a.this.f786b.size() > 0) {
                a.this.b().a();
            }
        }
    }

    public static a a() {
        if (f785a.get() == null) {
            f785a.set(new a());
        }
        return f785a.get();
    }

    /* access modifiers changed from: package-private */
    public c b() {
        if (this.f == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f = new e(this.e);
            } else {
                this.f = new d(this.e);
            }
        }
        return this.f;
    }

    public void a(b bVar, long j) {
        if (this.f786b.size() == 0) {
            b().a();
        }
        if (!this.f786b.contains(bVar)) {
            this.f786b.add(bVar);
        }
        if (j > 0) {
            this.d.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.d.remove(bVar);
        int indexOf = this.f786b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f786b.set(indexOf, (Object) null);
            this.g = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.f786b.size(); i++) {
            b bVar = this.f786b.get(i);
            if (bVar != null && b(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        c();
    }

    private boolean b(b bVar, long j) {
        Long l = this.d.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() >= j) {
            return false;
        }
        this.d.remove(bVar);
        return true;
    }

    private void c() {
        if (this.g) {
            for (int size = this.f786b.size() - 1; size >= 0; size--) {
                if (this.f786b.get(size) == null) {
                    this.f786b.remove(size);
                }
            }
            this.g = false;
        }
    }

    /* compiled from: AnimationHandler */
    private static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f791b = Choreographer.getInstance();
        private final Choreographer.FrameCallback c = new Choreographer.FrameCallback() {
            public void doFrame(long j) {
                e.this.f788a.a();
            }
        };

        e(C0026a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f791b.postFrameCallback(this.c);
        }
    }

    /* compiled from: AnimationHandler */
    private static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        long f789b = -1;
        private final Runnable c = new Runnable() {
            public void run() {
                d.this.f789b = SystemClock.uptimeMillis();
                d.this.f788a.a();
            }
        };
        private final Handler d = new Handler(Looper.myLooper());

        d(C0026a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.d.postDelayed(this.c, Math.max(10 - (SystemClock.uptimeMillis() - this.f789b), 0));
        }
    }

    /* compiled from: AnimationHandler */
    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final C0026a f788a;

        /* access modifiers changed from: package-private */
        public abstract void a();

        c(C0026a aVar) {
            this.f788a = aVar;
        }
    }
}
