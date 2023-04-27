package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.g.v;
import androidx.recyclerview.widget.RecyclerView;
import com.color.support.widget.e;
import com.color.support.widget.h;
import com.color.support.widget.m;
import com.color.support.widget.o;
import java.util.ArrayList;

public class ColorRecyclerView extends RecyclerView {
    private final int A;
    private a B;
    private final int[] C;
    private final int[] D;

    /* renamed from: a  reason: collision with root package name */
    boolean f1033a;

    /* renamed from: b  reason: collision with root package name */
    final int f1034b;
    final int c;
    final int d;
    final int e;
    private ArrayList<RecyclerView.m> f;
    private RecyclerView.m g;
    private boolean h;
    /* access modifiers changed from: private */
    public int i;
    private int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public m l;
    /* access modifiers changed from: private */
    public o m;
    private h n;
    /* access modifiers changed from: private */
    public e o;
    /* access modifiers changed from: private */
    public boolean p;
    private int q;
    private int r;
    private VelocityTracker s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private RecyclerView.l y;
    private final int z;

    public ColorRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1033a = true;
        this.f1034b = 0;
        this.c = 1;
        this.d = 2;
        this.e = 3;
        this.q = 0;
        this.r = -1;
        this.C = new int[2];
        this.D = new int[2];
        a();
        b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.x = viewConfiguration.getScaledTouchSlop();
        this.z = viewConfiguration.getScaledMinimumFlingVelocity();
        this.A = viewConfiguration.getScaledMaximumFlingVelocity();
        b(context);
        a(context);
        this.o = new e();
        this.o.a(this);
    }

    private void a() {
        if (this.B == null) {
            this.B = new a();
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        if (this.l == null) {
            this.m = new o(context);
            this.n = new h(context);
            setIsUseNativeOverScroll(false);
        }
    }

    private void b() {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
    }

    public void setHorizontalItemAlign(int i2) {
        if (g()) {
            setIsUseNativeOverScroll(true);
            this.o.a(i2);
        }
    }

    public int getHorizontalItemAlign() {
        return this.o.a();
    }

    public void setIsUseNativeOverScroll(boolean z2) {
        this.p = z2;
        if (this.p) {
            this.l = this.n;
        } else {
            this.l = this.m;
        }
    }

    public boolean getIsUseNativeOverScroll() {
        return this.p;
    }

    public void setHorizontalFlingFriction(float f2) {
        this.n.a(f2);
    }

    public void setLayoutManager(RecyclerView.i iVar) {
        super.setLayoutManager(iVar);
        if (iVar == null) {
            return;
        }
        if (iVar.canScrollHorizontally()) {
            this.m.d(3.2f);
        } else {
            this.m.d(2.15f);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("ColorRecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.x = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.x = viewConfiguration.getScaledTouchSlop();
    }

    public void setOnFlingListener(RecyclerView.l lVar) {
        this.y = lVar;
    }

    public RecyclerView.l getOnFlingListener() {
        return this.y;
    }

    public int getScrollState() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.q) {
            this.q = i2;
            if (i2 != 2) {
                d();
            }
            dispatchOnScrollStateChanged(i2);
        }
    }

    public void scrollBy(int i2, int i3) {
        if (this.mLayout == null) {
            Log.e("ColorRecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i2 = 0;
                }
                if (!canScrollVertically) {
                    i3 = 0;
                }
                scrollByInternal(i2, i3, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = i2;
        int i12 = i3;
        MotionEvent motionEvent2 = motionEvent;
        consumePendingUpdateOperations();
        if (this.mAdapter == null || ((i11 == 0 && i12 == 0) || (this.f1033a && ((getScrollY() < 0 && i12 > 0) || ((getScrollY() > 0 && i12 < 0) || ((getScrollX() < 0 && i11 > 0) || (getScrollX() > 0 && i11 < 0))))))) {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        } else {
            this.mReusableIntPair[0] = 0;
            this.mReusableIntPair[1] = 0;
            scrollStep(i11, i12, this.mReusableIntPair);
            int i13 = this.mReusableIntPair[0];
            int i14 = this.mReusableIntPair[1];
            i6 = i13;
            i7 = i14;
            i5 = i11 - i13;
            i4 = i12 - i14;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        this.mReusableIntPair[0] = 0;
        this.mReusableIntPair[1] = 0;
        int i15 = i7;
        int i16 = i6;
        dispatchNestedScroll(i6, i7, i5, i4, this.C, 0, this.mReusableIntPair);
        int i17 = i5 - this.mReusableIntPair[0];
        int i18 = i4 - this.mReusableIntPair[1];
        int i19 = this.v;
        int[] iArr = this.C;
        this.v = i19 - iArr[0];
        this.w -= iArr[1];
        if (motionEvent2 != null) {
            motionEvent2.offsetLocation((float) iArr[0], (float) iArr[1]);
        }
        int[] iArr2 = this.D;
        int i20 = iArr2[0];
        int[] iArr3 = this.C;
        iArr2[0] = i20 + iArr3[0];
        iArr2[1] = iArr2[1] + iArr3[1];
        if (getOverScrollMode() == 2 || motionEvent2 == null || !this.f1033a) {
            i8 = i16;
            i9 = i15;
        } else {
            if (!(i18 == 0 && i17 == 0)) {
                this.i = 2;
            }
            if (Math.abs(i18) == 0 && Math.abs(i15) < this.x && Math.abs(i3) < this.x && Math.abs(getScrollY()) > this.x) {
                this.i = 2;
            }
            if (i18 == 0) {
                i9 = i15;
                if (i9 == 0 && Math.abs(i3) > this.x) {
                    this.i = 2;
                }
            } else {
                i9 = i15;
            }
            if (Math.abs(i17) == 0 && Math.abs(i16) < this.x && Math.abs(i2) < this.x && Math.abs(getScrollX()) > this.x) {
                this.i = 2;
            }
            if (i17 == 0) {
                i10 = i16;
                if (i10 == 0 && Math.abs(i2) > this.x) {
                    this.i = 2;
                }
            } else {
                i10 = i16;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int a2 = com.color.support.a.a.a(i18, scrollY, this.j);
            int a3 = com.color.support.a.a.a(i17, scrollX, this.j);
            if ((scrollY < 0 && i12 > 0) || (scrollY > 0 && i12 < 0)) {
                a2 = com.color.support.a.a.a(i12, scrollX, this.j);
            }
            int i21 = a2;
            if ((scrollX < 0 && i11 > 0) || (scrollX > 0 && i11 < 0)) {
                a3 = com.color.support.a.a.a(i11, scrollX, this.j);
            }
            if (i21 == 0 && a3 == 0) {
                i8 = i10;
            } else {
                int i22 = this.j;
                i8 = i10;
                overScrollBy(a3, i21, scrollX, scrollY, 0, 0, i22, i22, true);
            }
        }
        if (!(i8 == 0 && i9 == 0)) {
            dispatchOnScrolled(i8, i9);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i8 == 0 && i9 == 0) {
            return false;
        }
        return true;
    }

    private void b(Context context) {
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        this.j = i2;
        this.k = i2;
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        if (getScrollY() != i3 || getScrollX() != i2) {
            onScrollChanged(i2, i3, getScrollX(), getScrollY());
            com.color.support.b.a.a.b(this, i2);
            com.color.support.b.a.a.a(this, i3);
            c();
            awakenScrollBars();
        }
    }

    private void c() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        int i10 = i2 + i4;
        int i11 = i3 + i5;
        if ((i4 < 0 && i10 > 0) || (i4 > 0 && i10 < 0)) {
            i10 = 0;
        }
        if ((i5 < 0 && i11 > 0) || (i5 > 0 && i11 < 0)) {
            i11 = 0;
        }
        onOverScrolled(i10, i11, false, false);
        return false;
    }

    public void computeScroll() {
        if (this.f1033a) {
            int i2 = this.i;
            if (i2 == 2 || i2 == 3) {
                o oVar = this.m;
                if (oVar.computeScrollOffset()) {
                    int scrollX = getScrollX();
                    int scrollY = getScrollY();
                    int b2 = oVar.b();
                    int c2 = oVar.c();
                    if (!(scrollX == b2 && scrollY == c2)) {
                        int i3 = this.k;
                        overScrollBy(b2 - scrollX, c2 - scrollY, scrollX, scrollY, 0, 0, i3, i3, false);
                        onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                    }
                    if (oVar.a()) {
                        setScrollState(0);
                    } else {
                        setScrollState(2);
                    }
                    if (!awakenScrollBars()) {
                        postInvalidateOnAnimation();
                    }
                }
            }
        }
    }

    public void setOverScrollEnable(boolean z2) {
        this.f1033a = z2;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, (Interpolator) null);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        if (this.mLayout == null) {
            Log.e("ColorRecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            if (!this.mLayout.canScrollHorizontally()) {
                i2 = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                this.B.a(i2, i3, Integer.MIN_VALUE, interpolator);
            }
        }
    }

    public boolean fling(int i2, int i3) {
        int i4 = 0;
        if (this.mLayout == null) {
            Log.e("ColorRecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i2) < this.z) {
                i2 = 0;
            }
            if (!canScrollVertically || Math.abs(i3) < this.z) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.m.a(getDisplay().getRefreshRate());
            float f2 = (float) i2;
            float f3 = (float) i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                this.i = 1;
                boolean z2 = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f2, f3, z2);
                RecyclerView.l lVar = this.y;
                if (lVar != null && lVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (canScrollHorizontally) {
                        i4 = 1;
                    }
                    if (canScrollVertically) {
                        i4 |= 2;
                    }
                    startNestedScroll(i4, 1);
                    int i5 = this.A;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.A;
                    this.B.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        d();
    }

    private void d() {
        a();
        this.B.b();
        if (this.mLayout != null) {
            this.mLayout.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.z;
    }

    public int getMaxFlingVelocity() {
        return this.A;
    }

    public void addOnItemTouchListener(RecyclerView.m mVar) {
        b();
        this.f.add(mVar);
    }

    public void removeOnItemTouchListener(RecyclerView.m mVar) {
        this.f.remove(mVar);
        if (this.g == mVar) {
            this.g = null;
        }
    }

    private boolean a(MotionEvent motionEvent) {
        RecyclerView.m mVar = this.g;
        if (mVar != null) {
            mVar.b(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.g = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return b(motionEvent);
        }
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f.size();
        int i2 = 0;
        while (i2 < size) {
            RecyclerView.m mVar = this.f.get(i2);
            if (!mVar.a(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.g = mVar;
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.g = null;
        if (b(motionEvent)) {
            f();
            return true;
        } else if (this.mLayout == null) {
            return false;
        } else {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (this.s == null) {
                this.s = VelocityTracker.obtain();
            }
            this.s.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                if (this.h) {
                    this.h = false;
                }
                this.r = motionEvent.getPointerId(0);
                int x2 = (int) (motionEvent.getX() + 0.5f);
                this.v = x2;
                this.t = x2;
                int y2 = (int) (motionEvent.getY() + 0.5f);
                this.w = y2;
                this.u = y2;
                if (this.q == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    stopNestedScroll(1);
                }
                int[] iArr = this.D;
                iArr[1] = 0;
                iArr[0] = 0;
                int i2 = canScrollHorizontally ? 1 : 0;
                if (canScrollVertically) {
                    i2 |= 2;
                }
                startNestedScroll(i2, 0);
            } else if (actionMasked == 1) {
                this.s.clear();
                stopNestedScroll(0);
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex < 0) {
                    Log.e("ColorRecyclerView", "Error processing scroll; pointer index for id " + this.r + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                if (this.q != 1) {
                    int i3 = x3 - this.t;
                    int i4 = y3 - this.u;
                    if (!canScrollHorizontally || Math.abs(i3) <= this.x) {
                        z2 = false;
                    } else {
                        this.v = x3;
                        z2 = true;
                    }
                    if (canScrollVertically && Math.abs(i4) > this.x) {
                        this.w = y3;
                        z2 = true;
                    }
                    if (z2) {
                        setScrollState(1);
                    }
                }
            } else if (actionMasked == 3) {
                f();
            } else if (actionMasked == 5) {
                this.r = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.v = x4;
                this.t = x4;
                int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.w = y4;
                this.u = y4;
            } else if (actionMasked == 6) {
                c(motionEvent);
            }
            if (this.q == 1) {
                return true;
            }
            return false;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        if (this.mLayoutSuppressed || this.h) {
            return false;
        }
        if (a(motionEvent)) {
            f();
            return true;
        } else if (this.mLayout == null) {
            return false;
        } else {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (this.s == null) {
                this.s = VelocityTracker.obtain();
            }
            if (this.f1033a) {
                this.s.addMovement(motionEvent);
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                int[] iArr = this.D;
                iArr[1] = 0;
                iArr[0] = 0;
            }
            int[] iArr2 = this.D;
            obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
            if (actionMasked == 0) {
                this.r = motionEvent.getPointerId(0);
                int x2 = (int) (motionEvent.getX() + 0.5f);
                this.v = x2;
                this.t = x2;
                int y2 = (int) (motionEvent.getY() + 0.5f);
                this.w = y2;
                this.u = y2;
                if ((!this.l.a() || !this.m.a()) && this.f1033a) {
                    this.l.abortAnimation();
                    this.m.abortAnimation();
                }
                int i6 = canScrollHorizontally ? 1 : 0;
                if (canScrollVertically) {
                    i6 |= 2;
                }
                startNestedScroll(i6, 0);
            } else if (actionMasked == 1) {
                if (!this.f1033a) {
                    this.s.addMovement(obtain);
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.s.computeCurrentVelocity(1000, (float) this.A);
                float f2 = canScrollHorizontally ? -this.s.getXVelocity(this.r) : 0.0f;
                float f3 = canScrollVertically ? -this.s.getYVelocity(this.r) : 0.0f;
                if (this.i != 2 || ((getScrollX() == 0 && getScrollY() == 0) || !this.f1033a)) {
                    if ((f2 == 0.0f && f3 == 0.0f) || !fling((int) f2, (int) f3)) {
                        setScrollState(0);
                    }
                } else if (this.m.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0)) {
                    this.m.a(getDisplay().getRefreshRate());
                    postInvalidateOnAnimation();
                    if (this.q != 0) {
                        this.q = 0;
                        dispatchOnScrollStateChanged(this.q);
                    }
                }
                e();
                if (!z2 && !this.f1033a) {
                    this.s.addMovement(obtain);
                }
                obtain.recycle();
                return true;
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex < 0) {
                    Log.e("ColorRecyclerView", "Error processing scroll; pointer index for id " + this.r + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                int i7 = this.v - x3;
                int i8 = this.w - y3;
                this.mReusableIntPair[0] = 0;
                this.mReusableIntPair[1] = 0;
                if (dispatchNestedPreScroll(i7, i8, this.mReusableIntPair, this.C, 0)) {
                    i7 -= this.mReusableIntPair[0];
                    i8 -= this.mReusableIntPair[1];
                    int[] iArr3 = this.C;
                    obtain.offsetLocation((float) iArr3[0], (float) iArr3[1]);
                    int[] iArr4 = this.D;
                    int i9 = iArr4[0];
                    int[] iArr5 = this.C;
                    iArr4[0] = i9 + iArr5[0];
                    iArr4[1] = iArr4[1] + iArr5[1];
                }
                if (this.q != 1) {
                    if (!canScrollHorizontally || Math.abs(i3) <= (i5 = this.x)) {
                        z3 = false;
                    } else {
                        i3 = i3 > 0 ? i3 - i5 : i3 + i5;
                        z3 = true;
                    }
                    if (canScrollVertically && Math.abs(i2) > (i4 = this.x)) {
                        i2 = i2 > 0 ? i2 - i4 : i2 + i4;
                        z3 = true;
                    }
                    if (z3) {
                        setScrollState(1);
                    }
                }
                if (this.q == 1) {
                    int[] iArr6 = this.C;
                    this.v = x3 - iArr6[0];
                    this.w = y3 - iArr6[1];
                    if (this.f1033a) {
                        this.i = 0;
                    }
                    if (scrollByInternal(canScrollHorizontally ? i3 : 0, canScrollVertically ? i2 : 0, obtain)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    if (!(this.mGapWorker == null || (i3 == 0 && i2 == 0))) {
                        this.mGapWorker.a((RecyclerView) this, i3, i2);
                    }
                }
            } else if (actionMasked == 3) {
                f();
            } else if (actionMasked == 5) {
                this.r = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.v = x4;
                this.t = x4;
                int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.w = y4;
                this.u = y4;
            } else if (actionMasked == 6) {
                c(motionEvent);
            }
            z2 = false;
            this.s.addMovement(obtain);
            obtain.recycle();
            return true;
        }
    }

    private void e() {
        VelocityTracker velocityTracker = this.s;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
    }

    private void f() {
        e();
        setScrollState(0);
        com.color.support.b.a.a.b(this, 0);
        com.color.support.b.a.a.a(this, 0);
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.r = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.v = x2;
            this.t = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.w = y2;
            this.u = y2;
        }
    }

    private boolean g() {
        return getLayoutManager() != null && (getLayoutManager() instanceof LinearLayoutManager) && ((LinearLayoutManager) getLayoutManager()).getOrientation() == 0;
    }

    public a getViewFlinger() {
        return this.B;
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Interpolator f1035a = RecyclerView.sQuinticInterpolator;
        private int c;
        private int d;
        private boolean e = false;
        private boolean f = false;

        a() {
        }

        public void run() {
            int i;
            int i2;
            if (ColorRecyclerView.this.mLayout == null) {
                b();
                return;
            }
            this.f = false;
            this.e = true;
            ColorRecyclerView.this.consumePendingUpdateOperations();
            m a2 = ColorRecyclerView.this.l;
            if (a2.computeScrollOffset()) {
                int b2 = a2.b();
                int c2 = a2.c();
                int i3 = b2 - this.c;
                int i4 = c2 - this.d;
                this.c = b2;
                this.d = c2;
                ColorRecyclerView.this.mReusableIntPair[0] = 0;
                ColorRecyclerView.this.mReusableIntPair[1] = 0;
                ColorRecyclerView colorRecyclerView = ColorRecyclerView.this;
                if (colorRecyclerView.dispatchNestedPreScroll(i3, i4, colorRecyclerView.mReusableIntPair, (int[]) null, 1)) {
                    i3 -= ColorRecyclerView.this.mReusableIntPair[0];
                    i4 -= ColorRecyclerView.this.mReusableIntPair[1];
                }
                if (ColorRecyclerView.this.mAdapter != null) {
                    ColorRecyclerView.this.mReusableIntPair[0] = 0;
                    ColorRecyclerView.this.mReusableIntPair[1] = 0;
                    ColorRecyclerView colorRecyclerView2 = ColorRecyclerView.this;
                    colorRecyclerView2.scrollStep(i3, i4, colorRecyclerView2.mReusableIntPair);
                    i2 = ColorRecyclerView.this.mReusableIntPair[0];
                    i = ColorRecyclerView.this.mReusableIntPair[1];
                    i3 -= i2;
                    i4 -= i;
                    RecyclerView.s sVar = ColorRecyclerView.this.mLayout.mSmoothScroller;
                    if (sVar != null && !sVar.isPendingInitialRun() && sVar.isRunning()) {
                        int e2 = ColorRecyclerView.this.mState.e();
                        if (e2 == 0) {
                            sVar.stop();
                        } else if (sVar.getTargetPosition() >= e2) {
                            sVar.setTargetPosition(e2 - 1);
                            sVar.onAnimation(i2, i);
                        } else {
                            sVar.onAnimation(i2, i);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!ColorRecyclerView.this.mItemDecorations.isEmpty()) {
                    ColorRecyclerView.this.invalidate();
                }
                ColorRecyclerView.this.mReusableIntPair[0] = 0;
                ColorRecyclerView.this.mReusableIntPair[1] = 0;
                ColorRecyclerView colorRecyclerView3 = ColorRecyclerView.this;
                colorRecyclerView3.dispatchNestedScroll(i2, i, i3, i4, (int[]) null, 1, colorRecyclerView3.mReusableIntPair);
                int i5 = i3 - ColorRecyclerView.this.mReusableIntPair[0];
                int i6 = i4 - ColorRecyclerView.this.mReusableIntPair[1];
                if (!(i2 == 0 && i == 0)) {
                    ColorRecyclerView.this.dispatchOnScrolled(i2, i);
                }
                if (i6 != 0 && ColorRecyclerView.this.f1033a) {
                    int unused = ColorRecyclerView.this.i = 3;
                    ColorRecyclerView colorRecyclerView4 = ColorRecyclerView.this;
                    colorRecyclerView4.overScrollBy(0, i6, 0, colorRecyclerView4.getScrollY(), 0, 0, 0, ColorRecyclerView.this.k, false);
                    if (ColorRecyclerView.this.p) {
                        ColorRecyclerView.this.m.c(a2.g());
                        ColorRecyclerView.this.m.notifyVerticalEdgeReached(ColorRecyclerView.this.getScrollY(), 0, ColorRecyclerView.this.k);
                    } else {
                        ColorRecyclerView.this.l.notifyVerticalEdgeReached(ColorRecyclerView.this.getScrollY(), 0, ColorRecyclerView.this.k);
                    }
                }
                if (i5 != 0 && ColorRecyclerView.this.f1033a) {
                    int unused2 = ColorRecyclerView.this.i = 3;
                    ColorRecyclerView colorRecyclerView5 = ColorRecyclerView.this;
                    colorRecyclerView5.overScrollBy(i5, 0, colorRecyclerView5.getScrollX(), 0, 0, 0, ColorRecyclerView.this.k, 0, false);
                    if (ColorRecyclerView.this.p) {
                        ColorRecyclerView.this.m.b(a2.f());
                        ColorRecyclerView.this.m.notifyHorizontalEdgeReached(ColorRecyclerView.this.getScrollX(), 0, ColorRecyclerView.this.k);
                    } else {
                        ColorRecyclerView.this.l.notifyHorizontalEdgeReached(ColorRecyclerView.this.getScrollX(), 0, ColorRecyclerView.this.k);
                    }
                }
                if (!ColorRecyclerView.this.awakenScrollBars()) {
                    ColorRecyclerView.this.invalidate();
                }
                boolean z = a2.a() || (((a2.b() == a2.d()) || i5 != 0) && ((a2.c() == a2.e()) || i6 != 0));
                RecyclerView.s sVar2 = ColorRecyclerView.this.mLayout.mSmoothScroller;
                if ((sVar2 != null && sVar2.isPendingInitialRun()) || !z) {
                    a();
                    if (ColorRecyclerView.this.mGapWorker != null) {
                        ColorRecyclerView.this.mGapWorker.a((RecyclerView) ColorRecyclerView.this, i2, i);
                    }
                } else if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    ColorRecyclerView.this.mPrefetchRegistry.a();
                }
            }
            RecyclerView.s sVar3 = ColorRecyclerView.this.mLayout.mSmoothScroller;
            if (sVar3 != null && sVar3.isPendingInitialRun()) {
                sVar3.onAnimation(0, 0);
            }
            this.e = false;
            if (this.f) {
                c();
            } else if (ColorRecyclerView.this.i != 3 || !ColorRecyclerView.this.f1033a) {
                ColorRecyclerView.this.setScrollState(0);
                ColorRecyclerView.this.stopNestedScroll(1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.e) {
                this.f = true;
            } else {
                c();
            }
        }

        private void c() {
            ColorRecyclerView.this.removeCallbacks(this);
            v.a((View) ColorRecyclerView.this, (Runnable) this);
        }

        public void a(int i, int i2) {
            ColorRecyclerView.this.setScrollState(2);
            this.d = 0;
            this.c = 0;
            if (this.f1035a != RecyclerView.sQuinticInterpolator) {
                this.f1035a = RecyclerView.sQuinticInterpolator;
                ColorRecyclerView.this.l.a(RecyclerView.sQuinticInterpolator);
            }
            ColorRecyclerView.this.l.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            ColorRecyclerView.this.l.a(ColorRecyclerView.this.o.b(ColorRecyclerView.this.l.d()));
            a();
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f1035a != interpolator) {
                this.f1035a = interpolator;
                ColorRecyclerView.this.l.a(interpolator);
            }
            this.d = 0;
            this.c = 0;
            ColorRecyclerView.this.setScrollState(2);
            ColorRecyclerView.this.l.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                ColorRecyclerView.this.l.computeScrollOffset();
            }
            a();
        }

        private float a(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        private int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? ColorRecyclerView.this.getWidth() : ColorRecyclerView.this.getHeight();
            int i6 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i6;
            float a2 = f3 + (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void b() {
            ColorRecyclerView.this.removeCallbacks(this);
            ColorRecyclerView colorRecyclerView = ColorRecyclerView.this;
            colorRecyclerView.a(colorRecyclerView.getContext());
            ColorRecyclerView.this.l.abortAnimation();
            ColorRecyclerView.this.m.abortAnimation();
        }
    }
}
