package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.e;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* compiled from: SavedStateRegistry */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    boolean f1228a = true;

    /* renamed from: b  reason: collision with root package name */
    private androidx.a.a.b.b<String, b> f1229b = new androidx.a.a.b.b<>();
    private Bundle c;
    private boolean d;

    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    /* compiled from: SavedStateRegistry */
    public interface C0038a {
        void a(c cVar);
    }

    /* compiled from: SavedStateRegistry */
    public interface b {
        Bundle a();
    }

    a() {
    }

    public Bundle a(String str) {
        if (this.d) {
            Bundle bundle = this.c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.c.remove(str);
            if (this.c.isEmpty()) {
                this.c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar, Bundle bundle) {
        if (!this.d) {
            if (bundle != null) {
                this.c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            eVar.a(new SavedStateRegistry$1(this));
            this.d = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        androidx.a.a.b.b<K, V>.d c2 = this.f1229b.c();
        while (c2.hasNext()) {
            Map.Entry entry = (Map.Entry) c2.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
