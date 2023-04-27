package androidx.widget;

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
import androidx.core.g.v;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import com.a.a.f;
import java.util.ArrayList;
import java.util.List;

public class ColorDrawerLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1397a = {16842931};

    /* renamed from: b  reason: collision with root package name */
    static final boolean f1398b = (Build.VERSION.SDK_INT >= 19);
    private static final int[] c = {16843828};
    private static final boolean d;
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private c G;
    private List<c> H;
    private float I;
    private float J;
    private Drawable K;
    private Drawable L;
    private Drawable M;
    private Drawable N;
    private Object O;
    private boolean P;
    private Drawable Q;
    private Drawable R;
    private Drawable S;
    private Drawable T;
    private Drawable U;
    private final ArrayList<View> V;
    private Rect W;
    private Matrix aa;
    private a ab;
    /* access modifiers changed from: private */
    public int ac;
    private f ad;
    private View ae;
    /* access modifiers changed from: private */
    public int af;
    private final b e;
    private float f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final androidx.customview.a.c k;
    private final androidx.customview.a.c l;
    private final androidx.customview.a.c m;
    private final e n;
    private final e o;
    private final e p;
    private Rect q;
    /* access modifiers changed from: private */
    public int r;
    private boolean s;
    private boolean t;
    /* access modifiers changed from: private */
    public int u;
    private int v;
    private boolean w;
    private boolean x;
    /* access modifiers changed from: private */
    public boolean y;
    private int z;

    public interface a {
        void a();
    }

    public interface c {
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
    public void setDrawerListener(c cVar) {
        c cVar2 = this.G;
        if (cVar2 != null) {
            b(cVar2);
        }
        if (cVar != null) {
            a(cVar);
        }
        this.G = cVar;
    }

    public void a(c cVar) {
        if (cVar != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(cVar);
        }
    }

    public void b(c cVar) {
        List<c> list;
        if (cVar != null && (list = this.H) != null) {
            list.remove(cVar);
        }
    }

    public void setDrawerLockMode(int i2) {
        a(i2, 3);
        a(i2, 5);
        a(i2, 80);
    }

    public void a(int i2, int i3) {
        View b2;
        androidx.customview.a.c cVar;
        int a2 = androidx.core.g.c.a(i3, v.g(this));
        if (i3 == 3) {
            this.z = i2;
        } else if (i3 == 5) {
            this.A = i2;
        } else if (i3 == 80) {
            this.D = i2;
        } else if (i3 == 8388611) {
            this.B = i2;
        } else if (i3 == 8388613) {
            this.C = i2;
        }
        if (i2 != 0) {
            if (a2 == 3) {
                cVar = this.k;
            } else if (a2 != 5) {
                cVar = this.m;
            } else {
                cVar = this.l;
            }
            cVar.e();
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
            int i6 = this.z;
            if (i6 != 3) {
                return i6;
            }
            int i7 = g2 == 0 ? this.B : this.C;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i2 == 5) {
            int i8 = this.A;
            if (i8 != 3) {
                return i8;
            }
            if (g2 == 0) {
                i3 = this.C;
            } else {
                i3 = this.B;
            }
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i2 == 80) {
            int i9 = this.D;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i10 = this.B;
            if (i10 != 3) {
                return i10;
            }
            if (g2 == 0) {
                i4 = this.z;
            } else {
                i4 = this.A;
            }
            if (i4 != 3) {
                return i4;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i11 = this.C;
            if (i11 != 3) {
                return i11;
            }
            if (g2 == 0) {
                i5 = this.A;
            } else {
                i5 = this.z;
            }
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
    }

    public int a(View view) {
        if (g(view)) {
            return a(((d) view.getLayoutParams()).f1399a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    private boolean a(float f2, float f3, View view) {
        if (this.W == null) {
            this.W = new Rect();
        }
        view.getHitRect(this.W);
        return this.W.contains((int) f2, (int) f3);
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
            if (this.aa == null) {
                this.aa = new Matrix();
            }
            matrix.invert(this.aa);
            obtain.transform(this.aa);
        }
        return obtain;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, View view) {
        int a2 = this.k.a();
        int a3 = this.l.a();
        int a4 = this.m.a();
        int i4 = (a2 == 1 || a3 == 1 || a4 == 1) ? 1 : (a2 == 2 || a3 == 2 || a4 == 2) ? 2 : 0;
        if (view != null && i3 == 0) {
            d dVar = (d) view.getLayoutParams();
            if (dVar.f1400b == 0.0f) {
                b(view);
            } else if (dVar.f1400b == 1.0f) {
                c(view);
            } else {
                dVar.d &= 2;
            }
        }
        if (i4 != this.v) {
            this.v = i4;
            List<c> list = this.H;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.H.get(size).a(i4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        View rootView;
        d dVar = (d) view.getLayoutParams();
        if (a(view, 80) && dVar.d != 4) {
            dVar.d = 1;
        }
        if ((dVar.d & 1) == 1) {
            dVar.d = 0;
            List<c> list = this.H;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.H.get(size).b(view);
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
        d dVar = (d) view.getLayoutParams();
        if ((dVar.d & 1) == 0) {
            dVar.d = 1;
            List<c> list = this.H;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.H.get(size).a(view);
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
        List<c> list = this.H;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.H.get(size).a(view, f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view, float f2) {
        d dVar = (d) view.getLayoutParams();
        if (f2 != dVar.f1400b) {
            dVar.f1400b = f2;
            a(view, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public float d(View view) {
        return ((d) view.getLayoutParams()).f1400b;
    }

    /* access modifiers changed from: package-private */
    public int e(View view) {
        return androidx.core.g.c.a(((d) view.getLayoutParams()).f1399a, v.g(this));
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
            d dVar = (d) childAt.getLayoutParams();
            if ((dVar.d & 1) == 1) {
                return childAt;
            }
            if (a(childAt, 80) && dVar.f1400b > 0.0f) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void c(View view, float f2) {
        float d2 = d(view);
        if (a(view, 80)) {
            view.offsetTopAndBottom((int) ((d2 - f2) * ((float) view.getMeasuredHeight())));
        } else {
            float width = (float) view.getWidth();
            int i2 = ((int) (width * f2)) - ((int) (d2 * width));
            if (!a(view, 3)) {
                i2 = -i2;
            }
            view.offsetLeftAndRight(i2);
        }
        b(view, f2);
    }

    /* access modifiers changed from: package-private */
    public View b(int i2) {
        int a2 = androidx.core.g.c.a(i2, v.g(this)) & 119;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((e(childAt) & 119) == a2) {
                return childAt;
            }
        }
        return null;
    }

    static String c(int i2) {
        if ((i2 & 3) == 3) {
            return "LEFT";
        }
        if ((i2 & 5) == 5) {
            return "RIGHT";
        }
        return (i2 & 80) == 80 ? "BOTTOM" : Integer.toHexString(i2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.x = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.x = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014e  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            int r1 = android.view.View.MeasureSpec.getMode(r19)
            int r2 = android.view.View.MeasureSpec.getMode(r20)
            int r3 = android.view.View.MeasureSpec.getSize(r19)
            int r4 = android.view.View.MeasureSpec.getSize(r20)
            r5 = 300(0x12c, float:4.2E-43)
            r6 = 1073741824(0x40000000, float:2.0)
            if (r1 != r6) goto L_0x001a
            if (r2 == r6) goto L_0x002e
        L_0x001a:
            boolean r7 = r18.isInEditMode()
            if (r7 == 0) goto L_0x021d
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r7) goto L_0x0025
            goto L_0x0028
        L_0x0025:
            if (r1 != 0) goto L_0x0028
            r3 = r5
        L_0x0028:
            if (r2 != r7) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            if (r2 != 0) goto L_0x002e
            r4 = r5
        L_0x002e:
            r0.setMeasuredDimension(r3, r4)
            java.lang.Object r1 = r0.O
            if (r1 == 0) goto L_0x003d
            boolean r1 = androidx.core.g.v.t(r18)
            if (r1 == 0) goto L_0x003d
            r1 = 1
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            int r7 = androidx.core.g.v.g(r18)
            int r8 = r18.getChildCount()
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x004a:
            if (r9 >= r8) goto L_0x021c
            android.view.View r13 = r0.getChildAt(r9)
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x005e
            r17 = r1
            r2 = r6
            r5 = 0
            goto L_0x0148
        L_0x005e:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.widget.ColorDrawerLayout$d r14 = (androidx.widget.ColorDrawerLayout.d) r14
            r6 = 3
            if (r1 == 0) goto L_0x0124
            int r15 = r14.f1399a
            int r15 = androidx.core.g.c.a(r15, r7)
            boolean r16 = androidx.core.g.v.t(r13)
            r2 = 21
            if (r16 == 0) goto L_0x00c2
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L_0x0124
            java.lang.Object r2 = r0.O
            android.view.WindowInsets r2 = (android.view.WindowInsets) r2
            if (r15 != r6) goto L_0x0093
            int r5 = r2.getSystemWindowInsetLeft()
            int r15 = r2.getSystemWindowInsetTop()
            int r6 = r2.getSystemWindowInsetBottom()
            r17 = r1
            r1 = 0
            android.view.WindowInsets r2 = r2.replaceSystemWindowInsets(r5, r15, r1, r6)
            goto L_0x00be
        L_0x0093:
            r17 = r1
            r1 = 0
            r5 = 5
            if (r15 != r5) goto L_0x00aa
            int r5 = r2.getSystemWindowInsetTop()
            int r6 = r2.getSystemWindowInsetRight()
            int r15 = r2.getSystemWindowInsetBottom()
            android.view.WindowInsets r2 = r2.replaceSystemWindowInsets(r1, r5, r6, r15)
            goto L_0x00be
        L_0x00aa:
            r5 = 80
            if (r15 != r5) goto L_0x00be
            int r5 = r2.getSystemWindowInsetLeft()
            int r6 = r2.getSystemWindowInsetRight()
            int r15 = r2.getSystemWindowInsetBottom()
            android.view.WindowInsets r2 = r2.replaceSystemWindowInsets(r5, r1, r6, r15)
        L_0x00be:
            r13.dispatchApplyWindowInsets(r2)
            goto L_0x0126
        L_0x00c2:
            r17 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r2) goto L_0x0126
            java.lang.Object r1 = r0.O
            android.view.WindowInsets r1 = (android.view.WindowInsets) r1
            r2 = 3
            if (r15 != r2) goto L_0x00e2
            int r2 = r1.getSystemWindowInsetLeft()
            int r5 = r1.getSystemWindowInsetTop()
            int r6 = r1.getSystemWindowInsetBottom()
            r15 = 0
            android.view.WindowInsets r1 = r1.replaceSystemWindowInsets(r2, r5, r15, r6)
            r5 = r15
            goto L_0x010b
        L_0x00e2:
            r2 = 5
            r5 = 0
            if (r15 != r2) goto L_0x00f7
            int r2 = r1.getSystemWindowInsetTop()
            int r6 = r1.getSystemWindowInsetRight()
            int r15 = r1.getSystemWindowInsetBottom()
            android.view.WindowInsets r1 = r1.replaceSystemWindowInsets(r5, r2, r6, r15)
            goto L_0x010b
        L_0x00f7:
            r2 = 80
            if (r15 != r2) goto L_0x010b
            int r2 = r1.getSystemWindowInsetLeft()
            int r6 = r1.getSystemWindowInsetRight()
            int r15 = r1.getSystemWindowInsetBottom()
            android.view.WindowInsets r1 = r1.replaceSystemWindowInsets(r2, r5, r6, r15)
        L_0x010b:
            int r2 = r1.getSystemWindowInsetLeft()
            r14.leftMargin = r2
            int r2 = r1.getSystemWindowInsetTop()
            r14.topMargin = r2
            int r2 = r1.getSystemWindowInsetRight()
            r14.rightMargin = r2
            int r1 = r1.getSystemWindowInsetBottom()
            r14.bottomMargin = r1
            goto L_0x0127
        L_0x0124:
            r17 = r1
        L_0x0126:
            r5 = 0
        L_0x0127:
            boolean r1 = r0.f(r13)
            if (r1 == 0) goto L_0x014e
            int r1 = r14.leftMargin
            int r1 = r3 - r1
            int r2 = r14.rightMargin
            int r1 = r1 - r2
            r2 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
            int r6 = r14.topMargin
            int r6 = r4 - r6
            int r14 = r14.bottomMargin
            int r6 = r6 - r14
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r2)
            r13.measure(r1, r6)
        L_0x0148:
            r6 = r19
            r15 = r20
            goto L_0x01eb
        L_0x014e:
            r2 = 1073741824(0x40000000, float:2.0)
            boolean r1 = r0.g(r13)
            if (r1 == 0) goto L_0x01f3
            boolean r1 = d
            if (r1 == 0) goto L_0x0167
            float r1 = androidx.core.g.v.o(r13)
            float r6 = r0.f
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0167
            androidx.core.g.v.a((android.view.View) r13, (float) r6)
        L_0x0167:
            int r1 = r0.e(r13)
            r1 = r1 & 119(0x77, float:1.67E-43)
            r6 = 3
            if (r1 != r6) goto L_0x0172
            r6 = 1
            goto L_0x0173
        L_0x0172:
            r6 = r5
        L_0x0173:
            r15 = 5
            if (r1 != r15) goto L_0x017a
            r2 = 80
            r15 = 1
            goto L_0x017d
        L_0x017a:
            r15 = r5
            r2 = 80
        L_0x017d:
            if (r1 != r2) goto L_0x0181
            r2 = 1
            goto L_0x0182
        L_0x0181:
            r2 = r5
        L_0x0182:
            if (r6 == 0) goto L_0x0186
            if (r10 != 0) goto L_0x018f
        L_0x0186:
            if (r15 == 0) goto L_0x018a
            if (r11 != 0) goto L_0x018f
        L_0x018a:
            if (r2 == 0) goto L_0x01be
            if (r12 != 0) goto L_0x018f
            goto L_0x01be
        L_0x018f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Child drawer has absolute gravity "
            r3.append(r4)
            java.lang.String r1 = c((int) r1)
            r3.append(r1)
            java.lang.String r1 = " but this "
            r3.append(r1)
            java.lang.String r1 = "DrawerLayout"
            r3.append(r1)
            java.lang.String r1 = " already has a "
            r3.append(r1)
            java.lang.String r1 = "drawer view along that edge"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x01be:
            if (r6 == 0) goto L_0x01c2
            r10 = 1
            goto L_0x01c7
        L_0x01c2:
            if (r15 == 0) goto L_0x01c6
            r11 = 1
            goto L_0x01c7
        L_0x01c6:
            r12 = 1
        L_0x01c7:
            if (r2 == 0) goto L_0x01cb
            r1 = r5
            goto L_0x01d3
        L_0x01cb:
            int r1 = r0.g
            int r2 = r14.leftMargin
            int r1 = r1 + r2
            int r2 = r14.rightMargin
            int r1 = r1 + r2
        L_0x01d3:
            int r2 = r14.width
            r6 = r19
            int r1 = getChildMeasureSpec(r6, r1, r2)
            int r2 = r14.topMargin
            int r15 = r14.bottomMargin
            int r2 = r2 + r15
            int r14 = r14.height
            r15 = r20
            int r2 = getChildMeasureSpec(r15, r2, r14)
            r13.measure(r1, r2)
        L_0x01eb:
            int r9 = r9 + 1
            r1 = r17
            r6 = 1073741824(0x40000000, float:2.0)
            goto L_0x004a
        L_0x01f3:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Child "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r3 = " at index "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r3 = " does not have a valid layout_gravity - must be Gravity.LEFT, "
            r2.append(r3)
            java.lang.String r3 = "Gravity.RIGHT or Gravity.NO_GRAVITY"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x021c:
            return
        L_0x021d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "DrawerLayout must be measured with MeasureSpec.EXACTLY."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.ColorDrawerLayout.onMeasure(int, int):void");
    }

    private void d() {
        if (!d) {
            this.L = e();
            this.M = f();
            this.N = this.U;
        }
    }

    private Drawable e() {
        int g2 = v.g(this);
        if (g2 == 0) {
            Drawable drawable = this.Q;
            if (drawable != null) {
                a(drawable, g2);
                return this.Q;
            }
        } else {
            Drawable drawable2 = this.R;
            if (drawable2 != null) {
                a(drawable2, g2);
                return this.R;
            }
        }
        return this.S;
    }

    private Drawable f() {
        int g2 = v.g(this);
        if (g2 == 0) {
            Drawable drawable = this.R;
            if (drawable != null) {
                a(drawable, g2);
                return this.R;
            }
        } else {
            Drawable drawable2 = this.Q;
            if (drawable2 != null) {
                a(drawable2, g2);
                return this.Q;
            }
        }
        return this.T;
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
        this.w = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(dVar.leftMargin, dVar.topMargin, dVar.leftMargin + childAt.getMeasuredWidth(), dVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (dVar.f1400b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else if (a(childAt, 5)) {
                        float f4 = (float) measuredWidth;
                        int i9 = i7 - ((int) (dVar.f1400b * f4));
                        f2 = ((float) (i7 - i9)) / f4;
                        i6 = i9;
                    } else {
                        int i10 = i5 - i3;
                        float f5 = (float) measuredHeight;
                        f2 = ((float) (i10 - (i10 - ((int) (dVar.f1400b * f5))))) / f5;
                        i6 = childAt.getPaddingLeft();
                    }
                    boolean z4 = f2 != dVar.f1400b ? z3 : false;
                    int i11 = dVar.f1399a & 119;
                    if (i11 == 16) {
                        int i12 = i5 - i3;
                        int i13 = (i12 - measuredHeight) / 2;
                        if (i13 < dVar.topMargin) {
                            i13 = dVar.topMargin;
                        } else if (i13 + measuredHeight > i12 - dVar.bottomMargin) {
                            i13 = (i12 - dVar.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i6, i13, measuredWidth + i6, measuredHeight + i13);
                    } else if (i11 != 80) {
                        childAt.layout(i6, dVar.topMargin, measuredWidth + i6, dVar.topMargin + measuredHeight);
                    } else {
                        int measuredHeight2 = (int) (((float) (i5 - i3)) - (((d) childAt.getLayoutParams()).f1400b * ((float) childAt.getMeasuredHeight())));
                        childAt.layout(i6, measuredHeight2, measuredWidth + i6, (childAt.getMeasuredHeight() + measuredHeight2) - dVar.bottomMargin);
                    }
                    if (z4) {
                        b(childAt, f2);
                    }
                    int i14 = dVar.f1400b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i14) {
                        childAt.setVisibility(i14);
                    }
                }
            }
            i8++;
            z3 = true;
        }
        this.w = false;
        this.x = false;
    }

    public void requestLayout() {
        if (!this.w) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((d) getChildAt(i2).getLayoutParams()).f1400b);
        }
        this.i = f2;
        boolean a2 = this.k.a(true);
        boolean a3 = this.l.a(true);
        boolean a4 = this.m.a(true);
        if (a2 || a3 || a4) {
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
        this.K = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.K;
    }

    public void setStatusBarBackground(int i2) {
        this.K = i2 != 0 ? androidx.core.content.a.a(getContext(), i2) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.K = new ColorDrawable(i2);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i2) {
        d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r4.O;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            boolean r0 = r4.P
            if (r0 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r4.K
            if (r0 == 0) goto L_0x002e
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x001d
            java.lang.Object r0 = r4.O
            if (r0 == 0) goto L_0x001d
            android.view.WindowInsets r0 = (android.view.WindowInsets) r0
            int r0 = r0.getSystemWindowInsetTop()
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r1 = r4.K
            int r3 = r4.getWidth()
            r1.setBounds(r2, r2, r3, r0)
            android.graphics.drawable.Drawable r0 = r4.K
            r0.draw(r5)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.ColorDrawerLayout.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        int i2;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean f2 = f(view2);
        int width = getWidth();
        int height2 = getHeight();
        int save = canvas.save();
        int i3 = 80;
        int i4 = 0;
        if (f2) {
            int childCount = getChildCount();
            i2 = width;
            int i5 = height2;
            int i6 = 0;
            int i7 = 0;
            while (i6 < childCount) {
                View childAt = getChildAt(i6);
                if (childAt != view2 && childAt.getVisibility() == 0 && ((m(childAt) || a(childAt, i3)) && g(childAt) && childAt.getHeight() >= height)) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i7) {
                            i7 = right;
                        }
                    } else if (a(childAt, 5)) {
                        int left = childAt.getLeft();
                        if (left < i2) {
                            i2 = left;
                        }
                    } else {
                        int top = childAt.getTop();
                        if (top < i5) {
                            Rect rect = this.q;
                            i5 = top + (rect != null ? rect.height() : 0);
                        }
                    }
                }
                i6++;
                i3 = 80;
            }
            canvas2.clipRect(i7, 0, i2, i5);
            i4 = i7;
        } else {
            i2 = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas2.restoreToCount(save);
        float f3 = this.i;
        if (f3 > 0.0f && f2) {
            int i8 = this.h;
            this.j.setColor((i8 & 16777215) | (((int) (((float) ((-16777216 & i8) >>> 24)) * f3)) << 24));
            canvas.drawRect((float) i4, 0.0f, (float) i2, (float) getHeight(), this.j);
        } else if (this.L != null && a(view2, 3)) {
            int intrinsicWidth = this.L.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.k.b()), 1.0f));
            this.L.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.L.setAlpha((int) (max * 255.0f));
            this.L.draw(canvas2);
        } else if (this.M != null && a(view2, 5)) {
            int intrinsicWidth2 = this.M.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.l.b()), 1.0f));
            this.M.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.M.setAlpha((int) (max2 * 255.0f));
            this.M.draw(canvas2);
        } else if (this.N != null && a(view2, 80)) {
            int intrinsicHeight = this.N.getIntrinsicHeight();
            int top2 = view.getTop();
            float max3 = Math.max(0.0f, Math.min(((float) (getHeight() - top2)) / ((float) this.m.b()), 1.0f));
            this.N.setBounds(view.getLeft(), top2 - intrinsicHeight, view.getRight(), view.getBottom());
            this.M.setAlpha((int) (max3 * 255.0f));
            this.M.draw(canvas2);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public boolean f(View view) {
        return ((d) view.getLayoutParams()).f1399a == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean g(View view) {
        int a2 = androidx.core.g.c.a(((d) view.getLayoutParams()).f1399a, v.g(view));
        return ((a2 & 3) == 0 && (a2 & 5) == 0 && (a2 & 80) == 0) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r0 != 3) goto L_0x00c7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getActionMasked()
            androidx.customview.a.c r1 = r9.k
            boolean r1 = r1.a((android.view.MotionEvent) r10)
            androidx.customview.a.c r2 = r9.l
            boolean r2 = r2.a((android.view.MotionEvent) r10)
            r1 = r1 | r2
            r2 = 80
            android.view.View r2 = r9.b((int) r2)
            r3 = 0
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0037
            android.view.ViewGroup$LayoutParams r6 = r2.getLayoutParams()
            androidx.widget.ColorDrawerLayout$d r6 = (androidx.widget.ColorDrawerLayout.d) r6
            float r7 = r6.f1400b
            r8 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x0033
            float r6 = r6.f1400b
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r6 = r5
            goto L_0x0034
        L_0x0033:
            r6 = r4
        L_0x0034:
            r9.s = r6
            goto L_0x0039
        L_0x0037:
            r9.s = r4
        L_0x0039:
            boolean r6 = r9.s
            if (r6 != 0) goto L_0x0048
            boolean r6 = r9.t
            if (r6 == 0) goto L_0x0048
            androidx.customview.a.c r6 = r9.m
            boolean r6 = r6.a((android.view.MotionEvent) r10)
            r1 = r1 | r6
        L_0x0048:
            if (r0 == 0) goto L_0x00ca
            if (r0 == r4) goto L_0x00c0
            r3 = 2
            r6 = 3
            if (r0 == r3) goto L_0x0054
            if (r0 == r6) goto L_0x00c0
            goto L_0x00c7
        L_0x0054:
            androidx.customview.a.c r0 = r9.k
            boolean r0 = r0.d(r6)
            if (r0 == 0) goto L_0x00c7
            androidx.widget.ColorDrawerLayout$e r0 = r9.n
            r0.a()
            androidx.widget.ColorDrawerLayout$e r0 = r9.o
            r0.a()
            float r0 = r10.getX()
            float r3 = r10.getY()
            boolean r6 = r9.t
            if (r6 == 0) goto L_0x00bd
            android.graphics.Rect r6 = r9.q
            if (r6 == 0) goto L_0x00b0
            int r6 = r2.getLeft()
            android.graphics.Rect r7 = r9.q
            int r7 = r7.left
            int r6 = r6 + r7
            float r6 = (float) r6
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00b0
            int r6 = r2.getLeft()
            android.graphics.Rect r7 = r9.q
            int r7 = r7.right
            int r6 = r6 + r7
            float r6 = (float) r6
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b0
            int r0 = r2.getTop()
            android.graphics.Rect r6 = r9.q
            int r6 = r6.top
            int r0 = r0 + r6
            float r0 = (float) r0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b0
            int r0 = r2.getTop()
            android.graphics.Rect r2 = r9.q
            int r2 = r2.bottom
            int r0 = r0 + r2
            float r0 = (float) r0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b0
            r0 = r4
            goto L_0x00b1
        L_0x00b0:
            r0 = r5
        L_0x00b1:
            if (r0 == 0) goto L_0x00bd
            r10.setAction(r5)
            androidx.customview.a.c r0 = r9.m
            r0.b((android.view.MotionEvent) r10)
            r10 = r4
            goto L_0x00be
        L_0x00bd:
            r10 = r5
        L_0x00be:
            r3 = r5
            goto L_0x010a
        L_0x00c0:
            r9.a((boolean) r4)
            r9.E = r5
            r9.F = r5
        L_0x00c7:
            r10 = r5
            r3 = r10
            goto L_0x010a
        L_0x00ca:
            float r0 = r10.getX()
            float r10 = r10.getY()
            r9.I = r0
            r9.J = r10
            float r6 = r9.i
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ee
            androidx.customview.a.c r3 = r9.k
            int r6 = (int) r0
            int r7 = (int) r10
            android.view.View r3 = r3.d(r6, r7)
            if (r3 == 0) goto L_0x00ee
            boolean r3 = r9.f(r3)
            if (r3 == 0) goto L_0x00ee
            r3 = r4
            goto L_0x00ef
        L_0x00ee:
            r3 = r5
        L_0x00ef:
            r9.E = r5
            r9.F = r5
            boolean r6 = r9.s
            if (r6 != 0) goto L_0x0107
            android.graphics.Rect r6 = r9.q
            int r0 = (int) r0
            int r10 = (int) r10
            int r2 = r2.getTop()
            int r10 = r10 - r2
            boolean r10 = r6.contains(r0, r10)
            r9.t = r10
            goto L_0x0109
        L_0x0107:
            r9.t = r5
        L_0x0109:
            r10 = r5
        L_0x010a:
            if (r1 != 0) goto L_0x011c
            if (r3 != 0) goto L_0x011c
            boolean r0 = r9.g()
            if (r0 != 0) goto L_0x011c
            boolean r0 = r9.F
            if (r0 != 0) goto L_0x011c
            if (r10 == 0) goto L_0x011b
            goto L_0x011c
        L_0x011b:
            r4 = r5
        L_0x011c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.ColorDrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
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
        this.k.b(motionEvent);
        this.l.b(motionEvent);
        if (!this.s && this.t) {
            this.m.b(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.I = x2;
            this.J = y2;
            this.E = false;
            this.F = false;
        } else if (action == 1) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            View d2 = this.k.d((int) x3, (int) y3);
            View a2 = a();
            if (d2 != null && f(d2)) {
                float f2 = x3 - this.I;
                float f3 = y3 - this.J;
                int d3 = this.k.d();
                if (!((f2 * f2) + (f3 * f3) >= ((float) (d3 * d3)) || a2 == null || a(a2) == 2)) {
                    z2 = false;
                    if (!this.y || a2 == null || z2) {
                        a(z2);
                    } else {
                        this.ae = a2;
                        this.ad.b(100.0d);
                    }
                    this.E = false;
                    this.t = false;
                }
            }
            z2 = true;
            if (!this.y) {
            }
            a(z2);
            this.E = false;
            this.t = false;
        } else if (action == 3) {
            a(true);
            this.E = false;
            this.F = false;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        this.E = z2;
        if (z2) {
            a(true);
        }
    }

    public void b() {
        a(false);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        boolean a2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            if (g(childAt) && (!z2 || dVar.c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    a2 = this.k.a(childAt, -width, childAt.getTop());
                } else if (a(childAt, 5)) {
                    a2 = this.l.a(childAt, getWidth(), childAt.getTop());
                } else {
                    a aVar = this.ab;
                    if (aVar != null) {
                        aVar.a();
                        dVar.c = false;
                    } else {
                        a2 = this.m.a(childAt, childAt.getLeft(), getHeight());
                    }
                }
                z3 |= a2;
                dVar.c = false;
            }
        }
        this.n.a();
        this.o.a();
        this.p.a();
        if (z3) {
            invalidate();
        }
    }

    public void h(View view) {
        a(view, true);
    }

    public void a(View view, boolean z2) {
        if (g(view)) {
            d dVar = (d) view.getLayoutParams();
            this.af = 0;
            if (this.x) {
                dVar.f1400b = 1.0f;
                dVar.d = 1;
                c(view, true);
            } else if (z2) {
                dVar.d |= 2;
                if (a(view, 3)) {
                    this.k.a(view, 0, view.getTop());
                } else if (a(view, 5)) {
                    this.l.a(view, getWidth() - view.getWidth(), view.getTop());
                } else {
                    this.m.a(view, view.getPaddingLeft(), 0);
                }
            } else {
                c(view, 1.0f);
                a(dVar.f1399a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void a(int i2, boolean z2) {
        View b2 = b(i2);
        if (b2 != null) {
            a(b2, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + c(i2));
    }

    public void i(View view) {
        b(view, true);
    }

    public void b(View view, boolean z2) {
        if (g(view)) {
            d dVar = (d) view.getLayoutParams();
            this.af = 2;
            if (this.x) {
                dVar.f1400b = 0.0f;
                dVar.d = 0;
            } else if (z2) {
                dVar.d |= 4;
                if (a(view, 3)) {
                    this.k.a(view, -view.getWidth(), view.getTop());
                } else if (a(view, 5)) {
                    this.l.a(view, getWidth(), view.getTop());
                } else {
                    this.m.a(view, view.getLeft(), getHeight());
                }
            } else {
                c(view, 0.0f);
                a(dVar.f1399a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void b(int i2, boolean z2) {
        View b2 = b(i2);
        if (b2 != null) {
            b(b2, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + c(i2));
    }

    public boolean j(View view) {
        if (g(view)) {
            return (((d) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean k(View view) {
        if (g(view)) {
            return ((d) view.getLayoutParams()).f1400b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    private boolean g() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((d) getChildAt(i2).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!g(childAt)) {
                    this.V.add(childAt);
                } else if (j(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z2 = true;
                }
            }
            if (!z2) {
                int size = this.V.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = this.V.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.V.clear();
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
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.openDrawerGravity == 0 || b(savedState.openDrawerGravity) == null)) {
            a(savedState.openDrawerGravity, savedState.onScreen, false);
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
        if (savedState.lockModeBottom != 3) {
            a(savedState.lockModeBottom, 80);
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
            d dVar = (d) getChildAt(i2).getLayoutParams();
            boolean z2 = true;
            boolean z3 = dVar.d == 1;
            if (dVar.d != 2) {
                z2 = false;
            }
            if (z3 || z2) {
                savedState.openDrawerGravity = dVar.f1399a;
                savedState.onScreen = dVar.f1400b;
            } else {
                i2++;
            }
        }
        savedState.lockModeLeft = this.z;
        savedState.lockModeRight = this.A;
        savedState.lockModeStart = this.B;
        savedState.lockModeEnd = this.C;
        savedState.lockModeBottom = this.D;
        return savedState;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (a() != null || g(view)) {
            v.b(view, 4);
        } else {
            v.b(view, 1);
        }
        if (!f1398b) {
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
        int lockModeBottom;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        float onScreen;
        int openDrawerGravity = 0;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
            this.lockModeBottom = parcel.readInt();
            this.onScreen = parcel.readFloat();
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
            parcel.writeInt(this.lockModeBottom);
            parcel.writeFloat(this.onScreen);
        }
    }

    private class e extends c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorDrawerLayout f1401a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1402b;
        private androidx.customview.a.c c;
        private int d;
        private final Runnable e;

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void a() {
            this.f1401a.removeCallbacks(this.e);
        }

        public boolean tryCaptureView(View view, int i) {
            return this.f1401a.g(view) && this.f1401a.a(view, this.f1402b) && this.f1401a.a(view) == 0;
        }

        public void onViewDragStateChanged(int i) {
            View c2 = this.c.c();
            if (i == 1) {
                this.d = c2 == null ? this.f1401a.getHeight() : c2.getTop();
            }
            this.f1401a.a(this.f1402b, i, c2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewPositionChanged(android.view.View r5, int r6, int r7, int r8, int r9) {
            /*
                r4 = this;
                int r8 = r5.getWidth()
                int r9 = r5.getHeight()
                androidx.widget.ColorDrawerLayout r0 = r4.f1401a
                r1 = 3
                boolean r0 = r0.a((android.view.View) r5, (int) r1)
                r1 = 4
                r2 = 0
                if (r0 == 0) goto L_0x0018
                int r6 = r6 + r8
                float r6 = (float) r6
            L_0x0015:
                float r7 = (float) r8
                float r6 = r6 / r7
                goto L_0x0042
            L_0x0018:
                androidx.widget.ColorDrawerLayout r0 = r4.f1401a
                r3 = 5
                boolean r0 = r0.a((android.view.View) r5, (int) r3)
                if (r0 == 0) goto L_0x002a
                androidx.widget.ColorDrawerLayout r7 = r4.f1401a
                int r7 = r7.getWidth()
                int r7 = r7 - r6
                float r6 = (float) r7
                goto L_0x0015
            L_0x002a:
                androidx.widget.ColorDrawerLayout r6 = r4.f1401a
                int r6 = r6.getMeasuredHeight()
                int r6 = r6 - r7
                float r6 = (float) r6
                float r7 = (float) r9
                float r6 = r6 / r7
                float r6 = java.lang.Math.max(r2, r6)
                int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r7 != 0) goto L_0x003e
                r7 = r1
                goto L_0x003f
            L_0x003e:
                r7 = 1
            L_0x003f:
                androidx.core.g.v.b((android.view.View) r5, (int) r7)
            L_0x0042:
                androidx.widget.ColorDrawerLayout r7 = r4.f1401a
                r7.b((android.view.View) r5, (float) r6)
                int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r6 != 0) goto L_0x004c
                goto L_0x004d
            L_0x004c:
                r1 = 0
            L_0x004d:
                r5.setVisibility(r1)
                androidx.widget.ColorDrawerLayout r5 = r4.f1401a
                r5.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.widget.ColorDrawerLayout.e.onViewPositionChanged(android.view.View, int, int, int, int):void");
        }

        public void onViewCaptured(View view, int i) {
            ((d) view.getLayoutParams()).c = false;
            b();
        }

        private void b() {
            View view;
            int i = this.f1402b;
            View view2 = null;
            if (i == 3) {
                view2 = this.f1401a.b(80);
                view = this.f1401a.b(5);
            } else if (i == 5) {
                view2 = this.f1401a.b(3);
                view = this.f1401a.b(80);
            } else if (i != 80) {
                view = null;
            } else {
                view2 = this.f1401a.b(3);
                view = this.f1401a.b(5);
            }
            if (view2 != null) {
                this.f1401a.i(view2);
            }
            if (view != null) {
                this.f1401a.i(view);
            }
        }

        public void onViewReleased(View view, float f, float f2) {
            int width;
            float d2 = this.f1401a.d(view);
            int width2 = view.getWidth();
            int height = view.getHeight();
            int left = view.getLeft();
            int top = view.getTop();
            if (this.f1401a.a(view, 3)) {
                int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i > 0 || (i == 0 && d2 > 0.5f)) {
                    left = 0;
                    this.c.a(left, top);
                    this.f1401a.invalidate();
                }
                width = -width2;
            } else if (this.f1401a.a(view, 5)) {
                width = this.f1401a.getWidth();
                if (f < 0.0f || (f == 0.0f && d2 > 0.5f)) {
                    width -= width2;
                }
            } else {
                top = this.f1401a.getHeight() - view.getMinimumHeight();
                int unused = this.f1401a.af = 1;
                int top2 = this.d - view.getTop();
                if (top2 > this.f1401a.u) {
                    top = this.f1401a.getHeight() - height;
                    int unused2 = this.f1401a.af = 0;
                } else if (top2 < (-this.f1401a.u) && this.f1401a.y) {
                    top = this.f1401a.ac;
                    int unused3 = this.f1401a.af = 2;
                }
                this.c.a(left, top);
                this.f1401a.invalidate();
            }
            left = width;
            this.c.a(left, top);
            this.f1401a.invalidate();
        }

        public void onEdgeTouched(int i, int i2) {
            this.f1401a.postDelayed(this.e, 160);
        }

        public void onEdgeDragStarted(int i, int i2) {
            View view;
            if ((i & 1) == 1) {
                view = this.f1401a.b(3);
            } else if ((i & 2) == 2) {
                view = this.f1401a.b(5);
            } else {
                view = this.f1401a.b(80);
            }
            if (view != null && this.f1401a.a(view) == 0) {
                this.c.a(view, i2);
            }
        }

        public int getViewHorizontalDragRange(View view) {
            if (!this.f1401a.g(view) || this.f1401a.a(view, 80)) {
                return 0;
            }
            return view.getWidth();
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (this.f1401a.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            if (!this.f1401a.a(view, 5)) {
                return 0;
            }
            int width = this.f1401a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return Math.min(this.f1401a.getHeight(), Math.max(i, Math.max(this.f1401a.getHeight() - view.getHeight(), this.f1401a.r)));
        }
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f1399a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f1400b;
        boolean c;
        int d;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ColorDrawerLayout.f1397a);
            this.f1399a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public d(int i, int i2) {
            super(i, i2);
        }

        public d(d dVar) {
            super(dVar);
            this.f1399a = dVar.f1399a;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    static final class b extends androidx.core.g.a {
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.g.a.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (!ColorDrawerLayout.l(view)) {
                dVar.b((View) null);
            }
        }
    }

    public void setBottomDrawerActionOffset(int i2) {
        this.u = i2;
    }

    public int getBottomDrawerActionOffset() {
        return this.u;
    }

    public void a(int i2, float f2, boolean z2) {
        if (f2 == 1.0f) {
            a(i2, z2);
        } else if (f2 == 0.0f) {
            b(i2, z2);
        } else {
            View b2 = b(i2);
            if (b2 != null) {
                d dVar = (d) b2.getLayoutParams();
                this.af = 1;
                if (this.x) {
                    dVar.f1400b = f2;
                    dVar.d = 2;
                    c(b2, true);
                } else if (z2) {
                    dVar.d |= 2;
                    if (a(b2, 3)) {
                        this.k.a(b2, (int) (0.0f - (((float) b2.getWidth()) * f2)), b2.getTop());
                    } else if (a(b2, 5)) {
                        this.l.a(b2, (int) (((float) (getWidth() - b2.getWidth())) * f2), b2.getTop());
                    } else {
                        this.m.a(b2, b2.getPaddingLeft(), (int) (((float) getHeight()) - (((float) b2.getHeight()) * f2)));
                    }
                } else {
                    c(b2, f2);
                    a(dVar.f1399a, 0, b2);
                    b2.setVisibility(0);
                }
                invalidate();
                return;
            }
            throw new IllegalArgumentException("No drawer view found with gravity " + c(i2));
        }
    }

    public void setDragRect(Rect rect) {
        this.q = rect;
    }

    public int getSettlingDirection() {
        return this.af;
    }

    public void setOffsetMinTop(int i2) {
        this.r = i2;
    }

    public void setBlankClickedListener(a aVar) {
        this.ab = aVar;
    }
}
