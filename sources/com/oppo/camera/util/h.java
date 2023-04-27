package com.oppo.camera.util;

import android.content.Context;
import android.widget.Toast;
import com.oppo.camera.e;

/* compiled from: ToastUtil */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f4629a;

    private static void a(Context context) {
        if (f4629a == null) {
            f4629a = Toast.makeText(context, "", 0);
        }
    }

    public static void a(Context context, int i) {
        a(context.getApplicationContext(), i, 0);
    }

    public static void b(Context context, int i) {
        a(context.getApplicationContext(), i, 1);
    }

    private static void a(Context context, int i, int i2) {
        if (i > 0) {
            try {
                a(context);
                f4629a.setText(i);
                f4629a.setDuration(i2);
                f4629a.show();
            } catch (Exception e) {
                e.b("ToastUtil", "showToast, e: " + e);
            }
        }
    }
}
