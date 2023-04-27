package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.preference.SwitchPreference;
import color.support.v7.appcompat.R;
import com.color.support.widget.ColorSwitch;

public class ColorSwitchPreference extends SwitchPreference {

    /* renamed from: b  reason: collision with root package name */
    private final a f1969b;
    private boolean c;
    private Drawable d;
    private boolean e;
    private ColorSwitch f;
    private boolean g;
    private int h;
    private float i;
    private int j;
    private int k;
    private CharSequence l;

    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ColorSwitchPreference.this.b() != z) {
                if (!ColorSwitchPreference.this.d(Boolean.valueOf(z))) {
                    compoundButton.setChecked(!z);
                } else {
                    ColorSwitchPreference.this.e(z);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean d(Object obj) {
        if (H() == null) {
            return true;
        }
        return H().onPreferenceChange(this, obj);
    }

    public ColorSwitchPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorSwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceStyle);
    }

    public ColorSwitchPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ColorSwitchPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.f1969b = new a();
        this.c = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreference, i2, 0);
        this.c = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_colorShowDivider, this.c);
        this.d = obtainStyledAttributes.getDrawable(R.styleable.ColorPreference_colorDividerDrawable);
        this.e = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_colorEnalbeClickSpan, false);
        this.g = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_hasBorder, false);
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPreference_preference_icon_radius, 14);
        this.l = obtainStyledAttributes.getText(R.styleable.ColorPreference_colorAssignment);
        obtainStyledAttributes.recycle();
        this.i = context.getResources().getDisplayMetrics().density;
        float f2 = this.i;
        this.j = (int) ((14.0f * f2) / 3.0f);
        this.k = (int) ((f2 * 36.0f) / 3.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        r0 = (android.widget.TextView) r5.a(16908304);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.preference.l r5) {
        /*
            r4 = this;
            int r0 = color.support.v7.appcompat.R.id.color_preference
            android.view.View r0 = r5.a((int) r0)
            r1 = 0
            if (r0 == 0) goto L_0x000f
            r0.setSoundEffectsEnabled(r1)
            r0.setHapticFeedbackEnabled(r1)
        L_0x000f:
            r0 = 16908352(0x1020040, float:2.3877408E-38)
            android.view.View r0 = r5.a((int) r0)
            boolean r2 = r0 instanceof com.color.support.widget.ColorSwitch
            if (r2 == 0) goto L_0x0029
            com.color.support.widget.ColorSwitch r0 = (com.color.support.widget.ColorSwitch) r0
            r0.d()
            com.color.support.preference.ColorSwitchPreference$a r2 = r4.f1969b
            r0.setOnCheckedChangeListener(r2)
            r0.setVerticalScrollBarEnabled(r1)
            r4.f = r0
        L_0x0029:
            super.a((androidx.preference.l) r5)
            boolean r0 = r4.e
            if (r0 == 0) goto L_0x005c
            r0 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x005c
            android.content.Context r2 = r4.J()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 17170445(0x106000d, float:2.461195E-38)
            int r2 = r2.getColor(r3)
            r0.setHighlightColor(r2)
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r2)
            com.color.support.preference.ColorSwitchPreference$1 r2 = new com.color.support.preference.ColorSwitchPreference$1
            r2.<init>(r0)
            r0.setOnTouchListener(r2)
        L_0x005c:
            android.view.View r0 = r5.itemView
            r2 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r0 = r0.findViewById(r2)
            if (r0 == 0) goto L_0x009d
            boolean r2 = r0 instanceof com.color.support.widget.ColorRoundImageView
            if (r2 == 0) goto L_0x009d
            int r2 = r0.getHeight()
            if (r2 == 0) goto L_0x0091
            r2 = r0
            com.color.support.widget.ColorRoundImageView r2 = (com.color.support.widget.ColorRoundImageView) r2
            android.graphics.drawable.Drawable r2 = r2.getDrawable()
            if (r2 == 0) goto L_0x0091
            int r2 = r2.getIntrinsicHeight()
            int r2 = r2 / 6
            r4.h = r2
            int r2 = r4.h
            int r3 = r4.j
            if (r2 >= r3) goto L_0x008b
            r4.h = r3
            goto L_0x0091
        L_0x008b:
            int r3 = r4.k
            if (r2 <= r3) goto L_0x0091
            r4.h = r3
        L_0x0091:
            com.color.support.widget.ColorRoundImageView r0 = (com.color.support.widget.ColorRoundImageView) r0
            boolean r2 = r4.g
            r0.setHasBorder(r2)
            int r2 = r4.h
            r0.setBorderRectRadius(r2)
        L_0x009d:
            android.view.View r5 = r5.itemView
            int r0 = color.support.v7.appcompat.R.id.assignment
            android.view.View r5 = r5.findViewById(r0)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00bf
            java.lang.CharSequence r0 = r4.h()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x00ba
            r5.setText(r0)
            r5.setVisibility(r1)
            goto L_0x00bf
        L_0x00ba:
            r0 = 8
            r5.setVisibility(r0)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.preference.ColorSwitchPreference.a(androidx.preference.l):void");
    }

    /* access modifiers changed from: protected */
    public void g() {
        g(true);
        h(true);
        super.g();
    }

    public void g(boolean z) {
        ColorSwitch colorSwitch = this.f;
        if (colorSwitch != null) {
            colorSwitch.setShouldPlaySound(z);
        }
    }

    public void h(boolean z) {
        ColorSwitch colorSwitch = this.f;
        if (colorSwitch != null) {
            colorSwitch.setTactileFeedbackEnabled(z);
        }
    }

    public CharSequence h() {
        return this.l;
    }

    public void g(CharSequence charSequence) {
        if (!TextUtils.equals(this.l, charSequence)) {
            this.l = charSequence;
            i();
        }
    }
}
