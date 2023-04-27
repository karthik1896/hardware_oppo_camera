package com.oppo.camera.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: TwoStateImageView */
public class o extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private final float f4318a = 0.4f;

    public o(Context context) {
        super(context);
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.4f);
        }
    }

    public void a(boolean z, boolean z2) {
        super.setEnabled(z);
        if (z) {
            setAlpha(1.0f);
        } else if (z2) {
            setAlpha(0.4f);
        }
    }
}
