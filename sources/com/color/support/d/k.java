package com.color.support.d;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;

/* compiled from: ColorPressFeedbackUtil */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final PathInterpolator f1870a = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    public static ScaleAnimation a(View view) {
        if (view != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, ((float) view.getWidth()) / 2.0f, ((float) view.getHeight()) / 2.0f);
            scaleAnimation.setDuration(200);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setInterpolator(f1870a);
            return scaleAnimation;
        }
        throw new IllegalArgumentException("The given view is empty. Please provide a valid view.");
    }

    public static ValueAnimator a() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.9f});
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(f1870a);
        return ofFloat;
    }

    public static ScaleAnimation a(View view, float f) {
        if (view != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, f, 1.0f, ((float) view.getWidth()) / 2.0f, ((float) view.getHeight()) / 2.0f);
            scaleAnimation.setDuration(200);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setInterpolator(f1870a);
            return scaleAnimation;
        }
        throw new IllegalArgumentException("The given view is empty. Please provide a valid view.");
    }
}
