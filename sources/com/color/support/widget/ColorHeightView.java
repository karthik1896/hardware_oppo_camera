package com.color.support.widget;

import android.view.View;
import android.view.ViewGroup;

public class ColorHeightView {

    /* renamed from: a  reason: collision with root package name */
    private View f2035a;

    public void setHeight(int i) {
        View view = this.f2035a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            this.f2035a.setLayoutParams(layoutParams);
        }
    }

    public int getHeight() {
        View view = this.f2035a;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }
}
