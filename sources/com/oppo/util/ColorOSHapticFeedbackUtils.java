package com.oppo.util;

import android.view.View;

public class ColorOSHapticFeedbackUtils {
    public static boolean performHapticFeedback(View view, int i, int i2) {
        if (view != null) {
            return view.performHapticFeedback(i);
        }
        return false;
    }

    public static boolean performHapticFeedback(View view, int i, int i2, int i3) {
        if (view != null) {
            return view.performHapticFeedback(i, i3);
        }
        return false;
    }
}
