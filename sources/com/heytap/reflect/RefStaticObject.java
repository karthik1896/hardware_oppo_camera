package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

public class RefStaticObject<T> {
    private static final String TAG = "RefStaticObject";
    private Field mField;

    public RefStaticObject(Class<?> cls, Field field) throws NoSuchFieldException {
        this.mField = cls.getDeclaredField(field.getName());
        this.mField.setAccessible(true);
    }

    public Class<?> type() {
        return this.mField.getType();
    }

    public T get() {
        try {
            return this.mField.get((Object) null);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public T getWithException() throws IllegalAccessException, IllegalArgumentException {
        return this.mField.get((Object) null);
    }

    public void set(T t) {
        try {
            this.mField.set((Object) null, t);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
