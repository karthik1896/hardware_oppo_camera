package com.oppo.camera.e;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import com.google.lens.sdk.LensApi;
import com.oppo.camera.MyApplication;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureResult;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.d.b;
import com.oppo.camera.d.d;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.ReminderMsgData;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.i;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.j;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.HashMap;
import java.util.List;

/* compiled from: CommonCapMode */
public class e extends a {
    protected long aA;
    private int aB;
    private int aC;
    private a aD;
    private Handler aE;
    private int aF;
    private int aG;
    private int aH;
    /* access modifiers changed from: private */
    public long aI;
    private boolean aJ;
    /* access modifiers changed from: private */
    public boolean aK;
    /* access modifiers changed from: private */
    public boolean aL;
    private boolean aM;
    private boolean aN;
    private long aO;
    private long aP;
    private long aQ;
    private int aR;
    private long aS;
    private int aT;
    /* access modifiers changed from: private */
    public b aU;
    /* access modifiers changed from: private */
    public boolean aV;
    /* access modifiers changed from: private */
    public LensApi aW;
    private RotateImageView aX;
    private boolean aY;
    private Size aZ;
    protected i at;
    protected boolean au;
    protected boolean av;
    protected boolean aw;
    protected boolean ax;
    protected int ay;
    protected long az;
    private Size ba;
    private boolean bb;

    public String a() {
        return ApsConstant.CAPTURE_MODE_COMMON;
    }

    /* access modifiers changed from: protected */
    public String bY() {
        return "pref_common_facebeauty_level_menu";
    }

    /* access modifiers changed from: protected */
    public boolean dA() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void eh() {
    }

