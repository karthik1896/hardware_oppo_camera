package com.airbnb.lottie.f;

import android.util.Log;
import com.airbnb.lottie.i;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LogcatLogger */
public class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f1818a = new HashSet();

    public void a(String str) {
        c(str, (Throwable) null);
    }

    public void c(String str, Throwable th) {
        if (com.airbnb.lottie.c.f1655a) {
            Log.d("LOTTIE", str, th);
        }
    }

    public void b(String str) {
        a(str, (Throwable) null);
    }

    public void a(String str, Throwable th) {
        if (!f1818a.contains(str)) {
            Log.w("LOTTIE", str, th);
            f1818a.add(str);
        }
    }

    public void b(String str, Throwable th) {
        if (com.airbnb.lottie.c.f1655a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
