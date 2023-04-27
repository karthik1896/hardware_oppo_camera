package com.oppo.camera.e;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.camera2.CaptureResult;
import android.location.Location;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import com.android.providers.downloads.Downloads;
import com.meicam.sdk.NvsStreamingContext;
import com.oppo.camera.MyApplication;
import com.oppo.camera.R;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.e.a;
import com.oppo.camera.e.v;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.gl.q;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.ReminderMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: VideoMode */
public abstract class u extends a implements v.e, v.f, v.g {
    protected v aA = null;
    protected String aB = VideoRecordMsgData.END_TYPE_NORMAL;
    protected boolean aC = false;
    protected float aD = 0.0f;
    protected int aE = 0;
    protected int aF = 0;
    protected long aG = 0;
    protected boolean aH = false;
    protected int aI = 0;
    protected int aJ = 0;
    protected int aK = 0;
    protected String aL;
    protected String aM;
    protected String aN = "";
    protected Uri aO = null;
    protected ContentValues aP = null;
    protected int aQ = 0;
    protected boolean aR = false;
    protected ParcelFileDescriptor aS = null;
    /* access modifiers changed from: private */
    public final ConditionVariable aT = new ConditionVariable();
    private final ConditionVariable aU = new ConditionVariable();
    private final Object aV = new Object();
    private final Object aW = new Object();
    /* access modifiers changed from: private */
    public Handler aX = null;
    private HandlerThread aY = null;
    private String aZ = null;
    protected Resources at = null;
    protected Handler au = null;
    protected String av = "video_size_1080p";
    protected long aw = 0;
    protected CamcorderProfile ax = null;
    protected Surface ay = null;
    protected Object az = new Object();
    private int bA = 0;
    private String bB = "";
    /* access modifiers changed from: private */
    public boolean bC = false;
    private volatile boolean bD = false;
    /* access modifiers changed from: private */
    public long bE = 0;
    private boolean bF = false;
    private boolean bG = false;
    private boolean bH = false;
    private String ba = "";
    private String bb = "";
    private int bc = 0;
    private int bd = -1;
    private volatile int be = 2;
    private boolean bf = false;
    private boolean bg = false;
    private boolean bh = true;
    private boolean bi = true;
    private boolean bj = false;
    private boolean bk = false;
    private boolean bl = false;
    private long bm = 0;
    private long bn = 0;
    private long bo = 0;
    private AlgoSwitchConfig.PreviewConfig bp = null;
    /* access modifiers changed from: private */
    public AsyncTask bq = null;
    private ValueAnimator br = null;
    private a bs = null;
    private long bt = 0;
    private boolean bu = false;
    private volatile int bv = 0;
    private long bw;
    private long bx;
    private int by = 0;
    private int bz = 0;

    private String J(int i) {
        return i == 2 ? ".mp4" : ".3gp";
    }

    private String K(int i) {
        return i == 2 ? "video/mp4" : "video/3gpp";
    }

    /* access modifiers changed from: protected */
    public void a(v vVar) {
    }

    /* access modifiers changed from: protected */
    public boolean a(long j) {
        return false;
    }

    /* access modifiers changed from: protected */
    public int aB() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public boolean aG() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean bf() {
        return false;
    }

    public boolean br() {
        return false;
    }

    /* access modifiers changed from: protected */
    public String dq() {
        return "pref_camera_line_video";
    }

    /* access modifiers changed from: protected */
    public void e_() {
    }

    public int eb() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public boolean fC() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fE() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int fF() {
        return 30;
    }

    /* access modifiers changed from: protected */
    public Integer fG() {
        return null;
    }

    /* access modifiers changed from: protected */
    public long fM() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean fP() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fQ() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int fY() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void f_() {
    }

    public boolean g() {
        return false;
    }

    public Float gb() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String gc() {
        return "";
    }

    /* access modifiers changed from: protected */
    public boolean gh() {
        return false;
    }

    /* access modifiers changed from: protected */
    public long gm() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean gr() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean gs() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean gt() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int gu() {
        return 1000;
    }

    /* access modifiers changed from: protected */
    public boolean gv() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void gw() {
    }

    public boolean h() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void q() {
    }

    public u(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
        this.at = activity.getApplicationContext().getResources();
        this.au = new c();
        this.bs = new a(activity);
        this.br = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.br.setDuration(10000);
        this.br.addUpdateListener(this.bs);
        fV();
    }

    /* access modifiers changed from: protected */
    public void fV() {
        if (this.aY == null) {
            this.aY = new HandlerThread("CameraRecorder");
            this.aY.start();
            this.aX = new Handler(this.aY.getLooper()) {
                public void handleMessage(Message message) {
                    com.oppo.camera.e.a("VideoMode", "initRecordThread,  what:" + message.what);
                    int i = message.what;
                    if (i == 8) {
                        u.this.Z.runOnUiThread(new Runnable() {
                            public void run() {
                                u.this.gL();
                            }
                        });
                    } else if (i != 12) {
                        switch (i) {
                            case 1:
                                u.this.gz();
                                return;
                            case 2:
                                u.this.gy();
                                return;
                            case 3:
                                u.this.C((String) message.obj);
                                return;
                            case 4:
                                u.this.E((String) message.obj);
                                return;
                            case 5:
                                u.this.G(true);
                                return;
                            case 6:
                                u.this.fD();
                                return;
                            default:
                                return;
                        }
                    } else {
                        com.oppo.camera.e.a("VideoMode", "mRecordSig open");
                        u.this.aT.open();
                    }
                }
            };
        }
    }

