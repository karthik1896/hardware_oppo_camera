package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.e;

class ReflectiveGenericLifecycleObserver implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f911a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0030a f912b = a.f914a.b(this.f911a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f911a = obj;
    }

    public void a(h hVar, e.a aVar) {
        this.f912b.a(hVar, aVar, this.f911a);
    }
}
