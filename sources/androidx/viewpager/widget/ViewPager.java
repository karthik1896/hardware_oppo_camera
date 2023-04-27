package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.g.ad;
import androidx.core.g.q;
import androidx.core.g.v;
import androidx.customview.view.AbsSavedState;
import com.oppo.exif.OppoExifTag;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1344a = {16842931};
    private static final i ai = new i();
    private static final Comparator<b> e = new Comparator<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.f1350b - bVar2.f1350b;
        }
    };
    private static final Interpolator f = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int A = 1;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K = -1;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private EdgeEffect R;
    private EdgeEffect S;
    private boolean T = true;
    private boolean U = false;
    private boolean V;
    private int W;
    private List<f> aa;
    private f ab;
    private f ac;
    private List<e> ad;
    private g ae;
    private int af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.c();
        }
    };
    private int ak = 0;

    /* renamed from: b  reason: collision with root package name */
    a f1345b;
    int c;
    private int d;
    private final ArrayList<b> g = new ArrayList<>();
    private final b h = new b();
    private final Rect i = new Rect();
    private int j = -1;
    private Parcelable k = null;
    private ClassLoader l = null;
    private Scroller m;
    private boolean n;
    private h o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t = -3.4028235E38f;
    private float u = Float.MAX_VALUE;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    public interface e {
        void onAdapterChanged(ViewPager viewPager, a aVar, a aVar2);
    }

    public interface f {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public interface g {
        void a(View view, float f);
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        Object f1349a;

        /* renamed from: b  reason: collision with root package name */
        int f1350b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setWillNotDraw(false);
        setDescendantFocusability(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.F = viewConfiguration.getScaledPagingTouchSlop();
        this.M = (int) (400.0f * f2);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context);
        this.S = new EdgeEffect(context);
        this.O = (int) (25.0f * f2);
        this.P = (int) (2.0f * f2);
        this.D = (int) (f2 * 16.0f);
        v.a((View) this, (androidx.core.g.a) new d());
        if (v.f(this) == 0) {
            v.b((View) this, 1);
        }
        v.a((View) this, (q) new q() {

            /* renamed from: b  reason: collision with root package name */
            private final Rect f1348b = new Rect();

            public ad onApplyWindowInsets(View view, ad adVar) {
                ad a2 = v.a(view, adVar);
                if (a2.f()) {
                    return a2;
                }
                Rect rect = this.f1348b;
                rect.left = a2.a();
                rect.top = a2.b();
                rect.right = a2.c();
                rect.bottom = a2.d();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ad b2 = v.b(ViewPager.this.getChildAt(i), a2);
                    rect.left = Math.min(b2.a(), rect.left);
                    rect.top = Math.min(b2.b(), rect.top);
                    rect.right = Math.min(b2.c(), rect.right);
                    rect.bottom = Math.min(b2.d(), rect.bottom);
                }
                return a2.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        Scroller scroller = this.m;
        if (scroller != null && !scroller.isFinished()) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (this.ak != i2) {
            this.ak = i2;
            if (this.ae != null) {
                b(i2 != 0);
            }
            f(i2);
        }
    }

    public void setAdapter(a aVar) {
        a aVar2 = this.f1345b;
        if (aVar2 != null) {
            aVar2.c((DataSetObserver) null);
            this.f1345b.a((ViewGroup) this);
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                b bVar = this.g.get(i2);
                this.f1345b.a((ViewGroup) this, bVar.f1350b, bVar.f1349a);
            }
            this.f1345b.b((ViewGroup) this);
            this.g.clear();
            f();
            this.c = 0;
            scrollTo(0, 0);
        }
        a aVar3 = this.f1345b;
        this.f1345b = aVar;
        this.d = 0;
        if (this.f1345b != null) {
            if (this.o == null) {
                this.o = new h();
            }
            this.f1345b.c(this.o);
            this.z = false;
            boolean z2 = this.T;
            this.T = true;
            this.d = this.f1345b.a();
            if (this.j >= 0) {
                this.f1345b.a(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (!z2) {
                c();
            } else {
                requestLayout();
            }
        }
        List<e> list = this.ad;
        if (list != null && !list.isEmpty()) {
            int size = this.ad.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.ad.get(i3).onAdapterChanged(this, aVar3, aVar);
            }
        }
    }

    private void f() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f1351a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public a getAdapter() {
        return this.f1345b;
    }

    public void a(e eVar) {
        if (this.ad == null) {
            this.ad = new ArrayList();
        }
        this.ad.add(eVar);
    }

    public void b(e eVar) {
        List<e> list = this.ad;
        if (list != null) {
            list.remove(eVar);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i2) {
        this.z = false;
        a(i2, !this.T, false);
    }

    public void a(int i2, boolean z2) {
        this.z = false;
        a(i2, z2, false);
    }

    public int getCurrentItem() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, boolean z3) {
        a(i2, z2, z3, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, boolean z3, int i3) {
        a aVar = this.f1345b;
        if (aVar == null || aVar.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.c != i2 || this.g.size() == 0) {
            boolean z4 = true;
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f1345b.a()) {
                i2 = this.f1345b.a() - 1;
            }
            int i4 = this.A;
            int i5 = this.c;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.g.size(); i6++) {
                    this.g.get(i6).c = true;
                }
            }
            if (this.c == i2) {
                z4 = false;
            }
            if (this.T) {
                this.c = i2;
                if (z4) {
                    e(i2);
                }
                requestLayout();
                return;
            }
            a(i2);
            a(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i2, boolean z2, int i3, boolean z3) {
        b b2 = b(i2);
        int clientWidth = b2 != null ? (int) (((float) getClientWidth()) * Math.max(this.t, Math.min(b2.e, this.u))) : 0;
        if (z2) {
            a(clientWidth, 0, i3);
            if (z3) {
                e(i2);
                return;
            }
            return;
        }
        if (z3) {
            e(i2);
        }
        a(false);
        scrollTo(clientWidth, 0);
        d(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.ab = fVar;
    }

    public void a(f fVar) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(fVar);
    }

    public void b(f fVar) {
        List<f> list = this.aa;
        if (list != null) {
            list.remove(fVar);
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.ag == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.ah.get(i3).getLayoutParams()).f;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to " + 1);
            i2 = 1;
        }
        if (i2 != this.A) {
            this.A = i2;
            c();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.p;
        this.p = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.content.a.a(getContext(), i2));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public float a(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.m;
        if (scroller != null && !scroller.isFinished()) {
            i5 = this.n ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i5 = getScrollX();
        }
        int i7 = i5;
        int scrollY = getScrollY();
        int i8 = i2 - i7;
        int i9 = i3 - scrollY;
        if (i8 == 0 && i9 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f2 = (float) clientWidth;
        float f3 = (float) i10;
        float a2 = f3 + (a(Math.min(1.0f, (((float) Math.abs(i8)) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        if (abs > 0) {
            i6 = Math.round(Math.abs(a2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i6 = (int) (((((float) Math.abs(i8)) / ((f2 * this.f1345b.b(this.c)) + ((float) this.p))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i6, 600);
        this.n = false;
        this.m.startScroll(i7, scrollY, i8, i9, min);
        v.e(this);
    }

    /* access modifiers changed from: package-private */
    public b a(int i2, int i3) {
        b bVar = new b();
        bVar.f1350b = i2;
        bVar.f1349a = this.f1345b.a((ViewGroup) this, i2);
        bVar.d = this.f1345b.b(i2);
        if (i3 < 0 || i3 >= this.g.size()) {
            this.g.add(bVar);
        } else {
            this.g.add(i3, bVar);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int a2 = this.f1345b.a();
        this.d = a2;
        boolean z2 = this.g.size() < (this.A * 2) + 1 && this.g.size() < a2;
        int i2 = this.c;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.g.size()) {
            b bVar = this.g.get(i3);
            int a3 = this.f1345b.a(bVar.f1349a);
            if (a3 != -1) {
                if (a3 == -2) {
                    this.g.remove(i3);
                    i3--;
                    if (!z3) {
                        this.f1345b.a((ViewGroup) this);
                        z3 = true;
                    }
                    this.f1345b.a((ViewGroup) this, bVar.f1350b, bVar.f1349a);
                    if (this.c == bVar.f1350b) {
                        i2 = Math.max(0, Math.min(this.c, a2 - 1));
                    }
                } else if (bVar.f1350b != a3) {
                    if (bVar.f1350b == this.c) {
                        i2 = a3;
                    }
                    bVar.f1350b = a3;
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.f1345b.b((ViewGroup) this);
        }
        Collections.sort(this.g, e);
        if (z2) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                if (!cVar.f1351a) {
                    cVar.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a(this.c);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (r8.f1350b == r0.c) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.c
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$b r2 = r0.b((int) r2)
            r0.c = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.a r1 = r0.f1345b
            if (r1 != 0) goto L_0x0018
            r17.g()
            return
        L_0x0018:
            boolean r1 = r0.z
            if (r1 == 0) goto L_0x0020
            r17.g()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.viewpager.widget.a r1 = r0.f1345b
            r1.a((android.view.ViewGroup) r0)
            int r1 = r0.A
            int r4 = r0.c
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.a r6 = r0.f1345b
            int r6 = r6.a()
            int r7 = r6 + -1
            int r8 = r0.c
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.d
            if (r6 != r7) goto L_0x0215
            r7 = r5
        L_0x004a:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r8 = r0.g
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x006a
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r8 = r0.g
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$b r8 = (androidx.viewpager.widget.ViewPager.b) r8
            int r9 = r8.f1350b
            int r10 = r0.c
            if (r9 < r10) goto L_0x0067
            int r9 = r8.f1350b
            int r10 = r0.c
            if (r9 != r10) goto L_0x006a
            goto L_0x006b
        L_0x0067:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x006a:
            r8 = 0
        L_0x006b:
            if (r8 != 0) goto L_0x0075
            if (r6 <= 0) goto L_0x0075
            int r8 = r0.c
            androidx.viewpager.widget.ViewPager$b r8 = r0.a((int) r8, (int) r7)
        L_0x0075:
            r9 = 0
            if (r8 == 0) goto L_0x01a2
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0085
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r11 = r0.g
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$b r11 = (androidx.viewpager.widget.ViewPager.b) r11
            goto L_0x0086
        L_0x0085:
            r11 = 0
        L_0x0086:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x0090
            r3 = r9
            goto L_0x009d
        L_0x0090:
            float r14 = r8.d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r3 = r14 + r15
        L_0x009d:
            int r14 = r0.c
            int r14 = r14 + -1
            r15 = r10
            r10 = r7
            r7 = r9
        L_0x00a4:
            if (r14 < 0) goto L_0x0104
            int r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00d2
            if (r14 >= r4) goto L_0x00d2
            if (r11 != 0) goto L_0x00af
            goto L_0x0104
        L_0x00af:
            int r5 = r11.f1350b
            if (r14 != r5) goto L_0x0100
            boolean r5 = r11.c
            if (r5 != 0) goto L_0x0100
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            r5.remove(r15)
            androidx.viewpager.widget.a r5 = r0.f1345b
            java.lang.Object r11 = r11.f1349a
            r5.a((android.view.ViewGroup) r0, (int) r14, (java.lang.Object) r11)
            int r15 = r15 + -1
            int r10 = r10 + -1
            if (r15 < 0) goto L_0x00fe
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r15)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x00ff
        L_0x00d2:
            if (r11 == 0) goto L_0x00e8
            int r5 = r11.f1350b
            if (r14 != r5) goto L_0x00e8
            float r5 = r11.d
            float r7 = r7 + r5
            int r15 = r15 + -1
            if (r15 < 0) goto L_0x00fe
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r15)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x00ff
        L_0x00e8:
            int r5 = r15 + 1
            androidx.viewpager.widget.ViewPager$b r5 = r0.a((int) r14, (int) r5)
            float r5 = r5.d
            float r7 = r7 + r5
            int r10 = r10 + 1
            if (r15 < 0) goto L_0x00fe
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r15)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x00ff
        L_0x00fe:
            r5 = 0
        L_0x00ff:
            r11 = r5
        L_0x0100:
            int r14 = r14 + -1
            r5 = 0
            goto L_0x00a4
        L_0x0104:
            float r3 = r8.d
            int r4 = r10 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0196
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x011d
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x011e
        L_0x011d:
            r5 = 0
        L_0x011e:
            if (r12 > 0) goto L_0x0122
            r7 = r9
            goto L_0x012a
        L_0x0122:
            int r7 = r17.getPaddingRight()
            float r7 = (float) r7
            float r11 = (float) r12
            float r7 = r7 / r11
            float r7 = r7 + r13
        L_0x012a:
            int r11 = r0.c
        L_0x012c:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x0196
            int r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r12 < 0) goto L_0x0160
            if (r11 <= r1) goto L_0x0160
            if (r5 != 0) goto L_0x0139
            goto L_0x0196
        L_0x0139:
            int r12 = r5.f1350b
            if (r11 != r12) goto L_0x0195
            boolean r12 = r5.c
            if (r12 != 0) goto L_0x0195
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r12 = r0.g
            r12.remove(r4)
            androidx.viewpager.widget.a r12 = r0.f1345b
            java.lang.Object r5 = r5.f1349a
            r12.a((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x0195
        L_0x015e:
            r5 = 0
            goto L_0x0195
        L_0x0160:
            if (r5 == 0) goto L_0x017c
            int r12 = r5.f1350b
            if (r11 != r12) goto L_0x017c
            float r5 = r5.d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x0195
        L_0x017c:
            androidx.viewpager.widget.ViewPager$b r5 = r0.a((int) r11, (int) r4)
            int r4 = r4 + 1
            float r5 = r5.d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.g
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
        L_0x0195:
            goto L_0x012c
        L_0x0196:
            r0.a((androidx.viewpager.widget.ViewPager.b) r8, (int) r10, (androidx.viewpager.widget.ViewPager.b) r2)
            androidx.viewpager.widget.a r1 = r0.f1345b
            int r2 = r0.c
            java.lang.Object r3 = r8.f1349a
            r1.b((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
        L_0x01a2:
            androidx.viewpager.widget.a r1 = r0.f1345b
            r1.b((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01ac:
            if (r2 >= r1) goto L_0x01d5
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r4 = (androidx.viewpager.widget.ViewPager.c) r4
            r4.f = r2
            boolean r5 = r4.f1351a
            if (r5 != 0) goto L_0x01d2
            float r5 = r4.c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01d2
            androidx.viewpager.widget.ViewPager$b r3 = r0.a((android.view.View) r3)
            if (r3 == 0) goto L_0x01d2
            float r5 = r3.d
            r4.c = r5
            int r3 = r3.f1350b
            r4.e = r3
        L_0x01d2:
            int r2 = r2 + 1
            goto L_0x01ac
        L_0x01d5:
            r17.g()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x0214
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01e9
            androidx.viewpager.widget.ViewPager$b r3 = r0.b((android.view.View) r1)
            goto L_0x01ea
        L_0x01e9:
            r3 = 0
        L_0x01ea:
            if (r3 == 0) goto L_0x01f2
            int r1 = r3.f1350b
            int r2 = r0.c
            if (r1 == r2) goto L_0x0214
        L_0x01f2:
            r1 = 0
        L_0x01f3:
            int r2 = r17.getChildCount()
            if (r1 >= r2) goto L_0x0214
            android.view.View r2 = r0.getChildAt(r1)
            androidx.viewpager.widget.ViewPager$b r3 = r0.a((android.view.View) r2)
            if (r3 == 0) goto L_0x0211
            int r3 = r3.f1350b
            int r4 = r0.c
            if (r3 != r4) goto L_0x0211
            r3 = 2
            boolean r2 = r2.requestFocus(r3)
            if (r2 == 0) goto L_0x0211
            goto L_0x0214
        L_0x0211:
            int r1 = r1 + 1
            goto L_0x01f3
        L_0x0214:
            return
        L_0x0215:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0222 }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0222 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0222 }
            goto L_0x022a
        L_0x0222:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x022a:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.d
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.a r1 = r0.f1345b
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int):void");
    }

    private void g() {
        if (this.ag != 0) {
            ArrayList<View> arrayList = this.ah;
            if (arrayList == null) {
                this.ah = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ah.add(getChildAt(i2));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int a2 = this.f1345b.a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.p) / ((float) clientWidth) : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.f1350b;
            if (i3 < bVar.f1350b) {
                float f3 = bVar2.e + bVar2.d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.f1350b && i5 < this.g.size()) {
                    Object obj = this.g.get(i5);
                    while (true) {
                        bVar4 = (b) obj;
                        if (i4 > bVar4.f1350b && i5 < this.g.size() - 1) {
                            i5++;
                            obj = this.g.get(i5);
                        }
                    }
                    while (i4 < bVar4.f1350b) {
                        f3 += this.f1345b.b(i4) + f2;
                        i4++;
                    }
                    bVar4.e = f3;
                    f3 += bVar4.d + f2;
                    i4++;
                }
            } else if (i3 > bVar.f1350b) {
                int size = this.g.size() - 1;
                float f4 = bVar2.e;
                while (true) {
                    i3--;
                    if (i3 < bVar.f1350b || size < 0) {
                        break;
                    }
                    Object obj2 = this.g.get(size);
                    while (true) {
                        bVar3 = (b) obj2;
                        if (i3 < bVar3.f1350b && size > 0) {
                            size--;
                            obj2 = this.g.get(size);
                        }
                    }
                    while (i3 > bVar3.f1350b) {
                        f4 -= this.f1345b.b(i3) + f2;
                        i3--;
                    }
                    f4 -= bVar3.d + f2;
                    bVar3.e = f4;
                }
            }
        }
        int size2 = this.g.size();
        float f5 = bVar.e;
        int i6 = bVar.f1350b - 1;
        this.t = bVar.f1350b == 0 ? bVar.e : -3.4028235E38f;
        int i7 = a2 - 1;
        this.u = bVar.f1350b == i7 ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            b bVar5 = this.g.get(i8);
            while (i6 > bVar5.f1350b) {
                f5 -= this.f1345b.b(i6) + f2;
                i6--;
            }
            f5 -= bVar5.d + f2;
            bVar5.e = f5;
            if (bVar5.f1350b == 0) {
                this.t = f5;
            }
            i8--;
            i6--;
        }
        float f6 = bVar.e + bVar.d + f2;
        int i9 = bVar.f1350b + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            b bVar6 = this.g.get(i10);
            while (i9 < bVar6.f1350b) {
                f6 += this.f1345b.b(i9) + f2;
                i9++;
            }
            if (bVar6.f1350b == i7) {
                this.u = (bVar6.d + f6) - 1.0f;
            }
            bVar6.e = f6;
            f6 += bVar6.d + f2;
            i10++;
            i9++;
        }
        this.U = false;
    }

    public static class SavedState extends AbsSavedState {
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
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.c;
        a aVar = this.f1345b;
        if (aVar != null) {
            savedState.adapterState = aVar.b();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a aVar = this.f1345b;
        if (aVar != null) {
            aVar.a(savedState.adapterState, savedState.loader);
            a(savedState.position, false, true);
            return;
        }
        this.j = savedState.position;
        this.k = savedState.adapterState;
        this.l = savedState.loader;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.f1351a |= c(view);
        if (!this.x) {
            super.addView(view, i2, layoutParams);
        } else if (cVar == null || !cVar.f1351a) {
            cVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    public b a(View view) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (this.f1345b.a(view, bVar.f1349a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public b b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    public b b(int i2) {
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            b bVar = this.g.get(i3);
            if (bVar.f1350b == i2) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        boolean z2 = false;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.E = Math.min(measuredWidth / 10, this.D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i7 = measuredHeight;
        int i8 = paddingLeft;
        int i9 = 0;
        while (true) {
            boolean z3 = true;
            int i10 = 1073741824;
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            if (!(childAt.getVisibility() == 8 || (cVar2 = (c) childAt.getLayoutParams()) == null || !cVar2.f1351a)) {
                int i11 = cVar2.f1352b & 7;
                int i12 = cVar2.f1352b & 112;
                boolean z4 = (i12 == 48 || i12 == 80) ? true : z2;
                if (!(i11 == 3 || i11 == 5)) {
                    z3 = z2;
                }
                int i13 = Integer.MIN_VALUE;
                if (z4) {
                    i4 = Integer.MIN_VALUE;
                    i13 = 1073741824;
                } else {
                    i4 = z3 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (cVar2.width != -2) {
                    i5 = cVar2.width != -1 ? cVar2.width : i8;
                    i13 = 1073741824;
                } else {
                    i5 = i8;
                }
                if (cVar2.height != -2) {
                    i6 = cVar2.height != -1 ? cVar2.height : i7;
                } else {
                    i6 = i7;
                    i10 = i4;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i13), View.MeasureSpec.makeMeasureSpec(i6, i10));
                if (z4) {
                    i7 -= childAt.getMeasuredHeight();
                } else if (z3) {
                    i8 -= childAt.getMeasuredWidth();
                }
            }
            i9++;
            z2 = false;
        }
        this.v = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        this.w = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        this.x = true;
        c();
        this.x = false;
        int childCount2 = getChildCount();
        for (int i14 = 0; i14 < childCount2; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.f1351a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) i8) * cVar.c), 1073741824), this.w);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.p;
            a(i2, i4, i6, i6);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.g.isEmpty()) {
            b b2 = b(this.c);
            int min = (int) ((b2 != null ? Math.min(b2.e, this.u) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.m.isFinished()) {
            this.m.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        b a2;
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i10 = paddingBottom;
        int i11 = 0;
        int i12 = paddingTop;
        int i13 = paddingLeft;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1351a) {
                    int i15 = cVar.f1352b & 7;
                    int i16 = cVar.f1352b & 112;
                    if (i15 == 1) {
                        i6 = Math.max((i8 - childAt.getMeasuredWidth()) / 2, i13);
                    } else if (i15 == 3) {
                        i6 = i13;
                        i13 = childAt.getMeasuredWidth() + i13;
                    } else if (i15 != 5) {
                        i6 = i13;
                    } else {
                        i6 = (i8 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i16 == 16) {
                        i7 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, i12);
                    } else if (i16 == 48) {
                        i7 = i12;
                        i12 = childAt.getMeasuredHeight() + i12;
                    } else if (i16 != 80) {
                        i7 = i12;
                    } else {
                        i7 = (i9 - i10) - childAt.getMeasuredHeight();
                        i10 += childAt.getMeasuredHeight();
                    }
                    int i17 = i6 + scrollX;
                    childAt.layout(i17, i7, childAt.getMeasuredWidth() + i17, i7 + childAt.getMeasuredHeight());
                    i11++;
                }
            }
        }
        int i18 = (i8 - i13) - paddingRight;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f1351a && (a2 = a(childAt2)) != null) {
                    float f2 = (float) i18;
                    int i20 = ((int) (a2.e * f2)) + i13;
                    if (cVar2.d) {
                        cVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.c), 1073741824), View.MeasureSpec.makeMeasureSpec((i9 - i12) - i10, 1073741824));
                    }
                    childAt2.layout(i20, i12, childAt2.getMeasuredWidth() + i20, childAt2.getMeasuredHeight() + i12);
                }
            }
        }
        this.r = i12;
        this.s = i9 - i10;
        this.W = i11;
        if (this.T) {
            z3 = false;
            a(this.c, false, 0, false);
        } else {
            z3 = false;
        }
        this.T = z3;
    }

    public void computeScroll() {
        this.n = true;
        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.m.getCurrX();
        int currY = this.m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        v.e(this);
    }

    private boolean d(int i2) {
        if (this.g.size() != 0) {
            b i3 = i();
            int clientWidth = getClientWidth();
            int i4 = this.p;
            int i5 = clientWidth + i4;
            float f2 = (float) clientWidth;
            int i6 = i3.f1350b;
            float f3 = ((((float) i2) / f2) - i3.e) / (i3.d + (((float) i4) / f2));
            this.V = false;
            a(i6, f3, (int) (((float) i5) * f3));
            if (this.V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.T) {
            return false;
        } else {
            this.V = false;
            a(0, 0.0f, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.W
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = r1
        L_0x001d:
            if (r3 >= r6) goto L_0x006d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r9 = (androidx.viewpager.widget.ViewPager.c) r9
            boolean r10 = r9.f1351a
            if (r10 != 0) goto L_0x002e
            goto L_0x006a
        L_0x002e:
            int r9 = r9.f1352b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004f
            r10 = 3
            if (r9 == r10) goto L_0x0049
            r10 = 5
            if (r9 == r10) goto L_0x003c
            r9 = r4
            goto L_0x005e
        L_0x003c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L_0x005b
        L_0x0049:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L_0x005e
        L_0x004f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L_0x005b:
            r11 = r9
            r9 = r4
            r4 = r11
        L_0x005e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L_0x0069
            r8.offsetLeftAndRight(r4)
        L_0x0069:
            r4 = r9
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x006d:
            r12.b(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$g r13 = r12.ae
            if (r13 == 0) goto L_0x00a1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007c:
            if (r1 >= r14) goto L_0x00a1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r0 = (androidx.viewpager.widget.ViewPager.c) r0
            boolean r0 = r0.f1351a
            if (r0 == 0) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$g r3 = r12.ae
            r3.a(r15, r0)
        L_0x009e:
            int r1 = r1 + 1
            goto L_0x007c
        L_0x00a1:
            r12.V = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int, float, int):void");
    }

    private void b(int i2, float f2, int i3) {
        f fVar = this.ab;
        if (fVar != null) {
            fVar.onPageScrolled(i2, f2, i3);
        }
        List<f> list = this.aa;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar2 = this.aa.get(i4);
                if (fVar2 != null) {
                    fVar2.onPageScrolled(i2, f2, i3);
                }
            }
        }
        f fVar3 = this.ac;
        if (fVar3 != null) {
            fVar3.onPageScrolled(i2, f2, i3);
        }
    }

    private void e(int i2) {
        f fVar = this.ab;
        if (fVar != null) {
            fVar.onPageSelected(i2);
        }
        List<f> list = this.aa;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar2 = this.aa.get(i3);
                if (fVar2 != null) {
                    fVar2.onPageSelected(i2);
                }
            }
        }
        f fVar3 = this.ac;
        if (fVar3 != null) {
            fVar3.onPageSelected(i2);
        }
    }

    private void f(int i2) {
        f fVar = this.ab;
        if (fVar != null) {
            fVar.onPageScrollStateChanged(i2);
        }
        List<f> list = this.aa;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar2 = this.aa.get(i3);
                if (fVar2 != null) {
                    fVar2.onPageScrollStateChanged(i2);
                }
            }
        }
        f fVar3 = this.ac;
        if (fVar3 != null) {
            fVar3.onPageScrollStateChanged(i2);
        }
    }

    private void a(boolean z2) {
        boolean z3 = this.ak == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.m.isFinished()) {
                this.m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.z = false;
        boolean z4 = z3;
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.c) {
                bVar.c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z2) {
            v.a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.E) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.E)) && f3 < 0.0f);
    }

    private void b(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z2 ? this.af : 0, (Paint) null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            h();
            return false;
        }
        if (action != 0) {
            if (this.B) {
                return true;
            }
            if (this.C) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.I = x2;
            this.G = x2;
            float y2 = motionEvent.getY();
            this.J = y2;
            this.H = y2;
            this.K = motionEvent2.getPointerId(0);
            this.C = false;
            this.n = true;
            this.m.computeScrollOffset();
            if (this.ak != 2 || Math.abs(this.m.getFinalX() - this.m.getCurrX()) <= this.P) {
                a(false);
                this.B = false;
            } else {
                this.m.abortAnimation();
                this.z = false;
                c();
                this.B = true;
                c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.K;
            if (i2 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i2);
                float x3 = motionEvent2.getX(findPointerIndex);
                float f2 = x3 - this.G;
                float abs = Math.abs(f2);
                float y3 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.J);
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 != 0 && !a(this.G, f2)) {
                    if (a(this, false, (int) f2, (int) x3, (int) y3)) {
                        this.G = x3;
                        this.H = y3;
                        this.C = true;
                        return false;
                    }
                }
                if (abs > ((float) this.F) && abs * 0.5f > abs2) {
                    this.B = true;
                    c(true);
                    setScrollState(1);
                    this.G = i3 > 0 ? this.I + ((float) this.F) : this.I - ((float) this.F);
                    this.H = y3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.F)) {
                    this.C = true;
                }
                if (this.B && b(x3)) {
                    v.e(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent2);
        return this.B;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.Q) {
            return true;
        }
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f1345b) == null || aVar.a() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.m.abortAnimation();
            this.z = false;
            c();
            float x2 = motionEvent.getX();
            this.I = x2;
            this.G = x2;
            float y2 = motionEvent.getY();
            this.J = y2;
            this.H = y2;
            this.K = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.B) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.K);
                    if (findPointerIndex == -1) {
                        z2 = h();
                    } else {
                        float x3 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x3 - this.G);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y3 - this.H);
                        if (abs > ((float) this.F) && abs > abs2) {
                            this.B = true;
                            c(true);
                            float f2 = this.I;
                            this.G = x3 - f2 > 0.0f ? f2 + ((float) this.F) : f2 - ((float) this.F);
                            this.H = y3;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.B) {
                    z2 = false | b(motionEvent.getX(motionEvent.findPointerIndex(this.K)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.G = motionEvent.getX(actionIndex);
                    this.K = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    a(motionEvent);
                    this.G = motionEvent.getX(motionEvent.findPointerIndex(this.K));
                }
            } else if (this.B) {
                a(this.c, true, 0, false);
                z2 = h();
            }
        } else if (this.B) {
            VelocityTracker velocityTracker = this.L;
            velocityTracker.computeCurrentVelocity(1000, (float) this.N);
            int xVelocity = (int) velocityTracker.getXVelocity(this.K);
            this.z = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            b i2 = i();
            float f3 = (float) clientWidth;
            a(a(i2.f1350b, ((((float) scrollX) / f3) - i2.e) / (i2.d + (((float) this.p) / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.K)) - this.I)), true, true, xVelocity);
            z2 = h();
        }
        if (z2) {
            v.e(this);
        }
        return true;
    }

    private boolean h() {
        this.K = -1;
        j();
        this.R.onRelease();
        this.S.onRelease();
        return this.R.isFinished() || this.S.isFinished();
    }

    private void c(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean b(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.G - f2;
        this.G = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.t * clientWidth;
        float f5 = this.u * clientWidth;
        boolean z4 = false;
        b bVar = this.g.get(0);
        ArrayList<b> arrayList = this.g;
        b bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f1350b != 0) {
            f4 = bVar.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (bVar2.f1350b != this.f1345b.a() - 1) {
            f5 = bVar2.e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.R.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.S.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.G += scrollX - ((float) i2);
        scrollTo(i2, getScrollY());
        d(i2);
        return z4;
    }

    private b i() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f2 = clientWidth > 0 ? ((float) this.p) / ((float) clientWidth) : 0.0f;
        b bVar = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = 0;
        int i4 = -1;
        boolean z2 = true;
        while (i3 < this.g.size()) {
            b bVar2 = this.g.get(i3);
            if (!z2 && bVar2.f1350b != (i2 = i4 + 1)) {
                bVar2 = this.h;
                bVar2.e = f3 + f4 + f2;
                bVar2.f1350b = i2;
                bVar2.d = this.f1345b.b(bVar2.f1350b);
                i3--;
            }
            f3 = bVar2.e;
            float f5 = bVar2.d + f3 + f2;
            if (!z2 && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i3 == this.g.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.f1350b;
            f4 = bVar2.d;
            i3++;
            z2 = false;
            bVar = bVar2;
        }
        return bVar;
    }

    private int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.O || Math.abs(i3) <= this.M) {
            i2 += (int) (f2 + (i2 >= this.c ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.g.size() <= 0) {
            return i2;
        }
        ArrayList<b> arrayList = this.g;
        return Math.max(this.g.get(0).f1350b, Math.min(i2, arrayList.get(arrayList.size() - 1).f1350b));
    }

    public void draw(Canvas canvas) {
        a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f1345b) != null && aVar.a() > 1)) {
            if (!this.R.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.t * ((float) width));
                this.R.setSize(height, width);
                z2 = false | this.R.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.S.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.u + 1.0f)) * ((float) width2));
                this.S.setSize(height2, width2);
                z2 |= this.S.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.R.finish();
            this.S.finish();
        }
        if (z2) {
            v.e(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.p > 0 && this.q != null && this.g.size() > 0 && this.f1345b != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f5 = (float) width;
            float f6 = ((float) this.p) / f5;
            int i2 = 0;
            b bVar = this.g.get(0);
            float f7 = bVar.e;
            int size = this.g.size();
            int i3 = bVar.f1350b;
            int i4 = this.g.get(size - 1).f1350b;
            while (i3 < i4) {
                while (i3 > bVar.f1350b && i2 < size) {
                    i2++;
                    bVar = this.g.get(i2);
                }
                if (i3 == bVar.f1350b) {
                    f3 = (bVar.e + bVar.d) * f5;
                    f2 = bVar.e + bVar.d + f6;
                } else {
                    float b2 = this.f1345b.b(i3);
                    f2 = f7 + b2 + f6;
                    f3 = (f7 + b2) * f5;
                }
                if (((float) this.p) + f3 > ((float) scrollX)) {
                    f4 = f6;
                    this.q.setBounds(Math.round(f3), this.r, Math.round(((float) this.p) + f3), this.s);
                    this.q.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f4 = f6;
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i3++;
                    f7 = f2;
                    f6 = f4;
                } else {
                    return;
                }
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.K) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.G = motionEvent.getX(i2);
            this.K = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.L;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void j() {
        this.B = false;
        this.C = false;
        VelocityTracker velocityTracker = this.L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
        }
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.f1345b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.t))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.u))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z2 || !view.canScrollHorizontally(-i2)) {
            return false;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return c(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return c(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return e();
                } else {
                    return c(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return d();
            } else {
                return c(17);
            }
        }
        return false;
    }

    public boolean c(int i2) {
        boolean requestFocus;
        boolean z2;
        View findFocus = findFocus();
        boolean z3 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z2 = false;
                        break;
                    } else if (parent == this) {
                        z2 = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus != null && findNextFocus != view) {
            if (i2 == 17) {
                int i3 = a(this.i, findNextFocus).left;
                int i4 = a(this.i, view).left;
                if (view == null || i3 < i4) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = d();
                }
            } else if (i2 == 66) {
                int i5 = a(this.i, findNextFocus).left;
                int i6 = a(this.i, view).left;
                if (view == null || i5 > i6) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = e();
                }
            }
            z3 = requestFocus;
        } else if (i2 == 17 || i2 == 1) {
            z3 = d();
        } else if (i2 == 66 || i2 == 2) {
            z3 = e();
        }
        if (z3) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return z3;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        int i2 = this.c;
        if (i2 <= 0) {
            return false;
        }
        a(i2 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        a aVar = this.f1345b;
        if (aVar == null || this.c >= aVar.a() - 1) {
            return false;
        }
        a(this.c + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f1350b == this.c) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        b a2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f1350b == this.c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b a2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f1350b == this.c && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b a2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f1350b == this.c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    class d extends androidx.core.g.a {
        d() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(a());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.f1345b != null) {
                accessibilityEvent.setItemCount(ViewPager.this.f1345b.a());
                accessibilityEvent.setFromIndex(ViewPager.this.c);
                accessibilityEvent.setToIndex(ViewPager.this.c);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.g.a.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.b((CharSequence) ViewPager.class.getName());
            dVar.j(a());
            if (ViewPager.this.canScrollHorizontally(1)) {
                dVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                dVar.a((int) OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.c - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.c + 1);
                return true;
            }
        }

        private boolean a() {
            return ViewPager.this.f1345b != null && ViewPager.this.f1345b.a() > 1;
        }
    }

    private class h extends DataSetObserver {
        h() {
        }

        public void onChanged() {
            ViewPager.this.b();
        }

        public void onInvalidated() {
            ViewPager.this.b();
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1351a;

        /* renamed from: b  reason: collision with root package name */
        public int f1352b;
        float c = 0.0f;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1344a);
            this.f1352b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f1351a != cVar2.f1351a) {
                return cVar.f1351a ? 1 : -1;
            }
            return cVar.e - cVar2.e;
        }
    }
}
