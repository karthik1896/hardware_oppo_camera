package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

public class ColorPanelPreferenceLinearLayoutManager extends LinearLayoutManager {
    public ColorPanelPreferenceLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public int computeVerticalScrollRange(RecyclerView.t tVar) {
        return super.computeVerticalScrollRange(tVar) + this.mRecyclerView.getScrollY();
    }

    public int computeVerticalScrollOffset(RecyclerView.t tVar) {
        return super.computeVerticalScrollOffset(tVar) + this.mRecyclerView.getScrollY();
    }
}
