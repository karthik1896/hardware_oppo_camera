package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class UnsafeUtil {
    private static final long ARRAY_BASE_OFFSET = ((long) byteArrayBaseOffset());
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(field(Buffer.class, "address"));
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final Unsafe UNSAFE = getUnsafe();

    private UnsafeUtil() {
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static Object allocateInstance(Class<?> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    static long getArrayBaseOffset() {
        return ARRAY_BASE_OFFSET;
    }

    static byte getByte(Object obj, long j) {
        return UNSAFE.getByte(obj, j);
    }

    static void putByte(Object obj, long j, byte b2) {
        UNSAFE.putByte(obj, j, b2);
    }

    static int getInt(Object obj, long j) {
        return UNSAFE.getInt(obj, j);
    }

    static void putInt(Object obj, long j, int i) {
        UNSAFE.putInt(obj, j, i);
    }

    static long getLong(Object obj, long j) {
        return UNSAFE.getLong(obj, j);
    }

    static void putLong(Object obj, long j, long j2) {
        UNSAFE.putLong(obj, j, j2);
    }

    static boolean getBoolean(Object obj, long j) {
        return UNSAFE.getBoolean(obj, j);
    }

    static void putBoolean(Object obj, long j, boolean z) {
        UNSAFE.putBoolean(obj, j, z);
    }

    static float getFloat(Object obj, long j) {
        return UNSAFE.getFloat(obj, j);
    }

    static void putFloat(Object obj, long j, float f) {
        UNSAFE.putFloat(obj, j, f);
    }

    static double getDouble(Object obj, long j) {
        return UNSAFE.getDouble(obj, j);
    }

    static void putDouble(Object obj, long j, double d) {
        UNSAFE.putDouble(obj, j, d);
    }

    static Object getObject(Object obj, long j) {
        return UNSAFE.getObject(obj, j);
    }

    static void putObject(Object obj, long j, Object obj2) {
        UNSAFE.putObject(obj, j, obj2);
    }

    static void copyMemory(Object obj, long j, Object obj2, long j2, long j3) {
        UNSAFE.copyMemory(obj, j, obj2, j2, j3);
    }

    static byte getByte(long j) {
        return UNSAFE.getByte(j);
    }

    static void putByte(long j, byte b2) {
        UNSAFE.putByte(j, b2);
    }

    static int getInt(long j) {
        return UNSAFE.getInt(j);
    }

    static void putInt(long j, int i) {
        UNSAFE.putInt(j, i);
    }

    static long getLong(long j) {
        return UNSAFE.getLong(j);
    }

    static void putLong(long j, long j2) {
        UNSAFE.putLong(j, j2);
    }

    static void copyMemory(long j, long j2, long j3) {
        UNSAFE.copyMemory(j, j2, j3);
    }

    static void setMemory(long j, long j2, byte b2) {
        UNSAFE.setMemory(j, j2, b2);
    }

    static long addressOffset(ByteBuffer byteBuffer) {
        return UNSAFE.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    private static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean supportsUnsafeArrayOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("allocateInstance", new Class[]{Class.class});
                cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
                cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
                cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
                cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
                cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
                cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
                cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("getByte", new Class[]{Long.TYPE});
                cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
                cls.getMethod("getInt", new Class[]{Long.TYPE});
                cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
                cls.getMethod("getLong", new Class[]{Long.TYPE});
                cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
                cls.getMethod("setMemory", new Class[]{Long.TYPE, Long.TYPE, Byte.TYPE});
                cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static int byteArrayBaseOffset() {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return UNSAFE.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static long fieldOffset(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = UNSAFE) == null) {
            return -1;
        }
        return unsafe.objectFieldOffset(field);
    }

    private static Field field(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }
}
