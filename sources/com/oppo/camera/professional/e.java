package com.oppo.camera.professional;

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureResult;
import android.view.MotionEvent;
import com.oppo.camera.R;
import com.oppo.camera.e.b;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.professional.i;
import com.oppo.camera.ui.control.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NightPro */
public class e {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f3522a;

    /* renamed from: b  reason: collision with root package name */
    protected com.oppo.camera.ui.e f3523b;
    protected b c;
    private i d = null;
    private j e = null;
    /* access modifiers changed from: private */
    public f f;
    /* access modifiers changed from: private */
    public a g = null;
    private SharedPreferences h;
    private String i;
    private ArrayList j = null;

    /* compiled from: NightPro */
    public interface a {
        boolean a();

        boolean a(String str);

        boolean b();

        int c();

        c d();
    }

    public e(Activity activity, b bVar, com.oppo.camera.ui.e eVar, String str, f fVar) {
        this.f3522a = activity;
        this.f3523b = eVar;
        this.c = bVar;
        this.h = this.c.r();
        this.i = str;
        this.f = fVar;
    }

    public boolean a() {
        boolean z = 1 == Integer.parseInt(this.h.getString("pref_camera_id_key", String.valueOf(0)));
        if (!a("pref_night_pro_mode_key") || z) {
            return false;
        }
        return true;
    }

    private boolean a(String str) {
        SharedPreferences sharedPreferences;
        if (this.g.a(str) && (sharedPreferences = this.h) != null) {
            return "on".equals(sharedPreferences.getString(str, "off"));
        }
        return false;
    }

    public void b() {
        com.oppo.camera.e.a("NightPro", "onDeInitCameraMode");
        this.f3523b.a(true, true, false);
        i iVar = this.d;
        if (iVar != null) {
            iVar.g();
            this.d.a((i.b) null);
            this.d = null;
        }
        j jVar = this.e;
        if (jVar != null) {
            jVar.a();
            this.e = null;
        }
    }

    public void c() {
        this.f3523b.a(true, true, false);
        if (this.d != null && a()) {
            this.d.m();
        }
    }

    public boolean d() {
        i iVar = this.d;
        if (iVar != null) {
            return iVar.i();
        }
        return false;
    }

    public boolean e() {
        i iVar = this.d;
        if (iVar != null) {
            return iVar.h();
        }
        return false;
    }

    public boolean f() {
        i iVar = this.d;
        if (iVar != null) {
            return iVar.x();
        }
        return false;
    }

    public boolean g() {
        i iVar = this.d;
        return iVar != null && iVar.i();
    }

    public void a(boolean z) {
        com.oppo.camera.e.b("NightPro", "onBeforePreview");
        if (this.d != null && a()) {
            this.d.d(z);
        }
    }

    public boolean a(d dVar, boolean z) {
        boolean b2 = this.g.b();
        if (this.d != null && a() && !this.d.a(b2)) {
            return false;
        }
        if (b2) {
            this.f3522a.runOnUiThread(new Runnable() {
                public void run() {
                    e.this.c.aB();
                }
            });
        }
        if (this.e == null) {
            return true;
        }
        if (!z && !dVar.ah) {
            return true;
        }
        this.e.a(8, false);
        return true;
    }

    public void a(byte[] bArr, boolean z, boolean z2) {
        com.oppo.camera.e.a("NightPro", "onAfterPictureTaken");
        if (a()) {
            this.f3523b.g();
            this.c.aC();
        }
        if (this.d != null && a()) {
            this.d.a(bArr, z, z2);
        }
        if (this.e != null && this.g.a("pref_night_pro_mode_key") && !t() && !this.f3523b.s() && !this.f3523b.ai()) {
            this.e.a(0, true);
        }
    }

    public void h() {
        if (this.e != null && this.g.a("pref_night_pro_mode_key") && t()) {
            this.e.a(0, true);
        }
    }

