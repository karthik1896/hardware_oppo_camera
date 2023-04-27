package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.q;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.a;
import com.oppo.camera.ui.widget.d;
import com.oppo.camera.util.Util;
import java.util.List;

/* compiled from: CameraMenuOptionFirstLevel */
public class h extends CameraMenuOption implements View.OnClickListener, q.a {
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.menu.h o = null;
    private String p = null;
    private boolean q;
    private boolean r;
    /* access modifiers changed from: private */
    public d s;
    private String t;
    private a u;
    private String v;

    public h(k kVar, Context context, a aVar, i iVar, f fVar, int i, String str, boolean z) {
        super(kVar, context, aVar, iVar, fVar, i, str);
        boolean z2 = false;
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.u = aVar;
        this.f4163a = kVar;
        this.q = z;
        this.r = 5 == i ? true : z2;
        Y();
    }

    public void b() {
        this.o = new com.oppo.camera.ui.menu.h(this.j, this.m, this.q, V(), K(), this.r, this.f4163a);
        c.INS.registerInverse(this.j, this.o);
        this.o.setOnClickListener(this);
        this.o.setSizeRatioType(this.i);
        this.o.setMenuName(this.p);
        this.o.setImageDrawable(I());
        this.o.setForceDarkAllowed(false);
        this.o.setSwitchIconNeedAnim(this.u.getSwitchIconNeedAnim());
        this.o.setOffAnimIcon(U());
        super.b();
    }

    /* access modifiers changed from: protected */
    public void r() {
        super.r();
        if (this.k != null) {
            this.k.b(a());
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        super.s();
        if (this.k != null) {
            this.k.c(a());
        }
    }

    public List<com.oppo.camera.ui.menu.d> W() {
        a aVar = this.u;
        if (aVar != null) {
            return aVar.getOptionItems();
        }
        return null;
    }

    public void a(boolean z, int i, int i2) {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            hVar.a(z, i, i2);
        }
    }

