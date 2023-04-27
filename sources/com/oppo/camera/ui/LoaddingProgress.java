package com.oppo.camera.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class LoaddingProgress extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private ObjectAnimator f3793a = null;

    public LoaddingProgress(Context context) {
        super(context);
        b();
    }

    public LoaddingProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public LoaddingProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.f3793a = ObjectAnimator.ofFloat(this, "rotation", new float[]{0.0f, 360.0f});
        this.f3793a.setDuration(1000);
        this.f3793a.setRepeatCount(-1);
        this.f3793a.setInterpolator(linearInterpolator);
    }

    public void a() {
        ObjectAnimator objectAnimator = this.f3793a;
        if (objectAnimator != null && !objectAnimator.isRunning() && !this.f3793a.isStarted()) {
            this.f3793a.start();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f3793a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }
}
