package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.g.a.d;
import androidx.core.g.a.g;
import androidx.core.g.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;
import androidx.viewpager2.R;
import com.google.android.material.badge.BadgeDrawable;
import com.oppo.exif.OppoExifTag;
import com.sensetime.stmobile.STMobileHumanActionNative;

public final class ViewPager2 extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static boolean f1368a = true;

    /* renamed from: b  reason: collision with root package name */
    int f1369b;
    boolean c = false;
    RecyclerView d;
    e e;
    a f;
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private b i = new b(3);
    private RecyclerView.c j = new c() {
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.c = true;
            viewPager2.e.a();
        }
    };
    private LinearLayoutManager k;
    private int l = -1;
    private Parcelable m;
    private o n;
    private b o;
    private c p;
    private d q;
    private RecyclerView.f r = null;
    private boolean s = false;
    private boolean t = true;
    private int u = -1;

    public static abstract class e {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    public interface g {
        void a(View view, float f);
    }

    public ViewPager2(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f = f1368a ? new f() : new b();
        this.d = new i(context);
        this.d.setId(v.a());
        this.d.setDescendantFocusability(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO);
        this.k = new d(context);
        this.d.setLayoutManager(this.k);
        this.d.setScrollingTouchSlop(1);
        b(context, attributeSet);
        this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.d.addOnChildAttachStateChangeListener(f());
        this.e = new e(this);
        this.p = new c(this, this.e, this.d);
        this.n = new h();
        this.n.a(this.d);
        this.d.addOnScrollListener(this.e);
        this.o = new b(3);
        this.e.a((e) this.o);
        AnonymousClass2 r3 = new e() {
            public void onPageSelected(int i) {
                if (ViewPager2.this.f1369b != i) {
                    ViewPager2 viewPager2 = ViewPager2.this;
                    viewPager2.f1369b = i;
                    viewPager2.f.e();
                }
            }

            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    ViewPager2.this.a();
                }
            }
        };
        AnonymousClass3 r4 = new e() {
            public void onPageSelected(int i) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.d.requestFocus(2);
                }
            }
        };
        this.o.a((e) r3);
        this.o.a((e) r4);
        this.f.a(this.o, this.d);
        this.o.a((e) this.i);
        this.q = new d(this.k);
        this.o.a((e) this.q);
        RecyclerView recyclerView = this.d;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private RecyclerView.k f() {
        return new RecyclerView.k() {
            public void b(View view) {
            }

            public void a(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                if (jVar.width != -1 || jVar.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        };
    }

    public CharSequence getAccessibilityClassName() {
        if (this.f.a()) {
            return this.f.b();
        }
        return super.getAccessibilityClassName();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewPager2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.ViewPager2, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.d.getId();
        int i2 = this.l;
        if (i2 == -1) {
            i2 = this.f1369b;
        }
        savedState.mCurrentItem = i2;
        Parcelable parcelable = this.m;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
        } else {
            RecyclerView.a adapter = this.d.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.c) {
                savedState.mAdapterState = ((androidx.viewpager2.adapter.c) adapter).b();
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.l = savedState.mCurrentItem;
        this.m = savedState.mAdapterState;
    }

    private void g() {
        RecyclerView.a adapter;
        if (this.l != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.m;
            if (parcelable != null) {
                if (adapter instanceof androidx.viewpager2.adapter.c) {
                    ((androidx.viewpager2.adapter.c) adapter).a(parcelable);
                }
                this.m = null;
            }
            this.f1369b = Math.max(0, Math.min(this.l, adapter.getItemCount() - 1));
            this.l = -1;
            this.d.scrollToPosition(this.f1369b);
            this.f.c();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.d.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        g();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readValues(parcel, classLoader);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            readValues(parcel, (ClassLoader) null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readValues(Parcel parcel, ClassLoader classLoader) {
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i);
        }
    }

    public void setAdapter(RecyclerView.a aVar) {
        RecyclerView.a adapter = this.d.getAdapter();
        this.f.b((RecyclerView.a<?>) adapter);
        b((RecyclerView.a<?>) adapter);
        this.d.setAdapter(aVar);
        this.f1369b = 0;
        g();
        this.f.a((RecyclerView.a<?>) aVar);
        a((RecyclerView.a<?>) aVar);
    }

    private void a(RecyclerView.a<?> aVar) {
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.j);
        }
    }

    private void b(RecyclerView.a<?> aVar) {
        if (aVar != null) {
            aVar.unregisterAdapterDataObserver(this.j);
        }
    }

    public RecyclerView.a getAdapter() {
        return this.d.getAdapter();
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        measureChild(this.d, i2, i3);
        int measuredWidth = this.d.getMeasuredWidth();
        int measuredHeight = this.d.getMeasuredHeight();
        int measuredState = this.d.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.d.getMeasuredWidth();
        int measuredHeight = this.d.getMeasuredHeight();
        this.g.left = getPaddingLeft();
        this.g.right = (i4 - i2) - getPaddingRight();
        this.g.top = getPaddingTop();
        this.g.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.g, this.h);
        this.d.layout(this.h.left, this.h.top, this.h.right, this.h.bottom);
        if (this.c) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        o oVar = this.n;
        if (oVar != null) {
            View a2 = oVar.a(this.k);
            if (a2 != null) {
                int position = this.k.getPosition(a2);
                if (position != this.f1369b && getScrollState() == 0) {
                    this.o.onPageSelected(position);
                }
                this.c = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    /* access modifiers changed from: package-private */
    public int getPageSize() {
        int i2;
        int i3;
        RecyclerView recyclerView = this.d;
        if (getOrientation() == 0) {
            i2 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i3 = recyclerView.getPaddingRight();
        } else {
            i2 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i3 = recyclerView.getPaddingBottom();
        }
        return i2 - i3;
    }

    public void setOrientation(int i2) {
        this.k.setOrientation(i2);
        this.f.d();
    }

    public int getOrientation() {
        return this.k.getOrientation();
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.k.getLayoutDirection() == 1;
    }

    public void setCurrentItem(int i2) {
        a(i2, true);
    }

    public void a(int i2, boolean z) {
        if (!c()) {
            b(i2, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, boolean z) {
        RecyclerView.a adapter = getAdapter();
        if (adapter == null) {
            if (this.l != -1) {
                this.l = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            if (min == this.f1369b && this.e.c()) {
                return;
            }
            if (min != this.f1369b || !z) {
                double d2 = (double) this.f1369b;
                this.f1369b = min;
                this.f.e();
                if (!this.e.c()) {
                    d2 = this.e.e();
                }
                this.e.a(min, z);
                if (!z) {
                    this.d.scrollToPosition(min);
                    return;
                }
                double d3 = (double) min;
                if (Math.abs(d3 - d2) > 3.0d) {
                    this.d.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
                    RecyclerView recyclerView = this.d;
                    recyclerView.post(new j(min, recyclerView));
                    return;
                }
                this.d.smoothScrollToPosition(min);
            }
        }
    }

    public int getCurrentItem() {
        return this.f1369b;
    }

    public int getScrollState() {
        return this.e.b();
    }

    public boolean c() {
        return this.p.a();
    }

    public void setUserInputEnabled(boolean z) {
        this.t = z;
        this.f.f();
    }

    public boolean d() {
        return this.t;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.u = i2;
            this.d.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public int getOffscreenPageLimit() {
        return this.u;
    }

    public boolean canScrollHorizontally(int i2) {
        return this.d.canScrollHorizontally(i2);
    }

    public boolean canScrollVertically(int i2) {
        return this.d.canScrollVertically(i2);
    }

    public void a(e eVar) {
        this.i.a(eVar);
    }

    public void b(e eVar) {
        this.i.b(eVar);
    }

    public void setPageTransformer(g gVar) {
        if (gVar != null) {
            if (!this.s) {
                this.r = this.d.getItemAnimator();
                this.s = true;
            }
            this.d.setItemAnimator((RecyclerView.f) null);
        } else if (this.s) {
            this.d.setItemAnimator(this.r);
            this.r = null;
            this.s = false;
        }
        if (gVar != this.q.a()) {
            this.q.a(gVar);
            e();
        }
    }

    public void e() {
        if (this.q.a() != null) {
            double e2 = this.e.e();
            int i2 = (int) e2;
            float f2 = (float) (e2 - ((double) i2));
            this.q.onPageScrolled(i2, f2, Math.round(((float) getPageSize()) * f2));
        }
    }

    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.f.g();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f.a(accessibilityNodeInfo);
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (this.f.a(i2, bundle)) {
            return this.f.b(i2, bundle);
        }
        return super.performAccessibilityAction(i2, bundle);
    }

    private class i extends RecyclerView {
        i(Context context) {
            super(context);
        }

        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f.h()) {
                return ViewPager2.this.f.i();
            }
            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f1369b);
            accessibilityEvent.setToIndex(ViewPager2.this.f1369b);
            ViewPager2.this.f.a(accessibilityEvent);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.d() && super.onTouchEvent(motionEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.d() && super.onInterceptTouchEvent(motionEvent);
        }
    }

    private class d extends LinearLayoutManager {
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        d(Context context) {
            super(context);
        }

        public boolean performAccessibilityAction(RecyclerView.p pVar, RecyclerView.t tVar, int i, Bundle bundle) {
            if (ViewPager2.this.f.a(i)) {
                return ViewPager2.this.f.b(i);
            }
            return super.performAccessibilityAction(pVar, tVar, i, bundle);
        }

        public void onInitializeAccessibilityNodeInfo(RecyclerView.p pVar, RecyclerView.t tVar, androidx.core.g.a.d dVar) {
            super.onInitializeAccessibilityNodeInfo(pVar, tVar, dVar);
            ViewPager2.this.f.a(dVar);
        }

        /* access modifiers changed from: protected */
        public void calculateExtraLayoutSpace(RecyclerView.t tVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(tVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }
    }

    private class h extends o {
        h() {
        }

        public View a(RecyclerView.i iVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.a(iVar);
        }
    }

    private static class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f1383a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f1384b;

        j(int i, RecyclerView recyclerView) {
            this.f1383a = i;
            this.f1384b = recyclerView;
        }

        public void run() {
            this.f1384b.smoothScrollToPosition(this.f1383a);
        }
    }

    public int getItemDecorationCount() {
        return this.d.getItemDecorationCount();
    }

    private abstract class a {
        /* access modifiers changed from: package-private */
        public void a(AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.core.g.a.d dVar) {
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView.a<?> aVar) {
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar, RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView.a<?> aVar) {
        }

        /* access modifiers changed from: package-private */
        public void c() {
        }

        /* access modifiers changed from: package-private */
        public void d() {
        }

        /* access modifiers changed from: package-private */
        public void e() {
        }

        /* access modifiers changed from: package-private */
        public void f() {
        }

        /* access modifiers changed from: package-private */
        public void g() {
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return false;
        }

        private a() {
        }

        /* access modifiers changed from: package-private */
        public String b() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public CharSequence i() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class b extends a {
        public boolean h() {
            return true;
        }

        b() {
            super();
        }

        public boolean a(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.d();
        }

        public boolean b(int i) {
            if (a(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public void a(androidx.core.g.a.d dVar) {
            if (!ViewPager2.this.d()) {
                dVar.b(d.a.n);
                dVar.b(d.a.m);
                dVar.j(false);
            }
        }

        public CharSequence i() {
            if (h()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    class f extends a {
        private final androidx.core.g.a.g c = new androidx.core.g.a.g() {
            public boolean perform(View view, g.a aVar) {
                f.this.c(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };
        private final androidx.core.g.a.g d = new androidx.core.g.a.g() {
            public boolean perform(View view, g.a aVar) {
                f.this.c(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };
        private RecyclerView.c e;

        public boolean a() {
            return true;
        }

        public boolean a(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        f() {
            super();
        }

        public void a(b bVar, RecyclerView recyclerView) {
            v.b((View) recyclerView, 2);
            this.e = new c() {
                public void onChanged() {
                    f.this.j();
                }
            };
            if (v.f(ViewPager2.this) == 0) {
                v.b((View) ViewPager2.this, 1);
            }
        }

        public String b() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void c() {
            j();
        }

        public void a(RecyclerView.a<?> aVar) {
            j();
            if (aVar != null) {
                aVar.registerAdapterDataObserver(this.e);
            }
        }

        public void b(RecyclerView.a<?> aVar) {
            if (aVar != null) {
                aVar.unregisterAdapterDataObserver(this.e);
            }
        }

        public void d() {
            j();
        }

        public void e() {
            j();
        }

        public void f() {
            j();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        public void g() {
            j();
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
            b(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                c(accessibilityNodeInfo);
            }
        }

        public boolean b(int i, Bundle bundle) {
            int i2;
            if (a(i, bundle)) {
                if (i == 8192) {
                    i2 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i2 = ViewPager2.this.getCurrentItem() + 1;
                }
                c(i2);
                return true;
            }
            throw new IllegalStateException();
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(b());
        }

        /* access modifiers changed from: package-private */
        public void c(int i) {
            if (ViewPager2.this.d()) {
                ViewPager2.this.b(i, true);
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = 16908360;
            v.c((View) viewPager2, 16908360);
            v.c((View) viewPager2, 16908361);
            v.c((View) viewPager2, 16908358);
            v.c((View) viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.d()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean b2 = ViewPager2.this.b();
                    int i2 = b2 ? 16908360 : 16908361;
                    if (b2) {
                        i = 16908361;
                    }
                    if (ViewPager2.this.f1369b < itemCount - 1) {
                        v.a(viewPager2, new d.a(i2, (CharSequence) null), (CharSequence) null, this.c);
                    }
                    if (ViewPager2.this.f1369b > 0) {
                        v.a(viewPager2, new d.a(i, (CharSequence) null), (CharSequence) null, this.d);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.f1369b < itemCount - 1) {
                    v.a(viewPager2, new d.a(16908359, (CharSequence) null), (CharSequence) null, this.c);
                }
                if (ViewPager2.this.f1369b > 0) {
                    v.a(viewPager2, new d.a(16908358, (CharSequence) null), (CharSequence) null, this.d);
                }
            }
        }

        private void b(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i;
            int i2;
            if (ViewPager2.this.getAdapter() == null) {
                i2 = 0;
                i = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i2 = ViewPager2.this.getAdapter().getItemCount();
                i = 0;
            } else {
                i = ViewPager2.this.getAdapter().getItemCount();
                i2 = 0;
            }
            androidx.core.g.a.d.a(accessibilityNodeInfo).a((Object) d.b.a(i2, i, false, 0));
        }

        private void c(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.a adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.d()) {
                if (ViewPager2.this.f1369b > 0) {
                    accessibilityNodeInfo.addAction(OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION);
                }
                if (ViewPager2.this.f1369b < itemCount - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }
    }

    private static abstract class c extends RecyclerView.c {
        public abstract void onChanged();

        private c() {
        }

        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }
}
