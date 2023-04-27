package com.oppo.camera.s;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Size;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import com.oppo.camera.Camera;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.aps.service.ApsAdapterListener;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.s.a;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.List;

/* compiled from: StarVideoMode */
public class b extends com.oppo.camera.e.a implements a.C0094a {
    private int aA;
    private int aB;
    private long aC;
    private boolean aD;
    private d aE;
    private ApsAdapterDecision.DecisionResult aF;
    private f.a aG;
    private ApsAdapterListener.CaptureCallback aH;
    private ValueAnimator aI;
    private a aJ;
    private HandlerThread at;
    private Handler au;
    private c av;
    private a aw;
    private int ax;
    private int ay;
    private int az;

    public int C() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public boolean J() {
        return true;
    }

    public String a() {
        return ApsConstant.REC_MODE_STAR_VIDEO;
    }

    public void a(byte[] bArr, int i, int i2, int i3, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
    }

    public int c() {
        return 32936;
    }

    public boolean ej() {
        return true;
    }

    public boolean ff() {
        return true;
    }

    public boolean fg() {
        return true;
    }

    public b(Activity activity, com.oppo.camera.e.b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
        this.at = null;
        this.au = null;
        this.av = null;
        this.aw = null;
        this.ax = 0;
        this.ay = 0;
        this.az = 0;
        this.aA = 3;
        this.aB = 0;
        this.aC = 0;
        this.aD = false;
        this.aE = null;
        this.aF = null;
        this.aG = null;
        this.aH = null;
        this.aI = null;
        this.aJ = null;
        this.aw = new a(this.Z.getApplicationContext(), this.X, this.Y, this.J);
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.c("StarVideoMode", "onInitCameraMode");
        this.av = new c(this.Z, this.aa, this.Y);
        this.at = new HandlerThread("StarVideoHandler");
        this.at.start();
        this.au = new Handler(this.at.getLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    b.this.fE();
                } else if (i == 2) {
                    b bVar = b.this;
                    bVar.a(bVar.Z);
                } else if (i == 3) {
                    b.this.fO();
                } else if (i == 4) {
                    b.this.fP();
                } else if (i == 5) {
                    b.this.fN();
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        if (3 == this.aA) {
            return false;
        }
        fL();
        return true;
    }

    /* access modifiers changed from: protected */
    public void u() {
        this.aw.a(this.n);
    }

    public void f(boolean z) {
        this.W.b(com.oppo.camera.f.a.a(this.X.am()).m());
        this.av.a();
        super.f(z);
    }

    public void p(boolean z) {
        if (!this.y && Camera.l && !fH()) {
            fJ();
            fL();
        }
    }

    public void e(int i) {
        super.e(i);
        c cVar = this.av;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    private int fC() {
        return super.C();
    }

    private boolean fD() {
        return this.ay >= fC();
    }

    /* access modifiers changed from: private */
    public void fE() {
        d dVar;
        com.oppo.camera.e.c("StarVideoMode", "handleBurstCaptureMessage, mNightScene: " + this.aB);
        int i = this.aB;
        if (i > 0) {
            G(i);
        }
        ApsAdapterListener.CaptureCallback captureCallback = this.aH;
        if (captureCallback != null && (dVar = this.aE) != null) {
            a(this.ax, dVar, this.aG, captureCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i, d dVar, f.a aVar, ApsAdapterListener.CaptureCallback captureCallback) {
        if (this.ay == 0) {
            synchronized (this.i) {
                this.aF = this.af;
            }
        }
        this.aD = fG() <= 17000;
        dVar.af = this.aD ? -1 : this.ay;
        dVar.ag = 17;
        super.a(i, dVar, aVar, captureCallback);
        this.ax = i;
        this.aE = super.b(this.aF);
        this.aG = aVar;
        this.aH = captureCallback;
        this.ah = 0;
        com.oppo.camera.e.c("StarVideoMode", "burstCapture, mReceivedRawNum: " + this.ay + ", mbLastCaptureRequest: " + this.aD);
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        this.aB = ah();
        int i = this.aB;
        if (i > 0) {
            G(i);
        }
        return fK();
    }

    public boolean aM() {
        this.X.c(4);
        return super.aM();
    }

    /* access modifiers changed from: protected */
    public void p() {
        com.oppo.camera.e.a("StarVideoMode", "onPause");
        this.av.c(false);
        this.au.removeMessages(1);
        this.au.removeMessages(3);
        this.au.removeMessages(5);
        this.au.removeMessages(2);
        fL();
        if (this.X != null) {
            this.X.Q();
            this.Y.b((int) R.string.camera_scene_star_video_mode_fixed_tips);
        }
        this.aG = null;
        this.aH = null;
        this.aF = null;
        this.aE = null;
    }

    /* access modifiers changed from: protected */
    public void q() {
        com.oppo.camera.e.a("StarVideoMode", "OnStop");
    }

    public boolean au() {
        com.oppo.camera.e.c("StarVideoMode", "onBackPressed, mRecordingStatus: " + this.aA);
        if (3 == this.aA) {
            return super.au();
        }
        fL();
        return true;
    }

    private void fF() {
        a aVar = this.aw;
        if (aVar != null) {
            aVar.a((a.C0094a) null);
        }
        ValueAnimator valueAnimator = this.aI;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.aI.removeAllUpdateListeners();
            this.aI = null;
            this.aJ = null;
        }
        HandlerThread handlerThread = this.at;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.at = null;
            this.au = null;
        }
        c cVar = this.av;
        if (cVar != null) {
            cVar.c();
            this.av = null;
        }
        this.aE = null;
        this.aF = null;
        this.aG = null;
        this.aH = null;
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("StarVideoMode", "onDeInitCameraMode");
        if (this.Y != null) {
            this.Y.b((int) R.string.camera_scene_star_video_mode_fixed_tips);
        }
        c cVar = this.av;
        if (cVar != null) {
            cVar.c(false);
        }
        fF();
    }

    /* access modifiers changed from: protected */
    public void r() {
        com.oppo.camera.e.a("StarVideoMode", "onDestroy");
        fF();
    }

    public boolean f(String str) {
        if ("pref_camera_pi_ai_mode_key".equals(str) || "pref_support_capture_preview".equals(str) || "pref_manual_exposure_key".equals(str) || "pref_camera_tap_shutter_key".equals(str) || "pref_continuous_focus_key".equals(str)) {
            return false;
        }
        if ("pref_support_raw_post_process".equals(str) || "pref_camera_slogan_key".equals(str) || "pref_support_switch_camera".equals(str) || "key_support_update_thumbnail_user_picture".equals(str)) {
            return true;
        }
        if ("pref_zoom_key".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_STARRY_MODE_ZOOM_SUPPORT);
        }
        return super.f(str);
    }

    public boolean d(String str) {
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_setting_key".equals(str)) {
            return true;
        }
        return super.d(str);
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

    public Size f(j jVar) {
        List<Size> configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_BACK_NIGHT_RAW_PICTURE_SIZE);
        Size size = (configSizeListValue == null || configSizeListValue.size() == 0) ? null : configSizeListValue.get(0);
        if (size != null) {
            return size;
        }
        return super.f(jVar);
    }

