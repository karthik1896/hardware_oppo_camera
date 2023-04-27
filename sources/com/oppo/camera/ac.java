package com.oppo.camera;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.color.support.widget.j;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.ZoomAdjustMsgData;
import com.oppo.camera.ui.InertiaZoomBar;
import com.oppo.camera.ui.RotableTextView;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.c;
import com.oppo.camera.ui.p;
import com.oppo.camera.ui.preview.w;
import com.oppo.camera.ui.preview.x;
import com.oppo.camera.ui.preview.y;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ZoomManager */
public class ac {
    /* access modifiers changed from: private */
    public FrameLayout A = null;
    private InertiaZoomBar B = null;
    /* access modifiers changed from: private */
    public p C = null;
    /* access modifiers changed from: private */
    public RotableTextView D = null;
    /* access modifiers changed from: private */
    public RotateImageView E = null;
    private View F = null;
    /* access modifiers changed from: private */
    public LottieAnimationView G = null;
    /* access modifiers changed from: private */
    public j H = null;
    private ScaleGestureDetector I = null;
    /* access modifiers changed from: private */
    public Activity J = null;
    private Resources K = null;
    /* access modifiers changed from: private */
    public k L = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.e.b M = null;
    /* access modifiers changed from: private */
    public ab N = null;
    private Rect O = null;
    private ViewGroup P = null;
    private ViewGroup Q = null;
    /* access modifiers changed from: private */
    public Handler R = null;
    private boolean S = true;
    private ValueAnimator T = null;
    private ValueAnimator U = null;
    private PathInterpolator V = new PathInterpolator(0.42f, 0.42f, 0.52f, 0.92f);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Float> f2756a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Float> f2757b = new ArrayList<>();
    private ArrayList<Float> c = new ArrayList<>();
    /* access modifiers changed from: private */
    public float d = 1.0f;
    private float e = 1.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private float k = 0.0f;
    /* access modifiers changed from: private */
    public float l = 0.0f;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private long r = 0;
    /* access modifiers changed from: private */
    public boolean s = false;
    /* access modifiers changed from: private */
    public boolean t = false;
    /* access modifiers changed from: private */
    public boolean u = false;
    private boolean v = false;
    private boolean w = false;
    /* access modifiers changed from: private */
    public boolean x = false;
    /* access modifiers changed from: private */
    public a y = null;
    /* access modifiers changed from: private */
    public y z = null;

    /* compiled from: ZoomManager */
    public interface a {
        void a(float f, boolean z, float f2);

        void a(int i);

        boolean a();

        boolean a(float f);

        void b();

        void c();

        boolean d();

        Size e();

        void f();

        void g();

        void h();

        void i();

        boolean j();

        boolean k();

        void l();

        void m();

        boolean n();

        boolean o();

        boolean p();

        boolean q();

        boolean r();

        boolean s();

        void t();

        void u();

        boolean v();

        boolean w();

        boolean x();
    }

    public static float c(float f2) {
        return ((float) ((int) ((f2 + 1.0E-5f) / 0.1f))) * 0.1f;
    }

    public ac(Activity activity, k kVar, com.oppo.camera.e.b bVar, ViewGroup viewGroup) {
        this.J = activity;
        this.K = this.J.getResources();
        this.L = kVar;
        this.M = bVar;
        this.P = viewGroup;
        this.Q = (ViewGroup) this.J.findViewById(R.id.frame_layout);
        this.z = new w(this.J);
        this.z.setId(R.id.zoom_seek_bar);
        this.m = this.K.getDimensionPixelSize(R.dimen.zoom_gesture_scale_step);
        this.n = this.K.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_anim_translation_yby);
        this.f2756a.add(Float.valueOf(1.0f));
        this.f2756a.add(Float.valueOf(5.0f));
        this.f2756a.add(Float.valueOf(10.0f));
        this.f2756a.add(Float.valueOf(10.1f));
        q();
        this.z.setOnSeekBarChangeListener(new c.a() {
            public void a(float f) {
                if (ac.this.M != null && ac.this.M.a(f, ac.this.d) && ac.this.M.au()) {
                    boolean unused = ac.this.t = true;
                }
                ac.this.f(f);
            }

            public void a(float f, boolean z) {
                e.a("ZoomManager", "onChanged, zoomValue: " + f);
                if (ac.this.N.e()) {
                    if (ac.this.y.o() && Float.compare(f, 2.0f) < 0) {
                        ac.this.L.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
                    } else if (!ac.this.y.o() && Float.compare(f, 2.0f) >= 0 && !ac.this.y.q()) {
                        ac.this.L.edit().putString("pref_none_sat_tele_angle_key", "on").apply();
                    }
                }
                if (!ac.this.N.d() || !ac.this.y.n()) {
                    ac.this.e(f);
                    ac.this.g(f);
                    ac.this.a(f, f, true, false);
                } else if (Float.compare(f, 1.0f) >= 0) {
                    ac.this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                    ac.this.e(f);
                    ac.this.g(f);
                }
            }

            public boolean a() {
                return ac.this.B();
            }

            public void b() {
                if (ac.this.y != null) {
                    ac.this.y.f();
                    ac.this.y.b();
                }
                if ("on".equals(ac.this.L.getString("pref_subsetting_key", "off"))) {
                    ac.this.L.edit().putString("pref_subsetting_key", "off").apply();
                }
                ac.this.a(0);
                ac acVar = ac.this;
                acVar.e(acVar.d);
            }

            public void c() {
                if (ac.this.y != null) {
                    ac.this.y.g();
                    ac.this.y.c();
                }
                if (ac.this.N.d() && Float.compare(ac.this.z.getCurrentZoom(), 1.0f) < 0) {
                    if (ac.this.N.c()) {
                        ac.this.z.b(0.6f, false);
                    } else {
                        ac.this.z.b(1.0f, false);
                    }
                    ac.this.e(1.0f);
                    ac.this.b(1.0f, 1.0f);
                }
            }

            public void d() {
                if (ac.this.N.d() && ac.this.N.c() && !ac.this.y.p()) {
                    ac.this.z.b(0.6f, false);
                }
                if (ac.this.y != null) {
                    ac.this.y.h();
                }
                if (ac.this.D()) {
                    ac.this.j(true);
                }
            }

            public void b(float f) {
                if (ac.this.M.m() || ac.this.M.ag()) {
                    ac.this.y.a(Color.argb((int) (Util.a(f, 0.0f, 1.0f) * ((float) Color.alpha(ac.this.J.getResources().getColor(R.color.plugin_background_30_percent_transparency_color)))), 0, 0, 0));
                }
            }

            public void c(float f) {
                if (ac.this.s) {
                    if (ac.this.D.getVisibility() == 0) {
                        ac.this.u();
                    }
                    if (ac.this.E.getVisibility() == 0) {
                        ac.this.v();
                    }
                }
                if (ac.this.M.m() || ac.this.M.ag()) {
                    ac.this.y.a(Color.argb((int) (Util.a(f, 0.0f, 1.0f) * ((float) Color.alpha(ac.this.J.getResources().getColor(R.color.plugin_background_30_percent_transparency_color)))), 0, 0, 0));
                }
                ac.this.a(4);
            }

            public void e() {
                float currentZoom = ac.this.z.getCurrentZoom();
                e.a("ZoomManager", "onActionUpOnExpandState, zoomValue: " + currentZoom);
                float f = 0.6f;
                if (ac.this.N.d()) {
                    if (ac.this.y.p()) {
                        if (Float.compare(currentZoom, 1.0f) < 0) {
                            ac.this.z.b(1.0f, false);
                            ac.this.e(1.0f);
                            ac.this.b(1.0f, 1.0f);
                        } else {
                            ac.this.z.b(currentZoom, false);
                            ac.this.e(currentZoom);
                            ac.this.b(currentZoom, currentZoom);
                        }
                    } else if (ac.this.y.n() && Float.compare(currentZoom, 0.6f) > 0) {
                        if (Float.compare(currentZoom, 0.8f) <= 0) {
                            ac.this.z.b(0.6f, false);
                        } else {
                            ac.this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                            ac.this.z.b(1.0f, false);
                        }
                        ac.this.e(1.0f);
                        ac.this.b(1.0f, 1.0f);
                    } else if (!ac.this.y.n() && Float.compare(currentZoom, 1.0f) < 0) {
                        if (Float.compare(currentZoom, 0.8f) <= 0) {
                            ac.this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", "on").apply();
                            ac.this.z.b(0.6f, false);
                        } else {
                            ac.this.z.b(1.0f, false);
                        }
                        ac.this.e(1.0f);
                        ac.this.b(1.0f, 1.0f);
                    }
                }
                p o = ac.this.C;
                if (!ac.this.y.n()) {
                    f = ac.this.d;
                }
                o.a(f, true);
                ac.this.e(2);
            }

            public void f() {
                e.a("ZoomManager", "onActionDownOnExpandState");
                if (ac.this.y != null) {
                    ac.this.y.b();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void q() {
        this.R = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        ac.this.e(true);
                    } else if (i == 3) {
                        sendEmptyMessageDelayed(3, 25);
                        ac acVar = ac.this;
                        final float d = acVar.d(acVar.l);
                        ac.this.J.runOnUiThread(new Runnable() {
                            public void run() {
                                ac.this.a(d, false);
                            }
                        });
                        ac.this.a(d, d, false, true);
                    }
                } else if (Float.compare(0.0f, ac.this.l) != 0) {
                    ac.this.e(6);
                }
            }
        };
    }

