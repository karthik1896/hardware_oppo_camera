package com.oppo.camera.professional;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.a.a.f;
import com.a.a.h;
import com.a.a.j;
import com.anc.humanvideo.BuildConfig;
import com.oppo.camera.R;
import com.oppo.camera.professional.ListProfessionalModeBar;
import com.oppo.camera.professional.g;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.menu.levelcontrol.c;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProMenuManager */
public class i implements ListProfessionalModeBar.ModeBarStateListener, ListProfessionalModeBar.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f3534a = false;

    /* renamed from: b  reason: collision with root package name */
    protected int f3535b = -1;
    protected Activity c;
    protected e d;
    protected com.oppo.camera.e.b e;
    protected Handler f = null;
    protected g g = null;
    protected b h;
    protected ListProfessionalModeBar i = null;
    protected c j = null;
    protected a k = null;
    /* access modifiers changed from: private */
    public boolean l = true;
    private boolean m = false;
    /* access modifiers changed from: private */
    public boolean n = false;
    private boolean o = false;
    private boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    private Resources r;
    private SharedPreferences s;
    private String t;
    private g.b u = new g.b() {
        public void a(int i, String str, boolean z) {
        }
    };

    /* compiled from: ProMenuManager */
    public interface b {
        void a(float f);

        void a(int i);

        void a(long j);

        void a(boolean z);

        boolean a();

        boolean a(String str);

        void b(int i);

        void b(String str);

        boolean b();

        int c();

        void c(int i);

        int d();

        void d(int i);

        void e();

        void e(int i);

        void f();

        void g();

        com.oppo.camera.ui.control.c h();
    }

    public void b() {
    }

    public i(Activity activity, com.oppo.camera.e.b bVar, e eVar, String str) {
        this.c = activity;
        this.d = eVar;
        this.e = bVar;
        this.r = this.c.getResources();
        this.s = this.e.r();
        this.t = str;
        f();
    }

    public void f() {
        this.f = new Handler();
        z();
        LevelPanel.setAutoValueMap(a());
    }

    public void b(int i2) {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(i2, true);
        }
    }

    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pref_professional_iso_key", BuildConfig.BUILD_NUMBER);
        hashMap.put("pref_professional_exposure_time_key", "1/50s");
        hashMap.put("pref_professional_whitebalance_key", "2000");
        hashMap.put("pref_professional_exposure_compensation_key", "0.00");
        hashMap.put("pref_professional_focus_mode_key", "0.00");
        return hashMap;
    }

    private void z() {
        if (this.j == null) {
            this.j = new c(this.c);
            this.j.setEnabled(true);
            this.j.setFocusable(false);
            this.j.setClickable(true);
            this.j.setNormalShape(true);
            this.j.setVisibility(4);
            this.j.setContentDescription(this.r.getString(R.string.camera_description_professional_auto));
            Drawable drawable = this.r.getDrawable(R.drawable.pro_btn_mode_change_light_a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMarginEnd(this.r.getDimensionPixelSize(R.dimen.control_button_margin_edge));
            this.j.setLayoutParams(layoutParams);
            ((RelativeLayout) this.c.findViewById(R.id.control_panel_button_layout)).addView(this.j);
            this.j.a(this.e.s(), false);
            A();
        }
    }

    private void A() {
        f b2 = j.c().b();
        b2.a(com.a.a.g.b(10.0d, 20.0d));
        final f a2 = b2.a((h) new com.a.a.e() {
            public void a(f fVar) {
                float c = (float) fVar.c();
                i.this.j.setScaleX(c);
                i.this.j.setScaleY(c);
            }
        });
        final f a3 = b2.a((h) new com.a.a.e() {
            public void a(f fVar) {
                i.this.j.setAlpha((float) fVar.c());
            }
        });
        a2.a(1.0d);
        a3.a(1.0d);
        this.j.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    a2.b(0.8999999761581421d);
                    a3.b(0.6000000238418579d);
                } else if (action == 1 || action == 3) {
                    a2.b(1.0d);
                    a3.b(1.0d);
                    if (!i.this.h.a() && !i.this.g.g() && i.this.i.isSelected()) {
                        int selectedPosition = i.this.i.getSelectedPosition();
                        View childAt = i.this.i.getChildAt(selectedPosition);
                        if (i.this.l) {
                            i.this.g.a(false, selectedPosition);
                            i.this.f(false);
                            if (3 == selectedPosition) {
                                i.this.g(false);
                            }
                            if (childAt != null) {
                                i.this.i.getAdapter().a(childAt, 8, false);
                            }
                        } else {
                            i.this.g.a(true, selectedPosition);
                            i.this.f(true);
                            if (3 == selectedPosition) {
                                i.this.g(true);
                            }
                            if (childAt != null) {
                                i.this.i.getAdapter().a(childAt, 0, true);
                            }
                        }
                    }
                }
                return false;
            }
        });
    }

    public void a(CaptureResult captureResult) {
        CaptureResult.Key key;
        int i2;
        int a2;
        int a3;
        int a4;
        int a5;
        if (this.g != null) {
            Integer num = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            Long l2 = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            Float f2 = (Float) captureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
            if (Util.p()) {
                key = com.oppo.camera.f.c.N;
            } else {
                key = com.oppo.camera.f.c.aa;
            }
            if (key != null) {
                try {
                    i2 = ((int[]) captureResult.get(key))[0];
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (num != null && this.g.g(0) && (a5 = a((long) num.intValue(), this.g.b(0))) > -1 && (!this.g.b(0, a5) || !this.o)) {
                    com.oppo.camera.e.b("ProMenuManager", "onPreviewCaptureResult, iso: " + num);
                    LevelPanel.a("pref_professional_iso_key", this.g.c(0).get(a5));
                    this.g.scrollTo(0, a5);
                }
                if (l2 != null && this.g.g(1) && (a4 = a(l2.longValue(), this.g.b(1))) > -1 && (!this.g.b(1, a4) || !this.o)) {
                    com.oppo.camera.e.b("ProMenuManager", "onPreviewCaptureResult, exposureTime: " + l2);
                    LevelPanel.a("pref_professional_exposure_time_key", this.g.c(1).get(a4));
                    this.g.scrollTo(1, a4);
                }
                if (this.g.g(2) && (a3 = a((long) i2, this.g.b(2))) > -1 && (!this.g.b(2, a3) || !this.o)) {
                    com.oppo.camera.e.b("ProMenuManager", "onPreviewCaptureResult, cct: " + i2);
                    LevelPanel.a("pref_professional_whitebalance_key", this.g.c(2).get(a3));
                    this.g.scrollTo(2, a3);
                }
                if (f2 != null && this.g.g(3) && (a2 = a(f2.floatValue(), this.g.b(3))) > -1 && (!this.g.b(3, a2) || !this.o)) {
                    com.oppo.camera.e.b("ProMenuManager", "onPreviewCaptureResult, focusDistance: " + f2);
                    LevelPanel.a("pref_professional_focus_mode_key", this.g.c(3).get(a2));
                    this.g.scrollTo(3, a2);
                }
                this.o = true;
            }
            i2 = 0;
            com.oppo.camera.e.b("ProMenuManager", "onPreviewCaptureResult, iso: " + num);
            LevelPanel.a("pref_professional_iso_key", this.g.c(0).get(a5));
            this.g.scrollTo(0, a5);
            com.oppo.camera.e.b("ProMenuManager", "onPreviewCaptureResult, exposureTime: " + l2);
            LevelPanel.a("pref_professional_exposure_time_key", this.g.c(1).get(a4));
            this.g.scrollTo(1, a4);
            com.oppo.camera.e.b("ProMenuManager", "onPreviewCaptureResult, cct: " + i2);
            LevelPanel.a("pref_professional_whitebalance_key", this.g.c(2).get(a3));
            this.g.scrollTo(2, a3);
            com.oppo.camera.e.b("ProMenuManager", "onPreviewCaptureResult, focusDistance: " + f2);
            LevelPanel.a("pref_professional_focus_mode_key", this.g.c(3).get(a2));
            this.g.scrollTo(3, a2);
            this.o = true;
        }
    }

    private int a(float f2, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float abs = Math.abs(Float.valueOf(arrayList.get(0)).floatValue() - f2);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            float floatValue = Float.valueOf(arrayList.get(i3)).floatValue() - f2;
            if (Math.abs(floatValue) < abs) {
                abs = Math.abs(floatValue);
                i2 = i3;
            }
        }
        return i2;
    }

    private int a(long j2, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long abs = Math.abs(Long.valueOf(arrayList.get(0)).longValue() - j2);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            long longValue = Long.valueOf(arrayList.get(i3)).longValue() - j2;
            if (Math.abs(longValue) < abs) {
                abs = Math.abs(longValue);
                i2 = i3;
            }
        }
        return i2;
    }

    public void g() {
        n();
        a(8, false);
        l();
    }

    public void a(int i2, boolean z) {
        com.oppo.camera.e.a("ProMenuManager", "setVisibility, visibility: " + i2);
        if (this.k == null) {
            j();
        }
        if (i2 == 0) {
            ListProfessionalModeBar listProfessionalModeBar = this.i;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.setVisibility(i2);
                return;
            }
            return;
        }
        if (i() && !z) {
            if (!this.d.d()) {
                this.d.a(0);
            }
            if (this.h.a("pref_support_switch_camera")) {
                this.i.a();
                this.d.f(0);
                this.d.b(true, false);
            }
        }
        ListProfessionalModeBar listProfessionalModeBar2 = this.i;
        if (listProfessionalModeBar2 != null) {
            listProfessionalModeBar2.a();
            this.i.setItemPressed(false);
            this.i.setVisibility(i2);
        }
        if (this.g != null) {
            Util.a((View) this.j, 4, (Animation.AnimationListener) null, 300);
            this.g.e();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h() {
        /*
            r1 = this;
            com.oppo.camera.professional.ListProfessionalModeBar r0 = r1.i
            if (r0 == 0) goto L_0x0016
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0016
            com.oppo.camera.professional.i$a r0 = r1.k
            if (r0 == 0) goto L_0x0016
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.professional.i.h():boolean");
    }

    public boolean i() {
        g gVar = this.g;
        return gVar != null && gVar.c();
    }

    public void b(boolean z) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.setTouchState(z);
        }
    }

    public void j() {
        this.f3535b = this.e.am();
        this.o = false;
        H();
        d();
        I();
        C();
        this.g.setSettleListener(this.i);
        this.g.setMotionListener(this.u);
        k();
    }

    private g.a B() {
        g.a configData = this.g.getConfigData();
        configData.f3533b = 15625000;
        return configData;
    }

    private void C() {
        this.i = new ListProfessionalModeBar(this.c, q());
        this.i.setModeBarStateListener(this);
        this.i.setPanelInterface(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.r.getDimensionPixelSize(R.dimen.main_mode_bar_height));
        layoutParams.setMargins(0, 0, 0, this.r.getDimensionPixelSize(R.dimen.sub_mode_bar_height));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.i.setBackground(this.c.getResources().getDrawable(R.drawable.professionalmode_mode_bar_background));
        ListModeBarAdapter listModeBarAdapter = new ListModeBarAdapter(this.c, this.g.getMainModeBarData());
        listModeBarAdapter.a((h) this.g);
        a(this.i, (int) R.id.main_bar_id, listModeBarAdapter, (ListProfessionalModeBar.OnItemClickListener) this);
        this.k.addView(this.i, layoutParams);
    }

    public void k() {
        if (this.i.isSelected()) {
            int selectedPosition = this.i.getSelectedPosition();
            this.i.a(selectedPosition, true);
            View childAt = this.i.getChildAt(selectedPosition);
            if (childAt != null && this.g.g(selectedPosition) && this.j.getVisibility() == 0) {
                this.i.getAdapter().a(childAt, 0, true);
            }
        }
        this.g.a();
    }

    public void l() {
        a(8, false);
        o();
        G();
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public void e() {
        this.q = false;
        a aVar = this.k;
        if (aVar != null) {
            aVar.setVisibility(0);
            if (x()) {
                this.j.setVisibility(0);
                this.d.g(4);
            }
        }
        this.e.d(true);
        k();
    }

    public void m() {
        this.q = true;
        a aVar = this.k;
        if (aVar != null) {
            aVar.setTouchState(false);
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.h();
        }
        this.d.d(true, false);
        if (this.i.getSelectedPosition() == 3) {
            f(true);
        }
        g gVar2 = this.g;
        if (gVar2 != null) {
            gVar2.setAuto(3);
            g(true);
        }
        F();
    }

    public void n() {
        b bVar = this.h;
        if (bVar != null) {
            bVar.d(0);
            a(this.c.getResources().getString(R.string.camera_iso_default_value));
            b(this.c.getResources().getString(R.string.camera_exposure_compensation_default_value));
            this.h.a(Long.valueOf(this.c.getResources().getString(R.string.camera_exposure_time_default_value)).longValue());
            E();
            this.h.e();
            this.h.f();
            J();
            D();
            g gVar = this.g;
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    private void D() {
        g gVar;
        if (this.i != null && (gVar = this.g) != null) {
            gVar.setPreference(2);
        }
    }

    private void E() {
        g gVar;
        if (this.i != null && (gVar = this.g) != null) {
            gVar.setPreference(0);
            this.g.setPreference(1);
        }
    }

    private void F() {
        com.oppo.camera.e.a("ProMenuManager", "restoreFocusMode");
        b bVar = this.h;
        if (bVar != null) {
            bVar.b(bVar.c());
            this.h.e(com.oppo.camera.a.b());
            this.h.f();
        }
    }

    public void a(String str) {
        String string = this.c.getResources().getString(R.string.camera_iso_default_value);
        if (str == null) {
            str = this.s.getString("pref_professional_iso_key", string);
        }
        if (!this.s.getString("pref_professional_iso_key", string).equals(str)) {
            SharedPreferences.Editor edit = this.s.edit();
            edit.putString("pref_professional_iso_key", string);
            edit.apply();
        }
        if (string.equals(str)) {
            this.h.c(-1);
        } else {
            K();
            this.h.b("off");
            this.h.c(Integer.valueOf(str).intValue());
        }
        com.oppo.camera.e.a("ProMenuManager", "setISOValue, iso: " + str);
    }

    private void G() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.setVisibility(4);
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.setTouchState(false);
            ListProfessionalModeBar listProfessionalModeBar = this.i;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.removeAllViews();
                this.k.removeView(this.i);
                this.i = null;
            }
        }
        this.k = null;
    }

    /* access modifiers changed from: protected */
    public void o() {
        this.g.scrollTo(0, 0);
        this.g.scrollTo(1, 0);
        this.g.scrollTo(2, 0);
        this.g.scrollTo(3, 0);
    }

    private void H() {
        this.k = new a(this.c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Util.E());
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        if (this.e != null) {
            layoutParams.bottomMargin = this.d.k() - this.r.getDimensionPixelSize(R.dimen.sub_mode_bar_height);
        } else {
            layoutParams.bottomMargin = 0;
        }
        this.k.setLayoutParams(layoutParams);
        this.k.setTouchState(true);
        this.k.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            public void onWindowFocusChanged(boolean z) {
                if (i.this.i != null) {
                    com.oppo.camera.e.a("ProMenuManager", "onWindowFocusChanged, SelectedPosition: " + i.this.i.getSelectedPosition() + ", hasFocus: " + z);
                    i.this.i.a(i.this.i.getSelectedPosition(), true);
                }
            }
        });
        this.d.a((View) this.k, this.t, 2, true);
    }

    public void d() {
        this.g = new g(this.c, this.e);
        this.g.a(com.oppo.camera.f.a.a(this.f3535b), this.f, B());
    }

    private void I() {
        this.g.setGravity(17);
        this.g.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.E(), this.r.getDimensionPixelSize(R.dimen.sub_mode_bar_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.k.addView(this.g, layoutParams);
    }

    public void b_(int i2) {
        ListProfessionalModeBar listProfessionalModeBar = this.i;
        if (listProfessionalModeBar != null && listProfessionalModeBar.getAdapter() != null && this.g != null) {
            com.oppo.camera.e.a("ProMenuManager", "onStateChange, index: " + i2);
            this.i.getAdapter().a((List<? extends Map<String, ?>>) this.g.getMainModeBarData());
            this.i.d(i2);
        }
    }

    private void a(ListProfessionalModeBar listProfessionalModeBar, int i2, ListModeBarAdapter listModeBarAdapter, ListProfessionalModeBar.OnItemClickListener onItemClickListener) {
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setId(i2);
            listProfessionalModeBar.setAdapter(listModeBarAdapter);
            listProfessionalModeBar.setOnItemClickListener(onItemClickListener);
        }
    }

    private void J() {
        ListProfessionalModeBar listProfessionalModeBar = this.i;
        if (listProfessionalModeBar != null && this.g != null) {
            if (listProfessionalModeBar.getSelectedPosition() == 3) {
                f(true);
            }
            this.g.setPreference(3);
        }
    }

    /* access modifiers changed from: private */
    public void f(boolean z) {
        com.oppo.camera.e.a("ProMenuManager", "setAutoChecked, checked: " + z);
        c cVar = this.j;
        if (cVar == null) {
            return;
        }
        if (z) {
            cVar.a(true, (String) null, this.c.getResources().getDrawable(R.drawable.pro_btn_mode_change_light_a));
            this.l = true;
            return;
        }
        cVar.a(false, (String) null, this.c.getResources().getDrawable(R.drawable.pro_btn_mode_change_a));
        this.l = false;
    }

    /* access modifiers changed from: private */
    public void g(boolean z) {
        g gVar;
        ListProfessionalModeBar listProfessionalModeBar = this.i;
        if (listProfessionalModeBar != null && listProfessionalModeBar.getAdapter() != null && (gVar = this.g) != null) {
            gVar.a(z);
            this.i.getAdapter().a((List<? extends Map<String, ?>>) this.g.getMainModeBarData());
            this.i.d(3);
        }
    }

    public void b(String str) {
        String string = this.c.getResources().getString(R.string.camera_exposure_compensation_default_value);
        if (str == null) {
            str = this.s.getString("pref_professional_exposure_compensation_key", string);
        }
        if (!this.s.getString("pref_professional_exposure_compensation_key", string).equals(str)) {
            SharedPreferences.Editor edit = this.s.edit();
            edit.putString("pref_professional_exposure_compensation_key", string);
            edit.apply();
        }
        try {
            int intValue = Integer.valueOf(str).intValue();
            this.h.e(intValue);
            com.oppo.camera.e.a("ProMenuManager", "setExposureCompensation, evValue: " + intValue);
        } catch (Exception e2) {
            com.oppo.camera.e.e("ProMenuManager", "setExposureCompensation, e: " + e2);
        }
    }

    public void p() {
        if (this.h != null) {
            String string = this.s.getString("pref_professional_exposure_time_key", this.c.getResources().getString(R.string.camera_exposure_time_default_value));
            com.oppo.camera.ui.control.c h2 = this.h.h();
            long longValue = Long.valueOf(this.c.getResources().getString(R.string.camera_exposure_time_default_value)).longValue();
            long parseLong = Long.parseLong(string);
            com.oppo.camera.e.a("ProMenuManager", "setExposureTime, exposureTimeValue: " + parseLong);
            if (parseLong != longValue) {
                K();
            }
            a(parseLong);
            if (!this.m && !this.e.x()) {
                this.d.a(h2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2) {
        if (j2 < 40000000) {
            com.oppo.camera.e.a("ProMenuManager", "setExposureTime, back exposureTimeValue: " + j2);
            this.h.a(false);
            this.h.a(j2);
            return;
        }
        com.oppo.camera.e.a("ProMenuManager", "setExposureTime, slow shutter");
        this.h.a(true);
        this.h.a(40000000);
    }

    private void K() {
        if (!"off".equals(this.s.getString("pref_camera_flashmode_key", this.c.getString(R.string.camera_flash_mode_default_value)))) {
            SharedPreferences.Editor edit = this.s.edit();
            edit.putString("pref_camera_flashmode_key", "off");
            edit.apply();
            this.d.f("pref_camera_flashmode_key");
        }
    }

    /* compiled from: ProMenuManager */
    protected class a extends RelativeLayout {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3547b = true;

        public a(Context context) {
            super(context);
        }

        public void setTouchState(boolean z) {
            this.f3547b = z;
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!this.f3547b || i.this.e == null || i.this.n) {
                if (!this.f3547b) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                }
                return false;
            } else if (!i.this.e.z()) {
                return super.dispatchTouchEvent(motionEvent);
            } else {
                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                obtain2.setAction(3);
                super.dispatchTouchEvent(obtain2);
                return false;
            }
        }
    }

    public void a(View view, View view2, int i2, long j2) {
        if (!this.e.x()) {
            if (ListProfessionalModeBar.ModePressState.NO_PRESSED != this.i.getModePressState() || !this.i.isSelected()) {
                this.e.E();
                L();
                com.oppo.camera.e.e("ProMenuManager", "onItemClick, position: " + i2 + ", id: " + j2);
                if (i2 == 4) {
                    this.j.setVisibility(4);
                } else {
                    Util.a((View) this.j, 0, (Animation.AnimationListener) null, 300);
                }
                this.d.a(4);
                this.d.g(4);
                this.g.setVisibility(0);
                this.g.f(i2);
                if (!this.g.g(i2) || this.j.getVisibility() != 0) {
                    f(false);
                    this.i.getAdapter().a(view2, 8, false);
                    return;
                }
                f(true);
                this.i.getAdapter().a(view2, 0, true);
                return;
            }
            c();
        }
    }

    private void L() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.clearAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void M() {
        J();
        g(true);
        this.g.setPanelsBarAuto(3);
    }

    public int q() {
        return this.e.s();
    }

    public void c(boolean z) {
        g gVar = this.g;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        ListProfessionalModeBar listProfessionalModeBar;
        if ("pref_professional_whitebalance_key".equals(str)) {
            if (2 == this.i.getSelectedPosition()) {
                f(this.g.h(2));
            }
            r();
            return;
        }
        boolean z = true;
        if ("pref_professional_iso_key".equals(str)) {
            if (this.i.getSelectedPosition() == 0) {
                if (!this.g.h(0) || this.j == null) {
                    z = false;
                }
                f(z);
            }
            a((String) null);
        } else if ("pref_professional_exposure_compensation_key".equals(str)) {
            b((String) null);
            this.h.f();
        } else if ("pref_professional_exposure_time_key".equals(str)) {
            if (!(this.j == null || (listProfessionalModeBar = this.i) == null || 1 != listProfessionalModeBar.getSelectedPosition())) {
                f(this.g.h(1));
            }
            p();
        } else if ("pref_professional_focus_mode_key".equals(str)) {
            this.g.h(3);
            if (!this.g.g(3)) {
                c((String) null);
                f(false);
                g(false);
                return;
            }
            if (4 != this.h.d()) {
                this.h.b(4);
                this.h.f();
            }
            if (4 == this.h.d() || 1 == this.h.d()) {
                M();
            }
        } else if ("pref_camera_flashmode_key".equals(str) && !this.c.getString(R.string.camera_flash_mode_default_value).equals(sharedPreferences.getString("pref_camera_flashmode_key", this.c.getString(R.string.camera_flash_mode_default_value)))) {
            N();
        }
    }

    private void N() {
        if (!"off".equals(this.s.getString("pref_camera_flashmode_key", this.c.getString(R.string.camera_flash_mode_default_value)))) {
            String string = this.s.getString("pref_professional_exposure_time_key", this.c.getResources().getString(R.string.camera_exposure_time_default_value));
            String string2 = this.s.getString("pref_professional_iso_key", this.c.getResources().getString(R.string.camera_iso_default_value));
            if (Long.parseLong(string) != -1) {
                this.g.setAuto(1);
                if (this.i.isSelected()) {
                    View childAt = this.i.getChildAt(1);
                    if (1 == this.i.getSelectedPosition()) {
                        this.i.getAdapter().a(childAt, 0, true);
                    } else {
                        this.i.getAdapter().a(childAt, 0, false);
                    }
                }
            }
            if (!this.c.getResources().getString(R.string.camera_exposure_time_default_value).equals(string2)) {
                this.g.setAuto(0);
                if (this.i.isSelected()) {
                    View childAt2 = this.i.getChildAt(0);
                    if (this.i.getSelectedPosition() == 0) {
                        this.i.getAdapter().a(childAt2, 0, true);
                    } else {
                        this.i.getAdapter().a(childAt2, 0, false);
                    }
                }
            }
        }
    }

    public void c(String str) {
        if (str == null) {
            str = this.s.getString("pref_professional_focus_mode_key", "0");
        }
        com.oppo.camera.e.a("ProMenuManager", "setFocusValue, focusValue: " + str);
        this.e.V();
        if (this.e.w()) {
            this.e.b(false, false);
        }
        this.h.a(Float.parseFloat(str));
    }

    public boolean c() {
        com.oppo.camera.e.a("ProMenuManager", "onBackPressed");
        ListProfessionalModeBar listProfessionalModeBar = this.i;
        if (listProfessionalModeBar == null || !listProfessionalModeBar.isSelected()) {
            return false;
        }
        this.i.a();
        this.j.setVisibility(4);
        if (!this.d.d()) {
            this.d.a(0);
        }
        this.d.f(0);
        this.d.d(true, false);
        this.g.e();
        this.h.g();
        return true;
    }

    public void r() {
        String string = this.s.getString("pref_professional_whitebalance_key", this.c.getResources().getString(R.string.camera_whitebalance_default_value));
        if (a(string, (List<String>) this.g.b(2))) {
            try {
                this.h.a(Integer.parseInt(string));
            } catch (NumberFormatException unused) {
                this.h.e();
            }
        } else {
            this.h.e();
        }
        com.oppo.camera.e.a("ProMenuManager", "setWhiteBalance, whiteBalance: " + string);
    }

    public boolean a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public boolean a(MotionEvent motionEvent) {
        com.oppo.camera.e.a("ProMenuManager", "onSingleTapUp");
        if (b(motionEvent) && this.i.isSelected() && !this.e.x()) {
            c();
        }
        c(motionEvent);
        return false;
    }

    private boolean b(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.d.i().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    private void c(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.d.i().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == this.h.c() || 4 == this.h.c()) {
                M();
                b_(3);
            }
        }
    }

    public void s() {
        if (this.e.x() || this.h.a()) {
            this.f3534a = true;
        } else {
            this.k.setEnabled(true);
        }
    }

    public void t() {
        this.k.setEnabled(false);
        c();
    }

    public void d(boolean z) {
        com.oppo.camera.e.a("ProMenuManager", "onBeforePreview");
        if (this.p) {
            com.oppo.camera.e.a("ProMenuManager", "onBeforePreview, initParamToAuto");
            P();
        } else if (z) {
            O();
        }
    }

    private void O() {
        g gVar;
        com.oppo.camera.e.a("ProMenuManager", "initParam");
        if (this.h != null && (gVar = this.g) != null) {
            String a2 = gVar.a(2);
            if (this.s.getString("pref_professional_whitebalance_key", a2).equals(a2)) {
                this.h.e();
            } else {
                r();
            }
            a((String) null);
            b((String) null);
            p();
            this.c.runOnUiThread(new Runnable() {
                public void run() {
                    if (!i.this.q) {
                        i.this.M();
                        i.this.Q();
                    }
                }
            });
        }
    }

    private void P() {
        this.c.runOnUiThread(new Runnable() {
            public void run() {
                i.this.n();
                i.this.Q();
            }
        });
        this.p = false;
    }

    public void e(boolean z) {
        this.p = z;
        g gVar = this.g;
        if (gVar != null) {
            gVar.b();
        }
    }

    /* access modifiers changed from: private */
    public void Q() {
        this.g.h(2);
        this.g.h(0);
        this.g.h(1);
        this.g.h(3);
        c(true);
        b_(3);
    }

    public void u() {
        com.oppo.camera.e.b("ProMenuManager", "onAfterStartPreview");
        a aVar = this.k;
        if (aVar != null) {
            aVar.setTouchState(true);
        }
    }

    public boolean a(boolean z) {
        g gVar = this.g;
        if (gVar == null || !gVar.g()) {
            this.c.runOnUiThread(new Runnable() {
                public void run() {
                    i iVar = i.this;
                    if (iVar.d(iVar.w())) {
                        if (i.this.d != null) {
                            i.this.d.j(4);
                            i.this.d.h(4);
                            i.this.d.a(4, true);
                            i.this.d.a(4);
                            i.this.e.a((Animation.AnimationListener) null);
                        }
                        Util.a((View) i.this.j, 4, (Animation.AnimationListener) null, 300);
                        Util.a((View) i.this.k, 4, (Animation.AnimationListener) null, 300);
                        if (i.this.d != null) {
                            i.this.d.k((int) (Long.valueOf(i.this.w()).longValue() / 1000000));
                        }
                    }
                    i.this.k.setTouchState(false);
                }
            });
            return true;
        }
        com.oppo.camera.e.c("ProMenuManager", "onBeforeSnapping, levelPanelScrolling");
        return false;
    }

    public boolean v() {
        com.oppo.camera.e.a("ProMenuManager", "onAfterSnapping");
        if (this.e.j() && Long.parseLong(w()) >= 1000000000) {
            this.e.c(4);
        }
        this.c.runOnUiThread(new Runnable() {
            public void run() {
                i iVar = i.this;
                if (iVar.d(iVar.w())) {
                    com.oppo.camera.ui.control.c cVar = new com.oppo.camera.ui.control.c();
                    if (i.this.d.l() == 9) {
                        cVar.a(3);
                        cVar.a("button_color_inside_none");
                    } else {
                        cVar.a(7);
                        cVar.a("button_color_inside_none");
                    }
                    i.this.d.a(cVar);
                }
            }
        });
        com.oppo.camera.e.a("ProMenuManager", "onAfterSnapping X");
        return true;
    }

    public boolean d(String str) {
        return str != null && Long.valueOf(str).longValue() >= 1000000000;
    }

    public void a(byte[] bArr, boolean z, boolean z2) {
        com.oppo.camera.e.a("ProMenuManager", "onAfterPictureTaken");
        if (d(w())) {
            this.d.a(new com.oppo.camera.ui.control.c(11, "button_color_inside_none"));
            if (this.d.l() == 4 || this.d.l() == 3 || !i()) {
                this.d.a(0);
            }
            c(0);
            Util.a((View) this.k, 0, (Animation.AnimationListener) null, 300);
            this.e.D();
            if (this.i.isSelected() && x()) {
                Util.a((View) this.j, 0, (Animation.AnimationListener) null, 300);
            }
        }
        this.d.d(true, false);
        if (this.f3534a) {
            Util.a((View) this.k, 0, (Animation.AnimationListener) null, 300);
            this.f3534a = false;
        }
        this.k.setTouchState(true);
    }

    public String w() {
        return this.s.getString("pref_professional_exposure_time_key", this.c.getResources().getString(R.string.camera_exposure_time_default_value));
    }

    /* access modifiers changed from: protected */
    public void c(int i2) {
        com.oppo.camera.e.a("ProMenuManager", "setCameraMenuControlViewVisibility, visibility: " + i2);
        e eVar = this.d;
        if (eVar != null) {
            eVar.j(i2);
            this.d.h(i2);
            this.d.e(i2);
        }
    }

    public boolean x() {
        return this.i.isSelected() && this.i.getSelectedPosition() != 4;
    }

    public boolean d(int i2) {
        g gVar = this.g;
        return gVar != null && gVar.g(i2);
    }

    public void y() {
        g(true);
    }
}
