package com.oppo.camera.e;

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e.a.a;
import com.oppo.camera.f.c;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.HashMap;
import java.util.List;

/* compiled from: MultiVideoMode */
public class p extends u {
    private boolean aT;
    private a aU;

    public String a() {
        return ApsConstant.CAPTURE_MODE_MULTI_VIDEO;
    }

    /* access modifiers changed from: protected */
    public int aB() {
        return 5;
    }

    public boolean b(int i, int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public String bY() {
        return "pref_multi_video_facebeauty_level_menu";
    }

    public int c() {
        return 32812;
    }

    /* access modifiers changed from: protected */
    public int df() {
        return 40;
    }

    /* access modifiers changed from: protected */
    public boolean en() {
        return true;
    }

    public boolean fe() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public boolean w(int i) {
        return false;
    }

    public p(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
        this.aT = true;
        this.aU = null;
        this.aU = new a(0, 1, 1);
    }

    /* access modifiers changed from: protected */
    public void s() {
        this.aT = true;
        if ("on".equals(this.aa.getString("key_multicamera_type_menu_key", "off"))) {
            this.aa.edit().putString("key_multicamera_type_menu_key", "off").apply();
        }
        super.s();
        com.oppo.camera.gl.b.e.a().a((int) this.Z.getResources().getDimension(R.dimen.multicamera_small_surface_start_margin), (int) this.Z.getResources().getDimension(R.dimen.multicamera_small_surface_top_margin), (int) this.Z.getResources().getDimension(R.dimen.multicamera_small_surface_end_margin), (int) this.Z.getResources().getDimension(R.dimen.multicamera_small_surface_bottom_margin));
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        this.aa.edit().putString("key_multicamera_type_menu_key", "off").apply();
        super.a(z);
    }

    /* access modifiers changed from: protected */
    public void p() {
        super.p();
        if (p("key_bubble_type_multi_video")) {
            this.Y.c(14, true);
        }
    }

    public boolean r(String str) {
        return "type_multi_main_preview_frame".equals(str) || "type_multi_sub_preview_frame".equals(str);
    }

    public Size e(j jVar) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
            return new Size(1920, 1080);
        }
        return new Size(1280, 720);
    }

    public Size a(j jVar, String str) {
        Size size;
        if (str == null) {
            return e(jVar);
        }
        int i = this.aa.getInt("pref_multicamera_show_position_state_key", 1);
        int i2 = this.aa.getInt("pref_multicamera_type_selected_key", 0);
        if (i2 != 0) {
            if (i2 != 1 && i2 != 2) {
                size = null;
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
                size = a(str, i, i2, 1920, 1080);
            } else {
                size = a(str, i, i2, 1280, 720);
            }
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
            size = new Size(960, 1080);
        } else {
            size = new Size(640, 720);
        }
        com.oppo.camera.e.b("MultiVideoMode", "getPreviewSize, surfaceType: " + str + ", previewSize: " + size);
        return size;
    }

    private Size a(String str, int i, int i2, int i3, int i4) {
        j a2 = com.oppo.camera.f.a.a(1);
        List<Size> D = a2 != null ? a2.D() : null;
        if (2 == i2) {
            if ("type_multi_main_preview_frame".equals(str)) {
                if (1 == i) {
                    return new Size(i3, i4);
                }
                return Util.a(D, (int) (((float) i3) / 3.0f), (int) (((float) i4) / 3.0f));
            } else if (!"type_multi_sub_preview_frame".equals(str)) {
                return null;
            } else {
                if (1 == i) {
                    return Util.a(D, (int) (((float) i3) / 3.0f), (int) (((float) i4) / 3.0f));
                }
                return new Size(i3, i4);
            }
        } else if (1 != i2) {
            return null;
        } else {
            if ("type_multi_main_preview_frame".equals(str)) {
                if (1 == i) {
                    return new Size(i3, i4);
                }
                int i5 = (int) (((float) i4) / 2.33f);
                return Util.a(D, i5, i5);
            } else if (!"type_multi_sub_preview_frame".equals(str)) {
                return null;
            } else {
                if (1 != i) {
                    return new Size(i3, i4);
                }
                int i6 = (int) (((float) i4) / 2.33f);
                return Util.a(D, i6, i6);
            }
        }
    }

    public a cN() {
        return this.aU;
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if (hashMap.get("type_multi_main_preview_frame") != null && 1 == i) {
            builder.addTarget(hashMap.get("type_multi_main_preview_frame").a());
        }
        if (hashMap.get("type_multi_sub_preview_frame") != null && 2 == i) {
            builder.addTarget(hashMap.get("type_multi_sub_preview_frame").a());
        }
        try {
            int i2 = 0;
            if (!Util.p()) {
                builder.set(c.aT, new int[]{0, 1});
            }
            if (this.aa.getInt("pref_multicamera_type_selected_key", 0) == 0) {
                builder.set(c.aU, 1);
            } else {
                int i3 = this.aa.getInt("pref_multicamera_show_position_state_key", 1);
                if (1 == i) {
                    CaptureRequest.Key<Integer> key = c.aU;
                    if (1 == i3) {
                        i2 = 1;
                    }
                    builder.set(key, Integer.valueOf(i2));
                } else {
                    CaptureRequest.Key<Integer> key2 = c.aU;
                    if (2 == i3) {
                        i2 = 1;
                    }
                    builder.set(key2, Integer.valueOf(i2));
                }
            }
        } catch (Exception e) {
            com.oppo.camera.e.e("MultiVideoMode", "onRequestBuilderCreated, key: " + c.aT + " is not supported by hal, Exception: " + e);
        }
        super.a(dVar, builder, hashMap, i);
    }

    public boolean d(String str) {
        if ("key_multicamera_type_menu_key".equals(str)) {
            return true;
        }
        return super.d(str);
    }

    public boolean f(String str) {
        if ("pref_camera_videoflashmode_key".equals(str) || "pref_support_switch_camera".equals(str) || "key_multicamera_type_menu_key".equals(str) || "pref_zoom_key".equals(str) || CameraFunction.FACE_BEAUTY_PROCESS.equals(str) || CameraFunction.FACE_BEAUTY_COMMON.equals(str)) {
            return true;
        }
        if ("pref_support_recording_capture".equals(str) || "pref_assist_gradienter".equals(str) || "pref_camera_assistant_line_key".equals(str) || "pref_face_detection_key".equals(str) || "pref_filter_process_key".equals(str)) {
            return false;
        }
        if (CameraFunction.FACE_BEAUTY_PROCESS.equals(str)) {
            return true;
        }
        if (CameraFunction.FACE_SLENDER_PROCESS.equals(str)) {
            return f(CameraFunction.FACE_BEAUTY_PROCESS);
        }
        if ("pref_camera_video_slogan_key".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_SUPPORT);
        }
        return super.f(str);
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        super.a(sharedPreferences, str);
        if ("key_multicamera_type_menu_key".equals(str) && f(str) && sharedPreferences != null) {
            f("on".equals(sharedPreferences.getString("key_multicamera_type_menu_key", this.Z.getString(R.string.camera_multicamera_type_default))), true);
            fN();
        }
    }

    private void f(boolean z, boolean z2) {
        if (this.X != null && this.Y != null) {
            this.Y.i(z, z2);
            if (z) {
                this.X.a((Animation.AnimationListener) null);
                this.Y.a(AnimationUtils.loadAnimation(this.Z, R.anim.mode_title_alpha_out));
                if (this.Y.C()) {
                    this.Y.b(true, true, false);
                }
            } else if (!dM() && !dN() && !dM()) {
                this.Y.a(0, z2);
                if (!this.Y.C()) {
                    this.X.D();
                    this.X.d(true);
                }
            }
        }
    }

    public void bh() {
        this.Y.a(new com.oppo.camera.ui.control.c(5, "button_color_inside_red", "button_shape_ring_none", 1));
        this.X.D();
        this.X.d(true);
        super.bh();
    }

    /* access modifiers changed from: protected */
    public void G(boolean z) {
        this.Y.a(new com.oppo.camera.ui.control.c(6, "button_color_inside_red", "button_shape_ring_none", 1));
        super.G(z);
    }

    public void bi() {
        super.bi();
        f(false, true);
    }

    public void B(boolean z) {
        super.B(z);
        if (this.aa != null) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.remove("key_multicamera_type_menu_key");
            edit.apply();
        }
    }

    /* access modifiers changed from: protected */
    public void u() {
        super.u();
        dd();
        int i = this.aa.getInt("pref_multicamera_type_selected_key", 0);
        int i2 = this.aa.getInt("pref_multicamera_show_position_state_key", 1);
        if (this.Y != null) {
            this.Y.s(i);
            this.Y.H(1 == i2);
            this.Y.I(false);
            if (i != 0) {
                int E = (int) (((float) Util.E()) * (1.0f / (1 == i ? 2.33f : 3.0f)));
                int E2 = (Util.E() - E) - ((int) this.Z.getResources().getDimension(R.dimen.multicamera_small_surface_end_margin));
                int u = Util.u() + ((int) this.Z.getResources().getDimension(R.dimen.multicamera_small_surface_top_margin));
                this.Y.b(E2, u);
                int i3 = (int) (((double) E) * (1 == i ? 1.0d : 1.7777777777777777d));
                this.Y.c(E, i3);
                com.oppo.camera.e.b("MultiVideoMode", "onBeforePreview, state: " + i2 + ", type: " + i + ", smallSurfaceWidth: " + E + ", smallSurfaceHeight: " + i3 + ", x: " + E2 + ", y: " + u);
            }
        }
    }

    public void f(boolean z) {
        super.f(z);
        fN();
        fL();
    }

    private void fL() {
        if (this.Y != null && p("key_bubble_type_multi_video")) {
            this.Y.a((View) null, 14, 0, this.Z.getResources().getDimensionPixelOffset(R.dimen.setting_menu_tip_offset_y));
        }
    }

    private void fN() {
        if (this.Y != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            this.Y.r(this.aa.getInt("pref_multicamera_type_selected_key", 0));
        }
    }

    /* access modifiers changed from: protected */
    public String[] de() {
        return e.f;
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData;
        int i;
        int i2;
        if (!(dcsMsgData instanceof VideoRecordMsgData) || this.aa == null) {
            videoRecordMsgData = null;
        } else {
            videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
            int i3 = this.aa.getInt("pref_multicamera_type_selected_key", 0);
            if (!(this.Y == null || i3 == 0)) {
                videoRecordMsgData.mSubScreenValue = String.valueOf(this.Y.aj());
            }
            if (1 == this.aa.getInt("pref_multicamera_show_position_state_key", 1)) {
                i2 = a(0);
                i = a(1);
            } else {
                i = a(0);
                i2 = a(1);
            }
            videoRecordMsgData.mScreenCompose = "{main: " + i2 + ", sub: " + i + "}";
            videoRecordMsgData.mScreenMode = String.valueOf(i3);
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    /* access modifiers changed from: protected */
    public void eg() {
        if (this.aT && this.Y != null) {
            this.aT = false;
            this.Y.a((int) R.string.camera_mode_multi_video_switch_tip, 0, true, false, false);
        }
    }

    public boolean b(MotionEvent motionEvent) {
        if (this.Y != null && this.Y.ak()) {
            this.Y.al();
        }
        return super.b(motionEvent);
    }

    public void s(String str) {
        if ("key_multicamera_type_menu_key".equals(str) && this.Y.T()) {
            this.Y.a("key_multicamera_type_menu_key", true, (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.Z.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    public ab dl() {
        ab dl = super.dl();
        dl.j(false);
        return dl;
    }
}
