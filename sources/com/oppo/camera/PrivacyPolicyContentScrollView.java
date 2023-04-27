package com.oppo.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class PrivacyPolicyContentScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private int f2747a;

    public PrivacyPolicyContentScrollView(Context context) {
        super(context);
        this.f2747a = 0;
    }

    public PrivacyPolicyContentScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrivacyPolicyContentScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2747a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PrivacyPolicyContentScrollView);
        this.f2747a = obtainStyledAttributes.getDimensionPixelOffset(0, getResources().getDimensionPixelSize(R.dimen.privacy_policy_text_max_height));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.f2747a), View.MeasureSpec.getMode(i2)));
    }
}
