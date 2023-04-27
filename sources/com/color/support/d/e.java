package com.color.support.d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import color.support.v7.appcompat.R;

/* compiled from: ColorHintRedDotHelper */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private int f1859a;

    /* renamed from: b  reason: collision with root package name */
    private int f1860b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private TextPaint n = new TextPaint();
    private Paint o;

    public e(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.f1859a = obtainStyledAttributes.getColor(R.styleable.ColorHintRedDot_colorHintRedDotColor, 0);
        this.f1860b = obtainStyledAttributes.getColor(R.styleable.ColorHintRedDot_colorHintRedDotTextColor, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorHintRedDot_colorHintTextSize, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorHintRedDot_colorSmallWidth, 0);
        this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorHintRedDot_colorMediumWidth, 0);
        this.f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorHintRedDot_colorLargeWidth, 0);
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorHintRedDot_colorHeight, 0);
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorHintRedDot_colorCornerRadius, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorHintRedDot_colorDotDiameter, 0);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorHintRedDot_colorEllipsisDiameter, 0);
        obtainStyledAttributes.recycle();
        this.k = context.getResources().getDimensionPixelSize(R.dimen.color_hint_red_dot_rect_radius);
        this.g = context.getResources().getDimensionPixelSize(R.dimen.color_hint_red_dot_navi_small_width);
        this.m = context.getResources().getDimensionPixelSize(R.dimen.color_hint_red_dot_ellipsis_spacing);
        this.n.setAntiAlias(true);
        this.n.setColor(this.f1860b);
        this.n.setTextSize((float) this.c);
        this.n.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.o = new Paint();
        this.o.setAntiAlias(true);
        this.o.setColor(this.f1859a);
        this.o.setStyle(Paint.Style.FILL);
    }

    public void a(Canvas canvas, int i2, int i3, RectF rectF) {
        if (i2 == 0) {
            return;
        }
        if (i2 == 1) {
            a(canvas, rectF);
        } else if (i2 == 2 || i2 == 3) {
            a(canvas, i3, rectF);
        }
    }

    private void a(Canvas canvas, RectF rectF) {
        float f2 = (rectF.bottom - rectF.top) / 2.0f;
        canvas.drawCircle(rectF.left + f2, rectF.top + f2, f2, this.o);
    }

    private void a(Canvas canvas, int i2, RectF rectF) {
        Path path;
        if (i2 > 0) {
            if (Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top) < ((float) (this.i * 2))) {
                path = l.a().a(rectF, 0.0f);
            } else {
                path = l.a().a(rectF, (float) this.i);
            }
            canvas.drawPath(path, this.o);
            b(canvas, i2, 255, rectF);
        }
    }

    public void a(Canvas canvas, int i2, int i3, int i4, int i5, RectF rectF) {
        canvas.drawPath(l.a().a(rectF, (float) this.i), this.o);
        if (i3 > i5) {
            b(canvas, i2, i3, rectF);
            b(canvas, i4, i5, rectF);
            return;
        }
        b(canvas, i4, i5, rectF);
        b(canvas, i2, i3, rectF);
    }

    private void b(Canvas canvas, int i2, int i3, RectF rectF) {
        if (i2 > 0) {
            this.n.setAlpha(Math.max(0, Math.min(255, i3)));
            if (i2 < 1000) {
                String valueOf = String.valueOf(i2);
                Paint.FontMetricsInt fontMetricsInt = this.n.getFontMetricsInt();
                canvas.drawText(valueOf, rectF.left + (((rectF.right - rectF.left) - ((float) ((int) this.n.measureText(valueOf)))) / 2.0f), (((rectF.top + rectF.bottom) - ((float) fontMetricsInt.ascent)) - ((float) fontMetricsInt.descent)) / 2.0f, this.n);
                return;
            }
            float f2 = (rectF.left + rectF.right) / 2.0f;
            float f3 = (rectF.top + rectF.bottom) / 2.0f;
            for (int i4 = -1; i4 <= 1; i4++) {
                int i5 = this.m;
                int i6 = this.l;
                canvas.drawCircle(((float) ((i5 + i6) * i4)) + f2, f3, ((float) i6) / 2.0f, this.n);
            }
        }
    }

    public int a(int i2, int i3) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return this.j;
        }
        if (i2 == 2) {
            return b(i3);
        }
        if (i2 != 3) {
            return 0;
        }
        return c(i3);
    }

    public int a(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return this.j;
        }
        if (i2 == 2) {
            return a();
        }
        if (i2 != 3) {
            return 0;
        }
        return this.e / 2;
    }

    private int b(int i2) {
        if (i2 < 10) {
            return this.d;
        }
        if (i2 < 100) {
            return this.e;
        }
        if (i2 < 1000) {
            return this.f;
        }
        return this.e;
    }

    private int c(int i2) {
        if (i2 < 10) {
            return this.g;
        }
        if (i2 < 100) {
            return this.d;
        }
        return this.e;
    }

    private int a() {
        return this.h;
    }
}
