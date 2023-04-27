package com.heytap.epona.c;

import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: ProviderInfo */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f2588a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, b> f2589b;
    private Map<String, Method> c;

    public Method a(String str) {
        Method method = this.c.get(str);
        if (method != null) {
            return method;
        }
        b bVar = this.f2589b.get(str);
        try {
            Method declaredMethod = Class.forName(this.f2588a).getDeclaredMethod(bVar.a(), a(bVar.b()));
            this.c.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    private Class<?>[] a(String[] strArr) throws ClassNotFoundException {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        Class<?>[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = Class.forName(strArr[i]);
        }
        return clsArr;
    }
}
