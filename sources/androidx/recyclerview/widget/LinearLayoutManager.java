package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.i implements RecyclerView.s.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    n mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.p pVar, RecyclerView.t tVar, a aVar, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.i.b properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f1061a);
        setReverseLayout(properties.c);
        setStackFromEnd(properties.d);
    }

    public RecyclerView.j generateDefaultLayoutParams() {
        return new RecyclerView.j(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.onDetachedFromWindow(recyclerView, pVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(pVar);
            pVar.a();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState2.mAnchorLayoutFromEnd = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState2.mAnchorOffset = this.mOrientationHelper.e() - this.mOrientationHelper.b(childClosestToEnd);
                savedState2.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState2.mAnchorPosition = getPosition(childClosestToStart);
                savedState2.mAnchorOffset = this.mOrientationHelper.a(childClosestToStart) - this.mOrientationHelper.d();
            }
        } else {
            savedState2.invalidateAnchor();
        }
        return savedState2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.mOrientation || this.mOrientationHelper == null) {
                this.mOrientationHelper = n.a(this, i);
                this.mAnchorInfo.f1043a = this.mOrientationHelper;
                this.mOrientation = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.t tVar) {
        if (tVar.d()) {
            return this.mOrientationHelper.g();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(RecyclerView.t tVar, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(tVar);
        if (this.mLayoutState.f == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i);
        startSmoothScroll(jVar);
    }

    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.mShouldReverseLayout) {
            i2 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void onLayoutChildren(RecyclerView.p pVar, RecyclerView.t tVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View findViewByPosition;
        int i7;
        int i8;
        int i9 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && tVar.e() == 0) {
            removeAndRecycleAllViews(pVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.f1047a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.a();
            a aVar = this.mAnchorInfo;
            aVar.d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(pVar, tVar, aVar);
            this.mAnchorInfo.e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.a(focusedChild) >= this.mOrientationHelper.e() || this.mOrientationHelper.b(focusedChild) <= this.mOrientationHelper.d())) {
            this.mAnchorInfo.a(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(tVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.d();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.h();
        if (!(!tVar.a() || (i6 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i6)) == null)) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.e() - this.mOrientationHelper.b(findViewByPosition);
                i8 = this.mPendingScrollPositionOffset;
            } else {
                i8 = this.mOrientationHelper.a(findViewByPosition) - this.mOrientationHelper.d();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i10 = i7 - i8;
            if (i10 > 0) {
                max += i10;
            } else {
                max2 -= i10;
            }
        }
        if (!this.mAnchorInfo.d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i9 = 1;
        }
        onAnchorReady(pVar, tVar, this.mAnchorInfo, i9);
        detachAndScrapAttachedViews(pVar);
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.j = tVar.a();
        this.mLayoutState.i = 0;
        if (this.mAnchorInfo.d) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar2 = this.mLayoutState;
            cVar2.h = max;
            fill(pVar, cVar2, tVar, false);
            i2 = this.mLayoutState.f1048b;
            int i11 = this.mLayoutState.d;
            if (this.mLayoutState.c > 0) {
                max2 += this.mLayoutState.c;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar3 = this.mLayoutState;
            cVar3.h = max2;
            cVar3.d += this.mLayoutState.e;
            fill(pVar, this.mLayoutState, tVar, false);
            i = this.mLayoutState.f1048b;
            if (this.mLayoutState.c > 0) {
                int i12 = this.mLayoutState.c;
                updateLayoutStateToFillStart(i11, i2);
                c cVar4 = this.mLayoutState;
                cVar4.h = i12;
                fill(pVar, cVar4, tVar, false);
                i2 = this.mLayoutState.f1048b;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar5 = this.mLayoutState;
            cVar5.h = max2;
            fill(pVar, cVar5, tVar, false);
            i = this.mLayoutState.f1048b;
            int i13 = this.mLayoutState.d;
            if (this.mLayoutState.c > 0) {
                max += this.mLayoutState.c;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar6 = this.mLayoutState;
            cVar6.h = max;
            cVar6.d += this.mLayoutState.e;
            fill(pVar, this.mLayoutState, tVar, false);
            i2 = this.mLayoutState.f1048b;
            if (this.mLayoutState.c > 0) {
                int i14 = this.mLayoutState.c;
                updateLayoutStateToFillEnd(i13, i);
                c cVar7 = this.mLayoutState;
                cVar7.h = i14;
                fill(pVar, cVar7, tVar, false);
                i = this.mLayoutState.f1048b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap = fixLayoutEndGap(i, pVar, tVar, true);
                i5 = i2 + fixLayoutEndGap;
                i3 = i + fixLayoutEndGap;
                i4 = fixLayoutStartGap(i5, pVar, tVar, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i2, pVar, tVar, true);
                i5 = i2 + fixLayoutStartGap;
                i3 = i + fixLayoutStartGap;
                i4 = fixLayoutEndGap(i3, pVar, tVar, false);
            }
            i2 = i5 + i4;
            i = i3 + i4;
        }
        layoutForPredictiveAnimations(pVar, tVar, i2, i);
        if (!tVar.a()) {
            this.mOrientationHelper.b();
        } else {
            this.mAnchorInfo.a();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(RecyclerView.t tVar) {
        super.onLayoutCompleted(tVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.a();
    }

    private void layoutForPredictiveAnimations(RecyclerView.p pVar, RecyclerView.t tVar, int i, int i2) {
        RecyclerView.p pVar2 = pVar;
        RecyclerView.t tVar2 = tVar;
        if (tVar.b() && getChildCount() != 0 && !tVar.a() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.w> c2 = pVar.c();
            int size = c2.size();
            int position = getPosition(getChildAt(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.w wVar = c2.get(i5);
                if (!wVar.isRemoved()) {
                    boolean z = true;
                    if ((wVar.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                        z = true;
                    }
                    if (z) {
                        i3 += this.mOrientationHelper.e(wVar.itemView);
                    } else {
                        i4 += this.mOrientationHelper.e(wVar.itemView);
                    }
                }
            }
            this.mLayoutState.l = c2;
            if (i3 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                c cVar = this.mLayoutState;
                cVar.h = i3;
                cVar.c = 0;
                cVar.a();
                fill(pVar2, this.mLayoutState, tVar2, false);
            }
            if (i4 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                c cVar2 = this.mLayoutState;
                cVar2.h = i4;
                cVar2.c = 0;
                cVar2.a();
                fill(pVar2, this.mLayoutState, tVar2, false);
            }
            this.mLayoutState.l = null;
        }
    }

    private void updateAnchorInfoForLayout(RecyclerView.p pVar, RecyclerView.t tVar, a aVar) {
        if (!updateAnchorFromPendingData(tVar, aVar) && !updateAnchorFromChildren(pVar, tVar, aVar)) {
            aVar.b();
            aVar.f1044b = this.mStackFromEnd ? tVar.e() - 1 : 0;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.p pVar, RecyclerView.t tVar, a aVar) {
        View view;
        int i;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.a(focusedChild, tVar)) {
            aVar.a(focusedChild, getPosition(focusedChild));
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        } else {
            if (aVar.d) {
                view = findReferenceChildClosestToEnd(pVar, tVar);
            } else {
                view = findReferenceChildClosestToStart(pVar, tVar);
            }
            if (view == null) {
                return false;
            }
            aVar.b(view, getPosition(view));
            if (!tVar.a() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.a(view) >= this.mOrientationHelper.e() || this.mOrientationHelper.b(view) < this.mOrientationHelper.d()) {
                    z = true;
                }
                if (z) {
                    if (aVar.d) {
                        i = this.mOrientationHelper.e();
                    } else {
                        i = this.mOrientationHelper.d();
                    }
                    aVar.c = i;
                }
            }
            return true;
        }
    }

    private boolean updateAnchorFromPendingData(RecyclerView.t tVar, a aVar) {
        int i;
        int i2;
        boolean z = false;
        if (!tVar.a() && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= tVar.e()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.f1044b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    aVar.d = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    if (aVar.d) {
                        aVar.c = this.mOrientationHelper.e() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        aVar.c = this.mOrientationHelper.d() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if ((this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout) {
                                z = true;
                            }
                            aVar.d = z;
                        }
                        aVar.b();
                    } else if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.g()) {
                        aVar.b();
                        return true;
                    } else if (this.mOrientationHelper.a(findViewByPosition) - this.mOrientationHelper.d() < 0) {
                        aVar.c = this.mOrientationHelper.d();
                        aVar.d = false;
                        return true;
                    } else if (this.mOrientationHelper.e() - this.mOrientationHelper.b(findViewByPosition) < 0) {
                        aVar.c = this.mOrientationHelper.e();
                        aVar.d = true;
                        return true;
                    } else {
                        if (aVar.d) {
                            i2 = this.mOrientationHelper.b(findViewByPosition) + this.mOrientationHelper.c();
                        } else {
                            i2 = this.mOrientationHelper.a(findViewByPosition);
                        }
                        aVar.c = i2;
                    }
                    return true;
                } else {
                    boolean z2 = this.mShouldReverseLayout;
                    aVar.d = z2;
                    if (z2) {
                        aVar.c = this.mOrientationHelper.e() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.c = this.mOrientationHelper.d() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private int fixLayoutEndGap(int i, RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int e;
        int e2 = this.mOrientationHelper.e() - i;
        if (e2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-e2, pVar, tVar);
        int i3 = i + i2;
        if (!z || (e = this.mOrientationHelper.e() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.a(e);
        return e + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int d;
        int d2 = i - this.mOrientationHelper.d();
        if (d2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(d2, pVar, tVar);
        int i3 = i + i2;
        if (!z || (d = i3 - this.mOrientationHelper.d()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.a(-d);
        return i2 - d;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f1044b, aVar.c);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.c = this.mOrientationHelper.e() - i2;
        this.mLayoutState.e = this.mShouldReverseLayout ? -1 : 1;
        c cVar = this.mLayoutState;
        cVar.d = i;
        cVar.f = 1;
        cVar.f1048b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f1044b, aVar.c);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.c = i2 - this.mOrientationHelper.d();
        c cVar = this.mLayoutState;
        cVar.d = i;
        cVar.e = this.mShouldReverseLayout ? 1 : -1;
        c cVar2 = this.mLayoutState;
        cVar2.f = -1;
        cVar2.f1048b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    /* access modifiers changed from: package-private */
    public c createLayoutState() {
        return new c();
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public int scrollHorizontallyBy(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, pVar, tVar);
    }

    public int scrollVerticallyBy(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, pVar, tVar);
    }

    public int computeHorizontalScrollOffset(RecyclerView.t tVar) {
        return computeScrollOffset(tVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.t tVar) {
        return computeScrollOffset(tVar);
    }

    public int computeHorizontalScrollExtent(RecyclerView.t tVar) {
        return computeScrollExtent(tVar);
    }

    public int computeVerticalScrollExtent(RecyclerView.t tVar) {
        return computeScrollExtent(tVar);
    }

    public int computeHorizontalScrollRange(RecyclerView.t tVar) {
        return computeScrollRange(tVar);
    }

    public int computeVerticalScrollRange(RecyclerView.t tVar) {
        return computeScrollRange(tVar);
    }

    private int computeScrollOffset(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        n nVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return q.a(tVar, nVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        n nVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return q.a(tVar, nVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(RecyclerView.t tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        n nVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return q.b(tVar, nVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.t tVar) {
        int i3;
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f = i;
        int[] iArr = this.mReusableIntPair;
        boolean z2 = false;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(tVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i == 1) {
            z2 = true;
        }
        this.mLayoutState.h = z2 ? max2 : max;
        c cVar = this.mLayoutState;
        if (!z2) {
            max = max2;
        }
        cVar.i = max;
        int i4 = -1;
        if (z2) {
            this.mLayoutState.h += this.mOrientationHelper.h();
            View childClosestToEnd = getChildClosestToEnd();
            c cVar2 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i4 = 1;
            }
            cVar2.e = i4;
            this.mLayoutState.d = getPosition(childClosestToEnd) + this.mLayoutState.e;
            this.mLayoutState.f1048b = this.mOrientationHelper.b(childClosestToEnd);
            i3 = this.mOrientationHelper.b(childClosestToEnd) - this.mOrientationHelper.e();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.h += this.mOrientationHelper.d();
            c cVar3 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i4 = 1;
            }
            cVar3.e = i4;
            this.mLayoutState.d = getPosition(childClosestToStart) + this.mLayoutState.e;
            this.mLayoutState.f1048b = this.mOrientationHelper.a(childClosestToStart);
            i3 = (-this.mOrientationHelper.a(childClosestToStart)) + this.mOrientationHelper.d();
        }
        c cVar4 = this.mLayoutState;
        cVar4.c = i2;
        if (z) {
            cVar4.c -= i3;
        }
        this.mLayoutState.g = i3;
    }

    /* access modifiers changed from: package-private */
    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.i() == 0 && this.mOrientationHelper.f() == 0;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.t tVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.d;
        if (i >= 0 && i < tVar.e()) {
            aVar.b(i, Math.max(0, cVar.g));
        }
    }

    public void collectInitialPrefetchPositions(int i, RecyclerView.i.a aVar) {
        int i2;
        boolean z;
        SavedState savedState = this.mPendingSavedState;
        int i3 = -1;
        if (savedState == null || !savedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = this.mPendingSavedState.mAnchorLayoutFromEnd;
            i2 = this.mPendingSavedState.mAnchorPosition;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            aVar.b(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.t tVar, RecyclerView.i.a aVar) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            ensureLayoutState();
            updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, tVar);
            collectPrefetchPositionsForLayoutState(tVar, this.mLayoutState, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f1047a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, tVar);
        int fill = this.mLayoutState.g + fill(pVar, this.mLayoutState, tVar, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.a(-i);
        this.mLayoutState.k = i;
        return i;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(RecyclerView.p pVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, pVar);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, pVar);
                i--;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.p pVar, int i, int i2) {
        if (i >= 0) {
            int i3 = i - i2;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i4 = childCount - 1;
                for (int i5 = i4; i5 >= 0; i5--) {
                    View childAt = getChildAt(i5);
                    if (this.mOrientationHelper.b(childAt) > i3 || this.mOrientationHelper.c(childAt) > i3) {
                        recycleChildren(pVar, i4, i5);
                        return;
                    }
                }
                return;
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt2 = getChildAt(i6);
                if (this.mOrientationHelper.b(childAt2) > i3 || this.mOrientationHelper.c(childAt2) > i3) {
                    recycleChildren(pVar, 0, i6);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.p pVar, int i, int i2) {
        int childCount = getChildCount();
        if (i >= 0) {
            int f = (this.mOrientationHelper.f() - i) + i2;
            if (this.mShouldReverseLayout) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (this.mOrientationHelper.a(childAt) < f || this.mOrientationHelper.d(childAt) < f) {
                        recycleChildren(pVar, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = childCount - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (this.mOrientationHelper.a(childAt2) < f || this.mOrientationHelper.d(childAt2) < f) {
                    recycleChildren(pVar, i4, i5);
                    return;
                }
            }
        }
    }

    private void recycleByLayoutState(RecyclerView.p pVar, c cVar) {
        if (cVar.f1047a && !cVar.m) {
            int i = cVar.g;
            int i2 = cVar.i;
            if (cVar.f == -1) {
                recycleViewsFromEnd(pVar, i, i2);
            } else {
                recycleViewsFromStart(pVar, i, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int fill(RecyclerView.p pVar, c cVar, RecyclerView.t tVar, boolean z) {
        int i = cVar.c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.c < 0) {
                cVar.g += cVar.c;
            }
            recycleByLayoutState(pVar, cVar);
        }
        int i2 = cVar.c + cVar.h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m && i2 <= 0) || !cVar.a(tVar)) {
                break;
            }
            bVar.a();
            layoutChunk(pVar, tVar, cVar, bVar);
            if (!bVar.f1046b) {
                cVar.f1048b += bVar.f1045a * cVar.f;
                if (!bVar.c || cVar.l != null || !tVar.a()) {
                    cVar.c -= bVar.f1045a;
                    i2 -= bVar.f1045a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.f1045a;
                    if (cVar.c < 0) {
                        cVar.g += cVar.c;
                    }
                    recycleByLayoutState(pVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.p pVar, RecyclerView.t tVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a2 = cVar.a(pVar);
        if (a2 == null) {
            bVar.f1046b = true;
            return;
        }
        RecyclerView.j jVar = (RecyclerView.j) a2.getLayoutParams();
        if (cVar.l == null) {
            if (this.mShouldReverseLayout == (cVar.f == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f == -1)) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        bVar.f1045a = this.mOrientationHelper.e(a2);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i5 = getWidth() - getPaddingRight();
                i4 = i5 - this.mOrientationHelper.f(a2);
            } else {
                i4 = getPaddingLeft();
                i5 = this.mOrientationHelper.f(a2) + i4;
            }
            if (cVar.f == -1) {
                int i6 = cVar.f1048b;
                i3 = cVar.f1048b - bVar.f1045a;
                i2 = i5;
                i = i6;
            } else {
                int i7 = cVar.f1048b;
                i = cVar.f1048b + bVar.f1045a;
                i2 = i5;
                i3 = i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f = this.mOrientationHelper.f(a2) + paddingTop;
            if (cVar.f == -1) {
                i3 = paddingTop;
                i2 = cVar.f1048b;
                i = f;
                i4 = cVar.f1048b - bVar.f1045a;
            } else {
                int i8 = cVar.f1048b;
                i2 = cVar.f1048b + bVar.f1045a;
                i3 = paddingTop;
                i = f;
                i4 = i8;
            }
        }
        layoutDecoratedWithMargins(a2, i4, i3, i2, i);
        if (jVar.d() || jVar.e()) {
            bVar.c = true;
        }
        bVar.d = a2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i) {
        if (i == 1) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        return Integer.MIN_VALUE;
                    }
                    return this.mOrientation == 1 ? 1 : Integer.MIN_VALUE;
                } else if (this.mOrientation == 0) {
                    return 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.mOrientation == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.mOrientation == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.mShouldReverseLayout) {
            return findFirstReferenceChild(pVar, tVar);
        }
        return findLastReferenceChild(pVar, tVar);
    }

    private View findReferenceChildClosestToStart(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.mShouldReverseLayout) {
            return findLastReferenceChild(pVar, tVar);
        }
        return findFirstReferenceChild(pVar, tVar);
    }

    private View findFirstReferenceChild(RecyclerView.p pVar, RecyclerView.t tVar) {
        return findReferenceChild(pVar, tVar, 0, getChildCount(), tVar.e());
    }

    private View findLastReferenceChild(RecyclerView.p pVar, RecyclerView.t tVar) {
        return findReferenceChild(pVar, tVar, getChildCount() - 1, -1, tVar.e());
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.p pVar, RecyclerView.t tVar, int i, int i2, int i3) {
        ensureLayoutState();
        int d = this.mOrientationHelper.d();
        int e = this.mOrientationHelper.e();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.j) childAt.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.a(childAt) < e && this.mOrientationHelper.b(childAt) >= d) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i, i2, i4, i3);
        }
        return this.mVerticalBoundCheck.a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.a(getChildAt(i)) < this.mOrientationHelper.d()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i, i2, i4, i3);
        }
        return this.mVerticalBoundCheck.a(i, i2, i4, i3);
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.g()) * MAX_SCROLL_FACTOR), false, tVar);
        c cVar = this.mLayoutState;
        cVar.g = Integer.MIN_VALUE;
        cVar.f1047a = false;
        fill(pVar, cVar, tVar, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.a(childAt));
        }
        Log.d(TAG, "==============");
    }

    /* access modifiers changed from: package-private */
    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() >= 1) {
            boolean z = false;
            int position = getPosition(getChildAt(0));
            int a2 = this.mOrientationHelper.a(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i = 1;
                while (i < getChildCount()) {
                    View childAt = getChildAt(i);
                    int position2 = getPosition(childAt);
                    int a3 = this.mOrientationHelper.a(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder();
                        sb.append("detected invalid position. loc invalid? ");
                        if (a3 < a2) {
                            z = true;
                        }
                        sb.append(z);
                        throw new RuntimeException(sb.toString());
                    } else if (a3 <= a2) {
                        i++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i2 = 1;
            while (i2 < getChildCount()) {
                View childAt2 = getChildAt(i2);
                int position3 = getPosition(childAt2);
                int a4 = this.mOrientationHelper.a(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    if (a4 < a2) {
                        z = true;
                    }
                    sb2.append(z);
                    throw new RuntimeException(sb2.toString());
                } else if (a4 >= a2) {
                    i2++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        boolean z = position < position2 ? true : true;
        if (this.mShouldReverseLayout) {
            if (z) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.e() - (this.mOrientationHelper.a(view2) + this.mOrientationHelper.e(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.e() - this.mOrientationHelper.b(view2));
            }
        } else if (z) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.a(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.b(view2) - this.mOrientationHelper.e(view));
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f1047a = true;

        /* renamed from: b  reason: collision with root package name */
        int f1048b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        int i = 0;
        boolean j = false;
        int k;
        List<RecyclerView.w> l = null;
        boolean m;

        c() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(RecyclerView.t tVar) {
            int i2 = this.d;
            return i2 >= 0 && i2 < tVar.e();
        }

        /* access modifiers changed from: package-private */
        public View a(RecyclerView.p pVar) {
            if (this.l != null) {
                return b();
            }
            View c2 = pVar.c(this.d);
            this.d += this.e;
            return c2;
        }

        private View b() {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.l.get(i2).itemView;
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                if (!jVar.d() && this.d == jVar.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.j) b2.getLayoutParams()).f();
            }
        }

        public View b(View view) {
            int f2;
            int size = this.l.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.l.get(i3).itemView;
                RecyclerView.j jVar = (RecyclerView.j) view3.getLayoutParams();
                if (view3 != view && !jVar.d() && (f2 = (jVar.f() - this.d) * this.e) >= 0 && f2 < i2) {
                    if (f2 == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i2 = f2;
                }
            }
            return view2;
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
        int mAnchorOffset;
        int mAnchorPosition;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        /* access modifiers changed from: package-private */
        public boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        /* access modifiers changed from: package-private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        n f1043a;

        /* renamed from: b  reason: collision with root package name */
        int f1044b;
        int c;
        boolean d;
        boolean e;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1044b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i;
            if (this.d) {
                i = this.f1043a.e();
            } else {
                i = this.f1043a.d();
            }
            this.c = i;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1044b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, RecyclerView.t tVar) {
            RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
            return !jVar.d() && jVar.f() >= 0 && jVar.f() < tVar.e();
        }

        public void a(View view, int i) {
            int c2 = this.f1043a.c();
            if (c2 >= 0) {
                b(view, i);
                return;
            }
            this.f1044b = i;
            if (this.d) {
                int e2 = (this.f1043a.e() - c2) - this.f1043a.b(view);
                this.c = this.f1043a.e() - e2;
                if (e2 > 0) {
                    int e3 = this.c - this.f1043a.e(view);
                    int d2 = this.f1043a.d();
                    int min = e3 - (d2 + Math.min(this.f1043a.a(view) - d2, 0));
                    if (min < 0) {
                        this.c += Math.min(e2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a2 = this.f1043a.a(view);
            int d3 = a2 - this.f1043a.d();
            this.c = a2;
            if (d3 > 0) {
                int e4 = (this.f1043a.e() - Math.min(0, (this.f1043a.e() - c2) - this.f1043a.b(view))) - (a2 + this.f1043a.e(view));
                if (e4 < 0) {
                    this.c -= Math.min(d3, -e4);
                }
            }
        }

        public void b(View view, int i) {
            if (this.d) {
                this.c = this.f1043a.b(view) + this.f1043a.c();
            } else {
                this.c = this.f1043a.a(view);
            }
            this.f1044b = i;
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f1045a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1046b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1045a = 0;
            this.f1046b = false;
            this.c = false;
            this.d = false;
        }
    }
}
