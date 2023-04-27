package com.oppo.camera.ui.inverse;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: InverseViewHolder */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, b> f4031a = new ConcurrentHashMap();

    /* compiled from: InverseViewHolder */
    public interface a {
        boolean call(Object obj, b bVar);
    }

    public void a(a aVar) {
        for (Map.Entry next : this.f4031a.entrySet()) {
            Object obj = ((b) next.getValue()).f.get();
            if (obj != null && aVar.call(obj, (b) next.getValue())) {
                return;
            }
        }
    }

    public void a(Object obj, b bVar) {
        bVar.f = new WeakReference<>(obj);
        this.f4031a.put(Integer.valueOf(obj.hashCode()), bVar);
    }

    public void a(Object obj) {
        this.f4031a.remove(Integer.valueOf(obj.hashCode()));
    }

    public void a(Context context) {
        for (Map.Entry next : this.f4031a.entrySet()) {
            if (context != null && context.hashCode() == ((b) next.getValue()).f4025a) {
                this.f4031a.remove(next.getKey());
            } else if (((b) next.getValue()).f.get() == null) {
                this.f4031a.remove(next.getKey());
            }
        }
    }

    public int a() {
        return this.f4031a.size();
    }

    public b b(Object obj) {
        return this.f4031a.get(Integer.valueOf(obj.hashCode()));
    }

    public boolean c(Object obj) {
        return this.f4031a.containsKey(Integer.valueOf(obj.hashCode()));
    }
}
