package com.color.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import color.support.v7.appcompat.R;

/* compiled from: ColorDraggableVerticalLinearLayout */
public class c extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f2163a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2164b = false;
    private float c = 0.0f;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;

    public c(Context context) {
        super(context);
        a();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
        a();
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
        a();
    }

    public c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(attributeSet);
        a();
    }

    private void a(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorDraggableVerticalLinearLayout);
            this.f2164b = obtainStyledAttributes.getBoolean(R.styleable.ColorDraggableVerticalLinearLayout_hasShadowNinePatchDrawable, false);
            obtainStyledAttributes.recycle();
        }
    }

    private void a() {
        setOrientation(1);
        this.f2163a = new ImageView(getContext());
        int dimension = (int) getResources().getDimension(R.dimen.color_panel_drag_view_size);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 1;
        this.f2163a.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2163a.setForceDarkAllowed(false);
        }
        this.f2163a.setImageDrawable(getResources().getDrawable(R.drawable.color_panel_drag_view, getContext().getTheme()));
        b();
        addView(this.f2163a);
        if (this.f2164b) {
            setBackground(getContext().getDrawable(R.drawable.color_panel_bg_with_shadow));
        } else {
            setBackground(getContext().getDrawable(R.drawable.color_panel_bg_without_shadow));
        }
    }

    private void b() {
        this.c = getElevation();
        this.d = getPaddingLeft();
        this.e = getPaddingTop();
        this.f = getPaddingRight();
        this.g = getPaddingBottom();
    }

    public void setOrientation(int i) {
        super.setOrientation(1);
    }

    public ImageView getDragView() {
        return this.f2163a;
    }

    public void setHasShadowNinePatchDrawable(boolean z) {
        this.f2164b = z;
        if (this.f2164b) {
            setBackground(getContext().getDrawable(R.drawable.color_panel_bg_with_shadow));
            setElevation(0.0f);
        } else {
            setBackground(getContext().getDrawable(R.drawable.color_panel_bg_without_shadow));
            setPadding(this.d, this.e, this.f, this.g);
            setElevation(this.c);
        }
        invalidate();
    }
}
