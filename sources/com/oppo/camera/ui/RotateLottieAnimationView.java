package com.oppo.camera.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;

public class RotateLottieAnimationView extends LottieAnimationView {

    /* renamed from: a  reason: collision with root package name */
    private int f3806a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3807b = 0;
    private int c = 0;
    private boolean d = false;
    private boolean e = true;
    private long f = 0;
    private long g = 0;

    public RotateLottieAnimationView(Context context) {
        super(context);
    }

    public RotateLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotateLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(int i, boolean z) {
        boolean z2 = false;
        if (getVisibility() == 0) {
            this.e = z;
        } else {
            this.e = false;
        }
        int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
        if (i2 != this.c) {
            this.c = i2;
            if (this.e) {
                this.f3807b = this.f3806a;
                this.f = AnimationUtils.currentAnimationTimeMillis();
                int i3 = this.c - this.f3806a;
                if (i3 < 0) {
                    i3 += 360;
                }
                if (i3 > 180) {
                    i3 -= 360;
                }
                if (i3 >= 0) {
                    z2 = true;
                }
                this.d = z2;
                this.g = this.f + ((long) ((Math.abs(i3) * 1000) / 270));
            } else {
                this.f3806a = this.c;
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.right - bounds.left;
            int i2 = bounds.bottom - bounds.top;
            if (i != 0 && i2 != 0) {
                if (this.f3806a != this.c) {
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    if (currentAnimationTimeMillis < this.g) {
                        int i3 = (int) (currentAnimationTimeMillis - this.f);
                        int i4 = this.f3807b;
                        if (!this.d) {
                            i3 = -i3;
                        }
                        int i5 = i4 + ((i3 * 270) / 1000);
                        this.f3806a = i5 >= 0 ? i5 % 360 : (i5 % 360) + 360;
                        invalidate();
                    } else {
                        this.f3806a = this.c;
                    }
                }
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int paddingRight = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                int width = (getWidth() - paddingLeft) - paddingRight;
                int height = (getHeight() - paddingTop) - paddingBottom;
                int saveCount = canvas.getSaveCount();
                if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i || height < i2)) {
                    float f2 = (float) width;
                    float f3 = (float) height;
                    float min = Math.min(f2 / ((float) i), f3 / ((float) i2));
                    canvas.scale(min, min, f2 * 0.5f, f3 * 0.5f);
                }
                canvas.translate((float) (paddingLeft + (width / 2)), (float) (paddingTop + (height / 2)));
                canvas.rotate((float) (-this.f3806a));
                canvas.translate((float) ((-i) / 2), (float) ((-i2) / 2));
                drawable.draw(canvas);
                canvas.restoreToCount(saveCount);
            }
        }
    }
}
