package com.oppo.camera.professional;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import com.anc.humanvideo.BuildConfig;
import com.oppo.camera.e.b;
import com.oppo.camera.f.a;
import com.oppo.camera.professional.g;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.util.Util;
import java.util.HashMap;

/* compiled from: NightProMenuManager */
public class f extends i {
    public f(Activity activity, b bVar, e eVar, String str) {
        super(activity, bVar, eVar, str);
    }

    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pref_professional_iso_key", BuildConfig.BUILD_NUMBER);
        hashMap.put("pref_professional_exposure_time_key", "1/50s");
        hashMap.put("pref_professional_whitebalance_key", "2000");
        hashMap.put("pref_professional_focus_mode_key", "0.00");
        return hashMap;
    }

    public void d() {
        this.g = new d(this.c, this.e);
        this.g.a(a.a(this.f3535b), this.f, z());
    }

    private g.a z() {
        g.a configData = this.g.getConfigData();
        configData.f3533b = 15625000;
        return configData;
    }

    public void e() {
        if (this.k != null) {
            this.k.setVisibility(0);
            if (x()) {
                this.j.setVisibility(0);
                this.d.f(4);
            }
        }
        this.e.d(true);
        k();
    }

    public boolean c() {
        if (this.i == null || !this.i.isSelected()) {
            return false;
        }
        this.i.a();
        Util.a((View) this.j, 4, (Animation.AnimationListener) null, 300);
        this.d.a(0);
        this.d.f(0);
        this.d.d(true, false);
        this.g.e();
        this.h.g();
        return true;
    }

    public boolean a(final boolean z) {
        if (this.g == null || !this.g.g()) {
            this.c.runOnUiThread(new Runnable() {
                public void run() {
                    com.oppo.camera.e.a("NightProMenuManager", "onBeforeSnapping isInNightProProcess: " + z);
                    if (z && f.this.h.b()) {
                        Util.a((View) f.this.j, 4, (Animation.AnimationListener) null, 300);
                        Util.a((View) f.this.k, 4, (Animation.AnimationListener) null, 300);
                    }
                    f.this.k.setTouchState(false);
                }
            });
            return true;
        }
        com.oppo.camera.e.c("NightProMenuManager", "onBeforeSnapping, levelPanelScrolling");
        return false;
    }

    public void a(long j) {
        this.h.a(j);
    }

    public void a(byte[] bArr, boolean z, boolean z2) {
        com.oppo.camera.e.a("NightProMenuManager", "onAfterPictureTaken isInNightProProcess: " + z2 + ", mbNeedShowMenuAfterTakePicture: " + this.f3534a);
        if (z2) {
            c(0);
            if (this.h.b()) {
                Util.a((View) this.k, 0, (Animation.AnimationListener) null, 300);
                a(0, false);
            }
            this.d.g(true);
            this.d.a(new c(1, "button_color_inside_none"), false);
            this.d.n(false);
            this.e.D();
            if (!i()) {
                if (!this.d.d()) {
                    this.d.a(0);
                }
                this.d.f(0);
            }
            if (this.i.isSelected() && x()) {
                Util.a((View) this.j, 0, (Animation.AnimationListener) null, 300);
            }
        }
        this.d.d(true, false);
        if (this.f3534a) {
            if (this.h.b()) {
                Util.a((View) this.k, 0, (Animation.AnimationListener) null, 300);
            }
            this.f3534a = false;
        }
        this.k.setTouchState(true);
    }
}
