package com.oppo.camera.ui.menu.setting;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.h;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.f.a;
import com.oppo.camera.util.Util;

public class CameraPhotoSloganSettingActivity extends m {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.setting_delegate_layout);
        setTitle(R.string.camera_slogan_title);
        h j = j();
        k kVar = (k) j.a("com.oppo.camera.ui.menu.setting.CameraPhotoSloganSettingActivity");
        if (kVar == null) {
            kVar = new k();
        }
        j.a().b(R.id.fragment_container, kVar, "com.oppo.camera.ui.menu.setting.CameraPhotoSloganSettingActivity").b();
        a.a(getApplicationContext());
        CameraConfig.initialize();
        Util.c(getApplicationContext());
        setTitle(R.string.camera_slogan_title);
        Intent intent = getIntent();
        if ("oppo.intent.action.APP_PHOTO_SLOGAN_SETTING".equals(intent.getAction())) {
            kVar.setArguments(intent.getBundleExtra("camera_intent_data"));
            c(true);
        }
    }
}
