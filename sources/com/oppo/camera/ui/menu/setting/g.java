package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.InverseImageView;
import com.oppo.camera.ui.inverse.a;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.OppoTextView;
import com.oppo.camera.ui.menu.d;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: CameraMenuOptionDrawerItem */
public class g extends CameraMenuOption implements View.OnClickListener, a {
    private String o = null;
    private PopupWindow p = null;
    private String q = null;
    private View r = null;
    private OppoTextView s;
    private Context t;
    private List<View> u = new ArrayList();
    private boolean v = false;

    public void a(boolean z, int i, int i2) {
    }

    public void c(boolean z) {
    }

    public g(k kVar, Context context, com.oppo.camera.ui.menu.a aVar, i iVar, f fVar, int i, String str) {
        super(kVar, context, aVar, iVar, fVar, i, str);
        this.t = context;
        W();
        this.c = true;
    }

    public void b() {
        e.b("CameraMenuOptionDrawerItem", "CameraMenuOptionDrawerItem, initCameraMenuOptionView");
        this.r = View.inflate(this.t, R.layout.menu_option_image, (ViewGroup) null);
        this.r.setOnClickListener(this);
        this.s = (OppoTextView) this.r.findViewById(R.id.tv_title);
        this.s.setText(this.o);
        c.INS.registerInverse(this.r.getContext(), this.s);
        if (H() == 0) {
            FrameLayout frameLayout = (FrameLayout) this.r;
            for (int i = 0; i < O(); i++) {
                RotateImageView rotateImageView = new RotateImageView(this.t);
                int dimensionPixelSize = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_width);
                int dimensionPixelSize2 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_height);
                int dimensionPixelSize3 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_space);
                int dimensionPixelSize4 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_last_space);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
                layoutParams.gravity = 8388629;
                layoutParams.setMarginEnd((dimensionPixelSize * i) + (dimensionPixelSize3 * i) + dimensionPixelSize4);
                int dimensionPixelSize5 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_padding_left_right);
                int dimensionPixelSize6 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_padding_top_bottom);
                rotateImageView.setPadding(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize6);
                d f = f((O() - i) - 1);
                if (f != null) {
                    rotateImageView.setImageDrawable(f.a());
                }
                frameLayout.addView(rotateImageView, layoutParams);
                this.u.add(rotateImageView);
                rotateImageView.setOnClickListener(this);
            }
        } else if (1 == H()) {
            FrameLayout frameLayout2 = (FrameLayout) this.r;
            int i2 = 0;
            while (i2 < O()) {
                OppoTextView oppoTextView = new OppoTextView(this.t);
                oppoTextView.setTextSize(0, (float) this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_size));
                int dimensionPixelSize7 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_width);
                int dimensionPixelSize8 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_height);
                int dimensionPixelSize9 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_space);
                int dimensionPixelSize10 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_text_last_space);
                int dimensionPixelSize11 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_text_padding);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimensionPixelSize7, dimensionPixelSize8);
                layoutParams2.gravity = 8388629;
                layoutParams2.setMarginEnd((dimensionPixelSize7 * i2) + (dimensionPixelSize9 * i2) + dimensionPixelSize10);
                oppoTextView.setGravity(17);
                oppoTextView.setMaxWidth(this.t.getResources().getDimensionPixelSize(R.dimen.drawer_text_max_width));
                oppoTextView.setSingleLine(true);
                oppoTextView.setEllipsize(TextUtils.TruncateAt.END);
                oppoTextView.setMarqueeRepeatLimit(6);
                oppoTextView.setPadding(dimensionPixelSize11, 0, dimensionPixelSize11, 0);
                oppoTextView.setText(i2 == 0 ? R.string.camera_slogan_assignment_on : R.string.camera_slogan_assignment_off);
                oppoTextView.setTextColor(-1);
                frameLayout2.addView(oppoTextView, layoutParams2);
                this.u.add(oppoTextView);
                oppoTextView.setOnClickListener(this);
                i2++;
            }
        } else if (2 == H()) {
            FrameLayout frameLayout3 = (FrameLayout) this.r;
            InverseImageView inverseImageView = new InverseImageView(this.t);
            int dimensionPixelSize12 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_set_icon_layout_width);
            int dimensionPixelSize13 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_set_icon_layout_height);
            int dimensionPixelSize14 = this.t.getResources().getDimensionPixelSize(R.dimen.drawer_set_icon_last_space);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(dimensionPixelSize12, dimensionPixelSize13);
            layoutParams3.gravity = 8388629;
            layoutParams3.setMarginEnd(dimensionPixelSize14);
            inverseImageView.setImageResource(R.drawable.sub_set_arrow_selector);
            if (1 == androidx.core.e.f.a(Locale.getDefault())) {
                inverseImageView.setRotation(180.0f);
            }
            frameLayout3.addView(inverseImageView, layoutParams3);
            c.INS.registerInverse(this.t, inverseImageView);
            inverseImageView.setOnClickListener(this);
        }
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

    public void a(String str, String str2, int i, int i2) {
        if (str2 != null && !str2.isEmpty() && this.p != null) {
            t();
        }
    }

    public void t() {
        PopupWindow popupWindow = this.p;
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                this.p.dismiss();
            }
            this.p = null;
        }
    }

    public void a(View view) {
        this.r = view;
    }

    public View F() {
        return this.r;
    }

    public void o() {
        double d;
        e.b("CameraMenuOptionDrawerItem", "updateMenuOptionView, index: " + T());
        boolean z = false;
        if (O() > 0) {
            if (J() != null && Q() && !TextUtils.isEmpty(N()) && "pref_camera_high_resolution_key".equals(a())) {
                int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.m.t()) / 100;
                if (configIntValue > 0) {
                    d = (double) configIntValue;
                } else {
                    d = Util.a(this.t, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.m.t()));
                }
                this.q = this.t.getString(R.string.camera_setting_submenu_high_resolution, new Object[]{Double.valueOf(d)});
                this.s.setText(this.q);
            }
            if (H() == 0) {
                for (int i = 0; i < O(); i++) {
                    RotateImageView rotateImageView = (RotateImageView) this.u.get((O() - i) - 1);
                    if (i == T()) {
                        rotateImageView.getDrawable().setTint(-16777216);
                        rotateImageView.setBackground(this.t.getDrawable(R.drawable.drawer_item_iv_background));
                    } else if (this.v) {
                        rotateImageView.getDrawable().setTint(this.t.getColor(R.color.inverse_text_color));
                        rotateImageView.setBackground(this.t.getDrawable(R.drawable.drawer_item_iv_background_grey_inverse));
                    } else {
                        rotateImageView.getDrawable().setTint(this.t.getColor(R.color.camera_white));
                        rotateImageView.setBackground(this.t.getDrawable(R.drawable.drawer_item_iv_background_grey));
                    }
                }
            } else if (1 == H()) {
                for (int i2 = 0; i2 < this.u.size(); i2++) {
                    TextView textView = (TextView) this.u.get(i2);
                    if (i2 == T()) {
                        textView.setTextColor(this.t.getColor(R.color.camera_white));
                        textView.setBackground(this.t.getDrawable(R.drawable.drawer_item_tv_background_grey));
                    } else {
                        textView.setTextColor(-16777216);
                        textView.setBackground(this.t.getDrawable(R.drawable.drawer_item_tv_background));
                    }
                }
            }
        }
        View view = this.r;
        if (view != null) {
            view.invalidate();
            View view2 = this.r;
            StringBuilder sb = new StringBuilder();
            sb.append(a().equals("pref_camera_high_resolution_key") ? this.q : this.o);
            sb.append(M());
            view2.setContentDescription(sb.toString());
        }
        if (R()) {
            if (T() != 0) {
                z = true;
            }
            c(z);
        }
    }

    public boolean a(String str, String... strArr) {
        if (!a().equals(str)) {
            return false;
        }
        e.b("CameraMenuOptionDrawerItem", "addMenuOptionItems, key: " + str);
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String l : strArr) {
            l(l);
        }
        if (this.f4164b == null) {
            return true;
        }
        k();
        return true;
    }

    public void onClick(View view) {
        if (this.k != null) {
            e.b("CameraMenuOptionDrawerItem", "onClick, Key: " + a());
            if (F() == null || F().isClickable()) {
                if (this.f4164b == null) {
                    i();
                }
                if (2 != S()) {
                    if (P()) {
                        int O = O();
                        if (com.oppo.camera.ui.menu.f.a()) {
                            com.oppo.camera.ui.menu.f.d();
                        }
                        int O2 = (O() - this.u.indexOf(view)) - 1;
                        if (H() == 0) {
                            if (T() != O2) {
                                g(O2);
                            } else {
                                e.d("CameraMenuOptionDrawerItem", "onClick, cancel, index unchanged");
                                return;
                            }
                        } else if (1 == H()) {
                            g(O2);
                        } else if (2 == H()) {
                            int i = this.n;
                            if (2 <= O) {
                                if (i < O - 1) {
                                    i++;
                                } else {
                                    O2 = 0;
                                    g(O2);
                                }
                            }
                            O2 = i;
                            g(O2);
                        }
                        e.b("CameraMenuOptionDrawerItem", "onClick, length: " + O + ", index: " + O2);
                        if (!"pref_filter_menu".equals(a())) {
                            o();
                        }
                    } else if (f()) {
                        n();
                    } else {
                        m();
                    }
                    boolean a2 = this.k.a(a(), false, true);
                    View view2 = this.r;
                    StringBuilder sb = new StringBuilder();
                    sb.append("pref_camera_high_resolution_key".equals(a()) ? this.q : this.o);
                    sb.append(M());
                    view2.setContentDescription(sb.toString());
                    e.b("CameraMenuOptionDrawerItem", "onClick, Key: " + a() + ", menuOptionClickResult: " + a2);
                    a(1.0f);
                }
            }
        }
    }

    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
    }

    public int x() {
        View view = this.r;
        if (view != null) {
            return view.getWidth();
        }
        return super.x();
    }

    public int y() {
        if (this.r != null) {
            return this.t.getResources().getDimensionPixelSize(R.dimen.drawer_height);
        }
        return super.y();
    }

    public void h(String str) {
        e.b("CameraMenuOptionDrawerItem", "setOptionItemText, text: " + str);
    }

    public void b(Drawable drawable, boolean z) {
        e.b("CameraMenuOptionDrawerItem", "setImageIcon, icon: " + drawable);
    }

    public void a(int i, boolean z) {
        super.a(i, z);
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            View view = this.u.get(i2);
            if (view instanceof RotateImageView) {
                ((RotateImageView) view).a(i, z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        if (this.r != null) {
            super.w();
            a((View) null);
        }
    }

    public void e(int i) {
        super.e(i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void W() {
        /*
            r6 = this;
            java.lang.String r0 = r6.a()
            java.lang.String r0 = com.oppo.camera.entry.b.c(r0)
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 1
            switch(r1) {
                case -1594132768: goto L_0x012e;
                case -1549661173: goto L_0x0123;
                case -1411115052: goto L_0x0119;
                case -1325782763: goto L_0x010e;
                case -1216190234: goto L_0x0103;
                case -1111095023: goto L_0x00f9;
                case -1063289942: goto L_0x00ef;
                case -609048017: goto L_0x00e4;
                case -530786764: goto L_0x00d9;
                case -408507050: goto L_0x00cf;
                case -229511348: goto L_0x00c3;
                case -156481052: goto L_0x00b8;
                case 23472237: goto L_0x00ac;
                case 82283425: goto L_0x00a1;
                case 197103307: goto L_0x0095;
                case 276021746: goto L_0x0089;
                case 279678802: goto L_0x007e;
                case 732950633: goto L_0x0072;
                case 796859654: goto L_0x0066;
                case 988585728: goto L_0x005a;
                case 1063692490: goto L_0x004e;
                case 1463159127: goto L_0x0042;
                case 1709159627: goto L_0x0036;
                case 1773908314: goto L_0x002a;
                case 1976199861: goto L_0x001f;
                case 2115588522: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0139
        L_0x0013:
            java.lang.String r1 = "pref_filter_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 11
            goto L_0x013a
        L_0x001f:
            java.lang.String r1 = "pref_camera_flashmode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = r2
            goto L_0x013a
        L_0x002a:
            java.lang.String r1 = "pref_video_hyper_lapse_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 22
            goto L_0x013a
        L_0x0036:
            java.lang.String r1 = "pref_video_super_eis_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 18
            goto L_0x013a
        L_0x0042:
            java.lang.String r1 = "pref_video_blur_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 20
            goto L_0x013a
        L_0x004e:
            java.lang.String r1 = "pref_raw_control_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 23
            goto L_0x013a
        L_0x005a:
            java.lang.String r1 = "pref_video_tilt_shift_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 15
            goto L_0x013a
        L_0x0066:
            java.lang.String r1 = "pref_super_raw_control_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 24
            goto L_0x013a
        L_0x0072:
            java.lang.String r1 = "pref_photo_tilt_shift_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 16
            goto L_0x013a
        L_0x007e:
            java.lang.String r1 = "key_video_hdr"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 3
            goto L_0x013a
        L_0x0089:
            java.lang.String r1 = "pref_camera_pi_ai_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 9
            goto L_0x013a
        L_0x0095:
            java.lang.String r1 = "pref_camera_pi_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 10
            goto L_0x013a
        L_0x00a1:
            java.lang.String r1 = "key_ultra_night_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 4
            goto L_0x013a
        L_0x00ac:
            java.lang.String r1 = "pref_high_resolution_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 12
            goto L_0x013a
        L_0x00b8:
            java.lang.String r1 = "pref_camera_torch_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 6
            goto L_0x013a
        L_0x00c3:
            java.lang.String r1 = "pref_subsetting_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 8
            goto L_0x013a
        L_0x00cf:
            java.lang.String r1 = "pref_camera_videoflashmode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = r3
            goto L_0x013a
        L_0x00d9:
            java.lang.String r1 = "pref_portrait_new_style_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 13
            goto L_0x013a
        L_0x00e4:
            java.lang.String r1 = "pref_portrait_blur_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 19
            goto L_0x013a
        L_0x00ef:
            java.lang.String r1 = "pref_camera_hdr_mode_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 2
            goto L_0x013a
        L_0x00f9:
            java.lang.String r1 = "key_ai_enhancement_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 5
            goto L_0x013a
        L_0x0103:
            java.lang.String r1 = "pref_video_filter_menu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 21
            goto L_0x013a
        L_0x010e:
            java.lang.String r1 = "pref_camera_timer_shutter_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 17
            goto L_0x013a
        L_0x0119:
            java.lang.String r1 = "pref_setting_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 7
            goto L_0x013a
        L_0x0123:
            java.lang.String r1 = "pref_camera_high_resolution_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 25
            goto L_0x013a
        L_0x012e:
            java.lang.String r1 = "pref_camera_photo_ratio_key"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0139
            r0 = 14
            goto L_0x013a
        L_0x0139:
            r0 = -1
        L_0x013a:
            r1 = 2131755589(0x7f100245, float:1.9142062E38)
            switch(r0) {
                case 0: goto L_0x02e8;
                case 1: goto L_0x02e8;
                case 2: goto L_0x02d8;
                case 3: goto L_0x02c8;
                case 4: goto L_0x02b8;
                case 5: goto L_0x02a8;
                case 6: goto L_0x0298;
                case 7: goto L_0x028c;
                case 8: goto L_0x027c;
                case 9: goto L_0x026b;
                case 10: goto L_0x025a;
                case 11: goto L_0x0249;
                case 12: goto L_0x0238;
                case 13: goto L_0x0227;
                case 14: goto L_0x0216;
                case 15: goto L_0x0208;
                case 16: goto L_0x01fa;
                case 17: goto L_0x01e9;
                case 18: goto L_0x01d8;
                case 19: goto L_0x01c7;
                case 20: goto L_0x01c7;
                case 21: goto L_0x01b6;
                case 22: goto L_0x01a5;
                case 23: goto L_0x0194;
                case 24: goto L_0x0183;
                case 25: goto L_0x0146;
                default: goto L_0x0140;
            }
        L_0x0140:
            java.lang.String r0 = ""
            r6.o = r0
            goto L_0x02f7
        L_0x0146:
            com.oppo.camera.ui.f r0 = r6.m
            int r0 = r0.t()
            java.lang.String r1 = "com.oplus.high.picturesize.name"
            int r0 = com.oppo.camera.aps.config.CameraConfig.getConfigIntValue(r1, r0)
            int r0 = r0 / 100
            if (r0 <= 0) goto L_0x0158
            double r0 = (double) r0
            goto L_0x016a
        L_0x0158:
            android.content.Context r0 = r6.t
            com.oppo.camera.ui.f r1 = r6.m
            int r1 = r1.t()
            java.lang.String r4 = "com.oplus.high.picturesize"
            android.util.Size r1 = com.oppo.camera.aps.config.CameraConfig.getSizeConfigValue(r4, r1)
            double r0 = com.oppo.camera.util.Util.a((android.content.Context) r0, (android.util.Size) r1)
        L_0x016a:
            android.content.Context r4 = r6.t
            android.content.res.Resources r4 = r4.getResources()
            r5 = 2131755587(0x7f100243, float:1.9142057E38)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r3[r2] = r0
            java.lang.String r0 = r4.getString(r5, r3)
            r6.o = r0
            goto L_0x02f7
        L_0x0183:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755700(0x7f1002b4, float:1.9142287E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x0194:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755513(0x7f1001f9, float:1.9141907E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x01a5:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755796(0x7f100314, float:1.9142481E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x01b6:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131756150(0x7f100476, float:1.91432E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x01c7:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755173(0x7f1000a5, float:1.9141218E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x01d8:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755823(0x7f10032f, float:1.9142536E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x01e9:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755590(0x7f100246, float:1.9142064E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x01fa:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x0208:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x0216:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755588(0x7f100244, float:1.914206E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x0227:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755480(0x7f1001d8, float:1.914184E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x0238:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755557(0x7f100225, float:1.9141997E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x0249:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755554(0x7f100222, float:1.914199E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x025a:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755559(0x7f100227, float:1.9142E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x026b:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755558(0x7f100226, float:1.9141999E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x027c:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755694(0x7f1002ae, float:1.9142275E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x028c:
            android.content.Context r0 = r6.t
            r1 = 2131755566(0x7f10022e, float:1.9142015E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x0298:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755562(0x7f10022a, float:1.9142007E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x02a8:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755127(0x7f100077, float:1.9141124E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x02b8:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755749(0x7f1002e5, float:1.9142386E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x02c8:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755789(0x7f10030d, float:1.9142467E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x02d8:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755556(0x7f100224, float:1.9141995E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
            goto L_0x02f7
        L_0x02e8:
            android.content.Context r0 = r6.t
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131755555(0x7f100223, float:1.9141993E38)
            java.lang.String r0 = r0.getString(r1)
            r6.o = r0
        L_0x02f7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "initMenuName, mMenuName: "
            r0.append(r1)
            java.lang.String r1 = r6.o
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CameraMenuOptionDrawerItem"
            com.oppo.camera.e.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.setting.g.W():void");
    }

    public void a(CameraMenuOption cameraMenuOption, int i) {
        super.a(cameraMenuOption, i);
    }

    public void setInverseColor(boolean z) {
        this.v = z;
        if (this.u.size() > 0) {
            o();
        }
    }
}
