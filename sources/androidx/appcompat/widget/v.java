package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.a.f;
import androidx.core.widget.b;
import java.lang.ref.WeakReference;

/* compiled from: AppCompatTextHelper */
class v {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f466a;

    /* renamed from: b  reason: collision with root package name */
    private ap f467b;
    private ap c;
    private ap d;
    private ap e;
    private ap f;
    private ap g;
    private ap h;
    private final w i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    v(TextView textView) {
        this.f466a = textView;
        this.i = new w(this.f466a);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012b  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.util.AttributeSet r19, int r20) {
        /*
            r18 = this;
            r7 = r18
            r0 = r19
            r1 = r20
            android.widget.TextView r2 = r7.f466a
            android.content.Context r2 = r2.getContext()
            androidx.appcompat.widget.i r3 = androidx.appcompat.widget.i.b()
            int[] r4 = androidx.appcompat.R.styleable.AppCompatTextHelper
            r5 = 0
            androidx.appcompat.widget.ar r4 = androidx.appcompat.widget.ar.a(r2, r0, r4, r1, r5)
            int r6 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_textAppearance
            r8 = -1
            int r6 = r4.g(r6, r8)
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x0032
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.ap r9 = a(r2, r3, r9)
            r7.f467b = r9
        L_0x0032:
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x0046
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.ap r9 = a(r2, r3, r9)
            r7.c = r9
        L_0x0046:
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x005a
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.ap r9 = a(r2, r3, r9)
            r7.d = r9
        L_0x005a:
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x006e
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.ap r9 = a(r2, r3, r9)
            r7.e = r9
        L_0x006e:
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 17
            if (r9 < r10) goto L_0x009c
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x0088
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.ap r9 = a(r2, r3, r9)
            r7.f = r9
        L_0x0088:
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x009c
            int r9 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.ap r9 = a(r2, r3, r9)
            r7.g = r9
        L_0x009c:
            r4.b()
            android.widget.TextView r4 = r7.f466a
            android.text.method.TransformationMethod r4 = r4.getTransformationMethod()
            boolean r4 = r4 instanceof android.text.method.PasswordTransformationMethod
            r9 = 26
            r11 = 23
            if (r6 == r8) goto L_0x0130
            int[] r13 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.ar r6 = androidx.appcompat.widget.ar.a((android.content.Context) r2, (int) r6, (int[]) r13)
            if (r4 != 0) goto L_0x00c6
            int r13 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r13 = r6.g(r13)
            if (r13 == 0) goto L_0x00c6
            int r13 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r13 = r6.a((int) r13, (boolean) r5)
            r14 = r13
            r13 = 1
            goto L_0x00c8
        L_0x00c6:
            r13 = r5
            r14 = r13
        L_0x00c8:
            r7.a((android.content.Context) r2, (androidx.appcompat.widget.ar) r6)
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 >= r11) goto L_0x0105
            int r15 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            boolean r15 = r6.g(r15)
            if (r15 == 0) goto L_0x00de
            int r15 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            android.content.res.ColorStateList r15 = r6.e(r15)
            goto L_0x00df
        L_0x00de:
            r15 = 0
        L_0x00df:
            int r10 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            boolean r10 = r6.g(r10)
            if (r10 == 0) goto L_0x00ee
            int r10 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r10 = r6.e(r10)
            goto L_0x00ef
        L_0x00ee:
            r10 = 0
        L_0x00ef:
            int r12 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            boolean r12 = r6.g(r12)
            if (r12 == 0) goto L_0x0103
            int r12 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r12 = r6.e(r12)
            r17 = r15
            r15 = r12
            r12 = r17
            goto L_0x0108
        L_0x0103:
            r12 = r15
            goto L_0x0107
        L_0x0105:
            r10 = 0
            r12 = 0
        L_0x0107:
            r15 = 0
        L_0x0108:
            int r8 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r8 = r6.g(r8)
            if (r8 == 0) goto L_0x0117
            int r8 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            java.lang.String r8 = r6.d(r8)
            goto L_0x0118
        L_0x0117:
            r8 = 0
        L_0x0118:
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r9) goto L_0x012b
            int r11 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r11 = r6.g(r11)
            if (r11 == 0) goto L_0x012b
            int r11 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            java.lang.String r11 = r6.d(r11)
            goto L_0x012c
        L_0x012b:
            r11 = 0
        L_0x012c:
            r6.b()
            goto L_0x0137
        L_0x0130:
            r13 = r5
            r14 = r13
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r15 = 0
        L_0x0137:
            int[] r6 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.ar r6 = androidx.appcompat.widget.ar.a(r2, r0, r6, r1, r5)
            if (r4 != 0) goto L_0x014e
            int r9 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r9 = r6.g(r9)
            if (r9 == 0) goto L_0x014e
            int r9 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r14 = r6.a((int) r9, (boolean) r5)
            r13 = 1
        L_0x014e:
            int r9 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r9 >= r5) goto L_0x017e
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x0162
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            android.content.res.ColorStateList r12 = r6.e(r5)
        L_0x0162:
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x0170
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r10 = r6.e(r5)
        L_0x0170:
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x017e
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r15 = r6.e(r5)
        L_0x017e:
            int r5 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x018c
            int r5 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            java.lang.String r8 = r6.d(r5)
        L_0x018c:
            int r5 = android.os.Build.VERSION.SDK_INT
            r9 = 26
            if (r5 < r9) goto L_0x01a0
            int r5 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x01a0
            int r5 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            java.lang.String r11 = r6.d(r5)
        L_0x01a0:
            int r5 = android.os.Build.VERSION.SDK_INT
            r9 = 28
            if (r5 < r9) goto L_0x01c1
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x01c1
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            r9 = -1
            int r5 = r6.e(r5, r9)
            if (r5 != 0) goto L_0x01c1
            android.widget.TextView r5 = r7.f466a
            r9 = 0
            r16 = r3
            r3 = 0
            r5.setTextSize(r3, r9)
            goto L_0x01c3
        L_0x01c1:
            r16 = r3
        L_0x01c3:
            r7.a((android.content.Context) r2, (androidx.appcompat.widget.ar) r6)
            r6.b()
            if (r12 == 0) goto L_0x01d0
            android.widget.TextView r3 = r7.f466a
            r3.setTextColor(r12)
        L_0x01d0:
            if (r10 == 0) goto L_0x01d7
            android.widget.TextView r3 = r7.f466a
            r3.setHintTextColor(r10)
        L_0x01d7:
            if (r15 == 0) goto L_0x01de
            android.widget.TextView r3 = r7.f466a
            r3.setLinkTextColor(r15)
        L_0x01de:
            if (r4 != 0) goto L_0x01e5
            if (r13 == 0) goto L_0x01e5
            r7.a((boolean) r14)
        L_0x01e5:
            android.graphics.Typeface r3 = r7.l
            if (r3 == 0) goto L_0x01fb
            int r4 = r7.k
            r5 = -1
            if (r4 != r5) goto L_0x01f6
            android.widget.TextView r4 = r7.f466a
            int r5 = r7.j
            r4.setTypeface(r3, r5)
            goto L_0x01fb
        L_0x01f6:
            android.widget.TextView r4 = r7.f466a
            r4.setTypeface(r3)
        L_0x01fb:
            if (r11 == 0) goto L_0x0202
            android.widget.TextView r3 = r7.f466a
            r3.setFontVariationSettings(r11)
        L_0x0202:
            if (r8 == 0) goto L_0x022e
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x0214
            android.widget.TextView r3 = r7.f466a
            android.os.LocaleList r4 = android.os.LocaleList.forLanguageTags(r8)
            r3.setTextLocales(r4)
            goto L_0x022e
        L_0x0214:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x022e
            r3 = 44
            int r3 = r8.indexOf(r3)
            r4 = 0
            java.lang.String r3 = r8.substring(r4, r3)
            android.widget.TextView r4 = r7.f466a
            java.util.Locale r3 = java.util.Locale.forLanguageTag(r3)
            r4.setTextLocale(r3)
        L_0x022e:
            androidx.appcompat.widget.w r3 = r7.i
            r3.a((android.util.AttributeSet) r0, (int) r1)
            boolean r1 = androidx.core.widget.b.d
            if (r1 == 0) goto L_0x0274
            androidx.appcompat.widget.w r1 = r7.i
            int r1 = r1.a()
            if (r1 == 0) goto L_0x0274
            androidx.appcompat.widget.w r1 = r7.i
            int[] r1 = r1.e()
            int r3 = r1.length
            if (r3 <= 0) goto L_0x0274
            android.widget.TextView r3 = r7.f466a
            int r3 = r3.getAutoSizeStepGranularity()
            float r3 = (float) r3
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x026e
            android.widget.TextView r1 = r7.f466a
            androidx.appcompat.widget.w r3 = r7.i
            int r3 = r3.c()
            androidx.appcompat.widget.w r4 = r7.i
            int r4 = r4.d()
            androidx.appcompat.widget.w r5 = r7.i
            int r5 = r5.b()
            r6 = 0
            r1.setAutoSizeTextTypeUniformWithConfiguration(r3, r4, r5, r6)
            goto L_0x0274
        L_0x026e:
            r6 = 0
            android.widget.TextView r3 = r7.f466a
            r3.setAutoSizeTextTypeUniformWithPresetSizes(r1, r6)
        L_0x0274:
            int[] r1 = androidx.appcompat.R.styleable.AppCompatTextView
            androidx.appcompat.widget.ar r8 = androidx.appcompat.widget.ar.a((android.content.Context) r2, (android.util.AttributeSet) r0, (int[]) r1)
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat
            r1 = -1
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x028b
            r3 = r16
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r4 = r0
            goto L_0x028e
        L_0x028b:
            r3 = r16
            r4 = 0
        L_0x028e:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x029c
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r5 = r0
            goto L_0x029d
        L_0x029c:
            r5 = 0
        L_0x029d:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02ab
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r6 = r0
            goto L_0x02ac
        L_0x02ab:
            r6 = 0
        L_0x02ac:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02ba
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r9 = r0
            goto L_0x02bb
        L_0x02ba:
            r9 = 0
        L_0x02bb:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02c9
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r10 = r0
            goto L_0x02ca
        L_0x02c9:
            r10 = 0
        L_0x02ca:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02d8
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r11 = r0
            goto L_0x02d9
        L_0x02d8:
            r11 = 0
        L_0x02d9:
            r0 = r18
            r1 = r4
            r2 = r5
            r3 = r6
            r4 = r9
            r5 = r10
            r6 = r11
            r0.a(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint
            boolean r0 = r8.g(r0)
            if (r0 == 0) goto L_0x02f7
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint
            android.content.res.ColorStateList r0 = r8.e(r0)
            android.widget.TextView r1 = r7.f466a
            androidx.core.widget.i.a((android.widget.TextView) r1, (android.content.res.ColorStateList) r0)
        L_0x02f7:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode
            boolean r0 = r8.g(r0)
            if (r0 == 0) goto L_0x0311
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode
            r1 = -1
            int r0 = r8.a((int) r0, (int) r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.aa.a(r0, r2)
            android.widget.TextView r2 = r7.f466a
            androidx.core.widget.i.a((android.widget.TextView) r2, (android.graphics.PorterDuff.Mode) r0)
            goto L_0x0312
        L_0x0311:
            r1 = -1
        L_0x0312:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.e(r0, r1)
            int r2 = androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r8.e(r2, r1)
            int r3 = androidx.appcompat.R.styleable.AppCompatTextView_lineHeight
            int r3 = r8.e(r3, r1)
            r8.b()
            if (r0 == r1) goto L_0x032e
            android.widget.TextView r4 = r7.f466a
            androidx.core.widget.i.b(r4, r0)
        L_0x032e:
            if (r2 == r1) goto L_0x0335
            android.widget.TextView r0 = r7.f466a
            androidx.core.widget.i.c(r0, r2)
        L_0x0335:
            if (r3 == r1) goto L_0x033c
            android.widget.TextView r0 = r7.f466a
            androidx.core.widget.i.d(r0, r3)
        L_0x033c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v.a(android.util.AttributeSet, int):void");
    }

    public void a(Typeface typeface) {
        if (this.m) {
            this.f466a.setTypeface(typeface);
            this.l = typeface;
        }
    }

    public void a(Runnable runnable) {
        this.f466a.post(runnable);
    }

    /* compiled from: AppCompatTextHelper */
    private static class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<v> f468a;

        /* renamed from: b  reason: collision with root package name */
        private final int f469b;
        private final int c;

        public void onFontRetrievalFailed(int i) {
        }

        /* renamed from: androidx.appcompat.widget.v$a$a  reason: collision with other inner class name */
        /* compiled from: AppCompatTextHelper */
        private class C0009a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final WeakReference<v> f471b;
            private final Typeface c;

            C0009a(WeakReference<v> weakReference, Typeface typeface) {
                this.f471b = weakReference;
                this.c = typeface;
            }

            public void run() {
                v vVar = (v) this.f471b.get();
                if (vVar != null) {
                    vVar.a(this.c);
                }
            }
        }

