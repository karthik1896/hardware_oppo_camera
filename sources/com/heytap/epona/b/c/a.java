package com.heytap.epona.b.c;

import android.os.IBinder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Dispatcher */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f2584a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, IBinder> f2585b = new ConcurrentHashMap();
    private Map<String, List<String>> c = new ConcurrentHashMap();

    private a() {
    }

    public static a a() {
        if (f2584a == null) {
            synchronized (a.class) {
                if (f2584a == null) {
                    f2584a = new a();
                }
            }
        }
        return f2584a;
    }

    public IBinder a(String str) {
        return this.f2585b.get(str);
    }
}
