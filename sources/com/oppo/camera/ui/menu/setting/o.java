package com.oppo.camera.ui.menu.setting;

import android.os.Bundle;
import com.oppo.camera.aps.config.CameraFunction;

/* compiled from: CameraSettingFactory */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static n f4237a = new n();

    public static Bundle a(com.oppo.camera.e.o oVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("pref_camera_countdown_effect_key", oVar.i("pref_camera_countdown_effect_key"));
        bundle.putBoolean("pref_camera_tap_shutter_key", oVar.i("pref_camera_tap_shutter_key"));
        bundle.putBoolean("pref_lens_dirty_detection_key", oVar.i("pref_lens_dirty_detection_key"));
        bundle.putBoolean("pref_camera_gesture_shutter_key", oVar.i("pref_camera_gesture_shutter_key"));
        bundle.putString("pref_camera_photo_ratio_key", oVar.bn());
        bundle.putBoolean("key_is_capture_mode", oVar.g());
        bundle.putBoolean("key_is_video_mode", oVar.i());
        bundle.putString("pref_camera_mode_key", oVar.l());
        bundle.putBoolean("pref_ai_scene_key", oVar.i("pref_ai_scene_key"));
        bundle.putBoolean("pref_super_clear_portrait", oVar.bO());
        bundle.putBoolean("pref_face_rectify_key", oVar.i("pref_face_rectify_key") && oVar.m());
        bundle.putBoolean("pref_camera_slogan_key", oVar.i("pref_camera_slogan_key"));
        bundle.putBoolean("pref_camera_video_slogan_key", oVar.i("pref_camera_video_slogan_key"));
        bundle.putString("key_full_pic_size_type", oVar.aa());
        bundle.putBoolean("pref_raw_key", oVar.i("pref_raw_key"));
        bundle.putBoolean("pref_assist_gradienter", oVar.i("pref_assist_gradienter"));
        bundle.putBoolean("pref_time_lapse_key", oVar.i("pref_time_lapse_key"));
        bundle.putBoolean("key_high_picture_size", oVar.i("key_high_picture_size"));
        bundle.putInt("pref_video_fps_key", oVar.bo());
        bundle.putBoolean("key_support_video_high_fps", oVar.i("key_support_video_high_fps"));
        bundle.putBoolean("key_support_slow_video_h265", oVar.i("key_support_slow_video_h265"));
        bundle.putBoolean(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS, oVar.i(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS));
        bundle.putBoolean("pref_inertial_zoom_key", oVar.i("pref_inertial_zoom_key"));
        bundle.putBoolean("pref_video_size_fps_settings", oVar.i("pref_video_size_fps_settings"));
        return f4237a.a(oVar, bundle);
    }
}
