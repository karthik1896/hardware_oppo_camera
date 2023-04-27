package com.oppo.camera.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oppo.camera.R;

public class TextCenterView extends RelativeLayout {
    public TextCenterView(Context context) {
        super(context);
        a();
    }

    public TextCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TextCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        setClipChildren(false);
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        appCompatImageView.setId(R.id.icon_image);
        appCompatImageView.setTranslationY((float) getResources().getDimensionPixelSize(R.dimen.double_exposure_guide_title_icon_offset_y));
        layoutParams.addRule(0, R.id.double_exposure_text);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.double_exposure_guide_title_left);
        appCompatImageView.setImageResource(R.drawable.panel_guides_tipsicon);
        addView(appCompatImageView, layoutParams);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        appCompatTextView.setText(getResources().getString(R.string.camera_double_exposure_guide_hint));
        appCompatTextView.setTypeface(Typeface.DEFAULT_BOLD);
        appCompatTextView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.double_exposure_guide_title_text_size));
        appCompatTextView.setTextColor(getResources().getColor(R.color.double_exposure_guide_text_color, (Resources.Theme) null));
        appCompatTextView.setId(R.id.double_exposure_text);
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(appCompatTextView, layoutParams2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int size = View.MeasureSpec.getSize(i);
        boolean z = false;
        int i3 = 0;
        TextView textView = null;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            measureChild(childAt, i, i2);
            if (!(childAt instanceof TextView)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                i3 = i3 + childAt.getMeasuredWidth() + layoutParams.rightMargin + layoutParams.leftMargin;
            } else {
                textView = (TextView) childAt;
            }
        }
        if (textView != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            int i5 = size - i3;
            if (textView.getMeasuredWidth() >= i5) {
                z = true;
            }
            if (!z) {
                i5 = -2;
            }
            layoutParams2.width = i5;
            layoutParams2.addRule(z ? 11 : 14);
            textView.setLayoutParams(layoutParams2);
        }
        super.onMeasure(i, i2);
    }
}
