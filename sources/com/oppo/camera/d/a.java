package com.oppo.camera.d;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.oppo.camera.ui.beauty3d.d;
import com.oppo.camera.util.Util;

/* compiled from: Beauty3DEditHelper */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2786a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2787b = true;
    /* access modifiers changed from: private */
    public d c;
    private SharedPreferences d = null;
    private Context e = null;

    public a(Activity activity, d dVar) {
        this.e = activity.getApplicationContext();
        this.c = dVar;
        Context context = this.e;
        this.d = context.getSharedPreferences(this.e.getPackageName() + "_beauty3d_preferences", 0);
    }

    public void a(String str, int[] iArr) {
        if (this.c != null) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -826558116) {
                if (hashCode != -624491669) {
                    if (hashCode == 175127237 && str.equals("com.oplus.beauty3d.analyses.ffd")) {
                        c2 = 1;
                    }
                } else if (str.equals("com.oplus.beauty3d.custom.result")) {
                    c2 = 2;
                }
            } else if (str.equals("com.oplus.beauty3d.analyses.result")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 == 2) {
                        this.c.c(iArr);
                    }
                } else if (this.c.o() == 1 || (this.c.o() == 2 && !this.f2786a)) {
                    this.c.b(iArr);
                    if (this.c.o() == 2) {
                        this.c.b(this.d.getInt("key_chose_style", 0));
                        Util.ab().postDelayed(new Runnable() {
                            public void run() {
                                a.this.c.b(true);
                            }
                        }, 3000);
                        this.f2786a = true;
                    }
                }
            } else if (iArr != null && iArr.length >= 5) {
                String[] strArr = new String[5];
                String string = this.e.getResources().getString(c.a().e(iArr[0]).intValue());
                if (string == null) {
                    string = "";
                }
                strArr[0] = string;
                String string2 = this.e.getResources().getString(c.a().d(iArr[1]).intValue());
                if (string2 == null) {
                    string2 = "";
                }
                strArr[1] = string2;
                String string3 = this.e.getResources().getString(c.a().c(iArr[2]).intValue());
                if (string3 == null) {
                    string3 = "";
                }
                strArr[2] = string3;
                String string4 = this.e.getResources().getString(c.a().b(iArr[3]).intValue());
                if (string4 == null) {
                    string4 = "";
                }
                strArr[3] = string4;
                String string5 = this.e.getResources().getString(c.a().a(iArr[4]).intValue());
                if (string5 == null) {
                    string5 = "";
                }
                strArr[4] = string5;
                this.c.a(strArr);
            }
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("key_chose_style", 0);
        }
        return 0;
    }

    public void b() {
        this.f2786a = false;
        if (this.f2787b) {
            c();
            int i = this.d.getInt("key_chose_style", 0);
            int[] iArr = {this.d.getInt("key_style_natural_high_nose", 50), this.d.getInt("key_style_natural_small_nose", 70), this.d.getInt("key_style_natural_eye", 30), this.d.getInt("key_style_natural_fix_face", 30), this.d.getInt("key_style_natural_small_face", 30), this.d.getInt("key_style_natural_cheek_bone", 50), this.d.getInt("key_style_natural_chin", 0), this.d.getInt("key_style_goose_egg_high_nose", 50), this.d.getInt("key_style_goose_egg_small_nose", 80), this.d.getInt("key_style_natural_eye", 30), this.d.getInt("key_style_natural_fix_face", 35), this.d.getInt("key_style_goose_egg_small_face", 20), this.d.getInt("key_style_goose_egg_cheek_bone", 30), this.d.getInt("key_style_goose_egg_chin", 0), this.d.getInt("key_style_lolita_high_nose", 50), this.d.getInt("key_style_lolita_small_nose", 80), this.d.getInt("key_style_lolita_eye", 40), this.d.getInt("key_style_lolita_fix_face", 25), this.d.getInt("key_style_lolita_small_face", 40), this.d.getInt("key_style_lolita_cheekbone", 30), this.d.getInt("key_style_lolita_chin", 0), this.d.getInt("key_style_mode_high_nose", 100), this.d.getInt("key_style_mode_small_nose", 80), this.d.getInt("key_style_mode_eye", 40), this.d.getInt("key_style_mode_fix_face", 50), this.d.getInt("key_style_mode_small_face", 0), this.d.getInt("key_style_mode_cheekbone", 50), this.d.getInt("key_style_mode_chin", 10)};
            d dVar = this.c;
            if (dVar != null) {
                dVar.a(i, iArr);
                this.f2787b = false;
            }
        }
    }

    public void c() {
        int[] iArr = {50, 70, 30, 30, 30, 50, 0, 50, 80, 30, 35, 20, 30, 0, 50, 80, 40, 25, 40, 30, 0, 100, 80, 40, 50, 0, 50, 10};
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(iArr);
        }
    }

    public void d() {
        int[] p = this.c.p();
        SharedPreferences.Editor edit = this.d.edit();
        if (p != null && p.length == 8) {
            int i = p[0];
            if (i == 0) {
                edit.putInt("key_chose_style", p[0]);
                edit.putInt("key_style_natural_high_nose", p[1]);
                edit.putInt("key_style_natural_small_nose", p[2]);
                edit.putInt("key_style_natural_eye", p[3]);
                edit.putInt("key_style_natural_fix_face", p[4]);
                edit.putInt("key_style_natural_small_face", p[5]);
                edit.putInt("key_style_natural_cheek_bone", p[6]);
                edit.putInt("key_style_natural_chin", p[7]);
            } else if (i == 1) {
                edit.putInt("key_chose_style", p[0]);
                edit.putInt("key_style_goose_egg_high_nose", p[1]);
                edit.putInt("key_style_goose_egg_small_nose", p[2]);
                edit.putInt("key_style_natural_eye", p[3]);
                edit.putInt("key_style_natural_fix_face", p[4]);
                edit.putInt("key_style_goose_egg_small_face", p[5]);
                edit.putInt("key_style_goose_egg_cheek_bone", p[6]);
                edit.putInt("key_style_goose_egg_chin", p[7]);
            } else if (i == 2) {
                edit.putInt("key_chose_style", p[0]);
                edit.putInt("key_style_lolita_high_nose", p[1]);
                edit.putInt("key_style_lolita_small_nose", p[2]);
                edit.putInt("key_style_lolita_eye", p[3]);
                edit.putInt("key_style_lolita_fix_face", p[4]);
                edit.putInt("key_style_lolita_small_face", p[5]);
                edit.putInt("key_style_lolita_cheekbone", p[6]);
                edit.putInt("key_style_lolita_chin", p[7]);
            } else if (i == 3) {
                edit.putInt("key_chose_style", p[0]);
                edit.putInt("key_style_mode_high_nose", p[1]);
                edit.putInt("key_style_mode_small_nose", p[2]);
                edit.putInt("key_style_mode_eye", p[3]);
                edit.putInt("key_style_mode_fix_face", p[4]);
                edit.putInt("key_style_mode_small_face", p[5]);
                edit.putInt("key_style_mode_cheekbone", p[6]);
                edit.putInt("key_style_mode_chin", p[7]);
            }
            edit.apply();
            this.f2787b = true;
        }
    }

    public void e() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.apply();
            this.f2787b = true;
        }
    }
}
