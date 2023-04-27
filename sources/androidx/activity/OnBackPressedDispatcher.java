package androidx.activity;

import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    final ArrayDeque<c> f104a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f105b;

    public OnBackPressedDispatcher() {
        this((Runnable) null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f104a = new ArrayDeque<>();
        this.f105b = runnable;
    }

    /* access modifiers changed from: package-private */
    public a a(c cVar) {
        this.f104a.add(cVar);
        a aVar = new a(cVar);
        cVar.a((a) aVar);
        return aVar;
    }

    public void a(h hVar, c cVar) {
        e lifecycle = hVar.getLifecycle();
        if (lifecycle.a() != e.b.DESTROYED) {
            cVar.a((a) new LifecycleOnBackPressedCancellable(lifecycle, cVar));
        }
    }

    public void a() {
        Iterator<c> descendingIterator = this.f104a.descendingIterator();
        while (descendingIterator.hasNext()) {
            c next = descendingIterator.next();
            if (next.a()) {
                next.c();
                return;
            }
        }
        Runnable runnable = this.f105b;
        if (runnable != null) {
            runnable.run();
        }
    }

    private class a implements a {

        /* renamed from: b  reason: collision with root package name */
        private final c f109b;

        a(c cVar) {
            this.f109b = cVar;
        }

        public void a() {
            OnBackPressedDispatcher.this.f104a.remove(this.f109b);
            this.f109b.b(this);
        }
    }

    private class LifecycleOnBackPressedCancellable implements a, f {

        /* renamed from: b  reason: collision with root package name */
        private final e f107b;
        private final c c;
        private a d;

        LifecycleOnBackPressedCancellable(e eVar, c cVar) {
            this.f107b = eVar;
            this.c = cVar;
            eVar.a(this);
        }

        public void a(h hVar, e.a aVar) {
            if (aVar == e.a.ON_START) {
                this.d = OnBackPressedDispatcher.this.a(this.c);
            } else if (aVar == e.a.ON_STOP) {
                a aVar2 = this.d;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else if (aVar == e.a.ON_DESTROY) {
                a();
            }
        }

        public void a() {
            this.f107b.b(this);
            this.c.b(this);
            a aVar = this.d;
            if (aVar != null) {
                aVar.a();
                this.d = null;
            }
        }
    }
}
