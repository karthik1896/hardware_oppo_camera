package com.heytap.epona;

import com.heytap.epona.e.a;

/* compiled from: ParcelableException */
final class g extends RuntimeException {
    private static final String TAG = "ParcelableException";

    private g(Throwable th) {
        super(th);
    }

    static g create(ExceptionInfo exceptionInfo) {
        String name = exceptionInfo.getName();
        String message = exceptionInfo.getMessage();
        try {
            Class<?> cls = Class.forName(name);
            if (Throwable.class.isAssignableFrom(cls)) {
                return new g((Throwable) cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{message}));
            }
        } catch (ReflectiveOperationException e) {
            a.b(TAG, e.toString(), new Object[0]);
        }
        return new g(new RuntimeException(name + ": " + message));
    }

    /* access modifiers changed from: package-private */
    public <T extends Throwable> void maybeRethrow(Class<T> cls) throws Throwable {
        if (cls.isAssignableFrom(getCause().getClass())) {
            throw getCause();
        }
    }
}
