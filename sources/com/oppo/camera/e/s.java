package com.oppo.camera.e;

import android.app.Activity;
import android.view.View;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;

/* compiled from: SuperTextMode */
public class s extends e {
    public boolean F() {
        return true;
    }

    public String a() {
        return "superText";
    }

    public boolean c(String str) {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean ej() {
        return true;
    }

    public boolean f() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fH() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fl() {
        return false;
    }

    public boolean z(String str) {
        return false;
    }

    public s(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    public int c() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_SCANNER_SUPPORT) ? 32934 : 32769;
    }

    public boolean d(String str) {
        if ("pref_camera_flashmode_key".equals(str) || "pref_camera_photo_ratio_key".equals(str) || "pref_setting_key".equals(str)) {
            return true;
        }
        return super.d(str);
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("SuperTextMode", "onInitCameraMode");
        this.Y.Q();
        super.s();
    }

    public boolean au() {
        super.au();
        return false;
    }

    public boolean ck() {
        return f(CameraFunction.SUPER_TEXT);
    }

    public c o() {
        c o = super.o();
        o.b("button_shape_ring_none");
        return o;
    }

    public boolean f(String str) {
        if ("pref_time_lapse_key".equals(str) || "pref_camera_gesture_shutter_key".equals(str) || "pref_support_switch_camera".equals(str) || "pref_ai_scene_key".equals(str) || "pref_super_clear_portrait".equals(str) || "pref_camera_slogan_key".equals(str) || "pref_camera_video_slogan_key".equals(str) || "pref_slogan_owner_key".equals(str) || "pref_burst_shot_key".equals(str) || "key_high_picture_size".equals(str) || CameraFunction.GOOGLE_LENS.equals(str) || "key_support_insensor_zoom_20x".equals(str) || "pref_10bits_heic_encode_key".equals(str) || "pref_qr_code_key".equals(str) || "pref_face_detection_key".equals(str) || "pref_support_capture_preview".equals(str)) {
            return false;
        }
        if ("key_support_update_thumbnail_user_picture".equals(str) || "pref_camera_flashmode_key".equals(str)) {
            return true;
        }
        if (!"key_suppport_multi_focus".equals(str) && !CameraFunction.AIS_SNAPSHOT.equals(str)) {
            return super.f(str);
        }
        return false;
    }

    public String b() {
        if (this.z) {
            return null;
        }
        if (AlgoSwitchConfig.getSupportCameraFeature("superText", this.n)) {
            return "superText";
        }
        return (!ex() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) ? ApsConstant.CAPTURE_MODE_COMMON : ApsConstant.FEATURE_COMMON_SAT_HAL;
    }

    public void f(boolean z) {
        super.f(z);
        if (!this.y && p("key_bubble_type_super_text")) {
            this.Y.a((View) null, 10, F(10), G(10));
        }
    }
}
