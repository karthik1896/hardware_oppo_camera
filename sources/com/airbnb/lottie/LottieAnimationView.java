package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.g.v;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f.d;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g.b;
import com.airbnb.lottie.g.c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1606a = "LottieAnimationView";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final h<Throwable> f1607b = new h<Throwable>() {
        public void a(Throwable th) {
            if (h.a(th)) {
                d.a("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };
    private final h<d> c = new h<d>() {
        public void a(d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    };
    private final h<Throwable> d = new h<Throwable>() {
        public void a(Throwable th) {
            if (LottieAnimationView.this.f != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f);
            }
            (LottieAnimationView.this.e == null ? LottieAnimationView.f1607b : LottieAnimationView.this.e).a(th);
        }
    };
    /* access modifiers changed from: private */
    public h<Throwable> e;
    /* access modifiers changed from: private */
    public int f = 0;
    private final f g = new f();
    private boolean h;
    private String i;
    private int j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = true;
    private o p = o.AUTOMATIC;
    private Set<j> q = new HashSet();
    private int r = 0;
    private m<d> s;
    private d t;

    public LottieAnimationView(Context context) {
        super(context);
        a((AttributeSet) null, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet, i2);
    }

    private void a(AttributeSet attributeSet, int i2) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i2, 0);
        if (!isInEditMode()) {
            this.o = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (!hasValue || !hasValue2) {
                if (hasValue) {
                    int resourceId = obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                    if (resourceId != 0) {
                        setAnimation(resourceId);
                    }
                } else if (hasValue2) {
                    String string2 = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
                    if (string2 != null) {
                        setAnimation(string2);
                    }
                } else if (hasValue3 && (string = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
                    setAnimationFromUrl(string);
                }
                setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
            } else {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.m = true;
            this.n = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.g.e(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        a(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            a(new e("**"), k.C, new c(new p(obtainStyledAttributes.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.g.e(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int i3 = obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, o.AUTOMATIC.ordinal());
            if (i3 >= o.values().length) {
                i3 = o.AUTOMATIC.ordinal();
            }
            setRenderMode(o.values()[i3]);
        }
        if (getScaleType() != null) {
            this.g.a(getScaleType());
        }
        obtainStyledAttributes.recycle();
        f fVar = this.g;
        if (h.a(getContext()) != 0.0f) {
            z = true;
        }
        fVar.a(Boolean.valueOf(z));
        i();
        this.h = true;
    }

    public void setImageResource(int i2) {
        g();
        super.setImageResource(i2);
    }

    public void setImageDrawable(Drawable drawable) {
        g();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        g();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.g;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.i;
        savedState.animationResId = this.j;
        savedState.progress = this.g.v();
        savedState.isAnimating = this.g.o() || (!v.D(this) && this.m);
        savedState.imageAssetsFolder = this.g.b();
        savedState.repeatMode = this.g.m();
        savedState.repeatCount = this.g.n();
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
        this.i = savedState.animationName;
        if (!TextUtils.isEmpty(this.i)) {
            setAnimation(this.i);
        }
        this.j = savedState.animationResId;
        int i2 = this.j;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            a();
        }
        this.g.a(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        if (this.h) {
            if (isShown()) {
                if (this.l) {
                    b();
                } else if (this.k) {
                    a();
                }
                this.l = false;
                this.k = false;
            } else if (c()) {
                e();
                this.l = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.n || this.m) {
            a();
            this.n = false;
            this.m = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (c()) {
            d();
            this.m = true;
        }
        super.onDetachedFromWindow();
    }

    public void a(boolean z) {
        this.g.a(z);
    }

    public void setCacheComposition(boolean z) {
        this.o = z;
    }

    public void setAnimation(int i2) {
        this.j = i2;
        this.i = null;
        setCompositionTask(this.o ? e.a(getContext(), i2) : e.a(getContext(), i2, (String) null));
    }

    public void setAnimation(String str) {
        this.i = str;
        this.j = 0;
        setCompositionTask(this.o ? e.b(getContext(), str) : e.b(getContext(), str, (String) null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        a(str, (String) null);
    }

    public void a(String str, String str2) {
        a((InputStream) new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void a(InputStream inputStream, String str) {
        setCompositionTask(e.a(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.o ? e.a(getContext(), str) : e.a(getContext(), str, (String) null));
    }

    public void setFailureListener(h<Throwable> hVar) {
        this.e = hVar;
    }

    public void setFallbackResource(int i2) {
        this.f = i2;
    }

    private void setCompositionTask(m<d> mVar) {
        h();
        g();
        this.s = mVar.a(this.c).c(this.d);
    }

    private void g() {
        m<d> mVar = this.s;
        if (mVar != null) {
            mVar.b(this.c);
            this.s.d(this.d);
        }
    }

    public void setComposition(d dVar) {
        if (c.f1655a) {
            String str = f1606a;
            Log.v(str, "Set Composition \n" + dVar);
        }
        this.g.setCallback(this);
        this.t = dVar;
        boolean a2 = this.g.a(dVar);
        i();
        if (getDrawable() != this.g || a2) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (j a3 : this.q) {
                a3.a(dVar);
            }
        }
    }

    public d getComposition() {
        return this.t;
    }

    public void a() {
        if (isShown()) {
            this.g.f();
            i();
            return;
        }
        this.k = true;
    }

    public void b() {
        if (isShown()) {
            this.g.h();
            i();
            return;
        }
        this.k = false;
        this.l = true;
    }

    public void setMinFrame(int i2) {
        this.g.a(i2);
    }

    public float getMinFrame() {
        return this.g.i();
    }

    public void setMinProgress(float f2) {
        this.g.a(f2);
    }

    public void setMaxFrame(int i2) {
        this.g.b(i2);
    }

    public float getMaxFrame() {
        return this.g.j();
    }

    public void setMaxProgress(float f2) {
        this.g.b(f2);
    }

    public void setMinFrame(String str) {
        this.g.b(str);
    }

    public void setMaxFrame(String str) {
        this.g.c(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.g.d(str);
    }

    public void setSpeed(float f2) {
        this.g.c(f2);
    }

    public float getSpeed() {
        return this.g.k();
    }

    public void setRepeatMode(int i2) {
        this.g.d(i2);
    }

    public int getRepeatMode() {
        return this.g.m();
    }

    public void setRepeatCount(int i2) {
        this.g.e(i2);
    }

    public int getRepeatCount() {
        return this.g.n();
    }

    public boolean c() {
        return this.g.o();
    }

    public void setImageAssetsFolder(String str) {
        this.g.a(str);
    }

    public String getImageAssetsFolder() {
        return this.g.b();
    }

    public void setImageAssetDelegate(b bVar) {
        this.g.a(bVar);
    }

    public void setFontAssetDelegate(a aVar) {
        this.g.a(aVar);
    }

    public void setTextDelegate(q qVar) {
        this.g.a(qVar);
    }

    public List<e> a(e eVar) {
        return this.g.a(eVar);
    }

    public <T> void a(e eVar, T t2, c<T> cVar) {
        this.g.a(eVar, t2, cVar);
    }

    public <T> void a(e eVar, T t2, final com.airbnb.lottie.g.e<T> eVar2) {
        this.g.a(eVar, t2, new c<T>() {
            public T a(b<T> bVar) {
                return eVar2.a(bVar);
            }
        });
    }

    public void setScale(float f2) {
        this.g.e(f2);
        if (getDrawable() == this.g) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.g);
        }
    }

    public float getScale() {
        return this.g.r();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        f fVar = this.g;
        if (fVar != null) {
            fVar.a(scaleType);
        }
    }

    public void d() {
        this.m = false;
        this.l = false;
        this.k = false;
        this.g.t();
        i();
    }

    public void e() {
        this.n = false;
        this.m = false;
        this.l = false;
        this.k = false;
        this.g.u();
        i();
    }

    public void setFrame(int i2) {
        this.g.c(i2);
    }

    public int getFrame() {
        return this.g.l();
    }

    public void setProgress(float f2) {
        this.g.d(f2);
    }

    public float getProgress() {
        return this.g.v();
    }

    public long getDuration() {
        d dVar = this.t;
        if (dVar != null) {
            return (long) dVar.e();
        }
        return 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.g.b(z);
    }

    public n getPerformanceTracker() {
        return this.g.c();
    }

    private void h() {
        this.t = null;
        this.g.e();
    }

    public void setSafeMode(boolean z) {
        this.g.d(z);
    }

    public void buildDrawingCache(boolean z) {
        c.a("buildDrawingCache");
        this.r++;
        super.buildDrawingCache(z);
        if (this.r == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(o.HARDWARE);
        }
        this.r--;
        c.b("buildDrawingCache");
    }

    public void setRenderMode(o oVar) {
        this.p = oVar;
        i();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.g.c(z);
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1612a = new int[o.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.airbnb.lottie.o[] r0 = com.airbnb.lottie.o.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1612a = r0
                int[] r0 = f1612a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.o r1 = com.airbnb.lottie.o.HARDWARE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1612a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.o r1 = com.airbnb.lottie.o.SOFTWARE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1612a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.o r1 = com.airbnb.lottie.o.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.AnonymousClass5.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        if (r3 != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.AnonymousClass5.f1612a
            com.airbnb.lottie.o r1 = r5.p
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x003d
            if (r0 == r1) goto L_0x0013
            r3 = 3
            if (r0 == r3) goto L_0x0015
        L_0x0013:
            r1 = r2
            goto L_0x003d
        L_0x0015:
            com.airbnb.lottie.d r0 = r5.t
            r3 = 0
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0027
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L_0x0027
            goto L_0x003b
        L_0x0027:
            com.airbnb.lottie.d r0 = r5.t
            if (r0 == 0) goto L_0x0033
            int r0 = r0.b()
            r4 = 4
            if (r0 <= r4) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r3 = r2
        L_0x003b:
            if (r3 == 0) goto L_0x0013
        L_0x003d:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L_0x0047
            r0 = 0
            r5.setLayerType(r1, r0)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.i():void");
    }

    public boolean a(j jVar) {
        d dVar = this.t;
        if (dVar != null) {
            jVar.a(dVar);
        }
        return this.q.add(jVar);
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
