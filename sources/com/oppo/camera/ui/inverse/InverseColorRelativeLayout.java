package com.oppo.camera.ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class InverseColorRelativeLayout extends RelativeLayout {
    public InverseColorRelativeLayout(Context context) {
        super(context);
        a(context);
    }

    public InverseColorRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public InverseColorRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        c.INS.registerBackgroundInverse(context, this, false);
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(c.INS.getBackgroundColor(this, i));
    }
}
