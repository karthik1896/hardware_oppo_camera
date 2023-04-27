package com.oppo.camera.f;

import android.media.CamcorderProfile;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/* compiled from: MtkCamcorderProfile */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Integer, Integer> f3192a = new HashMap<>();

    static {
        f3192a.put(6, 18);
        f3192a.put(5, 10);
        f3192a.put(4, 10);
        f3192a.put(10, 10);
        f3192a.put(12, -1);
    }

    public static int a(int i) {
        Integer num = f3192a.get(Integer.valueOf(i));
        return num == null ? i : num.intValue();
    }

    public static CamcorderProfile a(int i, int i2) {
        return b(i, i2);
    }

    public static CamcorderProfile b(int i, int i2) {
        try {
            Constructor<?> declaredConstructor = Class.forName("android.media.CamcorderProfile").getDeclaredConstructor(new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return (CamcorderProfile) declaredConstructor.newInstance(new Object[]{30, 10, 2, 2, 9000000, 30, 1280, 720, 3, 128000, 48000, 2});
        } catch (Exception e) {
            com.oppo.camera.e.d("MtkCamcorderProfile", " " + e);
            e.printStackTrace();
            return null;
        }
    }

    public static boolean c(int i, int i2) {
        return CamcorderProfile.hasProfile(i, a(i2));
    }
}
