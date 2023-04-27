package com.oppo.camera.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.oppo.camera.e;

/* compiled from: NavigateUtils */
public class c {
    public static void a(androidx.appcompat.app.c cVar, Intent intent, String str) {
        if (intent == null || cVar == null) {
            e.c("NavigateUtils", "setNavigateTitle, intent or action bar is null");
            return;
        }
        String stringExtra = intent.getStringExtra("navigate_title_text");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = a(cVar, intent);
        }
        e.c("NavigateUtils", "setNavigateTitle, contentDescription: " + stringExtra);
        if (!TextUtils.isEmpty(stringExtra)) {
            cVar.setTitle(stringExtra);
        } else {
            cVar.setTitle(str);
        }
    }

    private static String a(Context context, Intent intent) {
        Context context2;
        if (!(context == null || intent == null)) {
            int intExtra = intent.getIntExtra("navigate_title_id", 0);
            e.b("NavigateUtils", "getContentDescriptionById(), id: " + intExtra);
            if (intExtra != 0) {
                String stringExtra = intent.getStringExtra("navigate_parent_package");
                if (TextUtils.isEmpty(stringExtra) || stringExtra.equals(context.getPackageName())) {
                    return context.getResources().getString(intExtra);
                }
                try {
                    context2 = context.createPackageContext(stringExtra, 3);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    context2 = null;
                }
                if (context2 != null) {
                    return context2.getResources().getString(intExtra);
                }
            }
        }
        return null;
    }
}
