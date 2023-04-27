package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.a.c;
import androidx.core.d.b;
import com.sensetime.stmobile.sticker_module_types.STStickerMakeupParamType;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TypefaceCompatBaseImpl */
class l {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, c.b> f750a = new ConcurrentHashMap<>();

    /* compiled from: TypefaceCompatBaseImpl */
    private interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    l() {
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : STStickerMakeupParamType.ST_STICKER_PARAM_MAKEUP_FLOAT_SCALE;
        boolean z = (i & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        T t = null;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.b(t2) - i2) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    private static long b(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0;
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public b.C0015b a(b.C0015b[] bVarArr, int i) {
        return (b.C0015b) a(bVarArr, i, new a<b.C0015b>() {
            /* renamed from: a */
            public int b(b.C0015b bVar) {
                return bVar.c();
            }

            /* renamed from: b */
            public boolean a(b.C0015b bVar) {
                return bVar.d();
            }
        });
    }

    /* access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = m.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!m.a(a2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0015b[] bVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(bVarArr, i).a());
            try {
                Typeface a2 = a(context, inputStream);
                m.a((Closeable) inputStream);
                return a2;
            } catch (IOException unused) {
                m.a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                m.a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            m.a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            m.a((Closeable) inputStream2);
            throw th;
        }
    }

    private c.C0014c a(c.b bVar, int i) {
        return (c.C0014c) a(bVar.a(), i, new a<c.C0014c>() {
            /* renamed from: a */
            public int b(c.C0014c cVar) {
                return cVar.b();
            }

            /* renamed from: b */
            public boolean a(c.C0014c cVar) {
                return cVar.c();
            }
        });
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0014c a2 = a(bVar, i);
        if (a2 == null) {
            return null;
        }
        Typeface a3 = f.a(context, resources, a2.f(), a2.a(), i);
        a(a3, bVar);
        return a3;
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a2 = m.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!m.a(a2, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    /* access modifiers changed from: package-private */
    public c.b a(Typeface typeface) {
        long b2 = b(typeface);
        if (b2 == 0) {
            return null;
        }
        return this.f750a.get(Long.valueOf(b2));
    }

    private void a(Typeface typeface, c.b bVar) {
        long b2 = b(typeface);
        if (b2 != 0) {
            this.f750a.put(Long.valueOf(b2), bVar);
        }
    }
}