    private boolean t() {
        Activity activity;
        SharedPreferences sharedPreferences = this.h;
        if (sharedPreferences == null || (activity = this.f3522a) == null) {
            return false;
        }
        return "on".equals(sharedPreferences.getString("pref_night_tripod_mode_key", activity.getString(R.string.camera_night_tripod_mode_default_value)));
    }

    public void a(CaptureResult captureResult) {
        if (this.d != null && a()) {
            this.d.a(captureResult);
        }
    }

    public void b(boolean z) {
        i iVar;
        com.oppo.camera.e.e("NightPro", "onResume");
        if (a() && (iVar = this.d) != null) {
            iVar.e();
        }
    }

    public void i() {
        if (a()) {
            c(0, false);
        }
        this.e = new j(this.f3522a, this.c, this.f3523b);
        this.e.a("pref_night_pro_mode_key");
        b(this.g.a("pref_night_pro_mode_key") ? 0 : 8, false);
        this.f3523b.A(false);
    }

    public void j() {
        if (this.d != null && a()) {
            this.d.u();
        }
        j jVar = this.e;
        if (jVar != null) {
            jVar.b();
        }
        if (a()) {
            c(0, false);
            this.f3523b.A(false);
        }
    }

    private void b(int i2, boolean z) {
        if (this.e == null) {
            if (i2 == 0) {
                this.e = new j(this.f3522a, this.c, this.f3523b);
                this.e.a("pref_night_pro_mode_key");
            } else {
                return;
            }
        }
        this.e.a(i2, z);
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        i iVar = this.d;
        if (iVar != null) {
            iVar.a(sharedPreferences, str);
        }
    }

    private void c(int i2, boolean z) {
        com.oppo.camera.e.a("NightPro", "setProMenuVisibility visibility: " + i2);
        if (this.d == null) {
            if (i2 == 0) {
                k();
            } else {
                return;
            }
        }
        this.d.a(i2, z);
    }

    public void a(int i2) {
        i iVar = this.d;
        if (iVar != null) {
            iVar.b(i2);
        }
    }

