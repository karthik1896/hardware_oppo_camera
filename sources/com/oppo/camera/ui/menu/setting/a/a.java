package com.oppo.camera.ui.menu.setting.a;

import android.app.Activity;
import android.view.MenuItem;
import androidx.appcompat.app.e;

/* compiled from: ActivityDelegate */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f4174a;

    /* renamed from: b  reason: collision with root package name */
    private final com.oppo.camera.ui.menu.setting.a f4175b = ((com.oppo.camera.ui.menu.setting.a) this.f4174a);

    public void a() {
    }

    public a(Activity activity) {
        this.f4174a = activity;
    }

    public void a(e eVar) {
        b.a(this.f4174a, this.f4175b.c());
    }

    public void b(e eVar) {
        androidx.appcompat.app.a a2 = eVar.a();
        if (a2 != null) {
            a2.a(this.f4175b.a());
        }
        if (this.f4175b.p_()) {
            c.a(this.f4174a);
        }
    }

    public void a(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.f4174a.finish();
        }
    }
}
