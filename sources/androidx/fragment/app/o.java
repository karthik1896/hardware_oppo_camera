package androidx.fragment.app;

import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.i;

/* compiled from: FragmentViewLifecycleOwner */
class o implements h {

    /* renamed from: a  reason: collision with root package name */
    private i f900a = null;

    o() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f900a == null) {
            this.f900a = new i(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f900a != null;
    }

    public e getLifecycle() {
        a();
        return this.f900a;
    }

    /* access modifiers changed from: package-private */
    public void a(e.a aVar) {
        this.f900a.a(aVar);
    }
}
