package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

public class RefInt {
    private static final String TAG = "RefInt";
    private Field mField;

    public RefInt(Class cls, Field field) throws NoSuchFieldException {
        this.mField = cls.getDeclaredField(field.getName());
        this.mField.setAccessible(true);
    }

    public int get(Object obj) {
        try {
            return this.mField.getInt(obj);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return 0;
        }
    }

    public int getWithException(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.mField.getInt(obj);
    }

    public void set(Object obj, int i) {
        try {
            this.mField.setInt(obj, i);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
