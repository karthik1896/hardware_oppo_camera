package com.oppo.camera.ui.menu.setting;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import color.support.design.widget.ColorAppBarLayout;
import color.support.v7.widget.Toolbar;
import com.oppo.camera.R;

public class CameraVideoRatioSettingActivity extends m {
    private Toolbar k;
    private ColorAppBarLayout l;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_setting_video_resolution_activity_layout);
        s sVar = new s();
        j().a().a((int) R.id.list_container, (Fragment) sVar).b();
        this.k = (Toolbar) findViewById(R.id.toolbar);
        a((androidx.appcompat.widget.Toolbar) this.k);
        this.l = (ColorAppBarLayout) findViewById(R.id.appBarLayout);
        this.l.setPadding(0, getResources().getDimensionPixelSize(R.dimen.preference_topbar_padding_top), 0, 0);
        Intent intent = getIntent();
        if ("oppo.intent.action.APP_VIDEO_RATIO_SETTING".equals(intent.getAction())) {
            sVar.setArguments(intent.getBundleExtra("camera_intent_data"));
            c(true);
        }
    }
}
