package com.oppo.camera.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

public class RotateMoreItem extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f3808a;

    /* renamed from: b  reason: collision with root package name */
    private int f3809b;
    private int c;
    private boolean d;
    private long e;
    private long f;
    private Bitmap g;
    private Bitmap h;
    private String i;
    private TextPaint j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private int p;
    private int q;
    private int r;
    private boolean s;

    public RotateMoreItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public RotateMoreItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateMoreItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3808a = 0;
        this.f3809b = 0;
        this.c = 0;
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0.0f;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RotateMoreItem, i2, 0);
        this.k = obtainStyledAttributes.getDimensionPixelSize(2, 32);
        this.l = obtainStyledAttributes.getDimensionPixelSize(0, 32);
        this.m = obtainStyledAttributes.getDimensionPixelSize(1, 8);
        this.n = obtainStyledAttributes.getInt(4, 1);
        this.o = obtainStyledAttributes.getDimension(6, 12.0f);
        this.p = obtainStyledAttributes.getColor(3, -1);
        this.q = obtainStyledAttributes.getDimensionPixelSize(5, 70);
        this.r = obtainStyledAttributes.getDimensionPixelSize(7, 14);
        obtainStyledAttributes.recycle();
        b();
    }

    private void b() {
        if (this.j == null) {
            this.j = new TextPaint();
            this.j.setTextSize(this.o);
            this.j.setColor(this.p);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setFlags(1);
            this.j.setTypeface(Util.j(getContext()));
        }
    }

    public void setText(String str) {
        this.i = str;
        setContentDescription(str);
    }

    public void setImage(Bitmap bitmap) {
        this.g = bitmap;
    }

    public void setSubscriptHint(Bitmap bitmap) {
        if (bitmap != null || this.h != null) {
            Bitmap bitmap2 = this.h;
            if (bitmap2 != null) {
                if (!bitmap2.isRecycled()) {
                    this.h.recycle();
                }
                this.h = null;
            }
            this.h = bitmap;
            invalidate();
        }
    }

    public boolean a() {
        return this.h != null;
    }

    public void setSubscriptHintRTL(boolean z) {
        this.s = z;
    }

    public void a(int i2, int i3) {
        this.f3808a = i2;
        this.c = i3 >= 0 ? i3 % 360 : (i3 % 360) + 360;
        this.f3809b = this.f3808a;
        this.e = AnimationUtils.currentAnimationTimeMillis();
        int i4 = this.c - this.f3808a;
        if (i4 < 0) {
            i4 += 360;
        }
        if (i4 > 180) {
            i4 -= 360;
        }
        this.d = i4 >= 0;
        this.f = this.e + ((long) ((Math.abs(i4) * 1000) / 270));
        invalidate();
    }

    private Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        float f2 = 1.0f;
        if (width > this.k || height > this.l) {
            f2 = ((float) this.k) / ((float) width);
            float f3 = ((float) this.l) / ((float) height);
            if (f2 >= f3) {
                f2 = f3;
            }
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        if (this.f3808a != this.c) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.f) {
                int i2 = (int) (currentAnimationTimeMillis - this.e);
                int i3 = this.f3809b;
                if (!this.d) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 270) / 1000);
                this.f3808a = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                invalidate();
            } else {
                this.f3808a = this.c;
            }
        }
        canvas.rotate((float) (-this.f3808a), ((float) getWidth()) * 0.5f, ((float) getHeight()) * 0.5f);
        Bitmap a2 = a(this.g);
        if (a2 != null) {
            canvas.drawBitmap(a2, ((float) (getWidth() - a2.getWidth())) * 0.5f, ((float) this.r) + (((float) (this.l - a2.getHeight())) * 0.5f), (Paint) null);
        }
        Bitmap a3 = a(this.h);
        if (!(a3 == null || a2 == null)) {
            if (this.s) {
                f2 = (((float) ((getWidth() - a2.getWidth()) - a3.getWidth())) * 0.5f) - ((float) getResources().getDimensionPixelSize(R.dimen.item_right_margin));
            } else {
                f2 = (((float) ((getWidth() + a2.getWidth()) - a3.getWidth())) * 0.5f) + ((float) getResources().getDimensionPixelSize(R.dimen.item_right_margin));
            }
            canvas.drawBitmap(a3, f2, (((float) this.r) + (((float) (this.l - a2.getHeight())) * 0.5f)) - (((float) a3.getHeight()) * 0.5f), (Paint) null);
        }
        canvas.save();
        if (!TextUtils.isEmpty(this.i)) {
            b();
            String str = this.i;
            StaticLayout build = StaticLayout.Builder.obtain(str, 0, str.length(), this.j, this.q).setMaxLines(this.n).setAlignment(Layout.Alignment.ALIGN_CENTER).setEllipsize(TextUtils.TruncateAt.END).setTextDirection(TextDirectionHeuristics.LOCALE).build();
            canvas.translate(((float) (getWidth() - this.q)) * 0.5f, ((float) ((this.r + this.l) + this.m)) - (this.j.getFontMetrics().ascent - this.j.getFontMetrics().top));
            build.draw(canvas);
            canvas.restore();
        }
    }

    public void setTextColor(int i2) {
        this.p = i2;
        this.j.setColor(i2);
    }
}
