package com.oppo.camera.ui.modepanel;

import android.app.Activity;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.f.a;
import com.oppo.camera.util.Util;
import java.util.ArrayList;

/* compiled from: ModePanelData */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f4297a = null;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<a> f4298b = null;
    private Activity c = null;
    private boolean d = false;

    public b(Activity activity) {
        this.c = activity;
        a();
    }

    public void a() {
        e.a("ModePanelData", "init");
        this.f4297a = new ArrayList<>();
        this.f4298b = new ArrayList<>();
        b();
        c();
        this.d = true;
    }

    public void a(int i) {
        if (-1 == c(i)) {
            if (9 == i) {
                this.f4298b.add(new a(this.c, 9, R.drawable.breeno_scan));
            } else if (17 == i) {
                int c2 = c(9);
                if (-1 != c2) {
                    this.f4298b.add(c2, new a(this.c, 17, R.drawable.ic_mode_soloop));
                } else {
                    this.f4298b.add(new a(this.c, 17, R.drawable.ic_mode_soloop));
                }
            } else {
                this.f4298b.add(new a(this.c, i));
            }
        }
    }

    public void b(int i) {
        int c2 = c(i);
        if (-1 != c2) {
            this.f4298b.remove(c2);
        }
    }

    public int c(int i) {
        for (int i2 = 0; i2 < this.f4298b.size(); i2++) {
            if (this.f4298b.get(i2).b() == i) {
                return i2;
            }
        }
        return -1;
    }

    public ArrayList<a> d(int i) {
        return a.c(i) ? this.f4297a : this.f4298b;
    }

    private void b() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STARRY_MODE)) {
            this.f4298b.add(new a(this.c, 19, R.drawable.ic_mode_starry));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            this.f4298b.add(new a(this.c, 14, R.drawable.multi_video_entry));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO)) {
            this.f4298b.add(new a(this.c, 2, R.drawable.ic_mode_slomo));
        }
        this.f4298b.add(new a(this.c, 1, R.drawable.ic_mode_timelapse));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT)) {
            this.f4298b.add(new a(this.c, 18, R.drawable.ic_mode_double_exposure));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MOVIE_MODE)) {
            this.f4298b.add(new a(this.c, 3, R.drawable.ic_mode_movie));
        }
        this.f4298b.add(new a(this.c, 4, R.drawable.ic_mode_pro));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_HIGH_RESOLUTION_SUPPORT)) {
            this.f4298b.add(new a(this.c, 11, R.drawable.ic_mode_ultra_high_resolution));
        }
        this.f4298b.add(new a(this.c, 0, R.drawable.ic_mode_panorama));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT)) {
            this.f4298b.add(new a(this.c, 8, R.drawable.ic_mode_superword));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ID_PHOTO)) {
            Util.o(this.c);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MACRO_MODE)) {
            this.f4298b.add(new a(this.c, 10, R.drawable.ic_mode_macro));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MICROSCOPE_SUPPORT)) {
            this.f4298b.add(new a(this.c, 16, R.drawable.ic_mode_microscope));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            this.f4298b.add(new a(this.c, 7, R.drawable.ic_mode_qshot));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_GROUP_SHOT)) {
            this.f4298b.add(new a(this.c, 15, R.drawable.ic_mode_qshot));
        }
        if (Util.v(this.c)) {
            this.f4298b.add(new a(this.c, 17, R.drawable.ic_mode_soloop));
        }
    }

    private void c() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            this.f4297a.add(new a(this.c, 14, R.drawable.multi_video_entry));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) {
            this.f4297a.add(new a(this.c, 2, R.drawable.ic_mode_slomo));
        }
        this.f4297a.add(new a(this.c, 1, R.drawable.ic_mode_timelapse));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT)) {
            this.f4297a.add(new a(this.c, 18, R.drawable.ic_mode_double_exposure));
        }
        if (Util.X()) {
            this.f4297a.add(new a(this.c, 11, R.drawable.ic_mode_ultra_high_resolution));
        }
        this.f4297a.add(new a(this.c, 0, R.drawable.ic_mode_panorama));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ID_PHOTO)) {
            Util.o(this.c);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            this.f4297a.add(new a(this.c, 7, R.drawable.ic_mode_qshot));
        }
    }
}
