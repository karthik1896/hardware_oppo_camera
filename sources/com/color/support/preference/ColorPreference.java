package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import color.support.v7.appcompat.R;

public class ColorPreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1946a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1947b;
    private int c;
    private boolean d;
    private float e;
    private int f;
    private int g;
    private CharSequence h;

    public ColorPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1946a = true;
        a(context, attributeSet, 0, 0);
    }

    public ColorPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1946a = true;
        a(context, attributeSet, i, 0);
    }

    public ColorPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f1946a = true;
        a(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreference, i, i2);
        this.f1946a = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_colorShowDivider, this.f1946a);
        this.f1947b = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_hasBorder, false);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPreference_preference_icon_radius, 14);
        this.d = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_colorEnalbeClickSpan, false);
        obtainStyledAttributes.recycle();
        this.e = context.getResources().getDisplayMetrics().density;
        float f2 = this.e;
        this.f = (int) ((14.0f * f2) / 3.0f);
        this.g = (int) ((f2 * 36.0f) / 3.0f);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreference, i, i2);
        this.h = obtainStyledAttributes.getText(R.styleable.ColorPreference_colorAssignment);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        r0 = (android.widget.TextView) r4.a(16908304);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.preference.l r4) {
        /*
            r3 = this;
            super.a((androidx.preference.l) r4)
            r0 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r0 = r4.a((int) r0)
            if (r0 == 0) goto L_0x0042
            boolean r1 = r0 instanceof com.color.support.widget.ColorRoundImageView
            if (r1 == 0) goto L_0x0042
            int r1 = r0.getHeight()
            if (r1 == 0) goto L_0x0036
            r1 = r0
            com.color.support.widget.ColorRoundImageView r1 = (com.color.support.widget.ColorRoundImageView) r1
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            if (r1 == 0) goto L_0x0036
            int r1 = r1.getIntrinsicHeight()
            int r1 = r1 / 6
            r3.c = r1
            int r1 = r3.c
            int r2 = r3.f
            if (r1 >= r2) goto L_0x0030
            r3.c = r2
            goto L_0x0036
        L_0x0030:
            int r2 = r3.g
            if (r1 <= r2) goto L_0x0036
            r3.c = r2
        L_0x0036:
            com.color.support.widget.ColorRoundImageView r0 = (com.color.support.widget.ColorRoundImageView) r0
            boolean r1 = r3.f1947b
            r0.setHasBorder(r1)
            int r1 = r3.c
            r0.setBorderRectRadius(r1)
        L_0x0042:
            boolean r0 = r3.d
            if (r0 == 0) goto L_0x0072
            r0 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r0 = r4.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0072
            android.content.Context r1 = r3.J()
            android.content.res.Resources r1 = r1.getResources()
            r2 = 17170445(0x106000d, float:2.461195E-38)
            int r1 = r1.getColor(r2)
            r0.setHighlightColor(r1)
            android.text.method.MovementMethod r1 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r1)
            com.color.support.preference.ColorPreference$1 r1 = new com.color.support.preference.ColorPreference$1
            r1.<init>(r0)
            r0.setOnTouchListener(r1)
        L_0x0072:
            int r0 = color.support.v7.appcompat.R.id.assignment
            android.view.View r4 = r4.a((int) r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0093
            java.lang.CharSequence r0 = r3.c()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x008e
            r4.setText(r0)
            r0 = 0
            r4.setVisibility(r0)
            goto L_0x0093
        L_0x008e:
            r0 = 8
            r4.setVisibility(r0)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.preference.ColorPreference.a(androidx.preference.l):void");
    }

    public CharSequence c() {
        return this.h;
    }

    public void d(CharSequence charSequence) {
        if (!TextUtils.equals(this.h, charSequence)) {
            this.h = charSequence;
            i();
        }
    }
}
