package com.oppo.camera.r;

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.animation.Animation;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e.b;
import com.oppo.camera.e.u;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.jni.YuvProcessUtil;
import com.oppo.camera.k;
import com.oppo.camera.r.a;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.FocusAimMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.util.HashMap;

/* compiled from: SlowVideoMode */
public class g extends u {
    private boolean aT = false;
    private HashMap<String, String> aU = new HashMap<>();
    private Integer aV = null;
    private boolean aW = false;
    private boolean aX = false;
    private boolean aY = false;
    /* access modifiers changed from: private */
    public boolean aZ = false;
    private boolean ba = false;
    /* access modifiers changed from: private */
    public a bb = null;
    private final a.C0093a bc = new a.C0093a() {
        public void a(String str) {
            e.c cVar = new e.c();
            cVar.k = 1;
            cVar.d = Uri.parse(str);
            g gVar = g.this;
            boolean unused = gVar.a(gVar.gd(), str, cVar);
            g.this.a(cVar, true, true);
            boolean unused2 = g.this.aZ = false;
            com.oppo.camera.e.e("SlowVideoMode", "onProcessFinished !, videoContentUri = " + str);
        }

        public void b(String str) {
            g gVar = g.this;
            gVar.C(gVar.gd());
            g.this.a((e.c) null, true, false);
            boolean unused = g.this.aZ = false;
            com.oppo.camera.e.e("SlowVideoMode", "onCompileFailed !, videoContentUri = " + str);
        }
    };

    public String a() {
        return ApsConstant.REC_MODE_SLOW_VIDEO;
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        return false;
    }

    public boolean aM() {
        return false;
    }

    public boolean br() {
        return false;
    }

    public boolean f() {
        return true;
    }

    public boolean fd() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public boolean w(int i) {
        return false;
    }

