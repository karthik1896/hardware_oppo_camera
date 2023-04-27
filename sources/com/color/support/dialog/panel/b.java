package com.color.support.dialog.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.b.a;
import color.support.v7.appcompat.R;
import com.a.a.f;
import com.a.a.g;
import com.a.a.h;
import com.color.support.d.d;
import com.color.support.d.i;
import com.color.support.d.j;
import com.color.support.dialog.panel.ColorBottomSheetBehavior;
import com.color.support.widget.ColorMaxHeightDraggableVerticalLinearLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.lang.ref.WeakReference;

/* compiled from: ColorBottomSheetDialog */
public class b extends BottomSheetDialog {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f1908a = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f1909b = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
    private InputMethodManager A;
    private AnimatorSet B;
    private Interpolator C;
    /* access modifiers changed from: private */
    public float D = 0.0f;
    /* access modifiers changed from: private */
    public float E = 0.0f;
    /* access modifiers changed from: private */
    public boolean F = false;
    /* access modifiers changed from: private */
    public boolean G = false;
    /* access modifiers changed from: private */
    public int H = 0;
    private View.OnApplyWindowInsetsListener I = null;
    /* access modifiers changed from: private */
    public i J;
    /* access modifiers changed from: private */
    public boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    /* access modifiers changed from: private */
    public int M;
    private ViewTreeObserver.OnPreDrawListener N = new ViewTreeObserver.OnPreDrawListener() {
        public boolean onPreDraw() {
            b.this.m();
            if (!b.this.l() && Build.VERSION.SDK_INT >= 30) {
                b bVar = b.this;
                bVar.a(bVar.getWindow());
            }
            b.this.a(true, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    if (b.this.w != null && b.this.w.getState() == 5) {
                        ((ColorBottomSheetBehavior) b.this.w).b(3);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (b.this.s != null) {
                        b.this.s.setTranslationY(b.this.D);
                    }
                }
            });
            return false;
        }
    };
    private ComponentCallbacks O = new ComponentCallbacks() {
        public void onLowMemory() {
        }

        public void onConfigurationChanged(Configuration configuration) {
            boolean a2 = j.a(configuration);
            if (b.this.z != a2) {
                boolean unused = b.this.z = a2;
                boolean unused2 = b.this.G = true;
                b.this.i();
                if (b.this.J != null) {
                    b.this.J.a(b.this.g);
                }
                b bVar = b.this;
                bVar.f(bVar.z);
                b bVar2 = b.this;
                int unused3 = bVar2.d = j.b(bVar2.getContext(), configuration);
                if (b.this.y && b.this.x != null) {
                    ViewGroup.LayoutParams layoutParams = b.this.x.getLayoutParams();
                    layoutParams.height = b.this.d;
                    b.this.x.setLayoutParams(layoutParams);
                }
            }
        }
    };
    private e P = new e() {
        public int a(int i, int i2) {
            if (b.this.p == null || b.this.p.e() == 0.0d) {
                int x = b.this.c - b.this.o.getHeight();
                if (x <= 0) {
                    return b.this.m;
                }
                int a2 = a.a((int) (((float) b.this.o.getPaddingBottom()) - (((float) i) * 0.19999999f)), 0, Math.min(b.this.l, x));
                if (b.this.m != a2) {
                    int unused = b.this.m = a2;
                    b.this.o.setPadding(0, 0, 0, b.this.m);
                }
                return b.this.m;
            }
            b.this.p.j();
            return b.this.m;
        }

        public void a(int i) {
            int top = b.this.s.getTop() - (i - b.this.m);
            b bVar = b.this;
            bVar.c(bVar.m - top);
        }

        public void a() {
            if (b.this.o != null) {
                b.this.o.setPadding(0, 0, 0, 0);
            }
        }
    };
    /* access modifiers changed from: private */
    public int c = 0;
    /* access modifiers changed from: private */
    public int d = 0;
    private View e;
    /* access modifiers changed from: private */
    public View f;
    /* access modifiers changed from: private */
    public ColorMaxHeightDraggableVerticalLinearLayout g;
    private WeakReference<Activity> h;
    private boolean i = false;
    private View.OnTouchListener j;
    private boolean k = true;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public View o;
    /* access modifiers changed from: private */
    public f p;
    /* access modifiers changed from: private */
    public f q;
    /* access modifiers changed from: private */
    public View r;
    /* access modifiers changed from: private */
    public ViewGroup s;
    private int t = 0;
    private boolean u = true;
    private boolean v = false;
    /* access modifiers changed from: private */
    public BottomSheetBehavior w;
    /* access modifiers changed from: private */
    public View x;
    /* access modifiers changed from: private */
    public boolean y;
    /* access modifiers changed from: private */
    public boolean z;

    public b(Context context, int i2) {
        super(context, i2);
        if (context instanceof Activity) {
            this.h = new WeakReference<>((Activity) context);
        }
        if (getWindow() != null) {
            getWindow().setNavigationBarColor(context.getResources().getColor(R.color.color_panel_navigation_bar_color));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.w = getBehavior();
        BottomSheetBehavior bottomSheetBehavior = this.w;
        if (bottomSheetBehavior instanceof ColorBottomSheetBehavior) {
            ((ColorBottomSheetBehavior) bottomSheetBehavior).a(this.t);
            ((ColorBottomSheetBehavior) this.w).a(this.u);
            if (this.v) {
                ((ColorBottomSheetBehavior) this.w).b(4);
            } else {
                ((ColorBottomSheetBehavior) this.w).b(3);
            }
        }
        this.A = (InputMethodManager) getContext().getSystemService("input_method");
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            if (this.i) {
                window.findViewById(R.id.design_bottom_sheet).setBackground((Drawable) null);
            } else {
                window.findViewById(R.id.design_bottom_sheet).setBackground(getContext().getDrawable(R.drawable.color_panel_bg_without_shadow));
            }
            window.setLayout(-1, -1);
            window.setGravity(80);
        }
        boolean z2 = true;
        if (getContext().getResources().getConfiguration().orientation != 1) {
            z2 = false;
        }
        this.z = z2;
        this.x = findViewById(R.id.design_bottom_sheet);
        View view = this.x;
        if (view != null && !this.z) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -2;
            this.x.setLayoutParams(layoutParams);
        }
        if (this.y) {
            h();
        }
        this.f = findViewById(R.id.touch_outside);
        View view2 = this.f;
        if (view2 != null) {
            view2.setBackgroundColor(Color.argb(153, 0, 0, 0));
            View.OnTouchListener onTouchListener = this.j;
            if (onTouchListener != null) {
                this.f.setOnTouchListener(onTouchListener);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.J = new i();
        if (!l() && Build.VERSION.SDK_INT < 30) {
            a(getWindow());
        }
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode((window.getAttributes().softInputMode & 15) | 16);
            j();
        }
        View view = this.f;
        if (view != null) {
            view.getViewTreeObserver().addOnPreDrawListener(this.N);
        }
        i iVar = this.J;
        if (iVar != null) {
            iVar.a(true);
        }
        getContext().registerComponentCallbacks(this.O);
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null || weakReference.get() == null) {
            this.c = j.a(getContext(), (Configuration) null);
        } else {
            this.c = j.a((Activity) this.h.get(), (Configuration) null);
        }
        this.l = (int) getContext().getResources().getDimension(R.dimen.color_panel_pull_up_max_offset);
        if (this.k) {
            BottomSheetBehavior bottomSheetBehavior = this.w;
            if (bottomSheetBehavior instanceof ColorBottomSheetBehavior) {
                ((ColorBottomSheetBehavior) bottomSheetBehavior).a(this.P);
            }
        }
    }

    public void onDetachedFromWindow() {
        i iVar = this.J;
        if (iVar != null) {
            iVar.a();
            this.J = null;
        }
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
            this.I = null;
        }
        a((Animator) this.B);
        if (this.O != null) {
            getContext().unregisterComponentCallbacks(this.O);
        }
        BottomSheetBehavior bottomSheetBehavior = this.w;
        if (bottomSheetBehavior instanceof ColorBottomSheetBehavior) {
            ((ColorBottomSheetBehavior) bottomSheetBehavior).a((e) null);
            this.P = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public void a(Window window) {
        if (window != null) {
            View decorView = window.getDecorView();
            this.I = new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    int c = (!com.color.support.d.f.b(b.this.getContext()) || !j.d(b.this.getContext())) ? 0 : com.color.support.d.f.c(b.this.getContext());
                    int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                    if (b.this.l()) {
                        c = 0;
                    }
                    int i = systemWindowInsetBottom - c;
                    if (i > 0) {
                        int unused = b.this.H = i;
                        if (b.this.J != null) {
                            b.this.J.a(b.this.g, true, b.this.H);
                        }
                    } else if (b.this.H != 0) {
                        if (b.this.J != null) {
                            b.this.J.a(b.this.g, false, b.this.H);
                        }
                        int unused2 = b.this.H = 0;
                    }
                    view.onApplyWindowInsets(windowInsets);
                    return windowInsets;
                }
            };
            decorView.setOnApplyWindowInsetsListener(this.I);
        }
    }

    public View a() {
        return this.e;
    }

    public void setContentView(View view) {
        if (!this.i) {
            this.g = c();
            this.e = view;
            this.g.addView(this.e);
            super.setContentView((View) this.g);
            this.s = (ViewGroup) this.g.getParent();
        } else if (view != null) {
            this.e = view;
            super.setContentView(view);
            this.s = (ViewGroup) view.getParent();
        }
        this.o = this.s;
    }

    private ColorMaxHeightDraggableVerticalLinearLayout c() {
        FrameLayout.LayoutParams layoutParams;
        ColorMaxHeightDraggableVerticalLinearLayout colorMaxHeightDraggableVerticalLinearLayout = new ColorMaxHeightDraggableVerticalLinearLayout(getContext());
        if (j.d(getContext())) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) getContext().getResources().getDimension(R.dimen.color_panel_landscape_width), -2);
            layoutParams2.gravity = 1;
            layoutParams = layoutParams2;
        }
        colorMaxHeightDraggableVerticalLinearLayout.setLayoutParams(layoutParams);
        return colorMaxHeightDraggableVerticalLinearLayout;
    }

    public void dismiss() {
        g();
        b(true);
    }

    public void a(boolean z2) {
        this.L = z2;
    }

    public void a(int i2) {
        this.M = i2;
    }

    public void b(boolean z2) {
        if (!isShowing() || !z2 || this.K) {
            d();
        } else if (this.w.getState() == 5) {
            f();
        } else {
            e();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        super.dismiss();
    }

    private void e() {
        i();
        a(false, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = b.this.K = false;
                if (b.this.L) {
                    b bVar = b.this;
                    ValueAnimator b2 = bVar.b(bVar.M);
                    if (b2 != null) {
                        b2.addListener(new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                b.this.d();
                            }
                        });
                        b2.start();
                        return;
                    }
                    b.this.d();
                    return;
                }
                b.this.d();
            }
        });
    }

    private void f() {
        i();
        ValueAnimator b2 = this.L ? b(this.M) : null;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200);
        if (this.C == null) {
            this.C = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);
        }
        animatorSet.setInterpolator(this.C);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                boolean unused = b.this.K = true;
                super.onAnimationStart(animator);
            }

            public void onAnimationCancel(Animator animator) {
                boolean unused = b.this.K = false;
                super.onAnimationCancel(animator);
            }

            public void onAnimationEnd(Animator animator) {
                boolean unused = b.this.K = false;
                b.this.d();
            }
        });
        if (b2 == null) {
            animatorSet.playTogether(new Animator[]{d(false)});
        } else {
            animatorSet.playTogether(new Animator[]{d(false), b2});
        }
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, Animator.AnimatorListener animatorListener) {
        int i2;
        int i3;
        AnimatorSet animatorSet = this.B;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.F = true;
            this.B.end();
        }
        this.d = j.b(getContext(), (Configuration) null);
        if (this.y) {
            i2 = this.d;
        } else {
            i2 = Math.min(this.e.getMeasuredHeight(), this.d);
        }
        if (this.s != null && i2 > 0) {
            if (!z2) {
                i2 = (int) this.D;
            } else if (this.v) {
                i2 = this.t;
            }
            if (z2) {
                i3 = 0;
            } else {
                i3 = (!this.v || this.w.getState() != 4) ? this.s.getHeight() : this.t;
            }
            this.B = new AnimatorSet();
            if (z2) {
                this.B.setDuration((long) (Math.abs((((float) (i2 - i3)) * 120.0f) / ((float) this.d)) + 300.0f));
                this.B.setInterpolator(f1908a);
            } else {
                i3 -= this.H;
                this.B.setDuration((long) (Math.abs((((float) (i2 - i3)) * 50.0f) / ((float) this.d)) + 200.0f));
                this.B.setInterpolator(f1909b);
            }
            if (animatorListener != null) {
                this.B.addListener(animatorListener);
            }
            this.B.playTogether(new Animator[]{a(i2, i3), d(z2)});
            this.B.start();
            this.K = !z2;
        }
    }

    private ValueAnimator a(int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) i2, (float) i3});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (b.this.s != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    b.this.s.setTranslationY(floatValue);
                    if (!b.this.F) {
                        float unused = b.this.D = floatValue;
                    }
                    boolean unused2 = b.this.F = false;
                }
            }
        });
        return ofFloat;
    }

    private ValueAnimator d(boolean z2) {
        if (this.f == null) {
            this.f = findViewById(R.id.touch_outside);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.E, z2 ? 0.6f : 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (b.this.f != null) {
                    float unused = b.this.E = floatValue;
                    b.this.f.setAlpha(b.this.E);
                }
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public ValueAnimator b(int i2) {
        if (com.color.support.d.f.b(getContext()) && getWindow() != null) {
            final Window window = getWindow();
            int navigationBarColor = window.getNavigationBarColor();
            if (Color.alpha(i2) == 0) {
                i2 = Color.argb(1, Color.red(i2), Color.green(i2), Color.blue(i2));
            }
            if (navigationBarColor != i2) {
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(navigationBarColor), Integer.valueOf(i2)});
                ofObject.setDuration(200);
                ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        window.setNavigationBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                return ofObject;
            }
        }
        return null;
    }

    public void b() {
        AnimatorSet animatorSet;
        if (this.s != null && (animatorSet = this.B) != null && !animatorSet.isRunning()) {
            a((View) this.s);
        }
    }

    private void a(View view) {
        if (view != null) {
            if (this.q == null || this.r != view) {
                this.r = view;
                this.q = com.a.a.j.c().b();
                this.q.a(g.b(3.8d, 20.0d));
                this.q.a((h) new h() {
                    public void b(f fVar) {
                    }

                    public void c(f fVar) {
                    }

                    public void d(f fVar) {
                    }

                    public void a(f fVar) {
                        if (b.this.q != null && b.this.r != null) {
                            int c = (int) fVar.c();
                            if (c >= 100) {
                                b.this.q.b(0.0d);
                            }
                            b.this.r.setTranslationY((float) c);
                        }
                    }
                });
            }
            this.q.b(100.0d);
        }
    }

    private void g() {
        f fVar = this.q;
        if (fVar != null && fVar.e() != 0.0d) {
            this.q.j();
            this.q = null;
        }
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.j = onTouchListener;
        View findViewById = findViewById(R.id.touch_outside);
        if (findViewById != null) {
            findViewById.setOnTouchListener(this.j);
        }
    }

    public void c(boolean z2) {
        if (this.k != z2) {
            this.k = z2;
            BottomSheetBehavior bottomSheetBehavior = this.w;
            if (bottomSheetBehavior instanceof ColorBottomSheetBehavior) {
                ((ColorBottomSheetBehavior) bottomSheetBehavior).a(this.k ? this.P : null);
            }
        }
    }

    private void h() {
        ColorMaxHeightDraggableVerticalLinearLayout colorMaxHeightDraggableVerticalLinearLayout = this.g;
        if (colorMaxHeightDraggableVerticalLinearLayout != null) {
            colorMaxHeightDraggableVerticalLinearLayout.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.w;
        if (bottomSheetBehavior instanceof ColorBottomSheetBehavior) {
            ((ColorBottomSheetBehavior) bottomSheetBehavior).a((ColorBottomSheetBehavior.a) new ColorBottomSheetBehavior.a() {
                public void a(View view, float f) {
                }

                public void a(View view, int i) {
                    if (i == 5) {
                        b.this.dismiss();
                    }
                    if (i == 2 && ((ColorBottomSheetBehavior) b.this.w).a()) {
                        b.this.i();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        InputMethodManager inputMethodManager = this.A;
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            this.A.hideSoftInputFromWindow(this.x.getWindowToken(), 0);
        }
    }

    private void j() {
        int i2;
        Window window = getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 21) {
                int systemUiVisibility = decorView.getSystemUiVisibility() | 1024;
                e(l() && !k());
                window.setStatusBarColor(0);
                window.addFlags(Integer.MIN_VALUE);
                if (d.a(getContext())) {
                    i2 = systemUiVisibility & -8193 & -17;
                } else {
                    i2 = Build.VERSION.SDK_INT >= 23 ? systemUiVisibility | 256 : systemUiVisibility | 16;
                }
                decorView.setSystemUiVisibility(i2);
            }
        }
    }

    private boolean k() {
        WeakReference<Activity> weakReference = this.h;
        return (weakReference == null || weakReference.get() == null || !j.c((Activity) this.h.get())) ? false : true;
    }

    /* access modifiers changed from: private */
    public boolean l() {
        WeakReference<Activity> weakReference = this.h;
        return (weakReference == null || weakReference.get() == null || !j.b((Activity) this.h.get())) ? false : true;
    }

    private void e(boolean z2) {
        CoordinatorLayout coordinatorLayout;
        ViewGroup viewGroup = this.s;
        if (viewGroup != null && (coordinatorLayout = (CoordinatorLayout) viewGroup.getParent()) != null) {
            coordinatorLayout.setFitsSystemWindows(z2);
            FrameLayout frameLayout = (FrameLayout) coordinatorLayout.getParent();
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(z2);
            }
        }
    }

    private void a(Animator animator) {
        if (animator != null && animator.isRunning()) {
            animator.end();
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        View view = this.f;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.N);
        }
    }

    /* access modifiers changed from: private */
    public void f(boolean z2) {
        int i2;
        ColorMaxHeightDraggableVerticalLinearLayout colorMaxHeightDraggableVerticalLinearLayout = this.g;
        if (colorMaxHeightDraggableVerticalLinearLayout != null && this.s != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) colorMaxHeightDraggableVerticalLinearLayout.getLayoutParams();
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) this.s.getLayoutParams();
            if (layoutParams != null && eVar != null) {
                if (z2) {
                    i2 = -1;
                } else {
                    i2 = (int) getContext().getResources().getDimension(R.dimen.color_panel_landscape_width);
                }
                eVar.width = i2;
                layoutParams.width = i2;
                this.s.setLayoutParams(eVar);
                this.g.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        this.p = com.a.a.j.c().b();
        this.p.a(g.b(6.0d, 42.0d));
        this.n = 0;
        this.p.a((h) new h() {
            public void c(f fVar) {
            }

            public void d(f fVar) {
            }

            public void a(f fVar) {
                if (b.this.p != null && b.this.s != null) {
                    if (!fVar.h() || fVar.e() != 0.0d) {
                        int c = (int) fVar.c();
                        b.this.s.offsetTopAndBottom(c - b.this.n);
                        int unused = b.this.n = c;
                        return;
                    }
                    b.this.p.j();
                }
            }

            public void b(f fVar) {
                if ((b.this.w instanceof ColorBottomSheetBehavior) && b.this.o != null) {
                    int unused = b.this.m = 0;
                    b.this.o.setPadding(0, 0, 0, 0);
                    ((ColorBottomSheetBehavior) b.this.w).setStateInternal(3);
                }
            }
        });
        this.p.b((double) i2);
    }
}