    public void k() {
        this.d = new f(this.f3522a, this.c, this.f3523b, this.i);
        this.d.a((i.b) new i.b() {
            public boolean b() {
                return e.this.a();
            }

            public boolean a() {
                return e.this.g.a();
            }

            public boolean a(String str) {
                return e.this.g.a(str);
            }

            public int c() {
                return e.this.g.c();
            }

            public void b(String str) {
                if (e.this.f != null) {
                    e.this.f.a(str);
                }
            }

            public void a(int i) {
                if (e.this.f != null) {
                    e.this.f.k(i);
                }
            }

            public int d() {
                if (e.this.f != null) {
                    return e.this.f.p();
                }
                return 1;
            }

            public void b(int i) {
                if (e.this.f != null) {
                    e.this.f.a(i, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
                }
            }

            public void a(float f) {
                if (e.this.f != null) {
                    e.this.f.b(f);
                }
            }

            public void a(long j) {
                if (e.this.f != null) {
                    e.this.f.c(j);
                }
            }

            public void a(boolean z) {
                if (e.this.f != null) {
                    e.this.f.f(z);
                }
            }

            public void c(int i) {
                if (e.this.f != null) {
                    e.this.f.F(i);
                }
            }

            public void e() {
                if (e.this.f != null) {
                    e.this.f.r();
                }
            }

            public void d(int i) {
                if (e.this.f != null) {
                    e.this.f.q(0);
                }
            }

            public void e(int i) {
                if (e.this.f != null) {
                    e.this.f.f(i);
                }
            }

            public void f() {
                if (e.this.f != null) {
                    e.this.f.a((f.c) null);
                }
            }

            public void g() {
                if (e.this.f != null) {
                    e.this.f.t();
                }
            }

            public c h() {
                return e.this.g.d();
            }
        });
    }

    public boolean l() {
        if (this.d == null || !a()) {
            return false;
        }
        return this.d.c();
    }

    private void u() {
        if (this.d != null && this.h != null && a() && this.h.getBoolean("pref_restore_night_pro_params", false)) {
            this.h.edit().remove("pref_restore_night_pro_params").apply();
            this.d.n();
        }
    }

    public void m() {
        com.oppo.camera.e.a("NightPro", "onMoreModeShown");
        if (a()) {
            c(8, false);
        }
        b(8, false);
    }

    public void n() {
        com.oppo.camera.e.a("NightPro", "onMoreModeHidden");
        if (a()) {
            c(0, false);
        }
        b(this.g.a("pref_night_pro_mode_key") ? 0 : 8, false);
    }

    public boolean a(MotionEvent motionEvent) {
        if (this.d == null || !a()) {
            return false;
        }
        return this.d.a(motionEvent);
    }

    public void o() {
        if (this.d != null && a()) {
            this.d.s();
        }
        if (this.e != null && this.g.a("pref_night_pro_mode_key") && !this.g.a() && !this.c.x() && !this.f3523b.s()) {
            this.e.a(0, true);
        }
    }

    public void p() {
        if (this.d != null && a()) {
            this.d.t();
        }
        if (this.e != null && this.g.a("pref_night_pro_mode_key")) {
            this.e.a(4, true);
        }
    }

    public void c(boolean z) {
        c(z ? 0 : 8, false);
        this.e.a(z);
        u();
        this.c.aA();
        this.f3523b.A(false);
        if (!z) {
            this.d.n();
            this.d.b(false);
            if (!this.f3523b.d() && !this.f3523b.s()) {
                this.f3523b.a(0);
            }
            this.f3523b.f(0);
            this.f3523b.b(true, false);
            return;
        }
        this.d.b(true);
        this.d.y();
        this.c.a();
    }

    public void d(boolean z) {
        this.f3523b.a(true, true, false);
        if (z) {
            j jVar = this.e;
            if (jVar != null) {
                jVar.a(8, false);
            }
            if (this.d != null) {
                c(8, false);
            }
        }
        i iVar = this.d;
        if (iVar != null) {
            iVar.e(true);
        }
    }

    public void q() {
        if (!"off".equals(this.h.getString("pref_night_pro_mode_key", "off"))) {
            this.h.edit().putString("pref_night_pro_mode_key", "off").apply();
        }
        j jVar = this.e;
        if (jVar != null) {
            jVar.a(false);
        }
    }

    public void r() {
        if (a()) {
            this.f3523b.a((int) R.string.camera_scene_night_pro_fixed_tips_realme, -1, false, false, true);
        } else {
            this.f3523b.b((int) R.string.camera_scene_night_pro_fixed_tips_realme);
        }
    }

    public void a(int i2, boolean z) {
        com.oppo.camera.e.a("NightPro", "changeModeAllView animationType: " + i2 + ", isShow: " + z);
        if (3 == i2 && this.g.a("pref_night_pro_mode_key")) {
            if (this.d != null) {
                this.d.b((!z || !this.g.a()) ? z : false);
            }
            int i3 = 8;
            if (z) {
                if (a()) {
                    if (a()) {
                        i3 = 0;
                    }
                    c(i3, true);
                }
                b(0, false);
                return;
            }
            if (a()) {
                c(8, true);
            }
            b(8, false);
        }
    }

    public List<String> s() {
        ArrayList arrayList = this.j;
        if (arrayList != null) {
            return arrayList;
        }
        this.j = new ArrayList();
        this.j.add(this.f3522a.getResources().getString(R.string.camera_scene_night_tips));
        this.j.add(this.f3522a.getResources().getString(R.string.camera_scene_night_light_collect_tips_realme));
        this.j.add(this.f3522a.getResources().getString(R.string.camera_scene_night_low_exposure_time_tips_realme));
        this.j.add(this.f3522a.getResources().getString(R.string.camera_scene_night_image_optimizing_tips_realme));
        return this.j;
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void e(boolean z) {
        if (this.d != null && a()) {
            this.d.e(true);
        }
    }
}
