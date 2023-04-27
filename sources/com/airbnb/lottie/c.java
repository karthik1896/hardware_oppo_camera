package com.airbnb.lottie;

import androidx.core.c.a;

/* compiled from: L */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1655a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1656b = false;
    private static String[] c;
    private static long[] d;
    private static int e;
    private static int f;

    public static void a(String str) {
        if (f1656b) {
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

    public static float b(String str) {
        int i = f;
        if (i > 0) {
            f = i - 1;
            return 0.0f;
        } else if (!f1656b) {
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
