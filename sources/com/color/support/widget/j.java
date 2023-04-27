package com.color.support.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import color.support.v7.appcompat.R;
import com.color.support.d.b;
import com.color.support.d.d;
import com.coloros.anim.EffectiveAnimationView;

/* compiled from: ColorToolTips */
public class j extends PopupWindow {
    private int A;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2208a;

    /* renamed from: b  reason: collision with root package name */
    private View f2209b;
    private Rect c;
    private Rect d;
    /* access modifiers changed from: private */
    public ViewGroup e;
    private ViewGroup f;
    private TextView g;
    private ScrollView h;
    /* access modifiers changed from: private */
    public EffectiveAnimationView i;
    /* access modifiers changed from: private */
    public View j;
    private Drawable k;
    private Drawable l;
    private Drawable m;
    private Drawable n;
    private int o;
    private final int[] p;
    private int[] q;
    private final Point r;
    private float s;
    private float t;
    private Interpolator u;
    /* access modifiers changed from: private */
    public boolean v;
    private View.OnLayoutChangeListener w;
    private PopupWindow.OnDismissListener x;
    private Rect y;
    private Rect z;

    public j(Context context) {
        this(context, 0);
    }

    public j(Context context, int i2) {
        this.c = new Rect();
        this.o = 4;
        this.p = new int[2];
        this.q = new int[2];
        this.r = new Point();
        this.w = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                Rect rect = new Rect(i, i2, i3, i4);
                Rect rect2 = new Rect(i5, i6, i7, i8);
                if (j.this.isShowing() && !rect.equals(rect2) && j.this.j != null) {
                    j.this.g();
                }
            }
        };
        this.x = new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                j.this.e.removeAllViews();
            }
        };
        this.f2208a = context;
        a(i2);
    }

    public void a(int i2) {
        int i3;
        int i4;
        int i5 = i2;
        if (i5 == 0) {
            i4 = R.attr.colorToolTipsStyle;
            i3 = R.style.ColorToolTips;
        } else {
            i4 = R.attr.colorToolTipsDetailFloatingStyle;
            i3 = R.style.ColorToolTips_DetailFloating;
        }
        TypedArray obtainStyledAttributes = this.f2208a.obtainStyledAttributes((AttributeSet) null, R.styleable.ColorToolTips, i4, i3);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ColorToolTips_colorToolTipsBackground);
        this.k = obtainStyledAttributes.getDrawable(R.styleable.ColorToolTips_colorToolTipsArrowUpDrawable);
        this.l = obtainStyledAttributes.getDrawable(R.styleable.ColorToolTips_colorToolTipsArrowDownDrawable);
        this.m = obtainStyledAttributes.getDrawable(R.styleable.ColorToolTips_colorToolTipsArrowLeftDrawable);
        this.n = obtainStyledAttributes.getDrawable(R.styleable.ColorToolTips_colorToolTipsArrowRightDrawable);
        this.A = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsArrowOverflowOffset, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsMinWidth, 0);
        int i6 = obtainStyledAttributes.getInt(R.styleable.ColorToolTips_colorToolTipsContainerLayoutGravity, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsContainerLayoutMarginStart, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsContainerLayoutMarginTop, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsContainerLayoutMarginEnd, 0);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsContainerLayoutMarginBottom, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.ColorToolTips_colorToolTipsContentTextColor);
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsViewportOffsetStart, 0);
        int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsViewportOffsetTop, 0);
        int dimensionPixelSize8 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsViewportOffsetEnd, 0);
        int dimensionPixelSize9 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorToolTips_colorToolTipsViewportOffsetBottom, 0);
        obtainStyledAttributes.recycle();
        int i7 = dimensionPixelSize9;
        int i8 = dimensionPixelSize6;
        this.u = new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f);
        this.f = (ViewGroup) LayoutInflater.from(this.f2208a).inflate(R.layout.color_tool_tips_layout, (ViewGroup) null);
        this.f.setBackground(drawable);
        this.f.setMinimumWidth(dimensionPixelSize);
        this.e = a(this.f2208a);
        d.a(this.e, false);
        this.g = (TextView) this.f.findViewById(R.id.contentTv);
        this.h = (ScrollView) this.f.findViewById(R.id.scrollView);
        this.i = (EffectiveAnimationView) this.f.findViewById(R.id.tips_icon);
        if (i5 == 1) {
            this.i.setVisibility(8);
        } else {
            this.i.setAnimation("color_tool_tips_icon.json");
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.gravity = i6;
        layoutParams.setMargins(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize5);
        layoutParams.setMarginStart(dimensionPixelSize2);
        layoutParams.setMarginEnd(dimensionPixelSize4);
        this.h.setLayoutParams(layoutParams);
        this.g.setTextSize(0, (float) ((int) b.a((float) this.f2208a.getResources().getDimensionPixelSize(R.dimen.tool_tips_content_text_size), this.f2208a.getResources().getConfiguration().fontScale, 4)));
        this.g.setTextColor(colorStateList);
        if (!b((View) this.f)) {
            this.d = new Rect(i8, dimensionPixelSize7, dimensionPixelSize8, i7);
        } else {
            this.d = new Rect(dimensionPixelSize8, dimensionPixelSize7, i8, i7);
        }
        setClippingEnabled(false);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setOnDismissListener(this.x);
    }

    private static ViewGroup a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return frameLayout;
    }

    public void a(View view) {
        a(view, true);
    }

    public void a(View view, boolean z2) {
        a(view, 4, z2);
    }

    public void a(View view, int i2) {
        a(view, i2, true);
    }

    public void a(View view, int i2, boolean z2) {
        if (!isShowing()) {
            this.o = i2;
            this.f2209b = view.getRootView();
            int i3 = this.o;
            if (i3 == 32 || i3 == 64) {
                int i4 = 16;
                if (b(view)) {
                    if (this.o == 32) {
                        i4 = 8;
                    }
                    this.o = i4;
                } else {
                    if (this.o != 32) {
                        i4 = 8;
                    }
                    this.o = i4;
                }
            }
            this.j = view;
            this.f2209b.getWindowVisibleDisplayFrame(this.c);
            h();
            this.y = new Rect();
            view.getGlobalVisibleRect(this.y);
            this.z = new Rect();
            this.f2209b.getGlobalVisibleRect(this.z);
            int[] iArr = new int[2];
            this.f2209b.getLocationOnScreen(iArr);
            this.y.offset(iArr[0], iArr[1]);
            this.z.offset(iArr[0], iArr[1]);
            Rect rect = this.c;
            rect.left = Math.max(rect.left, this.z.left);
            Rect rect2 = this.c;
            rect2.top = Math.max(rect2.top, this.z.top);
            Rect rect3 = this.c;
            rect3.right = Math.min(rect3.right, this.z.right);
            Rect rect4 = this.c;
            rect4.bottom = Math.min(rect4.bottom, this.z.bottom);
            a();
            b(this.y);
            a(this.y, z2);
            setContentView(this.e);
            d();
            e();
            showAtLocation(this.f2209b, 0, this.r.x, this.r.y);
        }
    }

    private void a(Rect rect, boolean z2) {
        this.e.removeAllViews();
        this.e.addView(this.f);
        if (z2) {
            a(rect);
        }
    }

    private void a() {
        int dimensionPixelSize = this.f2208a.getResources().getDimensionPixelSize(R.dimen.tool_tips_max_width) + this.f.getPaddingLeft() + this.f.getPaddingRight();
        int i2 = this.o;
        if (i2 == 8) {
            dimensionPixelSize = Math.min(this.c.right - this.y.right, dimensionPixelSize);
        } else if (i2 == 16) {
            dimensionPixelSize = Math.min(this.y.left - this.c.left, dimensionPixelSize);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        this.g.setMaxWidth((((dimensionPixelSize - this.f.getPaddingLeft()) - this.f.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
        this.f.measure(0, 0);
        setWidth(Math.min(this.f.getMeasuredWidth(), dimensionPixelSize));
        setHeight(this.f.getMeasuredHeight());
        if ((this.y.centerY() - (((c() + this.f.getPaddingTop()) - this.f.getPaddingBottom()) / 2)) + c() >= this.c.bottom) {
            this.o = 4;
            int dimensionPixelSize2 = this.f2208a.getResources().getDimensionPixelSize(R.dimen.tool_tips_max_width) + this.f.getPaddingLeft() + this.f.getPaddingRight();
            this.g.setMaxWidth((((dimensionPixelSize2 - this.f.getPaddingLeft()) - this.f.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
            this.f.measure(0, 0);
            setWidth(Math.min(this.f.getMeasuredWidth(), dimensionPixelSize2));
            setHeight(this.f.getMeasuredHeight());
        }
    }

    private void a(Rect rect) {
        ImageView imageView = new ImageView(this.f2208a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i2 = this.o;
        if (i2 == 4) {
            this.f2209b.getRootView().getLocationOnScreen(this.p);
            int i3 = this.p[0];
            this.f2209b.getRootView().getLocationInWindow(this.p);
            layoutParams.leftMargin = ((rect.centerX() - this.r.x) - (i3 - this.p[0])) - (this.k.getIntrinsicWidth() / 2);
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.k.getIntrinsicWidth();
            if (this.r.y >= rect.top - this.q[1]) {
                imageView.setBackground(this.k);
                layoutParams.topMargin = (this.f.getPaddingTop() - this.k.getIntrinsicHeight()) + this.A;
            } else {
                imageView.setBackground(this.l);
                layoutParams.gravity = 80;
                layoutParams.bottomMargin = (this.f.getPaddingBottom() - this.l.getIntrinsicHeight()) + this.A;
            }
        } else if (i2 == 16) {
            layoutParams.rightMargin = (this.f.getPaddingRight() - this.n.getIntrinsicWidth()) + this.A;
            layoutParams.leftMargin = (getWidth() - layoutParams.rightMargin) - this.n.getIntrinsicWidth();
            layoutParams.topMargin = ((rect.centerY() - this.r.y) - this.q[1]) - (this.n.getIntrinsicHeight() / 2);
            layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.n.getIntrinsicHeight();
            imageView.setBackground(this.n);
        } else {
            layoutParams.leftMargin = (this.f.getPaddingLeft() - this.m.getIntrinsicWidth()) + this.A;
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.m.getIntrinsicWidth();
            layoutParams.topMargin = ((rect.centerY() - this.r.y) - this.q[1]) - (this.n.getIntrinsicHeight() / 2);
            layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.n.getIntrinsicHeight();
            imageView.setBackground(this.m);
        }
        this.e.addView(imageView, layoutParams);
    }

    private void b(Rect rect) {
        int i2;
        int i3;
        int i4 = this.o;
        if (i4 == 4) {
            i3 = Math.min(rect.centerX() - (b() / 2), this.c.right - b());
            int i5 = rect.top - this.c.top;
            int i6 = this.c.bottom - rect.bottom;
            int c2 = c();
            if (i5 >= c2) {
                i2 = rect.top - c2;
            } else if (i6 >= c2) {
                i2 = rect.bottom;
            } else if (i5 > i6) {
                i2 = this.c.top;
                setHeight(i5);
            } else {
                i2 = rect.bottom;
                setHeight(i6);
            }
        } else {
            i3 = i4 == 16 ? rect.left - b() : rect.right;
            i2 = rect.centerY() - (((c() + this.f.getPaddingTop()) - this.f.getPaddingBottom()) / 2);
        }
        this.f2209b.getRootView().getLocationOnScreen(this.p);
        int[] iArr = this.p;
        int i7 = iArr[0];
        int i8 = iArr[1];
        this.f2209b.getRootView().getLocationInWindow(this.p);
        int[] iArr2 = this.p;
        int i9 = iArr2[0];
        int i10 = iArr2[1];
        int[] iArr3 = this.q;
        iArr3[0] = i7 - i9;
        iArr3[1] = i8 - i10;
        this.r.set(Math.max(0, (i3 - iArr3[0]) - this.d.left), Math.max(0, (i2 - this.q[1]) - this.d.top));
    }

    private int b() {
        return (getWidth() - this.d.left) + this.d.right;
    }

    private int c() {
        return (getHeight() - this.d.top) + this.d.bottom;
    }

    public void a(CharSequence charSequence) {
        this.g.setText(charSequence);
    }

    private void d() {
        int i2 = this.o;
        float f2 = 0.0f;
        if (i2 == 4) {
            if ((this.y.centerX() - this.q[0]) - this.r.x >= b()) {
                this.s = 1.0f;
            } else if (b() != 0) {
                int centerX = (this.y.centerX() - this.q[0]) - this.r.x;
                if (centerX <= 0) {
                    centerX = -centerX;
                }
                this.s = ((float) centerX) / ((float) b());
            } else {
                this.s = 0.5f;
            }
            if (this.r.y >= this.y.top - this.q[1]) {
                this.t = 0.0f;
            } else {
                this.t = 1.0f;
            }
        } else {
            if (i2 == 16) {
                f2 = 1.0f;
            }
            this.s = f2;
            this.t = ((float) ((this.y.centerY() - this.r.y) - this.q[1])) / ((float) c());
        }
    }

    private void e() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, this.s, 1, this.t);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(this.u);
        animationSet.setDuration(200);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                j.this.i.a();
            }
        });
        this.e.startAnimation(animationSet);
    }

    private void f() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setInterpolator(this.u);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                boolean unused = j.this.v = true;
            }

            public void onAnimationEnd(Animation animation) {
                j.this.g();
                boolean unused = j.this.v = false;
                j.this.i.setProgress(0.0f);
            }
        });
        this.e.startAnimation(alphaAnimation);
    }

    public void dismiss() {
        if (!this.v) {
            f();
            return;
        }
        g();
        this.v = false;
        this.i.setProgress(0.0f);
    }

    /* access modifiers changed from: private */
    public void g() {
        super.dismiss();
        i();
        this.e.removeAllViews();
    }

    public void a(boolean z2) {
        if (z2) {
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
        } else {
            setFocusable(false);
            setOutsideTouchable(false);
        }
        update();
    }

    private void h() {
        i();
        this.f2209b.addOnLayoutChangeListener(this.w);
    }

    private void i() {
        this.f2209b.removeOnLayoutChangeListener(this.w);
    }

    public boolean b(View view) {
        return view.getLayoutDirection() == 1;
    }
}
