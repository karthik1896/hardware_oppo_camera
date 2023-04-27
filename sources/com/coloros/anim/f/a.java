package com.coloros.anim.f;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseAnimator */
public abstract class a extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f2450a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Animator.AnimatorListener> f2451b = new CopyOnWriteArraySet();

    public long getStartDelay() {
        throw new UnsupportedOperationException("EffectiveAnimator does not support getStartDelay.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setInterpolator.");
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2450a.add(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2450a.remove(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.f2450a.clear();
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f2451b.add(animatorListener);
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f2451b.remove(animatorListener);
    }

    public void removeAllListeners() {
        this.f2451b.clear();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        for (Animator.AnimatorListener next : this.f2451b) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationStart(this, z);
            } else {
                next.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (Animator.AnimatorListener onAnimationRepeat : this.f2451b) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        for (Animator.AnimatorListener next : this.f2451b) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationEnd(this, z);
            } else {
                next.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        for (Animator.AnimatorListener onAnimationCancel : this.f2451b) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        for (ValueAnimator.AnimatorUpdateListener onAnimationUpdate : this.f2450a) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }
}
