package com.oppo.camera.ui.menu.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

/* compiled from: HeadlineBackground */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f4067a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4068b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private Paint g = null;
    private float h = 1.0f;
    private int i = 0;

    public a(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.c = context.getResources().getDimensionPixelSize(R.dimen.head_line_background_radius);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.head_line_check_line_width);
        this.f = context.getResources().getDimensionPixelSize(R.dimen.head_line_background_padding);
        this.i = Util.s(context);
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setColor(this.i);
        e.a("HeadlineBackground", "initialize, mBackgroundRadius: " + this.c);
    }

    public void a(int i2, int i3) {
        e.a("HeadlineBackground", "updateView, width: " + i2 + ", height: " + i3);
        this.f4067a = i2;
        this.f4068b = i3;
        this.e = this.f4067a - this.f;
    }

    public void setVisibility(int i2) {
        e.a("HeadlineBackground", "setVisibility, visibility: " + i2);
        if (i2 != 0) {
            this.h = 0.0f;
        }
        super.setVisibility(i2);
    }

    public float getAlpha() {
        return this.h;
    }

    public void setAlpha(float f2) {
        e.a("HeadlineBackground", "setAlpha, alpha: " + f2);
        this.h = f2;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(0);
        if (this.f4067a <= 0 || this.f4068b <= 0 || this.g == null || getWidth() <= 0 || getHeight() <= 0) {
            e.e("HeadlineBackground", "onDraw, mBackgroundWidth: " + this.f4067a + ", mBackgroundHeight: " + this.f4068b + ", mPaint: " + this.g + ", getWidth: " + getWidth() + ", getHeight: " + getHeight());
            return;
        }
        e.a("HeadlineBackground", "onDraw: " + this.h);
        this.g.setColor(Color.argb((int) (this.h * ((float) Color.alpha(this.i))), (int) (this.h * ((float) Color.red(this.i))), (int) (this.h * ((float) Color.green(this.i))), (int) (this.h * ((float) Color.blue(this.i)))));
        canvas.drawRect((float) (((getWidth() / 2) - (this.f4067a / 2)) + this.f), (float) (((getHeight() / 2) + (this.f4068b / 2)) - (this.d / 2)), (float) (((getWidth() / 2) + (this.f4067a / 2)) - this.f), (float) ((getHeight() / 2) + (this.f4068b / 2) + (this.d / 2)), this.g);
        super.onDraw(canvas);
    }
}
