package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

public class RefLong {
    private static final String TAG = "RefLong";
    private Field mField;

    public RefLong(Class cls, Field field) throws NoSuchFieldException {
        this.mField = cls.getDeclaredField(field.getName());
        this.mField.setAccessible(true);
    }

    public long get(Object obj) {
        try {
            return this.mField.getLong(obj);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return 0;
        }
    }

    public long getWithException(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.mField.getLong(obj);
    }

    public void set(Object obj, long j) {
        try {
            this.mField.setLong(obj, j);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
