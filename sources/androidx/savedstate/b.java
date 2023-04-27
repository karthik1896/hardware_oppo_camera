package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.e;

/* compiled from: SavedStateRegistryController */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f1230a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1231b = new a();

    private b(c cVar) {
        this.f1230a = cVar;
    }

    public a a() {
        return this.f1231b;
    }

    public void a(Bundle bundle) {
        e lifecycle = this.f1230a.getLifecycle();
        if (lifecycle.a() == e.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f1230a));
            this.f1231b.a(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        this.f1231b.a(bundle);
    }

    public static b a(c cVar) {
        return new b(cVar);
    }
}
