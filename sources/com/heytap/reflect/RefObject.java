package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

public class RefObject<T> {
    private static final String TAG = "RefObject";
    private Field mField;

    public RefObject(Class<?> cls, Field field) throws NoSuchFieldException {
        this.mField = cls.getDeclaredField(field.getName());
        this.mField.setAccessible(true);
    }

    public T get(Object obj) {
        try {
            return this.mField.get(obj);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public T getWithException(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.mField.get(obj);
    }

    public void set(Object obj, T t) {
        try {
            this.mField.set(obj, t);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
