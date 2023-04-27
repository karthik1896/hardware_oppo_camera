package com.oppo.camera.ui.inverse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

public class InverseMaskView extends View implements a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4016a = false;

    /* renamed from: b  reason: collision with root package name */
    private Paint f4017b = null;
    private float c = 1.0f;
    private float d = 1.0f;
    private float e = 0.5f;
    private float f = 0.5f;
    private boolean g = true;
    private ValueAnimator h = null;
    /* access modifiers changed from: private */
    public ValueAnimator i = null;
    private ValueAnimator j = null;

    public InverseMaskView(Context context) {
        super(context);
        a(context);
    }

    public InverseMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public InverseMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f4017b = new Paint();
        this.f4017b.setAntiAlias(true);
    }

    public void setInverseColor(final boolean z) {
        this.f4016a = z;
        post(new Runnable() {
            public void run() {
                InverseMaskView.this.setVisibility(z ? 0 : 8);
                InverseMaskView.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4016a) {
            int E = Util.E();
            this.f4017b.setColor(c.INS.getInverseColor());
            this.f4017b.setBlendMode(BlendMode.SRC_OVER);
            this.f4017b.setAlpha(204);
            float f2 = (float) E;
            canvas.drawRect(0.0f, 0.0f, f2, (float) Util.v(), this.f4017b);
            this.f4017b.setAlpha((int) (this.d * 204.0f));
            canvas.drawRect(0.0f, (float) Util.v(), f2, (float) (Util.C() - Util.w()), this.f4017b);
            this.f4017b.setColor(-1);
            this.f4017b.setBlendMode(BlendMode.DST_OUT);
            float f3 = f2 / 2.0f;
            canvas.drawCircle(f3, ((float) Util.v()) + f3 + (((float) (((Util.C() - Util.w()) - Util.v()) - E)) * this.e), this.c * f3, this.f4017b);
        }
    }

    public void setMaskAlpha(float f2) {
        if (this.g) {
            this.d = f2;
            invalidate();
        }
    }

    public void a(boolean z, boolean z2) {
        this.g = z;
        if (z2) {
            ValueAnimator valueAnimator = this.h;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.h.cancel();
            }
            if (z) {
                this.h = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            } else {
                this.h = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            }
            this.h.setDuration(200);
            this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(z) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    InverseMaskView.this.a(this.f$1, valueAnimator);
                }
            });
            this.h.start();
            return;
        }
        this.d = z ? 1.0f : 0.0f;
        invalidate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if ((z && floatValue > this.d) || (!z && floatValue < this.d)) {
            this.d = floatValue;
            invalidate();
        }
    }

    public void a() {
        final ValueAnimator[] valueAnimatorArr = {ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(83), ValueAnimator.ofFloat(new float[]{0.0f, 0.0f}).setDuration(65), ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(185)};
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(getContext(), R.anim.inverse_interpolator);
        int i2 = 0;
        while (i2 < valueAnimatorArr.length) {
            ValueAnimator valueAnimator = valueAnimatorArr[i2];
            valueAnimator.setInterpolator(loadInterpolator);
            final int i3 = i2 < valueAnimatorArr.length - 1 ? i2 + 1 : -1;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    int i = i3;
                    if (i > 0) {
                        ValueAnimator unused = InverseMaskView.this.i = valueAnimatorArr[i];
                        InverseMaskView.this.i.start();
                    }
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    InverseMaskView.this.b(valueAnimator);
                }
            });
            i2++;
        }
        this.i = valueAnimatorArr[0];
        this.i.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void a(float f2, boolean z) {
        if (this.f != f2) {
            this.f = f2;
            if (z) {
                ValueAnimator valueAnimator = this.j;
                if (valueAnimator == null) {
                    this.j = ValueAnimator.ofFloat(new float[]{this.e, f2}).setDuration(300);
                    this.j.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.inverse_interpolator));
                    this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            InverseMaskView.this.a(valueAnimator);
                        }
                    });
                } else {
                    if (valueAnimator.isRunning()) {
                        this.j.cancel();
                    }
                    this.j.setFloatValues(new float[]{this.e, f2});
                }
                this.j.start();
                return;
            }
            this.e = f2;
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }
}
