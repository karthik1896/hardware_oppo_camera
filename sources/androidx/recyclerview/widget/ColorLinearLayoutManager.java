package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;

public class ColorLinearLayoutManager extends LinearLayoutManager {
    public ColorLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        super.scrollToPositionWithOffset(i, i2 - this.mRecyclerView.getPaddingTop());
    }
}
