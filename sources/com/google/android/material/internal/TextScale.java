package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.m;
import androidx.transition.t;
import java.util.Map;

public class TextScale extends m {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public void captureStartValues(t tVar) {
        captureValues(tVar);
    }

    public void captureEndValues(t tVar) {
        captureValues(tVar);
    }

    private void captureValues(t tVar) {
        if (tVar.f1312b instanceof TextView) {
            tVar.f1311a.put(PROPNAME_SCALE, Float.valueOf(((TextView) tVar.f1312b).getScaleX()));
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, t tVar, t tVar2) {
        if (tVar == null || tVar2 == null || !(tVar.f1312b instanceof TextView) || !(tVar2.f1312b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) tVar2.f1312b;
        Map<String, Object> map = tVar.f1311a;
        Map<String, Object> map2 = tVar2.f1311a;
        float f = 1.0f;
        float floatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (map2.get(PROPNAME_SCALE) != null) {
            f = ((Float) map2.get(PROPNAME_SCALE)).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
