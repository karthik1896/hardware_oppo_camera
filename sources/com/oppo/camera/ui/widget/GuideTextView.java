package com.oppo.camera.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.oppo.camera.MyApplication;

public class GuideTextView extends AppCompatTextView {
    public GuideTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GuideTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuideTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(getTextSize());
    }

    private void a(float f) {
        super.setTextSize(0, f * MyApplication.d().getResources().getConfiguration().fontScale);
    }
}
