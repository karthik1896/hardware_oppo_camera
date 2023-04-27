package com.oppo.camera.panorama;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;

public class FrontPanoramaGuideView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Path f3466a = null;

    /* renamed from: b  reason: collision with root package name */
    private Paint f3467b = null;
    private boolean c = true;
    private PathMeasure d = null;
    private float e = 100.0f;
    private float f = 50.0f;
    private float[] g = null;
    private float[] h = null;
    private RectF i = null;
    private Path j = null;
    private float k = 30.0f;
    private float l = 5.0f;
    private int m = -256;
    private int n = 40;
    private Bitmap o = null;
    /* access modifiers changed from: private */
    public int p = 1;
    private c q = null;
    private c r = null;
    /* access modifiers changed from: private */
    public c s = null;
    /* access modifiers changed from: private */
    public ValueAnimator t = null;
    private a u = null;
    /* access modifiers changed from: private */
    public Runnable v = new Runnable() {
        public void run() {
            if (FrontPanoramaGuideView.this.t != null && !FrontPanoramaGuideView.this.t.isRunning()) {
                if (FrontPanoramaGuideView.this.s.b() != FrontPanoramaGuideView.this.p) {
                    FrontPanoramaGuideView.this.e();
                }
                FrontPanoramaGuideView.this.s.a();
                FrontPanoramaGuideView.this.t.start();
            }
        }
    };

    public interface a {
        void a(int i);
    }

    private float a(float f2) {
        return (float) ((((double) f2) * 3.141592653589793d) / 180.0d);
    }

    public FrontPanoramaGuideView(Context context) {
        super(context);
    }

    public FrontPanoramaGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FrontPanoramaGuideView);
        this.k = obtainStyledAttributes.getDimension(0, this.k);
        this.l = obtainStyledAttributes.getDimension(2, this.l);
        this.e = obtainStyledAttributes.getDimension(3, this.e);
        this.f = obtainStyledAttributes.getDimension(4, this.f);
        this.m = obtainStyledAttributes.getColor(1, -256);
        obtainStyledAttributes.recycle();
        c();
    }

    public FrontPanoramaGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnDirectionChangeListener(a aVar) {
        this.u = aVar;
    }

    private void c() {
        this.f3467b = new Paint();
        this.f3467b.setAntiAlias(true);
        this.f3467b.setDither(true);
        this.f3467b.setStyle(Paint.Style.STROKE);
        this.f3467b.setColor(this.m);
        this.f3467b.setStrokeWidth(this.l);
        this.f3467b.setStrokeJoin(Paint.Join.ROUND);
        this.f3467b.setStrokeCap(Paint.Cap.ROUND);
        this.f3466a = new Path();
        this.g = new float[2];
        this.h = new float[2];
        this.d = new PathMeasure(this.f3466a, false);
        float a2 = a((float) this.n);
        this.j = new Path();
        double d2 = (double) a2;
        this.j.setLastPoint(-((float) (((double) this.k) * Math.cos(d2))), (float) (((double) this.k) * Math.sin(d2)));
        this.j.lineTo(0.0f, 0.0f);
        this.j.lineTo(-((float) (((double) this.k) * Math.cos(d2))), -((float) (((double) this.k) * Math.sin(d2))));
        this.o = BitmapFactory.decodeResource(getResources(), R.drawable.front_panorama_guide_phone_icon);
    }

    public void a(int i2) {
        e.a("FrontPanoramaGuideView", "startAnimation, direction: " + i2);
        this.p = i2;
        e();
        this.c = false;
        if (this.t == null) {
            this.t = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.t.setDuration(820);
            this.t.setInterpolator(new PathInterpolator(0.43f, 0.0f, 0.42f, 1.0f));
            this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FrontPanoramaGuideView.this.s.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    FrontPanoramaGuideView.this.invalidate();
                }
            });
            this.t.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    FrontPanoramaGuideView frontPanoramaGuideView = FrontPanoramaGuideView.this;
                    frontPanoramaGuideView.removeCallbacks(frontPanoramaGuideView.v);
                    FrontPanoramaGuideView frontPanoramaGuideView2 = FrontPanoramaGuideView.this;
                    frontPanoramaGuideView2.postDelayed(frontPanoramaGuideView2.v, 680);
                }
            });
            this.t.start();
        }
    }

    public void a() {
        e.a("FrontPanoramaGuideView", "stopAnimation");
        this.c = true;
        removeCallbacks(this.v);
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.t = null;
        }
    }

    public void setNextDirection(int i2) {
        this.p = i2;
    }

    public void b() {
        Bitmap bitmap = this.o;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.o.recycle();
            this.o = null;
        }
        this.c = true;
    }

    public String getCurrentGuideTips() {
        c cVar = this.s;
        return cVar != null ? cVar.a(getContext()) : "";
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() != 0 && getHeight() != 0) {
            d();
            if (!this.c) {
                canvas.drawBitmap(this.o, this.s.a(this.o.getWidth(), this.o.getHeight(), getWidth(), getHeight()), this.f3467b);
                this.f3466a.reset();
                this.f3466a.addArc(this.i, this.s.d(), this.s.e());
                canvas.drawPath(this.f3466a, this.f3467b);
                this.d.setPath(this.f3466a, false);
                this.d.getPosTan(this.s.b(this.d.getLength()), this.g, this.h);
                float[] fArr = this.h;
                float c2 = this.s.c((float) ((Math.atan2((double) fArr[1], (double) fArr[0]) * 180.0d) / 3.141592653589793d));
                canvas.save();
                float[] fArr2 = this.g;
                canvas.rotate(c2, fArr2[0], fArr2[1]);
                canvas.save();
                float[] fArr3 = this.g;
                canvas.translate(fArr3[0], fArr3[1]);
                canvas.drawPath(this.j, this.f3467b);
                canvas.restore();
                canvas.restore();
            }
        }
    }

    private void d() {
        if (this.i == null) {
            float width = (((float) getWidth()) - (this.e * 2.0f)) / 2.0f;
            float height = ((float) (getHeight() / 2)) - ((float) getResources().getDimensionPixelSize(R.dimen.front_panorama_guide_ellipse_margin_top_by_center));
            this.i = new RectF(width, height, (this.e * 2.0f) + width, (this.f * 2.0f) + height);
            e.a("FrontPanoramaGuideView", "initEllipseRect, mEllipseRect: " + this.i);
        }
    }

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            if (i2 == 8 || i2 == 4) {
                a();
            } else {
                a(this.p);
            }
        }
        super.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public void e() {
        e.a("FrontPanoramaGuideView", "changeDirectionMode, mNextDirection: " + this.p);
        int i2 = this.p;
        if (i2 == 0) {
            if (this.q == null) {
                this.q = new b(getContext());
            }
            this.s = this.q;
        } else if (i2 == 1) {
            if (this.r == null) {
                this.r = new a(getContext());
            }
            this.s = this.r;
        }
        a aVar = this.u;
        if (aVar != null) {
            aVar.a(this.s.b());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = true;
    }
}
