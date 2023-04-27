package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

public class AISceneView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private SweepGradient f4324a = null;

    /* renamed from: b  reason: collision with root package name */
    private PathInterpolator f4325b = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private PathInterpolator c = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private PathInterpolator d = new PathInterpolator(0.27f, 0.05f, 0.06f, 1.0f);
    private PathInterpolator e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private PathInterpolator f = new PathInterpolator(0.25f, 0.1f, 0.1f, 1.0f);
    private PathInterpolator g = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
    private AnimatorSet h = new AnimatorSet();
    private AnimatorSet i = new AnimatorSet();
    private int[] j = null;
    private int k = 0;
    /* access modifiers changed from: private */
    public int l = 255;
    /* access modifiers changed from: private */
    public float m = 0.0f;
    private RectF n = new RectF();
    private Matrix o = new Matrix();
    private Paint p = new Paint(1);
    private int q = 0;
    private int r = 0;
    private boolean s = false;
    private Context t = null;
    private a u = null;

    public interface a {
        void a();

        boolean b();
    }

    public AISceneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = context;
        b();
    }

    public void setAISceneViewListener(a aVar) {
        this.u = aVar;
    }

    private void b() {
        this.q = getResources().getDimensionPixelSize(R.dimen.pi_ai_scene_outline_border_background_stroke_width);
        this.r = getResources().getDimensionPixelSize(R.dimen.pi_ai_scene_background_radius);
        this.j = getResources().getIntArray(R.array.ai_scene_text_function_enable_color);
        this.k = androidx.core.content.a.c(this.t, R.color.ai_scene_text_function_disable_color);
        setTypeface(Util.j(this.t));
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth((float) this.q);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f4324a = new SweepGradient(((float) i2) / 2.0f, ((float) i3) / 2.0f, this.j, (float[]) null);
        RectF rectF = this.n;
        int i6 = this.q;
        rectF.left = (float) i6;
        rectF.top = (float) i6;
        rectF.right = (float) (i2 - i6);
        rectF.bottom = (float) (i3 - i6);
    }

    public void a(Animator.AnimatorListener animatorListener, boolean z) {
        this.s = z;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(this.f4325b);
        ofFloat.setDuration(250);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(this.c);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = AISceneView.this.l = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                AISceneView.this.invalidate();
            }
        });
        ofFloat2.setDuration(300);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{-540.0f, 0.0f});
        ofFloat3.setInterpolator(this.d);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = AISceneView.this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AISceneView.this.invalidate();
            }
        });
        ofFloat3.setDuration(1033);
        this.h.play(ofFloat3).with(ofFloat2).with(ofFloat);
        this.h.addListener(animatorListener);
        this.h.start();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(this.e);
        ofFloat.setDuration(150);
        this.i.play(ofFloat);
        this.i.addListener(animatorListener);
        this.i.start();
    }

    private void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, 1.06f});
        ofFloat.setInterpolator(this.f);
        ofFloat.setDuration(66);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.0f, 1.06f});
        ofFloat2.setInterpolator(this.f);
        ofFloat2.setDuration(66);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    private void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.06f, 1.0f});
        ofFloat.setInterpolator(this.g);
        ofFloat.setDuration(300);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.06f, 1.0f});
        ofFloat2.setInterpolator(this.g);
        ofFloat2.setDuration(300);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar = this.u;
        if (aVar != null && aVar.b()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                c();
                return true;
            } else if (1 == action) {
                a aVar2 = this.u;
                if (aVar2 != null) {
                    aVar2.a();
                }
                invalidate();
                d();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.s) {
            this.f4324a.setLocalMatrix(this.o);
            this.o.setRotate(this.m, (float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
            this.p.setShader(this.f4324a);
            this.p.setAlpha(this.l);
        } else {
            this.p.setColor(this.k);
            this.p.setShader((Shader) null);
        }
        RectF rectF = this.n;
        int i2 = this.r;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.p);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
    }

    public void setAISceneFunctionEnabled(boolean z) {
        this.s = z;
    }

    public void a() {
        AnimatorSet animatorSet = this.h;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.h.cancel();
        }
        AnimatorSet animatorSet2 = this.i;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.i.cancel();
        }
    }
}
