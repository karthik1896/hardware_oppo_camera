package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.color.support.preference.ColorListPreference;
import com.oppo.camera.R;

public class CameraCustomListPreference extends ColorListPreference {
    private CharSequence[] g = null;

    public CameraCustomListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraCustomListPreference, 0, 0);
        this.g = obtainStyledAttributes.getTextArray(0);
        obtainStyledAttributes.recycle();
    }

    public CharSequence[] U() {
        return this.g;
    }
}
