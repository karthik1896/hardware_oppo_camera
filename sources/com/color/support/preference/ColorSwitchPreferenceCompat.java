package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.preference.SwitchPreferenceCompat;
import color.support.v7.appcompat.R;
import com.color.support.widget.ColorSwitch;

public class ColorSwitchPreferenceCompat extends SwitchPreferenceCompat {

    /* renamed from: b  reason: collision with root package name */
    private final a f1973b;
    private boolean c;
    private Drawable d;
    private boolean e;
    private ColorSwitch f;

    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ColorSwitchPreferenceCompat.this.b() != z) {
                if (!ColorSwitchPreferenceCompat.this.d(Boolean.valueOf(z))) {
                    compoundButton.setChecked(!z);
                } else {
                    ColorSwitchPreferenceCompat.this.e(z);
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

    public ColorSwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle);
    }

    public ColorSwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ColorSwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f1973b = new a();
        this.c = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreference, i, 0);
        this.c = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_colorShowDivider, this.c);
        this.d = obtainStyledAttributes.getDrawable(R.styleable.ColorPreference_colorDividerDrawable);
        this.e = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_colorEnalbeClickSpan, false);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        r5 = (android.widget.TextView) r5.a(16908304);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.preference.l r5) {
        /*
            r4 = this;
            int r0 = color.support.v7.appcompat.R.id.color_preference
            android.view.View r0 = r5.a((int) r0)
            if (r0 == 0) goto L_0x000c
            r1 = 0
            r0.setSoundEffectsEnabled(r1)
        L_0x000c:
            int r0 = color.support.v7.appcompat.R.id.switchWidget
            android.view.View r0 = r5.a((int) r0)
            boolean r1 = r0 instanceof com.color.support.widget.ColorSwitch
            if (r1 == 0) goto L_0x001f
            r2 = r0
            com.color.support.widget.ColorSwitch r2 = (com.color.support.widget.ColorSwitch) r2
            r3 = 0
            r2.setOnCheckedChangeListener(r3)
            r4.f = r2
        L_0x001f:
            super.a((androidx.preference.l) r5)
            if (r1 == 0) goto L_0x002e
            com.color.support.widget.ColorSwitch r0 = (com.color.support.widget.ColorSwitch) r0
            r0.d()
            com.color.support.preference.ColorSwitchPreferenceCompat$a r1 = r4.f1973b
            r0.setOnCheckedChangeListener(r1)
        L_0x002e:
            boolean r0 = r4.e
            if (r0 == 0) goto L_0x005e
            r0 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r5 = r5.a((int) r0)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x005e
            android.content.Context r0 = r4.J()
            android.content.res.Resources r0 = r0.getResources()
            r1 = 17170445(0x106000d, float:2.461195E-38)
            int r0 = r0.getColor(r1)
            r5.setHighlightColor(r0)
            android.text.method.MovementMethod r0 = android.text.method.LinkMovementMethod.getInstance()
            r5.setMovementMethod(r0)
            com.color.support.preference.ColorSwitchPreferenceCompat$1 r0 = new com.color.support.preference.ColorSwitchPreferenceCompat$1
            r0.<init>(r5)
            r5.setOnTouchListener(r0)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.preference.ColorSwitchPreferenceCompat.a(androidx.preference.l):void");
    }

    /* access modifiers changed from: protected */
    public void g() {
        ColorSwitch colorSwitch = this.f;
        if (colorSwitch != null) {
            colorSwitch.setShouldPlaySound(true);
        }
        super.g();
    }
}
