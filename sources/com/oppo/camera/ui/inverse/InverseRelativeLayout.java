package com.oppo.camera.ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.oppo.camera.R;

public class InverseRelativeLayout extends RelativeLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4022a = false;

    public InverseRelativeLayout(Context context) {
        super(context);
        a(context);
    }

    public InverseRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public InverseRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        c.INS.registerInverse(context, this);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f4022a) {
            mergeDrawableStates(onCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return onCreateDrawableState;
    }

    public void setInverseColor(boolean z) {
        this.f4022a = z;
        refreshDrawableState();
    }
}
