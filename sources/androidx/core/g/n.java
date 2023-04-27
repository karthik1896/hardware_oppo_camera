package androidx.core.g;

import android.view.View;

/* compiled from: NestedScrollingParent2 */
public interface n extends m {
    void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3);

    void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(View view, View view2, int i, int i2);

    boolean onStartNestedScroll(View view, View view2, int i, int i2);

    void onStopNestedScroll(View view, int i);
}
