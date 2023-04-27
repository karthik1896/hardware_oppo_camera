package com.oppo.camera.a;

import com.oppo.camera.q.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ModelStorage */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, byte[]> f2750a = new HashMap();

    public static byte[] a(String str) {
        if (!f2750a.containsKey(str)) {
            f2750a.put(str, a.d("/odm/etc/camera/" + str));
        }
        return f2750a.get(str);
    }
}
