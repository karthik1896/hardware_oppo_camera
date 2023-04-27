package androidx.lifecycle;

import java.util.HashMap;

/* compiled from: ViewModelStore */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, q> f934a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void a(String str, q qVar) {
        q put = this.f934a.put(str, qVar);
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final q a(String str) {
        return this.f934a.get(str);
    }

    public final void a() {
        for (q d : this.f934a.values()) {
            d.d();
        }
        this.f934a.clear();
    }
}
