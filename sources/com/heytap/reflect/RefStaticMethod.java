package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefStaticMethod<T> {
    private static final String TAG = "RefStaticMethod";
    private Method mMethod;

    public RefStaticMethod(Class<?> cls, Field field) throws NoSuchMethodException {
        Class<?> cls2;
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
                Class[] clsArr2 = new Class[params.length];
                boolean z = false;
                while (i < params.length) {
                    Class<?> protoType = getProtoType(params[i]);
                    if (protoType == null) {
                        try {
                            protoType = Class.forName(params[i]);
                        } catch (ClassNotFoundException e) {
                            Log.e(TAG, e.toString());
                        }
                    }
                    clsArr[i] = protoType;
                    if ("java.util.HashSet".equals(params[i])) {
                        try {
                            cls2 = Class.forName("android.util.ArraySet");
                        } catch (ClassNotFoundException e2) {
                            Log.e(TAG, e2.toString());
                            cls2 = protoType;
                        }
                        if (cls2 != null) {
                            clsArr2[i] = cls2;
                        } else {
                            clsArr2[i] = protoType;
                        }
                        z = true;
                    } else {
                        clsArr2[i] = protoType;
                    }
                    i++;
                }
                try {
                    setMethod(cls, field, clsArr, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                } catch (Exception e3) {
                    Log.e(TAG, e3.toString());
                    if (z) {
                        setMethod(cls, field, clsArr2, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                    }
                }
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

    static Class<?> getProtoType(String str) {
        if (str.equals("int")) {
            return Integer.TYPE;
        }
        if (str.equals("long")) {
            return Long.TYPE;
        }
        if (str.equals("boolean")) {
            return Boolean.TYPE;
        }
        if (str.equals("byte")) {
            return Byte.TYPE;
        }
        if (str.equals("short")) {
            return Short.TYPE;
        }
        if (str.equals("char")) {
            return Character.TYPE;
        }
        if (str.equals("float")) {
            return Float.TYPE;
        }
        if (str.equals("double")) {
            return Double.TYPE;
        }
        if (str.equals("void")) {
            return Void.TYPE;
        }
        return null;
    }

    public T call(Object... objArr) {
        try {
            return this.mMethod.invoke((Object) null, objArr);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public T callWithException(Object... objArr) throws Throwable {
        try {
            return this.mMethod.invoke((Object) null, objArr);
        } catch (InvocationTargetException e) {
            if (e.getCause() != null) {
                throw e.getCause();
            }
            throw e;
        }
    }
}
