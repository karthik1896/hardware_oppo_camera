package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.t.a;
import com.oppo.camera.util.Util;
import java.util.Arrays;

/* compiled from: SuperTextFrameView */
public class r extends View {

    /* renamed from: a  reason: collision with root package name */
    private PointF[] f4555a = null;

    /* renamed from: b  reason: collision with root package name */
    private Paint f4556b = null;
    private Path c = null;
    private Path d = null;
    private boolean e = false;
    /* access modifiers changed from: private */
    public int f;
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public Handler h;
    private int i;
    private int j;

    public r(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f4556b = new Paint(1);
        this.c = new Path();
        this.d = new Path();
        this.f = Util.s(context);
        this.g = getResources().getColor(R.color.super_text_preview_solid_color);
        this.h = new Handler(Looper.getMainLooper());
    }

    public void setMStrokeColor(int i2) {
        this.f = i2;
        invalidate();
    }

    public void setMSolidColor(int i2) {
        this.g = i2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        PointF[] pointFArr = this.f4555a;
        if (pointFArr == null || pointFArr.length != 4) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            return;
        }
        canvas.save();
        this.i = getWidth();
        this.j = getHeight();
        this.f4556b.setAntiAlias(true);
        this.f4556b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4556b.setColor(this.g);
        this.c.reset();
        this.c.moveTo(this.f4555a[0].x * ((float) this.i), this.f4555a[0].y * ((float) this.j));
        this.c.lineTo(this.f4555a[1].x * ((float) this.i), this.f4555a[1].y * ((float) this.j));
        this.c.lineTo(this.f4555a[2].x * ((float) this.i), this.f4555a[2].y * ((float) this.j));
        this.c.lineTo(this.f4555a[3].x * ((float) this.i), this.f4555a[3].y * ((float) this.j));
        this.c.close();
        canvas.drawPath(this.c, this.f4556b);
        this.f4556b.setStyle(Paint.Style.STROKE);
        this.f4556b.setStrokeWidth(4.0f);
        this.f4556b.setColor(this.f);
        this.d.reset();
        this.d.moveTo(this.f4555a[0].x * ((float) this.i), this.f4555a[0].y * ((float) this.j));
        this.d.lineTo(this.f4555a[1].x * ((float) this.i), this.f4555a[1].y * ((float) this.j));
        this.d.lineTo(this.f4555a[2].x * ((float) this.i), this.f4555a[2].y * ((float) this.j));
        this.d.lineTo(this.f4555a[3].x * ((float) this.i), this.f4555a[3].y * ((float) this.j));
        this.d.close();
        canvas.drawPath(this.d, this.f4556b);
        canvas.restore();
    }

    public void setPointsArray(PointF[] pointFArr) {
        if (pointFArr == null || this.e) {
            this.f4555a = null;
            this.d.reset();
            this.c.reset();
            invalidate();
            return;
        }
        this.f4555a = pointFArr;
        invalidate();
    }

    public void a(a aVar) {
        e.a("TAG", "executeAnimation, mPointsArray: " + Arrays.toString(this.f4555a));
        this.f4555a = aVar.b();
        setVisibility(0);
        final int s = Util.s(getContext());
        final int color2 = getResources().getColor(R.color.super_text_preview_solid_color);
        int color3 = getResources().getColor(R.color.super_text_capture_stroke_color);
        int color4 = getResources().getColor(R.color.super_text_capture_solid_color);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofArgb = ObjectAnimator.ofArgb(this, "mStrokeColor", new int[]{s, color3});
        ObjectAnimator ofArgb2 = ObjectAnimator.ofArgb(this, "mSolidColor", new int[]{color2, color4});
        animatorSet.setDuration(500).playTogether(new Animator[]{ofArgb, ofArgb2});
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                e.a("SuperTextFrameView", "onAnimationEnd, start hideAnimation");
                r.this.h.postDelayed(new Runnable() {
                    public void run() {
                        r.this.a(s, color2);
                    }
                }, 1000);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final int i3) {
        e.a("SuperTextFrameView", "hideAnimation, start");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(200);
        ofFloat.start();
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                r.this.setVisibility(4);
                int unused = r.this.f = i2;
                int unused2 = r.this.g = i3;
                r.this.setAlpha(1.0f);
            }
        });
    }
}
