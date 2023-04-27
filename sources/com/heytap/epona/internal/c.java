package com.heytap.epona.internal;

import com.heytap.epona.b;
import com.heytap.epona.c.a;
import com.heytap.epona.h;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProviderRepo */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f2605a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f2606b = new ConcurrentHashMap<>();

    public b a(String str) {
        return this.f2605a.get(str);
    }

    public a b(String str) {
        return this.f2606b.get(str);
    }
}
