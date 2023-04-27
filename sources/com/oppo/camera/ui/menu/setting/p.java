package com.oppo.camera.ui.menu.setting;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.d;
import com.oppo.camera.e;
import com.oppo.camera.entry.b;
import com.oppo.camera.k;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.g;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CameraSettingUI */
public class p implements d {
    public Activity d = null;
    public k e = null;
    public f f = null;
    public CameraSettingMenuPanel g = null;
    public g h = null;
    public int i = 0;
    protected boolean j = false;
    private a k = null;
    private boolean l = false;
    private boolean m = false;
    private int n = 1;
    private int o = 0;

    public p(Activity activity, k kVar, f fVar, boolean z) {
        this.d = activity;
        this.e = kVar;
        this.f = fVar;
        this.m = z;
    }

    public boolean a(MotionEvent motionEvent) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel == null || !cameraSettingMenuPanel.isShown() || !a((View) this.g, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        e.a("CameraSettingUI", "needTouchEvent, mCameraSettingMenu is show and dispatchTouchEvent");
        return true;
    }

    private boolean a(View view, int i2, int i3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i4;
        int measuredHeight = view.getMeasuredHeight() + i5;
        if (i3 < i5 || i3 > measuredHeight || i2 < i4 || i2 > measuredWidth) {
            return false;
        }
        return true;
    }

    public void s() {
        this.k = new a();
        this.k.start();
    }

