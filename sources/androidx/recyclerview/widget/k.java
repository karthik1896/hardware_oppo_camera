package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LinearSnapHelper */
public class k extends s {

    /* renamed from: b  reason: collision with root package name */
    private n f1144b;
    private n c;

    public int[] a(RecyclerView.i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.canScrollHorizontally()) {
            iArr[0] = a(iVar, view, e(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.canScrollVertically()) {
            iArr[1] = a(iVar, view, d(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public int a(RecyclerView.i iVar, int i, int i2) {
        int itemCount;
        View a2;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(iVar instanceof RecyclerView.s.b) || (itemCount = iVar.getItemCount()) == 0 || (a2 = a(iVar)) == null || (position = iVar.getPosition(a2)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.s.b) iVar).computeScrollVectorForPosition(i3)) == null) {
            return -1;
        }
        if (iVar.canScrollHorizontally()) {
            i4 = a(iVar, e(iVar), i, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (iVar.canScrollVertically()) {
            i5 = a(iVar, d(iVar), 0, i2);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (iVar.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = position + i4;
        if (i6 < 0) {
            i6 = 0;
        }
        return i6 >= itemCount ? itemCount - 1 : i6;
    }

    public View a(RecyclerView.i iVar) {
        if (iVar.canScrollVertically()) {
            return a(iVar, d(iVar));
        }
        if (iVar.canScrollHorizontally()) {
            return a(iVar, e(iVar));
        }
        return null;
    }

    private int a(RecyclerView.i iVar, View view, n nVar) {
        return (nVar.a(view) + (nVar.e(view) / 2)) - (nVar.d() + (nVar.g() / 2));
    }

    private int a(RecyclerView.i iVar, n nVar, int i, int i2) {
        int[] b2 = b(i, i2);
        float b3 = b(iVar, nVar);
        if (b3 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(b2[0]) > Math.abs(b2[1]) ? b2[0] : b2[1])) / b3);
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

    private float b(RecyclerView.i iVar, n nVar) {
        int max;
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = iVar.getChildAt(i3);
            int position = iVar.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > i) {
                    view2 = childAt;
                    i = position;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(nVar.b(view), nVar.b(view2)) - Math.min(nVar.a(view), nVar.a(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i - i2) + 1));
    }

    private n d(RecyclerView.i iVar) {
        n nVar = this.f1144b;
        if (nVar == null || nVar.f1146a != iVar) {
            this.f1144b = n.b(iVar);
        }
        return this.f1144b;
    }

    private n e(RecyclerView.i iVar) {
        n nVar = this.c;
        if (nVar == null || nVar.f1146a != iVar) {
            this.c = n.a(iVar);
        }
        return this.c;
    }
}
