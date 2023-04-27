package com.oppo.camera.ui.menu.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;
import androidx.fragment.app.c;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.ui.menu.CameraSwitchPreference;
import com.color.support.preference.ColorJumpPreference;
import com.color.support.preference.ColorListPreference;
import com.color.support.preference.ColorMarkPreference;
import com.color.support.preference.ColorPreferenceCategory;
import com.color.support.preference.ColorSwitchWithDividerPreference;
import com.heytap.compat.c.a;
import com.oppo.camera.MyApplication;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;

/* compiled from: CameraSubSettingFragment */
public class r extends b {
    private ColorSwitchWithDividerPreference A = null;
    private ColorSwitchWithDividerPreference B = null;
    private ColorMarkPreference C = null;
    private ColorMarkPreference D = null;
    private ColorMarkPreference E = null;
    private CameraSwitchPreference F = null;
    private CameraSwitchPreference G = null;
    private CameraSwitchPreference H = null;
    private CameraSwitchPreference I = null;
    private ColorListPreference J = null;
    private ColorListPreference K = null;
    private Preference L = null;
    private boolean M = false;
    private boolean N = true;
    private boolean O = true;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = true;
    private boolean S = false;
    private boolean T = false;
    private int U = 0;
    private boolean V = true;
    private boolean W = true;
    private boolean X = false;
    private BroadcastReceiver Y = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            e.b("CameraSubSettingFragment", "onReceive(), action: " + action);
            if ("android.intent.action.MEDIA_MOUNTED".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
                r.this.B();
            }
        }
    };
    private int g = 0;
    private k h = null;
    private PreferenceScreen i = null;
    private ColorPreferenceCategory j = null;
    private ColorPreferenceCategory k = null;
    private ColorPreferenceCategory l = null;
    private ColorPreferenceCategory m = null;
    private ColorPreferenceCategory n = null;
    private ColorPreferenceCategory o = null;
    private ColorPreferenceCategory p = null;
    private ColorPreferenceCategory q = null;
    private ColorPreferenceCategory r = null;
    private CameraSwitchPreference s = null;
    private CameraSwitchPreference t = null;
    private CameraSwitchPreference u = null;
    private CameraSwitchPreference v = null;
    private ColorJumpPreference w = null;
    private CameraSwitchPreference x = null;
    private CameraSwitchPreference y = null;
    private ColorSwitchWithDividerPreference z = null;

    /* access modifiers changed from: protected */
    public int k() {
        return 4;
    }

    public void a(Bundle bundle, String str) {
        super.a(bundle, str);
        ((MyApplication) getContext().getApplicationContext()).e();
        e.e("CameraSubSettingFragment", "onCreatePreferences");
        b((int) R.xml.camera_setting_sub_preferences);
        r();
        s();
    }

    private void r() {
        a().b((CharSequence) n());
        this.h = new k(m());
        this.h.a(m(), this.d);
        t();
        this.i = (PreferenceScreen) a((CharSequence) "camera_setting_advance_root_preference");
        this.L = a((CharSequence) "pref_bottom_line");
        this.j = (ColorPreferenceCategory) a((CharSequence) "pref_shutter_setting_function");
        this.k = (ColorPreferenceCategory) a((CharSequence) "pref_self_setting_function");
        this.l = (ColorPreferenceCategory) a((CharSequence) "pref_lens_dirty_detection_function");
        this.m = (ColorPreferenceCategory) a((CharSequence) "pref_other_setting_function");
        this.n = (ColorPreferenceCategory) a((CharSequence) "pref_watermark_function");
        this.o = (ColorPreferenceCategory) a((CharSequence) "pref_build_image_setting_function");
        this.p = (ColorPreferenceCategory) a((CharSequence) "pref_gradienter_setting_function");
        this.q = (ColorPreferenceCategory) a((CharSequence) "pref_video_sound_function");
        this.r = (ColorPreferenceCategory) a((CharSequence) "pref_video_sound_noise_function");
        this.u = (CameraSwitchPreference) a((CharSequence) "pref_mirror_key");
        this.v = (CameraSwitchPreference) a((CharSequence) "pref_lens_dirty_detection_key");
        this.x = (CameraSwitchPreference) a((CharSequence) "pref_camera_quick_launch_key");
        this.y = (CameraSwitchPreference) a((CharSequence) "pref_camera_storage_key");
        this.w = (ColorJumpPreference) a((CharSequence) "pref_camera_code_key");
        this.s = (CameraSwitchPreference) a((CharSequence) "pref_camera_tap_shutter_key");
        this.t = (CameraSwitchPreference) a((CharSequence) "pref_camera_gesture_shutter_key");
        this.B = (ColorSwitchWithDividerPreference) a((CharSequence) "pref_watermark_device");
        this.A = (ColorSwitchWithDividerPreference) a((CharSequence) "pref_watermark_time");
        this.z = (ColorSwitchWithDividerPreference) a((CharSequence) "pref_watermark_location");
        this.C = (ColorMarkPreference) a((CharSequence) "pref_video_sound_normal_key");
        this.D = (ColorMarkPreference) a((CharSequence) "pref_video_sound_panorama_key");
        this.E = (ColorMarkPreference) a((CharSequence) "pref_video_sound_focusing_key");
        this.F = (CameraSwitchPreference) a((CharSequence) "pref_video_noise_filter_key");
        this.J = (ColorListPreference) a((CharSequence) "pref_camera_line_photo");
        this.K = (ColorListPreference) a((CharSequence) "pref_camera_line_video");
        this.G = (CameraSwitchPreference) a((CharSequence) "pref_assist_gradienter");
        this.H = (CameraSwitchPreference) a((CharSequence) "pref_share_and_edit_key");
        this.I = (CameraSwitchPreference) a((CharSequence) "pref_10bits_heic_encode_key");
        this.A.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.z.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.B.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.s.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.t.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.u.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.v.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.x.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.y.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.w.a((Preference.c) new Preference.c() {
            public final boolean onPreferenceClick(Preference preference) {
                return r.this.onPreferenceClick(preference);
            }
        });
        this.C.a((Preference.c) new Preference.c() {
            public final boolean onPreferenceClick(Preference preference) {
                return r.this.onPreferenceClick(preference);
            }
        });
        this.D.a((Preference.c) new Preference.c() {
            public final boolean onPreferenceClick(Preference preference) {
                return r.this.onPreferenceClick(preference);
            }
        });
        this.E.a((Preference.c) new Preference.c() {
            public final boolean onPreferenceClick(Preference preference) {
                return r.this.onPreferenceClick(preference);
            }
        });
        this.F.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.J.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.K.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.G.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.H.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.I.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return r.this.onPreferenceChange(preference, obj);
            }
        });
        this.B.a((ColorSwitchWithDividerPreference.a) new ColorSwitchWithDividerPreference.a() {
            public void a() {
                r.this.a("oppo.intent.action.APP_SLOGAN_SETTING", 0);
            }
        });
        this.A.a((ColorSwitchWithDividerPreference.a) new ColorSwitchWithDividerPreference.a() {
            public void a() {
                r.this.a("oppo.intent.action.APP_SLOGAN_SETTING", 1);
            }
        });
        this.z.a((ColorSwitchWithDividerPreference.a) new ColorSwitchWithDividerPreference.a() {
            public void a() {
                if (r.this.h()) {
                    r.this.a("oppo.intent.action.APP_SLOGAN_SETTING", 2);
                }
            }
        });
        if (2 == this.U) {
            this.L.a((int) R.layout.slogan_preference_bottom_divider);
        }
    }

    private void s() {
        ColorPreferenceCategory colorPreferenceCategory;
        ColorPreferenceCategory colorPreferenceCategory2;
        ColorPreferenceCategory colorPreferenceCategory3;
        e.b("CameraSubSettingFragment", "addOrRemoveCameraPreference()");
        if (!(this.m == null || this.y == null)) {
            if (!z.b(false)) {
                this.m.d((Preference) this.y);
            } else if (this.m.d((CharSequence) "pref_camera_storage_key") == null) {
                this.m.c((Preference) this.y);
            }
        }
        if (this.U == 0) {
            a(this.k);
            a(this.l);
            a(this.m);
            if (!this.P && (colorPreferenceCategory3 = this.m) != null) {
                colorPreferenceCategory3.d((Preference) this.w);
            }
            if (!this.Q && (colorPreferenceCategory2 = this.m) != null) {
                colorPreferenceCategory2.d((Preference) this.I);
            }
            if (!this.O) {
                this.i.d((Preference) this.l);
            }
        } else {
            this.i.d((Preference) this.k);
            this.i.d((Preference) this.l);
            this.i.d((Preference) this.m);
        }
        if (1 != this.U) {
            this.i.d((Preference) this.j);
        }
        if (2 != this.U) {
            this.i.d((Preference) this.n);
        }
        if (3 != this.U) {
            this.i.d((Preference) this.q);
            this.i.d((Preference) this.r);
        } else if (!Util.q()) {
            this.i.d((Preference) this.r);
        }
        if (4 != this.U) {
            this.i.d((Preference) this.o);
            this.i.d((Preference) this.p);
        }
        this.n.d((Preference) this.z);
        if (!this.W && (colorPreferenceCategory = this.m) != null) {
            colorPreferenceCategory.d((Preference) this.x);
        }
    }

    private void a(ColorPreferenceCategory colorPreferenceCategory) {
        if (colorPreferenceCategory != null) {
            int i2 = 0;
            while (i2 < colorPreferenceCategory.c()) {
                Preference i3 = colorPreferenceCategory.i(i2);
                if (i3 != null && !CameraConfig.getSupportSettingMenuKey(i3.B())) {
                    colorPreferenceCategory.d(i3);
                    i2--;
                }
                i2++;
            }
            if (colorPreferenceCategory.c() == 0) {
                this.i.d((Preference) colorPreferenceCategory);
            }
        }
    }

    private void t() {
        k kVar = this.h;
        if (kVar != null && 2 == this.U) {
            String string = kVar.getString("pref_camera_slogan_version_key", (String) null);
            if (!"1.1.0".equals(string)) {
                String string2 = this.h.getString("pref_slogan_owner_key", (String) null);
                this.h.edit().putString("pref_camera_slogan_version_key", "1.1.0").putString("pref_slogan_customize_key", string2).putString("pref_slogan_owner_key", (String) null).putString("pref_video_slogan_customize_key", this.h.getString("pref_slogan_customize_key", "off")).putString("pref_slogan_device_key", this.h.getString("pref_camera_slogan_key", "off")).apply();
                e.b("CameraSubSettingFragment", "updateSloganFromOTA, preSloganVersion: " + string + ", currentVersion: " + "1.1.0");
            }
        }
    }

    public void onPause() {
        String str;
        super.onPause();
        k kVar = this.h;
        if (kVar != null && 2 == this.U) {
            boolean z2 = false;
            boolean z3 = "on".equals(kVar.getString("pref_slogan_device_key", getString(R.string.camera_slogan_default_value))) || "on".equals(this.h.getString("pref_slogan_location_key", getString(R.string.camera_slogan_default_value))) || "on".equals(this.h.getString("pref_slogan_time_key", getString(R.string.camera_slogan_default_value)));
            String string = this.h.getString("pref_video_slogan_device_key", getString(R.string.camera_slogan_default_value));
            String string2 = this.h.getString("pref_video_slogan_location_key", getString(R.string.camera_slogan_default_value));
            String string3 = this.h.getString("pref_video_slogan_time_key", getString(R.string.camera_slogan_default_value));
            if ("on".equals(string) || "on".equals(string2) || "on".equals(string3)) {
                z2 = true;
            }
            e.e("CameraSubSettingFragment", "isSloganEnable:" + z3 + ",isVideoSloganEnable:" + z2);
            SharedPreferences.Editor edit = this.h.edit();
            String str2 = "off";
            if (z3) {
                str = "on";
            } else {
                str = str2;
            }
            edit.putString("pref_camera_slogan_key", str);
            if (z2) {
                str2 = "on";
            }
            edit.putString("pref_camera_video_slogan_key", str2);
            edit.apply();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(Bundle bundle) {
        if (getActivity() == null || this.y == null || !bundle.getBoolean("key_storage_dialog_show", false)) {
            return super.a(bundle);
        }
        this.y.c();
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        super.b(bundle);
        CameraSwitchPreference cameraSwitchPreference = this.y;
        bundle.putBoolean("key_storage_dialog_show", cameraSwitchPreference != null && cameraSwitchPreference.e());
    }

    public void onDestroyView() {
        super.onDestroyView();
        k kVar = this.h;
        if (kVar != null) {
            kVar.a(m());
            this.h = null;
        }
        PreferenceScreen preferenceScreen = this.i;
        if (preferenceScreen != null) {
            preferenceScreen.d();
            this.i = null;
        }
        ColorPreferenceCategory colorPreferenceCategory = this.j;
        if (colorPreferenceCategory != null) {
            colorPreferenceCategory.d();
            this.j = null;
        }
        ColorPreferenceCategory colorPreferenceCategory2 = this.k;
        if (colorPreferenceCategory2 != null) {
            colorPreferenceCategory2.d();
            this.k = null;
        }
        if (this.v != null) {
            this.l.d();
            this.l = null;
        }
        ColorPreferenceCategory colorPreferenceCategory3 = this.m;
        if (colorPreferenceCategory3 != null) {
            colorPreferenceCategory3.d();
            this.m = null;
        }
        ColorPreferenceCategory colorPreferenceCategory4 = this.n;
        if (colorPreferenceCategory4 != null) {
            colorPreferenceCategory4.d();
            this.n = null;
        }
        ColorPreferenceCategory colorPreferenceCategory5 = this.o;
        if (colorPreferenceCategory5 != null) {
            colorPreferenceCategory5.d();
            this.o = null;
        }
        ColorPreferenceCategory colorPreferenceCategory6 = this.p;
        if (colorPreferenceCategory6 != null) {
            colorPreferenceCategory6.d();
            this.p = null;
        }
        ColorPreferenceCategory colorPreferenceCategory7 = this.r;
        if (colorPreferenceCategory7 != null) {
            colorPreferenceCategory7.d();
            this.r = null;
        }
        ColorPreferenceCategory colorPreferenceCategory8 = this.q;
        if (colorPreferenceCategory8 != null) {
            colorPreferenceCategory8.d();
            this.q = null;
        }
        CameraSwitchPreference cameraSwitchPreference = this.y;
        if (cameraSwitchPreference != null && cameraSwitchPreference.e()) {
            e.a("CameraSubSettingFragment", "onDestroyView, Storage Dialog dismiss");
            if (this.y.e()) {
                this.y.f();
            }
            this.y.d();
            this.y = null;
        }
        this.z = null;
        this.B = null;
        this.A = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.s = null;
        this.t = null;
        this.F = null;
        this.C = null;
        this.E = null;
        this.D = null;
        this.G = null;
        this.K = null;
        this.J = null;
        this.H = null;
        this.I = null;
    }

    public boolean onPreferenceClick(Preference preference) {
        if (((CameraSubSettingActivity) getActivity()) == null) {
            return false;
        }
        if ("pref_camera_code_key".equals(preference.B())) {
            a("pref_camera_code_key", (Object) null);
            a("oppo.intent.action.APP_CODE_SETTING");
        } else if (preference == this.C) {
            this.h.edit().putString(F(), VideoRecordMsgData.END_TYPE_NORMAL).apply();
            x();
        } else if (preference == this.D) {
            this.h.edit().putString(F(), ApsConstant.CAPTURE_MODE_PANORAMA).apply();
            x();
        } else if (preference == this.E) {
            this.h.edit().putString(F(), "focusing").apply();
            x();
        }
        return false;
    }

    private void a(String str) {
        a(str, 0);
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2) {
        m mVar = (m) getActivity();
        if (mVar != null) {
            mVar.b(true);
        }
        Intent intent = new Intent(str);
        Bundle bundle = new Bundle();
        bundle.putInt("pref_camera_id_key", this.d);
        bundle.putInt("camera_enter_type", this.c);
        bundle.putInt("camera_property_camera_id", this.e);
        bundle.putString("pref_camera_mode_key", this.f4186b);
        bundle.putBoolean("camera_enter_form_lock_screen", this.X);
        bundle.putInt("camera_slogan_setting_from", i2);
        intent.putExtra("camera_intent_data", bundle);
        startActivity(intent);
    }

    public String n() {
        c activity = getActivity();
        return activity != null ? activity.getTitle().toString() : "";
    }

    /* access modifiers changed from: protected */
    public void c(Bundle bundle) {
        e.e("CameraSubSettingFragment", "parseActivityArguments start");
        if (bundle != null) {
            this.N = bundle.getBoolean("pref_camera_tap_shutter_key", true);
            this.O = bundle.getBoolean("pref_lens_dirty_detection_key", true);
            this.R = bundle.getBoolean("key_is_capture_mode", true);
            this.S = bundle.getBoolean("KEY_CAMERA_MENU", true);
            this.T = bundle.getBoolean("camera_entry_from", false);
            this.U = bundle.getInt("camera_sub_setting_from");
            this.V = bundle.getBoolean("pref_assist_gradienter");
            this.P = bundle.getBoolean("pref_photo_codec_key");
            this.Q = bundle.getBoolean("pref_10bits_heic_encode_key");
            this.W = bundle.getBoolean("pref_camera_quick_launch_key", true);
            this.X = bundle.getBoolean("camera_enter_form_lock_screen", false);
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        CameraSwitchPreference cameraSwitchPreference;
        CameraSwitchPreference cameraSwitchPreference2 = this.u;
        if (cameraSwitchPreference2 != null) {
            this.u.e("on".equals(cameraSwitchPreference2.K().getString(this.u.B(), "off")));
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.v;
        if (cameraSwitchPreference3 != null) {
            this.v.e("on".equals(cameraSwitchPreference3.K().getString(this.v.B(), "on")));
        }
        if (this.x != null) {
            c activity = getActivity();
            if (activity != null) {
                this.g = Settings.Secure.getInt(activity.getContentResolver(), "com.oppo.camera quick launch", 0);
            }
            this.x.e(1 == this.g);
        }
        if (1 == this.U) {
            D();
            E();
        }
        if (this.U == 0) {
            B();
            C();
        }
        if (2 == this.U) {
            A();
            z();
            y();
        }
        if (3 == this.U) {
            x();
        }
        if (4 == this.U) {
            w();
            v();
            u();
        }
        if (this.H != null) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SHARE_EDIT_SUPPORT)) {
                this.H.e(false);
                this.H.a(false);
            } else {
                this.H.e("on".equals(this.H.K().getString(this.H.B(), "on")));
            }
        }
        if (this.Q && (cameraSwitchPreference = this.I) != null) {
            String string = cameraSwitchPreference.K().getString(this.I.B(), "on");
            this.I.e("on".equals(string));
            this.w.a(!"on".equals(string));
        }
    }

    private void u() {
        CameraSwitchPreference cameraSwitchPreference = this.G;
        if (cameraSwitchPreference != null) {
            this.G.e("on".equals(this.h.getString(cameraSwitchPreference.B(), "off")));
        }
    }

    private void v() {
        ColorListPreference colorListPreference = this.K;
        if (colorListPreference != null) {
            String string = this.h.getString(colorListPreference.B(), "off");
            this.K.c(c(this.K, string));
            this.K.a(string);
        }
    }

    private void w() {
        ColorListPreference colorListPreference = this.J;
        if (colorListPreference != null) {
            String string = this.h.getString(colorListPreference.B(), "off");
            this.J.c(c(this.J, string));
            this.J.a(string);
        }
    }

    private void x() {
        if (this.E != null && this.D != null && this.C != null && this.F != null) {
            String string = this.h.getString(F(), ApsConstant.CAPTURE_MODE_PANORAMA);
            String string2 = this.h.getString("pref_video_noise_filter_key", "off");
            this.C.e(VideoRecordMsgData.END_TYPE_NORMAL.equals(string));
            this.D.e(ApsConstant.CAPTURE_MODE_PANORAMA.equals(string));
            this.E.e("focusing".equals(string));
            this.F.e("on".equals(string2));
            this.F.a(!VideoRecordMsgData.END_TYPE_NORMAL.equals(string));
        }
    }

    private void y() {
        if (this.z != null) {
            boolean z2 = false;
            if (!Util.p(getActivity())) {
                this.z.e(false);
                this.h.edit().putString("pref_slogan_location_key", "off").putString("pref_video_slogan_location_key", "off").apply();
                return;
            }
            String string = this.h.getString("pref_slogan_location_key", getString(R.string.camera_slogan_default_value));
            String string2 = this.h.getString("pref_video_slogan_location_key", getString(R.string.camera_slogan_default_value));
            if ("on".equals(string) || "on".equals(string2)) {
                z2 = true;
            }
            this.z.e(z2);
            b(string, string2);
        }
    }

    private void z() {
        if (this.A != null) {
            String string = this.h.getString("pref_slogan_time_key", getString(R.string.camera_slogan_default_value));
            String string2 = this.h.getString("pref_video_slogan_time_key", getString(R.string.camera_slogan_default_value));
            this.A.e("on".equals(string) || "on".equals(string2));
            if ("on".equals(string) && "on".equals(string2)) {
                this.A.g((CharSequence) getString(R.string.camera_slogan_apply_all));
            } else if ("on".equals(string)) {
                this.A.g((CharSequence) getString(R.string.camera_slogan_apply_photo));
            } else if ("on".equals(string2)) {
                this.A.g((CharSequence) getString(R.string.camera_slogan_apply_video));
            } else {
                this.A.g((CharSequence) "");
            }
        }
    }

    private void A() {
        if (this.B != null) {
            String string = this.h.getString("pref_slogan_device_key", getString(R.string.camera_slogan_default_value));
            String string2 = this.h.getString("pref_video_slogan_device_key", getString(R.string.camera_slogan_default_value));
            this.B.e("on".equals(string) || "on".equals(string2));
            if ("on".equals(string) && "on".equals(string2)) {
                this.B.g((CharSequence) getString(R.string.camera_slogan_apply_all));
            } else if ("on".equals(string)) {
                this.B.g((CharSequence) getString(R.string.camera_slogan_apply_photo));
            } else if ("on".equals(string2)) {
                this.B.g((CharSequence) getString(R.string.camera_slogan_apply_video));
            } else {
                this.B.g((CharSequence) "");
            }
        }
    }

    /* access modifiers changed from: private */
    public void B() {
        e.b("CameraSubSettingFragment", "updateStoragePreference()");
        if (this.y != null) {
            if (this.m != null) {
                if (!z.b(false)) {
                    this.m.d((Preference) this.y);
                    return;
                }
                if (this.m.d((CharSequence) "pref_camera_storage_key") == null) {
                    this.y.a(true);
                    this.m.c((Preference) this.y);
                }
                if (!Util.K()) {
                    this.y.a(false);
                    this.y.c((Object) false);
                    return;
                }
            }
            if (!z.b(true) || 8.0d <= z.g()) {
                this.y.c((Object) false);
            } else {
                this.y.c((Object) true);
            }
            this.y.e("on".equals(this.y.K().getString(this.y.B(), "off")));
        }
    }

    private void C() {
        k kVar = this.h;
        if (kVar != null) {
            this.w.d(a(kVar.getString("pref_photo_codec_key", "JPEG"), this.h.getString("pref_video_codec_key", "H264")));
        }
    }

    private void D() {
        CameraSwitchPreference cameraSwitchPreference = this.s;
        if (cameraSwitchPreference != null) {
            this.s.e("on".equals(cameraSwitchPreference.K().getString(this.s.B(), "off")));
            this.s.a(this.N && (this.T || (this.R && this.S)));
        }
    }

    private void E() {
        CameraSwitchPreference cameraSwitchPreference = this.t;
        if (cameraSwitchPreference != null) {
            this.t.e("on".equals(cameraSwitchPreference.K().getString(this.t.B(), "off")));
            this.t.a(this.T || (this.R && this.S));
        }
    }

    private String a(String str, String str2) {
        String str3;
        if ("HEIF".equals(str)) {
            str3 = "" + getString(R.string.camera_setting_reference_line_photo) + ": " + "HEIF";
        } else {
            str3 = "" + getString(R.string.camera_setting_reference_line_photo) + ": " + "JPEG";
        }
        String str4 = str3 + "/";
        if ("H265".equals(str2)) {
            return str4 + getString(R.string.camera_setting_reference_line_video) + ": " + "H.265";
        }
        return str4 + getString(R.string.camera_setting_reference_line_video) + ": " + "H.264";
    }

    private String F() {
        return this.f ? "pref_sound_types_key_front" : "pref_sound_types_key_rear";
    }

    private static CharSequence c(Preference preference, Object obj) {
        String obj2 = obj.toString();
        if (!(preference instanceof ListPreference)) {
            return obj2;
        }
        ListPreference listPreference = (ListPreference) preference;
        int b2 = listPreference.b(obj2);
        return b2 >= 0 ? listPreference.l()[b2] : "";
    }

    /* access modifiers changed from: protected */
    public void p() {
        e.b("CameraSubSettingFragment", "installIntentFilterIfNeeded");
        c activity = getActivity();
        if (!this.M && activity != null) {
            this.M = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addDataScheme("file");
            activity.getApplicationContext().registerReceiver(this.Y, intentFilter, "oppo.permission.OPPO_COMPONENT_SAFE", (Handler) null);
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        c activity = getActivity();
        if (this.M && activity != null) {
            this.M = false;
            activity.getApplicationContext().unregisterReceiver(this.Y);
        }
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str;
        String str2;
        String str3;
        boolean z2 = false;
        if (preference == null) {
            return false;
        }
        if (!(preference instanceof ColorSwitchWithDividerPreference)) {
            super.b(preference, obj);
        }
        if (preference instanceof ColorListPreference) {
            ((ColorListPreference) preference).c(c(preference, obj));
        }
        if (preference == this.x) {
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                this.g = 1;
            } else {
                this.g = 0;
            }
            a.C0063a.a("com.oppo.camera quick launch", this.g);
        } else {
            String str4 = "on";
            if (preference == this.B) {
                if (obj instanceof Boolean) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                a("pref_slogan_device_key", (Object) z2 ? "model_on" : "model_off");
                SharedPreferences.Editor edit = this.h.edit();
                if (z2) {
                    str3 = str4;
                } else {
                    str3 = "off";
                }
                edit.putString("pref_slogan_device_key", str3);
                if (!z2) {
                    str4 = "off";
                }
                edit.putString("pref_video_slogan_device_key", str4);
                edit.apply();
                A();
            } else if (preference == this.A) {
                if (obj instanceof Boolean) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                a("pref_slogan_time_key", (Object) z2 ? "time_on" : "time_off");
                SharedPreferences.Editor edit2 = this.h.edit();
                if (z2) {
                    str2 = str4;
                } else {
                    str2 = "off";
                }
                edit2.putString("pref_slogan_time_key", str2);
                if (!z2) {
                    str4 = "off";
                }
                edit2.putString("pref_video_slogan_time_key", str4);
                edit2.apply();
                z();
            } else if (preference == this.z) {
                boolean booleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
                if (booleanValue && !h()) {
                    return false;
                }
                a("pref_slogan_location_key", (Object) booleanValue ? "location_on" : "location_off");
                SharedPreferences.Editor edit3 = this.h.edit();
                if (booleanValue) {
                    str = str4;
                } else {
                    str = "off";
                }
                edit3.putString("pref_slogan_location_key", str);
                if (!booleanValue) {
                    str4 = "off";
                }
                edit3.putString("pref_video_slogan_location_key", str4);
                edit3.apply();
                y();
            } else if (preference == this.I) {
                boolean booleanValue2 = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
                SharedPreferences.Editor edit4 = this.h.edit();
                if (booleanValue2) {
                    String string = this.h.getString("pref_photo_codec_key", "JPEG");
                    String string2 = this.h.getString("pref_video_codec_key", "H264");
                    edit4.putString("pref_photo_codec_backup_key", string);
                    edit4.putString("pref_video_codec_backup_key", string2);
                    edit4.putString("pref_photo_codec_key", "HEIF");
                    edit4.putString("pref_video_codec_key", "H265");
                    Toast.makeText(m(), String.format(getResources().getString(R.string.camera_codec_disable_tips), new Object[]{getResources().getString(R.string.camera_heic_encode_10bits_title), getResources().getString(R.string.camera_codec_title)}), 0).show();
                } else {
                    String string3 = this.h.getString("pref_photo_codec_backup_key", "JPEG");
                    String string4 = this.h.getString("pref_video_codec_backup_key", "H264");
                    edit4.putString("pref_photo_codec_key", string3);
                    edit4.putString("pref_video_codec_key", string4);
                }
                edit4.apply();
                C();
                ColorJumpPreference colorJumpPreference = this.w;
                if (!booleanValue2) {
                    z2 = true;
                }
                colorJumpPreference.a(z2);
            }
        }
        if (preference instanceof CameraSwitchPreference) {
            return ((CameraSwitchPreference) preference).onPreferenceChange(preference, obj);
        }
        return true;
    }

    public void i() {
        this.z.I();
    }

    public void j() {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putString("pref_slogan_location_key", "off");
        edit.putString("pref_video_slogan_location_key", "off");
        edit.apply();
        ColorSwitchWithDividerPreference colorSwitchWithDividerPreference = this.z;
        if (colorSwitchWithDividerPreference != null) {
            colorSwitchWithDividerPreference.e(false);
        }
        a("pref_slogan_device_key", (Object) "location_disagree");
    }

    /* access modifiers changed from: protected */
    public void l() {
        if (this.z != null && this.h != null && !Util.p(getActivity())) {
            SharedPreferences.Editor edit = this.h.edit();
            edit.putString("pref_slogan_location_key", "off");
            edit.putString("pref_video_slogan_location_key", "off");
            edit.apply();
            ColorSwitchWithDividerPreference colorSwitchWithDividerPreference = this.z;
            if (colorSwitchWithDividerPreference != null) {
                colorSwitchWithDividerPreference.e(false);
            }
            b(this.h.getString("pref_slogan_location_key", getString(R.string.camera_slogan_default_value)), this.h.getString("pref_video_slogan_location_key", getString(R.string.camera_slogan_default_value)));
            a("pref_slogan_device_key", (Object) "location_disagree");
        }
    }

    private void b(String str, String str2) {
        if ("on".equals(str) && "on".equals(str2)) {
            this.z.g((CharSequence) getString(R.string.camera_slogan_apply_all));
            this.z.a((CharSequence) "");
        } else if ("on".equals(str)) {
            this.z.g((CharSequence) getString(R.string.camera_slogan_apply_photo));
            this.z.a((CharSequence) "");
        } else if ("on".equals(str2)) {
            this.z.g((CharSequence) getString(R.string.camera_slogan_apply_video));
            this.z.a((CharSequence) "");
        } else {
            this.z.g((CharSequence) "");
            this.z.e((int) R.string.camera_slogan_location_tip);
        }
    }
}