    public g(Activity activity, b bVar, com.oppo.camera.ui.e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    public boolean d() {
        return f("pref_support_switch_camera");
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
        this.X.a(4);
        if (dP()) {
            this.aW = false;
            this.aX = false;
        }
    }

    /* access modifiers changed from: protected */
    public void r() {
        super.r();
        this.aT = false;
        gA();
        HashMap<String, String> hashMap = this.aU;
        if (hashMap != null) {
            hashMap.clear();
            this.aU = null;
        }
    }

    public boolean i(String str) {
        if ("pref_camera_videoflashmode_key".equals(str) || "pref_platform_slow_video_fps_key".equals(str)) {
            return true;
        }
        return super.i(str);
    }

    /* access modifiers changed from: protected */
    public void p() {
        this.aR = false;
        this.au.removeMessages(12);
        super.p();
        if (this.Y != null) {
            this.Y.b((int) R.string.camera_intelligent_high_frame_saving);
            this.Y.b((int) R.string.camera_intelligent_high_frame_not_detected);
        }
        if (this.X != null) {
            this.X.b(4);
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("SlowVideoMode", "onInitCameraMode");
        super.s();
        H(false);
        this.k = this.X.s();
        this.X.a(4);
    }

    public boolean e(String str) {
        if ("pref_face_detection_key".equals(str) && dO()) {
            return false;
        }
        if (!"pref_zoom_key".equals(str)) {
            return super.e(str);
        }
        if (this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO_ZOOM)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void fL() {
        if (f("pref_intelligent_high_frame_selected_key")) {
            String string = this.aa.getString("pref_intelligent_high_frame_selected_key", this.Z.getString(R.string.camera_intelligent_high_frame_default_selected));
            if (gv()) {
                String string2 = this.aa.getString("pref_temp_intelligent_high_frame_selected_key", "");
                if (!TextUtils.isEmpty(string2)) {
                    SharedPreferences.Editor edit = this.aa.edit();
                    edit.putString("pref_intelligent_high_frame_selected_key", string2);
                    edit.apply();
                    string = string2;
                }
                this.aa.edit().putString("pref_temp_intelligent_high_frame_selected_key", string).apply();
                this.Y.b("pref_intelligent_high_frame_selected_key", string);
            } else {
                this.Y.a("pref_intelligent_high_frame_selected_key", "off");
            }
            if (!gv() || !"on".equals(string)) {
                G(4);
            } else {
                G(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void fN() {
        if (this.Y != null && f("key_slow_video_frame_seek_bar_menu_key")) {
            this.Y.q(fT());
        }
    }

    public boolean f(String str) {
        if ("pref_camera_videoflashmode_key".equals(str)) {
            return true;
        }
        if ("pref_update_setting_background_bar_key".equals(str) || CameraFunction.REQUEST_FAST_LAUNCH.equals(str) || "pref_face_detection_key".equals(str) || "pref_video_size_key".equals(str) || "pref_time_lapse_key".equals(str) || "pref_camera_tap_shutter_key".equals(str) || "pref_camera_gesture_shutter_key".equals(str) || "pref_support_recording_capture".equals(str) || "pref_video_ratio_key".equals(str)) {
            return false;
        }
        if ("key_support_show_dim_hint".equals(str)) {
            return f("pref_camera_videoflashmode_key");
        }
        if ("key_support_slow_video_h265".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SLOW_MOTION_H265_SUPPORT);
        }
        if ("pref_slow_video_size_key".equals(str)) {
            if (this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOWMOTION_FOR_PLATFORM)) {
                return true;
            }
            return false;
        } else if ("pref_support_switch_camera".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO);
        } else {
            if ("pref_intelligent_high_frame_selected_key".equals(str) || "key_slow_video_frame_seek_bar_menu_key".equals(str)) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) || this.t || dO()) {
                    return false;
                }
                return true;
            } else if ("key_intelligent_high_frame_usage_key".equals(str)) {
                if (this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) || !gv()) {
                    return false;
                }
                return true;
            } else if ("pref_zoom_key".equals(str)) {
                if (dO() || this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO_ZOOM) || fR()) {
                    return false;
                }
                return true;
            } else if ("key_accelerometer_usage".equals(str)) {
                if (!dO() || !gt() || this.aW) {
                    return false;
                }
                return true;
            } else if (!"pref_platform_slow_video_fps_key".equals(str)) {
                return super.f(str);
            } else {
                if (this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOWMOTION_FOR_PLATFORM)) {
                    return false;
                }
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean fR() {
        return f("key_slow_video_frame_seek_bar_menu_key") && "on".equals(this.aa.getString("key_slow_video_frame_seek_bar_menu_key", this.Z.getString(R.string.camera_slow_video_mode_frame_default_value)));
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("SlowVideoMode", "onDeInitCameraMode");
        H(true);
        gA();
        if (!Util.p()) {
            this.W.a(false, dk());
        }
        super.t();
        this.X.b(4);
        c(false, false, false);
        this.Y.b((int) R.string.camera_intelligent_high_frame_on_hint);
        this.Y.b((int) R.string.camera_intelligent_high_frame_off_hint);
        this.Y.c((int) R.string.camera_intelligent_high_frame_slow_selected);
        this.Y.c((int) R.string.camera_intelligent_high_frame_super_selected);
        G(8);
    }

    public c o() {
        c o = super.o();
        o.b("button_shape_dial_still");
        return o;
    }

    /* access modifiers changed from: protected */
    public void u() {
        super.u();
        if (d("pref_platform_slow_video_fps_key")) {
            gz();
        }
        if (this.av.equals("video_size_1080p")) {
            this.ax.videoBitRate = YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE;
        } else if (this.av.equals("video_size_720p")) {
            this.ax.videoBitRate = 7500000;
        }
        String fU = fU();
        if (!TextUtils.isEmpty(fU)) {
            this.aV = Integer.valueOf(Integer.parseInt(fU));
        }
        com.oppo.camera.e.a("SlowVideoMode", "onBeforePreview, mVideoSpeed = " + this.aV + ", mVideoSizeType = " + this.av + ", slowVideoFps: " + fY());
        if (!Util.p()) {
            this.W.a(true, this.av);
        }
    }

    public void f(boolean z) {
        super.f(z);
        if (!this.aT) {
            if (this.Z != null) {
                this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        if (g.this.Y != null) {
                            g.this.Y.a((int) R.string.camera_slow_video_tips, -1, true, false, false);
                        }
                    }
                });
            }
            this.aT = true;
        }
        if (this.au != null) {
            this.au.post(new Runnable() {
                public void run() {
                    g.this.fN();
                    g.this.fL();
                    g gVar = g.this;
                    gVar.c(gVar.fR(), false, true);
                    if (g.this.f("pref_intelligent_high_frame_selected_key") && g.this.f("key_intelligent_high_frame_usage_key") && "on".equals(g.this.aa.getString("pref_intelligent_high_frame_selected_key", g.this.Z.getString(R.string.camera_intelligent_high_frame_default_selected)))) {
                        g.this.G(0);
                    }
                    if (g.this.X != null) {
                        g.this.X.g(false);
                    }
                }
            });
        }
    }

    public void gp() {
        if (!Util.V() || !f("key_support_slow_video_h265")) {
            String string = this.Z.getString(R.string.camera_video_codec_default_value);
            if ("H265".equals(this.aa.getString("pref_video_codec_key", string))) {
                com.oppo.camera.e.a("SlowVideoMode", "checkVideoCodecAndReset, reset video codec to default.");
                SharedPreferences.Editor edit = this.aa.edit();
                edit.putString("pref_video_codec_key", string);
                edit.apply();
            }
        }
    }

    public Float gb() {
        return super.gb();
    }

    public boolean fI() {
        return "H265".equals(this.aa.getString("pref_video_codec_key", this.Z.getString(R.string.camera_video_codec_default_value)));
    }

    public Integer fG() {
        return this.aV;
    }

    /* access modifiers changed from: protected */
    public String gc() {
        String fU = fU();
        if (TextUtils.isEmpty(fU)) {
            return super.gc();
        }
        if (fs()) {
            return this.bb.a(fU);
        }
        return "slow_motion_hfr_" + fU + ":0,0,0,0";
    }

    public boolean r(String str) {
        if ("type_video_frame".equals(str)) {
            if (this.X == null || !this.X.j() || en() || ep() || !f("key_intelligent_high_frame_usage_key")) {
                return false;
            }
            return true;
        } else if (!"type_main_preview_frame".equals(str)) {
            return "type_video".equals(str);
        } else {
            if (3 == AlgoSwitchConfig.getApsVersion()) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean ee() {
        return Util.p();
    }

    public Range<Integer> e() {
        int i;
        String fU = fU();
        if (TextUtils.isEmpty(fU)) {
            return null;
        }
        if (dO() || Util.p()) {
            i = Integer.parseInt(fU);
        } else {
            i = 30;
        }
        return Range.create(Integer.valueOf(i), Integer.valueOf(Integer.parseInt(fU)));
    }

    public String dk() {
        if (this.aa instanceof k) {
            return ((k) this.aa).a("pref_slow_video_size_key", fH());
        }
        return this.aa.getString("pref_slow_video_size_key", fH());
    }

    public String fH() {
        return (!com.oppo.camera.f.a.c(this.n) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) ? "video_size_720p" : "video_size_1080p";
    }

    public int dj() {
        return fF();
    }

    public Size e(j jVar) {
        Size B = B(dk());
        if (B != null) {
            return B;
        }
        return super.e(jVar);
    }

    public ab dl() {
        ab dl = super.dl();
        dl.t(true);
        return dl;
    }

    /* access modifiers changed from: protected */
    public boolean ep() {
        return !AlgoSwitchConfig.getSupportApsPreview() || this.t || !gv();
    }

    /* access modifiers changed from: protected */
    public int fY() {
        int fY = super.fY();
        if (f("key_intelligent_high_frame_usage_key")) {
            fY = fT();
        } else if (d("pref_platform_slow_video_fps_key")) {
            fY = gy();
        } else {
            Range<Integer> e = e();
            if (e != null) {
                fY = e.getLower().intValue();
            }
        }
        com.oppo.camera.e.a("SlowVideoMode", "getSlowVideoFps: " + fY);
        return fY;
    }

    private int fS() {
        if (!this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) {
            return gB();
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P);
    }

    private int fT() {
        return this.aa.getInt("pref_slow_video_rear_fps_key", fS());
    }

    private String fU() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) && !this.t) {
            int fT = fT();
            if (fT == 120) {
                return CameraConfig.getConfigFpsValue(ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE);
            }
            if (fT == 240) {
                return CameraConfig.getConfigFpsValue(ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE);
            }
            if (fT == 480) {
                return CameraConfig.getConfigFpsValue(ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE);
            }
            if (fT != 960) {
                return "";
            }
            return CameraConfig.getConfigFpsValue(ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE);
        } else if (d("pref_platform_slow_video_fps_key")) {
            return f.b(gy());
        } else {
            String dk = dk();
            if ("video_size_1080p".equals(dk)) {
                return CameraConfig.getConfigStringValue(ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P);
            }
            if ("video_size_720p".equals(dk)) {
                return CameraConfig.getConfigStringValue(ConfigDataBase.KEY_PREVIEW_FPS_HFR_720P);
            }
            return "";
        }
    }

    public boolean d(String str) {
        if ("pref_camera_videoflashmode_key".equals(str)) {
            return !this.t;
        }
        if ("pref_intelligent_high_frame_selected_key".equals(str) || "key_slow_video_frame_seek_bar_menu_key".equals(str) || "pref_platform_slow_video_fps_key".equals(str)) {
            return f(str);
        }
        return super.d(str);
    }

    public int c() {
        int i = (this.t || !f("key_support_fovc")) ? 32781 : 33549;
        if (this.W == null || this.W.e().a(dk()) == null) {
            return i;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public ImageCategory.ItemInfoType eR() {
        return (!dO() || en() || !r("type_video_frame")) ? ImageCategory.ItemInfoType.PREVIEW : ImageCategory.ItemInfoType.VIDEO;
    }

    public int D() {
        if (f("key_intelligent_high_frame_usage_key")) {
            return 16;
        }
        return super.D();
    }

    /* renamed from: do  reason: not valid java name */
    public long m13do() {
        if (f("key_intelligent_high_frame_usage_key")) {
            return 65536;
        }
        return super.m2do();
    }

    public void bh() {
        if (this.X != null) {
            if (fs()) {
                this.Y.k(this.bb.c());
                this.Y.a(this.bb.a(2));
            } else {
                c(false, true, true);
                this.X.a((Animation.AnimationListener) null);
                this.Y.a(new c(5, "button_color_inside_red", "button_shape_dial_still", 1));
            }
        }
        if (!Util.p()) {
            this.W.a(true, dk());
        }
        super.bh();
        if (this.W != null) {
            if (!Util.p() && this.X != null) {
                this.W.c(com.oppo.camera.f.a.b(this.n, this.X.s()));
            }
            this.W.a((f.c) null);
        }
    }

    public void bi() {
        this.W.a(1, com.oppo.camera.a.a(), com.oppo.camera.a.a(), false);
        if (Util.p()) {
            this.W.a(1, com.oppo.camera.a.a(), com.oppo.camera.a.a(), false);
        }
        this.W.a((f.c) null);
        if (gt()) {
            if (this.Y != null) {
                this.Y.a((int) R.string.camera_intelligent_high_frame_detecting, -1, false, false, true);
                this.Y.G(false);
            }
            if (this.X != null) {
                this.X.U();
                this.X.g(true);
            }
            this.au.removeMessages(12);
            this.au.sendMessageDelayed(this.au.obtainMessage(12), 120000);
        } else if (this.Y != null && f("key_intelligent_high_frame_usage_key")) {
            this.Y.a(false, true);
            this.Y.a((int) R.string.camera_intelligent_high_frame_recording, -1, false, false, true);
        } else if (fs()) {
            this.Y.a(false, true);
        }
        if (!this.y && this.aY) {
            this.aY = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean gt() {
        return f("key_intelligent_high_frame_usage_key") && "on".equals(this.aa.getString("pref_intelligent_high_frame_selected_key", this.Z.getString(R.string.camera_intelligent_high_frame_default_selected)));
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if (d.a.PREVIEW == dVar.a() && gv()) {
            if (hashMap.containsKey("type_video_frame")) {
                builder.addTarget(hashMap.get("type_video_frame").a());
            } else {
                builder.addTarget(hashMap.get("type_video").a());
            }
        }
        super.a(dVar, builder, hashMap, i);
    }

    public void o(boolean z) {
        super.o(z);
        if (f("key_intelligent_high_frame_usage_key") && ((dN() || dM() || dQ()) && this.aj != null)) {
            this.aj.forceStop();
        }
        this.aY = true;
    }

    /* access modifiers changed from: protected */
    public boolean gg() {
        boolean z;
        if (gv()) {
            z = !this.aC && !this.aY;
        } else {
            z = super.gg();
        }
        boolean gt = gt();
        if (gt) {
            z = z && this.aW;
        }
        com.oppo.camera.e.b("SlowVideoMode", "isRecordFileValid: " + z + ", motionDetectOpen: " + gt + ", mbMotionDetected: " + this.aW + ", motionDetectOpen: " + gt + ", mbStopVideoFail: " + this.aC + ", mbForceStopRecord: " + this.aY);
        return z;
    }

    /* access modifiers changed from: protected */
    public void eQ() {
        if (!this.aW && !this.y) {
            com.oppo.camera.e.b("SlowVideoMode", "onMotionDetected");
            this.au.post(new Runnable() {
                public void run() {
                    if (g.this.Y != null && g.this.gt() && !g.this.y) {
                        g.this.Y.a((int) R.string.camera_intelligent_high_frame_recording, -1, false, false, true);
                        g.this.Y.a(false, true);
                        g.this.Y.k(2800);
                        g.this.Y.a(new c(3, "button_color_inside_none", "button_shape_dial_still", 1));
                        g.this.X.g(false);
                    }
                }
            });
        }
        if (!this.aW) {
            this.aW = true;
        }
    }

    /* access modifiers changed from: protected */
    public void eP() {
        if (!this.aX && !this.y) {
            com.oppo.camera.e.b("SlowVideoMode", "onFrameInterpolationStarted");
            this.au.post(new Runnable() {
                public void run() {
                    if (g.this.Y != null && !g.this.y) {
                        com.oppo.camera.e.b("SlowVideoMode", "onFrameInterpolationStarted, onVideoShutterButtonClick");
                        g.this.dI();
                        g.this.Y.a(new c(4, "button_color_inside_red", "button_shape_dial_still"));
                        g.this.Y.a((int) R.string.camera_intelligent_high_frame_saving, -1, false, false, true);
                    }
                }
            });
        }
        this.aX = true;
    }

    public boolean au() {
        if (!f("key_intelligent_high_frame_usage_key")) {
            return super.au();
        }
        if ((960 == fY() || gv()) && !this.t && dN() && this.aw < ((long) gu()) && !this.y && !this.X.m() && this.aA != null) {
            com.oppo.camera.e.d("SlowVideoMode", "onBackPressed(), Record Time less than 1 second.");
            return true;
        }
        this.an = true;
        if (!this.aY && gv() && !gx() && (dN() || dQ())) {
            o(false);
            if (this.Y != null) {
                this.Y.a(new c(6, "button_color_inside_red", "button_shape_dial_still", 1));
                this.Y.a(false, true);
                this.Y.b((int) R.string.camera_intelligent_high_frame_detecting);
                this.Y.b((int) R.string.camera_intelligent_high_frame_recording);
            }
            com.oppo.camera.e.a("SlowVideoMode", "onBackPressed, return, isVideoRecordStarted: " + dN() + ", isVideoRecordStopping: " + dQ());
            return true;
        } else if (!dO() && !dQ() && !gx()) {
            return false;
        } else {
            com.oppo.camera.e.a("SlowVideoMode", "onBackPressed, return, isVideoRecording: " + dO() + ", isVideoRecordStopping: " + dQ() + ", isSlowVideoFileSaving: " + gx());
            return true;
        }
    }

    private boolean gx() {
        return this.aX;
    }

    public void bj() {
        if (this.X != null) {
            this.X.D();
        }
        this.W.a(3, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
        this.W.a((f.c) null);
        if (this.Y != null && !this.y && !fs()) {
            this.Y.a(new c(6, "button_color_inside_red", "button_shape_dial_still", 1));
            this.Y.G(true);
            this.Y.b((int) R.string.camera_intelligent_high_frame_detecting);
            this.Y.b((int) R.string.camera_intelligent_high_frame_recording);
            fN();
            if (gt()) {
                if (this.X != null) {
                    this.X.g(false);
                }
                if (this.aW) {
                    this.Y.d(true, false);
                } else {
                    this.Y.a((int) R.string.camera_intelligent_high_frame_not_detected, -1, true, false, false);
                }
            }
            this.Y.b((int) R.string.camera_intelligent_high_frame_saving);
        }
        this.aW = false;
        this.aX = false;
        this.aR = false;
        super.bj();
    }

    public void a(ApsTotalResult apsTotalResult) {
        super.a(apsTotalResult);
    }

    public void cP() {
        if (fW()) {
            this.Y.a(-1, (int) R.drawable.torch_hint_icon, false, true, false);
        } else {
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

    public void am() {
        super.am();
        if (this.t) {
            this.Y.c((int) R.string.camera_intelligent_high_frame_slow_selected);
            this.Y.c((int) R.string.camera_intelligent_high_frame_super_selected);
            G(4);
        }
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        super.a(sharedPreferences, str);
        if ("key_slow_video_frame_seek_bar_menu_key".equals(str) && f(str) && sharedPreferences != null) {
            c("on".equals(sharedPreferences.getString("key_slow_video_frame_seek_bar_menu_key", this.Z.getString(R.string.camera_slow_video_mode_frame_default_value))), true, true);
        }
        if ("pref_intelligent_high_frame_selected_key".equals(str) && f(str) && sharedPreferences != null) {
            String string = sharedPreferences.getString("pref_intelligent_high_frame_selected_key", this.Z.getString(R.string.camera_intelligent_high_frame_default_selected));
            boolean equals = "on".equals(string);
            if (gv()) {
                sharedPreferences.edit().putString("pref_temp_intelligent_high_frame_selected_key", string).apply();
            }
            if (!equals || !f("key_intelligent_high_frame_usage_key")) {
                G(4);
                this.Y.a((int) R.string.camera_intelligent_high_frame_off_hint, -1, true, false, false);
            } else {
                G(0);
                this.Y.a((int) R.string.camera_intelligent_high_frame_on_hint, -1, true, false, false);
            }
        }
        if ("pref_platform_slow_video_fps_key".equals(str)) {
            gz();
        }
    }

    /* access modifiers changed from: protected */
    public boolean gv() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) || this.t) {
            return false;
        }
        int fT = fT();
        if (480 == fT || 960 == fT) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (this.Y == null) {
            return;
        }
        if (z) {
            this.X.a((Animation.AnimationListener) null);
            this.Y.F(z2);
            return;
        }
        this.Y.E(z2);
        if (z3) {
            this.X.D();
            this.X.d(true);
        }
    }

    /* access modifiers changed from: private */
    public void G(int i) {
        if (this.Y != null && this.X != null) {
            if (i == 0 && this.X.F()) {
                this.X.E();
            }
            this.Y.p(i);
        }
    }

    public void B(boolean z) {
        if (this.aa != null) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.remove("pref_slow_video_size_key");
            edit.remove("pref_slow_video_rear_fps_key");
            edit.remove("key_slow_video_frame_seek_bar_menu_key");
            edit.remove("pref_intelligent_high_frame_selected_key");
            edit.remove("pref_temp_intelligent_high_frame_selected_key");
            edit.apply();
        }
    }

    public void D(int i) {
        String str;
        SharedPreferences.Editor edit = this.aa.edit();
        if (120 == i) {
            str = CameraConfig.getConfigFpsVideoType(ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE);
        } else if (240 == i) {
            str = CameraConfig.getConfigFpsVideoType(ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE);
        } else if (480 == i) {
            str = CameraConfig.getConfigFpsVideoType(ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE);
        } else {
            str = 960 == i ? CameraConfig.getConfigFpsVideoType(ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE) : null;
        }
        edit.putString("pref_slow_video_size_key", str);
        edit.putInt("pref_slow_video_rear_fps_key", i).apply();
        String string = this.aa.getString("pref_intelligent_high_frame_selected_key", this.Z.getString(R.string.camera_intelligent_high_frame_default_selected));
        if (!gv() || "off".equals(string)) {
            G(4);
        }
        this.X.ap();
    }

    public void a(int i, int i2, boolean z, int i3) {
        this.aR = true;
        String str = i + "x" + i2;
        FocusAimMsgData focusAimMsgData = new FocusAimMsgData(this.Z);
        focusAimMsgData.mCameraId = a(this.n);
        focusAimMsgData.mCaptureMode = a();
        focusAimMsgData.mOrientation = this.k;
        focusAimMsgData.mCaptureType = 1;
        focusAimMsgData.mbVideoRecording = false;
        focusAimMsgData.mTouchXY = str;
        if (!this.t) {
            focusAimMsgData.mAeAfLock = String.valueOf(z);
        }
        focusAimMsgData.mTouchEV = String.valueOf(i3);
        focusAimMsgData.mActType = FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE;
        focusAimMsgData.report();
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof VideoRecordMsgData) {
            videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData.mLux = String.valueOf(this.aD);
            videoRecordMsgData.mIsIntelligentDetect = gt() ? "on" : "off";
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    public boolean b(int i, int i2) {
        if (!gt() || (!dN() && !dM())) {
            return super.b(i, i2);
        }
        return false;
    }

    public void bM() {
        super.bM();
        if (gt()) {
            G(4);
        }
    }

    public void bN() {
        super.bN();
        if (gt()) {
            G(0);
        }
    }

    /* access modifiers changed from: protected */
    public String gk() {
        return com.oppo.camera.h.b.b(a(), 0);
    }

    /* access modifiers changed from: protected */
    public void G(boolean z) {
        if (this.aw >= ((long) gu()) || this.y || this.X.m() || this.aA == null || !z || 960 != fY() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME)) {
            super.G(z);
            boolean equals = "on".equals(this.aa.getString("pref_camera_storage_key", this.Z.getString(R.string.camera_storage_default_value)));
            if (z.d() && equals) {
                this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        c cVar = new c();
                        cVar.a("button_color_inside_none");
                        cVar.a(4);
                        g.this.Y.a(cVar);
                    }
                });
                return;
            }
            return;
        }
        com.oppo.camera.e.d("SlowVideoMode", "onStopVideoRecording, Record Time less than 1 second.");
    }

    private int gy() {
        return Integer.parseInt(this.aa.getString("pref_platform_slow_video_fps_key", CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE)));
    }

    private a gz() {
        a aVar = this.bb;
        if (aVar == null || aVar.a() != gy()) {
            gA();
            this.bb = f.a(gy(), this.Z, this.Y);
            this.bb.a(this.bc);
            this.aa.edit().putString("pref_slow_video_size_key", f.c(this.bb.a())).apply();
        }
        com.oppo.camera.e.a("SlowVideoMode", "fpsModeInstanceWrap fpsMode: " + this.bb.a());
        return this.bb;
    }

    private void gA() {
        if (this.bb != null) {
            com.oppo.camera.e.a("SlowVideoMode", "destroyFpsMode mbCompilingVideo: " + this.aZ);
            if (this.aZ) {
                this.bb.d();
            }
            this.bb.e();
            this.bb = null;
        }
    }

    /* access modifiers changed from: protected */
    public int ge() {
        if (fs()) {
            return YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE;
        }
        return super.ge();
    }

    /* access modifiers changed from: protected */
    public boolean a(long j) {
        a aVar = this.bb;
        if (aVar != null) {
            this.ba = j > ((long) aVar.c());
        }
        return this.ba;
    }

    /* access modifiers changed from: protected */
    public void gw() {
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                c a2 = g.this.bb.a(3);
                if (a2 != null) {
                    g.this.Y.a(a2);
                }
                g.this.Y.d(false, false);
                boolean unused = g.this.aZ = true;
                g.this.bb.a(g.this.aQ, g.this.aO, g.this.aP, g.this.gk().concat(g.this.gc()));
            }
        });
    }

    public boolean fs() {
        a aVar = this.bb;
        return aVar != null && aVar.b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, com.oppo.camera.ui.control.e.c r6) {
        /*
            r4 = this;
            r0 = 0
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x0048 }
            r1.<init>()     // Catch:{ Exception -> 0x0048 }
            android.app.Activity r2 = r4.Z     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            android.net.Uri r3 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            r1.setDataSource(r2, r3)     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            r2 = -1
            android.graphics.Bitmap r2 = r1.getFrameAtTime(r2)     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            int r3 = com.oppo.camera.ui.control.ThumbImageView.f3902a     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            android.graphics.Bitmap r2 = com.oppo.camera.ui.control.e.b((android.graphics.Bitmap) r2, (int) r3)     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            r6.l = r2     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            r6.<init>()     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            java.lang.String r2 = "is_pending"
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            r6.put(r2, r3)     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            android.app.Activity r2 = r4.Z     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            r2.update(r5, r6, r0, r0)     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
            r1.release()
            goto L_0x0054
        L_0x0041:
            r5 = move-exception
            goto L_0x0055
        L_0x0043:
            r0 = r1
            goto L_0x0048
        L_0x0045:
            r5 = move-exception
            r1 = r0
            goto L_0x0055
        L_0x0048:
            java.lang.String r5 = "SlowVideoMode"
            java.lang.String r6 = "extractMetadataThumbnailFromFile, get video thumbnail fail."
            com.oppo.camera.e.a(r5, r6)     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0054
            r0.release()
        L_0x0054:
            return
        L_0x0055:
            if (r1 == 0) goto L_0x005a
            r1.release()
        L_0x005a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.r.g.a(java.lang.String, com.oppo.camera.ui.control.e$c):void");
    }

    /* access modifiers changed from: private */
    public boolean a(String str, String str2, e.c cVar) {
        if (!"on".equals(z.e()) || z.b(true)) {
            this.Y.o();
            a(str2, cVar);
            com.oppo.camera.e.b("SlowVideoMode", "deleteUpdateVideo, originalVideoFileName: " + str + ",  compiledSlowVideoUri: " + str2);
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_DUMP_960FPS_ORIGINAL)) {
                C(str);
            }
            if (this.aP != null) {
                this.aP.clear();
                this.aP = null;
            }
            return true;
        }
        this.aO = null;
        if (this.aP != null) {
            this.aP.clear();
            this.aP = null;
        }
        com.oppo.camera.e.a("SlowVideoMode", "deleteUpdateSlowVideoToMediaStore, Exception: sdcard has removed, so not add to mediaStore.");
        return false;
    }

    /* access modifiers changed from: private */
    public void a(e.c cVar, boolean z, boolean z2) {
        if (this.Y != null) {
            com.oppo.camera.e.b("SlowVideoMode", "enableUIView enable: " + z + ", animation: " + z2);
            c a2 = this.bb.a(1);
            if (a2 != null) {
                this.Y.a(a2);
            }
            this.Y.a(cVar, z2);
            this.Y.d(z, z2);
        }
    }

    private int gB() {
        int i;
        String dk = dk();
        if ("video_size_1080p".equals(dk)) {
            i = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE);
        } else {
            i = "video_size_720p".equals(dk) ? CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE) : 0;
        }
        return this.aa.getInt("pref_slow_video_rear_fps_key", i);
    }
}