    public Size d(j jVar) {
        a aVar = this.aw;
        if (aVar != null) {
            return aVar.b();
        }
        return super.d(jVar);
    }

    public boolean a(ApsResult apsResult, ApsCameraRequestTag apsCameraRequestTag) {
        com.oppo.camera.e.c("StarVideoMode", "onHeicReceived, mReceivedRawNum: " + this.ay + ", apsRequestTag: " + apsCameraRequestTag);
        if (apsCameraRequestTag == null || !a().equals(((d) apsCameraRequestTag.mTag).u)) {
            return super.a(apsResult, apsCameraRequestTag);
        }
        if (fD()) {
            this.az++;
            this.aw.a(apsResult.mCopyBuffer);
            com.oppo.camera.e.c("StarVideoMode", "onHeicReceived, mReceivedYuvImageNum: " + this.az);
        }
        fI();
        return true;
    }

    public void a(Image image, TotalCaptureResult totalCaptureResult, Rect rect, d dVar) {
        super.a(image, totalCaptureResult, a(rect), dVar);
    }

    public void a(CaptureRequest captureRequest) {
        com.oppo.camera.e.e("StarVideoMode", "onCaptureFailed");
        fL();
        super.a(captureRequest);
    }

    public void a(ImageReader imageReader) {
        this.ay++;
        com.oppo.camera.e.c("StarVideoMode", "onRawImageReceived, mReceivedRawNum: " + this.ay + ", num: " + fC());
    }