        a(v vVar, int i, int i2) {
            this.f468a = new WeakReference<>(vVar);
            this.f469b = i;
            this.c = i2;
        }

        public void onFontRetrieved(Typeface typeface) {
            int i;
            v vVar = (v) this.f468a.get();
            if (vVar != null) {
                if (Build.VERSION.SDK_INT >= 28 && (i = this.f469b) != -1) {
                    typeface = Typeface.create(typeface, i, (this.c & 2) != 0);
                }
                vVar.a((Runnable) new C0009a(this.f468a, typeface));
            }
        }
    }

    private void a(Context context, ar arVar) {
        String d2;
        this.j = arVar.a(R.styleable.TextAppearance_android_textStyle, this.j);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28) {
            this.k = arVar.a(R.styleable.TextAppearance_android_textFontWeight, -1);
            if (this.k != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (arVar.g(R.styleable.TextAppearance_android_fontFamily) || arVar.g(R.styleable.TextAppearance_fontFamily)) {
            this.l = null;
            int i2 = arVar.g(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
            int i3 = this.k;
            int i4 = this.j;
            if (!context.isRestricted()) {
                try {
                    Typeface a2 = arVar.a(i2, this.j, (f.a) new a(this, i3, i4));
                    if (a2 != null) {
                        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
                            this.l = a2;
                        } else {
                            this.l = Typeface.create(Typeface.create(a2, 0), this.k, (this.j & 2) != 0);
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l == null && (d2 = arVar.d(i2)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
                    this.l = Typeface.create(d2, this.j);
                    return;
                }
                Typeface create = Typeface.create(d2, 0);
                int i5 = this.k;
                if ((this.j & 2) != 0) {
                    z = true;
                }
                this.l = Typeface.create(create, i5, z);
            }
        } else if (arVar.g(R.styleable.TextAppearance_android_typeface)) {
            this.m = false;
            int a3 = arVar.a(R.styleable.TextAppearance_android_typeface, 1);
            if (a3 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (a3 == 2) {
                this.l = Typeface.SERIF;
            } else if (a3 == 3) {
                this.l = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, int i2) {
        String d2;
        ColorStateList e2;
        ar a2 = ar.a(context, i2, R.styleable.TextAppearance);
        if (a2.g(R.styleable.TextAppearance_textAllCaps)) {
            a(a2.a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a2.g(R.styleable.TextAppearance_android_textColor) && (e2 = a2.e(R.styleable.TextAppearance_android_textColor)) != null) {
            this.f466a.setTextColor(e2);
        }
        if (a2.g(R.styleable.TextAppearance_android_textSize) && a2.e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f466a.setTextSize(0, 0.0f);
        }
        a(context, a2);
        if (Build.VERSION.SDK_INT >= 26 && a2.g(R.styleable.TextAppearance_fontVariationSettings) && (d2 = a2.d(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f466a.setFontVariationSettings(d2);
        }
        a2.b();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f466a.setTypeface(typeface, this.j);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f466a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f467b == null && this.c == null && this.d == null && this.e == null)) {
            Drawable[] compoundDrawables = this.f466a.getCompoundDrawables();
            a(compoundDrawables[0], this.f467b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f != null || this.g != null) {
            Drawable[] compoundDrawablesRelative = this.f466a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, ap apVar) {
        if (drawable != null && apVar != null) {
            i.a(drawable, apVar, this.f466a.getDrawableState());
        }
    }

    private static ap a(Context context, i iVar, int i2) {
        ColorStateList b2 = iVar.b(context, i2);
        if (b2 == null) {
            return null;
        }
        ap apVar = new ap();
        apVar.d = true;
        apVar.f414a = b2;
        return apVar;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, int i2, int i3, int i4, int i5) {
        if (!b.d) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2) {
        if (!b.d && !d()) {
            b(i2, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.i.f();
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.i.g();
    }

    private void b(int i2, float f2) {
        this.i.a(i2, f2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.i.a(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.i.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr, int i2) throws IllegalArgumentException {
        this.i.a(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.i.a();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.i.b();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.i.c();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.i.d();
    }

    /* access modifiers changed from: package-private */
    public int[] i() {
        return this.i.e();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        ap apVar = this.h;
        if (apVar != null) {
            return apVar.f414a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new ap();
        }
        ap apVar = this.h;
        apVar.f414a = colorStateList;
        apVar.d = colorStateList != null;
        l();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        ap apVar = this.h;
        if (apVar != null) {
            return apVar.f415b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new ap();
        }
        ap apVar = this.h;
        apVar.f415b = mode;
        apVar.c = mode != null;
        l();
    }

    private void l() {
        ap apVar = this.h;
        this.f467b = apVar;
        this.c = apVar;
        this.d = apVar;
        this.e = apVar;
        this.f = apVar;
        this.g = apVar;
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f466a.getCompoundDrawablesRelative();
            TextView textView = this.f466a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f466a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f466a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f466a.getCompoundDrawables();
            TextView textView3 = this.f466a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }
}
