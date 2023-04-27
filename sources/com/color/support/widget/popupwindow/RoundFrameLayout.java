package com.color.support.widget.popupwindow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import color.support.v7.appcompat.R;

public class RoundFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Path f2252a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f2253b;
    private RectF c;
    private float d;

    public RoundFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundFrameLayout);
        this.d = obtainStyledAttributes.getDimension(R.styleable.RoundFrameLayout_rfRadius, 0.0f);
        obtainStyledAttributes.recycle();
        this.f2252a = new Path();
        this.f2253b = new Paint(1);
        this.c = new RectF();
        this.f2253b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void setRadius(float f) {
        this.d = f;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i - getPaddingRight()), (float) (i2 - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    private void a(Canvas canvas) {
        canvas.saveLayer(this.c, (Paint) null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(a(), this.f2253b);
        canvas.restore();
    }

    private void b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(a());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private Path a() {
        this.f2252a.reset();
        Path path = this.f2252a;
        RectF rectF = this.c;
        float f = this.d;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        return this.f2252a;
    }
}
