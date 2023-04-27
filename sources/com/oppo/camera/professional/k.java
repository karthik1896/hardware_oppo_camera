package com.oppo.camera.professional;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.a.a.f;
import com.a.a.h;
import com.a.a.j;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureResult;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.e.b;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.professional.ListProfessionalModeBar;
import com.oppo.camera.professional.g;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.i;
import com.oppo.camera.ui.menu.levelcontrol.c;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProfessionalCapMode */
public class k extends com.oppo.camera.e.a implements View.OnClickListener, ListProfessionalModeBar.ModeBarStateListener, ListProfessionalModeBar.OnItemClickListener {
    private boolean aA = false;
    private int aB = 0;
    private long aC = 0;
    private Thread aD = null;
    /* access modifiers changed from: private */
    public i aE = null;
    /* access modifiers changed from: private */
    public ListProfessionalModeBar aF = null;
    /* access modifiers changed from: private */
    public g aG = null;
    private Handler aH = null;
    /* access modifiers changed from: private */
    public a aI = null;
    private Image aJ = null;
    private CaptureResult aK = null;
    /* access modifiers changed from: private */
    public c aL = null;
    /* access modifiers changed from: private */
    public boolean aM = true;
    private Resources aN;
    private int aO = -1;
    private boolean aP = false;
    private int aQ = 0;
    private boolean aR = false;
    /* access modifiers changed from: private */
    public RotateImageView aS = null;
    private int aT = 0;
    private int aU = 0;
    /* access modifiers changed from: private */
    public g.b aV = new g.b() {
        public void a(int i, String str, boolean z) {
            k.this.a(i, str, z);
        }
    };
    private volatile boolean at = false;
    /* access modifiers changed from: private */
    public boolean au = false;
    /* access modifiers changed from: private */
    public boolean av = false;
    private boolean aw = false;
    private boolean ax = false;
    private boolean ay = true;
    private boolean az = false;

    public String a() {
        return ApsConstant.CAPTURE_MODE_PROFESSIONAL;
    }

    public void a(CaptureRequest.Builder builder, int i, int i2, String[] strArr) {
    }

    public boolean aa() {
        return false;
    }

    public int c() {
        return 32777;
    }

    public boolean d() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void q() {
    }

    public void u(String str) {
    }

    public k(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
        this.aN = activity.getApplicationContext().getResources();
    }

    public boolean b(MotionEvent motionEvent) {
        com.oppo.camera.e.a("ProfessionalCapMode", "onSingleTapUp");
        if (f(motionEvent) && this.aF.isSelected() && !this.X.x()) {
            au();
        }
        e(motionEvent);
        return false;
    }

    public void y() {
        if (this.aF.isSelected()) {
            Util.a((View) this.aL, 4, (Animation.AnimationListener) null, 300);
            this.Y.a(0, true);
            this.aG.e();
            this.aF.a();
            this.W.t();
        }
    }

    public boolean c(MotionEvent motionEvent) {
        com.oppo.camera.e.a("ProfessionalCapMode", "onLongPress");
        e(motionEvent);
        return false;
    }

