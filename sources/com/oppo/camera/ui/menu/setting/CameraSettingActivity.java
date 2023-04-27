package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.h;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.util.c;

public class CameraSettingActivity extends m {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        e.b("CameraSettingActivity", "attachBaseContext, follow system dpi.");
        super.attachBaseContext(Util.n(context));
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e.d("CameraSettingActivity", "onConfigurationChanged, densityDpi: " + configuration.densityDpi + " -> " + Util.f4604b + ", fontScale: " + configuration.fontScale + " -> " + Util.c);
        configuration.densityDpi = Util.f4604b;
        configuration.fontScale = Util.c;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.setting_delegate_layout);
        h j = j();
        l lVar = (l) j.a("com.oppo.camera.ui.menu.setting.CameraSettingActivity");
        if (lVar == null) {
            lVar = new l();
        }
        j.a().b(R.id.fragment_container, lVar, "com.oppo.camera.ui.menu.setting.CameraSettingActivity").b();
        Intent intent = getIntent();
        e.a("CameraSettingActivity", "onCreate(), Action: " + intent.getAction());
        c.a(this, intent, getString(R.string.camera_setting_name));
        if ("com.oppo.camera.action.SETTING_MENU".equals(intent.getAction())) {
            lVar.setArguments(intent.getBundleExtra("camera_intent_data"));
            c(true);
        } else if ("oppo.intent.action.APP_SETTINGS".equals(intent.getAction()) || "android.intent.action.MAIN".equals(intent.getAction())) {
            a(true);
        }
    }
}
