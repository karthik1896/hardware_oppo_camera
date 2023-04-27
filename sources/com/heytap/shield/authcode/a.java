package com.heytap.shield.authcode;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.heytap.shield.b.b;
import com.heytap.shield.b.d;
import com.heytap.shield.b.e;
import com.heytap.shield.b.h;
import java.util.Arrays;

/* compiled from: AuthCache */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private LruCache<String, com.heytap.shield.authcode.a.a> f2629a = new LruCache<>(com.heytap.shield.a.f2624b);

    /* renamed from: b  reason: collision with root package name */
    private Context f2630b;
    private String c;

    public a(Context context) {
        this.f2630b = context;
        this.c = b.b(this.f2630b, "android");
    }

    public boolean a(String str) {
        return TextUtils.equals(this.c, str);
    }

    public boolean a(String str, String str2) {
        com.heytap.shield.authcode.a.a a2 = b.a(this.f2630b, str, e.a(this.f2630b, str, "AppPlatformKey"));
        com.heytap.shield.authcode.a.a aVar = this.f2629a.get(str);
        if (a2 == null || aVar == null || aVar.e() || !TextUtils.equals(str2, aVar.d())) {
            return false;
        }
        return Arrays.equals(a2.a(), aVar.a());
    }

    public void a(String str, com.heytap.shield.authcode.a.a aVar, String str2) {
        aVar.f();
        aVar.c();
        aVar.a(str2);
        this.f2629a.put(str, aVar);
    }

    public boolean a(String str, String str2, String str3) {
        com.heytap.shield.authcode.a.a aVar = this.f2629a.get(str);
        if (aVar == null) {
            return false;
        }
        if (h.a(str2, ".").size() > 2) {
            str2 = str2.substring(str2.lastIndexOf(".") + 1);
        }
        boolean z = aVar.a("epona", str2) || aVar.a("epona", str3);
        boolean z2 = aVar.a("tingle", str2) || aVar.a("tingle", str3);
        if (!z && z2) {
            d.a("Action : [" + str2 + "/" + str3 + "] is re-wrapped form Tingle, Caller : [" + str + "]");
        }
        if (z || z2) {
            return true;
        }
        return false;
    }
}
