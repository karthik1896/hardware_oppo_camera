package com.oppo.camera.ui.widget;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.widget.AppCompatImageView;
import com.oppo.camera.R;
import com.oppo.camera.b.a;
import com.oppo.camera.doubleexposure.f;
import com.oppo.camera.util.e;

public class RoundRingImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f4577a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f4578b = new Paint();
    private Paint c = new Paint();
    /* access modifiers changed from: private */
    public Paint d = new Paint();
    private float e = 0.0f;
    private RectF f = new RectF();
    private float g = 0.0f;
    private float h = 0.0f;
    /* access modifiers changed from: private */
    public boolean i = false;
    private String j = "";
    private Context k = null;
    private float l = 0.0f;
    private Interpolator m = null;
    private ValueAnimator n = null;
    /* access modifiers changed from: private */
    public float o = 1.0f;
    private ValueAnimator p = null;

    public RoundRingImageView(Context context) {
        super(context);
        this.k = context;
        a();
    }

    public RoundRingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = context;
        a();
    }

    public RoundRingImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = context;
        a();
    }

    private void a() {
        this.h = this.k.getResources().getDimension(R.dimen.effect_menu_text_size);
        this.g = this.k.getResources().getDimension(R.dimen.effect_menu_border_width);
        this.e = this.k.getResources().getDimension(R.dimen.effect_menu_inner_radius);
        this.l = this.k.getResources().getDimension(R.dimen.effect_menu_text_baseline);
        this.f4578b.setAntiAlias(true);
        this.d.setAntiAlias(true);
        this.d.setColor(-1);
        this.d.setStrokeWidth(this.g);
        this.d.setStyle(Paint.Style.STROKE);
        this.c.setAntiAlias(true);
        this.c.setTextSize(this.h);
        this.c.setColor(-1);
        this.c.setShadowLayer(getResources().getDimension(R.dimen.num_seekbar_text_shadow_blur), 0.0f, 0.0f, getResources().getColor(R.color.color_black_with_70_percent_transparency));
        this.m = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public void setBitmap(Bitmap bitmap) {
        this.f4577a = bitmap;
        this.f4578b.setShader(new BitmapShader(this.f4577a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    }

    public void setParam(f fVar) {
        if (fVar != null) {
            setIsSelected(fVar.d());
            this.j = fVar.c();
        }
        invalidate();
    }

    public void setIsSelected(boolean z) {
        boolean z2 = this.i;
        this.i = z;
        if (z2 != this.i) {
            d();
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4578b.getShader() != null) {
            canvas.save();
            this.f.set(((float) getPaddingLeft()) + this.g, ((float) getPaddingTop()) + this.g, ((float) (getWidth() - getPaddingRight())) - this.g, ((float) (getHeight() - getPaddingBottom())) - this.g);
            RectF rectF = this.f;
            float f2 = this.e;
            canvas.drawRoundRect(rectF, f2, f2, this.f4578b);
            if (this.i) {
                this.f.set(((float) getPaddingLeft()) + this.g, ((float) getPaddingTop()) + this.g, ((float) (getWidth() - getPaddingRight())) - this.g, ((float) (getHeight() - getPaddingBottom())) - this.g);
                RectF rectF2 = this.f;
                float f3 = this.e;
                canvas.drawRoundRect(rectF2, f3, f3, this.d);
            }
            canvas.drawText(this.j, (((float) getWidth()) - this.c.measureText(this.j)) / 2.0f, ((float) getHeight()) - this.l, this.c);
            canvas.restore();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                b();
                c();
                a((View) this, this.p);
            }
            if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
                b();
                a((View) this, this.o);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void b() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.p.cancel();
        }
    }

    private void c() {
        final float b2 = e.b(this);
        this.p = e.a();
        this.p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedValue() != null) {
                    float unused = RoundRingImageView.this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float a2 = RoundRingImageView.this.o;
                    float f = b2;
                    if (a2 >= f) {
                        float unused2 = RoundRingImageView.this.o = f;
                    }
                }
            }
        });
    }

    private void a(View view, final ValueAnimator valueAnimator) {
        view.clearAnimation();
        ScaleAnimation a2 = e.a(view);
        a2.setAnimationListener(new a() {
            public void onAnimationStart(Animation animation) {
                valueAnimator.start();
            }
        });
        view.startAnimation(a2);
    }

    private void a(View view, float f2) {
        view.clearAnimation();
        view.startAnimation(e.a(view, f2));
    }

    private void d() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.n.cancel();
        }
        int[] iArr = new int[2];
        int i2 = 255;
        iArr[0] = this.i ? 0 : 255;
        if (!this.i) {
            i2 = 0;
        }
        iArr[1] = i2;
        this.n = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("brightnessHolder", iArr)});
        this.n.setInterpolator(this.m);
        this.n.setDuration(200);
        this.n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedValue("brightnessHolder") != null) {
                    RoundRingImageView.this.d.setAlpha(((Integer) valueAnimator.getAnimatedValue("brightnessHolder")).intValue());
                    RoundRingImageView.this.invalidate();
                }
            }
        });
        this.n.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                RoundRingImageView.this.d.setAlpha(RoundRingImageView.this.i ? 255 : 0);
                RoundRingImageView.this.invalidate();
            }

            public void onAnimationCancel(Animator animator) {
                RoundRingImageView.this.d.setAlpha(RoundRingImageView.this.i ? 255 : 0);
                RoundRingImageView.this.invalidate();
            }
        });
        this.n.start();
    }
}
