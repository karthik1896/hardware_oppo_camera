package com.color.support.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.j;
import androidx.core.g.v;
import color.support.v7.appcompat.R;
import com.color.support.widget.b;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

public class ColorEditText extends j {
    private float A;
    private float B;
    private int C;
    private int D;
    private int E;
    private RectF F;
    private ColorStateList G;
    private ColorStateList H;
    private int I;
    private int J;
    private int K;
    private boolean L;
    private boolean M;
    private ValueAnimator N;
    private ValueAnimator O;
    private ValueAnimator P;
    private boolean Q;
    private boolean R;
    private Paint S;
    private Paint T;
    private Paint U;
    private Paint V;
    /* access modifiers changed from: private */
    public int W;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b.a f2027a;
    /* access modifiers changed from: private */
    public float aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private k af;

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f2028b;
    private Interpolator c;
    private Drawable d;
    private Drawable e;
    private boolean f;
    private boolean g;
    private boolean h;
    private d i;
    private c j;
    private int k;
    private Context l;
    private int m;
    private boolean n;
    private a o;
    /* access modifiers changed from: private */
    public String p;
    private e q;
    private CharSequence r;
    private boolean s;
    private CharSequence t;
    private boolean u;
    private GradientDrawable v;
    private int w;
    private int x;
    private float y;
    private float z;

    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public interface c {
        boolean a();
    }

    public interface d {
        boolean a();
    }

