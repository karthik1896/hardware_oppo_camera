package com.oppo.camera.ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.oppo.camera.R;

public class InverseImageView extends ImageView implements a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4014a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f4015b = 0;
    private boolean c = false;

    public InverseImageView(Context context) {
        super(context);
        a(context);
    }

    public InverseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public InverseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        c.INS.registerInverse(context, this);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f4014a && a()) {
            mergeDrawableStates(onCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return onCreateDrawableState;
    }

    private boolean a() {
        if (this.c) {
            return true;
        }
        int i = this.f4015b;
        if (i == 90 || i == 270) {
            return false;
        }
        return true;
    }

    public void setInverseColor(boolean z) {
        this.f4014a = z;
        refreshDrawableState();
    }

    public void setOrientation(int i) {
        this.f4015b = i;
        refreshDrawableState();
    }

    public void setHorizontalInverseAble(boolean z) {
        this.c = z;
    }
}
