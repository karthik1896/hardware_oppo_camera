package com.oppo.camera.ui.menu.setting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.c;
import androidx.fragment.app.h;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.j;
import color.support.v7.app.b;
import com.android.ui.menu.CameraSwitchPreference;
import com.color.support.preference.ColorJumpPreference;
import com.color.support.preference.ColorListPreference;
import com.color.support.preference.ColorPreferenceCategory;
import com.heytap.compat.c.a;
import com.oppo.camera.MyApplication;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.f.a;
import com.oppo.camera.k;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: CameraSettingActivityFragment */
public class l extends b {
    private static final boolean g = Util.h("oplus.software.video.surround_record_support");
    private CameraSwitchPreference A = null;
    private ColorPreferenceCategory B = null;
    private ColorJumpPreference C = null;
    private ColorListPreference D = null;
    private ColorJumpPreference E = null;
    private ColorListPreference F = null;
    private CameraSwitchPreference G = null;
    private Preference H = null;
    private ColorPreferenceCategory I = null;
    private Preference J = null;
    private ColorPreferenceCategory K = null;
    private b L = null;
    private int M = 0;
    private String N = null;
    private String O = null;
    private String P = null;
    private boolean Q = true;
    private boolean R = true;
    private boolean S = true;
    private boolean T = false;
    private boolean U = false;
    private boolean V = true;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = true;
    private boolean Z = true;
    private boolean aa = false;
    private boolean ab = true;
    private boolean ac = true;
    private boolean ad = true;
    private boolean ae = true;
    private boolean af = true;
    private boolean ag = true;
    private boolean ah = true;
    private boolean ai = true;
    private boolean aj = true;
    private boolean ak = true;
    private boolean al = true;
    private boolean am = true;
    private boolean an = true;
    private boolean ao = true;
    private boolean ap = false;
    private boolean aq = false;
    private boolean ar = false;
    private k h = null;
    private PreferenceScreen i = null;
    private ColorPreferenceCategory j = null;
    private ColorListPreference k = null;
    private CameraSwitchPreference l = null;
    private CameraSwitchPreference m = null;
    private ColorJumpPreference n = null;
    private ColorJumpPreference o = null;
    private ColorJumpPreference p = null;
    private CameraSwitchPreference q = null;
    private CameraSwitchPreference r = null;
    private ColorPreferenceCategory s = null;
    private CameraSwitchPreference t = null;
    private CameraSwitchPreference u = null;
    private CameraSwitchPreference v = null;
    private ColorJumpPreference w = null;
    private CameraSwitchPreference x = null;
    private ColorJumpPreference y = null;
    private CameraSwitchPreference z = null;

    private void D() {
    }

    private void J() {
    }

    /* access modifiers changed from: protected */
    public int k() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public void p() {
    }

    /* access modifiers changed from: protected */
    public void q() {
    }

    public void a(Bundle bundle, String str) {
        super.a(bundle, str);
        e.b("SettingActivityFragment", "onCreatePreferences start");
        ((MyApplication) getContext().getApplicationContext()).e();
        b((int) R.xml.camera_setting_preferences);
        r();
        G();
    }

    public void onDestroyView() {
        e.b("SettingActivityFragment", "onDestroyView: " + this);
        b bVar = this.L;
        if (bVar != null && bVar.isShowing()) {
            e.a("SettingActivityFragment", "onDestroyView, mResetSettingDialog dismiss");
            this.L.dismiss();
        }
        this.L = null;
        Q();
        super.onDestroyView();
    }

    public String n() {
        c activity = getActivity();
        return activity != null ? activity.getTitle().toString() : "";
    }

    /* access modifiers changed from: protected */
    public boolean a(Bundle bundle) {
        if (getActivity() == null || !bundle.getBoolean("key_reset_dialog_show", false)) {
            return super.a(bundle);
        }
        a((Activity) getActivity());
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        super.b(bundle);
        b bVar = this.L;
        bundle.putBoolean("key_reset_dialog_show", bVar != null && bVar.isShowing());
    }

