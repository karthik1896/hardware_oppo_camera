package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

public class RefBoolean {
    private static final String TAG = "RefBoolean";
    private Field mField;

    public RefBoolean(Class<?> cls, Field field) throws NoSuchFieldException {
        this.mField = cls.getDeclaredField(field.getName());
        this.mField.setAccessible(true);
    }

    public boolean get(Object obj) {
        try {
            return this.mField.getBoolean(obj);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public boolean getWithException(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.mField.getBoolean(obj);
    }

    public void set(Object obj, boolean z) {
        try {
            this.mField.setBoolean(obj, z);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
