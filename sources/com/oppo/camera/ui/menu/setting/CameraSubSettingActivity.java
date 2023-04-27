package com.oppo.camera.ui.menu.setting;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.h;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.f.a;
import com.oppo.camera.util.Util;

public class CameraSubSettingActivity extends m {
    private int k = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.setting_delegate_layout);
        h j = j();
        r rVar = (r) j.a("com.oppo.camera.ui.menu.setting.CameraSubSettingActivity");
        if (rVar == null) {
            rVar = new r();
        }
        j.a().b(R.id.fragment_container, rVar, "com.oppo.camera.ui.menu.setting.CameraSubSettingActivity").b();
        a.a(getApplicationContext());
        CameraConfig.initialize();
        Util.c(getApplicationContext());
        Intent intent = getIntent();
        if ("oppo.intent.action.APP_SUB_SETTING".equals(intent.getAction())) {
            Bundle bundleExtra = intent.getBundleExtra("camera_intent_data");
            rVar.setArguments(bundleExtra);
            c(true);
            if (bundleExtra != null) {
                this.k = bundleExtra.getInt("camera_sub_setting_from");
                setTitle(o());
            }
        }
    }

    private String o() {
        int i = this.k;
        if (1 == i) {
            return getString(R.string.camera_setting_auxiliary_shutter);
        }
        if (2 == i) {
            return getString(R.string.camera_setting_water_mark);
        }
        if (i == 0) {
            return getString(R.string.camera_setting_advanced_setting);
        }
        if (3 == i) {
            return getString(R.string.camera_video_sound_title);
        }
        return getString(R.string.camera_setting_build_image);
    }
}
