package com.color.support.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.color.support.d.f;
import com.color.support.d.j;

public class ColorMaxHeightDraggableVerticalLinearLayout extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f2075a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f2076b = 0;
    private boolean c = j.d(getContext());
    private int d;
    private ViewTreeObserver.OnGlobalLayoutListener e;

    public ColorMaxHeightDraggableVerticalLinearLayout(Context context) {
        super(context);
    }

    public ColorMaxHeightDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorMaxHeightDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f2076b;
        if (i3 > 0 && mode != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, size), mode);
        }
        super.onMeasure(i, i2);
    }

    public void a() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.f2076b == 0) {
            this.f2076b = j.b(getContext(), (Configuration) null);
        }
        layoutParams.height = this.f2076b;
        setLayoutParams(layoutParams);
    }

    public int getMaxHeight() {
        return this.f2076b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2076b = j.b(getContext(), (Configuration) null);
        Activity a2 = j.a(getContext());
        if (a2 != null && j.b(a2)) {
            this.e = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    int a2;
                    Activity a3 = j.a(ColorMaxHeightDraggableVerticalLinearLayout.this.getContext());
                    int a4 = j.a(a3, (Configuration) null);
                    int b2 = j.b(ColorMaxHeightDraggableVerticalLinearLayout.this.getContext()) - (f.b(ColorMaxHeightDraggableVerticalLinearLayout.this.getContext()) ? f.c(ColorMaxHeightDraggableVerticalLinearLayout.this.getContext()) : 0);
                    if (j.b(a3) && a4 != 0 && a4 != ColorMaxHeightDraggableVerticalLinearLayout.this.f2075a && a4 >= b2 / 4 && ColorMaxHeightDraggableVerticalLinearLayout.this.f2076b != (a2 = j.a(a3, a4)) && a2 != 0 && ColorMaxHeightDraggableVerticalLinearLayout.this.isAttachedToWindow()) {
                        int unused = ColorMaxHeightDraggableVerticalLinearLayout.this.f2076b = a2;
                        ColorMaxHeightDraggableVerticalLinearLayout.this.requestLayout();
                    }
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(this.e);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.e != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.e);
            this.e = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean a2 = j.a(configuration);
        if (this.c != a2) {
            this.c = a2;
            this.f2076b = j.b(getContext(), configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (this.d == 8 && i == 0) {
            measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f2076b, Integer.MIN_VALUE));
        }
        this.d = i;
        super.onWindowVisibilityChanged(i);
    }
}
