package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.resources.R;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SparseArrayCompat;
import androidx.vectordrawable.a.a.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: ResourceManagerInternal */
public final class ah {

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuff.Mode f395a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static ah f396b;
    private static final c c = new c(6);
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> d;
    private ArrayMap<String, d> e;
    private SparseArrayCompat<String> f;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> g = new WeakHashMap<>(0);
    private TypedValue h;
    private boolean i;
    private e j;

    /* compiled from: ResourceManagerInternal */
    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal */
    interface e {
        ColorStateList a(Context context, int i);

        PorterDuff.Mode a(int i);

        Drawable a(ah ahVar, Context context, int i);

        boolean a(Context context, int i, Drawable drawable);

        boolean b(Context context, int i, Drawable drawable);
    }

    public static synchronized ah a() {
        ah ahVar;
        synchronized (ah.class) {
            if (f396b == null) {
                f396b = new ah();
                a(f396b);
            }
            ahVar = f396b;
        }
        return ahVar;
    }

    private static void a(ah ahVar) {
        if (Build.VERSION.SDK_INT < 24) {
            ahVar.a("vector", (d) new f());
            ahVar.a("animated-vector", (d) new b());
            ahVar.a("animated-selector", (d) new a());
        }
    }

    public synchronized void a(e eVar) {
        this.j = eVar;
    }

    public synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable d2;
        b(context);
        d2 = d(context, i2);
        if (d2 == null) {
            d2 = c(context, i2);
        }
        if (d2 == null) {
            d2 = androidx.core.content.a.a(context, i2);
        }
        if (d2 != null) {
            d2 = a(context, i2, z, d2);
        }
        if (d2 != null) {
            aa.b(d2);
        }
        return d2;
    }

    public synchronized void a(Context context) {
        LongSparseArray longSparseArray = this.g.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable c(Context context, int i2) {
        Drawable drawable;
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue typedValue = this.h;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        e eVar = this.j;
        if (eVar == null) {
            drawable = null;
        } else {
            drawable = eVar.a(this, context, i2);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, drawable);
        }
        return drawable;
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (aa.c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable g2 = androidx.core.graphics.drawable.a.g(drawable);
            androidx.core.graphics.drawable.a.a(g2, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 == null) {
                return g2;
            }
            androidx.core.graphics.drawable.a.a(g2, a2);
            return g2;
        }
        e eVar = this.j;
        if ((eVar == null || !eVar.a(context, i2, drawable)) && !a(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c A[Catch:{ Exception -> 0x00a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable d(android.content.Context r11, int r12) {
        /*
            r10 = this;
            androidx.collection.ArrayMap<java.lang.String, androidx.appcompat.widget.ah$d> r0 = r10.e
            r1 = 0
            if (r0 == 0) goto L_0x00b4
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b4
            androidx.collection.SparseArrayCompat<java.lang.String> r0 = r10.f
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.ArrayMap<java.lang.String, androidx.appcompat.widget.ah$d> r3 = r10.e
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.f = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.h
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.h = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.h
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = a((android.util.TypedValue) r0)
            android.graphics.drawable.Drawable r6 = r10.a((android.content.Context) r11, (long) r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00ac
            java.lang.CharSequence r7 = r0.string
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00ac
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a4 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a4 }
        L_0x0069:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a4 }
            r9 = 2
            if (r8 == r9) goto L_0x0073
            if (r8 == r3) goto L_0x0073
            goto L_0x0069
        L_0x0073:
            if (r8 != r9) goto L_0x009c
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a4 }
            androidx.collection.SparseArrayCompat<java.lang.String> r8 = r10.f     // Catch:{ Exception -> 0x00a4 }
            r8.append(r12, r3)     // Catch:{ Exception -> 0x00a4 }
            androidx.collection.ArrayMap<java.lang.String, androidx.appcompat.widget.ah$d> r8 = r10.e     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a4 }
            androidx.appcompat.widget.ah$d r3 = (androidx.appcompat.widget.ah.d) r3     // Catch:{ Exception -> 0x00a4 }
            if (r3 == 0) goto L_0x0091
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a4 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a4 }
            r6 = r1
        L_0x0091:
            if (r6 == 0) goto L_0x00ac
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a4 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a4 }
            r10.a((android.content.Context) r11, (long) r4, (android.graphics.drawable.Drawable) r6)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00ac
        L_0x009c:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a4 }
            throw r11     // Catch:{ Exception -> 0x00a4 }
        L_0x00a4:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00ac:
            if (r6 != 0) goto L_0x00b3
            androidx.collection.SparseArrayCompat<java.lang.String> r11 = r10.f
            r11.append(r12, r2)
        L_0x00b3:
            return r6
        L_0x00b4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ah.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable a(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.g     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.get(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.delete(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ah.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray longSparseArray = this.g.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray();
            this.g.put(context, longSparseArray);
        }
        longSparseArray.put(j2, new WeakReference(constantState));
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, aw awVar, int i2) {
        Drawable d2 = d(context, i2);
        if (d2 == null) {
            d2 = awVar.a(i2);
        }
        if (d2 == null) {
            return null;
        }
        return a(context, i2, false, d2);
    }

    /* access modifiers changed from: package-private */
    public boolean a(Context context, int i2, Drawable drawable) {
        e eVar = this.j;
        return eVar != null && eVar.b(context, i2, drawable);
    }

    private void a(String str, d dVar) {
        if (this.e == null) {
            this.e = new ArrayMap<>();
        }
        this.e.put(str, dVar);
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode a(int i2) {
        e eVar = this.j;
        if (eVar == null) {
            return null;
        }
        return eVar.a(i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i2) {
        ColorStateList e2;
        e2 = e(context, i2);
        if (e2 == null) {
            e2 = this.j == null ? null : this.j.a(context, i2);
            if (e2 != null) {
                a(context, i2, e2);
            }
        }
        return e2;
    }

    private ColorStateList e(Context context, int i2) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.d;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.get(i2);
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.d == null) {
            this.d = new WeakHashMap<>();
        }
        SparseArrayCompat sparseArrayCompat = this.d.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.d.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i2, colorStateList);
    }

    /* compiled from: ResourceManagerInternal */
    private static class c extends LruCache<Integer, PorterDuffColorFilter> {
        public c(int i) {
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

    static void a(Drawable drawable, ap apVar, int[] iArr) {
        if (!aa.c(drawable) || drawable.mutate() == drawable) {
            if (apVar.d || apVar.c) {
                drawable.setColorFilter(a(apVar.d ? apVar.f414a : null, apVar.c ? apVar.f415b : f395a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (ah.class) {
            a2 = c.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                c.a(i2, mode, a2);
            }
        }
        return a2;
    }

    private void b(Context context) {
        if (!this.i) {
            this.i = true;
            Drawable a2 = a(context, R.drawable.abc_vector_test);
            if (a2 == null || !a(a2)) {
                this.i = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* compiled from: ResourceManagerInternal */
    private static class f implements d {
        f() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal */
    private static class b implements d {
        b() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal */
    static class a implements d {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.appcompat.b.a.a.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }
}
