package com.heytap.compat.a;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import com.color.inner.content.ContextWrapper;
import com.heytap.compat.d.a.b;

/* compiled from: ContextNative */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f2562a;

    static {
        try {
            if (b.b()) {
                f2562a = "statusbar";
            } else if (b.d()) {
                f2562a = "statusbar";
            } else {
                throw new com.heytap.compat.d.a.a();
            }
        } catch (Throwable th) {
            Log.e("ContextNative", th.toString());
        }
    }

    public static Display a(Context context) throws com.heytap.compat.d.a.a {
        if (b.b()) {
            return ContextWrapper.getDisplay(context);
        }
        if (b.e()) {
            return context.getDisplay();
        }
        throw new com.heytap.compat.d.a.a();
    }
}
