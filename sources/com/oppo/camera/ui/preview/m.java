package com.oppo.camera.ui.preview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

/* compiled from: GradienterView */
public class m extends View {

    /* renamed from: a  reason: collision with root package name */
    private static String f4528a = "GradienterView";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f4529b = 0;
    private Paint c = null;
    private Paint d = null;
    private Path e = null;
    private Context f = null;
    private int g = -1;
    private int h = -1;
    private int i = 200;
    private int j = 300;
    private int k = 9;
    private float l = 4.0f;
    private ValueAnimator m = null;
    private boolean n = true;
    /* access modifiers changed from: private */
    public boolean o = false;

    public m(Context context, int i2, int i3, int i4) {
        super(context);
        this.f = context;
        this.j = this.f.getResources().getDimensionPixelSize(R.dimen.gradienter_dash_width) + (this.f.getResources().getDimensionPixelSize(R.dimen.gradienter_dash_gap) / 2);
        this.i = this.f.getResources().getDimensionPixelSize(R.dimen.gradienter_excircle_radius);
        this.k = this.f.getResources().getDimensionPixelSize(R.dimen.gradienter_inner_circle_radius);
        this.l = (float) this.f.getResources().getDimensionPixelSize(R.dimen.gradienter_line_width);
        this.g = i2;
        this.h = i3;
        this.f4529b = i4;
        if ((i4 <= 75 || i4 >= 105) && (i4 <= 255 || i4 >= 285)) {
            this.n = true;
            if (i4 > 345 && i4 < 360) {
                this.f4529b = i4 - 360;
            }
        } else {
            this.n = false;
        }
        d();
    }

    private void d() {
        this.c = new Paint();
        this.c.setStrokeWidth(this.l);
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(-1);
        this.d = new Paint();
        this.d.setColor(-1);
        this.d.setPathEffect(new DashPathEffect(new float[]{(float) this.f.getResources().getDimensionPixelSize(R.dimen.gradienter_dash_width), (float) this.f.getResources().getDimensionPixelSize(R.dimen.gradienter_dash_gap)}, 0.0f));
        this.d.setStrokeWidth(this.l);
        this.d.setAntiAlias(true);
        this.d.setStyle(Paint.Style.STROKE);
        this.e = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    private void a(Canvas canvas) {
        int i2 = this.g;
        float f2 = (float) i2;
        int i3 = this.h;
        float f3 = (float) i3;
        float f4 = (float) i2;
        float f5 = (float) i3;
        if (!this.n) {
            int i4 = this.j;
            f3 = (float) (i3 - i4);
            f5 = (float) (i3 + i4);
        } else {
            int i5 = this.j;
            f4 = (float) (i2 + i5);
            f2 = (float) (i2 - i5);
        }
        this.e.moveTo(f2, f3);
        this.e.lineTo(f4, f5);
        canvas.drawPath(this.e, this.d);
        this.e.reset();
        canvas.save();
        canvas.drawCircle((float) this.g, (float) this.h, (float) this.k, this.c);
        canvas.rotate((float) this.f4529b, (float) this.g, (float) this.h);
        int i6 = this.g;
        float f6 = (float) i6;
        int i7 = this.h;
        float f7 = (float) i7;
        float f8 = (float) (i6 + this.i);
        float f9 = (float) i7;
        canvas.drawLine(f6, f7, f8, f9, this.c);
        int i8 = this.g;
        canvas.drawLine((float) i8, f7, (float) (i8 - this.i), f9, this.c);
        canvas.restore();
    }

    public void a() {
        String str = f4528a;
        e.b(str, "showWithAnimation, mOrientation: " + this.f4529b);
        int i2 = this.f4529b;
        if (i2 % 90 > 75 || i2 % 90 < 15) {
            int i3 = this.f4529b;
            if (i3 % 90 > 89 || Math.abs(i3 % 90) < 1) {
                this.c.setColor(Util.s(getContext()));
            } else {
                this.c.setColor(-1);
            }
            invalidate();
            setVisibilityWithAnimation(0);
        }
    }

    public void b() {
        e.b(f4528a, "hideWithAnimation");
        setVisibilityWithAnimation(4);
    }

    private void setVisibilityWithAnimation(final int i2) {
        if (!this.o) {
            Util.a((View) this, i2, (Animation.AnimationListener) new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    boolean unused = m.this.o = true;
                }

                public void onAnimationEnd(Animation animation) {
                    m.this.setVisibility(i2);
                    boolean unused = m.this.o = false;
                }
            }, 300);
        }
    }

    public void setOrientation(int i2) {
        if (i2 <= 315 || i2 >= 360) {
            this.f4529b = i2;
        } else {
            this.f4529b = i2 - 360;
        }
    }

    public String getGradienterStatus() {
        int i2 = this.f4529b;
        if (i2 % 90 <= 75 && i2 % 90 >= 15) {
            return "3";
        }
        int i3 = this.f4529b;
        return (i3 % 90 > 89 || Math.abs(i3 % 90) < 1) ? "1" : "2";
    }

    public void a(int i2) {
        c();
        int i3 = i2 % 90;
        if (i3 > 75 || i3 < 15) {
            if ((i2 <= 75 || i2 >= 105) && (i2 <= 255 || i2 >= 285)) {
                this.n = true;
                if (i2 > 345 && i2 < 360) {
                    i2 -= 360;
                }
            } else {
                this.n = false;
            }
            this.m = ValueAnimator.ofInt(new int[]{this.f4529b, i2});
            this.m.setDuration(100);
            this.m.setInterpolator(new DecelerateInterpolator());
            this.m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (m.this.f4529b != intValue) {
                        int unused = m.this.f4529b = intValue;
                        m.this.a();
                    }
                }
            });
            this.m.start();
            return;
        }
        setOrientation(i2);
        b();
    }

    public void c() {
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.m = null;
        }
    }
}
