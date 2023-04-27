package com.oppo.camera.e;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.View;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.e.a;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.k;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.setting.CameraMenuOption;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.HashMap;

/* compiled from: CommonVideoMode */
public class f extends u {
    private boolean aT = true;
    private boolean aU = false;
    private boolean aV = false;
    private boolean aW = false;
    private int aX = -1;
    private int aY = 0;
    /* access modifiers changed from: private */
    public CameraMenuOption aZ = null;
    private boolean ba = false;
    private Range<Integer> bb = Range.create(60, 60);
    private Range<Integer> bc = Range.create(30, 30);
    private Range<Integer> bd = Range.create(20, 30);
    private Drawable be = null;
    private Drawable bf = null;
    private int bg = g.f4385a;

    public int C() {
        return 1;
    }

    public String a() {
        return ApsConstant.REC_MODE_COMMON;
    }

    /* access modifiers changed from: protected */
    public String bY() {
        return "pref_video_facebeauty_level_menu";
    }

    public String cJ() {
        return "key_video_hdr";
    }

    public String ch() {
        return "pref_video_filter_menu";
    }

    /* access modifiers changed from: protected */
    public boolean ee() {
        return false;
    }

    public boolean ej() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fl() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean v(String str) {
        return true;
    }

    public f(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
        if (this.ab == null) {
            return;
        }
        if (f("pref_video_blur_menu") || f(CameraFunction.VIDEO_BLUR_PROCESS)) {
            E(eu());
        }
    }

