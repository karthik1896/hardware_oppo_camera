package com.oppo.camera.e;

import android.app.Activity;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.f.a;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.util.Util;
import java.util.HashMap;
import java.util.List;

/* compiled from: MicroscopeVideoMode */
public class n extends u {
    public String a() {
        return ApsConstant.REC_MODE_MICROSCOPE;
    }

    public boolean a(float f) {
        return true;
    }

    public int aH() {
        return 180;
    }

    public boolean aa() {
        return false;
    }

    public String bu() {
        return "torch";
    }

    public int c() {
        return 32779;
    }

    public boolean c(String str) {
        return false;
    }

    public String cg() {
        return "key_filter_anc_index";
    }

    public String ch() {
        return "pref_video_filter_menu";
    }

    public boolean d() {
        return false;
    }

    public String dk() {
        return "video_size_1080p";
    }

    public boolean dt() {
        return true;
    }

    public boolean ej() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean en() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fI() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public n(Activity activity, b bVar, e eVar, com.oppo.camera.ui.preview.a.n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        super.a(dVar, builder, hashMap, i);
        e(this.k);
    }

    public void e(int i) {
        super.e(i);
        if (3 == AlgoSwitchConfig.getApsVersion() && this.X.j() && this.W != null) {
            this.W.c((a.b(this.n, this.k) + aH()) % 360);
            this.W.d(95);
            this.W.a(this.X.v());
            this.W.a((f.c) null);
        }
    }

    public boolean f(String str) {
        if ("pref_time_lapse_key".equals(str) || "pref_camera_videoflashmode_key".equals(str) || CameraFunction.ULTRA_NIGHT_VIDEO.equals(str) || "pref_video_super_eis_key".equals(str) || "key_support_video_high_fps".equals(str) || "pref_camera_gesture_shutter_key".equals(str) || "pref_ai_scene_key".equals(str) || "pref_super_clear_portrait".equals(str) || "pref_camera_video_slogan_key".equals(str) || "pref_slogan_owner_key".equals(str) || "pref_burst_shot_key".equals(str) || "key_high_picture_size".equals(str) || "key_support_show_soloop".equals(str) || CameraFunction.AI_ENHANCEMENT_VIDEO.equals(str) || CameraFunction.GOOGLE_LENS.equals(str)) {
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
                if (!n.this.y) {
                    n.this.Y.am();
                    n.this.Y.a((int) R.string.camera_hint_microscope, -1, true, false, false);
                }
            }
        });
    }

    public ab dl() {
        ab dl = super.dl();
        dl.u(true);
        return dl;
    }

    public boolean r(String str) {
        if (!"type_main_preview_frame".equals(str) || 3 != AlgoSwitchConfig.getApsVersion()) {
            return false;
        }
        return true;
    }

    public c o() {
        c o = super.o();
        o.b("button_shape_ring_none");
        return o;
    }

    public Size e(j jVar) {
        return B(dk());
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

    public void bh() {
        super.bh();
        this.Y.a(new c(5, "button_color_inside_red", "button_shape_ring_none", 1));
    }

    /* access modifiers changed from: protected */
    public void G(boolean z) {
        super.G(z);
        this.Y.a(new c(6, "button_color_inside_red", "button_shape_ring_none", 1));
    }
}
