package com.oppo.camera.j;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import com.oppo.camera.Camera;
import com.oppo.camera.R;
import com.oppo.camera.aps.ApsAdapterConstant;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e.b;
import com.oppo.camera.e.u;
import com.oppo.camera.f.a;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.n;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.ReminderMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.k;
import com.oppo.camera.util.Util;
import java.util.Arrays;

/* compiled from: MovieMode */
public class t extends u {
    /* access modifiers changed from: private */
    public a aT = null;
    private n aU = null;
    private int aV = 1920;
    private int aW = 1080;
    private int aX = 1080;
    private int aY = 1920;

    public String a() {
        return "movie";
    }

    public boolean cX() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public boolean d(String str) {
        return false;
    }

    public void dc() {
    }

    /* renamed from: do  reason: not valid java name */
    public long m10do() {
        return 128;
    }

    /* access modifiers changed from: protected */
    public String dq() {
        return "pref_film_video_guide_line";
    }

    public boolean f() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int fF() {
        return 30;
    }

    public int fi() {
        return R.anim.gallery_movie_mode_in;
    }

    public boolean fr() {
        return true;
    }

    public String ga() {
        return "H264";
    }

    /* access modifiers changed from: protected */
    public boolean gs() {
        return true;
    }

    public boolean k() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public t(Activity activity, b bVar, e eVar, com.oppo.camera.ui.preview.a.n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public boolean en() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MOVIE_DEFAULT_VIDEO_FRAME_RECORD_SUPPORT);
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("FilmVideoMode", "onInitCameraMode");
        if (this.aT == null) {
            if (f(CameraFunction.MOVIE_MODE_V2)) {
                this.aT = new s(this.Z, this.W, this.X, this.ac);
            } else {
                this.aT = new r(this.Z, this.W, this.X, this.ac);
            }
        }
        if (f("pref_film_video_histogram")) {
            gy();
        }
        if (this.Y != null) {
            fL();
            this.Y.X();
            this.Y.u(true);
            this.Y.Y();
            this.Y.D(true);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && TextUtils.isEmpty(this.aa.getString("pref_switch_camera_bar_key", ""))) {
            this.aa.edit().putString("pref_switch_camera_bar_key", "camera_ultra_wide").apply();
        }
        super.s();
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("FilmVideoMode", "onDeInitCameraMode");
        a aVar = this.aT;
        if (aVar != null) {
            aVar.x();
        }
        this.Y.Y();
        if (this.aT != null) {
            this.Y.F();
            this.aT.a(this.ac);
            this.Y.W();
            this.Y.a(false, true, true);
            this.Y.ae();
        }
        n nVar = this.aU;
        if (nVar != null) {
            nVar.d();
        }
        super.t();
    }

    public boolean f(String str) {
        if ("pref_support_switch_camera".equals(str) || "pref_zoom_key".equals(str) || "pref_manual_exposure_key".equals(str) || "key_setting_menu".equals(str) || "pref_support_recording_capture".equals(str) || "key_setting_support".equals(str) || "key_support_share_edit_thumb".equals(str)) {
            return false;
        }
        if ("key_support_gimbal_change".equals(str) || "pref_switch_camera_bar_key".equals(str) || "key_full_screen_center_support".equals(str)) {
            return true;
        }
        if ("pref_camera_film_mode_key".equals(str)) {
            return !this.t;
        }
        if (CameraFunction.MOVIE_MODE_V2.equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MOVIE_MODE_V2);
        }
        if ("pref_film_video_histogram".equals(str)) {
            return f(CameraFunction.MOVIE_MODE_V2);
        }
        if ("pref_camera_video_slogan_key".equals(str)) {
            return f(CameraFunction.MOVIE_MODE_V2);
        }
        if ("pref_film_video_log".equals(str)) {
            if (!f(CameraFunction.MOVIE_MODE_V2) || !f("pref_10bits_heic_encode_key")) {
                return false;
            }
            return true;
        } else if (!"pref_10bits_heic_encode_key".equals(str)) {
            return super.f(str);
        } else {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT) || this.t) {
                return false;
            }
            return true;
        }
    }

    public int c() {
        return fR() ? 32932 : 32931;
    }

    public String dk() {
        if (f(CameraFunction.MOVIE_MODE_V2)) {
            return fS() ? "4K" : "1080P";
        }
        return "video_size_1080p";
    }

    public String b() {
        return (!AlgoSwitchConfig.getSupportCameraFeature(ApsConstant.FEATURE_REC_MOVIE_NO_EIS, this.n) || fR()) ? "movie" : ApsConstant.FEATURE_REC_MOVIE_NO_EIS;
    }

    public Size e(j jVar) {
        fN();
        return new Size(this.aV, this.aW);
    }

    private void fN() {
        Size b2 = Util.b(a.a(this.n).a(), 2.3333333333333335d);
        if (b2 != null) {
            this.aV = b2.getWidth();
            this.aW = b2.getHeight();
            this.aX = this.aW;
        }
        com.oppo.camera.e.a("FilmVideoMode", "initMovieSize, mSizeWidth: " + this.aV + ", mSizeHeight: " + this.aW + ", mDisplayWidth: " + this.aX + ", mDisplayHeight: " + this.aY);
    }

    public String fZ() {
        return (!f("pref_film_video_log") || !fT()) ? "H264" : "H265";
    }

    /* access modifiers changed from: protected */
    public void u() {
        if (this.ab != null) {
            this.ab.j(true);
            this.g = ((float) this.aX) / ((float) Util.E());
            this.ab.d(this.g);
        }
        if (this.Y != null) {
            this.Y.a(false, true, true);
        }
        a aVar = this.aT;
        if (aVar != null) {
            aVar.u();
            if (!"camera_ultra_wide".equals(this.aa.getString("pref_switch_camera_bar_key", "camera_main")) || this.W == null || this.W.e() == null || this.W.e().s()) {
                this.aT.a(3, true);
            } else {
                this.aT.a(3, false);
            }
        }
        super.u();
    }

    public void f(boolean z) {
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                t.this.Y.k(t.this.aa != null && t.this.aa.getString("pref_film_video_guide_line", "off").equals("grid"));
            }
        });
        a aVar = this.aT;
        if (aVar != null) {
            aVar.v();
        }
        super.f(z);
    }

    public void a(ApsTotalResult apsTotalResult) {
        a aVar;
        super.a(apsTotalResult);
        if (this.A && (aVar = this.aT) != null) {
            aVar.a(apsTotalResult);
        }
    }

    public boolean r(String str) {
        if ("type_still_capture_yuv_main".equals(str)) {
            return false;
        }
        if (!"type_video_frame".equals(str)) {
            return super.r(str);
        }
        if (!f("pref_camera_video_slogan_key") || !gi()) {
            return false;
        }
        return true;
    }

    public void fL() {
        if (this.aT != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    t.this.aT.a(a.f());
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        a aVar = this.aT;
        if (aVar != null) {
            aVar.q();
        }
        if (this.Y != null) {
            this.Y.F();
        }
        super.p();
    }

    /* access modifiers changed from: protected */
    public void gn() {
        super.gn();
        if (Util.p()) {
            this.ax.videoFrameWidth = go().getWidth();
            this.ax.videoFrameHeight = go().getHeight();
        }
    }

    public Size go() {
        int i;
        int i2;
        if (!f(CameraFunction.MOVIE_MODE_V2)) {
            return e((j) null);
        }
        if (fS()) {
            i2 = 3840;
            i = 1644;
        } else {
            i2 = 2376;
            i = 1018;
        }
        return new Size(i2, i);
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        if ("pref_film_video_guide_line".equals(str) && this.Y != null && this.aa != null) {
            this.Y.k(this.aa.getString("pref_film_video_guide_line", "off").equals("grid"));
        } else if ("pref_camera_film_mode_key".equals(str) && this.Y != null) {
            String bu = bu();
            if (Camera.m || Camera.l) {
                if (!"off".equals(bu)) {
                    if (Camera.m) {
                        this.Y.a((int) R.string.camera_high_temperature_flash_disable, -1, true, false, false);
                        b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_FLASH);
                    } else if (Camera.l) {
                        this.Y.a((int) R.string.camera_low_battery_flash_disable, -1, true, false, false);
                        b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_FLASH);
                    }
                    if (this.aa != null) {
                        SharedPreferences.Editor edit = this.aa.edit();
                        edit.putString("pref_camera_film_mode_key", "off");
                        edit.apply();
                    }
                } else {
                    a aVar = this.aT;
                    if (aVar != null) {
                        aVar.m();
                    }
                }
            } else if (this.W != null) {
                this.W.a(bu);
                this.W.a((f.c) null);
            }
            cP();
        } else if ("pref_film_video_histogram".equals(str) && f("pref_film_video_histogram") && this.aa != null && this.aU != null) {
            if (this.aa.getString("pref_film_video_histogram", "off").equals("on")) {
                this.aU.a();
            } else {
                this.aU.c();
            }
        }
        super.a(sharedPreferences, str);
    }

    public void bh() {
        this.Y.a(new c(5, "button_color_inside_red", "button_shape_ring_none", 1));
        a aVar = this.aT;
        if (aVar != null) {
            aVar.n();
        }
        super.bh();
    }

    public void bi() {
        if (fU()) {
            cP();
        }
        super.bi();
    }

    /* access modifiers changed from: protected */
    public void G(boolean z) {
        a aVar = this.aT;
        if (aVar != null) {
            aVar.o();
        }
        super.G(z);
        if (fU()) {
            cP();
        }
    }

    public void bj() {
        this.Y.a(new c(6, "button_color_inside_red", "button_shape_ring_none", 1));
        super.bj();
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        a aVar = this.aT;
        if (aVar != null) {
            aVar.p();
        }
        n nVar = this.aU;
        if (nVar != null) {
            nVar.b();
        }
        super.a(z);
    }

    /* access modifiers changed from: protected */
    public void r() {
        a aVar = this.aT;
        if (aVar != null) {
            aVar.t();
        }
        n nVar = this.aU;
        if (nVar != null) {
            nVar.d();
            this.aU = null;
        }
        super.r();
    }

    public boolean b(MotionEvent motionEvent) {
        if (this.aT == null) {
            return false;
        }
        int actionIndex = motionEvent.getActionIndex();
        int x = (int) (((double) motionEvent.getX(actionIndex)) + 0.5d);
        int y = (int) (((double) motionEvent.getY(actionIndex)) + 0.5d);
        Rect rect = new Rect();
        this.Y.i().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        this.aT.r();
        if (b(x, y)) {
            this.aT.s();
        }
        return super.b(motionEvent);
    }

    public void cP() {
        if (this.Y == null) {
            return;
        }
        if (fU()) {
            this.Y.a(-1, R.drawable.torch_hint_icon, false, true, false, false, true, true, ApsAdapterConstant.LOG_INTERVAL);
        } else {
            this.Y.a(false, true, true);
        }
    }

    /* access modifiers changed from: protected */
    public boolean fC() {
        if (!Util.p()) {
            return false;
        }
        byte[] k = this.W.e().k();
        com.oppo.camera.e.a("FilmVideoMode", "isQualcommEndOfStreamNeed, endOfStreamValue: " + Arrays.toString(k));
        if (k == null || k.length <= 0) {
            return false;
        }
        return true;
    }

    private boolean fR() {
        return this.aa != null && this.aa.getString("pref_film_video_eis_menu", "on").equals("on");
    }

    private boolean fS() {
        return this.aa != null && this.aa.getString("pref_film_video_size_4k", "on").equals("on");
    }

    private boolean fT() {
        return this.aa != null && this.aa.getString("pref_film_video_log", "off").equals("on");
    }

    private boolean fU() {
        return this.aa != null && this.aa.getString("pref_camera_film_mode_key", "off").equals("torch");
    }

    private boolean gx() {
        return this.aa != null && this.aa.getString("pref_film_video_histogram", "off").equals("on");
    }

    public int fk() {
        return this.aX;
    }

    public boolean b(int i, int i2) {
        a aVar = this.aT;
        return aVar != null && aVar.a(i, i2, f("pref_manual_exposure_key"));
    }

    public int bt() {
        if (this.aa == null || !MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(this.aa.getString("pref_film_mode_focus", MenuClickMsgData.VALUE_PROFESSION_AUTO))) {
            return 0;
        }
        return super.bt();
    }

    public void B(boolean z) {
        a aVar = this.aT;
        if (aVar != null) {
            aVar.y();
        }
    }

    public k l() {
        fN();
        int E = Util.E();
        int C = Util.C();
        int i = this.aX;
        int i2 = (E - i) / 2;
        return new k().a(new Rect(i2, 0, i + i2, C + 0), (float) this.Z.getResources().getDimensionPixelSize(R.dimen.movie_mode_preview_corners_radius));
    }

    public boolean d(MotionEvent motionEvent) {
        a aVar = this.aT;
        if (aVar != null) {
            return aVar.a(motionEvent);
        }
        return super.d(motionEvent);
    }

    public boolean cM() {
        return f("pref_film_video_log") && fT();
    }

    public int y(String str) {
        if ((str.equals("type_main_preview_frame") || str.equals("type_video_frame")) && cM()) {
            return 34;
        }
        return super.y(str);
    }

    /* access modifiers changed from: protected */
    public boolean ep() {
        if (!f("pref_camera_video_slogan_key") || !gi()) {
            return super.ep();
        }
        return !eo();
    }

    /* access modifiers changed from: protected */
    public ImageCategory.ItemInfoType eR() {
        return gq() ? this.aH ? ImageCategory.ItemInfoType.VIDEO : ImageCategory.ItemInfoType.PREVIEW : (!dO() || en() || !r("type_video_frame")) ? ImageCategory.ItemInfoType.PREVIEW : ImageCategory.ItemInfoType.VIDEO;
    }

    public boolean dw() {
        return f("pref_film_video_histogram") && gx();
    }

    private void gy() {
        if (this.aU == null) {
            this.aU = new n(this.Z, this.ac);
        }
        Size size = new Size(this.aV, this.aW);
        this.aU.a(new Size(size.getWidth() / 3, size.getHeight() / 3));
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        a aVar;
        if ((dcsMsgData instanceof VideoRecordMsgData) && (aVar = this.aT) != null) {
            aVar.a((VideoRecordMsgData) dcsMsgData);
        }
        return dcsMsgData;
    }

    public void a(byte[] bArr) {
        if (this.aU != null && dw()) {
            this.aU.a(bArr);
        }
    }
}
