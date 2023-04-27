package com.color.support.widget;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import color.support.v7.appcompat.R;
import com.color.support.d.b;
import com.color.support.d.c;
import com.color.support.d.d;
import com.color.support.d.l;

public class ColorButton extends f {

    /* renamed from: a  reason: collision with root package name */
    private static String f2013a = "ColorButton";

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f2014b;
    private ValueAnimator c;
    /* access modifiers changed from: private */
    public boolean e;
    private boolean f;
    private final Paint g;
    private int h;
    private int i;
    private float j;
    private float k;
    /* access modifiers changed from: private */
    public float l;
    /* access modifiers changed from: private */
    public float m;
    private Rect n;
    private float[] o;

    public ColorButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842824);
    }

    public ColorButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = new Paint(1);
        this.j = 21.0f;
        this.l = 1.0f;
        this.m = 1.0f;
        this.n = new Rect();
        this.o = new float[3];
        d.a(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorButton, i2, 0);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.ColorButton_animColorEnable, false);
        if (this.f) {
            this.k = obtainStyledAttributes.getFloat(R.styleable.ColorButton_brightness, 1.2f);
            this.j = obtainStyledAttributes.getDimension(R.styleable.ColorButton_drawableRadius, 7.0f);
            this.i = obtainStyledAttributes.getColor(R.styleable.ColorButton_disabledColor, context.getResources().getColor(R.color.color_btn_drawable_color_disabled));
            this.h = obtainStyledAttributes.getColor(R.styleable.ColorButton_drawableColor, c.a(context, R.attr.colorTintControlNormal, 0));
            a();
        }
        obtainStyledAttributes.recycle();
        b.a((TextView) this, 4);
    }

    private void a() {
        setBackgroundDrawable((Drawable) null);
        this.f2014b = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.n.right = getWidth();
        this.n.bottom = getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.g.setColor(a(this.h));
            canvas.drawPath(l.a().a(this.n, this.j), this.g);
            canvas.restoreToCount(save);
        }
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a(true);
            } else if (action == 1 || action == 3) {
                a(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public void a(final boolean z) {
        this.e = false;
        b(z);
        if (!this.e) {
            float[] fArr = new float[2];
            float f2 = 1.0f;
            fArr[0] = z ? 1.0f : this.l;
            fArr[1] = z ? this.k : 1.0f;
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
            float[] fArr2 = new float[2];
            fArr2[0] = z ? 1.0f : this.m;
            if (z) {
                f2 = 0.9f;
            }
            fArr2[1] = f2;
            this.c = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, PropertyValuesHolder.ofFloat("scaleHolder", fArr2)});
            this.c.setInterpolator(this.f2014b);
            this.c.setDuration(200);
            this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = ColorButton.this.m = ((Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                    if (!ColorButton.this.e || !z || ColorButton.this.m > 0.99f) {
                        float unused2 = ColorButton.this.l = ((Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                        ColorButton colorButton = ColorButton.this;
                        colorButton.setScale(colorButton.m);
                        return;
                    }
                    valueAnimator.cancel();
                    ColorButton.this.a(false);
                }
            });
            this.c.start();
        }
    }

    /* access modifiers changed from: private */
    public void setScale(float f2) {
        float max = Math.max(0.9f, Math.min(1.0f, f2));
        setScaleX(max);
        setScaleY(max);
        invalidate();
    }

    private void b(boolean z) {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.e = !z && this.m > 0.99f;
            if (!this.e) {
                this.c.cancel();
            }
        }
    }

    private int a(int i2) {
        if (!isEnabled()) {
            return this.i;
        }
        androidx.core.graphics.d.a(i2, this.o);
        float[] fArr = this.o;
        fArr[2] = fArr[2] * this.l;
        int a2 = androidx.core.graphics.d.a(fArr);
        return Color.argb(Color.alpha(i2), Math.min(255, Color.red(a2)), Math.min(255, Color.green(a2)), Math.min(255, Color.blue(a2)));
    }

    public void setAnimColorEnable(boolean z) {
        this.f = z;
    }
}
