package com.oppo.camera.j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.e.b;
import com.oppo.camera.f.f;
import com.oppo.camera.j.o;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.FilmModeMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.control.MainShutterButton;
import com.oppo.camera.ui.control.ThumbImageView;
import com.oppo.camera.util.Util;
import java.util.ArrayList;

/* compiled from: FilmUIControlV2 */
public class s extends a {
    private q q = null;
    /* access modifiers changed from: private */
    public n r = null;
    private GestureDetector s = null;

    public s(Activity activity, f fVar, b bVar, ViewGroup viewGroup) {
        super(activity);
        this.f3343b = activity;
        this.c.setRotation(90.0f);
        this.c.setOnClickListener(this);
        this.g = fVar;
        this.d = bVar;
        this.j = bVar.r();
        this.l = Util.b((Context) activity, (int) R.drawable.exposure_control_bar_bottom);
        this.m = (ThumbImageView) this.f3343b.findViewById(R.id.thumbnail);
        this.n = (MainShutterButton) this.f3343b.findViewById(R.id.shutter_button);
        this.o = viewGroup;
        this.s = new GestureDetector(j(), new a());
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR) && this.c.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.topMargin = this.f3343b.getResources().getDimensionPixelSize(R.dimen.movie_mode_back_top) + j().getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
            this.c.setLayoutParams(layoutParams);
        }
    }

    private void d(boolean z) {
        if (this.q == null) {
            this.q = new q(j());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(j().getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_width), -2);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        layoutParams.topMargin = j().getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_margin_top);
        B();
        this.q.setRotation(90.0f);
        this.o.removeView(this.q);
        this.q.setVisibility(8);
        this.o.addView(this.q, layoutParams);
        if (z) {
            Util.a((View) this.q, 0, (Animation.AnimationListener) null, 200);
        } else {
            this.q.setVisibility(0);
        }
        z();
    }

    private void z() {
        this.m = (ThumbImageView) this.f3343b.findViewById(R.id.thumbnail);
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        if (this.f3342a != null) {
            this.f3342a.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void e(boolean z) {
        q qVar = this.q;
        if (qVar != null) {
            if (z) {
                Util.a((View) qVar, 8, (Animation.AnimationListener) null, 200);
            } else {
                qVar.setVisibility(8);
            }
            this.o.removeView(this.q);
        }
        A();
    }

    private void A() {
        this.m = (ThumbImageView) this.f3343b.findViewById(R.id.thumbnail);
        if (this.m != null) {
            this.m.setVisibility(0);
        }
        if (this.k != null) {
            this.k.setVisibility(0);
        }
        if (this.f3342a != null) {
            this.f3342a.setVisibility(0);
        }
    }

    public void a() {
        e.a("FilmUIControlV2", "initMenuList");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g().b(false).c(true).c((int) R.drawable.movie_mode_menu_bg).b((int) R.drawable.icon_show).a((int) R.drawable.icon_hide));
        arrayList.add(new g().a(C()).c((int) R.drawable.movie_mode_menu_bg).a((int) R.drawable.submenu_open).b((int) R.drawable.submenu_close));
        arrayList.add(new g().a(b()).c((int) R.drawable.movie_mode_menu_bg).a((int) R.drawable.menu_log_on).b((int) R.drawable.menu_log_off));
        arrayList.add(new g().a(g()).c((int) R.drawable.movie_mode_menu_bg).a((int) R.drawable.super_eis_light).b((int) R.drawable.super_eis_normal));
        if (this.i == null) {
            this.i = new e(arrayList, this.j, true);
        }
        this.h.setAdapter(this.i);
    }

    private void B() {
        ArrayList arrayList = new ArrayList();
        Resources resources = j().getResources();
        arrayList.add(new o().b(0).a(resources.getString(R.string.camera_film_flash_mode)).a(b(resources.getString(R.string.camera_film_flash_mode))).a(c() ? 1 : 0).a((o.a) new o.a() {
            public void a(int i) {
                if (s.this.r != null) {
                    s.this.r.notifyDataSetChanged();
                }
                if (i == 0) {
                    s.this.g(false);
                } else if (1 == i) {
                    s.this.g(true);
                }
            }
        }));
        arrayList.add(new o().b(0).a(resources.getString(R.string.camera_setting_ratio)).a(d() ? 1 : 0).a(b(resources.getString(R.string.camera_setting_ratio))).a((o.a) new o.a() {
            public void a(int i) {
                if (s.this.r != null) {
                    s.this.r.notifyDataSetChanged();
                }
                if (i == 0) {
                    s.this.i(false);
                } else if (1 == i) {
                    s.this.i(true);
                }
            }
        }));
        arrayList.add(new o().b(1).a(resources.getString(R.string.camera_histogram)).a(e() ? 1 : 0).a(b(resources.getString(R.string.camera_histogram))).a((o.a) new o.a() {
            public void a(int i) {
                if (s.this.r != null) {
                    s.this.r.notifyDataSetChanged();
                }
                if (i == 0) {
                    s.this.j(false);
                } else if (1 == i) {
                    s.this.j(true);
                }
            }
        }));
        arrayList.add(new o().b(1).a(resources.getString(R.string.camera_assistant_line_title)).a(f() ? 1 : 0).a(b(resources.getString(R.string.camera_assistant_line_title))).a((o.a) new o.a() {
            public void a(int i) {
                if (s.this.r != null) {
                    s.this.r.notifyDataSetChanged();
                }
                if (i == 0) {
                    s.this.h(false);
                } else if (1 == i) {
                    s.this.h(true);
                }
            }
        }));
        if (this.r == null) {
            this.r = new n(j(), arrayList);
        }
        this.q.setAdapter(this.r);
    }

    private ArrayList<p> b(String str) {
        ArrayList<p> arrayList = new ArrayList<>();
        Resources resources = j().getResources();
        if (str.equals(resources.getString(R.string.camera_film_flash_mode))) {
            arrayList.add(new p().c(0).a((int) R.drawable.menu_flash_off_dark_unselected).d(R.drawable.film_submenu_option_unselect_bg).b(R.drawable.menu_flash_off_dark_selected).e(R.drawable.film_submenu_option_select_bg).a("flash off"));
            arrayList.add(new p().c(1).a((int) R.drawable.menu_flash_torch_light_unselected).d(R.drawable.film_submenu_option_unselect_bg).b(R.drawable.menu_flash_torch_light_selected).e(R.drawable.film_submenu_option_select_bg).a("flash on"));
        } else if (str.equals(resources.getString(R.string.camera_setting_ratio))) {
            arrayList.add(new p().c(0).a((int) R.drawable.menu_1080p_unselect).d(R.drawable.film_submenu_option_unselect_bg).b(R.drawable.menu_1080p_select).e(R.drawable.film_submenu_option_select_bg));
            arrayList.add(new p().c(1).a((int) R.drawable.menu_4k_unselect).d(R.drawable.film_submenu_option_unselect_bg).b(R.drawable.menu_4k_select).e(R.drawable.film_submenu_option_select_bg));
        } else if (str.equals(resources.getString(R.string.camera_histogram))) {
            arrayList.add(new p().c(0));
            arrayList.add(new p().c(1));
        } else if (str.equals(resources.getString(R.string.camera_assistant_line_title))) {
            arrayList.add(new p().c(0));
            arrayList.add(new p().c(1));
        }
        return arrayList;
    }

    public boolean d() {
        return this.j != null && this.j.getString("pref_film_video_size_4k", "on").equals("on");
    }

    /* access modifiers changed from: private */
    public boolean C() {
        q qVar = this.q;
        return (qVar == null || qVar.getVisibility() != 0 || -1 == this.o.indexOfChild(this.q)) ? false : true;
    }

    private void f(boolean z) {
        if (this.f3342a != null) {
            this.f3342a.b(z);
            this.f3342a.d();
        }
        if (C()) {
            e(true);
            this.i.getItem(1).a(false);
            this.i.a(this.h, 1);
        }
        if (this.e != null && -1 != this.f) {
            int i = this.f;
            this.f = -1;
            this.e.getItem(i).b(false);
            a(i);
        }
    }

    public void a(ViewGroup viewGroup) {
        if (!(this.f3342a == null || viewGroup == null || viewGroup.indexOfChild(this.f3342a) < 0)) {
            f(false);
            viewGroup.removeView(this.f3342a);
        }
        if (this.i != null && this.h != null) {
            this.i.getItem(0).a(false);
            this.i.getItem(0).f(false);
            this.i.getItem(0).e(true);
            this.i.a(this.h, 0, false);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.movie_mode_back) {
            if (C()) {
                e(false);
                this.i.getItem(1).a(false);
                this.i.a(this.h, 1);
            }
            if (this.d != null) {
                this.d.av();
            }
            this.j.edit().remove("pref_film_video_eis_and_flash_enable").apply();
        }
    }

    public void i() {
        if (this.i != null && this.i.getCount() != 0) {
            this.i.getItem(3).a(g());
            this.i.getItem(2).a(b());
        }
    }

    public void b(View view, View view2, int i) {
        q qVar;
        boolean z = this.d != null && !this.d.O() && !this.d.P() && !(view2.getTag() instanceof Boolean ? ((Boolean) view2.getTag()).booleanValue() : false);
        if (j() == null || this.i == null || this.f3342a == null || this.f3342a.a() || (((qVar = this.q) != null && qVar.a()) || !z)) {
            e.b("FilmUIControlV2", "onMenuItemClick is intercepted, return");
            return;
        }
        g a2 = this.i.getItem(i);
        a2.a(!a2.d());
        boolean z2 = i == 0;
        if (z2) {
            boolean c = this.f3342a.c();
            a2.e(true);
            if (!a2.d() || c) {
                f(false);
            } else {
                this.f3342a.b();
            }
            if (this.d == null || this.d.ag() || c) {
                a2.f(true);
                this.i.a(this.h, i, this.i.a(), !a2.d());
            } else {
                a2.f(false);
                this.i.a(this.h, i, true);
            }
        } else {
            this.i.a(this.h, i);
        }
        if (1 == i) {
            b(a2);
        }
        if (2 == i) {
            c(a2);
        }
        if (3 == i) {
            a(a2);
        }
        if (this.j != null && z2) {
            this.j.edit().putBoolean("pref_film_show_ui_default", a2.d()).apply();
        }
        d(i, a2.d());
    }

    public void q() {
        super.q();
        if (C()) {
            e(false);
            this.i.getItem(1).a(false);
            this.i.a(this.h, 1);
        }
    }

    public void k() {
        if (j() != null && this.i != null && this.h != null && this.j != null && this.f3342a != null && this.i.getCount() != 0 && !this.i.a() && this.j.getBoolean("pref_film_show_ui_default", true)) {
            g a2 = this.i.getItem(0);
            a2.a(true);
            a2.f(false);
            a2.e(true);
            this.f3342a.b();
            this.i.a(this.h, 0, true);
        }
    }

    /* access modifiers changed from: private */
    public void g(boolean z) {
        if (this.g != null && this.j != null) {
            if (z) {
                a(true, 1);
                a(true, 0);
                this.j.edit().putString("pref_camera_film_mode_key", "torch").apply();
            } else {
                this.j.edit().putString("pref_camera_film_mode_key", "off").apply();
            }
            a("3");
        }
    }

    private void a(g gVar) {
        if (gVar != null && this.j != null) {
            if (gVar.d()) {
                this.j.edit().putString("pref_film_video_eis_menu", "on").apply();
            } else {
                this.j.edit().putString("pref_film_video_eis_menu", "off").apply();
            }
        }
    }

    /* access modifiers changed from: private */
    public void h(boolean z) {
        if (this.j != null) {
            this.j.edit().putString("pref_film_video_guide_line", z ? "grid" : "off").apply();
            a(FilmModeMsgData.FUNC_KEY_ID_GRID);
        }
    }

    /* access modifiers changed from: private */
    public void i(boolean z) {
        if (this.j != null) {
            this.j.edit().putString("pref_film_video_size_4k", z ? "on" : "off").apply();
            a(FilmModeMsgData.FUNC_KEY_ID_MENU_RESOLUTION);
        }
    }

    /* access modifiers changed from: private */
    public void j(boolean z) {
        if (this.j != null) {
            this.j.edit().putString("pref_film_video_histogram", z ? "on" : "off").apply();
            a(FilmModeMsgData.FUNC_KEY_ID_HISTOGRAM);
        }
    }

    private void b(g gVar) {
        if (gVar == null) {
            return;
        }
        if (gVar.d()) {
            d(true);
        } else {
            e(true);
        }
    }

    private void c(g gVar) {
        if (gVar != null && this.j != null) {
            if (gVar.d()) {
                this.j.edit().putString("pref_film_video_log", "on").apply();
            } else {
                this.j.edit().putString("pref_film_video_log", "off").apply();
            }
        }
    }

    public void l() {
        n nVar = this.r;
        if (nVar != null) {
            o a2 = nVar.getItem(0);
            if (1 == a2.a()) {
                a2.a(0);
            }
            this.r.notifyDataSetChanged();
        }
        g(false);
    }

    public void n() {
        this.p = true;
        if (this.d != null && this.i != null && this.i.a() && this.i.getCount() > 0) {
            g a2 = this.i.getItem(0);
            a2.a(true);
            a2.e(false);
            a2.f(false);
            this.i.a(this.h, 0, true, false);
        }
        if (this.k != null) {
            Util.a((View) this.k, 8, (Animation.AnimationListener) null, 200);
        }
        if (this.c != null) {
            Util.a((View) this.c, 8, (Animation.AnimationListener) null, 200);
        }
        if (!(this.f3342a == null || this.f3342a.getVisibility() == 0 || this.i == null || (!this.i.a() && !C()))) {
            Util.a((View) this.f3342a, 0, (Animation.AnimationListener) null, 200);
        }
        q qVar = this.q;
        if (qVar != null) {
            Util.a((View) qVar, 8, (Animation.AnimationListener) null, 200);
            this.i.getItem(1).a(false);
            this.i.a(this.h, 1);
        }
    }

    public DcsMsgData a(VideoRecordMsgData videoRecordMsgData) {
        VideoRecordMsgData videoRecordMsgData2 = (VideoRecordMsgData) super.a(videoRecordMsgData);
        String str = "on";
        videoRecordMsgData.mIsHistogramOpen = e() ? str : "off";
        if (!b()) {
            str = "off";
        }
        videoRecordMsgData.mIsLog = str;
        return videoRecordMsgData;
    }

    public void o() {
        this.p = false;
        boolean z = this.f3342a != null && this.f3342a.c();
        if (this.d != null && this.i != null && !this.i.a() && z && this.i.getCount() > 0) {
            g a2 = this.i.getItem(0);
            a2.a(true);
            a2.e(false);
            a2.f(false);
            this.i.a(this.h, 0, true);
        }
        if (this.k != null) {
            Util.a((View) this.k, 0, (Animation.AnimationListener) null, 200);
        }
        if (this.c != null) {
            Util.a((View) this.c, 0, (Animation.AnimationListener) null, 200);
        }
    }

    private void d(int i, boolean z) {
        if (this.f3343b != null) {
            FilmModeMsgData filmModeMsgData = new FilmModeMsgData(j());
            filmModeMsgData.buildEventId(FilmModeMsgData.EVENT_FUNCTION_MENU_CLICK);
            if (this.d != null) {
                filmModeMsgData.mCameraId = this.d.aq();
            }
            if (this.j != null) {
                filmModeMsgData.mCaptureMode = this.j.getString("pref_camera_mode_key", "");
            }
            String str = "1";
            if (i == 0) {
                filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_MENU_SWITCH;
                if (!z) {
                    str = "2";
                }
                filmModeMsgData.mFuncKeyResult = str;
            } else if (i == 1) {
                filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_SUBMENU;
                if (!z) {
                    str = "2";
                }
                filmModeMsgData.mFuncKeyResult = str;
            } else if (i == 2) {
                filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_LOG;
                if (!z) {
                    str = "2";
                }
                filmModeMsgData.mFuncKeyResult = str;
            } else if (i == 3) {
                filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_EIS;
                if (!z) {
                    str = "2";
                }
                filmModeMsgData.mFuncKeyResult = str;
            }
            filmModeMsgData.report();
        }
    }

    public void b(boolean z, boolean z2) {
        if (this.i != null && this.h != null) {
            g a2 = this.i.getItem(3);
            a2.a(z);
            a2.d(z2);
            this.i.a(this.h, 3);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.s;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* compiled from: FilmUIControlV2 */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (s.this.C()) {
                s.this.e(true);
                s.this.i.getItem(1).a(false);
                s.this.i.a(s.this.h, 1);
            }
            return false;
        }
    }
}
