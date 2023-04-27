package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.ListPreference;
import androidx.preference.l;
import color.support.v7.appcompat.R;

public class ColorListPreference extends ListPreference {

    /* renamed from: a  reason: collision with root package name */
    Context f1939a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f1940b;
    CharSequence c;
    CharSequence d;
    Drawable e;
    CharSequence[] f;
    private CharSequence g;

    public ColorListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1939a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorJumpPreference, 0, 0);
        this.e = obtainStyledAttributes.getDrawable(R.styleable.ColorJumpPreference_color_jump_mark);
        this.f1940b = obtainStyledAttributes.getText(R.styleable.ColorJumpPreference_color_jump_status1);
        this.c = obtainStyledAttributes.getText(R.styleable.ColorJumpPreference_color_jump_status2);
        this.d = obtainStyledAttributes.getText(R.styleable.ColorJumpPreference_color_jump_status3);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreference, 0, 0);
        this.g = obtainStyledAttributes2.getText(R.styleable.ColorPreference_colorAssignment);
        obtainStyledAttributes2.recycle();
    }

    public ColorListPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(l lVar) {
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
        TextView textView = (TextView) lVar.a(R.id.color_statusText1);
        if (textView != null) {
            CharSequence charSequence = this.f1940b;
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
            } else {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = (TextView) lVar.a(R.id.assignment);
        if (textView4 != null) {
            CharSequence h = h();
            if (!TextUtils.isEmpty(h)) {
                textView4.setText(h);
                textView4.setVisibility(0);
                return;
            }
            textView4.setVisibility(8);
        }
    }

    public CharSequence h() {
        return this.g;
    }

    public void c(CharSequence charSequence) {
        if (!TextUtils.equals(this.g, charSequence)) {
            this.g = charSequence;
            i();
        }
    }

    public void c(CharSequence[] charSequenceArr) {
        this.f = charSequenceArr;
    }

    /* access modifiers changed from: package-private */
    public CharSequence[] T() {
        return this.f;
    }
}
