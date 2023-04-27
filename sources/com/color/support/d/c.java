package com.color.support.d;

import android.content.Context;
import android.content.res.TypedArray;

/* compiled from: ColorContextUtil */
public class c {
    public static int a(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int color2 = obtainStyledAttributes.getColor(0, i2);
        obtainStyledAttributes.recycle();
        return color2;
    }
}