    public void g() {
        e.a("CameraSettingUI", "onResumeMessage");
        this.j = false;
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a();
        }
    }

    public void e() {
        e.a("CameraSettingUI", "onPause");
        this.l = false;
        this.j = true;
        d(false);
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.c();
            this.g.clearAnimation();
            f fVar = this.f;
            if (fVar != null && fVar.g("key_setting_support")) {
                this.g.setAlpha(1.0f);
            }
            this.g.setInitState(false);
        }
        k kVar = this.e;
        if (kVar != null && this.m) {
            kVar.edit().putString("pref_subsetting_key", "off").apply();
            e("pref_subsetting_key");
        }
        com.oppo.camera.ui.menu.f.e();
    }

    public void f() {
        e.a("CameraSettingUI", "onDestroy");
        a aVar = this.k;
        if (aVar != null) {
            try {
                aVar.a();
                this.k = null;
            } catch (Exception unused) {
            }
        }
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.i();
            this.g = null;
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a();
            this.h = null;
        }
        this.d = null;
        this.f = null;
    }

    public boolean t() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.d();
        }
        return false;
    }

    public void b(int i2) {
        this.i = i2;
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setSizeRatioType(this.i);
        }
    }

    public void d(boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setCameraMenuLayout(z);
        }
    }

    public void a(int i2, boolean z, boolean z2, boolean z3) {
        a aVar = this.k;
        if (aVar != null) {
            try {
                aVar.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        this.l = true;
        if (this.g == null) {
            a();
        }
        a(i2, z2, z3);
        f fVar = this.f;
        if (fVar != null && !fVar.g("key_filter_menu_updated")) {
            o();
        }
    }

    public void u() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.e();
            if (Util.z() == 0) {
                Util.a(this.g, com.oppo.camera.ui.d.a(this.d, 3), 300, (Interpolator) null, (Animator.AnimatorListener) null);
            }
        }
    }

    public void v() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.f();
            this.g.setOrientation(this.o);
        }
    }

    public void b(float f2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setAlpha(f2);
        }
    }

    public float w() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getAlpha();
        }
        return 1.0f;
    }

    public void c(int i2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null && !this.m) {
            cameraSettingMenuPanel.setVisibility(i2);
        }
    }

    public void d(int i2) {
        Util.a((View) this.g, i2, (Animation.AnimationListener) null, 300);
    }

    public void a(String str, int i2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b(str, i2);
        }
    }

    public void a(String str, boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b(str, z);
        }
    }

    public boolean x() {
        return this.e.getString("pref_subsetting_key", "off").equals("on");
    }

    public void e(int i2) {
        this.n = i2;
    }

    public void f(int i2) {
        this.o = i2;
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setOrientation(i2);
        }
    }

    public void b(int i2, boolean z, boolean z2, boolean z3) {
        a(i2, z, z2, z3);
        e(true);
    }

    public void e(boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setInitState(z);
        }
    }

    public CopyOnWriteArrayList<CameraMenuOption> y() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getMenuList();
        }
        return null;
    }

    public void o() {
        CopyOnWriteArrayList<CameraMenuOption> y = y();
        e.a("CameraSettingUI", "updateSettingMenu, mbCameraOpened: " + this.l);
        if (y != null && this.l) {
            Iterator<CameraMenuOption> it = y.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (this.m) {
                    if (a(next.a())) {
                        c(next.a());
                        if (!this.f.i(next.a())) {
                            a(next.a(), next.n((String) null));
                        } else {
                            b(next.a(), (String) null);
                        }
                    } else {
                        d(next.a());
                    }
                } else if (this.f.e(next.a())) {
                    c(next.a());
                    if (!this.f.i(next.a())) {
                        a(next.a(), next.n((String) null));
                    } else {
                        b(next.a(), (String) null);
                    }
                } else {
                    d(next.a());
                }
            }
        }
    }

    public boolean a(String str) {
        f fVar = this.f;
        return fVar != null && fVar.f(str);
    }

    public boolean z() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getMenuPanelEnable();
        }
        return false;
    }

    public void a(boolean z, boolean z2) {
        e.a("CameraSettingUI", "enableCameraSettingMenu(), enable: " + z + ", ashed: " + z2);
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(z, z2);
        }
    }

    public void c(float f2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(f2);
        }
    }

    public void b(boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null && !this.m) {
            cameraSettingMenuPanel.setVisibility(4);
            this.g.setClickable(false);
        }
    }

    public void i() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null && !this.m) {
            cameraSettingMenuPanel.setVisibility(0);
            this.g.setClickable(true);
        }
    }

    public boolean b(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.e(str);
        }
        return false;
    }

    public void a(String str, String str2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(str, str2);
        }
    }

    public void b(String str, String str2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b(str, str2);
        }
    }

    public void a(String str, String... strArr) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(str, strArr);
        }
    }

    public void a(String str, String str2, String str3) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(str, str2, str3);
        }
    }

    public void b(String str, String... strArr) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b(str, strArr);
        }
    }

    public void c(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.f(str);
        }
    }

    public void d(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.g(str);
        }
    }

    public void e(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.i(str);
        }
    }

    public void b(boolean z, boolean z2) {
        e.a("CameraSettingUI", "resetMenuState, resetVisibility:" + z + ", resetLayout:" + z2);
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b(z, z2);
        }
    }

    public void a() {
        e.a("CameraSettingUI", "initializeCameraSettingMenu, mPreferenceOptionGroup: " + this.h);
        if (this.h != null) {
            this.g = (CameraSettingMenuPanel) this.d.findViewById(R.id.oppo_setting_bar);
            c.INS.registerInverse(this.d, this.g);
            this.g.a(this.e, this.f, this.h, this.i, false);
        }
        f fVar = this.f;
        if (fVar != null) {
            fVar.ao();
        }
    }

    public CameraMenuOption f(String str) {
        Iterator<CameraMenuOption> it = this.g.c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (str.equals(next.a())) {
                return next;
            }
        }
        return null;
    }

    public void A() {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b();
        }
    }

    private void a(int i2, boolean z, boolean z2) {
        e.a("CameraSettingUI", "updateSupportedOptionItems");
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null && this.f != null && this.l) {
            cameraSettingMenuPanel.g();
            if (this.n != 3) {
                List<String> supportedList = CameraConfig.getSupportedList("pref_camera_timer_shutter_key", i2);
                if (supportedList != null) {
                    this.g.a("pref_camera_timer_shutter_key", supportedList);
                }
                this.g.a("pref_platform_slow_video_fps_key", CameraConfig.getSupportedList("pref_platform_slow_video_fps_key", i2));
            }
            this.g.a("pref_camera_torch_mode_key", CameraConfig.getSupportedList("pref_camera_torch_mode_key", i2));
            if (z && !this.m && !z2) {
                this.g.setVisibility(0);
            }
            this.g.setOrientation(this.o);
            this.f.o();
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        com.oppo.camera.ui.menu.a a2;
        ArrayList<com.oppo.camera.ui.menu.d> optionItems;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.m) {
            if (b.a(this.f.aw().y())) {
                this.h = new g(context, R.xml.camera_submenu_settings_from_other_app, true);
            } else {
                this.h = new g(context, R.xml.camera_submenu_settings, true);
            }
        } else if (b.a(this.f.aw().y())) {
            this.h = new g(context, R.xml.camera_preferences_from_other_app, false);
        } else {
            this.h = new g(context, R.xml.camera_preferences, false);
        }
        com.oppo.camera.ui.menu.a a3 = this.h.a("pref_switch_camera_key");
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_PROFESSIONAL_SWITCH_CAMERA_TYPE);
        if (!(a3 == null || configIntValue == 0)) {
            ArrayList<com.oppo.camera.ui.menu.d> optionItems2 = a3.getOptionItems();
            String[] stringArray = context.getResources().getStringArray(R.array.switch_camera_values);
            Iterator<com.oppo.camera.ui.menu.d> it = optionItems2.iterator();
            while (it.hasNext()) {
                com.oppo.camera.ui.menu.d next = it.next();
                if (next.b().equals(stringArray[2]) && (configIntValue & 4) == 0) {
                    it.remove();
                } else if (next.b().equals(stringArray[3]) && (configIntValue & 8) == 0) {
                    it.remove();
                } else if (next.b().equals(stringArray[1]) && (configIntValue & 2) == 0) {
                    it.remove();
                } else if (next.b().equals(stringArray[0]) && (configIntValue & 1) == 0) {
                    it.remove();
                }
            }
        }
        if (!(!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT) || (a2 = this.h.a("pref_camera_torch_mode_key")) == null || (optionItems = a2.getOptionItems()) == null)) {
            for (com.oppo.camera.ui.menu.d next2 : optionItems) {
                if ("on".equals(next2.b())) {
                    next2.c(context.getString(R.string.camera_flash_mode_torch));
                }
            }
        }
        e.a("CameraSettingUI", "parseCameraMenuConfig, use time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void b(String str, int i2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(str, i2);
        }
    }

    public void c(boolean z, boolean z2) {
        f fVar;
        e.a("CameraSettingUI", "updateSettingBarBg, halfOpaque: " + z + ", needAnimation: " + z2);
        if (this.g != null && this.l && (fVar = this.f) != null && !fVar.ay() && z2) {
            if (z) {
                Util.a(this.g, com.oppo.camera.ui.d.a(this.d, 1), 200, (Interpolator) null, (Animator.AnimatorListener) null);
            } else {
                Util.a(this.g, this.d.getResources().getColor(R.color.background_color), 200, (Interpolator) null, (Animator.AnimatorListener) null);
            }
        }
    }

    public void f(boolean z) {
        if (this.g != null) {
            int color2 = this.d.getColor(R.color.beauty3d_guide_background);
            if (z) {
                Util.a(this.g, color2, 200, (Interpolator) null, (Animator.AnimatorListener) null);
            }
        }
    }

    public int B() {
        return Util.u();
    }

    public void b(String str, boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b(str, z, false);
        }
    }

    public void c(String str, int i2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.c(str, i2);
        }
    }

    public void a(String str, boolean z, boolean z2) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b(str, z, z2);
        }
    }

    public void a(String str, boolean z, int i2, int i3) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(str, z, i2, i3);
        }
    }

    public void a(String str, String str2, String str3, int i2, int i3) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(str, str2, str3, i2, i3);
        }
    }

    public void g(String str) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.d(str);
        }
    }

    public void a(String str, String str2, String str3, String str4, int i2, int i3) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a(str, str2, str3, str4, i2, i3);
        }
    }

    public void g(boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setShadowOn(z);
        }
    }

    public void c(String str, boolean z) {
        CameraSettingMenuPanel cameraSettingMenuPanel = this.g;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.c(str, z);
        }
    }

    /* compiled from: CameraSettingUI */
    private class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private boolean f4239b;

        public a() {
            this.f4239b = false;
            this.f4239b = false;
        }

        public void run() {
            if (!this.f4239b) {
                p pVar = p.this;
                pVar.a((Context) pVar.d);
            }
        }

        public void a() {
            this.f4239b = true;
        }
    }
}
