package color.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.collection.LruCache;
import color.support.v7.appcompat.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: TintManager */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1549a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b  reason: collision with root package name */
    private static final PorterDuff.Mode f1550b = PorterDuff.Mode.SRC_IN;
    private static final WeakHashMap<Context, f> c = new WeakHashMap<>();
    private static final a d = new a(6);
    private final WeakReference<Context> e;
    private SparseArray<ColorStateList> f;

    /* access modifiers changed from: package-private */
    public final PorterDuff.Mode b(int i) {
        return null;
    }

    public static f a(Context context) {
        f fVar = c.get(context);
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(context);
        c.put(context, fVar2);
        return fVar2;
    }

    private f(Context context) {
        this.e = new WeakReference<>(context);
    }

    public Drawable a(int i) {
        return a(i, false);
    }

    public Drawable a(int i, boolean z) {
        Context context = (Context) this.e.get();
        Drawable drawable = null;
        if (context == null) {
            return null;
        }
        Drawable a2 = androidx.core.content.a.a(context, i);
        if (a2 == null) {
            return a2;
        }
        if (Build.VERSION.SDK_INT >= 8) {
            a2 = a2.mutate();
        }
        ColorStateList c2 = c(i);
        if (c2 != null) {
            drawable = androidx.core.graphics.drawable.a.g(a2);
            androidx.core.graphics.drawable.a.a(drawable, c2);
            PorterDuff.Mode b2 = b(i);
            if (b2 != null) {
                androidx.core.graphics.drawable.a.a(drawable, b2);
            }
        } else if (a(i, a2) || !z) {
            return a2;
        }
        return drawable;
    }

    public final boolean a(int i, Drawable drawable) {
        if (((Context) this.e.get()) == null) {
        }
        return false;
    }

    public final ColorStateList c(int i) {
        Context context = (Context) this.e.get();
        ColorStateList colorStateList = null;
        if (context == null) {
            return null;
        }
        SparseArray<ColorStateList> sparseArray = this.f;
        if (sparseArray != null) {
            colorStateList = sparseArray.get(i);
        }
        if (colorStateList == null) {
            if (i == R.drawable.color_back_arrow_normal) {
                colorStateList = b(context);
            }
            if (colorStateList != null) {
                if (this.f == null) {
                    this.f = new SparseArray<>();
                }
                this.f.append(i, colorStateList);
            }
        }
        return colorStateList;
    }

    private ColorStateList b(Context context) {
        return new ColorStateList(new int[][]{e.f1547a, e.d, e.g}, new int[]{e.c(context, R.attr.colorTintControlDisabled), e.a(context, R.attr.colorTintControlPressed), e.a(context, R.attr.colorTintControlNormal)});
    }

    /* compiled from: TintManager */
    private static class a extends LruCache<Integer, PorterDuffColorFilter> {
        public a(int i) {
            super(i);
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    private static void a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (mode == null) {
            mode = f1550b;
        }
        PorterDuffColorFilter a2 = d.a(i, mode);
        if (a2 == null) {
            a2 = new PorterDuffColorFilter(i, mode);
            d.a(i, mode, a2);
        }
        drawable.setColorFilter(a2);
    }
}
