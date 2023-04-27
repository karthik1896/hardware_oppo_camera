package com.oppo.camera.e;

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import android.view.MotionEvent;
import com.oppo.camera.R;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.professional.a;
import com.oppo.camera.professional.i;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: HighDefinitionMode */
public class j extends e {
    private i aB = null;
    private com.oppo.camera.professional.j aC = null;
    private ArrayList aD = null;

    public String a() {
        return ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
    }

    public String b() {
        return ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
    }

    public boolean bw() {
        return true;
    }

    public boolean c(String str) {
        return false;
    }

    public boolean cA() {
        return false;
    }

    public boolean d() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public j(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public long aK() {
        return (long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_HIGH_DEFINITION);
    }

    /* access modifiers changed from: protected */
    public String ei() {
        return this.Z.getString(R.string.camera_picture_size_standard);
    }

    public Size d(com.oppo.camera.f.j jVar) {
        return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE);
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("HighDefinitionMode", "onInitCameraMode");
        super.s();
        bo();
        if (bq()) {
            if (fO()) {
                H(1);
                e(0, false);
            } else {
                H(0);
            }
            this.aC = new com.oppo.camera.professional.j(this.Z, this.X, this.Y);
            this.aC.a("pref_high_picture_pro_mode_key");
            d(f("pref_high_picture_pro_mode_key") ? 0 : 8, false);
            this.Y.A(false);
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        i iVar;
        com.oppo.camera.e.e("HighDefinitionMode", "onResume");
        super.a(z);
        if (fO() && (iVar = this.aB) != null) {
            iVar.e();
        }
    }

    /* access modifiers changed from: private */
    public boolean fO() {
        if (f("pref_high_picture_pro_mode_key") && this.aa != null) {
            return "on".equals(this.aa.getString("pref_high_picture_pro_mode_key", "off"));
        }
        return false;
    }

    public boolean cS() {
        i iVar = this.aB;
        if (iVar != null) {
            return iVar.i();
        }
        return false;
    }

    private void d(int i, boolean z) {
        if (bq()) {
            if (this.aC == null) {
                if (i == 0) {
                    this.aC = new com.oppo.camera.professional.j(this.Z, this.X, this.Y);
                    this.aC.a("pref_high_picture_pro_mode_key");
                } else {
                    return;
                }
            }
            this.aC.a(i, z);
        }
    }

    private void e(int i, boolean z) {
        com.oppo.camera.e.a("HighDefinitionMode", "setProMenuVisibility visibility: " + i);
        if (this.aB == null) {
            if (i == 0) {
                fP();
            } else {
                return;
            }
        }
        this.aB.a(i, z);
    }

    public void e(int i) {
        i iVar = this.aB;
        if (iVar != null) {
            iVar.b(i);
        }
        if (this.k != i) {
            this.k = i;
        }
    }

    private void fP() {
        this.aB = new a(this.Z, this.X, this.Y, a());
        this.aB.a((i.b) new a.C0091a() {
            public boolean a() {
                return j.this.v;
            }

            public boolean b() {
                return j.this.fO();
            }

            public boolean a(String str) {
                return j.this.f(str);
            }

            public int c() {
                if (!j.this.bC() || !j.this.aV()) {
                    return j.super.bt();
                }
                return j.this.W.p();
            }

            public void b(String str) {
                j.this.W.a(str);
            }

            public void a(int i) {
                j.this.W.k(i);
            }

            public int d() {
                return j.this.W.p();
            }

            public void b(int i) {
                j.this.W.a(i, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
            }

            public void a(float f) {
                j.this.W.b(f);
            }

            public void a(long j) {
                j.this.W.a(j);
            }

            public void b(long j) {
                j.this.W.d(j);
            }

            public void a(boolean z) {
                j.this.W.f(z);
            }

            public void c(int i) {
                j.this.W.m(i);
            }

            public void e() {
                j.this.W.r();
            }

            public void d(int i) {
                j.this.W.q(0);
            }

            public void e(int i) {
                j.this.W.f(i);
            }

            public void f() {
                j.this.W.a((f.c) null);
            }

            public void g() {
                j.this.W.t();
            }

            public c h() {
                return j.this.o();
            }
        });
    }

    public void a(ApsTotalResult apsTotalResult) {
        super.a(apsTotalResult);
        if (this.A && this.aB != null && fO()) {
            this.aB.a(apsTotalResult.getTotalResult());
        }
    }

    public boolean f(String str) {
        i iVar;
        if (CameraFunction.MODE_PANEL.equals(str) || "pref_camera_hdr_mode_key".equals(str) || CameraFunction.SAT_CAMERA.equalsIgnoreCase(str) || "pref_support_switch_camera".equals(str) || "pref_filter_process_key".equals(str) || "pref_burst_shot_key".equals(str) || "pref_camera_photo_ratio_key".equals(str) || "pref_qr_code_key".equals(str) || CameraFunction.GOOGLE_LENS.equals(str)) {
            return false;
        }
        if ("pref_high_picture_pro_mode_key".equals(str)) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HIGHPICTURE_PRO_MODE_SUPPORT) || this.t) {
                return false;
            }
            return true;
        } else if ("pref_manual_exposure_key".equals(str)) {
            return !fO();
        } else {
            if ("key_support_update_thumbnail_user_picture".equals(str)) {
                if (this.X == null || !this.X.j() || (iVar = this.aB) == null || iVar.d(1)) {
                    return false;
                }
                return true;
            } else if ("pref_support_capture_preview".equals(str)) {
                if (this.X == null || !this.X.j() || f("key_support_update_thumbnail_user_picture") || f("high_resolution_cancel_snapshot")) {
                    return false;
                }
                return true;
            } else if ("high_resolution_cancel_snapshot".equals(str)) {
                return false;
            } else {
                return super.f(str);
            }
        }
    }

    public boolean d(String str) {
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_setting_key".equals(str) || "pref_high_picture_pro_mode_key".equals(str)) {
            return true;
        }
        return super.d(str);
    }

    public void G(boolean z) {
        fL();
        if (z) {
            if (f("pref_camera_pi_ai_mode_key")) {
                this.Y.a("pref_camera_pi_ai_mode_key", "off");
            } else {
                this.Y.a("pref_camera_pi_mode_key", "off");
            }
        } else if (f("pref_camera_pi_ai_mode_key")) {
            this.Y.b("pref_camera_pi_ai_mode_key", (String) null);
        } else {
            this.Y.b("pref_camera_pi_mode_key", (String) null);
        }
    }

    public Size a(String str, com.oppo.camera.f.j jVar) {
        if ("type_still_capture_yuv_mfnr".equals(str)) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_MFNR_PICTURE_SIZE);
        }
        return super.a(str, jVar);
    }

    public boolean r(String str) {
        if ("type_still_capture_yuv_mfnr".equals(str)) {
            return aJ();
        }
        return super.r(str);
    }

    /* access modifiers changed from: protected */
    public boolean aJ() {
        return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_MFNR_PICTURE_SIZE) != null;
    }

    /* access modifiers changed from: protected */
    public boolean v(String str) {
        if ("pref_camera_pi_ai_mode_key".equals(str) || "pref_camera_pi_mode_key".equals(str)) {
            return !fO();
        }
        return super.v(str);
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        if ("pref_high_picture_pro_mode_key".equals(str)) {
            boolean fO = fO();
            com.oppo.camera.e.b("HighDefinitionMode", "onSharedPreferenceChanged isProModeOn: " + fO);
            if (fO) {
                fP();
            } else {
                i iVar = this.aB;
                if (iVar != null) {
                    iVar.g();
                    this.aB.a((i.b) null);
                    this.aB = null;
                }
            }
            G(fO);
            e(fO ? 0 : 8, false);
            fQ();
            this.aC.a(fO);
            this.X.aA();
            this.Y.A(false);
            H(fO() ? 1 : 0);
            fR();
            if (!fO) {
                this.aB.n();
                if (!this.Y.d()) {
                    this.Y.a(0);
                }
            }
        }
        i iVar2 = this.aB;
        if (iVar2 != null) {
            iVar2.a(sharedPreferences, str);
        }
        super.a(sharedPreferences, str);
    }

    private void fQ() {
        if (this.aB != null && this.aa != null && fO() && this.aa.getBoolean("pref_restore_high_picture_pro_params", false)) {
            this.aa.edit().remove("pref_restore_high_picture_pro_params").apply();
            this.aB.n();
            this.aB.b();
        }
    }

    private void H(int i) {
        com.oppo.camera.e.a("HighDefinitionMode", "updateHighpictureProMode, value: " + i);
        if (this.W != null) {
            this.W.G(i);
            this.W.a(-1);
            this.W.m(-1);
            this.W.a((f.c) null);
        }
    }

    private void fR() {
        if (f("pref_high_picture_pro_mode_key")) {
            if (fO()) {
                this.Y.a((int) R.string.camera_scene_highpicture_pro_tips_realme, -1, false, false, true);
            } else {
                this.Y.b((int) R.string.camera_scene_highpicture_pro_tips_realme);
            }
        }
    }

    private List<String> fS() {
        ArrayList arrayList = this.aD;
        if (arrayList != null) {
            return arrayList;
        }
        this.aD = new ArrayList();
        this.aD.add(this.Z.getResources().getString(R.string.camera_scene_night_tips));
        this.aD.add(this.Z.getResources().getString(R.string.camera_scene_night_low_exposure_time_tips_realme));
        this.aD.add(this.Z.getResources().getString(R.string.camera_scene_night_image_optimizing_tips_realme));
        return this.aD;
    }

    public void cP() {
        if (!fO()) {
            super.cP();
        }
    }

    public void dr() {
        com.oppo.camera.e.a("HighDefinitionMode", "onMoreModeShown");
        if (bq()) {
            if (fO()) {
                e(8, false);
            }
            d(8, false);
        }
        super.dr();
    }

    public void t(int i) {
        com.oppo.camera.e.a("HighDefinitionMode", "onMoreModeHidden");
        if (bq()) {
            if (fO()) {
                e(0, false);
                fR();
            }
            d(f("pref_high_picture_pro_mode_key") ? 0 : 8, false);
        }
        super.t(i);
    }

    public boolean au() {
        if (this.aB == null || !fO()) {
            return super.au();
        }
        return this.aB.c();
    }

    /* access modifiers changed from: protected */
    public void u() {
        com.oppo.camera.e.b("HighDefinitionMode", "onBeforePreview");
        if (f("pref_high_picture_pro_mode_key")) {
            H(fO() ? 1 : 0);
        }
        if (this.aB != null && fO()) {
            this.aB.d(this.A);
            fR();
        }
        super.u();
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        if (bq()) {
            if (this.aB != null && fO()) {
                if (!this.aB.a(false)) {
                    return false;
                }
                i iVar = this.aB;
                if (iVar.d(iVar.w())) {
                    this.Y.b((int) R.string.camera_scene_highpicture_pro_tips_realme);
                    this.Y.a(fS(), 3000);
                }
            }
            com.oppo.camera.professional.j jVar = this.aC;
            if (jVar != null) {
                jVar.a(8, false);
            }
        }
        return super.a(dVar);
    }

    public boolean aM() {
        if (this.aB != null && fO()) {
            this.aB.v();
        }
        return super.aM();
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        if (this.aB != null && fO()) {
            this.aB.a(bArr, z, false);
        }
        if (this.aC != null && f("pref_high_picture_pro_mode_key")) {
            this.aC.a(0, true);
        }
        if (f("pref_high_picture_pro_mode_key")) {
            this.Y.g();
            fR();
        }
        super.a(bArr, z);
    }

    public boolean b(MotionEvent motionEvent) {
        if (this.aB == null || !fO()) {
            return super.b(motionEvent);
        }
        return this.aB.a(motionEvent);
    }

    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if (!Util.p() && d.a.CAPTURE == dVar.a() && hashMap.containsKey("type_main_preview_frame") && fO()) {
            Long valueOf = Long.valueOf(this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value)));
            if (valueOf.longValue() >= 40000000) {
                com.oppo.camera.e.a("HighDefinitionMode", "onRequestBuilderCreated, setSlowShutter, exposureTime: " + valueOf);
                builder.removeTarget(hashMap.get("type_main_preview_frame").a());
                builder.set(CaptureRequest.FLASH_MODE, 0);
                builder.set(CaptureRequest.CONTROL_AE_MODE, 0);
                builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, valueOf);
            } else {
                com.oppo.camera.e.a("HighDefinitionMode", "onRequestBuilderCreated, exposureTime not slow shutter");
            }
            if (hashMap.get("type_still_capture_raw") != null && eK()) {
                builder.addTarget(hashMap.get("type_still_capture_raw").a());
                builder.set(CaptureRequest.STATISTICS_LENS_SHADING_MAP_MODE, 1);
            }
        }
        super.a(dVar, builder, hashMap, i);
    }

    public void f(boolean z) {
        com.oppo.camera.e.b("HighDefinitionMode", "onAfterStartPreview");
        if (bq()) {
            if (this.aB != null && fO()) {
                this.aB.u();
            }
            com.oppo.camera.professional.j jVar = this.aC;
            if (jVar != null) {
                jVar.b();
            }
            if (fO()) {
                this.Y.A(false);
            }
        }
        if (this.W != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_PICTURE_ULTRA_RESOLUTION_MODE)) {
            this.W.n(true);
            this.W.a((f.c) null);
        }
        super.f(z);
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.c("HighDefinitionMode", "onDeInitCameraMode");
        if (bq()) {
            this.Y.b((int) R.string.camera_scene_highpicture_pro_tips_realme);
            this.Y.a(true, true, false);
            i iVar = this.aB;
            if (iVar != null) {
                iVar.g();
                this.aB.a((i.b) null);
                this.aB = null;
            }
            if (f("pref_high_picture_pro_mode_key")) {
                H(0);
            }
            com.oppo.camera.professional.j jVar = this.aC;
            if (jVar != null) {
                jVar.a();
                this.aC = null;
            }
        }
        super.t();
    }

    /* access modifiers changed from: protected */
    public void p() {
        com.oppo.camera.e.a("HighDefinitionMode", "onPause");
        if (bq()) {
            this.Y.b((int) R.string.camera_scene_highpicture_pro_tips_realme);
            this.Y.a(true, true, false);
            if (this.aB != null && fO()) {
                this.aB.m();
                this.Y.j(0);
                H(0);
            }
        }
        super.p();
    }

    public boolean br() {
        i iVar;
        if (!fO() || (iVar = this.aB) == null || iVar.d(1)) {
            return super.br();
        }
        return false;
    }

    public int c() {
        return super.c();
    }

    public void c(int i, boolean z) {
        com.oppo.camera.e.a("HighDefinitionMode", "changeModeAllView animationType: " + i + ", isShow: " + z);
        super.c(i, z);
        if (3 == i && f("pref_high_picture_pro_mode_key")) {
            if (this.aB != null) {
                this.aB.b((!z || !this.v) ? z : false);
            }
            int i2 = 8;
            if (z) {
                if (fO()) {
                    if (fO()) {
                        i2 = 0;
                    }
                    e(i2, true);
                }
                d(0, false);
                return;
            }
            if (fO()) {
                e(8, true);
            }
            d(8, false);
        }
    }
}
