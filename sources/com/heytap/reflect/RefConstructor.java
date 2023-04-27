package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class RefConstructor<T> {
    private static final String TAG = "RefConstructor";
    private Constructor<?> mConstructor;

    public RefConstructor(Class<?> cls, Field field) throws NoSuchMethodException {
        if (field.isAnnotationPresent(MethodName.class)) {
            this.mConstructor = cls.getDeclaredConstructor(((MethodName) field.getAnnotation(MethodName.class)).params());
        } else {
            int i = 0;
            if (field.isAnnotationPresent(MethodSignature.class)) {
                String[] params = ((MethodSignature) field.getAnnotation(MethodSignature.class)).params();
                Class[] clsArr = new Class[params.length];
                while (i < params.length) {
                    try {
                        clsArr[i] = Class.forName(params[i]);
                        i++;
                    } catch (Exception e) {
                        Log.e(TAG, e.toString());
                    }
                }
                this.mConstructor = cls.getDeclaredConstructor(clsArr);
            } else {
                this.mConstructor = cls.getDeclaredConstructor(new Class[0]);
            }
        }
        Constructor<?> constructor = this.mConstructor;
        if (constructor != null && !constructor.isAccessible()) {
            this.mConstructor.setAccessible(true);
        }
    }

    public T newInstance() {
        try {
            return this.mConstructor.newInstance(new Object[0]);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public T newInstance(Object... objArr) {
        try {
            return this.mConstructor.newInstance(objArr);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }
}
