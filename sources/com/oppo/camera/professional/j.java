package com.oppo.camera.professional;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e.b;
import com.oppo.camera.ui.SwitchButton;
import com.oppo.camera.ui.e;
import com.oppo.camera.util.Util;

/* compiled from: ProSwitchButtonManager */
public class j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f3548a;

    /* renamed from: b  reason: collision with root package name */
    private e f3549b;
    /* access modifiers changed from: private */
    public b c;
    /* access modifiers changed from: private */
    public SharedPreferences d;
    private SwitchButton.a e = null;
    /* access modifiers changed from: private */
    public SwitchButton f = null;
    /* access modifiers changed from: private */
    public String g = null;

    public j(Activity activity, b bVar, e eVar) {
        this.f3548a = activity;
        this.f3549b = eVar;
        this.c = bVar;
        this.d = this.c.r();
    }

    public void a(boolean z) {
        com.oppo.camera.e.b("ProSwitchButtonManager", "setChecked: " + z);
        SwitchButton switchButton = this.f;
        if (switchButton != null) {
            switchButton.setChecked(z);
        }
    }

    public void a() {
        com.oppo.camera.e.b("ProSwitchButtonManager", "unInit");
        a(8, false);
        if (this.f != null) {
            this.f3549b.b().removeView(this.f);
        }
    }

    public void a(final int i, final boolean z) {
        com.oppo.camera.e.b("ProSwitchButtonManager", "setVisibility: " + i);
        this.f3548a.runOnUiThread(new Runnable() {
            public void run() {
                if (i == 0) {
                    j.this.b(z);
                } else {
                    j.this.c(z);
                }
            }
        });
    }

    public void b() {
        com.oppo.camera.e.b("ProSwitchButtonManager", "onAfterStartPreview");
        boolean z = true;
        if (1 != Integer.parseInt(this.d.getString("pref_camera_id_key", String.valueOf(0)))) {
            z = false;
        }
        if (!z && !this.f3549b.ai() && !this.f3549b.s()) {
            a(0, false);
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        com.oppo.camera.e.b("ProSwitchButtonManager", "showSwitch, needAnimation: " + z);
        if (this.f3549b.b() != null && !this.f3549b.H()) {
            if (this.f == null) {
                c();
            }
            if (z) {
                Util.a((View) this.f, 0, (Animation.AnimationListener) null, 300);
            } else {
                this.f.setVisibility(0);
            }
        }
    }

    public void a(String str) {
        this.g = str;
    }

    private void c() {
        com.oppo.camera.e.b("ProSwitchButtonManager", "initSwitchButton");
        this.f = new SwitchButton(this.f3548a.getApplicationContext());
        this.f.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f3548a.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_width), this.f3548a.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_height));
        layoutParams.addRule(20);
        layoutParams.addRule(2, R.id.control_panel_layout);
        boolean equals = "on".equals(this.d.getString(this.g, "off"));
        if (equals) {
            layoutParams.bottomMargin = this.f3548a.getResources().getDimensionPixelOffset(R.dimen.night_pro_switch_on_margin_bottom);
        } else {
            layoutParams.bottomMargin = this.f3548a.getResources().getDimensionPixelOffset(R.dimen.night_pro_switch_off_margin_bottom);
        }
        layoutParams.setMarginStart(this.f3548a.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_margin_left));
        this.f.setChecked(equals);
        this.f.a(Util.a((Context) this.f3548a, (int) R.drawable.switch_button_pro_mode), Util.a((Context) this.f3548a, (int) R.drawable.switch_button_pro_mode_bg));
        if (this.f3549b.b().indexOfChild(this.f) == -1) {
            this.f3549b.b().addView(this.f, layoutParams);
        }
        this.f.setSwitchClickableListener(new SwitchButton.c() {
            public boolean a() {
                return j.this.c.aD() && !j.this.f.a() && !j.this.c.P();
            }
        });
        this.f.setOnCheckedChangeListener(new SwitchButton.a() {
            public void a(SwitchButton switchButton, boolean z) {
                com.oppo.camera.e.a("ProSwitchButtonManager", "initSwitchButton, onCheckedChanged, isChecked: " + z);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j.this.f.getLayoutParams();
                if (z) {
                    layoutParams.bottomMargin = j.this.f3548a.getResources().getDimensionPixelOffset(R.dimen.night_pro_switch_on_margin_bottom);
                } else {
                    layoutParams.bottomMargin = j.this.f3548a.getResources().getDimensionPixelOffset(R.dimen.night_pro_switch_off_margin_bottom);
                }
                j.this.f.setLayoutParams(layoutParams);
                j.this.d.edit().putString(j.this.g, z ? "on" : "off").apply();
            }
        });
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        com.oppo.camera.e.b("ProSwitchButtonManager", "hideSwitch, needAnimation: " + z);
        if (this.f == null) {
            com.oppo.camera.e.b("ProSwitchButtonManager", "hideSwitch, mProSwitchButton is null");
        } else if (this.f3549b.b() == null) {
            com.oppo.camera.e.e("ProSwitchButtonManager", "hideSwitch, mCameraRootView is null");
        } else if (z) {
            Util.a((View) this.f, 8, (Animation.AnimationListener) null, 300);
        } else {
            this.f.setVisibility(8);
        }
    }
}
