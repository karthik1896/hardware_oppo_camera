package com.coloros.anim.f;

import android.util.Log;

/* compiled from: ColorLog */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2452a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2453b = false;
    public static boolean c = false;
    public static boolean d = false;

    static {
        Log.i("EffectiveAnimation", "ColorLog, DEBUG_DRAW : " + f2452a + "; DEBUG_COMPOSITION : " + f2453b + "; DEBUG_KEYPATH : " + c + "; DEBUG_BUILD_LAYER = " + d);
    }

    public static void a(String str) {
        Log.d("EffectiveAnimation", str);
    }

    public static void b(String str) {
        Log.i("EffectiveAnimation", str);
    }

    public static void c(String str) {
        Log.w("EffectiveAnimation", str);
    }
}
