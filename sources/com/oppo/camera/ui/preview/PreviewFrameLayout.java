package com.oppo.camera.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class PreviewFrameLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private OnSizeChangedListener f4349a;

    public interface OnSizeChangedListener {
        void b(int i, int i2);
    }

    public PreviewFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.f4349a = onSizeChangedListener;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        OnSizeChangedListener onSizeChangedListener = this.f4349a;
        if (onSizeChangedListener != null) {
            onSizeChangedListener.b(i, i2);
        }
    }
}