    public boolean ej() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fG() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fJ() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fN() {
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

    public e(Activity activity, b bVar, com.oppo.camera.ui.e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
        this.at = null;
        this.au = false;
        this.av = true;
        this.aw = false;
        this.ax = false;
        this.ay = 0;
        this.az = 0;
        this.aA = 0;
        this.aB = 0;
        this.aC = 0;
        this.aD = new a();
        this.aE = null;
        this.aF = g.f4385a;
        this.aG = 0;
        this.aH = 0;
        this.aI = 0;
        this.aJ = false;
        this.aK = false;
        this.aL = true;
        this.aM = false;
        this.aN = false;
        this.aO = 0;
        this.aP = 0;
        this.aQ = 0;
        this.aR = 0;
        this.aS = 0;
        this.aT = 0;
        this.aU = null;
        this.aV = false;
        this.aW = null;
        this.aX = null;
        this.aY = true;
        this.aZ = null;
        this.ba = null;
        this.bb = false;
        this.aF = cf();
        this.aG = bX();
    }

    /* access modifiers changed from: protected */
    public long aK() {
        int configIntValue;
        long j = Util.e((Context) this.Z).totalMem;
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HAL_MEMORY_COMMON_SUPPORT_DIFFERENCE)) {
            configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_COMMON);
        } else if (5368709120L < j && 7516192768L > j) {
            configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_COMMON_6G);
        } else if (7516192768L < j && 9663676416L > j) {
            configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_COMMON_8G);
        } else if (9663676416L < j) {
            configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_COMMON_12G);
        } else {
            configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_COMMON);
        }
        return (long) configIntValue;
    }

    public int c() {
        if (ef() == 2 || ef() == 1) {
            return 32787;
        }
        if (ef() == 6 || ef() == 7 || ef() == 8 || ef() == 9) {
            return 32788;
        }
        if (!f(CameraFunction.VIDEO_HDR)) {
            return 32769;
        }
        String string = this.aa.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n));
        if ("on".equals(string)) {
            return 33025;
        }
        if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string)) {
            return 33281;
        }
        return 32769;
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("CommonCapMode", "onInitCameraMode");
        a aVar = this.aD;
        if (aVar != null) {
            aVar.a();
        }
        if (this.at == null) {
            this.at = new i(this.Y, new i.a() {
                public void a(boolean z) {
                    e.this.fC();
                }

                public void a() {
                    com.oppo.camera.e.a("CommonCapMode", "updateCountDownTime");
                    if (!e.this.y) {
                        e.this.at.d();
                    }
                }
            });
        }
        if (this.aE == null) {
            this.aE = new Handler() {
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1) {
                        com.oppo.camera.e.a("CommonCapMode", "handleMessage, MSG_CODE_HIDE_PICTURE_NUM");
                        if (!e.this.y) {
                            e.this.Y.d(true);
                            if (e.this.X != null && !e.this.f("pref_expand_popbar_key")) {
                                e.this.X.D();
                            }
                            if (e.this.f("pref_filter_menu")) {
                                e.this.Y.b(true);
                            }
                            if (e.this.f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                                e.this.Y.t(true);
                            }
                            e.this.cP();
                        }
                    } else if (i == 3) {
                        e.this.fC();
                    } else if (i != 4) {
                        if (i == 5 && !e.this.y) {
                            e.this.Y.b((int) R.string.micro_lens_mode_toast);
                            e eVar = e.this;
                            if (eVar.a(eVar.bd()) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                                e eVar2 = e.this;
                                eVar2.P = false;
                                eVar2.m(eVar2.bu());
                                e.this.Y.b("pref_camera_flashmode_key", (String) null);
                            }
                        }
                    } else if (!e.this.y) {
                        e.this.Y.a((int) R.string.micro_lens_mode_toast, -1, false, false, true);
                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                            e eVar3 = e.this;
                            eVar3.P = true;
                            eVar3.m("off");
                            e.this.Y.a("pref_camera_flashmode_key", "off");
                            if (1 == message.arg1) {
                                e.this.fS();
                            }
                        }
                    }
                }
            };
        }
        this.ax = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_PICTURE_TIMER_SUPPORT);
        this.Y.c(this.Z.getString(R.string.camera_description_common_shutter_button));
        fO();
        this.w = false;
        this.aT = 0;
        this.aY = true;
    }

    /* access modifiers changed from: protected */
    public void fC() {
        this.av = true;
        if (this.aL) {
            com.oppo.camera.e.a("CommonCapMode", "captureRawDone, resetAfterPictureTaken");
            this.Y.d(true, false);
            f(true, this.u);
            return;
        }
        com.oppo.camera.e.a("CommonCapMode", "captureRawDone");
        c cVar = new c();
        cVar.a("button_color_inside_none");
        cVar.a(4);
        this.Y.a(cVar);
        this.Y.g(true);
    }

    /* access modifiers changed from: private */
    public void fO() {
        if (f("key_beauty3d") && this.aU == null) {
            this.aU = new b(this.Z, new d() {
                public void a() {
                    com.oppo.camera.e.a("CommonCapMode", "onExitScan, beauty3D exit");
                    a(true);
                }

                public void b() {
                    com.oppo.camera.e.a("CommonCapMode", "onScanComplete, beauty3D scan Complete");
                    if (e.this.aa != null) {
                        SharedPreferences.Editor edit = e.this.aa.edit();
                        edit.putBoolean("key_bubble_type_add_beuty3d", false);
                        edit.apply();
                    }
                    e.this.H(false);
                    long currentTimeMillis = System.currentTimeMillis() - e.this.aI;
                    if (currentTimeMillis > 0) {
                        CameraStatisticsUtil.onCommon(e.this.Z, CameraStatisticsUtil.EVENT_BEAUTY3D, CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SCAN_TIME, String.valueOf(currentTimeMillis)), false);
                    }
                }

                public void c() {
                    if (e.this.Y != null) {
                        e.this.Y.x();
                    }
                }

                public void d() {
                    com.oppo.camera.e.a("CommonCapMode", "onStartScan, open dual camera, Beauty3DState: " + e.this.ef());
                    long unused = e.this.aI = System.currentTimeMillis();
                    int bX = e.this.bX();
                    com.oppo.camera.e.a("CommonCapMode", "onStartScan, BeautyCurrIndex: " + bX);
                    if (bX == -1) {
                        e eVar = e.this;
                        eVar.a(eVar.Y.z());
                    }
                    j.b(e.this.Z);
                    e.this.H(false);
                }

                public void e() {
                    e.this.H(false);
                }

                public void f() {
                    j.b(e.this.Z);
                    e eVar = e.this;
                    eVar.a(eVar.Y.z());
                    if (e.this.aa != null) {
                        SharedPreferences.Editor edit = e.this.aa.edit();
                        edit.putBoolean("key_bubble_type_custom_beuty3d", true);
                        edit.apply();
                    }
                }

                public void a(boolean z) {
                    if (e.this.ef() == 4) {
                        com.oppo.camera.e.a("CommonCapMode", "onScanCancel, Beauty3DState == BEAUTY3D_STATE_SCAN_CANCEL, return");
                    } else if (z) {
                        e.this.x(4);
                        e.this.H(false);
                    }
                }

                public void b(boolean z) {
                    if (z && e.this.aa != null) {
                        SharedPreferences.Editor edit = e.this.aa.edit();
                        edit.putInt(e.this.bY(), -1);
                        edit.apply();
                    }
                    e.this.H(z);
                }

                public void c(boolean z) {
                    if (e.this.Y != null) {
                        e.this.Y.m(z);
                    }
                }
            });
            this.aU.a();
        }
    }

    /* access modifiers changed from: protected */
    public String[] de() {
        if (!com.oppo.camera.entry.b.a(this.as)) {
            return com.oppo.camera.ui.e.e_;
        }
        String[] strArr = new String[com.oppo.camera.ui.e.e_.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = com.oppo.camera.entry.b.b(com.oppo.camera.ui.e.e_[i], this.as);
        }
        return strArr;
    }

    public boolean r(int i) {
        b bVar;
        if (1 != q(i) || (bVar = this.aU) == null) {
            return false;
        }
        bVar.k();
        return true;
    }

    public boolean db() {
        b bVar;
        if (!f("key_beauty3d") || (bVar = this.aU) == null) {
            return false;
        }
        return bVar.i();
    }

    public void b(int i, boolean z) {
        if (this.W != null) {
            com.oppo.camera.e.a("CommonCapMode", "setPIEnable, code: " + i + ", enable: " + z);
            boolean z2 = this.aM;
            if (this.u || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || 4 != i) {
                this.aM = false;
                if (12 == i && !this.aJ && z) {
                    this.aJ = true;
                    this.W.w(0);
                    this.W.a((f.c) null);
                    this.aH++;
                }
            } else {
                this.aM = z;
                if (f(CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.ab != null) {
                    this.ab.c(64);
                }
            }
            if (f(CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.ab != null) {
                this.ab.h(this.aM);
            }
            if (f(CameraFunction.SUPER_TEXT) && z2 && !this.aM) {
                com.oppo.camera.e.b("CommonCapMode", "setPIEnable, clear SuperText!");
                this.Y.a((com.oppo.camera.t.a) null);
            }
            this.W.x(this.Y.P());
            this.W.a((f.c) null);
        }
    }

    public void s(int i) {
        if (i == 12 && !this.aJ) {
            this.aJ = true;
            if (this.W != null) {
                this.W.w(0);
                this.W.a((f.c) null);
            }
            this.aH++;
        }
    }

    public boolean fD() {
        b bVar = this.aU;
        if (bVar != null) {
            return bVar.g();
        }
        return false;
    }

    public void fE() {
        b bVar = this.aU;
        if (bVar != null) {
            int f = bVar.f();
            com.oppo.camera.e.a("CommonCapMode", "updateBeauty3DView, type: " + f);
            if (f != 1) {
                if (f != 10) {
                    if (f == 6 || f == 7) {
                        this.aU.a(1, new Size(1440, 1080));
                        return;
                    } else if (f != 8) {
                        return;
                    }
                }
                this.aU.a(2, new Size(1440, 1080));
                return;
            }
            this.aU.h();
        }
    }

    public int q(int i) {
        com.oppo.camera.e.a("CommonCapMode", "getBeauty3DScanIconType, effectIndex: " + i);
        int a2 = j.a(this.Z);
        if (i != 0 || !"beauty".equals(bP()) || !f("key_beauty3d") || a2 != 0) {
            return (i != 0 || !"beauty".equals(bP()) || !f("key_beauty3d") || a2 != 1) ? 0 : 2;
        }
        this.Y.c(6, true);
        return 1;
    }

    public Size d(com.oppo.camera.f.j jVar) {
        Size a2;
        if (ef() == 2 || ef() == 1) {
            return new Size(3264, 2448);
        }
        if (ef() == 6 || ef() == 7 || ef() == 8 || ef() == 9) {
            return new Size(1440, 1080);
        }
        if (this.z || this.X == null || this.X.j() || (a2 = a(jVar)) == null) {
            return super.d(jVar);
        }
        return a2;
    }

    public Size e(com.oppo.camera.f.j jVar) {
        Size e = super.e(jVar);
        this.aZ = e;
        if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) && this.t && bX() != 0) || ((com.oppo.camera.f.a.h() == this.n && (this.Y.C() || bX() != 0)) || com.oppo.camera.f.a.j() == a(this.n))) {
            this.ba = gb();
            Size size = this.ba;
            if (size != null) {
                e = size;
            }
        }
        com.oppo.camera.e.a("CommonCapMode", "getPreviewSize, previewSize: " + e + ", mLastPreviewSize: " + this.aZ + ", mChangePreviewSize: " + this.ba);
        int ef = ef();
        return (ef == 0 || ef == 4) ? e : new Size(1440, 1080);
    }

    public int aS() {
        return Util.p() ? 32 : 0;
    }

    /* access modifiers changed from: protected */
    public boolean aT() {
        return this.aN;
    }

    public boolean ea() {
        if (this.u) {
            return false;
        }
        if (!Util.p()) {
            return super.ea();
        }
        if (this.z) {
            return false;
        }
        if ((this.t && cb()) || this.X.C()) {
            return true;
        }
        if (1 == this.X.h() || 2 == this.X.h()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean br() {
        /*
            r5 = this;
            boolean r0 = r5.t
            r1 = 1
            if (r0 == 0) goto L_0x0043
            boolean r0 = com.oppo.camera.util.Util.p()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r5.i
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r2 = r5.af     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003e
            java.lang.String r2 = "CommonCapMode"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r3.<init>()     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = "getZSLMode, feature Type: "
            r3.append(r4)     // Catch:{ all -> 0x0040 }
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r5.af     // Catch:{ all -> 0x0040 }
            int r4 = r4.mApsDecisionFeatureType     // Catch:{ all -> 0x0040 }
            r3.append(r4)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0040 }
            com.oppo.camera.e.a(r2, r3)     // Catch:{ all -> 0x0040 }
            r2 = 30
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r3 = r5.af     // Catch:{ all -> 0x0040 }
            int r3 = r3.mApsDecisionFeatureType     // Catch:{ all -> 0x0040 }
            if (r2 == r3) goto L_0x003c
            r2 = 26
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r3 = r5.af     // Catch:{ all -> 0x0040 }
            int r3 = r3.mApsDecisionFeatureType     // Catch:{ all -> 0x0040 }
            if (r2 != r3) goto L_0x003e
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return r1
        L_0x003e:
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            goto L_0x0043
        L_0x0040:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r1
        L_0x0043:
            com.oppo.camera.e.b r0 = r5.X
            if (r0 == 0) goto L_0x005a
            com.oppo.camera.e.b r0 = r5.X
            boolean r0 = r0.j()
            if (r0 != 0) goto L_0x005a
            int r0 = r5.ao
            if (r0 > 0) goto L_0x005a
            boolean r0 = com.oppo.camera.util.Util.p()
            if (r0 == 0) goto L_0x005a
            return r1
        L_0x005a:
            java.lang.String r0 = "com.oplus.zsl.support.preversion"
            boolean r0 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r0)
            if (r0 != 0) goto L_0x0083
            boolean r0 = r5.t
            if (r0 == 0) goto L_0x0083
            boolean r0 = com.oppo.camera.util.Util.p()
            if (r0 == 0) goto L_0x0083
            boolean r0 = r5.cb()
            if (r0 == 0) goto L_0x0083
            r0 = 4
            int r2 = r5.ar
            if (r0 == r2) goto L_0x0083
            r0 = 24
            int r2 = r5.ar
            if (r0 == r2) goto L_0x0083
            r0 = 5
            int r2 = r5.ar
            if (r0 == r2) goto L_0x0083
            return r1
        L_0x0083:
            boolean r0 = super.br()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.e.br():boolean");
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.a("CommonCapMode", "onDeInitCameraMode");
        this.Y.n(true);
        this.Y.u(true);
        this.Y.b((int) R.string.micro_lens_mode_toast);
        this.aJ = false;
        this.aR = 0;
        this.aT = 0;
        this.aN = false;
        this.aY = false;
        Handler handler = this.aE;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        if (this.W != null) {
            this.W.q(0);
        }
        a(0, false);
        if (this.ab != null) {
            this.ab.h(0);
        }
        this.Y.d(false);
        if (p("key_bubble_type_add_beuty3d") && f("key_beauty3d")) {
            this.Y.c(6, false);
        }
        if (p("key_bubble_type_custom_beuty3d")) {
            this.Y.c(5, false);
        }
        b bVar = this.aU;
        if (bVar != null) {
            bVar.c();
        }
        if (bx() && this.aa != null) {
            this.O = true;
            this.aa.edit().putString("pref_ultra_wide_high_picture_size_key", "off").apply();
            this.O = false;
        }
        if (this.aa != null && this.aa.getBoolean("key_bubble_type_zoom_ultra_wide", true)) {
            this.Y.c(12, true);
            this.Y.c(9, true);
        }
    }

    public boolean bw() {
        if (!f("key_high_picture_size") || this.aa == null) {
            return false;
        }
        return this.aa.getBoolean("key_high_picture_size", false);
    }

    public boolean bx() {
        if (!f("pref_ultra_wide_high_picture_size_key") || this.aa == null || !this.aa.getBoolean("key_high_picture_size", false) || !"on".equals(this.aa.getString("pref_ultra_wide_high_picture_size_key", "off"))) {
            return false;
        }
        return true;
    }

    public boolean cn() {
        if (!f("pref_face_rectify_key")) {
            return super.cn();
        }
        String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_FACE_RECTIFY_CONFIG_VALUE);
        if (TextUtils.isEmpty(configStringValue)) {
            configStringValue = this.Z.getString(R.string.camera_face_rectify_default_value);
        }
        if (this.aa != null) {
            configStringValue = this.aa.getString("pref_face_rectify_key", configStringValue);
        }
        return "on".equals(configStringValue);
    }

    public boolean cr() {
        return cn() && cs();
    }

    public boolean cs() {
        float bd = bd();
        return Float.compare(bd, 0.6f) == 0 || Float.compare(bd, 1.0f) == 0;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        b bVar;
        com.oppo.camera.e.e("CommonCapMode", "onResume");
        if (!(!f("key_beauty3d") || (bVar = this.aU) == null || bVar.f() == 0)) {
            this.aU.a(new Size(1440, 2448));
        }
        if (eB() && bw()) {
            this.X.c(true);
            this.aa.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
            this.X.c(false);
        }
        LensApi lensApi = this.aW;
        if (lensApi != null) {
            try {
                lensApi.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fV()) {
            I(true);
            K(true);
        } else {
            J(false);
        }
        if (this.aw) {
            this.Y.b((int) R.string.camera_scene_night_keep_phone_steady);
            this.Y.b((int) R.string.camera_scene_night_process_image_after_capture);
            this.aw = false;
            this.ay = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        com.oppo.camera.e.e("CommonCapMode", "OnStop");
    }

    public void cx() {
        StringBuilder sb = new StringBuilder();
        int i = this.aH;
        if (i > 0) {
            String format = CameraStatisticsUtil.format(CameraStatisticsUtil.NIGHT_CLOSED_NUM, String.valueOf(i));
            this.aH = 0;
            sb.append(format);
        }
        if (sb.length() > 0) {
            CameraStatisticsUtil.onCommon(this.Z, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString(), false);
        }
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) ? null : (CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        if (f("pref_support_night_process") && cm()) {
            captureMsgData.mNightState = ah();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_AUTO_MICRO)) {
            captureMsgData.mIsMacro = String.valueOf(this.aN ? 1 : 0);
        }
        if (this.t) {
            captureMsgData.mScreenHighLight = h ? "on" : "off";
        }
        super.b(dcsMsgData);
        return dcsMsgData;
    }

    /* access modifiers changed from: protected */
    public void aX() {
        this.aF = cf();
        this.aG = bX();
        n(g.f4385a);
        l(0);
        bQ();
        this.Y.h("pref_filter_menu");
        this.Y.m(0);
    }

    public void ed() {
        b bVar = this.aU;
        if (bVar != null) {
            bVar.a(this.W);
        }
        if (f(CameraFunction.VIDEO_HDR) && this.W.e().H()) {
            this.W.k(true);
        }
        super.ed();
    }

    /* access modifiers changed from: protected */
    public void aY() {
        n(this.aF);
        l(this.aG);
        bQ();
        this.Y.h("pref_filter_menu");
        this.Y.m(this.aG);
    }

    private void fP() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            if (f("pref_camera_pi_ai_mode_key")) {
                this.Y.C(false);
            }
        } else if (f("pref_camera_pi_mode_key")) {
            this.Y.b("pref_camera_pi_mode_key", (String) null);
            a(false, fT(), false, true);
        }
    }

    public boolean f(String str) {
        String c = com.oppo.camera.entry.b.c(str);
        boolean z = this.t;
        if (CameraFunction.MODE_PANEL.equals(c) || "pref_camera_photo_ratio_key".equals(c) || "pref_camera_timer_shutter_key".equals(c) || "pref_camera_high_resolution_key".equals(c) || "pref_setting_key".equals(c)) {
            return true;
        }
        if ("pref_filter_process_key".equals(c)) {
            return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FILTER);
        }
        if ("pref_save_jpg_after_pause_key".equals(c)) {
            if (!this.X.j() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAVE_JPG_AFTER_PAUSE) || !Util.p() || cy()) {
                return false;
            }
            return true;
        } else if (CameraFunction.FACE_SLENDER_PROCESS.equals(c)) {
            if (!f(CameraFunction.FACE_BEAUTY_PROCESS) || ((!z && CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE) < 6) || Z())) {
                return false;
            }
            return true;
        } else if ("pref_camera_vivid_effect_key".equals(c)) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIVID_EFFECT) || !com.oppo.camera.w.b.d() || fT()) {
                return false;
            }
            return true;
        } else if ("pref_burst_shot_key".equals(c)) {
            if (!this.X.j() || z || bw()) {
                return false;
            }
            return true;
        } else if ("pref_support_post_view".equals(c)) {
            return false;
        } else {
            if ("pref_support_capture_preview".equals(c)) {
                if (this.X == null || !this.X.j() || f("key_support_update_thumbnail_user_picture") || ck() || av() || f("high_resolution_cancel_snapshot")) {
                    return false;
                }
                return true;
            } else if ("key_support_update_thumbnail_user_picture".equals(c)) {
                if ((this.X == null || !this.X.j() || !cQ() || this.u) && !ck() && !av() && !f("high_resolution_cancel_snapshot")) {
                    return false;
                }
                return true;
            } else if ("high_resolution_cancel_snapshot".equals(c)) {
                if (!Util.f(MyApplication.d()) || (!bw() && !af())) {
                    return false;
                }
                return true;
            } else if ("pref_auto_night_scence_key".equals(c)) {
                return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_COMMON_AUTO_NIGHT_SCENCE);
            } else {
                if ("pref_camera_torch_mode_key".equals(c)) {
                    return z;
                }
                if (CameraFunction.TORCH_SOFT_LIGHT.equals(c)) {
                    if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT) || !z) {
                        return false;
                    }
                    return true;
                } else if ("pref_camera_flashmode_key".equals(c)) {
                    return !z;
                } else {
                    if ("pref_camera_hdr_mode_key".equals(c)) {
                        return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_HDR);
                    }
                    if (CameraFunction.FACE_BEAUTY_PROCESS.equals(c)) {
                        return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FACE_BEAUTY);
                    }
                    if (CameraFunction.AIS_SNAPSHOT.equals(c)) {
                        return !bw();
                    }
                    if ("pref_expand_popbar_key".equals(c)) {
                        if (this.Y.s() || this.Y.C()) {
                            return true;
                        }
                        return false;
                    } else if ("key_beauty3d".equals(c)) {
                        if (!z || !com.oppo.camera.f.a.e() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BEAUTY3D) || !f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                            return false;
                        }
                        return true;
                    } else if (CameraFunction.FACE_BEAUTY_CUSTOM.equals(c)) {
                        if (!z || !f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                            return false;
                        }
                        return true;
                    } else if (CameraFunction.FACE_BEAUTY_COMMON.equals(c)) {
                        if (z || !f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                            return false;
                        }
                        return true;
                    } else if ("pref_camera_slogan_key".equals(c)) {
                        if (ck() && R()) {
                            return false;
                        }
                        String lowerCase = Util.i("ro.oppo.market.name").toLowerCase();
                        boolean equals = "oppo f5 6gb".equals(lowerCase);
                        boolean equals2 = "oppo f5".equals(lowerCase);
                        boolean equals3 = "oppo f5youth".equals(lowerCase);
                        if (!equals && !equals2 && !equals3) {
                            return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_WATERMARK);
                        }
                        if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_WATERMARK) || this.u) {
                            return false;
                        }
                        return true;
                    } else if ("pref_ai_scene_key".equals(c)) {
                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || f("pref_camera_pi_ai_mode_key")) {
                            return !z;
                        }
                        return false;
                    } else if ("pref_super_clear_portrait".equals(c)) {
                        if (this.X == null || !this.X.j() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_CLEAR_PORTRAIT)) {
                            return false;
                        }
                        return true;
                    } else if ("key_remosaic".equals(c)) {
                        if (z || bw()) {
                            return true;
                        }
                        return false;
                    } else if (CameraFunction.VIDEO_HDR.equals(c)) {
                        if (!z || !f("pref_camera_hdr_mode_key") || (!com.oppo.camera.f.a.a(this.n).I() && !com.oppo.camera.f.a.a(this.n).H())) {
                            return false;
                        }
                        return true;
                    } else if ("pref_switch_front_dual_camera_key".equals(c)) {
                        if (!f("key_beauty3d") || (ef() != 2 && ef() != 1)) {
                            return false;
                        }
                        return true;
                    } else if ("key_beauty3d_main_face_detect".equals(c)) {
                        if (!f("key_beauty3d") || bX() != -1) {
                            return false;
                        }
                        return true;
                    } else if ("pref_face_detection_key".equals(c)) {
                        if (!f("key_beauty3d") || (ef() != 6 && ef() != 7 && ef() != 8 && ef() != 10 && ef() != 9)) {
                            return true;
                        }
                        return false;
                    } else if ("pref_camera_assistant_line_key".equals(c) || "pref_assist_gradienter".equals(c)) {
                        return !Z();
                    } else {
                        if ("pref_camera_pi_ai_mode_key".equals(c)) {
                            if (z || this.X == null || !this.X.j() || ((!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_PF_V1) && !AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_PF_V3)) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI))) {
                                return false;
                            }
                            return true;
                        } else if ("pref_camera_pi_mode_key".equals(c)) {
                            if (z || !AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_PF) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI)) {
                                return false;
                            }
                            return true;
                        } else if ("pref_support_raw_post_process".equals(c)) {
                            if (AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_RAW2YUV) || f("pref_support_night_process") || f(CameraFunction.RAW_HDR)) {
                                return true;
                            }
                            return false;
                        } else if ("pref_support_night_process".equals(c)) {
                            if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_SUPERNIGHT) || bw()) {
                                return false;
                            }
                            return true;
                        } else if ("pref_camera_gradienter_key".equals(c)) {
                            return false;
                        } else {
                            if ("pref_filter_menu".equals(c)) {
                                return f("pref_filter_process_key");
                            }
                            if (!Util.p() || !CameraFunction.RAW_HDR.equals(c)) {
                                if (!"key_high_picture_size".equals(c) || this.X == null || !this.X.j() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                                    if ("pref_ultra_wide_high_picture_size_key".equals(c)) {
                                        if (!f("key_high_picture_size") || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
                                            return false;
                                        }
                                        return true;
                                    } else if (CameraFunction.SAT_CAMERA.equalsIgnoreCase(c)) {
                                        if (z || !com.oppo.camera.f.a.f() || this.X == null || !this.X.j()) {
                                            return false;
                                        }
                                        return true;
                                    } else if ("key_support_no_face_forbid_beauty".equals(c)) {
                                        return true;
                                    } else {
                                        if ("pref_camera_tap_shutter_key".equals(c)) {
                                            if (!this.aL || !this.av) {
                                                return false;
                                            }
                                            return true;
                                        } else if ("key_support_mode_change_vibrate".equals(c)) {
                                            return true;
                                        } else {
                                            if ("pref_none_sat_ultra_wide_angle_key".equals(c)) {
                                                if (!N() || !this.X.j()) {
                                                    return false;
                                                }
                                                return true;
                                            } else if ("pref_face_rectify_key".equals(c)) {
                                                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_RECTIFY_SUPPORT) || !this.X.j()) {
                                                    return false;
                                                }
                                                return true;
                                            } else if ("key_support_show_dim_hint".equals(c)) {
                                                return true;
                                            } else {
                                                if (CameraFunction.SUPER_TEXT.equals(c)) {
                                                    if (this.t || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT)) {
                                                        return false;
                                                    }
                                                    return true;
                                                } else if (CameraFunction.SUPER_TEXT_CPU_PROCESS.equals(c)) {
                                                    if (!f(CameraFunction.SUPER_TEXT) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS)) {
                                                        return false;
                                                    }
                                                    return true;
                                                } else if (CameraFunction.SUPER_TEXT_GPU_PROCESS.equals(c)) {
                                                    if (!f(CameraFunction.SUPER_TEXT) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS)) {
                                                        return false;
                                                    }
                                                    return true;
                                                } else if ("pref_zoom_key".equals(c) && bw() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
                                                    return false;
                                                } else {
                                                    if ("pref_qr_code_key".equals(c)) {
                                                        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_QR_CODE_ENABLE) || this.t || cQ() || ck() || !this.X.j()) {
                                                            return false;
                                                        }
                                                        return true;
                                                    } else if ("key_suppport_multi_focus".equals(c)) {
                                                        return !z;
                                                    } else {
                                                        if (CameraFunction.GOOGLE_LENS.equals(c)) {
                                                            if (!com.oppo.camera.w.b.c() || this.X == null || !this.X.j() || this.t || (fY() && this.ak.m())) {
                                                                return false;
                                                            }
                                                            return true;
                                                        } else if ("key_support_insensor_zoom_20x".equals(c)) {
                                                            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INSENSOR_ZOOM_20X) || !this.X.j()) {
                                                                return false;
                                                            }
                                                            return true;
                                                        } else if ("pref_10bits_heic_encode_key".equals(c)) {
                                                            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT) || this.t) {
                                                                return false;
                                                            }
                                                            return true;
                                                        } else if ("key_bubble_type_zoom_ultra_wide".equals(c)) {
                                                            if (this.t || ((!ex() && !f("pref_none_sat_ultra_wide_angle_key")) || this.Y == null || this.Y.H() || this.Y.s())) {
                                                                return false;
                                                            }
                                                            return true;
                                                        } else if (CameraFunction.TILT_SHIFT.equals(c)) {
                                                            if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_TILT_SHIFT) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TILT_SHIFT) || z || this.Y == null || !this.X.j()) {
                                                                return false;
                                                            }
                                                            return true;
                                                        } else if ("pref_manual_exposure_key".equals(c) && dz()) {
                                                            return false;
                                                        } else {
                                                            if ("support_focus_out_of_range".equals(c)) {
                                                                return !z;
                                                            }
                                                            return super.f(c);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n) != null) {
                                    return true;
                                } else {
                                    return false;
                                }
                            } else if (z || bw()) {
                                return false;
                            } else {
                                return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_RAW_HDR);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean d(String str) {
        String c = com.oppo.camera.entry.b.c(str);
        if ("pref_camera_flashmode_key".equals(c) || "pref_setting_key".equals(c) || "pref_camera_hdr_mode_key".equals(c) || "pref_camera_vivid_effect_key".equals(c) || "pref_filter_menu".equals(c) || "pref_camera_pi_ai_mode_key".equals(c) || "pref_camera_pi_mode_key".equals(c)) {
            return f(c);
        }
        if ("pref_camera_timer_shutter_key".equals(c)) {
            return this.t;
        }
        return super.d(c);
    }

    public boolean c(String str) {
        String c = com.oppo.camera.entry.b.c(str);
        if ("pref_camera_high_resolution_key".equals(c)) {
            return f("key_high_picture_size");
        }
        if ("pref_camera_timer_shutter_key".equals(c)) {
            return !this.t;
        }
        if ("pref_photo_tilt_shift_key".equals(c)) {
            return f(CameraFunction.TILT_SHIFT);
        }
        if ("pref_camera_photo_ratio_key".equals(c)) {
            return f(c);
        }
        return super.c(c);
    }

    public boolean Z() {
        return f("key_beauty3d") && ef() > 0 && ef() != 4;
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        String str2 = "on";
        if ("pref_camera_pi_ai_mode_key".equals(str) && f("pref_camera_pi_ai_mode_key")) {
            boolean equals = str2.equals(sharedPreferences.getString("pref_camera_pi_ai_mode_key", this.Z.getString(R.string.camera_pi_ai_default_value)));
            if (this.aa != null) {
                SharedPreferences.Editor edit = this.aa.edit();
                if (!equals) {
                    str2 = "off";
                }
                edit.putString("pref_ai_scene_key", str2).apply();
            }
            a(this.u, equals, true, true);
        } else if ("pref_camera_pi_mode_key".equals(str) && f("pref_camera_pi_mode_key")) {
            a(this.u, str2.equals(sharedPreferences.getString("pref_camera_pi_mode_key", "off")), true, true);
        } else if ("pref_ultra_wide_high_picture_size_key".equals(str) && !this.O) {
            if (f("pref_camera_flashmode_key") && this.aa != null) {
                if (!bx() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                    this.P = false;
                    m(bu());
                } else {
                    this.P = true;
                    m("off");
                    this.Y.a("pref_camera_flashmode_key", "off");
                }
            }
            if (this.X != null) {
                this.X.ao();
            }
        } else if ("pref_camera_id_key".equals(str)) {
            if (bx() && this.aa != null) {
                this.O = true;
                this.aa.edit().putString("pref_ultra_wide_high_picture_size_key", "off").apply();
                this.O = false;
            }
        } else if (!"pref_camera_high_resolution_key".equals(str)) {
            if ("pref_photo_tilt_shift_key".equals(str) && dz() && fT()) {
                fL();
            }
            super.a(sharedPreferences, str);
        } else if (f("pref_ultra_wide_high_picture_size_key") && this.aa != null && "standard_high".equals(this.aa.getString("pref_camera_high_resolution_key", "standard_high"))) {
            if (Float.compare(bd(), 1.0f) < 0) {
                this.O = true;
                this.aa.edit().putString("pref_ultra_wide_high_picture_size_key", str2).apply();
                this.O = false;
                return;
            }
            this.O = true;
            this.aa.edit().putString("pref_ultra_wide_high_picture_size_key", "off").apply();
            this.O = false;
        }
    }

    /* access modifiers changed from: private */
    public void fQ() {
        if (fT()) {
            if (!"torch".equals(bu())) {
                this.Y.a(false, true, true);
            }
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                this.Y.b("pref_camera_pi_mode_key", "off");
                a(this.u, false, false, true);
            } else if (this.u) {
                this.Y.C(true);
            }
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && this.u) {
            this.Y.C(true);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        com.oppo.camera.e.a("CommonCapMode", "onPIChanged, isOpen: " + z6 + ", isBurstShot: " + z5 + ", isShowHint: " + z7 + ", isUpdateParam: " + z4);
        if (z5) {
            return;
        }
        if (z6) {
            if (z7) {
                this.Y.a(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) ? R.string.camera_pi_ai_scenes_on_hint : R.string.camera_pi_on_hint, -1, true, false, false);
            }
            n(g.f4385a);
            if (dz()) {
                fM();
            }
            if (!this.Y.s() || !"filter".equals(bP())) {
                this.Y.h("pref_filter_menu");
            } else {
                this.Y.q(true);
                this.X.D();
                this.X.d(true);
            }
            if (this.Y.C()) {
                this.Y.a(true, true, true, false);
            }
            this.Y.p(true);
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            this.aM = false;
            this.Y.a((com.oppo.camera.t.a) null);
            if (f(CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.ab != null) {
                this.ab.h(false);
            }
            if (f(CameraFunction.SUPER_TEXT)) {
                this.Y.a((com.oppo.camera.t.a) null);
            }
            if (z7) {
                this.Y.a((int) R.string.camera_pi_ai_scenes_off_hint, -1, true, false, false);
            }
        } else if (z7) {
            this.Y.a(Util.d((int) R.string.camera_pi_off_hint), -1, true, false, false);
        }
    }

    public void d(int i) {
        com.oppo.camera.e.e("CommonCapMode", "onCameraIdChanged");
        super.d(i);
        this.aJ = false;
        this.aR = 0;
        if (this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    e.this.fO();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        b bVar;
        com.oppo.camera.e.a("CommonCapMode", "onPause, mbBurstShot: " + this.u);
        this.aN = false;
        this.av = true;
        this.aL = true;
        this.Y.n(false);
        if (this.u && this.aE != null) {
            bJ();
            this.u = false;
        }
        if (cQ()) {
            this.Y.j(0);
        }
        this.aK = false;
        Handler handler = this.aE;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.Y.d(false);
        this.Y.g(false);
        this.aJ = false;
        this.aR = 0;
        if (f("key_beauty3d") && (bVar = this.aU) != null) {
            bVar.b();
        }
        if (f("key_beauty3d") && p("key_bubble_type_add_beuty3d") && this.Y.s()) {
            this.Y.c(6, true);
        }
        if (f("key_beauty3d") && p("key_bubble_type_custom_beuty3d")) {
            this.Y.c(5, true);
        }
        if (this.X != null && !this.X.an() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.aa.contains("pref_ultra_wide_high_picture_size_key")) {
            this.O = true;
            this.aa.edit().putString("pref_ultra_wide_high_picture_size_key", "off").apply();
            this.O = false;
        }
        LensApi lensApi = this.aW;
        if (lensApi != null) {
            try {
                lensApi.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void r() {
        com.oppo.camera.e.a("CommonCapMode", "onDestroy");
        this.aD = null;
        if (p("key_bubble_type_add_beuty3d")) {
            this.Y.c(6, false);
        }
        if (p("key_bubble_type_custom_beuty3d")) {
            this.Y.c(5, false);
        }
        b bVar = this.aU;
        if (bVar != null) {
            bVar.r();
            this.aU = null;
        }
    }

    public boolean au() {
        b bVar;
        super.au();
        if (f("key_beauty3d") && (bVar = this.aU) != null && bVar.d()) {
            return true;
        }
        if (!this.w) {
            return false;
        }
        com.oppo.camera.e.a("CommonCapMode", "onBackPressed, mbInBurstShotCapturing: " + this.w);
        return true;
    }

    public int cf() {
        if (!fT() && !Z()) {
            return super.cf();
        }
        com.oppo.camera.e.a("CommonCapMode", "getCurrFilterIndex, no filter");
        return g.f4385a;
    }

    public void n(int i) {
        if (fT() && i != g.f4385a) {
            fL();
        }
        if (this.ab != null) {
            this.ab.a(p(i));
            this.ab.c(false);
        }
        super.n(i);
    }

    public void o(int i) {
        if (fT() && i != g.f4385a) {
            fL();
        }
        super.o(i);
    }

    /* access modifiers changed from: protected */
    public void u() {
        com.oppo.camera.e.a("CommonCapMode", "onBeforePreview");
        this.aM = false;
        this.aN = false;
        if (f(CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.ab != null) {
            this.ab.h(ck());
        }
        dd();
        b bVar = this.aU;
        if (bVar != null && bVar.f() > 0) {
            this.aU.b(this.W);
        }
        dy();
    }

    public boolean d(MotionEvent motionEvent) {
        return Z();
    }

    public boolean fF() {
        ApsAdapterDecision.DecisionResult decisionResult;
        Integer num;
        int i;
        boolean cQ = cQ();
        boolean z = cQ && ai();
        boolean fJ = fJ();
        synchronized (this.i) {
            decisionResult = this.af;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("shouldShowSteadyTips, isInNightProcess: ");
        sb.append(cQ);
        sb.append(", isTripodNight: ");
        sb.append(z);
        sb.append(", mbBurstShot: ");
        sb.append(this.u);
        sb.append(", mbSceneNight: ");
        sb.append(this.au);
        sb.append(", mSupportCaptureZoomFeature: ");
        if (decisionResult == null) {
            num = null;
        } else {
            num = Integer.valueOf(decisionResult.mSupportCaptureZoomFeature);
        }
        sb.append(num);
        sb.append(", mRequestNum: ");
        if (this.u) {
            i = Util.d;
        } else {
            i = C();
        }
        sb.append(i);
        sb.append(", isTripodModeOpened: ");
        sb.append(fG());
        com.oppo.camera.e.a("CommonCapMode", sb.toString());
        if (!this.u && !fG()) {
            if ((this.au || cQ) && !z && !fJ) {
                return true;
            }
            int C = C();
            return decisionResult != null && 4 == decisionResult.mSupportCaptureZoomFeature && (1 == C || 3 <= C) && this.X.j();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(com.oppo.camera.f.d dVar) {
        com.oppo.camera.e.a("CommonCapMode", "onBeforeSnapping, mNightState: " + ah());
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (e.this.y) {
                    com.oppo.camera.e.a("CommonCapMode", "onBeforeSnapping, return after pause");
                    return;
                }
                boolean cQ = e.this.cQ();
                boolean z = cQ && e.this.ai();
                boolean fJ = e.this.fJ();
                if (e.this.fF()) {
                    e.this.Y.a((int) R.string.camera_scene_night_keep_phone_steady, -1, false, false, true);
                    e eVar = e.this;
                    eVar.aw = true;
                    if (eVar.fH()) {
                        e.this.ga();
                        e.this.ay = 1;
                    }
                }
                if (!e.this.u && ((e.this.au || cQ) && (!cQ || (!z && !fJ && !e.this.ax)))) {
                    c cVar = new c();
                    cVar.a("button_color_inside_none");
                    cVar.a(4);
                    e.this.Y.a(cVar);
                }
                if (e.this.f("key_beauty3d") && e.this.aU != null) {
                    if (e.this.fK()) {
                        e.this.aU.p();
                        e.this.aU.e(false);
                    } else {
                        e.this.aU.q();
                    }
                    String bv = e.this.bv();
                    if ((bv.equals("on") || bv.equals(MenuClickMsgData.VALUE_PROFESSION_AUTO)) && e.this.t && e.this.f("pref_camera_torch_mode_key")) {
                        e.this.aU.q();
                    }
                }
                if (e.this.fV()) {
                    e.this.K(false);
                }
                if (cQ && !e.this.u) {
                    e.this.fQ();
                    if (z || e.this.ax || fJ) {
                        e.this.ga();
                        e eVar2 = e.this;
                        eVar2.av = false;
                        boolean unused = eVar2.aL = false;
                        if (!fJ) {
                            e.this.Y.a((int) R.string.camera_scene_night_keep_phone_steady, -1, false, false, false);
                        }
                    }
                }
            }
        });
        if (this.t && Util.p() && this.X.j()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_LOCK_AE_BEFORE_CAPTURE_SUPPORT)) {
                this.W.a(true, false);
                this.M = true;
            }
            this.W.e(true);
            this.N = true;
            com.oppo.camera.e.b("CommonCapMode", "beforeSnapping, in QualcommPlatform front camera lock ae: " + this.M + " and awb: " + this.N + ", CameraMode: " + a());
        }
        if (dVar.ah) {
            if (ai()) {
                this.W.A(2400);
            }
            this.W.w(ah());
            if (!fN()) {
                this.W.a(1, com.oppo.camera.a.a(), com.oppo.camera.a.a(), false);
            }
            if (!cy()) {
                this.W.e(true);
            }
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_FILTER_SUPPORT) && !f("pref_night_filter_menu")) {
                o(g.f4385a);
            }
            bF();
            this.W.a((f.c) null);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MTK_FACE_BEAUTY_REMOSAIC_SUPPORT) && this.t && cb() && !ae()) {
            this.W.y(1);
        } else if (cb() || ae() || fT()) {
            this.W.y(0);
        } else {
            this.W.y(1);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MTK_INSENSOR_ZOOM)) {
            if (Util.p() || 4 != dVar.Z) {
                this.W.z(0);
            } else {
                this.W.z(1);
            }
        }
        M();
        boolean f = f("high_resolution_cancel_snapshot");
        if (ck() || av() || f) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    e.this.Y.d(false, false);
                    c cVar = new c();
                    cVar.a("button_color_inside_none");
                    cVar.a(4);
                    e.this.Y.a(cVar);
                }
            });
        }
        return true;
    }

    public void c(boolean z) {
        c o = o();
        if ((this.au || (fT() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI))) && !this.t) {
            if (z) {
                o.a(8);
                o.a("button_color_inside_none");
            } else {
                o.a(11);
                o.a("button_color_inside_none");
            }
        }
        this.Y.a(o);
    }

    /* access modifiers changed from: protected */
    public void d(ApsAdapterDecision.DecisionResult decisionResult) {
        if (!Util.p()) {
            this.W.m(decisionResult.mbAIShutter);
        }
        if (f(CameraFunction.AIS_SNAPSHOT)) {
            if (cB()) {
                com.oppo.camera.e.a("CommonCapMode", "onAISSnapshotChecked, in hdr return");
            } else if (decisionResult == null || 5 == decisionResult.mApsDecisionFeatureType || 7 == decisionResult.mApsDecisionSceneMode) {
                com.oppo.camera.e.a("CommonCapMode", "onAISSnapshotChecked, in QUADCFA return");
            } else if (this.X != null) {
                int p = this.X.p();
                com.oppo.camera.e.b("CommonCapMode", "onAISSnapshotChecked, aisBracket: " + p);
                if (p > 0 && decisionResult.mApsAlgoFlag != null && decisionResult.mApsAlgoFlag.length > 0) {
                    if (3 == decisionResult.mApsDecisionFeatureType && decisionResult.mMFSRFrameCount != 0 && 9 == decisionResult.mApsDecisionSceneMode) {
                        decisionResult.mApsBracketMode = p;
                        this.ao = p;
                        decisionResult.mCaptureEVList = null;
                        decisionResult.mCaptureNoNeedMatchMeta = 1;
                    } else if (ParameterKeys.ALGO_NAME_BLURLESS.equals(decisionResult.mApsAlgoFlag[0]) && 2 == decisionResult.mApsDecisionSceneMode && 2 == decisionResult.mApsDecisionFeatureType) {
                        decisionResult.mApsBracketMode = p;
                        this.ao = p;
                        decisionResult.mCaptureEVList = null;
                        decisionResult.mMultiFrameCount = Math.max(decisionResult.mMultiFrameCount, 4);
                    } else if (ParameterKeys.ALGO_NAME_PIC_BEST.equals(decisionResult.mApsAlgoFlag[0]) && this.t && 2 == decisionResult.mApsDecisionFeatureType) {
                        decisionResult.mApsBracketMode = p;
                        this.ao = p;
                        decisionResult.mCaptureEVList = null;
                        decisionResult.mMultiFrameCount = Math.min(decisionResult.mMultiFrameCount, 4);
                        System.arraycopy(new String[]{ApsParameters.ALGO_NAME_NONE}, 0, decisionResult.mApsAlgoFlag, 0, 1);
                    } else if (ParameterKeys.ALGO_NAME_COUPLE_HDR.equals(decisionResult.mApsAlgoFlag[0]) && 26 == decisionResult.mApsDecisionFeatureType) {
                        decisionResult.mApsBracketMode = p;
                        this.ao = p;
                        decisionResult.mCaptureEVList = null;
                        decisionResult.mCaptureNoNeedMatchMeta = 1;
                        decisionResult.mMultiFrameCount = 1;
                        decisionResult.mMFSRFrameCount = Math.max(decisionResult.mMFSRFrameCount, 5);
                        decisionResult.mApsDecisionFeatureType = 3;
                        decisionResult.mApsDecisionSceneMode = 9;
                        System.arraycopy(new String[]{ApsParameters.ALGO_NAME_NONE}, 0, decisionResult.mApsAlgoFlag, 0, 1);
                    } else if (1 < decisionResult.mApsAlgoFlag.length && ParameterKeys.ALGO_NAME_COUPLE_HDR.equals(decisionResult.mApsAlgoFlag[1]) && 28 == decisionResult.mApsDecisionFeatureType) {
                        decisionResult.mApsBracketMode = p;
                        this.ao = p;
                        decisionResult.mCaptureEVList = null;
                        decisionResult.mApsDecisionFeatureType = 2;
                        decisionResult.mApsDecisionSceneMode = 2;
                        decisionResult.mMultiFrameCount = Math.max(decisionResult.mMultiFrameCount, 4);
                        System.arraycopy(new String[]{ApsParameters.ALGO_NAME_NONE}, 0, decisionResult.mApsAlgoFlag, 1, 1);
                    } else if (!this.R) {
                    } else {
                        if (ParameterKeys.ALGO_NAME_HDR.equals(decisionResult.mApsAlgoFlag[0]) || ParameterKeys.ALGO_NAME_LOWLIGHT_HDR.equals(decisionResult.mApsAlgoFlag[0]) || ParameterKeys.ALGO_NAME_RAW_HDR.equals(decisionResult.mApsAlgoFlag[0])) {
                            decisionResult.mApsBracketMode = p;
                            this.ao = p;
                            decisionResult.mCaptureEVList = null;
                            if (M(this.t)) {
                                System.arraycopy(new String[]{ApsParameters.ALGO_NAME_NONE}, 0, decisionResult.mApsAlgoFlag, 0, 1);
                                decisionResult.mApsDecisionSceneMode = 9;
                                decisionResult.mApsDecisionFeatureType = 3;
                                decisionResult.mMultiFrameCount = 1;
                                decisionResult.mCaptureNoNeedMatchMeta = 1;
                                decisionResult.mMFSRFrameCount = Math.max(decisionResult.mMFSRFrameCount, 5);
                                return;
                            }
                            System.arraycopy(new String[]{ParameterKeys.ALGO_NAME_BLURLESS}, 0, decisionResult.mApsAlgoFlag, 0, 1);
                            decisionResult.mApsDecisionSceneMode = 2;
                            decisionResult.mApsDecisionFeatureType = 2;
                            decisionResult.mMultiFrameCount = 4;
                        }
                    }
                }
            }
        }
    }

    public void bg() {
        com.oppo.camera.e.d("CommonCapMode", "onCancelTakePicture, reset mbShutterCallback");
        if (fV()) {
            K(true);
        }
    }

    public void f(boolean z) {
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (!e.this.y) {
                    e.this.bK();
                }
                if (!e.this.bw() || e.this.Y.H() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                    e.this.Y.u(true);
                } else {
                    double by = e.this.by();
                    e.this.Y.a(e.this.Z.getString(R.string.camera_picture_size_standard_high_hint, new Object[]{Double.valueOf(by)}), 0, (int) R.color.screen_hint_text_color);
                }
                if (e.this.f(CameraFunction.GOOGLE_LENS)) {
                    e.this.fU();
                }
            }
        });
        super.f(z);
    }

    public void g(boolean z) {
        String string = this.aa.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value));
        com.oppo.camera.ui.inverse.c.INS.setPositionRatio(this.Z, "standard".equals(string) || "square".equals(string) || "standard_high".equals(string) ? 0.5f : 0.87f, z);
    }

    public boolean aM() {
        com.oppo.camera.e.a("CommonCapMode", "onAfterSnapping()");
        return true;
    }

    public int cY() {
        return this.aB;
    }

    /* access modifiers changed from: protected */
    public boolean aZ() {
        com.oppo.camera.e.a("CommonCapMode", "onBurstShotCapture");
        this.aB = 0;
        this.aC = 0;
        this.aE.removeMessages(1);
        this.X.a(true);
        fQ();
        a((ImageCategory.MetaItemInfo) null);
        if (Util.p() && this.W != null) {
            this.W.f(true);
            this.W.a((f.c) null);
        }
        if (fV()) {
            K(false);
        }
        if (be()) {
            return true;
        }
        bJ();
        if (this.W != null) {
            this.W.f(false);
            this.W.a((f.c) null);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2, boolean z3) {
        super.a(z, z2, z3);
        if (!z) {
            boolean z4 = this.t;
            if ((z2 && (!z4 || !cB())) || (z3 && z4 && cB())) {
                this.X.i();
            }
            if (z2) {
                this.X.c(0);
                if (fT() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                    com.oppo.camera.e.a("CommonCapMode", "onShutterCallback, PIOpen");
                    Handler handler = this.aE;
                    if (handler != null) {
                        handler.post(new Runnable() {
                            public void run() {
                                if (!e.this.v) {
                                    com.oppo.camera.e.a("CommonCapMode", "pictureTakenCallback is already received, so return");
                                } else if (e.this.Y.l() != 4) {
                                    c cVar = new c();
                                    cVar.a("button_color_inside_none");
                                    cVar.a(4);
                                    e.this.Y.a(cVar);
                                }
                            }
                        });
                    }
                }
                if (this.aU == null) {
                    return;
                }
                if (fK()) {
                    this.aU.p();
                } else {
                    this.aU.q();
                }
            }
        }
    }

    public void a(CaptureRequest captureRequest) {
        if (this.u) {
            this.aC++;
        }
        super.a(captureRequest);
    }

    public void a(ApsCaptureResult apsCaptureResult, CaptureRequest captureRequest) {
        com.oppo.camera.e.a("CommonCapMode", "onCaptureCompleted, result: " + apsCaptureResult + ", mReceivedRawResultNum: " + this.aR + ", mbPaused: " + this.y);
        if (!this.y && cQ()) {
            com.oppo.camera.f.d dVar = (com.oppo.camera.f.d) captureRequest.getTag();
            d.a a2 = dVar.a();
            if (d.a.CAPTURE_RAW == a2) {
                if (captureRequest.hashCode() == this.o) {
                    this.aO = apsCaptureResult.mSensorExposureTime.longValue();
                    if (!this.ax || ai()) {
                        if (dVar.M != null) {
                            this.az = (long) dVar.M.mNightTotalExpTime;
                        } else {
                            this.az = this.aO / 1000000;
                        }
                    }
                    if (ai() || this.ax) {
                        fR();
                    }
                }
                if (dVar.M != null && this.aR < dVar.M.mMultiFrameCount) {
                    this.aR++;
                }
            }
            if (this.W != null && !Util.p() && d.a.CAPTURE_REPROCESS == a2 && this.aR > 0) {
                this.W.w(0);
                this.W.a((f.c) null);
            }
        }
        super.a(apsCaptureResult, captureRequest);
    }

    public void S() {
        if (!this.y && this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (1 == e.this.ay && e.this.Y != null) {
                        e.this.Y.b((int) R.string.camera_scene_night_keep_phone_steady);
                        e.this.Y.a((int) R.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
                        e eVar = e.this;
                        eVar.ay = 2;
                        if (eVar.av) {
                            e.this.Y.a(false, true);
                            e.this.L(false);
                        }
                    } else if (e.this.af() && Util.f(MyApplication.d())) {
                        e.this.Y.a((int) R.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public boolean fH() {
        return !this.u && !fG() && cQ() && (!cQ() || !ai()) && !fJ();
    }

    private void fR() {
        long j;
        long j2 = 0;
        if (this.az == 0 || (this.ax && !ai())) {
            for (int i = 0; i < C(); i++) {
                long pow = (long) ((((double) this.aO) * Math.pow(2.0d, (double) (((float) i) / 2.0f))) / 1000000.0d);
                long j3 = ai() ? 5000 : 200;
                if (pow > j3) {
                    pow = j3;
                }
                j2 += pow;
            }
            j = this.ax ? (long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_NIGHT_PICTURE_HAND_PROCESS_TIME) : 3500;
            this.az = j2;
        } else {
            j = 0;
        }
        long round = ((long) Math.round(((float) (this.az + j)) / 1000.0f)) * 1000;
        this.at.a(round);
        com.oppo.camera.e.b("CommonCapMode", "onFirstCaptureArrived, nightProcessTotalTime: " + round + ", realTime: " + (j2 + j) + ", mNightCaptureTotalTime: " + this.az);
        fI();
    }

    /* access modifiers changed from: protected */
    public void fI() {
        if (this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (e.this.y) {
                        com.oppo.camera.e.b("CommonCapMode", "onFirstCaptureArrived, mbPaused, so return!");
                        return;
                    }
                    c cVar = new c();
                    cVar.a("button_color_inside_none");
                    long b2 = e.this.at.b();
                    if (b2 >= 2000) {
                        e.this.Y.k((int) b2);
                        int l = e.this.Y.l();
                        if (l == 2 || l == 10 || l == 11) {
                            cVar.a(3);
                        } else {
                            cVar.a(7);
                        }
                        e.this.Y.a(cVar);
                        e.this.Y.l(e.this.Z.getResources().getDimensionPixelOffset(R.dimen.night_countdown_time_margin_top));
                        e eVar = e.this;
                        boolean unused = eVar.aK = eVar.ai();
                        e.this.at.c();
                        e.this.at.d();
                    } else if (e.this.Y.l() == 1) {
                        cVar.a(4);
                    } else {
                        cVar.a(2);
                    }
                    e.this.Y.a(cVar);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void b(byte[] bArr, boolean z) {
        com.oppo.camera.e.c("CommonCapMode", "onBeforePictureTaken, mReceivedSnapNum: " + this.aB + ", isBurstShot: " + z);
        if (!this.y && z && this.aB < Util.d) {
            this.aB++;
            if (Util.p() && 1 == this.aB && this.W != null) {
                this.W.f(false);
                this.W.a((f.c) null);
            }
            this.Y.i(this.aB);
            if (SystemClock.uptimeMillis() - this.aS >= 30) {
                this.X.c(1);
                this.aS = SystemClock.uptimeMillis();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        com.oppo.camera.e.a("CommonCapMode", "onAfterPictureTaken, mReceivedSnapNum: " + this.aB + ", mBurstCaptureBufferLostNum: " + this.aC + ", isBurstShot: " + z);
        this.aL = true;
        if (!z) {
            if (this.X.j() && this.av && !this.T) {
                if (!this.Y.H()) {
                    this.Y.d(true, false);
                } else {
                    this.Y.d(false, true);
                }
            }
            boolean cQ = cQ();
            if (((this.Y.l() == 4 || this.Y.l() == 3) && ((f("pref_camera_hdr_mode_key") || f("pref_auto_night_scence_key") || f("pref_camera_pi_mode_key") || cQ) && !this.T && !av())) || 2 == this.ay) {
                f(cQ, z);
            }
            if (this.aw) {
                this.Y.b((int) R.string.camera_scene_night_keep_phone_steady);
                this.aw = false;
            }
            if (2 == this.ay) {
                this.Y.b((int) R.string.camera_scene_night_process_image_after_capture);
                this.ay = 0;
            } else if (af() && Util.f(MyApplication.d())) {
                this.Y.b((int) R.string.camera_scene_night_process_image_after_capture);
            }
            if (this.aU != null) {
                if (fK()) {
                    this.aU.e(true);
                    this.aU.p();
                } else {
                    this.aU.q();
                }
            }
            if (fV()) {
                K(true);
            }
        } else if (Util.d == this.aB + this.aC || (!Util.p() && this.aD.b())) {
            bJ();
        }
        w();
        if (er()) {
            this.Y.a((int) R.string.camera_10bit_pic_saved, -1, true, false, false);
        }
        if (this.t && Util.p() && this.X.j()) {
            x();
        }
    }

    /* access modifiers changed from: protected */
    public void f(boolean z, boolean z2) {
        if (this.av || !z) {
            this.Y.a(o(), f("pref_burst_shot_key"));
            if (!this.Y.s() && fT() && !z2 && this.Y.C()) {
                this.Y.r(false);
            }
            if (z) {
                if (this.aK || this.ax || 2 == this.ay) {
                    L(true);
                    this.Y.b((int) R.string.camera_scene_night_keep_phone_steady);
                    this.aK = false;
                }
                this.W.w(0);
                if (!fN()) {
                    this.X.V();
                    this.W.a(4, com.oppo.camera.a.a(), com.oppo.camera.a.a(), false);
                }
                this.W.e(false);
                this.W.a((f.c) null);
                o(cf());
                bI();
                fP();
                cP();
                return;
            }
            return;
        }
        com.oppo.camera.e.a("CommonCapMode", "resetAfterPictureTaken, CaptureRawTime not end");
    }

    /* access modifiers changed from: protected */
    public boolean P() {
        return "on".equals(this.aa.getString("pref_super_clear_portrait", "off")) && Q() && !this.u;
    }

    /* access modifiers changed from: protected */
    public boolean Q() {
        return f("pref_super_clear_portrait") && !cl() && !"on".equals(this.aa.getString("pref_camera_pi_mode_key", "off")) && !ae() && !af() && !bw();
    }

    /* access modifiers changed from: protected */
    public void bE() {
        com.oppo.camera.e.a("CommonCapMode", "onDisableBurstShot");
        if (this.u) {
            if (this.aB > 0) {
                this.X.c(2);
            }
            this.u = false;
            this.X.a(false);
            this.X.d(this.aB);
            com.oppo.camera.e.a("CommonCapMode", "onDisableBurstShot, CameraTest Continuous Shot End");
            this.aE.removeMessages(1);
            if (this.aB > 0) {
                if (!this.y) {
                    this.Y.af();
                }
                this.aE.sendEmptyMessageDelayed(1, 500);
                this.X.y();
            } else {
                this.Y.d(false);
                if (!f("pref_expand_popbar_key")) {
                    this.X.D();
                }
                if (f("pref_filter_menu")) {
                    this.Y.b(true);
                }
                if (f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                    this.Y.b(true);
                }
                cP();
            }
            fP();
            if (!this.Y.H()) {
                this.Y.a(true, false);
                this.Y.b(true, false);
                this.Y.c(true, false);
                this.Y.e(true, false);
            }
            if (fV()) {
                K(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int F(int i) {
        if (6 == i) {
            return this.Z.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_add_offset_x);
        }
        if (9 != i) {
            return 0;
        }
        if (this.X.aE() == null) {
            return -1;
        }
        return (int) this.X.aE()[0];
    }

    /* access modifiers changed from: protected */
    public int G(int i) {
        if (6 == i) {
            return this.Z.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_add_offset_y);
        }
        if (9 == i && this.X.aE() != null) {
            return ((int) this.X.aE()[1]) - this.Z.getResources().getDimensionPixelSize(R.dimen.bubble_sticker_guide_ultra_zoom_gap_y);
        }
        if (10 == i) {
            return Util.u() + this.Z.getResources().getDimensionPixelSize(R.dimen.bubble_super_text_gap_y);
        }
        return 0;
    }

    public void c(int i, boolean z) {
        super.c(i, z);
        if (i == 1) {
            G(false);
            if (!fV()) {
                return;
            }
            if (z) {
                I(true);
            } else {
                J(true);
            }
        } else if (i == 2) {
            if (p("key_bubble_type_add_beuty3d")) {
                if (!f("key_beauty3d") || Z() || !this.Y.s() || !"beauty".equals(bP()) || j.a(this.Z) != 0) {
                    this.Y.c(6, false);
                } else {
                    this.Y.a((View) null, 6, F(6), G(6));
                }
            }
            if (this.aU != null) {
                if (fK()) {
                    this.aU.e(true);
                    this.aU.p();
                } else {
                    this.aU.q();
                }
            }
            if (!fV()) {
                J(true);
            } else if (!z) {
                J(true);
            } else if (!this.Y.s()) {
                I(true);
            }
        } else if (i == 3 || i == 5) {
            b bVar = this.aU;
            if (bVar != null) {
                bVar.q();
            }
            if (!fV()) {
                return;
            }
            if (z) {
                I(true);
            } else {
                J(true);
            }
        } else {
            switch (i) {
                case 12:
                    if (this.aU == null) {
                        return;
                    }
                    if (!z || !fK()) {
                        this.aU.q();
                        return;
                    }
                    this.aU.e(true);
                    this.aU.p();
                    return;
                case 13:
                    G(z);
                    return;
                case 14:
                    b bVar2 = this.aU;
                    if (bVar2 != null) {
                        bVar2.j();
                        return;
                    }
                    return;
                case 15:
                    fE();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean dU() {
        return !cQ() || !this.v;
    }

    public boolean cV() {
        if (!cQ() || !ai()) {
            return super.cV();
        }
        return true;
    }

    public boolean ci() {
        return ae() && cB();
    }

    public int G() {
        int i;
        if (!ex()) {
            return super.G();
        }
        synchronized (this.i) {
            i = this.q;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public f.a O() {
        this.aR = 0;
        return super.O();
    }

    public void a(com.oppo.camera.f.d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        d.a a2 = dVar.a();
        if (d.a.PREVIEW == a2) {
            if ((cO() || f(CameraFunction.SUPER_TEXT_CPU_PROCESS)) && hashMap.containsKey("type_preview_frame")) {
                builder.addTarget(hashMap.get("type_preview_frame").a());
            }
        } else if (d.a.CAPTURE_REPROCESS == a2) {
            builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(this.az * 1000000));
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_PREVIEW) && hashMap.containsKey("type_main_preview_frame") && f(CameraFunction.NEED_PREVIEW_STREAM) && Util.p() && cQ()) {
                builder.addTarget(hashMap.get("type_main_preview_frame").a());
            }
        }
        super.a(dVar, builder, hashMap, i);
    }

    /* compiled from: CommonCapMode */
    private class a {

        /* renamed from: b  reason: collision with root package name */
        private Runtime f2869b;
        private long c;

        private a() {
            this.f2869b = null;
        }

        public void a() {
            if (this.f2869b == null) {
                this.f2869b = Runtime.getRuntime();
            }
            this.c = this.f2869b.maxMemory();
            com.oppo.camera.e.a("CommonCapMode", "initMemory, mMaxMemory: " + this.c);
        }

        public boolean b() {
            if (this.f2869b == null) {
                this.f2869b = Runtime.getRuntime();
            }
            if (this.c - (this.f2869b.totalMemory() - this.f2869b.freeMemory()) > 52428800) {
                return false;
            }
            com.oppo.camera.e.a("CommonCapMode", "isNeedStopCapture, realfree <= MIN_LEFT_MEMEORY");
            return true;
        }
    }

    public void dT() {
        if (p("key_bubble_type_custom_beuty3d")) {
            this.Y.c(5, true);
        }
        if (p("key_bubble_type_add_beuty3d") && j.a(this.Z) == 0 && !Z() && f("key_beauty3d") && "beauty".equals(bP())) {
            this.Y.a((View) null, 6, F(6), G(6));
        }
        if (this.aU != null) {
            if (fK()) {
                this.aU.e(true);
                this.aU.p();
            } else {
                this.aU.q();
            }
        }
        if (fV()) {
            J(false);
        }
    }

    public boolean ec() {
        return Util.p() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW) && f("pref_support_raw_post_process");
    }

    public boolean r(String str) {
        if ("type_preview_frame".equals(str)) {
            boolean z = (f("pref_camera_gesture_shutter_key") || f(CameraFunction.SUPER_TEXT_CPU_PROCESS)) && (ef() == 0 || ef() == 4);
            if (2 != AlgoSwitchConfig.getApsVersion() || !z) {
                return false;
            }
            return true;
        } else if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            if (3 != AlgoSwitchConfig.getApsVersion() || !f(CameraFunction.SAT_CAMERA) || bw() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
                return false;
            }
            return true;
        } else if ("type_still_capture_raw".equals(str)) {
            if (!f("pref_support_raw_post_process") || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CAPTURE_RAW)) {
                return false;
            }
            return true;
        } else if ("type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str)) {
            return ex();
        } else {
            if ("type_still_capture_jpeg".equals(str)) {
                return !AlgoSwitchConfig.getSupportApsCapture();
            }
            return super.r(str);
        }
    }

    public int y(String str) {
        if (!str.equals("type_reprocess_data_yuv") || !er()) {
            return super.y(str);
        }
        return 34;
    }

    public void s(boolean z) {
        if (p("key_bubble_type_add_beuty3d")) {
            this.Y.c(6, true);
        }
        if (p("key_bubble_type_custom_beuty3d")) {
            this.Y.c(5, true);
        }
        b bVar = this.aU;
        if (bVar != null) {
            bVar.q();
        }
        if (fV()) {
            I(true);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) && com.oppo.camera.f.a.j() != a(this.n) && !this.t && bX() == 0 && !this.bb) {
            this.X.b(this.aZ);
        }
    }

    public boolean cl() {
        if (this.aa == null || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            return false;
        }
        return TextUtils.equals("on", this.aa.getString("pref_camera_pi_ai_mode_key", this.Z.getString(R.string.camera_pi_ai_default_value)));
    }

    public boolean cm() {
        String str;
        if (!f("pref_ai_scene_key")) {
            return false;
        }
        if (this.Z != null) {
            str = this.Z.getString(R.string.camera_ai_scene_default_value);
        } else {
            str = "on";
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && this.Z != null) {
            str = this.Z.getString(R.string.camera_pi_ai_scene_default_value);
        }
        if (this.aa != null) {
            str = this.aa.getString("pref_ai_scene_key", str);
        }
        return "on".equals(str);
    }

    /* access modifiers changed from: protected */
    public int ef() {
        b bVar = this.aU;
        if (bVar != null) {
            return bVar.f();
        }
        return 0;
    }

    public boolean fK() {
        if (j.a(this.Z) != 1 || !f("key_beauty3d") || bX() != -1 || !this.Y.s() || ef() != 0 || !"beauty".equals(bP())) {
            return false;
        }
        return true;
    }

    public void a(ApsTotalResult apsTotalResult) {
        int[] iArr;
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            com.oppo.camera.e.e("CommonCapMode", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
            return;
        }
        CaptureResult totalResult = apsTotalResult.getTotalResult();
        if (!Z() || !fD()) {
            int[] a2 = this.W.a((CaptureResult.Key<?>) com.oppo.camera.f.c.T, totalResult);
            boolean z = false;
            if (a2 != null && a2.length > 0 && !this.v && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_AUTO_MICRO)) {
                if (1 == a2[0]) {
                    if (!this.aN) {
                        com.oppo.camera.e.b("CommonCapMode", "onPreviewCaptureResult, micro mode");
                        this.aN = true;
                        if (this.aE != null) {
                            Message obtain = Message.obtain();
                            obtain.what = 4;
                            obtain.arg1 = 1;
                            this.aE.sendMessage(obtain);
                        }
                    }
                } else if (this.aN) {
                    com.oppo.camera.e.b("CommonCapMode", "onPreviewCaptureResult, exit micro mode");
                    this.aN = false;
                    Handler handler = this.aE;
                    if (handler != null) {
                        handler.sendEmptyMessage(5);
                    }
                }
            }
            if (!this.v) {
                if (Util.p()) {
                    iArr = this.W.a((CaptureResult.Key<?>) com.oppo.camera.f.c.U, totalResult);
                } else {
                    iArr = this.W.a((CaptureResult.Key<?>) com.oppo.camera.f.c.V, totalResult);
                }
                if (iArr == null || iArr.length <= 0) {
                    this.au = false;
                } else {
                    if (iArr[0] == 1) {
                        z = true;
                    }
                    this.au = z;
                }
            }
            super.a(apsTotalResult);
            return;
        }
        this.aU.b(totalResult);
    }

    public void cP() {
        Handler handler;
        if (!this.aw) {
            super.cP();
        }
        if (er() && !this.t) {
            this.Y.a(this.Z.getString(R.string.camera_10bit_hint), 0, (int) R.color.screen_hint_text_color);
        }
        if (this.aN && (handler = this.aE) != null) {
            handler.sendEmptyMessage(4);
        }
    }

    /* access modifiers changed from: private */
    public void fS() {
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.Z, true);
        if (this.X != null) {
            if (!this.X.j()) {
                reminderMsgData.mCameraEnterType = String.valueOf(2);
            }
            reminderMsgData.mCameraId = this.X.aq();
        }
        reminderMsgData.mCaptureMode = a();
        reminderMsgData.mOrientation = this.k;
        reminderMsgData.mReminderTypeValue = "ai_scene";
        reminderMsgData.mReminderCodeValue = String.valueOf(18);
        reminderMsgData.mRearOrFront = this.t ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    /* access modifiers changed from: protected */
    public void x(int i) {
        b bVar = this.aU;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    private void G(boolean z) {
        if (this.y) {
            com.oppo.camera.e.e("CommonCapMode", "handleBeauty3DGuideView, pause, so return");
            return;
        }
        b bVar = this.aU;
        if (bVar == null) {
            com.oppo.camera.e.a("CommonCapMode", "handleBeauty3DGuideView, mBeauty3DManager null");
        } else if (!z) {
            if (bVar.i()) {
                this.aU.m();
            }
        } else if (!f("key_beauty3d")) {
            com.oppo.camera.e.a("CommonCapMode", "handleBeauty3DGuideView, not support return");
        } else if (j.a(this.Z) == 1) {
            com.oppo.camera.e.a("CommonCapMode", "handleBeauty3DGuideView, files exist, return");
        } else if (this.X.j() && z && this.aa.getBoolean("key_front_camera_first_switch", true)) {
            com.oppo.camera.e.a("CommonCapMode", "handleBeauty3DGuideView, start showBeauty3DGuide");
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putBoolean("key_front_camera_first_switch", false);
            edit.apply();
            this.Y.w();
            this.aU.c(e(this.W.e()));
        } else if (db() && z) {
            this.Y.w();
            this.aU.d(e(this.W.e()));
        }
    }

    /* access modifiers changed from: private */
    public void H(boolean z) {
        if (this.X != null) {
            this.X.f(z);
        }
    }

    private boolean fT() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            if (!f("pref_camera_pi_ai_mode_key")) {
                return false;
            }
            return cl();
        } else if (f("pref_camera_pi_mode_key") && this.aa != null && "on".equals(this.aa.getString("pref_camera_pi_mode_key", "off"))) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean cQ() {
        return f("pref_support_night_process") && cm() && ah() > 0 && this.X != null && this.X.j() && 12 == this.X.k() && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || !fT()) && !cb() && !ae() && !cB() && !cz() && !P();
    }

    /* access modifiers changed from: protected */
    public void fL() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            if (f("pref_camera_pi_ai_mode_key") && this.aa != null) {
                SharedPreferences.Editor edit = this.aa.edit();
                edit.putString("pref_camera_pi_ai_mode_key", "off");
                edit.commit();
                this.Y.f("pref_camera_pi_ai_mode_key");
            }
        } else if (f("pref_camera_pi_mode_key") && this.aa != null) {
            SharedPreferences.Editor edit2 = this.aa.edit();
            edit2.putString("pref_camera_pi_mode_key", "off");
            edit2.commit();
            this.Y.f("pref_camera_pi_mode_key");
        }
    }

    public boolean ex() {
        if (f(CameraFunction.SAT_CAMERA)) {
            return !bw();
        }
        return false;
    }

    public void ey() {
        if (bw()) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putBoolean("key_high_picture_size", false);
            edit.putString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value));
            edit.apply();
        }
    }

    /* access modifiers changed from: protected */
    public int eD() {
        if (eB()) {
            return (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || Float.compare(this.W.e().n(), 0.0f) == 0) ? R.string.ultra_wide_angel_toast : Util.d((int) R.string.ultra_wide_micro_lens_toast);
        }
        return -1;
    }

    public void eF() {
        super.eF();
        if (this.Z != null) {
            com.oppo.camera.e.a("CommonCapMode", "displayFixedUpModeHint");
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (e.this.bw() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                        double by = e.this.by();
                        e.this.Y.a(e.this.Z.getString(R.string.camera_picture_size_standard_high_hint, new Object[]{Double.valueOf(by)}), 0, (int) R.color.screen_hint_text_color);
                    }
                }
            });
        }
    }

    public ab dl() {
        ab dl = super.dl();
        dl.i(bw());
        dl.k(f("pref_ultra_wide_high_picture_size_key"));
        dl.p(f("key_support_insensor_zoom_20x"));
        dl.q(f("key_support_insensor_zoom_20x") && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_INSENSOR_ZOOM_POINT_3X_SUPPORT));
        return dl;
    }

    public boolean ck() {
        if (f(CameraFunction.SUPER_TEXT)) {
            return this.aM;
        }
        return false;
    }

    public void eL() {
        if (this.X.j()) {
            this.Y.d(true, false);
        }
        if (this.Y.l() == 4) {
            this.Y.a(o(), f("pref_burst_shot_key"));
        }
    }

    public void dm() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.aa.contains("pref_ultra_wide_high_picture_size_key")) {
            this.O = true;
            this.aa.edit().putString("pref_ultra_wide_high_picture_size_key", "off").apply();
            this.O = false;
        }
    }

    public String b() {
        if (this.z) {
            return null;
        }
        if (this.X != null && !this.X.j()) {
            return ApsConstant.FEATURE_COMMON_DUMMY;
        }
        if (ex() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
            return ApsConstant.FEATURE_COMMON_SAT_HAL;
        }
        if (bw()) {
            return ApsConstant.FEATURE_COMMON_DUMMY;
        }
        return super.b();
    }

    public boolean w(String str) {
        if ("type_main_preview_frame".equals(str) || "type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            if ((!Util.p() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && ex() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
                return true;
            }
            return false;
        } else if (!"type_still_capture_yuv_main".equals(str) && !"type_still_capture_yuv_sub".equals(str) && !"type_still_capture_yuv_third".equals(str) && !"type_tuning_data_yuv".equals(str)) {
            return super.w(str);
        } else {
            if ((!Util.p() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && ex()) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003a, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(boolean r4, boolean r5) {
        /*
            r3 = this;
            boolean r0 = r3.ex()
            if (r0 == 0) goto L_0x0040
            java.lang.Object r0 = r3.i
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r1 = r3.af     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x003b
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r1 = r3.af     // Catch:{ all -> 0x003d }
            int[] r1 = r1.mSensorMask     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x003b
            r1 = 0
            r2 = 1
            if (r4 == 0) goto L_0x0022
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r3.af     // Catch:{ all -> 0x003d }
            int[] r4 = r4.mSensorMask     // Catch:{ all -> 0x003d }
            r4 = r4[r1]     // Catch:{ all -> 0x003d }
            if (r2 != r4) goto L_0x0020
            r1 = r2
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return r1
        L_0x0022:
            if (r5 == 0) goto L_0x0030
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r3.af     // Catch:{ all -> 0x003d }
            int[] r4 = r4.mSensorMask     // Catch:{ all -> 0x003d }
            r5 = 2
            r4 = r4[r5]     // Catch:{ all -> 0x003d }
            if (r2 != r4) goto L_0x002e
            r1 = r2
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return r1
        L_0x0030:
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r3.af     // Catch:{ all -> 0x003d }
            int[] r4 = r4.mSensorMask     // Catch:{ all -> 0x003d }
            r4 = r4[r2]     // Catch:{ all -> 0x003d }
            if (r2 != r4) goto L_0x0039
            r1 = r2
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return r1
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0040
        L_0x003d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r4
        L_0x0040:
            boolean r4 = super.a((boolean) r4, (boolean) r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.e.a(boolean, boolean):boolean");
    }

    /* access modifiers changed from: protected */
    public boolean C(int i) {
        return !this.u && (17 == i || 18 == i || 19 == i) && !this.t;
    }

    public boolean w(int i) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL) && i == 0 && this.aT == 0) {
            return false;
        }
        return super.w(i);
    }

    public void a(TotalCaptureResult totalCaptureResult) {
        super.a(totalCaptureResult);
        this.aT++;
    }

    public void bM() {
        if (fV()) {
            J(false);
        }
    }

    public void bN() {
        if (fV()) {
            I(true);
        }
    }

    public void dr() {
        if (fV()) {
            J(false);
        }
    }

    public void t(int i) {
        if (fV()) {
            I(true);
        }
        if (1 != i && 2 != i) {
            B();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fU() {
        /*
            r4 = this;
            android.app.Activity r0 = r4.Z
            r1 = 0
            if (r0 == 0) goto L_0x0013
            android.app.Activity r0 = r4.Z
            android.content.Context r0 = r0.getApplicationContext()
            r2 = 0
            java.lang.String r3 = "rom_update_info"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r2)
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 == 0) goto L_0x002b
            java.lang.String r2 = "google_lens_switch"
            java.lang.String r0 = r0.getString(r2, r1)
            if (r0 == 0) goto L_0x002b
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0027 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0027 }
            goto L_0x002c
        L_0x0027:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002b:
            r0 = 1
        L_0x002c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkGoogleLensAvailability, enableGoogleLens: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CommonCapMode"
            com.oppo.camera.e.a(r2, r1)
            if (r0 == 0) goto L_0x0063
            com.google.lens.sdk.LensApi r0 = r4.aW
            if (r0 != 0) goto L_0x0063
            android.app.Activity r0 = r4.Z
            if (r0 == 0) goto L_0x0063
            com.google.lens.sdk.LensApi r0 = new com.google.lens.sdk.LensApi
            android.app.Activity r1 = r4.Z
            android.content.Context r1 = r1.getApplicationContext()
            r0.<init>(r1)
            r4.aW = r0
            com.google.lens.sdk.LensApi r0 = r4.aW
            com.oppo.camera.e.e$4 r1 = new com.oppo.camera.e.e$4
            r1.<init>()
            r0.checkLensAvailability(r1)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.e.fU():void");
    }

    /* access modifiers changed from: private */
    public boolean fV() {
        if (f(CameraFunction.GOOGLE_LENS)) {
            return this.aV;
        }
        return false;
    }

    private void fW() {
        this.Z.getLayoutInflater().inflate(R.layout.google_lens, this.ac);
        this.aX = (RotateImageView) this.ac.findViewById(R.id.google_lens_icon_view);
        this.aX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (e.this.aW != null) {
                    try {
                        e.this.aW.launchLensActivity(e.this.Z);
                        e.this.fX();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void fX() {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
        menuClickMsgData.buildEvent(false);
        if (this.X != null) {
            menuClickMsgData.mCameraId = this.X.aq();
        }
        menuClickMsgData.mCaptureMode = a();
        menuClickMsgData.mFuncKeyId = 53;
        menuClickMsgData.report();
    }

    /* access modifiers changed from: private */
    public void I(boolean z) {
        if (!this.Y.s() && !this.Y.C() && !this.Y.H() && !this.Y.ai() && !this.X.x() && this.aY) {
            if (this.aX == null) {
                fW();
            }
            if (z) {
                Util.a((View) this.aX);
                return;
            }
            Animation animation = this.aX.getAnimation();
            if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
                animation.cancel();
            }
            this.aX.setVisibility(0);
        }
    }

    private void J(boolean z) {
        RotateImageView rotateImageView = this.aX;
        if (rotateImageView == null) {
            return;
        }
        if (z) {
            Util.b((View) rotateImageView);
            return;
        }
        Animation animation = rotateImageView.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            animation.cancel();
        }
        this.aX.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void K(boolean z) {
        RotateImageView rotateImageView = this.aX;
        if (rotateImageView != null) {
            rotateImageView.setClickable(z);
        }
    }

    private boolean fY() {
        KeyguardManager keyguardManager;
        if (this.Z == null || (keyguardManager = (KeyguardManager) this.Z.getApplicationContext().getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.isDeviceLocked();
    }

    public void B() {
        super.B();
        if (this.Z != null && this.Y != null && !fZ() && z("key_bubble_type_zoom_ultra_wide")) {
            final View findViewById = this.Z.findViewById(R.id.zoom_seek_anchor_view);
            if (findViewById != null) {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (!e.this.fZ() && e.this.z("key_bubble_type_zoom_ultra_wide") && findViewById.getMeasuredWidth() != 0) {
                            e eVar = e.this;
                            eVar.a(eVar.Z.findViewById(R.id.zoom_seek_bar), 9);
                            findViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    }
                });
            }
            this.Y.aq();
        }
    }

    /* access modifiers changed from: private */
    public boolean fZ() {
        return this.Y != null && (this.Y.H() || this.Y.I());
    }

    public boolean z(String str) {
        if (com.oppo.camera.entry.b.a(this.as)) {
            return false;
        }
        if ("key_drawer_layout_anchor".equals(str)) {
            return p("key_drawer_layout_anchor");
        }
        if (!"key_bubble_type_zoom_ultra_wide".equals(str) || !p("key_bubble_type_zoom_ultra_wide") || !f("pref_zoom_key") || this.t) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(View view, int i) {
        if (this.Y != null) {
            int F = F(i);
            if (-1 != F) {
                this.Y.a(view, i, F, G(i));
            } else {
                com.oppo.camera.e.d("CommonCapMode", "showFirstBubble, ultra wide anchor view not found");
            }
        }
    }

    /* access modifiers changed from: private */
    public void ga() {
        if (this.Y.s()) {
            this.Y.q(false);
        } else {
            this.Y.o(false);
        }
        this.Y.a(false, true, false, false);
        this.Y.j(4);
        this.Y.f(4);
        this.Y.b(4, Util.b(e(com.oppo.camera.f.a.a(this.n))));
        this.Y.h(4);
        this.X.a((Animation.AnimationListener) null);
        if (ej()) {
            this.Y.a(4, false);
        } else {
            this.Y.a(4);
        }
    }

    /* access modifiers changed from: private */
    public void L(boolean z) {
        this.Y.g(true);
        this.Y.j(0);
        this.Y.b(0, Util.b(e(com.oppo.camera.f.a.a(this.n))));
        if (f("pref_support_switch_camera")) {
            this.Y.f(0);
        }
        if (f(CameraFunction.FACE_BEAUTY_PROCESS)) {
            this.Y.r(true);
        }
        this.Y.h(0);
        this.X.as();
        if (z) {
            this.Y.af();
        }
        if (!this.Y.s()) {
            this.Y.p(true);
            this.X.D();
            if (ej()) {
                this.Y.a(0, false);
            } else if (!cS()) {
                this.Y.a(0);
            }
        }
    }

    public boolean cW() {
        return !fF() || !fH();
    }

    private boolean M(boolean z) {
        int[] configIntArrayValue;
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MFNR) || (configIntArrayValue = CameraConfig.getConfigIntArrayValue(ConfigDataBase.KEY_AIS_SNAPSHOT_USE_MFNR)) == null) {
            return false;
        }
        if (z) {
            if (1 == configIntArrayValue[1]) {
                return true;
            }
            return false;
        } else if (1 == configIntArrayValue[0]) {
            return true;
        } else {
            return false;
        }
    }

    public void r(boolean z) {
        this.bb = z;
    }

    public void l(int i) {
        if (this.y) {
            m(i);
        } else if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) || !this.t || this.bb) {
            super.l(i);
        } else {
            int bX = bX();
            com.oppo.camera.e.a("CommonCapMode", "onFaceBeautyItemChange, level: " + i + ", currentLevel: " + bX);
            if (bX != i) {
                if (i != 0) {
                    this.ba = gb();
                    if (this.ba != null) {
                        this.X.b(this.ba);
                    }
                } else {
                    this.X.b(this.aZ);
                }
            }
            super.l(i);
        }
    }

    private Size gb() {
        if (this.aa != null) {
            String string = this.aa.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value));
            com.oppo.camera.e.a("CommonCapMode", "getFaceBeautyPreviewSize, pictureSizeType: " + string);
            double d = 1.3333333333333333d;
            if (!"standard".equals(string) && !"standard_high".equals(string)) {
                if ("full".equals(string)) {
                    d = Util.G();
                } else if ("square".equals(string)) {
                    d = 1.0d;
                } else if ("16_9".equals(string)) {
                    d = 1.7777777777777777d;
                }
            }
            List<Size> configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE);
            if (configSizeListValue != null && configSizeListValue.size() > 0) {
                com.oppo.camera.e.a("CommonCapMode", "getFaceBeautyPreviewSize, sizeList: " + configSizeListValue.toString());
                return Util.a(configSizeListValue, d);
            }
        }
        return null;
    }

    public boolean bV() {
        Size gb;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) && com.oppo.camera.f.a.j() != a(this.n) && !this.t && !this.bb) {
            com.oppo.camera.e.a("CommonCapMode", "onFaceBeautyMenuClick, isFaceBeautyMenuOpen: " + this.Y.C());
            if (!this.Y.C() && (gb = gb()) != null) {
                this.X.b(gb);
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean dz() {
        return f(CameraFunction.TILT_SHIFT) && "on".equals(this.aa.getString("pref_photo_tilt_shift_key", "off"));
    }

    public void dC() {
        boolean dz = dz();
        com.oppo.camera.e.a("CommonCapMode", "onTiltShiftChanged, isOpen: " + dz);
        if (!dz) {
            this.Y.c(true, true, true);
            this.Y.y(true);
        }
        dy();
    }

    /* access modifiers changed from: protected */
    public void fM() {
        if (this.aa != null) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString("pref_photo_tilt_shift_key", "off");
            edit.commit();
            this.Y.f("pref_photo_tilt_shift_key");
            dC();
        }
    }
}
