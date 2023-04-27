package com.oppo.camera.ui;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.Checkable;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

public class SwitchButton extends View implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3810a = b(58.0f);

    /* renamed from: b  reason: collision with root package name */
    private static final int f3811b = b(36.0f);
    private Bitmap A = null;
    /* access modifiers changed from: private */
    public b B = null;
    /* access modifiers changed from: private */
    public b C = null;
    /* access modifiers changed from: private */
    public b D = null;
    /* access modifiers changed from: private */
    public int E = 0;
    private ValueAnimator F = null;
    /* access modifiers changed from: private */
    public final ArgbEvaluator G = new ArgbEvaluator();
    private a H = null;
    private c I = null;
    private ValueAnimator.AnimatorUpdateListener J = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int a2 = SwitchButton.this.E;
            if (a2 != 0 && a2 == 1) {
                SwitchButton.this.B.f3814a = SwitchButton.this.C.f3814a + ((SwitchButton.this.D.f3814a - SwitchButton.this.C.f3814a) * floatValue);
                float e = (SwitchButton.this.B.f3814a - SwitchButton.this.q) / (SwitchButton.this.r - SwitchButton.this.q);
                SwitchButton.this.B.c = ((Integer) SwitchButton.this.G.evaluate(e, Integer.valueOf(SwitchButton.this.m), Integer.valueOf(SwitchButton.this.n))).intValue();
            }
            SwitchButton.this.postInvalidate();
        }
    };
    private Animator.AnimatorListener K = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            SwitchButton switchButton = SwitchButton.this;
            boolean unused = switchButton.s = !switchButton.s;
            SwitchButton.this.c();
        }

        public void onAnimationEnd(Animator animator) {
            int a2 = SwitchButton.this.E;
            if (a2 != 0 && a2 == 1) {
                int unused = SwitchButton.this.E = 0;
                SwitchButton.this.postInvalidate();
            }
        }
    };
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private float k = 0.0f;
    private int l = 0;
    /* access modifiers changed from: private */
    public int m = 0;
    /* access modifiers changed from: private */
    public int n = 0;
    private int o = 0;
    private int p = 0;
    /* access modifiers changed from: private */
    public float q = 0.0f;
    /* access modifiers changed from: private */
    public float r = 0.0f;
    /* access modifiers changed from: private */
    public boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private Paint w = null;
    private Paint x = null;
    private Bitmap y = null;
    private Bitmap z = null;

    public interface a {
        void a(SwitchButton switchButton, boolean z);
    }

    public interface c {
        boolean a();
    }

    public SwitchButton(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton);
        this.m = obtainStyledAttributes.getColor(16, context.getColor(R.color.super_eis_switch_thumb_unchecked_color));
        this.n = obtainStyledAttributes.getColor(5, Util.s(context));
        this.l = obtainStyledAttributes.getColor(1, context.getColor(R.color.super_eis_switch_border_color));
        this.o = obtainStyledAttributes.getDimensionPixelSize(2, getResources().getDimensionPixelSize(R.dimen.super_eis_switch_border_width));
        this.p = obtainStyledAttributes.getDimensionPixelSize(14, getResources().getDimensionPixelSize(R.dimen.super_eis_switch_thumb_padding));
        this.s = obtainStyledAttributes.getBoolean(4, false);
        this.t = obtainStyledAttributes.getBoolean(8, true);
        obtainStyledAttributes.recycle();
        b();
        this.B = new b();
        this.C = new b();
        this.D = new b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        this.y = BitmapFactory.decodeResource(getResources(), R.drawable.switch_button_bg, options);
        this.z = Util.a(getContext(), (int) R.drawable.switch_button_pro);
        this.A = Util.a(getContext(), (int) R.drawable.switch_button_eis);
        this.F = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.F.setDuration(300);
        this.F.setRepeatCount(0);
        this.F.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
        this.F.addUpdateListener(this.J);
        this.F.addListener(this.K);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        setLayerType(1, (Paint) null);
    }

    private void b() {
        this.x = new Paint(1);
        this.x.setStrokeWidth((float) this.o);
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setColor(this.l);
        this.w = new Paint(1);
        this.w.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f3810a, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(f3811b, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = this.o;
        float f2 = (float) i6;
        float f3 = ((float) i3) - f2;
        this.e = f3 - f2;
        float f4 = ((float) i2) - f2;
        this.f = f4 - f2;
        this.c = this.e / 2.0f;
        float f5 = this.c;
        this.d = (f5 - ((float) i6)) - ((float) this.p);
        this.g = f2;
        this.h = f2;
        this.i = f4;
        this.j = f3;
        this.k = (this.h + this.j) / 2.0f;
        this.q = this.g + f5;
        this.r = this.i - f5;
        if (isChecked()) {
            setCheckedViewState(this.B);
        } else {
            setUncheckViewState(this.B);
        }
        this.u = true;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.g;
        float f3 = this.h;
        float f4 = this.i;
        float f5 = this.j;
        float f6 = this.c;
        canvas.drawRoundRect(f2, f3, f4, f5, f6, f6, this.x);
        int width = (this.y.getWidth() - this.A.getWidth()) - this.z.getWidth();
        int height = (this.y.getHeight() - this.A.getHeight()) / 2;
        Bitmap bitmap = this.y;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), this.y.getHeight()), (Paint) null);
        if (this.D.d) {
            canvas.drawBitmap(this.A, (float) (width / 3), (float) height, (Paint) null);
        } else {
            Bitmap bitmap2 = this.A;
            canvas.drawBitmap(bitmap2, (float) (((width / 3) * 2) + bitmap2.getWidth()), (float) height, (Paint) null);
        }
        this.w.setColor(this.B.c);
        canvas.drawCircle(this.B.f3814a, this.k, this.d, this.w);
        canvas.drawBitmap(this.z, this.B.f3814a - ((float) (this.z.getWidth() / 2)), this.k - (((float) this.z.getHeight()) / 2.0f), (Paint) null);
    }

    public boolean performClick() {
        if (!this.I.a() || a()) {
            return false;
        }
        toggle();
        return super.performClick();
    }

    public void setChecked(boolean z2) {
        a(z2, true);
    }

    public boolean isChecked() {
        return this.s;
    }

    public void toggle() {
        a(true);
    }

    public void a(boolean z2) {
        b(z2, true);
    }

    private void b(boolean z2, boolean z3) {
        if (isEnabled()) {
            if (this.v) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            } else if (!this.u) {
                this.s = !this.s;
                if (z3) {
                    c();
                }
            } else {
                if (this.F.isRunning()) {
                    this.F.cancel();
                }
                if (!this.t || !z2) {
                    this.s = !this.s;
                    if (isChecked()) {
                        setCheckedViewState(this.B);
                    } else {
                        setUncheckViewState(this.B);
                    }
                    postInvalidate();
                    if (z3) {
                        c();
                        return;
                    }
                    return;
                }
                this.E = 1;
                this.C.a(this.B);
                if (isChecked()) {
                    setUncheckViewState(this.D);
                } else {
                    setCheckedViewState(this.D);
                }
                this.F.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        a aVar = this.H;
        if (aVar != null) {
            this.v = true;
            aVar.a(this, isChecked());
        }
        this.v = false;
    }

    public void a(boolean z2, boolean z3) {
        if (z2 == isChecked()) {
            postInvalidate();
            return;
        }
        b(z3, false);
        if (z2) {
            setCheckedViewState(this.D);
        } else {
            setUncheckViewState(this.D);
        }
        postInvalidate();
    }

    public boolean a() {
        return this.E != 0;
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.H = aVar;
    }

    public void setSwitchClickableListener(c cVar) {
        this.I = cVar;
    }

    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.z = bitmap;
        this.A = bitmap2;
        invalidate();
    }

    private static float a(float f2) {
        return TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    private static int b(float f2) {
        return (int) a(f2);
    }

    private void setUncheckViewState(b bVar) {
        bVar.d = false;
        bVar.c = this.m;
        bVar.f3814a = this.q;
    }

    private void setCheckedViewState(b bVar) {
        bVar.d = true;
        bVar.c = this.n;
        bVar.f3814a = this.r;
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        float f3814a;

        /* renamed from: b  reason: collision with root package name */
        float f3815b;
        int c;
        boolean d;

        private b() {
        }

        /* access modifiers changed from: private */
        public void a(b bVar) {
            this.d = bVar.d;
            this.f3814a = bVar.f3814a;
            this.f3815b = bVar.f3815b;
            this.c = bVar.c;
        }
    }
}
