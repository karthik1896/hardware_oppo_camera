package com.oppo.camera.ui.modepanel;

import android.app.Activity;
import com.oppo.camera.R;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.ui.menu.b.d;

/* compiled from: ModeInfo */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4295a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f4296b = 0;
    private int c;
    private int d = -1;

    public static String b(int i) {
        switch (i) {
            case 0:
                return ApsConstant.CAPTURE_MODE_PANORAMA;
            case 1:
                return ApsConstant.REC_MODE_FAST_VIDEO;
            case 2:
                return ApsConstant.REC_MODE_SLOW_VIDEO;
            case 3:
                return "movie";
            case 4:
                return ApsConstant.CAPTURE_MODE_PROFESSIONAL;
            case 5:
                return ApsConstant.CAPTURE_MODE_NIGHT;
            case 7:
                return ApsConstant.CAPTURE_MODE_STICKER;
            case 8:
                return "superText";
            case 10:
                return ApsConstant.CAPTURE_MODE_MACRO;
            case 11:
                return ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION;
            case 12:
                return ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
            case 13:
                return ApsConstant.CAPTURE_MODE_ID_PHOTO;
            case 14:
                return ApsConstant.CAPTURE_MODE_MULTI_VIDEO;
            case 15:
                return ApsConstant.CAPTURE_MODE_GROUP_SHOT;
            case 16:
                return ApsConstant.CAPTURE_MODE_MICROSCOPE;
            case 17:
                return ApsConstant.REC_MODE_SOLOOP;
            case 18:
                return ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
            case 19:
                return ApsConstant.CAPTURE_MODE_STARRY;
            default:
                return ApsConstant.CAPTURE_MODE_COMMON;
        }
    }

    public a(Activity activity, int i) {
        this.f4296b = i;
        this.f4295a = a(activity, i);
    }

    public a(Activity activity, int i, int i2) {
        this.f4296b = i;
        this.f4295a = a(activity, i);
        this.c = i2;
    }

    public String a() {
        return this.f4295a;
    }

    public int b() {
        return this.f4296b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public static String a(Activity activity, int i) {
        if (i != 9) {
            return activity.getString(d.a(b(i)));
        }
        return activity.getString(R.string.camera_mode_breeno_scan);
    }
}
