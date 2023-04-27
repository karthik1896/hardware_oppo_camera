package com.color.support.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.color.support.widget.ColorEditText;

/* compiled from: ColorScrolledEditText */
public class a extends ColorEditText {

    /* renamed from: a  reason: collision with root package name */
    private int f2012a;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f2012a = (getLineHeight() * getMaxLines()) + getPaddingTop() + getPaddingBottom();
            if (getHeight() >= this.f2012a) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
