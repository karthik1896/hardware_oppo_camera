package com.heytap.compat.os;

import android.os.PowerManager;
import com.color.inner.os.PowerManagerWrapper;
import com.heytap.compat.d.a.b;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefMethod;

/* compiled from: PowerManagerNative */
public class a {

    /* renamed from: com.heytap.compat.os.a$a  reason: collision with other inner class name */
    /* compiled from: PowerManagerNative */
    private static class C0066a {

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f2570a = RefClass.load(C0066a.class, (Class<?>) PowerManager.class);
        private static RefMethod<Integer> getDefaultScreenBrightnessSetting;
        private static RefMethod<Boolean> getDisplayAodStatus;
        /* access modifiers changed from: private */
        public static RefMethod<Integer> getMaximumScreenBrightnessSetting;
        private static RefMethod<Integer> getMinimumScreenBrightnessSetting;

        private C0066a() {
        }
    }

    public static int a(PowerManager powerManager) throws com.heytap.compat.d.a.a {
        if (b.a()) {
            return ((Integer) C0066a.getMaximumScreenBrightnessSetting.call(powerManager, new Object[0])).intValue();
        }
        if (b.b()) {
            return PowerManagerWrapper.getMaximumScreenBrightnessSetting(powerManager);
        }
        if (b.e()) {
            return ((Integer) C0066a.getMaximumScreenBrightnessSetting.call(powerManager, new Object[0])).intValue();
        }
        throw new com.heytap.compat.d.a.a("not supported before N");
    }
}
