package com.google.android.material.transition;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.animation.AnimationUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private final int axis;
    private final boolean forward;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }

    public static MaterialSharedAxis create(int i, boolean z) {
        return new MaterialSharedAxis(i, z);
    }

    private MaterialSharedAxis(int i, boolean z) {
        this.axis = i;
        this.forward = z;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        initialize();
    }

    public int getAxis() {
        return this.axis;
    }

    public boolean isEntering() {
        return this.forward;
    }

    /* access modifiers changed from: package-private */
    public VisibilityAnimatorProvider getDefaultPrimaryAnimatorProvider() {
        int i = this.axis;
        if (i == 0) {
            return new SlideDistanceProvider(this.forward ? 8388613 : 8388611);
        } else if (i == 1) {
            return new SlideDistanceProvider(this.forward ? 80 : 48);
        } else if (i == 2) {
            return new ScaleProvider(this.forward);
        } else {
            throw new IllegalArgumentException("Invalid axis: " + this.axis);
        }
    }

    public VisibilityAnimatorProvider getDefaultSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }
}
