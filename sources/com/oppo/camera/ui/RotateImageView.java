package com.oppo.camera.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.oppo.camera.R;
import com.oppo.camera.ui.inverse.a;

public class RotateImageView extends o implements a {

    /* renamed from: a  reason: collision with root package name */
    public int f3804a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f3805b = 0;
    public int c = 0;
    public boolean d = false;
    public boolean e = true;
    public long f = 0;
    public long g = 0;
    protected boolean h = false;

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public RotateImageView(Context context) {
        super(context);
    }

    public RotateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public int getDegree() {
        return this.c;
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
                this.f3805b = this.f3804a;
                this.f = AnimationUtils.currentAnimationTimeMillis();
                int i3 = this.c - this.f3804a;
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
                this.f3804a = this.c;
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
                if (this.f3804a != this.c) {
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    if (currentAnimationTimeMillis < this.g) {
                        int i3 = (int) (currentAnimationTimeMillis - this.f);
                        int i4 = this.f3805b;
                        if (!this.d) {
                            i3 = -i3;
                        }
                        int i5 = i4 + ((i3 * 270) / 1000);
                        this.f3804a = i5 >= 0 ? i5 % 360 : (i5 % 360) + 360;
                        invalidate();
                    } else {
                        this.f3804a = this.c;
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
                canvas.rotate((float) (-this.f3804a));
                canvas.translate((float) ((-i) / 2), (float) ((-i2) / 2));
                drawable.draw(canvas);
                canvas.restoreToCount(saveCount);
            }
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.h) {
            mergeDrawableStates(onCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return onCreateDrawableState;
    }

    public void setInverseColor(boolean z) {
        this.h = z;
        refreshDrawableState();
        invalidate();
    }
}
