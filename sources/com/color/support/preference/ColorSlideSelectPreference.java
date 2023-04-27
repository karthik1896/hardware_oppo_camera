package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.l;
import color.support.v7.appcompat.R;

public class ColorSlideSelectPreference extends ColorPreference {

    /* renamed from: a  reason: collision with root package name */
    Context f1960a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f1961b;
    private int c;
    private TextView d;

    public ColorSlideSelectPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorSlideSelectPreferenceStyle);
    }

    public ColorSlideSelectPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ColorSlideSelectPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.c = 0;
        this.f1960a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorSlideSelectPreference, i, 0);
        this.f1961b = obtainStyledAttributes.getText(R.styleable.ColorSlideSelectPreference_color_select_status1);
        obtainStyledAttributes.recycle();
    }

    public void a(l lVar) {
        int i;
        super.a(lVar);
        View a2 = lVar.a(R.id.color_preference);
        a2.setTag(new Object());
        View findViewById = a2.findViewById(R.id.color_preference);
        if (!(findViewById == null || (i = this.c) == 0)) {
            if (i == 1) {
                findViewById.setClickable(false);
            } else if (i == 2) {
                findViewById.setClickable(true);
            }
        }
        this.d = (TextView) a2.findViewById(R.id.color_statusText_select);
        if (this.d != null) {
            CharSequence charSequence = this.f1961b;
            if (!TextUtils.isEmpty(charSequence)) {
                this.d.setText(charSequence);
                this.d.setVisibility(0);
                return;
            }
            this.d.setVisibility(8);
        }
    }
}
