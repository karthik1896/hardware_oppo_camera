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
import android.view.inputmethod.InputMethodManager;
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
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.util.Util;
import com.oppo.camera.util.h;

/* compiled from: CameraSloganSettingFragment */
public class q extends b {
    /* access modifiers changed from: private */
    public k g = null;
    private PreferenceScreen h = null;
    private PreferenceCategory i = null;
    private PreferenceCategory j = null;
    private CameraSwitchPreference k = null;
    private CameraSwitchPreference l = null;
    private CameraSwitchPreference m = null;
    private ColorPreference n = null;
    /* access modifiers changed from: private */
    public b o = null;
    /* access modifiers changed from: private */
    public boolean p = false;
    private int q = 0;
    /* access modifiers changed from: private */
    public long r = 0;
    private InputMethodManager s = null;

    public void i() {
    }

    public void j() {
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
        this.s = (InputMethodManager) getActivity().getSystemService("input_method");
        b((int) R.xml.camera_setting_slogan_preferences);
        a().b((CharSequence) n());
        r();
        t();
    }

    private void r() {
        this.g = new k(m());
        this.g.getString("pref_camera_id_key", String.valueOf(0));
        this.g.a(m(), this.d);
        this.h = (PreferenceScreen) a((CharSequence) "camera_setting_slogan_root_preference");
        this.i = (PreferenceCategory) a((CharSequence) "pref_slogan_function");
        this.j = (PreferenceCategory) a((CharSequence) "pref_apply_slogan_function");
        this.n = (ColorPreference) a((CharSequence) "pref_slogan_customize_key");
        if (this.q == 0) {
            this.n.a((Preference.c) new Preference.c() {
                public final boolean onPreferenceClick(Preference preference) {
                    return q.this.onPreferenceClick(preference);
                }
            });
        } else {
            this.i.d((Preference) this.n);
        }
        this.k = (CameraSwitchPreference) a((CharSequence) "pref_slogan_switch_key");
        this.l = (CameraSwitchPreference) a((CharSequence) "pref_slogan_apply_photo_key");
        this.m = (CameraSwitchPreference) a((CharSequence) "pref_slogan_apply_video_key");
        this.k.b((CharSequence) n());
        this.k.a((Preference.b) this);
        this.l.a((Preference.b) this);
        this.m.a((Preference.b) this);
    }

    public String n() {
        c activity = getActivity();
        return activity != null ? activity.getTitle().toString() : "";
    }

    /* access modifiers changed from: protected */
    public void c(Bundle bundle) {
        if (bundle != null) {
            this.q = bundle.getInt("camera_slogan_setting_from");
        }
    }

