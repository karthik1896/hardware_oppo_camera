package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel */
class j extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final r.a f871a = new r.a() {
        public <T extends q> T a(Class<T> cls) {
            return new j(true);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<Fragment> f872b = new HashSet<>();
    private final HashMap<String, j> c = new HashMap<>();
    private final HashMap<String, s> d = new HashMap<>();
    private final boolean e;
    private boolean f = false;
    private boolean g = false;

    static j a(s sVar) {
        return (j) new r(sVar, f871a).a(j.class);
    }

    j(boolean z) {
        this.e = z;
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (i.f849b) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Fragment fragment) {
        return this.f872b.add(fragment);
    }

    /* access modifiers changed from: package-private */
    public Collection<Fragment> c() {
        return this.f872b;
    }

    /* access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (!this.f872b.contains(fragment)) {
            return true;
        }
        if (this.e) {
            return this.f;
        }
        return !this.g;
    }

    /* access modifiers changed from: package-private */
    public boolean c(Fragment fragment) {
        return this.f872b.remove(fragment);
    }

    /* access modifiers changed from: package-private */
    public j d(Fragment fragment) {
        j jVar = this.c.get(fragment.mWho);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this.e);
        this.c.put(fragment.mWho, jVar2);
        return jVar2;
    }

    /* access modifiers changed from: package-private */
    public s e(Fragment fragment) {
        s sVar = this.d.get(fragment.mWho);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s();
        this.d.put(fragment.mWho, sVar2);
        return sVar2;
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (i.f849b) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        j jVar = this.c.get(fragment.mWho);
        if (jVar != null) {
            jVar.a();
            this.c.remove(fragment.mWho);
        }
        s sVar = this.d.get(fragment.mWho);
        if (sVar != null) {
            sVar.a();
            this.d.remove(fragment.mWho);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (!this.f872b.equals(jVar.f872b) || !this.c.equals(jVar.c) || !this.d.equals(jVar.d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f872b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f872b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
