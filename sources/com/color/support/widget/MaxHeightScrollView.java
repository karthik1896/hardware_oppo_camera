package com.color.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import color.support.v7.appcompat.R;

public class MaxHeightScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private int f2138a;

    public MaxHeightScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightScrollView);
        this.f2138a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaxHeightScrollView_scrollViewMaxHeight, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f2138a;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, size), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        this.f2138a = i;
        requestLayout();
    }
}
