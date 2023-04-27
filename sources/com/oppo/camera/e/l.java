package com.oppo.camera.e;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Size;
import com.oppo.camera.Camera;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.f.d;
import com.oppo.camera.f.j;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;

/* compiled from: MacroMode */
public class l extends a {
    private boolean at = false;
    private int au = 0;

    public String a() {
        return ApsConstant.CAPTURE_MODE_MACRO;
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        return true;
    }

    public int c() {
        return 32934;
    }

    public String cg() {
        return "key_macro_filter_index";
    }

    /* access modifiers changed from: protected */
    public void p() {
    }

    /* access modifiers changed from: protected */
    public void q() {
    }

    /* access modifiers changed from: protected */
    public void r() {
    }

    /* access modifiers changed from: protected */
    public void s() {
    }

    /* access modifiers changed from: protected */
    public void u() {
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public l(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public void t() {
        fC();
    }

    public Size d(j jVar) {
        return Util.c(jVar.a(256), 1.3333333333333333d);
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences != null) {
            if ("pref_camera_videoflashmode_key".equals(str) && this.Z != null && !Camera.m && !Camera.l) {
                if ("off".equals(sharedPreferences.getString("pref_camera_videoflashmode_key", this.Z.getString(R.string.camera_flash_mode_default_value)))) {
                    fD();
                } else {
                    fC();
                }
            }
            if ("pref_subsetting_key".equals(str) && "on".equals(sharedPreferences.getString("pref_subsetting_key", "off"))) {
                fC();
            }
            super.a(sharedPreferences, str);
        }
    }

    public void cP() {
        if (cz() || !this.at) {
            super.cP();
        } else {
            this.at = false;
        }
    }

    private void fC() {
        if (this.Y != null && this.Z != null) {
            this.Y.b(this.Z.getResources().getString(R.string.camera_macro_best_focus_distance_text, new Object[]{Integer.valueOf(this.au)}));
        }
    }

    private void fD() {
        if (this.X != null && !this.Y.J() && !cz() && this.Z != null && !this.W.e().s()) {
            this.Y.a(this.Z.getResources().getString(R.string.camera_macro_best_focus_distance_text, new Object[]{Integer.valueOf(this.au)}), false, true);
        }
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        com.oppo.camera.e.b("MacroMode", "onAfterPictureTaken");
        if (this.X != null && this.X.j()) {
            this.Y.d(true, false);
        }
    }

    public boolean d(String str) {
        if ("pref_camera_videoflashmode_key".equals(str) || "pref_camera_timer_shutter_key".equals(str) || "pref_setting_key".equals(str)) {
            return true;
        }
        return super.d(str);
    }

    public boolean c(String str) {
        if ("pref_camera_high_resolution_key".equals(str)) {
            return false;
        }
        return super.c(str);
    }

    public boolean f(String str) {
        if ("pref_zoom_key".equals(str) || "pref_support_switch_camera".equals(str)) {
            return false;
        }
        if ("key_support_show_dim_hint".equals(str) || "pref_filter_process_key".equals(str) || "pref_support_capture_preview".equals(str)) {
            return true;
        }
        if ("pref_camera_slogan_key".equals(str)) {
            return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_WATERMARK);
        }
        if ("pref_camera_videoflashmode_key".equals(str)) {
            return true;
        }
        if ("pref_support_raw_post_process".equals(str)) {
            return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_RAW2YUV);
        }
        return super.f(str);
    }

    public void f(boolean z) {
        super.f(z);
        this.au = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE);
        this.at = !cz();
        fD();
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2, boolean z3) {
        super.a(z, z2, z3);
        if (z2) {
            this.X.c(0);
            this.X.i();
        }
    }

    public void c(boolean z) {
        c o = o();
        o.b(0);
        this.Y.a(o);
    }
}
