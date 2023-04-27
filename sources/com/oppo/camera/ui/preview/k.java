package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.g.b;
import com.airbnb.lottie.j;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.d;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.CommonComponent.SeekBar.ExposureControlSeekBar;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.RotateLottieAnimationView;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;

/* compiled from: FocusManager */
public class k implements d, ExposureControlSeekBar.OnSeekBarChangeListener {
    private int A = 0;
    private int B = 0;
    private int C = 0;
    private int D = 0;
    /* access modifiers changed from: private */
    public c E = null;
    private com.oppo.camera.k F = null;
    /* access modifiers changed from: private */
    public int G = 4;
    /* access modifiers changed from: private */
    public int H = 0;
    private boolean I = false;
    private boolean J = false;
    /* access modifiers changed from: private */
    public boolean K = false;
    private String L = VideoRecordMsgData.END_TYPE_NORMAL;
    private float M = 0.0f;
    private float N = 0.0f;
    private float O = 0.0f;
    private float P = 0.0f;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private boolean V = false;
    private boolean W = false;
    /* access modifiers changed from: private */
    public boolean X = false;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private Activity j = null;
    /* access modifiers changed from: private */
    public FaceView k = null;
    private t l = null;
    /* access modifiers changed from: private */
    public MultiFocusView m = null;
    /* access modifiers changed from: private */
    public FocusIndicatorRotateLayout n = null;
    /* access modifiers changed from: private */
    public ExposureControlSeekBar o = null;
    /* access modifiers changed from: private */
    public RotateLottieAnimationView p = null;
    /* access modifiers changed from: private */
    public View q = null;
    /* access modifiers changed from: private */
    public boolean r = false;
    /* access modifiers changed from: private */
    public RotateImageView s = null;
    /* access modifiers changed from: private */
    public Handler t = null;
    /* access modifiers changed from: private */
    public int u = -1;
    private int v = 1;
    private int w = 90;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    public k(Activity activity, com.oppo.camera.k kVar, c cVar) {
        this.j = activity;
        this.F = kVar;
        this.t = new a(this.j.getMainLooper());
        this.E = cVar;
    }

    public void a() {
        this.k = (FaceView) this.j.findViewById(R.id.face_view);
        this.l = (t) this.j.findViewById(R.id.track_focus_view);
        this.m = (MultiFocusView) this.j.findViewById(R.id.multi_focus_view);
        Resources resources = this.j.getResources();
        this.A = resources.getDimensionPixelSize(R.dimen.focus_view_size);
        this.B = resources.getDimensionPixelSize(R.dimen.focus_view_size);
        this.D = resources.getDimensionPixelSize(R.dimen.exposure_container_size);
        this.C = resources.getDimensionPixelSize(R.dimen.exposure_container_size);
        this.Q = resources.getDimensionPixelSize(R.dimen.focus_view_exposurebar_margin);
    }

    public void b() {
        this.L = this.F.getString("pref_camera_timer_shutter_key", this.j.getString(R.string.camera_shutter_mode_default_value));
    }

    public void c() {
        this.i = false;
        j(false);
        q();
        j();
    }

    public void d() {
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.E = null;
        this.t = null;
        FocusIndicatorRotateLayout focusIndicatorRotateLayout = this.n;
        if (focusIndicatorRotateLayout != null) {
            focusIndicatorRotateLayout.c();
            this.n = null;
        }
    }

    public void e() {
        if (this.n == null || this.o == null) {
            this.j.getLayoutInflater().inflate(R.layout.focus_exposure_indicator, (PreviewFrameLayout) this.j.findViewById(R.id.frame_layout));
            if (this.n == null) {
                this.n = (FocusIndicatorRotateLayout) this.j.findViewById(R.id.focus_indicator_rotate_layout);
                this.n.setBackground(Util.b((Context) this.j, (int) R.drawable.ic_focus_indicator));
                this.n.setRotation((float) this.R);
            }
            if (this.q == null) {
                this.q = this.j.findViewById(R.id.exposure_container);
            }
            if (this.p == null) {
                this.p = (RotateLottieAnimationView) this.j.findViewById(R.id.exposure_animation_view);
                this.p.setBackground(Util.b((Context) this.j, (int) R.drawable.exposure_anim_bg));
                this.p.setAnimation((int) R.raw.camera_exposure_anim);
                final int s2 = Util.s(this.j);
                this.p.a((j) new j() {
                    public void a(com.airbnb.lottie.d dVar) {
                        for (e next : k.this.p.a(new e("**"))) {
                            k.this.p.a(next, com.airbnb.lottie.k.f1837a, new com.airbnb.lottie.g.e<Integer>() {
                                /* renamed from: b */
                                public Integer a(b<Integer> bVar) {
                                    return Integer.valueOf(s2);
                                }
                            });
                            k.this.p.a(next, com.airbnb.lottie.k.f1838b, new com.airbnb.lottie.g.e<Integer>() {
                                /* renamed from: b */
                                public Integer a(b<Integer> bVar) {
                                    return Integer.valueOf(s2);
                                }
                            });
                        }
                    }
                });
            }
            if (this.o == null) {
                this.o = (ExposureControlSeekBar) this.j.findViewById(R.id.exposure_indicator_rotate_layout);
                this.o.setForceDarkAllowed(false);
                this.o.setOnSeekBarChangeListener(this);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                layoutParams.addRule(1, R.id.focus_indicator_rotate_layout);
                layoutParams.addRule(6, R.id.focus_indicator_rotate_layout);
                this.o.setOrientation(this.R, false);
            }
        }
    }

