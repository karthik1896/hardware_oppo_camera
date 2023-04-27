package com.oppo.camera.gl;

import android.os.SystemClock;

/* compiled from: AnimationTime */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f3273a;

    public static void a() {
        f3273a = SystemClock.uptimeMillis();
    }

    public static long b() {
        return f3273a;
    }
}
