package com.heytap.compat.hardware.a;

import android.hardware.display.DisplayManager;
import com.color.inner.hardware.display.DisplayManagerWrapper;
import com.heytap.compat.d.a.b;
import com.heytap.epona.Request;
import com.heytap.epona.c;

/* compiled from: DisplayManagerNative */
public class a {
    public static void a(float f) throws com.heytap.compat.d.a.a {
        if (b.a()) {
            c.a(new Request.a().a("android.hardware.display.DisplayManager").b("setTemporaryAutoBrightnessAdjustment").a("adjustment", f).a()).a();
        } else if (b.b()) {
            DisplayManagerWrapper.setTemporaryAutoBrightnessAdjustment((DisplayManager) c.c().getSystemService("display"), f);
        } else {
            throw new com.heytap.compat.d.a.a("not supported before Q");
        }
    }
}