    public boolean a(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo) {
        com.oppo.camera.e.c("StarVideoMode", "onFinishAddFrame");
        if (imageItemInfo == null || imageItemInfo.mImageBuffer == null || ((Integer) imageItemInfo.get(ParameterKeys.KEY_IMAGE_ROLE)).intValue() != 0 || !fD()) {
            return super.a(imageItemInfo, metaItemInfo);
        }
        this.aw.a(imageItemInfo.mImageBuffer);
        return true;
    }

    private void G(int i) {
        if (this.W != null) {
            com.oppo.camera.e.c("StarVideoMode", "setNightMode, nightMode: " + i);
            this.W.w(i);
            this.W.a((f.c) null);
        }
    }

    private long fG() {
        int i = this.aa.getInt("pref_star_video_record_total_time_key", 5400000);
        return ((long) i) - (SystemClock.uptimeMillis() - this.aC);
    }

    private boolean fH() {
        int i = this.aA;
        return 4 == i || 3 == i;
    }

    private Rect a(Rect rect) {
        List<Size> configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_BACK_NIGHT_RAW_PICTURE_SIZE);
        Size size = (configSizeListValue == null || configSizeListValue.size() == 0) ? null : configSizeListValue.get(0);
        Rect d = this.W.e().d();
        if (d == null || rect == null || rect.width() <= 0 || rect.height() <= 0 || size == null || (size.getWidth() == rect.width() && size.getHeight() == rect.height())) {
            return rect;
        }
        float width = ((float) d.width()) / (((float) size.getWidth()) * 1.0f);
        float height = ((float) d.height()) / (((float) size.getHeight()) * 1.0f);
        Rect rect2 = new Rect();
        rect2.set((int) (((float) rect.left) * width), (int) (((float) rect.top) * height), (int) (((float) rect.right) * width), (int) (((float) rect.bottom) * height));
        com.oppo.camera.e.a("StarVideoMode", "calculateCropRect, newCropRect: (" + rect2.left + ", " + rect2.top + ", " + rect2.right + ", " + rect2.bottom + "), scaleW: " + width + ", scaleH: " + height);
        return rect2;
    }

    private void fI() {
        com.oppo.camera.e.c("StarVideoMode", "trySendRepeatBurstCaptureMessage, mbLastCaptureRequest: " + this.aD);
        if (this.y || fH() || this.aD) {
            fL();
        } else {
            this.au.sendEmptyMessage(1);
        }
    }

    private void fJ() {
        com.oppo.camera.e.c("StarVideoMode", "showLowBatteryHint");
        if (!this.y && this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.fW();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fW() {
        if (this.Y != null) {
            this.Y.a((int) R.string.camera_star_video_low_battery_rec_disabled, -1, true, false, false);
        }
    }

    private boolean fK() {
        com.oppo.camera.e.c("StarVideoMode", "startRecording, mRecordingStatus: " + this.aA);
        if (Camera.l) {
            fJ();
            return false;
        } else if (3 != this.aA) {
            return false;
        } else {
            this.aA = 2;
            this.az = 0;
            this.ay = 0;
            this.aD = false;
            this.aC = SystemClock.uptimeMillis();
            this.X.a((Animation.AnimationListener) null);
            this.au.removeMessages(3);
            this.au.sendEmptyMessage(3);
            if (this.Z != null) {
                this.Z.runOnUiThread(new Runnable() {
                    public final void run() {
                        b.this.fV();
                    }
                });
            }
            this.W.e(true);
            this.W.a((f.c) null);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fV() {
        this.X.aB();
    }

    private void fL() {
        com.oppo.camera.e.c("StarVideoMode", "stopRecording, mRecordingStatus: " + this.aA);
        Handler handler = this.au;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.W.h();
        if (!fH()) {
            G(0);
            this.W.e(false);
            this.X.S();
            this.aA = 4;
            Handler handler2 = this.au;
            if (handler2 != null) {
                handler2.sendEmptyMessage(4);
            }
        }
    }

    private int fM() {
        a aVar = this.aw;
        if (aVar != null) {
            return aVar.d();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void fN() {
        if (this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.fU();
                }
            });
        }
        Handler handler = this.au;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(5, 1000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fU() {
        if (this.av == null) {
            return;
        }
        if (fG() < 0) {
            this.av.a(true);
        } else {
            this.av.a(fM(), SystemClock.uptimeMillis() - this.aC);
        }
    }

    /* access modifiers changed from: private */
    public void fO() {
        com.oppo.camera.e.c("StarVideoMode", "onStartRecordingMsg, E");
        if (!this.y) {
            this.aw.a((a.C0094a) this);
            this.aw.a();
            this.av.b();
            this.au.removeMessages(5);
            this.au.sendEmptyMessageDelayed(5, 1000);
            this.au.removeMessages(2);
            this.au.sendEmptyMessageDelayed(2, 300000);
            this.aA = 1;
        }
        com.oppo.camera.e.c("StarVideoMode", "onStartRecordingMsg, X");
    }

    /* access modifiers changed from: private */
    public void fP() {
        boolean z;
        com.oppo.camera.e.c("StarVideoMode", "onStopRecordingMsg, E, mbPaused: " + this.y);
        Handler handler = this.au;
        if (handler != null) {
            handler.removeMessages(5);
            this.au.removeMessages(2);
        }
        a aVar = this.aw;
        if (aVar != null) {
            aVar.a((a.C0094a) null);
            z = fM() >= 1;
            this.aw.a(z);
        } else {
            z = false;
        }
        if (this.aI != null) {
            this.Z.runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.fT();
                }
            });
        }
        if (!this.y) {
            this.Z.runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.fS();
                }
            });
            c cVar = this.av;
            if (cVar != null) {
                cVar.a(true, o(), z);
            }
            a((byte[]) null, 0, 0, (String) null, false, false, 0);
        }
        if (this.X != null) {
            this.X.c(5);
        }
        this.aA = 3;
        this.ay = 0;
        com.oppo.camera.e.c("StarVideoMode", "onStopRecordingMsg, X");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fT() {
        this.aI.cancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fS() {
        if (this.X != null) {
            this.X.aC();
            this.X.Q();
        }
    }

    private void fQ() {
        if (this.aI == null) {
            this.aJ = new a(this.Z, this.X.R());
            this.aI = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.aI.setDuration(10000);
            this.aI.addUpdateListener(this.aJ);
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity) {
        if (activity != null) {
            fQ();
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            float f = (float) Settings.System.getInt(activity.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, 20);
            float f2 = (float) 20;
            if (f > f2) {
                this.aJ.a(f, f - f2, f2);
                activity.runOnUiThread(new Runnable() {
                    public final void run() {
                        b.this.fR();
                    }
                });
            }
            com.oppo.camera.e.a("StarVideoMode", "setScreenBrightness, brightness: " + 20 + ", currBrightness: " + f + ", winParams.screenBrightness: " + attributes.screenBrightness);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fR() {
        this.aI.start();
    }

    public void b(Object obj, int i, int i2) {
        com.oppo.camera.e.a("StarVideoMode", "onInfo");
        if (i == 800) {
            if (dN()) {
                fL();
            }
        } else if ((i == 801 || i == 802) && dN()) {
            fL();
        }
    }

    public void a(Object obj, int i, int i2) {
        com.oppo.camera.e.a("StarVideoMode", "onError, what: " + i + ", extra: " + i2);
        if ((i == 1100 || i == 1101) && !dP()) {
            fL();
        }
    }

    public void F(int i) {
        com.oppo.camera.e.a("StarVideoMode", "onException, exceptionCode: " + i);
        if (1 == i && !dP()) {
            fL();
        }
    }

    /* compiled from: StarVideoMode */
    private class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private float f3601b;
        private float c;
        private float d;
        private Window e;
        private WindowManager.LayoutParams f = this.e.getAttributes();
        private int g;

        public a(Activity activity, int i) {
            this.e = activity.getWindow();
            this.g = i;
        }

        public void a(float f2, float f3, float f4) {
            com.oppo.camera.e.a("StarVideoMode", "setTargetBrightness, targetBrightness: " + f4 + ", deltaBrightness: " + f3);
            this.f3601b = f4;
            this.c = f3;
            this.d = f2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = (this.c * ((Float) valueAnimator.getAnimatedValue()).floatValue()) + this.f3601b;
            float f2 = this.c;
            if (this.d - floatValue >= (20.0f <= f2 ? f2 / 20.0f : 1.0f)) {
                WindowManager.LayoutParams layoutParams = this.f;
                layoutParams.screenBrightness = floatValue / ((float) this.g);
                this.e.setAttributes(layoutParams);
                this.d = floatValue;
            }
        }
    }
}
