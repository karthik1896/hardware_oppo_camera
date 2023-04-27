package com.oppo.camera.ui.menu.setting.down;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.j.u;

/* compiled from: ArrowView */
public class a extends View implements com.oppo.camera.ui.inverse.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f4204a = null;

    /* renamed from: b  reason: collision with root package name */
    private b f4205b = null;
    private float c = 0.0f;
    private Paint d = null;
    private float e = 0.0f;
    private Path f = null;
    private int g = 0;
    private BlurMaskFilter h = null;
    private PorterDuffXfermode i = null;
    /* access modifiers changed from: private */
    public ValueAnimator j = null;
    /* access modifiers changed from: private */
    public ValueAnimator k = null;
    private ValueAnimator l = null;
    private AnimatorSet m = null;
    private boolean n = true;
    private boolean o = false;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    /* access modifiers changed from: private */
    public float r = 0.0f;
    private float s = 0.0f;
    private C0104a t = null;

    public a(Context context, AttributeSet attributeSet, b bVar) {
        super(context, attributeSet);
        setLayerType(1, (Paint) null);
        this.f4205b = bVar;
        this.f4204a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawerLayout, 0, 0);
        this.g = obtainStyledAttributes.getColor(0, -7829368);
        this.c = obtainStyledAttributes.getDimension(3, 0.0f);
        this.e = obtainStyledAttributes.getDimension(2, 0.0f);
        obtainStyledAttributes.recycle();
        d();
    }

    private void d() {
        this.f = new Path();
        this.d = new Paint();
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setAntiAlias(true);
        this.d.setStrokeCap(Paint.Cap.ROUND);
        this.d.setStrokeJoin(Paint.Join.MITER);
        this.d.setStrokeWidth(this.c);
        this.h = new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.SOLID);
        this.i = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.t = new C0104a();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 > 0 && i3 > 0) {
            this.s = (((float) i2) - (this.e * 2.0f)) / 8.0f;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if ((this.n && !this.f4205b.getmDrawerLayout().e()) || this.o) {
            this.d.setColor(-12303292);
            this.d.setMaskFilter(this.h);
            canvas.drawPath(this.f, this.d);
            this.d.setMaskFilter((MaskFilter) null);
            this.d.setXfermode(this.i);
            canvas.drawPath(this.f, this.d);
            this.d.setXfermode((Xfermode) null);
        }
        this.d.setColor(this.g);
        canvas.drawPath(this.f, this.d);
    }

    public void a(float f2) {
        if (!this.p) {
            this.r += f2 / 5.0f;
            this.r = Math.min(this.r, this.s);
            this.r = Math.max(this.r, -this.s);
            c(this.r);
        }
    }

    /* access modifiers changed from: private */
    public void c(float f2) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float sqrt = (float) Math.sqrt(Math.pow((double) ((((float) measuredWidth) - (this.e * 2.0f)) / 4.0f), 2.0d) - Math.pow((double) f2, 2.0d));
        this.f.reset();
        this.n = 0.0f == f2;
        float f3 = (float) (measuredWidth >> 1);
        float f4 = (float) (measuredHeight >> 1);
        float f5 = sqrt * 2.0f;
        float f6 = f3 - f5;
        float f7 = f4 - f2;
        this.f.moveTo(f6, f7);
        this.f.lineTo(f6, f7);
        this.f.lineTo(f3, f4 + f2);
        this.f.lineTo(f3 + f5, f7);
        invalidate();
    }

    public void b(float f2) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i2 = (int) (((float) measuredWidth) - (this.e * 2.0f));
        int i3 = (int) (((float) (i2 / 8)) * f2);
        int i4 = measuredHeight / 2;
        int i5 = measuredWidth / 2;
        this.f.reset();
        int sqrt = ((int) Math.sqrt(Math.pow((double) (i2 >> 2), 2.0d) - Math.pow((double) i3, 2.0d))) * 2;
        float f3 = (float) (i5 - sqrt);
        float f4 = (float) (i4 - i3);
        this.f.moveTo(f3, f4);
        this.f.lineTo(f3, f4);
        this.f.lineTo((float) i5, (float) (i4 + i3));
        this.f.lineTo((float) (i5 + sqrt), f4);
        this.n = true;
        invalidate();
    }

    public void a() {
        if (this.p) {
            e.b("ArrowView", "startPromptAnimation, animation has started, so return");
            return;
        }
        this.p = true;
        this.j = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.j.setDuration(500);
        this.j.setInterpolator(AnimationUtils.loadInterpolator(this.f4204a, R.anim.gallery_in_interpolator));
        this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.k = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.k.setDuration(500);
        this.k.setInterpolator(AnimationUtils.loadInterpolator(this.f4204a, R.anim.gallery_in_interpolator));
        this.k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        AnonymousClass3 r0 = new Animator.AnimatorListener() {

            /* renamed from: a  reason: collision with root package name */
            int f4208a = 2;

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (a.this.j != null && a.this.k != null) {
                    if (animator == a.this.j) {
                        a.this.k.start();
                        return;
                    }
                    this.f4208a--;
                    if (this.f4208a == 0) {
                        boolean unused = a.this.p = false;
                        return;
                    }
                    a.this.j.setStartDelay(200);
                    a.this.j.start();
                }
            }

            public void onAnimationCancel(Animator animator) {
                boolean unused = a.this.p = false;
            }
        };
        this.j.addListener(r0);
        this.k.addListener(r0);
        this.j.setStartDelay(500);
        this.j.start();
    }

    /* access modifiers changed from: private */
    public void d(float f2) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f3 = ((float) measuredWidth) - (this.e * 2.0f);
        float f4 = ((f3 / 8.0f) / 2.0f) * f2;
        int sqrt = (int) Math.sqrt(Math.pow((double) (f3 / 4.0f), 2.0d) - Math.pow((double) f4, 2.0d));
        this.f.reset();
        float f5 = ((float) (measuredHeight / 2)) + (((float) (measuredHeight / 3)) * f2);
        int i2 = measuredWidth / 2;
        int i3 = sqrt * 2;
        float f6 = (float) (i2 - i3);
        float f7 = f5 - f4;
        this.f.moveTo(f6, f7);
        this.f.lineTo(f6, f7);
        this.f.lineTo((float) i2, f5 + f4);
        this.f.lineTo((float) (i2 + i3), f7);
        invalidate();
    }

    public void setInverseColor(boolean z) {
        this.o = z;
        invalidate();
    }

    public void b() {
        this.p = false;
        this.q = false;
        e();
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.l.removeAllListeners();
            this.l.cancel();
            this.l = null;
        }
    }

    private void e() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.j.removeAllListeners();
            this.j.cancel();
            this.j = null;
        }
        ValueAnimator valueAnimator2 = this.k;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.k.removeAllListeners();
            this.k.cancel();
            this.k = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.m;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.m.cancel();
            this.m = null;
        }
    }

    public void c() {
        if (this.q) {
            e.b("ArrowView", "startArrowToLineAnimator, animation already start, so return");
            return;
        }
        e();
        this.q = true;
        if (this.l == null) {
            this.l = ValueAnimator.ofFloat(new float[]{this.r, 0.0f});
            this.l.setDuration(283);
            this.l.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.drawer_arrow_to_line_interpolator));
            this.l.addUpdateListener(this.t);
            this.l.addListener(new u() {
                public void onAnimationEnd(Animator animator) {
                    boolean unused = a.this.q = false;
                }

                public void onAnimationCancel(Animator animator) {
                    boolean unused = a.this.q = false;
                }
            });
        }
        this.l.setStartDelay(167);
        this.l.setFloatValues(new float[]{this.r, 0.0f});
        this.l.start();
    }

    public void a(int i2) {
        e.b("ArrowView", "startArrowAndLineAnimator, aniState: " + i2 + ", mbIsArrowAnimatorRunning: " + this.q);
        if (!this.q) {
            e();
            this.q = true;
            this.m = new AnimatorSet();
            this.m.addListener(new u() {
                public void onAnimationEnd(Animator animator) {
                    e.b("ArrowView", "startArrowAndLineAnimator, onAnimationEnd");
                    boolean unused = a.this.q = false;
                }

                public void onAnimationCancel(Animator animator) {
                    e.b("ArrowView", "startArrowAndLineAnimator, onAnimationCancel");
                    boolean unused = a.this.q = false;
                }
            });
            if (-2000 == i2) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, this.s});
                ofFloat.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.drawer_ani_down_line2arrow_interpolator));
                ofFloat.setDuration(83);
                ofFloat.addUpdateListener(this.t);
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.s, 0.0f});
                ofFloat2.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.drawer_ani_down_arrow2line_interpolator));
                ofFloat2.setDuration(417);
                ofFloat2.addUpdateListener(this.t);
                this.m.playSequentially(new Animator[]{ofFloat, ofFloat2});
                this.m.start();
            } else if (2000 == i2) {
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, -this.s});
                ofFloat3.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.drawer_ani_up_line2arrow_interpolator));
                ofFloat3.setDuration(150);
                ofFloat3.addUpdateListener(this.t);
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{-this.s, 0.0f});
                ofFloat4.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.drawer_ani_up_arrow2line_interpolator));
                ofFloat4.setDuration(183);
                ofFloat4.addUpdateListener(this.t);
                this.m.playSequentially(new Animator[]{ofFloat3, ofFloat4});
                this.m.start();
            } else if (1000 == i2) {
                ValueAnimator ofFloat5 = ValueAnimator.ofFloat(new float[]{this.r, 0.0f});
                ofFloat5.setInterpolator(new DecelerateInterpolator());
                ofFloat5.setDuration(333);
                ofFloat5.addUpdateListener(this.t);
                this.m.play(ofFloat5);
                this.m.start();
            } else {
                this.q = false;
            }
        }
    }

    /* renamed from: com.oppo.camera.ui.menu.setting.down.a$a  reason: collision with other inner class name */
    /* compiled from: ArrowView */
    private class C0104a implements ValueAnimator.AnimatorUpdateListener {
        private C0104a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = a.this.r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a aVar = a.this;
            aVar.c(aVar.r);
        }
    }
}
