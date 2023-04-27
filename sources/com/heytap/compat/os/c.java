package com.heytap.compat.os;

import android.os.Trace;
import com.heytap.compat.d.a.b;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefMethod;

/* compiled from: TraceNative */
public class c {

    /* compiled from: TraceNative */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Class<?> f2575a = RefClass.load(a.class, (Class<?>) Trace.class);
        public static RefMethod<Void> traceBegin;
        public static RefMethod<Void> traceEnd;

        private a() {
        }
    }

    public static void a(long j, String str) throws com.heytap.compat.d.a.a {
        if (b.b()) {
            a.traceBegin.call((Object) null, Long.valueOf(j), str);
            return;
        }
        throw new com.heytap.compat.d.a.a("not supported before Q");
    }

    public static void a(long j) throws com.heytap.compat.d.a.a {
        if (b.b()) {
            a.traceEnd.call((Object) null, Long.valueOf(j));
            return;
        }
        throw new com.heytap.compat.d.a.a("not supported before Q");
    }
}
