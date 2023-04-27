package com.oppo.camera;

import android.content.Context;
import android.content.SharedPreferences;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.entry.b;
import com.oppo.camera.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ComboPreferences */
public class k implements SharedPreferences, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static final WeakHashMap<Context, k> f3118a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static List<String> f3119b = new ArrayList();
    /* access modifiers changed from: private */
    public SharedPreferences c;
    /* access modifiers changed from: private */
    public SharedPreferences d;
    private CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> e;
    private b f = null;
    private int g = 1;

    public k(Context context) {
        this.c = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        this.c.registerOnSharedPreferenceChangeListener(this);
        if (context instanceof Camera) {
            this.f = ((Camera) context).k();
        }
        synchronized (f3118a) {
            f3118a.put(context, this);
        }
        this.e = new CopyOnWriteArrayList<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02bc, code lost:
        r0 = f3119b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r1) {
        /*
            java.lang.String r1 = com.oppo.camera.entry.b.c(r1)
            java.lang.String r0 = "pref_camera_id_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_recordlocation_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_sound_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_storage_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_fingerprint_shutter_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_assistant_line_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_allow_network_access"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_statement_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_statement_agree"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_volume_key_function_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_mirror_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_lens_dirty_detection_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_share_and_edit_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_slogan_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_video_slogan_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_gesture_shutter_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slogan_owner_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slogan_market_name"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_slogan_market_name"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slogan_version"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slogan_customize"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_slogan_customize"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_bubble_sticker"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_bubble_type_multi_video"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_bubble_type_ai_enhancement_video"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_bubble_short_video"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_ai_scene_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_pi_ai_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_face_rectify_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_track_focus_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_inertial_zoom_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_photo_ratio_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_raw_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_filter_menu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "last_camera_gesture_shutter_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "last_camera_tap_shutter_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_gradienter_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_timer_shutter_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_exit_time_stamp_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_report_permission_timestamp"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_sticker_filter_index"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_high_picture_size"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_high_resolution_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_current_sticker_uuid"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slogan_customize_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_slogan_customize_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slogan_device_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_slogan_device_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slogan_location_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_slogan_location_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slogan_time_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_slogan_time_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_slogan_version_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slow_video_rear_fps_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_codec_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_photo_codec_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_sell_eis"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_none_sat_ultra_wide_angle_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_portrait_half_body_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_portrait_half_body_remosaic_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_subsetting_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_video_hyper_lapse_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_hyper_lapse_zoom_ultra_wide_open"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_assist_gradienter"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_10bits_heic_encode_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_camera_videoflashmode_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_multicamera_type_selected_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_multi_video_facebeauty_level_menu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_multicamera_show_position_state_key"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_drawer_layout_anchor"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_permission_dialog_displayed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "share_edit_video_show_expand"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_bottom_guide_type_id_photo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_bubble_type_zoom_ultra_wide"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_cur_temperature"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_slow_video_size_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x026c
            java.lang.String r0 = "com.oplus.feature.front.slow.video.support"
            boolean r0 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r0)
            if (r0 == 0) goto L_0x02c9
        L_0x026c:
            java.lang.String r0 = "pref_facerectify_set_default_value"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_camera_pid_history"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_support_front_face_point_animation"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_drawer_show_guide_animation"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "show_arrow_animation"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_double_exposure_effect_type"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "key_bottom_guide_double_exposure"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_double_exposure_tips"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String r0 = "pref_double_exposure_open_count"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c9
            java.lang.String[] r0 = com.oppo.camera.ui.e.f
            boolean r0 = a((java.lang.String[]) r0, (java.lang.String) r1)
            if (r0 != 0) goto L_0x02c9
            java.util.List<java.lang.String> r0 = f3119b
            if (r0 == 0) goto L_0x02c7
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x02c7
            goto L_0x02c9
        L_0x02c7:
            r1 = 0
            goto L_0x02ca
        L_0x02c9:
            r1 = 1
        L_0x02ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.k.a(java.lang.String):boolean");
    }

    public String a(String str, String str2) {
        String e2 = e(str);
        if (a(str)) {
            SharedPreferences sharedPreferences = this.c;
            return sharedPreferences == null ? str2 : sharedPreferences.getString(e2, str2);
        }
        SharedPreferences sharedPreferences2 = this.d;
        return sharedPreferences2 == null ? str2 : sharedPreferences2.getString(e2, str2);
    }

    public void a(Context context) {
        b(context);
        this.c = null;
        this.d = null;
        CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> copyOnWriteArrayList = this.e;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.e = null;
        }
    }

    private void b(Context context) {
        synchronized (f3118a) {
            f3118a.remove(context);
        }
    }

    public void a(Context context, int i) {
        String str = context.getPackageName() + "_preferences_" + i;
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        }
        this.d = context.getSharedPreferences(str, 0);
        this.d.registerOnSharedPreferenceChangeListener(this);
    }

    public SharedPreferences b(Context context, int i) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences_" + i, 0);
    }

    public SharedPreferences a() {
        return this.c;
    }

    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }

    public void b(String str) {
        String c2 = b.c(str);
        List<String> list = f3119b;
        if (list != null && !list.contains(c2)) {
            f3119b.add(c2);
        }
    }

    public void c(String str) {
        String c2 = b.c(str);
        List<String> list = f3119b;
        if (list != null && list.contains(c2)) {
            f3119b.remove(c2);
        }
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences;
        String e2 = e(str);
        if (a(str) || ((sharedPreferences = this.d) != null && !sharedPreferences.contains(e2))) {
            SharedPreferences sharedPreferences2 = this.c;
            return sharedPreferences2 == null ? str2 : sharedPreferences2.getString(e2, str2);
        }
        SharedPreferences sharedPreferences3 = this.d;
        return sharedPreferences3 == null ? str2 : sharedPreferences3.getString(e2, str2);
    }

    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences;
        String e2 = e(str);
        if (a(str) || ((sharedPreferences = this.d) != null && !sharedPreferences.contains(e2))) {
            SharedPreferences sharedPreferences2 = this.c;
            return sharedPreferences2 == null ? i : sharedPreferences2.getInt(e2, i);
        }
        SharedPreferences sharedPreferences3 = this.d;
        return sharedPreferences3 == null ? i : sharedPreferences3.getInt(e2, i);
    }

    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences;
        String e2 = e(str);
        if (a(str) || ((sharedPreferences = this.d) != null && !sharedPreferences.contains(e2))) {
            SharedPreferences sharedPreferences2 = this.c;
            return sharedPreferences2 == null ? j : sharedPreferences2.getLong(e2, j);
        }
        SharedPreferences sharedPreferences3 = this.d;
        return sharedPreferences3 == null ? j : sharedPreferences3.getLong(e2, j);
    }

    public float getFloat(String str, float f2) {
        SharedPreferences sharedPreferences;
        String e2 = e(str);
        if (a(str) || ((sharedPreferences = this.d) != null && !sharedPreferences.contains(e2))) {
            SharedPreferences sharedPreferences2 = this.c;
            return sharedPreferences2 == null ? f2 : sharedPreferences2.getFloat(e2, f2);
        }
        SharedPreferences sharedPreferences3 = this.d;
        return sharedPreferences3 == null ? f2 : sharedPreferences3.getFloat(e2, f2);
    }

    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences;
        String e2 = e(str);
        if (a(str) || ((sharedPreferences = this.d) != null && !sharedPreferences.contains(e2))) {
            SharedPreferences sharedPreferences2 = this.c;
            return sharedPreferences2 == null ? z : sharedPreferences2.getBoolean(e2, z);
        }
        SharedPreferences sharedPreferences3 = this.d;
        return sharedPreferences3 == null ? z : sharedPreferences3.getBoolean(e2, z);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences;
        String e2 = e(str);
        if (a(str) || ((sharedPreferences = this.d) != null && !sharedPreferences.contains(e2))) {
            SharedPreferences sharedPreferences2 = this.c;
            return sharedPreferences2 == null ? set : sharedPreferences2.getStringSet(e2, set);
        }
        SharedPreferences sharedPreferences3 = this.d;
        return sharedPreferences3 == null ? set : sharedPreferences3.getStringSet(e2, set);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = r1.c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean contains(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r2 = r1.e(r2)
            android.content.SharedPreferences r0 = r1.d
            if (r0 != 0) goto L_0x0009
            goto L_0x000f
        L_0x0009:
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L_0x001d
        L_0x000f:
            android.content.SharedPreferences r0 = r1.c
            if (r0 != 0) goto L_0x0014
            goto L_0x001b
        L_0x0014:
            boolean r2 = r0.contains(r2)
            if (r2 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r2 = 0
            goto L_0x001e
        L_0x001d:
            r2 = 1
        L_0x001e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.k.contains(java.lang.String):boolean");
    }

    public boolean d(String str) {
        String e2 = e(str);
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains(e2);
    }

    public SharedPreferences.Editor edit() {
        return new a();
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> copyOnWriteArrayList;
        if (onSharedPreferenceChangeListener != null && (copyOnWriteArrayList = this.e) != null && !copyOnWriteArrayList.contains(onSharedPreferenceChangeListener)) {
            this.e.add(onSharedPreferenceChangeListener);
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.e.remove(onSharedPreferenceChangeListener);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> copyOnWriteArrayList = this.e;
        if (copyOnWriteArrayList != null) {
            Iterator<SharedPreferences.OnSharedPreferenceChangeListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onSharedPreferenceChanged(this, str);
            }
        }
    }

    /* access modifiers changed from: private */
    public String e(String str) {
        if (!h(str)) {
            return str;
        }
        b bVar = this.f;
        if (bVar != null) {
            return b.b(str, bVar.y());
        }
        return b.b(str, this.g);
    }

    private static boolean a(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean f(String str) {
        return "pref_sticker_facebeauty_level_menu".equals(str) || "pref_common_facebeauty_level_menu".equals(str) || "pref_portrait_facebeauty_level_menu".equals(str) || "pref_video_facebeauty_level_menu".equals(str) || "pref_night_facebeauty_level_menu".equals(str) || "pref_multi_video_facebeauty_level_menu".equals(str) || a(e.e_, str) || a(e.f_, str) || a(e.d, str) || a(e.e, str) || a(e.f, str) || a(e.d_, str);
    }

    private boolean g(String str) {
        return "key_filter_index".equals(str) || "key_portrait_new_style_index".equals(str);
    }

    private boolean h(String str) {
        if (f(str) || g(str)) {
            return true;
        }
        List<String> menuPanelOptionList = CameraConfig.getMenuPanelOptionList();
        if (menuPanelOptionList != null && menuPanelOptionList.size() != 0) {
            return menuPanelOptionList.contains(str);
        }
        e.d("ComboPreferences", "isBelongToolKeys, camera config is not initialized yet, the key " + str + " keeps its origin.");
        return false;
    }

    /* compiled from: ComboPreferences */
    private class a implements SharedPreferences.Editor {

        /* renamed from: b  reason: collision with root package name */
        private SharedPreferences.Editor f3121b;
        private SharedPreferences.Editor c;

        a() {
            if (k.this.c != null) {
                this.f3121b = k.this.c.edit();
            }
            if (k.this.d != null) {
                this.c = k.this.d.edit();
            }
        }

        public boolean commit() {
            SharedPreferences.Editor editor = this.f3121b;
            boolean commit = editor != null ? editor.commit() : false;
            SharedPreferences.Editor editor2 = this.c;
            boolean commit2 = editor2 != null ? editor2.commit() : false;
            if (!commit || !commit2) {
                return false;
            }
            return true;
        }

        public void apply() {
            try {
                if (this.f3121b != null) {
                    this.f3121b.apply();
                }
                if (this.c != null) {
                    this.c.apply();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public SharedPreferences.Editor clear() {
            SharedPreferences.Editor editor = this.f3121b;
            if (editor != null) {
                editor.clear();
            }
            SharedPreferences.Editor editor2 = this.c;
            if (editor2 != null) {
                editor2.clear();
            }
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            String a2 = k.this.e(str);
            SharedPreferences.Editor editor = this.f3121b;
            if (editor != null) {
                editor.remove(a2);
            }
            SharedPreferences.Editor editor2 = this.c;
            if (editor2 != null) {
                editor2.remove(a2);
            }
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            SharedPreferences.Editor editor;
            String a2 = k.this.e(str);
            if (!k.a(str) || (editor = this.f3121b) == null) {
                SharedPreferences.Editor editor2 = this.c;
                if (editor2 != null) {
                    editor2.putString(a2, str2);
                }
            } else {
                editor.putString(a2, str2);
            }
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            SharedPreferences.Editor editor;
            String a2 = k.this.e(str);
            if (!k.a(str) || (editor = this.f3121b) == null) {
                SharedPreferences.Editor editor2 = this.c;
                if (editor2 != null) {
                    editor2.putInt(a2, i);
                }
            } else {
                editor.putInt(a2, i);
            }
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            SharedPreferences.Editor editor;
            String a2 = k.this.e(str);
            if (!k.a(str) || (editor = this.f3121b) == null) {
                SharedPreferences.Editor editor2 = this.c;
                if (editor2 != null) {
                    editor2.putLong(a2, j);
                }
            } else {
                editor.putLong(a2, j);
            }
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            SharedPreferences.Editor editor;
            String a2 = k.this.e(str);
            if (!k.a(str) || (editor = this.f3121b) == null) {
                SharedPreferences.Editor editor2 = this.c;
                if (editor2 != null) {
                    editor2.putFloat(a2, f);
                }
            } else {
                editor.putFloat(a2, f);
            }
            return this;
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            SharedPreferences.Editor editor;
            String a2 = k.this.e(str);
            if (!k.a(str) || (editor = this.f3121b) == null) {
                SharedPreferences.Editor editor2 = this.c;
                if (editor2 != null) {
                    editor2.putBoolean(a2, z);
                }
            } else {
                editor.putBoolean(a2, z);
            }
            return this;
        }

        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            SharedPreferences.Editor editor;
            String a2 = k.this.e(str);
            if (!k.a(str) || (editor = this.f3121b) == null) {
                SharedPreferences.Editor editor2 = this.c;
                if (editor2 != null) {
                    editor2.putStringSet(a2, set);
                }
            } else {
                editor.putStringSet(a2, set);
            }
            return this;
        }
    }
}
