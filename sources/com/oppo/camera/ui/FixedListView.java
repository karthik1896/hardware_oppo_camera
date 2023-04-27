package com.oppo.camera.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class FixedListView extends ListView {
    public FixedListView(Context context) {
        super(context);
    }

    public FixedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixedListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FixedListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action != 2) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }
}
