package com.airbnb.lottie.c;

import androidx.collection.LruCache;
import com.airbnb.lottie.d;

/* compiled from: LottieCompositionCache */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final g f1718a = new g();

    /* renamed from: b  reason: collision with root package name */
    private final LruCache<String, d> f1719b = new LruCache<>(20);

    public static g a() {
        return f1718a;
    }

    g() {
    }

    public d a(String str) {
        if (str == null) {
            return null;
        }
        return this.f1719b.get(str);
    }

    public void a(String str, d dVar) {
        if (str != null) {
            this.f1719b.put(str, dVar);
        }
    }
}
