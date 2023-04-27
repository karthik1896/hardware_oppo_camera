package com.coloros.anim;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.coloros.anim.c.f;
import com.coloros.anim.g.b;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

public class EffectiveAnimationView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2284a = "EffectiveAnimationView";

    /* renamed from: b  reason: collision with root package name */
    private final c<Throwable> f2285b = new c<Throwable>() {
        public void a(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };
    private final b c = new b();
    private String d;
    private int e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private n i = n.AUTOMATIC;
    private Set<l> j = new HashSet();
    private f<a> k;
    private a l;
    private final c<a> m = new c<a>() {
        public void a(a aVar) {
            EffectiveAnimationView.this.setComposition(aVar);
        }
    };

    public EffectiveAnimationView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public EffectiveAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public EffectiveAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EffectiveAnimationView);
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("rawRes and fileName cannot be used at the same time. Please use only one at once.");
            } else if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.EffectiveAnimationView_anim_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(R.styleable.EffectiveAnimationView_anim_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(R.styleable.EffectiveAnimationView_anim_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.EffectiveAnimationView_anim_autoPlay, false)) {
            this.g = true;
            this.h = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.EffectiveAnimationView_anim_loop, false)) {
            this.c.e(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(R.styleable.EffectiveAnimationView_anim_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(R.styleable.EffectiveAnimationView_anim_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(R.styleable.EffectiveAnimationView_anim_speed, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.EffectiveAnimationView_anim_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.EffectiveAnimationView_anim_progress, 0.0f));
        a(obtainStyledAttributes.getBoolean(R.styleable.EffectiveAnimationView_anim_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_colorFilter)) {
            o oVar = new o(obtainStyledAttributes.getColor(R.styleable.EffectiveAnimationView_anim_colorFilter, 0));
            a(new f("**"), d.z, new b(oVar));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_scale)) {
            this.c.d(obtainStyledAttributes.getFloat(R.styleable.EffectiveAnimationView_anim_scale, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_renderMode)) {
            this.i = n.values()[obtainStyledAttributes.getInt(R.styleable.EffectiveAnimationView_anim_renderMode, 0)];
        }
        obtainStyledAttributes.recycle();
        h();
    }

    public void setImageResource(int i2) {
        f();
        super.setImageResource(i2);
    }

    public void setImageDrawable(Drawable drawable) {
        f();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        f();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        b bVar = this.c;
        if (drawable2 == bVar) {
            super.invalidateDrawable(bVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.d;
        savedState.animationResId = this.e;
        savedState.progress = this.c.u();
        savedState.isAnimating = this.c.n();
        savedState.imageAssetsFolder = this.c.b();
        savedState.repeatMode = this.c.l();
        savedState.repeatCount = this.c.m();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.d = savedState.animationName;
        if (!TextUtils.isEmpty(this.d)) {
            setAnimation(this.d);
        }
        this.e = savedState.animationResId;
        int i2 = this.e;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            a();
        }
        this.c.a(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        if (i2 == 0) {
            if (this.f) {
                this.f = false;
                b();
            }
        } else if (c()) {
            this.f = true;
            e();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && this.g) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (c()) {
            d();
            this.g = true;
        }
        super.onDetachedFromWindow();
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public void setAnimation(int i2) {
        this.e = i2;
        this.d = null;
        setCompositionTask(g.a(getContext(), i2));
    }

    public void setAnimationUsingActivityContext(int i2) {
        this.e = i2;
        this.d = null;
        setCompositionTask(g.b(getContext(), i2));
    }

    public void setAnimation(String str) {
        this.d = str;
        this.e = 0;
        setCompositionTask(g.a(getContext().getAssets(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        a(str, (String) null);
    }

    public void a(String str, String str2) {
        a(new JsonReader(new StringReader(str)), str2);
    }

    public void a(JsonReader jsonReader, String str) {
        setCompositionTask(g.a(jsonReader, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(g.a(getContext(), str));
    }

    private void setCompositionTask(f<a> fVar) {
        g();
        f();
        this.k = fVar.a(this.m).c(this.f2285b);
    }

    private void f() {
        f<a> fVar = this.k;
        if (fVar != null) {
            fVar.b(this.m);
            this.k.d(this.f2285b);
        }
    }

    public a getComposition() {
        return this.l;
    }

    public void setComposition(a aVar) {
        if (com.coloros.anim.f.b.f2453b) {
            com.coloros.anim.f.b.b("Set Composition \n" + aVar);
        }
        this.c.setCallback(this);
        this.l = aVar;
        boolean a2 = this.c.a(aVar);
        h();
        if (getDrawable() != this.c || a2) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.c);
            requestLayout();
            for (l a3 : this.j) {
                a3.a(aVar);
            }
        }
    }

    public void a() {
        this.c.e();
        h();
    }

    public void b() {
        this.c.g();
        h();
    }

    public void setMinFrame(int i2) {
        this.c.a(i2);
    }

    public float getMinFrame() {
        return this.c.h();
    }

    public void setMinFrame(String str) {
        this.c.b(str);
    }

    public void setMinProgress(float f2) {
        this.c.a(f2);
    }

    public void setMaxFrame(int i2) {
        this.c.b(i2);
    }

    public float getMaxFrame() {
        return this.c.i();
    }

    public void setMaxFrame(String str) {
        this.c.c(str);
    }

    public void setMaxProgress(float f2) {
        this.c.b(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.c.d(str);
    }

    public float getSpeed() {
        return this.c.j();
    }

    public void setSpeed(float f2) {
        this.c.c(f2);
    }

    public int getRepeatMode() {
        return this.c.l();
    }

    public void setRepeatMode(int i2) {
        this.c.d(i2);
    }

    public int getRepeatCount() {
        return this.c.m();
    }

    public void setRepeatCount(int i2) {
        this.c.e(i2);
    }

    public boolean c() {
        return this.c.n();
    }

    public String getImageAssetsFolder() {
        return this.c.b();
    }

    public void setImageAssetsFolder(String str) {
        this.c.a(str);
    }

    public void setImageAssetDelegate(j jVar) {
        this.c.a(jVar);
    }

    public void setFontAssetDelegate(i iVar) {
        this.c.a(iVar);
    }

    public void setTextDelegate(p pVar) {
        this.c.a(pVar);
    }

    public <T> void a(f fVar, T t, b<T> bVar) {
        this.c.a(fVar, t, bVar);
    }

    public float getScale() {
        return this.c.q();
    }

    public void setScale(float f2) {
        this.c.d(f2);
        if (getDrawable() == this.c) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.c);
        }
    }

    public void d() {
        this.c.s();
        h();
    }

    public void e() {
        this.c.t();
        h();
    }

    public int getFrame() {
        return this.c.k();
    }

    public void setFrame(int i2) {
        this.c.c(i2);
    }

    public float getProgress() {
        return this.c.u();
    }

    public void setProgress(float f2) {
        this.c.e(f2);
    }

    public long getDuration() {
        a aVar = this.l;
        if (aVar != null) {
            return (long) aVar.e();
        }
        return 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.c.b(z);
    }

    public m getPerformanceTracker() {
        return this.c.c();
    }

    private void g() {
        this.l = null;
        this.c.d();
    }

    public void setRenderMode(n nVar) {
        this.i = nVar;
        h();
    }

    private void h() {
        a aVar;
        if (com.coloros.anim.f.b.f2453b) {
            com.coloros.anim.f.b.a("Render mode : " + this.i.name());
        }
        int i2 = AnonymousClass3.f2288a[this.i.ordinal()];
        int i3 = 2;
        if (i2 == 1) {
            setLayerType(2, (Paint) null);
        } else if (i2 != 2) {
            boolean z = false;
            if (i2 == 3) {
                setLayerType(0, (Paint) null);
            } else if (i2 == 4) {
                a aVar2 = this.l;
                if ((aVar2 == null || !aVar2.a() || Build.VERSION.SDK_INT >= 28) && ((aVar = this.l) == null || aVar.b() <= 4)) {
                    z = true;
                }
                if (!z) {
                    i3 = 1;
                }
                setLayerType(i3, (Paint) null);
            }
        } else {
            setLayerType(1, (Paint) null);
        }
    }

    /* renamed from: com.coloros.anim.EffectiveAnimationView$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2288a = new int[n.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.coloros.anim.n[] r0 = com.coloros.anim.n.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2288a = r0
                int[] r0 = f2288a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.coloros.anim.n r1 = com.coloros.anim.n.HARDWARE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2288a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.coloros.anim.n r1 = com.coloros.anim.n.SOFTWARE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2288a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.coloros.anim.n r1 = com.coloros.anim.n.NONE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f2288a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.coloros.anim.n r1 = com.coloros.anim.n.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.EffectiveAnimationView.AnonymousClass3.<clinit>():void");
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() != 1 ? false : true;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }
}
