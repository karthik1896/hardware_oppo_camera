package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.f.e;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ViewInfoStore */
class u {

    /* renamed from: a  reason: collision with root package name */
    final SimpleArrayMap<RecyclerView.w, a> f1161a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    final LongSparseArray<RecyclerView.w> f1162b = new LongSparseArray<>();

    /* compiled from: ViewInfoStore */
    interface b {
        void a(RecyclerView.w wVar);

        void a(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    u() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f1161a.clear();
        this.f1162b.clear();
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f1161a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f1161a.put(wVar, aVar);
        }
        aVar.f1164b = cVar;
        aVar.f1163a |= 4;
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.w wVar) {
        a aVar = this.f1161a.get(wVar);
        if (aVar == null || (aVar.f1163a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.f.c b(RecyclerView.w wVar) {
        return a(wVar, 4);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.f.c c(RecyclerView.w wVar) {
        return a(wVar, 8);
    }

    private RecyclerView.f.c a(RecyclerView.w wVar, int i) {
        a valueAt;
        RecyclerView.f.c cVar;
        int indexOfKey = this.f1161a.indexOfKey(wVar);
        if (indexOfKey < 0 || (valueAt = this.f1161a.valueAt(indexOfKey)) == null || (valueAt.f1163a & i) == 0) {
            return null;
        }
        valueAt.f1163a &= ~i;
        if (i == 4) {
            cVar = valueAt.f1164b;
        } else if (i == 8) {
            cVar = valueAt.c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((valueAt.f1163a & 12) == 0) {
            this.f1161a.removeAt(indexOfKey);
            a.a(valueAt);
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(long j, RecyclerView.w wVar) {
        this.f1162b.put(j, wVar);
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f1161a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f1161a.put(wVar, aVar);
        }
        aVar.f1163a |= 2;
        aVar.f1164b = cVar;
    }

    /* access modifiers changed from: package-private */
    public boolean d(RecyclerView.w wVar) {
        a aVar = this.f1161a.get(wVar);
        return (aVar == null || (aVar.f1163a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.w a(long j) {
        return this.f1162b.get(j);
    }

    /* access modifiers changed from: package-private */
    public void c(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVar = this.f1161a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f1161a.put(wVar, aVar);
        }
        aVar.c = cVar;
        aVar.f1163a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.w wVar) {
        a aVar = this.f1161a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.f1161a.put(wVar, aVar);
        }
        aVar.f1163a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView.w wVar) {
        a aVar = this.f1161a.get(wVar);
        if (aVar != null) {
            aVar.f1163a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.f1161a.size() - 1; size >= 0; size--) {
            RecyclerView.w keyAt = this.f1161a.keyAt(size);
            a removeAt = this.f1161a.removeAt(size);
            if ((removeAt.f1163a & 3) == 3) {
                bVar.a(keyAt);
            } else if ((removeAt.f1163a & 1) != 0) {
                if (removeAt.f1164b == null) {
                    bVar.a(keyAt);
                } else {
                    bVar.a(keyAt, removeAt.f1164b, removeAt.c);
                }
            } else if ((removeAt.f1163a & 14) == 14) {
                bVar.b(keyAt, removeAt.f1164b, removeAt.c);
            } else if ((removeAt.f1163a & 12) == 12) {
                bVar.c(keyAt, removeAt.f1164b, removeAt.c);
            } else if ((removeAt.f1163a & 4) != 0) {
                bVar.a(keyAt, removeAt.f1164b, (RecyclerView.f.c) null);
            } else if ((removeAt.f1163a & 8) != 0) {
                bVar.b(keyAt, removeAt.f1164b, removeAt.c);
            } else {
                int i = removeAt.f1163a;
            }
            a.a(removeAt);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(RecyclerView.w wVar) {
        int size = this.f1162b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (wVar == this.f1162b.valueAt(size)) {
                this.f1162b.removeAt(size);
                break;
            } else {
                size--;
            }
        }
        a remove = this.f1161a.remove(wVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a.b();
    }

    public void h(RecyclerView.w wVar) {
        f(wVar);
    }

    /* compiled from: ViewInfoStore */
    static class a {
        static e.a<a> d = new e.b(20);

        /* renamed from: a  reason: collision with root package name */
        int f1163a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.f.c f1164b;
        RecyclerView.f.c c;

        private a() {
        }

        static a a() {
            a a2 = d.a();
            return a2 == null ? new a() : a2;
        }

        static void a(a aVar) {
            aVar.f1163a = 0;
            aVar.f1164b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            do {
            } while (d.a() != null);
        }
    }
}
