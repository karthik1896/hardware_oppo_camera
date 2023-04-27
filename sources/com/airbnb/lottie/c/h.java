package com.airbnb.lottie.c;

/* compiled from: Marker */
public class h {
    private static String c = "\r";

    /* renamed from: a  reason: collision with root package name */
    public final float f1720a;

    /* renamed from: b  reason: collision with root package name */
    public final float f1721b;
    private final String d;

    public h(String str, float f, float f2) {
        this.d = str;
        this.f1721b = f2;
        this.f1720a = f;
    }

    public boolean a(String str) {
        if (this.d.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.d.endsWith(c)) {
            String str2 = this.d;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