    /* access modifiers changed from: protected */
    public void c(Bundle bundle) {
        e.b("SettingActivityFragment", "parseActivityArguments start");
        if (bundle != null) {
            this.Q = bundle.getBoolean("pref_camera_tap_shutter_key", true);
            this.R = bundle.getBoolean("pref_lens_dirty_detection_key", true);
            this.S = bundle.getBoolean("pref_camera_gesture_shutter_key", true);
            this.N = bundle.getString("pref_camera_photo_ratio_key", (String) null);
            this.V = bundle.getBoolean("key_is_capture_mode", true);
            this.W = bundle.getBoolean("key_is_video_mode", false);
            this.X = !TextUtils.isEmpty(bundle.getString("pref_camera_mode_key", (String) null));
            this.Y = bundle.getBoolean("pref_ai_scene_key", true);
            this.Z = bundle.getBoolean("pref_super_clear_portrait", false);
            this.aa = bundle.getBoolean("pref_face_rectify_key", false);
            this.ad = bundle.getBoolean("pref_raw_key", true);
            this.ae = bundle.getBoolean("pref_assist_gradienter", true);
            this.ac = bundle.getBoolean(this.W ? "pref_camera_video_slogan_key" : "pref_camera_slogan_key", true);
            this.O = bundle.getString("key_full_pic_size_type");
            this.af = bundle.getBoolean("pref_time_lapse_key");
            this.ag = bundle.getBoolean("key_high_picture_size");
            this.M = bundle.getInt("pref_video_fps_key", 0);
            this.ah = bundle.getBoolean("key_support_video_high_fps");
            this.ai = this.c == 1;
            this.aq = bundle.getBoolean("camera_enter_form_lock_screen", false);
            this.ab = bundle.getBoolean("pref_inertial_zoom_key", true);
            this.T = bundle.getBoolean("pref_photo_codec_key", true);
            this.U = bundle.getBoolean("pref_10bits_heic_encode_key", true);
            this.ak = bundle.getBoolean("pref_slow_video_size_key", true);
            this.aj = bundle.getBoolean("pref_video_ratio_key", true) && bundle.getBoolean("pref_video_size_fps_settings", true);
            this.al = bundle.getBoolean("pref_video_sound_key", true);
            this.am = bundle.getBoolean("pref_video_codec_key", true);
            this.an = bundle.getBoolean("pref_camera_quick_launch_key", true);
            this.P = bundle.getString("pref_video_size_key", (String) null);
            this.ao = bundle.getBoolean("key_support_slow_video_h265");
            this.ar = bundle.getBoolean("pref_qr_code_key", false);
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean onPreferenceChange(Preference preference, Object obj) {
        boolean z2 = false;
        if (preference == null) {
            return false;
        }
        super.b(preference, obj);
        if (preference instanceof ColorListPreference) {
            ((ColorListPreference) preference).c(c(preference, obj));
        }
        if (preference == this.G) {
            if ("false".equals(String.valueOf(obj))) {
                SharedPreferences.Editor edit = this.h.edit();
                edit.putString("pref_video_super_eis_key", "off");
                edit.putString("pref_video_fps_key", String.valueOf(60));
                edit.putString("pref_video_size_key", "video_size_1080p");
                edit.apply();
                I();
            }
        } else if (preference == this.m) {
            if (obj instanceof Boolean) {
                z2 = ((Boolean) obj).booleanValue();
            }
            if (z2) {
                return h();
            }
        } else {
            ColorListPreference colorListPreference = this.F;
            if (preference == colorListPreference) {
                String o2 = colorListPreference.o();
                String valueOf = String.valueOf(obj);
                if (!k.a("pref_slow_video_size_key")) {
                    this.h.edit().putString("pref_slow_video_size_key", valueOf).apply();
                }
                if (!a.c(this.d)) {
                    if (!"video_size_1080p".equals(o2) && "video_size_1080p".equals(valueOf)) {
                        this.h.edit().putInt("pref_slow_video_rear_fps_key", CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE)).apply();
                    } else if (!"video_size_720p".equals(o2) && "video_size_720p".equals(valueOf)) {
                        this.h.edit().putInt("pref_slow_video_rear_fps_key", CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE)).apply();
                    }
                }
            }
        }
        if (preference == this.D) {
            SharedPreferences.Editor edit2 = this.h.edit();
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && "H264".equals(String.valueOf(obj))) {
                edit2.putString("key_video_hdr", "off");
            }
            edit2.putString("pref_lasted_video_codec", "");
            edit2.apply();
        }
        if (preference instanceof CameraSwitchPreference) {
            return ((CameraSwitchPreference) preference).onPreferenceChange(preference, obj);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void o() {
        w();
        y();
        A();
        D();
    }

    public void b(Preference preference) {
        h fragmentManager = getFragmentManager();
        if (fragmentManager != null && fragmentManager.a("androidx.preference.PreferenceFragment.DIALOG") == null) {
            androidx.fragment.app.b bVar = null;
            if (!(preference instanceof CameraCustomListPreference)) {
                super.b(preference);
            } else if ("pref_sound_types_key_rear".equals(preference.B()) || "pref_sound_types_key_front".equals(preference.B())) {
                bVar = u.a(preference.B(), this.f4186b, this.d, this.e);
            } else {
                bVar = e.a(preference.B());
            }
            if (bVar != null) {
                bVar.setTargetFragment(this, 0);
                bVar.show(fragmentManager, "androidx.preference.PreferenceFragment.DIALOG");
            }
        }
    }

    private void r() {
        this.h = new k(m());
        this.h.a(m(), this.d);
        this.i = (PreferenceScreen) a((CharSequence) "camera_setting_menu_root_preference");
        s();
        t();
        u();
        v();
    }

    private void s() {
        this.j = (ColorPreferenceCategory) a((CharSequence) "pref_common_function");
        this.k = (ColorListPreference) a((CharSequence) "pref_volume_key_function_key");
        this.l = (CameraSwitchPreference) a((CharSequence) "pref_camera_sound_key");
        this.m = (CameraSwitchPreference) a((CharSequence) "pref_camera_recordlocation_key");
        this.n = (ColorJumpPreference) a((CharSequence) "pref_watermark_setting_key");
        this.q = (CameraSwitchPreference) a((CharSequence) "pref_camera_fingerprint_shutter_key");
        this.k.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return l.this.onPreferenceChange(preference, obj);
            }
        });
        this.l.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return l.this.onPreferenceChange(preference, obj);
            }
        });
        this.m.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return l.this.onPreferenceChange(preference, obj);
            }
        });
        this.n.a((Preference.c) new Preference.c() {
            public final boolean onPreferenceClick(Preference preference) {
                return l.this.onPreferenceClick(preference);
            }
        });
        this.q.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return l.this.onPreferenceChange(preference, obj);
            }
        });
    }

    private void t() {
        this.s = (ColorPreferenceCategory) a((CharSequence) "pref_capture_function");
        this.t = (CameraSwitchPreference) a((CharSequence) "pref_ai_scene_key");
        this.u = (CameraSwitchPreference) a((CharSequence) "pref_super_clear_portrait");
        this.v = (CameraSwitchPreference) a((CharSequence) "pref_face_rectify_key");
        this.x = (CameraSwitchPreference) a((CharSequence) "pref_raw_key");
        this.o = (ColorJumpPreference) a((CharSequence) "pref_advance_setting_key");
        this.p = (ColorJumpPreference) a((CharSequence) "pref_build_image_setting_key");
        this.y = (ColorJumpPreference) a((CharSequence) "pref_photo_slogan_key");
        this.r = (CameraSwitchPreference) a((CharSequence) "pref_qr_code_key");
        ColorJumpPreference colorJumpPreference = this.o;
        if (colorJumpPreference != null) {
            colorJumpPreference.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
        }
        ColorJumpPreference colorJumpPreference2 = this.p;
        if (colorJumpPreference2 != null) {
            colorJumpPreference2.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
        }
        CameraSwitchPreference cameraSwitchPreference = this.t;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.u;
        if (cameraSwitchPreference2 != null) {
            cameraSwitchPreference2.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.v;
        if (cameraSwitchPreference3 != null) {
            cameraSwitchPreference3.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
        }
        ColorJumpPreference colorJumpPreference3 = this.y;
        if (colorJumpPreference3 != null) {
            colorJumpPreference3.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
        }
        CameraSwitchPreference cameraSwitchPreference4 = this.x;
        if (cameraSwitchPreference4 != null) {
            cameraSwitchPreference4.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
            this.x.a(this.ad);
        }
        CameraSwitchPreference cameraSwitchPreference5 = this.r;
        if (cameraSwitchPreference5 != null) {
            cameraSwitchPreference5.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
        }
    }

    private void u() {
        this.A = (CameraSwitchPreference) a((CharSequence) "pref_inertial_zoom_key");
        this.z = (CameraSwitchPreference) a((CharSequence) "pref_track_focus_key");
        this.B = (ColorPreferenceCategory) a((CharSequence) "pref_video_function");
        this.C = (ColorJumpPreference) a((CharSequence) "pref_video_ratio_key");
        this.D = (ColorListPreference) a((CharSequence) "pref_video_codec_key");
        this.F = (ColorListPreference) a((CharSequence) "pref_slow_video_size_key");
        this.G = (CameraSwitchPreference) a((CharSequence) "pref_video_sell_eis");
        this.w = (ColorJumpPreference) a((CharSequence) "pref_shutter_help_key");
        this.E = (ColorJumpPreference) a((CharSequence) "pref_video_sound_key");
        ColorJumpPreference colorJumpPreference = this.w;
        if (colorJumpPreference != null) {
            colorJumpPreference.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
        }
        CameraSwitchPreference cameraSwitchPreference = this.A;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
            this.A.a(this.ab);
        }
        ColorJumpPreference colorJumpPreference2 = this.C;
        if (colorJumpPreference2 != null) {
            colorJumpPreference2.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
            this.C.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
            this.C.a(this.aj);
        }
        ColorListPreference colorListPreference = this.F;
        if (colorListPreference != null) {
            colorListPreference.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
            this.F.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
            this.F.a(this.ak);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO) && !this.h.d("pref_slow_video_size_key")) {
                SharedPreferences.Editor edit = this.h.edit();
                edit.putString("pref_slow_video_size_key", c(this.d));
                edit.apply();
            }
        }
        ColorListPreference colorListPreference2 = this.D;
        if (colorListPreference2 != null) {
            colorListPreference2.c((CharSequence[]) getResources().getStringArray(R.array.video_codec_summaries));
            this.D.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
            this.D.a(this.am);
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.G;
        if (cameraSwitchPreference2 != null) {
            cameraSwitchPreference2.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
        }
        if (g) {
            this.E.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
        }
    }

    private void v() {
        this.I = (ColorPreferenceCategory) a((CharSequence) "pref_help_and_feedback_function");
        this.H = a((CharSequence) "pref_restore_key");
        this.J = a((CharSequence) "pref_help_and_feedback_key");
        Preference preference = this.H;
        if (preference != null) {
            preference.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
            this.H.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
        }
        if (this.J != null) {
            if (((CameraSettingActivity) getActivity()).n()) {
                this.J.a(false);
            }
            this.J.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return l.this.onPreferenceClick(preference);
                }
            });
            this.J.a((Preference.b) new Preference.b() {
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return l.this.onPreferenceChange(preference, obj);
                }
            });
        }
    }

    private void w() {
        ColorListPreference colorListPreference = this.k;
        if (colorListPreference != null) {
            String string = colorListPreference.K().getString(this.k.B(), getString(R.string.camera_volume_key_function_default_value));
            this.k.c(c(this.k, string));
            this.k.a(string);
        }
        CameraSwitchPreference cameraSwitchPreference = this.l;
        if (cameraSwitchPreference != null) {
            this.l.e("on".equals(cameraSwitchPreference.K().getString(this.l.B(), "off")));
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.m;
        if (cameraSwitchPreference2 != null) {
            this.m.e("on".equals(cameraSwitchPreference2.K().getString(this.m.B(), "off")) && Util.p(getActivity()));
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.q;
        if (cameraSwitchPreference3 != null) {
            this.q.e("on".equals(cameraSwitchPreference3.K().getString(this.q.B(), getString(R.string.camera_fingerprint_capture_default_value))));
        }
        ColorJumpPreference colorJumpPreference = this.n;
        if (colorJumpPreference != null) {
            colorJumpPreference.d(getString(x() ? R.string.camera_slogan_assignment_on : R.string.camera_slogan_assignment_off));
        }
    }

    private boolean x() {
        boolean z2 = "on".equals(this.h.getString("pref_slogan_device_key", getString(R.string.camera_slogan_default_value))) || ("on".equals(this.h.getString("pref_slogan_location_key", getString(R.string.camera_slogan_default_value))) && Util.p(getActivity())) || "on".equals(this.h.getString("pref_slogan_time_key", getString(R.string.camera_slogan_default_value)));
        boolean z3 = "on".equals(this.h.getString("pref_video_slogan_device_key", getString(R.string.camera_slogan_default_value))) || ("on".equals(this.h.getString("pref_video_slogan_location_key", getString(R.string.camera_slogan_default_value))) && Util.p(getActivity())) || "on".equals(this.h.getString("pref_video_slogan_time_key", getString(R.string.camera_slogan_default_value)));
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    private void y() {
        N();
        O();
        P();
        K();
        L();
        J();
        z();
        E();
    }

    private void z() {
        if (this.y != null) {
            this.y.a(this.ac && (((CameraSettingActivity) getActivity()).l() || (this.V && this.X)));
        }
    }

    private void A() {
        I();
        C();
        F();
        B();
    }

    private void B() {
        if (this.D != null) {
            String str = "H264";
            if (this.ao) {
                str = this.h.getString("pref_video_codec_key", str);
            }
            this.D.c(c(this.D, str));
            this.D.a(str);
            this.D.a(this.ao);
        }
    }

    private void C() {
        if (this.F != null) {
            String a2 = this.h.a("pref_slow_video_size_key", c(this.d));
            this.F.c(c(this.F, a2));
            this.F.a(a2);
            this.F.a(this.ak);
        }
    }

    private void E() {
        CameraSwitchPreference cameraSwitchPreference = this.r;
        if (cameraSwitchPreference != null) {
            this.r.e("on".equals(cameraSwitchPreference.K().getString(this.r.B(), "off")));
            this.r.a(this.ai && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_QR_CODE_ENABLE) && this.ar);
        }
    }

    private void F() {
        if (this.E == null) {
            return;
        }
        if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(this.f4186b) || "movie".equals(this.f4186b) || ApsConstant.REC_MODE_FAST_VIDEO.equals(this.f4186b) || !this.al) {
            this.E.a(false);
            this.E.d(getString(R.string.camera_video_normal_sound));
            return;
        }
        String string = this.h.getString(this.f ? "pref_sound_types_key_front" : "pref_sound_types_key_rear", ApsConstant.CAPTURE_MODE_PANORAMA);
        this.E.a(true);
        if (VideoRecordMsgData.END_TYPE_NORMAL.equals(string)) {
            this.E.d(getString(R.string.camera_video_normal_sound));
        } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(string)) {
            this.E.d(getString(R.string.camera_video_panorama_sound));
        } else if ("focusing".equals(string)) {
            this.E.d(getString(R.string.camera_video_focusing_sound));
        }
    }

    private void G() {
        ColorJumpPreference colorJumpPreference;
        e.b("SettingActivityFragment", "addOrRemoveCameraPreference()");
        if (this.B != null) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT)) {
                this.B.d((Preference) this.z);
            }
            if (!H()) {
                this.B.d((Preference) this.F);
            }
            if (this.T) {
                this.B.d((Preference) this.D);
            }
            this.B.c((CharSequence) this.f ? "pref_sound_types_key_rear" : "pref_sound_types_key_front");
            if (!g && (colorJumpPreference = this.E) != null) {
                this.B.d((Preference) colorJumpPreference);
            }
            this.B.d((Preference) this.G);
        }
        if (this.s != null) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                this.s.d((Preference) this.t);
            }
            com.oppo.camera.w.b.a(this.i, this.I);
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_RECTIFY_SUPPORT)) {
                this.s.d((Preference) this.v);
            }
        }
        if (!(this.j == null || this.s == null)) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_SUPPORT)) {
                this.j.d((Preference) this.n);
            } else {
                this.s.d((Preference) this.y);
            }
        }
        a(this.j);
        a(this.s);
        a(this.B);
        a(this.I);
        a(this.K);
    }

    private boolean H() {
        boolean z2 = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOWVIDEO_1080P) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO);
        CharSequence[] m2 = this.F.m();
        CharSequence[] l2 = this.F.l();
        if (a.c(this.d) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_720P_SLOW_VIDEO)) {
            ArrayList arrayList = new ArrayList(Arrays.asList(m2));
            arrayList.remove("video_size_720p");
            ArrayList arrayList2 = new ArrayList(Arrays.asList(l2));
            arrayList2.remove(getString(R.string.camera_video_size_720p));
            this.F.b((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
            this.F.a((CharSequence[]) arrayList2.toArray(new CharSequence[arrayList2.size()]));
        }
        int length = this.F.m().length;
        if (!z2 || length <= 1) {
            return false;
        }
        return true;
    }

    private void I() {
        k kVar = this.h;
        if (kVar != null) {
            String string = kVar.getString("pref_video_size_key", CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", this.d));
            String string2 = this.h.getString("pref_video_fps_key", getString(R.string.camera_video_default_fps));
            if (!this.aj) {
                String str = this.P;
                if (str != null) {
                    string = str;
                }
                int i2 = this.M;
                if (i2 != 0) {
                    string2 = String.valueOf(i2);
                }
            }
            this.C.d(b(string) + ("/" + c(string2)));
            boolean equals = "on".equals(this.h.getString("pref_video_super_eis_key", "off"));
            boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS_FPS_SETTING_SUPPORT);
            if (!this.ai && !this.V && this.X) {
                this.C.a(false);
            } else if (!this.ai || this.V || !this.X || !equals || a.c(this.d) || configBooleanValue) {
                this.C.a(this.aj);
            } else {
                this.C.d(b(string));
                this.C.a(false);
            }
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
        }
    }

    private void K() {
        k kVar;
        CameraSwitchPreference cameraSwitchPreference = this.t;
        if (cameraSwitchPreference != null) {
            this.t.e("on".equals(cameraSwitchPreference.K().getString(this.t.B(), "off")));
            this.t.a(this.Y && (((CameraSettingActivity) getActivity()).l() || (this.V && this.X)));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && (kVar = this.h) != null) {
            this.h.edit().putString("pref_ai_scene_key", kVar.getString("pref_camera_pi_ai_mode_key", getResources().getString(R.string.camera_pi_ai_default_value))).apply();
        }
    }

    private void L() {
        CameraSwitchPreference cameraSwitchPreference = this.u;
        if (cameraSwitchPreference != null) {
            this.u.e("on".equals(cameraSwitchPreference.K().getString(this.u.B(), "off")));
            this.u.a(this.Z && (((CameraSettingActivity) getActivity()).l() || (this.V && this.X)));
        }
    }

    private void M() {
        if (this.h != null) {
            String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_FACE_RECTIFY_CONFIG_VALUE);
            String string = this.h.getString("pref_facerectify_set_default_value", "");
            if (!TextUtils.isEmpty(configStringValue) && TextUtils.isEmpty(string)) {
                this.h.edit().putString("pref_face_rectify_key", configStringValue).putString("pref_facerectify_set_default_value", "1").apply();
            }
        }
    }

    private void N() {
        if (this.v != null) {
            M();
            this.v.e("on".equals(this.v.K().getString(this.v.B(), "off")));
            this.v.a(this.aa && (((CameraSettingActivity) getActivity()).l() || (this.V && this.X)));
        }
    }

    private void O() {
        CameraSwitchPreference cameraSwitchPreference = this.z;
        if (cameraSwitchPreference != null) {
            this.z.e("on".equals(cameraSwitchPreference.K().getString(this.z.B(), "off")));
            if (this.h != null && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_4K_TRACK_FOCUS_SUPPORT)) {
                this.z.a(!"video_size_4kuhd".equals(this.h.getString("pref_video_size_key", (String) null)));
            }
        }
    }

    private void P() {
        CameraSwitchPreference cameraSwitchPreference = this.A;
        if (cameraSwitchPreference != null) {
            this.A.e("on".equals(cameraSwitchPreference.K().getString(this.A.B(), "off")));
        }
    }

    private void Q() {
        e.b("SettingActivityFragment", "releasePreferences");
        CameraSwitchPreference cameraSwitchPreference = this.m;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.d();
            this.m = null;
        }
        ColorPreferenceCategory colorPreferenceCategory = this.j;
        if (colorPreferenceCategory != null) {
            colorPreferenceCategory.d();
            this.j = null;
        }
        this.k = null;
        this.l = null;
        this.o = null;
        this.p = null;
        this.n = null;
        this.q = null;
        ColorPreferenceCategory colorPreferenceCategory2 = this.s;
        if (colorPreferenceCategory2 != null) {
            colorPreferenceCategory2.d();
            this.s = null;
        }
        this.t = null;
        this.u = null;
        this.x = null;
        this.w = null;
        this.y = null;
        ColorPreferenceCategory colorPreferenceCategory3 = this.B;
        if (colorPreferenceCategory3 != null) {
            colorPreferenceCategory3.d();
            this.B = null;
        }
        this.C = null;
        this.F = null;
        this.E = null;
        this.D = null;
        PreferenceScreen preferenceScreen = this.i;
        if (preferenceScreen != null) {
            preferenceScreen.d();
            this.i = null;
        }
        k kVar = this.h;
        if (kVar != null) {
            kVar.a(m());
            this.h = null;
        }
        this.H = null;
        ColorPreferenceCategory colorPreferenceCategory4 = this.I;
        if (colorPreferenceCategory4 != null) {
            colorPreferenceCategory4.d();
            this.I = null;
        }
        this.J = null;
        this.K = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onPreferenceClick(androidx.preference.Preference r15) {
        /*
            r14 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onPreferenceClick, key: "
            r0.append(r1)
            java.lang.String r1 = r15.B()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "SettingActivityFragment"
            com.oppo.camera.e.b(r1, r0)
            androidx.fragment.app.c r0 = r14.getActivity()
            com.oppo.camera.ui.menu.setting.CameraSettingActivity r0 = (com.oppo.camera.ui.menu.setting.CameraSettingActivity) r0
            r1 = 0
            if (r0 != 0) goto L_0x0024
            return r1
        L_0x0024:
            java.lang.String r2 = r15.B()
            r3 = -1
            int r4 = r2.hashCode()
            r5 = 3
            r6 = 2
            r7 = 4
            java.lang.String r8 = "pref_help_and_feedback_key"
            java.lang.String r9 = "pref_watermark_setting_key"
            java.lang.String r10 = "pref_shutter_help_key"
            java.lang.String r11 = "pref_build_image_setting_key"
            java.lang.String r12 = "pref_advance_setting_key"
            r13 = 1
            switch(r4) {
                case -1760868457: goto L_0x0088;
                case -958952174: goto L_0x007e;
                case -731027105: goto L_0x0076;
                case -513186997: goto L_0x006c;
                case 193590031: goto L_0x0064;
                case 249158521: goto L_0x005c;
                case 564362055: goto L_0x0051;
                case 860391471: goto L_0x0049;
                case 1624357455: goto L_0x003f;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0090
        L_0x003f:
            java.lang.String r4 = "pref_video_sound_key"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0090
            r2 = 7
            goto L_0x0091
        L_0x0049:
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x0090
            r2 = r6
            goto L_0x0091
        L_0x0051:
            java.lang.String r4 = "pref_photo_slogan_key"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0090
            r2 = 8
            goto L_0x0091
        L_0x005c:
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x0090
            r2 = 6
            goto L_0x0091
        L_0x0064:
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x0090
            r2 = r5
            goto L_0x0091
        L_0x006c:
            java.lang.String r4 = "pref_video_ratio_key"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0090
            r2 = r13
            goto L_0x0091
        L_0x0076:
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x0090
            r2 = 5
            goto L_0x0091
        L_0x007e:
            java.lang.String r4 = "pref_restore_key"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0090
            r2 = r1
            goto L_0x0091
        L_0x0088:
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0090
            r2 = r7
            goto L_0x0091
        L_0x0090:
            r2 = r3
        L_0x0091:
            r3 = 0
            java.lang.String r4 = "oppo.intent.action.APP_SUB_SETTING"
            switch(r2) {
                case 0: goto L_0x00f4;
                case 1: goto L_0x00eb;
                case 2: goto L_0x00d0;
                case 3: goto L_0x00c6;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00b2;
                case 6: goto L_0x00a8;
                case 7: goto L_0x00a1;
                case 8: goto L_0x0098;
                default: goto L_0x0097;
            }
        L_0x0097:
            goto L_0x00f7
        L_0x0098:
            r0.b(r13)
            java.lang.String r0 = "oppo.intent.action.APP_PHOTO_SLOGAN_SETTING"
            r14.a((java.lang.String) r0)
            goto L_0x00f7
        L_0x00a1:
            r0.b(r13)
            r14.a((java.lang.String) r4, (int) r5)
            goto L_0x00f7
        L_0x00a8:
            r0.b(r13)
            r14.a((java.lang.String) r9, (java.lang.Object) r3)
            r14.a((java.lang.String) r4, (int) r6)
            goto L_0x00f7
        L_0x00b2:
            r0.b(r13)
            r14.a((java.lang.String) r11, (java.lang.Object) r3)
            r14.a((java.lang.String) r4, (int) r7)
            goto L_0x00f7
        L_0x00bc:
            r0.b(r13)
            r14.a((java.lang.String) r12, (java.lang.Object) r3)
            r14.a((java.lang.String) r4, (int) r1)
            goto L_0x00f7
        L_0x00c6:
            r0.b(r13)
            r14.a((java.lang.String) r10, (java.lang.Object) r3)
            r14.a((java.lang.String) r4, (int) r13)
            goto L_0x00f7
        L_0x00d0:
            com.oppo.camera.k r0 = r14.h
            java.lang.String r2 = "pref_allow_network_access"
            boolean r0 = r0.getBoolean(r2, r1)
            if (r0 != 0) goto L_0x00de
            r14.h()
            goto L_0x00f7
        L_0x00de:
            java.lang.String r0 = ""
            r14.a((java.lang.String) r8, (java.lang.Object) r0)
            androidx.fragment.app.c r0 = r14.getActivity()
            com.oppo.camera.w.a.a(r0)
            goto L_0x00f7
        L_0x00eb:
            r0.b(r13)
            java.lang.String r0 = "oppo.intent.action.APP_VIDEO_RATIO_SETTING"
            r14.a((java.lang.String) r0)
            goto L_0x00f7
        L_0x00f4:
            r14.a((android.app.Activity) r0)
        L_0x00f7:
            com.color.support.preference.ColorJumpPreference r0 = r14.E
            if (r0 == 0) goto L_0x011e
            if (r15 != r0) goto L_0x011e
            androidx.fragment.app.c r15 = r14.getActivity()
            com.oppo.camera.ui.menu.setting.CameraSettingActivity r15 = (com.oppo.camera.ui.menu.setting.CameraSettingActivity) r15
            boolean r15 = r15.m()
            if (r15 == 0) goto L_0x011e
            androidx.fragment.app.c r15 = r14.getActivity()
            com.oppo.camera.ui.menu.setting.CameraSettingActivity r15 = (com.oppo.camera.ui.menu.setting.CameraSettingActivity) r15
            boolean r15 = r15.k()
            if (r15 == 0) goto L_0x011e
            androidx.fragment.app.c r15 = r14.getActivity()
            com.oppo.camera.ui.menu.setting.CameraSettingActivity r15 = (com.oppo.camera.ui.menu.setting.CameraSettingActivity) r15
            r15.b(r13)
        L_0x011e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.setting.l.onPreferenceClick(androidx.preference.Preference):boolean");
    }

    private void a(Activity activity) {
        b bVar = this.L;
        if (bVar != null && bVar.isShowing()) {
            this.L.dismiss();
        }
        this.L = new b.a(activity).f(1).setNeutralButton((CharSequence) getString(R.string.camera_setting_restore_default), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                l.this.R();
                l.this.a("pref_restore_key", (Object) true);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                l.this.a("pref_restore_key", (Object) false);
                dialogInterface.dismiss();
            }
        }).create();
        if (!activity.isFinishing()) {
            this.L.show();
        }
    }

    /* access modifiers changed from: private */
    public void R() {
        c activity = getActivity();
        if (activity != null) {
            this.h.edit().putString("pref_lasted_video_codec", "").apply();
            if (!this.f) {
                S();
            }
            T();
            U();
            V();
            j.a((Context) activity, (int) R.xml.camera_setting_preferences, true);
            if (g) {
                SharedPreferences.Editor edit = j.a((Context) getActivity()).edit();
                edit.putString("pref_video_noise_filter_key", "on");
                edit.apply();
            }
            o();
            return;
        }
        e.e("SettingActivityFragment", "restore Camera settings failed, due to activity is null!");
    }

    private void S() {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putString("pref_video_super_eis_key", "off");
        edit.putBoolean("pref_lasted_video_save_status", false);
        edit.putBoolean("pref_super_eis_wide_key", false);
        edit.apply();
    }

    private void T() {
        a.C0063a.a("com.oppo.camera quick launch", 0);
        SharedPreferences.Editor edit = this.h.edit();
        edit.remove(this.k.B());
        edit.remove(this.l.B());
        edit.remove(this.m.B());
        edit.remove("pref_mirror_key");
        edit.remove("pref_lens_dirty_detection_key");
        edit.remove("pref_camera_quick_launch_key");
        edit.remove("pref_camera_storage_key");
        edit.remove("pref_share_and_edit_key");
        edit.remove("pref_camera_tap_shutter_key");
        edit.remove("pref_camera_gesture_shutter_key");
        edit.remove("pref_camera_assistant_line_key");
        edit.remove("pref_qr_code_key");
        edit.remove(this.t.B());
        edit.remove(this.u.B());
        edit.remove(this.v.B());
        edit.remove(this.y.B());
        edit.remove("pref_video_slogan_key");
        edit.remove("pref_camera_slogan_key");
        edit.remove("pref_camera_video_slogan_key");
        edit.remove(this.z.B());
        edit.remove(this.A.B());
        edit.remove("pref_slogan_customize_key");
        edit.remove("pref_video_slogan_customize_key");
        edit.remove("pref_slogan_time_key");
        edit.remove("pref_video_slogan_time_key");
        edit.remove("pref_slogan_location_key");
        edit.remove("pref_video_slogan_location_key");
        edit.remove("pref_slogan_device_key");
        edit.remove("pref_video_slogan_device_key");
        edit.remove("pref_raw_key");
        edit.remove(this.F.B());
        edit.remove("pref_photo_codec_key");
        edit.remove("pref_video_codec_key");
        edit.remove("pref_sound_types_key_rear");
        edit.remove("pref_sound_types_key_front");
        edit.remove(this.J.B());
        edit.remove("pref_camera_line_photo");
        edit.remove("pref_camera_line_video");
        edit.remove("pref_assist_gradienter");
        edit.remove("pref_camera_fingerprint_shutter_key");
        edit.remove("pref_10bits_heic_encode_key");
        edit.remove("pref_facerectify_set_default_value");
        edit.apply();
    }

    private void U() {
        String optionKeyDefaultValue = CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", 0);
        SharedPreferences b2 = this.h.b(getActivity(), 0);
        a(b2, optionKeyDefaultValue, getString(R.string.camera_video_default_fps), c(0));
        a(b2);
    }

    private void a(SharedPreferences sharedPreferences) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME)) {
            String string = sharedPreferences.getString("pref_slow_video_size_key", c(0));
            SharedPreferences.Editor edit = this.h.edit();
            if ("video_size_1080p".equals(string)) {
                edit.putInt("pref_slow_video_rear_fps_key", CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE)).apply();
            } else if ("video_size_720p".equals(string)) {
                edit.putInt("pref_slow_video_rear_fps_key", CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE)).apply();
            }
        }
    }

    private void V() {
        a(this.h.b(getActivity(), 1), CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", 1), getString(R.string.camera_video_default_fps), c(1));
    }

    private void a(SharedPreferences sharedPreferences, String str, String str2, String str3) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("pref_lasted_video_size", "");
        edit.putString("pref_lasted_video_fps", "");
        edit.putString("pref_video_size_key", str);
        edit.putString("pref_video_fps_key", str2);
        edit.putString("pref_slow_video_size_key", str3);
        edit.apply();
    }

    private void a(String str) {
        a(str, 0);
    }

    private void a(String str, int i2) {
        Intent intent = new Intent(str);
        Bundle bundle = new Bundle();
        bundle.putBoolean("camera_entry_from", ((CameraSettingActivity) getActivity()).l());
        bundle.putBoolean("pref_camera_tap_shutter_key", this.Q);
        bundle.putBoolean("pref_lens_dirty_detection_key", this.R);
        bundle.putBoolean("pref_camera_gesture_shutter_key", this.S);
        bundle.putBoolean("pref_photo_codec_key", this.T);
        bundle.putBoolean("pref_10bits_heic_encode_key", this.U);
        bundle.putBoolean("key_is_capture_mode", this.V);
        bundle.putBoolean("pref_assist_gradienter", this.ae);
        bundle.putInt("pref_camera_id_key", this.d);
        bundle.putInt("camera_enter_type", this.c);
        bundle.putInt("camera_property_camera_id", this.e);
        bundle.putBoolean("camera_enter_form_lock_screen", this.aq);
        bundle.putString("pref_camera_mode_key", this.f4186b);
        bundle.putBoolean("key_is_video_mode", this.W);
        bundle.putBoolean("pref_camera_quick_launch_key", this.an);
        bundle.putInt("camera_sub_setting_from", i2);
        intent.putExtra("camera_intent_data", bundle);
        startActivity(intent);
    }

    private String b(String str) {
        if ("video_size_4kuhd".equals(str)) {
            return getString(R.string.camera_video_size_4kuhd);
        }
        if ("video_size_1080p".equals(str)) {
            return getString(R.string.camera_video_size_1080p);
        }
        if ("video_size_720p".equals(str)) {
            return getString(R.string.camera_video_size_720p);
        }
        return getString(R.string.camera_video_size_1080p);
    }

    private String c(String str) {
        if (String.valueOf(60).equals(str)) {
            return getString(R.string.camera_video_fps_60);
        }
        if (String.valueOf(30).equals(str)) {
            return getString(R.string.camera_video_fps_30);
        }
        return getString(R.string.camera_video_fps_30);
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

    public void i() {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putString("pref_camera_recordlocation_key", "on");
        edit.apply();
        CameraSwitchPreference cameraSwitchPreference = this.m;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.e(true);
        }
    }

    public void j() {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putString("pref_camera_recordlocation_key", "off");
        edit.apply();
        CameraSwitchPreference cameraSwitchPreference = this.m;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.e(false);
        }
    }

    /* access modifiers changed from: protected */
    public void l() {
        if (this.m != null && this.h != null && !Util.p(getActivity())) {
            this.h.edit().putString("pref_camera_recordlocation_key", "off").apply();
            this.m.e(false);
            this.h.edit().putString("pref_slogan_location_key", "off").apply();
            this.h.edit().putString("pref_video_slogan_location_key", "off").apply();
            w();
        }
    }

    public String c(int i2) {
        return (!com.oppo.camera.f.a.c(i2) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) ? "video_size_720p" : "video_size_1080p";
    }
}
