package com.coloros.anim;

import java.util.Map;

/* compiled from: TextDelegate */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f2490a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2491b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.f2491b && this.f2490a.containsKey(str)) {
            return this.f2490a.get(str);
        }
        String b2 = b(str);
        if (this.f2491b) {
            this.f2490a.put(str, b2);
        }
        return b2;
    }
}
