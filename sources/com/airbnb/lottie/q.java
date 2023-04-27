package com.airbnb.lottie;

import java.util.Map;

/* compiled from: TextDelegate */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f1848a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1849b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.f1849b && this.f1848a.containsKey(str)) {
            return this.f1848a.get(str);
        }
        String b2 = b(str);
        if (this.f1849b) {
            this.f1848a.put(str, b2);
        }
        return b2;
    }
}
