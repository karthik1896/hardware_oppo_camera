package com.oppo.camera.e;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.util.Size;
import android.view.MotionEvent;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureResult;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.f.a;
import com.oppo.camera.f.c;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.professional.e;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: NightMode */
public class q extends e {
    private long aB;
    private int aC;
    private int aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private int aH;
    private boolean aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private boolean aM;
    private e aN;
    private int aO;

    public String a() {
        return ApsConstant.CAPTURE_MODE_NIGHT;
    }

    /* access modifiers changed from: protected */
    public int aB() {
        return 3;
    }

    public boolean aa() {
        return false;
    }

    public String b() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String bY() {
        return "pref_night_facebeauty_level_menu";
    }

    public boolean br() {
        return false;
    }

    public int c() {
        return 32793;
    }

    public boolean c(String str) {
        return false;
    }

    public String cg() {
        return "key_night_filter_index";
    }

    public String ch() {
        return "pref_night_filter_menu";
    }

    public void cx() {
    }

    public boolean ej() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fl() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public boolean z(String str) {
        return false;
    }

    public q(Activity activity, b bVar, com.oppo.camera.ui.e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
        this.aB = Long.MAX_VALUE;
        this.aC = 0;
        this.aD = 0;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        this.aH = 0;
        this.aI = false;
        this.aJ = false;
        this.aK = false;
        this.aL = false;
        this.aM = false;
        this.aN = null;
        this.aO = 0;
        this.aO = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_NIGHT_TRIPOD_RAM_THRESHOLD);
    }

    /* access modifiers changed from: protected */
    public long aK() {
        return (long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_NIGHT);
    }

    public void a(CaptureRequest.Builder builder, int i, int i2, String[] strArr) {
        int i3;
        if (!Util.p() && builder != null) {
            com.oppo.camera.e.b("NightMode", "onCaptureRequestBuilderUpdate, index: " + i2 + ", pictureNum: " + i);
            builder.set(c.ar, Integer.valueOf(i2));
            builder.set(c.aq, Integer.valueOf(i));
            if (strArr != null && strArr.length > 0) {
                if (ParameterKeys.ALGO_NAME_MFNR.equals(strArr[0]) || ParameterKeys.ALGO_NAME_AINR.equals(strArr[0]) || ParameterKeys.ALGO_NAME_AIHDR.equals(strArr[0])) {
                    if (ParameterKeys.ALGO_NAME_AIHDR.equals(strArr[0]) && this.aF) {
                        i3 = 4;
                    } else if (i2 != i - 1 || !ParameterKeys.ALGO_NAME_AINR.equals(strArr[0]) || !this.aF) {
                        i3 = ParameterKeys.ALGO_NAME_MFNR.equals(strArr[0]) ? 1 : 2;
                    } else {
                        i3 = 5007;
                    }
                    builder.set(c.ap, new int[]{i3});
                    com.oppo.camera.e.b("NightMode", "onCaptureRequestBuilderUpdate, hintForIspTuning: " + i3);
                }
            }
        }
    }

    public int aS() {
        return Util.p() ? 32 : 0;
    }

    public Size d(j jVar) {
        if (a.h() == a(this.n)) {
            String string = this.aa.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value));
            if (k(string)) {
                string = "standard";
            }
            List<Size> a2 = jVar.a(256);
            Size fP = fP();
            if (fP != null) {
                com.oppo.camera.e.a("NightMode", "getPictureSize, nightCropSize: " + fP + ", sizeList: " + a2);
                if ("standard".equals(string) || "standard_high".equals(string)) {
                    return Util.a(a2, 1.3333333333333333d, fP.getHeight(), fP.getWidth());
                }
                if ("full".equals(string)) {
                    return Util.a(a2, Util.G(), fP.getHeight(), fP.getWidth());
                }
                if ("square".equals(string)) {
                    return Util.a(a2, 1.0d, fP.getHeight(), fP.getWidth());
                }
                if ("16_9".equals(string)) {
                    return Util.a(a2, 1.7777777777777777d, fP.getHeight(), fP.getWidth());
                }
            }
        }
        return super.d(jVar);
    }

    private Size fP() {
        Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_BACK_NIGHT_LOW_MEMORY_RAW_PICTURE_SIZE);
        if (sizeConfigValue != null && Util.e((Context) this.Z).totalMem <= STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1) {
            return sizeConfigValue;
        }
        List<Size> configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_BACK_NIGHT_RAW_PICTURE_SIZE);
        if (configSizeListValue == null || configSizeListValue.size() == 0) {
            return null;
        }
        return configSizeListValue.get(0);
    }

    public boolean k(String str) {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) || !"16_9".equals(str)) {
            return super.k(str);
        }
        return true;
    }

    public boolean aR() {
        if (this.aI || this.aF || this.aJ || this.aK || fG()) {
            return false;
        }
        return super.aR();
    }

    private void fQ() {
        this.Y.a((int) R.string.camera_scene_tripod_night_fixed_tips, -1, true, false, false);
    }

    private void fR() {
        this.Y.b((int) R.string.camera_scene_tripod_night_fixed_tips);
    }

    private void fS() {
        if (!this.aL && !this.y) {
            this.Y.a((int) R.string.camera_scene_ultra_dark_mode_tips, -1, false, false, true);
            this.aL = true;
        }
    }

    private void fT() {
        if (this.aL && !this.y) {
            this.Y.b((int) R.string.camera_scene_ultra_dark_mode_tips);
            this.aL = false;
        }
    }

    private void fU() {
        this.aE = false;
        this.aD = 0;
        this.aL = false;
    }

    /* access modifiers changed from: protected */
    public void u() {
        super.u();
        this.aF = false;
        this.aI = false;
        e eVar = this.aN;
        if (eVar != null) {
            eVar.a(this.A);
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("NightMode", "onDeInitCameraMode()");
        fR();
        fT();
        fU();
        e eVar = this.aN;
        if (eVar != null) {
            eVar.b();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) && this.W != null) {
            this.Y.a("pref_camera_photo_ratio_key", "16_9");
        }
        super.t();
    }

    /* access modifiers changed from: protected */
    public void p() {
        super.p();
        fU();
        e eVar = this.aN;
        if (eVar != null) {
            eVar.c();
        }
    }

    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if (d.a.CAPTURE_REPROCESS != dVar.a()) {
            super.a(dVar, builder, hashMap, i);
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_PREVIEW) && hashMap.containsKey("type_main_preview_frame") && f(CameraFunction.NEED_PREVIEW_STREAM) && Util.p() && cQ()) {
            builder.addTarget(hashMap.get("type_main_preview_frame").a());
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        int i = dVar.M.mMultiFrameCount;
        this.aB = Util.i((Context) this.Z);
        this.aM = false;
        com.oppo.camera.e.b("NightMode", "onBeforeSnapping, rawCaptureNum: " + i + ", getNightStateDecision: " + ah() + ", mAvailMemory: " + this.aB);
        e eVar = this.aN;
        if (eVar != null && !eVar.a(dVar, this.au)) {
            return false;
        }
        boolean a2 = super.a(dVar);
        if (fJ()) {
            this.Y.a(true, true, false);
            if (this.aN != null && fO()) {
                this.Y.a(this.aN.s(), 5000);
            }
            fV();
        }
        return a2;
    }

    private void fV() {
        if (this.az > 0) {
            this.at.a(this.az);
        }
        fI();
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        if (fJ()) {
            this.Y.g();
            this.X.aC();
        }
        super.a(bArr, z);
        e eVar = this.aN;
        if (eVar != null) {
            eVar.a(bArr, z, fJ());
        }
        if (f("pref_night_pro_mode_key")) {
            this.Y.b(0, Util.b(e(a.a(this.n))));
            fX();
        }
        if (er()) {
            this.Y.a((int) R.string.camera_10bit_pic_saved, -1, true, false, false);
        }
    }

    /* access modifiers changed from: protected */
    public void f(boolean z, boolean z2) {
        if (this.av || !z) {
            e eVar = this.aN;
            if (eVar != null) {
                eVar.h();
            }
            super.f(z, z2);
            return;
        }
        com.oppo.camera.e.a("NightMode", "resetAfterPictureTaken, CaptureRawTime not end");
    }

    public void a(ApsTotalResult apsTotalResult) {
        int[] a2;
        super.a(apsTotalResult);
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            com.oppo.camera.e.e("NightMode", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
            return;
        }
        CaptureResult totalResult = apsTotalResult.getTotalResult();
        if (!this.v && fO()) {
            a(totalResult);
        }
        e eVar = this.aN;
        if (eVar != null) {
            eVar.a(totalResult);
        }
        if (!f("pref_night_tripod_mode_key")) {
            fR();
            return;
        }
        boolean fG = fG();
        if (!this.v && fG && (a2 = this.W.a((CaptureResult.Key<?>) c.W, totalResult)) != null && a2.length > 0) {
            this.aC += a2[0];
            boolean z = true;
            this.aD++;
            if (this.aD == 10) {
                if (this.aC < 6) {
                    z = false;
                }
                this.aE = z;
                this.aC = 0;
                this.aD = 0;
            }
        }
        if (!this.aE && this.av && fG && (!this.X.a(bd()) || !this.X.F())) {
            fQ();
        } else if (!fG) {
            fR();
        }
    }

    private void a(CaptureResult captureResult) {
        long b2 = b(captureResult);
        com.oppo.camera.e.b("NightMode", "updateEstimatedCaptureTime, estimatedCountDownTime: " + b2);
        if (b2 <= 0) {
            this.az = 0;
            return;
        }
        this.az = b2 / 1000000;
        this.az = (long) (Math.round(((float) this.az) / 1000.0f) * 1000);
    }

    private long b(CaptureResult captureResult) {
        Object a2;
        if (captureResult == null || (a2 = c.a(captureResult, c.aW)) == null) {
            return -1;
        }
        return ((long[]) a2)[0];
    }

    public void a(ApsAdapterDecision.DecisionResult decisionResult) {
        super.a(decisionResult);
        synchronized (this.i) {
            boolean z = true;
            if (!Util.p()) {
                if (this.af != null) {
                    if (!(13 == this.af.mApsDecisionFeatureType || 14 == this.af.mApsDecisionFeatureType)) {
                        if (29 == this.af.mApsDecisionFeatureType) {
                        }
                    }
                    this.aF = z;
                }
                z = false;
                this.aF = z;
            } else if (!(this.af == null || this.af.mApsAlgoFlag == null)) {
                String str = this.af.mApsAlgoFlag[0];
                if (!ParameterKeys.ALGO_NAME_DARKSIGHT.equals(str)) {
                    if (16 != this.af.mApsDecisionSceneMode) {
                        z = false;
                    }
                }
                this.aF = z;
                this.aI = ParameterKeys.ALGO_NAME_AI_NIGHT.equals(str);
                this.aJ = ParameterKeys.ALGO_NAME_SUPERNIGHT.equals(str);
                this.aK = ParameterKeys.ALGO_NAME_FRONT_PORTRAIT_SUPERNIGHT.equals(str);
            }
        }
        if (Util.p()) {
            if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_DARKSIGHT)) {
                fT();
                return;
            }
        } else if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_AINR) && !AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_AIHDR)) {
            fT();
            return;
        }
        if (!this.aF || !this.av || fG() || fO()) {
            fT();
        } else {
            fS();
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        com.oppo.camera.e.e("NightMode", "onResume");
        int i = this.aH;
        if (i <= 0) {
            i = Util.ag();
        }
        this.aH = i;
        int i2 = this.aH;
        this.aG = i2 > this.aO || i2 <= 0;
        e eVar = this.aN;
        if (eVar != null) {
            eVar.b(z);
        }
        super.a(z);
    }

    /* access modifiers changed from: protected */
    public void s() {
        super.s();
        int i = this.aH;
        if (i <= 0) {
            i = Util.ag();
        }
        this.aH = i;
        int i2 = this.aH;
        this.aG = i2 > this.aO || i2 <= 0;
        if (bp()) {
            bo();
            gb();
        }
        e eVar = this.aN;
        if (eVar != null) {
            eVar.i();
            this.aN.e(true);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) && this.W != null) {
            this.Y.b("pref_camera_photo_ratio_key", "16_9");
        }
    }

    public void eH() {
        super.eH();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) && this.W != null) {
            this.Y.b("pref_camera_photo_ratio_key", "16_9");
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        com.oppo.camera.e.e("NightMode", "OnStop");
    }

    public void cP() {
        if (this.t && Util.W() && f("pref_camera_torch_mode_key")) {
            super.cP();
        } else if (er()) {
            this.Y.a(this.Z.getString(R.string.camera_10bit_hint), 0, (int) R.color.screen_hint_text_color);
        }
    }

    /* access modifiers changed from: protected */
    public boolean fG() {
        return "on".equals(this.aa.getString("pref_night_tripod_mode_key", this.Z.getString(R.string.camera_night_tripod_mode_default_value)));
    }

    /* access modifiers changed from: protected */
    public boolean ek() {
        return ((ai() && cQ()) || fH() || this.ay != 0 || fJ()) && bC();
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = dcsMsgData instanceof CaptureMsgData ? (CaptureMsgData) dcsMsgData : null;
        if (captureMsgData == null) {
            return null;
        }
        captureMsgData.mIsTripodMode = fG() ? "on" : "off";
        if (f("pref_support_night_process")) {
            captureMsgData.mNightState = ah();
        }
        super.b(dcsMsgData);
        return dcsMsgData;
    }

    public boolean f(String str) {
        e eVar;
        if ("pref_burst_shot_key".equals(str) || "pref_camera_vivid_effect_key".equals(str) || "pref_camera_flashmode_key".equals(str) || "pref_camera_hdr_mode_key".equals(str) || "key_beauty3d".equals(str) || "pref_ai_scene_key".equals(str) || "pref_super_clear_portrait".equals(str) || "pref_camera_pi_ai_mode_key".equals(str) || "pref_camera_pi_mode_key".equals(str) || "key_high_picture_size".equals(str) || CameraFunction.SUPER_TEXT.equals(str) || "pref_face_rectify_key".equals(str) || CameraFunction.GOOGLE_LENS.equals(str) || "key_support_insensor_zoom_20x".equals(str) || "pref_qr_code_key".equals(str) || "key_bubble_type_zoom_ultra_wide".equals(str) || "support_focus_out_of_range".equals(str)) {
            return false;
        }
        if ("key_support_share_edit_thumb".equals(str)) {
            return this.av;
        }
        if (CameraFunction.APS_BRACKETMODE.equals(str)) {
            return true;
        }
        if ("pref_support_post_view".equals(str)) {
            if ((this.X == null || this.X.j()) && !ae()) {
                return true;
            }
            return false;
        } else if ("pref_support_raw_post_process".equals(str) || "pref_support_night_process".equals(str)) {
            return true;
        } else {
            if ("pref_support_switch_camera".equals(str)) {
                if (!f("pref_night_pro_mode_key") || (eVar = this.aN) == null || !eVar.f()) {
                    return Util.W();
                }
                return false;
            } else if ("pref_night_tripod_mode_key".equals(str)) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_TRIPOD_SUPPORT) || this.t || !this.aG) {
                    return false;
                }
                return true;
            } else if ("pref_auto_night_scence_key".equals(str)) {
                return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_COMMON_AUTO_NIGHT_SCENCE);
            } else {
                if ("pref_expand_popbar_key".equals(str)) {
                    return this.Y.s();
                }
                if ("pref_camera_gradienter_key".equals(str) || CameraFunction.MODE_PANEL.equals(str)) {
                    return false;
                }
                if ("pref_night_filter_menu".equals(str)) {
                    return f("pref_filter_process_key");
                }
                if ("pref_filter_menu".equals(str) || "key_support_no_face_forbid_beauty".equals(str)) {
                    return false;
                }
                if ("key_support_mode_change_vibrate".equals(str)) {
                    return true;
                }
                if ("key_support_show_dim_hint".equals(str)) {
                    if (f("pref_camera_torch_mode_key") || f("pref_camera_flashmode_key")) {
                        return true;
                    }
                    return false;
                } else if ("key_night_tripod_zoom_hide_ultra_wide".equals(str)) {
                    if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE) || !f("pref_night_tripod_mode_key") || !fG()) {
                        return false;
                    }
                    return true;
                } else if ("key_suppport_multi_focus".equals(str) || CameraFunction.AIS_SNAPSHOT.equals(str)) {
                    return false;
                } else {
                    if ("pref_night_pro_mode_key".equals(str)) {
                        if (!bp() || this.t) {
                            return false;
                        }
                        return true;
                    } else if ("pref_manual_exposure_key".equals(str)) {
                        return !fO();
                    } else {
                        if ("pref_headline_control_by_mode".equals(str)) {
                            e eVar2 = this.aN;
                            if (eVar2 == null) {
                                return false;
                            }
                            return eVar2.g();
                        } else if (CameraFunction.SAT_CAMERA.equalsIgnoreCase(str) && fO()) {
                            return false;
                        } else {
                            if ("pref_10bits_heic_encode_key".equals(str)) {
                                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT) || this.t) {
                                    return false;
                                }
                                return true;
                            } else if (!"pref_camera_gesture_shutter_key".equals(str)) {
                                return super.f(str);
                            } else {
                                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_NIGHT_GESTURE_SHUTTER) || !this.t) {
                                    return false;
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean r(String str) {
        if (!Util.p() && !this.t && (("type_still_capture_yuv_main".equals(str) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)) || "type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str) || "type_tuning_data_yuv".equals(str) || ("type_tuning_data_raw".equals(str) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)))) {
            return false;
        }
        if (!"type_reprocess_data_yuv".equals(str)) {
            return super.r(str);
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV) || this.t) {
            return false;
        }
        return true;
    }

    public boolean f() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT);
    }

    public boolean d() {
        return Util.W();
    }

    public boolean d(String str) {
        if ("pref_camera_hdr_mode_key".equals(str)) {
            return false;
        }
        if ("pref_night_filter_menu".equals(str)) {
            return f(str);
        }
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_setting_key".equals(str) || "pref_camera_photo_ratio_key".equals(str)) {
            return true;
        }
        return super.d(str);
    }

    public boolean au() {
        e eVar = this.aN;
        if (eVar != null) {
            return eVar.l();
        }
        super.au();
        return false;
    }

    public boolean c(MotionEvent motionEvent) {
        if (f("pref_support_night_process")) {
            return true;
        }
        return super.c(motionEvent);
    }

    /* access modifiers changed from: protected */
    public boolean cQ() {
        return ah() > 0;
    }

    public void V() {
        if (!Util.p() && !this.M && this.t && cQ()) {
            this.W.a(true, false);
            this.M = true;
        }
    }

    /* access modifiers changed from: protected */
    public String[] de() {
        return com.oppo.camera.ui.e.e;
    }

    public Size f(j jVar) {
        Size fP;
        if (a.i() == a(this.n)) {
            Size a2 = Util.a(jVar.a(32), "8000000", 0);
            if (a2 != null) {
                return a2;
            }
        } else if (a.h() == a(this.n) && (fP = fP()) != null) {
            return fP;
        }
        return super.f(jVar);
    }

    private Rect a(Rect rect) {
        if (a.h() == a(this.n)) {
            Size fP = fP();
            Rect d = this.W.e().d();
            if (!(d == null || rect == null || rect.width() <= 0 || rect.height() <= 0 || fP == null)) {
                if (fP.getWidth() == rect.width() && fP.getHeight() == rect.height()) {
                    com.oppo.camera.e.a("NightMode", "calculateCropRect, not need cropRect");
                    return null;
                }
                float width = ((float) d.width()) / (((float) fP.getWidth()) * 1.0f);
                float height = ((float) d.height()) / (((float) fP.getHeight()) * 1.0f);
                Rect rect2 = new Rect();
                rect2.set((int) (((float) rect.left) * width), (int) (((float) rect.top) * height), (int) (((float) rect.right) * width), (int) (((float) rect.bottom) * height));
                com.oppo.camera.e.a("NightMode", "calculateCropRect, newCropRect: (" + rect2.left + ", " + rect2.top + ", " + rect2.right + ", " + rect2.bottom + "), scaleW: " + width + ", scaleH: " + height);
                return rect2;
            }
        }
        return rect;
    }

    public void a(Image image, TotalCaptureResult totalCaptureResult, Rect rect, d dVar) {
        super.a(image, totalCaptureResult, a(rect), dVar);
    }

    /* access modifiers changed from: protected */
    public boolean v(String str) {
        if (!"pref_night_tripod_mode_key".equals(str) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE) || !f("pref_night_tripod_mode_key") || !f("pref_none_sat_ultra_wide_angle_key")) {
            return true;
        }
        return !eB();
    }

    public boolean eX() {
        return this.aw;
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        if ("pref_night_tripod_mode_key".equals(str) && f("pref_night_tripod_mode_key")) {
            fY();
            if (fG() && !this.y && this.aa.getBoolean("key_bottom_guide_type_night_tripod", true)) {
                this.Y.n(2);
            }
        } else if ("pref_night_pro_mode_key".equals(str)) {
            boolean fO = fO();
            boolean eB = eB();
            com.oppo.camera.e.b("NightMode", "onSharedPreferenceChanged isProModeOn: " + fO);
            fW();
            fZ();
            if (fO) {
                ga();
            }
            e eVar = this.aN;
            if (eVar != null) {
                eVar.c(fO);
            }
            if (!eB) {
                fX();
            }
        } else if ("pref_camera_id_key".equals(str)) {
            boolean z = false;
            if (1 == Integer.parseInt(sharedPreferences.getString("pref_camera_id_key", String.valueOf(0)))) {
                z = true;
            }
            e eVar2 = this.aN;
            if (eVar2 != null) {
                eVar2.d(z);
            }
        } else {
            e eVar3 = this.aN;
            if (eVar3 != null) {
                eVar3.a(sharedPreferences, str);
            }
        }
        super.a(sharedPreferences, str);
    }

    private void fW() {
        if (eB()) {
            this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
        }
    }

    public boolean b(MotionEvent motionEvent) {
        e eVar = this.aN;
        if (eVar != null) {
            return eVar.a(motionEvent);
        }
        return super.b(motionEvent);
    }

    private void fX() {
        e eVar;
        if (f("pref_night_pro_mode_key") && (eVar = this.aN) != null) {
            eVar.r();
        }
    }

    private void fY() {
        e eVar;
        if (f("pref_night_pro_mode_key")) {
            if ((this.X.a(bd()) || fG() || this.Y.s()) && (eVar = this.aN) != null) {
                eVar.q();
            }
        }
    }

    private void fZ() {
        if (f("pref_night_tripod_mode_key")) {
            if (fO() && !"off".equals(this.aa.getString("pref_night_tripod_mode_key", "off"))) {
                this.aa.edit().putString("pref_night_tripod_mode_key", "off").apply();
            }
            this.Y.f("pref_night_tripod_mode_key");
        }
    }

    public void f(boolean z) {
        fX();
        e eVar = this.aN;
        if (eVar != null) {
            eVar.j();
        }
        super.f(z);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2, boolean z3) {
        if (!fJ() || !this.aM) {
            super.a(z, z2, z3);
        }
    }

    public ab dl() {
        ab dl = super.dl();
        if (f("pref_night_pro_mode_key")) {
            boolean fO = fO();
            dl.m(fO);
            dl.r(fO);
        }
        return dl;
    }

    public boolean aM() {
        com.oppo.camera.e.a("NightMode", "onAfterSnapping");
        if (fJ()) {
            this.X.c(0);
            this.Y.a(true, false);
            this.aM = true;
        }
        return super.aM();
    }

    /* access modifiers changed from: protected */
    public List<Integer> f(int i) {
        if (f("pref_night_filter_menu")) {
            return g.q;
        }
        return super.f(i);
    }

    /* access modifiers changed from: protected */
    public List<String> g(int i) {
        if (f("pref_night_filter_menu")) {
            return g.p;
        }
        return super.g(i);
    }

    /* access modifiers changed from: protected */
    public void ev() {
        super.ev();
        if (this.aN != null && fO()) {
            this.aN.q();
        }
    }

    public void dT() {
        e eVar = this.aN;
        if (eVar != null) {
            eVar.a(3, false);
        }
    }

    public void s(boolean z) {
        e eVar = this.aN;
        if (eVar != null) {
            eVar.a(3, true);
        }
    }

    public void n(int i) {
        super.n(i);
        if (fG() && g.f4385a != i) {
            fZ();
        }
    }

    private void ga() {
        if (this.Y.s()) {
            this.Y.g(true, false);
        }
        if (ae()) {
            this.aa.edit().putInt(cg(), g.f4385a).apply();
            n(g.f4385a);
        }
    }

    private void gb() {
        this.aN = new e(this.Z, this.X, this.Y, a(), this.W);
        this.aN.a((e.a) new e.a() {
            public boolean a() {
                return q.this.v;
            }

            public boolean b() {
                return q.this.fJ();
            }

            public boolean a(String str) {
                return q.this.f(str);
            }

            public int c() {
                if (!q.this.bC() || !q.this.aV()) {
                    return q.super.bt();
                }
                return q.this.W.p();
            }

            public com.oppo.camera.ui.control.c d() {
                return q.this.o();
            }
        });
    }

    private boolean A(String str) {
        if (f(str) && this.aa != null) {
            return "on".equals(this.aa.getString(str, "off"));
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fO() {
        boolean z = 1 == Integer.parseInt(this.aa.getString("pref_camera_id_key", String.valueOf(0)));
        if (!A("pref_night_pro_mode_key") || z) {
            return false;
        }
        return true;
    }

    public boolean cS() {
        e eVar = this.aN;
        if (eVar != null) {
            return eVar.d();
        }
        return false;
    }

    public void bN() {
        e eVar = this.aN;
        if (eVar != null) {
            eVar.o();
        }
        super.bN();
    }

    public void bM() {
        e eVar = this.aN;
        if (eVar != null) {
            eVar.p();
        }
        super.bM();
    }

    public boolean cV() {
        if (fJ()) {
            return true;
        }
        return super.cV();
    }

    public void e(int i) {
        e eVar = this.aN;
        if (eVar != null) {
            eVar.a(i);
        }
        super.e(i);
    }

    public int ao() {
        e eVar = this.aN;
        if (eVar == null || !eVar.e()) {
            return super.ao();
        }
        return this.Z.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.main_mode_bar_height);
    }

    public void cU() {
        fY();
    }

    /* access modifiers changed from: protected */
    public boolean fJ() {
        return fO() && this.az > 0;
    }

    /* access modifiers changed from: protected */
    public boolean fN() {
        return fO();
    }

    /* access modifiers changed from: protected */
    public boolean cR() {
        return fO();
    }

    public void dr() {
        com.oppo.camera.e.a("NightMode", "onMoreModeShown");
        e eVar = this.aN;
        if (eVar != null) {
            eVar.m();
        }
        super.dr();
    }

    public void t(int i) {
        com.oppo.camera.e.a("NightMode", "onMoreModeHidden");
        e eVar = this.aN;
        if (eVar != null) {
            eVar.n();
        }
        super.t(i);
    }

    public void c(int i, boolean z) {
        com.oppo.camera.e.a("NightMode", "changeModeAllView animationType: " + i + ", isShow: " + z);
        super.c(i, z);
        e eVar = this.aN;
        if (eVar != null) {
            eVar.a(i, z);
        }
    }

    public int y(String str) {
        if (!str.equals("type_reprocess_data_yuv") || !er()) {
            return super.y(str);
        }
        return 34;
    }

    public void a(ApsCaptureResult apsCaptureResult, ImageCategory.MetaItemInfo metaItemInfo) {
        if (apsCaptureResult.mUpscaleInputSize != null && apsCaptureResult.mUpscaleInputSize.length == 4) {
            int i = apsCaptureResult.mUpscaleInputSize[0];
            int i2 = apsCaptureResult.mUpscaleInputSize[1];
            int i3 = apsCaptureResult.mUpscaleInputSize[2];
            int i4 = apsCaptureResult.mUpscaleInputSize[3];
            com.oppo.camera.e.a("NightMode", "resizeReprocessSizeToAps: " + Arrays.toString(apsCaptureResult.mUpscaleInputSize));
            metaItemInfo.setParameter(ParameterKeys.KEY_INPUT_SIZE, new int[]{i, i2, i3, i4});
            metaItemInfo.setParameter(ParameterKeys.KEY_OUTPUT_SIZE, new int[]{i, i2, i3, i4});
        }
    }

    public boolean fB() {
        return !fN();
    }
}
