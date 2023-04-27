package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.d;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.s.b {

    /* renamed from: a  reason: collision with root package name */
    c[] f1076a;

    /* renamed from: b  reason: collision with root package name */
    n f1077b;
    n c;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    LazySpanLookup h = new LazySpanLookup();
    private int i = -1;
    private int j;
    private int k;
    private final i l;
    private BitSet m;
    private int n = 2;
    private boolean o;
    private boolean p;
    private SavedState q;
    private int r;
    private final Rect s = new Rect();
    private final a t = new a();
    private boolean u = false;
    private boolean v = true;
    private int[] w;
    private final Runnable x = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.a();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.i.b properties = getProperties(context, attributeSet, i2, i3);
        b(properties.f1061a);
        a(properties.f1062b);
        a(properties.c);
        this.l = new i();
        j();
    }

    public boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    private void j() {
        this.f1077b = n.a(this, this.j);
        this.c = n.a(this, 1 - this.j);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        int i2;
        int i3;
        if (getChildCount() == 0 || this.n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.e) {
            i3 = h();
            i2 = i();
        } else {
            i3 = i();
            i2 = h();
        }
        if (i3 == 0 && b() != null) {
            this.h.a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.u) {
            return false;
        } else {
            int i4 = this.e ? -1 : 1;
            int i5 = i2 + 1;
            LazySpanLookup.FullSpanItem a2 = this.h.a(i3, i5, i4, true);
            if (a2 == null) {
                this.u = false;
                this.h.a(i5);
                return false;
            }
            LazySpanLookup.FullSpanItem a3 = this.h.a(i3, a2.mPosition, i4 * -1, true);
            if (a3 == null) {
                this.h.a(a2.mPosition);
            } else {
                this.h.a(a3.mPosition + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public void onScrollStateChanged(int i2) {
        if (i2 == 0) {
            a();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.onDetachedFromWindow(recyclerView, pVar);
        removeCallbacks(this.x);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f1076a[i2].e();
        }
        recyclerView.requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View b() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.i
            r2.<init>(r3)
            int r3 = r12.i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.j
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.d()
            if (r3 == 0) goto L_0x0020
            r3 = r1
            goto L_0x0021
        L_0x0020:
            r3 = r5
        L_0x0021:
            boolean r6 = r12.e
            if (r6 == 0) goto L_0x0027
            r6 = r5
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = r1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f1083a
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f1083a
            boolean r9 = r12.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f1083a
            int r9 = r9.e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f1084b
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.e
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.n r10 = r12.f1077b
            int r10 = r10.b((android.view.View) r7)
            androidx.recyclerview.widget.n r11 = r12.f1077b
            int r11 = r11.b((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.n r10 = r12.f1077b
            int r10 = r10.a((android.view.View) r7)
            androidx.recyclerview.widget.n r11 = r12.f1077b
            int r11 = r11.a((android.view.View) r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = r1
            goto L_0x008b
        L_0x008a:
            r10 = r4
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.f1083a
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.f1083a
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = r1
            goto L_0x00a1
        L_0x00a0:
            r8 = r4
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = r1
            goto L_0x00a6
        L_0x00a5:
            r9 = r4
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b():android.view.View");
    }

    private boolean a(c cVar) {
        if (this.e) {
            if (cVar.d() < this.f1077b.e()) {
                return !cVar.c(cVar.f1085a.get(cVar.f1085a.size() - 1)).f1084b;
            }
        } else if (cVar.b() > this.f1077b.d()) {
            return !cVar.c(cVar.f1085a.get(0)).f1084b;
        }
        return false;
    }

    public void a(int i2) {
        assertNotInLayoutOrScroll((String) null);
        if (i2 != this.i) {
            c();
            this.i = i2;
            this.m = new BitSet(this.i);
            this.f1076a = new c[this.i];
            for (int i3 = 0; i3 < this.i; i3++) {
                this.f1076a[i3] = new c(i3);
            }
            requestLayout();
        }
    }

    public void b(int i2) {
        if (i2 == 0 || i2 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i2 != this.j) {
                this.j = i2;
                n nVar = this.f1077b;
                this.f1077b = this.c;
                this.c = nVar;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void a(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        SavedState savedState = this.q;
        if (!(savedState == null || savedState.mReverseLayout == z)) {
            this.q.mReverseLayout = z;
        }
        this.d = z;
        requestLayout();
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void c() {
        this.h.a();
        requestLayout();
    }

    private void k() {
        if (this.j == 1 || !d()) {
            this.e = this.d;
        } else {
            this.e = !this.d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return getLayoutDirection() == 1;
    }

    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.j == 1) {
            i5 = chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            i4 = chooseSize(i2, (this.k * this.i) + paddingLeft, getMinimumWidth());
        } else {
            i4 = chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            i5 = chooseSize(i3, (this.k * this.i) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i4, i5);
    }

    public void onLayoutChildren(RecyclerView.p pVar, RecyclerView.t tVar) {
        a(pVar, tVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0161, code lost:
        if (a() != false) goto L_0x0165;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.recyclerview.widget.RecyclerView.p r9, androidx.recyclerview.widget.RecyclerView.t r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r0 = r8.t
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.q
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.e()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.a()
            return
        L_0x0018:
            boolean r1 = r0.e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.q
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r4
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.a()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.q
            if (r5 == 0) goto L_0x0037
            r8.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            goto L_0x003e
        L_0x0037:
            r8.k()
            boolean r5 = r8.e
            r0.c = r5
        L_0x003e:
            r8.a((androidx.recyclerview.widget.RecyclerView.t) r10, (androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            r0.e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.q
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.c
            boolean r6 = r8.o
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.d()
            boolean r6 = r8.p
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.h
            r5.a()
            r0.d = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.q
            if (r5 == 0) goto L_0x006e
            int r5 = r5.mSpanOffsetsSize
            if (r5 >= r4) goto L_0x00cb
        L_0x006e:
            boolean r5 = r0.d
            if (r5 == 0) goto L_0x0090
            r1 = r3
        L_0x0073:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f1076a
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f1082b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008d
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f1076a
            r5 = r5[r1]
            int r6 = r0.f1082b
            r5.c((int) r6)
        L_0x008d:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x0090:
            if (r1 != 0) goto L_0x00b1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.t
            int[] r1 = r1.f
            if (r1 != 0) goto L_0x0099
            goto L_0x00b1
        L_0x0099:
            r1 = r3
        L_0x009a:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f1076a
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r6 = r8.t
            int[] r6 = r6.f
            r6 = r6[r1]
            r5.c((int) r6)
            int r1 = r1 + 1
            goto L_0x009a
        L_0x00b1:
            r1 = r3
        L_0x00b2:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00c4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f1076a
            r5 = r5[r1]
            boolean r6 = r8.e
            int r7 = r0.f1082b
            r5.a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00c4:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.t
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f1076a
            r1.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.c[]) r5)
        L_0x00cb:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.i r1 = r8.l
            r1.f1142a = r3
            r8.u = r3
            androidx.recyclerview.widget.n r1 = r8.c
            int r1 = r1.g()
            r8.c((int) r1)
            int r1 = r0.f1081a
            r8.b((int) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x0102
            r8.d(r2)
            androidx.recyclerview.widget.i r1 = r8.l
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.i) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
            r8.d(r4)
            androidx.recyclerview.widget.i r1 = r8.l
            int r2 = r0.f1081a
            androidx.recyclerview.widget.i r5 = r8.l
            int r5 = r5.d
            int r2 = r2 + r5
            r1.c = r2
            androidx.recyclerview.widget.i r1 = r8.l
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.i) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
            goto L_0x011d
        L_0x0102:
            r8.d(r4)
            androidx.recyclerview.widget.i r1 = r8.l
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.i) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
            r8.d(r2)
            androidx.recyclerview.widget.i r1 = r8.l
            int r2 = r0.f1081a
            androidx.recyclerview.widget.i r5 = r8.l
            int r5 = r5.d
            int r2 = r2 + r5
            r1.c = r2
            androidx.recyclerview.widget.i r1 = r8.l
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.i) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
        L_0x011d:
            r8.l()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x0137
            boolean r1 = r8.e
            if (r1 == 0) goto L_0x0131
            r8.b((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.t) r10, (boolean) r4)
            r8.c(r9, r10, r3)
            goto L_0x0137
        L_0x0131:
            r8.c(r9, r10, r4)
            r8.b((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.t) r10, (boolean) r3)
        L_0x0137:
            if (r11 == 0) goto L_0x0164
            boolean r11 = r10.a()
            if (r11 != 0) goto L_0x0164
            int r11 = r8.n
            if (r11 == 0) goto L_0x0155
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x0155
            boolean r11 = r8.u
            if (r11 != 0) goto L_0x0153
            android.view.View r11 = r8.b()
            if (r11 == 0) goto L_0x0155
        L_0x0153:
            r11 = r4
            goto L_0x0156
        L_0x0155:
            r11 = r3
        L_0x0156:
            if (r11 == 0) goto L_0x0164
            java.lang.Runnable r11 = r8.x
            r8.removeCallbacks(r11)
            boolean r11 = r8.a()
            if (r11 == 0) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r4 = r3
        L_0x0165:
            boolean r11 = r10.a()
            if (r11 == 0) goto L_0x0170
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.t
            r11.a()
        L_0x0170:
            boolean r11 = r0.c
            r8.o = r11
            boolean r11 = r8.d()
            r8.p = r11
            if (r4 == 0) goto L_0x0184
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.t
            r11.a()
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.t) r10, (boolean) r3)
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t, boolean):void");
    }

    public void onLayoutCompleted(RecyclerView.t tVar) {
        super.onLayoutCompleted(tVar);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.q = null;
        this.t.a();
    }

    private void l() {
        if (this.c.i() != 1073741824) {
            int childCount = getChildCount();
            float f2 = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                float e2 = (float) this.c.e(childAt);
                if (e2 >= f2) {
                    if (((b) childAt.getLayoutParams()).a()) {
                        e2 = (e2 * 1.0f) / ((float) this.i);
                    }
                    f2 = Math.max(f2, e2);
                }
            }
            int i3 = this.k;
            int round = Math.round(f2 * ((float) this.i));
            if (this.c.i() == Integer.MIN_VALUE) {
                round = Math.min(round, this.c.g());
            }
            c(round);
            if (this.k != i3) {
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = getChildAt(i4);
                    b bVar = (b) childAt2.getLayoutParams();
                    if (!bVar.f1084b) {
                        if (!d() || this.j != 1) {
                            int i5 = bVar.f1083a.e * this.k;
                            int i6 = bVar.f1083a.e * i3;
                            if (this.j == 1) {
                                childAt2.offsetLeftAndRight(i5 - i6);
                            } else {
                                childAt2.offsetTopAndBottom(i5 - i6);
                            }
                        } else {
                            childAt2.offsetLeftAndRight(((-((this.i - 1) - bVar.f1083a.e)) * this.k) - ((-((this.i - 1) - bVar.f1083a.e)) * i3));
                        }
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        int i2;
        if (this.q.mSpanOffsetsSize > 0) {
            if (this.q.mSpanOffsetsSize == this.i) {
                for (int i3 = 0; i3 < this.i; i3++) {
                    this.f1076a[i3].e();
                    int i4 = this.q.mSpanOffsets[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (this.q.mAnchorLayoutFromEnd) {
                            i2 = this.f1077b.e();
                        } else {
                            i2 = this.f1077b.d();
                        }
                        i4 += i2;
                    }
                    this.f1076a[i3].c(i4);
                }
            } else {
                this.q.invalidateSpanInfo();
                SavedState savedState = this.q;
                savedState.mAnchorPosition = savedState.mVisibleAnchorPosition;
            }
        }
        this.p = this.q.mLastLayoutRTL;
        a(this.q.mReverseLayout);
        k();
        if (this.q.mAnchorPosition != -1) {
            this.f = this.q.mAnchorPosition;
            aVar.c = this.q.mAnchorLayoutFromEnd;
        } else {
            aVar.c = this.e;
        }
        if (this.q.mSpanLookupSize > 1) {
            this.h.f1079a = this.q.mSpanLookup;
            this.h.f1080b = this.q.mFullSpanItems;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.t tVar, a aVar) {
        if (!b(tVar, aVar) && !c(tVar, aVar)) {
            aVar.b();
            aVar.f1081a = 0;
        }
    }

    private boolean c(RecyclerView.t tVar, a aVar) {
        int i2;
        if (this.o) {
            i2 = n(tVar.e());
        } else {
            i2 = m(tVar.e());
        }
        aVar.f1081a = i2;
        aVar.f1082b = Integer.MIN_VALUE;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b(RecyclerView.t tVar, a aVar) {
        int i2;
        int i3;
        int i4;
        boolean z = false;
        if (!tVar.a() && (i2 = this.f) != -1) {
            if (i2 < 0 || i2 >= tVar.e()) {
                this.f = -1;
                this.g = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.q;
                if (savedState == null || savedState.mAnchorPosition == -1 || this.q.mSpanOffsetsSize < 1) {
                    View findViewByPosition = findViewByPosition(this.f);
                    if (findViewByPosition != null) {
                        if (this.e) {
                            i3 = h();
                        } else {
                            i3 = i();
                        }
                        aVar.f1081a = i3;
                        if (this.g != Integer.MIN_VALUE) {
                            if (aVar.c) {
                                aVar.f1082b = (this.f1077b.e() - this.g) - this.f1077b.b(findViewByPosition);
                            } else {
                                aVar.f1082b = (this.f1077b.d() + this.g) - this.f1077b.a(findViewByPosition);
                            }
                            return true;
                        } else if (this.f1077b.e(findViewByPosition) > this.f1077b.g()) {
                            if (aVar.c) {
                                i4 = this.f1077b.e();
                            } else {
                                i4 = this.f1077b.d();
                            }
                            aVar.f1082b = i4;
                            return true;
                        } else {
                            int a2 = this.f1077b.a(findViewByPosition) - this.f1077b.d();
                            if (a2 < 0) {
                                aVar.f1082b = -a2;
                                return true;
                            }
                            int e2 = this.f1077b.e() - this.f1077b.b(findViewByPosition);
                            if (e2 < 0) {
                                aVar.f1082b = e2;
                                return true;
                            }
                            aVar.f1082b = Integer.MIN_VALUE;
                        }
                    } else {
                        aVar.f1081a = this.f;
                        int i5 = this.g;
                        if (i5 == Integer.MIN_VALUE) {
                            if (l(aVar.f1081a) == 1) {
                                z = true;
                            }
                            aVar.c = z;
                            aVar.b();
                        } else {
                            aVar.a(i5);
                        }
                        aVar.d = true;
                    }
                } else {
                    aVar.f1082b = Integer.MIN_VALUE;
                    aVar.f1081a = this.f;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.k = i2 / this.i;
        this.r = View.MeasureSpec.makeMeasureSpec(i2, this.c.i());
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.q == null;
    }

    public int computeHorizontalScrollOffset(RecyclerView.t tVar) {
        return a(tVar);
    }

    private int a(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return q.a(tVar, this.f1077b, b(!this.v), c(!this.v), this, this.v, this.e);
    }

    public int computeVerticalScrollOffset(RecyclerView.t tVar) {
        return a(tVar);
    }

    public int computeHorizontalScrollExtent(RecyclerView.t tVar) {
        return b(tVar);
    }

    private int b(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return q.a(tVar, this.f1077b, b(!this.v), c(!this.v), this, this.v);
    }

    public int computeVerticalScrollExtent(RecyclerView.t tVar) {
        return b(tVar);
    }

    public int computeHorizontalScrollRange(RecyclerView.t tVar) {
        return c(tVar);
    }

    private int c(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return q.b(tVar, this.f1077b, b(!this.v), c(!this.v), this, this.v);
    }

    public int computeVerticalScrollRange(RecyclerView.t tVar) {
        return c(tVar);
    }

    private void a(View view, b bVar, boolean z) {
        if (bVar.f1084b) {
            if (this.j == 1) {
                a(view, this.r, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true), z);
            } else {
                a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), this.r, z);
            }
        } else if (this.j == 1) {
            a(view, getChildMeasureSpec(this.k, getWidthMode(), 0, bVar.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true), z);
        } else {
            a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), getChildMeasureSpec(this.k, getHeightMode(), 0, bVar.height, false), z);
        }
    }

    private void a(View view, int i2, int i3, boolean z) {
        boolean z2;
        calculateItemDecorationsForChild(view, this.s);
        b bVar = (b) view.getLayoutParams();
        int a2 = a(i2, bVar.leftMargin + this.s.left, bVar.rightMargin + this.s.right);
        int a3 = a(i3, bVar.topMargin + this.s.top, bVar.bottomMargin + this.s.bottom);
        if (z) {
            z2 = shouldReMeasureChild(view, a2, a3, bVar);
        } else {
            z2 = shouldMeasureChild(view, a2, a3, bVar);
        }
        if (z2) {
            view.measure(a2, a3);
        }
    }

    private int a(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode);
        }
        return i2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.q = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i2;
        int i3;
        int i4;
        SavedState savedState = this.q;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.mReverseLayout = this.d;
        savedState2.mAnchorLayoutFromEnd = this.o;
        savedState2.mLastLayoutRTL = this.p;
        LazySpanLookup lazySpanLookup = this.h;
        if (lazySpanLookup == null || lazySpanLookup.f1079a == null) {
            savedState2.mSpanLookupSize = 0;
        } else {
            savedState2.mSpanLookup = this.h.f1079a;
            savedState2.mSpanLookupSize = savedState2.mSpanLookup.length;
            savedState2.mFullSpanItems = this.h.f1080b;
        }
        if (getChildCount() > 0) {
            if (this.o) {
                i2 = h();
            } else {
                i2 = i();
            }
            savedState2.mAnchorPosition = i2;
            savedState2.mVisibleAnchorPosition = e();
            int i5 = this.i;
            savedState2.mSpanOffsetsSize = i5;
            savedState2.mSpanOffsets = new int[i5];
            for (int i6 = 0; i6 < this.i; i6++) {
                if (this.o) {
                    i3 = this.f1076a[i6].b(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.f1077b.e();
                    } else {
                        savedState2.mSpanOffsets[i6] = i3;
                    }
                } else {
                    i3 = this.f1076a[i6].a(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.f1077b.d();
                    } else {
                        savedState2.mSpanOffsets[i6] = i3;
                    }
                }
                i3 -= i4;
                savedState2.mSpanOffsets[i6] = i3;
            }
        } else {
            savedState2.mAnchorPosition = -1;
            savedState2.mVisibleAnchorPosition = -1;
            savedState2.mSpanOffsetsSize = 0;
        }
        return savedState2;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.p pVar, RecyclerView.t tVar, View view, d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int i2 = 1;
        if (this.j == 0) {
            int b2 = bVar.b();
            if (bVar.f1084b) {
                i2 = this.i;
            }
            dVar.b((Object) d.c.a(b2, i2, -1, -1, false, false));
            return;
        }
        int b3 = bVar.b();
        if (bVar.f1084b) {
            i2 = this.i;
        }
        dVar.b((Object) d.c.a(-1, -1, b3, i2, false, false));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View b2 = b(false);
            View c2 = c(false);
            if (b2 != null && c2 != null) {
                int position = getPosition(b2);
                int position2 = getPosition(c2);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int e() {
        View view;
        if (this.e) {
            view = c(true);
        } else {
            view = b(true);
        }
        if (view == null) {
            return -1;
        }
        return getPosition(view);
    }

    public int getRowCountForAccessibility(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.j == 0) {
            return this.i;
        }
        return super.getRowCountForAccessibility(pVar, tVar);
    }

    public int getColumnCountForAccessibility(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.j == 1) {
            return this.i;
        }
        return super.getColumnCountForAccessibility(pVar, tVar);
    }

    /* access modifiers changed from: package-private */
    public View b(boolean z) {
        int d2 = this.f1077b.d();
        int e2 = this.f1077b.e();
        int childCount = getChildCount();
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int a2 = this.f1077b.a(childAt);
            if (this.f1077b.b(childAt) > d2 && a2 < e2) {
                if (a2 >= d2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View c(boolean z) {
        int d2 = this.f1077b.d();
        int e2 = this.f1077b.e();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int a2 = this.f1077b.a(childAt);
            int b2 = this.f1077b.b(childAt);
            if (b2 > d2 && a2 < e2) {
                if (b2 <= e2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int e2;
        int i2 = i(Integer.MIN_VALUE);
        if (i2 != Integer.MIN_VALUE && (e2 = this.f1077b.e() - i2) > 0) {
            int i3 = e2 - (-a(-e2, pVar, tVar));
            if (z && i3 > 0) {
                this.f1077b.a(i3);
            }
        }
    }

    private void c(RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int d2;
        int h2 = h(Integer.MAX_VALUE);
        if (h2 != Integer.MAX_VALUE && (d2 = h2 - this.f1077b.d()) > 0) {
            int a2 = d2 - a(d2, pVar, tVar);
            if (z && a2 > 0) {
                this.f1077b.a(-a2);
            }
        }
    }

    private void b(int i2, RecyclerView.t tVar) {
        int i3;
        int i4;
        int c2;
        i iVar = this.l;
        boolean z = false;
        iVar.f1143b = 0;
        iVar.c = i2;
        if (!isSmoothScrolling() || (c2 = tVar.c()) == -1) {
            i4 = 0;
            i3 = 0;
        } else {
            if (this.e == (c2 < i2)) {
                i4 = this.f1077b.g();
                i3 = 0;
            } else {
                i3 = this.f1077b.g();
                i4 = 0;
            }
        }
        if (getClipToPadding()) {
            this.l.f = this.f1077b.d() - i3;
            this.l.g = this.f1077b.e() + i4;
        } else {
            this.l.g = this.f1077b.f() + i4;
            this.l.f = -i3;
        }
        i iVar2 = this.l;
        iVar2.h = false;
        iVar2.f1142a = true;
        if (this.f1077b.i() == 0 && this.f1077b.f() == 0) {
            z = true;
        }
        iVar2.i = z;
    }

    private void d(int i2) {
        i iVar = this.l;
        iVar.e = i2;
        int i3 = 1;
        if (this.e != (i2 == -1)) {
            i3 = -1;
        }
        iVar.d = i3;
    }

    public void offsetChildrenHorizontal(int i2) {
        super.offsetChildrenHorizontal(i2);
        for (int i3 = 0; i3 < this.i; i3++) {
            this.f1076a[i3].d(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        super.offsetChildrenVertical(i2);
        for (int i3 = 0; i3 < this.i; i3++) {
            this.f1076a[i3].d(i2);
        }
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        b(i2, i3, 2);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        b(i2, i3, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.h.a();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        b(i2, i3, 8);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        b(i2, i3, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.e
            if (r0 == 0) goto L_0x0009
            int r0 = r6.h()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.i()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L_0x001f
        L_0x001b:
            int r2 = r7 + r8
        L_0x001d:
            r3 = r2
            r2 = r7
        L_0x001f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.h
            r4.b(r2)
            r4 = 1
            if (r9 == r4) goto L_0x003e
            r5 = 2
            if (r9 == r5) goto L_0x0038
            if (r9 == r1) goto L_0x002d
            goto L_0x0043
        L_0x002d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h
            r9.a((int) r7, (int) r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.h
            r7.b(r8, r4)
            goto L_0x0043
        L_0x0038:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h
            r9.a((int) r7, (int) r8)
            goto L_0x0043
        L_0x003e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h
            r9.b(r7, r8)
        L_0x0043:
            if (r3 > r0) goto L_0x0046
            return
        L_0x0046:
            boolean r7 = r6.e
            if (r7 == 0) goto L_0x004f
            int r7 = r6.i()
            goto L_0x0053
        L_0x004f:
            int r7 = r6.h()
        L_0x0053:
            if (r2 > r7) goto L_0x0058
            r6.requestLayout()
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, int, int):void");
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v4 */
    private int a(RecyclerView.p pVar, i iVar, RecyclerView.t tVar) {
        int i2;
        int i3;
        int i4;
        c cVar;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        RecyclerView.p pVar2 = pVar;
        i iVar2 = iVar;
        ? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i) {
            i2 = iVar2.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (iVar2.e == 1) {
            i2 = iVar2.g + iVar2.f1143b;
        } else {
            i2 = iVar2.f - iVar2.f1143b;
        }
        int i13 = i2;
        a(iVar2.e, i13);
        if (this.e) {
            i3 = this.f1077b.e();
        } else {
            i3 = this.f1077b.d();
        }
        int i14 = i3;
        boolean z3 = false;
        while (iVar.a(tVar) && (this.l.i || !this.m.isEmpty())) {
            View a2 = iVar2.a(pVar2);
            b bVar = (b) a2.getLayoutParams();
            int f2 = bVar.f();
            int c2 = this.h.c(f2);
            boolean z4 = c2 == -1 ? true : r9;
            if (z4) {
                cVar = bVar.f1084b ? this.f1076a[r9] : a(iVar2);
                this.h.a(f2, cVar);
            } else {
                cVar = this.f1076a[c2];
            }
            c cVar2 = cVar;
            bVar.f1083a = cVar2;
            if (iVar2.e == 1) {
                addView(a2);
            } else {
                addView(a2, r9);
            }
            a(a2, bVar, (boolean) r9);
            if (iVar2.e == 1) {
                if (bVar.f1084b) {
                    i12 = i(i14);
                } else {
                    i12 = cVar2.b(i14);
                }
                int e2 = this.f1077b.e(a2) + i12;
                if (z4 && bVar.f1084b) {
                    LazySpanLookup.FullSpanItem e3 = e(i12);
                    e3.mGapDir = -1;
                    e3.mPosition = f2;
                    this.h.a(e3);
                }
                i5 = e2;
                i6 = i12;
            } else {
                if (bVar.f1084b) {
                    i11 = h(i14);
                } else {
                    i11 = cVar2.a(i14);
                }
                i6 = i11 - this.f1077b.e(a2);
                if (z4 && bVar.f1084b) {
                    LazySpanLookup.FullSpanItem f3 = f(i11);
                    f3.mGapDir = 1;
                    f3.mPosition = f2;
                    this.h.a(f3);
                }
                i5 = i11;
            }
            if (bVar.f1084b && iVar2.d == -1) {
                if (z4) {
                    this.u = true;
                } else {
                    if (iVar2.e == 1) {
                        z2 = f();
                    } else {
                        z2 = g();
                    }
                    if (!z2) {
                        LazySpanLookup.FullSpanItem f4 = this.h.f(f2);
                        if (f4 != null) {
                            f4.mHasUnwantedGapAfter = true;
                        }
                        this.u = true;
                    }
                }
            }
            a(a2, bVar, iVar2);
            if (!d() || this.j != 1) {
                if (bVar.f1084b) {
                    i9 = this.c.d();
                } else {
                    i9 = (cVar2.e * this.k) + this.c.d();
                }
                i8 = i9;
                i7 = this.c.e(a2) + i9;
            } else {
                if (bVar.f1084b) {
                    i10 = this.c.e();
                } else {
                    i10 = this.c.e() - (((this.i - 1) - cVar2.e) * this.k);
                }
                i7 = i10;
                i8 = i10 - this.c.e(a2);
            }
            if (this.j == 1) {
                layoutDecoratedWithMargins(a2, i8, i6, i7, i5);
            } else {
                layoutDecoratedWithMargins(a2, i6, i8, i5, i7);
            }
            if (bVar.f1084b) {
                a(this.l.e, i13);
            } else {
                a(cVar2, this.l.e, i13);
            }
            a(pVar2, this.l);
            if (this.l.h && a2.hasFocusable()) {
                if (bVar.f1084b) {
                    this.m.clear();
                } else {
                    z = false;
                    this.m.set(cVar2.e, false);
                    r9 = z;
                    z3 = true;
                }
            }
            z = false;
            r9 = z;
            z3 = true;
        }
        int i15 = r9;
        if (!z3) {
            a(pVar2, this.l);
        }
        if (this.l.e == -1) {
            i4 = this.f1077b.d() - h(this.f1077b.d());
        } else {
            i4 = i(this.f1077b.e()) - this.f1077b.e();
        }
        return i4 > 0 ? Math.min(iVar2.f1143b, i4) : i15;
    }

    private LazySpanLookup.FullSpanItem e(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.i];
        for (int i3 = 0; i3 < this.i; i3++) {
            fullSpanItem.mGapPerSpan[i3] = i2 - this.f1076a[i3].b(i2);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem f(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.i];
        for (int i3 = 0; i3 < this.i; i3++) {
            fullSpanItem.mGapPerSpan[i3] = this.f1076a[i3].a(i2) - i2;
        }
        return fullSpanItem;
    }

    private void a(View view, b bVar, i iVar) {
        if (iVar.e == 1) {
            if (bVar.f1084b) {
                a(view);
            } else {
                bVar.f1083a.b(view);
            }
        } else if (bVar.f1084b) {
            b(view);
        } else {
            bVar.f1083a.a(view);
        }
    }

    private void a(RecyclerView.p pVar, i iVar) {
        int i2;
        int i3;
        if (iVar.f1142a && !iVar.i) {
            if (iVar.f1143b == 0) {
                if (iVar.e == -1) {
                    b(pVar, iVar.g);
                } else {
                    a(pVar, iVar.f);
                }
            } else if (iVar.e == -1) {
                int g2 = iVar.f - g(iVar.f);
                if (g2 < 0) {
                    i3 = iVar.g;
                } else {
                    i3 = iVar.g - Math.min(g2, iVar.f1143b);
                }
                b(pVar, i3);
            } else {
                int j2 = j(iVar.g) - iVar.g;
                if (j2 < 0) {
                    i2 = iVar.f;
                } else {
                    i2 = Math.min(j2, iVar.f1143b) + iVar.f;
                }
                a(pVar, i2);
            }
        }
    }

    private void a(View view) {
        for (int i2 = this.i - 1; i2 >= 0; i2--) {
            this.f1076a[i2].b(view);
        }
    }

    private void b(View view) {
        for (int i2 = this.i - 1; i2 >= 0; i2--) {
            this.f1076a[i2].a(view);
        }
    }

    private void a(int i2, int i3) {
        for (int i4 = 0; i4 < this.i; i4++) {
            if (!this.f1076a[i4].f1085a.isEmpty()) {
                a(this.f1076a[i4], i2, i3);
            }
        }
    }

    private void a(c cVar, int i2, int i3) {
        int i4 = cVar.i();
        if (i2 == -1) {
            if (cVar.b() + i4 <= i3) {
                this.m.set(cVar.e, false);
            }
        } else if (cVar.d() - i4 >= i3) {
            this.m.set(cVar.e, false);
        }
    }

    private int g(int i2) {
        int a2 = this.f1076a[0].a(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int a3 = this.f1076a[i3].a(i2);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int h(int i2) {
        int a2 = this.f1076a[0].a(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int a3 = this.f1076a[i3].a(i2);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        int b2 = this.f1076a[0].b(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.i; i2++) {
            if (this.f1076a[i2].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        int a2 = this.f1076a[0].a(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.i; i2++) {
            if (this.f1076a[i2].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    private int i(int i2) {
        int b2 = this.f1076a[0].b(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int b3 = this.f1076a[i3].b(i2);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int j(int i2) {
        int b2 = this.f1076a[0].b(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int b3 = this.f1076a[i3].b(i2);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void a(RecyclerView.p pVar, int i2) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f1077b.b(childAt) <= i2 && this.f1077b.c(childAt) <= i2) {
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.f1084b) {
                    int i3 = 0;
                    while (i3 < this.i) {
                        if (this.f1076a[i3].f1085a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.i; i4++) {
                        this.f1076a[i4].h();
                    }
                } else if (bVar.f1083a.f1085a.size() != 1) {
                    bVar.f1083a.h();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, pVar);
            } else {
                return;
            }
        }
    }

    private void b(RecyclerView.p pVar, int i2) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f1077b.a(childAt) >= i2 && this.f1077b.d(childAt) >= i2) {
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.f1084b) {
                    int i3 = 0;
                    while (i3 < this.i) {
                        if (this.f1076a[i3].f1085a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.i; i4++) {
                        this.f1076a[i4].g();
                    }
                } else if (bVar.f1083a.f1085a.size() != 1) {
                    bVar.f1083a.g();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, pVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean k(int i2) {
        if (this.j == 0) {
            if ((i2 == -1) != this.e) {
                return true;
            }
            return false;
        }
        if (((i2 == -1) == this.e) == d()) {
            return true;
        }
        return false;
    }

    private c a(i iVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (k(iVar.e)) {
            i3 = this.i - 1;
            i2 = -1;
        } else {
            i3 = 0;
            i4 = this.i;
            i2 = 1;
        }
        c cVar = null;
        if (iVar.e == 1) {
            int i5 = Integer.MAX_VALUE;
            int d2 = this.f1077b.d();
            while (i3 != i4) {
                c cVar2 = this.f1076a[i3];
                int b2 = cVar2.b(d2);
                if (b2 < i5) {
                    cVar = cVar2;
                    i5 = b2;
                }
                i3 += i2;
            }
            return cVar;
        }
        int i6 = Integer.MIN_VALUE;
        int e2 = this.f1077b.e();
        while (i3 != i4) {
            c cVar3 = this.f1076a[i3];
            int a2 = cVar3.a(e2);
            if (a2 > i6) {
                cVar = cVar3;
                i6 = a2;
            }
            i3 += i2;
        }
        return cVar;
    }

    public boolean canScrollVertically() {
        return this.j == 1;
    }

    public boolean canScrollHorizontally() {
        return this.j == 0;
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        return a(i2, pVar, tVar);
    }

    public int scrollVerticallyBy(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        return a(i2, pVar, tVar);
    }

    private int l(int i2) {
        if (getChildCount() != 0) {
            if ((i2 < i()) != this.e) {
                return -1;
            }
            return 1;
        } else if (this.e) {
            return 1;
        } else {
            return -1;
        }
    }

    public PointF computeScrollVectorForPosition(int i2) {
        int l2 = l(i2);
        PointF pointF = new PointF();
        if (l2 == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = (float) l2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) l2;
        }
        return pointF;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.t tVar, int i2) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i2);
        startSmoothScroll(jVar);
    }

    public void scrollToPosition(int i2) {
        SavedState savedState = this.q;
        if (!(savedState == null || savedState.mAnchorPosition == i2)) {
            this.q.invalidateAnchorPositionInfo();
        }
        this.f = i2;
        this.g = Integer.MIN_VALUE;
        requestLayout();
    }

    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.t tVar, RecyclerView.i.a aVar) {
        int i4;
        int i5;
        if (this.j != 0) {
            i2 = i3;
        }
        if (getChildCount() != 0 && i2 != 0) {
            a(i2, tVar);
            int[] iArr = this.w;
            if (iArr == null || iArr.length < this.i) {
                this.w = new int[this.i];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.i; i7++) {
                if (this.l.d == -1) {
                    i5 = this.l.f;
                    i4 = this.f1076a[i7].a(this.l.f);
                } else {
                    i5 = this.f1076a[i7].b(this.l.g);
                    i4 = this.l.g;
                }
                int i8 = i5 - i4;
                if (i8 >= 0) {
                    this.w[i6] = i8;
                    i6++;
                }
            }
            Arrays.sort(this.w, 0, i6);
            for (int i9 = 0; i9 < i6 && this.l.a(tVar); i9++) {
                aVar.b(this.l.c, this.w[i9]);
                this.l.c += this.l.d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, RecyclerView.t tVar) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = h();
            i3 = 1;
        } else {
            i3 = -1;
            i4 = i();
        }
        this.l.f1142a = true;
        b(i4, tVar);
        d(i3);
        i iVar = this.l;
        iVar.c = i4 + iVar.d;
        this.l.f1143b = Math.abs(i2);
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        a(i2, tVar);
        int a2 = a(pVar, this.l, tVar);
        if (this.l.f1143b >= a2) {
            i2 = i2 < 0 ? -a2 : a2;
        }
        this.f1077b.a(-i2);
        this.o = this.e;
        i iVar = this.l;
        iVar.f1143b = 0;
        a(pVar, iVar);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    /* access modifiers changed from: package-private */
    public int i() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int m(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            int position = getPosition(getChildAt(i3));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    private int n(int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    public RecyclerView.j generateDefaultLayoutParams() {
        if (this.j == 0) {
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

    public View onFocusSearchFailed(View view, int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        View findContainingItemView;
        int i3;
        int i4;
        int i5;
        int i6;
        View a2;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        k();
        int o2 = o(i2);
        if (o2 == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) findContainingItemView.getLayoutParams();
        boolean z = bVar.f1084b;
        c cVar = bVar.f1083a;
        if (o2 == 1) {
            i3 = h();
        } else {
            i3 = i();
        }
        b(i3, tVar);
        d(o2);
        i iVar = this.l;
        iVar.c = iVar.d + i3;
        this.l.f1143b = (int) (((float) this.f1077b.g()) * 0.33333334f);
        i iVar2 = this.l;
        iVar2.h = true;
        iVar2.f1142a = false;
        a(pVar, iVar2, tVar);
        this.o = this.e;
        if (!z && (a2 = cVar.a(i3, o2)) != null && a2 != findContainingItemView) {
            return a2;
        }
        if (k(o2)) {
            for (int i7 = this.i - 1; i7 >= 0; i7--) {
                View a3 = this.f1076a[i7].a(i3, o2);
                if (a3 != null && a3 != findContainingItemView) {
                    return a3;
                }
            }
        } else {
            for (int i8 = 0; i8 < this.i; i8++) {
                View a4 = this.f1076a[i8].a(i3, o2);
                if (a4 != null && a4 != findContainingItemView) {
                    return a4;
                }
            }
        }
        boolean z2 = (this.d ^ true) == (o2 == -1);
        if (!z) {
            if (z2) {
                i6 = cVar.j();
            } else {
                i6 = cVar.k();
            }
            View findViewByPosition = findViewByPosition(i6);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (k(o2)) {
            for (int i9 = this.i - 1; i9 >= 0; i9--) {
                if (i9 != cVar.e) {
                    if (z2) {
                        i5 = this.f1076a[i9].j();
                    } else {
                        i5 = this.f1076a[i9].k();
                    }
                    View findViewByPosition2 = findViewByPosition(i5);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i10 = 0; i10 < this.i; i10++) {
                if (z2) {
                    i4 = this.f1076a[i10].j();
                } else {
                    i4 = this.f1076a[i10].k();
                }
                View findViewByPosition3 = findViewByPosition(i4);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    private int o(int i2) {
        if (i2 == 1) {
            return (this.j != 1 && d()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.j != 1 && d()) ? -1 : 1;
        }
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        return Integer.MIN_VALUE;
                    }
                    return this.j == 1 ? 1 : Integer.MIN_VALUE;
                } else if (this.j == 0) {
                    return 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.j == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.j == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static class b extends RecyclerView.j {

        /* renamed from: a  reason: collision with root package name */
        c f1083a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1084b;

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

        public boolean a() {
            return this.f1084b;
        }

        public final int b() {
            c cVar = this.f1083a;
            if (cVar == null) {
                return -1;
            }
            return cVar.e;
        }
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f1085a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f1086b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        c(int i) {
            this.e = i;
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            int i2 = this.f1086b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1085a.size() == 0) {
                return i;
            }
            a();
            return this.f1086b;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            LazySpanLookup.FullSpanItem f2;
            View view = this.f1085a.get(0);
            b c2 = c(view);
            this.f1086b = StaggeredGridLayoutManager.this.f1077b.a(view);
            if (c2.f1084b && (f2 = StaggeredGridLayoutManager.this.h.f(c2.f())) != null && f2.mGapDir == -1) {
                this.f1086b -= f2.getGapForSpan(this.e);
            }
        }

        /* access modifiers changed from: package-private */
        public int b() {
            int i = this.f1086b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.f1086b;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1085a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            LazySpanLookup.FullSpanItem f2;
            ArrayList<View> arrayList = this.f1085a;
            View view = arrayList.get(arrayList.size() - 1);
            b c2 = c(view);
            this.c = StaggeredGridLayoutManager.this.f1077b.b(view);
            if (c2.f1084b && (f2 = StaggeredGridLayoutManager.this.h.f(c2.f())) != null && f2.mGapDir == 1) {
                this.c += f2.getGapForSpan(this.e);
            }
        }

        /* access modifiers changed from: package-private */
        public int d() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            b c2 = c(view);
            c2.f1083a = this;
            this.f1085a.add(0, view);
            this.f1086b = Integer.MIN_VALUE;
            if (this.f1085a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.d += StaggeredGridLayoutManager.this.f1077b.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(View view) {
            b c2 = c(view);
            c2.f1083a = this;
            this.f1085a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.f1085a.size() == 1) {
                this.f1086b = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.d += StaggeredGridLayoutManager.this.f1077b.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z, int i) {
            int i2;
            if (z) {
                i2 = b(Integer.MIN_VALUE);
            } else {
                i2 = a(Integer.MIN_VALUE);
            }
            e();
            if (i2 != Integer.MIN_VALUE) {
                if (z && i2 < StaggeredGridLayoutManager.this.f1077b.e()) {
                    return;
                }
                if (z || i2 <= StaggeredGridLayoutManager.this.f1077b.d()) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.c = i2;
                    this.f1086b = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f1085a.clear();
            f();
            this.d = 0;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f1086b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void c(int i) {
            this.f1086b = i;
            this.c = i;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int size = this.f1085a.size();
            View remove = this.f1085a.remove(size - 1);
            b c2 = c(remove);
            c2.f1083a = null;
            if (c2.d() || c2.e()) {
                this.d -= StaggeredGridLayoutManager.this.f1077b.e(remove);
            }
            if (size == 1) {
                this.f1086b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            View remove = this.f1085a.remove(0);
            b c2 = c(remove);
            c2.f1083a = null;
            if (this.f1085a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.d -= StaggeredGridLayoutManager.this.f1077b.e(remove);
            }
            this.f1086b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.d;
        }

        /* access modifiers changed from: package-private */
        public b c(View view) {
            return (b) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public void d(int i) {
            int i2 = this.f1086b;
            if (i2 != Integer.MIN_VALUE) {
                this.f1086b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(this.f1085a.size() - 1, -1, true);
            }
            return a(0, this.f1085a.size(), true);
        }

        public int k() {
            if (StaggeredGridLayoutManager.this.d) {
                return a(0, this.f1085a.size(), true);
            }
            return a(this.f1085a.size() - 1, -1, true);
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int d2 = StaggeredGridLayoutManager.this.f1077b.d();
            int e2 = StaggeredGridLayoutManager.this.f1077b.e();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f1085a.get(i);
                int a2 = StaggeredGridLayoutManager.this.f1077b.a(view);
                int b2 = StaggeredGridLayoutManager.this.f1077b.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a2 < e2 : a2 <= e2;
                if (!z3 ? b2 > d2 : b2 >= d2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (a2 < d2 || b2 > e2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (a2 >= d2 && b2 <= e2) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f1085a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f1085a.get(size);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.getPosition(view2) >= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.getPosition(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1085a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f1085a.get(i3);
                    if ((StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.getPosition(view3) <= i) || ((!StaggeredGridLayoutManager.this.d && StaggeredGridLayoutManager.this.getPosition(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f1079a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f1080b;

        LazySpanLookup() {
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            List<FullSpanItem> list = this.f1080b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1080b.get(size).mPosition >= i) {
                        this.f1080b.remove(size);
                    }
                }
            }
            return b(i);
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            int[] iArr = this.f1079a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                int[] iArr2 = this.f1079a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f1079a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f1079a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int c(int i) {
            int[] iArr = this.f1079a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        public void a(int i, c cVar) {
            e(i);
            this.f1079a[i] = cVar.e;
        }

        /* access modifiers changed from: package-private */
        public int d(int i) {
            int length = this.f1079a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        public void e(int i) {
            int[] iArr = this.f1079a;
            if (iArr == null) {
                this.f1079a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f1079a, -1);
            } else if (i >= iArr.length) {
                this.f1079a = new int[d(i)];
                System.arraycopy(iArr, 0, this.f1079a, 0, iArr.length);
                int[] iArr2 = this.f1079a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f1079a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1080b = null;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            int[] iArr = this.f1079a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                e(i3);
                int[] iArr2 = this.f1079a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f1079a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                c(i, i2);
            }
        }

        private void c(int i, int i2) {
            List<FullSpanItem> list = this.f1080b;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f1080b.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.f1080b.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i, int i2) {
            int[] iArr = this.f1079a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                e(i3);
                int[] iArr2 = this.f1079a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f1079a, i, i3, -1);
                d(i, i2);
            }
        }

        private void d(int i, int i2) {
            List<FullSpanItem> list = this.f1080b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f1080b.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.f1080b == null) {
                return -1;
            }
            FullSpanItem f = f(i);
            if (f != null) {
                this.f1080b.remove(f);
            }
            int size = this.f1080b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f1080b.get(i2).mPosition >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f1080b.remove(i2);
            return this.f1080b.get(i2).mPosition;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f1080b == null) {
                this.f1080b = new ArrayList();
            }
            int size = this.f1080b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f1080b.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.f1080b.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.f1080b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f1080b.add(fullSpanItem);
        }

        public FullSpanItem f(int i) {
            List<FullSpanItem> list = this.f1080b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f1080b.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem a(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f1080b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f1080b.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i && (i3 == 0 || fullSpanItem.mGapDir == i3 || (z && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: a */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.mGapPerSpan = new int[readInt];
                    parcel.readIntArray(this.mGapPerSpan);
                }
            }

            FullSpanItem() {
            }

            /* access modifiers changed from: package-private */
            public int getGapForSpan(int i) {
                int[] iArr = this.mGapPerSpan;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            this.mSpanOffsetsSize = parcel.readInt();
            int i = this.mSpanOffsetsSize;
            if (i > 0) {
                this.mSpanOffsets = new int[i];
                parcel.readIntArray(this.mSpanOffsets);
            }
            this.mSpanLookupSize = parcel.readInt();
            int i2 = this.mSpanLookupSize;
            if (i2 > 0) {
                this.mSpanLookup = new int[i2];
                parcel.readIntArray(this.mSpanLookup);
            }
            boolean z = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1 ? true : z;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        /* access modifiers changed from: package-private */
        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        /* access modifiers changed from: package-private */
        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f1081a;

        /* renamed from: b  reason: collision with root package name */
        int f1082b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1081a = -1;
            this.f1082b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.f1076a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = cVarArr[i].a(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i;
            if (this.c) {
                i = StaggeredGridLayoutManager.this.f1077b.e();
            } else {
                i = StaggeredGridLayoutManager.this.f1077b.d();
            }
            this.f1082b = i;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (this.c) {
                this.f1082b = StaggeredGridLayoutManager.this.f1077b.e() - i;
            } else {
                this.f1082b = StaggeredGridLayoutManager.this.f1077b.d() + i;
            }
        }
    }
}
