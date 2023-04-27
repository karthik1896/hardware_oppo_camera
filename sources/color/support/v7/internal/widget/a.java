package color.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

/* compiled from: AdapterViewCompat */
public abstract class a<T extends Adapter> extends ViewGroup {
    int A;
    int B;
    long C;
    boolean D;

    /* renamed from: a  reason: collision with root package name */
    private int f1515a;

    /* renamed from: b  reason: collision with root package name */
    private View f1516b;
    private boolean c;
    private boolean d;
    private a<T>.e e;
    @ViewDebug.ExportedProperty(category = "scrolling")
    int j;
    int k;
    int l;
    long m;
    long n;
    boolean o;
    int p;
    boolean q;
    d r;
    b s;
    c t;
    boolean u;
    @ViewDebug.ExportedProperty(category = "list")
    int v;
    long w;
    @ViewDebug.ExportedProperty(category = "list")
    int x;
    long y;
    @ViewDebug.ExportedProperty(category = "list")
    int z;

    /* compiled from: AdapterViewCompat */
    public interface b {
    }

    /* compiled from: AdapterViewCompat */
    public interface c {
    }

    /* compiled from: AdapterViewCompat */
    public interface d {
        void a(a<?> aVar);

        void a(a<?> aVar, View view, int i, long j);
    }

    /* access modifiers changed from: package-private */
    public int b(int i, boolean z2) {
        return i;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return false;
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t2);

    public abstract void setSelection(int i);

    public void setOnItemClickListener(b bVar) {
        this.s = bVar;
    }

    public final b getOnItemClickListener() {
        return this.s;
    }

    public void setOnItemLongClickListener(c cVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.t = cVar;
    }

    public final c getOnItemLongClickListener() {
        return this.t;
    }

    public void setOnItemSelectedListener(d dVar) {
        this.r = dVar;
    }

    public final d getOnItemSelectedListener() {
        return this.r;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        this.f1515a = getHeight();
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.v;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.w;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.z;
    }

    public int getFirstVisiblePosition() {
        return this.j;
    }

    public int getLastVisiblePosition() {
        return (this.j + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.f1516b = view;
        Adapter adapter = getAdapter();
        a(adapter == null || adapter.isEmpty());
    }

    public View getEmptyView() {
        return this.f1516b;
    }

    public void setFocusable(boolean z2) {
        Adapter adapter = getAdapter();
        boolean z3 = true;
        boolean z4 = adapter == null || adapter.getCount() == 0;
        this.c = z2;
        if (!z2) {
            this.d = false;
        }
        if (!z2 || (z4 && !c())) {
            z3 = false;
        }
        super.setFocusable(z3);
    }

    public void setFocusableInTouchMode(boolean z2) {
        Adapter adapter = getAdapter();
        boolean z3 = false;
        boolean z4 = adapter == null || adapter.getCount() == 0;
        this.d = z2;
        if (z2) {
            this.c = true;
        }
        if (z2 && (!z4 || c())) {
            z3 = true;
        }
        super.setFocusableInTouchMode(z3);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Adapter adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = !(adapter == null || adapter.getCount() == 0) || c();
        super.setFocusableInTouchMode(z3 && this.d);
        super.setFocusable(z3 && this.c);
        if (this.f1516b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z2 = true;
            }
            a(z2);
        }
    }

