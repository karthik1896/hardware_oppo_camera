package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.f.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e.a<ArrayList<T>> f566a = new e.b(10);

    /* renamed from: b  reason: collision with root package name */
    private final SimpleArrayMap<T, ArrayList<T>> f567b = new SimpleArrayMap<>();
    private final ArrayList<T> c = new ArrayList<>();
    private final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (!this.f567b.containsKey(t)) {
            this.f567b.put(t, null);
        }
    }

    public boolean b(T t) {
        return this.f567b.containsKey(t);
    }

    public void a(T t, T t2) {
        if (!this.f567b.containsKey(t) || !this.f567b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f567b.get(t);
        if (arrayList == null) {
            arrayList = c();
            this.f567b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public List c(T t) {
        return this.f567b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f567b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f567b.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f567b.keyAt(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f567b.size();
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f567b.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        int size = this.f567b.size();
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f567b.valueAt(i);
            if (valueAt != null) {
                a(valueAt);
            }
        }
        this.f567b.clear();
    }

    public ArrayList<T> b() {
        this.c.clear();
        this.d.clear();
        int size = this.f567b.size();
        for (int i = 0; i < size; i++) {
            a(this.f567b.keyAt(i), this.c, this.d);
        }
        return this.c;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f567b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private ArrayList<T> c() {
        ArrayList<T> a2 = this.f566a.a();
        return a2 == null ? new ArrayList<>() : a2;
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f566a.a(arrayList);
    }
}
