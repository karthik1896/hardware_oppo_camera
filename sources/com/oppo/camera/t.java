package com.oppo.camera;

/* compiled from: PhoneMotionState */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f3156a = false;

    /* renamed from: b  reason: collision with root package name */
    private static float f3157b = 1.0f;

    public static float a() {
        return f3157b;
    }

    public static void a(boolean z) {
        f3156a = z;
    }

    public static boolean b() {
        e.a("PhoneMotionState", "isPhoneMovingState: " + f3156a);
        return f3156a;
    }
}
