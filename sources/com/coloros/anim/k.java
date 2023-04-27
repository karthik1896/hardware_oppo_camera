package com.coloros.anim;

import android.util.Log;
import androidx.core.c.a;
import com.coloros.anim.f.b;
import java.util.HashSet;
import java.util.Set;

/* compiled from: L */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f2485a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2486b = false;
    private static String[] c;
    private static long[] d;
    private static int e = 0;
    private static int f = 0;

    public static void a(String str) {
        if (b.f2452a) {
            Log.d("EffectiveAnimation", str);
        }
    }

    public static void b(String str) {
        if (!f2485a.contains(str)) {
            Log.w("EffectiveAnimation", str);
            f2485a.add(str);
        }
    }

    public static void c(String str) {
        if (f2486b) {
            int i = e;
            if (i == 20) {
                f++;
                return;
            }
            c[i] = str;
            d[i] = System.nanoTime();
            a.a(str);
            e++;
        }
    }

    public static float d(String str) {
        int i = f;
        if (i > 0) {
            f = i - 1;
            return 0.0f;
        } else if (!f2486b) {
            return 0.0f;
        } else {
            e--;
            int i2 = e;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(c[i2])) {
                a.a();
                return ((float) (System.nanoTime() - d[e])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[e] + ".");
            }
        }
    }
}
