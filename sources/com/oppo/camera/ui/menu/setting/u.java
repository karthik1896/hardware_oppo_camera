package com.oppo.camera.ui.menu.setting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.fragment.app.c;
import androidx.preference.f;
import color.support.v7.app.b;
import com.color.support.widget.ColorSwitch;
import com.oppo.camera.R;
import com.oppo.camera.f.a;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.ui.menu.levelcontrol.l;
import com.oppo.camera.util.Util;

/* compiled from: VideoSoundSettingFragment */
public class u extends f {

    /* renamed from: a  reason: collision with root package name */
    private TextView f4268a = null;

    /* renamed from: b  reason: collision with root package name */
    private ColorSwitch f4269b = null;
    /* access modifiers changed from: private */
    public int c = 0;
    private int d = 0;
    private int e = 0;
    private String f = null;
    private String g = null;
    private CharSequence[] h = null;
    private CharSequence[] i = null;
    private CharSequence[] j = null;

    public static u a(String str, String str2, int i2, int i3) {
        u uVar = new u();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        bundle.putString("pref_camera_mode_key", str2);
        bundle.putInt("pref_camera_id_key", i2);
        bundle.putInt("camera_property_camera_id", i3);
        uVar.setArguments(bundle);
        return uVar;
    }

    public void a(int i2) {
        if (i2 == 0) {
            this.f4268a.setEnabled(false);
            this.f4268a.setTextColor(getResources().getColor(R.color.video_textView_dewind_noise_color));
            this.f4269b.setEnabled(false);
            return;
        }
        this.f4268a.setEnabled(true);
        this.f4268a.setTextColor(-16777216);
        this.f4269b.setEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void a(b.a aVar) {
        super.a(aVar);
        final l lVar = new l(getActivity(), true, true, this.c, "pref_sound_types_key_front".equals(this.g), this.h, this.j);
        aVar.setSingleChoiceItems((ListAdapter) lVar, this.c, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                int unused = u.this.c = i;
                if (Util.q()) {
                    lVar.a(i);
                    u.this.a(i);
                    return;
                }
                u.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
    }

    private CameraCustomListPreference c() {
        return (CameraCustomListPreference) b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            CameraCustomListPreference c2 = c();
            if (c2.l() == null || c2.m() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.c = c2.b(c2.o());
            this.h = c2.l();
            this.i = c2.m();
            this.j = c2.U();
            this.g = c2.B();
        } else {
            this.c = bundle.getInt("VideoSoundSettingFragment.index", 0);
            this.h = bundle.getCharSequenceArray("VideoSoundSettingFragment.entries");
            this.i = bundle.getCharSequenceArray("VideoSoundSettingFragment.entryValues");
            this.j = bundle.getCharSequenceArray("VideoSoundSettingFragment.entrySummary");
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f = arguments.getString("pref_camera_mode_key");
            this.d = arguments.getInt("pref_camera_id_key");
            this.e = arguments.getInt("camera_property_camera_id");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("VideoSoundSettingFragment.index", this.c);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entries", this.h);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entryValues", this.i);
        bundle.putCharSequenceArray("VideoSoundSettingFragment.entrySummary", this.j);
    }

    public void a(boolean z) {
        int i2;
        if (z && (i2 = this.c) >= 0) {
            String charSequence = this.i[i2].toString();
            CameraCustomListPreference c2 = c();
            if (c2.b((Object) charSequence)) {
                c2.a(charSequence);
            }
            if (Util.q()) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                edit.putString("pref_video_noise_filter_key", this.f4269b.isChecked() ? "on" : "off");
                edit.apply();
                a("pref_video_noise_filter_key", (Object) this.f4269b.isChecked() ? MenuClickMsgData.WNR_ON : MenuClickMsgData.WNR_OFF);
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        c activity = getActivity();
        b.a a2 = new b.a(activity).setTitle(b().a()).setIcon(b().c());
        if (Util.q()) {
            a2.setPositiveButton((CharSequence) getString(R.string.beauty3d_save), (DialogInterface.OnClickListener) this).setNegativeButton(b().e(), (DialogInterface.OnClickListener) this);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.video_sound_dewind_noise_switch_layout, (ViewGroup) null);
            this.f4268a = (TextView) inflate.findViewById(R.id.dewind_noise_text);
            this.f4269b = (ColorSwitch) inflate.findViewById(R.id.dewind_noise_switch);
            a(this.c);
            this.f4269b.setChecked("on".equals(PreferenceManager.getDefaultSharedPreferences(activity).getString("pref_video_noise_filter_key", "on")));
            a(inflate);
            a2.setView(inflate);
        } else {
            a2.setMessage(b().b());
        }
        a((b.a) a2);
        return a2.create();
    }

    private void a(String str, Object obj) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(getActivity());
        menuClickMsgData.mCaptureMode = this.f;
        menuClickMsgData.mCaptureType = 1;
        menuClickMsgData.mCameraId = this.e;
        menuClickMsgData.mOrientation = 0;
        menuClickMsgData.buildSettingMenuItem(str, obj);
        menuClickMsgData.mRearOrFront = a.c(this.e) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }
}
