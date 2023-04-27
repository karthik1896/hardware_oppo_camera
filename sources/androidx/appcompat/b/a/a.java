package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.b;
import androidx.appcompat.b.a.d;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ah;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.a.g;
import androidx.vectordrawable.a.a.i;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
/* compiled from: AnimatedStateListDrawableCompat */
public class a extends d implements androidx.core.graphics.drawable.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f200a = "a";

    /* renamed from: b  reason: collision with root package name */
    private b f201b;
    private f c;
    private int d;
    private int e;
    private boolean f;

    public boolean isStateful() {
        return true;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public a() {
        this((b) null, (Resources) null);
    }

    a(b bVar, Resources resources) {
        super((d.a) null);
        this.d = -1;
        this.e = -1;
        a((b.C0005b) new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.b(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        e();
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.c != null && (visible || z2)) {
            if (z) {
                this.c.a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.c;
        if (fVar != null) {
            fVar.b();
            this.c = null;
            a(this.d);
            this.d = -1;
            this.e = -1;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int a2 = this.f201b.a(iArr);
        boolean z = a2 != d() && (b(a2) || a(a2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    private boolean b(int i) {
        int i2;
        int a2;
        f fVar;
        f fVar2 = this.c;
        if (fVar2 == null) {
            i2 = d();
        } else if (i == this.d) {
            return true;
        } else {
            if (i != this.e || !fVar2.c()) {
                i2 = this.d;
                fVar2.b();
            } else {
                fVar2.d();
                this.d = this.e;
                this.e = i;
                return true;
            }
        }
        this.c = null;
        this.e = -1;
        this.d = -1;
        b bVar = this.f201b;
        int a3 = bVar.a(i2);
        int a4 = bVar.a(i);
        if (a4 == 0 || a3 == 0 || (a2 = bVar.a(a3, a4)) < 0) {
            return false;
        }
        boolean c2 = bVar.c(a3, a4);
        a(a2);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            fVar = new d((AnimationDrawable) current, bVar.b(a3, a4), c2);
        } else if (current instanceof androidx.vectordrawable.a.a.c) {
            fVar = new c((androidx.vectordrawable.a.a.c) current);
        } else {
            if (current instanceof Animatable) {
                fVar = new C0004a((Animatable) current);
            }
            return false;
        }
        fVar.a();
        this.c = fVar;
        this.e = i2;
        this.d = i;
        return true;
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static abstract class f {
        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }

        private f() {
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$a  reason: collision with other inner class name */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0004a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f202a;

        C0004a(Animatable animatable) {
            super();
            this.f202a = animatable;
        }

        public void a() {
            this.f202a.start();
        }

        public void b() {
            this.f202a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static class d extends f {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f206a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f207b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, i2});
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) eVar.a());
            ofInt.setInterpolator(eVar);
            this.f207b = z2;
            this.f206a = ofInt;
        }

        public boolean c() {
            return this.f207b;
        }

        public void a() {
            this.f206a.start();
        }

        public void d() {
            this.f206a.reverse();
        }

        public void b() {
            this.f206a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static class c extends f {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.vectordrawable.a.a.c f205a;

        c(androidx.vectordrawable.a.a.c cVar) {
            super();
            this.f205a = cVar;
        }

        public void a() {
            this.f205a.start();
        }

        public void b() {
            this.f205a.stop();
        }
    }

    private void a(TypedArray typedArray) {
        b bVar = this.f201b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f |= typedArray.getChangingConfigurations();
        }
        bVar.a(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, bVar.k));
        bVar.b(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, bVar.n));
        bVar.c(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C));
        bVar.d(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, bVar.z));
    }

    private void e() {
        onStateChange(getState());
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        e(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        d(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable a3 = resourceId3 > 0 ? ah.a().a(context, resourceId3) : null;
        boolean z = a2.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                a3 = androidx.vectordrawable.a.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a3 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f201b.a(resourceId, resourceId2, a3, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable a3 = resourceId2 > 0 ? ah.a().a(context, resourceId2) : null;
        a2.recycle();
        int[] a4 = a(attributeSet);
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                a3 = i.a(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a3 != null) {
            return this.f201b.a(a4, a3, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.f201b.a();
            this.f = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public b c() {
        return new b(this.f201b, this, (Resources) null);
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    static class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        LongSparseArray<Long> f203a;

        /* renamed from: b  reason: collision with root package name */
        SparseArrayCompat<Integer> f204b;

        private static long f(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.f203a = bVar.f203a;
                this.f204b = bVar.f204b;
                return;
            }
            this.f203a = new LongSparseArray<>();
            this.f204b = new SparseArrayCompat<>();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f203a = this.f203a.clone();
            this.f204b = this.f204b.clone();
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long f = f(i, i2);
            long j = z ? STMobileHumanActionNative.ST_MOBILE_BODY_ACTION2 : 0;
            long j2 = (long) a2;
            this.f203a.append(f, Long.valueOf(j2 | j));
            if (z) {
                this.f203a.append(f(i2, i), Long.valueOf(STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 | j2 | j));
            }
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable, int i) {
            int a2 = super.a(iArr, drawable);
            this.f204b.put(a2, Integer.valueOf(i));
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int a(int[] iArr) {
            int b2 = super.b(iArr);
            if (b2 >= 0) {
                return b2;
            }
            return super.b(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f204b.get(i, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            return (int) this.f203a.get(f(i, i2), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i, int i2) {
            return (this.f203a.get(f(i, i2), -1L).longValue() & STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i, int i2) {
            return (this.f203a.get(f(i, i2), -1L).longValue() & STMobileHumanActionNative.ST_MOBILE_BODY_ACTION2) != 0;
        }

        public Drawable newDrawable() {
            return new a(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b.C0005b bVar) {
        super.a(bVar);
        if (bVar instanceof b) {
            this.f201b = (b) bVar;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat */
    private static class e implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f208a;

        /* renamed from: b  reason: collision with root package name */
        private int f209b;
        private int c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        /* access modifiers changed from: package-private */
        public int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f209b = numberOfFrames;
            int[] iArr = this.f208a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f208a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f208a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.c;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.c)) + 0.5f);
            int i2 = this.f209b;
            int[] iArr = this.f208a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.c) : 0.0f);
        }
    }
}
