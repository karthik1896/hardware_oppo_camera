package com.oppo.camera.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class InertiaZoomBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private static Typeface f3790a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f3791b;
    /* access modifiers changed from: private */
    public float c;
    /* access modifiers changed from: private */
    public int d;
    private int e;
    private int f;
    /* access modifiers changed from: private */
    public int g;
    private int h;
    private int i;
    private Context j;
    private Paint k;
    private Path l;
    private Paint m;
    private DecimalFormat n;
    private a o;
    private TextPaint p;

    public interface a {
        void a(float f);
    }

    public InertiaZoomBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public InertiaZoomBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InertiaZoomBar(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public InertiaZoomBar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet);
        this.f3791b = 0.0f;
        this.c = -1.0f;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.j = context;
        Resources resources = this.j.getResources();
        this.d = resources.getDimensionPixelSize(R.dimen.inertial_zoombar_height);
        this.e = resources.getDimensionPixelSize(R.dimen.inertial_zoombar_text_margin_thumb);
        this.f = resources.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_margin);
        this.g = resources.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_size);
        this.h = resources.getDimensionPixelSize(R.dimen.inertial_zoombar_thumb_size);
        this.n = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
        c();
        a(resources);
    }

    private void a(Resources resources) {
        float dimensionPixelSize = (float) resources.getDimensionPixelSize(R.dimen.inertial_zoombar_text_shadow_radius_size);
        float dimensionPixelSize2 = (float) resources.getDimensionPixelSize(R.dimen.inertial_zoom_text_shadow_dx);
        float dimensionPixelSize3 = (float) resources.getDimensionPixelSize(R.dimen.inertial_zoom_text_shadow_dy);
        int color2 = this.j.getColor(R.color.inertial_bar_shadow_color);
        this.k = new Paint();
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setAntiAlias(true);
        this.k.setStrokeWidth((float) resources.getDimensionPixelSize(R.dimen.inertial_zoombar_width));
        this.k.setColor(this.j.getResources().getColor(R.color.inertia_zoom_bar_color));
        this.k.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
        this.l = new Path();
        this.p = new TextPaint();
        this.p.setAntiAlias(true);
        this.p.setTypeface(getMediumFontTypeface());
        this.p.setTextSize((float) resources.getDimensionPixelSize(R.dimen.inertial_zoombar_text_size));
        this.p.setColor(this.j.getResources().getColor(R.color.inertia_zoom_bar_color));
        this.p.setTextAlign(Paint.Align.LEFT);
        this.p.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
        this.m = new Paint();
        this.m.setColor(this.j.getResources().getColor(R.color.inertia_zoom_bar_color));
        this.m.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        this.m.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
    }

    private void c() {
        a();
    }

    public void setMoveProgress(float f2) {
        float f3 = this.f3791b + f2;
        float f4 = 0.0f;
        if (f3 >= 0.0f) {
            f4 = f3;
        }
        if (f4 > 100.0f) {
            f4 = 100.0f;
        }
        setProgress(f4);
    }

    /* access modifiers changed from: private */
    public void d() {
        int i2 = this.g;
        a(i2 / 2, this.d - (i2 / 2));
        invalidate();
    }

    private void a(int i2, int i3) {
        float f2 = (float) i3;
        if (this.c > f2) {
            this.c = f2;
        }
        float f3 = (float) i2;
        if (this.c < f3) {
            this.c = f3;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.c < 0.0f) {
            setProgress(50.0f);
        }
        c(canvas);
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    private void a(Canvas canvas) {
        float f2 = this.c;
        int i2 = this.g;
        int i3 = this.f;
        float f3 = (f2 - ((float) (i2 / 2))) - ((float) i3);
        float f4 = f2 + ((float) (i2 / 2)) + ((float) i3);
        if (Float.compare(f3, 0.0f) < 0) {
            f3 = 0.0f;
        }
        if (Float.compare(f4, (float) getHeight()) > 0) {
            f4 = (float) getHeight();
        }
        this.l.reset();
        this.l.moveTo((float) (this.g / 2), 0.0f);
        this.l.lineTo((float) (this.g / 2), f3);
        canvas.drawPath(this.l, this.k);
        this.l.reset();
        this.l.moveTo((float) (this.g / 2), f4);
        this.l.lineTo((float) (this.g / 2), (float) getHeight());
        canvas.drawPath(this.l, this.k);
    }

    private void b(Canvas canvas) {
        String str;
        float a2 = a(this.f3791b);
        if (Float.compare(a2, 0.0f) > 0) {
            str = "+" + String.valueOf(a2);
        } else {
            str = String.valueOf(a2);
        }
        if ("-0.0".equals(str) || "+0.0".equals(str)) {
            str = "0.0";
        }
        canvas.drawText(str + "/s", (float) (this.g + this.e), this.c + (this.p.getFontMetrics().bottom / 2.0f) + ((float) (this.h / 2)), this.p);
    }

    public float a(float f2) {
        return Float.valueOf(this.n.format((double) (((f2 / 100.0f) * 10.0f) - 0.875f))).floatValue();
    }

    private void c(Canvas canvas) {
        int i2 = this.g;
        canvas.drawCircle((float) (i2 / 2), this.c, (float) (i2 / 2), this.m);
    }

    private Typeface getMediumFontTypeface() {
        Typeface typeface = f3790a;
        if (typeface != null) {
            return typeface;
        }
        f3790a = Util.a(this.j, true);
        return f3790a;
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.o = aVar;
    }

    public void a(int i2, boolean z) {
        if (this.i != i2) {
            e.e("InertiaZoomBar", "setOrientation, orientation: " + i2);
            this.i = i2;
            int i3 = this.i;
            if (180 == i3) {
                setRotation(0.0f);
            } else {
                setRotation((float) (-i3));
            }
        }
    }

    public void a() {
        setProgress(50.0f);
    }

    public void b() {
        if (getHeight() != 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f3791b, 50.0f});
            PathInterpolator pathInterpolator = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = InertiaZoomBar.this.f3791b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    InertiaZoomBar inertiaZoomBar = InertiaZoomBar.this;
                    float unused2 = inertiaZoomBar.c = ((float) (inertiaZoomBar.d - (InertiaZoomBar.this.g / 2))) - ((InertiaZoomBar.this.f3791b / 100.0f) * ((float) (InertiaZoomBar.this.d - InertiaZoomBar.this.g)));
                    InertiaZoomBar.this.d();
                }
            });
            ofFloat.setInterpolator(pathInterpolator);
            ofFloat.setDuration(250);
            ofFloat.start();
        }
    }

    public void setProgress(float f2) {
        if (getHeight() != 0) {
            this.f3791b = f2;
            int i2 = this.d;
            int i3 = this.g;
            float f3 = this.f3791b;
            this.c = ((float) (i2 - (i3 / 2))) - ((f3 / 100.0f) * ((float) (i2 - i3)));
            a aVar = this.o;
            if (aVar != null) {
                aVar.a(a(f3));
            }
            d();
        }
    }
}
