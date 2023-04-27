package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.preference.CheckBoxPreference;
import color.support.v7.appcompat.R;

public class ColorMarkPreference extends CheckBoxPreference {

    /* renamed from: b  reason: collision with root package name */
    int f1941b;
    private boolean c;
    private Drawable d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private float j;

    public ColorMarkPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.f1941b = 0;
        this.c = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorMarkPreference, i2, 0);
        this.f1941b = obtainStyledAttributes.getInt(R.styleable.ColorMarkPreference_colorMarkStyle, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreference, i2, 0);
        this.c = obtainStyledAttributes2.getBoolean(R.styleable.ColorPreference_colorShowDivider, this.c);
        this.d = obtainStyledAttributes2.getDrawable(R.styleable.ColorPreference_colorDividerDrawable);
        this.e = obtainStyledAttributes2.getBoolean(R.styleable.ColorPreference_hasBorder, false);
        this.g = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.ColorPreference_preference_icon_radius, 14);
        this.f = obtainStyledAttributes2.getBoolean(R.styleable.ColorPreference_colorEnalbeClickSpan, false);
        obtainStyledAttributes2.recycle();
        e(true);
        this.j = context.getResources().getDisplayMetrics().density;
        float f2 = this.j;
        this.h = (int) ((14.0f * f2) / 3.0f);
        this.i = (int) ((f2 * 36.0f) / 3.0f);
    }

    public ColorMarkPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ColorMarkPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorMarkPreferenceStyle);
    }

    public ColorMarkPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        r6 = (android.widget.TextView) r6.a(16908304);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.preference.l r6) {
        /*
            r5 = this;
            super.a((androidx.preference.l) r6)
            int r0 = color.support.v7.appcompat.R.id.color_tail_mark
            android.view.View r0 = r6.a((int) r0)
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L_0x0026
            boolean r3 = r0 instanceof android.widget.Checkable
            if (r3 == 0) goto L_0x0026
            int r3 = r5.f1941b
            if (r3 != 0) goto L_0x0023
            r0.setVisibility(r1)
            android.widget.Checkable r0 = (android.widget.Checkable) r0
            boolean r3 = r5.b()
            r0.setChecked(r3)
            goto L_0x0026
        L_0x0023:
            r0.setVisibility(r2)
        L_0x0026:
            int r0 = color.support.v7.appcompat.R.id.color_head_mark
            android.view.View r0 = r6.a((int) r0)
            if (r0 == 0) goto L_0x0047
            boolean r3 = r0 instanceof android.widget.Checkable
            if (r3 == 0) goto L_0x0047
            int r3 = r5.f1941b
            r4 = 1
            if (r3 != r4) goto L_0x0044
            r0.setVisibility(r1)
            android.widget.Checkable r0 = (android.widget.Checkable) r0
            boolean r1 = r5.b()
            r0.setChecked(r1)
            goto L_0x0047
        L_0x0044:
            r0.setVisibility(r2)
        L_0x0047:
            r0 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r0 = r6.a((int) r0)
            if (r0 == 0) goto L_0x0086
            boolean r1 = r0 instanceof com.color.support.widget.ColorRoundImageView
            if (r1 == 0) goto L_0x0086
            int r1 = r0.getHeight()
            if (r1 == 0) goto L_0x007a
            r1 = r0
            com.color.support.widget.ColorRoundImageView r1 = (com.color.support.widget.ColorRoundImageView) r1
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            if (r1 == 0) goto L_0x007a
            int r1 = r1.getIntrinsicHeight()
            int r1 = r1 / 6
            r5.g = r1
            int r1 = r5.g
            int r2 = r5.h
            if (r1 >= r2) goto L_0x0074
            r5.g = r2
            goto L_0x007a
        L_0x0074:
            int r2 = r5.i
            if (r1 <= r2) goto L_0x007a
            r5.g = r2
        L_0x007a:
            com.color.support.widget.ColorRoundImageView r0 = (com.color.support.widget.ColorRoundImageView) r0
            boolean r1 = r5.e
            r0.setHasBorder(r1)
            int r1 = r5.g
            r0.setBorderRectRadius(r1)
        L_0x0086:
            boolean r0 = r5.f
            if (r0 == 0) goto L_0x00b6
            r0 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r6 = r6.a((int) r0)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00b6
            android.content.Context r0 = r5.J()
            android.content.res.Resources r0 = r0.getResources()
            r1 = 17170445(0x106000d, float:2.461195E-38)
            int r0 = r0.getColor(r1)
            r6.setHighlightColor(r0)
            android.text.method.MovementMethod r0 = android.text.method.LinkMovementMethod.getInstance()
            r6.setMovementMethod(r0)
            com.color.support.preference.ColorMarkPreference$1 r0 = new com.color.support.preference.ColorMarkPreference$1
            r0.<init>(r6)
            r6.setOnTouchListener(r0)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.preference.ColorMarkPreference.a(androidx.preference.l):void");
    }
}
