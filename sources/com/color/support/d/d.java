package com.color.support.d;

import android.content.Context;
import android.os.Build;
import android.view.View;

/* compiled from: ColorDarkModeUtil */
public class d {
    public static boolean a(Context context) {
        return 32 == (context.getResources().getConfiguration().uiMode & 48);
    }

    public static void a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.setForceDarkAllowed(z);
        }
    }
}
