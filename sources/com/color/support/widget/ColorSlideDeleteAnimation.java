package com.color.support.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

public abstract class ColorSlideDeleteAnimation {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public View f2112a;

    public abstract void a();

    /* renamed from: com.color.support.widget.ColorSlideDeleteAnimation$1  reason: invalid class name */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorSlideDeleteAnimation f2113a;

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2113a.f2112a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* renamed from: com.color.support.widget.ColorSlideDeleteAnimation$2  reason: invalid class name */
    class AnonymousClass2 implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorSlideDeleteAnimation f2114a;

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f2114a.a();
        }
    }

    private static class ViewWrapper {

        /* renamed from: a  reason: collision with root package name */
        View f2115a;

        public int getHeight() {
            return this.f2115a.getLayoutParams().height;
        }

        public void setHeight(int i) {
            this.f2115a.getLayoutParams().height = i;
            this.f2115a.requestLayout();
        }
    }
}
