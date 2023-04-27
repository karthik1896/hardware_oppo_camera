package com.oppo.camera.j;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e.b;
import com.oppo.camera.f.f;
import com.oppo.camera.statistics.model.FilmModeMsgData;
import com.oppo.camera.ui.control.MainShutterButton;
import com.oppo.camera.ui.control.ThumbImageView;
import com.oppo.camera.util.Util;
import java.util.ArrayList;

/* compiled from: FilmUIControlV1 */
public class r extends a {
    public r(Activity activity, f fVar, b bVar, ViewGroup viewGroup) {
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
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR) && this.c.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.topMargin = this.f3343b.getResources().getDimensionPixelSize(R.dimen.movie_mode_back_top) + j().getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
            this.c.setLayoutParams(layoutParams);
        }
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g().b(false).c(true).c((int) R.drawable.movie_mode_menu_bg).b((int) R.drawable.icon_show).a((int) R.drawable.icon_hide));
        arrayList.add(new g().a(f()).c((int) R.drawable.movie_mode_menu_bg).a((int) R.drawable.icon_tool_grid_light).b((int) R.drawable.icon_tool_grid));
        arrayList.add(new g().a(g()).c((int) R.drawable.movie_mode_menu_bg).a((int) R.drawable.super_eis_light).b((int) R.drawable.super_eis_normal));
        arrayList.add(new g().a(c()).c((int) R.drawable.movie_mode_menu_bg).a((int) R.drawable.menu_flash_torch_light).b((int) R.drawable.menu_flash_off_dark));
        if (this.i == null) {
            this.i = new e(arrayList, this.j, false);
        }
        this.h.setAdapter(this.i);
    }

    private void d(boolean z) {
        if (this.f3342a != null) {
            this.f3342a.b(z);
            this.f3342a.d();
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
            d(false);
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
            if (this.d != null) {
                this.d.av();
            }
            this.j.edit().remove("pref_film_video_eis_and_flash_enable").apply();
        }
    }

    public void i() {
        if (this.i != null && this.i.getCount() != 0) {
            this.i.getItem(3).a(c());
            this.i.getItem(2).a(g());
            this.i.getItem(1).a(f());
        }
    }

    public void b(View view, View view2, int i) {
        boolean z = this.d != null && !this.d.O() && !this.d.P() && !(view2.getTag() instanceof Boolean ? ((Boolean) view2.getTag()).booleanValue() : false);
        if (j() != null && this.i != null && this.f3342a != null && !this.f3342a.a() && z) {
            g a2 = this.i.getItem(i);
            a2.a(!a2.d());
            boolean z2 = i == 0;
            if (z2) {
                boolean c = this.f3342a.c();
                a2.e(true);
                if (!a2.d() || c) {
                    d(false);
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
            if (3 == i) {
                a(a2);
            }
            if (2 == i) {
                b(a2);
            }
            if (1 == i) {
                c(a2);
            }
            if (this.j != null && z2) {
                this.j.edit().putBoolean("pref_film_show_ui_default", a2.d()).apply();
            }
            d(i, a2.d());
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

    private void a(g gVar) {
        if (gVar != null && this.g != null && this.j != null) {
            if (gVar.d()) {
                a(true, 1);
                a(true, 0);
                this.j.edit().putString("pref_camera_film_mode_key", "torch").apply();
                return;
            }
            this.j.edit().putString("pref_camera_film_mode_key", "off").apply();
        }
    }

    private void b(g gVar) {
        if (gVar != null && this.j != null) {
            if (gVar.d()) {
                this.j.edit().putString("pref_film_video_eis_menu", "on").apply();
            } else {
                this.j.edit().putString("pref_film_video_eis_menu", "off").apply();
            }
        }
    }

    private void c(g gVar) {
        if (gVar != null && this.j != null) {
            if (gVar.d()) {
                this.j.edit().putString("pref_film_video_guide_line", "grid").apply();
            } else {
                this.j.edit().putString("pref_film_video_guide_line", "off").apply();
            }
        }
    }

    public void l() {
        if (this.i != null && c()) {
            g a2 = this.i.getItem(3);
            a2.a(false);
            a(a2);
            this.i.a(this.h, 3);
        }
    }

    public void m() {
        if (this.i != null && this.h != null) {
            g a2 = this.i.getItem(3);
            if (a2.d() != c()) {
                a2.a(c());
                this.i.a(this.h, 3);
            }
        }
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
                filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_GRID;
                if (!z) {
                    str = "2";
                }
                filmModeMsgData.mFuncKeyResult = str;
            } else if (i == 2) {
                filmModeMsgData.mFuncKeyId = FilmModeMsgData.FUNC_KEY_ID_EIS;
                if (!z) {
                    str = "2";
                }
                filmModeMsgData.mFuncKeyResult = str;
            } else if (i == 3) {
                filmModeMsgData.mFuncKeyId = "3";
                if (!z) {
                    str = "2";
                }
                filmModeMsgData.mFuncKeyResult = str;
            }
            filmModeMsgData.report();
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.i != null && this.h != null) {
            g a2 = this.i.getItem(3);
            a2.a(z);
            a2.d(z2);
            this.i.a(this.h, 3);
        }
    }

    public void b(boolean z, boolean z2) {
        if (this.i != null && this.h != null) {
            g a2 = this.i.getItem(2);
            a2.a(z);
            a2.d(z2);
            this.i.a(this.h, 2);
        }
    }
}
