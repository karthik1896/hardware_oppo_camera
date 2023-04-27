package com.oppo.camera.s;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.widget.c;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StarVideoUI */
class c {

    /* renamed from: a  reason: collision with root package name */
    private Activity f3602a = null;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f3603b = null;
    private e c = null;
    private int d = 0;
    private com.oppo.camera.ui.widget.c e = null;

    public c(Activity activity, SharedPreferences sharedPreferences, e eVar) {
        this.f3602a = activity;
        this.f3603b = sharedPreferences;
        this.c = eVar;
    }

    public void a(int i) {
        this.d = i;
        com.oppo.camera.ui.widget.c cVar = this.e;
        if (cVar != null) {
            cVar.a(i, true);
        }
    }

    public void a() {
        e eVar = this.c;
        if (eVar != null) {
            eVar.a((int) R.string.camera_scene_star_video_mode_fixed_tips, -1, false, false, true);
            b(false);
        }
    }

    public void a(int i, long j) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.a(j, (long) (i * 1000), true, false, 0);
            com.oppo.camera.e.c("StarVideoUI", "updateRecordingTime, recordingTime: " + j + ", videoTimeSec: " + i);
        }
    }

    public void b() {
        Activity activity = this.f3602a;
        if (activity != null && this.c != null) {
            activity.runOnUiThread(new Runnable() {
                public final void run() {
                    c.this.f();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        c(false);
        this.c.l(true);
        this.c.j(4);
        this.c.b(4, true);
        this.c.a(4, false);
        this.c.a(new com.oppo.camera.ui.control.c(5, "button_color_inside_red", "button_shape_dial_rotate", 1));
        this.c.a(true, false);
        a(0, 0);
        this.c.a(Float.valueOf(0.1f), this.f3602a.getResources().getDimensionPixelSize(R.dimen.record_time_margin_top), true);
        this.c.b((int) R.string.camera_scene_star_video_mode_fixed_tips);
        this.c.a(d(), 5000);
    }

    private List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f3602a.getResources().getString(R.string.camera_scene_night_tips));
        arrayList.add(this.f3602a.getResources().getString(R.string.camera_scene_night_light_collect_tips_realme));
        arrayList.add(this.f3602a.getResources().getString(R.string.camera_star_video_keep_battery_enough));
        return arrayList;
    }

    public void a(boolean z, com.oppo.camera.ui.control.c cVar, boolean z2) {
        com.oppo.camera.e.c("StarVideoUI", "hideRecordingUI");
        Activity activity = this.f3602a;
        if (activity != null) {
            activity.runOnUiThread(new Runnable(z, cVar, z2) {
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ c f$2;
                private final /* synthetic */ boolean f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    c.this.b(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(boolean z, com.oppo.camera.ui.control.c cVar, boolean z2) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.f(z);
            this.c.g();
            this.c.a((int) R.string.camera_scene_star_video_mode_fixed_tips, -1, false, false, true);
            this.c.a(cVar, false);
            this.c.b(0, true);
            this.c.a(0, true);
            this.c.y();
            b(false);
            if (z2) {
                this.c.af();
            }
        }
    }

    public void a(boolean z) {
        Activity activity = this.f3602a;
        if (activity != null) {
            activity.runOnUiThread(new Runnable(z) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    c.this.d(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(boolean z) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.f(z);
        }
    }

    public void b(boolean z) {
        if (this.e == null) {
            e();
        }
        this.e.a(this.f3603b.getInt("pref_star_video_record_total_time_key", 5400000));
        this.e.a(this.d, false);
        RelativeLayout i = this.c.i();
        int dimensionPixelSize = this.f3602a.getResources().getDimensionPixelSize(R.dimen.star_video_time_seekbar_width);
        int dimensionPixelSize2 = this.f3602a.getResources().getDimensionPixelSize(R.dimen.star_video_time_seekbar_height);
        int height = i.getHeight() - (this.f3602a.findViewById(R.id.control_panel_layout).getTop() - i.getTop());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, height);
        this.e.setLayoutParams(layoutParams);
        if (i.indexOfChild(this.e) < 0) {
            i.addView(this.e);
        }
        if (z) {
            Util.a((View) this.e, 0, (Animation.AnimationListener) null, 300);
        } else {
            this.e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        com.oppo.camera.ui.widget.c cVar;
        e eVar = this.c;
        if (eVar != null && eVar.b() != null && (cVar = this.e) != null) {
            if (z) {
                Util.a((View) cVar, 8, (Animation.AnimationListener) null, 300);
            } else {
                cVar.setVisibility(8);
            }
            this.c.b().removeView(this.e);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void e() {
        this.e = new com.oppo.camera.ui.widget.c(this.f3602a);
        this.e.setModeFrameChangeListener(new c.b() {
            public final void onSlowVideoFrameChange(int i) {
                c.this.b(i);
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c.a(3600000, this.f3602a.getString(R.string.camera_star_video_record_time_60m)));
        arrayList.add(new c.a(5400000, this.f3602a.getString(R.string.camera_star_video_record_time_90m)));
        arrayList.add(new c.a(7200000, this.f3602a.getString(R.string.camera_star_video_record_time_120m)));
        arrayList.add(new c.a(14400000, this.f3602a.getString(R.string.camera_star_video_record_time_240m)));
        this.e.setFrameList(arrayList);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i) {
        SharedPreferences sharedPreferences = this.f3603b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("pref_star_video_record_total_time_key", i).apply();
        }
    }

    public void c() {
        this.f3602a = null;
        this.f3603b = null;
        this.c = null;
    }
}
