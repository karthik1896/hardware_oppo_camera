package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

public class RefDouble {
    private static final String TAG = "RefDouble";
    private Field mField;

    public RefDouble(Class cls, Field field) throws NoSuchFieldException {
        this.mField = cls.getDeclaredField(field.getName());
        this.mField.setAccessible(true);
    }

    public double get(Object obj) {
        try {
            return this.mField.getDouble(obj);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return 0.0d;
        }
    }

    public double getWithException(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.mField.getDouble(obj);
    }

    public void set(Object obj, double d) {
        try {
            this.mField.setDouble(obj, d);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
