package androidx.core.f;

/* compiled from: Pools */
public final class e {

    /* compiled from: Pools */
    public interface a<T> {
        T a();

        boolean a(T t);
    }

    /* compiled from: Pools */
    public static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f678a;

        /* renamed from: b  reason: collision with root package name */
        private int f679b;

        public b(int i) {
            if (i > 0) {
                this.f678a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T a() {
            int i = this.f679b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f678a;
            T t = tArr[i2];
            tArr[i2] = null;
            this.f679b = i - 1;
            return t;
        }

        public boolean a(T t) {
            if (!b(t)) {
                int i = this.f679b;
                Object[] objArr = this.f678a;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.f679b = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }

        private boolean b(T t) {
            for (int i = 0; i < this.f679b; i++) {
                if (this.f678a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Pools */
    public static class c<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f680a = new Object();

        public c(int i) {
            super(i);
        }

        public T a() {
            T a2;
            synchronized (this.f680a) {
                a2 = super.a();
            }
            return a2;
        }

        public boolean a(T t) {
            boolean a2;
            synchronized (this.f680a) {
                a2 = super.a(t);
            }
            return a2;
        }
    }
}
