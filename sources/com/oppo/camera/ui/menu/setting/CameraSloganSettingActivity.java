package com.oppo.camera.ui.menu.setting;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.h;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.f.a;
import com.oppo.camera.util.Util;

public class CameraSloganSettingActivity extends m {
    private int k = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.setting_delegate_layout);
        h j = j();
        q qVar = (q) j.a("com.oppo.camera.ui.menu.setting.CameraSloganSettingActivity");
        if (qVar == null) {
            qVar = new q();
        }
        j.a().b(R.id.fragment_container, qVar, "com.oppo.camera.ui.menu.setting.CameraSloganSettingActivity").b();
        a.a(getApplicationContext());
        CameraConfig.initialize();
        Util.c(getApplicationContext());
        Intent intent = getIntent();
        if ("oppo.intent.action.APP_SLOGAN_SETTING".equals(intent.getAction())) {
            Bundle bundleExtra = intent.getBundleExtra("camera_intent_data");
            qVar.setArguments(bundleExtra);
            c(true);
            if (bundleExtra != null) {
                this.k = bundleExtra.getInt("camera_slogan_setting_from");
                setTitle(o());
            }
        }
    }

    public String o() {
        int i = this.k;
        if (i == 0) {
            return getString(R.string.camera_slogan_device);
        }
        if (1 == i) {
            return getString(R.string.camera_slogan_time);
        }
        return getString(R.string.camera_slogan_location);
    }
}
