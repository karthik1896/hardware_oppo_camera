package com.oppo.camera.e;

import android.app.Activity;
import android.util.Size;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.d;
import com.oppo.camera.f.j;
import com.oppo.camera.statistics.model.FocusAimMsgData;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;

/* compiled from: GroupShotMode */
public class i extends e implements d {
    private int aB = 0;

    public boolean F() {
        return true;
    }

    public String a() {
        return ApsConstant.CAPTURE_MODE_GROUP_SHOT;
    }

    public String b() {
        return null;
    }

    public String bu() {
        return "off";
    }

    public int c() {
        return 34817;
    }

    public boolean c(String str) {
        return false;
    }

    public boolean d() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int df() {
        return 30;
    }

    public boolean ec() {
        return false;
    }

    public boolean ej() {
        return true;
    }

    public boolean f() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fl() {
        return false;
    }

    public boolean z(String str) {
        return false;
    }

    public i(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
    }

    public Size d(j jVar) {
        return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n);
    }

    public boolean d(String str) {
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_filter_menu".equals(str) || "pref_setting_key".equals(str)) {
            return true;
        }
        if ("pref_camera_flashmode_key".equals(str) || "pref_camera_pi_ai_mode_key".equals(str)) {
            return false;
        }
        return super.d(str);
    }

    public c o() {
        String str;
        if (this.aa != null) {
            String string = this.aa.getString("pref_camera_timer_shutter_key", this.Z.getString(R.string.camera_shutter_mode_default_value));
            if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
            return new c(1, "button_color_inside_none", str, 0);
        }
        str = "button_shape_ring_none";
        return new c(1, "button_color_inside_none", str, 0);
    }

    /* access modifiers changed from: protected */
    public boolean a(com.oppo.camera.f.d dVar) {
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (i.this.y) {
                    com.oppo.camera.e.a("GroupShotMode", "onBeforeSnapping, return after pause");
                    return;
                }
                c cVar = new c();
                cVar.a("button_color_inside_none");
                cVar.a(4);
                i.this.Y.a(cVar);
            }
        });
        return true;
    }

    public boolean f(String str) {
        if ("pref_support_switch_camera".equals(str) || CameraFunction.SAT_CAMERA.equals(str) || CameraFunction.AIS_SNAPSHOT.equals(str) || "pref_burst_shot_key".equals(str) || "pref_camera_photo_ratio_key".equals(str) || "key_support_insensor_zoom_20x".equals(str) || CameraFunction.GOOGLE_LENS.equals(str) || "pref_10bits_heic_encode_key".equals(str) || "key_high_picture_size".equals(str) || "pref_support_raw_post_process".equals(str) || "pref_ai_scene_key".equals(str) || "pref_support_night_process".equals(str) || "support_focus_out_of_range".equals(str)) {
            return false;
        }
        if ("key_support_update_thumbnail_user_picture".equals(str)) {
            return true;
        }
        return super.f(str);
    }

    /* access modifiers changed from: protected */
    public boolean P() {
        return "on".equals(this.aa.getString("pref_super_clear_portrait", "off"));
    }

    public boolean br() {
        if (20 == this.aB) {
            return true;
        }
        return super.br();
    }

    public void a(ApsAdapterDecision.DecisionResult decisionResult) {
        this.aB = decisionResult.mApsDecisionFeatureType;
        super.a(decisionResult);
    }

    public ab dl() {
        ab abVar = new ab();
        abVar.p(false);
        abVar.b(false);
        abVar.f(false);
        abVar.c(false);
        abVar.d(false);
        abVar.m(true);
        return abVar;
    }
}