    public void onPause() {
        String str;
        super.onPause();
        k kVar = this.g;
        if (kVar != null) {
            boolean z = false;
            boolean z2 = "on".equals(kVar.getString("pref_slogan_device_key", getString(R.string.camera_slogan_default_value))) || "on".equals(this.g.getString("pref_slogan_location_key", getString(R.string.camera_slogan_default_value))) || "on".equals(this.g.getString("pref_slogan_time_key", getString(R.string.camera_slogan_default_value)));
            String string = this.g.getString("pref_video_slogan_device_key", getString(R.string.camera_slogan_default_value));
            String string2 = this.g.getString("pref_video_slogan_location_key", getString(R.string.camera_slogan_default_value));
            String string3 = this.g.getString("pref_video_slogan_time_key", getString(R.string.camera_slogan_default_value));
            if ("on".equals(string) || "on".equals(string2) || "on".equals(string3)) {
                z = true;
            }
            e.e("CameraSloganSettingFragment", "isSloganEnable:" + z2 + ",isVideoSloganEnable:" + z);
            SharedPreferences.Editor edit = this.g.edit();
            String str2 = "off";
            if (z2) {
                str = "on";
            } else {
                str = str2;
            }
            edit.putString("pref_camera_slogan_key", str);
            if (z) {
                str2 = "on";
            }
            edit.putString("pref_camera_video_slogan_key", str2);
            edit.apply();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.o;
        if (bVar != null) {
            this.p = false;
            bVar.b(false);
            this.o = null;
        }
        k kVar = this.g;
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
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.s = null;
    }

    public boolean onPreferenceClick(Preference preference) {
        if (!(preference instanceof ColorPreference)) {
            return false;
        }
        a((Parcelable) null);
        a("pref_slogan_device_key", (Object) "author");
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
        b bVar = this.o;
        if (bVar != null && bVar.isShowing()) {
            bundle.putParcelable("key_custiomize_dialog_state", ((ColorEditText) this.o.a().findViewById(R.id.bottom_sheet_edit)).onSaveInstanceState());
        }
    }

    private void a(Parcelable parcelable) {
        b bVar = this.o;
        if (bVar == null || !bVar.isShowing()) {
            CameraSwitchPreference cameraSwitchPreference = this.k;
            if (cameraSwitchPreference == null || cameraSwitchPreference.b()) {
                this.o = new b(getContext(), R.style.DefaultBottomSheetDialog);
                View inflate = View.inflate(getContext(), R.layout.camera_setting_custiomize_slogan, (ViewGroup) null);
                Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.bottom_sheet_toolbar);
                final ColorEditText colorEditText = (ColorEditText) inflate.findViewById(R.id.bottom_sheet_edit);
                colorEditText.requestFocus();
                colorEditText.setFocusable(true);
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
                                if (!q.this.w()) {
                                    return true;
                                }
                                boolean unused = q.this.p = false;
                                q.this.o.dismiss();
                                return true;
                            case R.id.menu_save:
                                Editable text = colorEditText.getText();
                                if (text == null) {
                                    str = "";
                                } else {
                                    str = text.toString();
                                }
                                q.this.g.edit().putString("pref_video_slogan_customize_key", str).putString("pref_slogan_customize_key", str).apply();
                                q.this.a(str);
                                q.this.a("pref_slogan_customize_key", (Object) str);
                                if (!q.this.w()) {
                                    return true;
                                }
                                boolean unused2 = q.this.p = false;
                                q.this.o.dismiss();
                                return true;
                            default:
                                return true;
                        }
                    }
                });
                this.o.setContentView(inflate);
                BottomSheetBehavior<FrameLayout> behavior = this.o.getBehavior();
                if (behavior != null) {
                    ((ColorBottomSheetBehavior) behavior).a((d) new d() {
                        public boolean a() {
                            if (colorEditText.length() == 0 || 2000 >= System.currentTimeMillis() - q.this.r) {
                                return false;
                            }
                            if (!q.this.p) {
                                return true;
                            }
                            long unused = q.this.r = System.currentTimeMillis();
                            Toast.makeText(q.this.getContext(), R.string.camera_slogan_toast_pull_down, 0).show();
                            return true;
                        }
                    });
                    this.o.setOnKeyListener(new DialogInterface.OnKeyListener() {
                        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                            if (4 != i || 1 != keyEvent.getAction() || q.this.o == null) {
                                return false;
                            }
                            if (colorEditText.length() == 0 || 2000 >= System.currentTimeMillis() - q.this.r) {
                                boolean unused = q.this.p = false;
                                q.this.o.dismiss();
                            } else if (q.this.p) {
                                long unused2 = q.this.r = System.currentTimeMillis();
                                Toast.makeText(q.this.getContext(), R.string.camera_slogan_toast_click_back, 0).show();
                                q.this.o.b();
                            }
                            return true;
                        }
                    });
                    this.o.a((View.OnTouchListener) new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (1 != motionEvent.getAction() || q.this.o == null) {
                                return false;
                            }
                            if (colorEditText.length() == 0 || 2000 >= System.currentTimeMillis() - q.this.r) {
                                boolean unused = q.this.p = false;
                                q.this.o.dismiss();
                            } else if (q.this.p) {
                                long unused2 = q.this.r = System.currentTimeMillis();
                                Toast.makeText(q.this.getContext(), R.string.camera_slogan_toast_click_blank, 0).show();
                                q.this.o.b();
                            }
                            return true;
                        }
                    });
                    this.o.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            b unused = q.this.o = null;
                        }
                    });
                    Window window = this.o.getWindow();
                    if (window != null) {
                        colorEditText.requestFocus();
                        window.setSoftInputMode(5);
                    }
                    this.o.show();
                    this.p = true;
                    this.r = 0;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        t();
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str;
        String str2;
        String str3;
        boolean z = false;
        if (preference == null) {
            return false;
        }
        CameraSwitchPreference cameraSwitchPreference = this.k;
        String str4 = "on";
        if (cameraSwitchPreference != null && preference == cameraSwitchPreference) {
            boolean booleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
            this.l.e(booleanValue);
            this.m.e(booleanValue);
            if (booleanValue) {
                if (this.q == 0) {
                    a(this.g.getString("pref_slogan_customize_key", getString(R.string.camera_slogan_customize_default_value)));
                    this.i.c((Preference) this.n);
                }
                this.j.c((Preference) this.l);
                this.j.c((Preference) this.m);
            } else {
                s();
            }
            if (booleanValue) {
                str2 = str4;
            } else {
                str2 = "off";
            }
            b(str2);
            if (booleanValue) {
                str3 = str4;
            } else {
                str3 = "off";
            }
            c(str3);
            int i2 = this.q;
            if (i2 == 0) {
                a("pref_slogan_device_key", (Object) booleanValue ? "model_on" : "model_off");
            } else if (1 == i2) {
                a("pref_slogan_time_key", (Object) booleanValue ? "time_on" : "time_off");
            } else {
                a("pref_slogan_location_key", (Object) booleanValue ? "location_on" : "location_off");
            }
        }
        CameraSwitchPreference cameraSwitchPreference2 = this.l;
        if (cameraSwitchPreference2 != null && preference == cameraSwitchPreference2) {
            boolean booleanValue2 = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
            if (booleanValue2) {
                str = str4;
            } else {
                str = "off";
            }
            b(str);
            if (!booleanValue2 && "off".equals(v())) {
                s();
            }
            int i3 = this.q;
            if (i3 == 0) {
                a("pref_slogan_device_key", (Object) booleanValue2 ? "portrait_model_on" : "portrait_model_off");
            } else if (1 == i3) {
                a("pref_slogan_time_key", (Object) booleanValue2 ? "portrait_time_on" : "portrait_time_off");
            } else {
                a("pref_slogan_location_key", (Object) booleanValue2 ? "portrait_location_on" : "portrait_location_off");
            }
        }
        CameraSwitchPreference cameraSwitchPreference3 = this.m;
        if (cameraSwitchPreference3 != null && preference == cameraSwitchPreference3) {
            if (obj instanceof Boolean) {
                z = ((Boolean) obj).booleanValue();
            }
            if (!z) {
                str4 = "off";
            }
            c(str4);
            if (!z && "off".equals(u())) {
                s();
            }
            int i4 = this.q;
            if (i4 == 0) {
                a("pref_slogan_device_key", (Object) z ? "video_model_on" : "video_model_off");
            } else if (1 == i4) {
                a("pref_slogan_time_key", (Object) z ? "video_time_on" : "video_time_off");
            } else {
                a("pref_slogan_location_key", (Object) z ? "video_location_on" : "video_location_off");
            }
        }
        return true;
    }

    private void s() {
        b bVar = this.o;
        if (bVar != null) {
            this.p = false;
            bVar.dismiss();
            this.o = null;
        }
        this.k.e(false);
        this.l.e(false);
        this.m.e(false);
        if (this.q == 0) {
            this.i.d((Preference) this.n);
        }
        this.j.d((Preference) this.l);
        this.j.d((Preference) this.m);
    }

    private void t() {
        if (this.n == null || this.g == null || this.i == null) {
            e.d("CameraSloganSettingFragment", "update preference failed!");
            return;
        }
        String u = u();
        String v = v();
        if ("on".equals(u) || "on".equals(v)) {
            this.k.e(true);
            this.l.e("on".equals(u));
            this.m.e("on".equals(v));
            if (this.q == 0) {
                a(this.g.getString("pref_slogan_customize_key", getString(R.string.camera_slogan_customize_default_value)));
                this.i.c((Preference) this.n);
            }
            this.j.c((Preference) this.l);
            this.j.c((Preference) this.m);
            return;
        }
        this.k.e(false);
        this.l.e(false);
        this.m.e(false);
        if (this.q == 0) {
            this.i.d((Preference) this.n);
        }
        this.j.d((Preference) this.l);
        this.j.d((Preference) this.m);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (this.n != null && this.g != null) {
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(R.string.camera_setting_slogan_name_default);
            }
            this.n.d(str);
        }
    }

    private void b(String str) {
        int i2 = this.q;
        if (i2 == 0) {
            this.g.edit().putString("pref_slogan_device_key", str).apply();
        } else if (1 == i2) {
            this.g.edit().putString("pref_slogan_time_key", str).apply();
        } else {
            this.g.edit().putString("pref_slogan_location_key", str).apply();
        }
    }

    private void c(String str) {
        int i2 = this.q;
        if (i2 == 0) {
            this.g.edit().putString("pref_video_slogan_device_key", str).apply();
        } else if (1 == i2) {
            this.g.edit().putString("pref_video_slogan_time_key", str).apply();
        } else {
            this.g.edit().putString("pref_video_slogan_location_key", str).apply();
        }
    }

    private String u() {
        int i2 = this.q;
        if (i2 == 0) {
            return this.g.getString("pref_slogan_device_key", "off");
        }
        if (1 == i2) {
            return this.g.getString("pref_slogan_time_key", "off");
        }
        return this.g.getString("pref_slogan_location_key", "off");
    }

    private String v() {
        int i2 = this.q;
        if (i2 == 0) {
            return this.g.getString("pref_video_slogan_device_key", "off");
        }
        if (1 == i2) {
            return this.g.getString("pref_video_slogan_time_key", "off");
        }
        return this.g.getString("pref_video_slogan_location_key", "off");
    }

    /* access modifiers changed from: protected */
    public void l() {
        if (2 == this.q && this.g != null && !Util.p(getActivity())) {
            SharedPreferences.Editor edit = this.g.edit();
            edit.putString("pref_slogan_location_key", "off");
            edit.putString("pref_video_slogan_location_key", "off");
            edit.apply();
            CameraSwitchPreference cameraSwitchPreference = this.k;
            if (cameraSwitchPreference != null) {
                cameraSwitchPreference.e(false);
            }
            CameraSwitchPreference cameraSwitchPreference2 = this.l;
            if (cameraSwitchPreference2 != null) {
                cameraSwitchPreference2.e(false);
            }
            CameraSwitchPreference cameraSwitchPreference3 = this.m;
            if (cameraSwitchPreference3 != null) {
                cameraSwitchPreference3.e(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean w() {
        b bVar = this.o;
        return bVar != null && bVar.isShowing();
    }
}
