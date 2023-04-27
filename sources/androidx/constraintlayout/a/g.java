package androidx.constraintlayout.a;

/* compiled from: Pools */
final class g {

    /* compiled from: Pools */
    interface a<T> {
        T a();

        void a(T[] tArr, int i);

        boolean a(T t);
    }

    /* compiled from: Pools */
    static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f543a;

        /* renamed from: b  reason: collision with root package name */
        private int f544b;

        b(int i) {
            if (i > 0) {
                this.f543a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T a() {
            int i = this.f544b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f543a;
            T t = tArr[i2];
            tArr[i2] = null;
            this.f544b = i - 1;
            return t;
        }

        public boolean a(T t) {
            int i = this.f544b;
            Object[] objArr = this.f543a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.f544b = i + 1;
            return true;
        }

        public void a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.f544b;
                Object[] objArr = this.f543a;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.f544b = i3 + 1;
                }
            }
        }
    }
}