    /* access modifiers changed from: protected */
    public boolean fW() {
        if (this.P) {
            return false;
        }
        if (this.aa != null && "torch".equals(this.aa.getString("pref_camera_videoflashmode_key", this.Z.getString(R.string.camera_flash_mode_video_default_value))) && f("pref_camera_videoflashmode_key") && !this.t) {
            return true;
        }
        if (this.aa == null || !"on".equals(this.aa.getString("pref_camera_torch_mode_key", Util.y(this.Z))) || !f(CameraFunction.TORCH_SOFT_LIGHT) || !this.t) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void fX() {
        if (dO() && f("pref_video_eis")) {
            com.oppo.camera.e.a("VideoMode", "releaseEisFrame");
            this.W.t(0);
            if (!Util.p()) {
                this.W.u(0);
            }
            this.W.a((f.c) null);
        }
    }

    /* access modifiers changed from: protected */
    public e.b aN() {
        return new e.b() {
            public void a(long j) {
                if (u.this.bC && j == u.this.bE) {
                    u.this.au.post(new Runnable() {
                        public void run() {
                            u.this.Y.c(true);
                        }
                    });
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void p() {
        com.oppo.camera.e.a("VideoMode", "onPause");
        if (!ee() && Util.p()) {
            fX();
        }
        p(false);
        Handler handler = this.aX;
        if (handler != null) {
            handler.removeMessages(5);
        }
        if (this.W != null && (!r("type_preview_frame") || !cj())) {
            this.W.h(!gv());
        }
        o(false);
        if (this.X != null && !com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode())) {
            this.X.Q();
        }
        if (dP()) {
            this.au.removeCallbacksAndMessages((Object) null);
        }
        synchronized (this.aW) {
            this.aX.removeMessages(6);
            if (fN()) {
                this.aU.block();
            } else {
                this.aU.open();
            }
        }
        this.bl = false;
        G(0);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        com.oppo.camera.e.a("VideoMode", "onResume");
        this.bH = this.X.ay() && !f("key_support_video_thumbnail_simultaneous");
        if (this.bH) {
            com.oppo.camera.ui.control.e.b();
        }
        this.bt = 0;
        this.au.removeMessages(9);
    }

    public int dj() {
        if (this.aa == null || this.t) {
            return Integer.valueOf("30").intValue();
        }
        return Integer.valueOf(this.aa.getString("pref_video_fps_key", "30")).intValue();
    }

    public String fZ() {
        return (this.aa == null || this.Z == null) ? "H264" : this.aa.getString("pref_video_codec_key", this.Z.getString(R.string.camera_video_codec_default_value));
    }

    public String ga() {
        return this.Z.getString(R.string.camera_video_codec_default_value);
    }

    /* access modifiers changed from: protected */
    public void r() {
        com.oppo.camera.e.a("VideoMode", "onDestroy");
        if (dQ()) {
            com.oppo.camera.e.a("VideoMode", "onDestroy, block");
            this.aT.block(5000);
        }
        HandlerThread handlerThread = this.aY;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.aY = null;
        }
        Handler handler = this.au;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.au = null;
        }
        ValueAnimator valueAnimator = this.br;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.br.removeAllUpdateListeners();
            this.br = null;
        }
        if (this.bs != null) {
            this.bs = null;
        }
        synchronized (this.az) {
            if (this.ay != null) {
                this.ay.release();
                this.ay = null;
            }
        }
        this.aO = null;
    }

    /* access modifiers changed from: protected */
    public void s() {
        gp();
        if (this.Y != null) {
            this.Y.c(this.Z.getString(R.string.camera_description_video_shutter_button));
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        if (this.W != null) {
            this.W.t(0);
            if (!Util.p()) {
                this.W.u(0);
            }
        }
    }

    public String b() {
        if (this.z) {
            return null;
        }
        if ("video_size_4kuhd".equals(dk())) {
            return ApsConstant.FEATURE_REC_4KUHD;
        }
        return super.b();
    }

    public com.oppo.camera.ui.control.c o() {
        com.oppo.camera.ui.control.c o = super.o();
        o.b("button_shape_ring_none");
        if (dO()) {
            o.a(2);
            o.a("button_color_inside_none");
            o.b(1);
        } else {
            o.a("button_color_inside_red");
        }
        return o;
    }

    public String fH() {
        return this.Z.getString(R.string.camera_video_size_default);
    }

    /* access modifiers changed from: protected */
    public String gd() {
        return this.aL;
    }

    /* access modifiers changed from: protected */
    public int ge() {
        return this.ax.videoBitRate;
    }

    public int bt() {
        return (!dO() || co()) ? 3 : 1;
    }

    public boolean d(String str) {
        String c2 = com.oppo.camera.entry.b.c(str);
        if ("pref_camera_videoflashmode_key".equals(c2) || "pref_video_filter_menu".equals(c2) || "pref_filter_menu".equals(c2) || "pref_video_super_eis_key".equals(c2)) {
            return f(c2);
        }
        if ("key_ultra_night_video".equals(c2)) {
            return f(CameraFunction.ULTRA_NIGHT_VIDEO);
        }
        if ("key_ai_enhancement_video".equals(c2)) {
            return f(CameraFunction.AI_ENHANCEMENT_VIDEO);
        }
        return super.d(c2);
    }

    /* access modifiers changed from: protected */
    public List<Integer> f(int i) {
        if (f("pref_video_filter_menu")) {
            return 1 == i ? g.o : g.m;
        }
        return super.f(i);
    }

    /* access modifiers changed from: protected */
    public List<String> g(int i) {
        if (f("pref_video_filter_menu")) {
            return 1 == i ? g.n : g.l;
        }
        return super.g(i);
    }

    public boolean c(String str) {
        if ("key_video_hdr".equals(str)) {
            return f(CameraFunction.VIDEO_HDR);
        }
        if ("pref_video_tilt_shift_key".equals(str)) {
            return f(CameraFunction.TILT_SHIFT);
        }
        if ("pref_setting_key".equals(str)) {
            return aa();
        }
        return false;
    }

    public boolean aa() {
        return c("key_video_hdr") || c("key_ultra_night_video");
    }

    public String cg() {
        if (f("pref_video_filter_menu")) {
            return "key_video_filter_index";
        }
        return super.cg();
    }

    public boolean f(String str) {
        if ("pref_assist_gradienter".equals(str) || "pref_camera_line_video".equals(str)) {
            return true;
        }
        if ("pref_continuous_focus_key".equals(str) && dO()) {
            return !dM();
        }
        if ("pref_support_recording_capture".equals(str)) {
            return true;
        }
        if ("key_support_fovc".equals(str)) {
            return Util.p();
        }
        if ("key_support_zsl".equals(str) || "key_support_video_recorder".equals(str)) {
            return false;
        }
        if ("pref_video_filter_menu".equals(str)) {
            return f("pref_filter_process_key");
        }
        if ("pref_filter_menu".equals(str)) {
            return false;
        }
        if (CameraFunction.FILTER_VIGNETTE.equals(str)) {
            return f("pref_video_filter_menu");
        }
        if ("pref_camera_video_slogan_key".equals(str)) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_SUPPORT) || !AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_WATERMARK)) {
                return false;
            }
            return true;
        } else if ("key_support_video_thumbnail_simultaneous".equals(str)) {
            if ("video_size_4kuhd".equals(dk())) {
                return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_THUMBNAIL_SIMULTANEOUS_4K);
            }
            return true;
        } else if ("pref_video_size_key".equals(str) || "pref_video_ratio_key".equals(str) || "pref_video_sound_key".equals(str)) {
            return true;
        } else {
            if ("pref_manual_exposure_key".equals(str) && dz()) {
                return false;
            }
            if ("key_temperature_control_stop_video_recording".equals(str)) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TEMPERATURE_CONTROL_STOP_VIDEO_RECORDING) || this.aa == null || !"on".equals(this.aa.getString("pref_video_super_eis_key", "off"))) {
                    return false;
                }
                return true;
            } else if ("support_video_count_down".equals(str)) {
                return false;
            } else {
                return super.f(str);
            }
        }
    }

    public boolean i(String str) {
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_camera_photo_ratio_key".equals(str)) {
            return false;
        }
        return super.i(str);
    }

    public void bh() {
        if (this.X != null) {
            this.X.E();
        }
        if (this.X != null && f("pref_inertial_zoom_key")) {
            this.X.a(true, false);
        }
        if (this.W != null) {
            if (Util.p()) {
                this.W.t(1);
            } else {
                this.W.u(1);
            }
        }
        this.bC = false;
        this.bF = true;
    }

    public void bj() {
        if (this.Y != null && this.X != null && !this.X.j()) {
            this.Y.b(4, true);
        }
    }

    public void a(ApsTotalResult apsTotalResult) {
        CaptureResult.Key key;
        CaptureResult.Key key2;
        Integer num;
        super.a(apsTotalResult);
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            com.oppo.camera.e.e("VideoMode", "onPreviewCaptureResult, invalid totalResult : " + apsTotalResult);
            return;
        }
        CaptureResult totalResult = apsTotalResult.getTotalResult();
        Object a2 = com.oppo.camera.f.c.a(totalResult, com.oppo.camera.f.c.M);
        Object a3 = com.oppo.camera.f.c.a(totalResult, com.oppo.camera.f.c.ab);
        if (a3 != null) {
            this.bG = ((Integer) a3).intValue() > 0;
        }
        if (a2 != null && (a2 instanceof Integer) && (num = (Integer) a2) != null && this.Z != null && 2 == this.X.h() && (1002 == num.intValue() || 1003 == num.intValue())) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    u.this.X.g();
                }
            });
        }
        this.bA = this.X.ac();
        if (this.bF) {
            this.bF = false;
            if (Util.p()) {
                key2 = com.oppo.camera.f.c.O;
                key = com.oppo.camera.f.c.N;
            } else {
                key2 = com.oppo.camera.f.c.Q;
                key = com.oppo.camera.f.c.aa;
            }
            try {
                if (Util.p()) {
                    float[] fArr = (float[]) totalResult.get(key2);
                    if (fArr == null || fArr.length <= 0) {
                        com.oppo.camera.e.a("VideoMode", "onPreviewCaptureResult, lux value: " + Arrays.toString(fArr));
                    } else {
                        this.aD = fArr[0];
                    }
                } else {
                    int[] iArr = (int[]) totalResult.get(key2);
                    if (iArr == null || iArr.length <= 0) {
                        com.oppo.camera.e.a("VideoMode", "onPreviewCaptureResult, key: " + key2 + ", luxIntValues: " + Arrays.toString(iArr));
                    } else {
                        this.aD = (float) iArr[0];
                    }
                }
                int[] iArr2 = (int[]) totalResult.get(key);
                if (iArr2 == null || iArr2.length <= 0) {
                    com.oppo.camera.e.a("VideoMode", "onPreviewCaptureResult, cct value: " + this.aE);
                } else {
                    this.aE = iArr2[0];
                }
                this.aF = (((Integer) totalResult.get(CaptureResult.SENSOR_SENSITIVITY)).intValue() * ((Integer) totalResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)).intValue()) / 100;
                this.aG = ((Long) totalResult.get(CaptureResult.SENSOR_EXPOSURE_TIME)).longValue();
            } catch (Exception e) {
                com.oppo.camera.e.d("VideoMode", "onPreviewCaptureResult, getValue error.", e);
            }
        }
    }

    public Size a(String str, j jVar) {
        Size a2 = a(b(), str, a.C0080a.INPUT);
        return a2 != null ? a2 : d(jVar);
    }

    public Size d(j jVar) {
        CamcorderProfile n_ = n_();
        if (n_ != null) {
            return new Size(n_.videoFrameWidth, n_.videoFrameHeight);
        }
        return super.d(jVar);
    }

    public boolean au() {
        super.au();
        if (!dO()) {
            return dQ();
        }
        if (dN() && this.X.h() == 1) {
            G(true);
        } else if (dM() && this.bl) {
            G(false);
        }
        com.oppo.camera.e.a("VideoMode", "onBackPressed, isVideoRecording return");
        return true;
    }

    public void o(boolean z) {
        if (dM()) {
            com.oppo.camera.e.a("VideoMode", "forceStopVideoRecording, mRecordSig.block");
            this.aT.block();
            com.oppo.camera.e.a("VideoMode", "forceStopVideoRecording, mRecordSig.block X");
        }
        if (dN() || dM()) {
            G(z);
        }
    }

    /* access modifiers changed from: protected */
    public void u() {
        com.oppo.camera.e.a("VideoMode", "onBeforePreview");
        gn();
        if (this.W != null) {
            if (Util.p()) {
                this.W.t(0);
            } else if (!this.t) {
                this.W.t(1);
            }
        }
        this.L = false;
    }

    public void p(boolean z) {
        this.bf = z;
    }

    public void q(boolean z) {
        int i;
        Intent intent = new Intent();
        if (z) {
            i = -1;
            intent.setData(this.aO);
            intent.addFlags(1);
        } else {
            i = 0;
        }
        this.Z.setResult(i, intent);
        this.Z.finish();
    }

    public void dF() {
        com.oppo.camera.e.a("VideoMode", "deleteCurrentVideo");
        String str = this.aL;
        if (str != null) {
            this.aX.obtainMessage(3, str).sendToTarget();
            this.aL = null;
        }
        this.Y.o();
    }

    public void dG() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(this.aO, K(n_().fileFormat));
        intent.addFlags(1);
        intent.putExtra("IsFromOppoViewCamera", true);
        try {
            this.Z.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            com.oppo.camera.e.d("VideoMode", "startPlayVideoActivity, Couldn't view video: " + this.aO, e);
        }
    }

    public void dH() {
        if (fW() || (cF() && "torch".equals(bu()))) {
            this.Y.a(-1, (int) R.drawable.torch_hint_icon, false, true, false);
        } else {
            this.Y.a(false, true, true);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        com.oppo.camera.e.a("VideoMode", "onBeforeSnapping");
        if (dN()) {
            return true;
        }
        com.oppo.camera.e.e("VideoMode", "onBeforeSnapping, is not in RECORD_STARTED");
        return false;
    }

    public void dI() {
        com.oppo.camera.e.e("VideoMode", "onVideoShutterButtonClick, mMediaRecorderState: " + this.be + ", mCameraInterface.isAnimationRunning: " + this.X.O());
        if (this.y || this.X.h() != 1 || this.X.O() || this.X.P() || this.X.B()) {
            com.oppo.camera.e.e("VideoMode", "onVideoShutterButtonClick, mbPaused: " + this.y + ", CameraState: " + this.X.h() + ", isAnimationRunning: " + this.X.O() + ", isBlurAnimRunning: " + this.X.P() + ", mCameraInterface.getSwitchingCameraState: " + this.X.B());
        } else if (this.X.C()) {
            com.oppo.camera.e.a("VideoMode", "onVideoShutterButtonClick, being capture mode change!");
        } else if (z.t != 0) {
            this.Y.o();
        } else if (!dO() && !this.X.M()) {
            com.oppo.camera.e.d("VideoMode", "onVideoShutterButtonClick, memory or storage is not enough");
            this.Y.a((int) R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
            b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
        } else if (dM() || this.au.hasMessages(5)) {
            com.oppo.camera.e.d("VideoMode", "onVideoShutterButtonClick, starting or error processing");
        } else if (!gG()) {
            if (!this.bi || this.Z.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
                com.oppo.camera.e.e("VideoMode", "onVideoShutterButtonClick, CameraTest Click Video Button");
                if (dN()) {
                    G(true);
                } else if (dP()) {
                    com.oppo.camera.perf.a.a("start_video_record");
                    this.bx = System.currentTimeMillis() - this.bw;
                    gB();
                }
            } else {
                com.oppo.camera.e.e("VideoMode", "onVideoShutterButtonClick, permission not granted");
                this.Z.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 2);
            }
        }
    }

    public void dJ() {
        if (dN() || dM()) {
            this.Z.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(this.aM))));
            com.oppo.camera.e.a("VideoMode", "notifyScanVideoFile, sendBroadcast() success");
        }
        if (!dP()) {
            this.au.removeMessages(9);
            this.au.sendEmptyMessage(9);
        }
    }

    public boolean I() {
        return gq() && this.aH;
    }

    public void e(boolean z, boolean z2) {
        com.oppo.camera.e.a("VideoMode", "handleStartError, fromBroadcast: " + z + ", showDialog: " + z2);
        this.aX.obtainMessage(3, this.aM).sendToTarget();
        if (!en()) {
            fR();
        }
        this.X.Q();
        if (dM() || dN()) {
            G(false);
        }
        if (z) {
            Handler handler = this.au;
            if (handler != null) {
                handler.removeMessages(5);
            }
            this.Z.onBackPressed();
        } else {
            this.Y.q();
            if ("on".equals(z.r) && !z.f()) {
                z.s = 5;
                z.r = "invalid";
                z.t = 3;
                this.aB = VideoRecordMsgData.END_TYPE_MOMORY_LIMIT;
                this.Y.o();
                this.bl = false;
                return;
            } else if (z2) {
                this.Y.a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        u.this.Z.onBackPressed();
                    }
                });
            }
        }
        this.bl = false;
    }

    public boolean dK() {
        com.oppo.camera.e.a("VideoMode", "onVideoRecordingPause");
        if (!dN()) {
            com.oppo.camera.e.a("VideoMode", "onVideoRecordingPause, VideoRecord is not started, so return");
            return false;
        } else if (this.aw < ((long) gu())) {
            com.oppo.camera.e.a("VideoMode", "onVideoRecordingPause, mRecordingTotalTime less then 1s, so return");
            return false;
        } else {
            if (this.au.hasMessages(1)) {
                this.au.removeMessages(1);
            }
            this.Y.e(false);
            this.bn = SystemClock.uptimeMillis();
            if (gr()) {
                return true;
            }
            return this.aA.f();
        }
    }

    public boolean dL() {
        com.oppo.camera.e.a("VideoMode", "onVideoRecordingResume");
        if (!dN()) {
            com.oppo.camera.e.a("VideoMode", "onVideoRecordingResume, VideoRecord is not started, so return");
            return false;
        }
        this.au.sendEmptyMessage(1);
        this.Y.e(true);
        this.bm += SystemClock.uptimeMillis() - this.bn;
        this.bn = 0;
        if (gr()) {
            return true;
        }
        return this.aA.e();
    }

    private void G(int i) {
        com.oppo.camera.e.a("VideoMode", "setVideoSurfaceState, mVideoSurfaceState: " + this.bv + " => " + i);
        this.bv = i;
    }

    private boolean fL() {
        return this.bv == 2;
    }

    private boolean fN() {
        return this.bv == 1;
    }

    private void H(int i) {
        com.oppo.camera.e.a("VideoMode", "setVideoRecordState, mMediaRecorderState: " + this.be + " => " + i);
        this.be = i;
    }

    public boolean dN() {
        return this.be == 0;
    }

    public boolean dM() {
        return this.be == 1;
    }

    public boolean dO() {
        return dN() || dM();
    }

    public boolean dP() {
        return this.be == 2;
    }

    public boolean eY() {
        return dP();
    }

    public boolean dQ() {
        return this.be == 3;
    }

    public CamcorderProfile n_() {
        return this.ax;
    }

    /* access modifiers changed from: protected */
    public Size B(String str) {
        int i;
        int i2 = 720;
        if (!"video_size_4kuhd".equals(str) && !"video_size_1080p".equals(str)) {
            if ("video_size_720p".equals(str)) {
                i2 = 1280;
                i = 720;
            } else if ("video_size_480p".equals(str)) {
                i = 480;
            } else if ("video_size_cif".equals(str)) {
                i2 = 352;
                i = 288;
            } else if ("video_size_qcif".equals(str)) {
                i2 = 176;
                i = 144;
            }
            com.oppo.camera.e.a("VideoMode", "getVideoPreviewSize, videoSizeType: " + str + ", width: " + i2 + ", height: " + i);
            return new Size(i2, i);
        }
        i = 1080;
        i2 = 1920;
        com.oppo.camera.e.a("VideoMode", "getVideoPreviewSize, videoSizeType: " + str + ", width: " + i2 + ", height: " + i);
        return new Size(i2, i);
    }

    public Bitmap u(int i) {
        ParcelFileDescriptor parcelFileDescriptor = this.aS;
        if (parcelFileDescriptor != null) {
            return com.oppo.camera.ui.control.e.a(parcelFileDescriptor.getFileDescriptor(), i);
        }
        String str = this.aL;
        if (str != null) {
            return com.oppo.camera.ui.control.e.a(str, i);
        }
        return null;
    }

    public void F(int i) {
        com.oppo.camera.e.a("VideoMode", "onException, exceptionCode: " + i);
        if (1 == i && !dP()) {
            G(false);
        }
    }

    public void a(Object obj, int i, int i2) {
        com.oppo.camera.e.a("VideoMode", "onError, what: " + i + ", extra: " + i2);
        if (en() || !(i == 1 || i2 == -1007)) {
            if (!en()) {
                return;
            }
            if (!(i == 1100 || i == 1101 || i < 0)) {
                return;
            }
        }
        if (en() && i < 0) {
            com.oppo.camera.e.e("VideoMode", "onError, kill myself");
            if (this.X != null) {
                this.X.N();
                return;
            }
        }
        if (!dP()) {
            G(true);
        }
    }

    public void b(Object obj, int i, int i2) {
        com.oppo.camera.e.a("VideoMode", "onInfo");
        if (i == 800) {
            if (dN()) {
                G(true);
            }
        } else if ((i == 801 || i == 802) && dN()) {
            this.bj = true;
            G(true);
        }
    }

    /* access modifiers changed from: protected */
    public void C(String str) {
        com.oppo.camera.e.a("VideoMode", "deleteVideoFile, fileName: " + str);
        if (str != null) {
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                com.oppo.camera.e.a("VideoMode", "deleteVideoFile, Could not delete " + str);
            }
            if (this.aO != null) {
                try {
                    this.Z.getContentResolver().delete(this.aO, (String) null, (String[]) null);
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    this.aO = null;
                    throw th;
                }
                this.aO = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void gf() {
        ParcelFileDescriptor parcelFileDescriptor = this.aS;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                com.oppo.camera.e.d("VideoMode", "closeVideoFileDescriptor, Fail to close fd", e);
            }
            this.aS = null;
        }
    }

    private void fR() {
        com.oppo.camera.e.a("VideoMode", "releaseVideoRecorderWrapper, Releasing media recorder.");
        synchronized (this.aV) {
            if (this.aA != null) {
                if (this.aM != null) {
                    this.aX.obtainMessage(4, this.aM).sendToTarget();
                }
                this.aA.c();
                this.aA = null;
            }
        }
    }

    private void fS() {
        Handler handler = this.au;
        if (handler != null) {
            handler.removeMessages(2);
        }
        AsyncTask asyncTask = this.bq;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.bq = null;
        }
    }

    private void fT() {
        if (this.au.hasMessages(1)) {
            this.au.removeMessages(1);
        }
    }

    /* access modifiers changed from: private */
    public void fU() {
        this.bm = 0;
        this.bn = 0;
        fS();
        if (this.X != null && !com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode())) {
            this.X.Q();
        }
        if (this.au != null) {
            fT();
            this.au.removeMessages(4);
            this.au.removeMessages(3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0107 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean gx() {
        /*
            r15 = this;
            java.lang.String r0 = "pipeline_video"
            java.lang.String r1 = "stopVideoRecording fail, time is too short or stop fail, mVideoFilename: "
            java.lang.String r2 = "type_video"
            java.lang.String r3 = "type_video_frame"
            java.lang.String r4 = "VideoMode"
            java.lang.String r5 = "stopVideoRecording"
            com.oppo.camera.e.a(r4, r5)
            boolean r5 = r15.dQ()
            r6 = 0
            if (r5 == 0) goto L_0x023d
            long r7 = r15.bt
            long r9 = r15.aw
            long r7 = r7 + r9
            r15.bt = r7
            r5 = 5
            r7 = 1
            r8 = 3
            com.oppo.camera.e.v r9 = r15.aA     // Catch:{ RuntimeException -> 0x00eb, all -> 0x00e5 }
            boolean r9 = r9.b()     // Catch:{ RuntimeException -> 0x00eb, all -> 0x00e5 }
            java.lang.String r10 = r15.aM     // Catch:{ RuntimeException -> 0x00e3 }
            r15.aL = r10     // Catch:{ RuntimeException -> 0x00e3 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00e3 }
            r10.<init>()     // Catch:{ RuntimeException -> 0x00e3 }
            java.lang.String r11 = "stopVideoRecording, mCurrentVideoFilename: "
            r10.append(r11)     // Catch:{ RuntimeException -> 0x00e3 }
            java.lang.String r11 = r15.aL     // Catch:{ RuntimeException -> 0x00e3 }
            r10.append(r11)     // Catch:{ RuntimeException -> 0x00e3 }
            java.lang.String r11 = ", stopResult: "
            r10.append(r11)     // Catch:{ RuntimeException -> 0x00e3 }
            r10.append(r9)     // Catch:{ RuntimeException -> 0x00e3 }
            java.lang.String r10 = r10.toString()     // Catch:{ RuntimeException -> 0x00e3 }
            com.oppo.camera.e.a(r4, r10)     // Catch:{ RuntimeException -> 0x00e3 }
            boolean r10 = r15.gq()
            if (r10 == 0) goto L_0x0065
            boolean r10 = r15.gv()
            if (r10 != 0) goto L_0x0065
            boolean r10 = r15.gr()
            if (r10 != 0) goto L_0x0065
            com.oppo.camera.aps.service.ApsService r10 = r15.aj
            if (r10 == 0) goto L_0x0065
            com.oppo.camera.aps.service.ApsService r10 = r15.aj
            r10.setEnableAPSPipeline(r0, r6)
            r15.aH = r6
        L_0x0065:
            com.oppo.camera.e.b r0 = r15.X
            if (r0 == 0) goto L_0x0072
            boolean r0 = r15.bk
            if (r0 != 0) goto L_0x0072
            com.oppo.camera.e.b r0 = r15.X
            r0.c((int) r5)
        L_0x0072:
            boolean r0 = r15.en()
            if (r0 == 0) goto L_0x00a7
            long r10 = r15.aw
            int r0 = r15.gu()
            long r12 = (long) r0
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x0085
            if (r9 != 0) goto L_0x00a7
        L_0x0085:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = r15.aM
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r4, r0)
            java.lang.String r0 = r15.aM
            if (r0 == 0) goto L_0x00a6
            android.os.Handler r1 = r15.aX
            android.os.Message r0 = r1.obtainMessage(r8, r0)
            r0.sendToTarget()
        L_0x00a6:
            r6 = r7
        L_0x00a7:
            r15.fR()
            com.oppo.camera.f.f r0 = r15.W
            if (r0 == 0) goto L_0x00c3
            com.oppo.camera.f.f r0 = r15.W
            boolean r0 = r0.c((java.lang.String) r2)
            if (r0 != 0) goto L_0x00c3
            boolean r0 = r15.ep()
            if (r0 == 0) goto L_0x00c3
            com.oppo.camera.f.f r0 = r15.W
            r0.d((java.lang.String) r2)
            goto L_0x023d
        L_0x00c3:
            boolean r0 = r15.r(r3)
            if (r0 == 0) goto L_0x023d
            boolean r0 = r15.en()
            if (r0 != 0) goto L_0x023d
            boolean r0 = r15.ep()
            if (r0 != 0) goto L_0x023d
            com.oppo.camera.f.f r0 = r15.W
            if (r0 == 0) goto L_0x023d
            com.oppo.camera.f.f r0 = r15.W
            r0.d((java.lang.String) r3)
            goto L_0x023d
        L_0x00e0:
            r7 = move-exception
            goto L_0x01a7
        L_0x00e3:
            r10 = move-exception
            goto L_0x00ed
        L_0x00e5:
            r9 = move-exception
            r14 = r9
            r9 = r7
            r7 = r14
            goto L_0x01a7
        L_0x00eb:
            r10 = move-exception
            r9 = r7
        L_0x00ed:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r11.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r12 = "stopVideoRecording fail, mVideoFilename: "
            r11.append(r12)     // Catch:{ all -> 0x00e0 }
            java.lang.String r12 = r15.aM     // Catch:{ all -> 0x00e0 }
            r11.append(r12)     // Catch:{ all -> 0x00e0 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00e0 }
            com.oppo.camera.e.a((java.lang.String) r4, (java.lang.String) r11, (java.lang.Throwable) r10)     // Catch:{ all -> 0x00e0 }
            java.lang.String r10 = r15.aM     // Catch:{ all -> 0x00e0 }
            if (r10 == 0) goto L_0x0112
            android.os.Handler r10 = r15.aX     // Catch:{ all -> 0x00e0 }
            java.lang.String r11 = r15.aM     // Catch:{ all -> 0x00e0 }
            android.os.Message r10 = r10.obtainMessage(r8, r11)     // Catch:{ all -> 0x00e0 }
            r10.sendToTarget()     // Catch:{ all -> 0x00e0 }
        L_0x0112:
            boolean r10 = r15.gq()
            if (r10 == 0) goto L_0x012f
            boolean r10 = r15.gv()
            if (r10 != 0) goto L_0x012f
            boolean r10 = r15.gr()
            if (r10 != 0) goto L_0x012f
            com.oppo.camera.aps.service.ApsService r10 = r15.aj
            if (r10 == 0) goto L_0x012f
            com.oppo.camera.aps.service.ApsService r10 = r15.aj
            r10.setEnableAPSPipeline(r0, r6)
            r15.aH = r6
        L_0x012f:
            com.oppo.camera.e.b r0 = r15.X
            if (r0 == 0) goto L_0x013c
            boolean r0 = r15.bk
            if (r0 != 0) goto L_0x013c
            com.oppo.camera.e.b r0 = r15.X
            r0.c((int) r5)
        L_0x013c:
            boolean r0 = r15.en()
            if (r0 == 0) goto L_0x0170
            long r5 = r15.aw
            int r0 = r15.gu()
            long r10 = (long) r0
            int r0 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r0 < 0) goto L_0x014f
            if (r9 != 0) goto L_0x0170
        L_0x014f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = r15.aM
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r4, r0)
            java.lang.String r0 = r15.aM
            if (r0 == 0) goto L_0x0170
            android.os.Handler r1 = r15.aX
            android.os.Message r0 = r1.obtainMessage(r8, r0)
            r0.sendToTarget()
        L_0x0170:
            r15.fR()
            com.oppo.camera.f.f r0 = r15.W
            if (r0 == 0) goto L_0x018b
            com.oppo.camera.f.f r0 = r15.W
            boolean r0 = r0.c((java.lang.String) r2)
            if (r0 != 0) goto L_0x018b
            boolean r0 = r15.ep()
            if (r0 == 0) goto L_0x018b
            com.oppo.camera.f.f r0 = r15.W
            r0.d((java.lang.String) r2)
            goto L_0x01a6
        L_0x018b:
            boolean r0 = r15.r(r3)
            if (r0 == 0) goto L_0x01a6
            boolean r0 = r15.en()
            if (r0 != 0) goto L_0x01a6
            boolean r0 = r15.ep()
            if (r0 != 0) goto L_0x01a6
            com.oppo.camera.f.f r0 = r15.W
            if (r0 == 0) goto L_0x01a6
            com.oppo.camera.f.f r0 = r15.W
            r0.d((java.lang.String) r3)
        L_0x01a6:
            return r7
        L_0x01a7:
            boolean r10 = r15.gq()
            if (r10 == 0) goto L_0x01c4
            boolean r10 = r15.gv()
            if (r10 != 0) goto L_0x01c4
            boolean r10 = r15.gr()
            if (r10 != 0) goto L_0x01c4
            com.oppo.camera.aps.service.ApsService r10 = r15.aj
            if (r10 == 0) goto L_0x01c4
            com.oppo.camera.aps.service.ApsService r10 = r15.aj
            r10.setEnableAPSPipeline(r0, r6)
            r15.aH = r6
        L_0x01c4:
            com.oppo.camera.e.b r0 = r15.X
            if (r0 == 0) goto L_0x01d1
            boolean r0 = r15.bk
            if (r0 != 0) goto L_0x01d1
            com.oppo.camera.e.b r0 = r15.X
            r0.c((int) r5)
        L_0x01d1:
            boolean r0 = r15.en()
            if (r0 == 0) goto L_0x0205
            long r5 = r15.aw
            int r0 = r15.gu()
            long r10 = (long) r0
            int r0 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r0 < 0) goto L_0x01e4
            if (r9 != 0) goto L_0x0205
        L_0x01e4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = r15.aM
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r4, r0)
            java.lang.String r0 = r15.aM
            if (r0 == 0) goto L_0x0205
            android.os.Handler r1 = r15.aX
            android.os.Message r0 = r1.obtainMessage(r8, r0)
            r0.sendToTarget()
        L_0x0205:
            r15.fR()
            com.oppo.camera.f.f r0 = r15.W
            if (r0 == 0) goto L_0x0221
            com.oppo.camera.f.f r0 = r15.W
            boolean r0 = r0.c((java.lang.String) r2)
            if (r0 != 0) goto L_0x0221
            boolean r0 = r15.ep()
            if (r0 != 0) goto L_0x021b
            goto L_0x0221
        L_0x021b:
            com.oppo.camera.f.f r0 = r15.W
            r0.d((java.lang.String) r2)
            goto L_0x023c
        L_0x0221:
            boolean r0 = r15.r(r3)
            if (r0 == 0) goto L_0x023c
            boolean r0 = r15.en()
            if (r0 != 0) goto L_0x023c
            boolean r0 = r15.ep()
            if (r0 != 0) goto L_0x023c
            com.oppo.camera.f.f r0 = r15.W
            if (r0 == 0) goto L_0x023c
            com.oppo.camera.f.f r0 = r15.W
            r0.d((java.lang.String) r3)
        L_0x023c:
            throw r7
        L_0x023d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.u.gx():boolean");
    }

    /* access modifiers changed from: protected */
    public void G(boolean z) {
        com.oppo.camera.e.a("VideoMode", "onStopVideoRecording, checkRecordTime: " + z);
        this.bl = false;
        if (this.W != null) {
            if (!Util.p()) {
                this.W.u(0);
                this.W.a((f.c) null);
            } else if (!ee()) {
                this.W.t(0);
                this.W.a((f.c) null);
            }
        }
        if (this.X != null && this.X.j() && !n() && this.W != null) {
            this.X.V();
            this.X.b(false, false);
            this.W.a(3, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
            this.W.a((f.c) null);
        }
        com.oppo.camera.perf.a.a("video_save");
        H(3);
        if (this.X != null) {
            this.X.K();
        }
        this.aT.close();
        this.au.removeMessages(6);
        this.br.cancel();
        if (this.X != null && gq() && !gN() && ((gv() || gr()) && this.aj != null)) {
            this.aj.setEnableAPSPipeline(ApsParameters.APS_PIPELINE_NAME_VIDEO, false);
            this.aH = false;
        }
        if (this.aX != null && !f("key_intelligent_high_frame_usage_key") && !gr()) {
            this.aX.removeMessages(2);
            this.aX.sendEmptyMessage(2);
        }
        if (this.X != null) {
            this.X.J();
        }
    }

    /* access modifiers changed from: private */
    public void gy() {
        Handler handler = this.au;
        if (handler != null && handler.hasMessages(7)) {
            this.au.removeMessages(7);
        }
        String gc = gc();
        boolean z = this.aR;
        this.aC = gx();
        boolean gg = gg();
        if (!gg) {
            String str = this.aM;
            if (str != null) {
                this.aX.obtainMessage(3, str).sendToTarget();
            }
            fv();
        } else {
            this.bC = false;
            if (fx()) {
                if (A(this.aM)) {
                    fu();
                } else {
                    fv();
                }
            }
        }
        if (this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (!u.this.z) {
                        if (u.this.cL()) {
                            u.this.Y.a(u.this.Z.getString(R.string.camera_video_hdr), 0, (int) R.color.screen_hint_text_color);
                        }
                        if (u.this.aE()) {
                            u.this.Y.a(u.this.Z.getString(R.string.camera_ultra_night_video), 0, (int) R.color.screen_hint_text_color);
                        }
                        if (u.this.ab != null) {
                            u.this.ab.e(false);
                        }
                        u.this.X.L();
                        u.this.f_();
                        u.this.fU();
                    }
                }
            });
        }
        e.c cVar = new e.c();
        cVar.k = 1;
        if (gg && this.Z != null) {
            if (!fx()) {
                a(cVar, z, gc);
            }
            cVar.d = this.aO;
        }
        Handler handler2 = this.au;
        if (handler2 != null) {
            handler2.post(new Runnable(cVar, gg) {
                private final /* synthetic */ e.c f$1;
                private final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    u.this.a(this.f$1, this.f$2);
                }
            });
            if (this.au.hasMessages(9)) {
                this.au.removeMessages(9);
                this.au.sendEmptyMessageDelayed(9, 100);
            }
            this.aX.sendEmptyMessageDelayed(12, 300);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e.c cVar, boolean z) {
        if (this.z) {
            com.oppo.camera.e.a("VideoMode", "stopVideoRecordThread, return");
            return;
        }
        gE();
        this.X.a(cVar, !z, !fx());
        gf();
        H(2);
        if (this.bj) {
            this.Y.g(this.Z.getString(R.string.camera_video_reach_size_limit));
            this.X.a((Animation.AnimationListener) null);
            this.X.d(false);
            this.aX.removeMessages(8);
            this.aX.sendEmptyMessageDelayed(8, 3000);
            this.bj = false;
            b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_VIDEO_SIZE_LIMIT);
        }
    }

    private boolean A(String str) {
        com.oppo.camera.e.a("VideoMode", "checkVideoFileReady, videoFilename: " + str);
        File file = new File(str);
        if (file.exists() && file.length() > 0) {
            return true;
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file2 = new File(str);
        boolean exists = file2.exists();
        long length = file2.length();
        com.oppo.camera.e.a("VideoMode", "checkVideoFileReady, exist: " + exists + ", fileLength: " + length);
        if (!exists || length <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean gg() {
        com.oppo.camera.e.a("VideoMode", "isRecordFileValid, mbStopVideoFail:  " + this.aC + ", mRecordingTotalTime: " + this.aw);
        return !this.aC && ((long) gu()) <= this.aw;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00db A[SYNTHETIC, Splitter:B:46:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e1 A[SYNTHETIC, Splitter:B:49:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011f A[Catch:{ Exception -> 0x01da, all -> 0x01d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0215  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.oppo.camera.ui.control.e.c r16, boolean r17, java.lang.String r18) {
        /*
            r15 = this;
            r1 = r15
            java.lang.String r2 = "com.oppo.camera.NEW_VIDEO"
            java.lang.String r3 = "CameraTest Video Flie Save End, mCurrentVideoUri: "
            java.lang.String r4 = "VideoMode"
            java.lang.String r0 = "addVideoToMediaStore"
            com.oppo.camera.e.a(r4, r0)
            java.lang.String r0 = com.oppo.camera.z.e()
            java.lang.String r5 = "on"
            boolean r0 = r5.equals(r0)
            r5 = 1
            r6 = 0
            if (r0 == 0) goto L_0x0033
            boolean r0 = com.oppo.camera.z.b((boolean) r5)
            if (r0 != 0) goto L_0x0033
            r1.aO = r6
            r1.aL = r6
            android.content.ContentValues r0 = r1.aP
            if (r0 == 0) goto L_0x002d
            r0.clear()
            r1.aP = r6
        L_0x002d:
            java.lang.String r0 = "addVideoToMediaStore, Exception: sdcard has removed, so not add to mediaStore."
            com.oppo.camera.e.a(r4, r0)
            return r5
        L_0x0033:
            android.os.ParcelFileDescriptor r0 = r1.aS
            r7 = 0
            if (r0 == 0) goto L_0x020e
            java.lang.String r0 = r1.aL
            if (r0 == 0) goto L_0x020e
            android.content.ContentValues r0 = r1.aP
            if (r0 == 0) goto L_0x020e
            boolean r0 = android.text.TextUtils.isEmpty(r18)
            if (r0 != 0) goto L_0x0057
            android.content.ContentValues r0 = r1.aP
            java.lang.String r8 = r15.gk()
            r9 = r18
            java.lang.String r8 = r8.concat(r9)
            java.lang.String r9 = "title"
            r0.put(r9, r8)
        L_0x0057:
            android.content.ContentValues r0 = r1.aP
            java.io.File r8 = new java.io.File
            java.lang.String r9 = r1.aL
            r8.<init>(r9)
            long r8 = r8.length()
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            java.lang.String r9 = "_size"
            r0.put(r9, r8)
            long r8 = java.lang.System.currentTimeMillis()
            android.content.ContentValues r0 = r1.aP
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            java.lang.String r9 = "datetaken"
            r0.put(r9, r8)
            android.content.ContentValues r0 = r1.aP
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            java.lang.String r9 = "is_pending"
            r0.put(r9, r8)
            boolean r0 = r15.fs()
            r8 = 0
            if (r0 != 0) goto L_0x00eb
            com.oppo.camera.e.b r0 = r1.X
            boolean r0 = r0.m()
            if (r0 != 0) goto L_0x00eb
            android.media.MediaMetadataRetriever r10 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x00d2, all -> 0x00ce }
            r10.<init>()     // Catch:{ Exception -> 0x00d2, all -> 0x00ce }
            android.app.Activity r0 = r1.Z     // Catch:{ Exception -> 0x00d3 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x00d3 }
            android.net.Uri r11 = r1.aO     // Catch:{ Exception -> 0x00d3 }
            r10.setDataSource(r0, r11)     // Catch:{ Exception -> 0x00d3 }
            r0 = 9
            java.lang.String r0 = r10.extractMetadata(r0)     // Catch:{ Exception -> 0x00d3 }
            long r11 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00d3 }
            r13 = -1
            android.graphics.Bitmap r0 = r10.getFrameAtTime(r13)     // Catch:{ Exception -> 0x00d4 }
            int r13 = com.oppo.camera.ui.control.ThumbImageView.f3902a     // Catch:{ Exception -> 0x00d4 }
            android.graphics.Bitmap r0 = com.oppo.camera.ui.control.e.b((android.graphics.Bitmap) r0, (int) r13)     // Catch:{ Exception -> 0x00d4 }
            r13 = r16
            r13.l = r0     // Catch:{ Exception -> 0x00d4 }
            r10.release()     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00ec
        L_0x00c5:
            r0 = move-exception
            r10 = r0
            r10.printStackTrace()
            goto L_0x00ec
        L_0x00cb:
            r0 = move-exception
            r2 = r0
            goto L_0x00df
        L_0x00ce:
            r0 = move-exception
            r2 = r0
            r10 = r6
            goto L_0x00df
        L_0x00d2:
            r10 = r6
        L_0x00d3:
            r11 = r8
        L_0x00d4:
            java.lang.String r0 = "addVideoToMediaStore, get video duration fail."
            com.oppo.camera.e.a(r4, r0)     // Catch:{ all -> 0x00cb }
            if (r10 == 0) goto L_0x00ec
            r10.release()     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00ec
        L_0x00df:
            if (r10 == 0) goto L_0x00ea
            r10.release()     // Catch:{ Exception -> 0x00e5 }
            goto L_0x00ea
        L_0x00e5:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x00ea:
            throw r2
        L_0x00eb:
            r11 = r8
        L_0x00ec:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "addVideoToMediaStore, Video duration: "
            r0.append(r10)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.a(r4, r0)
            int r0 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            java.lang.String r8 = "duration"
            if (r0 <= 0) goto L_0x0110
            android.content.ContentValues r0 = r1.aP
            java.lang.Long r9 = java.lang.Long.valueOf(r11)
            r0.put(r8, r9)
            goto L_0x011b
        L_0x0110:
            android.content.ContentValues r0 = r1.aP
            long r9 = r1.aw
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            r0.put(r8, r9)
        L_0x011b:
            android.app.Activity r0 = r1.Z     // Catch:{ Exception -> 0x01da }
            if (r0 == 0) goto L_0x01c3
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01da }
            r8 = 30
            if (r0 < r8) goto L_0x013d
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x01da }
            r0.<init>()     // Catch:{ Exception -> 0x01da }
            java.lang.String r8 = "android:query-arg-do-async-scan"
            r0.putBoolean(r8, r5)     // Catch:{ Exception -> 0x01da }
            android.app.Activity r8 = r1.Z     // Catch:{ Exception -> 0x01da }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ Exception -> 0x01da }
            android.net.Uri r9 = r1.aO     // Catch:{ Exception -> 0x01da }
            android.content.ContentValues r10 = r1.aP     // Catch:{ Exception -> 0x01da }
            r8.update(r9, r10, r0)     // Catch:{ Exception -> 0x01da }
            goto L_0x014a
        L_0x013d:
            android.app.Activity r0 = r1.Z     // Catch:{ Exception -> 0x01da }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x01da }
            android.net.Uri r8 = r1.aO     // Catch:{ Exception -> 0x01da }
            android.content.ContentValues r9 = r1.aP     // Catch:{ Exception -> 0x01da }
            r0.update(r8, r9, r6, r6)     // Catch:{ Exception -> 0x01da }
        L_0x014a:
            boolean r0 = r1.J     // Catch:{ Exception -> 0x01da }
            if (r0 == 0) goto L_0x0186
            android.net.Uri r0 = r1.aO     // Catch:{ Exception -> 0x01da }
            if (r0 == 0) goto L_0x0186
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x01da }
            r0.<init>()     // Catch:{ Exception -> 0x01da }
            java.lang.String r8 = "media_id"
            android.net.Uri r9 = r1.aO     // Catch:{ Exception -> 0x01da }
            long r9 = android.content.ContentUris.parseId(r9)     // Catch:{ Exception -> 0x01da }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x01da }
            r0.put(r8, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r8 = "content://com.oppo.gallery3d.open.provider/locked_pictures"
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x01da }
            android.app.Activity r9 = r1.Z     // Catch:{ Exception -> 0x01da }
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ Exception -> 0x01da }
            r9.insert(r8, r0)     // Catch:{ Exception -> 0x0176 }
            goto L_0x017d
        L_0x0176:
            r0 = move-exception
            r8 = r0
            java.lang.String r0 = "addVideoToMediaStore, updateLockCameraAlbum, err: "
            com.oppo.camera.e.a((java.lang.String) r4, (java.lang.String) r0, (java.lang.Throwable) r8)     // Catch:{ Exception -> 0x01da }
        L_0x017d:
            com.oppo.camera.e.b r0 = r1.X     // Catch:{ Exception -> 0x01da }
            if (r0 == 0) goto L_0x0186
            com.oppo.camera.e.b r0 = r1.X     // Catch:{ Exception -> 0x01da }
            r0.aF()     // Catch:{ Exception -> 0x01da }
        L_0x0186:
            android.app.Activity r0 = r1.Z     // Catch:{ Exception -> 0x01da }
            android.content.Intent r8 = new android.content.Intent     // Catch:{ Exception -> 0x01da }
            java.lang.String r9 = "android.hardware.action.NEW_VIDEO"
            android.net.Uri r10 = r1.aO     // Catch:{ Exception -> 0x01da }
            r8.<init>(r9, r10)     // Catch:{ Exception -> 0x01da }
            r0.sendBroadcast(r8)     // Catch:{ Exception -> 0x01da }
            android.app.Activity r0 = r1.Z     // Catch:{ Exception -> 0x01da }
            java.lang.String r8 = r1.aM     // Catch:{ Exception -> 0x01da }
            com.oppo.camera.util.Util.a((android.content.Context) r0, (java.lang.String) r8)     // Catch:{ Exception -> 0x01da }
            android.app.Activity r0 = r1.Z     // Catch:{ Exception -> 0x01da }
            android.net.Uri r8 = r1.aO     // Catch:{ Exception -> 0x01da }
            java.lang.String r9 = "com.coloros.gallery3d"
            com.oppo.camera.util.Util.a((android.content.Context) r0, (android.net.Uri) r8, (java.lang.String) r2, (java.lang.String) r9)     // Catch:{ Exception -> 0x01da }
            android.app.Activity r0 = r1.Z     // Catch:{ Exception -> 0x01da }
            android.net.Uri r8 = r1.aO     // Catch:{ Exception -> 0x01da }
            java.lang.String r9 = "com.heytap.cloud"
            com.oppo.camera.util.Util.a((android.content.Context) r0, (android.net.Uri) r8, (java.lang.String) r2, (java.lang.String) r9)     // Catch:{ Exception -> 0x01da }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01da }
            r0.<init>()     // Catch:{ Exception -> 0x01da }
            java.lang.String r2 = "addVideoToMediaStore, Video mCurrentVideoUri: "
            r0.append(r2)     // Catch:{ Exception -> 0x01da }
            android.net.Uri r2 = r1.aO     // Catch:{ Exception -> 0x01da }
            r0.append(r2)     // Catch:{ Exception -> 0x01da }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01da }
            com.oppo.camera.e.a(r4, r0)     // Catch:{ Exception -> 0x01da }
        L_0x01c3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            android.net.Uri r2 = r1.aO
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r4, r0)
            goto L_0x020e
        L_0x01d8:
            r0 = move-exception
            goto L_0x01f9
        L_0x01da:
            r0 = move-exception
            java.lang.String r2 = "addVideoToMediaStore, failed to add video to media store"
            com.oppo.camera.e.a((java.lang.String) r4, (java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x01d8 }
            r1.aO = r6     // Catch:{ all -> 0x01d8 }
            r1.aL = r6     // Catch:{ all -> 0x01d8 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            android.net.Uri r2 = r1.aO
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r4, r0)
            goto L_0x020f
        L_0x01f9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            android.net.Uri r3 = r1.aO
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.oppo.camera.e.e(r4, r2)
            throw r0
        L_0x020e:
            r5 = r7
        L_0x020f:
            boolean r0 = r15.fs()
            if (r0 == 0) goto L_0x0218
            r15.gw()
        L_0x0218:
            android.content.ContentValues r0 = r1.aP
            if (r0 == 0) goto L_0x022f
            boolean r0 = r15.fs()
            if (r0 != 0) goto L_0x022f
            boolean r0 = r15.fx()
            if (r0 != 0) goto L_0x022f
            android.content.ContentValues r0 = r1.aP
            r0.clear()
            r1.aP = r6
        L_0x022f:
            boolean r0 = r1.z
            if (r0 != 0) goto L_0x023c
            android.app.Activity r0 = r1.Z
            if (r0 == 0) goto L_0x023c
            r2 = r17
            r15.I((boolean) r2)
        L_0x023c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.u.a(com.oppo.camera.ui.control.e$c, boolean, java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public Size a(String str, String str2, a.C0080a aVar) {
        Size size;
        Size size2;
        if (fE() || eI() || gr() || n_() == null) {
            size2 = null;
            size = null;
        } else {
            size2 = B(dk());
            size = new Size(n_().videoFrameWidth, n_().videoFrameHeight);
        }
        this.bp = str != null ? AlgoSwitchConfig.getPreviewConfig(str, this.n, size2, size, eo(), ApsConstant.FEATURE_REC_SAT_HAL.equals(str) || ApsConstant.FEATURE_REC_4KUHD.equals(str) || ApsConstant.FEATURE_REC_LIVE_HDR.equals(str) || ApsConstant.FEATURE_REC_ULTRA_NIGHT.equals(str) || ApsConstant.FEATURE_REC_AI_ENHANCEMENT.equals(str) || (ApsConstant.REC_MODE_COMMON.equals(str) && 1 == this.n) || (ApsConstant.REC_MODE_FAST_VIDEO.equals(str) && 1 == this.n), ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) && this.n == 0) : null;
        AlgoSwitchConfig.PreviewConfig previewConfig = this.bp;
        if (previewConfig != null && previewConfig.mComponentMap.containsKey(AlgoSwitchConfig.APS_PIPELINE_VIDEO)) {
            AlgoSwitchConfig.PreviewConfig.Component component = this.bp.mComponentMap.get(AlgoSwitchConfig.APS_PIPELINE_VIDEO);
            if (component.mbEnable) {
                if ("type_video_frame".equals(str2)) {
                    return aVar == a.C0080a.INPUT ? new Size(component.mMasterInputWidth, component.mMasterInputHeight) : new Size(component.mOutputWidth, component.mOutputHeight);
                }
                if ("type_still_capture_yuv_main".equals(str2)) {
                    return new Size(component.mOutputWidth, component.mOutputHeight);
                }
            }
        }
        AlgoSwitchConfig.PreviewConfig previewConfig2 = this.bp;
        if (previewConfig2 != null && previewConfig2.mComponentMap.containsKey(AlgoSwitchConfig.APS_PIPELINE_PREVIEW)) {
            AlgoSwitchConfig.PreviewConfig.Component component2 = this.bp.mComponentMap.get(AlgoSwitchConfig.APS_PIPELINE_PREVIEW);
            if (component2.mbEnable && "type_main_preview_frame".equals(str2)) {
                return new Size(component2.mMasterInputWidth, component2.mMasterInputHeight);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void gz() {
        com.oppo.camera.e.a("VideoMode", "startVideoRecordThread");
        if (this.y) {
            this.aT.open();
            return;
        }
        boolean z = true;
        try {
            this.aA.d();
            if (this.W != null && !Util.p()) {
                this.W.a((Range) e());
            }
            if (!ee() && r("type_video") && ep() && !en() && this.W != null) {
                this.W.a("type_video", fC());
            } else if (r("type_video_frame") && !en() && !ep() && this.W != null) {
                this.W.a("type_video_frame", fC());
            }
            boolean a2 = this.aA.a();
            com.oppo.camera.e.a("VideoMode", "startVideoRecordThread, start end, result: " + a2 + ", isUseMediaCodec: " + en());
            if (a2) {
                if (this.ab != null) {
                    this.ab.e(true);
                }
                H(0);
                if (this.au.hasMessages(10)) {
                    this.au.removeMessages(10);
                    this.au.sendEmptyMessageDelayed(10, 1000);
                }
                if (this.au.hasMessages(7)) {
                    this.au.removeMessages(7);
                }
                this.au.sendEmptyMessage(7);
            } else if (en() && this.J) {
                this.au.sendEmptyMessage(5);
            }
        } catch (Exception e) {
            String parameters = ((AudioManager) this.Z.getApplicationContext().getSystemService("audio")).getParameters("record_forbid");
            com.oppo.camera.e.d("VideoMode", "startVideoRecordThread failed, mVideoFilename: " + this.aM + ", value: " + parameters, e);
            if (this.W != null) {
                if (!Util.p()) {
                    com.oppo.camera.e.e("VideoMode", "startVideoRecordThread failed, setMTKVideoEISRecordState");
                    this.W.u(0);
                    this.W.a((f.c) null);
                } else if (!ee()) {
                    com.oppo.camera.e.e("VideoMode", "startVideoRecordThread failed, setVideoEISRecordState");
                    this.W.t(0);
                    this.W.a((f.c) null);
                }
            }
            this.bl = true;
            if (!(!TextUtils.isEmpty(parameters) && "true".contains(parameters))) {
                if (en() || !this.J) {
                    z = false;
                }
            }
            this.au.obtainMessage(5, Boolean.valueOf(z)).sendToTarget();
        } catch (Throwable th) {
            this.aT.open();
            throw th;
        }
        this.aT.open();
    }

    /* access modifiers changed from: private */
    public void gA() {
        e_();
        this.bo = SystemClock.uptimeMillis();
        if (!f("key_short_video") && !f("key_intelligent_high_frame_usage_key") && !fs()) {
            this.Y.a(gb(), I((int) R.dimen.record_time_margin_top), gh());
        }
        gI();
        if (!f("key_short_video")) {
            this.Y.e(true);
        }
        this.X.I();
        if (gM()) {
            this.bD = true;
        }
        com.oppo.camera.e.a("VideoMode", "startVideoRecordHandler end");
    }

    private int I(int i) {
        Resources resources = this.at;
        if (resources != null) {
            return resources.getDimensionPixelSize(i);
        }
        return 0;
    }

    private void gB() {
        if (f("key_temperature_control_stop_video_recording")) {
            float f = this.aa.getFloat("key_cur_temperature", -1.0f);
            if (47.0f <= f) {
                H(2);
                this.Y.a((int) R.string.camera_high_temperature_video_record_disable, -1, true, false, false);
                com.oppo.camera.e.e("VideoMode", "startVideoRecording, Can't start recording video due to high temperature, so return, curTemperature: " + f);
                return;
            }
        }
        gD();
        boolean G = this.X.G();
        this.bj = false;
        this.bk = gC();
        if (this.aX.hasMessages(8)) {
            this.aX.removeMessages(8);
            gL();
        }
        gJ();
        gK();
        if (!G) {
            H(2);
            com.oppo.camera.e.e("VideoMode", "startVideoRecording, ret is false, so return");
            return;
        }
        com.oppo.camera.e.a("VideoMode", "startVideoRecording, mVideoRecorder: " + this.aA);
        this.aX.removeMessages(12);
        this.aX.removeMessages(5);
        if ((!f("key_intelligent_high_frame_usage_key") || gt()) && !fs()) {
            this.au.sendEmptyMessageDelayed(4, 200);
        }
        if (!fs()) {
            this.au.sendEmptyMessageDelayed(3, 200);
        }
        if (gq() && this.aj != null) {
            this.aj.setEnableAPSPipeline(ApsParameters.APS_PIPELINE_NAME_VIDEO, true);
            this.aH = true;
        }
        H(1);
        this.aT.close();
        this.aO = null;
        if (!gj()) {
            com.oppo.camera.e.e("VideoMode", "startVideoRecording, init FileDescriptor fail");
            return;
        }
        gH();
        gF();
        this.X.c(4);
        this.au.removeMessages(6);
        this.au.sendEmptyMessageDelayed(6, 10000);
        this.aX.sendEmptyMessage(1);
        this.X.H();
        com.oppo.camera.w.b.a(this.Z.getContentResolver(), 1);
        this.au.sendEmptyMessageDelayed(2, 5000);
        this.by = this.X.s();
        this.bz = this.X.ac();
        this.bB = bB();
        this.X.a(VideoRecordMsgData.END_TYPE_NORMAL);
        com.oppo.camera.e.a("VideoMode", "afterInitRecorder end");
    }

    private boolean gC() {
        AlgoSwitchConfig.PreviewConfig.Component component;
        AlgoSwitchConfig.PreviewConfig previewConfig = this.bp;
        if (previewConfig == null || previewConfig.mComponentMap == null || (component = this.bp.mComponentMap.get(AlgoSwitchConfig.APS_PIPELINE_VIDEO)) == null) {
            return false;
        }
        String[] strArr = component.mAlgoList;
        if (Util.a((Object[]) strArr)) {
            return false;
        }
        for (String str : strArr) {
            if ("preview_video_supereis".equals(str) || "preview_video_eis".equals(str)) {
                return true;
            }
            if (f("key_intelligent_high_frame_usage_key") && "preview_video_frc".equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean gi() {
        return (this.Z == null || this.aa == null || !"on".equals(this.aa.getString("pref_camera_video_slogan_key", this.Z.getString(R.string.camera_slogan_default_value)))) ? false : true;
    }

    private void gD() {
        if (gi() && f("pref_camera_video_slogan_key") && this.X != null) {
            com.oppo.camera.e.a("getVideoWatermark");
            boolean z = !en();
            com.oppo.camera.e.b("VideoMode", "setVideoWatermark, needToSetToHal: " + z);
            this.X.v();
            this.X.a(z, gs() ? 2 : 1, fr());
            if (!z && this.ab != null) {
                this.ab.a(this.X.ai().a(this.k));
                this.ab.f(true);
                this.ab.e(this.k);
            }
            if (!z || 2 != AlgoSwitchConfig.getApsVersion()) {
                if (2 == AlgoSwitchConfig.getApsVersion() && this.W != null) {
                    this.W.o(0);
                    if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT)) {
                        this.W.b("NULL");
                    }
                }
            } else if (this.W != null) {
                this.W.o(1);
                this.W.p(this.k);
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT)) {
                    this.W.b(this.X.ai().e());
                }
            }
            com.oppo.camera.e.b("getVideoWatermark");
        } else if (!gi() && f("pref_camera_video_slogan_key")) {
            if (this.ab != null) {
                this.ab.a((Bitmap) null);
            }
            if (2 == AlgoSwitchConfig.getApsVersion() && this.W != null) {
                this.W.o(0);
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT)) {
                    this.W.b("NULL");
                }
            }
        }
    }

    private void gE() {
        AudioManager audioManager = (AudioManager) this.Z.getApplicationContext().getSystemService("audio");
        if (!this.bg) {
            int abandonAudioFocus = audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            com.oppo.camera.e.a("VideoMode", "resumeAudioPlayback, Not send broadcast to restore the background music: " + abandonAudioFocus);
            return;
        }
        com.oppo.camera.e.a("VideoMode", "resumeAudioPlayback, send broadcast to restore the background music: " + 0);
        Intent intent = new Intent("com.oppo.music.musicservicecommand.resume");
        intent.putExtra("command", "VideoReqMusicRestore");
        this.Z.sendBroadcast(intent);
    }

    private void gF() {
        com.oppo.camera.e.a("VideoMode", "pauseAudioPlayback");
        int requestAudioFocus = ((AudioManager) this.Z.getApplicationContext().getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 2);
        if (requestAudioFocus == 1) {
            com.oppo.camera.e.a("VideoMode", "pauseAudioPlayback, Not send broadcast to pause the background music: " + requestAudioFocus);
            this.bg = false;
        }
        if (requestAudioFocus == 0) {
            com.oppo.camera.e.a("VideoMode", "pauseAudioPlayback, send broadcast to pause the background music: " + requestAudioFocus);
            this.bg = true;
            Intent intent = new Intent("com.oppo.music.musicservicecommand.pause");
            intent.putExtra("command", "VideoReqMusicPause");
            this.Z.sendBroadcast(intent);
        }
    }

    private boolean gG() {
        com.oppo.camera.e.a("VideoMode", "recDisabledReturn");
        if (!this.bf) {
            return false;
        }
        this.Y.a((int) R.string.camera_low_battery_rec_disabled, -1, true, false, false);
        b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_VIDEO);
        return true;
    }

    private String b(long j) {
        return new SimpleDateFormat(this.Z.getResources().getString(R.string.camera_video_file_name_format), Locale.US).format(new Date(j));
    }

    private void L(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        String b2 = b(currentTimeMillis);
        String str = b2 + J(i);
        String K = K(i);
        this.aZ = fO();
        String str2 = this.aZ + str;
        com.oppo.camera.e.a("VideoMode", "generateVideoFilename, path: " + str2 + ", mime: " + K);
        this.aN = str;
        this.aM = str2;
        this.aP = new ContentValues(7);
        this.aP.put(Downloads.Impl.COLUMN_TITLE, b2);
        this.aP.put("_display_name", str);
        this.aP.put("datetaken", Long.valueOf(currentTimeMillis));
        this.aP.put("mime_type", K);
        this.aP.put("relative_path", z.d((z.a) null));
        this.aP.put("is_pending", 1);
        if (fQ()) {
            this.aO = com.oppo.camera.util.storage.a.a(this.Z, this.Z.getContentResolver(), this.aP);
            try {
                this.aS = this.Z.getContentResolver().openFileDescriptor(this.aO, "rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
        }
        this.aQ = this.X.s();
        this.bu = this.X.X();
        CamcorderProfile n_ = n_();
        this.aP.put("resolution", Integer.toString(n_.videoFrameWidth) + "x" + Integer.toString(n_.videoFrameHeight));
        this.aP.put(CameraStatisticsUtil.IMAGE_WIDTH, Integer.toString(n_.videoFrameWidth));
        this.aP.put(CameraStatisticsUtil.IMAGE_HEIGHT, Integer.toString(n_.videoFrameHeight));
        Location v = this.X.v();
        if (v != null) {
            this.aP.put("latitude", Double.valueOf(v.getLatitude()));
            this.aP.put("longitude", Double.valueOf(v.getLongitude()));
        }
        com.oppo.camera.e.a("VideoMode", "generateVideoFilename, New video filename: " + this.aM);
    }

    /* access modifiers changed from: protected */
    public String fO() {
        if (z.r.equals("off")) {
            return z.n + '/';
        }
        return z.i + '/';
    }

    /* access modifiers changed from: private */
    public void E(String str) {
        com.oppo.camera.e.a("VideoMode", "cleanupEmptyFile");
        if (str != null) {
            File file = new File(str);
            if (file.length() == 0 && file.delete()) {
                com.oppo.camera.e.a("VideoMode", "cleanupEmptyFile, Empty video file deleted: " + str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean fI() {
        return !"video_size_1080p".equals(this.av) || "H265".equals(fZ());
    }

    public boolean gj() {
        Bundle extras = this.Z.getIntent().getExtras();
        gf();
        if (this.X.m() && extras != null) {
            Uri uri = (Uri) extras.getParcelable("output");
            com.oppo.camera.e.c("VideoMode", "initializeRecorder, saveUri: " + uri);
            if (uri != null) {
                try {
                    this.aS = this.Z.getContentResolver().openFileDescriptor(uri, "rw");
                    this.aO = uri;
                } catch (FileNotFoundException e) {
                    com.oppo.camera.e.e("VideoMode", e.toString());
                }
            }
        }
        if (this.aS != null) {
            return true;
        }
        if (n_() != null) {
            L(n_().fileFormat);
        }
        if (this.aM != null) {
            return true;
        }
        com.oppo.camera.e.e("VideoMode", "initializeRecorder, mVideoFilename is null");
        return false;
    }

    private void gH() {
        com.oppo.camera.e.c("VideoMode", "initializeRecorder");
        Bundle extras = this.Z.getIntent().getExtras();
        long j = "on".equals(z.r) ? STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 : 0;
        if (this.X.m() && extras != null) {
            j = extras.getLong("android.intent.extra.sizeLimit");
        }
        boolean z = false;
        if (extras != null) {
            z = extras.getBoolean("is_from_oppo_mms", false);
            if (this.X.m()) {
                j = extras.getLong("android.intent.extra.sizeLimit");
            }
        }
        this.aA = new v(en(), this.X.ae());
        this.aA.a(fP());
        synchronized (this.az) {
            if (this.ay != null) {
                this.aA.a(this.ay);
            }
        }
        this.aA.a((q) this.Y.a());
        CamcorderProfile n_ = n_();
        if (!this.bi || !Util.U()) {
            n_.audioCodec = -1;
        } else {
            this.aA.a(5);
            n_.audioCodec = 3;
            if (!z && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_ELEVATE_AUDIO_BIT_RATE)) {
                n_.audioBitRate = 320000;
            }
        }
        this.aA.f(2);
        String gc = gc();
        if (gc != null) {
            this.aA.b(gk().concat(gc));
        }
        gp();
        String fZ = fZ();
        if ("H264".equals(fZ)) {
            n_.videoCodec = 2;
            this.aA.b(8, 2048);
        } else if ("H265".equals(fZ)) {
            n_.videoCodec = 5;
            if (cM()) {
                this.aA.b(2, 16384);
            }
        }
        if (Util.p()) {
            if (K() && TextUtils.equals(bA(), "off")) {
                int s = this.X.s();
                if (s == 0 || s == 180) {
                    this.aA.n(2);
                } else {
                    this.aA.n(1);
                }
            }
            n_.videoFrameRate = fF();
            com.oppo.camera.e.b("VideoMode", "initializeRecorder, videoCodec: " + n_.videoCodec + ", videoBitRate: " + n_.videoBitRate + ", getNeedReduceBitRate(): " + fI());
            this.aA.a(n_);
            if (!this.X.m()) {
                this.aA.g(fI() ? n_.videoBitRate / 2 : n_.videoBitRate);
            } else if (z) {
                this.aA.g(n_.videoBitRate / 4);
            } else {
                this.aA.g(n_.videoBitRate);
            }
            if (Util.h("oplus.software.video.surround_record_support")) {
                if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(a()) || "movie".equals(a()) || ApsConstant.REC_MODE_FAST_VIDEO.equals(a())) {
                    this.ba = VideoRecordMsgData.END_TYPE_NORMAL;
                } else {
                    this.ba = this.aa.getString(this.t ? "pref_sound_types_key_front" : "pref_sound_types_key_rear", this.Z.getString(R.string.camera_video_default_sound));
                    this.bb = this.aa.getString("pref_video_noise_filter_key", this.Z.getString(R.string.camera_noise_filter_default_value));
                }
                this.aA.a(this.bb, this.ba, this.n, this.X.s());
                int bd2 = (int) ((bd() - 1.0f) * 10.0f);
                if (bd2 <= 0) {
                    bd2 = 1;
                }
                com.oppo.camera.e.c("VideoMode", "initSoundType, soundType: " + this.ba + ", modeType: " + a() + ", mNoiseFilter: " + this.bb + ", soundValue: " + bd2);
                this.aA.m(bd2);
            }
        } else {
            CamcorderProfile camcorderProfile = this.ax;
            camcorderProfile.fileFormat = 2;
            this.aA.h(camcorderProfile.fileFormat);
            this.ax.videoFrameRate = fF();
            this.aA.i(this.ax.videoFrameRate);
            this.aA.a(this.ax.videoFrameWidth, this.ax.videoFrameHeight);
            this.aA.j(this.ax.videoCodec);
            if (!this.X.m()) {
                this.aA.g(fI() ? n_.videoBitRate / 2 : n_.videoBitRate);
            } else if (z) {
                com.oppo.camera.w.b.a(this.aA, n_.videoBitRate);
            } else {
                this.aA.g(n_.videoBitRate / 4);
            }
            if (this.bi) {
                if (this.av.equals("video_size_cif") || this.av.equals("video_size_qcif")) {
                    this.aA.b(this.ax.audioBitRate / 8);
                    this.aA.c(this.ax.audioChannels);
                    this.aA.d(this.ax.audioSampleRate / 8);
                    this.aA.e(this.ax.audioCodec);
                } else {
                    this.aA.b(this.ax.audioBitRate);
                    this.aA.c(this.ax.audioChannels);
                    this.aA.d(this.ax.audioSampleRate);
                    this.aA.e(this.ax.audioCodec);
                }
            }
        }
        Location v = this.X.v();
        if (v != null) {
            this.aA.a((float) v.getLatitude(), (float) v.getLongitude());
        }
        int fF = (fG() == null || fG().intValue() <= 0) ? -1 : fF() / fG().intValue();
        v vVar = this.aA;
        if (!dB()) {
            fF = -1;
        }
        vVar.k(fF);
        if (f("key_short_video")) {
            this.aA.l(60000);
        } else if (f("key_video_duration_limit")) {
            this.aA.l(15000);
        } else {
            this.aA.l(this.bd);
        }
        this.Y.a(n_.videoFrameWidth, n_.videoFrameHeight);
        com.oppo.camera.e.a("VideoMode", "initializeRecorder, profile.videoFrameRate: " + n_.videoFrameRate + ", profile.duration: " + n_.duration + ", videoSize: " + (n_.videoFrameWidth + "x" + n_.videoFrameHeight) + ", profile.videoBitRate: " + n_.videoBitRate);
        this.aA.d((this.X.s() + aH()) % 360, this.n);
        ParcelFileDescriptor parcelFileDescriptor = this.aS;
        if (parcelFileDescriptor != null) {
            this.aA.a(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.aA.a(this.aM);
        }
        if (fG() != null && fG().intValue() > 0) {
            this.aA.a((double) fG().intValue());
        }
        long c2 = z.c(z.r);
        if (j > 0 && j < c2) {
            c2 = j;
        }
        try {
            this.aA.a(c2);
        } catch (RuntimeException unused) {
        }
        this.aA.a((v.e) this);
        this.aA.a((v.g) this);
        this.aA.a((v.f) this);
        a(this.aA);
        com.oppo.camera.e.a("VideoMode", "initializeRecorder end, maxFileSize: " + c2 + ", requestedSizeLimit: " + j);
    }

    /* access modifiers changed from: protected */
    public String gk() {
        return com.oppo.camera.h.b.b(a(), this.n);
    }

    /* access modifiers changed from: private */
    public void gI() {
        if (!dN()) {
            gl();
            return;
        }
        long uptimeMillis = (SystemClock.uptimeMillis() - this.bo) - this.bm;
        this.aw = uptimeMillis;
        if (a(uptimeMillis)) {
            dI();
            return;
        }
        if (!f("key_short_video")) {
            this.Y.a(this.aw, gm(), this.bh, f("support_video_count_down"), fM());
        }
        this.bc++;
        this.bc %= 6;
        if (this.bc == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateRecordingTime, mbShowRecordingIndicator: ");
            sb.append(this.bh);
            sb.append("->");
            sb.append(!this.bh);
            com.oppo.camera.e.a("VideoMode", sb.toString());
            this.bh = !this.bh;
        }
        this.au.sendEmptyMessageDelayed(1, 81);
    }

    public void gl() {
        boolean f = f("support_video_count_down");
        long fM = fM();
        if (!f("key_short_video") && f && fM - this.aw < 300) {
            this.aw = fM;
            this.Y.a(fM, gm(), this.bh, true, fM);
        }
    }

    public String dk() {
        String str;
        if (this.X != null && this.X.m()) {
            Bundle extras = this.Z.getIntent().getExtras();
            if (extras != null) {
                boolean z = extras.getBoolean("is_from_oppo_mms", false);
                int i = 4;
                if (!z) {
                    i = extras.getInt("android.intent.extra.videoQuality", 4);
                }
                str = (!com.oppo.camera.w.b.e() || !z) ? (i == 6 || (i == 1 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALITY_HIGH_1080P_SUPPORT))) ? "video_size_1080p" : (i == 5 || i == 1) ? "video_size_720p" : "video_size_480p" : extras.getString("mms_size_type", (String) null);
            } else {
                str = "video_size_480p";
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            com.oppo.camera.e.d("VideoMode", "getVideoSizeType, sizeType: " + str);
            return "video_size_480p";
        } else if (this.aa != null) {
            return this.aa.getString("pref_video_size_key", fH());
        } else {
            com.oppo.camera.e.d("VideoMode", "getVideoSizeType, mPreferences is null!");
            return fH();
        }
    }

    private void gJ() {
        this.Z.sendBroadcast(new Intent("oppo.multimedia.soundrecorder.stopRecroderNormal"));
    }

    private void gK() {
        this.Z.sendBroadcast(new Intent("coloros.camera.record.start"));
    }

    /* access modifiers changed from: private */
    public void a(Activity activity) {
        if (!com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode())) {
            int i = 0;
            try {
                i = com.heytap.compat.os.b.a("persist.sys.oplus.display.brightness.mode", 0);
            } catch (com.heytap.compat.d.a.a e) {
                e.printStackTrace();
            }
            int i2 = 130;
            if (i == 1) {
                i2 = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_CAMERA_VIDEO_BRIGHTNESS);
            }
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            float f = (float) Settings.System.getInt(activity.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, i2);
            float f2 = (float) i2;
            if (f > f2) {
                this.bs.a(f, f - f2, f2);
                this.br.start();
            }
            com.oppo.camera.e.a("VideoMode", "setScreenBrightness, brightness: " + i2 + ", currBrightness: " + f + ", winParams.screenBrightness: " + attributes.screenBrightness);
        }
    }

    private String a(int i, String str) {
        if (CamcorderProfile.hasProfile(i, Integer.valueOf(str).intValue())) {
            return str;
        }
        return Integer.toString(1);
    }

    /* access modifiers changed from: protected */
    public void H(boolean z) {
        com.oppo.camera.e.a("VideoMode", "enableVideoRecordingSound, enable: " + z);
        this.bi = z;
    }

    private int F(String str) {
        int i = 2;
        int i2 = 5;
        if (Util.p()) {
            if ("video_size_4kuhd".equals(this.av) || "video_size_1080p".equals(this.av)) {
                i = 6;
            } else if ("video_size_720p".equals(this.av)) {
                i = 5;
            } else if ("video_size_480p".equals(this.av)) {
                i = 4;
            } else if ("video_size_cif".equals(this.av)) {
                i = 3;
            } else if (!"video_size_qcif".equals(this.av)) {
                i = Integer.valueOf(str).intValue();
            }
            if (fe()) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
                    i2 = 6;
                }
                com.oppo.camera.e.a("VideoMode", "matchRecModeToVideoQuality, mVideoSizeType: " + this.av + ", videoQuality: " + i2);
                return i2;
            }
        } else {
            if ("video_size_1080p".equals(this.av)) {
                i = com.oppo.camera.f.e.a(6);
            } else if ("video_size_720p".equals(this.av)) {
                i = com.oppo.camera.f.e.a(5);
            } else if ("video_size_480p".equals(this.av)) {
                i = com.oppo.camera.f.e.a(10);
            } else if ("video_size_cif".equals(this.av)) {
                i = 3;
            } else if (!"video_size_qcif".equals(this.av)) {
                i = Integer.valueOf(str).intValue();
            }
            if (fe()) {
                i2 = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT) ? com.oppo.camera.f.e.a(6) : com.oppo.camera.f.e.a(5);
                com.oppo.camera.e.a("VideoMode", "matchRecModeToVideoQuality, mVideoSizeType: " + this.av + ", videoQuality: " + i2);
                return i2;
            }
        }
        i2 = i;
        com.oppo.camera.e.a("VideoMode", "matchRecModeToVideoQuality, mVideoSizeType: " + this.av + ", videoQuality: " + i2);
        return i2;
    }

    /* compiled from: VideoMode */
    private final class c extends Handler {
        private c() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case 1:
                    u.this.gI();
                    return;
                case 2:
                    u uVar = u.this;
                    AsyncTask unused = uVar.bq = new b().execute(new Void[0]);
                    return;
                case 3:
                    u.this.Y.b(true, false);
                    return;
                case 4:
                    u.this.Y.a(true, false);
                    return;
                case 5:
                    if (message.obj != null) {
                        z = ((Boolean) message.obj).booleanValue();
                    }
                    u.this.e(false, z);
                    return;
                case 6:
                    u uVar2 = u.this;
                    uVar2.a(uVar2.Z);
                    return;
                case 7:
                    u.this.gA();
                    return;
                case 9:
                    if (!u.this.dP()) {
                        u.this.aX.sendEmptyMessageDelayed(9, 1000);
                        return;
                    } else {
                        MyApplication.c();
                        return;
                    }
                case 10:
                    if (u.this.dN()) {
                        u.this.dI();
                        return;
                    } else {
                        sendEmptyMessageDelayed(10, 1000);
                        return;
                    }
                case 11:
                    if (u.this.Y != null) {
                        u.this.Y.a((int) R.string.super_eis_on_keep_on_toast, -1, true, false, false);
                        return;
                    }
                    return;
                case 12:
                    com.oppo.camera.e.b("VideoMode", "no motion detected");
                    if (u.this.dN()) {
                        u.this.dI();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public long dZ() {
        return this.bt;
    }

    /* compiled from: VideoMode */
    private class b extends AsyncTask<Void, Void, Boolean> {
        private b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            int b2 = z.b(z.r);
            if (b2 != 0) {
                if (b2 == 3 && u.this.X != null) {
                    u.this.X.N();
                }
                return true;
            } else if (!u.this.dP() || !"on".equals(z.r) || z.b(true)) {
                if (u.this.au != null) {
                    u.this.au.removeMessages(2);
                    u.this.au.sendEmptyMessageDelayed(2, 5000);
                }
                return false;
            } else {
                com.oppo.camera.e.a("VideoMode", "doInBackground, external storage is removed, wait unmounted broadcast to finish activity");
                return false;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                u.this.G(true);
            }
        }
    }

    /* compiled from: VideoMode */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private float f2933b;
        private float c;
        private float d;
        private Window e;
        private WindowManager.LayoutParams f = this.e.getAttributes();

        public a(Activity activity) {
            this.e = activity.getWindow();
        }

        public void a(float f2, float f3, float f4) {
            com.oppo.camera.e.a("VideoMode", "setTargetBrightness, targetBrightness: " + f4 + ", deltaBrightness: " + f3);
            this.f2933b = f4;
            this.c = f3;
            this.d = f2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (u.this.X != null) {
                float floatValue = (this.c * ((Float) valueAnimator.getAnimatedValue()).floatValue()) + this.f2933b;
                float f2 = this.c;
                if (f2 >= 20.0f) {
                    if (this.d - floatValue >= f2 / 20.0f) {
                        this.f.screenBrightness = floatValue / ((float) u.this.X.R());
                        this.e.setAttributes(this.f);
                        this.d = floatValue;
                    }
                } else if (this.d - floatValue >= 1.0f) {
                    this.f.screenBrightness = floatValue / ((float) u.this.X.R());
                    this.e.setAttributes(this.f);
                    this.d = floatValue;
                }
            }
        }
    }

    public boolean r(String str) {
        if (this.z) {
            return false;
        }
        if ("type_video".equals(str)) {
            return true;
        }
        if (!"type_tuning_data_yuv".equals(str) && !"type_tuning_data_raw".equals(str)) {
            return super.r(str);
        }
        return false;
    }

    public void j(boolean z) {
        super.j(z);
        if (!z) {
            this.aX.removeMessages(6);
            this.aX.sendEmptyMessage(6);
        }
    }

    public void am() {
        super.am();
        synchronized (this.aW) {
            this.aX.removeMessages(6);
            this.aX.sendEmptyMessage(6);
            if (5 == this.X.h()) {
                this.aU.close();
                this.aU.block();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean fD() {
        if (r("type_video") && this.aa != null) {
            com.oppo.camera.e.b("VideoMode", "prepareVideoSurface");
            G(1);
            gn();
            com.oppo.camera.e.a("prepareVideoSurface");
            v vVar = new v(false, this.X.ae());
            synchronized (this.az) {
                if (this.ay != null) {
                    this.ay.release();
                }
                this.ay = MediaCodec.createPersistentInputSurface();
                vVar.a(this.ay);
            }
            vVar.f(2);
            vVar.h(2);
            vVar.o(this.k);
            String fZ = fZ();
            if (fG() != null && fG().intValue() > 0) {
                vVar.a((double) fG().intValue());
            }
            vVar.i(30);
            vVar.a(this.ax.videoFrameWidth, this.ax.videoFrameHeight);
            if ("H264".equals(fZ)) {
                vVar.j(2);
                vVar.b(8, 2048);
                vVar.g(this.ax.videoBitRate);
            } else if ("H265".equals(fZ)) {
                vVar.j(5);
                vVar.g(this.ax.videoBitRate / 2);
                if (cM()) {
                    vVar.b(2, 16384);
                }
            }
            File file = null;
            try {
                file = File.createTempFile("VideoMode", "TempMediaRecorder");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file != null) {
                vVar.a(file.getAbsolutePath());
            } else {
                com.oppo.camera.e.e("VideoMode", "configSessionSurface, setOutputFile failed, tempFile: " + file);
            }
            try {
                vVar.d();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            vVar.c();
            if (this.bH) {
                com.oppo.camera.ui.control.e.c();
                this.bH = false;
            }
            if (file != null && file.exists()) {
                com.oppo.camera.q.a.c(file.getAbsolutePath());
            }
            G(2);
            this.aU.open();
            com.oppo.camera.e.b("prepareVideoSurface");
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void gn() {
        String str;
        com.oppo.camera.e.a("VideoMode", "readProfile");
        com.oppo.camera.e.a("readProfile");
        this.av = dk();
        if (this.t) {
            str = a(this.n, this.Z.getString(R.string.camera_video_quality_front_default_value));
        } else {
            str = a(this.n, this.Z.getString(R.string.camera_video_quality_default_value));
        }
        int F = F(str);
        Intent intent = this.Z.getIntent();
        Bundle extras = intent.getExtras();
        boolean z = false;
        if (extras != null) {
            z = extras.getBoolean("is_from_oppo_mms", false);
        }
        if (intent.hasExtra("android.intent.extra.videoQuality")) {
            if (extras != null && !z) {
                F = extras.getInt("android.intent.extra.videoQuality", 4);
            }
            if (F == 1 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALITY_HIGH_1080P_SUPPORT)) {
                F = 6;
            } else if (F == 1) {
                F = 5;
            } else if (com.oppo.camera.w.b.f() && z) {
                if ("video_size_cif".equals(this.av)) {
                    F = 3;
                } else if ("video_size_qcif".equals(this.av)) {
                    F = 2;
                }
            }
        }
        com.oppo.camera.e.a("VideoMode", "readProfile, quality: " + F);
        if (intent.hasExtra("android.intent.extra.durationLimit")) {
            int intExtra = intent.getIntExtra("android.intent.extra.durationLimit", -1);
            if (intExtra >= 0) {
                this.bd = intExtra * 1000;
            }
            com.oppo.camera.e.a("VideoMode", "readProfile, mMaxVideoDurationInMs: " + this.bd);
        }
        if (!Util.p()) {
            if (com.oppo.camera.f.e.c(this.n, F)) {
                this.ax = com.oppo.camera.f.e.a(this.n, F);
            } else {
                this.ax = com.oppo.camera.f.e.a(this.n, 4);
            }
            if (this.ax != null) {
                if (this.av.equals("video_size_1080p") || this.av.equals("video_size_720p")) {
                    this.ax.videoBitRate = 17000000;
                } else if (this.av.equals("video_size_cif")) {
                    this.ax.videoBitRate = 720000;
                } else if (this.av.equals("video_size_qcif")) {
                    this.ax.videoBitRate = 192000;
                } else {
                    this.ax.videoBitRate = 9000000;
                }
                this.ax.videoFrameWidth = go().getWidth();
                this.ax.videoFrameHeight = go().getHeight();
                if (fe()) {
                    if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
                        CamcorderProfile camcorderProfile = this.ax;
                        camcorderProfile.videoBitRate = 17000000;
                        camcorderProfile.videoFrameWidth = 1920;
                        camcorderProfile.videoFrameHeight = 1080;
                    } else {
                        CamcorderProfile camcorderProfile2 = this.ax;
                        camcorderProfile2.videoBitRate = 17000000;
                        camcorderProfile2.videoFrameWidth = 1280;
                        camcorderProfile2.videoFrameHeight = 720;
                    }
                }
            }
        } else {
            try {
                this.ax = CamcorderProfile.get(this.n, F);
            } catch (Exception e) {
                this.ax = null;
                com.oppo.camera.e.a("VideoMode", "readProfile, CamcorderProfile.get fail! ", (Throwable) e);
            }
        }
        if (this.ax == null) {
            com.oppo.camera.e.a("VideoMode", "readProfile, mProfile is null, so return...");
            return;
        }
        if ("video_size_4kuhd".equals(this.av) && !fe()) {
            CamcorderProfile camcorderProfile3 = this.ax;
            camcorderProfile3.videoBitRate = 100000000;
            camcorderProfile3.videoFrameWidth = 3840;
            camcorderProfile3.videoFrameHeight = 2160;
            camcorderProfile3.audioSampleRate = 48000;
            camcorderProfile3.audioBitRate = 156000;
            camcorderProfile3.audioChannels = 2;
        }
        this.ax.videoFrameRate = fF();
        this.ax.videoBitRate = ge();
        com.oppo.camera.e.b("readProfile");
        com.oppo.camera.e.a("VideoMode", "readProfile, videoFrameWidth: " + this.ax.videoFrameWidth + ", videoFrameHeight: " + this.ax.videoFrameHeight + ", videoFrameRate: " + this.ax.videoFrameRate + ", mProfile.videoBitRate: " + this.ax.videoBitRate);
    }

    public Size go() {
        int i;
        int i2 = 720;
        if (this.av.equals("video_size_1080p")) {
            i2 = 1920;
            i = 1080;
        } else if (this.av.equals("video_size_720p")) {
            i2 = 1280;
            i = 720;
        } else if (this.av.equals("video_size_cif")) {
            i2 = 352;
            i = 288;
        } else if (this.av.equals("video_size_qcif")) {
            i2 = 176;
            i = 144;
        } else {
            i = 480;
        }
        return new Size(i2, i);
    }

    public int D(String str) {
        if ("video_size_4kuhd".equals(str)) {
            return 2160;
        }
        if ("video_size_1080p".equals(str)) {
            return 1080;
        }
        if ("video_size_720p".equals(str)) {
            return 720;
        }
        if ("video_size_480p".equals(str)) {
            return 480;
        }
        if ("video_size_cif".equals(str)) {
            return 288;
        }
        return "video_size_qcif".equals(str) ? 144 : 0;
    }

    /* access modifiers changed from: private */
    public void gL() {
        com.oppo.camera.e.a("VideoMode", "hideHintViewShowZoom");
        this.Y.n(true);
        if (this.aC && this.X != null) {
            this.X.D();
            this.X.d(true);
        }
    }

    public void a(HashMap<String, f.C0084f> hashMap) {
        if (this.ax == null) {
            com.oppo.camera.e.e("VideoMode", "configSessionSurface, mProfile is null");
        } else if (r("type_video")) {
            com.oppo.camera.e.a("VideoMode", "configSessionSurface, mVideoSurfaceState: " + this.bv);
            synchronized (this.aW) {
                if (!fL()) {
                    if (!this.aX.hasMessages(6) && !fN()) {
                        com.oppo.camera.e.a("VideoMode", "configSessionSurface, send MSG_PREPARE_VIDEO_SURFACE");
                        this.aX.sendEmptyMessage(6);
                    }
                    this.aU.close();
                    this.aU.block();
                }
            }
            G(0);
            synchronized (this.az) {
                if (this.ay != null && (((!f("pref_camera_video_slogan_key") || !gi() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_DEFAULT_VIDEO_FRAME_RECORD)) && (ep() || eu() || ew())) || gO())) {
                    hashMap.put("type_video", new f.C0084f(this.ay));
                }
            }
        }
    }

    public void gp() {
        if (!Util.V() && "H265".equals(fZ())) {
            com.oppo.camera.e.a("VideoMode", "checkVideoCodecAndReset, reset video codec to default.");
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString("pref_video_codec_key", ga());
            edit.apply();
        }
    }

    /* access modifiers changed from: protected */
    public void b(byte[] bArr, boolean z) {
        this.X.i();
        this.bC = true;
        this.bE = this.aq;
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        this.Y.d(true, false);
    }

    public void f(boolean z) {
        super.f(z);
        this.bw = System.currentTimeMillis();
        this.bx = -1;
    }

    public boolean b(float f) {
        float[] configFloatArrayValue;
        if (!f(CameraFunction.SAT_CAMERA)) {
            return false;
        }
        if (!dR() || (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_VIDEO_SAT_60FPS_MAIN_ZOOM_RANGE)) == null || configFloatArrayValue.length != 2) {
            return super.b(f);
        }
        if (Float.compare(f, configFloatArrayValue[1]) <= 0) {
            return true;
        }
        return false;
    }

    public boolean a(float f) {
        float[] configFloatArrayValue;
        if (!f(CameraFunction.SAT_CAMERA)) {
            return false;
        }
        if (!dR() || (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_VIDEO_SAT_60FPS_MAIN_ZOOM_RANGE)) == null || configFloatArrayValue.length != 2) {
            return super.a(f);
        }
        if (Float.compare(f, configFloatArrayValue[0]) < 0 || Float.compare(f, configFloatArrayValue[1]) > 0 || aT()) {
            return false;
        }
        return true;
    }

    private void I(boolean z) {
        String str;
        VideoRecordMsgData videoRecordMsgData = new VideoRecordMsgData(this.Z);
        videoRecordMsgData.mCaptureMode = a();
        boolean z2 = true;
        videoRecordMsgData.mCaptureType = g() ^ true ? 1 : 0;
        videoRecordMsgData.mVideoMode = a();
        videoRecordMsgData.mVideoTime = this.aw;
        videoRecordMsgData.mVideoSizeType = dk();
        videoRecordMsgData.mFlashMode = bu();
        videoRecordMsgData.mAvaliableStorage = z.c(z.r) / 1024;
        videoRecordMsgData.mOrientation = this.k;
        videoRecordMsgData.mVideoCodec = fZ();
        videoRecordMsgData.mIsSDCard = String.valueOf("on".equals(this.aa.getString("pref_camera_storage_key", this.Z.getString(R.string.camera_storage_default_value))));
        if (this.X.m()) {
            videoRecordMsgData.mCameraEnterType = String.valueOf(3);
        }
        videoRecordMsgData.mCameraId = this.X.ar();
        if (f("key_support_video_recorder") && !this.t) {
            videoRecordMsgData.mVideoRecorderSound = this.ba;
            this.ba = this.aa.getString(this.t ? "pref_sound_types_key_front" : "pref_sound_types_key_rear", this.Z.getString(R.string.camera_video_default_sound));
            if (!VideoRecordMsgData.END_TYPE_NORMAL.equals(this.ba)) {
                videoRecordMsgData.mNoiseFilter = this.bb;
            }
        }
        if (e("pref_zoom_key")) {
            videoRecordMsgData.mZoomValue = String.valueOf(this.X.ad());
        }
        if (e("pref_camera_video_slogan_key")) {
            videoRecordMsgData.mIsCustomSlogan = TextUtils.isEmpty(this.aa.getString("pref_video_slogan_customize_key", "")) ? "0" : "1";
            videoRecordMsgData.mIsLocationSlogan = this.aa.getString("pref_video_slogan_location_key", this.Z.getString(R.string.camera_slogan_default_value));
            videoRecordMsgData.mIsModelSlogan = this.aa.getString("pref_video_slogan_device_key", this.Z.getString(R.string.camera_slogan_default_value));
            videoRecordMsgData.mIsTimeSlogan = this.aa.getString("pref_video_slogan_time_key", this.Z.getString(R.string.camera_slogan_default_value));
        }
        if (f(CameraFunction.KEY_VIDEO_HYPER_LAPSE_PROCESS)) {
            videoRecordMsgData.mMotionFastVideo = this.aa.getString("pref_video_hyper_lapse_key", this.Z.getString(R.string.camera_video_hyper_lapse_default_value));
            if ("on".equals(videoRecordMsgData.mMotionFastVideo)) {
                if (E() != 0) {
                    videoRecordMsgData.mPosterizeTime = (30 / E()) + "X";
                }
                videoRecordMsgData.mTouchXYMotionFastVideo = this.Y.r();
            }
        }
        videoRecordMsgData.mSmooth = bX();
        if (videoRecordMsgData.mSmooth == 102) {
            videoRecordMsgData.parseFaceBeauty(dh());
        }
        videoRecordMsgData.mIsRecordLocation = this.aa.getString("pref_camera_recordlocation_key", this.Z.getString(R.string.camera_location_default_value));
        videoRecordMsgData.mPreviewCaptureCostTime = this.bx;
        if (K()) {
            videoRecordMsgData.mIsMirror = bA();
        }
        if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(a())) {
            str = fY() + NvsStreamingContext.COMPILE_FPS;
        } else {
            str = String.valueOf(dj());
        }
        videoRecordMsgData.mVideoFps = str;
        if (e("pref_filter_process_key") && g.f4385a != cf()) {
            if (ApsConstant.REC_MODE_MICROSCOPE.equals(a())) {
                videoRecordMsgData.mAncFilterType = p(cf());
            } else {
                videoRecordMsgData.mFilterType = p(cf());
            }
        }
        if (f("pref_camera_videoflashmode_key") || f("pref_camera_torch_mode_key")) {
            videoRecordMsgData.mFlashMode = bu();
        }
        if (!this.t) {
            videoRecordMsgData.mAeAfLock = String.valueOf(this.bu);
        }
        if (e("pref_zoom_key")) {
            videoRecordMsgData.mZoomValue = String.valueOf(this.X.ad());
        }
        if (this.aa == null || !this.aa.getBoolean("pref_camera_statement_agree", false)) {
            z2 = false;
        }
        com.oppo.camera.w.b.a(videoRecordMsgData, z2, this.X.v());
        videoRecordMsgData.mFlashTrigger = com.oppo.camera.a.a.a(bu());
        videoRecordMsgData.mTouchXYValue = this.X.Y();
        videoRecordMsgData.mTouchEVValue = this.X.aa();
        videoRecordMsgData.mVolumeFunction = this.aa.getString("pref_volume_key_function_key", this.Z.getString(R.string.camera_volume_key_function_default_value));
        videoRecordMsgData.mIsShutterVoice = this.aa.getString("pref_camera_sound_key", this.Z.getString(R.string.camera_sound_default_value));
        videoRecordMsgData.mFaceCount = this.bA;
        videoRecordMsgData.mScreenBrightness = this.r;
        if (f("pref_none_sat_ultra_wide_angle_key")) {
            videoRecordMsgData.mIsWideAngle = this.aa.getString("pref_none_sat_ultra_wide_angle_key", this.Z.getString(R.string.ultra_wide_angle_default_value));
        }
        if (eu()) {
            videoRecordMsgData.mBlurLevel = es();
        }
        videoRecordMsgData.mStartVideoRecordingOrientation = this.by;
        videoRecordMsgData.mStartVideoRecordingFaceCount = this.bz;
        videoRecordMsgData.mMemoryValue = String.valueOf(Util.i((Context) this.Z));
        videoRecordMsgData.mFilePath = this.aL;
        videoRecordMsgData.mShutterType = this.bB + DcsMsgData.DIVIDER + bB();
        if (f(CameraFunction.VIDEO_HDR)) {
            videoRecordMsgData.mIs3HDR = n(cJ());
        }
        if (f(CameraFunction.ULTRA_NIGHT_VIDEO)) {
            videoRecordMsgData.mIsNightScene = this.aa.getString("key_ultra_night_video", "off");
        }
        if (f(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            videoRecordMsgData.mIsAiEnhance = this.aa.getString("key_ai_enhancement_video", "off");
            videoRecordMsgData.mAiEnhanceSceneStart = this.aI;
            videoRecordMsgData.mAiEnhanceSceneEnd = this.aJ;
            videoRecordMsgData.mAiEnhanceSceneChangeCount = this.aK;
        }
        if (f("pref_video_super_eis_key")) {
            videoRecordMsgData.mIsStablized = this.aa.getString("pref_video_super_eis_key", "off");
        }
        if (f("key_support_super_eis_wide_menu")) {
            if ("off".equals(this.aa.getString("pref_video_super_eis_key", "off"))) {
                videoRecordMsgData.mUltraSteady = MenuClickMsgData.ULTRA_OFF;
            } else if (this.aa.getBoolean("pref_super_eis_wide_key", false)) {
                videoRecordMsgData.mUltraSteady = MenuClickMsgData.ULTRA_ON;
            } else {
                videoRecordMsgData.mUltraSteady = MenuClickMsgData.ULTRA_OFF;
            }
        }
        if ("".equals(this.aB)) {
            this.aB = VideoRecordMsgData.END_TYPE_NORMAL;
        }
        videoRecordMsgData.mEndType = this.aB;
        videoRecordMsgData.mRearOrFront = this.t ? DcsMsgData.FRONT : DcsMsgData.REAR;
        if (f("pref_inertial_zoom_key") && this.aa != null) {
            videoRecordMsgData.mSmoothZoom = this.aa.getString("pref_inertial_zoom_key", this.Z.getString(R.string.camera_face_rectify_default_value));
        }
        if (f("pref_camera_line_video")) {
            if (this.aa != null) {
                videoRecordMsgData.mVideoAssistantLine = this.aa.getString("pref_camera_line_video", "off");
            }
            videoRecordMsgData.mSpiritLevel = this.aa.getString("pref_assist_gradienter", "off");
            if ("on".equals(videoRecordMsgData.mSpiritLevel)) {
                videoRecordMsgData.mIsOverlap = String.valueOf(this.Y.ac());
            }
            if (this.Y.ac()) {
                videoRecordMsgData.mHorizontalOrVertical = this.Y.ad();
            }
        }
        if (gv()) {
            videoRecordMsgData.mIsDragBox = String.valueOf(z);
        }
        b((DcsMsgData) videoRecordMsgData);
        videoRecordMsgData.report();
    }

    /* access modifiers changed from: protected */
    public void b(String str, String str2) {
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.Z, false);
        if (this.X != null) {
            if (this.X.m()) {
                reminderMsgData.mCameraEnterType = String.valueOf(3);
            }
            reminderMsgData.mCameraId = this.X.ar();
        }
        reminderMsgData.mCaptureMode = a();
        reminderMsgData.mCaptureType = 1;
        reminderMsgData.mOrientation = this.k;
        reminderMsgData.mReminderTypeValue = str;
        reminderMsgData.mReminderCodeValue = str2;
        reminderMsgData.mbRecording = dO();
        reminderMsgData.mRearOrFront = this.t ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    /* access modifiers changed from: protected */
    public String[] de() {
        return com.oppo.camera.ui.e.d;
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        super.a(sharedPreferences, str);
        if ("pref_camera_videoflashmode_key".equals(str) && fW() && this.aa.getBoolean("pref_super_eis_wide_key", false) && "on".equals(sharedPreferences.getString("pref_video_super_eis_key", "off")) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            this.X.c(true);
            this.aa.edit().putBoolean("pref_super_eis_wide_key", false).apply();
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS)) {
                this.aa.edit().putString("pref_video_fps_key", String.valueOf(60)).apply();
            }
            this.X.c(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean gq() {
        return !en() && !ep();
    }

    private boolean gM() {
        return (ex() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) || (fE() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS)) || gr() || f("key_intelligent_high_frame_usage_key");
    }

    /* access modifiers changed from: protected */
    public void eN() {
        this.bD = false;
        com.oppo.camera.e.b("VideoMode", "stopRecordingFrame, isHyperLapseOpen: " + gr());
        if (f("key_intelligent_high_frame_usage_key") || gr()) {
            this.aX.removeMessages(2);
            this.aX.sendEmptyMessage(2);
        }
        if (this.bk && this.X != null) {
            this.X.c(5);
        }
    }

    /* access modifiers changed from: protected */
    public Surface eS() {
        Surface surface;
        synchronized (this.az) {
            surface = this.ay;
        }
        return surface;
    }

    public boolean w(String str) {
        if ("type_main_preview_frame".equals(str) || "type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return (!Util.p() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && ex() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL);
        }
        return super.w(str);
    }

    public boolean eo() {
        return f("pref_camera_video_slogan_key") && gi() && !en();
    }

    private boolean gN() {
        return this.bG || (ex() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL) && eo());
    }

    public boolean fm() {
        return Util.p();
    }

    public void bc() {
        boolean dO = dO();
        com.oppo.camera.e.b("VideoMode", "stopVideoRecordingByTemperatureSafety, isVideoRecording: " + dO);
        if (dO) {
            this.Y.a((int) R.string.camera_high_temperature_video_record_disable, -1, true, false, false);
            b(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_VIDEO);
            this.aB = VideoRecordMsgData.END_TYPE_TEMP_LIMIT;
            o(true);
        }
    }

    public void a(int i, int i2) {
        if (47 <= i2 && f("key_temperature_control_stop_video_recording")) {
            bc();
        }
        if (this.aa != null) {
            this.aa.edit().putFloat("key_cur_temperature", (float) i2).apply();
        }
    }

    private boolean gO() {
        return gi() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT);
    }
}
