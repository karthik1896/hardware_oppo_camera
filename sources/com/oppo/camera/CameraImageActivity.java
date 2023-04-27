package com.oppo.camera;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.oppo.camera.util.Util;

public class CameraImageActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private i f2736a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2737b = false;
    private int c = 0;
    private String d = null;
    private Handler e = new Handler();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean isKeyguardLocked = ((KeyguardManager) getApplicationContext().getSystemService("keyguard")).isKeyguardLocked();
        boolean J = Util.J();
        this.d = a();
        e.c("CameraImageActivity", "onCreate, this: " + this + ", isKeyguardLocked: " + isKeyguardLocked + ", hasNavigationBar: " + J + ", mCallerHost: " + this.d);
        if (!isKeyguardLocked || !"com.android.systemui".equals(this.d) || J) {
            b();
        } else {
            this.c = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        e.a("CameraImageActivity", "onResume, this: " + this + ", launched: " + this.f2737b);
        if (!this.f2737b) {
            this.c++;
            e.a("CameraImageActivity", "onResume, this: " + this + ", lifecycleCount: " + this.c);
            if (this.c > 1) {
                this.e.removeCallbacksAndMessages((Object) null);
                b();
                return;
            }
            this.e.postDelayed(new Runnable() {
                public void run() {
                    e.a("CameraImageActivity", "run post delayed task, launch camera.");
                    CameraImageActivity.this.b();
                }
            }, 500);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        e.a("CameraImageActivity", "onPause, this: " + this + ", lifecycleCount: " + this.c + ", launched: " + this.f2737b);
        if (this.f2737b) {
            finish();
            this.c = 0;
        }
    }

    private String a() {
        Uri uri;
        try {
            uri = getReferrer();
        } catch (Exception e2) {
            e2.printStackTrace();
            uri = null;
        }
        if (uri == null || TextUtils.isEmpty(uri.getHost())) {
            return null;
        }
        return uri.getHost();
    }

    /* access modifiers changed from: private */
    public void b() {
        boolean z;
        if (this.f2737b) {
            e.a("CameraImageActivity", "launchCameraActivity, mbLaunchCameraActivity: " + this.f2737b);
            return;
        }
        e.a("CameraImageActivity", "launchCameraActivity, isVoiceInteractionRoot: " + isVoiceInteractionRoot());
        try {
            z = getIntent().getBooleanExtra("com.oppo.camera.extra.IS_VOICE_INTERACTION_ROOT", false);
        } catch (Exception e2) {
            e2.printStackTrace();
            z = false;
        }
        if (isVoiceInteractionRoot()) {
            getIntent().addFlags(276824064);
            getIntent().putExtra("com.oppo.camera.extra.IS_VOICE_INTERACTION_ROOT", true);
        } else if (z) {
            getIntent().putExtra("com.oppo.camera.extra.IS_VOICE_INTERACTION_ROOT", false);
        }
        this.f2736a = new i(this, (k) null);
        if (!this.f2736a.d()) {
            getIntent().addFlags(268468224);
            e.a("CameraImageActivity", "onCreate, has no necessaryPermissions so clean task");
        }
        if (this.d != null) {
            getIntent().putExtra("extra_key_caller_package_name", this.d);
        }
        getIntent().setComponent(new ComponentName(this, Camera.class));
        startActivity(getIntent());
        overridePendingTransition(R.anim.oppo_fade_in_fast, R.anim.oppo_fade_out_fast);
        this.f2737b = true;
    }
}
