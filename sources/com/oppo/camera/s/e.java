package com.oppo.camera.s;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.ui.control.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StarryUIControl */
public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f3607a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f3608b = 0;
    private boolean c = false;
    private Activity d;
    private Handler e;
    private com.oppo.camera.ui.e f;
    private ArrayList g = null;
    private a h = null;

    /* compiled from: StarryUIControl */
    public interface a {
        void a();
    }

    public e(Activity activity, com.oppo.camera.ui.e eVar, a aVar) {
        this.d = activity;
        this.f = eVar;
        this.h = aVar;
        this.e = new b();
    }

    /* compiled from: StarryUIControl */
    private class b extends Handler {
        private b() {
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                e.this.e();
            } else if (i == 2) {
                e.this.f();
            } else if (i == 3) {
                e.this.g();
                e eVar = e.this;
                eVar.b(eVar.f3607a);
                e.this.h();
            } else if (i == 4) {
                e.this.b((c) message.obj);
            }
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.f.a((int) R.string.camera_scene_starry_mode_fixed_tips_realme, -1, false, false, true);
        } else if (i == 2) {
            this.f.a(true, true, false);
            this.f.a(d(), 5000);
        }
    }

    private List<String> d() {
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            return arrayList;
        }
        this.g = new ArrayList();
        this.g.add(this.d.getResources().getString(R.string.camera_scene_night_tips));
        this.g.add(this.d.getResources().getString(R.string.camera_scene_night_light_collect_tips_realme));
        this.g.add(this.d.getResources().getString(R.string.camera_scene_night_image_optimizing_tips_realme));
        return this.g;
    }

    public void a(long j) {
        this.c = false;
        this.f3607a = j;
        this.e.removeMessages(1);
        this.e.sendEmptyMessage(3);
    }

    /* access modifiers changed from: private */
    public void b(long j) {
        c cVar = new c();
        cVar.a("button_color_inside_none");
        cVar.a(7);
        this.f.k((int) j);
        this.f.a(cVar);
        this.f.a(true, false);
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f3608b -= 1000;
        this.f.a(this.f3608b, false);
        if (this.f3608b > 0) {
            this.e.sendEmptyMessageDelayed(1, 1000);
        } else {
            this.e.sendEmptyMessage(2);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        com.oppo.camera.e.a("StarryUIControl", "doOnCountDownEnd");
        if (!this.c) {
            c cVar = new c();
            cVar.a("button_color_inside_none");
            cVar.a(4);
            this.f.a(cVar);
            this.f.g(true);
            return;
        }
        this.h.a();
    }

    /* access modifiers changed from: private */
    public void g() {
        this.f.f(4);
        this.f.j(4);
        this.f.b(4, true);
        this.f.h(4);
        this.f.a(4, false);
    }

    public void a() {
        this.e.removeCallbacksAndMessages((Object) null);
        this.f.g(true);
        this.f.b((int) R.string.camera_scene_starry_mode_fixed_tips_realme);
    }

    public void a(c cVar) {
        this.f3607a = 0;
        this.e.removeMessages(1);
        this.e.obtainMessage(4, cVar).sendToTarget();
    }

    /* access modifiers changed from: private */
    public void b(c cVar) {
        this.f.g();
        this.f.a((int) R.string.camera_scene_starry_mode_fixed_tips_realme, -1, false, false, true);
        this.f.d(true, true);
        this.f.a(cVar, false);
        this.f.g(true);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO)) {
            this.f.f(0);
        }
        this.f.b(0, true);
        this.f.j(0);
        this.f.h(0);
        this.f.af();
        this.f.a(0, true);
    }

    public void b() {
        this.c = true;
    }

    public void c() {
        this.d = null;
        this.f = null;
        this.e = null;
    }

    /* access modifiers changed from: private */
    public void h() {
        this.f.l(this.d.getResources().getDimensionPixelOffset(R.dimen.night_countdown_time_margin_top));
        this.f.a(this.f3607a, false);
        this.f3608b = this.f3607a;
        this.e.sendEmptyMessageDelayed(1, 1000);
    }
}