    public void a(boolean z2) {
        com.oppo.camera.e.a("FocusManager", "initialized");
        this.f = true;
        b(z2);
    }

    public void a(int i2) {
        this.v = i2;
    }

    public void a(int i2, int i3) {
        if (this.y != i2 || this.z != i3) {
            this.y = i2;
            this.z = i3;
        }
    }

    public void b(boolean z2) {
        this.g = z2;
    }

    public void b(int i2) {
        ExposureControlSeekBar exposureControlSeekBar = this.o;
        if (exposureControlSeekBar != null) {
            exposureControlSeekBar.setOrientation(i2, true);
        }
        this.R = i2;
    }

    public void c(int i2) {
        this.w = i2;
    }

    public void a(RotateImageView rotateImageView) {
        this.s = rotateImageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams.addRule(5, R.id.focus_indicator_rotate_layout);
        layoutParams.addRule(6, R.id.focus_indicator_rotate_layout);
        layoutParams.addRule(7, R.id.focus_indicator_rotate_layout);
        layoutParams.addRule(8, R.id.focus_indicator_rotate_layout);
        this.s.a(this.R, false);
    }

    public void a(int i2, int i3, int[] iArr, int i4, int i5) {
        boolean z2 = true;
        if ((this.H == i2 && 1 != i2) || this.j == null) {
            return;
        }
        if (i3 == 1 || 1 != this.x) {
            boolean z3 = this.H == i2;
            this.H = i2;
            this.G = i3;
            this.K = false;
            if (iArr != null) {
                this.K = iArr[0] == 1;
            }
            this.I = 1 == i5;
            if (!this.K || 1 != i2) {
                if (this.I || 1 != i2) {
                    z2 = false;
                }
                this.J = z2;
            }
            com.oppo.camera.e.a("FocusManager", "updateFocusState, state: " + i2 + ", mode: " + i3 + ", isPdaf: " + this.K + ", mbPdafConvergeDone: " + this.I + ", mbAfMoving: " + this.J);
            if (i4 == 0 || i4 == 3 || i4 == 4 || i4 == 5) {
                com.oppo.camera.e.a("FocusManager", "updateFocusState, return, cameraState: " + i4);
            } else if (!z3) {
                this.t.removeMessages(10);
                this.t.sendEmptyMessage(10);
            } else if (this.i && this.I) {
                com.oppo.camera.e.a("FocusManager", "updateFocusState, on AF status converged");
                this.t.removeMessages(12);
                this.t.sendEmptyMessage(12);
            }
        } else {
            com.oppo.camera.e.a("FocusManager", "updateFocusState, af is focusing, so discard caf state");
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        int i2 = this.H;
        switch (i2) {
            case 1:
                k(this.K);
                return;
            case 2:
                a(this.G, i2, true, this.K, false);
                return;
            case 4:
                if (3 == this.x) {
                    com.oppo.camera.e.d("FocusManager", "onFocusStateUpdate, af focused receive again");
                    return;
                }
                if (2 == this.d && y()) {
                    this.E.b(true, true);
                }
                a(this.G, this.H, false, this.K, true);
                Handler handler = this.t;
                if (handler != null) {
                    handler.removeMessages(6);
                    this.t.removeMessages(8);
                    this.t.removeMessages(7);
                    this.t.removeMessages(11);
                    this.t.sendEmptyMessageDelayed(7, 1000);
                    return;
                }
                return;
            case 5:
                if (2 == this.d && y()) {
                    this.E.b(true, true);
                }
                a(this.G, false, this.K, true);
                Handler handler2 = this.t;
                if (handler2 != null) {
                    handler2.removeMessages(6);
                    this.t.removeMessages(8);
                    this.t.removeMessages(7);
                    this.t.removeMessages(11);
                    this.t.sendEmptyMessageDelayed(7, 1000);
                    return;
                }
                return;
            case 6:
                a(this.G, true, this.K, false);
                return;
            default:
                return;
        }
    }

    private void k(boolean z2) {
        com.oppo.camera.e.a("FocusManager", "onFocusStart");
        FaceView faceView = this.k;
        if (faceView == null || !faceView.a()) {
            MultiFocusView multiFocusView = this.m;
            if ((multiFocusView != null && multiFocusView.f()) || this.E.l() || this.E.a() || this.W) {
                return;
            }
            if (z2 || this.X) {
                t();
                return;
            }
            e();
            this.n.setAlpha(1.0f);
            this.n.a();
            View view = this.q;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, boolean z2, boolean z3, boolean z4) {
        com.oppo.camera.e.a("FocusManager", "onFocusSuccess, mode: " + i2 + ", mExposureState: " + this.u);
        boolean z5 = true;
        if (i3 == 4 && i2 == 1) {
            d(3);
        }
        f();
        FaceView faceView = this.k;
        if (faceView == null || !faceView.a()) {
            MultiFocusView multiFocusView = this.m;
            if ((multiFocusView == null || !multiFocusView.f()) && !this.E.l()) {
                FocusIndicatorRotateLayout focusIndicatorRotateLayout = this.n;
                if (focusIndicatorRotateLayout != null && focusIndicatorRotateLayout.getVisibility() != 0) {
                    return;
                }
                if (!z3 && !this.X) {
                    e();
                    this.n.setAlpha(1.0f);
                    FocusIndicatorRotateLayout focusIndicatorRotateLayout2 = this.n;
                    if (this.u == -1) {
                        z5 = false;
                    }
                    focusIndicatorRotateLayout2.a(z2, z4, z5);
                    if (this.W) {
                        this.n.setVisibility(8);
                    }
                } else if (!z4) {
                    t();
                }
            }
        }
    }

    private void a(int i2, boolean z2, boolean z3, boolean z4) {
        com.oppo.camera.e.a("FocusManager", "onFocusFail, mode: " + i2);
        f();
        FaceView faceView = this.k;
        if (faceView == null || !faceView.a()) {
            MultiFocusView multiFocusView = this.m;
            if ((multiFocusView == null || !multiFocusView.f()) && !this.E.l() && !this.W) {
                FocusIndicatorRotateLayout focusIndicatorRotateLayout = this.n;
                if (focusIndicatorRotateLayout != null && focusIndicatorRotateLayout.getVisibility() != 0) {
                    return;
                }
                if (!z3 && !this.X) {
                    e();
                    this.n.setAlpha(1.0f);
                    this.n.b(z2, this.u != -1);
                } else if (!z4) {
                    t();
                }
            }
        }
    }

    public boolean f() {
        Handler handler = this.t;
        if (handler == null || !handler.hasMessages(5)) {
            return false;
        }
        this.t.removeMessages(9);
        this.t.removeMessages(5);
        l(false);
        return true;
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        if ("pref_camera_timer_shutter_key".equals(com.oppo.camera.entry.b.c(str))) {
            String string = sharedPreferences.getString("pref_camera_timer_shutter_key", this.j.getString(R.string.camera_shutter_mode_default_value));
            if (!string.equals(this.L)) {
                this.L = string;
            }
        }
    }

    public boolean g() {
        c cVar;
        Activity activity = this.j;
        if (activity != null && this.F.getString("pref_camera_tap_shutter_key", activity.getString(R.string.camera_tap_shutter_default_value)).equals("on") && (cVar = this.E) != null && cVar.f() && !this.E.k() && this.v != 3 && this.h && 2 != this.d && !this.E.s() && this.E.a("pref_camera_tap_shutter_key")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void l(boolean z2) {
        com.oppo.camera.e.a("FocusManager", "doCapture, mAfFocusState: " + this.H);
        if (!this.E.s()) {
            if (!this.f || z.t != 0) {
                this.E.a(true, false);
                this.E.b(false);
                return;
            }
            d(2);
            this.E.a(z2);
            this.E.b(false);
            this.i = false;
            d(0);
            this.t.removeMessages(1);
        }
    }

    public boolean c(boolean z2) {
        com.oppo.camera.e.a("FocusManager", "checkStateBeforeCapture, isAISSnapshot: " + z2);
        if (!e(z2)) {
            return false;
        }
        d(z2);
        return true;
    }

    public void d(boolean z2) {
        com.oppo.camera.e.a("FocusManager", "delayCapture, isAISSnapshot: " + z2);
        d(4);
        Handler handler = this.t;
        if (handler != null) {
            handler.removeMessages(5);
            if (z2) {
                this.t.sendEmptyMessageDelayed(5, 240);
            } else {
                this.t.sendEmptyMessageDelayed(5, 2000);
            }
            this.i = true;
        }
    }

    public boolean e(boolean z2) {
        Handler handler;
        if (v() && (handler = this.t) != null && handler.hasMessages(6)) {
            this.t.removeMessages(6);
            this.t.sendEmptyMessageDelayed(6, 3000);
        }
        return h(z2);
    }

    public void h() {
        c cVar = this.E;
        if (cVar != null) {
            cVar.b(false);
        }
        Handler handler = this.t;
        if (handler != null) {
            handler.removeMessages(5);
            this.i = false;
            if (4 == this.x) {
                d(0);
            }
        }
    }

    public void d(int i2) {
        com.oppo.camera.e.a("FocusManager", "setFocusState(), mFocusState: " + this.x + "=>" + i2);
        this.x = i2;
    }

    public void i() {
        com.oppo.camera.e.a("FocusManager", "checkFocusStateBeforeCapture, mFocusState: " + this.x);
        if (m() == 1 && this.x == 1) {
            k();
        }
    }

    public void e(int i2) {
        this.d = i2;
    }

    public void a(int i2, int i3, boolean z2) {
        c cVar;
        int i4 = i2;
        int i5 = i3;
        boolean z3 = z2;
        if (this.f && this.x != 2 && (cVar = this.E) != null) {
            if (z3) {
                cVar.a(i4, i5);
                m(true);
            }
            e();
            com.oppo.camera.e.a("FocusManager", "onSingleTapUp, fromUserTouch: " + z3);
            this.h = z3;
            int i6 = this.A;
            int i7 = this.B;
            int i8 = this.C;
            int i9 = this.D;
            if (!this.E.o()) {
                if (g() && this.E.g()) {
                    this.E.b(true);
                    l(true);
                    return;
                } else if (!this.E.n()) {
                    com.oppo.camera.e.a("FocusManager", "onSingleTapUp(), camera not support touch ae");
                    return;
                }
            }
            if (1 == m()) {
                this.E.q();
                l();
                this.h = z3;
            }
            if (g() && this.E.g()) {
                this.E.b(true);
                this.E.a(false, true);
            }
            int i10 = this.y;
            int i11 = this.z;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.setMargins(Util.a(i4 - (i6 / 2), 0, i10 - i6), Util.a(i5 - (i7 / 2), 0, i11 - i7), 0, 0);
            layoutParams.getRules()[13] = 0;
            this.n.requestLayout();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            int a2 = Util.a(i4 - (i8 / 2), 0, i10 - i8);
            int a3 = Util.a(i5 - (i9 / 2), 0, i11 - i9);
            layoutParams2.setMargins(a2, a3, 0, 0);
            layoutParams2.getRules()[13] = 0;
            this.q.requestLayout();
            this.S = a2;
            this.T = a3;
            a(a2, a3, i6, false);
            this.E.c();
            this.E.e();
            if (this.E.o()) {
                this.t.removeMessages(6);
                if (this.h && v()) {
                    this.t.sendEmptyMessageDelayed(6, 3000);
                }
            }
            this.q.setVisibility(8);
            if (this.E.m()) {
                this.o.show();
            }
            Rect w2 = this.E.w();
            float f2 = (float) i4;
            float f3 = (float) i5;
            float f4 = f2;
            float f5 = f3;
            Rect a4 = com.oppo.camera.a.a(f4, f5, this.y, this.z, this.A, this.g, this.w, 0, w2, com.oppo.camera.a.d());
            if (this.E.o()) {
                float f6 = f2;
                float f7 = f3;
                Rect a5 = com.oppo.camera.a.a(f6, f7, this.y, this.z, this.A, this.g, this.w, 0, w2, com.oppo.camera.a.c());
                if (1 == this.d) {
                    this.E.p();
                    a(a5);
                    t();
                } else {
                    j(true);
                    this.n.a();
                    a(a5, a4);
                }
                if (g()) {
                    d(false);
                    return;
                }
                return;
            }
            this.n.a();
            this.E.a(a4, (Rect) null);
            this.V = false;
            n();
        }
    }

    private void D() {
        a(this.S, this.T, this.A, true);
    }

    private void a(final int i2, final int i3, final int i4, boolean z2) {
        if (z2) {
            ExposureControlSeekBar exposureControlSeekBar = this.o;
            float[] fArr = new float[2];
            FocusIndicatorRotateLayout focusIndicatorRotateLayout = this.n;
            fArr[0] = focusIndicatorRotateLayout != null ? focusIndicatorRotateLayout.getAlpha() : 1.0f;
            fArr[1] = 0.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(exposureControlSeekBar, "alpha", fArr);
            ofFloat.setDuration(300);
            ofFloat.start();
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    k.this.a(i2, i3, i4);
                    k.this.o.requestLayout();
                    ExposureControlSeekBar b2 = k.this.o;
                    float[] fArr = new float[2];
                    fArr[0] = 0.0f;
                    fArr[1] = k.this.n != null ? k.this.n.getAlpha() : 1.0f;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2, "alpha", fArr);
                    ofFloat.setDuration(300);
                    ofFloat.start();
                }
            });
            return;
        }
        a(i2, i3, i4);
    }

