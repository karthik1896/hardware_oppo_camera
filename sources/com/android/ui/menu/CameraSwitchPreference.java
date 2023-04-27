package com.android.ui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import androidx.preference.Preference;
import color.support.v7.app.b;
import com.color.support.preference.ColorSwitchPreference;
import com.oppo.camera.R;
import com.oppo.camera.e;

public class CameraSwitchPreference extends ColorSwitchPreference implements Preference.b {

    /* renamed from: b  reason: collision with root package name */
    private Context f1850b = null;
    private Preference c = null;
    private b d = null;
    private b e = null;
    private final DialogInterface.OnClickListener f = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            CameraSwitchPreference.this.e(true);
        }
    };
    private final DialogInterface.OnClickListener g = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            CameraSwitchPreference.this.l();
        }
    };

    public CameraSwitchPreference(Context context) {
        super(context);
        this.f1850b = context;
        a((Preference.b) this);
    }

    public CameraSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1850b = context;
        a((Preference.b) this);
    }

    public CameraSwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1850b = context;
        a((Preference.b) this);
    }

    /* access modifiers changed from: protected */
    public boolean c(boolean z) {
        e.a("CameraSwitchPreference", "persistBoolean, key: " + B() + ", value: " + z);
        return d(z ? "on" : "off");
    }

    /* access modifiers changed from: protected */
    public boolean d(boolean z) {
        return "on".equals(e(z ? "on" : "off"));
    }

    public void c() {
        b bVar = this.e;
        if (bVar != null && bVar.isShowing()) {
            this.e.dismiss();
        }
        b.a aVar = new b.a(this.f1850b, R.style.DialogAlert);
        aVar.setTitle((int) R.string.camera_storage_sdcard_title);
        aVar.setMessage((int) R.string.camera_storage_footer_summary);
        aVar.setPositiveButton((int) R.string.camera_storage_confirm, this.f);
        aVar.setNegativeButton((int) R.string.camera_storage_cancel, this.g);
        this.e = aVar.create();
        if ((this.f1850b instanceof Activity) && !((Activity) J()).isFinishing()) {
            this.e.show();
        }
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (!"pref_camera_storage_key".equals(preference.B()) || !"off".equals(preference.K().getString(preference.B(), "off"))) {
            return true;
        }
        this.c = preference;
        c();
        return false;
    }

    /* access modifiers changed from: private */
    public void l() {
        Preference preference = this.c;
        if (preference == null) {
            e.e("CameraSwitchPreference", "Exception: null == mPreference");
            return;
        }
        synchronized (preference) {
            SharedPreferences.Editor edit = this.c.K().edit();
            edit.putString(this.c.B(), "off");
            edit.apply();
            e(false);
        }
    }

    public void d() {
        e.b("CameraSwitchPreference", "release");
        b bVar = this.d;
        if (bVar != null && bVar.isShowing()) {
            e.a("CameraSwitchPreference", "release, mRecordLocationDialog dismiss");
            this.d.dismiss();
        }
        this.d = null;
        b bVar2 = this.e;
        if (bVar2 != null && bVar2.isShowing()) {
            e.a("CameraSwitchPreference", "release, mStoragePlaceDialog dismiss");
            this.e.dismiss();
        }
        this.e = null;
    }

    public boolean e() {
        b bVar = this.e;
        return bVar != null && bVar.isShowing();
    }

    public void f() {
        b bVar = this.e;
        if (bVar != null && bVar.isShowing()) {
            this.e.dismiss();
        }
    }
}
