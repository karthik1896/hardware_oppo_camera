package com.color.support.d;

/* compiled from: MathUtils */
public class q {
    public static int a(int i, int i2) {
        return i - (b(i, i2) * i2);
    }

    public static int b(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}
