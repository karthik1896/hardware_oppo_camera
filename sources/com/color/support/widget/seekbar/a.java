package com.color.support.widget.seekbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: SeekBarHelper */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final int f2274a = Color.argb(12, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    static final int f2275b = Color.parseColor("#4D4D4D");
    static final int c = Color.argb(76, 255, 255, 255);

    static int a(View view, ColorStateList colorStateList, int i) {
        if (colorStateList == null) {
            return i;
        }
        return colorStateList.getColorForState(view.getDrawableState(), i);
    }

    static int a(View view, ColorStateList colorStateList) {
        return a(view, colorStateList, f2274a);
    }

    static boolean a(MotionEvent motionEvent, View view) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x >= ((float) view.getPaddingLeft()) && x <= ((float) (view.getWidth() - view.getPaddingRight())) && y >= 0.0f && y <= ((float) view.getHeight());
    }
}
