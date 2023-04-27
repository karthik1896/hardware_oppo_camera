package com.oppo.camera.o;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import androidx.preference.j;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.PolarrRender;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.e.b;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.k;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.ReminderMsgData;
import com.oppo.camera.ui.CameraScreenHintView;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: PortraitCapMode */
public class a extends com.oppo.camera.e.a {
    private float aA = -1.0f;
    private int aB = g.f4385a;
    private int aC = 0;
    /* access modifiers changed from: private */
    public String aD = "";
    private boolean aE = false;
    private boolean aF = false;
    /* access modifiers changed from: private */
    public Handler aG = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1 && a.this.av) {
                boolean unused = a.this.au = true;
                a aVar = a.this;
                aVar.d(aVar.az, false);
            }
        }
    };
    private boolean at = false;
    /* access modifiers changed from: private */
    public boolean au = true;
    /* access modifiers changed from: private */
    public boolean av = false;
    private boolean aw = false;
    private boolean ax = false;
    private CameraScreenHintView ay = null;
    /* access modifiers changed from: private */
    public int az = -1;

    private String fL() {
        return FilterPackageUtil.F_DEFAULT;
    }

    public String a() {
        return "portrait";
    }

    /* access modifiers changed from: protected */
    public int aB() {
        return 2;
    }

    public boolean aM() {
        return true;
    }

    public boolean aa() {
        return false;
    }

    /* access modifiers changed from: protected */
    public String bY() {
        return "pref_portrait_facebeauty_level_menu";
    }

    public boolean ea() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void eh() {
    }

    public boolean ej() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public a(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    public int eW() {
        if (this.t) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SUPPORT_FRONT_DARK_TIPS_THRESHOLD);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SUPPORT_BACK_DARK_TIPS_THRESHOLD);
    }

    public int C() {
        if ((this.X == null || !this.X.j()) && !fa() && (Util.p() || !fb())) {
            return 1;
        }
        return super.C();
    }

    public void ak() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MEMORY_NOT_ENOUGH_HINT) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MEMORY_NOT_ENOUGH_PORTRAIT_HINT)) {
            al();
        }
    }

    public int G() {
        if (f("pref_dual_camera")) {
            return fI() ? 1 : 2;
        }
        return super.G();
    }

    public int H() {
        if (f("pref_dual_camera")) {
            return 2;
        }
        return super.H();
    }

    public int bm() {
        return this.t ? g.i() : g.h();
    }

    public void e(int i) {
        super.e(i);
        PolarrRender.updateGlobalScreenOrientation(i);
        CameraScreenHintView cameraScreenHintView = this.ay;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setOrientation(i);
        }
    }

    /* access modifiers changed from: protected */
    public long aK() {
        return (long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_PORTRAIT);
    }

    public boolean X() {
        return this.aw;
    }

    public void eM() {
        g.a();
        fE();
        fM();
    }

    private void fE() {
        if (!(this.aa instanceof k)) {
            return;
        }
        if (g.k.size() == g.j.size() && -1 == g.b() && -1 == g.c() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_STREAMER_SUPPORT)) {
            ((k) this.aa).b("key_portrait_new_style_index");
        } else {
            ((k) this.aa).c("key_portrait_new_style_index");
        }
    }

    public int c() {
        return f("pref_dual_camera") ? (fJ() || fK()) ? 32784 : 32785 : CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_SINGLE_BLUR_OPERATING) ? 32806 : 32769;
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("PortraitCapMode", "onInitCameraMode");
        this.aE = false;
        this.aF = false;
        if (!c.INS.isInverseColor(this.Z.hashCode())) {
            this.Y.a(false, true, true);
        }
        this.Y.c(this.Z.getString(R.string.camera_description_common_shutter_button));
        this.av = f("pref_dual_camera");
        this.ax = fD();
        g.a();
        fE();
        fM();
        PolarrRender.updateGlobalScreenOrientation(this.k);
        if (this.ax) {
            A("on");
        } else {
            A("off");
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("PortraitCapMode", "onDeInitCameraMode");
        boolean z = false;
        this.aF = false;
        a(0, false);
        if (this.Y != null) {
            this.Y.b((int) R.string.camera_half_body_better);
        }
        if (this.ab != null) {
            this.ab.h(0);
        }
        Handler handler = this.aG;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        if (this.X != null && !f("pref_camera_torch_mode_key")) {
            this.X.Q();
            if (this.ax) {
                A("on");
            } else {
                A("off");
            }
        }
        CameraScreenHintView cameraScreenHintView = this.ay;
        if (cameraScreenHintView != null && cameraScreenHintView.getHintTextView().getVisibility() == 0) {
            this.ay.c(true);
        }
        this.aA = -1.0f;
        if (2 == this.aC && H(this.aB)) {
            z = true;
        }
        H(z);
    }

    public void s(String str) {
        com.oppo.camera.e.a("PortraitCapMode", "onMenuOptionAdded, key: " + str);
        if ("pref_portrait_new_style_menu".equals(str)) {
            this.Y.a("pref_portrait_new_style_menu", f("pref_portrait_new_style_menu") && this.Y.R(), (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    public String bS() {
        if (!this.Y.R()) {
            return super.bS();
        }
        return this.Z.getString(f(this.n).get(this.t ? g.g() : g.f()).intValue());
    }

    /* access modifiers changed from: protected */
    public void ev() {
        if (this.Y.R()) {
            fF();
            int g = this.t ? g.g() : g.f();
            this.aa.edit().putInt(cg(), g).apply();
            c(p(g), true);
            this.Y.a(true, ch());
            fM();
        }
    }

    private void fF() {
        this.Y.a("pref_portrait_new_style_menu", false, (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
        j.a((Context) this.Z).edit().putBoolean("portrait_filter_reddot_show", false).apply();
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        com.oppo.camera.e.a("PortraitCapMode", "onResume");
        this.au = f("pref_dual_camera");
        PolarrRender.updateGlobalScreenOrientation(this.k);
        fM();
    }

    public Size e(com.oppo.camera.f.j jVar) {
        if (!f("pref_dual_camera") && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SINGLE_CAMERA_USE_COMMOM_PORTRAIT_PREVIEW_SIZE)) {
            return super.e(jVar);
        }
        if (this.t) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_FRONT_PORTRAIT_PREVIEW_SIZE);
        }
        return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_REAR_PORTRAIT_PREVIEW_SIZE);
    }

    public Size a(com.oppo.camera.f.j jVar, String str) {
        double d;
        if (!"type_sub_preview_frame".equals(str) || Util.p()) {
            return super.a(jVar, str);
        }
        List<Size> a2 = jVar.a(538982489);
        String a3 = Util.a(d(jVar), this.n);
        if ("full".equals(a3)) {
            d = Util.G();
        } else if ("16_9".equals(a3)) {
            d = 1.7777777777777777d;
        } else {
            d = "square".equals(a3) ? 1.0d : 1.3333333333333333d;
        }
        com.oppo.camera.e.a("PortraitCapMode", "getPreviewSize, depth size list: " + a2);
        return Util.a(a2, d, 538982489);
    }

    public int x(String str) {
        if (!"type_sub_preview_frame".equals(str) || Util.p()) {
            return super.x(str);
        }
        return 538982489;
    }

    public Size d(com.oppo.camera.f.j jVar) {
        if (!f("pref_dual_camera")) {
            List<Size> a2 = jVar.a(256);
            Size size = null;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_FRONT_MAX_SIZE_SUPPORT)) {
                size = Util.c(a2, 1.3333333333333333d);
            } else {
                Size a3 = Util.a(a2, "8000000", 0);
                if (a3 != null) {
                    size = a3;
                }
            }
            if (size != null) {
                com.oppo.camera.e.b("PortraitCapMode", "getPictureSize, width: " + size.getWidth() + ", height: " + size.getHeight());
                return size;
            }
        }
        if (this.t) {
            Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_FRONT_PORTRAIT_NORMAL_MODE_PIC_SIZE);
            if (sizeConfigValue != null) {
                com.oppo.camera.e.b("PortraitCapMode", "getPictureSize, front size: " + sizeConfigValue.getWidth() + "x" + sizeConfigValue.getHeight());
            }
            return sizeConfigValue;
        }
        Size sizeConfigValue2 = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_BACK_PORTRAIT_NORMAL_MODE_PIC_SIZE);
        if (sizeConfigValue2 != null) {
            com.oppo.camera.e.b("PortraitCapMode", "getPictureSize, rear size: " + sizeConfigValue2.getWidth() + "x" + sizeConfigValue2.getHeight());
        }
        return sizeConfigValue2;
    }

    /* access modifiers changed from: protected */
    public float et() {
        return z(I(cf()) ? 100 : es());
    }

    /* access modifiers changed from: protected */
    public boolean eu() {
        return f(CameraFunction.BOKEH) || f(CameraFunction.FACE_BLUR);
    }

    public boolean fc() {
        return F(cf());
    }

    public boolean f(String str) {
        String c = com.oppo.camera.entry.b.c(str);
        if ("key_dark_environment_tips".equals(c)) {
            if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_SINGLE_AICOLOR) || !"portrait_retention".equals(this.aD)) {
                return false;
            }
            return true;
        } else if ("pref_filter_process_key".equals(c)) {
            if (f("pref_portrait_new_style_menu") || f("pref_filter_menu")) {
                return true;
            }
            return false;
        } else if ("pref_portrait_new_style_menu".equals(c)) {
            if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FILTER) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEW_STYLE)) {
                return false;
            }
            return true;
        } else if ("key_support_decrease_brightness".equals(c)) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DECREASE_BRIGHTNESS_SUPPORT) || this.t) {
                return false;
            }
            return true;
        } else if ("pref_filter_menu".equals(c)) {
            if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FILTER) || f("pref_portrait_new_style_menu") || f("pref_dual_camera")) {
                return false;
            }
            return true;
        } else if ("pref_support_capture_preview".equals(c)) {
            return this.X != null && this.X.j();
        } else {
            if ("pref_save_jpg_after_pause_key".equals(c)) {
                if (this.X == null || !this.X.j() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAVE_JPG_AFTER_PAUSE) || !Util.p()) {
                    return false;
                }
                return true;
            } else if ("key_remosaic".equals(c)) {
                return this.t;
            } else {
                if ("pref_camera_gesture_shutter_key".equals(c)) {
                    return this.t;
                }
                if ("pref_dual_camera".equals(c)) {
                    if (this.t) {
                        return com.oppo.camera.f.a.e();
                    }
                    if (!com.oppo.camera.f.a.d() || cf() == g.d()) {
                        return false;
                    }
                    return true;
                } else if ("pref_support_post_view".equals(c)) {
                    return false;
                } else {
                    if ("key_support_bokeh_hdr".equals(c)) {
                        if (this.X == null || !this.X.j()) {
                            return false;
                        }
                        return true;
                    } else if ("pref_auto_night_scence_key".equals(c)) {
                        if (this.X != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_COMMON_AUTO_NIGHT_SCENCE) && this.X.j()) {
                            return true;
                        }
                        return false;
                    } else if ("pref_portrait_half_body_key".equals(c)) {
                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_HALF_BODY_SUPPORT) || this.t) {
                            return false;
                        }
                        return true;
                    } else if ("pref_portrait_half_body_remosaic_key".equals(c)) {
                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_HALF_BODY_REMOSAIC_SUPPORT) || this.t) {
                            return false;
                        }
                        return true;
                    } else if ("pref_zoom_key".equals(c)) {
                        if (f("pref_portrait_half_body_key") || f("pref_portrait_half_body_remosaic_key")) {
                            return true;
                        }
                        return false;
                    } else if (CameraFunction.FACE_BEAUTY_PROCESS.equals(c)) {
                        if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FACE_BEAUTY)) {
                            return false;
                        }
                        if (!f("pref_dual_camera") || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BOKEH_BEAUTY_SUPPORT)) {
                            return true;
                        }
                        return false;
                    } else if (CameraFunction.FACE_SLENDER_PROCESS.equals(c)) {
                        if (!f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                            return false;
                        }
                        if (this.t || CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE) >= 6) {
                            return true;
                        }
                        return false;
                    } else if (CameraFunction.FACE_BEAUTY_CUSTOM.equals(c)) {
                        if (!f(CameraFunction.FACE_BEAUTY_PROCESS) || !this.t) {
                            return false;
                        }
                        return true;
                    } else if (CameraFunction.FACE_BEAUTY_COMMON.equals(c)) {
                        if (!f(CameraFunction.FACE_BEAUTY_PROCESS) || this.t) {
                            return false;
                        }
                        return true;
                    } else if (CameraFunction.BOKEH.equals(c)) {
                        if ((AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_BOKEH) || AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FRONT_BOKEH)) && f("pref_dual_camera")) {
                            return true;
                        }
                        return false;
                    } else if (CameraFunction.FACE_BLUR.equals(c)) {
                        if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, T()) || f("pref_dual_camera")) {
                            return false;
                        }
                        return true;
                    } else if ("pref_portrait_blur_menu".equals(c)) {
                        int cf = cf();
                        if ((f(CameraFunction.BOKEH) || f(CameraFunction.FACE_BLUR)) && !H(cf) && !I(cf)) {
                            return true;
                        }
                        return false;
                    } else if (CameraFunction.MODE_PANEL.equals(c)) {
                        return true;
                    } else {
                        if ("pref_camera_torch_mode_key".equals(c)) {
                            if (f(CameraFunction.TORCH_SOFT_LIGHT) || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_PORTRAIT) && this.t && c.INS.isInverseAble(this.Z))) {
                                return true;
                            }
                            return false;
                        } else if (CameraFunction.TORCH_SOFT_LIGHT.equals(c)) {
                            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT) || !this.t) {
                                return false;
                            }
                            return true;
                        } else if ("key_support_mode_change_vibrate".equals(c)) {
                            return true;
                        } else {
                            if ("pref_camera_slogan_key".equals(c)) {
                                return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_WATERMARK);
                            }
                            if ("pref_support_raw_post_process".equals(c)) {
                                if (AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_RAW2YUV) || (!Util.p() && fc())) {
                                    return true;
                                }
                                return false;
                            } else if ("key_support_show_dim_hint".equals(c)) {
                                if (f("pref_camera_flashmode_key") || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_PORTRAIT) && this.t && c.INS.isInverseAble(this.Z))) {
                                    return true;
                                }
                                return false;
                            } else if ("pref_camera_timer_shutter_key".equals(c) || "pref_setting_key".equals(c)) {
                                return true;
                            } else {
                                if ("key_filter_menu_updated".equals(c)) {
                                    return this.aF;
                                }
                                return super.f(c);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean g(String str) {
        return !"portrait_retention".equals(str) && !"portrait_streamer".equals(str) && (!"neon-2020.cube.rgb.bin".equals(str) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_REAR_NEON_SUPPORT_FILTER)) && super.g(str);
    }

    /* access modifiers changed from: protected */
    public void q() {
        com.oppo.camera.e.e("PortraitCapMode", "onStop");
    }

    public List<String> a(String str, int i) {
        if (!"pref_camera_photo_ratio_key".equals(str)) {
            return super.a(str, i);
        }
        List<String> supportedList = CameraConfig.getSupportedList("pref_camera_photo_ratio_key", i);
        ArrayList arrayList = new ArrayList();
        if (supportedList != null && supportedList.contains("standard")) {
            arrayList.add("standard");
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public boolean d(String str) {
        String c = com.oppo.camera.entry.b.c(str);
        if ("pref_portrait_new_style_menu".equals(c)) {
            return f("pref_portrait_new_style_menu");
        }
        if ("pref_filter_menu".equals(c)) {
            return f("pref_filter_menu");
        }
        if ("pref_camera_timer_shutter_key".equals(c) || "pref_setting_key".equals(c)) {
            return f(c);
        }
        if (!"pref_portrait_blur_menu".equals(c)) {
            return super.d(c);
        }
        return (f(CameraFunction.BOKEH) || f(CameraFunction.FACE_BLUR)) && !H(cf()) && !I(cf()) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_BLUR_LEVEL_ENABLE);
    }

    public void d(int i) {
        com.oppo.camera.e.e("PortraitCapMode", "onCameraIdChanged");
        H(2 == this.aC && this.t && c(this.aB));
        fM();
        this.aD = "";
        super.d(i);
    }

    /* access modifiers changed from: protected */
    public void p() {
        com.oppo.camera.e.a("PortraitCapMode", "onPause");
        Handler handler = this.aG;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        if (this.ay != null) {
            this.ac.removeView(this.ay);
            this.ay = null;
        }
        boolean z = false;
        if (this.Y != null && this.X.j()) {
            this.Y.a(o(), false);
        }
        if (this.X != null) {
            this.X.Q();
        }
        this.aD = "";
        this.aE = false;
        this.au = false;
        this.aw = false;
        this.aF = false;
        if (2 == this.aC && H(this.aB)) {
            z = true;
        }
        H(z);
        if (this.X != null && !this.X.an()) {
            if (this.ax) {
                A("on");
            } else {
                A("off");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void r() {
        com.oppo.camera.e.a("PortraitCapMode", "onDestroy");
    }

    /* access modifiers changed from: protected */
    public void u() {
        com.oppo.camera.e.a("PortraitCapMode", "onBeforePreview");
        if (this.Y != null && !"portrait_streamer".equals(this.aD)) {
            this.Y.b((int) R.string.camera_half_body_better);
        }
        b(false, J(cf()));
        this.aE = false;
        if (this.aw) {
            this.aw = false;
            c(p(this.aB), false);
        }
        if (f(CameraFunction.FACE_BEAUTY_PROCESS)) {
            int bX = bX();
            com.oppo.camera.e.a("PortraitCapMode", "onBeforePreview, level: " + bX);
            a(bX, false);
            a(dh());
            if (this.ab != null) {
                this.ab.h(bX);
                this.ab.a(dh());
                return;
            }
            return;
        }
        a(0, false);
        if (this.ab != null) {
            this.ab.h(0);
        }
    }

    /* access modifiers changed from: protected */
    public String[] de() {
        if (!com.oppo.camera.entry.b.a(this.as)) {
            return e.f_;
        }
        String[] strArr = new String[e.f_.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = com.oppo.camera.entry.b.b(e.f_[i], this.as);
        }
        return strArr;
    }

    /* access modifiers changed from: protected */
    public boolean cb() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BOKEH_BEAUTY_SUPPORT) || !f("pref_dual_camera")) {
            return super.cb();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int df() {
        if (bZ()) {
            return 0;
        }
        if (this.t || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BOKEH_BEAUTY_OPEN_DEFAULT)) {
            return 40;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        com.oppo.camera.e.a("PortraitCapMode", "onBeforeSnapping");
        if (!this.X.j() && this.Y.l() == 1) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (a.this.y) {
                        com.oppo.camera.e.a("PortraitCapMode", "onBeforeSnapping, return after pause");
                        return;
                    }
                    com.oppo.camera.ui.control.c cVar = new com.oppo.camera.ui.control.c();
                    cVar.a("button_color_inside_none");
                    cVar.a(4);
                    a.this.Y.a(cVar);
                }
            });
        }
        return true;
    }

    public void f(boolean z) {
        super.f(z);
        if (!this.aE) {
            this.aF = false;
            this.aE = true;
            this.az = -1;
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (!a.this.y) {
                        if (a.this.Y != null && "portrait_streamer".equals(a.this.aD)) {
                            a.this.Y.a((int) R.string.camera_half_body_better, -1, true, false, false);
                        }
                        a.this.bK();
                        a aVar = a.this;
                        boolean unused = aVar.av = aVar.f("pref_dual_camera");
                        if (a.this.av) {
                            a.this.aG.removeMessages(1);
                            a.this.aG.sendEmptyMessageDelayed(1, 400);
                        }
                    }
                }
            });
        }
    }

    public void c(boolean z) {
        com.oppo.camera.ui.control.c o = o();
        if (z) {
            o.a(8);
            o.a("button_color_inside_none");
        } else {
            o.a(11);
            o.a("button_color_inside_none");
        }
        this.Y.a(o);
    }

    /* access modifiers changed from: private */
    public void fG() {
        fH();
    }

    /* access modifiers changed from: private */
    public void B(String str) {
        if (this.au) {
            if (this.ay == null) {
                fG();
            }
            this.ay.setVisibility(0);
            this.ay.a(str, true, false);
        }
    }

    /* access modifiers changed from: private */
    public void G(boolean z) {
        if (this.ay != null) {
            boolean z2 = this.Z.getString(R.string.camera_toast_LDAF) == this.ay.getHintTextView().getText() && this.Y.D();
            if (this.ay.getHintTextView().getVisibility() == 0) {
                if (this.Z.getString(R.string.camera_toast_gesture_take_picture).equals(this.ay.getHintTextView().getText().toString())) {
                    int i = this.az;
                    if (-1 != i && 1 != i) {
                        this.ay.c(z);
                    }
                } else if (!z2) {
                    this.ay.c(z);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2, boolean z3) {
        super.a(z, z2, z3);
        if (z2) {
            this.X.c(0);
            this.X.i();
        }
    }

    /* access modifiers changed from: protected */
    public void b(byte[] bArr, boolean z) {
        com.oppo.camera.e.c("PortraitCapMode", "onBeforePictureTaken");
        if (this.y) {
        }
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        com.oppo.camera.e.a("PortraitCapMode", "onAfterPictureTaken");
        if (com.oppo.camera.entry.b.a(this.as)) {
            this.az = -1;
        }
        if (this.X.j()) {
            if (!br()) {
                this.X.n();
            }
            this.Y.d(true, false);
        }
        this.Y.a(o(), false);
        w();
    }

    public boolean i(String str) {
        if ("pref_camera_photo_ratio_key".equals(str)) {
            return false;
        }
        return super.i(str);
    }

    public void c(int i, boolean z) {
        super.c(i, z);
        if (i != 1) {
            if (i != 4) {
                if (i == 5) {
                    this.au = z;
                    if (!z) {
                        CameraScreenHintView cameraScreenHintView = this.ay;
                        if (cameraScreenHintView != null) {
                            cameraScreenHintView.c(false);
                        }
                    } else if (this.Y.l() == 4) {
                        this.Y.a(o(), false);
                    }
                }
            } else if (this.av) {
                d(0, false);
                CameraScreenHintView cameraScreenHintView2 = this.ay;
                if (cameraScreenHintView2 != null) {
                    cameraScreenHintView2.setVisibility(z ? 0 : 8);
                }
            }
        } else if (!z) {
            this.au = false;
            Handler handler = this.aG;
            if (handler != null) {
                handler.removeMessages(1);
            }
            CameraScreenHintView cameraScreenHintView3 = this.ay;
            if (cameraScreenHintView3 != null && cameraScreenHintView3.getHintTextView().getVisibility() == 0) {
                this.ay.c(true);
            }
        }
        if (4 != i && 7 != i && 8 != i && 9 != i && !z && 3 != i) {
            this.au = false;
            Handler handler2 = this.aG;
            if (handler2 != null) {
                handler2.removeMessages(1);
            }
            CameraScreenHintView cameraScreenHintView4 = this.ay;
            if (cameraScreenHintView4 != null) {
                cameraScreenHintView4.c(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void n(int i) {
        boolean z = true;
        if (c(this.aB, i)) {
            this.aw = true;
        } else {
            this.aw = false;
        }
        if (this.ab != null) {
            this.aF = c(p(i), true);
            this.ab.c(false);
        }
        super.n(i);
        if (this.aF) {
            this.aF = this.aw;
            aD();
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    a.this.Y.j();
                }
            });
        }
        if (!this.t && this.aB != i) {
            if (this.aw) {
                this.au = false;
                G(true);
                this.X.T();
                if (2 != this.aC || !H(this.aB)) {
                    z = false;
                }
                H(z);
            }
            this.aB = i;
        }
        if (fN() && this.Y.R()) {
            fF();
        }
    }

    /* access modifiers changed from: protected */
    public void o(int i) {
        if (this.ab != null) {
            if (ct() && i != g.f4385a) {
                cu();
            }
            if (!this.aw) {
                c(p(i), false);
                return;
            }
            return;
        }
        com.oppo.camera.e.e("PortraitCapMode", "updateFilterParam, mPreviewEffectProcess: " + this.ab + ", mPreferences: " + this.aa);
    }

    /* access modifiers changed from: protected */
    public List<Integer> f(int i) {
        if (f("pref_portrait_new_style_menu")) {
            return com.oppo.camera.f.a.c(i) ? g.j : g.k;
        }
        return super.f(i);
    }

    /* access modifiers changed from: protected */
    public List<String> g(int i) {
        if (f("pref_portrait_new_style_menu")) {
            return com.oppo.camera.f.a.c(i) ? g.h : g.i;
        }
        return super.g(i);
    }

    public String cg() {
        if (f("pref_portrait_new_style_menu")) {
            return "key_portrait_new_style_index";
        }
        return super.cg();
    }

    private void fH() {
        this.Y.m();
        this.ay = this.Y.n();
    }

    public String p(int i) {
        return g(this.n).get(i);
    }

    public void eG() {
        d(this.az, false);
    }

    public void a(ApsTotalResult apsTotalResult) {
        int i;
        super.a(apsTotalResult);
        if (apsTotalResult == null) {
            com.oppo.camera.e.e("PortraitCapMode", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
            return;
        }
        CaptureResult totalResult = apsTotalResult.getTotalResult();
        if (this.au && f("pref_dual_camera")) {
            int i2 = -1;
            if (2 == AlgoSwitchConfig.getApsVersion()) {
                i = a(totalResult);
            } else if (fI()) {
                i = a(totalResult);
            } else {
                if (apsTotalResult.get(ApsTotalResult.APS_BOKEN_STATE) != null) {
                    i2 = ((Integer) apsTotalResult.get(ApsTotalResult.APS_BOKEN_STATE)).intValue();
                }
                i = i2;
            }
            if (this.az != i) {
                com.oppo.camera.e.a("PortraitCapMode", "onPreviewCaptureResult, bokehState: " + this.az + " > " + i);
                this.az = i;
                d(this.az, true);
            }
        }
        int[] a2 = this.W.a((CaptureResult.Key<?>) com.oppo.camera.f.c.X, totalResult);
        if (a2 != null && Float.compare((float) a2[0], 0.0f) > 0) {
            this.aA = 1000.0f / ((float) a2[0]);
        }
    }

    private int a(CaptureResult captureResult) {
        Object a2 = com.oppo.camera.f.c.a(captureResult, com.oppo.camera.f.c.ad);
        if (a2 == null || !(a2 instanceof int[])) {
            return -1;
        }
        return ((int[]) a2)[0];
    }

    /* access modifiers changed from: private */
    public void G(int i) {
        if (7 == i && 2 != this.aC) {
            this.aC = 2;
            if (H(this.aB) && this.ab != null) {
                String fL = fL();
                this.ab.a(fL);
                this.Y.a(this.aB, fL);
                c(true, this.aB);
            }
        } else if (7 != i && 1 != this.aC) {
            this.aC = 1;
            if (H(this.aB) && this.ab != null) {
                String K = K(this.aB);
                this.ab.a(K);
                this.Y.a(this.aB, K);
                c(false, this.aB);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(final int i, final boolean z) {
        if (this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (!a.this.y) {
                        if (!a.this.Y.J() && !a.this.Y.H()) {
                            a.this.fG();
                            switch (i) {
                                case 1:
                                    a.this.G(true);
                                    break;
                                case 2:
                                    a aVar = a.this;
                                    aVar.B(aVar.Z.getString(R.string.camera_bokeh_move_farther_away));
                                    a.this.a("bokeh_code", String.valueOf(2));
                                    break;
                                case 3:
                                    a aVar2 = a.this;
                                    aVar2.B(aVar2.Z.getString(R.string.camera_bokeh_move_closer));
                                    a.this.a("bokeh_code", String.valueOf(3));
                                    break;
                                case 4:
                                    a aVar3 = a.this;
                                    aVar3.B(aVar3.Z.getString(R.string.camera_bokeh_need_more_light));
                                    a.this.a("bokeh_code", String.valueOf(4));
                                    break;
                                case 5:
                                    a aVar4 = a.this;
                                    aVar4.B(aVar4.Z.getString(R.string.camera_bokeh_place_subject_not_found));
                                    a.this.a("bokeh_code", String.valueOf(5));
                                    break;
                                case 7:
                                    a aVar5 = a.this;
                                    aVar5.B(aVar5.Z.getString(R.string.camera_bokeh_camera_occlusion));
                                    a.this.a("bokeh_code", String.valueOf(7), a.this.ce());
                                    break;
                                case 9:
                                    a aVar6 = a.this;
                                    aVar6.B(aVar6.Z.getString(R.string.camera_bokeh_single));
                                    a.this.a("bokeh_code", String.valueOf(9));
                                    break;
                                case 10:
                                    a aVar7 = a.this;
                                    aVar7.B(aVar7.Z.getString(R.string.camera_bokeh_camera_occlusion));
                                    a.this.a("bokeh_code", String.valueOf(10), a.this.ce());
                                    break;
                                default:
                                    a.this.G(true);
                                    break;
                            }
                            if (z) {
                                a.this.G(i);
                            }
                        } else if (z) {
                            a.this.G(i);
                        }
                    }
                }
            });
        }
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) ? null : (CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        captureMsgData.mBokehCode = this.az;
        return captureMsgData;
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if (d.a.PREVIEW == dVar.a() && ((cO() || f(CameraFunction.FACE_BLUR)) && hashMap.containsKey("type_preview_frame"))) {
            builder.addTarget(hashMap.get("type_preview_frame").a());
        }
        super.a(dVar, builder, hashMap, i);
    }

    private boolean fI() {
        return !this.t && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BACK_PURE_3RD_BOKEH_PREVIEW);
    }

    public boolean r(String str) {
        if ("type_sub_preview_frame".equals(str)) {
            if (3 != AlgoSwitchConfig.getApsVersion() || !f("pref_dual_camera") || fI()) {
                return false;
            }
            return true;
        } else if ("type_preview_frame".equals(str)) {
            if (2 != AlgoSwitchConfig.getApsVersion()) {
                return false;
            }
            if (f(CameraFunction.FACE_BLUR) || f("pref_camera_gesture_shutter_key")) {
                return true;
            }
            return false;
        } else if ("type_still_capture_yuv_sub".equals(str)) {
            return f("pref_dual_camera");
        } else {
            if ("type_still_capture_jpeg".equals(str)) {
                return !AlgoSwitchConfig.getSupportApsCapture();
            }
            return super.r(str);
        }
    }

    /* access modifiers changed from: protected */
    public String ei() {
        return this.Z.getString(R.string.camera_picture_size_standard);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        a(str, str2, "");
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.Z, true);
        if (this.X != null) {
            if (!this.X.j()) {
                reminderMsgData.mCameraEnterType = String.valueOf(2);
            }
            reminderMsgData.mCameraId = this.X.aq();
        }
        reminderMsgData.mCaptureMode = a();
        reminderMsgData.mCaptureType = 0;
        reminderMsgData.mOrientation = this.k;
        reminderMsgData.mPortraitNewStyleType = str3;
        reminderMsgData.mReminderTypeValue = str;
        reminderMsgData.mReminderCodeValue = str2;
        reminderMsgData.mRearOrFront = this.t ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    public String ch() {
        return com.oppo.camera.entry.b.b("pref_portrait_new_style_menu", this.as);
    }

    public boolean aj() {
        if (Util.p() || !f("pref_dual_camera")) {
            return super.aj();
        }
        return false;
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        if (!"pref_portrait_half_body_key".equals(str) || this.O) {
            if (!"pref_portrait_half_body_remosaic_key".equals(str) || this.O) {
                if (!"pref_camera_id_key".equals(str)) {
                    super.a(sharedPreferences, str);
                } else if (this.ax) {
                    A("on");
                } else {
                    A("off");
                }
            } else if (this.X != null) {
                this.X.ap();
            }
        } else if (this.X != null) {
            this.X.ao();
        }
    }

    public ab dl() {
        ab dl = super.dl();
        dl.g(f("pref_portrait_half_body_key"));
        dl.h(f("pref_portrait_half_body_remosaic_key"));
        return dl;
    }

    private boolean fJ() {
        if (!f("pref_portrait_half_body_key") || this.aa == null) {
            return false;
        }
        return "on".equals(this.aa.getString("pref_portrait_half_body_key", "off"));
    }

    private boolean fK() {
        if (!f("pref_portrait_half_body_remosaic_key") || this.aa == null) {
            return false;
        }
        return "on".equals(this.aa.getString("pref_portrait_half_body_remosaic_key", "off"));
    }

    public void dm() {
        if (this.ax) {
            A("on");
        } else {
            A("off");
        }
    }

    public int[] b(com.oppo.camera.f.j jVar) {
        if (Math.abs(c(jVar) - 2.0f) > 1.0E-6f) {
            return CameraConfig.getConfigIntArrayValue(ConfigDataBase.KEY_PORTRAIT_MODE_PHYSICAL_CAMERAID_1X);
        }
        return CameraConfig.getConfigIntArrayValue(ConfigDataBase.KEY_PORTRAIT_MODE_PHYSICAL_CAMERAID_2X);
    }

    public int m() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_MODE_SET_DEFAULT_LOGIC_CAMERA_TYPE) || this.t) {
            return super.m();
        }
        return 1;
    }

    public float c(com.oppo.camera.f.j jVar) {
        if (32784 == c()) {
            return 2.0f;
        }
        if (jVar != null) {
            return jVar.b(dl());
        }
        return 1.0f;
    }

    public boolean w(String str) {
        if ("type_main_preview_frame".equals(str)) {
            if (fI()) {
                return false;
            }
            if ((!Util.p() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && f("pref_dual_camera")) {
                return true;
            }
            return false;
        } else if ("type_sub_preview_frame".equals(str)) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT) || !f("pref_dual_camera")) {
                return false;
            }
            return true;
        } else if (!"type_still_capture_yuv_main".equals(str) && !"type_still_capture_yuv_sub".equals(str) && !"type_tuning_data_yuv".equals(str)) {
            return super.w(str);
        } else {
            if ((!Util.p() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && f("pref_dual_camera")) {
                return true;
            }
            return false;
        }
    }

    public boolean c(int i) {
        return i == g.b() || i == g.c();
    }

    private boolean H(int i) {
        return !this.t && c(i);
    }

    public boolean F(int i) {
        return !this.t && i == g.d();
    }

    private boolean I(int i) {
        return !com.oppo.camera.f.a.c(this.n) && i == g.e();
    }

    private boolean J(int i) {
        return !this.t && i == g.f();
    }

    private void H(boolean z) {
        if (z && this.Y != null) {
            e eVar = this.Y;
            int i = this.aB;
            eVar.a(i, K(i));
            c(false, this.aB);
        }
        this.aC = 0;
        this.az = -1;
    }

    private String K(int i) {
        if (i == g.b()) {
            return FilterPackageUtil.PORTRAIT4_1;
        }
        return i == g.c() ? FilterPackageUtil.PORTRAIT4_3 : FilterPackageUtil.F_DEFAULT;
    }

    public synchronized void c(boolean z, int i) {
        com.oppo.camera.e.a("PortraitCapMode", "setIsShelterByIndex, isShelter: " + z + ", index: " + i);
        g.i.set(i, z ? fL() : K(i));
    }

    private boolean c(int i, int i2) {
        return (!this.t && (c(i) || c(i2))) || F(i) || F(i2);
    }

    public int[] U() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(com.oppo.camera.aps.adapter.ApsAdapterDecision.DecisionResult r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.i
            monitor-enter(r0)
            r1 = 0
            if (r6 != 0) goto L_0x000f
            java.lang.String r6 = "PortraitCapMode"
            java.lang.String r2 = "disableBokehHDR, decisionResult null"
            com.oppo.camera.e.a(r6, r2)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x000f:
            java.lang.String r2 = "key_support_bokeh_hdr"
            boolean r2 = r5.f((java.lang.String) r2)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x0019:
            int r2 = r5.C()     // Catch:{ all -> 0x002f }
            r3 = 1
            if (r3 != r2) goto L_0x002d
            r2 = 12
            int r4 = r6.mApsDecisionSceneMode     // Catch:{ all -> 0x002f }
            if (r2 == r4) goto L_0x002c
            r2 = 13
            int r6 = r6.mApsDecisionSceneMode     // Catch:{ all -> 0x002f }
            if (r2 != r6) goto L_0x002d
        L_0x002c:
            r1 = r3
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x002f:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.o.a.c(com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult):boolean");
    }

    private boolean c(String str, boolean z) {
        boolean equals = "portrait_retention".equals(str);
        String str2 = FilterPackageUtil.F_DEFAULT;
        boolean z2 = false;
        if (equals) {
            this.ab.a(str2);
            this.ab.b(true);
        } else if ("portrait_streamer".equals(str)) {
            this.ab.a(str2);
            this.ab.b(false);
        } else if ("neon-2020.cube.rgb.bin".equals(str)) {
            n nVar = this.ab;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_REAR_NEON_SUPPORT_FILTER)) {
                str2 = str;
            }
            nVar.a(str2);
            this.ab.b(false);
        } else {
            this.ab.a(str);
            this.ab.b(false);
        }
        if (this.aD.equals(str)) {
            return false;
        }
        boolean z3 = z && (b("neon-2020.cube.rgb.bin", this.aD, str) || b(FilterPackageUtil.PORTRAIT4_1, this.aD, str) || b(FilterPackageUtil.PORTRAIT4_3, this.aD, str));
        if (z && b("portrait_retention", this.aD, str)) {
            z2 = true;
        }
        this.aD = str;
        if (!Util.p() && z3 && this.W != null) {
            this.W.u(fa());
            this.W.a((f.c) null);
        }
        if (z2 && !this.t) {
            b(true, "portrait_retention".equals(this.aD));
        }
        return z3;
    }

    private void fM() {
        if (!this.t && this.aa != null) {
            this.aB = this.aa.getInt("key_portrait_new_style_index", g.f4385a);
        }
    }

    private boolean b(String str, String str2, String str3) {
        return (!str.equals(str2) && str.equals(str3)) || (str.equals(str2) && !str.equals(str3));
    }

    private boolean fN() {
        return fa() || fb() || fh();
    }

    public boolean fa() {
        return "neon-2020.cube.rgb.bin".equals(this.aD);
    }

    public boolean fb() {
        return "portrait_streamer".equals(this.aD);
    }

    public boolean fh() {
        return "portrait_retention".equals(this.aD);
    }

    public String b() {
        if ("portrait_streamer".equals(ce())) {
            return ApsConstant.FEATURE_STREAMER_PORTRAIT;
        }
        return null;
    }

    public float fC() {
        return CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_PORTRAIT_ZOOM_VALUE_DEFAULT);
    }

    public boolean fD() {
        return Float.compare(2.0f, fC()) == 0;
    }

    public void A(String str) {
        if (this.aa != null) {
            if (f("pref_portrait_half_body_key")) {
                this.O = true;
                this.aa.edit().putString("pref_portrait_half_body_key", str).apply();
                this.O = false;
            }
            if (f("pref_portrait_half_body_remosaic_key")) {
                this.O = true;
                this.aa.edit().putString("pref_portrait_half_body_remosaic_key", str).apply();
                this.O = false;
            }
        }
    }
}
