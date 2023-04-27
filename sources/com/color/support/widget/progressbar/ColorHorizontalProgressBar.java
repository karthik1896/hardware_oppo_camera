package com.color.support.widget.progressbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import color.support.v7.appcompat.R;
import com.color.support.d.c;
import com.color.support.d.n;

public class ColorHorizontalProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2264a = Color.argb(12, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    private static final int f2265b = Color.parseColor("#FF2AD181");
    private Paint c;
    private ColorStateList d;
    private ColorStateList e;
    private RectF f;
    private RectF g;
    private int h;
    private Path i;
    private Path j;

    public ColorHorizontalProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorHorizontalProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorHorizontalProgressBarStyle);
    }

    public ColorHorizontalProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, R.attr.colorHorizontalProgressBarStyle);
        this.c = new Paint();
        this.f = new RectF();
        this.g = new RectF();
        this.h = Integer.MAX_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorHorizontalProgressBar, i2, 0);
        this.d = obtainStyledAttributes.getColorStateList(R.styleable.ColorHorizontalProgressBar_colorHorizontalProgressBarBackgroundColor);
        if (Build.VERSION.SDK_INT >= 23) {
            this.e = obtainStyledAttributes.getColorStateList(R.styleable.ColorHorizontalProgressBar_colorHorizontalProgressBarProgressColor);
        } else {
            this.e = n.a(c.a(context, R.attr.colorTintControlNormal, 0), getResources().getColor(R.color.color_seekbar_progress_color_disabled));
        }
        obtainStyledAttributes.recycle();
        this.c.setDither(true);
        this.c.setAntiAlias(true);
        setLayerType(1, this.c);
        this.i = new Path();
        this.j = new Path();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int paddingRight = (i2 - getPaddingRight()) - getPaddingLeft();
        int paddingTop = (i3 - getPaddingTop()) - getPaddingBottom();
        this.h = paddingRight >= paddingTop ? paddingTop / 2 : paddingRight / 2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.j.reset();
        this.i.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.c.setColor(a(this.d, f2264a));
        this.f.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
        RectF rectF = this.f;
        int i2 = this.h;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.c);
        Path path = this.i;
        RectF rectF2 = this.f;
        int i3 = this.h;
        path.addRoundRect(rectF2, (float) i3, (float) i3, Path.Direction.CCW);
        boolean z = Build.VERSION.SDK_INT >= 19;
        float progress = ((float) getProgress()) / ((float) getMax());
        if (a()) {
            if (z) {
                int round = Math.round(((float) (getWidth() - getPaddingRight())) - (progress * ((float) width)));
                this.g.set((float) round, (float) getPaddingTop(), (float) (round + width), (float) (getHeight() - getPaddingBottom()));
            } else {
                this.g.set(((float) getPaddingLeft()) + ((1.0f - progress) * ((float) width)), (float) getPaddingTop(), (float) (getPaddingLeft() + width), (float) (getHeight() - getPaddingBottom()));
            }
        } else if (z) {
            int round2 = Math.round(((float) getPaddingLeft()) - ((1.0f - progress) * ((float) width)));
            this.g.set((float) round2, (float) getPaddingTop(), (float) (round2 + width), (float) (getHeight() - getPaddingBottom()));
        } else {
            this.g.set((float) getPaddingLeft(), (float) getPaddingTop(), ((float) getPaddingLeft()) + (progress * ((float) width)), (float) (getHeight() - getPaddingBottom()));
        }
        this.c.setColor(a(this.e, f2265b));
        if (Build.VERSION.SDK_INT >= 19) {
            Path path2 = this.j;
            RectF rectF3 = this.g;
            int i4 = this.h;
            path2.addRoundRect(rectF3, (float) i4, (float) i4, Path.Direction.CCW);
            this.j.op(this.i, Path.Op.INTERSECT);
            canvas.drawPath(this.j, this.c);
            return;
        }
        RectF rectF4 = this.g;
        int i5 = this.h;
        canvas.drawRoundRect(rectF4, (float) i5, (float) i5, this.c);
    }

    private int a(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            return i2;
        }
        return colorStateList.getColorForState(getDrawableState(), i2);
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT <= 16 || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }
}
