package com.oppo.camera.ui;

import android.content.Context;
import com.oppo.camera.R;

/* compiled from: CameraUIAttributes */
public class d {
    public static int a(Context context, int i) {
        int color2 = context.getResources().getColor(R.color.plugin_background_15_percent_transparency_color);
        if (i == 0) {
            return context.getResources().getColor(R.color.plugin_background_15_percent_transparency_color);
        }
        if (i == 1) {
            return context.getResources().getColor(R.color.plugin_background_30_percent_transparency_color);
        }
        if (i == 2) {
            return context.getResources().getColor(R.color.plugin_background_50_percent_transparency_color);
        }
        if (i != 3) {
            return color2;
        }
        return context.getResources().getColor(R.color.plugin_background_color_full);
    }
}
