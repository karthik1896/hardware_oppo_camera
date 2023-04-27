package com.oppo.camera.e;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import color.support.v7.app.b;
import com.meicam.sdk.NvsStreamingContext;
import com.oppo.camera.R;
import com.oppo.camera.aps.ApsAdapterConstant;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.doubleexposure.b;
import com.oppo.camera.doubleexposure.g;
import com.oppo.camera.e.h;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.DoubleExposureMsgData;
import com.oppo.camera.statistics.model.ReminderMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.ui.widget.e;
import com.oppo.camera.util.Util;
import java.io.File;
import java.io.FileFilter;

/* compiled from: DoubleExposureMode */
public class h extends f implements View.OnClickListener {
    /* access modifiers changed from: private */
    public a aT = a.FIRST_STAGE_PREVIEW;
    /* access modifiers changed from: private */
    public a aU = a.FIRST_STAGE_PREVIEW;
    private boolean aV = true;
    private boolean aW = false;
    private boolean aX = false;
    /* access modifiers changed from: private */
    public boolean aY = false;
    private String aZ = "";
    private String ba = "";
    /* access modifiers changed from: private */
    public b bb = null;
    private b bc = null;
    private color.support.v7.app.b bd;
    private int be = 0;
    private RotateImageView bf = null;
    private e bg = null;
    private boolean bh = false;
    /* access modifiers changed from: private */
    public boolean bi = false;
    private boolean bj = false;
    private boolean bk = false;
    private long bl = 0;
    private long bm = 0;
    private boolean bn = false;
    /* access modifiers changed from: private */
    public boolean bo = false;
    private final DialogInterface.OnClickListener bp = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            if (a.SECOND_STAGE_PREVIEW == h.this.fN()) {
                h.this.a(a.FIRST_STAGE_PREVIEW);
                h.this.Y.ay();
                h.this.gH();
                h.this.gF();
                if (h.this.aY) {
                    h.this.a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE0, "cancel");
                } else {
                    h.this.a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE1, "cancel");
                }
            } else if (a.SECOND_STAGE_REPLAY == h.this.fN()) {
                h.this.a(a.SECOND_STAGE_PREVIEW);
                h.this.Y.az();
                h hVar = h.this;
                hVar.a(hVar.bb, false, (g.a) null);
                h.this.gG();
                h.this.a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, "cancel");
            }
            h.this.Y.a(h.this.o());
            h.this.gD();
            h.this.gE();
        }
    };
    private com.oppo.camera.doubleexposure.a bq = new com.oppo.camera.doubleexposure.a() {
        public void a() {
            com.oppo.camera.e.a("DoubleExposureMode", "hideBlurView, mState: " + h.this.fN());
            if ((h.this.fN() == a.SECOND_STAGE_PREVIEW || h.this.fN() == a.SECOND_STAGE_REPLAY) && h.this.Y != null) {
                h.this.Y.aC();
                boolean unused = h.this.bo = false;
            }
        }
    };
    private final DialogInterface.OnClickListener br = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            if (a.SECOND_STAGE_REPLAY == h.this.fN()) {
                h.this.a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, "exit");
            }
            if (a.FIRST_STAGE_PAUSED == h.this.fN() || a.SECOND_STAGE_PAUSED == h.this.fN()) {
                h.this.bb();
            }
            h.this.C(false);
        }
    };

    /* compiled from: DoubleExposureMode */
    enum a {
        FIRST_STAGE_PREVIEW,
        FIRST_STAGE_RECORDING,
        FIRST_STAGE_PAUSED,
        SECOND_STAGE_PREVIEW,
        SECOND_STAGE_RECORDING,
        SECOND_STAGE_PAUSED,
        SECOND_STAGE_REPLAY
    }

    public String a() {
        return ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
    }

    public boolean ax() {
        return false;
    }

    public String b() {
        return ApsConstant.FEATURE_REC_DOUBLE_EXPOSURE;
    }

    public int c() {
        return 32779;
    }

    public boolean c(String str) {
        return false;
    }

    public boolean d() {
        return true;
    }

    public String dk() {
        return "video_size_720p";
    }

    public boolean ej() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean en() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean ep() {
        return true;
    }

    public boolean f() {
        return true;
    }

    /* access modifiers changed from: protected */
    public long fM() {
        return 15000;
    }

    /* access modifiers changed from: protected */
    public boolean fP() {
        return false;
    }

    public boolean fx() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return false;
    }

    public h(Activity activity, b bVar, com.oppo.camera.ui.e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public void u() {
        super.u();
        this.ab.j(this.aa.getInt("pref_double_exposure_effect_type", 5));
    }

    public void f(boolean z) {
        super.f(z);
        boolean z2 = this.aa.getBoolean("key_bottom_guide_double_exposure", true);
        if (this.aa.getBoolean("pref_double_exposure_tips", true) || z2) {
            this.aa.edit().putInt("pref_double_exposure_open_count", this.be).apply();
        }
        gD();
        gE();
    }

    public void j(boolean z) {
        super.j(z);
        a(a.FIRST_STAGE_PREVIEW);
        gD();
        gE();
    }

    public void am() {
        super.am();
        this.bo = false;
        if (this.ab != null) {
            this.ab.q();
        }
    }

    public boolean f(String str) {
        if (CameraFunction.DOUBLE_EXPOSURE.equals(str) || "key_video_duration_limit".equals(str) || "support_video_count_down".equals(str)) {
            return true;
        }
        if ("pref_camera_torch_mode_key".equals(str)) {
            return f(CameraFunction.TORCH_SOFT_LIGHT);
        }
        if ("pref_support_recording_capture".equals(str) || "pref_video_size_key".equals(str) || "key_support_show_soloop".equals(str) || "pref_sound_types_key_rear".equals(str) || "pref_sound_types_key_front".equals(str) || "pref_video_noise_filter_key".equals(str) || CameraFunction.VIDEO_HDR.equals(str) || CameraFunction.ULTRA_NIGHT_VIDEO.equals(str) || CameraFunction.AI_ENHANCEMENT_VIDEO.equals(str) || "pref_filter_process_key".equals(str) || CameraFunction.FACE_BEAUTY_PROCESS.equals(str) || "pref_video_eis".equals(str) || CameraFunction.VIDEO_BLUR_PROCESS.equals(str) || "pref_video_blur_menu".equals(str) || CameraFunction.SAT_CAMERA.equals(str) || "pref_video_super_eis_key".equals(str) || CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS.equals(str) || "key_support_super_eis_wide_menu".equals(str) || CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE.equals(str) || "key_suppport_multi_focus".equals(str) || "pref_10bits_heic_encode_key".equals(str) || "key_support_show_low_ambient_light_hint".equals(str) || "pref_inertial_zoom_key".equals(str) || "pref_video_size_fps_settings".equals(str) || "key_support_video_high_fps".equals(str)) {
            return false;
        }
        if (!"pref_camera_video_slogan_key".equals(str)) {
            return super.f(str);
        }
        if (a.FIRST_STAGE_RECORDING == fN()) {
            return false;
        }
        return true;
    }

    public boolean d(String str) {
        String c = com.oppo.camera.entry.b.c(str);
        if ("pref_camera_torch_mode_key".equals(c) || "pref_none_sat_ultra_wide_angle_key".equals(c) || "pref_camera_videoflashmode_key".equals(c)) {
            if (a.SECOND_STAGE_REPLAY == fN() || !f(c)) {
                return false;
            }
            return true;
        } else if (!"pref_setting_key".equals(c)) {
            return false;
        } else {
            if (a.SECOND_STAGE_REPLAY != fN()) {
                return true;
            }
            return false;
        }
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        super.a(sharedPreferences, str);
        if (!"key_bottom_guide_double_exposure".equals(str) || a.FIRST_STAGE_PREVIEW != fN()) {
            SharedPreferences sharedPreferences2 = this.aa;
            String str2 = DoubleExposureMsgData.KEY_VIDEO_OPEN_TYPE_VALUE_FIRST_GUIDE;
            if (sharedPreferences2 == null || !"pref_double_exposure_tips".equals(str)) {
                if (this.aa != null && "pref_double_exposure_open_count".equals(str)) {
                    int i = this.aa.getInt("pref_double_exposure_open_count", 0);
                    boolean z = this.aa.getBoolean("key_bottom_guide_double_exposure", true);
                    if (3 == i && this.Y != null) {
                        this.bm = SystemClock.uptimeMillis();
                        this.Y.a(this.Z.findViewById(R.id.load_video_button), 16, 0, (int) ((float) this.Z.getResources().getDimensionPixelSize(R.dimen.video_clip_view_tip_offset)));
                    } else if (!z && 3 > i && a.FIRST_STAGE_PREVIEW == fN()) {
                        G((int) R.string.camera_double_exposure_first_video_hint);
                    }
                } else if ("pref_double_exposure_effect_type".equals(str)) {
                    if (5 == this.aa.getInt("pref_double_exposure_effect_type", 5)) {
                        a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_EFFECT, "mixed");
                    } else {
                        a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_EFFECT, "silhouette");
                    }
                } else if (this.aa != null && "key_double_exposure_guid_page_and_duration".equals(str)) {
                    String string = this.aa.getString("key_double_exposure_guid_page_and_duration", "");
                    String[] strArr = null;
                    if (!TextUtils.isEmpty(string)) {
                        strArr = string.split(":");
                    }
                    if (strArr != null && 2 < strArr.length) {
                        boolean z2 = this.aa.getBoolean("key_bottom_guide_double_exposure", true);
                        String str3 = strArr[0];
                        String str4 = strArr[1];
                        String str5 = strArr[2];
                        if (!z2) {
                            str2 = DoubleExposureMsgData.KEY_VIDEO_OPEN_TYPE_VALUE_DURABLE_GUIDE;
                        }
                        a(str3, str4, str5, str2);
                    }
                } else if ("pref_camera_videoflashmode_key".equals(str) && this.aa.getString("pref_camera_videoflashmode_key", "off").equals("off")) {
                    gD();
                }
            } else if (!this.aa.getBoolean("pref_double_exposure_tips", false)) {
                G((int) R.string.camera_double_exposure_first_video_hint);
                a(String.valueOf(-1), String.valueOf(SystemClock.uptimeMillis() - this.bm), DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CLICK, str2);
            }
        } else {
            G((int) R.string.camera_double_exposure_first_video_hint);
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        this.bo = fN() != a.FIRST_STAGE_PREVIEW;
        this.bh = false;
        this.Y.c(16, true);
        fT();
        super.p();
    }

    /* renamed from: com.oppo.camera.e.h$4  reason: invalid class name */
    /* compiled from: DoubleExposureMode */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2882a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.oppo.camera.e.h$a[] r0 = com.oppo.camera.e.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2882a = r0
                int[] r0 = f2882a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.oppo.camera.e.h$a r1 = com.oppo.camera.e.h.a.SECOND_STAGE_REPLAY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2882a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.oppo.camera.e.h$a r1 = com.oppo.camera.e.h.a.FIRST_STAGE_PREVIEW     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2882a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.oppo.camera.e.h$a r1 = com.oppo.camera.e.h.a.SECOND_STAGE_PREVIEW     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.h.AnonymousClass4.<clinit>():void");
        }
    }

    public c o() {
        c cVar;
        if (AnonymousClass4.f2882a[fN().ordinal()] != 1) {
            cVar = super.o();
        } else {
            cVar = new c(21, "button_color_inside_none", "button_shape_ring_none", 0);
        }
        cVar.b(true);
        return cVar;
    }

    public void bh() {
        super.h(true);
        this.Z.runOnUiThread(new Runnable() {
            public final void run() {
                h.this.gS();
            }
        });
        if (a.FIRST_STAGE_PREVIEW == this.aT) {
            a(a.FIRST_STAGE_RECORDING);
            this.aV = false;
            this.Y.at();
        } else if (a.SECOND_STAGE_PREVIEW == this.aT) {
            a(a.SECOND_STAGE_RECORDING);
            this.aV = false;
            this.Y.au();
            gI();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gS() {
        this.Y.k(15000);
        c cVar = new c();
        cVar.a(22);
        cVar.b(1);
        cVar.b(true);
        this.Y.a(cVar);
    }

    /* access modifiers changed from: protected */
    public void G(boolean z) {
        gl();
        super.G(z);
        if (a.FIRST_STAGE_RECORDING == fN() || a.FIRST_STAGE_PAUSED == fN()) {
            a(a.SECOND_STAGE_PREVIEW);
        } else if (a.SECOND_STAGE_RECORDING == fN() || a.SECOND_STAGE_PAUSED == fN()) {
            a(a.SECOND_STAGE_REPLAY);
        }
        gD();
        gE();
    }

    public void a(b bVar, g.a aVar) {
        com.oppo.camera.e.a("DoubleExposureMode", "onVideoLoadedDone, clipVideoInfo: " + bVar);
        this.aW = false;
        this.aZ = bVar.c();
        this.bb = bVar;
        b(this.bb, aVar);
    }

    public void fu() {
        com.oppo.camera.e.a("DoubleExposureMode", "onVideoRecordingFinish, mState: " + fN());
        if (a.SECOND_STAGE_PREVIEW == this.aT || a.FIRST_STAGE_RECORDING == this.aT || a.FIRST_STAGE_PAUSED == this.aT) {
            a(a.SECOND_STAGE_PREVIEW);
            this.Z.runOnUiThread(new Runnable() {
                public final void run() {
                    h.this.gR();
                }
            });
            this.aZ = this.aM;
            this.bb = new b(this.aZ);
            b(this.bb, (g.a) null);
        } else if (a.SECOND_STAGE_REPLAY == this.aT || a.SECOND_STAGE_RECORDING == this.aT || a.SECOND_STAGE_PAUSED == this.aT) {
            a(a.SECOND_STAGE_REPLAY);
            gx();
        }
        gD();
        gE();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gR() {
        c cVar = new c(6, "button_color_inside_red", "button_shape_ring_none", 1);
        cVar.b(true);
        this.Y.a(cVar);
    }

    public void fv() {
        com.oppo.camera.e.a("DoubleExposureMode", "onVideoRecordingFail, mState: " + fN());
        if (a.SECOND_STAGE_PREVIEW == this.aT || a.FIRST_STAGE_RECORDING == this.aT) {
            c((int) R.string.camera_double_exposure_recording_hint, (int) ApsAdapterConstant.LOG_INTERVAL);
            I((int) R.string.camera_double_exposure_recording_hint);
            a(a.FIRST_STAGE_PREVIEW);
            I(false);
        }
        if (a.FIRST_STAGE_PREVIEW == fN()) {
            c((int) R.string.camera_double_exposure_recording_hint, (int) ApsAdapterConstant.LOG_INTERVAL);
            I((int) R.string.camera_double_exposure_recording_hint);
        } else if (a.SECOND_STAGE_REPLAY == this.aT || a.SECOND_STAGE_RECORDING == this.aT) {
            c((int) R.string.camera_double_exposure_recording_hint, (int) ApsAdapterConstant.LOG_INTERVAL);
            I((int) R.string.camera_double_exposure_recording_hint);
            a(a.SECOND_STAGE_PREVIEW);
            c cVar = new c(6, "button_color_inside_red", "button_shape_ring_none", 1);
            cVar.b(true);
            this.Y.a(cVar);
            b(this.bb, (g.a) null);
        }
        gD();
        gE();
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (h.this.Y != null) {
                    h.this.Y.j();
                }
            }
        });
    }

    private void gx() {
        com.oppo.camera.e.a("DoubleExposureMode", "onSecondStateRecordingFinish, mVideoFilename: " + this.aM);
        this.bl = SystemClock.uptimeMillis();
        this.ba = this.aM;
        this.bc = new b(this.ba);
        a("2", this.bc);
        this.Y.av();
        a(this.bc, true, (g.a) null);
        a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, DoubleExposureMsgData.KEY_FUNC_VALUE_SAVE);
        this.Z.runOnUiThread(new Runnable() {
            public final void run() {
                h.this.gQ();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gQ() {
        c cVar = new c(17, "button_color_inside_none", "button_shape_ring_none", 0);
        cVar.b(true);
        this.Y.a(cVar);
    }

    private void b(final b bVar, final g.a aVar) {
        com.oppo.camera.e.a("DoubleExposureMode", "onFirstStageDone, clipVideoInfo: " + bVar);
        a(a.SECOND_STAGE_PREVIEW);
        if (aVar == null) {
            a("1", bVar);
            this.Y.aw();
            a(bVar, false, (g.a) null);
            this.aY = false;
            a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE1, DoubleExposureMsgData.KEY_FUNC_VALUE_SAVE);
            return;
        }
        a(bVar, false, new g.a() {
            public void onVideoClipDone() {
                h.this.a("0", bVar);
                aVar.onVideoClipDone();
                h.this.Y.aw();
                boolean unused = h.this.aY = true;
                h.this.a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE0, DoubleExposureMsgData.KEY_FUNC_VALUE_SAVE);
                h.this.au.postDelayed(new Runnable() {
                    public final void run() {
                        h.AnonymousClass8.this.a();
                    }
                }, 300);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a() {
                h.this.gD();
                h.this.gE();
            }
        });
    }

    private void I(boolean z) {
        com.oppo.camera.e.a("DoubleExposureMode", "onSecondStageDone, isNeedButtonAnim: " + z);
        gH();
        fU();
        this.Z.runOnUiThread(new Runnable(z) {
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                h.this.J(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(boolean z) {
        c cVar;
        this.Y.ax();
        if (z) {
            cVar = new c(19, "button_color_inside_red", "button_shape_ring_none", 0);
        } else {
            cVar = new c(6, "button_color_inside_red", "button_shape_ring_none", 1);
        }
        cVar.b(true);
        this.Y.a(cVar);
        this.bn = false;
    }

    private void gy() {
        com.oppo.camera.v.c.a().a(new Runnable() {
            public void run() {
                h.this.gz();
            }
        }, "clear cache video");
    }

    /* access modifiers changed from: private */
    public void gz() {
        com.oppo.camera.e.a("DoubleExposureMode", "deleteCacheVideos");
        File[] listFiles = new File(gJ()).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().contains(".mp4");
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    public void dI() {
        com.oppo.camera.e.a("DoubleExposureMode", "onVideoShutterButtonClick, mState: " + fN());
        if (gC()) {
            com.oppo.camera.e.a("DoubleExposureMode", "onVideoShutterButtonClick, need wait hide blur");
        } else if (this.bn) {
            com.oppo.camera.e.a("DoubleExposureMode", "onVideoShutterButtonClick Cannot record while saving");
        } else {
            if (a.SECOND_STAGE_REPLAY == fN()) {
                this.bn = true;
                a(a.FIRST_STAGE_PREVIEW);
                this.aP.put("relative_path", super.ft());
                this.aO = com.oppo.camera.util.storage.a.a(this.Z, this.Z.getContentResolver(), this.aP);
                com.oppo.camera.v.c.a().a(new Runnable() {
                    public final void run() {
                        h.this.gP();
                    }
                }, "save-video");
            } else {
                super.dI();
            }
            gD();
            gE();
            this.bo = false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[SYNTHETIC, Splitter:B:24:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007c A[SYNTHETIC, Splitter:B:35:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084 A[Catch:{ IOException -> 0x0080 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void gP() {
        /*
            r5 = this;
            r0 = 0
            android.app.Activity r1 = r5.Z     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            android.net.Uri r2 = r5.aO     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.lang.String r3 = "rw"
            android.os.ParcelFileDescriptor r1 = r1.openFileDescriptor(r2, r3)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r5.aS = r1     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.lang.String r2 = r5.aM     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003d, all -> 0x0037 }
            android.os.ParcelFileDescriptor r3 = r5.aS     // Catch:{ IOException -> 0x003d, all -> 0x0037 }
            java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ IOException -> 0x003d, all -> 0x0037 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x003d, all -> 0x0037 }
            android.os.FileUtils.copy(r1, r2)     // Catch:{ IOException -> 0x0032, all -> 0x002d }
            r1.close()     // Catch:{ IOException -> 0x0051 }
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x005c
        L_0x002d:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x007a
        L_0x0032:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0048
        L_0x0037:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r1
            r1 = r4
            goto L_0x007a
        L_0x003d:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r1
            r1 = r4
            goto L_0x0048
        L_0x0043:
            r1 = move-exception
            r2 = r0
            goto L_0x007a
        L_0x0046:
            r1 = move-exception
            r2 = r0
        L_0x0048:
            r1.printStackTrace()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0053
            r0.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            goto L_0x0059
        L_0x0053:
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x005c
        L_0x0059:
            r0.printStackTrace()
        L_0x005c:
            com.oppo.camera.ui.control.e$c r0 = new com.oppo.camera.ui.control.e$c
            r0.<init>()
            r1 = 1
            r0.k = r1
            r2 = 0
            java.lang.String r3 = r5.gc()
            r5.a((com.oppo.camera.ui.control.e.c) r0, (boolean) r2, (java.lang.String) r3)
            r5.a((com.oppo.camera.ui.control.e.c) r0)
            r5.gf()
            r5.gB()
            r5.I((boolean) r1)
            return
        L_0x0079:
            r1 = move-exception
        L_0x007a:
            if (r0 == 0) goto L_0x0082
            r0.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0082
        L_0x0080:
            r0 = move-exception
            goto L_0x0088
        L_0x0082:
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x008b
        L_0x0088:
            r0.printStackTrace()
        L_0x008b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.h.gP():void");
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
        if (this.bj && !this.bk) {
            this.bj = false;
            this.bk = false;
            com.oppo.camera.e.a("DoubleExposureMode", "DoubleExposureMode, onResume, mbNeedRestore");
        } else if (this.aW) {
            this.aW = false;
            this.Y.ax();
        } else {
            int i = AnonymousClass4.f2882a[this.aT.ordinal()];
            if (i == 1) {
                gx();
            } else if (i == 2) {
                I(false);
                gA();
            } else if (i == 3) {
                b bVar = this.bb;
                if (bVar != null) {
                    b(bVar, (g.a) null);
                    return;
                }
                this.bo = false;
                a(a.FIRST_STAGE_PREVIEW);
                I(false);
            }
        }
    }

    private void gA() {
        if (this.ab != null && this.aX) {
            this.ab.r();
            this.ab.j(this.aa.getInt("pref_double_exposure_effect_type", 5));
        }
        this.aX = true;
    }

    private void gB() {
        gF();
        gG();
        this.aZ = "";
        this.ba = "";
    }

    public void fw() {
        if (gC()) {
            com.oppo.camera.e.a("DoubleExposureMode", "revertOp, need wait hide blur");
            return;
        }
        com.oppo.camera.e.a("DoubleExposureMode", "revertOp");
        fS();
    }

    public void C(boolean z) {
        if (gC()) {
            com.oppo.camera.e.a("DoubleExposureMode", "cancelOp, need wait hide blur");
            return;
        }
        com.oppo.camera.e.a("DoubleExposureMode", "cancelOp, showDialog: " + z);
        if (z) {
            fR();
        } else {
            a(a.FIRST_STAGE_PREVIEW);
            this.Y.ay();
            gH();
            gF();
            gG();
            this.Y.a(o());
        }
        gD();
        gE();
    }

    private boolean gC() {
        return this.bo && a.FIRST_STAGE_PREVIEW != fN();
    }

    /* access modifiers changed from: private */
    public void gD() {
        boolean z = this.aa.getBoolean("key_bottom_guide_double_exposure", true);
        boolean z2 = this.aa.getBoolean("pref_double_exposure_tips", true);
        if (z || gM() || (z2 && 3 == this.be && a.SECOND_STAGE_PREVIEW != fN())) {
            H(R.string.camera_double_exposure_first_video_hint);
            H(R.string.camera_double_exposure_two_video_hint);
        } else if (a.FIRST_STAGE_PREVIEW == fN()) {
            G((int) R.string.camera_double_exposure_first_video_hint);
        } else if (a.SECOND_STAGE_PREVIEW == fN()) {
            G((int) R.string.camera_double_exposure_two_video_hint);
        } else {
            H(R.string.camera_double_exposure_first_video_hint);
            H(R.string.camera_double_exposure_two_video_hint);
        }
    }

    /* access modifiers changed from: private */
    public void gE() {
        this.Z.runOnUiThread(new Runnable() {
            public final void run() {
                h.this.gO();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gO() {
        if (this.bf == null || gM()) {
            Util.a((View) this.bf, 8, (Animation.AnimationListener) null, 200);
        } else if (a.FIRST_STAGE_PREVIEW == fN()) {
            Util.a((View) this.bf, 0, (Animation.AnimationListener) null, 200);
        } else if (a.SECOND_STAGE_PREVIEW == fN()) {
            Util.a((View) this.bf, 0, (Animation.AnimationListener) null, 200);
        } else {
            Util.a((View) this.bf, 8, (Animation.AnimationListener) null, 200);
        }
    }

    /* access modifiers changed from: private */
    public void gF() {
        File file = new File(this.aZ);
        if (file.exists() && a(file)) {
            file.delete();
        }
    }

    /* access modifiers changed from: private */
    public void gG() {
        File file = new File(this.ba);
        if (file.exists() && a(file)) {
            file.delete();
        }
    }

    private boolean a(File file) {
        return file.getAbsolutePath().startsWith(gJ());
    }

    private void a(final e.c cVar) {
        if (this.X != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    h.this.X.a(cVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void gH() {
        if (this.ab != null) {
            this.ab.o();
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar, boolean z, g.a aVar) {
        if (this.y) {
            com.oppo.camera.e.a("DoubleExposureMode", "decodeVideo, cancel decode video, mbPaused: " + this.y);
        } else if (this.ab != null) {
            this.ab.a(new com.oppo.camera.doubleexposure.c(bVar, z, aVar, this.bq));
        }
    }

    private void gI() {
        if (this.ab != null) {
            this.ab.p();
        }
    }

    public boolean dK() {
        if (a.FIRST_STAGE_RECORDING == this.aT) {
            a(a.FIRST_STAGE_PAUSED);
        } else if (a.SECOND_STAGE_RECORDING == this.aT) {
            a(a.SECOND_STAGE_PAUSED);
        }
        return super.dK();
    }

    public boolean dL() {
        if (a.FIRST_STAGE_PAUSED == this.aT) {
            a(a.FIRST_STAGE_RECORDING);
        } else if (a.SECOND_STAGE_PAUSED == this.aT) {
            a(a.SECOND_STAGE_RECORDING);
        }
        return super.dL();
    }

    public a fN() {
        return this.aT;
    }

    public void a(a aVar) {
        this.aU = this.aT;
        this.aT = aVar;
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (h.this.Y == null) {
                    return;
                }
                if (a.SECOND_STAGE_REPLAY == h.this.aU || a.SECOND_STAGE_REPLAY == h.this.aT) {
                    h.this.Y.j();
                }
            }
        });
    }

    public void D(boolean z) {
        if (this.J) {
            this.bh = true;
            Util.am();
            return;
        }
        this.bh = false;
        this.aW = true;
        if (this.aa == null || !gj()) {
            this.aW = false;
            return;
        }
        RotateImageView rotateImageView = this.bf;
        if (rotateImageView != null) {
            Util.a((View) rotateImageView, 8, (Animation.AnimationListener) null, 200);
        }
        A(DoubleExposureMsgData.KEY_FUNC_ID_VALUE_TO_GALLERY);
        this.aa.edit().putString("PREF_VIDEO_CLIP_SAVE_PATH", this.aM).apply();
        this.aa.edit().putBoolean("pref_double_exposure_tips", false).apply();
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.setPackage("com.coloros.gallery3d");
        intent.putExtra("from-Camera-For-Limit", true);
        intent.putExtra("limit_type", 0);
        intent.putExtra("animation_type", 0);
        this.Z.startActivityForResult(intent, 11111);
        this.Z.overridePendingTransition(R.anim.gallery_video_in, R.anim.camera_video_out);
    }

    public void n(boolean z) {
        super.n(z);
        if (!this.J && this.bh) {
            D(false);
        }
    }

    /* access modifiers changed from: protected */
    public String fO() {
        String str;
        if (a.SECOND_STAGE_RECORDING == this.aT || a.FIRST_STAGE_RECORDING == this.aT || this.aW) {
            str = gJ();
        } else {
            str = super.fO();
        }
        com.oppo.camera.e.a("DoubleExposureMode", "getVideoSavePath, path: " + str + ", mState: " + this.aT);
        return str;
    }

    public String ft() {
        if (a.SECOND_STAGE_RECORDING == this.aT || a.FIRST_STAGE_RECORDING == this.aT) {
            return gJ();
        }
        return super.ft();
    }

    private String gJ() {
        return this.Z.getDataDir().getAbsolutePath() + File.separator + "files" + File.separator;
    }

    /* access modifiers changed from: protected */
    public boolean fQ() {
        return this.aV;
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("DoubleExposureMode", "onInitCameraMode");
        super.s();
        com.oppo.camera.v.c.a().a(new Runnable() {
            public void run() {
                if (!h.this.bi) {
                    NvsStreamingContext.init(h.this.Z.getApplicationContext(), "assets:/meicam.lic", 1);
                    boolean unused = h.this.bi = true;
                    if (h.this.Y != null) {
                        h.this.Y.aB();
                    }
                }
            }
        }, "init NvsStreamingContext");
        if (!(this.Y == null || this.aa == null)) {
            boolean z = this.aa.getBoolean("key_bottom_guide_double_exposure", true);
            boolean z2 = this.aa.getBoolean("pref_double_exposure_tips", true);
            if (z || z2) {
                this.be = this.aa.getInt("pref_double_exposure_open_count", 0);
                this.be++;
            }
            if (z) {
                this.Y.n(5);
            }
        }
        this.bg = (com.oppo.camera.ui.widget.e) this.Z.findViewById(R.id.video_clip_view);
        gN();
        this.bh = false;
        this.bn = false;
        gK();
    }

    private void gK() {
        String string = this.aa.getString("pref_video_size_key", fH());
        String string2 = this.aa.getString("pref_video_fps_key", "30");
        SharedPreferences.Editor edit = this.aa.edit();
        if (!"video_size_720p".equals(string) || Integer.parseInt(string2) != 30) {
            edit.putString("pref_old_video_fps", string2);
            edit.putString("pref_old_video_size", string);
            edit.putString("pref_video_size_key", "video_size_720p");
            edit.putString("pref_video_fps_key", String.valueOf(30));
            edit.apply();
            return;
        }
        edit.putString("pref_old_video_fps", "");
        edit.putString("pref_old_video_size", "");
        edit.apply();
    }

    private void gL() {
        String string = this.aa.getString("pref_old_video_size", fH());
        String string2 = this.aa.getString("pref_old_video_fps", String.valueOf(dj()));
        SharedPreferences.Editor edit = this.aa.edit();
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

    private boolean gM() {
        if (this.bg == null && this.Z != null) {
            this.bg = (com.oppo.camera.ui.widget.e) this.Z.findViewById(R.id.video_clip_view);
        }
        com.oppo.camera.ui.widget.e eVar = this.bg;
        return eVar != null && eVar.d();
    }

    private void G(int i) {
        if (this.Y == null || !(a.FIRST_STAGE_PREVIEW == fN() || a.SECOND_STAGE_PREVIEW == fN())) {
            H(i);
        } else {
            this.Y.a(i, 0, false, false, true, false, false, true, 5000);
        }
    }

    private void H(int i) {
        if (this.Y != null) {
            this.Y.a(true, false, true);
        }
    }

    private void c(int i, int i2) {
        if (this.Y != null) {
            this.Y.a(i, 0, true, false, false, false, false, true, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("DoubleExposureMode", "onDeInitCameraMode");
        super.t();
        RotateImageView rotateImageView = this.bf;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
        fT();
        this.bh = false;
        this.bn = false;
        this.Y.aA();
        H(R.string.camera_double_exposure_first_video_hint);
        H(R.string.camera_double_exposure_two_video_hint);
        gL();
        gy();
    }

    public int ao() {
        if (a.SECOND_STAGE_PREVIEW == fN()) {
            return (int) this.Z.getResources().getDimension(R.dimen.effect_menu_zoom_margin_bottom);
        }
        return super.ao();
    }

    public void B(boolean z) {
        super.B(z);
        boolean z2 = true;
        this.bj = true;
        this.bk = z;
        com.oppo.camera.ui.e eVar = this.Y;
        if (!(a.FIRST_STAGE_PREVIEW == fN() || a.SECOND_STAGE_RECORDING == fN() || a.FIRST_STAGE_RECORDING == fN())) {
            z2 = false;
        }
        eVar.J(z2);
    }

    public void fR() {
        fT();
        this.bd = new b.a(this.Z).f(1).setNeutralButton((int) R.string.camera_double_exposure_exit_hint, this.br).setNegativeButton((int) R.string.camera_double_exposure_cancel, (DialogInterface.OnClickListener) null).create();
        if (!this.Z.isFinishing()) {
            this.bd.show();
        }
    }

    public void fS() {
        fT();
        this.bd = new b.a(this.Z).f(1).setNeutralButton((int) R.string.camera_double_exposure_replay_last_video_hint, this.bp).setNegativeButton((int) R.string.camera_double_exposure_cancel, (DialogInterface.OnClickListener) null).create();
        if (!this.Z.isFinishing()) {
            this.bd.show();
        }
    }

    public void fT() {
        color.support.v7.app.b bVar = this.bd;
        if (bVar != null && bVar.isShowing()) {
            this.bd.dismiss();
        }
    }

    public boolean au() {
        if (a.FIRST_STAGE_PREVIEW == fN()) {
            return super.au();
        }
        if (a.FIRST_STAGE_RECORDING != fN() && a.SECOND_STAGE_RECORDING != fN()) {
            fR();
            return true;
        } else if (this.aw < ((long) gu())) {
            return true;
        } else {
            this.Z.findViewById(R.id.video_pause_resume).performClick();
            fR();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void bb() {
        if (dN()) {
            dI();
            return;
        }
        this.au.removeMessages(10);
        this.au.sendEmptyMessage(10);
    }

    /* access modifiers changed from: protected */
    public void r() {
        if (this.bf != null) {
            this.bf = null;
        }
        super.r();
    }

    public void e(int i) {
        RotateImageView rotateImageView = this.bf;
        if (rotateImageView != null) {
            rotateImageView.a(i, true);
        }
        super.e(i);
    }

    private void gN() {
        if (this.bf == null) {
            this.bf = new RotateImageView(this.Z);
            this.bf.setId(R.id.professional_parameter_bottom_guide_entry);
            this.bf.setImageResource(R.drawable.professional_guide_tip);
            int dimensionPixelSize = this.Z.getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_size);
            int u = Util.u() + this.Z.getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = this.Z.getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_end);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMargins(0, u, 0, 0);
            layoutParams.setMarginEnd(dimensionPixelSize2);
            this.bf.setLayoutParams(layoutParams);
            this.bf.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    h.this.onClick(view);
                }
            });
        }
        this.Y.a((View) this.bf, ApsConstant.REC_MODE_DOUBLE_EXPOSURE, 3, false);
    }

    public void E(int i) {
        I(i);
    }

    public void a(String str, String str2) {
        if (this.Z != null) {
            DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.Z.getApplicationContext());
            doubleExposureMsgData.buildEventId("funcValue_select");
            doubleExposureMsgData.mFuncKeyId = DoubleExposureMsgData.KEY_FUNC_ID_VALUE;
            doubleExposureMsgData.mCaptureMode = a();
            doubleExposureMsgData.mCameraId = a(this.n);
            doubleExposureMsgData.mFuncKeyItem = str;
            doubleExposureMsgData.mFuncKeyValue = str2;
            doubleExposureMsgData.report();
        }
    }

    public void A(String str) {
        if (this.Z != null) {
            DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.Z.getApplicationContext());
            doubleExposureMsgData.buildEventId(DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_CLICK);
            doubleExposureMsgData.mFuncKeyId = str;
            doubleExposureMsgData.mCaptureMode = a();
            doubleExposureMsgData.mCameraId = a(this.n);
            doubleExposureMsgData.mFuncKeyResult = String.valueOf(2);
            doubleExposureMsgData.report();
        }
    }

    public void a(String str, com.oppo.camera.doubleexposure.b bVar) {
        if (this.Z != null) {
            DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.Z.getApplicationContext());
            doubleExposureMsgData.buildEventId(DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_VIDEO_CLIP);
            doubleExposureMsgData.mPageId = str;
            doubleExposureMsgData.mOrientation = this.k;
            doubleExposureMsgData.mCaptureMode = a();
            doubleExposureMsgData.mCameraId = a(this.n);
            if (bVar == null) {
                return;
            }
            if (!bVar.h()) {
                doubleExposureMsgData.mVideoTime = String.valueOf(bVar.e() - bVar.d());
                doubleExposureMsgData.mVideoRecMode = bVar.b();
                doubleExposureMsgData.mVideoFps = String.valueOf(bVar.a());
                doubleExposureMsgData.report();
                return;
            }
            a(doubleExposureMsgData, bVar);
        }
    }

    private void a(final DoubleExposureMsgData doubleExposureMsgData, final com.oppo.camera.doubleexposure.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.c())) {
            com.oppo.camera.v.c.a().a(new Runnable() {
                public void run() {
                    try {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(bVar.c());
                        doubleExposureMsgData.mVideoFps = String.valueOf(mediaMetadataRetriever.extractMetadata(20));
                        doubleExposureMsgData.mVideoTime = String.valueOf(mediaMetadataRetriever.extractMetadata(9));
                        String valueOf = String.valueOf(mediaMetadataRetriever.extractMetadata(18));
                        String valueOf2 = String.valueOf(mediaMetadataRetriever.extractMetadata(19));
                        mediaMetadataRetriever.release();
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(valueOf2);
                        stringBuffer.append("x");
                        stringBuffer.append(valueOf);
                        doubleExposureMsgData.mVideoRecMode = stringBuffer.toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    doubleExposureMsgData.report();
                }
            }, "setClipVideoInfo");
        }
    }

    public void fU() {
        if (this.Z != null && this.aO != null) {
            DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.Z.getApplicationContext());
            doubleExposureMsgData.buildEventId(DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_VIDEO_PLAYBACK);
            doubleExposureMsgData.mPageId = "2";
            doubleExposureMsgData.mOrientation = this.k;
            doubleExposureMsgData.mCaptureMode = a();
            doubleExposureMsgData.mCameraId = a(this.n);
            doubleExposureMsgData.mDuration = String.valueOf(SystemClock.uptimeMillis() - this.bl);
            doubleExposureMsgData.report();
        }
    }

    private void I(int i) {
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.Z, false);
        switch (i) {
            case R.string.camera_double_exposure_nobody_hint:
                reminderMsgData.mReminderTypeValue = ReminderMsgData.TYPE_ADVICE;
                reminderMsgData.mReminderCodeValue = "no_face";
                break;
            case R.string.camera_double_exposure_recording_hint:
                reminderMsgData.mReminderTypeValue = ReminderMsgData.TYPE_DISABLE_CODE;
                reminderMsgData.mReminderCodeValue = ReminderMsgData.CODE_TIME_SHORT;
                break;
            case R.string.mode_double_exposure_move_closer:
                reminderMsgData.mReminderTypeValue = "bokeh_code";
                reminderMsgData.mReminderCodeValue = ReminderMsgData.CODE_MOVE_CLOSER;
                break;
            case R.string.mode_double_exposure_video_cannot_resolve:
                reminderMsgData.mReminderTypeValue = ReminderMsgData.TYPE_DISABLE_CODE;
                reminderMsgData.mReminderCodeValue = ReminderMsgData.CODE_VIDEO_UNPARSEABLE;
                break;
            default:
                return;
        }
        reminderMsgData.mCameraId = a(this.n);
        reminderMsgData.mCaptureMode = a();
        reminderMsgData.mOrientation = this.k;
        reminderMsgData.mRearOrFront = this.t ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    public void a(String str, String str2, String str3, String str4) {
        if (this.Z != null) {
            DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.Z.getApplicationContext());
            doubleExposureMsgData.buildEventId(DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_GUIDE_PAGE);
            char c = 65535;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c = 0;
                        break;
                    }
                    break;
                case 49:
                    if (str.equals("1")) {
                        c = 1;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                doubleExposureMsgData.mPageId = DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_VIDEO_OVERLAY;
            } else if (c == 1) {
                doubleExposureMsgData.mPageId = DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_SCENE_VIDEO;
            } else if (c != 2) {
                doubleExposureMsgData.mPageId = DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_GUIDE_GALLERY;
            } else {
                doubleExposureMsgData.mPageId = DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_PORTRAIT_VIDEO;
            }
            doubleExposureMsgData.mPageDuration = str2;
            doubleExposureMsgData.mCaptureMode = a();
            doubleExposureMsgData.mCameraId = a(this.n);
            doubleExposureMsgData.mExitType = str3.trim();
            doubleExposureMsgData.mOpenType = str4;
            doubleExposureMsgData.report();
        }
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        super.b(dcsMsgData);
        if (dcsMsgData instanceof VideoRecordMsgData) {
            VideoRecordMsgData videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
            if (5 == this.aa.getInt("pref_double_exposure_effect_type", 5)) {
                videoRecordMsgData.mDoubleExposureEffect = "mixed";
            } else {
                videoRecordMsgData.mDoubleExposureEffect = "silhouette";
            }
        }
        return dcsMsgData;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.professional_parameter_bottom_guide_entry && this.Y != null) {
            A(DoubleExposureMsgData.KEY_FUNC_ID_VALUE_i);
            this.Y.n(5);
        }
    }

    public boolean fz() {
        boolean z = (fN() == a.SECOND_STAGE_PREVIEW || fN() == a.SECOND_STAGE_REPLAY) ? false : true;
        com.oppo.camera.e.a("DoubleExposureMode", "shouldHideBlur, shouldHideBlur: " + z);
        return z;
    }

    public boolean fA() {
        return a.FIRST_STAGE_PREVIEW == fN() || a.SECOND_STAGE_PREVIEW == fN();
    }
}
