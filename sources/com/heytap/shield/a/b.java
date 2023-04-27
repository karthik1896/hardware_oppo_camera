package com.heytap.shield.a;

import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: SystemServiceMap */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, String> f2627a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private String f2628b;

    b(String str) {
        this.f2628b = str;
        a();
    }

    private void a() {
        try {
            Class<?> cls = Class.forName(this.f2628b + "$Stub");
            for (Field field : cls.getDeclaredFields()) {
                if (field.getName().startsWith("TRANSACTION_")) {
                    field.setAccessible(true);
                    this.f2627a.put(Integer.valueOf(field.getInt(cls)), field.getName().replaceFirst("TRANSACTION_", ""));
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
