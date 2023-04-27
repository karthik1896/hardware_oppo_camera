package com.heytap.compat.os;

import android.os.SystemProperties;
import com.heytap.compat.d.a.a;

/* compiled from: SystemPropertiesNative */
public class b {
    public static String a(String str) throws a {
        if (com.heytap.compat.d.a.b.g()) {
            return SystemProperties.get(str);
        }
        throw new a("not supported before L");
    }

    public static String a(String str, String str2) throws a {
        if (com.heytap.compat.d.a.b.g()) {
            return SystemProperties.get(str, str2);
        }
        throw new a("not supported before L");
    }

    public static int a(String str, int i) throws a {
        if (com.heytap.compat.d.a.b.g()) {
            return SystemProperties.getInt(str, i);
        }
        throw new a("not supported before L");
    }

    public static boolean a(String str, boolean z) throws a {
        if (com.heytap.compat.d.a.b.g()) {
            return SystemProperties.getBoolean(str, z);
        }
        throw new a("not supported before L");
    }
}
