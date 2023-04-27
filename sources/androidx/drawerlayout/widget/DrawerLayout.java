package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.g.v;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f779a = {16842931};

    /* renamed from: b  reason: collision with root package name */
    static final boolean f780b = (Build.VERSION.SDK_INT >= 19);
    private static final int[] c = {16843828};
    private static final boolean d;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private Object E;
    private boolean F;
    private Drawable G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private final ArrayList<View> K;
    private Rect L;
    private Matrix M;
    private final a e;
    private float f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final androidx.customview.a.c k;
    private final androidx.customview.a.c l;
    private final d m;
    private final d n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private b x;
    private List<b> y;
    private float z;

    public interface b {
        void a(int i);

        void a(View view);

        void a(View view, float f);

        void b(View view);
    }

    static {
        boolean z2 = true;
        if (Build.VERSION.SDK_INT < 21) {
            z2 = false;
        }
        d = z2;
    }

    public void setDrawerElevation(float f2) {
        this.f = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (g(childAt)) {
                v.a(childAt, this.f);
            }
        }
    }

    public float getDrawerElevation() {
        if (d) {
            return this.f;
        }
        return 0.0f;
    }

    public void setScrimColor(int i2) {
        this.h = i2;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(b bVar) {
        b bVar2 = this.x;
        if (bVar2 != null) {
            b(bVar2);
        }
        if (bVar != null) {
            a(bVar);
        }
        this.x = bVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (this.y == null) {
                this.y = new ArrayList();
            }
            this.y.add(bVar);
        }
    }

    public void b(b bVar) {
        List<b> list;
        if (bVar != null && (list = this.y) != null) {
            list.remove(bVar);
        }
    }

    public void setDrawerLockMode(int i2) {
        a(i2, 3);
        a(i2, 5);
    }

    public void a(int i2, int i3) {
        View b2;
        int a2 = androidx.core.g.c.a(i3, v.g(this));
        if (i3 == 3) {
            this.r = i2;
        } else if (i3 == 5) {
            this.s = i2;
        } else if (i3 == 8388611) {
            this.t = i2;
        } else if (i3 == 8388613) {
            this.u = i2;
        }
        if (i2 != 0) {
            (a2 == 3 ? this.k : this.l).e();
        }
        if (i2 == 1) {
            View b3 = b(a2);
            if (b3 != null) {
                i(b3);
            }
        } else if (i2 == 2 && (b2 = b(a2)) != null) {
            h(b2);
        }
    }

    public int a(int i2) {
        int i3;
        int i4;
        int i5;
        int g2 = v.g(this);
        if (i2 == 3) {
            int i6 = this.r;
            if (i6 != 3) {
                return i6;
            }
            int i7 = g2 == 0 ? this.t : this.u;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i2 == 5) {
            int i8 = this.s;
            if (i8 != 3) {
                return i8;
            }
            if (g2 == 0) {
                i3 = this.u;
            } else {
                i3 = this.t;
            }
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i9 = this.t;
            if (i9 != 3) {
                return i9;
            }
            if (g2 == 0) {
                i4 = this.r;
            } else {
                i4 = this.s;
            }
            if (i4 != 3) {
                return i4;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i10 = this.u;
            if (i10 != 3) {
                return i10;
            }
            if (g2 == 0) {
                i5 = this.s;
            } else {
                i5 = this.r;
            }
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
    }

    public int a(View view) {
        if (g(view)) {
            return a(((c) view.getLayoutParams()).f781a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    private boolean a(float f2, float f3, View view) {
        if (this.L == null) {
            this.L = new Rect();
        }
        view.getHitRect(this.L);
        return this.L.contains((int) f2, (int) f3);
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent b2 = b(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(b2);
            b2.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent b(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.M == null) {
                this.M = new Matrix();
            }
            matrix.invert(this.M);
            obtain.transform(this.M);
        }
        return obtain;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, View view) {
        int a2 = this.k.a();
        int a3 = this.l.a();
        int i4 = 2;
        if (a2 == 1 || a3 == 1) {
            i4 = 1;
        } else if (!(a2 == 2 || a3 == 2)) {
            i4 = 0;
        }
        if (view != null && i3 == 0) {
            c cVar = (c) view.getLayoutParams();
            if (cVar.f782b == 0.0f) {
                b(view);
            } else if (cVar.f782b == 1.0f) {
                c(view);
            }
        }
        if (i4 != this.o) {
            this.o = i4;
            List<b> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).a(i4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        View rootView;
        c cVar = (c) view.getLayoutParams();
        if ((cVar.d & 1) == 1) {
            cVar.d = 0;
            List<b> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).b(view);
                }
            }
            c(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        c cVar = (c) view.getLayoutParams();
        if ((cVar.d & 1) == 0) {
            cVar.d = 1;
            List<b> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).a(view);
                }
            }
            c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    private void c(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z2 || g(childAt)) && (!z2 || childAt != view)) {
                v.b(childAt, 4);
            } else {
                v.b(childAt, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, float f2) {
        List<b> list = this.y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.y.get(size).a(view, f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view, float f2) {
        c cVar = (c) view.getLayoutParams();
        if (f2 != cVar.f782b) {
            cVar.f782b = f2;
            a(view, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public float d(View view) {
        return ((c) view.getLayoutParams()).f782b;
    }

    /* access modifiers changed from: package-private */
    public int e(View view) {
        return androidx.core.g.c.a(((c) view.getLayoutParams()).f781a, v.g(this));
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i2) {
        return (e(view) & i2) == i2;
    }

    /* access modifiers changed from: package-private */
    public View a() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((c) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void c(View view, float f2) {
        float d2 = d(view);
        float width = (float) view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (d2 * width));
        if (!a(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        b(view, f2);
    }

    /* access modifiers changed from: package-private */
    public View b(int i2) {
        int a2 = androidx.core.g.c.a(i2, v.g(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((e(childAt) & 7) == a2) {
                return childAt;
            }
        }
        return null;
    }

    static String c(int i2) {
        if ((i2 & 3) == 3) {
            return "LEFT";
        }
        return (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i4 = 0;
        boolean z2 = this.E != null && v.t(this);
        int g2 = v.g(this);
        int childCount = getChildCount();
        int i5 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (z2) {
                    int a2 = androidx.core.g.c.a(cVar.f781a, g2);
                    if (v.t(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.E;
                            if (a2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i4, windowInsets.getSystemWindowInsetBottom());
                            } else if (a2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i4, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.E;
                        if (a2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i4, windowInsets2.getSystemWindowInsetBottom());
                        } else if (a2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i4, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        cVar.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        cVar.topMargin = windowInsets2.getSystemWindowInsetTop();
                        cVar.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        cVar.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (f(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - cVar.leftMargin) - cVar.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - cVar.topMargin) - cVar.bottomMargin, 1073741824));
                } else if (g(childAt)) {
                    if (d) {
                        float o2 = v.o(childAt);
                        float f2 = this.f;
                        if (o2 != f2) {
                            v.a(childAt, f2);
                        }
                    }
                    int e2 = e(childAt) & 7;
                    int i6 = e2 == 3 ? 1 : i4;
                    if ((i6 == 0 || !z3) && (i6 != 0 || !z4)) {
                        if (i6 != 0) {
                            z3 = true;
                        } else {
                            z4 = true;
                        }
                        childAt.measure(getChildMeasureSpec(i2, this.g + cVar.leftMargin + cVar.rightMargin, cVar.width), getChildMeasureSpec(i3, cVar.topMargin + cVar.bottomMargin, cVar.height));
                        i5++;
                        i4 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + c(e2) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i7 = i2;
            int i8 = i3;
            i5++;
            i4 = 0;
        }
    }

    private void d() {
        if (!d) {
            this.C = e();
            this.D = f();
        }
    }

    private Drawable e() {
        int g2 = v.g(this);
        if (g2 == 0) {
            Drawable drawable = this.G;
            if (drawable != null) {
                a(drawable, g2);
                return this.G;
            }
        } else {
            Drawable drawable2 = this.H;
            if (drawable2 != null) {
                a(drawable2, g2);
                return this.H;
            }
        }
        return this.I;
    }

    private Drawable f() {
        int g2 = v.g(this);
        if (g2 == 0) {
            Drawable drawable = this.H;
            if (drawable != null) {
                a(drawable, g2);
                return this.H;
            }
        } else {
            Drawable drawable2 = this.G;
            if (drawable2 != null) {
                a(drawable2, g2);
                return this.G;
            }
        }
        return this.J;
    }

    private boolean a(Drawable drawable, int i2) {
        if (drawable == null || !androidx.core.graphics.drawable.a.b(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable, i2);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        boolean z3 = true;
        this.p = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(cVar.leftMargin, cVar.topMargin, cVar.leftMargin + childAt.getMeasuredWidth(), cVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (cVar.f782b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i9 = i7 - ((int) (cVar.f782b * f4));
                        f2 = ((float) (i7 - i9)) / f4;
                        i6 = i9;
                    }
                    boolean z4 = f2 != cVar.f782b ? z3 : false;
                    int i10 = cVar.f781a & 112;
                    if (i10 == 16) {
                        int i11 = i5 - i3;
                        int i12 = (i11 - measuredHeight) / 2;
                        if (i12 < cVar.topMargin) {
                            i12 = cVar.topMargin;
                        } else if (i12 + measuredHeight > i11 - cVar.bottomMargin) {
                            i12 = (i11 - cVar.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        childAt.layout(i6, cVar.topMargin, measuredWidth + i6, cVar.topMargin + measuredHeight);
                    } else {
                        int i13 = i5 - i3;
                        childAt.layout(i6, (i13 - cVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i13 - cVar.bottomMargin);
                    }
                    if (z4) {
                        b(childAt, f2);
                    }
                    int i14 = cVar.f782b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i14) {
                        childAt.setVisibility(i14);
                    }
                }
            }
            i8++;
            z3 = true;
        }
        this.p = false;
        this.q = false;
    }

    public void requestLayout() {
        if (!this.p) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((c) getChildAt(i2).getLayoutParams()).f782b);
        }
        this.i = f2;
        boolean a2 = this.k.a(true);
        boolean a3 = this.l.a(true);
        if (a2 || a3) {
            v.e(this);
        }
    }

    private static boolean m(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    public void setStatusBarBackground(int i2) {
        this.B = i2 != 0 ? androidx.core.content.a.a(getContext(), i2) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.B = new ColorDrawable(i2);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i2) {
        d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r4.E;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            boolean r0 = r4.F
            if (r0 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r4.B
            if (r0 == 0) goto L_0x002e
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x001d
            java.lang.Object r0 = r4.E
            if (r0 == 0) goto L_0x001d
            android.view.WindowInsets r0 = (android.view.WindowInsets) r0
            int r0 = r0.getSystemWindowInsetTop()
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r1 = r4.B
            int r3 = r4.getWidth()
            r1.setBounds(r2, r2, r3, r0)
            android.graphics.drawable.Drawable r0 = r4.B
            r0.draw(r5)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        int i2;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean f2 = f(view2);
        int width = getWidth();
        int save = canvas.save();
        int i3 = 0;
        if (f2) {
            int childCount = getChildCount();
            i2 = width;
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != view2 && childAt.getVisibility() == 0 && m(childAt) && g(childAt) && childAt.getHeight() >= height) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i4) {
                            i4 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < i2) {
                            i2 = left;
                        }
                    }
                }
            }
            canvas.clipRect(i4, 0, i2, getHeight());
            i3 = i4;
        } else {
            i2 = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f3 = this.i;
        if (f3 > 0.0f && f2) {
            int i6 = this.h;
            this.j.setColor((i6 & 16777215) | (((int) (((float) ((-16777216 & i6) >>> 24)) * f3)) << 24));
            canvas.drawRect((float) i3, 0.0f, (float) i2, (float) getHeight(), this.j);
        } else if (this.C != null && a(view2, 3)) {
            int intrinsicWidth = this.C.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.k.b()), 1.0f));
            this.C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.C.setAlpha((int) (max * 255.0f));
            this.C.draw(canvas);
        } else if (this.D != null && a(view2, 5)) {
            int intrinsicWidth2 = this.D.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.l.b()), 1.0f));
            this.D.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.D.setAlpha((int) (max2 * 255.0f));
            this.D.draw(canvas);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public boolean f(View view) {
        return ((c) view.getLayoutParams()).f781a == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean g(View view) {
        int a2 = androidx.core.g.c.a(((c) view.getLayoutParams()).f781a, v.g(view));
        return ((a2 & 3) == 0 && (a2 & 5) == 0) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        r7 = r6.k.d((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.a.c r1 = r6.k
            boolean r1 = r1.a((android.view.MotionEvent) r7)
            androidx.customview.a.c r2 = r6.l
            boolean r2 = r2.a((android.view.MotionEvent) r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x003a
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0038
        L_0x001e:
            androidx.customview.a.c r7 = r6.k
            boolean r7 = r7.d(r4)
            if (r7 == 0) goto L_0x0038
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.m
            r7.a()
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.n
            r7.a()
            goto L_0x0038
        L_0x0031:
            r6.a((boolean) r2)
            r6.v = r3
            r6.w = r3
        L_0x0038:
            r7 = r3
            goto L_0x0064
        L_0x003a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.z = r0
            r6.A = r7
            float r4 = r6.i
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005f
            androidx.customview.a.c r4 = r6.k
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.d(r0, r7)
            if (r7 == 0) goto L_0x005f
            boolean r7 = r6.f(r7)
            if (r7 == 0) goto L_0x005f
            r7 = r2
            goto L_0x0060
        L_0x005f:
            r7 = r3
        L_0x0060:
            r6.v = r3
            r6.w = r3
        L_0x0064:
            if (r1 != 0) goto L_0x0074
            if (r7 != 0) goto L_0x0074
            boolean r7 = r6.g()
            if (r7 != 0) goto L_0x0074
            boolean r7 = r6.w
            if (r7 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r2 = r3
        L_0x0074:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (a(x2, y2, childAt) && !f(childAt) && a(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        View a2;
        this.k.b(motionEvent);
        this.l.b(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.z = x2;
            this.A = y2;
            this.v = false;
            this.w = false;
        } else if (action == 1) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            View d2 = this.k.d((int) x3, (int) y3);
            if (d2 != null && f(d2)) {
                float f2 = x3 - this.z;
                float f3 = y3 - this.A;
                int d3 = this.k.d();
                if (!((f2 * f2) + (f3 * f3) >= ((float) (d3 * d3)) || (a2 = a()) == null || a(a2) == 2)) {
                    z2 = false;
                    a(z2);
                    this.v = false;
                }
            }
            z2 = true;
            a(z2);
            this.v = false;
        } else if (action == 3) {
            a(true);
            this.v = false;
            this.w = false;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        this.v = z2;
        if (z2) {
            a(true);
        }
    }

    public void b() {
        a(false);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        boolean z3;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c cVar = (c) childAt.getLayoutParams();
            if (g(childAt) && (!z2 || cVar.c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    z3 = this.k.a(childAt, -width, childAt.getTop());
                } else {
                    z3 = this.l.a(childAt, getWidth(), childAt.getTop());
                }
                z4 |= z3;
                cVar.c = false;
            }
        }
        this.m.a();
        this.n.a();
        if (z4) {
            invalidate();
        }
    }

    public void h(View view) {
        a(view, true);
    }

    public void a(View view, boolean z2) {
        if (g(view)) {
            c cVar = (c) view.getLayoutParams();
            if (this.q) {
                cVar.f782b = 1.0f;
                cVar.d = 1;
                c(view, true);
            } else if (z2) {
                cVar.d |= 2;
                if (a(view, 3)) {
                    this.k.a(view, 0, view.getTop());
                } else {
                    this.l.a(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                c(view, 1.0f);
                a(cVar.f781a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void i(View view) {
        b(view, true);
    }

    public void b(View view, boolean z2) {
        if (g(view)) {
            c cVar = (c) view.getLayoutParams();
            if (this.q) {
                cVar.f782b = 0.0f;
                cVar.d = 0;
            } else if (z2) {
                cVar.d |= 4;
                if (a(view, 3)) {
                    this.k.a(view, -view.getWidth(), view.getTop());
                } else {
                    this.l.a(view, getWidth(), view.getTop());
                }
            } else {
                c(view, 0.0f);
                a(cVar.f781a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean j(View view) {
        if (g(view)) {
            return (((c) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean k(View view) {
        if (g(view)) {
            return ((c) view.getLayoutParams()).f782b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    private boolean g() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((c) getChildAt(i2).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof c) {
            return new c((c) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!g(childAt)) {
                    this.K.add(childAt);
                } else if (j(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z2 = true;
                }
            }
            if (!z2) {
                int size = this.K.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = this.K.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.K.clear();
        }
    }

    private boolean h() {
        return c() != null;
    }

    /* access modifiers changed from: package-private */
    public View c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (g(childAt) && k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !h()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View c2 = c();
        if (c2 != null && a(c2) == 0) {
            b();
        }
        return c2 != null;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View b2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.openDrawerGravity == 0 || (b2 = b(savedState.openDrawerGravity)) == null)) {
            h(b2);
        }
        if (savedState.lockModeLeft != 3) {
            a(savedState.lockModeLeft, 3);
        }
        if (savedState.lockModeRight != 3) {
            a(savedState.lockModeRight, 5);
        }
        if (savedState.lockModeStart != 3) {
            a(savedState.lockModeStart, 8388611);
        }
        if (savedState.lockModeEnd != 3) {
            a(savedState.lockModeEnd, 8388613);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            c cVar = (c) getChildAt(i2).getLayoutParams();
            boolean z2 = true;
            boolean z3 = cVar.d == 1;
            if (cVar.d != 2) {
                z2 = false;
            }
            if (z3 || z2) {
                savedState.openDrawerGravity = cVar.f781a;
            } else {
                i2++;
            }
        }
        savedState.lockModeLeft = this.r;
        savedState.lockModeRight = this.s;
        savedState.lockModeStart = this.t;
        savedState.lockModeEnd = this.u;
        return savedState;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (a() != null || g(view)) {
            v.b(view, 4);
        } else {
            v.b(view, 1);
        }
        if (!f780b) {
            v.a(view, (androidx.core.g.a) this.e);
        }
    }

    static boolean l(View view) {
        return (v.f(view) == 4 || v.f(view) == 2) ? false : true;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity = 0;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }
    }

    private class d extends c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerLayout f783a;

        /* renamed from: b  reason: collision with root package name */
        private final int f784b;
        private androidx.customview.a.c c;
        private final Runnable d;

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void a() {
            this.f783a.removeCallbacks(this.d);
        }

        public boolean tryCaptureView(View view, int i) {
            return this.f783a.g(view) && this.f783a.a(view, this.f784b) && this.f783a.a(view) == 0;
        }

        public void onViewDragStateChanged(int i) {
            this.f783a.a(this.f784b, i, this.c.c());
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (this.f783a.a(view, 3)) {
                f = (float) (i + width);
            } else {
                f = (float) (this.f783a.getWidth() - i);
            }
            float f2 = f / ((float) width);
            this.f783a.b(view, f2);
            view.setVisibility(f2 == 0.0f ? 4 : 0);
            this.f783a.invalidate();
        }

        public void onViewCaptured(View view, int i) {
            ((c) view.getLayoutParams()).c = false;
            b();
        }

        private void b() {
            int i = 3;
            if (this.f784b == 3) {
                i = 5;
            }
            View b2 = this.f783a.b(i);
            if (b2 != null) {
                this.f783a.i(b2);
            }
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            float d2 = this.f783a.d(view);
            int width = view.getWidth();
            if (this.f783a.a(view, 3)) {
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                i = (i2 > 0 || (i2 == 0 && d2 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = this.f783a.getWidth();
                if (f < 0.0f || (f == 0.0f && d2 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.c.a(i, view.getTop());
            this.f783a.invalidate();
        }

        public void onEdgeTouched(int i, int i2) {
            this.f783a.postDelayed(this.d, 160);
        }

        public void onEdgeDragStarted(int i, int i2) {
            View view;
            if ((i & 1) == 1) {
                view = this.f783a.b(3);
            } else {
                view = this.f783a.b(5);
            }
            if (view != null && this.f783a.a(view) == 0) {
                this.c.a(view, i2);
            }
        }

        public int getViewHorizontalDragRange(View view) {
            if (this.f783a.g(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (this.f783a.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.f783a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f781a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f782b;
        boolean c;
        int d;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f779a);
            this.f781a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(c cVar) {
            super(cVar);
            this.f781a = cVar.f781a;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    static final class a extends androidx.core.g.a {
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.g.a.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (!DrawerLayout.l(view)) {
                dVar.b((View) null);
            }
        }
    }
}