    private void e(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.Y.i().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == bt() || 4 == bt()) {
                fY();
                H(true);
                this.aG.setPanelsBarAuto(3);
                b_(3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public long aK() {
        return (long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_PROFESSIONAL);
    }

    public boolean aR() {
        if (1000000000 <= Long.parseLong(fK())) {
            return false;
        }
        return super.aR();
    }

    private void fI() {
        if (this.aL == null) {
            this.aL = new c(this.Z.getApplicationContext());
            this.aL.setEnabled(true);
            this.aL.setFocusable(false);
            this.aL.setClickable(true);
            this.aL.setNormalShape(true);
            this.aL.setVisibility(4);
            this.aL.setContentDescription(this.Z.getResources().getString(R.string.camera_description_professional_auto));
            Drawable b2 = Util.b((Context) this.Z, (int) R.drawable.pro_btn_mode_change_light_a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b2.getIntrinsicWidth(), b2.getIntrinsicHeight());
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMarginEnd(this.aN.getDimensionPixelSize(R.dimen.control_button_margin_edge));
            this.aL.setLayoutParams(layoutParams);
            ((RelativeLayout) this.Z.findViewById(R.id.control_panel_button_layout)).addView(this.aL);
            fJ();
        }
        this.aL.a(this.X.s(), false);
    }

    private void fJ() {
        j c = j.c();
        final f b2 = c.b();
        b2.a(com.a.a.g.b(10.0d, 20.0d));
        b2.a((h) new com.a.a.e() {
            public void a(f fVar) {
                float c = (float) fVar.c();
                k.this.aL.setScaleX(c);
                k.this.aL.setScaleY(c);
            }
        });
        final f b3 = c.b();
        b3.a(com.a.a.g.b(10.0d, 20.0d));
        b2.a((h) new com.a.a.e() {
            public void a(f fVar) {
                k.this.aL.setAlpha((float) fVar.c());
            }
        });
        b2.a(1.0d);
        b3.a(1.0d);
        this.aL.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    b2.b(0.8999999761581421d);
                    b3.b(0.6000000238418579d);
                } else if (action == 1 || action == 3) {
                    b2.b(1.0d);
                    b3.b(1.0d);
                    if (!k.this.v && !k.this.aG.g() && k.this.aF.isSelected()) {
                        int selectedPosition = k.this.aF.getSelectedPosition();
                        View childAt = k.this.aF.getChildAt(selectedPosition);
                        if (k.this.aM) {
                            k.this.aG.a(false, selectedPosition);
                            k.this.G(false);
                            if (3 == selectedPosition) {
                                k.this.H(false);
                            }
                            k.this.aV.a(selectedPosition, MenuClickMsgData.VALUE_PROFESSION_AUTO_OFF, false);
                            if (childAt != null) {
                                k.this.aF.getAdapter().a(childAt, 8, false);
                            }
                        } else {
                            k.this.aG.a(true, selectedPosition);
                            k.this.G(true);
                            if (3 == selectedPosition) {
                                k.this.H(true);
                            }
                            k.this.aV.a(selectedPosition, MenuClickMsgData.VALUE_PROFESSION_AUTO, true);
                            if (childAt != null) {
                                k.this.aF.getAdapter().a(childAt, 0, true);
                            }
                        }
                    }
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public void G(boolean z) {
        c cVar = this.aL;
        if (cVar == null) {
            return;
        }
        if (z) {
            cVar.a(true, (String) null, Util.b((Context) this.Z, (int) R.drawable.pro_btn_mode_change_light_a));
            this.aM = true;
            return;
        }
        cVar.a(false, (String) null, this.Z.getResources().getDrawable(R.drawable.pro_btn_mode_change_a));
        this.aM = false;
    }

    /* access modifiers changed from: private */
    public void H(boolean z) {
        g gVar;
        ListProfessionalModeBar listProfessionalModeBar = this.aF;
        if (listProfessionalModeBar != null && listProfessionalModeBar.getAdapter() != null && (gVar = this.aG) != null) {
            gVar.a(z);
            this.aF.getAdapter().a((List<? extends Map<String, ?>>) this.aG.getMainModeBarData());
            this.aF.d(3);
        }
    }

    public void eM() {
        this.aO = this.X.am();
        g gVar = this.aG;
        if (gVar == null) {
            return;
        }
        if (this.aR) {
            gVar.a(com.oppo.camera.f.a.a(this.aO), (g.a) null);
            if (aO()) {
                this.aG.a(com.oppo.camera.f.a.a(this.aO), 2000000000);
            }
            this.aG.a();
            return;
        }
        gVar.a(com.oppo.camera.f.a.a(this.aO), this.aH, (g.a) null);
        if (aO()) {
            this.aG.a(com.oppo.camera.f.a.a(this.aO), 2000000000);
        }
        fQ();
        this.aG.setSettleListener(this.aF);
        this.aG.setMotionListener(this.aV);
        a aVar = this.aI;
        if (aVar != null) {
            aVar.setVisibility(0);
            if (gk()) {
                this.aL.setVisibility(0);
            }
        }
        this.X.d(true);
        F(1);
        this.aR = true;
    }

    public boolean a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    /* access modifiers changed from: protected */
    public void s() {
        com.oppo.camera.e.a("ProfessionalCapMode", "onInitCameraMode, Start");
        bo();
        fI();
        LevelPanel.a();
        if (bp()) {
            this.aP = true;
        }
        this.au = "on".equals(this.aa.getString("pref_high_resolution_key", this.Z.getResources().getString(R.string.camera_high_resolution_default_value)));
        if (!this.au) {
            this.Y.b("pref_high_resolution_key", "off");
        }
        if (this.aE == null) {
            this.aE = new i(this.Y, new i.a() {
                public void a(boolean z) {
                    k.this.Y.g(true);
                    if (!z) {
                        com.oppo.camera.ui.control.c o = k.this.o();
                        o.a(14);
                        k.this.Y.a(o);
                    }
                }

                public void a() {
                    if (!k.this.y) {
                        k.this.aE.d();
                    }
                }
            });
        }
        if (this.aH == null) {
            this.aH = new Handler() {
                public void handleMessage(Message message) {
                    k.this.a(message.what, message);
                }
            };
        }
        if (1000000000 <= Long.parseLong(fK())) {
            this.Y.a(o());
        }
        this.Y.c(this.Z.getString(R.string.camera_description_common_shutter_button));
        fS();
        int i = 0;
        if (this.aG != null) {
            if (fW()) {
                this.aG.e();
            } else {
                this.aG.setVisibility(0);
            }
        }
        if (this.aF != null) {
            if (fW()) {
                i = 8;
            }
            this.aF.setVisibility(i);
        }
    }

    public void bN() {
        if (this.X.x() || this.v) {
            this.aw = true;
        } else {
            this.aI.setEnabled(true);
        }
    }

    public void bM() {
        this.aI.setEnabled(false);
        if (this.aF.isSelected()) {
            Util.a((View) this.aL, 4, (Animation.AnimationListener) null, 300);
            this.aG.setAllPopupInvisibility(AnimationUtils.loadAnimation(this.Z, R.anim.zoom_panel_level_out));
            this.aF.a();
            this.W.t();
        }
    }

    public boolean br() {
        this.au = "on".equals(this.aa.getString("pref_high_resolution_key", this.Z.getResources().getString(R.string.camera_high_resolution_default_value)));
        g gVar = this.aG;
        if ((gVar == null || gVar.g(1)) && !eJ()) {
            return this.au || (bs() == 0 && Util.p());
        }
        com.oppo.camera.e.a("ProfessionalCapMode", "getZSLMode exposure time isn't auto or raw open,so return false");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = com.oppo.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oppo.camera.aps.config.ConfigDataBase.KEY_DEFAULT_SENSOR_SIZE_SCALE);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Size d(com.oppo.camera.f.j r4) {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = r3.aa
            java.lang.String r1 = "pref_switch_camera_key"
            java.lang.String r2 = "camera_main"
            java.lang.String r0 = r0.getString(r1, r2)
            java.lang.String r1 = "camera_ultra_wide"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003a
            java.lang.String r0 = "com.oplus.default.sensor.size.scale"
            java.util.List r0 = com.oppo.camera.aps.config.CameraConfig.getConfigSizeListValue(r0)
            if (r0 == 0) goto L_0x003a
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x003a
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            android.util.Size r2 = (android.util.Size) r2
            int r2 = r2.getWidth()
            float r2 = (float) r2
            java.lang.Object r0 = r0.get(r1)
            android.util.Size r0 = (android.util.Size) r0
            int r0 = r0.getHeight()
            float r0 = (float) r0
            float r2 = r2 / r0
            double r0 = (double) r2
            goto L_0x003f
        L_0x003a:
            r0 = 4608683618675807573(0x3ff5555555555555, double:1.3333333333333333)
        L_0x003f:
            r2 = 256(0x100, float:3.59E-43)
            java.util.List r4 = r4.a((int) r2)
            android.util.Size r4 = com.oppo.camera.util.Util.c((java.util.List<android.util.Size>) r4, (double) r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.professional.k.d(com.oppo.camera.f.j):android.util.Size");
    }

    public boolean r(String str) {
        if ("type_still_capture_raw".equals(str)) {
            if ((f("pref_raw_control_key") || f("pref_super_raw_control_key")) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW)) {
                return true;
            }
            return false;
        } else if ("type_still_capture_jpeg".equals(str)) {
            return !AlgoSwitchConfig.getSupportApsCapture();
        } else {
            if (!"type_tuning_data_raw".equals(str)) {
                return super.r(str);
            }
            if (Util.p() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT)) {
                return false;
            }
            if (f("pref_raw_control_key") || f("pref_super_raw_control_key")) {
                return true;
            }
            return false;
        }
    }

    public boolean eJ() {
        return (f("pref_raw_control_key") && !"off".equals(this.aa.getString("pref_raw_control_key", "off"))) || (f("pref_super_raw_control_key") && !"off".equals(this.aa.getString("pref_super_raw_control_key", "off")));
    }

    /* access modifiers changed from: protected */
    public boolean aO() {
        return f("pref_super_raw_control_key") && "super_raw".equals(this.aa.getString("pref_super_raw_control_key", "off"));
    }

    public boolean eK() {
        return this.am;
    }

    public void s(String str) {
        if ("pref_super_raw_control_key".equals(str) && this.Y.U()) {
            this.Y.a("pref_super_raw_control_key", true, (int) this.Z.getResources().getDimension(R.dimen.super_raw_setting_menu_reddot_offset_x), (int) this.Z.getResources().getDimension(R.dimen.super_raw_setting_menu_reddot_offset_y));
        }
    }

    public void an() {
        com.oppo.camera.e.a("ProfessionalCapMode", "closeImageReader");
        Image image = this.aJ;
        if (image != null) {
            image.close();
            this.aJ = null;
        }
        this.aK = null;
        this.ay = true;
    }

    public boolean i(String str) {
        return !"pref_camera_photo_ratio_key".equals(str);
    }

    public List<String> a(String str, int i) {
        if ("pref_camera_timer_shutter_key".equals(str)) {
            List<String> b2 = b(str, i);
            ArrayList arrayList = new ArrayList();
            if (b2 != null) {
                arrayList.addAll(b2);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } else if ("pref_camera_photo_ratio_key".equals(str)) {
            List<String> supportedList = CameraConfig.getSupportedList("pref_camera_photo_ratio_key", i);
            ArrayList arrayList2 = new ArrayList();
            if (supportedList != null && supportedList.contains("standard")) {
                arrayList2.add("standard");
            }
            if (arrayList2.size() > 0) {
                return arrayList2;
            }
            return null;
        } else if (!"pref_camera_flashmode_key".equals(str)) {
            return super.a(str, i);
        } else {
            List<String> b3 = b("pref_camera_flashmode_key", this.n);
            ArrayList arrayList3 = new ArrayList();
            if (b3 != null) {
                arrayList3.addAll(b3);
            }
            if (arrayList3.size() > 0) {
                return arrayList3;
            }
            return null;
        }
    }

    public boolean d(String str) {
        if ("pref_camera_flashmode_key".equals(str)) {
            return true;
        }
        if ("pref_switch_dual_camera_key".equals(str) || "pref_camera_timer_shutter_key".equals(str) || "pref_raw_key".equals(str) || "pref_high_resolution_key".equals(str) || "pref_switch_camera_key".equals(str) || "pref_raw_control_key".equals(str) || "pref_super_raw_control_key".equals(str) || "pref_setting_key".equals(str)) {
            return f(str);
        }
        return super.d(str);
    }

    public int fC() {
        return this.X.s();
    }

    /* access modifiers changed from: private */
    public String fK() {
        return this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value));
    }

    private long fL() {
        return Long.parseLong(this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value)));
    }

    public int fp() {
        String string = this.aa.getString("pref_professional_iso_key", this.Z.getResources().getString(R.string.camera_iso_default_value));
        if (this.Z.getResources().getString(R.string.camera_iso_default_value).equals(string)) {
            return this.aB;
        }
        return Integer.parseInt(string);
    }

    public long fq() {
        long parseLong = Long.parseLong(fK());
        return -1 == parseLong ? this.aC : parseLong;
    }

    private int a(int i, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int abs = Math.abs(Integer.parseInt(arrayList.get(0)) - i);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int parseInt = Integer.parseInt(arrayList.get(i3)) - i;
            if (Math.abs(parseInt) < abs) {
                abs = Math.abs(parseInt);
                i2 = i3;
            }
        }
        return i2;
    }

    private int a(float f, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float abs = Math.abs(Float.parseFloat(arrayList.get(0)) - f);
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float parseFloat = Float.parseFloat(arrayList.get(i2)) - f;
            if (Math.abs(parseFloat) < abs) {
                abs = Math.abs(parseFloat);
                i = i2;
            }
        }
        return i;
    }

    private int a(long j, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long abs = Math.abs(Long.parseLong(arrayList.get(0)) - j);
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long parseLong = Long.parseLong(arrayList.get(i2)) - j;
            if (Math.abs(parseLong) < abs) {
                abs = Math.abs(parseLong);
                i = i2;
            }
        }
        return i;
    }

    public void a(ApsTotalResult apsTotalResult) {
        CaptureResult.Key key;
        int i;
        int a2;
        ArrayList<String> c;
        int a3;
        ArrayList<String> c2;
        int a4;
        ArrayList<String> c3;
        int a5;
        ArrayList<String> c4;
        super.a(apsTotalResult);
        if (this.A) {
            if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
                com.oppo.camera.e.e("ProfessionalCapMode", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
                return;
            }
            CaptureResult totalResult = apsTotalResult.getTotalResult();
            if (Util.p()) {
                key = com.oppo.camera.f.c.N;
            } else {
                key = com.oppo.camera.f.c.aa;
            }
            Integer num = (Integer) totalResult.get(CaptureResult.SENSOR_SENSITIVITY);
            Long l = (Long) totalResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            Float f = (Float) totalResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
            if (key != null) {
                try {
                    i = ((int[]) totalResult.get(key))[0];
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (num != null && this.aG.g(0) && (a5 = a(num.intValue(), this.aG.b(0))) > -1 && (!this.aG.b(0, a5) || !this.az)) {
                    com.oppo.camera.e.b("ProfessionalCapMode", "onPreviewCaptureResult, iso: " + num);
                    this.aB = num.intValue();
                    c4 = this.aG.c(0);
                    if (c4 != null && c4.size() > a5) {
                        String str = c4.get(a5);
                        LevelPanel.a("pref_professional_iso_key", str);
                        this.aG.scrollTo(0, a5);
                        a(0, str);
                    }
                }
                if (l != null && this.aG.g(1) && (a4 = a(l.longValue(), this.aG.b(1))) > -1 && (!this.aG.b(1, a4) || !this.az)) {
                    com.oppo.camera.e.b("ProfessionalCapMode", "onPreviewCaptureResult, exposureTime: " + l);
                    this.aC = l.longValue();
                    c3 = this.aG.c(1);
                    if (c3 != null && c3.size() > a4) {
                        String str2 = c3.get(a4);
                        LevelPanel.a("pref_professional_exposure_time_key", str2);
                        this.aG.scrollTo(1, a4);
                        a(1, str2);
                    }
                }
                if (this.aG.g(2) && (a3 = a(i, this.aG.b(2))) > -1 && (!this.aG.b(2, a3) || !this.az)) {
                    com.oppo.camera.e.b("ProfessionalCapMode", "onPreviewCaptureResult, cct: " + i);
                    c2 = this.aG.c(2);
                    if (c2 != null && c2.size() > a3) {
                        String str3 = c2.get(a3);
                        LevelPanel.a("pref_professional_whitebalance_key", str3);
                        this.aG.scrollTo(2, a3);
                        a(2, str3);
                    }
                }
                if (f != null && this.aG.g(3) && (a2 = a(f.floatValue(), this.aG.b(3))) > -1 && (!this.aG.b(3, a2) || !this.az)) {
                    com.oppo.camera.e.b("ProfessionalCapMode", "onPreviewCaptureResult, focusDistance: " + f);
                    c = this.aG.c(3);
                    if (c != null && c.size() > a2) {
                        String str4 = c.get(a2);
                        LevelPanel.a("pref_professional_focus_mode_key", str4);
                        this.aG.scrollTo(3, a2);
                        a(3, str4);
                    }
                }
                this.az = true;
            }
            i = 0;
            com.oppo.camera.e.b("ProfessionalCapMode", "onPreviewCaptureResult, iso: " + num);
            this.aB = num.intValue();
            c4 = this.aG.c(0);
            String str5 = c4.get(a5);
            LevelPanel.a("pref_professional_iso_key", str5);
            this.aG.scrollTo(0, a5);
            a(0, str5);
            com.oppo.camera.e.b("ProfessionalCapMode", "onPreviewCaptureResult, exposureTime: " + l);
            this.aC = l.longValue();
            c3 = this.aG.c(1);
            String str22 = c3.get(a4);
            LevelPanel.a("pref_professional_exposure_time_key", str22);
            this.aG.scrollTo(1, a4);
            a(1, str22);
            com.oppo.camera.e.b("ProfessionalCapMode", "onPreviewCaptureResult, cct: " + i);
            c2 = this.aG.c(2);
            String str32 = c2.get(a3);
            LevelPanel.a("pref_professional_whitebalance_key", str32);
            this.aG.scrollTo(2, a3);
            a(2, str32);
            com.oppo.camera.e.b("ProfessionalCapMode", "onPreviewCaptureResult, focusDistance: " + f);
            c = this.aG.c(3);
            String str42 = c.get(a2);
            LevelPanel.a("pref_professional_focus_mode_key", str42);
            this.aG.scrollTo(3, a2);
            a(3, str42);
            this.az = true;
        }
    }

    public boolean f(String str) {
        g gVar;
        ListProfessionalModeBar listProfessionalModeBar;
        if ("pref_camera_gesture_shutter_key".equals(str) || "pref_manual_exposure_key".equals(str) || "pref_support_switch_camera".equals(str) || "pref_camera_tap_shutter_key".equals(str)) {
            return false;
        }
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_setting_key".equals(str)) {
            return true;
        }
        if ("pref_switch_dual_camera_key".equals(str)) {
            return !this.t;
        }
        if ("pref_support_post_view".equals(str)) {
            return false;
        }
        if ("pref_professional_exposure_time_key".equals(str) && this.aa != null) {
            String string = this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value));
            if (this.au || 1000000000 > Long.parseLong(string)) {
                return false;
            }
            return true;
        } else if ("pref_camera_flashmode_key".equals(str)) {
            return !this.t;
        } else {
            if ("pref_zoom_key".equals(str)) {
                if (fW()) {
                    return false;
                }
                if ((!fH() || !eJ()) && !aO()) {
                    return true;
                }
                return false;
            } else if ("pref_expand_popbar_key".equals(str)) {
                return false;
            } else {
                if ("pref_raw_key".equals(str)) {
                    return CameraConfig.getSupportSettingMenuKey("pref_raw_key");
                }
                if ("pref_camera_gradienter_key".equals(str)) {
                    return false;
                }
                if ("pref_headline_control_by_mode".equals(str) && (listProfessionalModeBar = this.aF) != null) {
                    return listProfessionalModeBar.isSelected();
                }
                if ("pref_high_resolution_key".equals(str)) {
                    return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_RESOLUTION);
                }
                if ("pref_support_capture_preview".equals(str)) {
                    if (this.X == null || !this.X.j() || f("key_support_update_thumbnail_user_picture") || eK()) {
                        return false;
                    }
                    return true;
                } else if ("key_support_update_thumbnail_user_picture".equals(str)) {
                    if (aO() || ((this.X != null && this.X.j() && (gVar = this.aG) != null && !gVar.g(1)) || eK())) {
                        return true;
                    }
                    return false;
                } else if ("pref_switch_camera_key".equals(str)) {
                    if (CameraConfig.getConfigIntValue(ConfigDataBase.KEY_PROFESSIONAL_SWITCH_CAMERA_TYPE) != 0) {
                        return true;
                    }
                    return false;
                } else if ("pref_raw_control_key".equals(str)) {
                    return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_RAW);
                } else {
                    if ("pref_super_raw_control_key".equals(str)) {
                        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW);
                    }
                    if ("pref_camera_slogan_key".equals(str)) {
                        return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_WATERMARK);
                    }
                    if ("pref_none_sat_tele_angle_key".equals(str)) {
                        return false;
                    }
                    return super.f(str);
                }
            }
        }
    }

    private void a(ListProfessionalModeBar listProfessionalModeBar, int i, ListModeBarAdapter listModeBarAdapter, ListProfessionalModeBar.OnItemClickListener onItemClickListener) {
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setId(i);
            listProfessionalModeBar.setAdapter(listModeBarAdapter);
            listProfessionalModeBar.setOnItemClickListener(onItemClickListener);
        }
    }

    private void fM() {
        if (this.W != null) {
            if (this.au) {
                this.W.b(Long.parseLong(this.Z.getResources().getString(R.string.camera_exposure_time_default_value)));
                this.W.a(Long.parseLong(this.Z.getResources().getString(R.string.camera_exposure_time_default_value)));
            } else {
                String a2 = this.aG.a(2);
                if (this.aa.getString("pref_professional_whitebalance_key", a2).equals(a2)) {
                    fE();
                } else {
                    fD();
                }
                B((String) null);
                if (fW()) {
                    this.W.f(com.oppo.camera.a.b());
                } else {
                    this.W.f(fF());
                }
                A((String) null);
                F(5);
            }
            F(3);
        }
    }

    private void fN() {
        fO();
        fP();
        F(3);
        this.aP = false;
        this.aa.edit().remove("pref_restore_professional_params").apply();
    }

    public void F(int i) {
        if (Thread.currentThread() != this.aD) {
            Handler handler = this.aH;
            if (handler != null) {
                handler.sendEmptyMessage(i);
                return;
            }
            return;
        }
        a(i, (Message) null);
    }

    public void a(int i, Message message) {
        switch (i) {
            case 1:
                if (this.aF.isSelected()) {
                    int selectedPosition = this.aF.getSelectedPosition();
                    this.aF.a(selectedPosition, true);
                    View childAt = this.aF.getChildAt(selectedPosition);
                    if (childAt != null && this.aG.g(selectedPosition) && this.aL.getVisibility() == 0) {
                        this.aF.getAdapter().a(childAt, 0, true);
                    }
                }
                this.aG.a();
                return;
            case 2:
                Float valueOf = Float.valueOf(0.0f);
                if (message != null) {
                    valueOf = (Float) message.obj;
                }
                this.X.V();
                H(false);
                if (this.W != null) {
                    if (this.X.w()) {
                        this.X.b(false, false);
                    }
                    this.W.b(valueOf.floatValue());
                    return;
                }
                return;
            case 3:
                this.aG.h(2);
                this.aG.h(0);
                this.aG.h(1);
                this.aG.h(4);
                this.aG.h(3);
                b_(3);
                return;
            case 4:
                fY();
                H(true);
                this.aG.setPanelsBarAuto(3);
                return;
            case 5:
                fG();
                return;
            case 6:
                if (fW()) {
                    int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE);
                    this.Y.a(this.Z.getString(R.string.camera_macro_best_focus_distance_text, new Object[]{Integer.valueOf(configIntValue)}), 0, (int) R.color.screen_hint_text_color);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void fO() {
        if (this.W != null) {
            this.W.q(0);
            A(this.Z.getResources().getString(R.string.camera_iso_default_value));
            long parseLong = Long.parseLong(this.Z.getResources().getString(R.string.camera_exposure_time_default_value));
            this.W.b(parseLong);
            this.W.a(parseLong);
            ga();
            if (!this.aP || fW()) {
                this.W.f(com.oppo.camera.a.b());
            } else {
                this.W.f(fF());
            }
            this.W.r();
            this.W.a((f.c) null);
            fZ();
            gb();
            fY();
            synchronized (this) {
                H(true);
                this.aG.setPanelsBarAuto(3);
            }
            this.aG.b();
        }
    }

    private synchronized void fP() {
        this.aG.scrollTo(0, 0);
        this.aG.scrollTo(1, 0);
        this.aG.scrollTo(2, 0);
        this.aG.scrollTo(3, 0);
        ArrayList<String> c = this.aG.c(4);
        int indexOf = this.aG.b(4).indexOf(this.aG.a(4));
        this.aG.scrollTo(4, indexOf);
        this.aG.a(4, indexOf);
        if (c != null && c.size() > indexOf) {
            a(4, c.get(indexOf));
        }
    }

    private void fQ() {
        if (this.aF == null) {
            this.aF = new ListProfessionalModeBar(this.Z, fC());
            this.aF.setModeBarStateListener(this);
            this.aF.setPanelInterface(this.aG);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.aN.getDimensionPixelSize(R.dimen.main_mode_bar_height));
            layoutParams.setMargins(0, 0, 0, this.aN.getDimensionPixelSize(R.dimen.sub_mode_bar_height));
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            this.aF.setBackground(this.Z.getResources().getDrawable(R.drawable.professionalmode_mode_bar_background));
            ListModeBarAdapter listModeBarAdapter = new ListModeBarAdapter(this.Z, this.aG.getMainModeBarData());
            listModeBarAdapter.a((h) this.aG);
            a(this.aF, (int) R.id.main_bar_id, listModeBarAdapter, (ListProfessionalModeBar.OnItemClickListener) this);
            this.aI.addView(this.aF, layoutParams);
        }
    }

    private void fR() {
        if (this.aG == null) {
            this.aG = new g(this.Z, this.X);
            this.aG.setGravity(17);
            this.aG.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.E(), this.aN.getDimensionPixelSize(R.dimen.sub_mode_bar_height));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            this.aI.addView(this.aG, layoutParams);
        }
    }

    private void fS() {
        this.aD = Thread.currentThread();
        int a2 = a(this.n);
        com.oppo.camera.e.a("ProfessionalCapMode", "addViewToRoot, mUiThread: " + this.aD);
        this.az = false;
        fU();
        fR();
        int i = this.aO;
        if (!(i == a2 || i == -1)) {
            this.aG.d();
        }
        this.aO = a2;
        if (Util.r(this.Z)) {
            this.aG.a(com.oppo.camera.f.a.a(this.aO), this.aH, (g.a) null);
            if (aO()) {
                this.aG.a(com.oppo.camera.f.a.a(this.aO), 2000000000);
            }
            fQ();
            this.aG.setSettleListener(this.aF);
            this.aG.setMotionListener(this.aV);
            F(1);
            this.aR = true;
        }
        fT();
    }

    private void fT() {
        if (this.aS == null) {
            this.aS = new RotateImageView(this.Z);
            this.aS.setId(R.id.professional_parameter_bottom_guide_entry);
            this.aS.setImageResource(R.drawable.professional_guide_tip);
            int dimensionPixelSize = this.aN.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_size);
            int u = Util.u() + this.aN.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = this.aN.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_end);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMargins(0, u, 0, 0);
            layoutParams.setMarginEnd(dimensionPixelSize2);
            this.aS.setLayoutParams(layoutParams);
            this.aS.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k.this.onClick(view);
                }
            });
        }
        this.aS.a(this.X.s(), false);
        this.Y.a((View) this.aS, ApsConstant.CAPTURE_MODE_PROFESSIONAL, 2, false);
    }

    public int ao() {
        return this.aN.getDimensionPixelSize(R.dimen.main_mode_bar_height);
    }

    private void fU() {
        if (this.aI == null) {
            this.aI = new a(this.Z);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Util.E());
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            if (this.X != null) {
                layoutParams.bottomMargin = this.Y.k() - this.aN.getDimensionPixelSize(R.dimen.sub_mode_bar_height);
            } else {
                layoutParams.bottomMargin = 0;
            }
            this.aI.setLayoutParams(layoutParams);
            this.aI.setVisibility(8);
            this.aI.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
                public void onWindowFocusChanged(boolean z) {
                    if (k.this.aF != null) {
                        com.oppo.camera.e.a("ProfessionalCapMode", "onWindowFocusChanged, SelectedPosition: " + k.this.aF.getSelectedPosition() + ", hasFocus: " + z);
                        k.this.aF.a(k.this.aF.getSelectedPosition(), true);
                    }
                }
            });
        }
        this.Y.a((View) this.aI, ApsConstant.CAPTURE_MODE_PROFESSIONAL, 1, false);
        a aVar = this.aI;
        if (aVar != null) {
            aVar.a(true);
        }
    }

    public void ab() {
        com.oppo.camera.ui.control.c cVar = new com.oppo.camera.ui.control.c(10, "button_color_inside_none");
        cVar.b(0);
        this.Y.a(cVar);
    }

    public void c(boolean z) {
        com.oppo.camera.ui.control.c o = o();
        if (!this.au || !z) {
            o.a(11);
            o.a("button_color_inside_none");
        } else {
            o.a(8);
            o.a("button_color_inside_none");
        }
        this.Y.a(o);
    }

    public boolean au() {
        com.oppo.camera.e.c("ProfessionalCapMode", "onBackPressed, mbInCapturing: " + this.v);
        super.au();
        if (!this.aF.isSelected()) {
            return false;
        }
        Util.a((View) this.aL, 4, (Animation.AnimationListener) null, 300);
        this.Y.a(0, true);
        this.aG.e();
        this.aF.a();
        this.W.t();
        return true;
    }

    public void S() {
        super.S();
        com.oppo.camera.e.c("ProfessionalCapMode", "onCaptureSequenceCompleted");
        if (aO()) {
            this.Y.b((int) R.string.camera_scene_night_keep_phone_steady);
            if (!this.at) {
                this.Y.a((int) R.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
                this.Y.a(new com.oppo.camera.ui.control.c());
                this.Y.a(false, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        if (this.Y.l() != 3 && this.Y.l() != 14) {
            return false;
        }
        this.Z.runOnUiThread(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
                if (com.oppo.camera.professional.k.b(r0, com.oppo.camera.professional.k.k(r0)) != false) goto L_0x001a;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    java.lang.String r1 = r0.fK()
                    boolean r0 = r0.C((java.lang.String) r1)
                    r1 = 1
                    r2 = 0
                    if (r0 != 0) goto L_0x001a
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    java.lang.String r3 = r0.fK()
                    boolean r0 = r0.D((java.lang.String) r3)
                    if (r0 == 0) goto L_0x006f
                L_0x001a:
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.f.f r0 = r0.W
                    r0.h()
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.e.b r0 = r0.X
                    r0.S()
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    boolean r0 = r0.gk()
                    if (r0 == 0) goto L_0x003d
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.ui.menu.levelcontrol.c r0 = r0.aL
                    r0.setVisibility(r2)
                L_0x003d:
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.professional.ListProfessionalModeBar r0 = r0.aF
                    boolean r0 = r0.isSelected()
                    if (r0 != 0) goto L_0x0052
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.ui.e r0 = r0.Y
                    r0.a((int) r2, (boolean) r1)
                L_0x0052:
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    boolean r0 = r0.aO()
                    if (r0 == 0) goto L_0x006f
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.ui.e r0 = r0.Y
                    r3 = 2131755518(0x7f1001fe, float:1.9141918E38)
                    r0.b((int) r3)
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.ui.i r0 = r0.aE
                    r0.a()
                L_0x006f:
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.professional.k$a r0 = r0.aI
                    r3 = 0
                    r4 = 300(0x12c, double:1.48E-321)
                    com.oppo.camera.util.Util.a((android.view.View) r0, (int) r2, (android.view.animation.Animation.AnimationListener) r3, (long) r4)
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    r0.G((int) r2)
                    com.oppo.camera.professional.k r0 = com.oppo.camera.professional.k.this
                    com.oppo.camera.ui.e r0 = r0.Y
                    r0.c((boolean) r1, (boolean) r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.professional.k.AnonymousClass13.run():void");
            }
        });
        this.v = false;
        b(2);
        this.aI.a(true);
        this.X.e(true);
        this.Y.a(true, false);
        return true;
    }

    private void fV() {
        this.Y.g(true);
        c cVar = this.aL;
        if (cVar != null) {
            cVar.setVisibility(4);
        }
        a aVar = this.aI;
        if (aVar != null) {
            aVar.a(false);
            ListProfessionalModeBar listProfessionalModeBar = this.aF;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.removeAllViews();
                this.aI.removeView(this.aF);
                this.aF = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        com.oppo.camera.e.c("ProfessionalCapMode", "onDeInitCameraMode");
        Handler handler = this.aH;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        g gVar = this.aG;
        if (gVar != null) {
            gVar.h();
        }
        if (fW()) {
            this.Y.u(true);
        }
        a aVar = this.aI;
        if (!(aVar == null || aVar.getVisibility() == 0)) {
            gc();
            fV();
        }
        this.W.z();
        c("0", false);
    }

    public void a(Object obj, boolean z, boolean z2) {
        if ((obj instanceof Integer) && 1 == ((Integer) obj).intValue() && !z && z2) {
            com.oppo.camera.e.b("ProfessionalCapMode", "removeAllView when mEmptyViewToAnimate hide animation end");
            gc();
            fV();
        }
    }

    /* access modifiers changed from: private */
    public boolean C(String str) {
        return str != null && 1000000000 <= Long.parseLong(str);
    }

    /* access modifiers changed from: private */
    public boolean D(String str) {
        return str != null && aO() && 1000000000 <= Long.parseLong(str);
    }

    /* access modifiers changed from: protected */
    public boolean ek() {
        return C(fK()) && bC();
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        g gVar = this.aG;
        if (gVar == null || !gVar.g()) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.y) {
                        com.oppo.camera.e.a("ProfessionalCapMode", "onBeforeSnapping, return after pause");
                        return;
                    }
                    if (k.this.aO()) {
                        k kVar = k.this;
                        if (kVar.D(kVar.fK())) {
                            int longValue = ((int) (Long.valueOf(k.this.fK()).longValue() / 1000000)) * 3;
                            k.this.aE.a((long) longValue);
                            if (k.this.Y != null) {
                                k.this.Y.a((int) R.string.camera_scene_night_keep_phone_steady, -1, false, false, true);
                                k.this.Y.k(longValue);
                            }
                        }
                        if (k.this.Y != null) {
                            k.this.Y.j(4);
                            k.this.Y.h(4);
                            k.this.Y.a(4, true);
                            k.this.X.a((Animation.AnimationListener) null);
                        }
                        if (k.this.aS != null) {
                            k.this.aS.setVisibility(4);
                        }
                        Util.a((View) k.this.aL, 4, (Animation.AnimationListener) null, 300);
                        Util.a((View) k.this.aI, 4, (Animation.AnimationListener) null, 300);
                    } else {
                        k kVar2 = k.this;
                        if (kVar2.C(kVar2.fK())) {
                            if (k.this.Y != null) {
                                k.this.Y.j(4);
                                k.this.Y.h(4);
                                k.this.Y.a(4, true);
                                k.this.X.a((Animation.AnimationListener) null);
                            }
                            if (k.this.aS != null) {
                                k.this.aS.setVisibility(4);
                            }
                            Util.a((View) k.this.aL, 4, (Animation.AnimationListener) null, 300);
                            Util.a((View) k.this.aI, 4, (Animation.AnimationListener) null, 300);
                            if (k.this.Y != null) {
                                k.this.Y.k((int) (Long.valueOf(k.this.fK()).longValue() / 1000000));
                            }
                        }
                    }
                    k.this.aI.a(false);
                    if (k.this.au && k.this.Y != null && k.this.Y.l() != 2) {
                        k.this.Y.a(new com.oppo.camera.ui.control.c(4, "button_color_inside_none"));
                    }
                }
            });
            x(false);
            if (eJ()) {
                x(true);
                this.aU = 0;
                this.aT = dVar.q;
                this.ay = false;
            }
            if (aO()) {
                x(false);
                this.ay = false;
            }
            if (this.W != null) {
                this.W.t();
            }
            M();
            return true;
        }
        com.oppo.camera.e.c("ProfessionalCapMode", "onBeforeSnapping, levelPanelScrolling");
        return false;
    }

    public void a(Image image, TotalCaptureResult totalCaptureResult, Rect rect, d dVar) {
        this.aJ = image;
        this.aK = totalCaptureResult;
        a(this.aq);
    }

    /* access modifiers changed from: private */
    public void G(int i) {
        com.oppo.camera.e.a("ProfessionalCapMode", "setCameraMenuControlViewVisibility, visibility: " + i);
        if (this.Y != null) {
            this.Y.j(i);
            this.Y.h(i);
            this.Y.e(i);
            this.Y.b(i, true);
        }
        RotateImageView rotateImageView = this.aS;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(i);
        }
    }

    public boolean aM() {
        com.oppo.camera.e.a("ProfessionalCapMode", "onAfterSnapping");
        if (this.au || !this.X.j() || Long.parseLong(fK()) < 1000000000) {
            com.oppo.camera.e.a("ProfessionalCapMode", "onAfterSnapping is ZSL mode, do nothing");
        } else {
            this.X.c(4);
        }
        if (aO()) {
            this.at = false;
        }
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (k.this.aO()) {
                    com.oppo.camera.ui.control.c o = k.this.o();
                    k kVar = k.this;
                    if (kVar.D(kVar.fK())) {
                        k.this.Y.a(true, false);
                        k.this.Y.l(k.this.Z.getResources().getDimensionPixelOffset(R.dimen.night_countdown_time_margin_top));
                        k.this.aE.c();
                        k.this.aE.d();
                        if (k.this.Y.l() == 9) {
                            o.a(3);
                            o.a("button_color_inside_none");
                        } else {
                            o.a(15);
                            o.a("button_color_inside_none");
                        }
                    } else if (k.this.Y.l() == 9) {
                        o.a(4);
                        o.a("button_color_inside_none");
                    } else {
                        o.a(4);
                        o.a("button_color_inside_none");
                    }
                    k.this.Y.a(o);
                    return;
                }
                k kVar2 = k.this;
                if (kVar2.C(kVar2.fK())) {
                    k.this.Y.a(true, false);
                    com.oppo.camera.ui.control.c o2 = k.this.o();
                    if (k.this.Y.l() == 9) {
                        o2.a(3);
                        o2.a("button_color_inside_none");
                    } else {
                        o2.a(7);
                        o2.a("button_color_inside_none");
                    }
                    k.this.Y.a(o2);
                }
            }
        });
        com.oppo.camera.e.a("ProfessionalCapMode", "onAfterSnapping X");
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2, boolean z3) {
        super.a(z, z2, z3);
        if (z2) {
            if (this.au || !this.X.j() || Long.parseLong(fK()) < 1000000000) {
                this.X.c(0);
            } else if (!aO()) {
                this.X.c(5);
                G(0);
            }
            if (!aO()) {
                this.X.i();
            }
        }
    }

    public void a(ImageReader imageReader) {
        com.oppo.camera.e.a("ProfessionalCapMode", "onRawImageReceived, mRequestRawNumber: " + this.aT);
        if (!aO()) {
            Image image = this.aJ;
            if (image != null) {
                image.close();
                this.aJ = null;
            }
            Image acquireNextImage = imageReader.acquireNextImage();
            this.aT--;
            if (this.aT != 0) {
                acquireNextImage.close();
                acquireNextImage = null;
            }
            if (this.aT == 0) {
                this.aJ = acquireNextImage;
                a(this.aq);
            }
        }
    }

    public d b(ApsAdapterDecision.DecisionResult decisionResult) {
        d b2 = super.b(decisionResult);
        b2.ao = aO();
        if (b2.ao) {
            b2.H = decisionResult.mCaptureEVList;
            b2.y = true;
        }
        return b2;
    }

    public void a(ApsCaptureResult apsCaptureResult, CaptureRequest captureRequest) {
        super.a(apsCaptureResult, captureRequest);
        com.oppo.camera.e.a("ProfessionalCapMode", "onCaptureCompleted, systemTime: " + System.currentTimeMillis());
        d dVar = (d) captureRequest.getTag();
        this.aQ = dVar.F;
        if (d.a.CAPTURE == dVar.a() && eK()) {
            int i = this.aU + 1;
            this.aU = i;
            if (i == dVar.q) {
                this.aK = apsCaptureResult.getTotalResult();
                a(this.aq);
            }
        }
    }

    public void a(CaptureRequest captureRequest) {
        super.a(captureRequest);
        if (aO()) {
            this.at = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2 A[SYNTHETIC, Splitter:B:44:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ed A[SYNTHETIC, Splitter:B:54:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(long r12) {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "saveResultToDng, rawImg: "
            r0.append(r1)
            android.media.Image r1 = r11.aJ
            r0.append(r1)
            java.lang.String r1 = ", capResult: "
            r0.append(r1)
            android.hardware.camera2.CaptureResult r1 = r11.aK
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ProfessionalCapMode"
            com.oppo.camera.e.a(r1, r0)
            android.media.Image r0 = r11.aJ
            if (r0 == 0) goto L_0x00f6
            android.hardware.camera2.CaptureResult r0 = r11.aK
            if (r0 != 0) goto L_0x002c
            goto L_0x00f6
        L_0x002c:
            android.hardware.camera2.DngCreator r0 = new android.hardware.camera2.DngCreator
            com.oppo.camera.f.f r1 = r11.W
            com.oppo.camera.f.j r1 = r1.e()
            android.hardware.camera2.CameraCharacteristics r1 = r1.F()
            android.hardware.camera2.CaptureResult r2 = r11.aK
            r0.<init>(r1, r2)
            int r1 = r11.n
            int r2 = r11.aQ
            int r1 = com.oppo.camera.f.a.b(r1, r2)
            r2 = 90
            if (r1 == r2) goto L_0x005d
            r2 = 180(0xb4, float:2.52E-43)
            if (r1 == r2) goto L_0x0058
            r2 = 270(0x10e, float:3.78E-43)
            if (r1 == r2) goto L_0x0052
            goto L_0x0061
        L_0x0052:
            r1 = 8
            r0.setOrientation(r1)
            goto L_0x0061
        L_0x0058:
            r1 = 3
            r0.setOrientation(r1)
            goto L_0x0061
        L_0x005d:
            r1 = 6
            r0.setOrientation(r1)
        L_0x0061:
            com.oppo.camera.e.b r1 = r11.X
            r2 = 0
            if (r1 == 0) goto L_0x006d
            com.oppo.camera.e.b r1 = r11.X
            android.location.Location r1 = r1.v()
            goto L_0x006e
        L_0x006d:
            r1 = r2
        L_0x006e:
            if (r1 == 0) goto L_0x0073
            r0.setLocation(r1)
        L_0x0073:
            boolean r1 = com.oppo.camera.util.Util.p()
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = "this is from oplus camera"
            r0.setDescription(r1)
        L_0x007e:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
            r1.<init>()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
            android.media.Image r3 = r11.aJ     // Catch:{ IOException -> 0x00b8 }
            r0.writeImage(r1, r3)     // Catch:{ IOException -> 0x00b8 }
            byte[] r6 = r1.toByteArray()     // Catch:{ IOException -> 0x00b8 }
            android.media.Image r3 = r11.aJ     // Catch:{ IOException -> 0x00b8 }
            int r7 = r3.getFormat()     // Catch:{ IOException -> 0x00b8 }
            r3 = 1
            long r3 = r12 - r3
            com.oppo.camera.h.a.a((byte[]) r6, (long) r3)     // Catch:{ IOException -> 0x00b8 }
            android.os.Handler r3 = r11.aH     // Catch:{ IOException -> 0x00b8 }
            com.oppo.camera.professional.k$2 r10 = new com.oppo.camera.professional.k$2     // Catch:{ IOException -> 0x00b8 }
            r4 = r10
            r5 = r11
            r8 = r12
            r4.<init>(r6, r7, r8)     // Catch:{ IOException -> 0x00b8 }
            r3.post(r10)     // Catch:{ IOException -> 0x00b8 }
            android.media.Image r12 = r11.aJ
            if (r12 == 0) goto L_0x00af
            r12.close()
            r11.aJ = r2
        L_0x00af:
            r0.close()
            r11.aK = r2
            r1.close()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00da
        L_0x00b8:
            r12 = move-exception
            goto L_0x00bf
        L_0x00ba:
            r12 = move-exception
            r1 = r2
            goto L_0x00dd
        L_0x00bd:
            r12 = move-exception
            r1 = r2
        L_0x00bf:
            r12.printStackTrace()     // Catch:{ all -> 0x00dc }
            android.media.Image r12 = r11.aJ
            if (r12 == 0) goto L_0x00cb
            r12.close()
            r11.aJ = r2
        L_0x00cb:
            r0.close()
            r11.aK = r2
            if (r1 == 0) goto L_0x00da
            r1.close()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00da:
            r12 = 1
            return r12
        L_0x00dc:
            r12 = move-exception
        L_0x00dd:
            android.media.Image r13 = r11.aJ
            if (r13 == 0) goto L_0x00e6
            r13.close()
            r11.aJ = r2
        L_0x00e6:
            r0.close()
            r11.aK = r2
            if (r1 == 0) goto L_0x00f5
            r1.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f5
        L_0x00f1:
            r13 = move-exception
            r13.printStackTrace()
        L_0x00f5:
            throw r12
        L_0x00f6:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.professional.k.a(long):boolean");
    }

    /* access modifiers changed from: protected */
    public void b(byte[] bArr, boolean z) {
        com.oppo.camera.e.c("ProfessionalCapMode", "onBeforePictureTaken");
        if (this.au) {
            this.Y.a(o(), false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean aU() {
        return aO();
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        com.oppo.camera.e.a("ProfessionalCapMode", "onAfterPictureTaken");
        if (this.ay || !eK()) {
            if (aO()) {
                this.Y.b((int) R.string.camera_scene_night_process_image_after_capture);
                G(0);
                Util.a((View) this.aI, 0, (Animation.AnimationListener) null, 300);
                this.X.D();
                this.X.d(true);
                this.Y.a(o());
                if (!this.aF.isSelected()) {
                    this.Y.a(0, true);
                } else if (gk()) {
                    Util.a((View) this.aL, 0, (Animation.AnimationListener) null, 300);
                }
            } else if (C(fK())) {
                com.oppo.camera.ui.control.c o = o();
                if (1 != this.Y.l()) {
                    o.a(11);
                }
                this.Y.a(o);
                G(0);
                Util.a((View) this.aI, 0, (Animation.AnimationListener) null, 300);
                this.X.D();
                if (!this.aF.isSelected()) {
                    this.Y.a(0, true);
                } else if (gk()) {
                    Util.a((View) this.aL, 0, (Animation.AnimationListener) null, 300);
                }
            }
            this.Y.d(true, false);
            if (this.aw) {
                Util.a((View) this.aI, 0, (Animation.AnimationListener) null, 300);
                this.aw = false;
            }
            this.aI.a(true);
            return;
        }
        this.ay = true;
    }

    public void d(int i) {
        super.d(i);
        final int am = this.X.am();
        com.oppo.camera.e.a("ProfessionalCapMode", "cameraIdChanged, id: " + am);
        if (this.aO != am) {
            this.aO = am;
            this.aP = true;
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.fW()) {
                        k.this.aF.setVisibility(8);
                        k.this.aF.setItemPressed(false);
                        k.this.aG.e();
                        if (k.this.aF.isSelected()) {
                            Util.a((View) k.this.aL, 4, (Animation.AnimationListener) null, 300);
                            k.this.Y.a(0, true);
                            k.this.aG.e();
                            k.this.aF.a();
                            return;
                        }
                        return;
                    }
                    k.this.aF.setVisibility(0);
                    k.this.aG.setVisibility(0);
                    k.this.Y.u(true);
                    k.this.H(am);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean fW() {
        return "camera_macro".equals(this.aa.getString("pref_switch_camera_key", "camera_main"));
    }

    /* access modifiers changed from: private */
    public synchronized void H(int i) {
        long j;
        this.aG.d();
        com.oppo.camera.f.j a2 = com.oppo.camera.f.a.a(i);
        this.aG.a(a2.u(), a2.v(), a2.w(), this.aH);
        if (aO()) {
            j = 2000000000;
        } else {
            j = a2.x();
        }
        this.aG.a(j, a2.y(), a2.a(256), this.aH);
        this.aG.a(a2.B(), this.aH);
        this.aG.a(a2.n(), a2.m(), this.aH);
        this.aG.a(a2.p(), a2.q(), a2.r(), this.aH);
        this.aG.e();
        if (this.aF.isSelected()) {
            this.aG.f(this.aF.getSelectedPosition());
        }
        this.aG.a();
    }

    public void e(int i) {
        c cVar = this.aL;
        if (cVar != null) {
            cVar.a(i, true);
        }
        RotateImageView rotateImageView = this.aS;
        if (rotateImageView != null) {
            rotateImageView.a(i, true);
        }
        if (this.k != i) {
            this.k = i;
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        com.oppo.camera.e.a("ProfessionalCapMode", "onResume");
        if (this.aa != null) {
            this.au = "on".equals(this.aa.getString("pref_high_resolution_key", this.Z.getResources().getString(R.string.camera_high_resolution_default_value)));
        }
        if (Util.r(this.Z)) {
            a aVar = this.aI;
            if (aVar != null) {
                aVar.setVisibility(0);
                if (gk()) {
                    this.aL.setVisibility(0);
                }
            }
            this.X.d(true);
            F(1);
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        com.oppo.camera.e.a("ProfessionalCapMode", "onPause");
        this.Y.n(false);
        this.Y.j(0);
        this.Y.g(false);
        a aVar = this.aI;
        if (aVar != null) {
            aVar.a(false);
        }
        this.aw = false;
        Handler handler = this.aH;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        g gVar = this.aG;
        if (gVar != null) {
            gVar.h();
        }
        this.Y.d(true, false);
    }

    /* access modifiers changed from: protected */
    public void r() {
        com.oppo.camera.e.a("ProfessionalCapMode", "onDestroy");
        g gVar = this.aG;
        if (gVar != null) {
            gVar.f();
            this.aG = null;
            this.aR = false;
        }
        if (this.aI != null) {
            this.aI = null;
        }
        if (this.aS != null) {
            this.aS = null;
        }
        if (this.aF != null) {
            this.aF = null;
        }
    }

    private void fX() {
        if (f("pref_switch_camera_key") && f("pref_raw_control_key") && this.aa != null) {
            if (Util.e(this.aa.getString("pref_switch_camera_key", "camera_main"))) {
                this.Y.b("pref_raw_control_key", (String) null);
            } else {
                if (!"off".equals(this.aa.getString("pref_raw_control_key", "off"))) {
                    this.aa.edit().putString("pref_raw_control_key", "off").apply();
                }
                this.Y.a("pref_raw_control_key", "off");
            }
            this.Y.f("pref_raw_control_key");
        }
        if (f("pref_switch_camera_key") && f("pref_super_raw_control_key") && this.aa != null) {
            if (Util.e(this.aa.getString("pref_switch_camera_key", "camera_main"))) {
                this.Y.b("pref_super_raw_control_key", (String) null);
            } else {
                if (!"off".equals(this.aa.getString("pref_super_raw_control_key", "off"))) {
                    this.aa.edit().putString("pref_super_raw_control_key", "off").apply();
                }
                this.Y.a("pref_super_raw_control_key", "off");
            }
            this.Y.f("pref_super_raw_control_key");
        }
    }

    /* access modifiers changed from: protected */
    public boolean v(String str) {
        if (!"pref_raw_control_key".equals(str) || !f("pref_raw_control_key") || !f("pref_switch_dual_camera_key") || this.aa == null) {
            return super.v(str);
        }
        return Util.e(this.aa.getString("pref_switch_camera_key", "camera_main"));
    }

    public void f(boolean z) {
        com.oppo.camera.e.b("ProfessionalCapMode", "onAfterStartPreview");
        a aVar = this.aI;
        if (aVar != null) {
            aVar.a(true);
        }
        if (fW()) {
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE);
            this.Y.a(this.Z.getString(R.string.camera_macro_best_focus_distance_text, new Object[]{Integer.valueOf(configIntValue)}), 0, (int) R.color.screen_hint_text_color);
        }
        gf();
        super.f(z);
    }

    /* access modifiers changed from: protected */
    public void u() {
        com.oppo.camera.e.a("ProfessionalCapMode", "onBeforePreview");
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (k.this.W == null || k.this.W.e() == null || k.this.W.e().s()) {
                    k.this.c(true, 3);
                    return;
                }
                if (3 == k.this.aF.getSelectedPosition()) {
                    Util.a((View) k.this.aL, 4, (Animation.AnimationListener) null, 300);
                    k.this.Y.a(0, true);
                    k.this.aG.e();
                    k.this.aF.a();
                    k.this.W.t();
                }
                k.this.c(false, 3);
            }
        });
        if (this.aP || this.aa.getBoolean("pref_restore_professional_params", false)) {
            com.oppo.camera.e.a("ProfessionalCapMode", "onBeforePreview, initParamToAuto");
            fN();
            return;
        }
        if (this.A) {
            fM();
        }
        fG();
    }

    public String bu() {
        if (this.aa == null || this.P) {
            return "off";
        }
        String string = this.Z.getResources().getString(R.string.camera_exposure_time_default_value);
        String string2 = this.aa.getString("pref_professional_exposure_time_key", string);
        return (TextUtils.isEmpty(string2) || !string2.equals(string)) ? "off" : super.bu();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.professional_parameter_bottom_guide_entry && this.Y != null) {
            this.Y.ag();
        }
    }

    /* access modifiers changed from: protected */
    public void eh() {
        a aVar = this.aI;
        if (aVar != null) {
            aVar.setVisibility(4);
        }
    }

    private void fY() {
        ListProfessionalModeBar listProfessionalModeBar = this.aF;
        if (listProfessionalModeBar != null && this.aG != null) {
            if (listProfessionalModeBar.getSelectedPosition() == 3) {
                G(true);
            }
            this.aG.setPreference(3);
        }
    }

    private void fZ() {
        g gVar;
        if (this.aF != null && (gVar = this.aG) != null) {
            gVar.setPreference(2);
        }
    }

    private void ga() {
        g gVar;
        if (this.aF != null && (gVar = this.aG) != null) {
            gVar.setPreference(0);
            this.aG.setPreference(1);
        }
    }

    private void gb() {
        g gVar;
        if (this.aF != null && (gVar = this.aG) != null) {
            gVar.setPreference(4);
        }
    }

    private void gc() {
        ListProfessionalModeBar listProfessionalModeBar = this.aF;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setVisibility(8);
            this.aF.setItemPressed(false);
        }
        g gVar = this.aG;
        if (gVar != null) {
            gVar.setVisibility(4);
        }
    }

    private void gd() {
        g gVar = this.aG;
        if (gVar != null) {
            gVar.clearAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z, int i) {
        View childAt = this.aF.getChildAt(i);
        if (childAt != null) {
            childAt.setEnabled(z);
            if (childAt instanceof m) {
                ((m) childAt).setRotateViewClickable(z);
            }
            if (z) {
                childAt.setAlpha(1.0f);
            } else {
                childAt.setAlpha(0.5f);
            }
        }
    }

    public boolean a(int i, MotionEvent motionEvent) {
        if ((this.X != null && this.X.x()) || !f(motionEvent)) {
            return false;
        }
        if (i == 1) {
            this.aF.a(1);
        } else if (i == 2) {
            this.aF.b(1);
        }
        return true;
    }

    public void a(View view, View view2, int i, long j) {
        if (!this.X.x()) {
            if (ListProfessionalModeBar.ModePressState.NO_PRESSED != this.aF.getModePressState() || !this.aF.isSelected()) {
                boolean E = this.X.E();
                this.Y.D(false);
                gd();
                com.oppo.camera.e.e("ProfessionalCapMode", "onItemClick, position: " + i + ", id: " + j);
                d(i, true);
                if (i == 4) {
                    this.aL.setVisibility(4);
                } else {
                    if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                        e(this.k);
                    }
                    this.aL.setVisibility(0);
                }
                if (1 == i) {
                    this.aA = aO();
                }
                this.Y.a(4, true);
                Animation animation = null;
                if (E) {
                    animation = AnimationUtils.loadAnimation(this.Z, R.anim.zoom_panel_level_in);
                }
                this.aG.a(i, animation);
                if (!this.aG.g(i) || this.aL.getVisibility() != 0) {
                    G(false);
                    this.aF.getAdapter().a(view2, 8, false);
                    return;
                }
                G(true);
                this.aF.getAdapter().a(view2, 0, true);
                return;
            }
            au();
            d(i, false);
        }
    }

    public void fD() {
        String string = this.aa.getString("pref_professional_whitebalance_key", this.Z.getResources().getString(R.string.camera_whitebalance_default_value));
        if (a(string, (List<String>) this.aG.b(2))) {
            try {
                this.W.k(Integer.parseInt(string));
            } catch (NumberFormatException unused) {
                this.W.r();
            }
        } else {
            this.W.r();
        }
        com.oppo.camera.e.a("ProfessionalCapMode", "setWhiteBalance, whiteBalance: " + string);
    }

    public void fE() {
        this.W.r();
    }

    public void A(String str) {
        if (str == null) {
            str = this.aa.getString("pref_professional_iso_key", this.Z.getResources().getString(R.string.camera_iso_default_value));
        }
        if (!this.aa.getString("pref_professional_iso_key", this.Z.getResources().getString(R.string.camera_iso_default_value)).equals(str)) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString("pref_professional_iso_key", this.aG.a(0));
            edit.apply();
        }
        if (this.Z.getResources().getString(R.string.camera_iso_default_value).equals(str)) {
            this.W.m(-1);
        } else {
            gi();
            this.W.s();
            this.W.m(Integer.parseInt(str));
        }
        com.oppo.camera.e.a("ProfessionalCapMode", "setISOValue, iso: " + str);
    }

    public void B(String str) {
        if (str == null) {
            str = this.aa.getString("pref_professional_focus_mode_key", this.Z.getString(R.string.camera_focus_mode_default_value));
        }
        com.oppo.camera.e.a("ProfessionalCapMode", "setFocusValue, focusValue: " + str);
        if (!this.Z.getString(R.string.camera_focus_mode_default_value).equals(str)) {
            this.aH.removeMessages(2);
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = Float.valueOf(Float.parseFloat(str));
            this.aH.sendMessage(obtain);
            if (this.au) {
                I(false);
            }
        }
    }

    public int fF() {
        return Integer.parseInt(this.aa.getString("pref_professional_exposure_compensation_key", this.Z.getResources().getString(R.string.camera_exposure_compensation_default_value)));
    }

    public void fG() {
        String string = this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value));
        com.oppo.camera.ui.control.c o = o();
        long longValue = Long.valueOf(this.Z.getResources().getString(R.string.camera_exposure_time_default_value)).longValue();
        long parseLong = Long.parseLong(string);
        this.W.b(parseLong);
        if (parseLong != longValue) {
            gi();
        }
        if (parseLong < 40000000) {
            this.W.f(false);
            if (this.t) {
                this.W.a(longValue);
            } else {
                com.oppo.camera.e.a("ProfessionalCapMode", "setExposureTime, back exposureTimeValue: " + parseLong);
                this.W.a(parseLong);
            }
        } else {
            com.oppo.camera.e.a("ProfessionalCapMode", "setExposureTime, slow shutter");
            this.W.f(true);
            this.W.a(40000000);
        }
        if (!this.ax && !this.X.x()) {
            this.Y.a(o);
        }
    }

    private void c(final String str, boolean z) {
        final Boolean valueOf = Boolean.valueOf(z);
        com.oppo.camera.e.a("ProfessionalCapMode", "setFlashModeMenuEnable, exposureTime: " + str + ", mDisPlayFlashIcon: " + valueOf);
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Integer.parseInt(str) == 0) {
                    if (this.Y != null) {
                        this.Y.b("pref_camera_flashmode_key", (String) null);
                        f(true, z);
                    }
                } else if (this.Y != null) {
                    f(false, z);
                    this.Y.a("pref_camera_flashmode_key", "off");
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.Z != null) {
                    this.Z.runOnUiThread(new Runnable() {
                        public void run() {
                            if (Integer.parseInt(str) == 0) {
                                if (k.this.Y != null) {
                                    k.this.f(true, valueOf.booleanValue());
                                    k.this.Y.b("pref_camera_flashmode_key", (String) null);
                                }
                            } else if (k.this.Y != null) {
                                k.this.f(false, valueOf.booleanValue());
                                k.this.Y.a("pref_camera_flashmode_key", "off");
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void f(boolean z, boolean z2) {
        if (z2) {
            com.oppo.camera.e.a("ProfessionalCapMode", "showOrHideFlashIcon, enable: " + z + ", isOpenFlash: " + cC());
            if (z) {
                cP();
            } else {
                this.Y.a(false, true, false);
            }
        }
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        com.oppo.camera.e.a("ProfessionalCapMode", "onSharedPreferenceChanged, key: " + str);
        if ("pref_professional_whitebalance_key".equals(str)) {
            if (2 == this.aF.getSelectedPosition()) {
                G(this.aG.h(2));
            }
            fD();
            return;
        }
        boolean z = true;
        if ("pref_professional_iso_key".equals(str)) {
            if (this.aF.getSelectedPosition() == 0) {
                if (!this.aG.h(0) || this.aL == null) {
                    z = false;
                }
                G(z);
            }
            A((String) null);
        } else if ("pref_professional_exposure_compensation_key".equals(str)) {
            this.aF.getAdapter().a(this.aF.getChildAt(0), 0, false);
            this.W.f(fF());
            this.W.a((f.c) null);
        } else if ("pref_professional_exposure_time_key".equals(str)) {
            if (this.aL != null && 1 == this.aF.getSelectedPosition()) {
                G(this.aG.h(1));
            }
            fG();
            long fL = fL();
            if (this.aF.isSelected() && this.aA && fL >= 500000000 && aO()) {
                this.aA = false;
                this.Y.a((int) R.string.camera_raw_control_super_long_exposure_hint, -1, true, false, false);
            }
        } else {
            if ("pref_high_resolution_key".equals(str)) {
                gh();
            } else if ("pref_professional_focus_mode_key".equals(str)) {
                this.aG.h(3);
                if (!this.aG.g(3)) {
                    B((String) null);
                    G(false);
                    H(false);
                } else {
                    if (4 != this.W.p()) {
                        this.W.a(4, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
                        this.W.a((f.c) null);
                    }
                    if (4 == this.W.p() || 1 == this.W.p()) {
                        fY();
                        H(true);
                        this.aG.setPanelsBarAuto(3);
                    }
                }
            } else if ("pref_camera_flashmode_key".equals(str)) {
                if (!this.Z.getString(R.string.camera_flash_mode_default_value).equals(sharedPreferences.getString("pref_camera_flashmode_key", this.Z.getString(R.string.camera_flash_mode_default_value)))) {
                    gg();
                }
                I(true);
            } else if ("pref_raw_control_key".equals(str) && f("pref_raw_control_key")) {
                ge();
                return;
            } else if ("pref_super_raw_control_key".equals(str) && f("pref_super_raw_control_key")) {
                ge();
                return;
            }
            super.a(sharedPreferences, str);
            if ("pref_switch_camera_key".equals(str)) {
                gf();
                fX();
            }
        }
    }

    private void ge() {
        long j;
        if (f("pref_super_raw_control_key")) {
            String string = this.aa.getString("pref_super_raw_control_key", "off");
            char c = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -332521116) {
                if (hashCode != 3551) {
                    if (hashCode == 109935 && string.equals("off")) {
                        c = 2;
                    }
                } else if (string.equals("on")) {
                    c = 0;
                }
            } else if (string.equals("super_raw")) {
                c = 1;
            }
            if (c == 0) {
                this.Y.a((int) R.string.camera_raw_control_on_hint, -1, true, false, false);
            } else if (c == 1) {
                this.Y.a((int) R.string.camera_raw_control_super_on_hint, -1, true, false, false);
                this.aG.b(false);
                fN();
                this.aG.b(true);
                if (!this.aA) {
                    this.aA = true;
                }
                if (this.X != null) {
                    this.X.aA();
                }
            } else if (c == 2) {
                this.Y.a((int) R.string.camera_raw_control_off_hint, -1, true, false, false);
            }
            if (aO()) {
                j = 2000000000;
            } else {
                j = com.oppo.camera.f.a.a(this.aO).x();
            }
            this.aG.a(com.oppo.camera.f.a.a(this.aO), j);
            this.aG.a();
        } else if ("on".equals(this.aa.getString("pref_raw_control_key", "off"))) {
            this.Y.a((int) R.string.camera_raw_control_on_hint, -1, true, false, false);
        } else {
            this.Y.a((int) R.string.camera_raw_control_off_hint, -1, true, false, false);
        }
        if (this.X != null) {
            if (f("pref_zoom_key")) {
                this.X.D();
                this.X.d(true);
            } else {
                this.X.a((Animation.AnimationListener) null);
            }
            if (fH()) {
                this.X.aA();
            }
        }
    }

    public void y(boolean z) {
        if (!f("pref_switch_camera_key") || !f("pref_camera_flashmode_key") || this.aa == null) {
            this.P = z;
            return;
        }
        String string = this.aa.getString("pref_switch_camera_key", "camera_main");
        String bu = bu();
        boolean z2 = true;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            if (!"camera_tele".equals(string) || (!"on".equals(bu) && !MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(bu))) {
                z2 = false;
            }
            this.P = z2;
            return;
        }
        this.P = !"camera_main".equals(string);
    }

    private void gf() {
        if (this.aa != null) {
            String string = this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value));
            String string2 = this.aa.getString("pref_professional_iso_key", this.Z.getResources().getString(R.string.camera_iso_default_value));
            if (f("pref_switch_camera_key") && f("pref_camera_flashmode_key") && this.Z.getResources().getString(R.string.camera_exposure_time_default_value).equals(string) && this.Z.getResources().getString(R.string.camera_iso_default_value).equals(string2)) {
                String string3 = this.aa.getString("pref_switch_camera_key", "camera_main");
                String bu = bu();
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                    if ("camera_tele".equals(string3)) {
                        if ("on".equals(bu) || MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(bu)) {
                            this.P = true;
                            m("off");
                            this.Y.b("pref_camera_flashmode_key", "off");
                        }
                        this.Y.b("pref_camera_flashmode_key", "on", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                    } else {
                        this.P = false;
                        this.Y.a("pref_camera_flashmode_key", "on", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                        this.Y.b("pref_camera_flashmode_key", (String) null);
                        m(bu);
                    }
                } else if ("camera_main".equals(string3)) {
                    this.P = false;
                    m(bu());
                    this.Y.b("pref_camera_flashmode_key", (String) null);
                } else {
                    this.P = true;
                    m("off");
                    this.Y.a("pref_camera_flashmode_key", "off");
                }
                this.Y.f("pref_camera_flashmode_key");
            }
        }
    }

    private void gg() {
        if (!"off".equals(this.aa.getString("pref_camera_flashmode_key", this.Z.getString(R.string.camera_flash_mode_default_value)))) {
            String string = this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value));
            String string2 = this.aa.getString("pref_professional_iso_key", this.Z.getResources().getString(R.string.camera_iso_default_value));
            if (!this.Z.getResources().getString(R.string.camera_exposure_time_default_value).equals(string)) {
                this.aG.setAuto(1);
                if (this.aF.isSelected()) {
                    View childAt = this.aF.getChildAt(1);
                    if (1 == this.aF.getSelectedPosition()) {
                        this.aF.getAdapter().a(childAt, 0, true);
                    } else {
                        this.aF.getAdapter().a(childAt, 0, false);
                    }
                }
            }
            if (!this.Z.getResources().getString(R.string.camera_iso_default_value).equals(string2)) {
                this.aG.setAuto(0);
                if (this.aF.isSelected()) {
                    View childAt2 = this.aF.getChildAt(0);
                    if (this.aF.getSelectedPosition() == 0) {
                        this.aF.getAdapter().a(childAt2, 0, true);
                    } else {
                        this.aF.getAdapter().a(childAt2, 0, false);
                    }
                }
            }
        }
    }

    private void I(boolean z) {
        boolean z2 = true;
        if (z) {
            z2 = true ^ "off".equals(this.aa.getString("pref_camera_flashmode_key", this.Z.getString(R.string.camera_flash_mode_default_value)));
        }
        if (this.au && z2) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString("pref_high_resolution_key", "off");
            edit.apply();
            this.Y.b("pref_high_resolution_key", "off");
        }
    }

    private void gh() {
        com.oppo.camera.e.a("ProfessionalCapMode", "updateHighResolutionMode");
        this.au = "on".equals(this.aa.getString("pref_high_resolution_key", this.Z.getResources().getString(R.string.camera_high_resolution_default_value)));
        com.oppo.camera.ui.control.c cVar = new com.oppo.camera.ui.control.c(1);
        cVar.a("button_color_inside_none");
        this.W.g(br());
        if (this.au) {
            gi();
            gj();
            this.aG.setAuto(0);
            this.aG.setAuto(1);
            this.aG.setAuto(2);
            this.aG.setAuto(3);
            g gVar = this.aG;
            gVar.a(4, "pref_professional_exposure_compensation_key", gVar.b(4).indexOf(this.aG.a(4)));
            F(1);
            this.Y.a(cVar);
            if (this.W.p() == 0) {
                this.W.a(bt(), com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
                this.W.f(com.oppo.camera.a.b());
                this.W.a((f.c) null);
            }
            if (1 == this.W.p() || 4 == this.W.p()) {
                fY();
                H(true);
                this.aG.setPanelsBarAuto(3);
            }
            this.Y.a((int) R.string.camera_toast_high_resolution_on, -1, true, false, false);
            return;
        }
        this.Y.a((int) R.string.camera_toast_high_resolution_off, -1, true, false, false);
        this.Y.a(cVar);
    }

    private void gi() {
        if (!"off".equals(this.aa.getString("pref_camera_flashmode_key", this.Z.getString(R.string.camera_flash_mode_default_value)))) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString("pref_camera_flashmode_key", "off");
            edit.apply();
            this.Y.f("pref_camera_flashmode_key");
        }
    }

    private void gj() {
        if (!"off".equals(this.aa.getString("pref_raw_key", "off"))) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString("pref_raw_key", "off");
            edit.apply();
        }
    }

    public boolean cV() {
        String string = this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value));
        return TextUtils.isEmpty(string) || Long.valueOf(string).longValue() >= 1000000000;
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) ? null : (CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        String d = this.aG.d(2);
        String a2 = this.aG.a(Integer.valueOf(this.aG.d(4)).intValue(), this.W.e().r());
        String d2 = this.aG.d(1);
        String d3 = this.aG.d(0);
        String focusValue = this.aG.getFocusValue();
        if (TextUtils.equals(d2, this.Z.getString(R.string.camera_exposure_time_default_value))) {
            d2 = MenuClickMsgData.VALUE_PROFESSION_AUTO;
        }
        captureMsgData.mProfessionWbValue = d;
        captureMsgData.mProfessionEvValue = a2;
        captureMsgData.mProfessionExpValue = d2;
        captureMsgData.mProfessionISOValue = d3;
        captureMsgData.mProfessionFocusValue = focusValue;
        captureMsgData.mProfessionHighResolution = String.valueOf(this.au);
        String str = "off";
        if (this.aa != null) {
            if (f("pref_super_raw_control_key")) {
                str = this.aa.getString("pref_super_raw_control_key", str);
            } else {
                str = this.aa.getString("pref_raw_control_key", str);
            }
        }
        captureMsgData.mProfessionRawControl = str;
        String str2 = "camera_main";
        if (this.aa != null) {
            str2 = this.aa.getString("pref_switch_camera_key", str2);
        }
        captureMsgData.mProfessionCameraId = str2;
        return captureMsgData;
    }

    /* access modifiers changed from: private */
    public boolean gk() {
        return this.aF.isSelected() && this.aF.getSelectedPosition() != 4;
    }

    public void c(int i, boolean z) {
        super.c(i, z);
        int i2 = 0;
        if (i == 3) {
            this.aI.a((!z || !this.v) ? z : false);
            if (!z) {
                i2 = 8;
            }
            Util.a((View) this.aI, i2, (Animation.AnimationListener) null, 300);
            if (gk()) {
                Util.a((View) this.aL, i2, (Animation.AnimationListener) null, 300);
            }
        } else if (i != 5) {
            if (i == 17 && z && fW()) {
                this.aH.sendEmptyMessageDelayed(6, 3000);
            }
        } else if (z) {
            ListProfessionalModeBar listProfessionalModeBar = this.aF;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.setVisibility(0);
            }
        } else if (this.aF != null) {
            gc();
        }
    }

    /* compiled from: ProfessionalCapMode */
    private class a extends RelativeLayout {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3575b = true;

        public a(Context context) {
            super(context);
        }

        public void a(boolean z) {
            this.f3575b = z;
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!k.this.A || !this.f3575b || k.this.X == null || k.this.av) {
                if (!this.f3575b) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                }
                return false;
            } else if (!k.this.X.z()) {
                return super.dispatchTouchEvent(motionEvent);
            } else {
                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                obtain2.setAction(3);
                super.dispatchTouchEvent(obtain2);
                return false;
            }
        }
    }

    public int bt() {
        if (!bC() || !aV()) {
            return super.bt();
        }
        return this.W.p();
    }

    public Size f(com.oppo.camera.f.j jVar) {
        Size d;
        List<Size> a2 = jVar.a(32);
        Size c = Util.c(a2, 1.3333333333333333d);
        if (c != null) {
            com.oppo.camera.e.b("ProfessionalCapMode", "getRawSize, optimalSize: " + c);
            return c;
        } else if (this.aa == null || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_IMPRECISE_RAW_SIZE) || !"camera_tele".equals(this.aa.getString("pref_switch_camera_key", "camera_main")) || (d = Util.d(a2, 1.3333333333333333d)) == null) {
            return super.f(jVar);
        } else {
            com.oppo.camera.e.b("ProfessionalCapMode", "getRawSize, impreciseOptimalSize: " + d);
            return d;
        }
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if ((d.a.CAPTURE == dVar.a() || (d.a.CAPTURE_RAW == dVar.a() && aO())) && hashMap.containsKey("type_main_preview_frame")) {
            Long valueOf = Long.valueOf(this.aa.getString("pref_professional_exposure_time_key", this.Z.getResources().getString(R.string.camera_exposure_time_default_value)));
            if (valueOf.longValue() >= 40000000) {
                com.oppo.camera.e.a("ProfessionalCapMode", "onRequestBuilderCreated, setSlowShutter, exposureTime: " + valueOf);
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                    String string = this.aa.getString("pref_professional_iso_key", this.Z.getResources().getString(R.string.camera_iso_default_value));
                    if (this.Z.getResources().getString(R.string.camera_iso_default_value).equals(string)) {
                        builder.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(this.aB));
                    } else {
                        builder.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(Integer.parseInt(string)));
                    }
                    builder.set(com.oppo.camera.f.c.i, new int[]{2});
                    builder.set(com.oppo.camera.f.c.j, new long[]{valueOf.longValue()});
                }
                builder.removeTarget(hashMap.get("type_main_preview_frame").a());
                builder.set(CaptureRequest.FLASH_MODE, 0);
                builder.set(CaptureRequest.CONTROL_AE_MODE, 0);
                builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, valueOf);
            } else {
                com.oppo.camera.e.a("ProfessionalCapMode", "onRequestBuilderCreated, exposureTime not slow shutter");
            }
            if (hashMap.get("type_still_capture_raw") != null && eK()) {
                builder.addTarget(hashMap.get("type_still_capture_raw").a());
                builder.set(CaptureRequest.STATISTICS_LENS_SHADING_MAP_MODE, 1);
            }
        }
        super.a(dVar, builder, hashMap, i);
    }

    /* access modifiers changed from: protected */
    public String ei() {
        return this.Z.getString(R.string.camera_picture_size_standard);
    }

    /* access modifiers changed from: protected */
    public int eD() {
        if (this.aa == null) {
            return -1;
        }
        String string = this.aa.getString("pref_switch_camera_key", "camera_main");
        if ("camera_main".equals(string)) {
            return Util.d((int) R.string.camera_switch_main);
        }
        if ("camera_ultra_wide".equals(string)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || Float.compare(this.W.e().n(), 0.0f) == 0) {
                return Util.d((int) R.string.camera_switch_ultra_wide);
            }
            return Util.d((int) R.string.camera_switch_ultra_wide_micro_lens);
        } else if ("camera_tele".equals(string)) {
            return R.string.camera_switch_tele;
        } else {
            if ("camera_macro".equals(string)) {
                return R.string.camera_switch_macro;
            }
            return -1;
        }
    }

    public void b_(int i) {
        ListProfessionalModeBar listProfessionalModeBar = this.aF;
        if (listProfessionalModeBar != null && listProfessionalModeBar.getAdapter() != null && this.aG != null) {
            com.oppo.camera.e.a("ProfessionalCapMode", "onStateChange, index: " + i);
            this.aF.getAdapter().a((List<? extends Map<String, ?>>) this.aG.getMainModeBarData());
            this.aF.d(i);
        }
    }

    private void d(int i, boolean z) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
        menuClickMsgData.buildEvent(false);
        int i2 = 2;
        if (i == 0) {
            menuClickMsgData.mFuncKeyId = 28;
        } else if (i == 1) {
            menuClickMsgData.mFuncKeyId = 27;
        } else if (i == 2) {
            menuClickMsgData.mFuncKeyId = 13;
        } else if (i == 3) {
            menuClickMsgData.mFuncKeyId = 14;
        } else if (i == 4) {
            menuClickMsgData.mFuncKeyId = 15;
        }
        if (z) {
            i2 = 1;
        }
        menuClickMsgData.mFuncKeyResult = i2;
        menuClickMsgData.mCaptureMode = a();
        menuClickMsgData.mCameraId = this.X.aq();
        menuClickMsgData.mOrientation = this.k;
        menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.X.aq()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    /* access modifiers changed from: private */
    public void a(int i, String str, boolean z) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
        menuClickMsgData.buildEvent(true);
        if (i == 0) {
            menuClickMsgData.mFuncKeyId = 28;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_ISO_VALUE;
        } else if (i == 1) {
            menuClickMsgData.mFuncKeyId = 27;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_EXPOSURE_TIME;
            str = this.aa.getString("pref_professional_exposure_time_key", "");
        } else if (i == 2) {
            menuClickMsgData.mFuncKeyId = 13;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_WHITE_BALANCE;
        } else if (i == 3) {
            menuClickMsgData.mFuncKeyId = 14;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_FOCUS_VALUE;
        } else if (i == 4) {
            menuClickMsgData.mFuncKeyId = 15;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_EXPOSURE_COMPENSATION;
        }
        menuClickMsgData.mCaptureMode = a();
        menuClickMsgData.mCameraId = this.X.aq();
        menuClickMsgData.mOrientation = this.k;
        menuClickMsgData.mItemValue = str;
        menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.X.aq()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    private boolean f(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.Y.i().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public ab dl() {
        ab dl = super.dl();
        dl.f(f("pref_switch_camera_key"));
        return dl;
    }

    /* access modifiers changed from: protected */
    public boolean el() {
        return this.aF.isSelected();
    }

    public boolean fH() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_RAW_ZOOM_MUTEX_SUPPORT);
    }

    private void a(final int i, final String str) {
        if (this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (str != null && k.this.aF != null && !str.equals(k.this.aF.e(i))) {
                        k.this.aF.a(i, str);
                    }
                }
            });
        }
    }

    public boolean fA() {
        RotateImageView rotateImageView = this.aS;
        return rotateImageView != null && rotateImageView.isShown();
    }
}
