package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.l;
import color.support.v7.appcompat.R;

public class ColorJumpPreference extends ColorPreference {

    /* renamed from: a  reason: collision with root package name */
    Context f1937a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f1938b;
    CharSequence c;
    CharSequence d;
    Drawable e;
    private int f;

    public ColorJumpPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f = 0;
        this.f1937a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorJumpPreference, i, 0);
        this.e = obtainStyledAttributes.getDrawable(R.styleable.ColorJumpPreference_color_jump_mark);
        this.f1938b = obtainStyledAttributes.getText(R.styleable.ColorJumpPreference_color_jump_status1);
        this.c = obtainStyledAttributes.getText(R.styleable.ColorJumpPreference_color_jump_status2);
        this.d = obtainStyledAttributes.getText(R.styleable.ColorJumpPreference_color_jump_status3);
        this.f = obtainStyledAttributes.getInt(R.styleable.ColorJumpPreference_colorClickStyle, 0);
        obtainStyledAttributes.recycle();
    }

    public ColorJumpPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ColorJumpPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorJumpPreferenceStyle);
    }

    public ColorJumpPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(l lVar) {
        int i;
        super.a(lVar);
        ImageView imageView = (ImageView) lVar.a(R.id.color_preference_widget_jump);
        if (imageView != null) {
            Drawable drawable = this.e;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View a2 = lVar.a(R.id.color_preference);
        if (!(a2 == null || (i = this.f) == 0)) {
            if (i == 1) {
                a2.setClickable(false);
            } else if (i == 2) {
                a2.setClickable(true);
            }
        }
        TextView textView = (TextView) lVar.a(R.id.color_statusText1);
        if (textView != null) {
            CharSequence charSequence = this.f1938b;
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) lVar.a(R.id.color_statusText2);
        if (textView2 != null) {
            CharSequence charSequence2 = this.c;
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) lVar.a(R.id.color_statusText3);
        if (textView3 != null) {
            CharSequence charSequence3 = this.d;
            if (!TextUtils.isEmpty(charSequence3)) {
                textView3.setText(charSequence3);
                textView3.setVisibility(0);
                return;
            }
            textView3.setVisibility(8);
        }
    }
}
