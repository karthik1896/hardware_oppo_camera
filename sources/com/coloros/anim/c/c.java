package com.coloros.anim.c;

import android.util.LruCache;
import com.coloros.anim.a;

/* compiled from: EffectiveCompositionCache */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c f2402a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final LruCache<String, a> f2403b = new LruCache<>(20);

    c() {
    }

    public static c a() {
        return f2402a;
    }

    public a a(String str) {
        if (str == null) {
            return null;
        }
        return this.f2403b.get(str);
    }

    public void a(String str, a aVar) {
        if (str != null) {
            this.f2403b.put(str, aVar);
        }
    }
}
