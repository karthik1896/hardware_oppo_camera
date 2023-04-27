package com.oppo.camera.gl;

import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Utils */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3325a = (Build.TYPE.equals("eng") || Build.TYPE.equals("userdebug"));

    /* renamed from: b  reason: collision with root package name */
    private static long[] f3326b = new long[256];

    public static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    static {
        for (int i = 0; i < 256; i++) {
            long j = (long) i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? -7661587058870466123L : 0);
            }
            f3326b[i] = j;
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS", Locale.CHINA).format(Long.valueOf(j));
    }
}
