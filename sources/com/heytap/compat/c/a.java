package com.heytap.compat.c;

import android.provider.Settings;
import android.util.Log;
import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.c;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefStaticObject;

/* compiled from: SettingsNative */
public class a {

    /* renamed from: com.heytap.compat.c.a$a  reason: collision with other inner class name */
    /* compiled from: SettingsNative */
    public static class C0063a {

        /* renamed from: a  reason: collision with root package name */
        public static String f2566a;

        /* renamed from: b  reason: collision with root package name */
        public static int f2567b;
        public static String c;

        /* renamed from: com.heytap.compat.c.a$a$a  reason: collision with other inner class name */
        /* compiled from: SettingsNative */
        private static class C0064a {
            /* access modifiers changed from: private */
            public static RefStaticObject<String> WIFI_DISCONNECT_DELAY_DURATION;

            /* renamed from: a  reason: collision with root package name */
            private static Class<?> f2568a = RefClass.load(C0064a.class, (Class<?>) Settings.Secure.class);

            private C0064a() {
            }
        }

        static {
            try {
                if (com.heytap.compat.d.a.b.a()) {
                    Response a2 = c.a(new Request.a().a("Settings.Secure").b("getConstant").a()).a();
                    if (a2.isSuccessful()) {
                        c = a2.getBundle().getString("LOCATION_CHANGER");
                        f2567b = a2.getBundle().getInt("LOCATION_CHANGER_SYSTEM_SETTINGS");
                        return;
                    }
                    Log.e("SettingsNative", "Epona Communication failed, static initializer failed.");
                } else if (com.heytap.compat.d.a.b.b()) {
                    f2566a = (String) C0064a.WIFI_DISCONNECT_DELAY_DURATION.getWithException();
                } else {
                    Log.e("SettingsNative", "Not supported before Q");
                }
            } catch (Throwable th) {
                Log.e("SettingsNative", th.toString());
            }
        }

        public static boolean a(String str, int i) {
            if (com.heytap.compat.d.a.b.a()) {
                Response a2 = c.a(new Request.a().a("Settings.Secure").b("putInt").a("SETTINGS_KEY", str).a("SETTINGS_VALUE", i).a()).a();
                if (a2.isSuccessful()) {
                    return a2.getBundle().getBoolean("result");
                }
                return false;
            } else if (com.heytap.compat.d.a.b.f()) {
                return Settings.Secure.putInt(c.c().getContentResolver(), str, i);
            } else {
                Log.e("SettingsNative", "SettingsNative.Secure.putInt is not supported before M");
                return false;
            }
        }
    }

    /* compiled from: SettingsNative */
    public static class b {
        public static boolean a(String str, String str2) {
            if (com.heytap.compat.d.a.b.a()) {
                Response a2 = c.a(new Request.a().a("Settings.System").b("putString").a("SETTINGS_KEY", str).a("SETTINGS_VALUE", str2).a()).a();
                if (a2.isSuccessful()) {
                    return a2.getBundle().getBoolean("result");
                }
                return false;
            } else if (com.heytap.compat.d.a.b.f()) {
                return Settings.System.putString(c.c().getContentResolver(), str, str2);
            } else {
                Log.e("SettingsNative", "SettingsNative.System.putString is not supported before M");
                return false;
            }
        }

        public static boolean a(String str, int i) {
            if (com.heytap.compat.d.a.b.a()) {
                Response a2 = c.a(new Request.a().a("Settings.System").b("putInt").a("SETTINGS_KEY", str).a("SETTINGS_VALUE", i).a()).a();
                if (a2.isSuccessful()) {
                    return a2.getBundle().getBoolean("result");
                }
                return false;
            } else if (com.heytap.compat.d.a.b.f()) {
                return Settings.System.putInt(c.c().getContentResolver(), str, i);
            } else {
                Log.e("SettingsNative", "SettingsNative.System.putInt is not supported before M");
                return false;
            }
        }
    }
}