    public void a(String str, String str2, int i, int i2) {
        if (str2 != null && !str2.isEmpty()) {
            if (this.s != null) {
                t();
            }
            if (this.o != null) {
                this.s = new d(this.j);
                this.s.a(true);
                this.s.setFocusable(false);
                this.s.a((CharSequence) str2);
                this.v = str;
                q.a().a(this);
                this.s.setTouchInterceptor(new View.OnTouchListener(str) {
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return h.this.a(this.f$1, view, motionEvent);
                    }
                });
                if (!this.s.isShowing()) {
                    try {
                        this.s.a(i, i2);
                        this.o.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                            public boolean onPreDraw() {
                                if (h.this.o == null || h.this.o.getWidth() <= 0) {
                                    return false;
                                }
                                h.this.o.getViewTreeObserver().removeOnPreDrawListener(this);
                                if (h.this.s == null) {
                                    return false;
                                }
                                h.this.s.a((View) h.this.o, 4);
                                return false;
                            }
                        });
                        this.o.invalidate();
                    } catch (WindowManager.BadTokenException e) {
                        e.d("CameraMenuOptionFirstLevel", "showMenuOptionTipsBubble, exception: " + e.getMessage());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(String str, View view, MotionEvent motionEvent) {
        e.a("CameraMenuOptionFirstLevel", "onTouch");
        t();
        if (!(this.f4163a == null || str == null)) {
            SharedPreferences.Editor edit = this.f4163a.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
        return false;
    }

    public void d(boolean z) {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            hVar.setShadowOn(z);
        }
    }

    public boolean G() {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            return hVar.getShadowOn();
        }
        return this.r;
    }

    public void t() {
        d dVar = this.s;
        if (dVar != null) {
            if (dVar.isShowing()) {
                this.s.dismiss();
            }
            this.s = null;
        }
    }

    public void a(View view) {
        this.o = (com.oppo.camera.ui.menu.h) view;
    }

    public View F() {
        return this.o;
    }

    public void b(boolean z) {
        X();
        String string = this.f4163a.getString("pref_subsetting_key", "off");
        if (this.f4164b != null) {
            this.f4164b.setDrawShadow(this.r && "off".equals(string));
        }
    }

    private void X() {
        if (!this.h) {
            b(J(), K());
        }
    }

    public void o() {
        double d;
        this.r = G();
        boolean z = true;
        if (O() <= 0) {
            b((Drawable) null, false);
        } else if (Q() && J() != null && !TextUtils.isEmpty(N())) {
            X();
            if (a().equals("pref_camera_high_resolution_key")) {
                int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.m.t()) / 100;
                if (configIntValue > 0) {
                    d = (double) configIntValue;
                } else {
                    d = Util.a(this.j, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.m.t()));
                }
                this.t = this.j.getString(R.string.camera_setting_submenu_high_resolution, new Object[]{Double.valueOf(d)});
                h(this.t);
            } else {
                h(N());
            }
        } else if (L() != null && B() == 1) {
            h((String) null);
            b(L(), K());
        } else if (J() != null) {
            h((String) null);
            X();
        } else if (!TextUtils.isEmpty(N())) {
            h(N());
            b((Drawable) null, false);
        }
        if (this.o != null) {
            if (a() != null && a().equals("pref_subsetting_key")) {
                this.o.setImageDrawable(I());
            }
            this.o.invalidate();
            com.oppo.camera.ui.menu.h hVar = this.o;
            StringBuilder sb = new StringBuilder();
            sb.append(a().equals("pref_camera_high_resolution_key") ? this.t : this.p);
            sb.append(M());
            hVar.setContentDescription(sb.toString());
        }
        if (R()) {
            if (T() == 0) {
                z = false;
            }
            c(z);
        }
    }

    public void onClick(View view) {
        if (this.k != null) {
            e.a("CameraMenuOptionFirstLevel", "onClick, Key: " + a());
            if (F() != null && !F().isClickable()) {
                return;
            }
            if (this.e) {
                e.a("CameraMenuOptionFirstLevel", "onClick, mbMenuItemRemoved: " + this.e);
                return;
            }
            if (this.f4164b == null) {
                i();
            }
            int i = 0;
            boolean a2 = this.k.a(a(), false, false);
            com.oppo.camera.ui.menu.h hVar = this.o;
            StringBuilder sb = new StringBuilder();
            sb.append(a().equals("pref_camera_high_resolution_key") ? this.t : this.p);
            sb.append(M());
            hVar.setContentDescription(sb.toString());
            if (!a2) {
                e.a("CameraMenuOptionFirstLevel", "onClick, onMenuButtonClick(Key): " + a() + " return false.");
                a(1.0f);
            } else if (2 != S()) {
                if (P()) {
                    int O = O();
                    if (com.oppo.camera.ui.menu.f.a()) {
                        com.oppo.camera.ui.menu.f.d();
                    }
                    int i2 = this.n;
                    if (O < 2) {
                        i = i2;
                    } else if (i2 < O - 1) {
                        i = i2 + 1;
                    }
                    g(i);
                    if (!a().equals("pref_filter_menu") && !a().equals("key_slow_video_frame_seek_bar_menu_key") && !a().equals("key_multicamera_type_menu_key")) {
                        o();
                    }
                } else if (f()) {
                    n();
                } else {
                    m();
                }
                a(1.0f);
            }
        }
    }

    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.o.setContentDescription(this.p);
    }

    public int x() {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            return hVar.getViewWidth();
        }
        return super.x();
    }

    public int y() {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            return hVar.getViewHeight();
        }
        return super.y();
    }

    public void h(String str) {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            hVar.setItemText(str);
        }
    }

    public void b(Drawable drawable, boolean z) {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            hVar.a(drawable, z);
        }
    }

    public void a(int i, boolean z) {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            hVar.a(i, z);
        }
        super.a(i, z);
    }

    /* access modifiers changed from: protected */
    public void w() {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            hVar.a();
            super.w();
            a((View) null);
        }
    }

    public void e(int i) {
        super.e(i);
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null) {
            hVar.setSizeRatioType(this.i);
        }
    }

    public int o(String str) {
        a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = this.u) != null && aVar.getOptionItems() != null && 1 <= this.u.getOptionItems().size()) {
            for (int i = 0; i < this.u.getOptionItems().size(); i++) {
                if (str.equals(this.u.getOptionItems().get(i).b())) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Y() {
        /*
            r5 = this;
            java.lang.String r0 = r5.a()
            java.lang.String r0 = com.oppo.camera.entry.b.c(r0)
            int r1 = r0.hashCode()
            switch(r1) {
                case -2072835425: goto L_0x015d;
                case -1913768701: goto L_0x0152;
                case -1671873609: goto L_0x0147;
                case -1594132768: goto L_0x013c;
                case -1411115052: goto L_0x0131;
                case -1325782763: goto L_0x0126;
                case -1216190234: goto L_0x011b;
                case -1111095023: goto L_0x0111;
                case -1063289942: goto L_0x0107;
                case -609048017: goto L_0x00fc;
                case -530786764: goto L_0x00f0;
                case -408507050: goto L_0x00e4;
                case -233391066: goto L_0x00d8;
                case -229511348: goto L_0x00cc;
                case -156481052: goto L_0x00c1;
                case 23472237: goto L_0x00b5;
                case 82283425: goto L_0x00aa;
                case 197103307: goto L_0x009e;
                case 276021746: goto L_0x0092;
                case 279678802: goto L_0x0087;
                case 796859654: goto L_0x007b;
                case 988585728: goto L_0x0070;
                case 1063692490: goto L_0x0064;
                case 1463159127: goto L_0x0058;
                case 1658068003: goto L_0x004c;
                case 1709159627: goto L_0x0040;
                case 1773908314: goto L_0x0034;
                case 1947940510: goto L_0x0028;
                case 1976199861: goto L_0x001d;
                case 2115588522: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0167
        L_0x0011:
            java.lang.String r1 = "pref_filter_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 12
            goto L_0x0168
        L_0x001d:
            java.lang.String r1 = "pref_camera_flashmode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 0
            goto L_0x0168
        L_0x0028:
            java.lang.String r1 = "key_slow_video_frame_seek_bar_menu_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 27
            goto L_0x0168
        L_0x0034:
            java.lang.String r1 = "pref_video_hyper_lapse_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 23
            goto L_0x0168
        L_0x0040:
            java.lang.String r1 = "pref_video_super_eis_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 18
            goto L_0x0168
        L_0x004c:
            java.lang.String r1 = "key_multicamera_type_menu_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 28
            goto L_0x0168
        L_0x0058:
            java.lang.String r1 = "pref_video_blur_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 20
            goto L_0x0168
        L_0x0064:
            java.lang.String r1 = "pref_raw_control_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 24
            goto L_0x0168
        L_0x0070:
            java.lang.String r1 = "pref_video_tilt_shift_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 3
            goto L_0x0168
        L_0x007b:
            java.lang.String r1 = "pref_super_raw_control_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 25
            goto L_0x0168
        L_0x0087:
            java.lang.String r1 = "key_video_hdr"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 2
            goto L_0x0168
        L_0x0092:
            java.lang.String r1 = "pref_camera_pi_ai_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 10
            goto L_0x0168
        L_0x009e:
            java.lang.String r1 = "pref_camera_pi_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 11
            goto L_0x0168
        L_0x00aa:
            java.lang.String r1 = "key_ultra_night_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 5
            goto L_0x0168
        L_0x00b5:
            java.lang.String r1 = "pref_high_resolution_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 14
            goto L_0x0168
        L_0x00c1:
            java.lang.String r1 = "pref_camera_torch_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 7
            goto L_0x0168
        L_0x00cc:
            java.lang.String r1 = "pref_subsetting_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 9
            goto L_0x0168
        L_0x00d8:
            java.lang.String r1 = "pref_intelligent_high_frame_selected_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 26
            goto L_0x0168
        L_0x00e4:
            java.lang.String r1 = "pref_camera_videoflashmode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 13
            goto L_0x0168
        L_0x00f0:
            java.lang.String r1 = "pref_portrait_new_style_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 15
            goto L_0x0168
        L_0x00fc:
            java.lang.String r1 = "pref_portrait_blur_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 19
            goto L_0x0168
        L_0x0107:
            java.lang.String r1 = "pref_camera_hdr_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 1
            goto L_0x0168
        L_0x0111:
            java.lang.String r1 = "key_ai_enhancement_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 6
            goto L_0x0168
        L_0x011b:
            java.lang.String r1 = "pref_video_filter_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 21
            goto L_0x0168
        L_0x0126:
            java.lang.String r1 = "pref_camera_timer_shutter_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 17
            goto L_0x0168
        L_0x0131:
            java.lang.String r1 = "pref_setting_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 8
            goto L_0x0168
        L_0x013c:
            java.lang.String r1 = "pref_camera_photo_ratio_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 16
            goto L_0x0168
        L_0x0147:
            java.lang.String r1 = "pref_platform_slow_video_fps_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 29
            goto L_0x0168
        L_0x0152:
            java.lang.String r1 = "pref_night_filter_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 22
            goto L_0x0168
        L_0x015d:
            java.lang.String r1 = "pref_video_timelapse_tilt_shift_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0167
            r0 = 4
            goto L_0x0168
        L_0x0167:
            r0 = -1
        L_0x0168:
            r1 = 2131755173(0x7f1000a5, float:1.9141218E38)
            r2 = 2131755554(0x7f100222, float:1.914199E38)
            r3 = 2131755589(0x7f100245, float:1.9142062E38)
            r4 = 2131755555(0x7f100223, float:1.9141993E38)
            switch(r0) {
                case 0: goto L_0x034a;
                case 1: goto L_0x033a;
                case 2: goto L_0x032a;
                case 3: goto L_0x031d;
                case 4: goto L_0x0310;
                case 5: goto L_0x0300;
                case 6: goto L_0x02f0;
                case 7: goto L_0x02e0;
                case 8: goto L_0x02d3;
                case 9: goto L_0x02c2;
                case 10: goto L_0x02b1;
                case 11: goto L_0x02a0;
                case 12: goto L_0x0292;
                case 13: goto L_0x0284;
                case 14: goto L_0x0273;
                case 15: goto L_0x0262;
                case 16: goto L_0x0251;
                case 17: goto L_0x0240;
                case 18: goto L_0x022f;
                case 19: goto L_0x0221;
                case 20: goto L_0x0213;
                case 21: goto L_0x0202;
                case 22: goto L_0x01f4;
                case 23: goto L_0x01e3;
                case 24: goto L_0x01d2;
                case 25: goto L_0x01c1;
                case 26: goto L_0x01b0;
                case 27: goto L_0x019f;
                case 28: goto L_0x018e;
                case 29: goto L_0x017d;
                default: goto L_0x0177;
            }
        L_0x0177:
            java.lang.String r0 = ""
            r5.p = r0
            goto L_0x0356
        L_0x017d:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755561(0x7f100229, float:1.9142005E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x018e:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755407(0x7f10018f, float:1.9141692E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x019f:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755658(0x7f10028a, float:1.9142201E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x01b0:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755343(0x7f10014f, float:1.9141563E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x01c1:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755700(0x7f1002b4, float:1.9142287E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x01d2:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755513(0x7f1001f9, float:1.9141907E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x01e3:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755796(0x7f100314, float:1.9142481E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x01f4:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r2)
            r5.p = r0
            goto L_0x0356
        L_0x0202:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131756150(0x7f100476, float:1.91432E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0213:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0221:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x022f:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755823(0x7f10032f, float:1.9142536E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0240:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755590(0x7f100246, float:1.9142064E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0251:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755588(0x7f100244, float:1.914206E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0262:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755480(0x7f1001d8, float:1.914184E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0273:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755557(0x7f100225, float:1.9141997E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0284:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r4)
            r5.p = r0
            goto L_0x0356
        L_0x0292:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r2)
            r5.p = r0
            goto L_0x0356
        L_0x02a0:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755559(0x7f100227, float:1.9142E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x02b1:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755558(0x7f100226, float:1.9141999E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x02c2:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755694(0x7f1002ae, float:1.9142275E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x02d3:
            android.content.Context r0 = r5.j
            r1 = 2131755566(0x7f10022e, float:1.9142015E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x02e0:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755562(0x7f10022a, float:1.9142007E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x02f0:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755127(0x7f100077, float:1.9141124E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0300:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755749(0x7f1002e5, float:1.9142386E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x0310:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r3)
            r5.p = r0
            goto L_0x0356
        L_0x031d:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r3)
            r5.p = r0
            goto L_0x0356
        L_0x032a:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755791(0x7f10030f, float:1.9142471E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x033a:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755556(0x7f100224, float:1.9141995E38)
            java.lang.String r0 = r0.getString(r1)
            r5.p = r0
            goto L_0x0356
        L_0x034a:
            android.content.Context r0 = r5.j
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r4)
            r5.p = r0
        L_0x0356:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.setting.h.Y():void");
    }

    public void c(boolean z) {
        com.oppo.camera.ui.menu.h hVar = this.o;
        if (hVar != null && this.q) {
            hVar.setSelected(z);
        }
    }

    public void a(int i, KeyEvent keyEvent) {
        e.a("CameraMenuOptionFirstLevel", "onKeyDown - keyCode: " + i);
        if (i == 24 || i == 25) {
            t();
            if (!(this.f4163a == null || this.v == null)) {
                SharedPreferences.Editor edit = this.f4163a.edit();
                edit.putBoolean(this.v, false);
                edit.apply();
            }
            q.a().b(this);
        }
    }
}
