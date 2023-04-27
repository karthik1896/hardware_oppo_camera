package com.oppo.camera;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

public class VideoCamera extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        e.a("VideoCamera", "onCreate");
        super.onCreate(bundle);
        if (isInMultiWindowMode()) {
            Toast.makeText(this, getString(R.string.camera_in_multiwindow_cannot_use), 0).show();
            finish();
            return;
        }
        Bundle extras = getIntent().getExtras();
        String str = "android.media.action.VIDEO_CAPTURE".equals(getIntent().getAction()) ? "com.oppo.action.VIDEO_CAPTURE" : "com.oppo.action.VIDEO_CAMERA";
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(this, Camera.class));
        if ("com.oppo.action.VIDEO_CAMERA".equals(str)) {
            intent.addFlags(268468224);
        }
        Uri uri = null;
        try {
            uri = getReferrer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (uri != null && !TextUtils.isEmpty(uri.getHost())) {
            intent.putExtra("extra_key_caller_package_name", uri.getHost());
        }
        if (extras != null) {
            try {
                e.a("VideoCamera", "onCreate, save uri: " + extras.getParcelable("output") + ", crop value: " + extras.getString("crop"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            intent.putExtras(extras);
        }
        startActivityForResult(intent, 1003);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        e.a("VideoCamera", "onActivityResult(), requestCode: " + i + ", resultCode: " + i2);
        super.onActivityResult(i, i2, intent);
        if (i == 1003) {
            setResult(i2, intent);
            finish();
            overridePendingTransition(R.anim.oppo_close_slide_enter, R.anim.oppo_close_slide_exit);
        }
    }
}