    public int eW() {
        if (this.t) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SUPPORT_FRONT_DARK_TIPS_THRESHOLD);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SUPPORT_BACK_DARK_TIPS_THRESHOLD);
    }

    /* access modifiers changed from: protected */
    public void h(int i) {
        if (this.aA != null) {
            this.aA.m(i);
        }
    }

    public void eF() {
        super.eF();
        if (this.Z != null) {
            com.oppo.camera.e.a("CommonVideoMode", "displayFixedUpModeHint");
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (f.this.fE()) {
                        f.this.Y.E();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public boolean fC() {
        if ((aG() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_END_VIDEO_EIS_STREAM)) || !Util.p()) {
            return false;
        }
        byte[] k = this.W.e().k();
        com.oppo.camera.e.a("CommonVideoMode", "isQualcommEndOfStreamNeed, endOfStreamValue: " + k);
        if (k == null || k.length <= 0) {
            return false;
        }
        return true;
    }

    public int c() {
        int i;
        if (this.t || !f("key_support_fovc")) {
            i = 32779;
        } else {
            i = 33547;
            if (Util.p() && f("key_support_video_high_fps") && 60 == gB()) {
                i = 32801;
            }
        }
        if (!Util.p() && f("key_support_video_high_fps") && 60 == gB()) {
            i = 32801;
        }
        if (f(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS)) {
            i = this.t ? 32811 : 32808;
        }
        if (cL()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR)) {
                i |= 1024;
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                i = 32929;
            }
        }
        if (f(CameraFunction.ULTRA_NIGHT_VIDEO) && !this.t && aE()) {
            i = 32930;
        }
        if (f(CameraFunction.AI_ENHANCEMENT_VIDEO) && aF()) {
            i = 32935;
        }
        return (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT) || !em()) ? i : i | 1024;
    }

    public Size e(j jVar) {
        gn();
        String dk = dk();
        Size a2 = a(b(), "type_main_preview_frame", a.C0080a.INPUT);
        if (a2 != null) {
            return a2;
        }
        return B(dk) != null ? B(dk) : super.e(jVar);
    }

    public Size a(Size size) {
        if (eI() || fE()) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_VIDEO_EIS_SURFACE_SIZE);
        }
        return size;
    }

    public boolean r(String str) {
        if ("type_still_capture_jpeg".equals(str)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                return false;
            }
            return !AlgoSwitchConfig.getSupportApsCapture();
        } else if ("type_still_capture_yuv_main".equals(str)) {
            if ((2 == AlgoSwitchConfig.getApsVersion() || dS() || (cM() && cL())) && (this.X.j() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREAM_SUPPORT_PREVERSION))) {
                return true;
            }
            return false;
        } else if ("type_video_frame".equals(str)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS) && fE() && Util.p() && this.X.j()) {
                return true;
            }
            if (!f("pref_camera_video_slogan_key") || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_DEFAULT_VIDEO_FRAME_RECORD) || !gi()) {
                return false;
            }
            return true;
        } else if (!"type_sub_preview_frame".equals(str) && !"type_third_preview_frame".equals(str)) {
            return super.r(str);
        } else {
            if (3 != AlgoSwitchConfig.getApsVersion() || !ex() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
        String string = this.aa.getString("pref_video_size_key", CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", this.n));
        if (gF() && !"video_size_1080p".equals(string)) {
            this.X.c(true);
            this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
            this.X.c(false);
        }
        if (eB()) {
            boolean z2 = (!aF() || !gz()) && 60 == Integer.parseInt(this.aa.getString("pref_video_fps_key", "30"));
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_NONE_SAT_ULTRA_WIDE_ANGLE_RESOLUTION_LIMIT);
            boolean z3 = configIntValue > 0 && configIntValue < D(string);
            if ("video_size_4kuhd".equals(string) || z2 || z3 || ("video_size_1080p".equals(string) && gU())) {
                this.X.c(true);
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                this.X.c(false);
                this.P = false;
            }
        }
        if (f(CameraFunction.VIDEO_HDR)) {
            fU();
        }
        if (f(CameraFunction.ULTRA_NIGHT_VIDEO)) {
            gx();
        }
        if (f(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            gy();
        }
        if (this.aZ != null && aF() && (gz() || gA())) {
            this.aZ.f(true);
        }
        if (f("pref_10bits_heic_encode_key")) {
            fJ();
        }
        gQ();
    }

    public void a(String str) {
        if (!a().equals(str)) {
            if (gz()) {
                if (p("key_bubble_type_allmighty_video")) {
                    this.Y.c(13, true);
                }
            } else if (p("key_bubble_type_ai_enhancement_video")) {
                this.Y.c(7, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        if (p("key_bubble_type_ai_enhancement_video")) {
            this.Y.c(7, true);
        }
        if (p("key_bubble_type_allmighty_video")) {
            this.Y.c(13, true);
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        super.p();
        if (this.aa != null) {
            if ("off".equals(this.aa.getString("pref_video_blur_menu", "off"))) {
                this.aa.edit().putBoolean("pref_video_blur_menu_state", false).apply();
            }
            fN();
        }
        this.aX = -1;
        if (this.aZ != null && aF()) {
            if (gz() || gA()) {
                this.aZ.f(false);
            }
        }
    }

    private boolean A(String str) {
        if ("pref_video_super_eis_key".equals(str) || "pref_video_filter_menu".equals(str) || "pref_none_sat_ultra_wide_angle_key".equals(str)) {
            return f(str);
        }
        if ("key_video_hdr".equals(str)) {
            return f(CameraFunction.VIDEO_HDR);
        }
        if ("pref_video_tilt_shift_key".equals(str)) {
            return f(CameraFunction.TILT_SHIFT);
        }
        if ("key_ultra_night_video".equals(str)) {
            return f(CameraFunction.ULTRA_NIGHT_VIDEO);
        }
        if ("key_ai_enhancement_video".equals(str)) {
            return f(CameraFunction.AI_ENHANCEMENT_VIDEO);
        }
        return "pref_video_blur_menu_state".equals(str);
    }

    /* access modifiers changed from: protected */
    public boolean fD() {
        fN();
        return super.fD();
    }

    /* access modifiers changed from: private */
    public void fN() {
        if (this.X.j() && !dO() && this.aa != null && !fx()) {
            boolean fS = fS();
            boolean z = this.aa.getBoolean("pref_lasted_video_save_status", false);
            com.oppo.camera.e.a("CommonVideoMode", "restoreSpecialEffectStatus, isAnySwitchOn: " + fS + ", isSavedStatus: " + z);
            SharedPreferences.Editor edit = this.aa.edit();
            if (fS && !z) {
                edit.putBoolean("pref_lasted_video_save_status", true);
                edit.putString("pref_lasted_video_fps", String.valueOf(dj()));
                edit.putString("pref_lasted_video_size", dk());
                edit.putString("pref_lasted_video_codec", fZ());
                edit.apply();
                com.oppo.camera.e.a("CommonVideoMode", "restoreSpecialEffectStatus, save status");
            } else if (!fS && z) {
                edit.putBoolean("pref_lasted_video_save_status", false).apply();
                String string = this.aa.getString("pref_lasted_video_codec", "");
                if (!"".equals(string)) {
                    if (!TextUtils.equals(string, fZ())) {
                        edit.putString("pref_video_codec_key", string);
                    }
                    edit.putString("pref_lasted_video_codec", "");
                    edit.apply();
                }
                if (fT()) {
                    if (this.X.B()) {
                        this.X.c(true);
                    }
                    String string2 = this.aa.getString("pref_lasted_video_fps", "30");
                    String string3 = this.aa.getString("pref_lasted_video_size", fH());
                    boolean a2 = a(string2, string3, this.aa.getString("pref_video_fps_key", String.valueOf(dj())), dk());
                    com.oppo.camera.e.a("CommonVideoMode", "restoreSpecialEffectStatus, read status, videoSizeAndFpsSame: " + a2 + ", VideoFps: " + string2 + ", VideoSize: " + string3);
                    if (!a2) {
                        edit.putString("pref_video_fps_key", string2);
                        edit.putString("pref_video_size_key", string3);
                    }
                    edit.putString("pref_lasted_video_fps", "");
                    edit.putString("pref_lasted_video_size", "");
                    edit.apply();
                    if (this.X.B()) {
                        this.X.c(false);
                    }
                    gL();
                }
            }
        }
    }

    private void fR() {
        if (fE()) {
            this.X.c(true);
            SharedPreferences.Editor edit = this.aa.edit();
            if (eu()) {
                edit.putString("pref_video_blur_menu", "off");
            }
            if (dz()) {
                edit.putString("pref_video_tilt_shift_key", "off");
                this.Y.f("pref_video_tilt_shift_key");
            }
            if (cb()) {
                edit.putInt(bY(), 0);
            }
            if (ae()) {
                gM();
            }
            edit.apply();
            this.X.c(false);
        }
    }

    private boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.equals(str, str3) && TextUtils.equals(str2, str4);
    }

    private boolean fS() {
        if (cf() != bm()) {
            com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, filter is open");
            return true;
        } else if (fE() || gF()) {
            com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, super EIS is open");
            return true;
        } else {
            if (f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                if (this.y && this.aU && bX() == 0) {
                    this.aU = false;
                }
                if (this.aU || bX() != 0) {
                    com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, face beauty is open");
                    return true;
                }
            }
            if (f("pref_video_blur_menu")) {
                if ((!this.X.B() && this.Y.G()) || this.aa.getBoolean("pref_video_blur_menu_state", false)) {
                    com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, blur is open");
                    return true;
                }
            }
            if (f("pref_none_sat_ultra_wide_angle_key") && eB()) {
                com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, NoneSatUltraWideAngle is Open");
                return true;
            } else if (cL()) {
                com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, 3hdr is open");
                return true;
            } else if (aE()) {
                com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, night video is open.");
                return true;
            } else if (aF()) {
                com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, ai enhancement video is open.");
                return true;
            } else if (dz()) {
                com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, tilt shift is open.");
                return true;
            } else if (!er()) {
                return false;
            } else {
                com.oppo.camera.e.a("CommonVideoMode", "checkSpecialEffectSwitch, 10bits video is open.");
                return true;
            }
        }
    }

    private boolean fT() {
        return !"".equals(this.aa.getString("pref_lasted_video_fps", "")) && !"".equals(this.aa.getString("pref_lasted_video_size", ""));
    }

    public void j(boolean z) {
        CameraMenuOption cameraMenuOption = this.aZ;
        if (cameraMenuOption != null) {
            cameraMenuOption.f(false);
        }
        super.j(z);
        H(true);
    }

    public void am() {
        fN();
        super.am();
        CameraMenuOption cameraMenuOption = this.aZ;
        if (cameraMenuOption != null) {
            cameraMenuOption.f(false);
        }
        if (this.Y.J() && !this.aV) {
            this.Y.K();
        }
        this.Y.b((int) R.string.camera_ai_enhancement_video_on_hint);
        this.Y.b((int) R.string.camera_ai_enhancement_video_off_hint);
        fR();
        gC();
    }

    public void d(int i) {
        super.d(i);
    }

    public void cZ() {
        this.Y.f("pref_video_size_key");
    }

    public int bm() {
        return this.t ? g.k() : g.j();
    }

    public void e(int i) {
        this.k = i;
        if (3 == AlgoSwitchConfig.getApsVersion() && this.X.j() && this.W != null) {
            this.W.c(com.oppo.camera.f.a.b(this.n, this.k));
            this.W.d(95);
            this.W.a(this.X.v());
            this.W.a((f.c) null);
        }
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        super.a(dVar, builder, hashMap, i);
        e(this.k);
    }

    private void I(boolean z) {
        boolean z2;
        if (this.X.j()) {
            if (eB() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                if (z) {
                    this.X.c(false);
                }
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE)) {
                z2 = aG();
            } else {
                z2 = fE();
            }
            if (z2) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
                if (z) {
                    this.X.c(false);
                }
            }
            String str = "video_size_720p";
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO)) {
                int bX = bX();
                int i = this.aa.getInt(de()[0], k(0));
                int i2 = (i == 0 || i == -100000) ? 0 : 102;
                if (cb() || (!this.t && bX != i2)) {
                    if (z) {
                        this.X.c(true);
                    }
                    this.aa.edit().putString("pref_video_size_key", str).apply();
                    if (z) {
                        this.X.c(false);
                    }
                }
            }
            if (cL()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("key_video_hdr", "off").apply();
                this.Y.f("key_video_hdr");
                if (z) {
                    this.X.c(false);
                }
            }
            if (aE()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("key_ultra_night_video", "off").apply();
                this.Y.f("key_ultra_night_video");
                if (z) {
                    this.X.c(false);
                }
            }
            if (aF()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("key_ai_enhancement_video", "off").apply();
                this.Y.f("key_ai_enhancement_video");
                if (z) {
                    this.X.c(false);
                }
            }
            if (dz()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("pref_video_tilt_shift_key", "off").apply();
                this.Y.f("pref_video_tilt_shift_key");
                if (z) {
                    this.X.c(false);
                }
            }
            if (f(CameraFunction.FACE_BEAUTY_CUSTOM) && cb() && ae() && aG() && this.t) {
                if (z) {
                    this.X.c(true);
                }
                gM();
                this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
                if (z) {
                    this.X.c(false);
                }
            }
            String dk = dk();
            boolean z3 = 60 == gB() && !this.t;
            com.oppo.camera.e.a("CommonVideoMode", "checkVideoBlurCondition, executeBeforePreview: " + z + ", videoSizeType: " + dk + ", isHighFps: " + z3);
            if ("video_size_4kuhd".equals(dk) || ("video_size_1080p".equals(dk) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P))) {
                if (z) {
                    this.X.c(true);
                }
                SharedPreferences.Editor edit = this.aa.edit();
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P)) {
                    str = "video_size_1080p";
                }
                edit.putString("pref_video_size_key", str).apply();
                if (z) {
                    this.X.c(false);
                }
            }
            if (z3) {
                L(z);
                gL();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        super.s();
        if (this.aa instanceof k) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT) || g.m.size() != g.o.size()) {
                ((k) this.aa).c("key_video_filter_index");
            } else {
                ((k) this.aa).b("key_video_filter_index");
            }
        }
        fN();
    }

    /* access modifiers changed from: protected */
    public void t() {
        super.t();
        if (this.Y != null) {
            this.Y.y(false);
            this.Y.A();
            this.Y.b((int) R.string.camera_video_fps_60);
        }
    }

    public void j() {
        if (androidx.preference.j.a((Context) this.Z).getBoolean("video_mode_reddot_show", true)) {
            this.Y.a(R.string.camera_mode_video);
            androidx.preference.j.a((Context) this.Z).edit().putBoolean("video_mode_reddot_show", false).apply();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int r7 = r5.gB()
            r0 = 1
            r1 = 0
            r2 = 60
            if (r2 != r7) goto L_0x0010
            boolean r7 = r5.t
            if (r7 != 0) goto L_0x0010
            r7 = r0
            goto L_0x0011
        L_0x0010:
            r7 = r1
        L_0x0011:
            int r2 = r5.bX()
            java.lang.String r3 = "video_size_4kuhd"
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x008e
            java.lang.String r3 = "com.oplus.feature.custom.beauty.front.video.support"
            boolean r3 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            java.lang.String r4 = "video_size_1080p"
            if (r3 != 0) goto L_0x002d
            boolean r3 = r4.equals(r6)
            if (r3 != 0) goto L_0x008e
        L_0x002d:
            if (r7 != 0) goto L_0x008e
            boolean r7 = r5.aF()
            if (r7 != 0) goto L_0x0041
            boolean r7 = r5.eu()
            if (r7 == 0) goto L_0x0041
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x008e
        L_0x0041:
            boolean r6 = r5.fE()
            if (r6 != 0) goto L_0x008e
            boolean r6 = r5.dz()
            if (r6 == 0) goto L_0x004e
            goto L_0x008e
        L_0x004e:
            java.lang.String r6 = "func_face_beauty_common"
            boolean r6 = r5.f((java.lang.String) r6)
            if (r6 == 0) goto L_0x00b5
            boolean r6 = r5.aW
            if (r6 != 0) goto L_0x00b5
            android.content.SharedPreferences r6 = r5.aa
            java.lang.String[] r7 = r5.de()
            r7 = r7[r1]
            int r0 = r5.k((int) r1)
            int r6 = r6.getInt(r7, r0)
            if (r6 == 0) goto L_0x0074
            r7 = -100000(0xfffffffffffe7960, float:NaN)
            if (r6 == r7) goto L_0x0074
            r6 = 102(0x66, float:1.43E-43)
            goto L_0x0075
        L_0x0074:
            r6 = r1
        L_0x0075:
            if (r2 == r6) goto L_0x00b5
            android.content.SharedPreferences r7 = r5.aa
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r0 = r5.bY()
            android.content.SharedPreferences$Editor r7 = r7.putInt(r0, r6)
            r7.apply()
            com.oppo.camera.ui.e r7 = r5.Y
            r7.m((int) r6)
            goto L_0x00b6
        L_0x008e:
            com.oppo.camera.ui.e r6 = r5.Y
            boolean r6 = r6.C()
            if (r6 == 0) goto L_0x009b
            com.oppo.camera.ui.e r6 = r5.Y
            r6.b(r1, r0, r1)
        L_0x009b:
            if (r2 == 0) goto L_0x00b5
            android.content.SharedPreferences r6 = r5.aa
            android.content.SharedPreferences$Editor r6 = r6.edit()
            java.lang.String r7 = r5.bY()
            android.content.SharedPreferences$Editor r6 = r6.putInt(r7, r1)
            r6.apply()
            com.oppo.camera.ui.e r6 = r5.Y
            r6.m((int) r1)
            r6 = r1
            goto L_0x00b6
        L_0x00b5:
            r6 = r2
        L_0x00b6:
            r5.a((int) r6, (boolean) r1)
            int[] r7 = r5.dh()
            r5.a((int[]) r7)
            com.oppo.camera.ui.preview.a.n r7 = r5.ab
            if (r7 == 0) goto L_0x00d2
            com.oppo.camera.ui.preview.a.n r7 = r5.ab
            r7.h((int) r6)
            com.oppo.camera.ui.preview.a.n r6 = r5.ab
            int[] r7 = r5.dh()
            r6.a((int[]) r7)
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.f.a(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void c(String str, String str2) {
        int cf = cf();
        boolean z = 60 == gB() && !this.t;
        boolean equals = "oppo_video_filter_portrait_retention".equals(p(cf));
        if ("video_size_4kuhd".equals(str) || z || ((aE() && !equals) || gF() || ((aF() && !equals) || er() || ((cL() && cf != bm()) || (equals && !"video_size_720p".equals(str)))))) {
            gM();
            cf = bm();
            this.Y.b(bS(), bm());
            o(bm());
        }
        this.bg = cf;
        this.ab.i("oppo_video_filter_portrait_retention".equals(p(cf)));
    }

    /* access modifiers changed from: private */
    public void d(String str, String str2) {
        if ("video_size_4kuhd".equals(str) || cL() || dz() || ew() || aE() || aF() || er() || (("video_size_1080p".equals(str) && (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P) || (cb() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO)))) || 60 == Integer.parseInt(str2))) {
            this.X.c(true);
            gO();
            this.X.c(false);
            this.Y.d(true, true, true);
        }
        if (this.ab != null) {
            boolean eu = eu();
            E(eu);
            if (eu) {
                this.ab.b(et());
            }
        }
    }

    /* access modifiers changed from: private */
    public void e(String str, String str2) {
        if (dz() && ("video_size_4kuhd".equals(str) || cL() || eu() || aE() || aF() || 60 == Integer.parseInt(str2))) {
            this.X.c(true);
            gN();
            this.X.c(false);
            this.Y.d(true, true, true);
        }
        dy();
    }

    private void J(boolean z) {
        Boolean bool;
        if (this.X.j()) {
            Boolean valueOf = Boolean.valueOf(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE));
            Boolean.valueOf(false);
            if (valueOf.booleanValue()) {
                bool = Boolean.valueOf(aG());
            } else {
                bool = Boolean.valueOf(fE());
            }
            if (bool.booleanValue()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
                if (z) {
                    this.X.c(false);
                }
            }
            if (cL()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("key_video_hdr", "off").apply();
                this.Y.f("key_video_hdr");
                if (z) {
                    this.X.c(false);
                }
            }
            if (aE()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("key_ultra_night_video", "off").apply();
                this.Y.f("key_ultra_night_video");
                if (z) {
                    this.X.c(false);
                }
            }
            if (aF()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("key_ai_enhancement_video", "off").apply();
                this.Y.f("key_ai_enhancement_video");
                if (z) {
                    this.X.c(false);
                }
            }
            if (eu()) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("pref_video_blur_menu", "off").apply();
                if (z) {
                    this.X.c(false);
                }
            }
            String dk = dk();
            boolean z2 = 60 == gB() && !this.t;
            com.oppo.camera.e.a("CommonVideoMode", "checkVideoTiltShiftCondition, executeBeforePreview: " + z + ", videoSizeType: " + dk + ", isHighFps: " + z2);
            if ("video_size_4kuhd".equals(dk)) {
                if (z) {
                    this.X.c(true);
                }
                this.aa.edit().putString("pref_video_size_key", CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P) ? "video_size_1080p" : "video_size_720p").apply();
                if (z) {
                    this.X.c(false);
                }
            }
            if (z2) {
                L(z);
                gL();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean dz() {
        return f(CameraFunction.TILT_SHIFT) && "on".equals(this.aa.getString("pref_video_tilt_shift_key", "off"));
    }

    public void dC() {
        boolean dz = dz();
        com.oppo.camera.e.a("CommonVideoMode", "onTiltShiftChanged, isOpen: " + dz);
        if (dz && ew()) {
            gM();
        }
        if (cb()) {
            this.aa.edit().putInt(bY(), 0).apply();
        }
        if (!f(CameraFunction.SAT_CAMERA)) {
            if (dz) {
                this.P = false;
                J(false);
            }
            dy();
        } else if (dz) {
            this.P = false;
            J(true);
        }
        if (!dz) {
            this.Y.c(true, true, true);
            this.Y.y(true);
        }
        this.Y.f("pref_video_super_eis_key");
    }

    /* access modifiers changed from: protected */
    public boolean fE() {
        return aG() && !this.t;
    }

    /* access modifiers changed from: private */
    public void fU() {
        if (cL() && !gR()) {
            this.X.c(true);
            this.aa.edit().putString("key_video_hdr", "off").apply();
            this.X.c(false);
        }
    }

    /* access modifiers changed from: private */
    public void gx() {
        if (aE() && !gS()) {
            this.X.c(true);
            this.aa.edit().putString("key_ultra_night_video", "off").apply();
            this.X.c(false);
        }
    }

    /* access modifiers changed from: private */
    public void gy() {
        if (aF() && !gT()) {
            this.X.c(true);
            this.aa.edit().putString("key_ai_enhancement_video", "off").apply();
            CameraMenuOption cameraMenuOption = this.aZ;
            if (cameraMenuOption != null) {
                cameraMenuOption.f(false);
            }
            this.Y.f("key_ai_enhancement_video");
            this.X.c(false);
        }
        if (!aF()) {
            return;
        }
        if (gz() || gA()) {
            this.aX = -1;
        }
    }

    /* access modifiers changed from: private */
    public void f(String str, String str2) {
        if (!this.t) {
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_EIS_FPS);
            boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS);
            boolean z = this.aa.getBoolean("pref_super_eis_wide_key", false);
            boolean aG = aG();
            if (!"video_size_1080p".equals(str) || ((z && configBooleanValue && Integer.parseInt(str2) != 60) || ((z && !configBooleanValue && Integer.parseInt(str2) == 60) || (!z && aG && Integer.parseInt(str2) != configIntValue)))) {
                this.X.c(true);
                this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
                this.aa.edit().putBoolean("pref_super_eis_wide_key", false).apply();
                this.X.c(false);
                if (z) {
                    this.X.S();
                }
            }
        } else if (gF() && !"video_size_1080p".equals(str)) {
            this.X.c(true);
            this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
            this.X.c(false);
        }
    }

    /* access modifiers changed from: protected */
    public void u() {
        if (!Util.p()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT) && this.W != null) {
                boolean z = true;
                if (!K(true) || this.aa == null || !"on".equals(this.aa.getString("pref_track_focus_key", this.Z.getString(R.string.camera_face_rectify_default_value)))) {
                    z = false;
                }
                this.W.i(z);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT) && this.W != null) {
                this.W.v(ew());
            }
        }
        super.u();
        if (this.au != null) {
            this.au.post(new Runnable() {
                public void run() {
                    if (f.this.X.j()) {
                        f.this.fN();
                        String string = f.this.aa.getString("pref_video_size_key", CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", f.this.n));
                        String string2 = f.this.aa.getString("pref_video_fps_key", "30");
                        com.oppo.camera.e.a("CommonVideoMode", "onBeforePreview, videoSizeType: " + string + ", videoFps: " + string2);
                        f.this.a(string, string2);
                        f.this.c(string, string2);
                        f.this.d(string, string2);
                        f.this.e(string, string2);
                        f.this.f(string, string2);
                        if (f.this.f(CameraFunction.VIDEO_HDR)) {
                            f.this.fU();
                        }
                        if (f.this.f(CameraFunction.ULTRA_NIGHT_VIDEO)) {
                            f.this.gx();
                        }
                        if (f.this.f(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
                            f.this.gy();
                        }
                        if (f.this.f("pref_10bits_heic_encode_key")) {
                            f.this.fJ();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public int fF() {
        return gK() ? 60 : 30;
    }

    /* access modifiers changed from: protected */
    public Integer fG() {
        return Integer.valueOf(gK() ? 60 : 30);
    }

    public void f(boolean z) {
        super.f(z);
        this.aV = false;
        gQ();
        if (this.aU) {
            this.Y.s(true);
        }
        if (cF() && eu()) {
            gP();
        }
    }

    public void t(int i) {
        super.t(i);
        if (1 != i && 2 != i) {
            B();
        }
    }

    public void B() {
        super.B();
        if (this.Y != null && !this.Y.H() && !this.Y.I()) {
            if (this.aa != null && !this.aa.getBoolean("key_permission_dialog_displayed", false)) {
                com.oppo.camera.e.e("CommonVideoMode", "showNextTipWithDrawerSettingGuideAni, return");
            } else if (f(CameraFunction.ALLMIGHTY_VIDEO)) {
                if (p("key_bubble_type_allmighty_video")) {
                    this.Y.a((View) null, 13, 0, 0);
                }
            } else if (f(CameraFunction.AI_ENHANCEMENT_VIDEO) && p("key_bubble_type_ai_enhancement_video")) {
                this.Y.a((View) null, 7, 0, this.Z.getResources().getDimensionPixelOffset(R.dimen.setting_menu_tip_offset_y));
            }
        }
    }

    public void g(boolean z) {
        c.INS.setPositionRatio(this.Z, 0.87f, z);
    }

    /* access modifiers changed from: protected */
    public float fo() {
        return c.INS.getVideoBrightness();
    }

    public void F(boolean z) {
        this.aU = z;
    }

    private boolean gz() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ALLMIGHTY_VIDEO) || (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_AI_VIDEO_SCENE) && 1 == this.n)) {
            return false;
        }
        return true;
    }

    private boolean gA() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_ALLMIGHTY_VIDEO_SCENE) || (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_AI_VIDEO_SCENE) && 1 == this.n)) {
            return false;
        }
        return true;
    }

    private void b(ApsTotalResult apsTotalResult) {
        this.aY++;
        if (30 == this.aY) {
            this.aY = 0;
            if (this.be == null) {
                this.be = new BitmapDrawable(Util.f().getResources(), Util.a(Util.f(), (int) R.drawable.menu_allmighty_video_hdr));
            }
            if (this.bf == null) {
                this.bf = new BitmapDrawable(Util.f().getResources(), Util.a(Util.f(), (int) R.drawable.menu_allmighty_video_night));
            }
            Integer.valueOf(-1);
            try {
                Integer num = (Integer) apsTotalResult.getTotalResult().get(com.oppo.camera.f.c.ag);
                if (num != null) {
                    final Drawable drawable = null;
                    boolean dO = dO();
                    boolean z = !this.ba && dO;
                    this.ba = dO;
                    if (z) {
                        this.aK = 0;
                        this.aI = num.intValue();
                    }
                    if (this.ba) {
                        this.aJ = num.intValue();
                    }
                    if (num.intValue() != this.aX) {
                        if (!z) {
                            this.aK++;
                        }
                        this.aX = num.intValue();
                        int intValue = num.intValue();
                        if (intValue == 1) {
                            drawable = this.be;
                            this.Y.a((int) R.string.camera_ai_allmighty_video_hdr_hint, -1, true, false, false);
                        } else if (intValue != 2) {
                            CameraMenuOption i = this.Y.i("key_ai_enhancement_video");
                            if (i != null) {
                                drawable = i.v();
                            }
                            this.Y.a(false, false, true);
                        } else {
                            drawable = this.bf;
                            this.Y.a((int) R.string.camera_ai_allmighty_video_night_hint, -1, true, false, false);
                        }
                        if (this.aZ == null) {
                            this.aZ = this.Y.i("key_ai_enhancement_video");
                        }
                        if (drawable != null) {
                            this.Z.runOnUiThread(new Runnable() {
                                public void run() {
                                    f.this.aZ.f(true);
                                    f.this.aZ.b(drawable, true);
                                }
                            });
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(ApsTotalResult apsTotalResult) {
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            com.oppo.camera.e.e("CommonVideoMode", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
            return;
        }
        if (gz() || gA()) {
            if (aF()) {
                b(apsTotalResult);
            } else {
                c(apsTotalResult);
            }
        }
        super.a(apsTotalResult);
        if (10 < apsTotalResult.getTotalResult().getFrameNumber() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_EIS_PRO_LOW_LIGHT_HINT) && eI() && 1 == this.s) {
            this.Y.p();
        }
    }

    private void c(ApsTotalResult apsTotalResult) {
        this.aY++;
        if (30 == this.aY) {
            this.aY = 0;
            Integer.valueOf(-1);
            try {
                Integer num = (Integer) apsTotalResult.getTotalResult().get(com.oppo.camera.f.c.ag);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        this.Y.N();
                    } else if (intValue == 2) {
                        this.Y.M();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean en() {
        return this.X != null && this.X.j() && (ae() || cb() || eu() || dz() || ew() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_DEFAULT_VIDEO_FRAME_RECORD) || (eB() && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WIDE_ONLY_MEDIACODEC_SUPPORT) || (AlgoSwitchConfig.getSupportApsPreview() && AlgoSwitchConfig.getSupportPreviewAlgo(a(), this.n, AlgoSwitchConfig.APS_PIPELINE_PREVIEW, "preview_rectify")))));
    }

    /* access modifiers changed from: protected */
    public boolean ep() {
        String b2 = b();
        if (b2 == null) {
            b2 = a();
        }
        String str = b2;
        if (!f("pref_camera_video_slogan_key")) {
            AlgoSwitchConfig.PreviewConfig previewConfig = AlgoSwitchConfig.getPreviewConfig(str, this.n, (Size) null, (Size) null, eo(), ApsConstant.FEATURE_REC_SAT_HAL.equals(str) || ApsConstant.FEATURE_REC_4KUHD.equals(str) || ApsConstant.FEATURE_REC_LIVE_HDR.equals(str) || ApsConstant.FEATURE_REC_ULTRA_NIGHT.equals(str) || (ApsConstant.REC_MODE_COMMON.equals(str) && 1 == this.n) || (ApsConstant.REC_MODE_FAST_VIDEO.equals(str) && 1 == this.n), ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) && this.n == 0);
            AlgoSwitchConfig.PreviewConfig.Component component = previewConfig != null ? previewConfig.mComponentMap.get(AlgoSwitchConfig.APS_PIPELINE_VIDEO) : null;
            if (previewConfig == null || component == null || !component.mbEnable) {
                return true;
            }
            return false;
        } else if (gi()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT)) {
                return !en();
            }
            return !eo();
        } else if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS)) {
            return true;
        } else {
            if (fE() || eI()) {
                return false;
            }
            return true;
        }
    }

    public ab dl() {
        ab dl = super.dl();
        boolean z = true;
        dl.l((aE() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE)) || (aF() && gz()));
        dl.v(f("key_zoom_wide_angle_open_default"));
        boolean z2 = dl.d() && !aG();
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_ULTAR_WIDE_VIDEO_4K_OR_60FPS) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_ANGLE_SUPPORT)) {
            if (!this.X.j() || gK() || "video_size_4kuhd".equals(dk())) {
                z = false;
            }
            z2 &= z;
        }
        dl.d(z2);
        return dl;
    }

    public boolean e(String str) {
        if (!"pref_face_detection_key".equals(str) || !dO()) {
            return super.e(str);
        }
        return false;
    }

    public boolean aa() {
        return (f("pref_camera_videoflashmode_key") || f("pref_camera_torch_mode_key")) && f("pref_video_super_eis_key") && f("pref_video_filter_menu") && f("pref_video_blur_menu") && (f(CameraFunction.AI_ENHANCEMENT_VIDEO) || f(CameraFunction.ULTRA_NIGHT_VIDEO));
    }

    public boolean cT() {
        if (this.aa == null) {
            return false;
        }
        if (this.t || ("off".equals(this.aa.getString("pref_video_super_eis_key", "off")) && !dz() && "off".equals(this.aa.getString("key_ultra_night_video", "off")) && "off".equals(this.aa.getString("key_video_hdr", "off")))) {
            return true;
        }
        return false;
    }

    public boolean f(String str) {
        boolean z;
        boolean z2 = this.t;
        if ("key_dark_environment_tips".equals(str)) {
            return ew();
        }
        if (CameraFunction.ALLMIGHTY_VIDEO.equals(str)) {
            if (!gz() || this.t) {
                return false;
            }
            return true;
        } else if ("pref_video_size_key".equals(str)) {
            if (this.X == null || !this.X.j()) {
                return false;
            }
            return true;
        } else if (CameraFunction.VIDEO_RETENTION.equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT);
        } else {
            if (CameraFunction.TILT_SHIFT.equals(str)) {
                if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_TILT_SHIFT) || z2 || this.X == null || !this.X.j()) {
                    return false;
                }
                return true;
            } else if (CameraFunction.MODE_PANEL.equals(str)) {
                return true;
            } else {
                if ("pref_support_capture_preview".equals(str)) {
                    return false;
                }
                if ("pref_camera_videoflashmode_key".equals(str)) {
                    return !z2;
                }
                if ("pref_sound_types_key_rear".equals(str) || "pref_sound_types_key_front".equals(str) || "pref_video_noise_filter_key".equals(str)) {
                    return true;
                }
                if ("key_support_show_low_ambient_light_hint".equals(str)) {
                    if (!gA() || aF() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_ALLMIGHTY_VIDEO_SCENE_FUNCTION_OFF)) {
                        return false;
                    }
                    return true;
                } else if ("pref_camera_tap_shutter_key".equals(str) || "pref_time_lapse_key".equals(str) || "pref_camera_gesture_shutter_key".equals(str)) {
                    return false;
                } else {
                    if ("pref_expand_popbar_key".equals(str)) {
                        if (this.Y.s() || this.Y.C() || this.Y.G()) {
                            return true;
                        }
                        return false;
                    } else if (CameraFunction.VIDEO_HDR.equals(str)) {
                        if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) && !z2 && this.X != null && this.X.j()) {
                            return true;
                        }
                        return false;
                    } else if (CameraFunction.ULTRA_NIGHT_VIDEO.equals(str)) {
                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO) || z2 || this.X == null || !this.X.j()) {
                            return false;
                        }
                        return true;
                    } else if (CameraFunction.AI_ENHANCEMENT_VIDEO.equals(str)) {
                        if (this.X == null || !this.X.j()) {
                            return false;
                        }
                        if (z2) {
                            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_FRONT_VIDEO)) {
                                return false;
                            }
                        } else if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO)) {
                            return false;
                        }
                        return true;
                    } else if ("pref_filter_process_key".equals(str)) {
                        if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FILTER) || this.X == null || !this.X.j()) {
                            return false;
                        }
                        return true;
                    } else if (CameraFunction.FACE_BEAUTY_PROCESS.equals(str)) {
                        if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FACE_BEAUTY) || this.X == null || !this.X.j()) {
                            return false;
                        }
                        return true;
                    } else if (CameraFunction.FACE_SLENDER_PROCESS.equals(str)) {
                        return f(CameraFunction.FACE_BEAUTY_PROCESS);
                    } else {
                        if (!CameraFunction.FACE_BEAUTY_CUSTOM.equals(str) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO)) {
                            if (CameraFunction.FACE_BEAUTY_COMMON.equals(str)) {
                                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO)) {
                                    return f(CameraFunction.FACE_BEAUTY_PROCESS);
                                }
                                if (!f(CameraFunction.FACE_BEAUTY_PROCESS) || z2) {
                                    return false;
                                }
                                return true;
                            } else if ("key_support_no_face_forbid_beauty".equals(str)) {
                                return !z2;
                            } else {
                                if ("pref_video_eis".equals(str) && !z2 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS) && ("video_size_720p".equals(this.av) || "video_size_1080p".equals(this.av))) {
                                    return true;
                                }
                                if ("key_support_video_high_fps".equals(str)) {
                                    String dk = dk();
                                    if ("video_size_720p".equals(dk)) {
                                        z = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS);
                                    } else if ("video_size_1080p".equals(dk)) {
                                        z = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS);
                                    } else {
                                        z = "video_size_4kuhd".equals(dk) ? CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS) : false;
                                    }
                                    com.oppo.camera.e.a("CommonVideoMode", "getSupportFunction, sizeType: " + dk + ", isSupportHps: " + z);
                                    if (this.X == null || !this.X.j() || z2 || !z) {
                                        return false;
                                    }
                                    return true;
                                } else if ("pref_camera_torch_mode_key".equals(str)) {
                                    if (f(CameraFunction.TORCH_SOFT_LIGHT) || (z2 && c.INS.isInverseAble(this.Z) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO))) {
                                        return true;
                                    }
                                    return false;
                                } else if (CameraFunction.TORCH_SOFT_LIGHT.equals(str)) {
                                    if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT) || !z2) {
                                        return false;
                                    }
                                    return true;
                                } else if ("key_support_mode_change_vibrate".equals(str)) {
                                    return true;
                                } else {
                                    if ("key_support_video_recorder".equals(str)) {
                                        return Util.h("oplus.software.video.surround_record_support");
                                    }
                                    if (CameraFunction.VIDEO_BLUR_PROCESS.equals(str) || "pref_video_blur_menu".equals(str)) {
                                        if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_VIDEO_BLUR) || this.X == null || !this.X.j() || !this.aT) {
                                            return false;
                                        }
                                        return true;
                                    } else if (CameraFunction.SAT_CAMERA.equals(str)) {
                                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SAT) || z2 || !com.oppo.camera.f.a.f() || this.X == null) {
                                            return false;
                                        }
                                        if ((!aF() || !gz()) && this.X.j()) {
                                            return true;
                                        }
                                        return false;
                                    } else if ("pref_video_super_eis_key".equals(str)) {
                                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_PROCESS) || this.X == null || !this.X.j()) {
                                            return false;
                                        }
                                        if (!z2 || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS)) {
                                            return true;
                                        }
                                        return false;
                                    } else if (CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS.equals(str)) {
                                        if (!f("pref_video_super_eis_key") || !aG()) {
                                            return false;
                                        }
                                        return true;
                                    } else if ("key_support_super_eis_wide_menu".equals(str)) {
                                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE) || this.X == null || !this.X.j() || z2) {
                                            return false;
                                        }
                                        return true;
                                    } else if (CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE.equals(str)) {
                                        if (!f("key_support_super_eis_wide_menu") || !aG()) {
                                            return false;
                                        }
                                        return true;
                                    } else if ("pref_zoom_key".equals(str)) {
                                        if ((this.t && (!N() || (this.X != null && !this.X.j()))) || f(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS)) {
                                            return false;
                                        }
                                        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR) && cL()) {
                                            return false;
                                        }
                                        if ((aE() || aF()) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE)) {
                                            return false;
                                        }
                                        return true;
                                    } else if ("pref_none_sat_ultra_wide_angle_key".equals(str)) {
                                        boolean a2 = z2 ? Util.a(a(), true) : com.oppo.camera.f.a.g();
                                        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_NONE_SAT_ULTRA_WIDE_ANGLE_RESOLUTION_LIMIT);
                                        boolean z3 = configIntValue > 0 && this.ax != null && configIntValue < this.ax.videoFrameHeight;
                                        if (this.X == null || !this.X.j()) {
                                            return false;
                                        }
                                        if ((!N() || z3) && ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE) || (!aE() && !aF())) && !dz() && ((!eu() || !a2 || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) && (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) || 60 != gB() || "video_size_4kuhd" != dk())))) {
                                            return false;
                                        }
                                        return true;
                                    } else if ("key_support_show_dim_hint".equals(str)) {
                                        if ((!f("pref_camera_videoflashmode_key") || ew()) && !f("pref_camera_torch_mode_key")) {
                                            return false;
                                        }
                                        return true;
                                    } else if ("pref_track_focus_key".equals(str)) {
                                        return K(false);
                                    } else {
                                        if ("pref_inertial_zoom_key".equals(str)) {
                                            if (!f("pref_zoom_key") || z2 || this.X == null || !this.X.j() || aE() || eB() || aF() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_MODE_INERTIAL_ZOOM)) {
                                                return false;
                                            }
                                            return true;
                                        } else if ("key_suppport_multi_focus".equals(str)) {
                                            if (gK() || z2) {
                                                return false;
                                            }
                                            return true;
                                        } else if ("pref_10bits_heic_encode_key".equals(str)) {
                                            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT) || this.t) {
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
                                }
                            }
                        } else if (!f(CameraFunction.FACE_BEAUTY_PROCESS) || !z2) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
    }

    private boolean K(boolean z) {
        return !this.t && !eu() && !aG() && this.X != null && (z || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_ULTRA_WIDE_SUPPORT) || Float.compare(this.X.ad(), 1.0f) >= 0) && ((z || Float.compare(this.X.ad(), 1.1f) < 0) && this.X.j() && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_4K_TRACK_FOCUS_SUPPORT) || !dS()));
    }

    /* access modifiers changed from: protected */
    public void v(boolean z) {
        com.oppo.camera.e.a("CommonVideoMode", "setVideoBlurOpen, open: " + z);
        this.aT = z;
    }

    public int y(String str) {
        return ((str.equals("type_main_preview_frame") || str.equals("type_video_frame")) && cM()) ? 34 : 35;
    }

    /* access modifiers changed from: protected */
    public int B(int i) {
        if (!this.t) {
            if (i != 0) {
                if (i != 90) {
                    if (i != 180) {
                        return 0;
                    }
                }
                return 180;
            }
            return 270;
        } else if (i != 0) {
            if (i != 90) {
                if (i != 180) {
                    return 0;
                }
                return 270;
            }
            return 180;
        }
        return 90;
    }

    private int gB() {
        String str = "30";
        if (this.aa != null) {
            str = this.aa.getString("pref_video_fps_key", str);
        }
        return Integer.valueOf(str).intValue();
    }

    public int dj() {
        if (f("key_support_video_high_fps")) {
            return gB();
        }
        return Integer.valueOf("30").intValue();
    }

    private void G(int i) {
        if (this.ab != null) {
            this.ab.i("oppo_video_filter_portrait_retention".equals(p(i)));
            if ("oppo_video_filter_portrait_retention".equals(p(i)) || "oppo_video_filter_portrait_retention".equals(p(this.bg))) {
                if (this.X != null) {
                    this.X.ap();
                }
                if ("oppo_video_filter_portrait_retention".equals(p(i))) {
                    gE();
                    this.ab.i(true);
                    this.Y.a((int) R.string.camera_video_retention_open, -1, true, false, false);
                } else {
                    gD();
                    this.ab.i(false);
                    if (this.Y != null) {
                        this.Y.b((int) R.string.camera_video_retention_open);
                    }
                }
            }
            String p = p(i);
            if (!TextUtils.isEmpty(p)) {
                this.ab.i("oppo_video_filter_portrait_retention".equals(p));
                this.bg = i;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean ew() {
        return ae() && "oppo_video_filter_portrait_retention".equals(ce());
    }

    /* access modifiers changed from: protected */
    public boolean eu() {
        if (!f(CameraFunction.VIDEO_BLUR_PROCESS) || !this.aa.getBoolean("pref_video_blur_menu_state", false)) {
            return false;
        }
        return true;
    }

    public void n(int i) {
        boolean z = true;
        if (this.ab != null) {
            String p = p(i);
            this.ab.a(p);
            this.ab.c(f(CameraFunction.FILTER_VIGNETTE) && "oppo_video_filter_olympus".equals(p));
        }
        super.n(i);
        G(i);
        if (g.f4385a != cf()) {
            if (cL()) {
                this.aa.edit().putString("key_video_hdr", "off").apply();
                this.Y.f("key_video_hdr");
            }
            if (fE() || gF()) {
                this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
            }
            if (aE()) {
                this.aa.edit().putString("key_ultra_night_video", "off").apply();
                this.Y.f("key_ultra_night_video");
            }
            if (aF()) {
                this.aa.edit().putString("key_ai_enhancement_video", "off").apply();
                this.Y.f("key_ai_enhancement_video");
            }
            if (f(CameraFunction.FACE_BEAUTY_CUSTOM) && aG() && this.t && eu() && cb()) {
                gO();
                this.Y.f("pref_video_blur_menu");
                this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
            }
            String dk = dk();
            if (Integer.parseInt(this.aa.getString("pref_video_fps_key", "30")) != 60 || this.t) {
                z = false;
            }
            com.oppo.camera.e.a("CommonVideoMode", "onFilterItemChange, index: " + i + ", videoSizeType: " + dk + ", isHighFps: " + z);
            boolean equals = "video_size_4kuhd".equals(dk);
            if (z && cf() != g.f4385a) {
                L(equals);
                gL();
            }
            if (this.X.j() && equals && cf() != g.f4385a) {
                this.aa.edit().putString("pref_video_size_key", "video_size_1080p").apply();
                return;
            }
            return;
        }
        gC();
    }

    private void gC() {
        if (f("pref_10bits_heic_encode_key") && this.aW && !ae() && !eu() && !cb()) {
            if (this.X.B()) {
                this.X.c(true);
            }
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString("pref_10bits_heic_encode_key", "on");
            edit.putString("pref_photo_codec_key", "HEIF");
            edit.putString("pref_video_codec_key", "H265");
            edit.apply();
            this.Y.a(this.Z.getString(R.string.camera_10bit_hint), 0, (int) R.color.screen_hint_text_color);
            if (this.X.B()) {
                this.X.c(false);
            }
            com.oppo.camera.e.a("CommonVideoMode", "checkAndRestore10bit");
        }
    }

    private void gD() {
        if (this.aa.getBoolean("pref_old_video_status_for_retention", false)) {
            String string = this.aa.getString("pref_old_video_size", fH());
            String string2 = this.aa.getString("pref_old_video_fps", String.valueOf(dj()));
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putBoolean("pref_old_video_status_for_retention", false);
            if (!"".equals(string2)) {
                edit.putString("pref_video_fps_key", string2);
            }
            if (!"".equals(string)) {
                edit.putString("pref_video_size_key", string);
            }
            edit.putString("pref_old_video_fps", "");
            edit.putString("pref_old_video_size", "");
            edit.apply();
        }
    }

    private void gE() {
        String dk = dk();
        String string = this.aa.getString("pref_video_fps_key", "30");
        SharedPreferences.Editor edit = this.aa.edit();
        if (!"video_size_720p".equals(dk) || Integer.parseInt(string) != 30) {
            if (!gF()) {
                edit.putBoolean("pref_old_video_status_for_retention", true);
                edit.putString("pref_old_video_fps", string);
                edit.putString("pref_old_video_size", dk);
            }
            edit.putString("pref_video_size_key", "video_size_720p");
            edit.putString("pref_video_fps_key", String.valueOf(30));
            edit.apply();
        } else {
            edit.putBoolean("pref_old_video_status_for_retention", false);
            edit.putString("pref_old_video_fps", "");
            edit.putString("pref_old_video_size", "");
            edit.apply();
        }
        if (eB()) {
            this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
        }
        if (eu()) {
            this.aa.edit().putBoolean("pref_video_blur_menu_state", false).apply();
        }
        if (dz()) {
            this.aa.edit().putString("pref_video_tilt_shift_key", "off").apply();
            this.Y.f("pref_video_tilt_shift_key");
        }
        this.Y.d(true, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void eA() {
        /*
            r19 = this;
            r0 = r19
            boolean r1 = r19.aG()
            boolean r2 = r0.t
            java.lang.String r3 = "com.oplus.feature.front.eis.wide.force.support"
            boolean r3 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            java.lang.String r4 = r19.dk()
            android.content.SharedPreferences r5 = r0.aa
            java.lang.String r6 = "pref_video_fps_key"
            java.lang.String r7 = "30"
            java.lang.String r5 = r5.getString(r6, r7)
            boolean r7 = r19.gF()
            if (r7 == 0) goto L_0x0025
            r7 = 30
            goto L_0x002b
        L_0x0025:
            java.lang.String r7 = "com.oplus.feature.video.eis.fps"
            int r7 = com.oppo.camera.aps.config.CameraConfig.getConfigIntValue(r7)
        L_0x002b:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            int r8 = r8.intValue()
            r9 = 60
            r11 = 1
            if (r8 != r9) goto L_0x003e
            boolean r8 = r0.t
            if (r8 != 0) goto L_0x003e
            r8 = r11
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r12 = "onSuperEISChange, isOpen: "
            r9.append(r12)
            r9.append(r1)
            java.lang.String r12 = ", videoSizeType: "
            r9.append(r12)
            r9.append(r4)
            java.lang.String r12 = ", isHighFps: "
            r9.append(r12)
            r9.append(r8)
            java.lang.String r8 = ", videoEisFps: "
            r9.append(r8)
            r9.append(r7)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "CommonVideoMode"
            com.oppo.camera.e.a(r9, r8)
            android.content.SharedPreferences r8 = r0.aa
            android.content.SharedPreferences$Editor r8 = r8.edit()
            com.oppo.camera.e.b r9 = r0.X
            r9.c((boolean) r11)
            java.lang.String r9 = "func_video_super_eis_wide"
            java.lang.String r12 = "pref_lasted_video_size"
            java.lang.String r13 = "pref_video_size_key"
            java.lang.String r14 = "off"
            if (r1 == 0) goto L_0x01e7
            java.lang.String r15 = "func_enhancement_video"
            java.lang.String r10 = "key_ai_enhancement_video"
            if (r2 == 0) goto L_0x00aa
            java.lang.String r16 = "com.oplus.feature.front.super.eis.ai.enhance.coexist"
            boolean r16 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r16)
            if (r16 != 0) goto L_0x00aa
            boolean r16 = r0.f((java.lang.String) r15)
            if (r16 == 0) goto L_0x00aa
            boolean r16 = r19.aF()
            if (r16 == 0) goto L_0x00aa
            android.content.SharedPreferences$Editor r5 = r8.putString(r10, r14)
            r5.apply()
            com.oppo.camera.ui.e r5 = r0.Y
            r5.f((java.lang.String) r10)
            goto L_0x01e7
        L_0x00aa:
            java.lang.String r11 = "video_size_1080p"
            if (r2 != 0) goto L_0x0171
            r17 = r1
            java.lang.String r1 = "func_hdr"
            boolean r1 = r0.f((java.lang.String) r1)
            if (r1 == 0) goto L_0x00d5
            boolean r1 = r19.cL()
            if (r1 == 0) goto L_0x00d5
            android.content.SharedPreferences r1 = r0.aa
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r18 = r2
            java.lang.String r2 = "key_video_hdr"
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r14)
            r1.apply()
            com.oppo.camera.ui.e r1 = r0.Y
            r1.f((java.lang.String) r2)
            goto L_0x00d7
        L_0x00d5:
            r18 = r2
        L_0x00d7:
            boolean r1 = r19.eu()
            if (r1 == 0) goto L_0x00e6
            r19.gO()
            com.oppo.camera.ui.e r1 = r0.Y
            r2 = 1
            r1.d(r2, r2, r2)
        L_0x00e6:
            boolean r1 = r19.dz()
            if (r1 == 0) goto L_0x00f6
            java.lang.String r1 = "pref_video_tilt_shift_key"
            r8.putString(r1, r14)
            com.oppo.camera.ui.e r2 = r0.Y
            r2.f((java.lang.String) r1)
        L_0x00f6:
            java.lang.String r1 = "func_ultra_night_video"
            boolean r1 = r0.f((java.lang.String) r1)
            if (r1 == 0) goto L_0x0112
            boolean r1 = r19.aE()
            if (r1 == 0) goto L_0x0112
            java.lang.String r1 = "key_ultra_night_video"
            android.content.SharedPreferences$Editor r2 = r8.putString(r1, r14)
            r2.apply()
            com.oppo.camera.ui.e r2 = r0.Y
            r2.f((java.lang.String) r1)
        L_0x0112:
            boolean r1 = r0.f((java.lang.String) r15)
            if (r1 == 0) goto L_0x012a
            boolean r1 = r19.aF()
            if (r1 == 0) goto L_0x012a
            android.content.SharedPreferences$Editor r1 = r8.putString(r10, r14)
            r1.apply()
            com.oppo.camera.ui.e r1 = r0.Y
            r1.f((java.lang.String) r10)
        L_0x012a:
            boolean r1 = r19.cb()
            if (r1 == 0) goto L_0x0138
            java.lang.String r1 = r19.bY()
            r2 = 0
            r8.putInt(r1, r2)
        L_0x0138:
            boolean r1 = r19.ae()
            if (r1 == 0) goto L_0x0141
            r19.gM()
        L_0x0141:
            boolean r1 = r11.equals(r4)
            if (r1 != 0) goto L_0x014a
            r8.putString(r13, r11)
        L_0x014a:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            int r1 = r1.intValue()
            if (r1 == r7) goto L_0x015b
            java.lang.String r1 = java.lang.String.valueOf(r7)
            r8.putString(r6, r1)
        L_0x015b:
            boolean r1 = r0.f((java.lang.String) r9)
            if (r1 == 0) goto L_0x016c
            java.lang.String r1 = "com.oplus.feature.video.super.eis.wide.open.default"
            boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r1)
            java.lang.String r2 = "pref_super_eis_wide_key"
            r8.putBoolean(r2, r1)
        L_0x016c:
            r8.apply()
            goto L_0x01eb
        L_0x0171:
            r17 = r1
            r18 = r2
            if (r3 == 0) goto L_0x01b0
            boolean r1 = r19.eu()
            if (r1 == 0) goto L_0x0180
            r19.gO()
        L_0x0180:
            boolean r1 = r19.dz()
            if (r1 == 0) goto L_0x0189
            r19.gN()
        L_0x0189:
            boolean r1 = r19.cb()
            if (r1 == 0) goto L_0x0197
            java.lang.String r1 = r19.bY()
            r2 = 0
            r8.putInt(r1, r2)
        L_0x0197:
            boolean r1 = r19.ae()
            if (r1 == 0) goto L_0x01a0
            r19.gM()
        L_0x01a0:
            boolean r1 = r11.equals(r4)
            if (r1 != 0) goto L_0x01ac
            r8.putString(r12, r4)
            r8.putString(r13, r11)
        L_0x01ac:
            r8.apply()
            goto L_0x01eb
        L_0x01b0:
            java.lang.String r1 = "func_face_beauty_custom"
            boolean r1 = r0.f((java.lang.String) r1)
            if (r1 == 0) goto L_0x01eb
            boolean r1 = r19.eu()
            if (r1 == 0) goto L_0x01eb
            boolean r1 = r19.ae()
            if (r1 == 0) goto L_0x01eb
            boolean r1 = r19.cb()
            if (r1 == 0) goto L_0x01eb
            r19.gO()
            com.oppo.camera.ui.e r1 = r0.Y
            r2 = 2131755756(0x7f1002ec, float:1.91424E38)
            r1.b((int) r2)
            com.oppo.camera.ui.e r1 = r0.Y
            java.lang.String r2 = "pref_video_blur_menu"
            r1.f((java.lang.String) r2)
            com.oppo.camera.ui.e r1 = r0.Y
            r2 = 0
            r5 = 1
            r1.d(r5, r2, r5)
            r19.gM()
            goto L_0x01eb
        L_0x01e7:
            r17 = r1
            r18 = r2
        L_0x01eb:
            if (r3 == 0) goto L_0x020d
            if (r18 == 0) goto L_0x020d
            if (r17 != 0) goto L_0x020d
            android.content.SharedPreferences r1 = r0.aa
            r2 = 0
            java.lang.String r1 = r1.getString(r12, r2)
            if (r1 == 0) goto L_0x020d
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x020d
            boolean r2 = r1.equals(r4)
            if (r2 != 0) goto L_0x020d
            android.content.SharedPreferences$Editor r1 = r8.putString(r13, r1)
            r1.apply()
        L_0x020d:
            com.oppo.camera.e.b r1 = r0.X
            r2 = 0
            r1.c((boolean) r2)
            if (r17 == 0) goto L_0x02fc
            java.lang.String r1 = "filter"
            if (r18 != 0) goto L_0x02ba
            android.content.SharedPreferences r2 = r0.aa
            android.content.SharedPreferences$Editor r2 = r2.edit()
            java.lang.String r3 = "pref_none_sat_ultra_wide_angle_key"
            android.content.SharedPreferences$Editor r2 = r2.putString(r3, r14)
            r2.apply()
            android.content.SharedPreferences r2 = r0.aa
            android.content.SharedPreferences$Editor r2 = r2.edit()
            java.lang.String r3 = "pref_none_sat_tele_angle_key"
            android.content.SharedPreferences$Editor r2 = r2.putString(r3, r14)
            r2.apply()
            com.oppo.camera.ui.e r2 = r0.Y
            boolean r2 = r2.s()
            if (r2 == 0) goto L_0x025a
            java.lang.String r2 = r19.bP()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x025a
            com.oppo.camera.ui.e r1 = r0.Y
            r2 = 1
            r1.q((boolean) r2)
            com.oppo.camera.e.b r1 = r0.X
            r1.D()
            com.oppo.camera.e.b r1 = r0.X
            r1.d((boolean) r2)
            goto L_0x0261
        L_0x025a:
            com.oppo.camera.ui.e r1 = r0.Y
            java.lang.String r2 = "pref_video_filter_menu"
            r1.h((java.lang.String) r2)
        L_0x0261:
            com.oppo.camera.ui.e r1 = r0.Y
            boolean r1 = r1.C()
            if (r1 == 0) goto L_0x0271
            com.oppo.camera.ui.e r1 = r0.Y
            r2 = 0
            r3 = 1
            r1.a((boolean) r3, (boolean) r3, (boolean) r3, (boolean) r2)
            goto L_0x0272
        L_0x0271:
            r3 = 1
        L_0x0272:
            boolean r1 = r0.f((java.lang.String) r9)
            if (r1 == 0) goto L_0x027d
            com.oppo.camera.ui.e r1 = r0.Y
            r1.v(r3)
        L_0x027d:
            java.lang.String r1 = "pref_video_super_eis_key"
            boolean r1 = r0.f((java.lang.String) r1)
            if (r1 == 0) goto L_0x028a
            com.oppo.camera.ui.e r1 = r0.Y
            r1.E()
        L_0x028a:
            com.oppo.camera.ui.e r1 = r0.Y
            r2 = 0
            r1.m((int) r2)
            android.content.SharedPreferences r1 = r0.aa
            java.lang.String r2 = "pref_camera_videoflashmode_key"
            java.lang.String r1 = r1.getString(r2, r14)
            boolean r3 = r19.eI()
            if (r3 == 0) goto L_0x0314
            boolean r1 = r14.equals(r1)
            if (r1 != 0) goto L_0x0314
            java.lang.String r1 = "com.oplus.feature.flash.full.zoom.support"
            boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r1)
            if (r1 != 0) goto L_0x0314
            android.content.SharedPreferences r1 = r0.aa
            android.content.SharedPreferences$Editor r1 = r1.edit()
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r14)
            r1.apply()
            goto L_0x0314
        L_0x02ba:
            if (r3 == 0) goto L_0x0314
            com.oppo.camera.ui.e r2 = r0.Y
            r2.E()
            com.oppo.camera.ui.e r2 = r0.Y
            r3 = 0
            r2.m((int) r3)
            com.oppo.camera.ui.e r2 = r0.Y
            boolean r2 = r2.G()
            if (r2 == 0) goto L_0x02d6
            com.oppo.camera.ui.e r2 = r0.Y
            r4 = 1
            r2.d(r4, r3, r4)
            goto L_0x02d7
        L_0x02d6:
            r4 = 1
        L_0x02d7:
            com.oppo.camera.ui.e r2 = r0.Y
            boolean r2 = r2.C()
            if (r2 == 0) goto L_0x02e4
            com.oppo.camera.ui.e r2 = r0.Y
            r2.a((boolean) r4, (boolean) r4, (boolean) r4, (boolean) r3)
        L_0x02e4:
            com.oppo.camera.ui.e r2 = r0.Y
            boolean r2 = r2.s()
            if (r2 == 0) goto L_0x0314
            java.lang.String r2 = r19.bP()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0314
            com.oppo.camera.ui.e r1 = r0.Y
            r1.q((boolean) r4)
            goto L_0x0314
        L_0x02fc:
            r4 = 1
            com.oppo.camera.ui.e r1 = r0.Y
            r1.w(r4)
            com.oppo.camera.ui.e r1 = r0.Y
            r1.F()
            java.lang.String r1 = "com.oplus.feature.wide.angle.open.default"
            boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r1)
            if (r1 == 0) goto L_0x0314
            com.oppo.camera.e.b r1 = r0.X
            r1.af()
        L_0x0314:
            java.lang.String r1 = "func_sat_camera"
            boolean r1 = r0.f((java.lang.String) r1)
            if (r1 != 0) goto L_0x0321
            com.oppo.camera.ui.e r1 = r0.Y
            r1.j()
        L_0x0321:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.f.eA():void");
    }

    public boolean eI() {
        if (!f(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE) || this.aa == null || !this.aa.getBoolean("pref_super_eis_wide_key", false)) {
            return false;
        }
        return true;
    }

    private boolean gF() {
        return Boolean.valueOf(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE)).booleanValue() && this.t && aG();
    }

    public Range<Integer> e() {
        int[] b2;
        if (!f("key_support_video_high_fps") && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_DYNAMIC_FPS_RANGE)) {
            return null;
        }
        if (gK()) {
            if (!fE() || (b2 = this.W.e().b((CameraCharacteristics.Key<?>) com.oppo.camera.f.c.u)) == null || b2.length < 2) {
                return this.bb;
            }
            return Range.create(Integer.valueOf(b2[0]), Integer.valueOf(b2[1]));
        } else if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_DYNAMIC_FPS_RANGE) || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FIXED_FPS_IN_4K) && dS())) {
            return this.bc;
        } else {
            return this.bd;
        }
    }

    /* access modifiers changed from: protected */
    public int di() {
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_FRONT_FACE_BEAUTY_LEVEL);
        return configIntValue >= 0 ? configIntValue : super.di();
    }

    public void l(int i) {
        if (!this.y && bX() != i && this.X.h() == 1 && !dO()) {
            super.l(i);
        }
    }

    private boolean gG() {
        if (this.X.P()) {
            return true;
        }
        String dk = dk();
        boolean z = 60 == gB() && !this.t;
        if (gF()) {
            this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
        }
        com.oppo.camera.e.a("CommonVideoMode", "onFaceBeautyMenuClick, videoSizeType: " + dk + ", isHighFps: " + z);
        if (er() && !ae() && !eu()) {
            this.aa.edit().putString("pref_10bits_heic_encode_key", "off").apply();
            gW();
            if (this.Y != null) {
                this.Y.c((int) R.string.camera_10bit_hint);
            }
            this.aW = true;
        }
        if (!"video_size_4kuhd".equals(dk) && !"video_size_1080p".equals(dk) && !z) {
            return true;
        }
        this.aU = true;
        if (cL()) {
            this.aa.edit().putString("key_video_hdr", "off").apply();
            this.Y.f("key_video_hdr");
        }
        if (fE()) {
            this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
        }
        if (f(CameraFunction.ULTRA_NIGHT_VIDEO) && aE()) {
            this.aa.edit().putString("key_ultra_night_video", "off").apply();
            this.Y.f("key_ultra_night_video");
        }
        boolean equals = "video_size_720p".equals(dk);
        fN();
        if (z) {
            L(!equals);
            gL();
        }
        if (!equals) {
            this.aa.edit().putString("pref_video_size_key", "video_size_720p").apply();
        }
        if (f(CameraFunction.FACE_BEAUTY_COMMON)) {
            int bX = bX();
            int i = this.aa.getInt(de()[0], k(0));
            int i2 = (i == 0 || i == -100000) ? 0 : 102;
            if (bX != i2) {
                this.aa.edit().putInt(bY(), i2).apply();
                this.Y.m(i2);
            }
        }
        this.Y.a(false, false);
        this.Y.b(false);
        this.Y.t(false);
        return false;
    }

    private boolean gH() {
        if (this.X.P()) {
            return true;
        }
        if (cL()) {
            this.aa.edit().putString("key_video_hdr", "off").apply();
            this.Y.f("key_video_hdr");
        }
        if (fE()) {
            this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
        }
        if (f(CameraFunction.ULTRA_NIGHT_VIDEO) && aE()) {
            this.aa.edit().putString("key_ultra_night_video", "off").apply();
            this.Y.f("key_ultra_night_video");
        }
        if (gF()) {
            this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
        }
        if (ae() && aG() && eu() && this.t) {
            this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
            gO();
            gM();
            this.Y.f("pref_video_blur_menu");
        }
        String dk = dk();
        boolean z = 60 == gB() && !this.t;
        com.oppo.camera.e.a("CommonVideoMode", "onFaceBeautyMenuClick, videoSizeType: " + dk + ", isHighFps: " + z);
        if ("video_size_4kuhd".equals(dk) || z) {
            this.aU = true;
            boolean equals = "video_size_1080p".equals(dk);
            fN();
            if (z) {
                L(!equals);
                gL();
            }
            if (!equals) {
                this.aa.edit().putString("pref_video_size_key", "video_size_1080p").apply();
            }
            if (f(CameraFunction.FACE_BEAUTY_COMMON)) {
                int bX = bX();
                int i = this.aa.getInt(de()[0], k(0));
                int i2 = (i == 0 || i == -100000) ? 0 : 102;
                if (bX != i2) {
                    this.aa.edit().putInt(bY(), i2).apply();
                    this.Y.m(i2);
                }
            }
            this.Y.a(false, false);
            this.Y.b(false);
            this.Y.t(false);
            return false;
        } else if (!"video_size_1080p".equals(dk) || !eu()) {
            return true;
        } else {
            this.aU = true;
            fN();
            this.aa.edit().putString("pref_video_size_key", "video_size_720p").apply();
            this.Y.a(false, false);
            this.Y.b(false);
            this.Y.t(false);
            return false;
        }
    }

    public boolean bV() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO)) {
            return gH();
        }
        return gG();
    }

    public void dv() {
        gC();
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        return dO();
    }

    public Size cp() {
        return a("type_video_frame", this.W.e());
    }

    /* access modifiers changed from: protected */
    public void o(int i) {
        com.oppo.camera.e.a("CommonVideoMode", "updateFilterParam, index: " + i);
        super.o(i);
        if (this.ab != null) {
            String p = p(i);
            this.ab.a(p);
            this.ab.c(f(CameraFunction.FILTER_VIGNETTE) && "oppo_video_filter_olympus".equals(p));
        }
    }

    public boolean aM() {
        return dO();
    }

    /* access modifiers changed from: protected */
    public boolean fn() {
        return eu();
    }

    public void bh() {
        h(false);
    }

    public void h(boolean z) {
        com.oppo.camera.ui.control.c cVar = new com.oppo.camera.ui.control.c(5, "button_color_inside_red", "button_shape_ring_none", 1);
        cVar.b(z);
        this.Y.a(cVar);
        super.bh();
        if (this.W != null) {
            if (!Util.p() && this.X != null) {
                this.W.c(com.oppo.camera.f.a.b(this.n, this.X.s()));
            }
            this.W.a((f.c) null);
        }
        super.h(z);
    }

    public void bi() {
        super.bi();
        if (gI()) {
            this.au.removeMessages(11);
            this.au.sendEmptyMessageDelayed(11, 300000);
        }
        if (Util.p() && eI() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS_AF_AUTO_LOCK)) {
            this.W.a(1, com.oppo.camera.a.a(), com.oppo.camera.a.a(), false);
            this.W.a((f.c) null);
        }
    }

    private boolean gI() {
        return aG() || eu() || ew() || dz();
    }

    /* access modifiers changed from: protected */
    public void G(boolean z) {
        if (!fx()) {
            this.Y.a(new com.oppo.camera.ui.control.c(6, "button_color_inside_red", "button_shape_ring_none", 1));
        }
        if (gI()) {
            this.au.removeMessages(11);
        }
        super.G(z);
    }

    public String eq() {
        if (this.aa != null && this.X.j() && !aE() && !this.t) {
            if (er()) {
                return "heic_10bits";
            }
            com.oppo.camera.e.a("CommonVideoMode", "getHeicCodecFormat return null");
        }
        return null;
    }

    public void bj() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS_AF_AUTO_LOCK)) {
            this.W.a(3, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
            this.W.a((f.c) null);
        }
        if (er()) {
            this.Y.a((int) R.string.camera_10bit_video_saved, -1, true, false, false);
        }
        super.bj();
    }

    private boolean gJ() {
        return "video_size_1080p".equals(dk()) && 30 == gB();
    }

    public void cP() {
        if (fW() || (cF() && "torch".equals(bu()))) {
            this.Y.a(-1, (int) R.drawable.torch_hint_icon, false, true, false);
        } else if (cL() && gR() && dP()) {
            this.Y.a(false, true, true);
            this.Y.a(this.Z.getString(R.string.camera_video_hdr), 0, (int) R.color.screen_hint_text_color);
        } else if (aE() && dP() && gJ()) {
            this.Y.a(false, true, true);
            this.Y.a(this.Z.getString(R.string.camera_ultra_night_video), 0, (int) R.color.screen_hint_text_color);
        } else if (er() || er()) {
            this.Y.a(false, true, true);
            this.Y.c((int) R.string.camera_video_hdr);
            this.Y.c((int) R.string.camera_ultra_night_video);
            if (!dN()) {
                this.Y.a(this.Z.getString(R.string.camera_10bit_hint), 0, (int) R.color.screen_hint_text_color);
            }
        } else {
            this.Y.a(false, true, true);
            this.Y.c((int) R.string.camera_video_hdr);
            this.Y.c((int) R.string.camera_ultra_night_video);
            this.Y.c((int) R.string.camera_10bit_hint);
        }
    }

    public void d(boolean z, boolean z2) {
        if (!fW() && !cL() && !c.INS.isInverseColor(this.Z.hashCode())) {
            this.Y.a(false, true, true);
        }
    }

    public boolean cz() {
        return fW();
    }

    public String fH() {
        return CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", this.n);
    }

    public boolean dR() {
        return gK();
    }

    public void s(boolean z) {
        com.oppo.camera.e.a("CommonVideoMode", "onEffectMenuPopDown");
        if (!z) {
            gL();
        }
        fN();
    }

    public void a(int i, int i2, boolean z) {
        super.a(i, i2, z);
        com.oppo.camera.e.a("CommonVideoMode", "onFaceBeautyItemValueChange");
        gL();
    }

    private boolean gK() {
        boolean z = false;
        if (this.t) {
            return false;
        }
        if (30 == gB()) {
            com.oppo.camera.e.a("CommonVideoMode", "isHighFps false, videoFps: 30");
            return false;
        }
        String dk = dk();
        if (("video_size_720p".equals(dk) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS)) || (("video_size_1080p".equals(dk) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS)) || ("video_size_4kuhd".equals(dk) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS)))) {
            if (60 == gB()) {
                z = true;
            }
            com.oppo.camera.e.a("CommonVideoMode", "isHighFps, isHighFps: " + z);
        }
        return z;
    }

    private void gL() {
        com.oppo.camera.e.a("CommonVideoMode", "onHighFpsStateChange");
        if (this.Y != null && gK() && !aG() && !this.Y.H() && this.Y.L()) {
            this.Y.a((int) R.string.camera_video_fps_60, -1, true, false, false);
        }
    }

    /* access modifiers changed from: protected */
    public void u(boolean z) {
        com.oppo.camera.e.a("CommonVideoMode", "switchVideoBlur, isOpen: " + z);
        if (f(CameraFunction.SAT_CAMERA) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
            if (z && this.X.a(bd())) {
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "on").apply();
            } else if (!z) {
                if (eB()) {
                    this.X.af();
                }
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
            }
        }
        this.aa.edit().putBoolean("pref_video_blur_menu_state", z).apply();
        if (z && ew()) {
            gM();
        }
        if (!f(CameraFunction.SAT_CAMERA)) {
            if (z) {
                this.P = false;
                I(false);
            }
            if (this.ab != null) {
                E(z);
                if (z) {
                    this.ab.b(et());
                }
            }
        } else if (z) {
            this.P = false;
            I(true);
        }
    }

    private void L(boolean z) {
        String string = this.aa.getString("pref_video_fps_key", "30");
        com.oppo.camera.e.b("CommonVideoMode", "setFpsToDefault, nowVideoFPS: " + string + ", executeBeforePreview: " + z);
        if (!TextUtils.equals(string, "30")) {
            if (z) {
                this.X.c(true);
            }
            this.aa.edit().putString("pref_video_fps_key", "30").apply();
            if (z) {
                this.X.c(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean aG() {
        if (!f("pref_video_super_eis_key") || this.aa == null) {
            return false;
        }
        return "on".equals(this.aa.getString("pref_video_super_eis_key", "off"));
    }

    public boolean ex() {
        if (!f(CameraFunction.SAT_CAMERA) || eu() || ew() || dz() || aG()) {
            return false;
        }
        if (cL() && gR()) {
            return false;
        }
        if (aE() && gS()) {
            return false;
        }
        if (aF() && gS()) {
            return false;
        }
        String dk = dk();
        boolean z = Integer.parseInt(this.aa.getString("pref_video_fps_key", "30")) == 60 && !this.t;
        if ((CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK) & 1) == 0 && z) {
            return false;
        }
        if ((CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK) & 2) == 0 && "video_size_4kuhd".equals(dk)) {
            return false;
        }
        if ((CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK) & 4) != 0 || !z || !"video_size_4kuhd".equals(dk)) {
            return true;
        }
        return false;
    }

    public boolean cq() {
        String str;
        if (!f("pref_inertial_zoom_key")) {
            return super.cq();
        }
        if (this.aa != null) {
            str = this.aa.getString("pref_inertial_zoom_key", this.Z.getString(R.string.camera_face_rectify_default_value));
        } else {
            str = "on";
        }
        return "on".equals(str);
    }

    public void ey() {
        if (aG()) {
            this.X.c(true);
            this.aa.edit().putString("pref_video_super_eis_key", "off").apply();
            this.X.c(false);
        }
        if (cL()) {
            this.X.c(true);
            this.aa.edit().putString("key_video_hdr", "off").apply();
            this.X.c(false);
        }
        if (eu() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
            this.X.c(true);
            gO();
            this.X.c(false);
        }
        if (ew()) {
            this.X.c(true);
            gM();
            this.X.c(false);
        }
        String dk = dk();
        boolean z = Integer.parseInt(this.aa.getString("pref_video_fps_key", "30")) == 60 && !this.t;
        boolean gU = gU();
        com.oppo.camera.e.a("CommonVideoMode", "onUltraWideAngleOpened, videoSizeType: " + dk + ", isHighFps: " + z + ", isWideVideoOnly720P: " + gU);
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) || !"video_size_4kuhd".equals(dk) || !z) {
            if ("video_size_4kuhd".equals(dk) || ("video_size_1080p".equals(dk) && gU)) {
                this.X.c(true);
                if (gU) {
                    this.aa.edit().putString("pref_video_size_key", "video_size_720p").apply();
                } else {
                    this.aa.edit().putString("pref_video_size_key", "video_size_1080p").apply();
                }
                this.X.c(false);
            }
            if (!z) {
                return;
            }
            if (!aF() || !gz()) {
                L(true);
                gL();
            }
        }
    }

    public void s(String str) {
        if (this.Y.S() && f(CameraFunction.VIDEO_RETENTION)) {
            this.Y.a("pref_video_filter_menu", true, (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    public String bS() {
        if (!this.Y.S() || !f(CameraFunction.VIDEO_RETENTION)) {
            return super.bS();
        }
        return this.Z.getString(f(this.n).get(g.a(this.t)).intValue());
    }

    /* access modifiers changed from: protected */
    public void ev() {
        if (this.Y.S() && f(CameraFunction.VIDEO_RETENTION)) {
            this.Y.d(false, false);
            int a2 = g.a(this.t);
            this.aa.edit().putInt(cg(), a2).apply();
            this.Y.a(true, ch());
            n(a2);
            this.Y.a(R.string.camera_mode_video);
            this.Y.a("pref_video_filter_menu", false, (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
            androidx.preference.j.a((Context) this.Z).edit().putBoolean("video_retention_filter_reddot_show", false).apply();
        }
    }

    public boolean g(String str) {
        return !"oppo_video_filter_portrait_retention".equals(str) && super.g(str);
    }

    /* access modifiers changed from: protected */
    public int eD() {
        if (eB()) {
            return (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || Float.compare(this.W.e().n(), 0.0f) == 0) ? R.string.ultra_wide_angel_toast : Util.d((int) R.string.ultra_wide_micro_lens_toast);
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void eE() {
        super.eE();
        if (this.X.j()) {
            gL();
        }
    }

    private void gM() {
        SharedPreferences.Editor edit = this.aa.edit();
        edit.putInt(cg(), bm());
        edit.apply();
        this.bg = bm();
        this.ab.i(false);
        this.Y.b(bS(), bm());
        this.Y.a(this.Y.s(), ch());
    }

    private void gN() {
        com.oppo.camera.e.c("CommonVideoMode", "resetCurrentVideoTiltShiftPreference");
        SharedPreferences.Editor edit = this.aa.edit();
        edit.remove("pref_video_tilt_shift_key");
        edit.remove("pref_tilt_shift_blur_menu_index");
        edit.apply();
    }

    private void gO() {
        com.oppo.camera.e.c("CommonVideoMode", "resetCurrentVideoBlurPreference");
        SharedPreferences.Editor edit = this.aa.edit();
        edit.remove("pref_video_blur_menu_state");
        edit.remove("pref_video_blur_menu_index");
        edit.remove("pref_video_blur_menu");
        edit.apply();
    }

    public void w(boolean z) {
        this.aa.edit().putBoolean("pref_super_eis_wide_key", z).apply();
        String string = this.aa.getString("pref_camera_videoflashmode_key", "off");
        boolean z2 = false;
        if (z && !"off".equals(string) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            this.Y.a(false, true, true);
            this.aa.edit().putString("pref_camera_videoflashmode_key", "off").apply();
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS) && 60 == CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_EIS_FPS)) {
            if (Integer.parseInt(this.aa.getString("pref_video_fps_key", "30")) == 60) {
                z2 = true;
            }
            if (z && z2) {
                this.aa.edit().putString("pref_video_fps_key", String.valueOf(30)).apply();
            } else if (!z && !z2) {
                this.aa.edit().putString("pref_video_fps_key", String.valueOf(60)).apply();
            }
        }
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        super.a(sharedPreferences, str);
        if ("pref_video_super_eis_key".equals(str) && f(str) && sharedPreferences != null && "off".equals(sharedPreferences.getString("pref_video_super_eis_key", "off")) && sharedPreferences.getBoolean("pref_super_eis_wide_key", false)) {
            sharedPreferences.edit().putBoolean("pref_super_eis_wide_key", false).apply();
        }
        if ("pref_video_tilt_shift_key".equals(str) && f(str)) {
            if (dz()) {
                this.Y.x(false);
            } else {
                this.Y.c(true, false, true);
                this.Y.y(false);
            }
        }
        if (A(str)) {
            fN();
        }
        if ("pref_none_sat_ultra_wide_angle_key".equals(str) && !this.X.at()) {
            this.aV = true;
        }
        if ("key_ultra_night_video".equals(str)) {
            d_();
        }
        if ("key_ai_enhancement_video".equals(str)) {
            fK();
        }
        if ("pref_camera_torch_mode_key".equals(str) && cF() && eu()) {
            gP();
        }
        if ("pref_video_blur_menu".equals(str) && cF() && eu()) {
            this.aa.edit().putString("pref_camera_torch_mode_key", "off").apply();
            this.Y.f("pref_camera_torch_mode_key");
        }
        if ("pref_10bits_heic_encode_key".equals(str)) {
            fJ();
        }
        if ("pref_video_blur_menu".equals(str)) {
            if (er() && !cc() && !ae() && eu()) {
                this.aa.edit().putString("pref_10bits_heic_encode_key", "off").apply();
                gW();
                if (this.Y != null) {
                    this.Y.c((int) R.string.camera_10bit_hint);
                }
                this.aW = true;
            }
            if (!eu()) {
                gC();
            }
        }
        if ("pref_video_filter_menu".equals(str)) {
            if (er() && !cc() && ae() && !eu()) {
                this.aa.edit().putString("pref_10bits_heic_encode_key", "off").apply();
                gW();
                if (this.Y != null) {
                    this.Y.c((int) R.string.camera_10bit_hint);
                }
                this.aW = true;
            }
            if (!ae()) {
                gC();
            }
        }
        if ("pref_video_size_key".equals(str) && this.aa.contains("pref_none_sat_ultra_wide_angle_key")) {
            String string = this.aa.getString("pref_none_sat_ultra_wide_angle_key", "off");
            if (!f("pref_none_sat_ultra_wide_angle_key") && "on".equals(string) && !fE()) {
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
            }
        }
        if ("pref_video_blur_menu_state".equals(str) && !f(CameraFunction.SAT_CAMERA)) {
            aC();
        }
        gQ();
    }

    private void gP() {
        SharedPreferences.Editor edit = this.aa.edit();
        edit.remove("pref_video_blur_menu_state");
        edit.remove("pref_video_blur_menu_index");
        edit.remove("pref_video_blur_menu");
        edit.apply();
        A(0);
        E(false);
        this.Y.b((int) R.string.camera_video_blur_open);
        this.Y.f("pref_video_blur_menu");
        this.Y.d(true, false, true);
    }

    private void gQ() {
        if (this.Y != null && this.aa != null) {
            if ((this.t || (!"on".equals(this.aa.getString("pref_video_super_eis_key", "off")) && !"on".equals(this.aa.getString("key_ultra_night_video", "off")) && !"on".equals(this.aa.getString("key_video_hdr", "off")))) && !dz()) {
                this.Y.r(true);
            } else {
                this.Y.a(true, true, false, false);
            }
        }
    }

    public String cK() {
        return this.Z.getResources().getString(R.string.camera_video_hdr_default_value);
    }

    public void o(String str) {
        if ("key_video_hdr".equals(str)) {
            fL();
        }
    }

    public void d_() {
        boolean aE = aE();
        String dk = dk();
        String string = this.aa.getString("pref_video_fps_key", "30");
        com.oppo.camera.e.a("CommonVideoMode", "onUltraNightVideoChanged, isUltraNightVideoOpen: " + aE + ", videoSizeType: " + dk + ", videoFps: " + string);
        SharedPreferences.Editor edit = this.aa.edit();
        this.X.c(true);
        if (aE) {
            if (eu()) {
                edit.putString("pref_video_blur_menu", "off");
                this.Y.b((int) R.string.camera_video_blur_open);
            }
            if (dz()) {
                edit.putString("pref_video_tilt_shift_key", "off");
            }
            if (cb()) {
                edit.putInt(bY(), 0);
            }
            if (ae()) {
                gM();
            }
            if (aG()) {
                edit.putString("pref_video_super_eis_key", "off");
            }
            if (f(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                edit.putBoolean("pref_super_eis_wide_key", false);
            }
            if (f(CameraFunction.VIDEO_HDR) && cL()) {
                edit.putString("key_video_hdr", "off").apply();
            }
            if (!"video_size_1080p".equals(dk)) {
                edit.putString("pref_video_size_key", "video_size_1080p");
            }
            if (30 != Integer.parseInt(string)) {
                edit.putString("pref_video_fps_key", String.valueOf(30));
            }
            edit.apply();
            this.Y.f("pref_video_super_eis_key");
            this.Y.f("key_video_hdr");
            this.Y.f("pref_video_blur_menu");
            this.Y.f("pref_video_tilt_shift_key");
        }
        this.X.c(false);
        if (aE) {
            if (eB()) {
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && !eB() && this.X.a(bd())) {
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "on").apply();
            }
            if (!this.Y.s() || !"filter".equals(bP())) {
                this.Y.h("pref_video_filter_menu");
            } else {
                this.Y.q(true);
            }
            if (this.Y.C()) {
                this.Y.a(true, true, true, false);
            }
            this.Y.m(0);
        } else if ("on".equals(this.aa.getString("pref_none_sat_ultra_wide_angle_key", "off"))) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                this.X.af();
            }
            this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
        }
    }

    public void fJ() {
        boolean er = er();
        String dk = dk();
        String string = this.aa.getString("pref_video_fps_key", "30");
        com.oppo.camera.e.a("CommonVideoMode", "on10bitChanged, is10bitOpen: " + er + ", videoSizeType: " + dk + ", videoFps: " + string);
        SharedPreferences.Editor edit = this.aa.edit();
        if (er) {
            if (eu()) {
                edit.putString("pref_video_blur_menu", "off");
                this.Y.b((int) R.string.camera_video_blur_open);
            }
            if (ae()) {
                gM();
            }
            if (cb()) {
                edit.putInt(bY(), 0);
            }
            edit.apply();
            this.Y.f("pref_video_blur_menu");
        }
        if (er) {
            if (!this.Y.s() || !"filter".equals(bP())) {
                this.Y.h("pref_video_filter_menu");
            }
            this.Y.C();
            if (this.aa.getInt(bY(), 0) == 0) {
                l(0);
                this.Y.m(0);
            }
        }
    }

    public void fK() {
        boolean aF = aF();
        String dk = dk();
        int gB = gB();
        com.oppo.camera.e.a("CommonVideoMode", "onAiEnhancementVideoChanged, isAiEnhancementVideoOpen: " + aF + ", videoSizeType: " + dk + ", videoFps: " + gB);
        SharedPreferences.Editor edit = this.aa.edit();
        this.X.c(true);
        boolean z = this.t;
        if (aF) {
            this.aX = -1;
            if (eu()) {
                edit.putString("pref_video_blur_menu", "off");
                this.Y.b((int) R.string.camera_video_blur_open);
            }
            if (dz()) {
                edit.putString("pref_video_tilt_shift_key", "off");
            }
            if (ae()) {
                gM();
            }
            if (aG() && (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_SUPER_EIS_AND_AI_VIDEO_ENHANCE_COEXIST) || !z)) {
                edit.putString("pref_video_super_eis_key", "off");
            }
            if (f(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                edit.putBoolean("pref_super_eis_wide_key", false);
            }
            String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_FRONT_RESOLUTION);
            String[] configStringArrayValue2 = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_REAR_RESOLUTION);
            String str = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_REAR_VIDEO_1080P_SIZE) ? "video_size_1080p" : "video_size_720p";
            if (this.t && configStringArrayValue != null && !Util.b(configStringArrayValue, dk)) {
                edit.putString("pref_video_size_key", configStringArrayValue[0]);
            } else if (!this.t && configStringArrayValue2 != null && !Util.b(configStringArrayValue2, dk)) {
                edit.putString("pref_video_size_key", configStringArrayValue2[0]);
            } else if (!z && !str.equals(dk)) {
                edit.putString("pref_video_size_key", str);
            }
            if (30 != gB) {
                edit.putString("pref_video_fps_key", String.valueOf(30));
            }
            if (gz() && !"video_size_1080p".equals(dk)) {
                edit.putString("pref_video_size_key", "video_size_1080p");
            }
            edit.apply();
            gC();
            this.Y.f("pref_video_super_eis_key");
            this.Y.f("key_video_hdr");
            this.Y.f("pref_video_blur_menu");
            this.Y.f("pref_video_tilt_shift_key");
        }
        this.X.c(false);
        if (aF) {
            if (eB()) {
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && Float.compare(bd(), 0.6f) == 0) {
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "on").apply();
            }
            if (!this.Y.s() || !"filter".equals(bP())) {
                this.Y.h("pref_video_filter_menu");
            } else {
                this.Y.q(true);
            }
            if (this.Y.C()) {
                this.Y.a(true, true, true, false);
            }
            this.Y.a((int) R.string.camera_ai_enhancement_video_on_hint, -1, true, false, false);
            return;
        }
        CameraMenuOption cameraMenuOption = this.aZ;
        if (cameraMenuOption != null) {
            cameraMenuOption.f(false);
        }
        String e = this.Y.e();
        if (TextUtils.isEmpty(e) || !e.equals(this.Z.getString(R.string.camera_video_blur_open))) {
            this.Y.a((int) R.string.camera_ai_enhancement_video_off_hint, -1, true, false, false);
        }
        if ("on".equals(this.aa.getString("pref_none_sat_ultra_wide_angle_key", "off"))) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                this.X.af();
            }
            this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
        }
    }

    public void fL() {
        boolean cL = cL();
        String dk = dk();
        String string = this.aa.getString("pref_video_fps_key", "30");
        com.oppo.camera.e.a("CommonVideoMode", "onVideoHdrModeChanged, isVideHdrOpen: " + cL + ", videoSizeType: " + dk + ", videoFps: " + string);
        SharedPreferences.Editor edit = this.aa.edit();
        this.X.c(true);
        if (cL) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !"H265".equals(fZ())) {
                edit.putString("pref_video_codec_key", "H265");
            }
            if (eu()) {
                edit.putString("pref_video_blur_menu", "off");
            }
            if (dz()) {
                edit.putString("pref_video_tilt_shift_key", "off").apply();
                this.Y.f("pref_video_tilt_shift_key");
            }
            if (cb()) {
                edit.putInt(bY(), 0);
            }
            if (ae()) {
                gM();
            }
            if (aG()) {
                edit.putString("pref_video_super_eis_key", "off").apply();
                this.Y.f("pref_video_super_eis_key");
            }
            if (f(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                edit.putBoolean("pref_super_eis_wide_key", false);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR)) {
                if (!"video_size_4kuhd".equals(dk)) {
                    edit.putString("pref_video_size_key", "video_size_4kuhd");
                }
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR) && !"video_size_1080p".equals(dk)) {
                edit.putString("pref_video_size_key", "video_size_1080p");
            }
            if (30 != Integer.parseInt(string)) {
                edit.putString("pref_video_fps_key", String.valueOf(30));
            }
            if (f(CameraFunction.ULTRA_NIGHT_VIDEO) && aE()) {
                edit.putString("key_ultra_night_video", "off").apply();
                this.Y.f("key_ultra_night_video");
            }
            if (f(CameraFunction.AI_ENHANCEMENT_VIDEO) && aF()) {
                edit.putString("key_ai_enhancement_video", "off").apply();
                this.Y.f("key_ai_enhancement_video");
            }
            edit.apply();
        }
        this.X.c(false);
        if (cL) {
            if (eB()) {
                this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
            }
            if (!this.Y.s() || !"filter".equals(bP())) {
                this.Y.h("pref_video_filter_menu");
            } else {
                this.Y.q(true);
            }
            if (this.Y.C()) {
                this.Y.a(true, true, true, false);
            }
            this.Y.m(0);
        }
    }

    private boolean gR() {
        return (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) ? "video_size_4kuhd" : "video_size_1080p").equals(dk()) && 30 == gB();
    }

    private boolean gS() {
        return "video_size_1080p".equals(dk()) && 30 == gB();
    }

    private boolean gT() {
        String dk = dk();
        int gB = gB();
        String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_FRONT_RESOLUTION);
        String[] configStringArrayValue2 = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_REAR_RESOLUTION);
        if (!this.t || configStringArrayValue == null || configStringArrayValue.length <= 0) {
            if (this.t || configStringArrayValue2 == null || configStringArrayValue2.length <= 0) {
                String str = "video_size_1080p";
                if (gz()) {
                    if (!str.equals(dk) || 30 != gB) {
                        return false;
                    }
                    return true;
                } else if (!this.t) {
                    if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_REAR_VIDEO_1080P_SIZE)) {
                        str = "video_size_720p";
                    }
                    if (30 != gB || !str.equals(dk)) {
                        return false;
                    }
                    return true;
                } else if (30 != gB || (!str.equals(dk) && !"video_size_720p".equals(dk))) {
                    return false;
                } else {
                    return true;
                }
            } else if (!Util.b(configStringArrayValue2, dk) || 30 != gB) {
                return false;
            } else {
                return true;
            }
        } else if (!Util.b(configStringArrayValue, dk) || 30 != gB) {
            return false;
        } else {
            return true;
        }
    }

    public boolean cL() {
        if (f(CameraFunction.VIDEO_HDR)) {
            return "on".equals(n(cJ()));
        }
        return false;
    }

    private boolean gU() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_WIDE_VIDEO_ONLY_720P_SUPPORT);
    }

    private boolean gV() {
        return this.aa != null && this.aa.getString("pref_camera_line_video", "off").equals("grid");
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof VideoRecordMsgData) {
            videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData.mLux = String.valueOf(this.aD);
            videoRecordMsgData.mCct = String.valueOf(this.aE);
            videoRecordMsgData.mIso = String.valueOf(this.aF);
            videoRecordMsgData.mExp = String.valueOf(this.aG);
            videoRecordMsgData.mIsAssistantLine = Boolean.toString(gV());
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    public boolean aE() {
        if (f(CameraFunction.ULTRA_NIGHT_VIDEO)) {
            return "on".equals(this.aa.getString("key_ultra_night_video", "off"));
        }
        return false;
    }

    public boolean aF() {
        if (!f(CameraFunction.AI_ENHANCEMENT_VIDEO) || this.aa == null) {
            return false;
        }
        return "on".equals(this.aa.getString("key_ai_enhancement_video", "off"));
    }

    public boolean cB() {
        return cL();
    }

    public boolean dn() {
        return !this.t;
    }

    /* access modifiers changed from: protected */
    public ImageCategory.ItemInfoType eR() {
        return gq() ? this.aH ? ImageCategory.ItemInfoType.VIDEO : ImageCategory.ItemInfoType.PREVIEW : (!dO() || en() || !r("type_video_frame")) ? ImageCategory.ItemInfoType.PREVIEW : ImageCategory.ItemInfoType.VIDEO;
    }

    /* renamed from: do  reason: not valid java name */
    public long m3do() {
        return ((fE() || eI()) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS)) ? 131 : 128;
    }

    public long eU() {
        return super.eU();
    }

    public boolean cM() {
        if (f("pref_10bits_heic_encode_key")) {
            if (cb() || eu() || ae() || !er()) {
                return false;
            }
            return true;
        } else if (!cL() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR_10BIT)) {
            return false;
        } else {
            return true;
        }
    }

    public int D() {
        return (!fE() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS)) ? 20 : 40;
    }

    public String b() {
        if (this.z) {
            return null;
        }
        if (((this.X != null && !this.X.j()) || (!aG() && !ex() && gK())) && !eo()) {
            return AlgoSwitchConfig.getSupportCameraFeature(ApsConstant.FEATURE_COMMON_VIDEO_DUMMY, this.n) ? ApsConstant.FEATURE_COMMON_VIDEO_DUMMY : ApsConstant.FEATURE_COMMON_DUMMY;
        }
        if (this.t || !ew()) {
            if (fE()) {
                return eI() ? ApsConstant.FEATURE_REC_SUPER_EIS_PRO : ApsConstant.FEATURE_REC_SUPER_EIS;
            }
            if (ex() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
                return ApsConstant.FEATURE_REC_SAT_HAL;
            }
            if (cL()) {
                return ApsConstant.FEATURE_REC_LIVE_HDR;
            }
            if (aE()) {
                return ApsConstant.FEATURE_REC_ULTRA_NIGHT;
            }
            if (aF()) {
                return ApsConstant.FEATURE_REC_AI_ENHANCEMENT;
            }
            return super.b();
        } else if (AlgoSwitchConfig.getSupportCameraFeature(ApsConstant.FEATURE_VIDEO_RETENTION, this.n)) {
            return ApsConstant.FEATURE_VIDEO_RETENTION;
        } else {
            return AlgoSwitchConfig.getSupportCameraFeature(ApsConstant.FEATURE_COMMON_VIDEO_DUMMY, this.n) ? ApsConstant.FEATURE_COMMON_VIDEO_DUMMY : ApsConstant.FEATURE_COMMON_DUMMY;
        }
    }

    public boolean dS() {
        return this.aa != null && "video_size_4kuhd".equals(this.aa.getString("pref_video_size_key", fH()));
    }

    private void gW() {
        SharedPreferences.Editor edit = this.aa.edit();
        String string = this.aa.getString("pref_photo_codec_backup_key", "JPEG");
        String string2 = this.aa.getString("pref_video_codec_backup_key", "H264");
        edit.putString("pref_photo_codec_key", string);
        edit.putString("pref_video_codec_key", string2);
        edit.apply();
    }
}
