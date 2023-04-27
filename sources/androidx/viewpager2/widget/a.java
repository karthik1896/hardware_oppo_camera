package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: AnimateLayoutChangeDetector */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f1385a = new ViewGroup.MarginLayoutParams(-1, -1);

    /* renamed from: b  reason: collision with root package name */
    private LinearLayoutManager f1386b;

    static {
        f1385a.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.f1386b = linearLayoutManager;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if ((!b() || this.f1386b.getChildCount() <= 1) && c()) {
            return true;
        }
        return false;
    }

    private boolean b() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i;
        int i2;
        int i3;
        int i4;
        int childCount = this.f1386b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.f1386b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{childCount, 2});
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = this.f1386b.getChildAt(i5);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f1385a;
                }
                int[] iArr2 = iArr[i5];
                if (z) {
                    i2 = childAt.getLeft();
                    i = marginLayoutParams.leftMargin;
                } else {
                    i2 = childAt.getTop();
                    i = marginLayoutParams.topMargin;
                }
                iArr2[0] = i2 - i;
                int[] iArr3 = iArr[i5];
                if (z) {
                    i4 = childAt.getRight();
                    i3 = marginLayoutParams.rightMargin;
                } else {
                    i4 = childAt.getBottom();
                    i3 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = i4 + i3;
                i5++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new Comparator<int[]>() {
            /* renamed from: a */
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[0] - iArr2[0];
            }
        });
        for (int i6 = 1; i6 < childCount; i6++) {
            if (iArr[i6 - 1][1] != iArr[i6][0]) {
                return false;
            }
        }
        int i7 = iArr[0][1] - iArr[0][0];
        if (iArr[0][0] > 0 || iArr[childCount - 1][1] < i7) {
            return false;
        }
        return true;
    }

    private boolean c() {
        int childCount = this.f1386b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(this.f1386b.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
