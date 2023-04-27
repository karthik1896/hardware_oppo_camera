package androidx.vectordrawable.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.graphics.e;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat */
public class i extends h {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f1331a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private g f1332b;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    i() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f1332b = new g();
    }

    i(g gVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f1332b = gVar;
        this.d = a(this.d, gVar.c, gVar.d);
    }

    public Drawable mutate() {
        if (this.c != null) {
            this.c.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.f1332b = new g(this.f1332b);
            this.f = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f1332b.f1340b.k.get(str);
    }

    public Drawable.ConstantState getConstantState() {
        if (this.c != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.c.getConstantState());
        }
        this.f1332b.f1339a = getChangingConfigurations();
        return this.f1332b;
    }

    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.e;
            if (colorFilter == null) {
                colorFilter = this.d;
            }
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float abs = Math.abs(this.i[0]);
            float abs2 = Math.abs(this.i[4]);
            float abs3 = Math.abs(this.i[1]);
            float abs4 = Math.abs(this.i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.k.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.k.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate((float) this.k.left, (float) this.k.top);
                if (a()) {
                    canvas.translate((float) this.k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.f1332b.b(min, min2);
                if (!this.g) {
                    this.f1332b.a(min, min2);
                } else if (!this.f1332b.b()) {
                    this.f1332b.a(min, min2);
                    this.f1332b.c();
                }
                this.f1332b.a(canvas, colorFilter, this.k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.c != null) {
            return androidx.core.graphics.drawable.a.c(this.c);
        }
        return this.f1332b.f1340b.getRootAlpha();
    }

    public void setAlpha(int i2) {
        if (this.c != null) {
            this.c.setAlpha(i2);
        } else if (this.f1332b.f1340b.getRootAlpha() != i2) {
            this.f1332b.f1340b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.c != null) {
            this.c.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        if (this.c != null) {
            return androidx.core.graphics.drawable.a.e(this.c);
        }
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i2) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, colorStateList);
            return;
        }
        g gVar = this.f1332b;
        if (gVar.c != colorStateList) {
            gVar.c = colorStateList;
            this.d = a(this.d, colorStateList, gVar.d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, mode);
            return;
        }
        g gVar = this.f1332b;
        if (gVar.d != mode) {
            gVar.d = mode;
            this.d = a(this.d, gVar.c, mode);
            invalidateSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = r1.f1332b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.c
            if (r0 == 0) goto L_0x000b
            android.graphics.drawable.Drawable r0 = r1.c
            boolean r0 = r0.isStateful()
            return r0
        L_0x000b:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x002e
            androidx.vectordrawable.a.a.i$g r0 = r1.f1332b
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x002e
            androidx.vectordrawable.a.a.i$g r0 = r1.f1332b
            android.content.res.ColorStateList r0 = r0.c
            if (r0 == 0) goto L_0x002c
            androidx.vectordrawable.a.a.i$g r0 = r1.f1332b
            android.content.res.ColorStateList r0 = r0.c
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a.a.i.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.c != null) {
            return this.c.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f1332b;
        if (!(gVar.c == null || gVar.d == null)) {
            this.d = a(this.d, gVar.c, gVar.d);
            invalidateSelf();
            z = true;
        }
        if (!gVar.d() || !gVar.a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.c != null) {
            return this.c.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.c != null) {
            return this.c.getIntrinsicWidth();
        }
        return (int) this.f1332b.f1340b.d;
    }

    public int getIntrinsicHeight() {
        if (this.c != null) {
            return this.c.getIntrinsicHeight();
        }
        return (int) this.f1332b.f1340b.e;
    }

    public boolean canApplyTheme() {
        if (this.c == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.d(this.c);
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.c != null) {
            return androidx.core.graphics.drawable.a.b(this.c);
        }
        return this.f1332b.e;
    }

    public void setAutoMirrored(boolean z) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, z);
        } else {
            this.f1332b.e = z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.a.a.i a(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.vectordrawable.a.a.i r0 = new androidx.vectordrawable.a.a.i
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.a.f.a(r6, r7, r8)
            r0.c = r6
            androidx.vectordrawable.a.a.i$h r6 = new androidx.vectordrawable.a.a.i$h
            android.graphics.drawable.Drawable r7 = r0.c
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.h = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            androidx.vectordrawable.a.a.i r6 = a(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a.a.i.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.a.a.i");
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.c != null) {
            this.c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f1332b;
        gVar.f1340b = new f();
        TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.f1319a);
        a(a2, xmlPullParser, theme);
        a2.recycle();
        gVar.f1339a = getChangingConfigurations();
        gVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.d = a(this.d, gVar.c, gVar.d);
    }

    private static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        g gVar = this.f1332b;
        f fVar = gVar.f1340b;
        gVar.d = a(androidx.core.content.a.g.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList a2 = androidx.core.content.a.g.a(typedArray, xmlPullParser, theme, "tint", 1);
        if (a2 != null) {
            gVar.c = a2;
        }
        gVar.e = androidx.core.content.a.g.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.e);
        fVar.f = androidx.core.content.a.g.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f);
        fVar.g = androidx.core.content.a.g.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.g);
        if (fVar.f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.g > 0.0f) {
            fVar.d = typedArray.getDimension(3, fVar.d);
            fVar.e = typedArray.getDimension(2, fVar.e);
            if (fVar.d <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.e > 0.0f) {
                fVar.setAlpha(androidx.core.content.a.g.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.i = string;
                    fVar.k.put(string, fVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        g gVar = this.f1332b;
        f fVar = gVar.f1340b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1336b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.k.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f1339a = bVar.o | gVar.f1339a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1336b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.k.put(aVar.getPathName(), aVar);
                    }
                    gVar.f1339a = aVar.o | gVar.f1339a;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1336b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.k.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f1339a = cVar2.e | gVar.f1339a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.g = z;
    }

    private boolean a() {
        if (Build.VERSION.SDK_INT < 17 || !isAutoMirrored() || androidx.core.graphics.drawable.a.i(this) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.c != null) {
            return this.c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f1332b.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.c != null) {
            this.c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        if (this.c != null) {
            this.c.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.c != null) {
            return this.c.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.c != null) {
            this.c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f1341a;

        public h(Drawable.ConstantState constantState) {
            this.f1341a = constantState;
        }

        public Drawable newDrawable() {
            i iVar = new i();
            iVar.c = (VectorDrawable) this.f1341a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.c = (VectorDrawable) this.f1341a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.c = (VectorDrawable) this.f1341a.newDrawable(resources, theme);
            return iVar;
        }

        public boolean canApplyTheme() {
            return this.f1341a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f1341a.getChangingConfigurations();
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class g extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f1339a;

        /* renamed from: b  reason: collision with root package name */
        f f1340b;
        ColorStateList c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g(g gVar) {
            this.c = null;
            this.d = i.f1331a;
            if (gVar != null) {
                this.f1339a = gVar.f1339a;
                this.f1340b = new f(gVar.f1340b);
                if (gVar.f1340b.f1338b != null) {
                    this.f1340b.f1338b = new Paint(gVar.f1340b.f1338b);
                }
                if (gVar.f1340b.f1337a != null) {
                    this.f1340b.f1337a = new Paint(gVar.f1340b.f1337a);
                }
                this.c = gVar.c;
                this.d = gVar.d;
                this.e = gVar.e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.f1340b.getRootAlpha() < 255;
        }

        public Paint a(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f1340b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int i2, int i3) {
            this.f.eraseColor(0);
            this.f1340b.a(new Canvas(this.f), i2, i3, (ColorFilter) null);
        }

        public void b(int i2, int i3) {
            if (this.f == null || !c(i2, i3)) {
                this.f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean c(int i2, int i3) {
            return i2 == this.f.getWidth() && i3 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.f1340b.getRootAlpha();
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.f1340b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public g() {
            this.c = null;
            this.d = i.f1331a;
            this.f1340b = new f();
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public int getChangingConfigurations() {
            return this.f1339a;
        }

        public boolean d() {
            return this.f1340b.a();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f1340b.a(iArr);
            this.k |= a2;
            return a2;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class f {
        private static final Matrix n = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        Paint f1337a;

        /* renamed from: b  reason: collision with root package name */
        Paint f1338b;
        final c c;
        float d;
        float e;
        float f;
        float g;
        int h;
        String i;
        Boolean j;
        final ArrayMap<String, Object> k;
        private final Path l;
        private final Path m;
        private final Matrix o;
        private PathMeasure p;
        private int q;

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        public f() {
            this.o = new Matrix();
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new ArrayMap<>();
            this.c = new c();
            this.l = new Path();
            this.m = new Path();
        }

        public void setRootAlpha(int i2) {
            this.h = i2;
        }

        public int getRootAlpha() {
            return this.h;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public f(f fVar) {
            this.o = new Matrix();
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new ArrayMap<>();
            this.c = new c(fVar.c, this.k);
            this.l = new Path(fVar.l);
            this.m = new Path(fVar.m);
            this.d = fVar.d;
            this.e = fVar.e;
            this.f = fVar.f;
            this.g = fVar.g;
            this.q = fVar.q;
            this.h = fVar.h;
            this.i = fVar.i;
            String str = fVar.i;
            if (str != null) {
                this.k.put(str, this);
            }
            this.j = fVar.j;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            cVar.f1335a.set(matrix);
            cVar.f1335a.preConcat(cVar.d);
            canvas.save();
            for (int i4 = 0; i4 < cVar.f1336b.size(); i4++) {
                d dVar = cVar.f1336b.get(i4);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f1335a, canvas, i2, i3, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        public void a(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            a(this.c, n, canvas, i2, i3, colorFilter);
        }

        private void a(c cVar, e eVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.f;
            float f3 = ((float) i3) / this.g;
            float min = Math.min(f2, f3);
            Matrix matrix = cVar.f1335a;
            this.o.set(matrix);
            this.o.postScale(f2, f3);
            float a2 = a(matrix);
            if (a2 != 0.0f) {
                eVar.a(this.l);
                Path path = this.l;
                this.m.reset();
                if (eVar.a()) {
                    this.m.setFillType(eVar.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.m.addPath(path, this.o);
                    canvas.clipPath(this.m);
                    return;
                }
                b bVar = (b) eVar;
                if (!(bVar.f == 0.0f && bVar.g == 1.0f)) {
                    float f4 = (bVar.f + bVar.h) % 1.0f;
                    float f5 = (bVar.g + bVar.h) % 1.0f;
                    if (this.p == null) {
                        this.p = new PathMeasure();
                    }
                    this.p.setPath(this.l, false);
                    float length = this.p.getLength();
                    float f6 = f4 * length;
                    float f7 = f5 * length;
                    path.reset();
                    if (f6 > f7) {
                        this.p.getSegment(f6, length, path, true);
                        this.p.getSegment(0.0f, f7, path, true);
                    } else {
                        this.p.getSegment(f6, f7, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.m.addPath(path, this.o);
                if (bVar.c.e()) {
                    androidx.core.content.a.b bVar2 = bVar.c;
                    if (this.f1338b == null) {
                        this.f1338b = new Paint(1);
                        this.f1338b.setStyle(Paint.Style.FILL);
                    }
                    Paint paint = this.f1338b;
                    if (bVar2.c()) {
                        Shader a3 = bVar2.a();
                        a3.setLocalMatrix(this.o);
                        paint.setShader(a3);
                        paint.setAlpha(Math.round(bVar.e * 255.0f));
                    } else {
                        paint.setShader((Shader) null);
                        paint.setAlpha(255);
                        paint.setColor(i.a(bVar2.b(), bVar.e));
                    }
                    paint.setColorFilter(colorFilter);
                    this.m.setFillType(bVar.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.m, paint);
                }
                if (bVar.f1333a.e()) {
                    androidx.core.content.a.b bVar3 = bVar.f1333a;
                    if (this.f1337a == null) {
                        this.f1337a = new Paint(1);
                        this.f1337a.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint2 = this.f1337a;
                    if (bVar.j != null) {
                        paint2.setStrokeJoin(bVar.j);
                    }
                    if (bVar.i != null) {
                        paint2.setStrokeCap(bVar.i);
                    }
                    paint2.setStrokeMiter(bVar.k);
                    if (bVar3.c()) {
                        Shader a4 = bVar3.a();
                        a4.setLocalMatrix(this.o);
                        paint2.setShader(a4);
                        paint2.setAlpha(Math.round(bVar.d * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(i.a(bVar3.b(), bVar.d));
                    }
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(bVar.f1334b * min * a2);
                    canvas.drawPath(this.m, paint2);
                }
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public boolean a() {
            if (this.j == null) {
                this.j = Boolean.valueOf(this.c.b());
            }
            return this.j.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.c.a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static abstract class d {
        public boolean a(int[] iArr) {
            return false;
        }

        public boolean b() {
            return false;
        }

        private d() {
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class c extends d {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f1335a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<d> f1336b = new ArrayList<>();
        float c = 0.0f;
        final Matrix d = new Matrix();
        int e;
        private float f = 0.0f;
        private float g = 0.0f;
        private float h = 1.0f;
        private float i = 1.0f;
        private float j = 0.0f;
        private float k = 0.0f;
        private int[] l;
        private String m = null;

        public c(c cVar, ArrayMap<String, Object> arrayMap) {
            super();
            e eVar;
            this.c = cVar.c;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.e = cVar.e;
            String str = this.m;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.d.set(cVar.d);
            ArrayList<d> arrayList = cVar.f1336b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = arrayList.get(i2);
                if (dVar instanceof c) {
                    this.f1336b.add(new c((c) dVar, arrayMap));
                } else {
                    if (dVar instanceof b) {
                        eVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        eVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f1336b.add(eVar);
                    if (eVar.m != null) {
                        arrayMap.put(eVar.m, eVar);
                    }
                }
            }
        }

        public c() {
            super();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.d;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.f1320b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = androidx.core.content.a.g.a(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.f = typedArray.getFloat(1, this.f);
            this.g = typedArray.getFloat(2, this.g);
            this.h = androidx.core.content.a.g.a(typedArray, xmlPullParser, "scaleX", 3, this.h);
            this.i = androidx.core.content.a.g.a(typedArray, xmlPullParser, "scaleY", 4, this.i);
            this.j = androidx.core.content.a.g.a(typedArray, xmlPullParser, "translateX", 6, this.j);
            this.k = androidx.core.content.a.g.a(typedArray, xmlPullParser, "translateY", 7, this.k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        private void a() {
            this.d.reset();
            this.d.postTranslate(-this.f, -this.g);
            this.d.postScale(this.h, this.i);
            this.d.postRotate(this.c, 0.0f, 0.0f);
            this.d.postTranslate(this.j + this.f, this.k + this.g);
        }

        public float getRotation() {
            return this.c;
        }

        public void setRotation(float f2) {
            if (f2 != this.c) {
                this.c = f2;
                a();
            }
        }

        public float getPivotX() {
            return this.f;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                a();
            }
        }

        public float getPivotY() {
            return this.g;
        }

        public void setPivotY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                a();
            }
        }

        public float getScaleX() {
            return this.h;
        }

        public void setScaleX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                a();
            }
        }

        public float getScaleY() {
            return this.i;
        }

        public void setScaleY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                a();
            }
        }

        public float getTranslateX() {
            return this.j;
        }

        public void setTranslateX(float f2) {
            if (f2 != this.j) {
                this.j = f2;
                a();
            }
        }

        public float getTranslateY() {
            return this.k;
        }

        public void setTranslateY(float f2) {
            if (f2 != this.k) {
                this.k = f2;
                a();
            }
        }

        public boolean b() {
            for (int i2 = 0; i2 < this.f1336b.size(); i2++) {
                if (this.f1336b.get(i2).b()) {
                    return true;
                }
            }
            return false;
        }

        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f1336b.size(); i2++) {
                z |= this.f1336b.get(i2).a(iArr);
            }
            return z;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static abstract class e extends d {
        protected e.b[] l = null;
        String m;
        int n = 0;
        int o;

        public boolean a() {
            return false;
        }

        public e() {
            super();
        }

        public e(e eVar) {
            super();
            this.m = eVar.m;
            this.o = eVar.o;
            this.l = androidx.core.graphics.e.a(eVar.l);
        }

        public void a(Path path) {
            path.reset();
            e.b[] bVarArr = this.l;
            if (bVarArr != null) {
                e.b.a(bVarArr, path);
            }
        }

        public String getPathName() {
            return this.m;
        }

        public e.b[] getPathData() {
            return this.l;
        }

        public void setPathData(e.b[] bVarArr) {
            if (!androidx.core.graphics.e.a(this.l, bVarArr)) {
                this.l = androidx.core.graphics.e.a(bVarArr);
            } else {
                androidx.core.graphics.e.b(this.l, bVarArr);
            }
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class a extends e {
        public boolean a() {
            return true;
        }

        a() {
        }

        a(a aVar) {
            super(aVar);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.a.g.a(xmlPullParser, "pathData")) {
                TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.d);
                a(a2, xmlPullParser);
                a2.recycle();
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.l = androidx.core.graphics.e.b(string2);
            }
            this.n = androidx.core.content.a.g.a(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class b extends e {

        /* renamed from: a  reason: collision with root package name */
        androidx.core.content.a.b f1333a;

        /* renamed from: b  reason: collision with root package name */
        float f1334b = 0.0f;
        androidx.core.content.a.b c;
        float d = 1.0f;
        float e = 1.0f;
        float f = 0.0f;
        float g = 1.0f;
        float h = 0.0f;
        Paint.Cap i = Paint.Cap.BUTT;
        Paint.Join j = Paint.Join.MITER;
        float k = 4.0f;
        private int[] p;

        b() {
        }

        b(b bVar) {
            super(bVar);
            this.p = bVar.p;
            this.f1333a = bVar.f1333a;
            this.f1334b = bVar.f1334b;
            this.d = bVar.d;
            this.c = bVar.c;
            this.n = bVar.n;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
        }

        private Paint.Cap a(int i2, Paint.Cap cap) {
            if (i2 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i2 != 1) {
                return i2 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join a(int i2, Paint.Join join) {
            if (i2 == 0) {
                return Paint.Join.MITER;
            }
            if (i2 != 1) {
                return i2 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.p = null;
            if (androidx.core.content.a.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.l = androidx.core.graphics.e.b(string2);
                }
                Resources.Theme theme2 = theme;
                this.c = androidx.core.content.a.g.a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.e = androidx.core.content.a.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.e);
                this.i = a(androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.i);
                this.j = a(androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.j);
                this.k = androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.k);
                this.f1333a = androidx.core.content.a.g.a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.d = androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
                this.f1334b = androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f1334b);
                this.g = androidx.core.content.a.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.g);
                this.h = androidx.core.content.a.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.h);
                this.f = androidx.core.content.a.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.f);
                this.n = androidx.core.content.a.g.a(typedArray, xmlPullParser, "fillType", 13, this.n);
            }
        }

        public boolean b() {
            return this.c.d() || this.f1333a.d();
        }

        public boolean a(int[] iArr) {
            return this.f1333a.a(iArr) | this.c.a(iArr);
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f1333a.b();
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i2) {
            this.f1333a.b(i2);
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f1334b;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f2) {
            this.f1334b = f2;
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.d;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f2) {
            this.d = f2;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.c.b();
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i2) {
            this.c.b(i2);
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.e;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f2) {
            this.e = f2;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f2) {
            this.f = f2;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.g;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f2) {
            this.g = f2;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.h;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f2) {
            this.h = f2;
        }
    }
}
