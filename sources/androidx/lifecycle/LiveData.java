package androidx.lifecycle;

import androidx.a.a.b.b;
import androidx.lifecycle.e;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f906b = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f907a = new Object();
    int c = 0;
    volatile Object d;
    private b<n<? super T>, LiveData<T>.a> e = new b<>();
    private volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public LiveData() {
        Object obj = f906b;
        this.f = obj;
        this.d = obj;
        this.g = -1;
        this.j = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f907a) {
                    obj = LiveData.this.d;
                    LiveData.this.d = LiveData.f906b;
                }
                LiveData.this.a(obj);
            }
        };
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.d) {
            if (!aVar.a()) {
                aVar.a(false);
                return;
            }
            int i2 = aVar.e;
            int i3 = this.g;
            if (i2 < i3) {
                aVar.e = i3;
                aVar.c.a(this.f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar == null) {
                b<K, V>.d c2 = this.e.c();
                while (c2.hasNext()) {
                    b((a) ((Map.Entry) c2.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(aVar);
                aVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    public void a(h hVar, n<? super T> nVar) {
        a("observe");
        if (hVar.getLifecycle().a() != e.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(hVar, nVar);
            a a2 = this.e.a(nVar, lifecycleBoundObserver);
            if (a2 != null && !a2.a(hVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (a2 == null) {
                hVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(n<? super T> nVar) {
        a("removeObserver");
        a b2 = this.e.b(nVar);
        if (b2 != null) {
            b2.b();
            b2.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
        a("setValue");
        this.g++;
        this.f = t;
        a((LiveData<T>.a) null);
    }

    public T a() {
        T t = this.f;
        if (t != f906b) {
            return t;
        }
        return null;
    }

    public boolean d() {
        return this.c > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.a implements d {

        /* renamed from: a  reason: collision with root package name */
        final h f909a;

        LifecycleBoundObserver(h hVar, n<? super T> nVar) {
            super(nVar);
            this.f909a = hVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f909a.getLifecycle().a().isAtLeast(e.b.STARTED);
        }

        public void a(h hVar, e.a aVar) {
            if (this.f909a.getLifecycle().a() == e.b.DESTROYED) {
                LiveData.this.a(this.c);
            } else {
                a(a());
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(h hVar) {
            return this.f909a == hVar;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f909a.getLifecycle().b(this);
        }
    }

    private abstract class a {
        final n<? super T> c;
        boolean d;
        int e = -1;

        /* access modifiers changed from: package-private */
        public abstract boolean a();

        /* access modifiers changed from: package-private */
        public boolean a(h hVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }

        a(n<? super T> nVar) {
            this.c = nVar;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (z != this.d) {
                this.d = z;
                int i = 1;
                boolean z2 = LiveData.this.c == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.c;
                if (!this.d) {
                    i = -1;
                }
                liveData.c = i2 + i;
                if (z2 && this.d) {
                    LiveData.this.b();
                }
                if (LiveData.this.c == 0 && !this.d) {
                    LiveData.this.c();
                }
                if (this.d) {
                    LiveData.this.a((LiveData<T>.a) this);
                }
            }
        }
    }

    private static void a(String str) {
        if (!androidx.a.a.a.a.a().c()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }
}
