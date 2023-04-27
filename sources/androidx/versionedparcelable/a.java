package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: VersionedParcel */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final ArrayMap<String, Method> f1342a;

    /* renamed from: b  reason: collision with root package name */
    protected final ArrayMap<String, Method> f1343b;
    protected final ArrayMap<String, Class> c;

    /* access modifiers changed from: protected */
    public abstract void a(int i);

    /* access modifiers changed from: protected */
    public abstract void a(Parcelable parcelable);

    /* access modifiers changed from: protected */
    public abstract void a(CharSequence charSequence);

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public abstract void a(boolean z);

    public void a(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr);

    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public abstract boolean b(int i);

    /* access modifiers changed from: protected */
    public abstract a c();

    /* access modifiers changed from: protected */
    public abstract void c(int i);

    /* access modifiers changed from: protected */
    public abstract int d();

    /* access modifiers changed from: protected */
    public abstract String e();

    /* access modifiers changed from: protected */
    public abstract byte[] f();

    /* access modifiers changed from: protected */
    public abstract CharSequence g();

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T h();

    /* access modifiers changed from: protected */
    public abstract boolean i();

    public a(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.f1342a = arrayMap;
        this.f1343b = arrayMap2;
        this.c = arrayMap3;
    }

    public void a(boolean z, int i) {
        c(i);
        a(z);
    }

    public void a(byte[] bArr, int i) {
        c(i);
        a(bArr);
    }

    public void a(CharSequence charSequence, int i) {
        c(i);
        a(charSequence);
    }

    public void a(int i, int i2) {
        c(i2);
        a(i);
    }

    public void a(String str, int i) {
        c(i);
        a(str);
    }

    public void a(Parcelable parcelable, int i) {
        c(i);
        a(parcelable);
    }

    public boolean b(boolean z, int i) {
        if (!b(i)) {
            return z;
        }
        return i();
    }

    public int b(int i, int i2) {
        if (!b(i2)) {
            return i;
        }
        return d();
    }

    public String b(String str, int i) {
        if (!b(i)) {
            return str;
        }
        return e();
    }

    public byte[] b(byte[] bArr, int i) {
        if (!b(i)) {
            return bArr;
        }
        return f();
    }

    public <T extends Parcelable> T b(T t, int i) {
        if (!b(i)) {
            return t;
        }
        return h();
    }

    public CharSequence b(CharSequence charSequence, int i) {
        if (!b(i)) {
            return charSequence;
        }
        return g();
    }

    public void a(c cVar, int i) {
        c(i);
        a(cVar);
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
        if (cVar == null) {
            a((String) null);
            return;
        }
        b(cVar);
        a c2 = c();
        a(cVar, c2);
        c2.b();
    }

    private void b(c cVar) {
        try {
            a(b((Class<? extends c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public <T extends c> T b(T t, int i) {
        if (!b(i)) {
            return t;
        }
        return j();
    }

    /* access modifiers changed from: protected */
    public <T extends c> T j() {
        String e = e();
        if (e == null) {
            return null;
        }
        return a(e, c());
    }

    /* access modifiers changed from: protected */
    public <T extends c> T a(String str, a aVar) {
        try {
            return (c) b(str).invoke((Object) null, new Object[]{aVar});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    /* access modifiers changed from: protected */
    public <T extends c> void a(T t, a aVar) {
        try {
            a((Class) t.getClass()).invoke((Object) null, new Object[]{t, aVar});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    private Method b(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f1342a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[]{a.class});
        this.f1342a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method a(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f1343b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class b2 = b((Class<? extends c>) cls);
        System.currentTimeMillis();
        Method declaredMethod = b2.getDeclaredMethod("write", new Class[]{cls, a.class});
        this.f1343b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private Class b(Class<? extends c> cls) throws ClassNotFoundException {
        Class cls2 = this.c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.c.put(cls.getName(), cls3);
        return cls3;
    }
}
