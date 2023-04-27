package color.support.v7.widget.pageindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import color.support.v7.appcompat.R;
import com.color.support.d.d;
import java.util.ArrayList;
import java.util.List;

public class ColorPageIndicator extends FrameLayout {
    /* access modifiers changed from: private */
    public RectF A;
    private ValueAnimator B;
    private Handler C;
    private int D;
    /* access modifiers changed from: private */
    public a E;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f1583a;

    /* renamed from: b  reason: collision with root package name */
    private int f1584b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private int i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    private int l;
    /* access modifiers changed from: private */
    public float m;
    /* access modifiers changed from: private */
    public float n;
    /* access modifiers changed from: private */
    public float o;
    /* access modifiers changed from: private */
    public float p;
    /* access modifiers changed from: private */
    public boolean q;
    /* access modifiers changed from: private */
    public boolean r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public boolean t;
    private boolean u;
    /* access modifiers changed from: private */
    public boolean v;
    private boolean w;
    private LinearLayout x;
    private List<View> y;
    private Paint z;

    public interface a {
        void onClick(int i);
    }

    public ColorPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorPageIndicatorStyle);
    }

    @TargetApi(21)
    public ColorPageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = 0;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.A = new RectF();
        d.a(this, false);
        this.y = new ArrayList();
        this.h = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPageIndicator, i2, 0);
            this.f = obtainStyledAttributes.getColor(R.styleable.ColorPageIndicator_traceDotColor, 0);
            this.c = obtainStyledAttributes.getColor(R.styleable.ColorPageIndicator_dotColor, 0);
            this.f1583a = (int) obtainStyledAttributes.getDimension(R.styleable.ColorPageIndicator_dotSize, 0.0f);
            this.f1584b = (int) obtainStyledAttributes.getDimension(R.styleable.ColorPageIndicator_dotSpacing, 0.0f);
            this.e = (int) obtainStyledAttributes.getDimension(R.styleable.ColorPageIndicator_dotCornerRadius, (float) (this.f1583a / 2));
            this.g = obtainStyledAttributes.getBoolean(R.styleable.ColorPageIndicator_dotClickable, true);
            this.d = (int) obtainStyledAttributes.getDimension(R.styleable.ColorPageIndicator_dotStrokeWidth, 0.0f);
            obtainStyledAttributes.recycle();
        }
        RectF rectF = this.A;
        rectF.top = 0.0f;
        rectF.bottom = (float) this.f1583a;
        this.B = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.B.setDuration(240);
        if (Build.VERSION.SDK_INT >= 21) {
            this.B.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        }
        this.B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (!ColorPageIndicator.this.t) {
                    float b2 = ColorPageIndicator.this.m - ColorPageIndicator.this.o;
                    float d = ColorPageIndicator.this.n - ColorPageIndicator.this.p;
                    float b3 = ColorPageIndicator.this.m - (b2 * floatValue);
                    if (b3 > ColorPageIndicator.this.A.right - ((float) ColorPageIndicator.this.f1583a)) {
                        b3 = ColorPageIndicator.this.A.right - ((float) ColorPageIndicator.this.f1583a);
                    }
                    float d2 = ColorPageIndicator.this.n - (d * floatValue);
                    if (d2 < ColorPageIndicator.this.A.left + ((float) ColorPageIndicator.this.f1583a)) {
                        d2 = ((float) ColorPageIndicator.this.f1583a) + ColorPageIndicator.this.A.left;
                    }
                    if (ColorPageIndicator.this.v) {
                        ColorPageIndicator.this.A.left = b3;
                        ColorPageIndicator.this.A.right = d2;
                    } else if (ColorPageIndicator.this.q) {
                        ColorPageIndicator.this.A.right = d2;
                    } else {
                        ColorPageIndicator.this.A.left = b3;
                    }
                    ColorPageIndicator.this.invalidate();
                }
            }
        });
        this.B.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!ColorPageIndicator.this.t) {
                    ColorPageIndicator.this.A.right = ColorPageIndicator.this.A.left + ((float) ColorPageIndicator.this.f1583a);
                    boolean unused = ColorPageIndicator.this.v = false;
                    boolean unused2 = ColorPageIndicator.this.r = true;
                    ColorPageIndicator.this.invalidate();
                }
                boolean unused3 = ColorPageIndicator.this.s = false;
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                boolean unused = ColorPageIndicator.this.t = false;
                ColorPageIndicator colorPageIndicator = ColorPageIndicator.this;
                float unused2 = colorPageIndicator.m = colorPageIndicator.A.left;
                ColorPageIndicator colorPageIndicator2 = ColorPageIndicator.this;
                float unused3 = colorPageIndicator2.n = colorPageIndicator2.A.right;
            }
        });
        this.z = new Paint(1);
        this.z.setStyle(Paint.Style.FILL);
        this.z.setColor(this.f);
        this.l = this.f1583a + (this.f1584b * 2);
        this.C = new Handler() {
            public void handleMessage(Message message) {
                if (message.what == 17) {
                    ColorPageIndicator.this.d();
                }
                super.handleMessage(message);
            }
        };
        this.x = new LinearLayout(context);
        this.x.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.x.setOrientation(0);
        addView(this.x);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT > 16) {
                    ColorPageIndicator.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                ColorPageIndicator colorPageIndicator = ColorPageIndicator.this;
                colorPageIndicator.c(colorPageIndicator.j);
            }
        });
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        f(this.j);
        RectF rectF = this.A;
        rectF.left = this.o;
        rectF.right = this.p;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        RectF rectF = this.A;
        int i2 = this.e;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.z);
    }

    private void a(boolean z2, View view, int i2) {
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        if (z2) {
            gradientDrawable.setStroke(this.d, i2);
        } else {
            gradientDrawable.setColor(i2);
        }
        gradientDrawable.setCornerRadius((float) this.e);
    }

    @TargetApi(21)
    private View a(boolean z2, int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.color_page_indicator_dot_layout, this, false);
        View findViewById = inflate.findViewById(R.id.color_page_indicator_dot);
        if (Build.VERSION.SDK_INT > 16) {
            findViewById.setBackground(getContext().getResources().getDrawable(z2 ? R.drawable.color_page_indicator_dot_stroke : R.drawable.color_page_indicator_dot));
        } else {
            findViewById.setBackgroundDrawable(getContext().getResources().getDrawable(z2 ? R.drawable.color_page_indicator_dot_stroke : R.drawable.color_page_indicator_dot));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        int i3 = this.f1583a;
        layoutParams.height = i3;
        layoutParams.width = i3;
        findViewById.setLayoutParams(layoutParams);
        int i4 = this.f1584b;
        layoutParams.setMargins(i4, 0, i4, 0);
        a(z2, findViewById, i2);
        return inflate;
    }

    private void d(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            LinearLayout linearLayout = this.x;
            linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
            List<View> list = this.y;
            list.remove(list.size() - 1);
        }
    }

    private void e(int i2) {
        for (final int i3 = 0; i3 < i2; i3++) {
            View a2 = a(this.h, this.c);
            if (this.g) {
                a2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (ColorPageIndicator.this.E != null && ColorPageIndicator.this.k != i3) {
                            boolean unused = ColorPageIndicator.this.v = true;
                            boolean unused2 = ColorPageIndicator.this.r = false;
                            ColorPageIndicator.this.a();
                            ColorPageIndicator.this.E.onClick(i3);
                        }
                    }
                });
            }
            this.y.add(a2.findViewById(R.id.color_page_indicator_dot));
            this.x.addView(a2);
        }
    }

    private void c() {
        int i2 = this.i;
        if (i2 >= 1) {
            this.D = this.l * i2;
            requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.B != null) {
            a();
            this.B.start();
        }
    }

    public void a() {
        if (!this.t) {
            this.t = true;
        }
        ValueAnimator valueAnimator = this.B;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.B.cancel();
        }
    }

    private void e() {
        this.u = true;
    }

    private void f() {
        this.u = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(this.D, this.f1583a);
    }

    public void setDotsCount(int i2) {
        d(this.i);
        this.i = i2;
        c();
        e(i2);
    }

    public void setCurrentPosition(int i2) {
        this.j = i2;
        this.k = i2;
        c(i2);
    }

    public void setTraceDotColor(int i2) {
        this.f = i2;
        this.z.setColor(i2);
    }

    public void setPageIndicatorDotsColor(int i2) {
        this.c = i2;
        List<View> list = this.y;
        if (list != null && !list.isEmpty()) {
            for (View a2 : this.y) {
                a(this.h, a2, i2);
            }
        }
    }

    public void setOnDotClickListener(a aVar) {
        this.E = aVar;
    }

    public void a(int i2, float f2, int i3) {
        boolean b2 = b();
        boolean z2 = true;
        if (!b2 ? this.j > i2 : this.j <= i2) {
            z2 = false;
        }
        if (z2) {
            if (b2) {
                int i4 = this.f1584b;
                int i5 = this.l;
                this.A.right = ((float) this.D) - (((float) (i4 + (i2 * i5))) + (((float) i5) * f2));
            } else {
                int i6 = this.f1584b + this.f1583a;
                int i7 = this.l;
                this.A.right = ((float) (i6 + (i2 * i7))) + (((float) i7) * f2);
            }
            if (this.u) {
                if (!this.s && this.r) {
                    RectF rectF = this.A;
                    rectF.left = rectF.right - ((float) this.f1583a);
                } else if (this.A.right - this.A.left < ((float) this.f1583a)) {
                    RectF rectF2 = this.A;
                    rectF2.left = rectF2.right - ((float) this.f1583a);
                }
            } else if (this.r) {
                RectF rectF3 = this.A;
                rectF3.left = rectF3.right - ((float) this.f1583a);
            } else if (this.A.right - this.A.left < ((float) this.f1583a)) {
                RectF rectF4 = this.A;
                rectF4.left = rectF4.right - ((float) this.f1583a);
            }
        } else {
            if (b2) {
                this.A.left = ((((float) this.D) - (((float) this.l) * (((float) i2) + f2))) - ((float) this.f1584b)) - ((float) this.f1583a);
            } else {
                this.A.left = ((float) this.f1584b) + (((float) this.l) * (((float) i2) + f2));
            }
            if (this.u) {
                if (!this.s && this.r) {
                    RectF rectF5 = this.A;
                    rectF5.right = rectF5.left + ((float) this.f1583a);
                } else if (this.A.right - this.A.left < ((float) this.f1583a)) {
                    RectF rectF6 = this.A;
                    rectF6.right = rectF6.left + ((float) this.f1583a);
                }
            } else if (this.r) {
                RectF rectF7 = this.A;
                rectF7.right = rectF7.left + ((float) this.f1583a);
            } else if (this.A.right - this.A.left < ((float) this.f1583a)) {
                RectF rectF8 = this.A;
                rectF8.right = rectF8.left + ((float) this.f1583a);
            }
        }
        this.m = this.A.left;
        this.n = this.A.right;
        if (f2 == 0.0f) {
            this.j = i2;
        }
        invalidate();
    }

    private void f(int i2) {
        if (b()) {
            this.p = (float) (this.D - (this.f1584b + (i2 * this.l)));
            this.o = this.p - ((float) this.f1583a);
            return;
        }
        int i3 = this.f1584b;
        int i4 = this.f1583a;
        this.p = (float) (i3 + i4 + (i2 * this.l));
        this.o = this.p - ((float) i4);
    }

    public void a(int i2) {
        boolean z2 = true;
        this.w = true;
        if (this.k != i2 && this.r) {
            this.r = false;
        }
        if (!b() ? this.k <= i2 : this.k > i2) {
            z2 = false;
        }
        this.q = z2;
        f(i2);
        if (this.k != i2) {
            if (this.C.hasMessages(17)) {
                this.C.removeMessages(17);
            }
            a();
            this.C.sendEmptyMessageDelayed(17, 100);
        } else if (this.C.hasMessages(17)) {
            this.C.removeMessages(17);
        }
        this.k = i2;
    }

    public void b(int i2) {
        if (i2 == 1) {
            e();
            if (this.r) {
                this.r = false;
            }
        } else if (i2 == 2) {
            f();
        } else if (i2 == 0 && (this.u || !this.w)) {
            if (this.C.hasMessages(17)) {
                this.C.removeMessages(17);
            }
            a();
            this.C.sendEmptyMessageDelayed(17, 100);
        }
        this.w = false;
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT <= 16 || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }
}
