package com.oppo.camera.util;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;

/* compiled from: PressFeedbackHelper */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final PathInterpolator f4621a = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    public static ScaleAnimation a(View view) {
        if (view == null) {
            com.oppo.camera.e.d("PressFeedbackHelper", "generatePressAnimation, The given view is empty. Please provide a valid view.");
            return null;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, ((float) view.getWidth()) / 2.0f, ((float) view.getHeight()) / 2.0f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(f4621a);
        return scaleAnimation;
    }

    public static ValueAnimator a() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.9f});
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(f4621a);
        return ofFloat;
    }

    public static ScaleAnimation a(View view, float f) {
        if (view == null) {
            com.oppo.camera.e.d("PressFeedbackHelper", "generateResumeAnimation, The given view is empty. Please provide a valid view.");
            return null;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, f, 1.0f, ((float) view.getWidth()) / 2.0f, ((float) view.getHeight()) / 2.0f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(f4621a);
        return scaleAnimation;
    }

    public static float b(View view) {
        if (view == null) {
            com.oppo.camera.e.d("PressFeedbackHelper", "getGuaranteedAnimationValue, The given view is empty. Please provide a valid view.");
            return 0.0f;
        } else if (view.getHeight() >= 600) {
            return 0.993f;
        } else {
            if (((float) view.getHeight()) >= 156.0f) {
                return 0.965f;
            }
            return 0.99f;
        }
    }
}
