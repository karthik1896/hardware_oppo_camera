package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.preference.SwitchPreferenceCompat;
import color.support.v7.appcompat.R;
import com.color.support.widget.ColorSwitch;

public class ColorSwitchLoadingPreference extends SwitchPreferenceCompat {

    /* renamed from: b  reason: collision with root package name */
    View f1965b;
    private ColorSwitch c;
    private final a d;
    private boolean e;
    private Drawable f;
    private boolean g;
    private ColorSwitch.a h;

    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!ColorSwitchLoadingPreference.this.d(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                ColorSwitchLoadingPreference.this.e(z);
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

    public ColorSwitchLoadingPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorSwitchLoadPreferenceStyle);
    }

    public ColorSwitchLoadingPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ColorSwitchLoadingPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.d = new a();
        this.e = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreference, i, 0);
        this.e = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_colorShowDivider, this.e);
        this.f = obtainStyledAttributes.getDrawable(R.styleable.ColorPreference_colorDividerDrawable);
        this.g = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_colorEnalbeClickSpan, false);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        r4 = (android.widget.TextView) r4.a(16908304);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.preference.l r4) {
        /*
            r3 = this;
            int r0 = color.support.v7.appcompat.R.id.color_preference
            android.view.View r0 = r4.a((int) r0)
            r1 = 0
            if (r0 == 0) goto L_0x000f
            r0.setSoundEffectsEnabled(r1)
            r0.setHapticFeedbackEnabled(r1)
        L_0x000f:
            int r0 = color.support.v7.appcompat.R.id.switchWidget
            android.view.View r0 = r4.a((int) r0)
            r3.f1965b = r0
            android.view.View r0 = r3.f1965b
            boolean r2 = r0 instanceof com.color.support.widget.ColorSwitch
            if (r2 == 0) goto L_0x0035
            com.color.support.widget.ColorSwitch r0 = (com.color.support.widget.ColorSwitch) r0
            r2 = 1
            r0.setLoadingStyle(r2)
            r0.d()
            com.color.support.widget.ColorSwitch$a r2 = r3.h
            r0.setOnLoadingStateChangedListener(r2)
            com.color.support.preference.ColorSwitchLoadingPreference$a r2 = r3.d
            r0.setOnCheckedChangeListener(r2)
            r0.setVerticalScrollBarEnabled(r1)
            r3.c = r0
        L_0x0035:
            super.a((androidx.preference.l) r4)
            boolean r0 = r3.g
            if (r0 == 0) goto L_0x0068
            r0 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r4 = r4.a((int) r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0068
            android.content.Context r0 = r3.J()
            android.content.res.Resources r0 = r0.getResources()
            r1 = 17170445(0x106000d, float:2.461195E-38)
            int r0 = r0.getColor(r1)
            r4.setHighlightColor(r0)
            android.text.method.MovementMethod r0 = android.text.method.LinkMovementMethod.getInstance()
            r4.setMovementMethod(r0)
            com.color.support.preference.ColorSwitchLoadingPreference$1 r0 = new com.color.support.preference.ColorSwitchLoadingPreference$1
            r0.<init>(r4)
            r4.setOnTouchListener(r0)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.preference.ColorSwitchLoadingPreference.a(androidx.preference.l):void");
    }

    /* access modifiers changed from: protected */
    public void g() {
        ColorSwitch colorSwitch = this.c;
        if (colorSwitch != null) {
            colorSwitch.setShouldPlaySound(true);
            this.c.setTactileFeedbackEnabled(true);
            this.c.b();
        }
    }
}
