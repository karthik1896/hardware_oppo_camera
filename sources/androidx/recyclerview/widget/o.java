package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PagerSnapHelper */
public class o extends s {

    /* renamed from: b  reason: collision with root package name */
    private n f1148b;
    private n c;

    public int[] a(RecyclerView.i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.canScrollHorizontally()) {
            iArr[0] = a(iVar, view, g(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.canScrollVertically()) {
            iArr[1] = a(iVar, view, f(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View a(RecyclerView.i iVar) {
        if (iVar.canScrollVertically()) {
            return a(iVar, f(iVar));
        }
        if (iVar.canScrollHorizontally()) {
            return a(iVar, g(iVar));
        }
        return null;
    }

    public int a(RecyclerView.i iVar, int i, int i2) {
        n e;
        int itemCount = iVar.getItemCount();
        if (itemCount == 0 || (e = e(iVar)) == null) {
            return -1;
        }
        int childCount = iVar.getChildCount();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = iVar.getChildAt(i5);
            if (childAt != null) {
                int a2 = a(iVar, childAt, e);
                if (a2 <= 0 && a2 > i4) {
                    view2 = childAt;
                    i4 = a2;
                }
                if (a2 >= 0 && a2 < i3) {
                    view = childAt;
                    i3 = a2;
                }
            }
        }
        boolean b2 = b(iVar, i, i2);
        if (b2 && view != null) {
            return iVar.getPosition(view);
        }
        if (!b2 && view2 != null) {
            return iVar.getPosition(view2);
        }
        if (!b2) {
            view2 = view;
        }
        if (view2 == null) {
            return -1;
        }
        int position = iVar.getPosition(view2) + (d(iVar) == b2 ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    private boolean b(RecyclerView.i iVar, int i, int i2) {
        return iVar.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    private boolean d(RecyclerView.i iVar) {
        PointF computeScrollVectorForPosition;
        int itemCount = iVar.getItemCount();
        if (!(iVar instanceof RecyclerView.s.b) || (computeScrollVectorForPosition = ((RecyclerView.s.b) iVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        if (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public j b(RecyclerView.i iVar) {
        if (!(iVar instanceof RecyclerView.s.b)) {
            return null;
        }
        return new j(this.f1152a.getContext()) {
            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.t tVar, RecyclerView.s.a aVar) {
                o oVar = o.this;
                int[] a2 = oVar.a(oVar.f1152a.getLayoutManager(), view);
                int i = a2[0];
                int i2 = a2[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    aVar.a(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }
        };
    }

    private int a(RecyclerView.i iVar, View view, n nVar) {
        return (nVar.a(view) + (nVar.e(view) / 2)) - (nVar.d() + (nVar.g() / 2));
    }

    private View a(RecyclerView.i iVar, n nVar) {
        int childCount = iVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int d = nVar.d() + (nVar.g() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = iVar.getChildAt(i2);
            int abs = Math.abs((nVar.a(childAt) + (nVar.e(childAt) / 2)) - d);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    private n e(RecyclerView.i iVar) {
        if (iVar.canScrollVertically()) {
            return f(iVar);
        }
        if (iVar.canScrollHorizontally()) {
            return g(iVar);
        }
        return null;
    }

    private n f(RecyclerView.i iVar) {
        n nVar = this.f1148b;
        if (nVar == null || nVar.f1146a != iVar) {
            this.f1148b = n.b(iVar);
        }
        return this.f1148b;
    }

    private n g(RecyclerView.i iVar) {
        n nVar = this.c;
        if (nVar == null || nVar.f1146a != iVar) {
            this.c = n.a(iVar);
        }
        return this.c;
    }
}
