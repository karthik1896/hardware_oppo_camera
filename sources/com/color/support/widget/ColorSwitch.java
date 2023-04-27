package com.color.support.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.g.b.b;
import color.support.v7.appcompat.R;
import com.color.support.d.d;
import com.color.support.d.m;
import com.oppo.util.ColorOSHapticFeedbackUtils;

public class ColorSwitch extends CompoundButton {
    private float A;
    private int B;
    private float C;
    private float D;
    private float E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private Paint L;
    private Paint M;
    private Paint N;
    private Drawable O;
    private Drawable P;
    private Drawable Q;
    private Drawable R;
    private Drawable S;
    private Drawable T;
    private AnimatorSet U;
    private AnimatorSet V;
    private AnimatorSet W;

    /* renamed from: a  reason: collision with root package name */
    private String f2116a;
    private AnimatorSet aa;
    private m ab;
    private int ac;
    private int ad;
    private boolean ae;
    private boolean af;
    private AccessibilityManager ag;
    private a ah;

    /* renamed from: b  reason: collision with root package name */
    private String f2117b;
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private RectF u;
    private RectF v;
    private int w;
    private int x;
    private float y;
    private float z;

    public interface a {
        void a();
    }

    public ColorSwitch(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorSwitch(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.u = new RectF();
        this.v = new RectF();
        this.y = 1.0f;
        this.z = 1.0f;
        this.F = false;
        this.G = false;
        this.U = new AnimatorSet();
        this.af = false;
        setSoundEffectsEnabled(false);
        d.a(this, false);
        this.ag = (AccessibilityManager) getContext().getSystemService("accessibility");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorSwitch, i2, R.style.ColorSwitchStyle);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSwitch_barWidth, 0);
        this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSwitch_barHeight, 0);
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSwitch_outerCircleStrokeWidth, 0);
        this.g = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_barUncheckedColor, 0);
        this.f = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_barCheckedColor, 0);
        this.h = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ColorSwitch_outerCircleWidth, 0);
        this.j = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_outerCircleColor, 0);
        this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSwitch_innerCircleWidth, 0);
        this.l = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_innerCircleColor, 0);
        this.s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSwitch_circlePadding, 0);
        this.O = obtainStyledAttributes.getDrawable(R.styleable.ColorSwitch_loadingDrawable);
        this.m = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_barUncheckedDisabledColor, 0);
        this.n = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_barCheckedDisabledColor, 0);
        this.o = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_innerCircleUncheckedDisabledColor, 0);
        this.p = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_innerCircleCheckedDisabledColor, 0);
        this.q = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_outerCircleUncheckedDisabledColor, 0);
        this.r = obtainStyledAttributes.getColor(R.styleable.ColorSwitch_outerCircleCheckedDisabledColor, 0);
        this.P = obtainStyledAttributes.getDrawable(R.styleable.ColorSwitch_themedCheckedDrawable);
        this.Q = obtainStyledAttributes.getDrawable(R.styleable.ColorSwitch_themedUncheckedDrawable);
        this.R = obtainStyledAttributes.getDrawable(R.styleable.ColorSwitch_themedLoadingCheckedBackground);
        this.S = obtainStyledAttributes.getDrawable(R.styleable.ColorSwitch_themedLoadingUncheckedBackground);
        this.T = obtainStyledAttributes.getDrawable(R.styleable.ColorSwitch_themedLoadingDrawable);
        this.x = (this.d - (this.s * 2)) - this.h;
        obtainStyledAttributes.recycle();
        this.t = getContext().getResources().getDimensionPixelSize(R.dimen.color_switch_padding);
        this.K = getContext().getResources().getBoolean(R.bool.color_switch_theme_enable);
        e();
        f();
        this.ab = m.a();
        this.ac = this.ab.a(context, R.raw.color_switch_sound_on);
        this.ad = this.ab.a(context, R.raw.color_switch_sound_off);
        this.f2116a = getResources().getString(R.string.switch_on);
        this.f2117b = getResources().getString(R.string.switch_off);
        this.c = getResources().getString(R.string.switch_loading);
    }

    private void e() {
        this.L = new Paint(1);
        this.M = new Paint(1);
        this.N = new Paint(1);
    }

    private void f() {
        g();
        h();
        i();
    }

    private void g() {
        Interpolator a2 = b.a(0.3f, 0.0f, 0.1f, 1.0f);
        this.V = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "circleScale", new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(a2);
        ofFloat.setDuration(433);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "loadingScale", new float[]{0.5f, 1.0f});
        ofFloat2.setInterpolator(a2);
        ofFloat2.setDuration(550);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "loadingAlpha", new float[]{0.0f, 1.0f});
        ofFloat3.setInterpolator(a2);
        ofFloat3.setDuration(550);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "loadingRotation", new float[]{0.0f, 360.0f});
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setDuration(800);
        ofFloat4.setInterpolator(new LinearInterpolator());
        this.V.play(ofFloat).with(ofFloat3).with(ofFloat2).with(ofFloat4);
    }

    private void h() {
        Interpolator a2 = b.a(0.3f, 0.0f, 0.1f, 1.0f);
        this.W = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "loadingAlpha", new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(a2);
        ofFloat.setDuration(100);
        this.W.play(ofFloat);
    }

    private void i() {
        this.aa = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "loadingRotation", new float[]{0.0f, 360.0f});
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(800);
        ofFloat.setInterpolator(new LinearInterpolator());
        this.aa.play(ofFloat);
    }

    public void setOnLoadingStateChangedListener(a aVar) {
        this.ah = aVar;
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    private void a(boolean z2) {
        this.ab.a(getContext(), z2 ? this.ac : this.ad, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    private void j() {
        if (a()) {
            ColorOSHapticFeedbackUtils.performHapticFeedback(this, 302, 0);
            setTactileFeedbackEnabled(false);
        }
    }

    public void setTactileFeedbackEnabled(boolean z2) {
        this.J = z2;
    }

    public boolean a() {
        return this.J;
    }

    public void setChecked(boolean z2) {
        int i2;
        if (z2 != isChecked()) {
            super.setChecked(z2);
            if (!this.K) {
                z2 = isChecked();
                AnimatorSet animatorSet = this.U;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.U.end();
                }
                if (!this.H || !this.I) {
                    if (o()) {
                        if (z2) {
                            i2 = 0;
                        } else {
                            i2 = this.x;
                        }
                        setCircleTranslation(i2);
                    } else {
                        setCircleTranslation(z2 ? this.x : 0);
                    }
                    setInnerCircleAlpha(z2 ? 0.0f : 1.0f);
                    setBarColor(z2 ? this.f : this.g);
                } else {
                    b(z2);
                }
            }
            if (this.ae) {
                a(z2);
                this.ae = false;
            }
            j();
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(boolean r11) {
        /*
            r10 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            r2 = 1050253722(0x3e99999a, float:0.3)
            r3 = 1036831949(0x3dcccccd, float:0.1)
            android.view.animation.Interpolator r2 = androidx.core.g.b.b.a(r2, r1, r3, r0)
            android.animation.AnimatorSet r3 = r10.U
            r3.setInterpolator(r2)
            r2 = 2
            float[] r3 = new float[r2]
            r3 = {1065353216, 1067869798} // fill-array
            java.lang.String r4 = "circleScaleX"
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r10, r4, r3)
            r5 = 133(0x85, double:6.57E-322)
            r3.setDuration(r5)
            float[] r7 = new float[r2]
            r7 = {1067869798, 1065353216} // fill-array
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r10, r4, r7)
            r4.setStartDelay(r5)
            r5 = 250(0xfa, double:1.235E-321)
            r4.setDuration(r5)
            int r5 = r10.getCircleTranslation()
            boolean r6 = r10.o()
            r7 = 0
            if (r6 == 0) goto L_0x0046
            if (r11 == 0) goto L_0x0043
        L_0x0041:
            r6 = r7
            goto L_0x004a
        L_0x0043:
            int r6 = r10.x
            goto L_0x004a
        L_0x0046:
            if (r11 == 0) goto L_0x0041
            int r6 = r10.x
        L_0x004a:
            int[] r8 = new int[r2]
            r8[r7] = r5
            r5 = 1
            r8[r5] = r6
            java.lang.String r6 = "circleTranslation"
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofInt(r10, r6, r8)
            r8 = 383(0x17f, double:1.89E-321)
            r6.setDuration(r8)
            float r8 = r10.getInnerCircleAlpha()
            if (r11 == 0) goto L_0x0063
            r0 = r1
        L_0x0063:
            float[] r1 = new float[r2]
            r1[r7] = r8
            r1[r5] = r0
            java.lang.String r0 = "innerCircleAlpha"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r10, r0, r1)
            r8 = 100
            r0.setDuration(r8)
            int r1 = r10.getBarColor()
            if (r11 == 0) goto L_0x007d
            int r11 = r10.f
            goto L_0x007f
        L_0x007d:
            int r11 = r10.g
        L_0x007f:
            int[] r2 = new int[r2]
            r2[r7] = r1
            r2[r5] = r11
            java.lang.String r11 = "barColor"
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofArgb(r10, r11, r2)
            r1 = 450(0x1c2, double:2.223E-321)
            r11.setDuration(r1)
            android.animation.AnimatorSet r1 = r10.U
            android.animation.AnimatorSet$Builder r1 = r1.play(r3)
            android.animation.AnimatorSet$Builder r1 = r1.with(r4)
            android.animation.AnimatorSet$Builder r1 = r1.with(r6)
            android.animation.AnimatorSet$Builder r0 = r1.with(r0)
            r0.with(r11)
            android.animation.AnimatorSet r11 = r10.U
            r11.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.ColorSwitch.b(boolean):void");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.K) {
            a(canvas);
            f(canvas);
            return;
        }
        m();
        n();
        b(canvas);
        e(canvas);
        c(canvas);
        d(canvas);
    }

    private void a(Canvas canvas) {
        canvas.save();
        Drawable l2 = l();
        l2.setAlpha(k());
        int i2 = this.t;
        l2.setBounds(i2, i2, this.d + i2, this.e + i2);
        l().draw(canvas);
        canvas.restore();
    }

    private int k() {
        return (int) ((isEnabled() ? 1.0f : 0.5f) * 255.0f);
    }

    private Drawable l() {
        return c() ? isChecked() ? this.R : this.S : isChecked() ? this.P : this.Q;
    }

    private void b(Canvas canvas) {
        canvas.save();
        this.L.setColor(this.B);
        if (!isEnabled()) {
            this.L.setColor(isChecked() ? this.n : this.m);
        }
        int i2 = this.e;
        float f2 = ((float) i2) / 2.0f;
        int i3 = this.t;
        canvas.drawRoundRect((float) i3, (float) i3, (float) (this.d + i3), (float) (i2 + i3), f2, f2, this.L);
        canvas.restore();
    }

    private void c(Canvas canvas) {
        canvas.save();
        float f2 = this.z;
        canvas.scale(f2, f2, this.u.centerX(), this.u.centerY());
        this.M.setColor(this.j);
        if (!isEnabled()) {
            this.M.setColor(isChecked() ? this.r : this.q);
        }
        float f3 = ((float) this.h) / 2.0f;
        canvas.drawRoundRect(this.u, f3, f3, this.M);
        canvas.restore();
    }

    private void m() {
        float f2;
        float f3;
        float f4;
        float f5;
        if (isChecked()) {
            if (o()) {
                f3 = (float) (this.s + this.w + this.t);
                f5 = (float) this.h;
                f4 = this.y;
            } else {
                f2 = (float) (((this.d - this.s) - (this.x - this.w)) + this.t);
                f3 = f2 - (((float) this.h) * this.y);
                int i2 = this.e;
                int i3 = this.h;
                float f6 = (((float) (i2 - i3)) / 2.0f) + ((float) this.t);
                this.u.set(f3, f6, f2, ((float) i3) + f6);
            }
        } else if (o()) {
            int i4 = (this.d - this.s) - (this.x - this.w);
            int i5 = this.t;
            float f7 = (float) (i4 + i5);
            float f8 = ((float) i5) + (f7 - (((float) this.h) * this.y));
            f2 = f7;
            f3 = f8;
            int i22 = this.e;
            int i32 = this.h;
            float f62 = (((float) (i22 - i32)) / 2.0f) + ((float) this.t);
            this.u.set(f3, f62, f2, ((float) i32) + f62);
        } else {
            f3 = (float) (this.s + this.w + this.t);
            f5 = (float) this.h;
            f4 = this.y;
        }
        f2 = (f5 * f4) + f3;
        int i222 = this.e;
        int i322 = this.h;
        float f622 = (((float) (i222 - i322)) / 2.0f) + ((float) this.t);
        this.u.set(f3, f622, f2, ((float) i322) + f622);
    }

    private void d(Canvas canvas) {
        canvas.save();
        float f2 = this.z;
        canvas.scale(f2, f2, this.u.centerX(), this.u.centerY());
        float f3 = ((float) this.k) / 2.0f;
        this.N.setColor(this.l);
        if (!isEnabled()) {
            this.N.setColor(isChecked() ? this.p : this.o);
        }
        this.N.setAlpha((int) (this.A * 255.0f));
        canvas.drawRoundRect(this.v, f3, f3, this.N);
        canvas.restore();
    }

    private void n() {
        float f2 = this.u.left + ((float) this.i);
        float f3 = this.u.right - ((float) this.i);
        this.v.set(f2, this.u.top + ((float) this.i), f3, this.u.bottom - ((float) this.i));
    }

    private void e(Canvas canvas) {
        canvas.save();
        float f2 = this.C;
        canvas.scale(f2, f2, this.u.centerX(), this.u.centerY());
        canvas.rotate(this.E, this.u.centerX(), this.u.centerY());
        Drawable drawable = this.O;
        if (drawable != null) {
            drawable.setBounds((int) this.u.left, (int) this.u.top, (int) this.u.right, (int) this.u.bottom);
            this.O.setAlpha((int) (this.D * 255.0f));
            this.O.draw(canvas);
        }
        canvas.restore();
    }

    private void f(Canvas canvas) {
        if (this.F) {
            int height = (getHeight() - this.h) / 2;
            canvas.save();
            canvas.rotate(this.E, (float) (getWidth() / 2), (float) (getHeight() / 2));
            this.T.setBounds((getWidth() - this.h) / 2, height, (getWidth() + this.h) / 2, (getHeight() + this.h) / 2);
            this.T.draw(canvas);
            canvas.restore();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.ae = true;
            this.J = true;
        }
        if (this.G && motionEvent.getAction() == 1 && isEnabled()) {
            b();
            return false;
        } else if (this.F) {
            return false;
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    public void b() {
        if (!this.F) {
            AccessibilityManager accessibilityManager = this.ag;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                announceForAccessibility(this.c);
            }
            this.F = true;
            if (this.K) {
                this.aa.start();
            } else {
                this.V.start();
            }
            a aVar = this.ah;
            if (aVar != null) {
                aVar.a();
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = this.d;
        int i5 = this.t;
        setMeasuredDimension(i4 + (i5 * 2), this.e + (i5 * 2));
        if (!this.af) {
            this.af = true;
            int i6 = 0;
            if (o()) {
                if (!isChecked()) {
                    i6 = this.x;
                }
                this.w = i6;
            } else {
                if (isChecked()) {
                    i6 = this.x;
                }
                this.w = i6;
            }
            this.A = isChecked() ? 0.0f : 1.0f;
            this.B = isChecked() ? this.f : this.g;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.H = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = false;
        this.H = false;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        AnimatorSet animatorSet = this.U;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.U.end();
        }
    }

    public void setShouldPlaySound(boolean z2) {
        this.ae = z2;
    }

    public boolean c() {
        return this.F;
    }

    public void d() {
        this.H = true;
    }

    public void setLoadingStyle(boolean z2) {
        this.G = z2;
    }

    public void setCircleTranslation(int i2) {
        this.w = i2;
        invalidate();
    }

    public int getCircleTranslation() {
        return this.w;
    }

    public void setCircleScaleX(float f2) {
        this.y = f2;
        invalidate();
    }

    public float getCircleScaleX() {
        return this.y;
    }

    public void setInnerCircleAlpha(float f2) {
        this.A = f2;
        invalidate();
    }

    public float getInnerCircleAlpha() {
        return this.A;
    }

    public void setBarColor(int i2) {
        this.B = i2;
        invalidate();
    }

    public int getBarColor() {
        return this.B;
    }

    public void setCircleScale(float f2) {
        this.z = f2;
        invalidate();
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
    }

    public float getCircleScale() {
        return this.z;
    }

    public void setLoadingScale(float f2) {
        this.C = f2;
        invalidate();
    }

    public float getLoadingScale() {
        return this.C;
    }

    public void setLoadingAlpha(float f2) {
        this.D = f2;
        invalidate();
    }

    public float getLoadingAlpha() {
        return this.D;
    }

    public void setLoadingRotation(float f2) {
        this.E = f2;
        invalidate();
    }

    public float getLoadingRotation() {
        return this.E;
    }

    public CharSequence getAccessibilityClassName() {
        return Switch.class.getName();
    }

    private boolean o() {
        if (Build.VERSION.SDK_INT <= 16 || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.G) {
            accessibilityNodeInfo.setCheckable(false);
            accessibilityNodeInfo.setText(isChecked() ? this.f2116a : this.f2117b);
            return;
        }
        accessibilityNodeInfo.setText(isChecked() ? this.f2116a : this.f2117b);
    }
}