    public ColorEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    @SuppressLint({"WrongConstant"})
    public ColorEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        this.f2027a = new b.a(this);
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.n = false;
        this.p = null;
        this.q = null;
        this.C = 3;
        this.F = new RectF();
        this.l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorEditText, 0, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.ColorEditText_quickDelete, false);
        int color2 = obtainStyledAttributes.getColor(R.styleable.ColorEditText_colorEditTextErrorColor, getResources().getColor(R.color.color_error_color_default));
        obtainStyledAttributes.recycle();
        setFastDeletable(z2);
        this.d = getResources().getDrawable(R.drawable.color_edit_text_delete_icon_normal);
        this.e = getResources().getDrawable(R.drawable.color_edit_text_delete_icon_pressed);
        Drawable drawable = this.d;
        if (drawable != null) {
            this.ae = drawable.getIntrinsicWidth();
            i3 = this.d.getIntrinsicHeight();
            this.d.setBounds(0, 0, this.ae, i3);
        } else {
            i3 = 0;
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.ae, i3);
        }
        this.o = new a(this);
        v.a((View) this, (androidx.core.g.a) this.o);
        v.b((View) this, 1);
        this.p = this.l.getString(R.string.color_slide_delete);
        this.o.invalidateRoot();
        this.af = new k(this);
        a(context, attributeSet, i2);
        this.af.a(color2, this.C, this.x, getCornerRadiiAsArray(), this.f2027a);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        this.f2027a.a((Interpolator) new LinearInterpolator());
        this.f2027a.b((Interpolator) new LinearInterpolator());
        this.f2027a.b((int) BadgeDrawable.TOP_START);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2028b = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
            this.c = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
        } else {
            this.f2028b = new LinearInterpolator();
            this.c = new LinearInterpolator();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorEditText, i2, R.style.Widget_ColorSupport_EditText_HintAnim_Line);
        this.s = obtainStyledAttributes.getBoolean(R.styleable.ColorEditText_colorHintEnabled, false);
        if (Build.VERSION.SDK_INT < 23) {
            this.s = false;
            setPadding(0, 0, 0, 0);
            return;
        }
        setTopHint(obtainStyledAttributes.getText(R.styleable.ColorEditText_android_hint));
        if (this.s) {
            this.M = obtainStyledAttributes.getBoolean(R.styleable.ColorEditText_colorHintAnimationEnabled, true);
        }
        this.ab = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ColorEditText_rectModePaddingTop, 0);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.ColorEditText_cornerRadius, 0.0f);
        this.y = dimension;
        this.z = dimension;
        this.A = dimension;
        this.B = dimension;
        this.J = obtainStyledAttributes.getColor(R.styleable.ColorEditText_colorStrokeColor, com.color.support.d.c.a(context, R.attr.colorPrimaryColor, 0));
        this.C = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ColorEditText_colorStrokeWidth, 0);
        this.D = this.C;
        if (this.s) {
            this.w = context.getResources().getDimensionPixelOffset(R.dimen.color_textinput_label_cutout_padding);
            this.ac = context.getResources().getDimensionPixelOffset(R.dimen.color_textinput_line_padding_top);
            this.ad = context.getResources().getDimensionPixelOffset(R.dimen.color_textinput_line_padding_middle);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.ColorEditText_colorBackgroundMode, 0);
        setBoxBackgroundMode(i3);
        if (this.x != 0) {
            setBackgroundDrawable((Drawable) null);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ColorEditText_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.ColorEditText_android_textColorHint);
            this.H = colorStateList;
            this.G = colorStateList;
        }
        this.I = obtainStyledAttributes.getColor(R.styleable.ColorEditText_colorDefaultStrokeColor, getResources().getColor(R.color.color_textinput_stroke_color_default));
        this.K = obtainStyledAttributes.getColor(R.styleable.ColorEditText_colorDisabledStrokeColor, getResources().getColor(R.color.color_textinput_stroke_color_disabled));
        a(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorEditText_collapsedTextSize, 0), obtainStyledAttributes.getColorStateList(R.styleable.ColorEditText_colorStrokeColor));
        if (i3 == 2) {
            this.f2027a.a(Typeface.create("sans-serif-medium", 0));
        }
        obtainStyledAttributes.recycle();
        this.V = new Paint();
        this.T = new Paint();
        this.T.setColor(this.I);
        this.T.setStrokeWidth((float) this.C);
        this.U = new Paint();
        this.U.setColor(this.K);
        this.U.setStrokeWidth((float) this.C);
        this.S = new Paint();
        this.S.setColor(this.J);
        this.S.setStrokeWidth((float) this.C);
        g();
    }

    public void setFastDeletable(boolean z2) {
        if (this.g != z2) {
            this.g = z2;
            if (this.g) {
                if (this.q == null) {
                    this.q = new e();
                    addTextChangedListener(this.q);
                }
                this.m = this.l.getResources().getDimensionPixelSize(R.dimen.oppo_edit_text_drawable_padding);
                setCompoundDrawablePadding(this.m);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (TextUtils.isEmpty(getText().toString())) {
            if (t()) {
                setPaddingRelative(0, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
            }
            setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.h = false;
        } else if (z2) {
            if (this.d != null && !this.h) {
                if (t()) {
                    setPaddingRelative(this.ae + this.m, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
                }
                setCompoundDrawables((Drawable) null, (Drawable) null, this.d, (Drawable) null);
                this.h = true;
            }
        } else if (this.h) {
            if (t()) {
                setPaddingRelative(0, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
            }
            setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.h = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.g) {
            b(z2);
        }
    }

    public void setOnTextDeletedListener(d dVar) {
        this.i = dVar;
    }

    public void setTextDeletedListener(c cVar) {
        this.j = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0069, code lost:
        if (r1 < r0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006f, code lost:
        if (r1 > r0) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.g
            if (r0 == 0) goto L_0x00e6
            android.text.Editable r0 = r6.getText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00e6
            boolean r0 = r6.hasFocus()
            if (r0 == 0) goto L_0x00e6
            int r0 = r6.getRight()
            int r1 = r6.getLeft()
            int r0 = r0 - r1
            int r1 = r6.getPaddingRight()
            int r0 = r0 - r1
            int r1 = r6.k
            int r0 = r0 - r1
            int r1 = r6.getWidth()
            int r2 = r6.k
            int r3 = r6.getPaddingRight()
            int r2 = r2 + r3
            int r3 = r6.getPaddingLeft()
            int r2 = r2 + r3
            r3 = 0
            if (r1 >= r2) goto L_0x0039
            return r3
        L_0x0039:
            float r1 = r7.getX()
            int r1 = (int) r1
            float r2 = r7.getY()
            int r2 = (int) r2
            boolean r4 = r6.s()
            r5 = 1
            if (r4 == 0) goto L_0x006f
            boolean r0 = r6.t()
            if (r0 == 0) goto L_0x0060
            int r0 = r6.getCompoundPaddingLeft()
            int r4 = r6.getPaddingRight()
            int r0 = r0 - r4
            int r4 = r6.ae
            int r0 = r0 + r4
            int r4 = r6.m
            int r0 = r0 + r4
            goto L_0x0069
        L_0x0060:
            int r0 = r6.getCompoundPaddingLeft()
            int r4 = r6.getPaddingRight()
            int r0 = r0 - r4
        L_0x0069:
            if (r1 >= r0) goto L_0x006d
        L_0x006b:
            r0 = r5
            goto L_0x0072
        L_0x006d:
            r0 = r3
            goto L_0x0072
        L_0x006f:
            if (r1 <= r0) goto L_0x006d
            goto L_0x006b
        L_0x0072:
            int r1 = r7.getAction()
            r4 = 0
            if (r1 == 0) goto L_0x00d6
            if (r1 == r5) goto L_0x00b4
            r3 = 2
            if (r1 == r3) goto L_0x008d
            r0 = 3
            if (r1 == r0) goto L_0x0085
            r0 = 4
            if (r1 == r0) goto L_0x0085
            goto L_0x00e6
        L_0x0085:
            android.graphics.drawable.Drawable r0 = r6.d
            if (r0 == 0) goto L_0x00e6
            r6.setCompoundDrawables(r4, r4, r0, r4)
            goto L_0x00e6
        L_0x008d:
            if (r0 == 0) goto L_0x0098
            boolean r1 = r6.h
            if (r1 == 0) goto L_0x0098
            boolean r1 = r6.f
            if (r1 == 0) goto L_0x0098
            return r5
        L_0x0098:
            if (r0 == 0) goto L_0x00a2
            if (r2 < 0) goto L_0x00a2
            int r0 = r6.getHeight()
            if (r2 <= r0) goto L_0x00e6
        L_0x00a2:
            android.graphics.drawable.Drawable r0 = r6.d
            if (r0 == 0) goto L_0x00e6
            android.graphics.drawable.Drawable[] r0 = r6.getCompoundDrawablesRelative()
            r0 = r0[r3]
            if (r0 != 0) goto L_0x00e6
            android.graphics.drawable.Drawable r0 = r6.d
            r6.setCompoundDrawables(r4, r4, r0, r4)
            goto L_0x00e6
        L_0x00b4:
            if (r0 == 0) goto L_0x00e6
            boolean r0 = r6.h
            if (r0 == 0) goto L_0x00e6
            boolean r0 = r6.f
            if (r0 == 0) goto L_0x00e6
            android.graphics.drawable.Drawable r0 = r6.d
            if (r0 == 0) goto L_0x00c5
            r6.setCompoundDrawables(r4, r4, r0, r4)
        L_0x00c5:
            com.color.support.widget.ColorEditText$d r0 = r6.i
            if (r0 == 0) goto L_0x00d0
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x00d0
            goto L_0x00e6
        L_0x00d0:
            r6.c()
            r6.f = r3
            goto L_0x00e6
        L_0x00d6:
            if (r0 == 0) goto L_0x00e6
            boolean r0 = r6.h
            if (r0 == 0) goto L_0x00e6
            r6.f = r5
            android.graphics.drawable.Drawable r7 = r6.e
            if (r7 == 0) goto L_0x00e5
            r6.setCompoundDrawables(r4, r4, r7, r4)
        L_0x00e5:
            return r5
        L_0x00e6:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.ColorEditText.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: private */
    public void c() {
        Editable text = getText();
        text.delete(0, text.length());
        setText("");
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        return TextUtils.isEmpty(str);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        if (drawable3 != null) {
            this.k = drawable3.getBounds().width();
        } else {
            this.k = 0;
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.g || i2 != 67) {
            return super.onKeyDown(i2, keyEvent);
        }
        super.onKeyDown(i2, keyEvent);
        c cVar = this.j;
        if (cVar == null) {
            return true;
        }
        cVar.a();
        return true;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        Selection.setSelection(getText(), length());
    }

    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        if (this.n) {
            onStartTemporaryDetach();
        }
    }

    public boolean a() {
        return this.g && !a(getText().toString()) && hasFocus();
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        a aVar;
        if (!a() || (aVar = this.o) == null || !aVar.dispatchHoverEvent(motionEvent)) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return true;
    }

    public int getDeleteButtonLeft() {
        Drawable drawable = this.d;
        return ((getRight() - getLeft()) - getPaddingRight()) - (drawable != null ? drawable.getIntrinsicWidth() : 0);
    }

    private Drawable getBoxBackground() {
        int i2 = this.x;
        if (i2 == 1 || i2 == 2) {
            return this.v;
        }
        return null;
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.x) {
            this.x = i2;
            d();
        }
    }

    private void d() {
        f();
        h();
    }

    private void e() {
        v.b(this, s() ? getPaddingRight() : getPaddingLeft(), getModePaddingTop(), s() ? getPaddingLeft() : getPaddingRight(), getPaddingBottom());
    }

    private int getModePaddingTop() {
        int e2;
        int i2;
        int i3 = this.x;
        if (i3 == 1) {
            e2 = this.ac + ((int) this.f2027a.e());
            i2 = this.ad;
        } else if (i3 != 2) {
            return 0;
        } else {
            e2 = this.ab;
            i2 = (int) (this.f2027a.d() / 2.0f);
        }
        return e2 + i2;
    }

    private void f() {
        int i2 = this.x;
        if (i2 == 0) {
            this.v = null;
        } else if (i2 == 2 && this.s && !(this.v instanceof b)) {
            this.v = new b();
        } else if (this.v == null) {
            this.v = new GradientDrawable();
        }
    }

    public int getBoxStrokeColor() {
        return this.J;
    }

    public void setBoxStrokeColor(int i2) {
        if (this.J != i2) {
            this.J = i2;
            p();
        }
    }

    private float[] getCornerRadiiAsArray() {
        float f2 = this.z;
        float f3 = this.y;
        float f4 = this.B;
        float f5 = this.A;
        return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
    }

    private void g() {
        d();
        this.f2027a.a(getTextSize());
        int gravity = getGravity();
        this.f2027a.b((gravity & -113) | 48);
        this.f2027a.a(gravity);
        if (this.G == null) {
            this.G = getHintTextColors();
        }
        CharSequence charSequence = null;
        setHint(this.s ? null : "");
        if (TextUtils.isEmpty(this.t)) {
            this.r = getHint();
            setTopHint(this.r);
            if (!this.s) {
                charSequence = "";
            }
            setHint(charSequence);
        }
        this.u = true;
        a(false, true);
        if (this.s) {
            e();
        }
    }

    public void a(boolean z2) {
        a(z2, false);
    }

    private void a(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        boolean isEnabled = isEnabled();
        boolean z4 = !TextUtils.isEmpty(getText());
        if (this.G != null) {
            this.G = getHintTextColors();
            this.f2027a.a(this.G);
            this.f2027a.b(this.G);
        }
        if (!isEnabled) {
            this.f2027a.a(ColorStateList.valueOf(this.K));
            this.f2027a.b(ColorStateList.valueOf(this.K));
        } else if (hasFocus() && (colorStateList = this.H) != null) {
            this.f2027a.a(colorStateList);
        }
        if (z4 || (isEnabled() && hasFocus())) {
            if (z3 || this.L) {
                c(z2);
            }
        } else if ((z3 || !this.L) && b()) {
            d(z2);
        }
        k kVar = this.af;
        if (kVar != null) {
            kVar.a(this.f2027a);
        }
    }

    public void setTopHint(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            setHintInternal(charSequence);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.t)) {
            this.t = charSequence;
            this.f2027a.a(charSequence);
            if (!this.L) {
                m();
            }
            k kVar = this.af;
            if (kVar != null) {
                kVar.b(this.f2027a);
            }
        }
    }

    public CharSequence getHint() {
        if (this.s) {
            return this.t;
        }
        return null;
    }

    public boolean b() {
        return this.s;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.s) {
            this.s = z2;
            if (!this.s) {
                this.u = false;
                if (!TextUtils.isEmpty(this.t) && TextUtils.isEmpty(getHint())) {
                    setHint(this.t);
                }
                setHintInternal((CharSequence) null);
                return;
            }
            CharSequence hint = getHint();
            if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.t)) {
                    setTopHint(hint);
                }
                setHint((CharSequence) null);
            }
            this.u = true;
        }
    }

    public void a(int i2, ColorStateList colorStateList) {
        this.f2027a.a(i2, colorStateList);
        this.H = this.f2027a.p();
        a(false);
        this.af.a(i2, colorStateList);
    }

    private void h() {
        if (this.x != 0 && this.v != null && getRight() != 0) {
            this.v.setBounds(0, getBoundsTop(), getWidth(), getHeight());
            k();
        }
    }

    private int getBoundsTop() {
        int i2 = this.x;
        if (i2 == 1) {
            return this.ac;
        }
        if (i2 != 2) {
            return 0;
        }
        return (int) (this.f2027a.d() / 2.0f);
    }

    public int getLabelMarginTop() {
        if (this.s) {
            return (int) (this.f2027a.d() / 2.0f);
        }
        return 0;
    }

    public Rect getBackgroundRect() {
        int i2 = this.x;
        if (i2 == 1 || i2 == 2) {
            return getBoxBackground().getBounds();
        }
        return null;
    }

    private int i() {
        int i2 = this.x;
        if (i2 == 1) {
            return getBoxBackground().getBounds().top;
        }
        if (i2 != 2) {
            return getPaddingTop();
        }
        return getBoxBackground().getBounds().top - getLabelMarginTop();
    }

    private void j() {
        int i2 = this.x;
        if (i2 == 1) {
            this.C = 0;
        } else if (i2 == 2 && this.J == 0) {
            this.J = this.H.getColorForState(getDrawableState(), this.H.getDefaultColor());
        }
    }

    private void k() {
        int i2;
        if (this.v != null) {
            j();
            int i3 = this.C;
            if (i3 > -1 && (i2 = this.E) != 0) {
                this.v.setStroke(i3, i2);
            }
            this.v.setCornerRadii(getCornerRadiiAsArray());
            invalidate();
        }
    }

    public void setmHintAnimationEnabled(boolean z2) {
        this.M = z2;
    }

    public void draw(Canvas canvas) {
        if (getHintTextColors() != this.G) {
            a(false);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            if (!this.s && getText().length() != 0) {
                canvas.drawText(" ", 0.0f, 0.0f, this.V);
            } else if (!this.af.a()) {
                this.f2027a.a(canvas);
            } else {
                this.af.a(canvas, this.f2027a);
            }
            if (this.v != null && this.x == 2) {
                if (getScrollX() != 0) {
                    h();
                }
                if (!this.af.a()) {
                    this.v.draw(canvas);
                } else {
                    this.af.a(canvas, this.v, this.E);
                }
            }
            if (this.x == 1) {
                int height = getHeight() - ((int) ((((double) this.D) / 2.0d) + 0.5d));
                this.S.setAlpha(this.W);
                if (!isEnabled()) {
                    float f2 = (float) height;
                    canvas.drawLine(0.0f, f2, (float) getWidth(), f2, this.U);
                } else if (!this.af.a()) {
                    float f3 = (float) height;
                    float f4 = f3;
                    canvas.drawLine(0.0f, f3, (float) getWidth(), f4, this.T);
                    canvas.drawLine(0.0f, f4, this.aa * ((float) getWidth()), f3, this.S);
                } else {
                    this.af.a(canvas, height, getWidth(), (int) (this.aa * ((float) getWidth())), this.T, this.S);
                }
            }
            canvas.restoreToCount(save);
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.af.a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.v != null) {
                h();
            }
            if (this.s) {
                e();
            }
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int width = getWidth() - getCompoundPaddingRight();
            int i6 = i();
            this.f2027a.a(compoundPaddingLeft, getCompoundPaddingTop(), width, getHeight() - getCompoundPaddingBottom());
            this.f2027a.b(compoundPaddingLeft, i6, width, getHeight() - getCompoundPaddingBottom());
            this.f2027a.m();
            if (l() && !this.L) {
                m();
            }
            this.af.c(this.f2027a);
        }
    }

    private void c(boolean z2) {
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.N.cancel();
        }
        if (!z2 || !this.M) {
            this.f2027a.b(1.0f);
        } else {
            a(1.0f);
        }
        this.L = false;
        if (l()) {
            m();
        }
    }

    private boolean l() {
        if (Build.VERSION.SDK_INT >= 23 && this.s && !TextUtils.isEmpty(this.t) && (this.v instanceof b)) {
            return true;
        }
        return false;
    }

    private void m() {
        if (l()) {
            RectF rectF = this.F;
            this.f2027a.a(rectF);
            a(rectF);
            ((b) this.v).a(rectF);
        }
    }

    private void n() {
        if (l()) {
            ((b) this.v).c();
        }
    }

    private void a(RectF rectF) {
        rectF.left -= (float) this.w;
        rectF.top -= (float) this.w;
        rectF.right += (float) this.w;
        rectF.bottom += (float) this.w;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drawableStateChanged() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 >= r1) goto L_0x000a
            super.drawableStateChanged()
            return
        L_0x000a:
            boolean r0 = r4.Q
            if (r0 == 0) goto L_0x000f
            return
        L_0x000f:
            r0 = 1
            r4.Q = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            boolean r2 = r4.s
            r3 = 0
            if (r2 == 0) goto L_0x0030
            boolean r2 = androidx.core.g.v.A(r4)
            if (r2 == 0) goto L_0x002b
            boolean r2 = r4.isEnabled()
            if (r2 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r3
        L_0x002c:
            r4.a((boolean) r0)
            goto L_0x0033
        L_0x0030:
            r4.a((boolean) r3)
        L_0x0033:
            r4.o()
            boolean r0 = r4.s
            if (r0 == 0) goto L_0x004f
            r4.h()
            r4.p()
            com.color.support.widget.b$a r0 = r4.f2027a
            if (r0 == 0) goto L_0x004f
            boolean r0 = r0.a((int[]) r1)
            r0 = r0 | r3
            com.color.support.widget.k r2 = r4.af
            r2.a((int[]) r1)
            goto L_0x0050
        L_0x004f:
            r0 = r3
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            r4.invalidate()
        L_0x0055:
            r4.Q = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.ColorEditText.drawableStateChanged():void");
    }

    private void o() {
        if (this.x == 1) {
            if (!isEnabled()) {
                this.aa = 0.0f;
            } else if (hasFocus()) {
                if (!this.R) {
                    q();
                }
            } else if (this.R) {
                r();
            }
        }
    }

    private void p() {
        int i2;
        if (this.v != null && (i2 = this.x) != 0 && i2 == 2) {
            if (!isEnabled()) {
                this.E = this.K;
            } else if (hasFocus()) {
                this.E = this.J;
            } else {
                this.E = this.I;
            }
            k();
        }
    }

    private void d(boolean z2) {
        if (this.v != null) {
            Log.d("ColorEditText", "mBoxBackground: " + this.v.getBounds());
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.N.cancel();
        }
        if (!z2 || !this.M) {
            this.f2027a.b(0.0f);
        } else {
            a(0.0f);
        }
        if (l() && ((b) this.v).a()) {
            n();
        }
        this.L = true;
    }

    private void q() {
        if (this.O == null) {
            this.O = new ValueAnimator();
            this.O.setInterpolator(this.c);
            this.O.setDuration(250);
            this.O.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = ColorEditText.this.aa = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ColorEditText.this.invalidate();
                }
            });
        }
        this.W = 255;
        this.O.setFloatValues(new float[]{0.0f, 1.0f});
        this.O.start();
        this.R = true;
    }

    private void r() {
        if (this.P == null) {
            this.P = new ValueAnimator();
            this.P.setInterpolator(this.c);
            this.P.setDuration(250);
            this.P.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int unused = ColorEditText.this.W = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ColorEditText.this.invalidate();
                }
            });
        }
        this.P.setIntValues(new int[]{255, 0});
        this.P.start();
        this.R = false;
    }

    private void a(float f2) {
        if (this.f2027a.j() != f2) {
            if (this.N == null) {
                this.N = new ValueAnimator();
                this.N.setInterpolator(this.f2028b);
                this.N.setDuration(200);
                this.N.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ColorEditText.this.f2027a.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.N.setFloatValues(new float[]{this.f2027a.j(), f2});
            this.N.start();
        }
    }

    private boolean s() {
        return getLayoutDirection() == 1;
    }

    public void setErrorState(boolean z2) {
        this.af.a(z2);
    }

    private class e implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private e() {
        }

        public void afterTextChanged(Editable editable) {
            ColorEditText colorEditText = ColorEditText.this;
            colorEditText.b(colorEditText.hasFocus());
        }
    }

    private boolean t() {
        return (getGravity() & 7) == 1;
    }

    public class a extends androidx.customview.a.a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private View f2033b = null;
        private Context c = null;
        private Rect d = null;
        private Rect e = null;

        public void onClick(View view) {
        }

        public a(View view) {
            super(view);
            this.f2033b = view;
            this.c = this.f2033b.getContext();
        }

        private void a() {
            this.d = new Rect();
            this.d.left = ColorEditText.this.getDeleteButtonLeft();
            this.d.right = ColorEditText.this.getWidth();
            Rect rect = this.d;
            rect.top = 0;
            rect.bottom = ColorEditText.this.getHeight();
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f, float f2) {
            if (this.d == null) {
                a();
            }
            if (f < ((float) this.d.left) || f > ((float) this.d.right) || f2 < ((float) this.d.top) || f2 > ((float) this.d.bottom) || !ColorEditText.this.a()) {
                return Integer.MIN_VALUE;
            }
            return 0;
        }

        /* access modifiers changed from: protected */
        public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(ColorEditText.this.p);
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i, androidx.core.g.a.d dVar) {
            if (i == 0) {
                dVar.e((CharSequence) ColorEditText.this.p);
                dVar.b((CharSequence) Button.class.getName());
                dVar.a(16);
            }
            dVar.b(a(i));
        }

        private Rect a(int i) {
            if (i != 0) {
                return new Rect();
            }
            if (this.d == null) {
                a();
            }
            return this.d;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> list) {
            if (ColorEditText.this.a()) {
                list.add(0);
            }
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (i != 0 || !ColorEditText.this.a()) {
                return true;
            }
            ColorEditText.this.c();
            return true;
        }
    }
}
