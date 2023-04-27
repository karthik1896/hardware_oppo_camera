package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.a.c;
import androidx.core.d.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl */
class h extends l {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f746a;

    /* renamed from: b  reason: collision with root package name */
    private static final Constructor<?> f747b;
    private static final Method c;
    private static final Method d;

    h() {
    }

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = null;
            method = null;
        }
        f747b = constructor;
        f746a = cls;
        c = method;
        d = method2;
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static Object b() {
        try {
            return f747b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f746a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0015b[] bVarArr, int i) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (b.C0015b bVar : bVarArr) {
            Uri a2 = bVar.a();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(a2);
            if (byteBuffer == null) {
                byteBuffer = m.a(context, cancellationSignal, a2);
                simpleArrayMap.put(a2, byteBuffer);
            }
            if (byteBuffer == null || !a(b2, byteBuffer, bVar.b(), bVar.c(), bVar.d())) {
                return null;
            }
        }
        Typeface a3 = a(b2);
        if (a3 == null) {
            return null;
        }
        return Typeface.create(a3, i);
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (c.C0014c cVar : bVar.a()) {
            ByteBuffer a2 = m.a(context, resources, cVar.f());
            if (a2 == null || !a(b2, a2, cVar.e(), cVar.b(), cVar.c())) {
                return null;
            }
        }
        return a(b2);
    }
}
