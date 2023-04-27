package com.color.support.widget.popupwindow;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import color.support.v7.appcompat.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ColorPopupListWindow */
public class a extends PopupWindow implements View.OnLayoutChangeListener {
    private boolean A;
    private boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    private Animation.AnimationListener D = new Animation.AnimationListener() {
        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            boolean unused = a.this.C = true;
        }

        public void onAnimationEnd(Animation animation) {
            a.this.i();
            boolean unused = a.this.C = false;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Context f2254a;

    /* renamed from: b  reason: collision with root package name */
    private BaseAdapter f2255b;
    private BaseAdapter c;
    private BaseAdapter d;
    private View e;
    private Rect f;
    private Rect g;
    private Rect h;
    private Rect i;
    private List<c> j;
    private ViewGroup k;
    private ListView l;
    private ListView m;
    private AdapterView.OnItemClickListener n;
    private Point o = new Point();
    private int[] p = new int[2];
    private int[] q = new int[2];
    private int[] r = new int[4];
    private float s;
    private float t;
    private int u;
    private int v;
    private Interpolator w;
    private Interpolator x;
    private int y;
    private boolean z;

    public a(Context context) {
        super(context);
        this.f2254a = context;
        this.j = new ArrayList();
        this.u = context.getResources().getInteger(R.integer.oppo_animation_time_move_veryfast);
        this.v = context.getResources().getInteger(R.integer.oppo_animation_time_move_veryfast);
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(context, R.interpolator.oppo_curve_opacity_inout);
        this.x = loadInterpolator;
        this.w = loadInterpolator;
        this.y = context.getResources().getDimensionPixelSize(R.dimen.color_popup_list_window_min_width);
        this.m = new ListView(context);
        this.m.setDivider((Drawable) null);
        this.m.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.k = a(context);
        setBackgroundDrawable(new ColorDrawable(0));
        setClippingEnabled(false);
        if (Build.VERSION.SDK_INT > 23) {
            setExitTransition((Transition) null);
            setEnterTransition((Transition) null);
        }
    }

    private ViewGroup a(Context context) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.color_popup_list_window_layout, (ViewGroup) null);
        this.l = (ListView) frameLayout.findViewById(R.id.color_popup_list_view);
        Drawable drawable = context.getResources().getDrawable(R.drawable.color_popup_list_window_bg);
        this.i = new Rect();
        drawable.getPadding(this.i);
        frameLayout.setBackground(drawable);
        return frameLayout;
    }

    public void a(View view) {
        if (view == null) {
            return;
        }
        if (!(this.f2255b == null && this.c == null) && !isShowing()) {
            this.e = view;
            this.e.getRootView().removeOnLayoutChangeListener(this);
            this.e.getRootView().addOnLayoutChangeListener(this);
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter == null) {
                this.d = this.f2255b;
            } else {
                this.d = baseAdapter;
            }
            this.l.setAdapter(this.d);
            AdapterView.OnItemClickListener onItemClickListener = this.n;
            if (onItemClickListener != null) {
                this.l.setOnItemClickListener(onItemClickListener);
            }
            this.f = new Rect();
            this.g = new Rect();
            this.h = new Rect();
            this.e.getWindowVisibleDisplayFrame(this.f);
            this.e.getGlobalVisibleRect(this.g);
            this.e.getRootView().getGlobalVisibleRect(this.h);
            this.g.left -= this.r[0];
            this.g.top -= this.r[1];
            this.g.right += this.r[2];
            this.g.bottom += this.r[3];
            this.e.getRootView().getLocationOnScreen(this.p);
            Rect rect = this.g;
            int[] iArr = this.p;
            rect.offset(iArr[0], iArr[1]);
            Rect rect2 = this.h;
            int[] iArr2 = this.p;
            rect2.offset(iArr2[0], iArr2[1]);
            Rect rect3 = this.f;
            rect3.left = Math.max(rect3.left, this.h.left);
            Rect rect4 = this.f;
            rect4.top = Math.max(rect4.top, this.h.top);
            Rect rect5 = this.f;
            rect5.right = Math.min(rect5.right, this.h.right);
            Rect rect6 = this.f;
            rect6.bottom = Math.min(rect6.bottom, this.h.bottom);
            c();
            a();
            e();
            if (this.z && this.A) {
                setContentView(this.k);
                f();
                g();
                showAtLocation(this.e, 0, this.o.x, this.o.y);
            }
        }
    }

    private void c() {
        this.e.getRootView().getLocationOnScreen(this.p);
        int[] iArr = this.p;
        int i2 = iArr[0];
        int i3 = iArr[1];
        this.e.getRootView().getLocationInWindow(this.p);
        int[] iArr2 = this.p;
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        int[] iArr3 = this.q;
        iArr3[0] = i2 - i4;
        iArr3[1] = i3 - i5;
    }

    public void a() {
        BaseAdapter baseAdapter = this.d;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(d(), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = baseAdapter.getCount();
        int i2 = 0;
        int i3 = makeMeasureSpec2;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            View view = baseAdapter.getView(i5, (View) null, this.m);
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams.height != -2) {
                i3 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            view.measure(makeMeasureSpec, i3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (measuredWidth > i4) {
                i4 = measuredWidth;
            }
            i2 += measuredHeight;
        }
        setWidth(Math.max(i4, this.y) + this.i.left + this.i.right);
        setHeight(i2 + this.i.top + this.i.bottom);
    }

    private int d() {
        return ((this.f.right - this.f.left) - this.i.left) - this.i.right;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007a, code lost:
        if (r9.B != false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        if (r9.B != false) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r9 = this;
            r0 = 1
            r9.A = r0
            r9.z = r0
            android.graphics.Rect r1 = r9.f
            int r1 = r1.right
            android.graphics.Rect r2 = r9.f
            int r2 = r2.left
            int r1 = r1 - r2
            int r2 = r9.getWidth()
            r3 = 0
            if (r1 >= r2) goto L_0x0018
            r9.A = r3
            return
        L_0x0018:
            android.graphics.Rect r1 = r9.g
            int r1 = r1.centerX()
            int r2 = r9.getWidth()
            int r2 = r2 / 2
            int r1 = r1 - r2
            android.graphics.Rect r2 = r9.f
            int r2 = r2.right
            int r4 = r9.getWidth()
            int r2 = r2 - r4
            int r1 = java.lang.Math.min(r1, r2)
            android.graphics.Rect r2 = r9.f
            int r2 = r2.left
            int r1 = java.lang.Math.max(r2, r1)
            int[] r2 = r9.q
            r2 = r2[r3]
            int r1 = r1 - r2
            android.graphics.Rect r2 = r9.g
            int r2 = r2.top
            android.graphics.Rect r4 = r9.f
            int r4 = r4.top
            int r2 = r2 - r4
            android.graphics.Rect r4 = r9.f
            int r4 = r4.bottom
            android.graphics.Rect r5 = r9.g
            int r5 = r5.bottom
            int r4 = r4 - r5
            int r5 = r9.getHeight()
            if (r2 < r5) goto L_0x0059
            r6 = r0
            goto L_0x005a
        L_0x0059:
            r6 = r3
        L_0x005a:
            if (r4 < r5) goto L_0x005e
            r7 = r0
            goto L_0x005f
        L_0x005e:
            r7 = r3
        L_0x005f:
            android.graphics.Rect r8 = r9.g
            int r8 = r8.top
            int r8 = r8 - r5
            android.graphics.Rect r5 = r9.g
            int r5 = r5.bottom
            if (r4 > 0) goto L_0x006f
            if (r2 > 0) goto L_0x006f
            r9.z = r3
            return
        L_0x006f:
            boolean r3 = r9.B
            if (r3 == 0) goto L_0x0076
            if (r6 == 0) goto L_0x007e
            goto L_0x0078
        L_0x0076:
            if (r7 == 0) goto L_0x007e
        L_0x0078:
            boolean r2 = r9.B
            if (r2 == 0) goto L_0x009d
        L_0x007c:
            r5 = r8
            goto L_0x009d
        L_0x007e:
            boolean r3 = r9.B
            if (r3 == 0) goto L_0x0085
            if (r7 == 0) goto L_0x008c
            goto L_0x0087
        L_0x0085:
            if (r6 == 0) goto L_0x008c
        L_0x0087:
            boolean r2 = r9.B
            if (r2 == 0) goto L_0x007c
            goto L_0x009d
        L_0x008c:
            if (r2 <= r4) goto L_0x0096
            android.graphics.Rect r3 = r9.f
            int r5 = r3.top
            r9.setHeight(r2)
            goto L_0x009d
        L_0x0096:
            android.graphics.Rect r2 = r9.g
            int r5 = r2.bottom
            r9.setHeight(r4)
        L_0x009d:
            android.graphics.Point r2 = r9.o
            int[] r3 = r9.q
            r0 = r3[r0]
            int r5 = r5 - r0
            r2.set(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.popupwindow.a.e():void");
    }

    private void f() {
        if ((this.g.centerX() - this.q[0]) - this.o.x >= getWidth()) {
            this.s = 1.0f;
        } else {
            this.s = ((float) ((this.g.centerX() - this.q[0]) - this.o.x)) / ((float) getWidth());
        }
        if (this.o.y >= this.g.top - this.q[1]) {
            this.t = 0.0f;
        } else {
            this.t = 1.0f;
        }
    }

    private void g() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, this.s, 1, this.t);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        scaleAnimation.setDuration((long) this.u);
        scaleAnimation.setInterpolator(this.w);
        alphaAnimation.setDuration((long) this.v);
        alphaAnimation.setInterpolator(this.x);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.k.startAnimation(animationSet);
    }

    private void h() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) this.v);
        alphaAnimation.setInterpolator(this.x);
        alphaAnimation.setAnimationListener(this.D);
        this.k.startAnimation(alphaAnimation);
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Rect rect = new Rect(i2, i3, i4, i5);
        Rect rect2 = new Rect(i6, i7, i8, i9);
        if (isShowing() && !rect.equals(rect2)) {
            i();
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        super.dismiss();
        this.C = false;
        this.e.getRootView().removeOnLayoutChangeListener(this);
        setContentView((View) null);
    }

    public void dismiss() {
        if (!this.C) {
            h();
        }
    }

    public void a(List<c> list) {
        if (list != null) {
            this.j = list;
            this.f2255b = new b(this.f2254a, list);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.n = onItemClickListener;
    }

    public ListView b() {
        return this.l;
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
}
