package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefMethod<T> {
    private static final String TAG = "RefMethod";
    private Method mMethod;

    public RefMethod(Class<?> cls, Field field) throws NoSuchMethodException {
        if (!field.isAnnotationPresent(MethodName.class)) {
            int i = 0;
            if (!field.isAnnotationPresent(MethodSignature.class)) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Method method = declaredMethods[i];
                    if (method.getName().equals(field.getName())) {
                        this.mMethod = method;
                        this.mMethod.setAccessible(true);
                        break;
                    }
                    i++;
                }
            } else {
                String[] params = ((MethodSignature) field.getAnnotation(MethodSignature.class)).params();
                Class[] clsArr = new Class[params.length];
                while (i < params.length) {
                    Class<?> protoType = RefStaticMethod.getProtoType(params[i]);
                    if (protoType == null) {
                        try {
                            protoType = Class.forName(params[i]);
                        } catch (ClassNotFoundException e) {
                            Log.e(TAG, e.toString());
                        }
                    }
                    clsArr[i] = protoType;
                    i++;
                }
                setMethod(cls, field, clsArr, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                this.mMethod.setAccessible(true);
            }
        } else {
            setMethod(cls, field, ((MethodName) field.getAnnotation(MethodName.class)).params(), ((MethodName) field.getAnnotation(MethodName.class)).name());
            this.mMethod.setAccessible(true);
        }
        if (this.mMethod == null) {
            throw new NoSuchMethodException(field.getName());
        }
    }

    private void setMethod(Class<?> cls, Field field, Class<?>[] clsArr, String str) throws NoSuchMethodException {
        if (!str.isEmpty()) {
            this.mMethod = cls.getDeclaredMethod(str, clsArr);
        } else {
            this.mMethod = cls.getDeclaredMethod(field.getName(), clsArr);
        }
    }

    public T call(Object obj, Object... objArr) {
        try {
            return this.mMethod.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            if (e.getCause() != null) {
                Log.e(TAG, e.getCause().toString());
                return null;
            }
            Log.e(TAG, e.toString());
            return null;
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return null;
        }
    }

    public T callWithException(Object obj, Object... objArr) throws Throwable {
        try {
            return this.mMethod.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            if (e.getCause() != null) {
                throw e.getCause();
            }
            throw e;
        }
    }

    public Class<?>[] paramList() {
        return this.mMethod.getParameterTypes();
    }
}