    public void a(int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        int i5 = this.R;
        if (i5 != 0) {
            if (i5 != 90) {
                if (i5 != 180) {
                    if (i5 == 270) {
                        if (i3 + i4 >= this.z - 5) {
                            layoutParams.setMargins(-i4, 0, 0, 0);
                            return;
                        } else {
                            layoutParams.setMargins(-i4, i4 + this.Q, 0, 0);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else if (i3 <= 5) {
                layoutParams.setMargins(-i4, i4 + this.Q, 0, 0);
                return;
            } else {
                layoutParams.setMargins(-i4, 0, 0, 0);
                return;
            }
        }
        if (i2 + i4 >= this.y - 5) {
            layoutParams.setMargins(-i4, 0, 0, 0);
        } else {
            layoutParams.setMargins(this.Q, 0, 0, 0);
        }
    }

    public void j() {
        d(0);
        o();
        this.V = false;
        n();
    }

    private void a(Rect rect, Rect rect2) {
        com.oppo.camera.e.a("FocusManager", "Start autofocus.");
        FaceView faceView = this.k;
        if (faceView != null) {
            faceView.d();
        }
        MultiFocusView multiFocusView = this.m;
        if (multiFocusView != null) {
            multiFocusView.c();
        }
        if (v()) {
            this.V = true;
        }
        this.E.a(1, rect, rect2);
        d(1);
        n();
        this.t.removeMessages(1);
    }

    public void k() {
        com.oppo.camera.e.a("FocusManager", "resetAutoFocusMode");
        this.d = 0;
        c cVar = this.E;
        if (cVar != null) {
            cVar.p();
        }
        l();
    }

    public void l() {
        com.oppo.camera.e.a("FocusManager", "resetCameraFocusState()");
        o();
        FaceView faceView = this.k;
        if (faceView != null) {
            faceView.e();
        }
        MultiFocusView multiFocusView = this.m;
        if (multiFocusView != null) {
            multiFocusView.d();
        }
        d(0);
        this.t.removeMessages(1);
    }

    public int m() {
        return this.E.t();
    }

    public void n() {
        j jVar;
        if (this.f) {
            e();
            FaceView faceView = this.k;
            boolean z2 = faceView != null && faceView.a();
            MultiFocusView multiFocusView = this.m;
            boolean z3 = multiFocusView != null && multiFocusView.f();
            if (z2) {
                jVar = this.k;
            } else if (z3) {
                jVar = this.m;
            } else {
                jVar = this.n;
            }
            boolean z4 = !this.h;
            Handler handler = this.t;
            if (handler != null) {
                handler.removeMessages(7);
            }
            this.n.setAlpha(1.0f);
            int i2 = this.G;
            if (4 == i2 || (3 == i2 && !this.X)) {
                jVar.a(z4, this.u != -1);
            }
            if (this.h && this.t != null) {
                if (!this.E.i() && !this.V) {
                    this.t.removeMessages(6);
                    this.t.sendEmptyMessageDelayed(6, 3000);
                }
                RotateImageView rotateImageView = this.s;
                if (rotateImageView != null) {
                    rotateImageView.setAlpha(1.0f);
                }
                this.t.removeMessages(7);
                this.t.removeMessages(8);
                this.t.removeMessages(11);
                if (this.E.i()) {
                    this.t.sendEmptyMessageDelayed(7, 1000);
                    this.r = true;
                }
                if (this.E.m()) {
                    FocusIndicatorRotateLayout focusIndicatorRotateLayout = this.n;
                    if ((focusIndicatorRotateLayout instanceof FocusIndicatorRotateLayout) && !focusIndicatorRotateLayout.b() && this.n.getVisibility() == 0) {
                        this.o.setVisibility(0);
                    }
                }
            }
        }
    }

    public void o() {
        if (this.f) {
            this.h = false;
            this.j.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.n != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) k.this.n.getLayoutParams();
                        layoutParams.getRules()[13] = -1;
                        layoutParams.setMargins(0, 0, 0, 0);
                        k.this.n.requestLayout();
                        k.this.n.c();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) k.this.q.getLayoutParams();
                        layoutParams2.getRules()[13] = -1;
                        layoutParams2.setMargins(0, 0, 0, 0);
                        k.this.q.requestLayout();
                        k.this.q.setVisibility(8);
                    }
                    k.this.m(true);
                    if (k.this.s != null) {
                        k.this.s.setVisibility(8);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void m(boolean z2) {
        ExposureControlSeekBar exposureControlSeekBar = this.o;
        if (exposureControlSeekBar != null) {
            exposureControlSeekBar.setVisibility(4);
            this.o.setBarVisibility(false);
        }
        ExposureControlSeekBar exposureControlSeekBar2 = this.o;
        if (!(exposureControlSeekBar2 == null || !z2 || (this.u == -1 && Float.compare(exposureControlSeekBar2.getValue(), 50.0f) == 0))) {
            this.o.resetProgress();
            b(0.5f);
        }
        this.u = -1;
    }

    public void p() {
        Handler handler = this.t;
        if (handler != null) {
            handler.removeMessages(6);
            this.t.removeMessages(7);
            this.t.removeMessages(8);
        }
    }

    public void q() {
        this.t.removeMessages(1);
        this.t.removeMessages(5);
        this.t.removeCallbacksAndMessages((Object) null);
    }

    public boolean r() {
        return this.e;
    }

    public boolean s() {
        View view = this.q;
        return view != null && view.getVisibility() == 0;
    }

    public void f(boolean z2) {
        this.e = z2;
    }

    public void t() {
        Activity activity = this.j;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.n != null) {
                        k.this.n.c();
                        k.this.m(true);
                    }
                    if (k.this.s != null) {
                        k.this.s.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r11) {
        /*
            r10 = this;
            int r0 = r10.u
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x0022
            com.oppo.camera.ui.preview.c r0 = r10.E
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x0019
            boolean r0 = r10.h
            if (r0 == 0) goto L_0x0019
            boolean r0 = r10.r
            if (r0 != 0) goto L_0x0022
        L_0x0019:
            int r11 = r11.getAction()
            if (r11 != 0) goto L_0x0021
            r10.r = r3
        L_0x0021:
            return r2
        L_0x0022:
            int r0 = r11.getPointerCount()
            r4 = 1000(0x3e8, double:4.94E-321)
            r6 = 11
            r7 = 7
            if (r0 <= r3) goto L_0x003a
            android.os.Handler r11 = r10.t
            if (r11 == 0) goto L_0x0039
            r11.removeMessages(r6)
            android.os.Handler r11 = r10.t
            r11.sendEmptyMessageDelayed(r7, r4)
        L_0x0039:
            return r2
        L_0x003a:
            int r0 = r11.getAction()
            r8 = 8
            r9 = 2
            if (r0 == 0) goto L_0x013f
            r1 = 180(0xb4, float:2.52E-43)
            if (r0 == r3) goto L_0x00fc
            if (r0 == r9) goto L_0x004b
            goto L_0x016d
        L_0x004b:
            com.oppo.camera.ui.CommonComponent.SeekBar.ExposureControlSeekBar r0 = r10.o
            if (r0 == 0) goto L_0x0056
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x0056
            return r2
        L_0x0056:
            float r0 = r10.O
            float r4 = r11.getY()
            float r0 = r0 - r4
            float r4 = r10.P
            float r5 = r11.getX()
            float r4 = r4 - r5
            int r5 = r10.R
            if (r5 == 0) goto L_0x0075
            if (r5 != r1) goto L_0x006b
            goto L_0x0075
        L_0x006b:
            r0 = 90
            if (r5 != r0) goto L_0x0072
            r1 = r3
            r0 = r4
            goto L_0x0089
        L_0x0072:
            float r0 = -r4
        L_0x0073:
            r1 = r3
            goto L_0x0089
        L_0x0075:
            float r1 = java.lang.Math.abs(r0)
            float r4 = java.lang.Math.abs(r4)
            r5 = 1058306785(0x3f147ae1, float:0.58)
            float r4 = r4 * r5
            int r1 = java.lang.Float.compare(r1, r4)
            if (r1 <= 0) goto L_0x0088
            goto L_0x0073
        L_0x0088:
            r1 = r2
        L_0x0089:
            r4 = 1090519040(0x41000000, float:8.0)
            if (r1 == 0) goto L_0x00ec
            float r1 = java.lang.Math.abs(r0)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ec
            int r1 = r10.u
            if (r1 != r3) goto L_0x00ec
            com.oppo.camera.ui.preview.FocusIndicatorRotateLayout r1 = r10.n
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x00a2
            r1.setAlpha(r5)
        L_0x00a2:
            android.view.View r1 = r10.q
            if (r1 == 0) goto L_0x00a9
            r1.setAlpha(r5)
        L_0x00a9:
            com.oppo.camera.ui.RotateImageView r1 = r10.s
            if (r1 == 0) goto L_0x00b0
            r1.setAlpha(r5)
        L_0x00b0:
            int r1 = r10.z
            float r1 = (float) r1
            float r1 = r0 / r1
            r6 = 1112014848(0x42480000, float:50.0)
            float r1 = r1 * r6
            com.oppo.camera.ui.CommonComponent.SeekBar.ExposureControlSeekBar r6 = r10.o
            if (r6 == 0) goto L_0x00c9
            r6.setAlpha(r5)
            com.oppo.camera.ui.CommonComponent.SeekBar.ExposureControlSeekBar r5 = r10.o
            r5.setBarVisibility(r3)
            com.oppo.camera.ui.CommonComponent.SeekBar.ExposureControlSeekBar r5 = r10.o
            r5.setMoveProgress(r1)
        L_0x00c9:
            com.oppo.camera.ui.preview.FocusIndicatorRotateLayout r1 = r10.n
            if (r1 == 0) goto L_0x00d1
            r5 = 4
            r1.setVisibility(r5)
        L_0x00d1:
            com.oppo.camera.ui.RotateImageView r1 = r10.s
            if (r1 == 0) goto L_0x00d8
            r1.setVisibility(r8)
        L_0x00d8:
            android.view.View r1 = r10.q
            if (r1 == 0) goto L_0x00df
            r1.setVisibility(r2)
        L_0x00df:
            float r1 = r11.getY()
            r10.O = r1
            float r11 = r11.getX()
            r10.P = r11
            r2 = r3
        L_0x00ec:
            float r11 = java.lang.Math.abs(r0)
            int r11 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x016d
            int r11 = r10.u
            if (r11 != 0) goto L_0x016d
            r10.u = r3
            goto L_0x016d
        L_0x00fc:
            android.os.Handler r0 = r10.t
            if (r0 == 0) goto L_0x0108
            r0.removeMessages(r6)
            android.os.Handler r0 = r10.t
            r0.sendEmptyMessageDelayed(r7, r4)
        L_0x0108:
            float r0 = r10.N
            float r4 = r11.getY()
            float r0 = r0 - r4
            float r4 = r10.M
            float r11 = r11.getX()
            float r4 = r4 - r11
            int r11 = r10.u
            if (r11 != r3) goto L_0x016d
            com.oppo.camera.ui.preview.c r11 = r10.E
            if (r11 == 0) goto L_0x0121
            r11.h()
        L_0x0121:
            r10.u = r9
            int r11 = r10.R
            r5 = 1101004800(0x41a00000, float:20.0)
            if (r11 == 0) goto L_0x0135
            if (r11 != r1) goto L_0x012c
            goto L_0x0135
        L_0x012c:
            float r11 = java.lang.Math.abs(r4)
            int r11 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x016d
            goto L_0x013d
        L_0x0135:
            float r11 = java.lang.Math.abs(r0)
            int r11 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x016d
        L_0x013d:
            r2 = r3
            goto L_0x016d
        L_0x013f:
            float r0 = r11.getX()
            r10.M = r0
            float r11 = r11.getY()
            r10.N = r11
            float r11 = r10.M
            r10.P = r11
            float r11 = r10.N
            r10.O = r11
            android.os.Handler r11 = r10.t
            if (r11 == 0) goto L_0x0165
            r0 = 6
            r11.removeMessages(r0)
            android.os.Handler r11 = r10.t
            r11.removeMessages(r7)
            android.os.Handler r11 = r10.t
            r11.removeMessages(r8)
        L_0x0165:
            int r11 = r10.u
            if (r11 == r1) goto L_0x016b
            if (r11 != r9) goto L_0x016d
        L_0x016b:
            r10.u = r2
        L_0x016d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.k.a(android.view.MotionEvent):boolean");
    }

    public void onProgressChange(float f2) {
        b(f2);
    }

    public void onOrientationChange(int i2) {
        this.R = i2;
        D();
        RotateImageView rotateImageView = this.s;
        if (rotateImageView != null) {
            rotateImageView.a(this.R, true);
        }
        RotateLottieAnimationView rotateLottieAnimationView = this.p;
        if (rotateLottieAnimationView != null) {
            rotateLottieAnimationView.a(this.R, true);
        }
    }

    private void b(float f2) {
        c cVar = this.E;
        if (cVar != null) {
            int u2 = cVar.u();
            int v2 = this.E.v();
            if (u2 != 0 || v2 != 0) {
                this.E.a((int) (((float) v2) + (((float) (u2 - v2)) * f2)));
            }
        }
    }

    public boolean u() {
        return this.u > 0;
    }

    public void g(boolean z2) {
        com.oppo.camera.e.a("FocusManager", "disableFocusIndicator, disable: " + z2);
        FocusIndicatorRotateLayout focusIndicatorRotateLayout = this.n;
        if (focusIndicatorRotateLayout != null) {
            focusIndicatorRotateLayout.a(z2);
        }
    }

    public boolean v() {
        return this.E != null && (!this.F.getString("pref_camera_tap_shutter_key", this.j.getString(R.string.camera_tap_shutter_default_value)).equals("on") || !this.E.f() || !this.E.a("pref_camera_tap_shutter_key")) && this.E.r() && this.v != 3;
    }

    public void w() {
        if (v() && !r() && this.t != null && this.E.a(CameraFunction.RESET_AUTO_FOCUS)) {
            if ((G() || H() || (this.E.j() && 3 == this.x && 1 != this.u)) && !E() && !F()) {
                this.t.removeMessages(6);
                this.t.sendEmptyMessage(6);
            }
        }
    }

    public void x() {
        if (v() && !r() && this.t != null) {
            if ((G() || H() || (this.E.j() && 3 == this.x && 1 != this.u && !E() && !F())) && this.E.a(CameraFunction.RESET_AUTO_FOCUS)) {
                this.t.removeMessages(6);
                this.t.sendEmptyMessageDelayed(6, 3000);
            }
        }
    }

    private boolean E() {
        FocusIndicatorRotateLayout focusIndicatorRotateLayout = this.n;
        return focusIndicatorRotateLayout != null && focusIndicatorRotateLayout.getVisibility() == 0 && 1.0f == this.n.getAlpha();
    }

    private boolean F() {
        View view = this.q;
        return view != null && view.getVisibility() == 0 && 1.0f == this.q.getAlpha();
    }

    private boolean G() {
        FocusIndicatorRotateLayout focusIndicatorRotateLayout;
        FocusIndicatorRotateLayout focusIndicatorRotateLayout2 = this.n;
        if (focusIndicatorRotateLayout2 != null && Math.abs(0.5f - focusIndicatorRotateLayout2.getAlpha()) <= 0.01f && (focusIndicatorRotateLayout = this.n) != null && focusIndicatorRotateLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private boolean H() {
        View view;
        View view2 = this.q;
        if (view2 != null && Math.abs(0.5f - view2.getAlpha()) <= 0.01f && (view = this.q) != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r0 = r1.l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean y() {
        /*
            r1 = this;
            com.oppo.camera.ui.preview.FocusIndicatorRotateLayout r0 = r1.n
            if (r0 == 0) goto L_0x000a
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x001e
        L_0x000a:
            android.view.View r0 = r1.q
            if (r0 == 0) goto L_0x0014
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x001e
        L_0x0014:
            com.oppo.camera.ui.preview.t r0 = r1.l
            if (r0 == 0) goto L_0x0020
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.k.y():boolean");
    }

    public boolean h(boolean z2) {
        int i2 = this.H;
        boolean z3 = 2 == i2 || 6 == i2 || i2 == 0;
        com.oppo.camera.e.a("FocusManager", "inScanProgress, afDone: " + z3 + ", mAfFocusState: " + this.H + ", mbPdaf: " + this.K + ", mbPdafConvergeDone: " + this.I + ", mbAfMoving: " + this.J + ", isAISSnapshot: " + z2);
        int i3 = this.G;
        if (4 == i3) {
            if (z3 || this.I) {
                return false;
            }
            if (z2) {
                return !this.J;
            }
            if (this.H != 1 || this.K) {
                return false;
            }
            return true;
        } else if (1 == i3 && this.H == 3 && !this.K) {
            return true;
        } else {
            return false;
        }
    }

    public void z() {
        Handler handler = this.t;
        if (handler != null) {
            handler.removeMessages(13);
            this.t.sendEmptyMessage(13);
        }
    }

    /* compiled from: FocusManager */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            j jVar;
            com.oppo.camera.e.a("FocusManager", "handleMessage, msg: " + message.what);
            int i = message.what;
            boolean z = true;
            if (i != 1) {
                boolean z2 = false;
                if (i != 2) {
                    switch (i) {
                        case 5:
                            k.this.t.removeMessages(5);
                            if (!k.this.g() || !Util.p()) {
                                z = false;
                            }
                            if (z) {
                                k.this.t.removeMessages(9);
                                k.this.t.sendEmptyMessageDelayed(9, 100);
                                return;
                            }
                            k.this.l(false);
                            return;
                        case 6:
                            if (!k.this.r() && !k.this.E.k()) {
                                if (k.this.n != null) {
                                    k.this.n.c();
                                }
                                if (k.this.o != null) {
                                    k.this.o.setVisibility(4);
                                }
                                if (k.this.t != null) {
                                    k.this.t.sendEmptyMessage(1);
                                }
                                if (!k.this.E.i()) {
                                    k.this.d(0);
                                    if (k.this.t == null || !k.this.t.hasMessages(5)) {
                                        k.this.E.p();
                                        return;
                                    }
                                    k.this.t.removeMessages(9);
                                    k.this.t.removeMessages(5);
                                    k.this.l(true);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 7:
                            if (k.this.o != null && k.this.o.getVisibility() == 0) {
                                k.this.o.setAlpha(0.5f);
                            }
                            if (k.this.n != null) {
                                k.this.n.setAlpha(0.5f);
                            }
                            if (k.this.s != null) {
                                k.this.s.setAlpha(0.5f);
                            }
                            if (k.this.q != null && k.this.q.getVisibility() == 0) {
                                k.this.q.setAlpha(0.5f);
                            }
                            if (k.this.t != null) {
                                k.this.t.removeMessages(8);
                                k.this.t.sendEmptyMessageDelayed(8, 1000);
                                if (k.this.E.j() && 1 != k.this.u) {
                                    k.this.t.removeMessages(11);
                                    k.this.t.sendEmptyMessageDelayed(11, 1500);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 8:
                            if (k.this.o != null) {
                                k.this.o.setBarVisibility(false);
                                boolean unused = k.this.r = false;
                            }
                            if (k.this.t != null && !k.this.v()) {
                                k.this.t.sendEmptyMessageDelayed(6, 3000);
                                return;
                            }
                            return;
                        case 9:
                            k.this.l(true);
                            return;
                        case 10:
                            k.this.C();
                            return;
                        case 11:
                            if (k.this.n != null) {
                                k.this.n.c();
                                k.this.m(false);
                            }
                            if (k.this.s != null) {
                                k.this.s.setVisibility(8);
                            }
                            if (k.this.q != null) {
                                k.this.q.setVisibility(8);
                                return;
                            }
                            return;
                        case 12:
                            k.this.d(3);
                            k kVar = k.this;
                            kVar.a(kVar.G, k.this.H, true, k.this.K, false);
                            com.oppo.camera.e.b("FocusManager", "handleMessage, check AF converged");
                            return;
                        case 13:
                            k.this.f(8);
                            k.this.h(8);
                            k.this.g(8);
                            k.this.i(8);
                            return;
                        default:
                            return;
                    }
                } else {
                    boolean z3 = k.this.u != -1;
                    boolean z4 = k.this.k != null && k.this.k.a();
                    if (k.this.m != null && k.this.m.f()) {
                        z2 = true;
                    }
                    if (z4) {
                        jVar = k.this.k;
                    } else if (z2) {
                        jVar = k.this.m;
                    } else {
                        jVar = k.this.n;
                    }
                    if (!k.this.X) {
                        jVar.a(true, z3);
                    }
                }
            } else {
                k.this.k();
                k.this.E.b();
                k.this.E.d();
            }
        }
    }

    public void i(boolean z2) {
        this.W = z2;
    }

    public void A() {
        Activity activity = this.j;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.n != null) {
                        k.this.n.d();
                    }
                }
            });
            if (this.E.j() && 1 != this.u) {
                this.t.removeMessages(11);
                this.t.sendEmptyMessageDelayed(11, 1500);
            }
        }
    }

    public void f(final int i2) {
        Activity activity = this.j;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.n != null) {
                        k.this.n.setVisibility(i2);
                    }
                }
            });
        }
    }

    public void g(final int i2) {
        Activity activity = this.j;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.o != null) {
                        k.this.o.setVisibility(i2);
                    }
                }
            });
        }
    }

    public void h(final int i2) {
        Activity activity = this.j;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.q != null) {
                        k.this.q.setVisibility(i2);
                    }
                }
            });
        }
    }

    public void i(final int i2) {
        Activity activity = this.j;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (k.this.s != null) {
                        k.this.s.setVisibility(i2);
                    }
                }
            });
        }
    }

    public void onProgressMoveChanged(float f2) {
        com.oppo.camera.e.a("FocusManager", "onProgressMoveChanged, progress: " + f2);
        this.p.setProgress(1.0f - (f2 / 100.0f));
    }

    public boolean B() {
        return this.i;
    }

    public void a(float f2) {
        t tVar = this.l;
        if (tVar != null) {
            tVar.setZoomValue(f2);
        }
    }

    public void a(int[] iArr) {
        t tVar = this.l;
        if (tVar != null) {
            tVar.a(iArr);
        }
    }

    public void j(boolean z2) {
        t tVar = this.l;
        if (tVar != null) {
            tVar.a();
        }
        this.X = false;
        this.E.a(new int[]{0, 0, 0, 0}, z2);
    }

    public void a(Rect rect) {
        this.E.a(new int[]{rect.left, rect.top, rect.right, rect.bottom}, true);
        this.X = true;
        t tVar = this.l;
        if (tVar != null) {
            tVar.b();
        }
    }
}
