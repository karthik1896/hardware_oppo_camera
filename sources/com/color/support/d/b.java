package com.color.support.d;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

/* compiled from: ColorChangeTextUtil */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f1858a = {0.9f, 1.0f, 1.1f, 1.25f, 1.45f, 1.65f};

    public static float a(float f, float f2, int i) {
        float f3;
        if (i < 2) {
            return f;
        }
        float[] fArr = f1858a;
        if (i > fArr.length) {
            i = fArr.length;
        }
        float f4 = f / f2;
        if (i == 2) {
            return f2 < 1.1f ? f4 * 1.0f : f4 * 1.1f;
        }
        if (i != 3) {
            float[] fArr2 = f1858a;
            int i2 = i - 1;
            if (f2 <= fArr2[i2]) {
                return f4 * f2;
            }
            f3 = fArr2[i2];
        } else if (f2 < 1.1f) {
            return f4 * 1.0f;
        } else {
            if (f2 < 1.45f) {
                return f4 * 1.1f;
            }
            f3 = 1.25f;
        }
        return f4 * f3;
    }

    public static void a(TextView textView, boolean z) {
        if (textView == null) {
            return;
        }
        if (g.a() < 12) {
            textView.getPaint().setFakeBoldText(z);
        } else {
            textView.setTypeface(z ? Typeface.create("sans-serif-medium", 0) : Typeface.DEFAULT);
        }
    }

    public static void a(Paint paint, boolean z) {
        if (paint == null) {
            return;
        }
        if (g.a() < 12) {
            paint.setFakeBoldText(z);
        } else {
            paint.setTypeface(z ? Typeface.create("sans-serif-medium", 0) : Typeface.DEFAULT);
        }
    }

    public static void a(TextView textView, int i) {
        textView.setTextSize(0, a(textView.getTextSize(), textView.getResources().getConfiguration().fontScale, i));
    }
}
