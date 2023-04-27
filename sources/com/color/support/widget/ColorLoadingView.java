package com.color.support.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.g.v;
import color.support.v7.appcompat.R;
import com.color.support.c.a.a;
import com.color.support.d.c;
import com.color.support.d.d;
import java.lang.ref.WeakReference;

public class ColorLoadingView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2042a = "ColorLoadingView";
    private RectF A;
    private float B;
    private float C;
    private a.C0054a D;

    /* renamed from: b  reason: collision with root package name */
    private float[] f2043b;
    private int c;
    private int d;
    /* access modifiers changed from: private */
    public int e;
    /* access modifiers changed from: private */
    public int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float k;
    private Paint l;
    private float m;
    private float n;
    private float o;
    private ValueAnimator p;
    private com.color.support.c.a.a q;
    /* access modifiers changed from: private */
    public String r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private Paint w;
    private float x;
    private float y;
    private float z;

    public ColorLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorLoadingViewStyle);
    }

    public ColorLoadingView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, R.attr.colorLoadingViewStyle, 0);
    }

    public ColorLoadingView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.f2043b = new float[6];
        this.e = 0;
        this.f = 0;
        this.g = 1;
        this.o = 60.0f;
        this.r = null;
        this.s = 0.1f;
        this.t = 0.4f;
        this.u = false;
        this.v = false;
        this.D = new a.C0054a() {

            /* renamed from: b  reason: collision with root package name */
            private int f2045b = -1;

            public int a() {
                return -1;
            }

            public void a(int i, int i2, boolean z) {
            }

            public int b() {
                return 1;
            }

            public CharSequence c() {
                return null;
            }

            public int d() {
                return -1;
            }

            public void a(int i, Rect rect) {
                if (i == 0) {
                    rect.set(0, 0, ColorLoadingView.this.e, ColorLoadingView.this.f);
                }
            }

            public int a(float f, float f2) {
                return (f < 0.0f || f > ((float) ColorLoadingView.this.e) || f2 < 0.0f || f2 > ((float) ColorLoadingView.this.f)) ? -1 : 0;
            }

            public CharSequence a(int i) {
                if (ColorLoadingView.this.r != null) {
                    return ColorLoadingView.this.r;
                }
                return getClass().getSimpleName();
            }
        };
        d.a(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.colorLoadingView, i2, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.color_loading_view_default_length);
        this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.colorLoadingView_colorLoadingViewWidth, dimensionPixelSize);
        this.f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.colorLoadingView_colorLoadingViewHeight, dimensionPixelSize);
        this.g = obtainStyledAttributes.getInteger(R.styleable.colorLoadingView_colorLoadingViewType, 1);
        int a2 = c.a(context, R.attr.colorTintControlNormal, 0);
        int a3 = c.a(context, R.attr.colorTintLightNormal, 0);
        this.c = obtainStyledAttributes.getColor(R.styleable.colorLoadingView_colorLoadingViewColor, a2);
        this.d = obtainStyledAttributes.getColor(R.styleable.colorLoadingView_colorLoadingViewBgCircleColor, a3);
        obtainStyledAttributes.recycle();
        this.h = context.getResources().getDimensionPixelSize(R.dimen.color_circle_loading_strokewidth);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.color_circle_loading_medium_strokewidth);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.color_circle_loading_large_strokewidth);
        this.k = (float) this.h;
        int i4 = this.g;
        if (1 == i4) {
            this.k = (float) this.i;
            this.s = 0.1f;
            this.t = 0.4f;
        } else if (2 == i4) {
            this.k = (float) this.j;
            this.s = 0.215f;
            this.t = 1.0f;
        }
        this.m = (float) (this.e >> 1);
        this.n = (float) (this.f >> 1);
        this.q = new com.color.support.c.a.a(this);
        this.q.a(this.D);
        v.a((View) this, (androidx.core.g.a) this.q);
        v.b((View) this, 1);
        this.r = context.getString(R.string.color_loading_view_access_string);
        a();
        f();
    }

    private void a() {
        this.l = new Paint(1);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setColor(this.c);
        this.l.setStrokeWidth(this.k);
        this.l.setStrokeCap(Paint.Cap.ROUND);
    }

    private void b() {
        this.p = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.p.setDuration(480);
        this.p.setInterpolator(new LinearInterpolator());
        this.p.addUpdateListener(new a(this));
        this.p.setRepeatMode(1);
        this.p.setRepeatCount(-1);
        this.p.setInterpolator(new LinearInterpolator());
    }

    private static class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<ColorLoadingView> f2046a;

        public a(ColorLoadingView colorLoadingView) {
            this.f2046a = new WeakReference<>(colorLoadingView);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            valueAnimator.getAnimatedFraction();
            ColorLoadingView colorLoadingView = (ColorLoadingView) this.f2046a.get();
            if (colorLoadingView != null) {
                colorLoadingView.invalidate();
            }
        }
    }

    private void c() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.p.removeAllListeners();
            this.p.removeAllUpdateListeners();
            this.p = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.u) {
            b();
            this.u = true;
        }
        if (!this.v) {
            d();
            this.v = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        this.u = false;
        this.v = false;
    }

    private void d() {
        ValueAnimator valueAnimator;
        if (getVisibility() == 0 && (valueAnimator = this.p) != null) {
            if (valueAnimator.isRunning()) {
                this.p.cancel();
            }
            this.p.start();
        }
    }

    private void e() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            if (!this.u) {
                b();
                this.u = true;
            }
            if (!this.v) {
                d();
                this.v = true;
                return;
            }
            return;
        }
        e();
        this.v = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(this.e, this.f);
    }

    public void onDraw(Canvas canvas) {
        this.C = (this.C + 6.0f) % 360.0f;
        a(canvas);
        canvas.save();
        canvas.rotate(-90.0f, this.y, this.z);
        if (this.A == null) {
            g();
        }
        RectF rectF = this.A;
        float f2 = this.C;
        canvas.drawArc(rectF, f2 - 30.0f, (2.0f - Math.abs((180.0f - f2) / 180.0f)) * 60.0f, false, this.l);
        canvas.restore();
    }

    private void f() {
        this.w = new Paint(1);
        this.w.setColor(this.d);
        this.w.setStyle(Paint.Style.STROKE);
        this.w.setStrokeWidth(this.k);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.A == null) {
            g();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        g();
    }

    private void g() {
        this.x = this.k / 2.0f;
        this.y = (float) (getWidth() / 2);
        this.z = (float) (getHeight() / 2);
        float f2 = this.y;
        this.B = f2 - this.x;
        float f3 = this.B;
        this.A = new RectF(f2 - f3, f2 - f3, f2 + f3, f2 + f3);
    }

    private void a(Canvas canvas) {
        float f2 = this.y;
        canvas.drawCircle(f2, f2, this.B, this.w);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            d();
        } else {
            e();
        }
    }
}
