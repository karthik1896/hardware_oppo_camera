package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

public class RefStaticInt {
    private static final String TAG = "RefStaticInt";
    private Field mField;

    public RefStaticInt(Class<?> cls, Field field) throws NoSuchFieldException {
        this.mField = cls.getDeclaredField(field.getName());
        this.mField.setAccessible(true);
    }

    public int get() {
        try {
            return this.mField.getInt((Object) null);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return 0;
        }
    }

    public int getWithException() throws IllegalAccessException, IllegalArgumentException {
        return this.mField.getInt((Object) null);
    }

    public void set(int i) {
        try {
            this.mField.setInt((Object) null, i);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
