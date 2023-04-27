package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.a.c;
import androidx.core.content.a.f;
import androidx.core.d.b;

@SuppressLint({"NewApi"})
/* compiled from: TypefaceCompat */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final l f742a;

    /* renamed from: b  reason: collision with root package name */
    private static final LruCache<String, Typeface> f743b = new LruCache<>(16);

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f742a = new k();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f742a = new j();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f742a = new i();
        } else if (Build.VERSION.SDK_INT >= 24 && h.a()) {
            f742a = new h();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f742a = new g();
        } else {
            f742a = new l();
        }
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return f743b.get(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.b() == 0) {
                z2 = true;
            }
            typeface = b.a(context, dVar.a(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typeface = f742a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.callbackSuccessAsync(typeface, handler);
                } else {
                    aVar2.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f743b.put(b(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = f742a.a(context, resources, i, str, i2);
        if (a2 != null) {
            f743b.put(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0015b[] bVarArr, int i) {
        return f742a.a(context, cancellationSignal, bVarArr, i);
    }

    private static Typeface b(Context context, Typeface typeface, int i) {
        c.b a2 = f742a.a(typeface);
        if (a2 == null) {
            return null;
        }
        return f742a.a(context, a2, context.getResources(), i);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        Typeface b2;
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (Build.VERSION.SDK_INT >= 21 || (b2 = b(context, typeface, i)) == null) {
            return Typeface.create(typeface, i);
        } else {
            return b2;
        }
    }
}
