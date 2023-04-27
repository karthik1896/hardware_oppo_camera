package com.color.support.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import color.support.v7.appcompat.R;
import com.color.support.d.e;

public class ColorHintRedDot extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f2036a = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: b  reason: collision with root package name */
    private boolean f2037b;
    private int c;
    private int d;
    private int e;
    private e f;
    private RectF g;
    private String h;
    private int i;
    private int j;
    private boolean k;
    private ValueAnimator l;
    private int m;
    private boolean n;
    private ValueAnimator o;

    public ColorHintRedDot(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorHintRedDot(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorHintRedDotStyle);
    }

    public ColorHintRedDot(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.j = 255;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorHintRedDot, i2, 0);
        this.c = obtainStyledAttributes.getInteger(R.styleable.ColorHintRedDot_colorHintRedPointMode, 0);
        this.d = obtainStyledAttributes.getInteger(R.styleable.ColorHintRedDot_colorHintRedPointNum, 0);
        obtainStyledAttributes.recycle();
        this.f = new e(context, attributeSet, R.styleable.ColorHintRedDot, i2, 0);
        this.g = new RectF();
        this.h = getResources().getString(R.string.red_dot_description);
        this.i = R.plurals.red_dot_with_number_description;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.n) {
            i4 = this.m;
        } else {
            i4 = this.f.a(this.c, this.d);
        }
        setMeasuredDimension(i4, this.f.a(this.c));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f2037b = true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = (float) getWidth();
        this.g.bottom = (float) getHeight();
        if (!this.k || (this.d >= 1000 && this.e >= 1000)) {
            this.f.a(canvas, this.c, this.d, this.g);
            return;
        }
        e eVar = this.f;
        int i2 = this.d;
        int i3 = this.j;
        eVar.a(canvas, i2, i3, this.e, 255 - i3, this.g);
    }

    public boolean getIsLaidOut() {
        return this.f2037b;
    }

    public void setPointNumber(int i2) {
        this.d = i2;
        requestLayout();
        if (i2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(",");
            Resources resources = getResources();
            int i3 = this.i;
            int i4 = this.d;
            sb.append(resources.getQuantityString(i3, i4, new Object[]{Integer.valueOf(i4)}));
            setContentDescription(sb.toString());
        }
    }

    public void setPointMode(int i2) {
        if (this.c != i2) {
            this.c = i2;
            requestLayout();
            int i3 = this.c;
            if (i3 == 1) {
                setContentDescription(this.h);
            } else if (i3 == 0) {
                setContentDescription("");
            }
        }
    }

    public int getPointMode() {
        return this.c;
    }

    public int getPointNumber() {
        return this.d;
    }

    private void a() {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.l.end();
        }
        ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.o.end();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
        this.f2037b = false;
    }
}
