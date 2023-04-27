package com.oppo.camera.ui.menu.setting;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.c;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import color.support.v7.widget.Toolbar;
import com.android.ui.menu.CameraSwitchPreference;
import com.color.support.dialog.panel.ColorBottomSheetBehavior;
import com.color.support.dialog.panel.b;
import com.color.support.dialog.panel.d;
import com.color.support.preference.ColorPreference;
import com.color.support.widget.ColorEditText;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.oppo.camera.MyApplication;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.util.h;

/* compiled from: CameraPhotoSloganSettingFragment */
public class k extends b {
    /* access modifiers changed from: private */
    public com.oppo.camera.k g = null;
    private PreferenceScreen h = null;
    private PreferenceCategory i = null;
    private PreferenceCategory j = null;
    private PreferenceCategory k = null;
    private CameraSwitchPreference l = null;
    private CameraSwitchPreference m = null;
    private CameraSwitchPreference n = null;
    private ColorPreference o = null;
    private boolean p = true;
    /* access modifiers changed from: private */
    public long q = 0;
    /* access modifiers changed from: private */
    public b r = null;
    /* access modifiers changed from: private */
    public boolean s = false;

    /* access modifiers changed from: protected */
    public void c(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public int k() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void p() {
    }

    /* access modifiers changed from: protected */
    public void q() {
    }

    public void a(Bundle bundle, String str) {
        super.a(bundle, str);
        ((MyApplication) getContext().getApplicationContext()).e();
        b((int) R.xml.camera_setting_photo_slogan_preferences);
        a().c((int) R.string.camera_slogan_title);
        r();
    }

    public void onPause() {
        super.onPause();
        com.oppo.camera.k kVar = this.g;
        if (kVar != null) {
            String string = kVar.getString("pref_slogan_device_key", getString(R.string.camera_slogan_default_value));
            String string2 = this.g.getString("pref_slogan_location_key", getString(R.string.camera_slogan_default_value));
            String string3 = this.g.getString("pref_slogan_time_key", getString(R.string.camera_slogan_default_value));
            String str = "on";
            boolean z = str.equals(string) || str.equals(string2) || str.equals(string3);
            e.b("CameraSloganSettingFrag", "onPause, deviceValue: " + string + ", locationValue: " + string2 + ", timeValue: " + string3);
            SharedPreferences.Editor edit = this.g.edit();
            if (!z) {
                str = "off";
            }
            edit.putString("pref_camera_slogan_key", str);
            edit.apply();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.r;
        if (bVar != null) {
            this.s = false;
            bVar.b(false);
            this.r = null;
        }
        com.oppo.camera.k kVar = this.g;
        if (kVar != null) {
            kVar.a(m());
            this.g = null;
        }
        PreferenceScreen preferenceScreen = this.h;
        if (preferenceScreen != null) {
            preferenceScreen.d();
            this.h = null;
        }
        PreferenceCategory preferenceCategory = this.i;
        if (preferenceCategory != null) {
            preferenceCategory.d();
            this.i = null;
        }
        PreferenceCategory preferenceCategory2 = this.j;
        if (preferenceCategory2 != null) {
            preferenceCategory2.d();
            this.j = null;
        }
        PreferenceCategory preferenceCategory3 = this.k;
        if (preferenceCategory3 != null) {
            preferenceCategory3.d();
            this.j = null;
        }
        this.l = null;
        this.n = null;
        this.m = null;
        this.o = null;
    }

    public boolean onPreferenceClick(Preference preference) {
        if (!(preference instanceof ColorPreference)) {
            return false;
        }
        a("pref_slogan_device_key", (Object) "author");
        a((Parcelable) null);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(Bundle bundle) {
        if (getActivity() == null || bundle.getParcelable("key_custiomize_dialog_state") == null) {
            return super.a(bundle);
        }
        a(bundle.getParcelable("key_custiomize_dialog_state"));
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        super.b(bundle);
        b bVar = this.r;
        if (bVar != null && bVar.isShowing()) {
            bundle.putParcelable("key_custiomize_dialog_state", ((ColorEditText) this.r.a().findViewById(R.id.bottom_sheet_edit)).onSaveInstanceState());
        }
    }

    private void a(Parcelable parcelable) {
        b bVar = this.r;
        if (bVar == null || !bVar.isShowing()) {
            this.r = new b(getContext(), R.style.DefaultBottomSheetDialog);
            View inflate = View.inflate(getContext(), R.layout.camera_setting_custiomize_slogan, (ViewGroup) null);
            Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.bottom_sheet_toolbar);
            final ColorEditText colorEditText = (ColorEditText) inflate.findViewById(R.id.bottom_sheet_edit);
            toolbar.setTitle((int) R.string.camera_slogan_customize);
            toolbar.inflateMenu(R.menu.menu_slogan_custiom);
            toolbar.setIsTitleCenterStyle(true);
            colorEditText.setFastDeletable(true);
            colorEditText.setFilters(new InputFilter[]{new InputFilter() {
                public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    int length = 20 - (spanned.length() - (i4 - i3));
                    if (length > 0 && length >= i2 - i) {
                        return null;
                    }
                    h.b(Util.f(), R.string.camera_namelength_outofrange);
                    return (length <= 0 || Character.isHighSurrogate(charSequence.charAt(i))) ? "" : charSequence.subSequence(i, length + i);
                }
            }});
            if (parcelable != null) {
                colorEditText.onRestoreInstanceState(parcelable);
            } else {
                colorEditText.setText(this.g.getString("pref_slogan_customize_key", ""));
            }
            toolbar.setOnMenuItemClickListener(new Toolbar.c() {
                public boolean a(MenuItem menuItem) {
                    String str;
                    switch (menuItem.getItemId()) {
                        case R.id.menu_cancel:
                            boolean unused = k.this.s = false;
                            k.this.r.dismiss();
                            return true;
                        case R.id.menu_save:
                            Editable text = colorEditText.getText();
                            if (text == null) {
                                str = "";
                            } else {
                                str = text.toString();
                            }
                            k.this.g.edit().putString("pref_video_slogan_customize_key", str).putString("pref_slogan_customize_key", str).apply();
                            k.this.a(str);
                            k.this.a("pref_slogan_customize_key", (Object) str);
                            boolean unused2 = k.this.s = false;
                            k.this.r.dismiss();
                            return true;
                        default:
                            return true;
                    }
                }
            });
            this.r.setContentView(inflate);
            BottomSheetBehavior<FrameLayout> behavior = this.r.getBehavior();
            if (behavior != null) {
                ((ColorBottomSheetBehavior) behavior).a((d) new d() {
                    public boolean a() {
                        if (colorEditText.length() == 0 || 2000 >= System.currentTimeMillis() - k.this.q) {
                            return false;
                        }
                        if (!k.this.s) {
                            return true;
                        }
                        long unused = k.this.q = System.currentTimeMillis();
                        Toast.makeText(k.this.getContext(), R.string.camera_slogan_toast_pull_down, 0).show();
                        return true;
                    }
                });
                this.r.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (4 != i || 1 != keyEvent.getAction()) {
                            return false;
                        }
                        if (colorEditText.length() == 0 || 2000 >= System.currentTimeMillis() - k.this.q) {
                            boolean unused = k.this.s = false;
                            k.this.r.dismiss();
                        } else if (k.this.s) {
                            long unused2 = k.this.q = System.currentTimeMillis();
                            Toast.makeText(k.this.getContext(), R.string.camera_slogan_toast_click_back, 0).show();
                            k.this.r.b();
                        }
                        return true;
                    }
                });
                this.r.a((View.OnTouchListener) new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (1 != motionEvent.getAction()) {
                            return false;
                        }
                        if (colorEditText.length() == 0 || 2000 >= System.currentTimeMillis() - k.this.q) {
                            boolean unused = k.this.s = false;
                            k.this.r.dismiss();
                        } else if (k.this.s) {
                            long unused2 = k.this.q = System.currentTimeMillis();
                            Toast.makeText(k.this.getContext(), R.string.camera_slogan_toast_click_blank, 0).show();
                            k.this.r.b();
                        }
                        return true;
                    }
                });
                Window window = this.r.getWindow();
                if (window != null) {
                    colorEditText.requestFocus();
                    window.setSoftInputMode(5);
                }
                this.r.show();
                this.s = true;
                this.q = 0;
            }
        }
    }

    public String n() {
        c activity = getActivity();
        return activity != null ? activity.getTitle().toString() : "";
    }

    /* access modifiers changed from: protected */
    public void o() {
        t();
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str;
        String str2;
        if (preference == null) {
            return false;
        }
        CameraSwitchPreference cameraSwitchPreference = this.n;
        if (cameraSwitchPreference != null && preference == cameraSwitchPreference) {
            boolean booleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
            if (booleanValue) {
                a(this.g.getString("pref_slogan_customize_key", getString(R.string.camera_slogan_customize_default_value)));
                str2 = "model_on";
            } else {
                str2 = "model_off";
            }
            this.o.a(booleanValue);
            super.b(preference, str2);
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.m;
        if (cameraSwitchPreference2 != null && preference == cameraSwitchPreference2) {
            super.b(preference, obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false ? "time_on" : "time_off");
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.l;
        if (cameraSwitchPreference3 == null || preference != cameraSwitchPreference3) {
            return true;
        }
        if (!(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false)) {
            str = "location_off";
        } else if (!h()) {
            return false;
        } else {
            str = "location_on";
        }
        super.b(preference, str);
        return true;
    }

    private void r() {
        this.p = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SLOGAN_LOCATION_SUPPORT);
        this.g = new com.oppo.camera.k(m());
        this.g.getString("pref_camera_id_key", String.valueOf(0));
        this.g.a(m(), this.d);
        s();
        this.h = (PreferenceScreen) a((CharSequence) "camera_setting_slogan_root_preference");
        this.i = (PreferenceCategory) a((CharSequence) "pref_device_watermark_function");
        this.o = (ColorPreference) a((CharSequence) "pref_slogan_customize_key");
        this.o.a(b("pref_slogan_device_key"));
        this.j = (PreferenceCategory) a((CharSequence) "pref_location_watermark_function");
        this.n = (CameraSwitchPreference) a((CharSequence) "pref_slogan_device_key");
        this.m = (CameraSwitchPreference) a((CharSequence) "pref_slogan_time_key");
        this.l = (CameraSwitchPreference) a((CharSequence) "pref_slogan_location_key");
        this.o.a((Preference.c) new Preference.c() {
            public final boolean onPreferenceClick(Preference preference) {
                return k.this.onPreferenceClick(preference);
            }
        });
        this.m.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return k.this.onPreferenceChange(preference, obj);
            }
        });
        this.n.a((Preference.b) new Preference.b() {
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                return k.this.onPreferenceChange(preference, obj);
            }
        });
        if (!this.p) {
            this.h.d((Preference) this.j);
        } else {
            this.l.a((Preference.b) this);
        }
    }

    private void s() {
        com.oppo.camera.k kVar = this.g;
        if (kVar != null) {
            String string = kVar.getString("pref_camera_slogan_version_key", (String) null);
            if (!"1.1.0".equals(string)) {
                String string2 = this.g.getString("pref_slogan_owner_key", (String) null);
                this.g.edit().putString("pref_camera_slogan_version_key", "1.1.0").putString("pref_slogan_customize_key", string2).putString("pref_slogan_owner_key", (String) null).putString("pref_slogan_device_key", this.g.getString("pref_camera_slogan_key", "off")).apply();
                e.b("CameraSloganSettingFrag", "updateSloganFromOTA, preSloganVersion: " + string + ", currentVersion: " + "1.1.0");
            }
        }
    }

    private void t() {
        com.oppo.camera.k kVar;
        if (this.o == null || (kVar = this.g) == null || this.i == null) {
            e.d("CameraSloganSettingFrag", "update preference failed!");
            return;
        }
        a(kVar.getString("pref_slogan_customize_key", getString(R.string.camera_slogan_customize_default_value)));
        boolean b2 = b("pref_slogan_device_key");
        this.n.e(b2);
        this.o.a(b2);
        if (!b("pref_slogan_location_key")) {
            this.l.e(false);
        } else if (!Util.p(getActivity())) {
            this.l.e(false);
            this.g.edit().putString("pref_slogan_location_key", "off").apply();
        } else {
            this.l.e(true);
        }
        this.m.e(b("pref_slogan_time_key"));
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (this.o != null && this.g != null) {
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(R.string.camera_setting_slogan_name_default);
            }
            this.o.d(str);
        }
    }

    private boolean b(String str) {
        return "on".equals(this.g.getString(str, getString(R.string.camera_slogan_default_value)));
    }

    public void i() {
        SharedPreferences.Editor edit = this.g.edit();
        edit.putString("pref_slogan_location_key", "on");
        edit.apply();
        CameraSwitchPreference cameraSwitchPreference = this.l;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.e(true);
        }
        a("pref_slogan_location_key", (Object) "location_on");
    }

    public void j() {
        SharedPreferences.Editor edit = this.g.edit();
        edit.putString("pref_slogan_location_key", "off");
        edit.apply();
        CameraSwitchPreference cameraSwitchPreference = this.l;
        if (cameraSwitchPreference != null) {
            cameraSwitchPreference.e(false);
        }
        a("pref_slogan_location_key", (Object) "location_disagree");
    }

    /* access modifiers changed from: protected */
    public void l() {
        com.oppo.camera.k kVar;
        if (!Util.p(getActivity()) && this.l != null && (kVar = this.g) != null) {
            kVar.edit().putString("pref_slogan_location_key", "off").apply();
            this.l.e(false);
        }
    }
}
