package com.oppo.camera.j;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.e.b;
import com.oppo.camera.f.c;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.j.f;
import com.oppo.camera.j.h;
import com.oppo.camera.j.m;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.FilmModeMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.CommonComponent.SlideBar;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.SwitchCameraBar;
import com.oppo.camera.ui.control.MainShutterButton;
import com.oppo.camera.ui.control.ThumbImageView;
import com.oppo.camera.util.Util;
import com.oppo.exif.OppoExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: BaseFilmUIControl */
public class a implements View.OnClickListener, f.a, h.a, m.a, SlideBar.SlideBarValueChangeListener {

    /* renamed from: a  reason: collision with root package name */
    protected l f3342a = null;

    /* renamed from: b  reason: collision with root package name */
    protected Activity f3343b = null;
    protected RotateImageView c = null;
    protected b d = null;
    protected c e = null;
    protected int f = -1;
    protected com.oppo.camera.f.f g = null;
    protected f h = null;
    protected e i = null;
    protected SharedPreferences j = null;
    protected SwitchCameraBar k = null;
    protected Drawable l = null;
    protected ThumbImageView m = null;
    protected MainShutterButton n = null;
    protected ViewGroup o = null;
    protected boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    private boolean r = false;
    private Rect s = new Rect();
    private Handler t = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 && !a.this.q) {
                        a.this.h();
                    }
                } else if (!a.this.q) {
                    a.this.k();
                }
            } else if (message.obj != null && !a.this.q) {
                a.this.a((TotalCaptureResult) message.obj);
            }
        }
    };

    private String b(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : FilmModeMsgData.FUNC_KEY_ID_EV : FilmModeMsgData.FUNC_KEY_ID_FOCUS : FilmModeMsgData.FUNC_KEY_ID_WB : FilmModeMsgData.FUNC_KEY_ID_SHUTTER : FilmModeMsgData.FUNC_KEY_ID_ISO;
    }

    public void a() {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(boolean z, boolean z2) {
    }

    public boolean a(MotionEvent motionEvent) {
        return false;
    }

    public void b(View view, View view2, int i2) {
    }

    public void b(boolean z, boolean z2) {
    }

    public void i() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    public void onBarMoving() {
    }

    public void onClick(View view) {
    }

    public a(Activity activity) {
        this.c = (RotateImageView) activity.findViewById(R.id.movie_mode_back);
        if (this.c == null) {
            this.c = (RotateImageView) activity.getLayoutInflater().inflate(R.layout.view_movie_mode_back, (ViewGroup) activity.findViewById(R.id.camera)).findViewById(R.id.movie_mode_back);
        }
    }

    public void a(boolean z) {
        if (j() != null) {
            l lVar = this.f3342a;
            if (lVar == null) {
                int dimensionPixelSize = j().getResources().getDimensionPixelSize(R.dimen.movie_mode_params_min_width);
                this.f3342a = new l(j());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
                layoutParams.addRule(12);
                layoutParams.leftMargin = j().getResources().getDimensionPixelOffset(R.dimen.movie_mode_params_left);
                layoutParams.bottomMargin = j().getResources().getDimensionPixelSize(R.dimen.movie_mode_params_bottom) + Util.aj();
                layoutParams.rightMargin = j().getResources().getDimensionPixelSize(R.dimen.movie_mode_params_margin_right);
                this.e = new c(j(), A());
                this.f3342a.setId(R.id.movie_params_container_id);
                this.f3342a.a((BaseAdapter) this.e, (h.a) this);
                this.f3342a.setSlideBarValueChangeListener(this);
                this.f3342a.setSlideBarAutoListener(this);
                this.f3342a.setSlideAdapter(new j(j(), B()));
                this.o.addView(this.f3342a, layoutParams);
            } else if (this.o.indexOfChild(lVar) < 0) {
                this.o.addView(this.f3342a);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3342a.getLayoutParams();
            layoutParams2.bottomMargin = j().getResources().getDimensionPixelSize(R.dimen.movie_mode_params_bottom) + Util.aj();
            this.f3342a.setLayoutParams(layoutParams2);
            this.f3342a.setVisibility(8);
            b(true);
            b(this.o);
            C();
            this.e.a((ViewGroup) this.f3342a.getFilmModeBarLayout());
            if (this.k == null) {
                a(this.o, z);
            } else if (!z().equals(this.k.getSelectValue())) {
                this.k.setSelectValue(z());
                this.k.setSelectBg(z());
                b(z());
            }
            this.t.removeMessages(1);
            this.t.sendEmptyMessageDelayed(1, 300);
        }
    }

    private void b(ViewGroup viewGroup) {
        if (j() != null) {
            f fVar = this.h;
            if (fVar == null) {
                this.h = new f(j());
                this.h.setId(R.id.movie_menu_id);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(10);
                layoutParams.leftMargin = j().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_margin_left);
                layoutParams.topMargin = j().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_margin_top);
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR)) {
                    layoutParams.topMargin += j().getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
                }
                int dimensionPixelSize = j().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_width);
                this.h.setMenuItemClickListener(this);
                a();
                layoutParams.width = (dimensionPixelSize * this.i.getCount()) + ((this.i.getCount() - 1) * this.f3343b.getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_item_move_x));
                viewGroup.addView(this.h, layoutParams);
            } else if (viewGroup.indexOfChild(fVar) < 0) {
                viewGroup.addView(this.h);
            }
            this.h.setVisibility(8);
        }
    }

    private void a(ViewGroup viewGroup, boolean z) {
        Activity activity = this.f3343b;
        if (activity != null && this.j != null) {
            this.k = (SwitchCameraBar) activity.getLayoutInflater().inflate(R.layout.switch_camera_layout, viewGroup).findViewById(R.id.switch_camera_bar);
            this.k.a(z(), z);
            this.k.setRotation(90.0f);
            this.k.setClickListener(new SwitchCameraBar.a() {
                public void a(String str) {
                    if (!str.equals(a.this.z())) {
                        a.this.b(false);
                        a.this.j.edit().putString("pref_switch_camera_bar_key", str).apply();
                        a.this.a(FilmModeMsgData.FUNC_KEY_ID_SWITCH_CAMERA);
                        a.this.b(str);
                        a.this.C();
                        a.this.w();
                    }
                }

                public boolean a() {
                    if (a.this.d == null || a.this.d.O() || !a.this.d.ah() || a.this.d.h() != 1 || a.this.d.P() || a.this.f3342a == null || a.this.p || a.this.f3342a.a()) {
                        return false;
                    }
                    return true;
                }
            });
            this.k.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public String z() {
        String str = "camera_main";
        if (this.j == null) {
            return str;
        }
        boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT);
        SharedPreferences sharedPreferences = this.j;
        if (configBooleanValue) {
            str = "camera_ultra_wide";
        }
        return sharedPreferences.getString("pref_switch_camera_bar_key", str);
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        SharedPreferences sharedPreferences = this.j;
        return sharedPreferences != null && sharedPreferences.getString("pref_film_video_log", "off").equals("on");
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        SharedPreferences sharedPreferences = this.j;
        return sharedPreferences != null && sharedPreferences.getString("pref_camera_film_mode_key", "off").equals("torch");
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        SharedPreferences sharedPreferences = this.j;
        return sharedPreferences != null && sharedPreferences.getString("pref_film_video_size_4k", "on").equals("on");
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        SharedPreferences sharedPreferences = this.j;
        return sharedPreferences != null && sharedPreferences.getString("pref_film_video_histogram", "off").equals("on");
    }

    /* access modifiers changed from: protected */
    public boolean f() {
        SharedPreferences sharedPreferences = this.j;
        return sharedPreferences != null && sharedPreferences.getString("pref_film_video_guide_line", "off").equals("grid");
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        SharedPreferences sharedPreferences = this.j;
        return sharedPreferences != null && sharedPreferences.getString("pref_film_video_eis_menu", "on").equals("on");
    }

    public void h() {
        int i2;
        l lVar = this.f3342a;
        if (lVar != null) {
            lVar.a(true);
            this.f3342a.d();
        }
        c cVar = this.e;
        if (cVar != null && -1 != (i2 = this.f)) {
            this.f = -1;
            cVar.getItem(i2).b(false);
            a(i2);
        }
    }

    private List<i> A() {
        b bVar = this.d;
        if (bVar == null) {
            return new ArrayList();
        }
        j a2 = com.oppo.camera.f.a.a(bVar.aq());
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(a2.u(), a2.v(), a2.w()));
        long x = a2.x();
        arrayList.add(a(125000000 < x ? 125000000 : x, a2.y(), a2.a(256)));
        arrayList.add(a(a2.B()));
        arrayList.add(a(a2.n(), a2.m()));
        arrayList.add(a(a2.p(), a2.q(), a2.r()));
        return arrayList;
    }

    private void b(List<i> list) {
        if (list != null && list.size() != 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    a(i2, list.get(i2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    e.e("BaseFilmUIControl", "getItemData, initParamsDefault error index: " + i2);
                }
            }
        }
    }

    private void a(int i2, i iVar) {
        boolean z;
        String str;
        SharedPreferences sharedPreferences = this.j;
        if (sharedPreferences != null && this.f3343b != null) {
            boolean z2 = true;
            String str2 = "";
            if (i2 == 0) {
                String string = sharedPreferences.getString("pref_film_mode_iso", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                z = MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string);
                if (!z) {
                    str2 = iVar.c(a(Integer.valueOf(Integer.parseInt(string)).intValue(), iVar.a()));
                }
            } else if (i2 == 1) {
                String string2 = sharedPreferences.getString("pref_film_mode_shutter", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                z = MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string2);
                if (!z) {
                    str2 = iVar.c(a(Long.valueOf(Long.parseLong(string2)).longValue(), iVar.a()));
                }
            } else if (i2 == 2) {
                String string3 = sharedPreferences.getString("pref_film_mode_white_balance", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                z = MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string3);
                if (!z) {
                    str2 = iVar.c(a(Integer.valueOf(Integer.parseInt(string3)).intValue(), iVar.a()));
                }
            } else if (i2 != 3) {
                if (i2 == 4) {
                    String string4 = sharedPreferences.getString("pref_film_mode_exposure", (String) null);
                    if (string4 == null) {
                        str = iVar.c(a(0, iVar.a()));
                    } else {
                        str = iVar.c(a(Integer.valueOf(Integer.parseInt(string4)).intValue(), iVar.a()));
                    }
                    str2 = str;
                }
                z = false;
            } else {
                String string5 = sharedPreferences.getString("pref_film_mode_focus", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                z = MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string5);
                if (!z) {
                    iVar.a((int) R.drawable.profession_mf_selector);
                    str2 = iVar.c(a(Float.valueOf(Float.parseFloat(string5)).floatValue(), iVar.a()));
                } else {
                    iVar.a((int) R.drawable.profession_af_selector);
                }
            }
            if (z) {
                str2 = iVar.c(0);
            }
            iVar.a(z);
            iVar.c(str2);
            if (this.f != i2) {
                z2 = false;
            }
            iVar.b(z2);
        }
    }

    private i a(int i2, int i3, int i4) {
        i a2 = new i().a((int) R.drawable.profession_iso_selector).a(true);
        a(a2, i2, i3, i4);
        return a2;
    }

    private void a(i iVar, int i2, int i3, int i4) {
        if (i3 > i2) {
            i2 = i3;
        }
        ArrayList<String> a2 = iVar.a();
        ArrayList<String> b2 = iVar.b();
        if (i2 <= 0 || i4 <= 0 || i2 == i4) {
            e.e("BaseFilmUIControl", "generateIsoValues, return null, maxISOValue: " + i2 + ", minISOValue: " + i4 + ", maxISOValue: " + i2);
            return;
        }
        a2.clear();
        b2.clear();
        while (i4 <= i2) {
            a2.add(Integer.toString(i4));
            b2.add(Integer.toString(i4));
            i4 += 100;
        }
    }

    private i a(long j2, long j3, List<Size> list) {
        i b2 = new i().a((int) R.drawable.profession_shutter_selector).a(true).a(j().getResources().getStringArray(R.array.movie_exposure_time_values)).b(j().getResources().getStringArray(R.array.movie_exposure_time_names));
        a(b2, j2, j3, list);
        return b2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.oppo.camera.j.i r19, long r20, long r22, java.util.List<android.util.Size> r24) {
        /*
            r18 = this;
            r0 = r20
            r2 = r22
            java.util.ArrayList r4 = r19.a()
            java.util.ArrayList r5 = r19.b()
            r6 = 1
            if (r5 == 0) goto L_0x0051
            int r7 = r5.size()
            if (r7 <= 0) goto L_0x0051
            if (r4 == 0) goto L_0x0051
            int r7 = r4.size()
            if (r7 <= 0) goto L_0x0051
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = r18
            r9 = r24
            long r9 = r8.a((java.util.List<android.util.Size>) r9)
            float r9 = (float) r9
            java.lang.String r10 = "8000000"
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            long r10 = r10.longValue()
            float r10 = (float) r10
            float r9 = r9 / r10
            float r7 = r7 - r9
            float r7 = java.lang.Math.abs(r7)
            r9 = 1036831949(0x3dcccccd, float:0.1)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 > 0) goto L_0x0053
            int r7 = r5.size()
            int r7 = r7 - r6
            r5.remove(r7)
            int r7 = r4.size()
            int r7 = r7 - r6
            r4.remove(r7)
            goto L_0x0053
        L_0x0051:
            r8 = r18
        L_0x0053:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "generateShutterValues, max: "
            r7.append(r9)
            r7.append(r0)
            java.lang.String r9 = ", min: "
            r7.append(r9)
            r7.append(r2)
            java.lang.String r9 = ", before filtering, parameterNamesList: "
            r7.append(r9)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            java.lang.String r9 = "BaseFilmUIControl"
            com.oppo.camera.e.b(r9, r7)
            if (r5 == 0) goto L_0x012a
            if (r4 == 0) goto L_0x012a
            java.util.Iterator r7 = r5.iterator()
            r10 = -1
        L_0x0083:
            boolean r12 = r7.hasNext()
            java.lang.String r13 = "s"
            if (r12 == 0) goto L_0x00dc
            java.lang.Object r12 = r7.next()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r14 = "/"
            java.lang.String[] r12 = r12.split(r14)
            int r14 = r12.length
            r15 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            r17 = 0
            if (r6 >= r14) goto L_0x00b7
            r10 = r12[r17]
            double r10 = java.lang.Double.parseDouble(r10)
            r12 = r12[r6]
            java.lang.String[] r12 = r12.split(r13)
            r12 = r12[r17]
            double r12 = java.lang.Double.parseDouble(r12)
            double r10 = r10 / r12
        L_0x00b4:
            double r10 = r10 * r15
            long r10 = (long) r10
            goto L_0x00c7
        L_0x00b7:
            int r14 = r12.length
            if (r6 != r14) goto L_0x00c7
            r10 = r12[r17]
            java.lang.String[] r10 = r10.split(r13)
            r10 = r10[r17]
            double r10 = java.lang.Double.parseDouble(r10)
            goto L_0x00b4
        L_0x00c7:
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x00d8
            int r12 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x00d0
            goto L_0x00d8
        L_0x00d0:
            java.lang.String r12 = java.lang.String.valueOf(r10)
            r4.add(r12)
            goto L_0x0083
        L_0x00d8:
            r7.remove()
            goto L_0x0083
        L_0x00dc:
            int r2 = r4.size()
            int r2 = r2 - r6
            java.lang.Object r2 = r4.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            long r2 = java.lang.Long.parseLong(r2)
            r6 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r2 = r2 / r6
            long r6 = r0 / r6
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x010e
            java.lang.String r0 = java.lang.String.valueOf(r20)
            r4.add(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            r5.add(r0)
        L_0x010e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "generateShutterValues, after filtering, parameterValuesList: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ", parameterNamesList: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.b(r9, r0)
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.j.a.a(com.oppo.camera.j.i, long, long, java.util.List):void");
    }

    private i a(int[] iArr) {
        i a2 = new i().a(true).a((int) R.drawable.profession_wb_selector);
        a(a2, iArr);
        return a2;
    }

    private void a(i iVar, int[] iArr) {
        ArrayList<String> a2 = iVar.a();
        ArrayList<String> b2 = iVar.b();
        if (iArr == null || 2 > iArr.length) {
            e.e("BaseFilmUIControl", "generateWhiteBalanceValues, return, range: " + iArr);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("generateWhiteBalanceValues, min: ");
        sb.append(iArr[0]);
        sb.append(", max: ");
        sb.append(iArr[1]);
        e.b("BaseFilmUIControl", sb.toString());
        int i2 = iArr[0];
        int i3 = (iArr[1] - i2) / 100;
        if (i3 <= 0) {
            e.e("BaseFilmUIControl", "generateWhiteBalanceValues, return, valueNum: " + i3);
            return;
        }
        a2.clear();
        b2.clear();
        for (int i4 = 0; i4 <= i3; i4++) {
            int i5 = (100 * i4) + i2;
            a2.add(Integer.toString(i5));
            b2.add(i5 + OppoExifInterface.GpsSpeedRef.KILOMETERS);
        }
    }

    private i a(float f2, float f3) {
        i a2 = new i().a(true).a((int) R.drawable.profession_af_selector);
        a(a2, f2, f3);
        return a2;
    }

    private void a(i iVar, float f2, float f3) {
        if (f2 < f3) {
            float f4 = f3;
            f3 = f2;
            f2 = f4;
        }
        if (((float) Float.compare(f2, 0.0f)) <= 0.0f || Float.compare(f2, f3) == 0) {
            e.e("BaseFilmUIControl", "generateFocusValues, return, minFocusDistance: " + f2);
            return;
        }
        float f5 = (f2 - f3) / 50.0f;
        e.a("BaseFilmUIControl", "generateFocusValues, maxFocusDistance: " + f3 + ", minFocusDistance: " + f2);
        ArrayList<String> a2 = iVar.a();
        ArrayList<String> b2 = iVar.b();
        a2.clear();
        b2.clear();
        for (int i2 = 0; i2 <= 50; i2++) {
            float f6 = (float) i2;
            a2.add(Float.toString(f2 - (f5 * f6)));
            b2.add(String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f6 * 0.02f)}));
        }
    }

    private i a(int i2, int i3, float f2) {
        i a2 = new i().a(false).a((int) R.drawable.profession_ev_selector);
        a(a2, i2, i3, f2);
        return a2;
    }

    private void a(i iVar, int i2, int i3, float f2) {
        e.a("BaseFilmUIControl", "generateExposureCompensationValues, minIndex: " + i2 + ", maxValue: " + i3 + ", step: " + f2);
        if ((-1 == i2 && -1 == i3) || i2 > i3 || Float.compare(f2, 0.0f) == 0) {
            e.e("BaseFilmUIControl", "generateExposureCompensationValues, return, minIndex: " + i2 + ", maxIndex: " + i3);
            return;
        }
        ArrayList<String> a2 = iVar.a();
        ArrayList<String> b2 = iVar.b();
        a2.clear();
        b2.clear();
        while (i2 <= i3) {
            a2.add(String.valueOf(i2));
            b2.add(a(i2, f2));
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public String a(int i2, float f2) {
        float f3 = ((float) i2) * f2;
        if (0.0f < f3) {
            return "+" + String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f3)});
        }
        return String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f3)});
    }

    public long a(List<Size> list) {
        long j2 = 0;
        for (Size next : list) {
            if (((long) next.getWidth()) * ((long) next.getHeight()) > j2) {
                j2 = ((long) next.getWidth()) * ((long) next.getHeight());
            }
        }
        e.a("BaseFilmUIControl", "getMaxPictureSize, max: " + j2);
        return j2;
    }

    private List<k> B() {
        if (this.e == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int count = this.e.getCount();
        int i2 = 0;
        while (i2 < count) {
            i a2 = this.e.getItem(i2);
            k kVar = new k();
            kVar.b(a2.b().size());
            kVar.a(a2.b(a2.g()));
            kVar.b(4 != i2);
            kVar.a(a2.d());
            kVar.a(a2.g());
            arrayList.add(kVar);
            i2++;
        }
        return arrayList;
    }

    public void a(View view, View view2, int i2, long j2) {
        if (this.e != null && this.f3342a != null && view2 != null && view2.isEnabled()) {
            int i3 = this.f;
            if (-1 != i3) {
                this.e.getItem(i3).b(false);
                a(this.f);
            }
            this.f = i2;
            this.e.b(i2);
            i a2 = this.e.getItem(i2);
            a2.b(true);
            k a3 = this.f3342a.getSlideAdapter().getItem(i2);
            a3.a(a2.c(a3.b()));
            a(i2);
            a(b(this.f));
        }
    }

    public void a(int i2, boolean z) {
        d dVar = (d) this.f3342a.getFilmModeBarLayout().getChildAt(i2);
        if (dVar != null) {
            dVar.setEnabled(z);
            if (z) {
                dVar.setAlpha(1.0f);
                return;
            }
            dVar.setAlpha(0.5f);
            if (i2 == this.f) {
                this.t.removeMessages(2);
                this.t.sendEmptyMessage(2);
                return;
            }
            return;
        }
        e.e("BaseFilmUIControl", "setParamsBarItemEnable, item is null");
    }

    public void b(boolean z) {
        l lVar = this.f3342a;
        if (lVar != null && lVar.getFilmModeBarLayout() != null) {
            this.f3342a.getFilmModeBarLayout().setEnabled(z);
        }
    }

    public void a(View view, View view2, int i2) {
        c cVar = this.e;
        if (cVar != null && this.f3342a != null) {
            cVar.getItem(i2).b(false);
            a(this.f);
            this.f = -1;
            this.f3342a.a(true);
        }
    }

    public void onValueChange(int i2) {
        c cVar;
        int i3 = this.f;
        if (i3 >= 0 && this.f3342a != null && (cVar = this.e) != null) {
            i a2 = cVar.getItem(i3);
            a2.c(a2.c(i2));
            a2.a(false);
            if (3 == this.f) {
                a2.a((int) R.drawable.profession_mf_selector);
            }
            k a3 = this.f3342a.getSlideAdapter().getItem(this.f);
            a3.a(i2);
            a3.a(a2.g());
            a3.a(false);
            a3.c(false);
            String b2 = a2.b(i2);
            a(this.f);
            a3.c(true);
            if (!TextUtils.isEmpty(b2)) {
                if (4 == this.f) {
                    c cVar2 = this.e;
                    if (cVar2 != null && !cVar2.getItem(0).d()) {
                        a(true, 0);
                    }
                    c cVar3 = this.e;
                    if (cVar3 != null && !cVar3.getItem(1).d()) {
                        a(true, 1);
                    }
                }
                a(a3.c(), b2, this.f);
                a(this.f, a2.b(i2));
            }
        }
    }

    public void onActionUp() {
        int i2;
        if (this.f3342a != null && -1 != (i2 = this.f) && !this.r) {
            a(b(i2));
        }
    }

    public void onBarScrolling(boolean z) {
        int i2;
        if (this.r && !z && this.f3342a != null && -1 != (i2 = this.f)) {
            a(b(i2));
        }
        this.r = z;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, String str) {
        SharedPreferences sharedPreferences = this.j;
        if (sharedPreferences != null && this.f3343b != null) {
            if (i2 == 0) {
                sharedPreferences.edit().putString("pref_film_mode_iso", str).apply();
            } else if (i2 == 1) {
                sharedPreferences.edit().putString("pref_film_mode_shutter", str).apply();
            } else if (i2 == 2) {
                sharedPreferences.edit().putString("pref_film_mode_white_balance", str).apply();
            } else if (i2 == 3) {
                sharedPreferences.edit().putString("pref_film_mode_focus", str).apply();
            } else if (i2 == 4) {
                sharedPreferences.edit().putString("pref_film_mode_exposure", str).apply();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        d(i2, false);
    }

    private void d(int i2, boolean z) {
        l lVar = this.f3342a;
        if (lVar != null && this.e != null && -1 != i2) {
            if (this.f == i2) {
                lVar.setSlideSelected(i2);
            }
            View a2 = this.f3342a.a(i2);
            if (a2 == null) {
                return;
            }
            if (z) {
                this.e.b(a2, i2);
            } else {
                this.e.a(a2, i2);
            }
        }
    }

    public void a(boolean z, String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            if (i2 == 0) {
                e(Integer.parseInt(str), z);
            } else if (i2 == 1) {
                a(Long.parseLong(str), z);
            } else if (i2 == 2) {
                b(Integer.parseInt(str), z);
            } else if (i2 == 3) {
                a(Float.parseFloat(str), z);
            } else if (i2 == 4) {
                c(Integer.parseInt(str), z);
            }
        }
    }

    private void e(int i2, boolean z) {
        com.oppo.camera.f.f fVar = this.g;
        if (fVar == null) {
            return;
        }
        if (z) {
            fVar.m(-1);
            return;
        }
        e.a("BaseFilmUIControl", "setISOValue, back ISOValue: " + i2);
        l();
        this.g.m(i2);
    }

    public void a(long j2, boolean z) {
        if (this.g != null && j() != null) {
            if (z) {
                this.g.a(Long.valueOf(j().getResources().getString(R.string.camera_exposure_time_default_value)).longValue());
                return;
            }
            e.a("BaseFilmUIControl", "setExposureTime, slow shutter");
            l();
            this.g.f(false);
            this.g.a(j2);
        }
    }

    public void b(int i2, boolean z) {
        com.oppo.camera.f.f fVar = this.g;
        if (fVar != null) {
            if (z) {
                fVar.r();
            } else {
                try {
                    fVar.k(i2);
                } catch (NumberFormatException unused) {
                    this.g.r();
                }
            }
            e.a("BaseFilmUIControl", "setWhiteBalance, whiteBalance: " + i2);
        }
    }

    public void a(float f2, boolean z) {
        b bVar;
        com.oppo.camera.f.f fVar = this.g;
        if (fVar != null && (bVar = this.d) != null) {
            if (!z) {
                bVar.V();
                if (this.g != null) {
                    if (this.d.w()) {
                        this.d.b(false, false);
                    }
                    this.g.b(f2);
                }
            } else if (3 != fVar.p()) {
                this.g.a(3, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
                this.g.a((f.c) null);
            }
        }
    }

    public void c(int i2, boolean z) {
        if (this.g != null && j() != null) {
            if (z) {
                try {
                    this.g.f(Integer.valueOf(j().getResources().getString(R.string.camera_exposure_compensation_default_value)).intValue());
                    this.g.a((f.c) null);
                    e.a("BaseFilmUIControl", "setExposureCompensation, defaultValue: " + i2);
                } catch (Exception e2) {
                    e.e("BaseFilmUIControl", "setExposureCompensation, e: " + e2);
                }
            } else {
                try {
                    this.g.f(i2);
                    this.g.a((f.c) null);
                    e.a("BaseFilmUIControl", "setExposureCompensation, evValue: " + i2);
                } catch (Exception e3) {
                    e.e("BaseFilmUIControl", "setExposureCompensation, e: " + e3);
                }
            }
        }
    }

    public void c(boolean z) {
        a(z, this.f);
    }

    public void a(boolean z, int i2) {
        c cVar;
        if (-1 != i2 && (cVar = this.e) != null && this.f3342a != null) {
            i a2 = cVar.getItem(i2);
            if (z) {
                a2.d(a2.g());
            }
            a2.a(z);
            if (3 == i2) {
                a2.a(z ? R.drawable.profession_af_selector : R.drawable.profession_mf_selector);
            }
            k a3 = this.f3342a.getSlideAdapter().getItem(i2);
            a3.a(z);
            String b2 = a2.b(a3.b());
            if (!TextUtils.isEmpty(a2.h()) && !z) {
                b2 = a2.a(a2.h());
                a3.a(a2.b(a2.h()));
                a2.c(a2.h());
                a3.c(true);
                a3.a(a2.h());
            }
            a(a3.c(), b2, i2);
            a(i2);
            if (z) {
                a(i2, MenuClickMsgData.VALUE_PROFESSION_AUTO);
                return;
            }
            a2.d((String) null);
            a(i2, b2);
        }
    }

    public void a(ApsTotalResult apsTotalResult) {
        c cVar;
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null || (cVar = this.e) == null || cVar.getCount() == 0 || this.f3342a == null) {
            e.e("BaseFilmUIControl", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
            return;
        }
        TotalCaptureResult totalCaptureResult = (TotalCaptureResult) apsTotalResult.getTotalResult();
        Handler handler = this.t;
        if (handler != null) {
            handler.removeMessages(0);
            this.t.obtainMessage(0, totalCaptureResult).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    public void a(TotalCaptureResult totalCaptureResult) {
        CaptureResult.Key<int[]> key;
        if (Util.p()) {
            key = c.N;
        } else {
            key = c.aa;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        Long l2 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        int i2 = 0;
        Float f2 = (Float) totalCaptureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
        if (key != null) {
            try {
                i2 = Integer.valueOf(((int[]) totalCaptureResult.get(key))[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        j slideAdapter = this.f3342a.getSlideAdapter();
        if (slideAdapter != null) {
            a(num, slideAdapter);
            a(l2, slideAdapter);
            b(i2, slideAdapter);
            a(f2, slideAdapter);
        }
    }

    private void a(Integer num, j jVar) {
        int a2;
        i a3 = this.e.getItem(0);
        k a4 = jVar.getItem(0);
        if (num != null && a3 != null && a3.d() && (a2 = a(num.intValue(), a3.a())) >= 0 && this.f3342a != null) {
            a3.c(a3.c(a2));
            if (this.f3342a.b(a2)) {
                a4.a(a2);
                a4.a(a3.g());
            }
            d(0, true);
        }
    }

    private void a(Long l2, j jVar) {
        int a2;
        i a3 = this.e.getItem(1);
        k a4 = jVar.getItem(1);
        if (l2 != null && a3 != null && a3.d() && (a2 = a(l2.longValue(), a3.a())) >= 0 && this.f3342a != null) {
            a3.c(a3.c(a2));
            if (this.f3342a.b(a2)) {
                a4.a(a2);
                a4.a(a3.g());
            }
            d(1, true);
        }
    }

    private void b(Integer num, j jVar) {
        int a2;
        i a3 = this.e.getItem(2);
        k a4 = jVar.getItem(2);
        if (num != null && a3 != null && a3.d() && (a2 = a(num.intValue(), a3.a())) >= 0 && this.f3342a != null) {
            a3.c(a3.c(a2));
            if (this.f3342a.b(a2)) {
                a4.a(a2);
                a4.a(a3.g());
            }
            d(2, true);
        }
    }

    private void a(Float f2, j jVar) {
        int a2;
        i a3 = this.e.getItem(3);
        k a4 = jVar.getItem(3);
        if (f2 != null && a3 != null && a3.d() && (a2 = a(f2.floatValue(), a3.a())) >= 0 && this.f3342a != null) {
            a3.c(a3.c(a2));
            if (this.f3342a.b(a2)) {
                a4.a(a2);
                a4.a(a3.g());
            }
            d(3, true);
        }
    }

    private int a(int i2, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int abs = Math.abs(Integer.valueOf(arrayList.get(0)).intValue() - i2);
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            int intValue = Integer.valueOf(arrayList.get(i4)).intValue() - i2;
            if (Math.abs(intValue) < abs) {
                abs = Math.abs(intValue);
                i3 = i4;
            }
        }
        return i3;
    }

    private int a(float f2, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float abs = Math.abs(Float.valueOf(arrayList.get(0)).floatValue() - f2);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            float floatValue = Float.valueOf(arrayList.get(i3)).floatValue() - f2;
            if (Math.abs(floatValue) < abs) {
                abs = Math.abs(floatValue);
                i2 = i3;
            }
        }
        return i2;
    }

    private int a(long j2, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long abs = Math.abs(Long.valueOf(arrayList.get(0)).longValue() - j2);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            long longValue = Long.valueOf(arrayList.get(i3)).longValue() - j2;
            if (Math.abs(longValue) < abs) {
                abs = Math.abs(longValue);
                i2 = i3;
            }
        }
        return i2;
    }

    public Context j() {
        Activity activity = this.f3343b;
        if (activity == null) {
            return null;
        }
        return activity;
    }

    public void p() {
        if (j() != null) {
            this.q = false;
            l lVar = this.f3342a;
            if (lVar != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lVar.getLayoutParams();
                layoutParams.bottomMargin = j().getResources().getDimensionPixelSize(R.dimen.movie_mode_params_bottom) + Util.aj();
                this.f3342a.setLayoutParams(layoutParams);
            }
            if (this.n != null) {
                Resources resources = j().getResources();
                int w = Util.w();
                int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.control_panel_button_height);
                int dimensionPixelSize = (((dimensionPixelOffset / 2) + ((w - resources.getDimensionPixelSize(R.dimen.control_panel_margin_top)) - dimensionPixelOffset)) - (resources.getDimensionPixelSize(R.dimen.movie_mode_params_bottom) + Util.aj())) - (resources.getDimensionPixelSize(R.dimen.movie_mode_params_item_height) / 2);
                ObjectAnimator.ofFloat(this.n, "translationY", new float[]{(float) dimensionPixelSize}).setDuration(0).start();
            }
            b(true);
        }
    }

    public void q() {
        this.q = true;
        int i2 = this.f;
        if (-1 < i2) {
            a((View) null, (View) null, i2);
            l lVar = this.f3342a;
            if (lVar != null) {
                lVar.d();
            }
        }
        Handler handler = this.t;
        if (handler != null && handler.hasMessages(1)) {
            k();
        }
    }

    public void r() {
        l lVar = this.f3342a;
        if (lVar != null && !lVar.a()) {
            h();
        }
    }

    public void s() {
        i a2;
        c cVar = this.e;
        if (cVar != null && (a2 = cVar.getItem(3)) != null && !a2.d()) {
            a(true, 3);
        }
    }

    public void t() {
        Handler handler = this.t;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.t = null;
        }
        l lVar = this.f3342a;
        if (lVar != null) {
            lVar.setSlideBarAutoListener((m.a) null);
            this.f3342a.setSlideBarValueChangeListener((SlideBar.SlideBarValueChangeListener) null);
        }
        this.f3343b = null;
        this.j = null;
        this.d = null;
        this.g = null;
    }

    public void u() {
        if (this.j != null && this.f3343b != null) {
            b(true);
            String string = this.j.getString("pref_film_mode_iso", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            String string2 = this.j.getString("pref_film_mode_shutter", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            String string3 = this.j.getString("pref_film_mode_white_balance", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            String string4 = this.j.getString("pref_film_mode_focus", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            String string5 = this.j.getString("pref_film_mode_exposure", (String) null);
            if (!MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string)) {
                a(false, string, 0);
            } else {
                a(true, "0", 0);
            }
            if (!MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string2)) {
                a(false, string2, 1);
            } else {
                a(true, "0", 1);
            }
            if (!MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string3)) {
                a(false, string3, 2);
            } else {
                a(true, "0", 2);
            }
            if (!MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string4)) {
                a(false, string4, 3);
            } else {
                a(true, "0", 3);
            }
            if (string5 != null) {
                a(false, string5, 4);
            } else {
                a(true, "0", 4);
            }
        }
    }

    public void v() {
        String string = this.j.getString("pref_film_mode_focus", MenuClickMsgData.VALUE_PROFESSION_AUTO);
        if (!MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string)) {
            a(false, string, 3);
        } else {
            a(true, "0", 3);
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        c cVar = this.e;
        if (cVar != null && this.f3342a != null) {
            cVar.a(A());
            b(this.e.b());
            i();
            this.f3342a.a(B(), this.f);
        }
    }

    public void w() {
        c cVar = this.e;
        if (cVar != null && cVar.getCount() > 0) {
            int count = this.e.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (4 != i2) {
                    a(true, i2);
                } else {
                    String e2 = this.e.getItem(i2).e();
                    e.a("BaseFilmUIControl", "resetAllAuto, value: " + e2);
                    if ("camera_ultra_wide".equals(z()) && Integer.parseInt(this.j.getString("pref_film_mode_exposure", "0")) != Integer.parseInt(e2)) {
                        this.j.edit().putString("pref_film_mode_exposure", e2).apply();
                        a(i2);
                    }
                }
                this.e.getItem(i2).d((String) null);
            }
        }
    }

    public void x() {
        if (this.j != null) {
            e.a("BaseFilmUIControl", "resetFilmModeParams");
            this.j.edit().remove("pref_film_mode_iso").apply();
            this.j.edit().remove("pref_film_mode_shutter").apply();
            this.j.edit().remove("pref_film_mode_white_balance").apply();
            this.j.edit().remove("pref_film_mode_focus").apply();
            this.j.edit().remove("pref_film_mode_exposure").apply();
            this.j.edit().remove("pref_film_show_ui_default").apply();
            this.j.edit().remove("pref_switch_camera_bar_key").apply();
            a(true, "0", 0);
            a(true, "0", 1);
            a(true, "0", 2);
            a(true, "0", 3);
            a(true, "0", 4);
            this.r = false;
            c cVar = this.e;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public DcsMsgData a(VideoRecordMsgData videoRecordMsgData) {
        b bVar = this.d;
        if (bVar != null) {
            videoRecordMsgData.mCameraId = bVar.aq();
        }
        SharedPreferences sharedPreferences = this.j;
        if (sharedPreferences != null) {
            String str = "off";
            String string = sharedPreferences.getString("pref_camera_film_mode_key", str);
            videoRecordMsgData.mFlashTrigger = com.oppo.camera.a.a.a(string);
            videoRecordMsgData.mFlashMode = string;
            videoRecordMsgData.mMovieCameraId = z();
            videoRecordMsgData.mVideoMode = this.j.getString("pref_camera_mode_key", "");
            if (g()) {
                str = "on";
            }
            videoRecordMsgData.mMovieSteady = str;
            String string2 = this.j.getString("pref_film_mode_iso", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            String string3 = this.j.getString("pref_film_mode_shutter", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            String string4 = this.j.getString("pref_film_mode_white_balance", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            String string5 = this.j.getString("pref_film_mode_focus", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            String string6 = this.j.getString("pref_film_mode_exposure", MenuClickMsgData.VALUE_PROFESSION_AUTO);
            videoRecordMsgData.mMovieExpTime = a(1, string3, MenuClickMsgData.VALUE_PROFESSION_AUTO);
            videoRecordMsgData.mMovieIsoValue = a(0, string2, MenuClickMsgData.VALUE_PROFESSION_AUTO);
            videoRecordMsgData.mMovieFocusValue = b(3, string5, MenuClickMsgData.VALUE_PROFESSION_AUTO);
            videoRecordMsgData.mMovieEvValue = b(4, string6, "0");
            videoRecordMsgData.mMovieWbValue = a(2, string4, MenuClickMsgData.VALUE_PROFESSION_AUTO);
        }
        videoRecordMsgData.mIsAssistantLine = Boolean.toString(f());
        return videoRecordMsgData;
    }

    private String a(int i2, String str, String str2) {
        c cVar;
        if (this.f3343b == null || (cVar = this.e) == null || i2 >= cVar.getCount()) {
            return "";
        }
        if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(str) && !"0".equals(str2)) {
            return str2;
        }
        String e2 = this.e.getItem(i2).e();
        return TextUtils.isEmpty(e2) ? str2 : e2;
    }

    private String b(int i2, String str, String str2) {
        c cVar;
        if (this.f3343b == null || (cVar = this.e) == null || i2 >= cVar.getCount()) {
            return "";
        }
        if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(str) && !"0".equals(str2)) {
            return str2;
        }
        String g2 = this.e.getItem(i2).g();
        return TextUtils.isEmpty(g2) ? str2 : g2.replace("+", "");
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        if (this.f3343b != null) {
            FilmModeMsgData filmModeMsgData = new FilmModeMsgData(j());
            filmModeMsgData.buildEventId("funcValue_select");
            filmModeMsgData.mFuncKeyId = str;
            b bVar = this.d;
            if (bVar != null) {
                filmModeMsgData.mCameraId = bVar.aq();
            }
            SharedPreferences sharedPreferences = this.j;
            if (sharedPreferences != null) {
                filmModeMsgData.mCaptureMode = sharedPreferences.getString("pref_camera_mode_key", "");
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 51) {
                    if (hashCode != 1636) {
                        if (hashCode != 1638) {
                            if (hashCode != 1699) {
                                if (hashCode != 1722) {
                                    switch (hashCode) {
                                        case 1660:
                                            if (str.equals(FilmModeMsgData.FUNC_KEY_ID_SHUTTER)) {
                                                c2 = 5;
                                                break;
                                            }
                                            break;
                                        case 1661:
                                            if (str.equals(FilmModeMsgData.FUNC_KEY_ID_WB)) {
                                                c2 = 6;
                                                break;
                                            }
                                            break;
                                        case 1662:
                                            if (str.equals(FilmModeMsgData.FUNC_KEY_ID_FOCUS)) {
                                                c2 = 7;
                                                break;
                                            }
                                            break;
                                        case 1663:
                                            if (str.equals(FilmModeMsgData.FUNC_KEY_ID_EV)) {
                                                c2 = 8;
                                                break;
                                            }
                                            break;
                                        case 1664:
                                            if (str.equals(FilmModeMsgData.FUNC_KEY_ID_ISO)) {
                                                c2 = 9;
                                                break;
                                            }
                                            break;
                                    }
                                } else if (str.equals(FilmModeMsgData.FUNC_KEY_ID_MENU_RESOLUTION)) {
                                    c2 = 2;
                                }
                            } else if (str.equals(FilmModeMsgData.FUNC_KEY_ID_HISTOGRAM)) {
                                c2 = 3;
                            }
                        } else if (str.equals(FilmModeMsgData.FUNC_KEY_ID_SWITCH_CAMERA)) {
                            c2 = 0;
                        }
                    } else if (str.equals(FilmModeMsgData.FUNC_KEY_ID_GRID)) {
                        c2 = 4;
                    }
                } else if (str.equals("3")) {
                    c2 = 1;
                }
                String str2 = "on";
                String str3 = "off";
                switch (c2) {
                    case 0:
                        filmModeMsgData.mFuncKeyValue = z();
                        break;
                    case 1:
                        if (c()) {
                            str3 = "torch";
                        }
                        filmModeMsgData.mFuncKeyValue = str3;
                        break;
                    case 2:
                        filmModeMsgData.mFuncKeyValue = d() ? "4K" : "1080P";
                        break;
                    case 3:
                        if (!e()) {
                            str2 = str3;
                        }
                        filmModeMsgData.mFuncKeyValue = str2;
                        break;
                    case 4:
                        if (!f()) {
                            str2 = str3;
                        }
                        filmModeMsgData.mFuncKeyValue = str2;
                        break;
                    case 5:
                        filmModeMsgData.mFuncKeyValue = a(1, this.j.getString("pref_film_mode_shutter", MenuClickMsgData.VALUE_PROFESSION_AUTO), "0");
                        break;
                    case 6:
                        filmModeMsgData.mFuncKeyValue = a(2, this.j.getString("pref_film_mode_white_balance", MenuClickMsgData.VALUE_PROFESSION_AUTO), MenuClickMsgData.VALUE_PROFESSION_AUTO);
                        break;
                    case 7:
                        filmModeMsgData.mFuncKeyValue = b(3, this.j.getString("pref_film_mode_focus", MenuClickMsgData.VALUE_PROFESSION_AUTO), MenuClickMsgData.VALUE_PROFESSION_AUTO);
                        break;
                    case 8:
                        filmModeMsgData.mFuncKeyValue = b(4, this.j.getString("pref_film_mode_exposure", MenuClickMsgData.VALUE_PROFESSION_AUTO), "0");
                        break;
                    case 9:
                        filmModeMsgData.mFuncKeyValue = a(0, this.j.getString("pref_film_mode_iso", MenuClickMsgData.VALUE_PROFESSION_AUTO), MenuClickMsgData.VALUE_PROFESSION_AUTO);
                        break;
                }
            }
            filmModeMsgData.report();
        }
    }

    public boolean a(int i2, int i3, boolean z) {
        Activity activity = this.f3343b;
        if (activity == null || this.q) {
            return false;
        }
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.exposure_anim_view_size) / 2;
        int bottom = this.h.getBottom() + dimensionPixelSize;
        int y = ((int) this.f3342a.getY()) - dimensionPixelSize;
        int dimensionPixelSize2 = this.f3343b.getResources().getDimensionPixelSize(R.dimen.switch_camera_bar_margin_left);
        int E = Util.E() - this.f3343b.getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_margin_top);
        if (z) {
            y -= this.l.getIntrinsicHeight();
        }
        this.s.set(dimensionPixelSize2, bottom, E, y);
        Rect rect = new Rect();
        float width = (float) ((this.k.getWidth() / 2) - (this.k.getHeight() / 2));
        rect.left = (int) (this.k.getX() + width);
        rect.top = ((int) (this.k.getY() - width)) - dimensionPixelSize;
        rect.right = rect.left + this.k.getHeight() + dimensionPixelSize;
        rect.bottom = ((int) (this.k.getY() - width)) + this.k.getWidth() + dimensionPixelSize;
        if (z) {
            rect.top -= this.l.getIntrinsicHeight();
        }
        Rect rect2 = new Rect();
        ThumbImageView thumbImageView = this.m;
        if (thumbImageView != null) {
            rect2.left = (int) thumbImageView.getX();
            rect2.top = ((int) this.m.getY()) - dimensionPixelSize;
            rect2.right = (this.m.getRight() + dimensionPixelSize) - this.m.getPaddingRight();
            rect2.bottom = this.m.getBottom() + dimensionPixelSize;
        }
        if (!this.s.contains(i2, i3) || rect.contains(i2, i3) || rect2.contains(i2, i3)) {
            return false;
        }
        return true;
    }

    public void y() {
        e.a("BaseFilmUIControl", "restoreDefaultMode, Restore UI");
        if (this.f3343b != null && this.f3342a != null && this.e != null && this.i != null) {
            C();
            this.i.a(this.h, false);
            this.e.a((ViewGroup) this.f3342a.getFilmModeBarLayout());
            if (this.k != null && !z().equals(this.k.getSelectValue())) {
                this.k.setSelectValue(z());
                this.k.setSelectBg(z());
            }
            b(z());
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MOVIE_ULTRA_WIDE_FLASH_EIS_SUPPORT)) {
            return;
        }
        if ("camera_ultra_wide".equals(str)) {
            D();
        } else {
            E();
        }
    }

    private void D() {
        String string = this.j.getString("pref_camera_film_mode_key", "off");
        String string2 = this.j.getString("pref_film_video_eis_menu", "on");
        this.j.edit().putString("pref_film_flash_mode_key", string).apply();
        this.j.edit().putString("pref_film_eis_mode_key", string2).apply();
        this.j.edit().putBoolean("pref_film_video_eis_and_flash_enable", false).apply();
        a(false, false);
        b(false, false);
        this.j.edit().putString("pref_camera_film_mode_key", "off").apply();
        this.j.edit().putString("pref_film_video_eis_menu", "off").apply();
    }

    private void E() {
        String string = this.j.getString("pref_film_flash_mode_key", "off");
        String string2 = this.j.getString("pref_film_eis_mode_key", "on");
        this.j.edit().putBoolean("pref_film_video_eis_and_flash_enable", true).apply();
        a("torch".equals(string), true);
        b("on".equals(string2), true);
        this.j.edit().putString("pref_camera_film_mode_key", string).apply();
        this.j.edit().putString("pref_film_video_eis_menu", string2).apply();
    }
}
