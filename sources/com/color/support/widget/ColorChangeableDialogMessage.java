package com.color.support.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class ColorChangeableDialogMessage extends AppCompatTextView {
    public ColorChangeableDialogMessage(Context context) {
        super(context);
    }

    public ColorChangeableDialogMessage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorChangeableDialogMessage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        if (layout != null) {
            if (layout.getLineCount() > 1) {
                setTextAlignment(2);
            } else {
                setTextAlignment(4);
            }
            setText(getText());
        }
    }
}
