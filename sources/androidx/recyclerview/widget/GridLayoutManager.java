package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.a.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    boolean f1037a = false;

    /* renamed from: b  reason: collision with root package name */
    int f1038b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    c g = new a();
    final Rect h = new Rect();
    private boolean i;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(getProperties(context, attributeSet, i2, i3).f1062b);
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        a(i2);
    }

    public GridLayoutManager(Context context, int i2, int i3, boolean z) {
        super(context, i3, z);
        a(i2);
    }

    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public int getRowCountForAccessibility(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.mOrientation == 0) {
            return this.f1038b;
        }
        if (tVar.e() < 1) {
            return 0;
        }
        return a(pVar, tVar, tVar.e() - 1) + 1;
    }

    public int getColumnCountForAccessibility(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.mOrientation == 1) {
            return this.f1038b;
        }
        if (tVar.e() < 1) {
            return 0;
        }
        return a(pVar, tVar, tVar.e() - 1) + 1;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.p pVar, RecyclerView.t tVar, View view, d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a2 = a(pVar, tVar, bVar.f());
        if (this.mOrientation == 0) {
            dVar.b((Object) d.c.a(bVar.a(), bVar.b(), a2, 1, false, false));
            return;
        }
        dVar.b((Object) d.c.a(a2, 1, bVar.a(), bVar.b(), false, false));
    }

    public void onLayoutChildren(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (tVar.a()) {
            c();
        }
        super.onLayoutChildren(pVar, tVar);
        b();
    }

    public void onLayoutCompleted(RecyclerView.t tVar) {
        super.onLayoutCompleted(tVar);
        this.f1037a = false;
    }

    private void b() {
        this.e.clear();
        this.f.clear();
    }

    private void c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            b bVar = (b) getChildAt(i2).getLayoutParams();
            int f2 = bVar.f();
            this.e.put(f2, bVar.b());
            this.f.put(f2, bVar.a());
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        this.g.a();
        this.g.b();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.g.a();
        this.g.b();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        this.g.a();
        this.g.b();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.g.a();
        this.g.b();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.g.a();
        this.g.b();
    }

    public RecyclerView.j generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public RecyclerView.j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public boolean checkLayoutParams(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    private void d() {
        int i2;
        int i3;
        if (getOrientation() == 1) {
            i3 = getWidth() - getPaddingRight();
            i2 = getPaddingLeft();
        } else {
            i3 = getHeight() - getPaddingBottom();
            i2 = getPaddingTop();
        }
        b(i3 - i2);
    }

    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        if (this.c == null) {
            super.setMeasuredDimension(rect, i2, i3);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i5 = chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.c;
            i4 = chooseSize(i2, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i4 = chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.c;
            i5 = chooseSize(i3, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i4, i5);
    }

    private void b(int i2) {
        this.c = a(this.c, this.f1038b, i2);
    }

    static int[] a(int[] iArr, int i2, int i3) {
        int i4;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i3)) {
            iArr = new int[(i2 + 1)];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, int i3) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.c;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.c;
        int i4 = this.f1038b;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.p pVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i2) {
        super.onAnchorReady(pVar, tVar, aVar, i2);
        d();
        if (tVar.e() > 0 && !tVar.a()) {
            a(pVar, tVar, aVar, i2);
        }
        e();
    }

    private void e() {
        View[] viewArr = this.d;
        if (viewArr == null || viewArr.length != this.f1038b) {
            this.d = new View[this.f1038b];
        }
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        d();
        e();
        return super.scrollHorizontallyBy(i2, pVar, tVar);
    }

    public int scrollVerticallyBy(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        d();
        e();
        return super.scrollVerticallyBy(i2, pVar, tVar);
    }

    private void a(RecyclerView.p pVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i2) {
        boolean z = i2 == 1;
        int b2 = b(pVar, tVar, aVar.f1044b);
        if (z) {
            while (b2 > 0 && aVar.f1044b > 0) {
                aVar.f1044b--;
                b2 = b(pVar, tVar, aVar.f1044b);
            }
            return;
        }
        int e2 = tVar.e() - 1;
        int i3 = aVar.f1044b;
        while (i3 < e2) {
            int i4 = i3 + 1;
            int b3 = b(pVar, tVar, i4);
            if (b3 <= b2) {
                break;
            }
            i3 = i4;
            b2 = b3;
        }
        aVar.f1044b = i3;
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.p pVar, RecyclerView.t tVar, int i2, int i3, int i4) {
        ensureLayoutState();
        int d2 = this.mOrientationHelper.d();
        int e2 = this.mOrientationHelper.e();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4 && b(pVar, tVar, position) == 0) {
                if (((RecyclerView.j) childAt.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.a(childAt) < e2 && this.mOrientationHelper.b(childAt) >= d2) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    private int a(RecyclerView.p pVar, RecyclerView.t tVar, int i2) {
        if (!tVar.a()) {
            return this.g.c(i2, this.f1038b);
        }
        int b2 = pVar.b(i2);
        if (b2 != -1) {
            return this.g.c(b2, this.f1038b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    private int b(RecyclerView.p pVar, RecyclerView.t tVar, int i2) {
        if (!tVar.a()) {
            return this.g.b(i2, this.f1038b);
        }
        int i3 = this.f.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int b2 = pVar.b(i2);
        if (b2 != -1) {
            return this.g.b(b2, this.f1038b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    private int c(RecyclerView.p pVar, RecyclerView.t tVar, int i2) {
        if (!tVar.a()) {
            return this.g.a(i2);
        }
        int i3 = this.e.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int b2 = pVar.b(i2);
        if (b2 != -1) {
            return this.g.a(b2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.t tVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int i2 = this.f1038b;
        for (int i3 = 0; i3 < this.f1038b && cVar.a(tVar) && i2 > 0; i3++) {
            int i4 = cVar.d;
            aVar.b(i4, Math.max(0, cVar.g));
            i2 -= this.g.a(i4);
            cVar.d += cVar.e;
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.p pVar, RecyclerView.t tVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        View a2;
        RecyclerView.p pVar2 = pVar;
        RecyclerView.t tVar2 = tVar;
        LinearLayoutManager.c cVar2 = cVar;
        LinearLayoutManager.b bVar2 = bVar;
        int j = this.mOrientationHelper.j();
        boolean z = false;
        boolean z2 = j != 1073741824;
        int i12 = getChildCount() > 0 ? this.c[this.f1038b] : 0;
        if (z2) {
            d();
        }
        boolean z3 = cVar2.e == 1;
        int i13 = this.f1038b;
        if (!z3) {
            i13 = b(pVar2, tVar2, cVar2.d) + c(pVar2, tVar2, cVar2.d);
        }
        int i14 = i13;
        int i15 = 0;
        while (i15 < this.f1038b && cVar2.a(tVar2) && i14 > 0) {
            int i16 = cVar2.d;
            int c2 = c(pVar2, tVar2, i16);
            if (c2 <= this.f1038b) {
                i14 -= c2;
                if (i14 < 0 || (a2 = cVar2.a(pVar2)) == null) {
                    break;
                }
                this.d[i15] = a2;
                i15++;
            } else {
                throw new IllegalArgumentException("Item at position " + i16 + " requires " + c2 + " spans but GridLayoutManager has only " + this.f1038b + " spans.");
            }
        }
        if (i15 == 0) {
            bVar2.f1046b = true;
            return;
        }
        float f2 = 0.0f;
        a(pVar2, tVar2, i15, z3);
        int i17 = 0;
        int i18 = 0;
        while (i17 < i15) {
            View view = this.d[i17];
            if (cVar2.l == null) {
                if (z3) {
                    addView(view);
                } else {
                    addView(view, z);
                }
            } else if (z3) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, z ? 1 : 0);
            }
            calculateItemDecorationsForChild(view, this.h);
            a(view, j, z);
            int e2 = this.mOrientationHelper.e(view);
            if (e2 > i18) {
                i18 = e2;
            }
            float f3 = (((float) this.mOrientationHelper.f(view)) * 1.0f) / ((float) ((b) view.getLayoutParams()).f1040b);
            if (f3 > f2) {
                f2 = f3;
            }
            i17++;
            z = false;
        }
        if (z2) {
            a(f2, i12);
            i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                View view2 = this.d[i19];
                a(view2, 1073741824, true);
                int e3 = this.mOrientationHelper.e(view2);
                if (e3 > i18) {
                    i18 = e3;
                }
            }
        }
        for (int i20 = 0; i20 < i15; i20++) {
            View view3 = this.d[i20];
            if (this.mOrientationHelper.e(view3) != i18) {
                b bVar3 = (b) view3.getLayoutParams();
                Rect rect = bVar3.d;
                int i21 = rect.top + rect.bottom + bVar3.topMargin + bVar3.bottomMargin;
                int i22 = rect.left + rect.right + bVar3.leftMargin + bVar3.rightMargin;
                int a3 = a(bVar3.f1039a, bVar3.f1040b);
                if (this.mOrientation == 1) {
                    i11 = getChildMeasureSpec(a3, 1073741824, i22, bVar3.width, false);
                    i10 = View.MeasureSpec.makeMeasureSpec(i18 - i21, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - i22, 1073741824);
                    i10 = getChildMeasureSpec(a3, 1073741824, i21, bVar3.height, false);
                    i11 = makeMeasureSpec;
                }
                a(view3, i11, i10, true);
            }
        }
        int i23 = 0;
        bVar2.f1045a = i18;
        if (this.mOrientation == 1) {
            if (cVar2.f == -1) {
                int i24 = cVar2.f1048b;
                i4 = i24 - i18;
                i3 = i24;
            } else {
                int i25 = cVar2.f1048b;
                i3 = i25 + i18;
                i4 = i25;
            }
            i5 = 0;
            i2 = 0;
        } else if (cVar2.f == -1) {
            i2 = cVar2.f1048b;
            i5 = i2 - i18;
            i4 = 0;
            i3 = 0;
        } else {
            int i26 = cVar2.f1048b;
            int i27 = i26 + i18;
            i4 = 0;
            i3 = 0;
            int i28 = i26;
            i2 = i27;
            i5 = i28;
        }
        while (i23 < i15) {
            View view4 = this.d[i23];
            b bVar4 = (b) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                int paddingTop = getPaddingTop() + this.c[bVar4.f1039a];
                i9 = i5;
                i8 = paddingTop;
                i6 = this.mOrientationHelper.f(view4) + paddingTop;
                i7 = i2;
            } else if (isLayoutRTL()) {
                int paddingLeft = getPaddingLeft() + this.c[this.f1038b - bVar4.f1039a];
                i7 = paddingLeft;
                i8 = i4;
                i6 = i3;
                i9 = paddingLeft - this.mOrientationHelper.f(view4);
            } else {
                int paddingLeft2 = getPaddingLeft() + this.c[bVar4.f1039a];
                i9 = paddingLeft2;
                i8 = i4;
                i6 = i3;
                i7 = this.mOrientationHelper.f(view4) + paddingLeft2;
            }
            layoutDecoratedWithMargins(view4, i9, i8, i7, i6);
            if (bVar4.d() || bVar4.e()) {
                bVar2.c = true;
            }
            bVar2.d |= view4.hasFocusable();
            i23++;
            i5 = i9;
            i4 = i8;
            i2 = i7;
            i3 = i6;
        }
        Arrays.fill(this.d, (Object) null);
    }

    private void a(View view, int i2, boolean z) {
        int i3;
        int i4;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.d;
        int i5 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i6 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int a2 = a(bVar.f1039a, bVar.f1040b);
        if (this.mOrientation == 1) {
            i3 = getChildMeasureSpec(a2, i2, i6, bVar.width, false);
            i4 = getChildMeasureSpec(this.mOrientationHelper.g(), getHeightMode(), i5, bVar.height, true);
        } else {
            int childMeasureSpec = getChildMeasureSpec(a2, i2, i5, bVar.height, false);
            int childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.g(), getWidthMode(), i6, bVar.width, true);
            i4 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        a(view, i3, i4, z);
    }

    private void a(float f2, int i2) {
        b(Math.max(Math.round(f2 * ((float) this.f1038b)), i2));
    }

    private void a(View view, int i2, int i3, boolean z) {
        boolean z2;
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        if (z) {
            z2 = shouldReMeasureChild(view, i2, i3, jVar);
        } else {
            z2 = shouldMeasureChild(view, i2, i3, jVar);
        }
        if (z2) {
            view.measure(i2, i3);
        }
    }

    private void a(RecyclerView.p pVar, RecyclerView.t tVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i3 = 1;
            i6 = i2;
            i4 = 0;
        } else {
            i4 = i2 - 1;
            i3 = -1;
        }
        while (i4 != i6) {
            View view = this.d[i4];
            b bVar = (b) view.getLayoutParams();
            bVar.f1040b = c(pVar, tVar, getPosition(view));
            bVar.f1039a = i5;
            i5 += bVar.f1040b;
            i4 += i3;
        }
    }

    public int a() {
        return this.f1038b;
    }

    public void a(int i2) {
        if (i2 != this.f1038b) {
            this.f1037a = true;
            if (i2 >= 1) {
                this.f1038b = i2;
                this.g.a();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f1041a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f1042b = new SparseIntArray();
        private boolean c = false;
        private boolean d = false;

        public abstract int a(int i);

        public void a() {
            this.f1041a.clear();
        }

        public void b() {
            this.f1042b.clear();
        }

        /* access modifiers changed from: package-private */
        public int b(int i, int i2) {
            if (!this.c) {
                return a(i, i2);
            }
            int i3 = this.f1041a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int a2 = a(i, i2);
            this.f1041a.put(i, a2);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int c(int i, int i2) {
            if (!this.d) {
                return d(i, i2);
            }
            int i3 = this.f1042b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int d2 = d(i, i2);
            this.f1042b.put(i, d2);
            return d2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.a(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.c
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.f1041a
                int r2 = a((android.util.SparseIntArray) r2, (int) r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.f1041a
                int r3 = r3.get(r2)
                int r4 = r5.a(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = r1
                r3 = r2
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.a(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = r1
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.a(int, int):int");
        }

        static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int d(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int a2;
            if (!this.d || (a2 = a(this.f1042b, i)) == -1) {
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                i4 = this.f1042b.get(a2);
                i3 = a2 + 1;
                i5 = a(a2) + b(a2, i2);
                if (i5 == i2) {
                    i4++;
                    i5 = 0;
                }
            }
            int a3 = a(i);
            while (i3 < i) {
                int a4 = a(i3);
                int i6 = i5 + a4;
                if (i6 == i2) {
                    i4++;
                    i6 = 0;
                } else if (i6 > i2) {
                    i4++;
                    i6 = a4;
                }
                i3++;
            }
            return i5 + a3 > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f7, code lost:
        if (r13 == r10) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.p r25, androidx.recyclerview.widget.RecyclerView.t r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r25
            r2 = r26
            android.view.View r3 = r22.findContainingItemView(r23)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.b) r5
            int r6 = r5.f1039a
            int r7 = r5.f1039a
            int r5 = r5.f1040b
            int r7 = r7 + r5
            android.view.View r5 = super.onFocusSearchFailed(r23, r24, r25, r26)
            if (r5 != 0) goto L_0x0022
            return r4
        L_0x0022:
            r5 = r24
            int r5 = r0.convertFocusDirectionToLayoutDirection(r5)
            r9 = 1
            if (r5 != r9) goto L_0x002d
            r5 = r9
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            boolean r10 = r0.mShouldReverseLayout
            if (r5 == r10) goto L_0x0034
            r5 = r9
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            r10 = -1
            if (r5 == 0) goto L_0x0040
            int r5 = r22.getChildCount()
            int r5 = r5 - r9
            r11 = r10
            r12 = r11
            goto L_0x0047
        L_0x0040:
            int r5 = r22.getChildCount()
            r11 = r5
            r12 = r9
            r5 = 0
        L_0x0047:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x0053
            boolean r13 = r22.isLayoutRTL()
            if (r13 == 0) goto L_0x0053
            r13 = r9
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            int r14 = r0.a((androidx.recyclerview.widget.RecyclerView.p) r1, (androidx.recyclerview.widget.RecyclerView.t) r2, (int) r5)
            r8 = r10
            r17 = r8
            r15 = 0
            r16 = 0
            r10 = r4
        L_0x005f:
            if (r5 == r11) goto L_0x0145
            int r9 = r0.a((androidx.recyclerview.widget.RecyclerView.p) r1, (androidx.recyclerview.widget.RecyclerView.t) r2, (int) r5)
            android.view.View r1 = r0.getChildAt(r5)
            if (r1 != r3) goto L_0x006d
            goto L_0x0145
        L_0x006d:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0087
            if (r9 == r14) goto L_0x0087
            if (r4 == 0) goto L_0x0079
            goto L_0x0145
        L_0x0079:
            r18 = r3
            r20 = r8
            r23 = r10
            r19 = r11
            r8 = r16
            r11 = r17
            goto L_0x0131
        L_0x0087:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.b) r9
            int r2 = r9.f1039a
            r18 = r3
            int r3 = r9.f1039a
            r19 = r11
            int r11 = r9.f1040b
            int r3 = r3 + r11
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a3
            if (r2 != r6) goto L_0x00a3
            if (r3 != r7) goto L_0x00a3
            return r1
        L_0x00a3:
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00ab
            if (r4 == 0) goto L_0x00b3
        L_0x00ab:
            boolean r11 = r1.hasFocusable()
            if (r11 != 0) goto L_0x00bd
            if (r10 != 0) goto L_0x00bd
        L_0x00b3:
            r20 = r8
            r23 = r10
            r8 = r16
            r11 = r17
        L_0x00bb:
            r10 = 1
            goto L_0x0103
        L_0x00bd:
            int r11 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r7)
            int r11 = r20 - r11
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x00da
            if (r11 <= r15) goto L_0x00d0
            goto L_0x00b3
        L_0x00d0:
            if (r11 != r15) goto L_0x00fa
            if (r2 <= r8) goto L_0x00d6
            r11 = 1
            goto L_0x00d7
        L_0x00d6:
            r11 = 0
        L_0x00d7:
            if (r13 != r11) goto L_0x00fa
            goto L_0x00b3
        L_0x00da:
            if (r4 != 0) goto L_0x00fa
            r20 = r8
            r23 = r10
            r8 = 0
            r10 = 1
            boolean r21 = r0.isViewPartiallyVisible(r1, r8, r10)
            if (r21 == 0) goto L_0x00fe
            r8 = r16
            if (r11 <= r8) goto L_0x00ef
            r11 = r17
            goto L_0x0103
        L_0x00ef:
            if (r11 != r8) goto L_0x0100
            r11 = r17
            if (r2 <= r11) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r10 = 0
        L_0x00f7:
            if (r13 != r10) goto L_0x0102
            goto L_0x00bb
        L_0x00fa:
            r20 = r8
            r23 = r10
        L_0x00fe:
            r8 = r16
        L_0x0100:
            r11 = r17
        L_0x0102:
            r10 = 0
        L_0x0103:
            if (r10 == 0) goto L_0x0131
            boolean r10 = r1.hasFocusable()
            if (r10 == 0) goto L_0x0120
            int r4 = r9.f1039a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r23
            r15 = r3
            r16 = r8
            r17 = r11
            r8 = r4
            r4 = r1
            goto L_0x0139
        L_0x0120:
            int r8 = r9.f1039a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r16 = r3
            r17 = r8
            goto L_0x0137
        L_0x0131:
            r10 = r23
            r16 = r8
            r17 = r11
        L_0x0137:
            r8 = r20
        L_0x0139:
            int r5 = r5 + r12
            r1 = r25
            r2 = r26
            r3 = r18
            r11 = r19
            r9 = 1
            goto L_0x005f
        L_0x0145:
            r23 = r10
            if (r4 == 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r4 = r23
        L_0x014c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t):android.view.View");
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f1037a;
    }

    public int computeHorizontalScrollRange(RecyclerView.t tVar) {
        if (this.i) {
            return a(tVar);
        }
        return super.computeHorizontalScrollRange(tVar);
    }

    public int computeVerticalScrollRange(RecyclerView.t tVar) {
        if (this.i) {
            return a(tVar);
        }
        return super.computeVerticalScrollRange(tVar);
    }

    public int computeHorizontalScrollOffset(RecyclerView.t tVar) {
        if (this.i) {
            return b(tVar);
        }
        return super.computeHorizontalScrollOffset(tVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.t tVar) {
        if (this.i) {
            return b(tVar);
        }
        return super.computeVerticalScrollOffset(tVar);
    }

    private int a(RecyclerView.t tVar) {
        if (!(getChildCount() == 0 || tVar.e() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.g.c(tVar.e() - 1, this.f1038b) + 1;
                }
                int b2 = this.mOrientationHelper.b(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart);
                int c2 = this.g.c(getPosition(findFirstVisibleChildClosestToStart), this.f1038b);
                return (int) ((((float) b2) / ((float) ((this.g.c(getPosition(findFirstVisibleChildClosestToEnd), this.f1038b) - c2) + 1))) * ((float) (this.g.c(tVar.e() - 1, this.f1038b) + 1)));
            }
        }
        return 0;
    }

    private int b(RecyclerView.t tVar) {
        int i2;
        if (!(getChildCount() == 0 || tVar.e() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int c2 = this.g.c(getPosition(findFirstVisibleChildClosestToStart), this.f1038b);
                int c3 = this.g.c(getPosition(findFirstVisibleChildClosestToEnd), this.f1038b);
                int min = Math.min(c2, c3);
                int max = Math.max(c2, c3);
                int c4 = this.g.c(tVar.e() - 1, this.f1038b) + 1;
                if (this.mShouldReverseLayout) {
                    i2 = Math.max(0, (c4 - max) - 1);
                } else {
                    i2 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i2;
                }
                return Math.round((((float) i2) * (((float) Math.abs(this.mOrientationHelper.b(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart))) / ((float) ((this.g.c(getPosition(findFirstVisibleChildClosestToEnd), this.f1038b) - this.g.c(getPosition(findFirstVisibleChildClosestToStart), this.f1038b)) + 1)))) + ((float) (this.mOrientationHelper.d() - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    public static final class a extends c {
        public int a(int i) {
            return 1;
        }

        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends RecyclerView.j {

        /* renamed from: a  reason: collision with root package name */
        int f1039a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f1040b = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.f1039a;
        }

        public int b() {
            return this.f1040b;
        }
    }
}
