package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public final class RefClass {
    private static HashMap<Class<?>, Constructor<?>> REF_TYPES = new HashMap<>();
    private static final String TAG = "RefClass";

    static {
        try {
            REF_TYPES.put(RefObject.class, RefObject.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefMethod.class, RefMethod.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefInt.class, RefInt.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefLong.class, RefLong.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefFloat.class, RefFloat.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefDouble.class, RefDouble.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefBoolean.class, RefBoolean.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefStaticObject.class, RefStaticObject.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefStaticInt.class, RefStaticInt.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefStaticMethod.class, RefStaticMethod.class.getConstructor(new Class[]{Class.class, Field.class}));
            REF_TYPES.put(RefConstructor.class, RefConstructor.class.getConstructor(new Class[]{Class.class, Field.class}));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public static Class<?> load(Class<?> cls, String str) {
        try {
            return load((Class) cls, Class.forName(str));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public static Class load(Class cls, Class<?> cls2) {
        Constructor constructor;
        for (Field field : cls.getDeclaredFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && (constructor = REF_TYPES.get(field.getType())) != null) {
                    field.setAccessible(true);
                    field.set((Object) null, constructor.newInstance(new Object[]{cls2, field}));
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
        return cls2;
    }
}
