package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.v;
import androidx.preference.Preference;
import color.support.design.widget.ColorAppBarLayout;
import color.support.v7.widget.Toolbar;
import com.color.support.preference.e;
import com.oppo.camera.R;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.f.a;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;

/* compiled from: BasePreferenceFragment */
public abstract class c extends e implements Preference.b, Preference.c {

    /* renamed from: b  reason: collision with root package name */
    public String f4186b = null;
    public int c = 2;
    public int d = 0;
    public int e = 0;
    protected boolean f = false;
    private Toolbar g;
    private ColorAppBarLayout h;
    private Context i;

    /* access modifiers changed from: protected */
    public abstract void c(Bundle bundle);

    public abstract String n();

    /* access modifiers changed from: protected */
    public abstract void o();

    /* access modifiers changed from: protected */
    public abstract void p();

    /* access modifiers changed from: protected */
    public abstract void q();

    public void a(Bundle bundle, String str) {
        super.a(bundle, str);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f4186b = arguments.getString("pref_camera_mode_key", (String) null);
            this.c = arguments.getInt("camera_enter_type");
            this.d = arguments.getInt("pref_camera_id_key");
            this.f = a.c(this.d);
            this.e = arguments.getInt("camera_property_camera_id");
        }
        c(arguments);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.g = (Toolbar) onCreateView.findViewById(R.id.toolbar);
        Toolbar toolbar = this.g;
        if (toolbar == null) {
            return onCreateView;
        }
        toolbar.setNavigationIcon((int) R.drawable.color_back_arrow);
        this.g.setNavigationContentDescription((int) R.string.abc_action_bar_up_description);
        this.g.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.getActivity().onBackPressed();
            }
        });
        v.c((View) e(), true);
        e().setBackgroundColor(getResources().getColor(R.color.color_list_overscroll_background_color));
        this.g.setTitle((CharSequence) n());
        this.h = (ColorAppBarLayout) onCreateView.findViewById(R.id.appBarLayout);
        this.h.setPadding(0, getResources().getDimensionPixelSize(R.dimen.preference_topbar_padding_top), 0, 0);
        return onCreateView;
    }

    public void onResume() {
        p();
        o();
        super.onResume();
    }

    public void onPause() {
        q();
        super.onPause();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.i = context.getApplicationContext();
    }

    public void onDetach() {
        super.onDetach();
    }

    public Context m() {
        return this.i;
    }

    static Object a(Preference preference, Object obj) {
        String B = preference.B();
        boolean z = false;
        if (B.equals("pref_camera_tap_shutter_key") || B.equals("pref_camera_gesture_shutter_key") || B.equals("pref_camera_sound_key") || B.equals("pref_camera_recordlocation_key") || B.equals("pref_face_rectify_key") || B.equals("pref_camera_slogan_key") || B.equals("pref_track_focus_key") || B.equals("pref_inertial_zoom_key") || B.equals("pref_camera_video_slogan_key") || B.equals("pref_assist_gradienter") || B.equals("pref_share_and_edit_key") || B.equals("pref_super_clear_portrait") || B.equals("pref_10bits_heic_encode_key")) {
            if (obj instanceof Boolean) {
                z = ((Boolean) obj).booleanValue();
            }
            if (z) {
                return "on";
            }
        } else if (!B.equals("pref_camera_quick_launch_key")) {
            return obj;
        } else {
            if (obj instanceof Boolean) {
                z = ((Boolean) obj).booleanValue();
            }
            if (z) {
                return "only_start";
            }
        }
        return "off";
    }

    /* access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(m());
        menuClickMsgData.mCaptureMode = this.f4186b;
        menuClickMsgData.mCaptureType = a(str);
        menuClickMsgData.mCameraEnterType = String.valueOf(this.c);
        int i2 = this.e;
        menuClickMsgData.mCameraId = i2;
        if (obj != null) {
            menuClickMsgData.mRearOrFront = a.c(i2) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.buildSettingMenuItem(str, obj);
        } else {
            menuClickMsgData.buildSettingJumpItem(str);
        }
        menuClickMsgData.report();
    }

    private int a(String str) {
        if ("pref_sound_types_key_rear".equals(str) || "pref_sound_types_key_front".equals(str) || "pref_camera_video_slogan_key".equals(str) || "pref_video_slogan_device_key".equals(str) || "pref_video_slogan_customize_key".equals(str) || "pref_video_slogan_location_key".equals(str) || "pref_video_slogan_key".equals(str) || "pref_video_slogan_time_key".equals(str)) {
            return 1;
        }
        if (!"pref_help_and_feedback_key".equals(str)) {
            return 0;
        }
        String str2 = this.f4186b;
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -1933413040) {
            if (hashCode != -35510913) {
                if (hashCode == 764302074 && str2.equals(ApsConstant.REC_MODE_SLOW_VIDEO)) {
                    c2 = 2;
                }
            } else if (str2.equals(ApsConstant.REC_MODE_FAST_VIDEO)) {
                c2 = 1;
            }
        } else if (str2.equals(ApsConstant.REC_MODE_COMMON)) {
            c2 = 0;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void b(Preference preference, Object obj) {
        if (this.f4186b == null) {
            com.oppo.camera.e.e("BasePreferenceFragment", "report Msg data failed, current mode is null!");
            return;
        }
        a(preference.B(), a(preference, obj));
    }
}
