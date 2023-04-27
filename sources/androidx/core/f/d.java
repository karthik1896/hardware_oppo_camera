package androidx.core.f;

/* compiled from: Pair */
public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f676a;

    /* renamed from: b  reason: collision with root package name */
    public final S f677b;

    public d(F f, S s) {
        this.f676a = f;
        this.f677b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!c.a(dVar.f676a, this.f676a) || !c.a(dVar.f677b, this.f677b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f = this.f676a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f677b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f676a) + " " + String.valueOf(this.f677b) + "}";
    }

    public static <A, B> d<A, B> a(A a2, B b2) {
        return new d<>(a2, b2);
    }
}
