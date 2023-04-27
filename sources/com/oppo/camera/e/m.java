package com.oppo.camera.e;

import android.app.Activity;
import android.util.Size;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.f.j;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.List;

/* compiled from: MicroscopeCaptureMode */
public class m extends e {
    public String a() {
        return ApsConstant.CAPTURE_MODE_MICROSCOPE;
    }

    public boolean a(float f) {
        return true;
    }

    public boolean aa() {
        return false;
    }

    public String bu() {
        return "torch";
    }

    public boolean c(String str) {
        return false;
    }

    public String cg() {
        return "key_filter_anc_index";
    }

    public boolean d() {
        return false;
    }

    public boolean dt() {
        return true;
    }

    public boolean ec() {
        return false;
    }

    public boolean ej() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fl() {
        return false;
    }

    public boolean z(String str) {
        return false;
    }

    public m(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    public boolean r(String str) {
        if (!"type_main_preview_frame".equals(str)) {
            return "type_still_capture_yuv_main".equals(str);
        }
        if (3 == AlgoSwitchConfig.getApsVersion()) {
            return true;
        }
        return false;
    }

    public boolean f(String str) {
        if ("pref_time_lapse_key".equals(str) || "pref_camera_flashmode_key".equals(str) || "pref_camera_gesture_shutter_key".equals(str) || "pref_ai_scene_key".equals(str) || "pref_super_clear_portrait".equals(str) || "pref_camera_video_slogan_key".equals(str) || "pref_slogan_owner_key".equals(str) || "pref_burst_shot_key".equals(str) || "key_high_picture_size".equals(str) || "pref_10bits_heic_encode_key".equals(str) || CameraFunction.SAT_CAMERA.equals(str) || "pref_qr_code_key".equals(str) || CameraFunction.GOOGLE_LENS.equals(str) || "key_suppport_multi_focus".equals(str) || "support_focus_out_of_range".equals(str)) {
            return false;
        }
        if ("pref_filter_process_key".equals(str)) {
            return true;
        }
        return super.f(str);
    }

    public void f(boolean z) {
        super.f(z);
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (!m.this.y) {
                    m.this.Y.am();
                    m.this.Y.a((int) R.string.camera_hint_microscope, -1, true, false, false);
                }
            }
        });
    }

    public ab dl() {
        ab dl = super.dl();
        dl.u(true);
        return dl;
    }

    public c o() {
        c o = super.o();
        o.b("button_shape_ring_none");
        return o;
    }

    public Size d(j jVar) {
        return Util.c(jVar.a(256), 1.3333333333333333d);
    }

    public h.a du() {
        return h.a.Anc;
    }

    /* access modifiers changed from: protected */
    public List<Integer> f(int i) {
        return g.g;
    }

    /* access modifiers changed from: protected */
    public List<String> g(int i) {
        return g.d;
    }
}
