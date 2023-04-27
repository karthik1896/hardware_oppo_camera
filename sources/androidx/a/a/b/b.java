package androidx.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f92a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f93b;
    private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap<>();
    private int d = 0;

    /* compiled from: SafeIterableMap */
    interface f<K, V> {
        void a_(c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k) {
        c<K, V> cVar = this.f92a;
        while (cVar != null && !cVar.f94a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public V a(K k, V v) {
        c a2 = a(k);
        if (a2 != null) {
            return a2.f95b;
        }
        b(k, v);
        return null;
    }

    /* access modifiers changed from: protected */
    public c<K, V> b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.d++;
        c<K, V> cVar2 = this.f93b;
        if (cVar2 == null) {
            this.f92a = cVar;
            this.f93b = this.f92a;
            return cVar;
        }
        cVar2.c = cVar;
        cVar.d = cVar2;
        this.f93b = cVar;
        return cVar;
    }

    public V b(K k) {
        c a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            for (f<K, V> a_ : this.c.keySet()) {
                a_.a_(a2);
            }
        }
        if (a2.d != null) {
            a2.d.c = a2.c;
        } else {
            this.f92a = a2.c;
        }
        if (a2.c != null) {
            a2.c.d = a2.d;
        } else {
            this.f93b = a2.d;
        }
        a2.c = null;
        a2.d = null;
        return a2.f95b;
    }

    public int a() {
        return this.d;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f92a, this.f93b);
        this.c.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0000b bVar = new C0000b(this.f93b, this.f92a);
        this.c.put(bVar, false);
        return bVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f92a;
    }

    public Map.Entry<K, V> e() {
        return this.f93b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != bVar.a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* compiled from: SafeIterableMap */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f98a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f99b;

        /* access modifiers changed from: package-private */
        public abstract c<K, V> a(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f98a = cVar2;
            this.f99b = cVar;
        }

        public boolean hasNext() {
            return this.f99b != null;
        }

        public void a_(c<K, V> cVar) {
            if (this.f98a == cVar && cVar == this.f99b) {
                this.f99b = null;
                this.f98a = null;
            }
            c<K, V> cVar2 = this.f98a;
            if (cVar2 == cVar) {
                this.f98a = b(cVar2);
            }
            if (this.f99b == cVar) {
                this.f99b = b();
            }
        }

        private c<K, V> b() {
            c<K, V> cVar = this.f99b;
            c<K, V> cVar2 = this.f98a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return a(cVar);
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f99b;
            this.f99b = b();
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> a(c<K, V> cVar) {
            return cVar.c;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* renamed from: androidx.a.a.b.b$b  reason: collision with other inner class name */
    /* compiled from: SafeIterableMap */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> a(c<K, V> cVar) {
            return cVar.d;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.c;
        }
    }

    /* compiled from: SafeIterableMap */
    private class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private c<K, V> f97b;
        private boolean c = true;

        d() {
        }

        public void a_(c<K, V> cVar) {
            c<K, V> cVar2 = this.f97b;
            if (cVar == cVar2) {
                this.f97b = cVar2.d;
                this.c = this.f97b == null;
            }
        }

        public boolean hasNext() {
            if (!this.c) {
                c<K, V> cVar = this.f97b;
                if (cVar == null || cVar.c == null) {
                    return false;
                }
                return true;
            } else if (b.this.f92a != null) {
                return true;
            } else {
                return false;
            }
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (this.c) {
                this.c = false;
                this.f97b = b.this.f92a;
            } else {
                c<K, V> cVar = this.f97b;
                this.f97b = cVar != null ? cVar.c : null;
            }
            return this.f97b;
        }
    }

    /* compiled from: SafeIterableMap */
    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f94a;

        /* renamed from: b  reason: collision with root package name */
        final V f95b;
        c<K, V> c;
        c<K, V> d;

        c(K k, V v) {
            this.f94a = k;
            this.f95b = v;
        }

        public K getKey() {
            return this.f94a;
        }

        public V getValue() {
            return this.f95b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f94a + "=" + this.f95b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f94a.equals(cVar.f94a) || !this.f95b.equals(cVar.f95b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f94a.hashCode() ^ this.f95b.hashCode();
        }
    }
}
