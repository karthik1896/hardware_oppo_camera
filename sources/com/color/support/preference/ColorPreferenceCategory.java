package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.preference.PreferenceCategory;
import androidx.preference.l;
import color.support.v7.appcompat.R;

public class ColorPreferenceCategory extends PreferenceCategory {

    /* renamed from: b  reason: collision with root package name */
    private boolean f1950b;
    private int c;

    public ColorPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreferenceCategory, 0, 0);
        this.f1950b = obtainStyledAttributes.getBoolean(R.styleable.ColorPreferenceCategory_isFirstCategory, false);
        this.c = context.getResources().getDimensionPixelSize(R.dimen.support_preference_category_padding_top);
        obtainStyledAttributes.recycle();
    }

    public void a(l lVar) {
        super.a(lVar);
        if (this.f1950b) {
            a(lVar, R.id.oppo_category_top_divider, 8, R.id.oppo_category_root, this.c);
            return;
        }
        a(lVar, R.id.oppo_category_top_divider, 0, R.id.oppo_category_root, 0);
    }

    private void a(l lVar, int i, int i2, int i3, int i4) {
        View a2 = lVar.a(i);
        if (a2 != null) {
            a2.setVisibility(i2);
            LinearLayout linearLayout = (LinearLayout) lVar.a(i3);
            if (linearLayout != null) {
                linearLayout.setPadding(0, i4, 0, 0);
            }
        }
    }
}
