package com.oppo.camera.ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.oppo.camera.R;

public class InverseTextView extends TextView implements a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4023a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f4024b = 0;
    private boolean c = false;

    public InverseTextView(Context context) {
        super(context);
        a(context);
    }

    public InverseTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public InverseTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        c.INS.registerInverse(context, this);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f4023a && a()) {
            mergeDrawableStates(onCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return onCreateDrawableState;
    }

    private boolean a() {
        if (this.c) {
            return true;
        }
        int i = this.f4024b;
        if (i == 90 || i == 270) {
            return false;
        }
        return true;
    }

    public void setInverseColor(boolean z) {
        this.f4023a = z;
        refreshDrawableState();
    }

    public void setOrientation(int i) {
        this.f4024b = i;
        refreshDrawableState();
    }

    public void setHorizontalInverseAble(boolean z) {
        this.c = z;
    }
}
