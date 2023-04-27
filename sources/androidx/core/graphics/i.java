package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.core.content.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: TypefaceCompatApi26Impl */
public class i extends g {

    /* renamed from: a  reason: collision with root package name */
    protected final Class<?> f748a;

    /* renamed from: b  reason: collision with root package name */
    protected final Constructor<?> f749b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    public i() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> a2 = a();
            constructor = a(a2);
            method4 = b(a2);
            method3 = c(a2);
            method2 = d(a2);
            method = e(a2);
            Class<?> cls2 = a2;
            method5 = f(a2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f748a = cls;
        this.f749b = constructor;
        this.c = method4;
        this.d = method3;
        this.e = method2;
        this.f = method;
        this.g = method5;
    }

    private boolean b() {
        if (this.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    private Object c() {
        try {
            return this.f749b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, new Object[]{context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f748a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.g.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean b(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void c(Object obj) {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        if (!b()) {
            return super.a(context, bVar, resources, i);
        }
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        for (c.C0014c cVar : bVar.a()) {
            if (!a(context, c2, cVar.a(), cVar.e(), cVar.b(), cVar.c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                c(c2);
                return null;
            }
        }
        if (!b(c2)) {
            return null;
        }
        return a(c2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r10 = r14;
        r14 = r13;
        r13 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface a(android.content.Context r12, android.os.CancellationSignal r13, androidx.core.d.b.C0015b[] r14, int r15) {
        /*
            r11 = this;
            int r0 = r14.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L_0x0006
            return r2
        L_0x0006:
            boolean r0 = r11.b()
            if (r0 != 0) goto L_0x0064
            androidx.core.d.b$b r14 = r11.a((androidx.core.d.b.C0015b[]) r14, (int) r15)
            android.content.ContentResolver r12 = r12.getContentResolver()
            android.net.Uri r15 = r14.a()     // Catch:{ IOException -> 0x0063 }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r12 = r12.openFileDescriptor(r15, r0, r13)     // Catch:{ IOException -> 0x0063 }
            if (r12 != 0) goto L_0x0026
            if (r12 == 0) goto L_0x0025
            r12.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0025:
            return r2
        L_0x0026:
            android.graphics.Typeface$Builder r13 = new android.graphics.Typeface$Builder     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            java.io.FileDescriptor r15 = r12.getFileDescriptor()     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            r13.<init>(r15)     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            int r15 = r14.c()     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            android.graphics.Typeface$Builder r13 = r13.setWeight(r15)     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            boolean r14 = r14.d()     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            android.graphics.Typeface$Builder r13 = r13.setItalic(r14)     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            android.graphics.Typeface r13 = r13.build()     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            if (r12 == 0) goto L_0x0048
            r12.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0048:
            return r13
        L_0x0049:
            r13 = move-exception
            r14 = r2
            goto L_0x0052
        L_0x004c:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x004e }
        L_0x004e:
            r14 = move-exception
            r10 = r14
            r14 = r13
            r13 = r10
        L_0x0052:
            if (r12 == 0) goto L_0x0062
            if (r14 == 0) goto L_0x005f
            r12.close()     // Catch:{ Throwable -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r12 = move-exception
            r14.addSuppressed(r12)     // Catch:{ IOException -> 0x0063 }
            goto L_0x0062
        L_0x005f:
            r12.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0062:
            throw r13     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            return r2
        L_0x0064:
            java.util.Map r12 = androidx.core.d.b.a((android.content.Context) r12, (androidx.core.d.b.C0015b[]) r14, (android.os.CancellationSignal) r13)
            java.lang.Object r13 = r11.c()
            if (r13 != 0) goto L_0x006f
            return r2
        L_0x006f:
            int r0 = r14.length
            r3 = 0
            r9 = r3
        L_0x0072:
            if (r9 >= r0) goto L_0x009f
            r4 = r14[r9]
            android.net.Uri r5 = r4.a()
            java.lang.Object r5 = r12.get(r5)
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            if (r5 != 0) goto L_0x0083
            goto L_0x009c
        L_0x0083:
            int r6 = r4.b()
            int r7 = r4.c()
            boolean r8 = r4.d()
            r3 = r11
            r4 = r13
            boolean r3 = r3.a((java.lang.Object) r4, (java.nio.ByteBuffer) r5, (int) r6, (int) r7, (int) r8)
            if (r3 != 0) goto L_0x009b
            r11.c((java.lang.Object) r13)
            return r2
        L_0x009b:
            r3 = r1
        L_0x009c:
            int r9 = r9 + 1
            goto L_0x0072
        L_0x009f:
            if (r3 != 0) goto L_0x00a5
            r11.c((java.lang.Object) r13)
            return r2
        L_0x00a5:
            boolean r12 = r11.b((java.lang.Object) r13)
            if (r12 != 0) goto L_0x00ac
            return r2
        L_0x00ac:
            android.graphics.Typeface r12 = r11.a((java.lang.Object) r13)
            if (r12 != 0) goto L_0x00b3
            return r2
        L_0x00b3:
            android.graphics.Typeface r12 = android.graphics.Typeface.create(r12, r15)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.i.a(android.content.Context, android.os.CancellationSignal, androidx.core.d.b$b[], int):android.graphics.Typeface");
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        if (!a(context, c2, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            c(c2);
            return null;
        } else if (!b(c2)) {
            return null;
        } else {
            return a(c2);
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    public Constructor<?> a(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method b(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    public Method c(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    /* access modifiers changed from: protected */
    public Method d(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method e(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method f(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
