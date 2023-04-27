package com.oppo.camera.i;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Size;
import android.view.animation.Animation;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.e.a;
import com.oppo.camera.e.b;
import com.oppo.camera.e.u;
import com.oppo.camera.e.v;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.HashMap;

/* compiled from: FastVideoMode */
public class a extends u {
    private int aT = 10;
    private String aU = "video_size_1080p";
    private HashMap<String, String> aV = new HashMap<>();
    private Integer aW = 3;
    private float aX;
    private long aY = -1;
    private boolean aZ = false;

    public String a() {
        return ApsConstant.REC_MODE_FAST_VIDEO;
    }

    public boolean aM() {
        return false;
    }

    public boolean aa() {
        return false;
    }

    public boolean br() {
        return false;
    }

    public boolean c(String str) {
        return false;
    }

    public boolean fI() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int gu() {
        return 1500;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public a(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public void p() {
        H(true);
        if (fS() && this.X != null && !this.X.an()) {
            this.aa.edit().putBoolean("key_hyper_lapse_zoom_ultra_wide_open", true).apply();
        }
        super.p();
    }

    /* access modifiers changed from: protected */
    public void r() {
        super.r();
        HashMap<String, String> hashMap = this.aV;
        if (hashMap != null) {
            hashMap.clear();
            this.aV = null;
        }
    }

    public boolean au() {
        return super.au();
    }

    public boolean i(String str) {
        if (!"pref_video_size_key".equals(str) && !"pref_camera_videoflashmode_key".equals(str)) {
            return super.i(str);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("FastVideoMode", "onInitCameraMode");
        super.s();
        this.k = this.X.s();
        this.aT = 10;
        this.aZ = gr();
    }

    public boolean e(String str) {
        if (!"pref_face_detection_key".equals(str) || !dO()) {
            return super.e(str);
        }
        return false;
    }

    public boolean f(String str) {
        if ("pref_time_lapse_key".equals(str) || "pref_camera_videoflashmode_key".equals(str) || "pref_video_size_key".equals(str) || "pref_camera_tap_shutter_key".equals(str) || "pref_camera_gesture_shutter_key".equals(str) || "pref_support_recording_capture".equals(str) || "pref_slow_video_size_key".equals(str) || "pref_video_ratio_key".equals(str)) {
            return false;
        }
        if ("pref_zoom_key".equals(str)) {
            if (dO() || this.t) {
                return false;
            }
            if (!this.aZ || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HYPER_LAPSE_ULTRA_WIDE_SUPPORT)) {
                return true;
            }
            return false;
        } else if ("pref_video_eis".equals(str)) {
            if (!Util.p() || this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS)) {
                return false;
            }
            return true;
        } else if (CameraFunction.SAT_CAMERA.equals(str)) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_SAT) || this.t || !com.oppo.camera.f.a.f() || this.X == null || !this.X.j() || this.aZ) {
                return false;
            }
            return true;
        } else if ("pref_none_sat_ultra_wide_angle_key".equals(str)) {
            if (!N() || !this.X.j()) {
                return false;
            }
            return true;
        } else if (CameraFunction.TILT_SHIFT.equals(str)) {
            if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_TILT_SHIFT) || this.t || this.X == null || !this.X.j()) {
                return false;
            }
            return true;
        } else if ("pref_video_hyper_lapse_key".equals(str) || CameraFunction.KEY_VIDEO_HYPER_LAPSE_PROCESS.equals(str)) {
            if (this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HYPER_LAPSE) || this.X == null || !this.X.j()) {
                return false;
            }
            return true;
        } else if (!"key_zoom_wide_angle_open_default".equals(str)) {
            return super.f(str);
        } else {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) || this.t) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("FastVideoMode", "onDeInitCameraMode");
        H(true);
        super.t();
        this.aa.edit().putBoolean("key_hyper_lapse_zoom_ultra_wide_open", true).apply();
        fN();
    }

    public void e(int i) {
        this.k = i;
    }

    /* access modifiers changed from: protected */
    public void u() {
        com.oppo.camera.e.a("FastVideoMode", "onBeforePreview");
        super.u();
        this.aZ = gr();
        fL();
        H(false);
        dy();
    }

    public void am() {
        super.am();
        this.aZ = gr();
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof VideoRecordMsgData) {
            videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData.mLux = String.valueOf(this.aD);
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    public boolean eB() {
        if (!fT() || this.aa == null) {
            return super.eB();
        }
        return this.aa.getBoolean("key_hyper_lapse_zoom_ultra_wide_open", true);
    }

    private void fL() {
        com.oppo.camera.e.a("FastVideoMode", "setFastValueToParameter, mSpeedValue: " + this.aT);
        int i = this.aT;
        if (i == 2) {
            this.aW = 15;
            this.aX = 0.5f;
        } else if (i == 4) {
            this.aX = 0.25f;
            this.aW = 8;
        } else if (i == 6) {
            this.aW = 5;
            this.aX = 0.16666667f;
        } else if (i == 8) {
            this.aW = 4;
            this.aX = 0.125f;
        } else if (i == 10) {
            this.aW = 3;
            this.aX = 0.1f;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        return dO();
    }

    public Float gb() {
        float f = this.aX;
        com.oppo.camera.e.a("FastVideoMode", "getRealVideoTimeRatio, ratio: " + f);
        return Float.valueOf(f);
    }

    public int E() {
        return this.aZ ? 3 : 0;
    }

    /* access modifiers changed from: protected */
    public Integer fG() {
        if (this.aZ) {
            return 0;
        }
        return this.aW;
    }

    public boolean r(String str) {
        if ("type_main_preview_frame".equals(str)) {
            if (3 == AlgoSwitchConfig.getApsVersion()) {
                return true;
            }
            return false;
        } else if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            if (3 != AlgoSwitchConfig.getApsVersion() || this.t || !ex() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
                return false;
            }
            return true;
        } else if (!"type_video_frame".equals(str)) {
            return "type_video".equals(str);
        } else {
            if (this.aZ) {
                return true;
            }
            if (!f("pref_camera_video_slogan_key") || !gi()) {
                return false;
            }
            return true;
        }
    }

    public boolean d(String str) {
        if ("pref_video_hyper_lapse_key".equals(str)) {
            return f(str);
        }
        if ("pref_video_timelapse_tilt_shift_key".equals(str)) {
            return f(CameraFunction.TILT_SHIFT);
        }
        return super.d(str);
    }

    /* access modifiers changed from: protected */
    public boolean dz() {
        return dB();
    }

    /* access modifiers changed from: protected */
    public boolean dB() {
        return f(CameraFunction.TILT_SHIFT) && this.aa != null && "on".equals(this.aa.getString("pref_video_timelapse_tilt_shift_key", "off"));
    }

    /* access modifiers changed from: protected */
    public boolean fP() {
        return !dB();
    }

    public void s(String str) {
        com.oppo.camera.e.a("FastVideoMode", "onMenuOptionAdded, key: " + str);
        if ("pref_video_timelapse_tilt_shift_key".equals(str)) {
            this.Y.a("pref_video_timelapse_tilt_shift_key", f(CameraFunction.TILT_SHIFT) && this.Y.V(), (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    public void dC() {
        boolean dz = dz();
        com.oppo.camera.e.a("FastVideoMode", "onTiltShiftChanged, isOpen: " + dz);
        if (dz && gr()) {
            this.aa.edit().putString("pref_video_hyper_lapse_key", "off").apply();
        }
        dy();
        if (!dz) {
            this.Y.c(true, true, true);
            this.Y.y(true);
            return;
        }
        this.Y.x(true);
    }

    /* access modifiers changed from: protected */
    public boolean en() {
        return this.X != null && this.X.j() && dB();
    }

    public boolean dn() {
        return !this.t && dz();
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        if ("pref_video_hyper_lapse_key".equals(str)) {
            this.aZ = "on".equals(sharedPreferences.getString("pref_video_hyper_lapse_key", this.Z.getString(R.string.camera_video_hyper_lapse_default_value)));
            if (fS()) {
                sharedPreferences.edit().putBoolean("key_hyper_lapse_zoom_ultra_wide_open", true).apply();
            }
            if (this.X != null) {
                this.X.ap();
            }
            if (this.aZ && !this.y && this.aa.getBoolean("key_bottom_guide_type_fast_video", true)) {
                this.Y.n(1);
            }
        } else if (!fS() || !"key_hyper_lapse_zoom_ultra_wide_open".equals(str) || this.X == null || dO()) {
            if ("key_video_hyper_lapse_focus_first_hints".equals(str) && this.aa.getBoolean("key_video_hyper_lapse_focus_first_hints", false)) {
                this.Y.a(R.string.camera_video_hyper_lapse_hint, 0, false, false, true, false, false);
            }
            super.a(sharedPreferences, str);
        } else {
            this.X.ao();
        }
    }

    public void f(boolean z) {
        super.f(z);
        if (!this.aZ || this.t) {
            fN();
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HYPER_LAPSE_ULTRA_WIDE_SUPPORT) && this.t) {
                this.aa.edit().putBoolean("key_hyper_lapse_zoom_ultra_wide_open", true).apply();
                return;
            }
            return;
        }
        this.Y.h(true);
        if (this.aa.getBoolean("key_video_hyper_lapse_focus_first_hints", false) && !this.aa.getBoolean("key_bottom_guide_type_fast_video", true)) {
            this.Y.a(R.string.camera_video_hyper_lapse_hint, 0, false, false, true, true, false);
        }
    }

    private void fN() {
        this.Y.h(false);
        this.Y.b((int) R.string.camera_video_hyper_lapse_hint);
    }

    public void dm() {
        super.dm();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HYPER_LAPSE_ULTRA_WIDE_SUPPORT) && this.aa != null) {
            this.aa.edit().putBoolean("key_hyper_lapse_zoom_ultra_wide_open", true).apply();
        }
    }

    public Size a(String str, j jVar) {
        if (this.aZ) {
            Size a2 = a(b(), str, a.C0080a.INPUT);
            if (a2 != null) {
                return a2;
            }
            com.oppo.camera.e.d("FastVideoMode", "getSurfaceSize, getVideoPipelineSize failed!");
        }
        return super.d(jVar);
    }

    /* access modifiers changed from: protected */
    public boolean fC() {
        if ((this.aZ && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_END_VIDEO_EIS_STREAM)) || !Util.p()) {
            return false;
        }
        byte[] k = this.W.e().k();
        com.oppo.camera.e.a("FastVideoMode", "isQualcommEndOfStreamNeed, endOfStreamValue: " + k);
        if (k == null || k.length <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean ep() {
        return !AlgoSwitchConfig.getSupportApsPreview() || (!eo() && !this.aZ && (this.t || !ex() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)));
    }

    /* access modifiers changed from: protected */
    public ImageCategory.ItemInfoType eR() {
        return (!dO() || en() || !r("type_video_frame")) ? ImageCategory.ItemInfoType.PREVIEW : ImageCategory.ItemInfoType.VIDEO;
    }

    public long eU() {
        if (!Util.p() || !this.aZ) {
            return super.eU();
        }
        return super.eU();
    }

    public String dk() {
        return this.aU;
    }

    public int dj() {
        return fF();
    }

    public Size e(j jVar) {
        Size B = B("video_size_1080p");
        if (B != null) {
            return B;
        }
        return super.e(jVar);
    }

    public int c() {
        int i = (this.t || !f("key_support_fovc")) ? 32780 : 33548;
        if (this.aZ) {
            i = 32933;
        }
        return (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT) || !em()) ? i : i | 1024;
    }

    public c o() {
        c o = super.o();
        o.b("button_shape_dial_rotate");
        return o;
    }

    public void cP() {
        if (fW()) {
            this.Y.a(false, true, true);
        }
    }

    public void d(boolean z, boolean z2) {
        if (!fW()) {
            this.Y.a(false, true, true);
        }
    }

    public boolean cz() {
        return fW();
    }

    public void bh() {
        if (this.X != null) {
            this.X.a((Animation.AnimationListener) null);
        }
        this.Y.a(new c(5, "button_color_inside_red", "button_shape_dial_rotate", 1));
        super.bh();
        if (this.W != null) {
            if (!Util.p() && this.X != null) {
                this.W.c(com.oppo.camera.f.a.b(this.n, this.X.s()));
            }
            this.W.a((f.c) null);
        }
    }

    public void G(boolean z) {
        super.G(z);
        if (this.X != null) {
            this.X.D();
        }
        this.aY = -1;
        this.Y.a(new c(6, "button_color_inside_red", "button_shape_dial_rotate", 1));
    }

    public String b() {
        if (this.z) {
            return null;
        }
        if (this.aZ) {
            return fR() ? ApsConstant.FEATURE_REC_HYPER_LAPSE_PRO : ApsConstant.FEATURE_REC_HYPER_LAPSE;
        }
        if (!ex() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
            return super.b();
        }
        return ApsConstant.FEATURE_REC_SAT_HAL;
    }

    public boolean w(String str) {
        if (!ex() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
            return super.w(str);
        }
        return false;
    }

    public ab dl() {
        ab dl = super.dl();
        dl.n(gr());
        dl.c(eB());
        dl.d(fS());
        dl.e(false);
        dl.v(f("key_zoom_wide_angle_open_default"));
        return dl;
    }

    /* access modifiers changed from: protected */
    public long gm() {
        double intValue;
        long j;
        if (this.aZ) {
            intValue = 10.0d;
            j = this.aw;
        } else {
            intValue = 30.0d / ((double) this.aW.intValue());
            j = this.aw;
        }
        return (long) ((int) (((double) j) / intValue));
    }

    public int D() {
        return (this.aZ || dB()) ? 40 : 20;
    }

    private boolean fR() {
        if (!fS() || !this.aa.getBoolean("key_hyper_lapse_zoom_ultra_wide_open", true)) {
            return false;
        }
        return true;
    }

    private boolean fS() {
        return f("pref_none_sat_ultra_wide_angle_key") || fT();
    }

    private boolean fT() {
        return this.aZ && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HYPER_LAPSE_ULTRA_WIDE_SUPPORT);
    }

    /* access modifiers changed from: protected */
    public boolean gr() {
        return !this.t && this.X != null && this.X.j() && "on".equals(this.aa.getString("pref_video_hyper_lapse_key", this.Z.getString(R.string.camera_video_hyper_lapse_default_value)));
    }

    /* renamed from: do  reason: not valid java name */
    public long m8do() {
        return (this.aZ || dB()) ? 131 : 128;
    }

    /* access modifiers changed from: protected */
    public boolean gh() {
        return !gr();
    }

    /* access modifiers changed from: protected */
    public void a(v vVar) {
        super.a(vVar);
        if (Util.p()) {
            vVar.c("set-video-mode=fastvideo");
        }
    }
}
