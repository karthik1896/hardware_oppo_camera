package color.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.g.v;
import color.support.v7.appcompat.R;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;

/* compiled from: ColorBasePopupWindow */
public class c extends PopupWindow {
    /* access modifiers changed from: private */
    public static final int[] R = {16842922};
    private int A;
    private int B;
    private int C;
    private float D;
    private int[] E;
    private int[] F;
    private Rect G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private int K;
    private int L;
    /* access modifiers changed from: private */
    public boolean M;
    private int N;
    private a O;
    private boolean P;
    private int Q;
    /* access modifiers changed from: private */
    public WeakReference<View> S;
    private final ViewTreeObserver.OnScrollChangedListener T;
    /* access modifiers changed from: private */
    public int U;
    /* access modifiers changed from: private */
    public int V;
    /* access modifiers changed from: private */
    public int W;
    private boolean X;
    private boolean Y;

    /* renamed from: a  reason: collision with root package name */
    private Context f1577a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager f1578b;
    private boolean c;
    private boolean d;
    /* access modifiers changed from: private */
    public View e;
    /* access modifiers changed from: private */
    public View f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    /* access modifiers changed from: private */
    public View.OnTouchListener u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* compiled from: ColorBasePopupWindow */
    public interface a {
        void a();
    }

    public c(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.h = 0;
        this.i = 1;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.p = true;
        this.q = false;
        this.s = true;
        this.t = false;
        this.E = new int[2];
        this.F = new int[2];
        this.G = new Rect();
        this.N = 1000;
        this.P = false;
        this.Q = -1;
        this.T = new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                View view = c.this.S != null ? (View) c.this.S.get() : null;
                if (view != null && c.this.f != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.f.getLayoutParams();
                    c cVar = c.this;
                    cVar.b(cVar.a(view, layoutParams, cVar.U, c.this.V, c.this.W));
                    c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        this.f1577a = context;
        this.f1578b = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PopupWindow, i2, i3);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.PopupWindowCompat, i2, i3);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground);
        this.D = obtainStyledAttributes2.getDimension(R.styleable.PopupWindowCompat_supportPopupElevation, 0.0f);
        this.X = obtainStyledAttributes.getBoolean(R.styleable.PopupWindow_overlapAnchor, false);
        int resourceId = obtainStyledAttributes2.getResourceId(R.styleable.PopupWindowCompat_android_popupAnimationStyle, -1);
        this.Q = resourceId == R.style.Animation_ColorSupport_PopupWindow ? -1 : resourceId;
        obtainStyledAttributes2.recycle();
        obtainStyledAttributes.recycle();
        setBackgroundDrawable(drawable);
    }

    public c() {
        this((View) null, 0, 0);
    }

    public c(View view, int i2, int i3) {
        this(view, i2, i3, false);
    }

    public c(View view, int i2, int i3, boolean z2) {
        this.h = 0;
        this.i = 1;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.p = true;
        this.q = false;
        this.s = true;
        this.t = false;
        this.E = new int[2];
        this.F = new int[2];
        this.G = new Rect();
        this.N = 1000;
        this.P = false;
        this.Q = -1;
        this.T = new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                View view = c.this.S != null ? (View) c.this.S.get() : null;
                if (view != null && c.this.f != null) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.f.getLayoutParams();
                    c cVar = c.this;
                    cVar.b(cVar.a(view, layoutParams, cVar.U, c.this.V, c.this.W));
                    c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
                }
            }
        };
        if (view != null) {
            this.f1577a = view.getContext();
            this.f1578b = (WindowManager) this.f1577a.getSystemService("window");
        }
        setContentView(view);
        setWidth(i2);
        setHeight(i3);
        setFocusable(z2);
    }

    public Drawable getBackground() {
        return this.H;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.H = drawable;
        if (this.H instanceof StateListDrawable) {
            this.J = null;
            this.I = null;
        }
    }

    public float getElevation() {
        return this.D;
    }

    public void setElevation(float f2) {
        this.D = f2;
    }

    public int getAnimationStyle() {
        return this.Q;
    }

    public void setIgnoreCheekPress() {
        this.P = true;
    }

    public void setAnimationStyle(int i2) {
        this.Q = i2;
    }

    public View getContentView() {
        return this.e;
    }

    public void setContentView(View view) {
        View view2;
        if (!isShowing()) {
            this.e = view;
            if (this.f1577a == null && (view2 = this.e) != null) {
                this.f1577a = view2.getContext();
            }
            if (this.f1578b == null && this.e != null) {
                this.f1578b = (WindowManager) this.f1577a.getSystemService("window");
            }
            Context context = this.f1577a;
            if (context != null && !this.t) {
                setAttachedInDecor(context.getApplicationInfo().targetSdkVersion >= 22);
            }
        }
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.u = onTouchListener;
    }

    public boolean isFocusable() {
        return this.g;
    }

    public void setFocusable(boolean z2) {
        this.g = z2;
    }

    public int getInputMethodMode() {
        return this.h;
    }

    public void setInputMethodMode(int i2) {
        this.h = i2;
    }

    public void setSoftInputMode(int i2) {
        this.i = i2;
    }

    public int getSoftInputMode() {
        return this.i;
    }

    public boolean isTouchable() {
        return this.j;
    }

    public void setTouchable(boolean z2) {
        this.j = z2;
    }

    public boolean isOutsideTouchable() {
        return this.k;
    }

    public void setOutsideTouchable(boolean z2) {
        this.k = z2;
    }

    public boolean isClippingEnabled() {
        return this.l;
    }

    public void setClippingEnabled(boolean z2) {
        this.l = z2;
    }

    public void a(boolean z2) {
        this.o = z2;
        setClippingEnabled(!z2);
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        if (this.m >= 0 || (context = this.f1577a) == null) {
            if (this.m == 1) {
                return true;
            }
            return false;
        } else if (context.getApplicationInfo().targetSdkVersion >= 11) {
            return true;
        } else {
            return false;
        }
    }

    public void setSplitTouchEnabled(boolean z2) {
        this.m = z2 ? 1 : 0;
    }

    public boolean isAttachedInDecor() {
        return this.s;
    }

    public void setAttachedInDecor(boolean z2) {
        this.s = z2;
        this.t = true;
    }

    public void setWindowLayoutType(int i2) {
        this.N = i2;
    }

    public int getWindowLayoutType() {
        return this.N;
    }

    public void setTouchModal(boolean z2) {
        this.r = !z2;
    }

    public void setWindowLayoutMode(int i2, int i3) {
        this.v = i2;
        this.y = i3;
    }

    public int getHeight() {
        return this.z;
    }

    public void setHeight(int i2) {
        this.z = i2;
    }

    public int getWidth() {
        return this.w;
    }

    public void setWidth(int i2) {
        this.w = i2;
    }

    public boolean isShowing() {
        return this.c;
    }

    public void showAtLocation(View view, int i2, int i3, int i4) {
        a(view.getWindowToken(), i2, i3, i4);
    }

    public void a(IBinder iBinder, int i2, int i3, int i4) {
        if (!isShowing() && this.e != null) {
            d();
            this.c = true;
            this.d = false;
            WindowManager.LayoutParams a2 = a(iBinder);
            a2.windowAnimations = c();
            b(a2);
            if (i2 == 0) {
                i2 = BadgeDrawable.TOP_START;
            }
            a2.gravity = i2;
            a2.x = i3;
            a2.y = i4;
            int i5 = this.y;
            if (i5 < 0) {
                this.A = i5;
                a2.height = i5;
            }
            int i6 = this.v;
            if (i6 < 0) {
                this.x = i6;
                a2.width = i6;
            }
            a(a2);
        }
    }

    public void showAsDropDown(View view) {
        showAsDropDown(view, 0, 0);
    }

    public void showAsDropDown(View view, int i2, int i3) {
        showAsDropDown(view, i2, i3, BadgeDrawable.TOP_START);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (!isShowing() && this.e != null) {
            a(view, i2, i3, i4);
            this.c = true;
            this.d = true;
            WindowManager.LayoutParams a2 = a(view.getWindowToken());
            b(a2);
            b(a(view, a2, i2, i3, i4));
            int i5 = this.y;
            if (i5 < 0) {
                this.A = i5;
                a2.height = i5;
            }
            int i6 = this.v;
            if (i6 < 0) {
                this.x = i6;
                a2.width = i6;
            }
            a2.windowAnimations = c();
            a(a2);
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (z2 != this.M) {
            this.M = z2;
            if (this.H != null) {
                Drawable drawable = this.I;
                if (drawable == null) {
                    this.f.refreshDrawableState();
                } else if (this.M) {
                    this.f.setBackgroundDrawable(drawable);
                } else {
                    this.f.setBackgroundDrawable(this.J);
                }
            }
        }
    }

    public boolean isAboveAnchor() {
        return this.M;
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        View view = this.e;
        if (view == null || this.f1577a == null || this.f1578b == null) {
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        }
        if (this.H != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i2 = -2;
            if (layoutParams2 == null || layoutParams2.height != -2) {
                i2 = -1;
            }
            b bVar = new b(this.f1577a);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
            bVar.setBackgroundDrawable(this.H);
            bVar.addView(this.e, layoutParams3);
            this.f = bVar;
        } else {
            this.f = view;
        }
        v.a(this.f, this.D);
        this.Y = color.support.a.a.a.b(this.f) == 2;
        this.B = layoutParams.width;
        this.C = layoutParams.height;
    }

    /* access modifiers changed from: package-private */
    public void a(WindowManager.LayoutParams layoutParams) {
        Context context = this.f1577a;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f.setFitsSystemWindows(this.q);
        b();
        this.f1578b.addView(this.f, layoutParams);
    }

    @SuppressLint({"NewApi"})
    private void b() {
        View view;
        WeakReference<View> weakReference = this.S;
        if (weakReference != null && (view = (View) weakReference.get()) != null && this.Y) {
            this.f.setLayoutDirection(view.getLayoutDirection());
        }
    }

    private WindowManager.LayoutParams a(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = BadgeDrawable.TOP_START;
        int i2 = this.w;
        this.x = i2;
        layoutParams.width = i2;
        int i3 = this.z;
        this.A = i3;
        layoutParams.height = i3;
        Drawable drawable = this.H;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = a(layoutParams.flags);
        layoutParams.type = this.N;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.i;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r3.h == 1) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r3.h == 2) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(int r4) {
        /*
            r3 = this;
            r0 = -8815129(0xffffffffff797de7, float:-3.316315E38)
            r4 = r4 & r0
            boolean r0 = r3.P
            if (r0 == 0) goto L_0x000c
            r0 = 32768(0x8000, float:4.5918E-41)
            r4 = r4 | r0
        L_0x000c:
            boolean r0 = r3.g
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r0 != 0) goto L_0x001a
            r4 = r4 | 8
            int r0 = r3.h
            r2 = 1
            if (r0 != r2) goto L_0x0020
            goto L_0x001f
        L_0x001a:
            int r0 = r3.h
            r2 = 2
            if (r0 != r2) goto L_0x0020
        L_0x001f:
            r4 = r4 | r1
        L_0x0020:
            boolean r0 = r3.j
            if (r0 != 0) goto L_0x0026
            r4 = r4 | 16
        L_0x0026:
            boolean r0 = r3.k
            if (r0 == 0) goto L_0x002d
            r0 = 262144(0x40000, float:3.67342E-40)
            r4 = r4 | r0
        L_0x002d:
            boolean r0 = r3.l
            if (r0 != 0) goto L_0x0033
            r4 = r4 | 512(0x200, float:7.175E-43)
        L_0x0033:
            boolean r0 = r3.isSplitTouchEnabled()
            if (r0 == 0) goto L_0x003c
            r0 = 8388608(0x800000, float:1.17549435E-38)
            r4 = r4 | r0
        L_0x003c:
            boolean r0 = r3.n
            if (r0 == 0) goto L_0x0042
            r4 = r4 | 256(0x100, float:3.59E-43)
        L_0x0042:
            boolean r0 = r3.q
            if (r0 == 0) goto L_0x0049
            r0 = 65536(0x10000, float:9.18355E-41)
            r4 = r4 | r0
        L_0x0049:
            boolean r0 = r3.r
            if (r0 == 0) goto L_0x004f
            r4 = r4 | 32
        L_0x004f:
            boolean r0 = r3.s
            if (r0 == 0) goto L_0x0056
            r0 = 1073741824(0x40000000, float:2.0)
            r4 = r4 | r0
        L_0x0056:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: color.support.v7.widget.c.a(int):int");
    }

    private int c() {
        int i2 = this.Q;
        if (i2 != -1) {
            return i2;
        }
        if (this.d) {
            return this.M ? R.style.Animation_ColorSupport_DropDownUp : R.style.Animation_ColorSupport_DropDownDown;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i2, int i3, int i4) {
        boolean z2;
        View view2 = view;
        WindowManager.LayoutParams layoutParams2 = layoutParams;
        int height = view.getHeight();
        int width = view.getWidth();
        int i5 = this.X ? i3 - height : i3;
        view2.getLocationInWindow(this.E);
        int[] iArr = this.E;
        layoutParams2.x = iArr[0] + i2;
        layoutParams2.y = iArr[1] + height + i5;
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, view.getLayoutDirection()) & 7;
        if (absoluteGravity == 5) {
            layoutParams2.x -= this.B - width;
        }
        layoutParams2.gravity = 51;
        view2.getLocationOnScreen(this.F);
        Rect rect = new Rect();
        view2.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (this.F[1] + height + i5 + this.C > rect.bottom || (layoutParams2.x + this.B) - rootView.getWidth() > 0) {
            if (this.p) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view2.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.B + scrollX + i2, this.C + scrollY + height + i5), true);
            }
            view2.getLocationInWindow(this.E);
            int[] iArr2 = this.E;
            layoutParams2.x = iArr2[0] + i2;
            layoutParams2.y = iArr2[1] + height + i5;
            if (absoluteGravity == 5) {
                layoutParams2.x -= this.B - width;
            }
            view2.getLocationOnScreen(this.F);
            int i6 = rect.bottom;
            int[] iArr3 = this.F;
            z2 = ((i6 - iArr3[1]) - height) - i5 < (iArr3[1] - i5) - rect.top;
            if (z2) {
                layoutParams2.gravity = 83;
                layoutParams2.y = (rootView.getHeight() - this.E[1]) + i5;
            } else {
                layoutParams2.y = this.E[1] + height + i5;
            }
        } else {
            z2 = false;
        }
        if (this.o) {
            int i7 = rect.right - rect.left;
            int i8 = layoutParams2.x + layoutParams2.width;
            if (i8 > i7) {
                layoutParams2.x -= i8 - i7;
            }
            if (layoutParams2.x < rect.left) {
                layoutParams2.x = rect.left;
                layoutParams2.width = Math.min(layoutParams2.width, i7);
            }
            if (z2) {
                int i9 = (this.F[1] + i5) - this.C;
                if (i9 < 0) {
                    layoutParams2.y += i9;
                }
            } else {
                layoutParams2.y = Math.max(layoutParams2.y, rect.top);
            }
        }
        layoutParams2.gravity |= 268435456;
        this.K = (this.E[0] - layoutParams2.x) + (height / 2);
        this.L = (this.E[1] - layoutParams2.y) + (width / 2);
        return z2;
    }

    public int getMaxAvailableHeight(View view) {
        return getMaxAvailableHeight(view, 0);
    }

    public int getMaxAvailableHeight(View view, int i2) {
        return getMaxAvailableHeight(view, i2, false);
    }

    public int getMaxAvailableHeight(View view, int i2, boolean z2) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = this.E;
        view.getLocationOnScreen(iArr);
        int i3 = rect.bottom;
        if (z2) {
            i3 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int max = Math.max((i3 - (iArr[1] + view.getHeight())) - i2, (iArr[1] - rect.top) + i2);
        Drawable drawable = this.H;
        if (drawable == null) {
            return max;
        }
        drawable.getPadding(this.G);
        return max - (this.G.top + this.G.bottom);
    }

    public void dismiss() {
        if (isShowing() && this.f != null) {
            this.c = false;
            d();
            try {
                this.f1578b.removeViewImmediate(this.f);
            } finally {
                View view = this.f;
                View view2 = this.e;
                if (view != view2 && (view instanceof ViewGroup)) {
                    ((ViewGroup) view).removeView(view2);
                }
                this.f = null;
                a aVar = this.O;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    public void a(a aVar) {
        this.O = aVar;
    }

    public void update() {
        if (isShowing() && this.e != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
            boolean z2 = false;
            int c2 = c();
            if (c2 != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = c2;
                z2 = true;
            }
            int a2 = a(layoutParams.flags);
            if (a2 != layoutParams.flags) {
                layoutParams.flags = a2;
                z2 = true;
            }
            if (z2) {
                b();
                this.f1578b.updateViewLayout(this.f, layoutParams);
            }
        }
    }

    public void update(int i2, int i3) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
        update(layoutParams.x, layoutParams.y, i2, i3, false);
    }

    public void update(int i2, int i3, int i4, int i5) {
        update(i2, i3, i4, i5, false);
    }

    public void update(int i2, int i3, int i4, int i5, boolean z2) {
        if (i4 != -1) {
            this.x = i4;
            setWidth(i4);
        }
        if (i5 != -1) {
            this.A = i5;
            setHeight(i5);
        }
        if (isShowing() && this.e != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
            int i6 = this.v;
            if (i6 >= 0) {
                i6 = this.x;
            }
            if (!(i4 == -1 || layoutParams.width == i6)) {
                this.x = i6;
                layoutParams.width = i6;
                z2 = true;
            }
            int i7 = this.y;
            if (i7 >= 0) {
                i7 = this.A;
            }
            if (!(i5 == -1 || layoutParams.height == i7)) {
                this.A = i7;
                layoutParams.height = i7;
                z2 = true;
            }
            if (layoutParams.x != i2) {
                layoutParams.x = i2;
                z2 = true;
            }
            if (layoutParams.y != i3) {
                layoutParams.y = i3;
                z2 = true;
            }
            int c2 = c();
            if (c2 != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = c2;
                z2 = true;
            }
            int a2 = a(layoutParams.flags);
            if (a2 != layoutParams.flags) {
                layoutParams.flags = a2;
                z2 = true;
            }
            if (z2) {
                b();
                this.f1578b.updateViewLayout(this.f, layoutParams);
            }
        }
    }

    public void update(View view, int i2, int i3) {
        a(view, false, 0, 0, true, i2, i3, this.W);
    }

    public void update(View view, int i2, int i3, int i4, int i5) {
        a(view, true, i2, i3, true, i4, i5, this.W);
    }

    private void a(View view, boolean z2, int i2, int i3, boolean z3, int i4, int i5, int i6) {
        View view2 = view;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        int i11 = i6;
        if (isShowing() && this.e != null) {
            WeakReference<View> weakReference = this.S;
            boolean z4 = true;
            boolean z5 = z2 && !(this.U == i7 && this.V == i8);
            if (weakReference == null || weakReference.get() != view2 || (z5 && !this.d)) {
                a(view, i7, i8, i11);
            } else if (z5) {
                this.U = i7;
                this.V = i8;
                this.W = i11;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
            if (z3) {
                if (i9 == -1) {
                    i9 = this.B;
                } else {
                    this.B = i9;
                }
                if (i10 == -1) {
                    i10 = this.C;
                } else {
                    this.C = i10;
                }
            }
            int i12 = i9;
            int i13 = i10;
            int i14 = layoutParams.x;
            int i15 = layoutParams.y;
            if (z2) {
                b(a(view, layoutParams, i2, i3, i6));
            } else {
                b(a(view, layoutParams, this.U, this.V, this.W));
            }
            int i16 = layoutParams.x;
            int i17 = layoutParams.y;
            if (i14 == layoutParams.x && i15 == layoutParams.y) {
                z4 = false;
            }
            update(i16, i17, i12, i13, z4);
        }
    }

    private void d() {
        WeakReference<View> weakReference = this.S;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.T);
        }
        this.S = null;
    }

    private void a(View view, int i2, int i3, int i4) {
        d();
        this.S = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.T);
        }
        this.U = i2;
        this.V = i3;
        this.W = i4;
    }

    /* compiled from: ColorBasePopupWindow */
    private class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public int[] onCreateDrawableState(int i) {
            if (!c.this.M) {
                return super.onCreateDrawableState(i);
            }
            int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
            View.mergeDrawableStates(onCreateDrawableState, c.R);
            return onCreateDrawableState;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() != 4) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                }
                return true;
            } else if (keyEvent.getAction() != 1 || (keyDispatcherState = getKeyDispatcherState()) == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled()) {
                return super.dispatchKeyEvent(keyEvent);
            } else {
                c.this.dismiss();
                return true;
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (c.this.u == null || !c.this.u.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
                c.this.dismiss();
                return true;
            } else if (motionEvent.getAction() != 4) {
                return super.onTouchEvent(motionEvent);
            } else {
                c.this.dismiss();
                return true;
            }
        }

        public void sendAccessibilityEvent(int i) {
            if (c.this.e != null) {
                c.this.e.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }
}