    private void r() {
        Size e2 = this.y.e();
        if (e2 != null) {
            a(e2.getWidth(), e2.getHeight());
        }
    }

    public void a(int i2) {
        p pVar = this.C;
        if (pVar != null && i2 != pVar.getVisibility()) {
            this.C.a(i2, true);
        }
    }

    private void e(ViewGroup viewGroup) {
        e.a("ZoomManager", "initFocusChooseView");
        if (this.C == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Util.B());
            layoutParams.addRule(6, R.id.control_panel_layout);
            layoutParams.topMargin = this.J.getResources().getDimensionPixelSize(R.dimen.head_line_margin_top);
            this.C = new p(this.J);
            this.C.setLayoutParams(layoutParams);
            viewGroup.addView(this.C);
            this.C.setVisibility(4);
            this.C.setListener(new p.a() {
                public void a(float f) {
                    if (ac.this.z.g()) {
                        ac.this.z.b(f, true);
                        ac.this.e(f);
                        if (!a()) {
                            ac.this.b(f, f);
                        }
                    }
                }

                public void b(float f) {
                    if (ac.this.N.d()) {
                        if (ac.this.y.n() && Float.compare(f, 0.6f) > 0) {
                            ac.this.f(f);
                        } else if (!ac.this.y.n() && Float.compare(f, 0.6f) <= 0) {
                            ac.this.f(0.6f);
                        }
                    }
                    if (!ac.this.N.e()) {
                        return;
                    }
                    if ((ac.this.y.o() && Float.compare(f, 2.0f) < 0) || (!ac.this.y.o() && Float.compare(f, 2.0f) >= 0 && !ac.this.y.q())) {
                        ac.this.f(f);
                    }
                }

                public boolean a() {
                    return ac.this.M.O() || ac.this.M.P();
                }

                public boolean b() {
                    return ac.this.y != null && ac.this.y.d();
                }

                public void c() {
                    ac.this.e(7);
                }
            });
            e.a("ZoomManager", "initFocusChooseView X");
        }
    }

    /* access modifiers changed from: private */
    public float d(float f2) {
        return Util.a(this.d + (f2 / 40.0f), this.f, this.k);
    }

    private boolean a(View view, int i2, int i3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i4;
        int measuredHeight = view.getMeasuredHeight() + i5;
        if (i3 < i5 || i3 > measuredHeight || i2 < i4 || i2 > measuredWidth) {
            return false;
        }
        return true;
    }

    public void a(a aVar) {
        this.y = aVar;
        this.z.setZoomListener(new c());
        if (this.I == null) {
            this.I = new ScaleGestureDetector(this.J, new b());
        }
    }

    public float a() {
        return this.d;
    }

    public float b() {
        return this.e;
    }

    public void a(boolean z2) {
        if (!z2) {
            this.z.setEnabled(false);
            this.C.setEnabled(false);
        } else if (l()) {
            this.z.setEnabled(true);
            this.C.setEnabled(true);
        }
    }

    public void a(float f2, boolean z2) {
        this.z.b(f2, z2);
    }

    private void d(int i2) {
        if (-1 == i2 && this.J != null) {
            i2 = this.q;
        }
        if (this.D != null) {
            int dimensionPixelSize = this.K.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_padding_bottom);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
            if (i2 % 180 == 0) {
                this.D.setBottomMargin(dimensionPixelSize);
                return;
            }
            this.D.setBottomMargin(0);
            layoutParams.bottomMargin = this.K.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_land_display_text_bottom_margin);
            this.D.setLayoutParams(layoutParams);
        }
    }

    public void a(int i2, boolean z2) {
        e.a("ZoomManager", "setOrientation, orientation: " + i2 + ", anim: " + z2);
        this.z.a(i2, z2);
        d(i2);
        RotableTextView rotableTextView = this.D;
        if (rotableTextView != null) {
            rotableTextView.a(i2, true);
        }
        RotateImageView rotateImageView = this.E;
        if (rotateImageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rotateImageView.getLayoutParams();
            if (i2 % 180 == 0) {
                layoutParams.bottomMargin = this.K.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_padding_bottom);
            } else {
                layoutParams.bottomMargin = this.K.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_land_display_value_padding_bottom);
            }
            this.E.a(i2, true);
        }
        if (this.B != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_layout_width), this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_layout_height));
            if (i2 != 0) {
                if (i2 == 90) {
                    layoutParams2.addRule(14);
                    layoutParams2.topMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_margin_right) + Util.u();
                } else if (i2 != 180) {
                    if (i2 == 270) {
                        layoutParams2.addRule(14);
                        layoutParams2.topMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_margin_left) + Util.u();
                    }
                }
                this.B.setLayoutParams(layoutParams2);
                this.B.a(i2, true);
            }
            layoutParams2.addRule(9);
            layoutParams2.addRule(2, R.id.control_panel_layout);
            layoutParams2.leftMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_margin_left);
            layoutParams2.bottomMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_margin_bottom);
            this.B.setLayoutParams(layoutParams2);
            this.B.a(i2, true);
        }
        View view = this.F;
        if (view != null) {
            if (180 == i2) {
                view.setRotation(0.0f);
            } else {
                view.setRotation((float) (-i2));
            }
        }
        this.q = i2;
    }

    public void c() {
        if (!l()) {
            e.a("ZoomManager", "performShow, isSupportZoomMenu is false, so return");
        } else {
            this.z.a(!this.y.p());
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        this.z.a(animationListener);
    }

    public void b(int i2) {
        if (i2 != 0) {
            this.C.setVisibility(i2);
            this.z.a((Animation.AnimationListener) null);
            return;
        }
        this.z.a(false);
    }

    public void c(int i2) {
        this.z.setLayoutDirection(i2);
    }

    public boolean b(boolean z2) {
        if (!l()) {
            e.a("ZoomManager", "performCollapse, isSupportZoomMenu is false, so return");
            return false;
        }
        if (this.N.d() && (this.y.n() || Float.compare(this.d, 1.0f) < 0)) {
            b(1.0f, 1.0f);
        }
        return this.z.b(z2);
    }

    public void a(ViewGroup viewGroup) {
        c(viewGroup);
        b(viewGroup);
    }

    public void b(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, this.A.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.K.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_padding_bottom);
        this.E = new RotateImageView(this.J);
        this.E.setImageResource(R.drawable.zoom_ultra_wide_angle_indicator);
        this.E.setVisibility(8);
        this.E.setAlpha(1.0f);
        this.E.a(this.q, false);
        viewGroup.addView(this.E, layoutParams);
    }

    public void c(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, this.A.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.K.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_padding_bottom);
        this.D = new RotableTextView(this.J);
        this.D.setTextColor(-1);
        this.D.setTypeface(Util.j((Context) this.J));
        this.D.setShadowLayer(4.0f, 0.0f, 0.0f, this.K.getColor(R.color.color_black_with_70_percent_transparency));
        this.D.setTextSize(0, (float) this.K.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_text_size));
        this.D.setVisibility(8);
        this.D.setAlpha(1.0f);
        this.D.a(this.q, false);
        viewGroup.addView(this.D, layoutParams);
    }

    /* access modifiers changed from: private */
    public void e(float f2) {
        if (Float.compare(f2, 1.0f) < 0 || this.y.n()) {
            if (this.E.getVisibility() != 0) {
                this.E.setVisibility(0);
                this.E.setTranslationY(0.0f);
            }
            if (this.D.getVisibility() == 0) {
                this.D.setVisibility(8);
            }
            if (!this.s) {
                this.D.setAlpha(1.0f);
                t();
                return;
            }
            return;
        }
        if (this.E.getVisibility() == 0) {
            this.E.setVisibility(8);
        }
        if (this.D.getVisibility() != 0) {
            this.D.setVisibility(0);
            this.D.setTranslationY(0.0f);
        }
        this.D.setText(this.z.getCurrentDisplayText());
        if (!this.s) {
            this.E.setAlpha(1.0f);
            s();
        }
    }

    private void s() {
        this.s = true;
        this.D.setAlpha(0.0f);
        this.D.setTranslationY((float) this.n);
        this.D.animate().cancel();
        this.D.animate().setDuration(500).alpha(1.0f).translationY(0.0f).setInterpolator(AnimationUtils.loadInterpolator(this.J, R.anim.zoom_interpolator_in)).withLayer().start();
    }

    private void t() {
        this.s = true;
        this.E.setAlpha(0.0f);
        this.E.setTranslationY((float) this.n);
        this.E.animate().cancel();
        this.E.animate().setDuration(500).alpha(1.0f).translationY(0.0f).setInterpolator(AnimationUtils.loadInterpolator(this.J, R.anim.zoom_interpolator_in)).withLayer().start();
    }

    /* access modifiers changed from: private */
    public void u() {
        this.s = false;
        this.D.setAlpha(1.0f);
        this.D.setTranslationY(0.0f);
        this.D.animate().cancel();
        this.D.animate().setDuration(300).alpha(0.0f).translationY((float) this.n).setInterpolator(AnimationUtils.loadInterpolator(this.J, R.anim.zoom_interpolator_out)).withLayer().start();
    }

    /* access modifiers changed from: private */
    public void v() {
        this.s = false;
        this.E.setAlpha(1.0f);
        this.E.setTranslationY(0.0f);
        this.E.animate().cancel();
        this.E.animate().setDuration(300).alpha(0.0f).translationY((float) this.n).setInterpolator(AnimationUtils.loadInterpolator(this.J, R.anim.zoom_interpolator_out)).withLayer().start();
    }

    public void d(ViewGroup viewGroup) {
        if (viewGroup != null) {
            View findViewById = this.J.findViewById(R.id.face_beauty_enter_button);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(2, R.id.control_panel_layout);
            this.A = new FrameLayout(this.J);
            this.A.setId(R.id.zoom_seek_bar_container);
            this.A.addView(this.z, 0, new FrameLayout.LayoutParams(-1, -2));
            this.z.setVisibility(4);
            View view = new View(this.J);
            view.setId(R.id.zoom_seek_anchor_view);
            view.setWillNotDraw(true);
            view.setVisibility(4);
            this.A.addView(view, 1);
            viewGroup.addView(this.A, viewGroup.indexOfChild(findViewById), layoutParams);
            a(viewGroup);
            e(viewGroup);
        }
    }

    public void c(boolean z2) {
        FrameLayout frameLayout = this.A;
        if (frameLayout == null) {
            return;
        }
        if (z2) {
            Util.a((View) frameLayout, 4, (Animation.AnimationListener) null, 300);
        } else {
            frameLayout.setVisibility(4);
        }
    }

    public void d(boolean z2) {
        FrameLayout frameLayout = this.A;
        if (frameLayout == null) {
            return;
        }
        if (z2) {
            Util.a((View) frameLayout, 0, (Animation.AnimationListener) null, 300);
        } else {
            frameLayout.setVisibility(0);
        }
    }

    public View d() {
        return this.A;
    }

    public float a(float f2, float f3) {
        ab abVar;
        if (this.k < 1.0f) {
            return 0.0f;
        }
        float f4 = f2 + ((f3 / ((float) this.m)) * 0.1f);
        float f5 = this.f;
        if (this.v && (abVar = this.N) != null && abVar.d() && !this.N.l()) {
            f5 = 0.6f;
        }
        return Util.a(f4, f5, this.k);
    }

    public boolean e() {
        if (l()) {
            return this.z.g();
        }
        e.a("ZoomManager", "isZoomMenuExpand, isSupportZoomMenu is false, so return");
        return false;
    }

    public boolean f() {
        if (l()) {
            return this.z.f();
        }
        e.a("ZoomManager", "isZoomMenuCollapsing, isSupportZoomMenu is false, so return");
        return false;
    }

    public void e(boolean z2) {
        e.a("ZoomManager", "stopInertialZoomGuide");
        LottieAnimationView lottieAnimationView = this.G;
        if (lottieAnimationView != null) {
            lottieAnimationView.d();
        }
        View view = this.F;
        if (view != null) {
            if (z2) {
                Util.a(view, 8, (Animation.AnimationListener) null, 300);
            } else {
                view.setVisibility(8);
            }
        }
        j jVar = this.H;
        if (jVar != null) {
            jVar.dismiss();
            this.H = null;
        }
    }

    public void g() {
        RotableTextView rotableTextView = this.D;
        if (rotableTextView != null) {
            rotableTextView.setVisibility(8);
        }
        RotateImageView rotateImageView = this.E;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
        p pVar = this.C;
        if (pVar != null) {
            pVar.setVisibility(8);
        }
        ValueAnimator valueAnimator = this.T;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.U;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.s = false;
        if (this.B != null) {
            g(false);
            this.B.a();
        }
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.z.b();
        this.t = false;
        if (!this.y.a()) {
            this.z.setVisibility(8);
        }
        e(false);
        this.x = false;
        this.S = true;
    }

    public void a(float f2, float f3, float f4, Rect rect, ab abVar, boolean z2) {
        ab abVar2;
        this.O = rect;
        this.N = abVar;
        this.e = this.d;
        this.d = f4;
        this.f = f2;
        this.k = f3;
        this.v = z2;
        ab abVar3 = this.N;
        boolean k2 = abVar3 != null ? abVar3.k() : false;
        this.f2757b.clear();
        this.c.clear();
        ab abVar4 = this.N;
        float f5 = 0.6f;
        if (abVar4 == null || ((!abVar4.i() || !this.N.j()) && !this.N.o() && (!this.N.m() || !this.N.d()))) {
            if (Float.compare(this.f, 1.0f) < 0) {
                this.f2757b.add(Float.valueOf(this.f));
                this.c.add(Float.valueOf(this.f));
            } else if (z2 && (abVar2 = this.N) != null && abVar2.d() && !this.N.l()) {
                this.f2757b.add(Float.valueOf(0.6f));
            }
            if (Float.compare(this.f, 1.0f) <= 0) {
                this.f2757b.add(Float.valueOf(1.0f));
            }
            ab abVar5 = this.N;
            float f6 = (abVar5 == null || !abVar5.q()) ? 2.0f : 3.0f;
            if (!k2 && Float.compare(this.k, f6) >= 0) {
                this.f2757b.add(Float.valueOf(f6));
                if (Float.compare(this.k, 5.0f) >= 0) {
                    this.f2757b.add(Float.valueOf(5.0f));
                    if (Float.compare(this.k, 20.0f) > 0) {
                        this.f2757b.add(Float.valueOf(10.0f));
                    }
                }
            }
            if (Float.compare(this.f, 1.0f) <= 0) {
                this.c.add(Float.valueOf(1.0f));
            }
            this.c.add(Float.valueOf(f6));
            if (Float.compare(this.k, 8.0f) >= 0) {
                this.c.add(Float.valueOf(5.0f));
                if (Float.compare(this.k, 10.0f) > 0) {
                    this.c.add(Float.valueOf(10.0f));
                }
            }
        } else {
            this.f2757b.add(Float.valueOf(0.6f));
            this.f2757b.add(Float.valueOf(1.0f));
            this.c.add(Float.valueOf(1.0f));
        }
        this.z.a(this.y.n() ? 0.6f : this.d, this.f, this.k, this.c, this.f2757b);
        p pVar = this.C;
        if (!this.y.n()) {
            f5 = this.d;
        }
        pVar.a(f5, (List<Float>) this.f2757b);
        e.a("ZoomManager", "initialize, mMinZoomValue: " + this.f + ", mMaxZoomValue: " + this.k + ", mCurrentZoomValue: " + this.d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a0, code lost:
        if (r0 != 3) goto L_0x01b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r10) {
        /*
            r9 = this;
            android.view.ScaleGestureDetector r0 = r9.I
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0058
            boolean r0 = r9.n()
            if (r0 == 0) goto L_0x0058
            com.oppo.camera.ac$a r0 = r9.y
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x003e
            boolean r0 = r9.C()
            if (r0 == 0) goto L_0x001b
            goto L_0x003e
        L_0x001b:
            android.view.ScaleGestureDetector r0 = r9.I
            boolean r0 = r0.isInProgress()
            if (r0 == 0) goto L_0x0030
            int r0 = r10.getPointerCount()
            if (r1 > r0) goto L_0x0030
            r0 = 6
            int r3 = r10.getAction()
            if (r0 == r3) goto L_0x0038
        L_0x0030:
            r0 = 262(0x106, float:3.67E-43)
            int r3 = r10.getAction()
            if (r0 != r3) goto L_0x0058
        L_0x0038:
            android.view.ScaleGestureDetector r0 = r9.I
            r0.onTouchEvent(r10)
            goto L_0x0058
        L_0x003e:
            int r0 = r10.getPointerCount()
            if (r0 < r1) goto L_0x0049
            android.view.ScaleGestureDetector r0 = r9.I
            r0.onTouchEvent(r10)
        L_0x0049:
            boolean r0 = r9.C()
            if (r0 != 0) goto L_0x0058
            android.view.ScaleGestureDetector r0 = r9.I
            boolean r0 = r0.isInProgress()
            if (r0 == 0) goto L_0x0058
            return r2
        L_0x0058:
            int r0 = r10.getPointerCount()
            r3 = 0
            if (r0 >= r1) goto L_0x01b6
            boolean r0 = r9.x()
            if (r0 != 0) goto L_0x01b6
            com.oppo.camera.ac$a r0 = r9.y
            boolean r0 = r0.v()
            if (r0 == 0) goto L_0x01b6
            com.oppo.camera.ac$a r0 = r9.y
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x01b6
            com.oppo.camera.ac$a r0 = r9.y
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x01b6
            com.oppo.camera.ab r0 = r9.N
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x01b6
            com.oppo.camera.ac$a r0 = r9.y
            boolean r0 = r0.s()
            if (r0 != 0) goto L_0x01b6
            com.oppo.camera.ac$a r0 = r9.y
            boolean r0 = r0.w()
            if (r0 != 0) goto L_0x01b6
            int r0 = r10.getAction()
            if (r0 == 0) goto L_0x019c
            if (r0 == r2) goto L_0x0192
            if (r0 == r1) goto L_0x00a4
            r10 = 3
            if (r0 == r10) goto L_0x0192
            goto L_0x01b6
        L_0x00a4:
            boolean r0 = r9.x
            if (r0 != 0) goto L_0x00ac
            r9.a((boolean) r3, (boolean) r3)
            return r3
        L_0x00ac:
            boolean r0 = r9.S
            if (r0 != 0) goto L_0x00b1
            return r3
        L_0x00b1:
            float r0 = r9.i
            float r1 = r10.getY()
            float r0 = r0 - r1
            float r1 = r9.j
            float r4 = r10.getX()
            float r1 = r1 - r4
            long r4 = r10.getEventTime()
            long r6 = r9.r
            long r4 = r4 - r6
            r6 = 500(0x1f4, double:2.47E-321)
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00e0
            float r5 = r10.getX()
            r9.g = r5
            float r5 = r10.getY()
            r9.h = r5
            float r5 = r9.g
            r9.j = r5
            float r5 = r9.h
            r9.i = r5
        L_0x00e0:
            int r5 = r9.q
            r6 = 1058306785(0x3f147ae1, float:0.58)
            if (r5 == 0) goto L_0x0118
            r7 = 180(0xb4, float:2.52E-43)
            if (r7 != r5) goto L_0x00ec
            goto L_0x0118
        L_0x00ec:
            r7 = 90
            if (r7 != r5) goto L_0x0103
            float r5 = java.lang.Math.abs(r1)
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r6
            int r0 = java.lang.Float.compare(r5, r0)
            if (r0 <= 0) goto L_0x0101
            r0 = r2
            goto L_0x012d
        L_0x0101:
            r0 = r3
            goto L_0x012d
        L_0x0103:
            float r5 = -r1
            float r1 = java.lang.Math.abs(r1)
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r6
            int r0 = java.lang.Float.compare(r1, r0)
            if (r0 <= 0) goto L_0x0115
            r0 = r2
            goto L_0x0116
        L_0x0115:
            r0 = r3
        L_0x0116:
            r1 = r5
            goto L_0x012d
        L_0x0118:
            float r5 = java.lang.Math.abs(r0)
            float r1 = java.lang.Math.abs(r1)
            float r1 = r1 * r6
            int r1 = java.lang.Float.compare(r5, r1)
            if (r1 <= 0) goto L_0x0129
            r1 = r2
            goto L_0x012a
        L_0x0129:
            r1 = r3
        L_0x012a:
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x012d:
            if (r0 == 0) goto L_0x01b6
            r0 = 1090519040(0x41000000, float:8.0)
            float r5 = java.lang.Math.abs(r1)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x01b6
            if (r4 >= 0) goto L_0x01b6
            int r0 = r9.o
            float r0 = (float) r0
            float r1 = r1 / r0
            r0 = 1130102784(0x435c0000, float:220.0)
            float r1 = r1 * r0
            com.oppo.camera.ui.InertiaZoomBar r0 = r9.B
            if (r0 != 0) goto L_0x0149
            r9.y()
        L_0x0149:
            com.oppo.camera.ui.InertiaZoomBar r0 = r9.B
            if (r0 != 0) goto L_0x014e
            goto L_0x01b6
        L_0x014e:
            int r0 = r9.p
            if (r0 == 0) goto L_0x0156
            int r0 = r9.o
            if (r0 != 0) goto L_0x0159
        L_0x0156:
            r9.r()
        L_0x0159:
            com.oppo.camera.ui.InertiaZoomBar r0 = r9.B
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x016c
            android.view.ViewGroup r0 = r9.P
            com.oppo.camera.ui.InertiaZoomBar r4 = r9.B
            int r0 = r0.indexOfChild(r4)
            r4 = -1
            if (r0 != r4) goto L_0x0170
        L_0x016c:
            r9.w()
            r3 = r2
        L_0x0170:
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r9.r
            long r4 = r4 - r6
            r6 = 1500(0x5dc, double:7.41E-321)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0180
            r9.e((boolean) r2)
        L_0x0180:
            com.oppo.camera.ui.InertiaZoomBar r0 = r9.B
            r0.setMoveProgress(r1)
            float r0 = r10.getY()
            r9.i = r0
            float r10 = r10.getX()
            r9.j = r10
            goto L_0x01b6
        L_0x0192:
            boolean r10 = r9.u
            boolean r0 = r9.h()
            r9.a((boolean) r2, (boolean) r10, (boolean) r0)
            goto L_0x01b6
        L_0x019c:
            android.view.ViewGroup r0 = r9.Q
            float r1 = r10.getRawX()
            int r1 = (int) r1
            float r4 = r10.getRawY()
            int r4 = (int) r4
            boolean r0 = r9.a((android.view.View) r0, (int) r1, (int) r4)
            r9.S = r0
            r9.x = r2
            long r0 = r10.getDownTime()
            r9.r = r0
        L_0x01b6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ac.a(android.view.MotionEvent):boolean");
    }

    private void w() {
        e.a("ZoomManager", "startInertialZoom");
        z();
        this.z.setInertial(true);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        b(true);
        Handler handler = this.R;
        if (handler != null) {
            handler.removeMessages(3);
            this.R.sendEmptyMessage(3);
        }
        this.y.t();
    }

    public void f(boolean z2) {
        a(z2, true);
    }

    public void a(boolean z2, boolean z3) {
        a(z2, z3, true);
    }

    public void a(boolean z2, boolean z3, boolean z4) {
        e.a("ZoomManager", "stopInertialZoom, needAnim: " + z2 + ", stopGuide: " + z3);
        this.z.setInertial(false);
        if (this.y.r()) {
            if (this.B != null) {
                g(z2);
                this.y.u();
                if (z2) {
                    this.B.b();
                } else {
                    this.B.a();
                }
            }
            Handler handler = this.R;
            if (handler != null) {
                handler.removeMessages(3);
            }
            if (z3) {
                e(true);
            }
            this.x = false;
            if (z4) {
                e(5);
            }
        }
    }

    private boolean x() {
        Animation animation;
        InertiaZoomBar inertiaZoomBar = this.B;
        if (inertiaZoomBar == null || (animation = inertiaZoomBar.getAnimation()) == null) {
            return false;
        }
        return !animation.hasEnded();
    }

    private void y() {
        this.B = (InertiaZoomBar) this.J.getLayoutInflater().inflate(R.layout.inertial_zoom_seek_bar, (ViewGroup) null);
        this.B.setVisibility(8);
        this.B.setOnSeekBarChangeListener(new InertiaZoomBar.a() {
            public void a(float f) {
                if (Float.compare(ac.this.l, f) != 0) {
                    e.a("ZoomManager", "onVelocityChanged, velocity: " + f);
                    float unused = ac.this.l = f;
                    if (ac.this.R == null) {
                        ac.this.q();
                    }
                    ac.this.R.removeMessages(1);
                    ac.this.R.sendEmptyMessageDelayed(1, 1000);
                }
            }
        });
    }

    private void z() {
        e.a("ZoomManager", "showInertialZoomBar, mLastOrientation: " + this.q);
        if (this.P != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_layout_width), this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_layout_height));
            int i2 = this.q;
            if (i2 != 0) {
                if (i2 == 90) {
                    layoutParams.addRule(14);
                    layoutParams.topMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_margin_right) + Util.u();
                } else if (i2 != 180) {
                    if (i2 == 270) {
                        layoutParams.addRule(14);
                        layoutParams.topMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_margin_left) + Util.u();
                    }
                }
                this.P.removeView(this.B);
                this.B.a(this.q, false);
                this.P.addView(this.B, layoutParams);
                this.B.setVisibility(0);
                this.u = true;
            }
            layoutParams.addRule(9);
            layoutParams.addRule(2, R.id.control_panel_layout);
            layoutParams.leftMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_margin_left);
            layoutParams.bottomMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoombar_margin_bottom);
            this.P.removeView(this.B);
            this.B.a(this.q, false);
            this.P.addView(this.B, layoutParams);
            this.B.setVisibility(0);
            this.u = true;
        }
    }

    public void g(boolean z2) {
        e.a("ZoomManager", "hideInertialZoomBar");
        if (this.P == null) {
            e.e("ZoomManager", "hideInertialZoomBar, mCameraRootView is null");
            return;
        }
        InertiaZoomBar inertiaZoomBar = this.B;
        if (inertiaZoomBar != null) {
            if (z2) {
                Util.a((View) inertiaZoomBar, 8, (Animation.AnimationListener) null, 300);
            } else {
                inertiaZoomBar.setVisibility(8);
            }
            this.P.removeView(this.B);
        }
        this.u = false;
    }

    public void a(int i2, int i3) {
        e.a("ZoomManager", "setPreviewSize, previewWidth: " + i2 + ", previewHeight: " + i3);
        if (this.p != i2 || this.o != i3) {
            this.p = i2;
            this.o = i3;
        }
    }

    public boolean h() {
        return this.u;
    }

    /* access modifiers changed from: private */
    public void f(float f2) {
        if (!this.y.d()) {
            e.e("ZoomManager", "handleMessage, cancel click");
            return;
        }
        float f3 = this.d;
        if (this.y.k()) {
            this.y.l();
        }
        ab abVar = this.N;
        String str = "on";
        if (abVar != null && abVar.e()) {
            if (!this.y.o() && Float.compare(2.0f, f2) <= 0) {
                this.L.edit().putString("pref_none_sat_tele_angle_key", str).apply();
            } else if (this.y.o() && Float.compare(2.0f, f2) > 0) {
                this.L.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
            }
        }
        ab abVar2 = this.N;
        if (abVar2 == null || (!abVar2.g() && !this.N.h())) {
            ab abVar3 = this.N;
            if (abVar3 == null || !abVar3.i()) {
                ab abVar4 = this.N;
                if (abVar4 != null && abVar4.m() && this.N.d()) {
                    this.L.edit().putBoolean("key_hyper_lapse_zoom_ultra_wide_open", !this.L.getBoolean("key_hyper_lapse_zoom_ultra_wide_open", true)).apply();
                } else if (Float.compare(0.6f, f2) == 0) {
                    ab abVar5 = this.N;
                    if (abVar5 == null || !abVar5.b()) {
                        ab abVar6 = this.N;
                        if (abVar6 != null && abVar6.d()) {
                            this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", str).apply();
                            b(1.0f, f2);
                        }
                    } else {
                        b(f2, f2);
                    }
                } else {
                    ab abVar7 = this.N;
                    if (abVar7 != null && abVar7.d() && this.L.contains("pref_none_sat_ultra_wide_angle_key") && this.y.n()) {
                        this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                    }
                    for (int i2 = 1; i2 <= 1; i2++) {
                        b(((f2 - f3) * this.V.getInterpolation(((float) i2) / ((float) 1))) + f3, f2);
                    }
                }
            } else {
                b(f2, f2);
                if (Float.compare(0.6f, f2) != 0) {
                    str = "off";
                }
                this.L.edit().putString("pref_ultra_wide_high_picture_size_key", str).apply();
            }
        } else {
            b(f2, f2);
            if (Float.compare(2.0f, f2) != 0) {
                str = "off";
            }
            if (this.N.g()) {
                this.L.edit().putString("pref_portrait_half_body_key", str).apply();
            } else if (this.N.h()) {
                this.L.edit().putString("pref_portrait_half_body_remosaic_key", str).apply();
            }
        }
        e(1);
    }

    public void h(boolean z2) {
        ab abVar;
        if (B()) {
            ab abVar2 = this.N;
            if (abVar2 == null || !abVar2.c() || (!this.M.ag() && z2)) {
                float f2 = this.d + (z2 ? 0.1f : -0.1f);
                float f3 = this.f;
                float f4 = f2 + 1.0E-5f;
                if (this.v && (abVar = this.N) != null && abVar.d() && !this.N.l()) {
                    f3 = 0.6f;
                }
                float a2 = Util.a(f4, f3, this.k);
                if (this.d != a2) {
                    e(3);
                    ab abVar3 = this.N;
                    if (abVar3 != null && abVar3.e()) {
                        if (this.y.o() && Float.compare(a2, 2.0f) < 0) {
                            this.L.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
                        } else if (!this.y.o() && Float.compare(a2, 2.0f) >= 0 && !this.y.q()) {
                            this.L.edit().putString("pref_none_sat_tele_angle_key", "on").apply();
                        }
                    }
                    ab abVar4 = this.N;
                    if (abVar4 != null && abVar4.d()) {
                        if (this.y.n() && Float.compare(a2, 0.6f) > 0) {
                            this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                            a(1.0f, true);
                            if (this.z.g()) {
                                e(1.0f);
                                return;
                            }
                            return;
                        } else if (!this.y.n() && Float.compare(a2, 1.0f) < 0) {
                            if (this.u) {
                                f(false);
                            }
                            this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", "on").apply();
                            a(0.6f, true);
                            if (this.z.g()) {
                                e(0.6f);
                                return;
                            }
                            return;
                        }
                    }
                    a(a2, true);
                    b(a2, a2);
                    if (this.s && this.z.g()) {
                        e(a2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void g(float f2) {
        if (this.y.k()) {
            Iterator<Float> it = this.c.iterator();
            while (it.hasNext()) {
                float floatValue = it.next().floatValue();
                if ((Float.compare(floatValue, this.d) > 0 && Float.compare(floatValue, f2) <= 0) || (Float.compare(floatValue, this.d) < 0 && Float.compare(floatValue, f2) >= 0)) {
                    this.y.m();
                    return;
                }
            }
            if (this.w && this.z.a(f2, this.d)) {
                this.y.l();
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(float f2, float f3) {
        a(f2, f3, true, true);
    }

    /* access modifiers changed from: private */
    public void a(float f2, float f3, boolean z2, boolean z3) {
        if (Float.compare(this.d, f2) != 0) {
            ab abVar = this.N;
            if (abVar != null && abVar.b() && z2) {
                Iterator<Float> it = this.f2756a.iterator();
                while (it.hasNext()) {
                    float floatValue = it.next().floatValue();
                    if (f2 < floatValue && f2 >= floatValue - 0.1f) {
                        float width = ((float) this.O.width()) / 2.0f;
                        float f4 = width / ((float) ((int) ((width / floatValue) + 1.0f)));
                        if (f2 >= f4) {
                            f2 = f4;
                        }
                    }
                }
            }
            float a2 = Util.a(f2, this.f, this.k);
            if (Float.compare(a2, this.d) != 0) {
                this.e = this.d;
                this.d = a2;
                this.y.a(a2, true, f3);
                this.C.a(this.y.n() ? 0.6f : this.d, z3);
            }
            e.a("ZoomManager", "changeZoom, mZoomValue: " + this.d + ", value: " + a2);
        }
    }

    public int i() {
        return this.z.getLayoutHeight();
    }

    public void a(int i2, int i3, boolean z2) {
        ValueAnimator valueAnimator = this.T;
        if (valueAnimator == null || (!valueAnimator.isRunning() && !this.T.isStarted())) {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A.getLayoutParams();
            layoutParams.height = i3;
            int i4 = layoutParams.bottomMargin;
            Activity activity = this.J;
            int i5 = i2 - i4;
            if (Math.abs(i5) <= (activity != null ? activity.getResources().getDimensionPixelOffset(R.dimen.zoom_view_translate_anim_threshold) : 0) || !z2) {
                layoutParams.bottomMargin = i2;
                this.A.setLayoutParams(layoutParams);
                j();
                return;
            }
            ValueAnimator valueAnimator2 = this.T;
            if (valueAnimator2 == null) {
                this.T = ValueAnimator.ofInt(new int[]{i4, i2});
                this.T.setDuration(200);
                this.T.setInterpolator(AnimationUtils.loadInterpolator(this.A.getContext(), R.anim.zoom_interpolator_in));
                this.T.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        layoutParams.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ac.this.A.setLayoutParams(layoutParams);
                        ac.this.j();
                    }
                });
            } else {
                valueAnimator2.setIntValues(new int[]{i4, i2});
            }
            if (this.U == null) {
                this.U = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.U.setDuration(200);
                this.U.setInterpolator(AnimationUtils.loadInterpolator(this.A.getContext(), R.anim.alpha_path_interpolator));
                this.U.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ac.this.A.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            if (i5 > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(this.T).with(this.U);
                animatorSet.start();
                return;
            }
            this.T.start();
        }
    }

    public void j() {
        ViewParent parent = this.z.getParent();
        if ((parent instanceof FrameLayout) && this.J != null) {
            View findViewById = ((FrameLayout) parent).findViewById(R.id.zoom_seek_anchor_view);
            float[] ultraWideZoomDotViewLocation = this.z.getUltraWideZoomDotViewLocation();
            float dimensionPixelSize = (float) this.J.getResources().getDimensionPixelSize(R.dimen.zoom_click_point_radius);
            if (findViewById == null) {
                return;
            }
            if (ultraWideZoomDotViewLocation == null || 2 != ultraWideZoomDotViewLocation.length) {
                findViewById.setVisibility(8);
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
            int i2 = (int) (2.0f * dimensionPixelSize);
            layoutParams.width = i2;
            layoutParams.height = i2;
            if (1 == this.z.getLayoutDirection()) {
                layoutParams.setMarginStart((int) ((((float) Util.E()) - ultraWideZoomDotViewLocation[0]) - dimensionPixelSize));
            } else {
                layoutParams.setMarginStart((int) (ultraWideZoomDotViewLocation[0] - dimensionPixelSize));
            }
            layoutParams.gravity = 8388611;
            layoutParams.topMargin = (int) ((ultraWideZoomDotViewLocation[1] - dimensionPixelSize) + ((float) (this.z.getFocusCircleRadius() / 2)));
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(4);
        }
    }

    public void k() {
        e.a("ZoomManager", "onDestroy");
        this.J = null;
        this.L = null;
        this.M = null;
        this.y = null;
        this.I = null;
    }

    /* compiled from: ZoomManager */
    private class b implements ScaleGestureDetector.OnScaleGestureListener {

        /* renamed from: b  reason: collision with root package name */
        private float f2771b;
        private float c;

        private b() {
            this.f2771b = 0.0f;
            this.c = 0.0f;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (ac.this.y != null && ac.this.y.x()) {
                return true;
            }
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (!Float.isInfinite(scaleFactor) && !Float.isNaN(scaleFactor)) {
                if (ac.this.u) {
                    ac.this.f(false);
                    return true;
                }
                float a2 = ac.this.a(this.c, scaleGestureDetector.getCurrentSpan() - this.f2771b);
                if (ac.this.N != null && ac.this.N.e() && !ac.this.M.ag()) {
                    if (!ac.this.y.o() && Float.compare(2.0f, a2) <= 0 && !ac.this.y.q()) {
                        ac.this.L.edit().putString("pref_none_sat_tele_angle_key", "on").apply();
                    } else if (ac.this.y.o() && Float.compare(2.0f, a2) > 0) {
                        ac.this.L.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
                    }
                }
                if (ac.this.N.d()) {
                    if (ac.this.N.c() && Float.compare(a2, 0.6f) <= 0) {
                        return true;
                    }
                    if (ac.this.y.n() && Float.compare(a2, 0.6f) > 0) {
                        if (Float.compare(a2, 0.8f) > 0 && !ac.this.M.ag()) {
                            ac.this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                            ac.this.a(1.0f, false);
                            ac.this.b(1.0f, 1.0f);
                            if (ac.this.z.g()) {
                                ac.this.e(1.0f);
                            }
                        }
                        return true;
                    } else if (!ac.this.y.n() && Float.compare(a2, 1.0f) < 0) {
                        if (Float.compare(a2, 0.8f) < 0 && !ac.this.M.ag()) {
                            ac.this.L.edit().putString("pref_none_sat_ultra_wide_angle_key", "on").apply();
                            ac.this.a(0.6f, false);
                            ac.this.b(1.0f, 1.0f);
                            if (ac.this.z.g()) {
                                ac.this.e(1.0f);
                            }
                        }
                        return true;
                    }
                }
                ac.this.a(a2, false);
                ac.this.b(a2, a2);
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            if (!ac.this.B()) {
                if (ac.this.C()) {
                    ac.this.y.i();
                }
                return false;
            } else if (ac.this.y.p() || !ac.this.y.d()) {
                return false;
            } else {
                if (ac.this.u) {
                    ac.this.f(false);
                }
                this.f2771b = scaleGestureDetector.getCurrentSpan();
                this.c = ac.this.y.n() ? 0.6f : ac.this.d;
                boolean unused = ac.this.x = false;
                ac.this.y.b();
                ac.this.b(false);
                return true;
            }
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (ac.this.y != null) {
                ac.this.y.c();
            }
            if (ac.this.D()) {
                ac.this.j(true);
            }
            ac.this.e(4);
        }
    }

    public boolean l() {
        return this.y.a();
    }

    private void A() {
        e.a("ZoomManager", "initInertialZoomView");
        if (this.F == null) {
            this.F = this.J.getLayoutInflater().inflate(R.layout.inertial_zoom_guide_layout, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(3, R.id.oppo_setting_bar);
            layoutParams.topMargin = this.J.getResources().getDimensionPixelSize(R.dimen.inertial_zoom_guide_margin_top);
            this.F.setVisibility(8);
            int i2 = this.q;
            if (180 == i2) {
                this.F.setRotation(0.0f);
            } else {
                this.F.setRotation((float) (-i2));
            }
            this.P.addView(this.F, layoutParams);
        }
        this.G = (LottieAnimationView) this.F.findViewById(R.id.inertial_zoom_guide_anim);
        this.G.setRepeatCount(-1);
        this.G.setAnimation((int) R.raw.inertial_zoom_guide);
    }

    /* access modifiers changed from: private */
    public void j(boolean z2) {
        e.a("ZoomManager", "showInertialZoomGuide, animation: " + z2);
        if (this.P != null) {
            if (this.F == null) {
                A();
            }
            if (this.R == null) {
                q();
            }
            this.G.a();
            a(this.J.getResources().getString(R.string.camera_inertial_zoom_guide_scroll_tip));
            if (z2) {
                Util.a(this.F, 0, (Animation.AnimationListener) null, 300);
            } else {
                this.F.setVisibility(0);
            }
            Handler handler = this.R;
            if (handler != null) {
                handler.removeMessages(2);
                this.R.sendEmptyMessageDelayed(2, 5000);
            }
            this.L.edit().putBoolean("pref_camera_inertial_zoom_guide", true).apply();
        }
    }

    private void a(final String str) {
        final AnonymousClass7 r0 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ac.this.e(false);
                return false;
            }
        };
        AnonymousClass8 r1 = new Runnable() {
            public void run() {
                if (ac.this.G != null) {
                    ac acVar = ac.this;
                    j unused = acVar.H = new j(acVar.J);
                    ac.this.H.a((CharSequence) str);
                    ac.this.H.a(true);
                    ac.this.H.setFocusable(false);
                    ac.this.H.setTouchInterceptor(r0);
                    ac.this.H.a((View) ac.this.G);
                }
            }
        };
        Handler handler = this.R;
        if (handler != null) {
            handler.post(r1);
        }
    }

    /* access modifiers changed from: private */
    public void e(int i2) {
        float f2;
        if (this.y != null) {
            ZoomAdjustMsgData zoomAdjustMsgData = new ZoomAdjustMsgData(this.J);
            zoomAdjustMsgData.mCaptureType = this.y.j() ^ true ? 1 : 0;
            zoomAdjustMsgData.mCaptureMode = this.L.getString("pref_camera_mode_key", "");
            zoomAdjustMsgData.mOrientation = this.q;
            zoomAdjustMsgData.mZoomType = i2;
            zoomAdjustMsgData.mbVideoRecording = this.M.ag();
            if (6 == i2) {
                zoomAdjustMsgData.mRateValue = String.valueOf(this.l);
            } else {
                if (this.y.n()) {
                    f2 = 0.6f;
                } else {
                    f2 = a();
                }
                zoomAdjustMsgData.mZoomValue = String.valueOf(f2);
            }
            if (this.M.j()) {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(1);
            } else if (this.M.m()) {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(3);
            } else {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(2);
            }
            zoomAdjustMsgData.mCameraId = this.M.ar();
            zoomAdjustMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.M.aq()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            zoomAdjustMsgData.report();
        }
    }

    public Drawable a(float f2) {
        if (this.y.a(f2) || (this.y.n() && Float.compare(f2, 1.0f) <= 0)) {
            return this.J.getDrawable(R.drawable.seekbar_zoom_ultra_wide_angle);
        }
        return null;
    }

    public boolean m() {
        return this.z.h();
    }

    /* access modifiers changed from: private */
    public boolean B() {
        ab abVar = this.N;
        if (abVar != null) {
            return !abVar.g() && !this.N.h() && !this.N.i() && !this.N.o() && !this.N.k() && !this.N.u() && !this.N.m() && !this.N.w();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean C() {
        ab abVar = this.N;
        return abVar != null && abVar.i() && !this.N.j();
    }

    /* access modifiers changed from: private */
    public boolean D() {
        a aVar = this.y;
        if (aVar == null || !aVar.r() || !"off".equals(this.L.getString("pref_video_blur_menu", "off")) || this.L.getBoolean("pref_camera_inertial_zoom_guide", false) || this.M.ag() || this.M.O()) {
            return false;
        }
        return true;
    }

    public boolean n() {
        return "off".equals(this.L.getString("pref_subsetting_key", "off"));
    }

    public void i(boolean z2) {
        this.t = z2;
    }

    public boolean o() {
        return this.t;
    }

    public float[] p() {
        ab abVar;
        if (this.z == null || (abVar = this.N) == null) {
            return null;
        }
        if (abVar.b() || this.N.d()) {
            return this.z.getUltraWideZoomDotViewLocation();
        }
        return null;
    }

    public boolean b(MotionEvent motionEvent) {
        if (!e()) {
            return false;
        }
        return a((View) this.z, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public boolean c(MotionEvent motionEvent) {
        y yVar = this.z;
        return yVar != null && yVar.b(motionEvent);
    }

    public void b(float f2) {
        this.d = f2;
    }

    /* compiled from: ZoomManager */
    private class c implements x {
        private c() {
        }

        public boolean a() {
            return ac.this.y.d();
        }

        public Drawable a(float f) {
            return ac.this.a(f);
        }

        public boolean b() {
            return ac.this.n();
        }

        public boolean c() {
            return ac.this.y.n();
        }

        public boolean d() {
            return ac.this.y.p();
        }
    }
}
