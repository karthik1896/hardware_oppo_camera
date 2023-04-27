package com.oppo.camera.ui.menu.setting.down;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.menu.setting.down.b;

public class DrawerLayout extends ViewGroup implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f4198a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4199b = false;
    private b c;
    /* access modifiers changed from: private */
    public int d = 0;
    private int e = 0;
    private int f = 0;
    private float g = 0.0f;
    /* access modifiers changed from: private */
    public boolean h = false;
    private int i;
    private float j = 0.0f;
    private float k = 0.0f;
    private View l = null;
    private b m = null;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = true;
    /* access modifiers changed from: private */
    public a s = null;
    /* access modifiers changed from: private */
    public ValueAnimator t = null;
    private ValueAnimator u = null;

    public interface b {
        void a(float f);

        void a(boolean z);

        void c();

        void d();

        boolean h();

        boolean q();
    }

    public DrawerLayout(Context context) {
        super(context);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4198a = context;
        this.c = new b(context, attributeSet, this);
        com.oppo.camera.ui.inverse.c.INS.registerBackgroundInverse(context, this.c, true);
        this.c.setOnRollLayoutListener(this);
        setEnabled(false);
        setWillNotDraw(false);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        e.b("DrawerLayout", "visibility: " + i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.t.end();
        }
        e.b("DrawerLayout", "onMeasure, mbOpen: " + this.f4199b);
        int size = View.MeasureSpec.getSize(i2);
        this.l = getChildAt(0);
        measureChild(this.l, i2, i3);
        this.i = this.l.getMeasuredHeight();
        c cVar = (c) this.l.getLayoutParams();
        cVar.f4202a = 0;
        cVar.f4203b = 0;
        cVar.c = size;
        cVar.d = this.i;
        a(i2, i3);
        this.j = (float) (this.f4199b ? this.e : this.f);
        this.d = (int) this.j;
        setMeasuredDimension(size, this.i + this.e + 100);
    }

    public void a(int i2, int i3) {
        e.b("DrawerLayout", "replaceView");
        int size = View.MeasureSpec.getSize(i2);
        boolean z = true;
        View childAt = getChildAt(1);
        b bVar = this.c;
        if (childAt != bVar) {
            bVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            removeView(childAt);
            addView(this.c);
            this.c.addView(childAt, 0);
            childAt = this.c;
        }
        measureChild(this.c, i2, i3);
        if (this.c.getMeasuredHeight() != 0) {
            z = false;
        }
        this.p = z;
        this.e = this.c.getMaxScroll();
        this.f = this.c.getMinScroll();
        c cVar = (c) childAt.getLayoutParams();
        cVar.f4202a = 0;
        int i4 = this.i;
        cVar.f4203b = i4;
        cVar.c = size;
        cVar.d = i4 + this.e;
        this.c.setLayoutParams(cVar);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVar;
        b bVar2;
        b bVar3;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            c cVar = (c) childAt.getLayoutParams();
            if (this.c != childAt || ((bVar3 = this.m) != null && !bVar3.q())) {
                childAt.layout(cVar.f4202a, cVar.f4203b, cVar.c, cVar.d);
            }
            if (this.c != childAt || (!this.p && (bVar2 = this.m) != null && !bVar2.q())) {
                childAt.layout(cVar.f4202a, cVar.f4203b, cVar.c, cVar.d);
            }
            if (this.c == childAt && getVisibility() == 0 && ((bVar = this.m) == null || !bVar.q())) {
                e.b("DrawerLayout", "onLayout, setScroll: " + this.d);
                b((float) this.d, 0.0f, true);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e.b("DrawerLayout", "onInterceptTouchEvent, mbEnabled: " + this.q);
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        boolean z = false;
        if (!this.q) {
            setEnableTouch(false);
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = y;
            if (!this.f4199b && this.c.a(x, y - 280.0f)) {
                setEnableTouch(true);
            }
        } else if (action == 1) {
            setEnableTouch(false);
        } else if (action == 2) {
            float f2 = this.g;
            if (f2 <= ((float) this.i) || Math.abs(f2 - motionEvent.getY()) < ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop()) || motionEvent.getPointerId(motionEvent.getActionIndex()) != 0) {
                setEnableTouch(false);
            } else {
                this.g = y;
                setEnableTouch(true);
                z = true;
            }
        }
        e.b("DrawerLayout", "onInterceptTouchEvent, mScrolling: " + z);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        if (r1 != 3) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            float r0 = r6.getY()
            boolean r1 = r5.p
            java.lang.String r2 = "DrawerLayout"
            r3 = 1
            if (r1 != 0) goto L_0x00bd
            boolean r1 = r5.q
            if (r1 == 0) goto L_0x00bd
            boolean r1 = r5.f4199b
            if (r1 != 0) goto L_0x0017
            boolean r1 = r5.n
            if (r1 == 0) goto L_0x00bd
        L_0x0017:
            boolean r1 = r5.r
            if (r1 == 0) goto L_0x00bd
            com.oppo.camera.ui.menu.setting.down.DrawerLayout$b r1 = r5.m
            if (r1 == 0) goto L_0x0027
            boolean r1 = r1.h()
            if (r1 != 0) goto L_0x0027
            goto L_0x00bd
        L_0x0027:
            float r1 = r5.g
            int r4 = r5.i
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x008d
            boolean r1 = r5.h
            if (r1 == 0) goto L_0x0035
            goto L_0x008d
        L_0x0035:
            int r1 = r6.getAction()
            if (r1 == 0) goto L_0x0085
            if (r1 == r3) goto L_0x0081
            r2 = 2
            if (r1 == r2) goto L_0x0044
            r0 = 3
            if (r1 == r0) goto L_0x0081
            goto L_0x008c
        L_0x0044:
            float r6 = r5.k
            float r6 = r0 - r6
            r5.k = r0
            int r1 = r5.d
            float r1 = (float) r1
            float r1 = r1 + r0
            float r0 = r5.g
            float r1 = r1 - r0
            boolean r0 = r5.f4199b
            if (r0 != 0) goto L_0x0060
            r5.f4199b = r3
            com.oppo.camera.ui.menu.setting.down.DrawerLayout$b r0 = r5.m
            if (r0 == 0) goto L_0x0060
            boolean r2 = r5.f4199b
            r0.a((boolean) r2)
        L_0x0060:
            int r0 = r5.e
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0072
            int r0 = r5.f
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0072
            r5.b(r1, r6, r3)
            goto L_0x008c
        L_0x0072:
            int r0 = r5.e
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008c
            float r0 = r5.a((float) r1)
            r5.a(r0, r6, r3)
            goto L_0x008c
        L_0x0081:
            r5.a((android.view.MotionEvent) r6)
            goto L_0x008c
        L_0x0085:
            r5.setEnableTouch(r3)
            r5.g = r0
            r5.k = r0
        L_0x008c:
            return r3
        L_0x008d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "onTouchEvent, mDownY: "
            r6.append(r0)
            float r0 = r5.g
            r6.append(r0)
            java.lang.String r0 = ", mStartScroll: "
            r6.append(r0)
            int r0 = r5.i
            r6.append(r0)
            java.lang.String r0 = ", mbAnimationRun: "
            r6.append(r0)
            boolean r0 = r5.h
            r6.append(r0)
            java.lang.String r0 = ", return true"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.oppo.camera.e.b(r2, r6)
            return r3
        L_0x00bd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onTouchEvent, mbEnabled: "
            r0.append(r1)
            boolean r1 = r5.q
            r0.append(r1)
            java.lang.String r1 = ", mHeightNone: "
            r0.append(r1)
            boolean r1 = r5.p
            r0.append(r1)
            java.lang.String r1 = ", mbOpen: "
            r0.append(r1)
            boolean r1 = r5.f4199b
            r0.append(r1)
            java.lang.String r1 = ", mbTouch: "
            r0.append(r1)
            boolean r1 = r5.n
            r0.append(r1)
            java.lang.String r1 = ", mbRollVisibility: "
            r0.append(r1)
            boolean r1 = r5.r
            r0.append(r1)
            java.lang.String r1 = ", canResponseDrawerTouch: "
            r0.append(r1)
            com.oppo.camera.ui.menu.setting.down.DrawerLayout$b r1 = r5.m
            r4 = 0
            if (r1 == 0) goto L_0x0105
            boolean r1 = r1.h()
            if (r1 != 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r3 = r4
        L_0x0106:
            r0.append(r3)
            java.lang.String r1 = ", return false"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.b(r2, r0)
            boolean r0 = r5.f4199b
            if (r0 == 0) goto L_0x0120
            boolean r0 = r5.n
            if (r0 == 0) goto L_0x0120
            r5.a((android.view.MotionEvent) r6)
        L_0x0120:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.setting.down.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setEnabled(boolean z) {
        e.b("DrawerLayout", "setEnabled, mbEnabled: " + this.q + " > " + z);
        setEnableTouch(false);
        this.q = z;
        super.setEnabled(z);
    }

    private void a(MotionEvent motionEvent) {
        this.k = 0.0f;
        this.d = (int) this.j;
        setEnableTouch(false);
        if (this.c.c()) {
            this.f4199b = true;
            b(this.d, this.e);
        } else {
            float y = motionEvent.getY() - this.g;
            float eventTime = y / ((float) (motionEvent.getEventTime() - motionEvent.getDownTime()));
            if (((1.2f >= Math.abs(eventTime) || 0.0f >= eventTime) && this.d <= this.e / 2) || (0.0f > y && ((float) ViewConfiguration.get(this.f4198a).getScaledTouchSlop()) < Math.abs(y))) {
                this.f4199b = false;
                c(this.d, this.f);
            } else {
                this.f4199b = true;
                c(this.d, this.e);
            }
            this.c.b(1000);
        }
        this.g = 0.0f;
        b bVar = this.m;
        if (bVar != null) {
            bVar.a(this.f4199b);
            this.m.c();
        }
    }

    private float a(float f2) {
        int i2 = this.e;
        float f3 = ((f2 - ((float) i2)) / 2.5f) + ((float) i2);
        return f3 > ((float) (i2 + 100)) ? (float) (i2 + 100) : f3;
    }

    private void a(float f2, float f3, boolean z) {
        this.j = f2;
        this.c.a((int) f2, f3, true, z);
    }

    /* access modifiers changed from: private */
    public void b(float f2, float f3, boolean z) {
        this.j = f2;
        this.c.a((int) f2, f3, false, z);
        b bVar = this.m;
        if (bVar != null) {
            int i2 = this.e;
            if (i2 > 0) {
                bVar.a((((float) i2) - f2) / ((float) (i2 - this.f)));
            } else {
                bVar.a(1.0f);
            }
        }
    }

    private void b(int i2, int i3) {
        e.b("DrawerLayout", "startUpDampAnimator, start: " + i2 + ", end: " + i3);
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator == null) {
            this.u = ValueAnimator.ofInt(new int[]{i2, i3});
            this.u.setDuration(450);
            this.u.setInterpolator(AnimationUtils.loadInterpolator(this.f4198a, R.anim.drawer_damp_up_interpolator));
            this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DrawerLayout.this.a(valueAnimator);
                }
            });
        } else {
            valueAnimator.setIntValues(new int[]{i2, i3});
        }
        if (this.s == null) {
            this.s = new a();
        }
        this.u.addListener(this.s);
        this.c.d();
        this.u.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        if (this.f4199b) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.d = intValue;
            a((float) intValue, 0.0f, false);
            return;
        }
        this.u.cancel();
    }

    private void c(int i2, int i3) {
        e.b("DrawerLayout", "startAnimator, start: " + i2 + ", end: " + i3);
        this.t = ValueAnimator.ofInt(new int[]{i2, i3});
        this.t.setDuration(333);
        this.t.setInterpolator(AnimationUtils.loadInterpolator(this.f4198a, R.anim.gallery_in_interpolator));
        this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = DrawerLayout.this.d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                DrawerLayout drawerLayout = DrawerLayout.this;
                drawerLayout.b((float) drawerLayout.d, 0.0f, false);
            }
        });
        if (this.s == null) {
            this.s = new a();
        }
        this.t.addListener(this.s);
        this.t.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.t.cancel();
        }
    }

    public void setOpenAndClose(boolean z) {
        e.b("DrawerLayout", "setOpenAndClose, isShow: " + z + ", mbPause: " + this.o + ", mbTouch: " + this.n + ", mbOpen: " + this.f4199b);
        if (this.o || (!this.n && this.f4199b != z)) {
            this.f4199b = z;
            if (!this.o) {
                c(this.d, this.f4199b ? this.e : this.f);
                this.c.b(z ? -2000 : 2000);
            }
            b bVar = this.m;
            if (bVar != null) {
                bVar.a(this.f4199b);
            }
        }
    }

    public void b() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void c() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(int i2) {
        View view = this.l;
        if (view != null) {
            if (this.c.getVisibility() != 0) {
                i2 = 0;
            }
            view.setBackgroundColor(i2);
        }
    }

    public void d() {
        e.b("DrawerLayout", "onArrowClick");
        setEnableTouch(false);
        b bVar = this.m;
        if (bVar != null) {
            bVar.d();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f4202a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f4203b = 0;
        public int c = 0;
        public int d = 0;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class a extends AnimatorListenerAdapter {
        private a() {
        }

        public void onAnimationEnd(Animator animator) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.b((float) drawerLayout.d, 0.0f, false);
            boolean unused = DrawerLayout.this.h = false;
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = DrawerLayout.this.h = true;
        }

        public void onAnimationCancel(Animator animator) {
            if (DrawerLayout.this.t != null) {
                DrawerLayout.this.t.removeListener(DrawerLayout.this.s);
                ValueAnimator unused = DrawerLayout.this.t = null;
            }
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.b((float) drawerLayout.d, 0.0f, false);
            boolean unused2 = DrawerLayout.this.h = false;
        }
    }

    public void setOnDrawerListener(b bVar) {
        this.m = bVar;
    }

    public void setRollVisibility(int i2) {
        if (this.c != null) {
            this.r = i2 == 0;
            this.c.setVisibility(i2);
        }
    }

    public void setEnableTouch(boolean z) {
        e.b("DrawerLayout", "setEnableTouch, mbTouch: " + this.n + " > " + z);
        this.n = z;
    }

    public boolean getEnableTouch() {
        return this.n;
    }

    public boolean e() {
        return this.f4199b;
    }

    public void f() {
        this.f4199b = false;
        this.o = true;
        setEnableTouch(false);
    }

    public void g() {
        this.o = false;
    }

    public boolean h() {
        return this.p;
    }

    public boolean i() {
        return this.h;
    }

    public b getDrawerScrollLayout() {
        return this.c;
    }
}
