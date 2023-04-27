package com.oppo.camera.s;

import android.app.Activity;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.util.Size;
import android.view.animation.Animation;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.e.a;
import com.oppo.camera.e.b;
import com.oppo.camera.f.c;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.s.e;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.HashMap;
import java.util.List;

/* compiled from: StarryMode */
public class d extends a {
    private static final int at = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STARRY_MODE_PROCESS_TIME);
    private static long au = ((long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STARRY_MODE_CAPTURE_EXPOSURETIME));
    private static int av = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STARRY_MODE_CAPTURE_ISO);
    private long aw = 0;
    /* access modifiers changed from: private */
    public e ax;

    /* access modifiers changed from: protected */
    public boolean J() {
        return true;
    }

    public String a() {
        return ApsConstant.CAPTURE_MODE_STARRY;
    }

    public boolean aR() {
        return false;
    }

    public int c() {
        return 32936;
    }

    public boolean cW() {
        return false;
    }

    public boolean ej() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean ek() {
        return true;
    }

    public boolean ff() {
        return true;
    }

    public d(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public void s() {
        if (this.ax == null) {
            this.ax = new e(this.Z, this.Y, new e.a() {
                public void a() {
                    d.this.ax.a(d.this.o());
                    d.this.X.D();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void u() {
        com.oppo.camera.e.a("StarryMode", "onBeforePreview");
    }

    public void f(boolean z) {
        this.W.b(com.oppo.camera.f.a.a(this.X.am()).m());
        this.ax.a(this.X.h());
        super.f(z);
    }

    /* access modifiers changed from: protected */
    public boolean a(com.oppo.camera.f.d dVar) {
        com.oppo.camera.e.a("StarryMode", "onBeforeSnapping");
        if (ah() > 0) {
            F(ah());
        }
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                d.this.X.a((Animation.AnimationListener) null);
            }
        });
        this.ax.a(this.X.h());
        this.ax.a(this.aw + ((long) at));
        if (this.W != null) {
            this.W.e(true);
            this.W.a(true, false);
        }
        return true;
    }

    public boolean aM() {
        this.X.c(0);
        return super.aM();
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        if (this.Y.l() != 3) {
            return false;
        }
        com.oppo.camera.e.b("StarryMode", "onStopTakePicture");
        this.W.h();
        this.W.e(false);
        this.W.a(false, false);
        F(0);
        this.ax.b();
        this.ax.a(o());
        this.X.S();
        this.v = false;
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        this.X.aC();
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (d.this.ax != null) {
                    d.this.ax.b();
                    if (d.this.Y.l() == 4) {
                        d.this.ax.a(d.this.o());
                    }
                }
            }
        });
        if (this.W != null) {
            this.W.e(false);
            this.W.a(false, false);
            this.W.a((f.c) null);
        }
    }

    private void F(int i) {
        if (this.W != null) {
            this.W.w(i);
            this.W.a((f.c) null);
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        com.oppo.camera.e.a("StarryMode", "onPause");
        this.ax.a();
    }

    /* access modifiers changed from: protected */
    public void q() {
        com.oppo.camera.e.a("StarryMode", "OnStop");
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("StarryMode", "onDeInitCameraMode");
        this.ax.a();
    }

    /* access modifiers changed from: protected */
    public void r() {
        com.oppo.camera.e.a("StarryMode", "onDestroy");
        e eVar = this.ax;
        if (eVar != null) {
            eVar.c();
            this.ax = null;
        }
    }

    public boolean f(String str) {
        if ("pref_camera_pi_ai_mode_key".equals(str) || "pref_manual_exposure_key".equals(str) || "pref_camera_tap_shutter_key".equals(str) || "pref_continuous_focus_key".equals(str)) {
            return false;
        }
        if ("pref_support_raw_post_process".equals(str) || "key_support_update_thumbnail_user_picture".equals(str)) {
            return true;
        }
        if ("pref_support_switch_camera".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO);
        }
        if ("pref_zoom_key".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_STARRY_MODE_ZOOM_SUPPORT);
        }
        if ("pref_camera_slogan_key".equals(str)) {
            return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_WATERMARK);
        }
        if (!CameraFunction.SAT_CAMERA.equalsIgnoreCase(str)) {
            return super.f(str);
        }
        if (this.t || !com.oppo.camera.f.a.f() || this.X == null || !this.X.j() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STARRY_MODE_SUPPORT_PREVERSION)) {
            return false;
        }
        return true;
    }

    public boolean d(String str) {
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_setting_key".equals(str) || "pref_camera_photo_ratio_key".equals(str)) {
            return true;
        }
        return super.d(str);
    }

    public void a(ApsTotalResult apsTotalResult) {
        super.a(apsTotalResult);
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            com.oppo.camera.e.e("StarryMode", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
        } else if (!this.v) {
            a(apsTotalResult.getTotalResult());
        }
    }

    private void a(CaptureResult captureResult) {
        long b2 = b(captureResult);
        if (b2 <= 0) {
            this.aw = au * ((long) C());
        } else {
            this.aw = b2 / 1000000;
        }
    }

    private long b(CaptureResult captureResult) {
        Object a2;
        if (captureResult == null || (a2 = c.a(captureResult, c.aW)) == null) {
            return -1;
        }
        return ((long[]) a2)[0];
    }

    public ab dl() {
        ab dl = super.dl();
        dl.m(true);
        dl.s(true);
        return dl;
    }

    public int aS() {
        return Util.p() ? 32 : 0;
    }

    public boolean ec() {
        return Util.p() && f("pref_support_raw_post_process");
    }

    /* access modifiers changed from: protected */
    public void a(com.oppo.camera.f.d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STARRY_MODE_SUPPORT_PREVERSION)) {
            super.a(dVar, builder, hashMap, i);
        } else if (d.a.CAPTURE_REPROCESS != dVar.a()) {
            super.a(dVar, builder, hashMap, i);
        } else {
            builder.addTarget(hashMap.get("type_main_preview_frame").a());
        }
    }

    public Size f(j jVar) {
        List<Size> configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_BACK_NIGHT_RAW_PICTURE_SIZE);
        Size size = (configSizeListValue == null || configSizeListValue.size() == 0) ? null : configSizeListValue.get(0);
        if (size != null) {
            return size;
        }
        return super.f(jVar);
    }

    public void a(Image image, TotalCaptureResult totalCaptureResult, Rect rect, com.oppo.camera.f.d dVar) {
        super.a(image, totalCaptureResult, a(rect), dVar);
    }

    public void a(CaptureRequest.Builder builder, int i, int i2, String[] strArr) {
        if (!Util.p() && builder != null) {
            com.oppo.camera.e.b("StarryMode", "onCaptureRequestBuilderUpdate, index: " + i2 + ", pictureNum: " + i);
            builder.set(c.at, 0);
            builder.set(c.au, new int[]{10});
            builder.set(CaptureRequest.FLASH_MODE, 0);
            builder.set(CaptureRequest.CONTROL_AE_MODE, 0);
            builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(au * 1000000));
            builder.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(av));
        }
    }

    public boolean r(String str) {
        if ("type_tuning_data_raw".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return false;
        }
        if ("type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STARRY_MODE_SUPPORT_PREVERSION);
        }
        return super.r(str);
    }

    private Rect a(Rect rect) {
        List<Size> configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_BACK_NIGHT_RAW_PICTURE_SIZE);
        Size size = (configSizeListValue == null || configSizeListValue.size() == 0) ? null : configSizeListValue.get(0);
        Rect d = this.W.e().d();
        if (d == null || rect == null || rect.width() <= 0 || rect.height() <= 0 || size == null) {
            return rect;
        }
        if (size.getWidth() == rect.width() && size.getHeight() == rect.height()) {
            com.oppo.camera.e.a("StarryMode", "calculateCropRect, not need cropRect");
            return null;
        }
        float width = ((float) d.width()) / (((float) size.getWidth()) * 1.0f);
        float height = ((float) d.height()) / (((float) size.getHeight()) * 1.0f);
        Rect rect2 = new Rect();
        rect2.set((int) (((float) rect.left) * width), (int) (((float) rect.top) * height), (int) (((float) rect.right) * width), (int) (((float) rect.bottom) * height));
        com.oppo.camera.e.a("StarryMode", "calculateCropRect, newCropRect: (" + rect2.left + ", " + rect2.top + ", " + rect2.right + ", " + rect2.bottom + "), scaleW: " + width + ", scaleH: " + height);
        return rect2;
    }
}
