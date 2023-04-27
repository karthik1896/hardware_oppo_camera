package com.heytap.shield.authcode.a;

import android.text.TextUtils;
import com.heytap.shield.authcode.d;
import com.heytap.shield.b.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AuthResult */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f2631a;

    /* renamed from: b  reason: collision with root package name */
    private int f2632b;
    private byte[] c;
    private long d;
    private Map<String, d> e;
    private String f;

    public a(String str, int i, byte[] bArr) {
        this.f2631a = str;
        this.f2632b = i;
        this.c = bArr;
    }

    public byte[] a() {
        return this.c;
    }

    public int b() {
        return this.f2632b;
    }

    public void c() {
        this.d = System.currentTimeMillis();
    }

    public void a(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public boolean e() {
        return System.currentTimeMillis() - this.d > com.heytap.shield.a.f2623a;
    }

    public void f() {
        this.e = new ConcurrentHashMap();
        for (String next : h.a(new String(this.c), ";")) {
            int indexOf = next.indexOf(",");
            if (indexOf != -1) {
                String substring = next.substring(0, indexOf);
                String substring2 = next.substring(indexOf + 1);
                if (TextUtils.equals(substring, "epona") || TextUtils.equals(substring, "tingle")) {
                    this.e.put(substring, new d(substring2));
                    com.heytap.shield.b.d.a("Package : " + this.f2631a + " Permission : type [" + substring + "] -" + h.a(substring2, ","));
                }
            }
        }
    }

    public boolean a(String str, String str2) {
        d dVar = this.e.get(str);
        if (dVar != null) {
            return dVar.a(str2);
        }
        return false;
    }
}
