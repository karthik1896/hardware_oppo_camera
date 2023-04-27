package com.oppo.camera.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RotableTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f3802a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3803b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private boolean g = true;
    private long h = 0;
    private long i = 0;

    public RotableTextView(Context context) {
        super(context);
    }

    public RotableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public RotableTextView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void setBottomMargin(int i2) {
        this.e = i2;
        this.d = ((RelativeLayout.LayoutParams) getLayoutParams()).bottomMargin;
    }

    public void a(int i2, boolean z) {
        boolean z2 = false;
        if (isShown()) {
            this.g = z;
        } else {
            this.g = false;
        }
        int i3 = i2 >= 0 ? i2 % 360 : (i2 % 360) + 360;
        if (i3 != this.c) {
            this.c = i3;
            if (this.g) {
                this.f3803b = this.f3802a;
                this.h = AnimationUtils.currentAnimationTimeMillis();
                int i4 = this.c - this.f3802a;
                if (i4 < 0) {
                    i4 += 360;
                }
                if (i4 > 180) {
                    i4 -= 360;
                }
                if (i4 >= 0) {
                    z2 = true;
                }
                this.f = z2;
                this.i = this.h + ((long) ((Math.abs(i4) * 1000) / 270));
            } else {
                this.f3802a = this.c;
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (this.f3802a != this.c) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.i) {
                int i3 = (int) (currentAnimationTimeMillis - this.h);
                int i4 = this.f3803b;
                if (!this.f) {
                    i3 = -i3;
                }
                int i5 = i4 + ((i3 * 270) / 1000);
                int i6 = i5 >= 0 ? i5 % 360 : (i5 % 360) + 360;
                this.f3802a = i6;
                if (this.e > 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                    if (!this.f || this.c >= (i2 = this.f3803b)) {
                        int i7 = this.d;
                        layoutParams.bottomMargin = i7 - ((int) (((float) (i7 - this.e)) * (((float) Math.abs(i6 - this.f3803b)) / ((float) Math.abs(this.c - this.f3803b)))));
                    } else {
                        int i8 = this.d;
                        layoutParams.bottomMargin = i8 - ((int) (((float) (i8 - this.e)) * (((float) Math.abs(i6 - i2)) / ((float) Math.abs((this.c + 360) - this.f3803b)))));
                    }
                    setLayoutParams(layoutParams);
                }
                invalidate();
            } else {
                this.f3802a = this.c;
                if (this.e > 0) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
                    layoutParams2.bottomMargin = this.e;
                    setLayoutParams(layoutParams2);
                }
            }
        }
        setRotation((float) (-this.f3802a));
    }
}
