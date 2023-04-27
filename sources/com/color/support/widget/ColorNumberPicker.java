package com.color.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import color.support.v7.appcompat.R;
import com.color.support.d.m;
import com.color.support.d.q;
import com.oppo.util.ColorOSHapticFeedbackUtils;
import com.sensetime.stmobile.STCommon;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class ColorNumberPicker extends LinearLayout {
    private int A;
    private int B;
    private b C;
    private float D;
    private long E;
    private float F;
    private VelocityTracker G;
    private int H;
    private int I;
    private int J;
    private int K;
    private boolean L;
    /* access modifiers changed from: private */
    public int M;
    /* access modifiers changed from: private */
    public int N;
    private int O;
    /* access modifiers changed from: private */
    public boolean P;
    /* access modifiers changed from: private */
    public boolean Q;
    private a R;
    private int S;
    /* access modifiers changed from: private */
    public AccessibilityManager T;
    private m U;
    private HandlerThread V;
    private Handler W;

    /* renamed from: a  reason: collision with root package name */
    private final int f2080a;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private int ai;
    private int aj;
    private int ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private float as;
    private float at;
    /* access modifiers changed from: private */
    public String au;
    private boolean av;
    private boolean aw;
    private float ax;
    private float ay;
    private float az;

    /* renamed from: b  reason: collision with root package name */
    private final int f2081b;
    private final int c;
    private final int d;
    /* access modifiers changed from: private */
    public final SparseArray<String> e;
    private final Paint f;
    private final Paint g;
    private final Scroller h;
    private final Scroller i;
    private final f j;
    private int k;
    private int l;
    private String[] m;
    private int n;
    private int o;
    /* access modifiers changed from: private */
    public int p;
    private e q;
    private d r;
    private h s;
    private boolean t;
    private boolean u;
    private c v;
    /* access modifiers changed from: private */
    public long w;
    private int[] x;
    private int y;
    private int z;

    public interface c {
        String a(int i);
    }

    public interface d {
        void a(ColorNumberPicker colorNumberPicker, int i);
    }

    public interface e {
        void a(ColorNumberPicker colorNumberPicker, int i, int i2);
    }

    private int a(int i2, int i3, float f2) {
        return i3 - ((int) (((float) ((i3 - i2) * 2)) * f2));
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public ColorNumberPicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorNumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorNumberPickerStyle);
    }

    public ColorNumberPicker(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ColorNumberPicker(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        int i4;
        int i5;
        this.e = new SparseArray<>();
        this.t = true;
        this.w = 300;
        this.z = Integer.MIN_VALUE;
        this.K = 0;
        this.S = -1;
        com.color.support.d.d.a(this, false);
        context.setTheme(R.style.ColorNumberPicker);
        this.T = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.U = m.a();
        this.ac = this.U.a(context, R.raw.color_numberpicker_click);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorNumberPicker, i2, 0);
        this.aa = obtainStyledAttributes.getInteger(R.styleable.ColorNumberPicker_colorPickerRowNumber, 5);
        int i6 = this.aa;
        this.ab = i6 / 2;
        this.x = new int[i6];
        this.f2080a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_internalMinHeight, -1);
        this.f2081b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_internalMaxHeight, -1);
        int i7 = this.f2080a;
        if (i7 == -1 || (i5 = this.f2081b) == -1 || i7 <= i5) {
            this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_internalMinWidth, -1);
            this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_internalMaxWidth, -1);
            int i8 = this.c;
            if (i8 == -1 || (i4 = this.k) == -1 || i8 <= i4) {
                this.ao = obtainStyledAttributes.getInteger(R.styleable.ColorNumberPicker_colorPickerAlignPosition, -1);
                this.ap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_focusTextSize, -1);
                this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_startTextSize, -1);
                this.an = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_colorPickerVisualWidth, -1);
                this.aq = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_colorNOPickerPaddingLeft, 0);
                this.ar = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorNumberPicker_colorNOPickerPaddingRight, 0);
                a(obtainStyledAttributes.getColor(R.styleable.ColorNumberPicker_colorNormalTextColor, -1), obtainStyledAttributes.getColor(R.styleable.ColorNumberPicker_colorFocusTextColor, -1));
                obtainStyledAttributes.recycle();
                this.ax = getResources().getDimension(R.dimen.color_numberpicker_ignore_bar_width);
                this.ay = getResources().getDimension(R.dimen.color_numberpicker_ignore_bar_height);
                this.az = getResources().getDimension(R.dimen.color_numberpicker_ignore_bar_spacing);
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.H = viewConfiguration.getScaledTouchSlop();
                this.I = viewConfiguration.getScaledMinimumFlingVelocity();
                this.J = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
                Paint paint = new Paint();
                paint.setTextSize((float) this.d);
                paint.setAntiAlias(true);
                paint.setTextAlign(Paint.Align.CENTER);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                paint.setTypeface(Typeface.create("sys-sans-en", 0));
                this.as = fontMetrics.top;
                this.at = fontMetrics.bottom;
                this.f = paint;
                this.g = paint;
                this.g.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.oppo_numberpicker_textSize_big));
                this.h = new Scroller(getContext(), (Interpolator) null, true);
                this.i = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
                if (getImportantForAccessibility() == 0) {
                    setImportantForAccessibility(1);
                }
                this.j = new f();
                setWillNotDraw(false);
                setVerticalScrollBarEnabled(false);
                return;
            }
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        throw new IllegalArgumentException("minHeight > maxHeight");
    }

    private static String a(int i2) {
        return String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i2)});
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (z2) {
            f();
            g();
        }
        k();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(b(i2, this.k), b(i3, this.f2081b));
        setMeasuredDimension(a(this.c, getMeasuredWidth(), i2) + ((this.ar + this.aq) * 2), a(this.f2080a, getMeasuredHeight(), i3));
    }

    private boolean a(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i2 = this.z - ((this.A + finalY) % this.y);
        if (i2 == 0) {
            return false;
        }
        int abs = Math.abs(i2);
        int i3 = this.y;
        if (abs > i3 / 2) {
            i2 = i2 > 0 ? i2 - i3 : i2 + i3;
        }
        scrollBy(0, finalY + i2);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        i();
        float y2 = motionEvent.getY();
        this.D = y2;
        this.F = y2;
        this.E = motionEvent.getEventTime();
        this.L = false;
        float f2 = this.D;
        if (f2 < ((float) this.M)) {
            if (this.K == 0) {
                this.j.a(2);
            }
        } else if (f2 > ((float) this.N) && this.K == 0) {
            this.j.a(1);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.h.isFinished()) {
            this.h.forceFinished(true);
            this.i.forceFinished(true);
            c(0);
        } else if (!this.i.isFinished()) {
            this.h.forceFinished(true);
            this.i.forceFinished(true);
        } else {
            float f3 = this.D;
            if (f3 < ((float) this.M)) {
                a(false, (long) ViewConfiguration.getLongPressTimeout());
            } else if (f3 > ((float) this.N)) {
                a(true, (long) ViewConfiguration.getLongPressTimeout());
            } else {
                this.L = true;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.G == null) {
            this.G = VelocityTracker.obtain();
        }
        this.G.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            h();
            this.j.a();
            VelocityTracker velocityTracker = this.G;
            velocityTracker.computeCurrentVelocity(1000, (float) this.J);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.I) {
                d(yVelocity * 2);
                c(2);
            } else {
                int y2 = (int) motionEvent.getY();
                int abs = (int) Math.abs(((float) y2) - this.D);
                long eventTime = motionEvent.getEventTime() - this.E;
                if (abs > this.H || eventTime >= ((long) ViewConfiguration.getTapTimeout())) {
                    j();
                } else if (this.L) {
                    this.L = false;
                    performClick();
                } else {
                    int i2 = (y2 / this.y) - this.ab;
                    if (i2 > 0) {
                        a(true);
                        this.j.b(1);
                    } else if (i2 < 0) {
                        a(false);
                        this.j.b(2);
                    }
                    j();
                }
                c(0);
            }
            this.G.recycle();
            this.G = null;
        } else if (actionMasked == 2) {
            float y3 = motionEvent.getY();
            if (this.K == 1) {
                scrollBy(0, (int) (y3 - this.F));
                invalidate();
            } else if (((int) Math.abs(y3 - this.D)) > this.H) {
                i();
                c(1);
            }
            this.F = y3;
        } else if (actionMasked == 3) {
            j();
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            i();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            int action = keyEvent.getAction();
            if (action != 0) {
                if (action == 1 && this.S == keyCode) {
                    this.S = -1;
                    return true;
                }
            } else if (this.u || (keyCode != 20 ? getValue() > getMinValue() : getValue() < getMaxValue())) {
                requestFocus();
                this.S = keyCode;
                i();
                if (this.h.isFinished()) {
                    a(keyCode == 20);
                }
                return true;
            }
        } else if (keyCode == 23 || keyCode == 66) {
            i();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            i();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.T.isEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            a aVar = (a) getAccessibilityNodeProvider();
            if (actionMasked == 7) {
                int i2 = this.O;
                if (!(i2 == 0 || i2 == -1)) {
                    aVar.a(i2, 256);
                    aVar.a(0, 128);
                    this.O = 0;
                    aVar.performAction(0, 64, (Bundle) null);
                }
            } else if (actionMasked == 9) {
                aVar.a(0, 128);
                this.O = 0;
                aVar.performAction(0, 64, (Bundle) null);
            } else if (actionMasked == 10) {
                aVar.a(0, 256);
                this.O = -1;
            }
        }
        return false;
    }

    public void computeScroll() {
        Scroller scroller = this.h;
        if (scroller.isFinished()) {
            scroller = this.i;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.B == 0) {
            this.B = scroller.getStartY();
        }
        scrollBy(0, currY - this.B);
        this.B = currY;
        if (scroller.isFinished()) {
            b(scroller);
        } else {
            invalidate();
        }
    }

    public void scrollBy(int i2, int i3) {
        int i4;
        int[] iArr = this.x;
        int i5 = this.A;
        if (!this.u && i3 > 0 && iArr[this.ab] <= this.n) {
            this.A = this.z;
        } else if (this.u || i3 >= 0 || iArr[this.ab] < this.o) {
            this.A += i3;
            while (true) {
                int i6 = this.A;
                if (i6 - this.z <= this.l) {
                    break;
                }
                this.A = i6 - this.y;
                b(iArr);
                a(iArr[this.ab], true);
                if (!this.u && iArr[this.ab] <= this.n) {
                    this.A = this.z;
                }
            }
            while (true) {
                i4 = this.A;
                if (i4 - this.z >= (-this.l)) {
                    break;
                }
                this.A = i4 + this.y;
                a(iArr);
                a(iArr[this.ab], true);
                if (!this.u && iArr[this.ab] >= this.o) {
                    this.A = this.z;
                }
            }
            if (i5 != i4) {
                onScrollChanged(0, i4, 0, i5);
            }
        } else {
            this.A = this.z;
        }
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollOffset() {
        return this.A;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        return ((this.o - this.n) + 1) * this.y;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollExtent() {
        return getHeight();
    }

    public void setOnValueChangedListener(e eVar) {
        this.q = eVar;
    }

    public void setOnScrollListener(d dVar) {
        this.r = dVar;
    }

    public void setFormatter(c cVar) {
        if (cVar != this.v) {
            this.v = cVar;
            c();
        }
    }

    public void a() {
        if (this.s == null) {
            this.s = new h();
        }
        this.v = this.s;
    }

    public void setOnLongPressUpdateInterval(long j2) {
        this.w = j2;
    }

    public int getValue() {
        return this.p;
    }

    public void setValue(int i2) {
        a(i2, false);
    }

    public int getMinValue() {
        return this.n;
    }

    public void setMinValue(int i2) {
        if (this.n != i2) {
            if (i2 >= 0) {
                this.n = i2;
                int i3 = this.n;
                if (i3 > this.p) {
                    this.p = i3;
                }
                c();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("minValue must be >= 0");
        }
    }

    private void b() {
        boolean z2 = true;
        if (!(this.o - this.n >= this.x.length) || !this.t) {
            z2 = false;
        }
        this.u = z2;
    }

    public boolean getWrapSelectorWheel() {
        return this.u;
    }

    public void setWrapSelectorWheel(boolean z2) {
        this.t = z2;
        b();
    }

    public int getMaxValue() {
        return this.o;
    }

    public void setMaxValue(int i2) {
        if (this.o != i2) {
            if (i2 >= 0) {
                this.o = i2;
                int i3 = this.o;
                if (i3 < this.p) {
                    this.p = i3;
                }
                c();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
    }

    public String[] getDisplayedValues() {
        return this.m;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.m != strArr) {
            this.m = strArr;
            c();
        }
    }

    public void setPickerRowNumber(int i2) {
        this.aa = i2;
        this.ab = i2 / 2;
        this.x = new int[this.aa];
    }

    public void setAlignPosition(int i2) {
        this.ao = i2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = new HandlerThread("touchEffect", -16);
        this.V.start();
        this.W = new g(this.V.getLooper());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
        HandlerThread handlerThread = this.V;
        if (handlerThread != null) {
            handlerThread.quit();
            this.V = null;
        }
        Handler handler = this.W;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 2;
        float right = (float) ((getRight() - getLeft()) / 2);
        int i10 = this.A;
        int i11 = this.an;
        boolean z2 = true;
        if (!(i11 == -1 || i11 >= getRight() - getLeft() || (i7 = this.ao) == 0)) {
            if (i7 == 1) {
                i8 = this.an / 2;
            } else if (i7 == 2) {
                int right2 = getRight() - getLeft();
                int i12 = this.an;
                i8 = (right2 - i12) + (i12 / 2);
            }
            right = (float) i8;
        }
        int i13 = this.aq;
        if (i13 != 0) {
            right += (float) i13;
        }
        int i14 = this.ar;
        if (i14 != 0) {
            right -= (float) i14;
        }
        float f2 = right;
        int[] iArr = this.x;
        int i15 = 0;
        int i16 = i10;
        while (i15 < iArr.length) {
            int i17 = iArr[i15];
            if (i16 <= this.ad || i16 >= this.ae) {
                i4 = this.af;
                i3 = this.ag;
                i2 = this.ah;
                i5 = this.ai;
            } else {
                float b2 = (float) b(i16);
                i4 = a(this.af, this.aj, b2);
                i3 = a(this.ag, this.ak, b2);
                i2 = a(this.ah, this.al, b2);
                i5 = a(this.ai, this.am, b2);
            }
            int argb = Color.argb(i4, i3, i2, i5);
            int i18 = this.d;
            float a2 = a(i18, this.ap, i18, i18, i16);
            this.f.setColor(argb);
            String str = this.e.get(i17);
            if (!this.aw) {
                this.f.setTextSize(a2);
                if (this.g.measureText(str) >= ((float) getMeasuredWidth())) {
                    this.f.setTextSize((float) this.d);
                    this.aw = z2;
                }
            }
            if (i17 != Integer.MIN_VALUE) {
                if (i15 == this.ab) {
                    Paint.FontMetrics fontMetrics = this.f.getFontMetrics();
                    i6 = ((int) ((((float) ((i16 + i16) + this.y)) - fontMetrics.top) - fontMetrics.bottom)) / i9;
                } else {
                    i6 = ((int) ((((float) ((i16 + i16) + this.y)) - this.as) - this.at)) / i9;
                }
                canvas.drawText(str, f2, (float) i6, this.f);
            } else {
                Canvas canvas2 = canvas;
                float f3 = a2 / ((float) this.ap);
                for (float f4 = -0.5f; f4 < 1.0f; f4 += 1.0f) {
                    float f5 = this.ax;
                    float f6 = ((this.az + f5) * f4 * f3) + f2;
                    float f7 = (f5 * f3) / 2.0f;
                    float f8 = (float) i16;
                    int i19 = this.y;
                    float f9 = (this.ay * f3) / 2.0f;
                    canvas.drawRect(f6 - f7, ((((float) i19) / 2.0f) + f8) - f9, f6 + f7, f8 + (((float) i19) / 2.0f) + f9, this.f);
                }
            }
            i16 += this.y;
            i15++;
            i9 = 2;
            z2 = true;
        }
    }

    private int b(int i2) {
        return Math.abs((i2 - this.z) - (this.ab * this.y)) / this.y;
    }

    private float a(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        int i11 = i6;
        int i12 = this.z;
        int i13 = this.ab;
        int i14 = this.y;
        int i15 = (i13 * i14) + i12;
        int length = ((this.x.length - 1) * i14) + i12;
        double d2 = (double) i11;
        double d3 = (double) i15;
        if (d2 > d3 - (((double) i14) * 0.5d)) {
            i7 = length;
            if (d2 < d3 + (((double) i14) * 0.5d)) {
                return ((float) i8) - (((((float) (i8 - i2)) * 2.0f) * ((float) Math.abs(i11 - i15))) / ((float) this.y));
            }
        } else {
            i7 = length;
        }
        int i16 = this.y;
        if (i11 <= i15 - i16) {
            return ((float) i9) + ((((((float) (i10 - i9)) * 1.0f) * ((float) (i11 - i12))) / ((float) i16)) / 2.0f);
        }
        return i11 >= i15 + i16 ? ((float) i9) + ((((((float) (i10 - i9)) * 1.0f) * ((float) (i7 - i11))) / ((float) i16)) / 2.0f) : (float) i10;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.R == null) {
            this.R = new a();
        }
        return this.R;
    }

    public float getTextSize() {
        return this.f.getTextSize();
    }

    private int b(int i2, int i3) {
        if (i3 == -1) {
            return i2;
        }
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        if (mode == 1073741824) {
            return i2;
        }
        throw new IllegalArgumentException("Unknown measure mode: " + mode);
    }

    private int a(int i2, int i3, int i4) {
        return i2 != -1 ? resolveSizeAndState(Math.max(i2, i3), i4, 0) : i3;
    }

    private void c() {
        this.e.clear();
        int[] iArr = this.x;
        int value = getValue();
        for (int i2 = 0; i2 < this.x.length; i2++) {
            int i3 = i2 - this.ab;
            int c2 = this.av ? c(value, i3) : i3 + value;
            if (this.u) {
                c2 = e(c2);
            }
            iArr[i2] = c2;
            f(iArr[i2]);
        }
    }

    private void a(int i2, boolean z2) {
        int i3;
        if (this.p == i2) {
            c();
            return;
        }
        if (this.u) {
            i3 = e(i2);
        } else {
            i3 = Math.min(Math.max(i2, this.n), this.o);
        }
        int i4 = this.p;
        this.p = i3;
        if (z2) {
            d(i4, i3);
            this.W.removeMessages(0);
            this.W.sendEmptyMessage(0);
            AccessibilityManager accessibilityManager = this.T;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                Message message = new Message();
                message.what = 1;
                message.obj = Integer.valueOf(i3);
                this.W.sendMessage(message);
            }
        }
        c();
        invalidate();
    }

    /* access modifiers changed from: private */
    public void d() {
        this.U.a(getContext(), this.ac, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    /* access modifiers changed from: private */
    public void e() {
        ColorOSHapticFeedbackUtils.performHapticFeedback(this, 302, 0);
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (!a(this.h)) {
            a(this.i);
        }
        this.B = 0;
        if (z2) {
            this.h.startScroll(0, 0, 0, -this.y, 300);
        } else {
            this.h.startScroll(0, 0, 0, this.y, 300);
        }
        invalidate();
    }

    private void f() {
        c();
        int[] iArr = this.x;
        this.l = (int) ((((float) ((getBottom() - getTop()) - (iArr.length * this.d))) / ((float) iArr.length)) + 0.5f);
        this.y = this.d + this.l;
        this.z = 0;
        this.A = 0;
        this.M = (getHeight() / 2) - (this.y / 2);
        this.N = (getHeight() / 2) + (this.y / 2);
    }

    private void g() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.d) / 2);
    }

    private void b(Scroller scroller) {
        if (scroller == this.h) {
            j();
            c(0);
            return;
        }
        int i2 = this.K;
    }

    private void c(int i2) {
        if (this.K != i2) {
            this.K = i2;
            d dVar = this.r;
            if (dVar != null) {
                dVar.a(this, i2);
            }
        }
    }

    private void d(int i2) {
        this.B = 0;
        if (i2 > 0) {
            this.h.fling(0, 0, 0, i2, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.h.fling(0, Integer.MAX_VALUE, 0, i2, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    private int e(int i2) {
        return c(i2, 0);
    }

    private int c(int i2, int i3) {
        int i4 = this.o;
        int i5 = this.n;
        if (i4 - i5 <= 0) {
            return -1;
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = i5 - 1;
        }
        int i6 = this.o;
        int i7 = this.n;
        int a2 = q.a((i2 - i7) + i3, (i6 - i7) + 1 + (this.av ? 1 : 0));
        int i8 = this.o;
        int i9 = this.n;
        if (a2 < (i8 - i9) + 1) {
            return i9 + a2;
        }
        return Integer.MIN_VALUE;
    }

    private void a(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = c(iArr[i2], 1);
        }
        f(iArr[iArr.length - 1]);
    }

    private void b(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = c(iArr[i2], -1);
        }
        f(iArr[0]);
    }

    private void f(int i2) {
        String str;
        SparseArray<String> sparseArray = this.e;
        if (sparseArray.get(i2) == null) {
            int i3 = this.n;
            if (i2 < i3 || i2 > this.o) {
                str = "";
            } else {
                String[] strArr = this.m;
                str = strArr != null ? strArr[i2 - i3] : g(i2);
            }
            sparseArray.put(i2, str);
        }
    }

    private String g(int i2) {
        c cVar = this.v;
        return cVar != null ? cVar.a(i2) : a(i2);
    }

    private void d(int i2, int i3) {
        e eVar = this.q;
        if (eVar != null) {
            eVar.a(this, i2, this.p);
        }
    }

    private void a(boolean z2, long j2) {
        b bVar = this.C;
        if (bVar == null) {
            this.C = new b();
        } else {
            removeCallbacks(bVar);
        }
        this.C.a(z2);
        postDelayed(this.C, j2);
    }

    private void h() {
        b bVar = this.C;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
    }

    private void i() {
        b bVar = this.C;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        this.j.a();
    }

    private boolean j() {
        int i2 = this.z - this.A;
        if (i2 == 0) {
            return false;
        }
        this.B = 0;
        int abs = Math.abs(i2);
        int i3 = this.y;
        if (abs > i3 / 2) {
            if (i2 > 0) {
                i3 = -i3;
            }
            i2 += i3;
        }
        this.i.startScroll(0, 0, 0, i2, 800);
        invalidate();
        return true;
    }

    public void a(int i2, int i3) {
        this.af = Color.alpha(i2);
        this.aj = Color.alpha(i3);
        this.ag = Color.red(i2);
        this.ak = Color.red(i3);
        this.ah = Color.green(i2);
        this.al = Color.green(i3);
        this.ai = Color.blue(i2);
        this.am = Color.blue(i3);
    }

    public void setPickerNormalColor(int i2) {
        this.af = Color.alpha(i2);
        this.ag = Color.red(i2);
        this.ah = Color.green(i2);
        this.ai = Color.green(i2);
    }

    public void setPickerFocusColor(int i2) {
        this.aj = Color.alpha(i2);
        this.ak = Color.red(i2);
        this.al = Color.green(i2);
        this.am = Color.green(i2);
    }

    private void k() {
        int i2 = this.z;
        int i3 = this.y;
        int i4 = this.ab;
        this.ad = (int) (((double) i2) + (((double) i3) * (((double) i4) - 0.5d)));
        this.ae = (int) (((double) i2) + (((double) i3) * (((double) i4) + 0.5d)));
    }

    public void setIgnorable(boolean z2) {
        if (this.av != z2) {
            this.av = z2;
            c();
            invalidate();
        }
    }

    class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final int f2087b = 1;
        private final int c = 2;
        private int d;
        private int e;

        f() {
        }

        public void a() {
            this.e = 0;
            this.d = 0;
            ColorNumberPicker.this.removeCallbacks(this);
            if (ColorNumberPicker.this.P) {
                boolean unused = ColorNumberPicker.this.P = false;
                ColorNumberPicker colorNumberPicker = ColorNumberPicker.this;
                colorNumberPicker.invalidate(0, colorNumberPicker.N, ColorNumberPicker.this.getRight(), ColorNumberPicker.this.getBottom());
            }
            boolean unused2 = ColorNumberPicker.this.Q = false;
            if (ColorNumberPicker.this.Q) {
                ColorNumberPicker colorNumberPicker2 = ColorNumberPicker.this;
                colorNumberPicker2.invalidate(0, 0, colorNumberPicker2.getRight(), ColorNumberPicker.this.M);
            }
        }

        public void a(int i) {
            a();
            this.e = 1;
            this.d = i;
            ColorNumberPicker.this.postDelayed(this, (long) ViewConfiguration.getTapTimeout());
        }

        public void b(int i) {
            a();
            this.e = 2;
            this.d = i;
            ColorNumberPicker.this.post(this);
        }

        public void run() {
            int i = this.e;
            if (i == 1) {
                int i2 = this.d;
                if (i2 == 1) {
                    boolean unused = ColorNumberPicker.this.P = true;
                    ColorNumberPicker colorNumberPicker = ColorNumberPicker.this;
                    colorNumberPicker.invalidate(0, colorNumberPicker.N, ColorNumberPicker.this.getRight(), ColorNumberPicker.this.getBottom());
                } else if (i2 == 2) {
                    boolean unused2 = ColorNumberPicker.this.Q = true;
                    ColorNumberPicker colorNumberPicker2 = ColorNumberPicker.this;
                    colorNumberPicker2.invalidate(0, 0, colorNumberPicker2.getRight(), ColorNumberPicker.this.M);
                }
            } else if (i == 2) {
                int i3 = this.d;
                if (i3 == 1) {
                    if (!ColorNumberPicker.this.P) {
                        ColorNumberPicker.this.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    ColorNumberPicker colorNumberPicker3 = ColorNumberPicker.this;
                    boolean unused3 = colorNumberPicker3.P = !colorNumberPicker3.P;
                    ColorNumberPicker colorNumberPicker4 = ColorNumberPicker.this;
                    colorNumberPicker4.invalidate(0, colorNumberPicker4.N, ColorNumberPicker.this.getRight(), ColorNumberPicker.this.getBottom());
                } else if (i3 == 2) {
                    if (!ColorNumberPicker.this.Q) {
                        ColorNumberPicker.this.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    ColorNumberPicker colorNumberPicker5 = ColorNumberPicker.this;
                    boolean unused4 = colorNumberPicker5.Q = !colorNumberPicker5.Q;
                    ColorNumberPicker colorNumberPicker6 = ColorNumberPicker.this;
                    colorNumberPicker6.invalidate(0, 0, colorNumberPicker6.getRight(), ColorNumberPicker.this.M);
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private boolean f2085b;

        b() {
        }

        /* access modifiers changed from: private */
        public void a(boolean z) {
            this.f2085b = z;
        }

        public void run() {
            ColorNumberPicker.this.a(this.f2085b);
            ColorNumberPicker colorNumberPicker = ColorNumberPicker.this;
            colorNumberPicker.postDelayed(this, colorNumberPicker.w);
        }
    }

    class a extends AccessibilityNodeProvider {

        /* renamed from: b  reason: collision with root package name */
        private final Rect f2083b = new Rect();
        private final int[] c = new int[2];
        private int d = Integer.MIN_VALUE;

        a() {
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return a(0, (String) ColorNumberPicker.this.e.get(ColorNumberPicker.this.p), ColorNumberPicker.this.getScrollX(), ColorNumberPicker.this.getScrollY(), ColorNumberPicker.this.getScrollX() + (ColorNumberPicker.this.getRight() - ColorNumberPicker.this.getLeft()), ColorNumberPicker.this.getScrollY() + (ColorNumberPicker.this.getBottom() - ColorNumberPicker.this.getTop()));
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            return super.findAccessibilityNodeInfosByText(str, i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            if (i != -1) {
                if (i == 0) {
                    if (i2 == 16) {
                        return ColorNumberPicker.this.isEnabled();
                    }
                    if (i2 != 64) {
                        if (i2 != 128 || this.d != i) {
                            return false;
                        }
                        this.d = Integer.MIN_VALUE;
                        a(i, STCommon.ST_MOBILE_TRACKING_SINGLE_THREAD);
                        ColorNumberPicker colorNumberPicker = ColorNumberPicker.this;
                        colorNumberPicker.invalidate(0, 0, colorNumberPicker.getRight(), ColorNumberPicker.this.M);
                        return true;
                    } else if (this.d == i) {
                        return false;
                    } else {
                        this.d = i;
                        a(i, 32768);
                        ColorNumberPicker colorNumberPicker2 = ColorNumberPicker.this;
                        colorNumberPicker2.invalidate(0, 0, colorNumberPicker2.getRight(), ColorNumberPicker.this.M);
                        return true;
                    }
                }
            } else if (i2 != 64) {
                if (i2 != 128) {
                    if (i2 != 4096) {
                        if (i2 == 8192) {
                            if (!ColorNumberPicker.this.isEnabled()) {
                                return false;
                            }
                            ColorNumberPicker.this.a(false);
                            return true;
                        }
                    } else if (!ColorNumberPicker.this.isEnabled()) {
                        return false;
                    } else {
                        ColorNumberPicker.this.a(true);
                        return true;
                    }
                } else if (this.d != i) {
                    return false;
                } else {
                    this.d = Integer.MIN_VALUE;
                    return true;
                }
            } else if (this.d == i) {
                return false;
            } else {
                this.d = i;
                return true;
            }
            return super.performAction(i, i2, bundle);
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            a(i, i2, (String) null);
        }

        private void a(int i, int i2, String str) {
            if (ColorNumberPicker.this.T.isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
                obtain.setPackageName(ColorNumberPicker.this.getContext().getPackageName());
                obtain.getText().add(str);
                obtain.setEnabled(ColorNumberPicker.this.isEnabled());
                obtain.setSource(ColorNumberPicker.this, i);
                ColorNumberPicker colorNumberPicker = ColorNumberPicker.this;
                colorNumberPicker.requestSendAccessibilityEvent(colorNumberPicker, obtain);
            }
        }

        private AccessibilityNodeInfo a(int i, String str, int i2, int i3, int i4, int i5) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setPackageName(ColorNumberPicker.this.getContext().getPackageName());
            obtain.setSource(ColorNumberPicker.this, i);
            obtain.setParent(ColorNumberPicker.this);
            if (!TextUtils.isEmpty(ColorNumberPicker.this.au)) {
                str = str + ColorNumberPicker.this.au;
            }
            obtain.setText(str);
            obtain.setClickable(true);
            obtain.setLongClickable(true);
            obtain.setEnabled(ColorNumberPicker.this.isEnabled());
            Rect rect = this.f2083b;
            rect.set(i2, i3, i4, i5);
            obtain.setBoundsInParent(rect);
            int[] iArr = this.c;
            ColorNumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.d != i) {
                obtain.addAction(64);
            }
            if (this.d == i) {
                obtain.addAction(128);
            }
            if (ColorNumberPicker.this.isEnabled()) {
                obtain.addAction(16);
            }
            return obtain;
        }
    }

    private class h implements c {

        /* renamed from: a  reason: collision with root package name */
        final StringBuilder f2089a = new StringBuilder();

        /* renamed from: b  reason: collision with root package name */
        final Object[] f2090b = new Object[1];
        Formatter c;

        h() {
            a(Locale.getDefault());
        }

        private void a(Locale locale) {
            this.c = b(locale);
        }

        public String a(int i) {
            this.f2090b[0] = Integer.valueOf(i);
            StringBuilder sb = this.f2089a;
            sb.delete(0, sb.length());
            this.c.format("%02d", this.f2090b);
            return this.c.toString();
        }

        private Formatter b(Locale locale) {
            return new Formatter(this.f2089a, locale);
        }
    }

    private class g extends Handler {
        g(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ColorNumberPicker.this.d();
                ColorNumberPicker.this.e();
            } else if (i == 1) {
                String str = (String) ColorNumberPicker.this.e.get(((Integer) message.obj).intValue());
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(ColorNumberPicker.this.au)) {
                        str = str + ColorNumberPicker.this.au;
                    }
                    ColorNumberPicker.this.announceForAccessibility(str);
                } else {
                    return;
                }
            }
            super.handleMessage(message);
        }
    }
}