    private void a(boolean z2) {
        if (c()) {
            z2 = false;
        }
        if (z2) {
            View view = this.f1516b;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.f1516b;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    public long a(int i) {
        Adapter adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* renamed from: color.support.v7.internal.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AdapterViewCompat */
    class C0047a extends DataSetObserver {

        /* renamed from: b  reason: collision with root package name */
        private Parcelable f1518b = null;

        C0047a() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.u = true;
            aVar.A = aVar.z;
            a aVar2 = a.this;
            aVar2.z = aVar2.getAdapter().getCount();
            if (!a.this.getAdapter().hasStableIds() || this.f1518b == null || a.this.A != 0 || a.this.z <= 0) {
                a.this.i();
            } else {
                a.this.onRestoreInstanceState(this.f1518b);
                this.f1518b = null;
            }
            a.this.d();
            a.this.requestLayout();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.u = true;
            if (aVar.getAdapter().hasStableIds()) {
                this.f1518b = a.this.onSaveInstanceState();
            }
            a aVar2 = a.this;
            aVar2.A = aVar2.z;
            a aVar3 = a.this;
            aVar3.z = 0;
            aVar3.x = -1;
            aVar3.y = Long.MIN_VALUE;
            aVar3.v = -1;
            aVar3.w = Long.MIN_VALUE;
            aVar3.o = false;
            aVar3.d();
            a.this.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    /* compiled from: AdapterViewCompat */
    private class e implements Runnable {
        private e() {
        }

        public void run() {
            if (!a.this.u) {
                a.this.a();
            } else if (a.this.getAdapter() != null) {
                a.this.post(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.r != null) {
            if (this.q || this.D) {
                if (this.e == null) {
                    this.e = new e();
                }
                post(this.e);
            } else {
                a();
            }
        }
        if (this.x != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.r != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.r.a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.r.a(this);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return super.canAnimate() && this.z > 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r5 = this;
            int r0 = r5.z
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0041
            boolean r3 = r5.o
            if (r3 == 0) goto L_0x001d
            r5.o = r2
            int r3 = r5.h()
            if (r3 < 0) goto L_0x001d
            int r4 = r5.b(r3, r1)
            if (r4 != r3) goto L_0x001d
            r5.setNextSelectedPositionInt(r3)
            r3 = r1
            goto L_0x001e
        L_0x001d:
            r3 = r2
        L_0x001e:
            if (r3 != 0) goto L_0x003f
            int r4 = r5.getSelectedItemPosition()
            if (r4 < r0) goto L_0x0028
            int r0 = r0 - r1
            goto L_0x0029
        L_0x0028:
            r0 = r4
        L_0x0029:
            if (r0 >= 0) goto L_0x002c
            r0 = r2
        L_0x002c:
            int r4 = r5.b(r0, r1)
            if (r4 >= 0) goto L_0x0036
            int r4 = r5.b(r0, r2)
        L_0x0036:
            if (r4 < 0) goto L_0x003f
            r5.setNextSelectedPositionInt(r4)
            r5.g()
            goto L_0x0042
        L_0x003f:
            r1 = r3
            goto L_0x0042
        L_0x0041:
            r1 = r2
        L_0x0042:
            if (r1 != 0) goto L_0x0054
            r0 = -1
            r5.x = r0
            r3 = -9223372036854775808
            r5.y = r3
            r5.v = r0
            r5.w = r3
            r5.o = r2
            r5.g()
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: color.support.v7.internal.widget.a.f():void");
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.x != this.B || this.y != this.C) {
            e();
            this.B = this.x;
            this.C = this.y;
        }
    }

    /* access modifiers changed from: package-private */
    public int h() {
        int i = this.z;
        if (i == 0) {
            return -1;
        }
        long j2 = this.m;
        int i2 = this.l;
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        int i3 = i - 1;
        int min = Math.min(i3, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i4 = min;
        int i5 = i4;
        boolean z2 = false;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(min) != j2) {
                boolean z3 = i4 == i3;
                boolean z4 = i5 == 0;
                if (z3 && z4) {
                    break;
                } else if (z4 || (z2 && !z3)) {
                    i4++;
                    z2 = false;
                    min = i4;
                } else if (z3 || (!z2 && !z4)) {
                    i5--;
                    z2 = true;
                    min = i5;
                }
            } else {
                return min;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void setSelectedPositionInt(int i) {
        this.x = i;
        this.y = a(i);
    }

    /* access modifiers changed from: package-private */
    public void setNextSelectedPositionInt(int i) {
        this.v = i;
        this.w = a(i);
        if (this.o && this.p == 0 && i >= 0) {
            this.l = i;
            this.m = this.w;
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (getChildCount() > 0) {
            this.o = true;
            this.n = (long) this.f1515a;
            int i = this.x;
            if (i >= 0) {
                View childAt = getChildAt(i - this.j);
                this.m = this.w;
                this.l = this.v;
                if (childAt != null) {
                    this.k = childAt.getTop();
                }
                this.p = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapter = getAdapter();
            int i2 = this.j;
            if (i2 < 0 || i2 >= adapter.getCount()) {
                this.m = -1;
            } else {
                this.m = adapter.getItemId(this.j);
            }
            this.l = this.j;
            if (childAt2 != null) {
                this.k = childAt2.getTop();
            }
            this.p = 1;
        }
    }
}
