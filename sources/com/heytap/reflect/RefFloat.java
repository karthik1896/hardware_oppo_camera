package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

public class RefFloat {
    private static final String TAG = "RefFloat";
    private Field mField;

    public RefFloat(Class cls, Field field) throws NoSuchFieldException {
        this.mField = cls.getDeclaredField(field.getName());
        this.mField.setAccessible(true);
    }

    public float get(Object obj) {
        try {
            return this.mField.getFloat(obj);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return 0.0f;
        }
    }

    public float getWithException(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.mField.getFloat(obj);
    }

    public void set(Object obj, float f) {
        try {
            this.mField.setFloat(obj, f);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
