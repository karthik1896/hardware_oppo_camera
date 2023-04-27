package com.oppo.camera.ui.control;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.a.a.g;
import com.a.a.h;
import com.a.a.j;
import com.a.a.l;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.d;
import com.oppo.camera.k;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.control.ShutterButton;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.menu.b.c;
import com.oppo.camera.ui.menu.shareedit.a;
import com.oppo.camera.ui.widget.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.util.List;

/* compiled from: CameraControlUI */
public class b implements View.OnClickListener, d, ShutterButton.OnShutterButtonListener, c.e {
    private RelativeLayout A = null;
    private RotateImageView B = null;
    private RotateImageView C = null;
    private RotateImageView D = null;
    private ShutterButton E = null;
    private MainShutterButton F = null;
    /* access modifiers changed from: private */
    public ShutterButton G = null;
    private ShutterButton H = null;
    private ShutterButton I = null;
    private ShutterButton J = null;
    private ShutterButton K = null;
    private ThumbImageView L = null;
    private e M = null;
    /* access modifiers changed from: private */
    public f N = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.menu.shareedit.a O = null;
    private TextView P = null;
    private TextView Q = null;
    private d R = null;
    private c S = null;
    private com.oppo.camera.ui.menu.b.d T = new com.oppo.camera.ui.menu.b.d();
    private List<Integer> U = null;
    private int V = 0;
    /* access modifiers changed from: private */
    public ContentResolver W = null;
    private e X = null;
    private RotateImageView Y = null;
    private e Z = null;
    private f aa = null;
    private f ab = null;
    private boolean ac = false;
    private boolean ad = false;
    private boolean ae = false;
    private ShutterButton.OnShutterButtonListener af = new ShutterButton.OnShutterButtonListener() {
        public boolean I() {
            return true;
        }

        public void a(ShutterButton shutterButton, boolean z) {
            if (b.this.u != null) {
                b.this.u.b(z);
            }
        }

        public void a(ShutterButton shutterButton) {
            com.oppo.camera.e.a("CameraControlUI", "onShutterButtonClick, ShutterButton.id: " + shutterButton.getId());
            if (b.this.ak()) {
                com.oppo.camera.e.a("CameraControlUI", "onShutterButtonClick, moreTab is showing....");
                return;
            }
            if (com.oppo.camera.ui.menu.f.a()) {
                com.oppo.camera.ui.menu.f.d();
                com.oppo.camera.e.a("CameraControlUI", "onShutterButtonClick, camera menu is popup....");
            }
            com.oppo.camera.e.a("CameraCapturePerformance.onShutterButtonClick");
            if (b.this.n == 3) {
                b.this.u.k();
            } else {
                b.this.u.h();
            }
            com.oppo.camera.e.b("CameraCapturePerformance.onShutterButtonClick");
        }

        public void b(ShutterButton shutterButton) {
            com.oppo.camera.e.a("CameraControlUI", "onShutterButtonLongClick, ShutterButton.id: " + shutterButton.getId());
            if (b.this.ak()) {
                com.oppo.camera.e.a("CameraControlUI", "onShutterButtonLongClick, moreTab is showing....");
                return;
            }
            if (com.oppo.camera.ui.menu.f.a()) {
                com.oppo.camera.ui.menu.f.d();
            }
            com.oppo.camera.e.a("CameraCapturePerformance.onShutterButtonLongClick");
            if (b.this.u != null && shutterButton.getId() == R.id.shutter_button) {
                b.this.u.i();
            }
            com.oppo.camera.e.b("CameraCapturePerformance.onShutterButtonLongClick");
        }

        public void c(ShutterButton shutterButton) {
            if (b.this.u != null && shutterButton != null && shutterButton.getId() == R.id.shutter_button) {
                b.this.u.j();
            }
        }

        public void d(ShutterButton shutterButton) {
            if (b.this.v != null) {
                b.this.v.Y();
            }
        }

        public void e(ShutterButton shutterButton) {
            if (b.this.v != null) {
                b.this.v.Y();
            }
        }
    };
    private ShutterButton.OnShutterButtonListener ag = new ShutterButton.OnShutterButtonListener() {
        public void a(ShutterButton shutterButton, boolean z) {
        }

        public void b(ShutterButton shutterButton) {
        }

        public void c(ShutterButton shutterButton) {
        }

        public void a(ShutterButton shutterButton) {
            com.oppo.camera.e.a("CameraControlUI", "onShutterButtonClick, switch_camera_button");
            if (com.oppo.camera.ui.menu.f.a()) {
                com.oppo.camera.ui.menu.f.d();
            }
            b.this.u.m();
        }

        public void d(ShutterButton shutterButton) {
            if (b.this.u != null) {
                b.this.u.n();
            }
        }

        public void e(ShutterButton shutterButton) {
            if (b.this.u != null) {
                b.this.u.o();
            }
        }

        public boolean I() {
            if (b.this.G != null) {
                return b.this.G.isEnabled();
            }
            return true;
        }
    };
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g;
    private boolean h;
    /* access modifiers changed from: private */
    public boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    /* access modifiers changed from: private */
    public int n = 1;
    private int o = 0;
    private long p = 0;
    private AsyncTask<Void, Void, e> q = null;
    private Bitmap r = null;
    private Activity s = null;
    private k t = null;
    /* access modifiers changed from: private */
    public a u = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.f v = null;
    private RelativeLayout w = null;
    private View x = null;
    private RelativeLayout y = null;
    private RelativeLayout z = null;

    /* renamed from: com.oppo.camera.ui.control.b$b  reason: collision with other inner class name */
    /* compiled from: CameraControlUI */
    public interface C0100b {
        void a(e eVar);
    }

    public boolean I() {
        return true;
    }

    public void d(ShutterButton shutterButton) {
    }

    public void e(ShutterButton shutterButton) {
    }

    public b(Activity activity, k kVar, com.oppo.camera.ui.f fVar) {
        this.s = activity;
        this.t = kVar;
        this.v = fVar;
        this.W = this.s.getContentResolver();
    }

    public void a(boolean z2) {
        a(z2, false);
    }

    public void a(boolean z2, boolean z3) {
        c cVar = this.S;
        if (cVar != null) {
            cVar.a(4, z2, z3);
        }
    }

    public void a(int i2, long j2, long j3, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener) {
        c cVar = this.S;
        if (cVar != null) {
            cVar.a(i2, j2, j3, timeInterpolator, animatorListener, false);
        }
    }

    public void b(boolean z2) {
        b(z2, false);
    }

    public void b(boolean z2, boolean z3) {
        c cVar = this.S;
        if (cVar != null) {
            cVar.a(0, z2, z3);
        }
    }

    public boolean a() {
        c cVar = this.S;
        if (cVar != null) {
            return cVar.e();
        }
        return false;
    }

    public boolean b() {
        c cVar = this.S;
        if (cVar != null) {
            return cVar.f();
        }
        return false;
    }

    public void a(c cVar) {
        if (!this.F.b(cVar)) {
            this.F.a(cVar);
        }
    }

    public void c(boolean z2) {
        if (!this.v.aI()) {
            if (!this.v.g("pref_support_switch_camera") || (!this.v.B() && !u(z2))) {
                f(4);
            } else {
                f(0);
                if (u(z2)) {
                    g(false, false);
                }
            }
            if (!this.v.g("pref_support_thumbnail") || (!this.v.B() && !u(z2))) {
                i(4);
                return;
            }
            i(0);
            if (u(z2)) {
                h(false, false);
            }
        }
    }

    private boolean u(boolean z2) {
        return 1 == this.n && z2 && this.v.c();
    }

    public void c() {
        this.l = Util.J();
        f();
        this.F = (MainShutterButton) this.s.findViewById(R.id.shutter_button);
        c cVar = new c(1, "button_color_inside_none");
        this.F.setButtonTypeAndInvalidate(cVar);
        this.F.setOnShutterButtonListener(this.af);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT)) {
            this.F.setBackgroundResource(R.drawable.button_shutter_low_shadow_background);
        }
        this.F.setVisibility(0);
        this.F.setCameraUIListener(this.v);
        com.oppo.camera.ui.inverse.c.INS.registerInverse(this.s, this.F);
        this.G = (ShutterButton) this.s.findViewById(R.id.switch_camera_button);
        this.G.setOnShutterButtonListener(this.ag);
        this.G.setVisibility(0);
        this.G.setCameraUIListener(this.v);
        com.oppo.camera.ui.inverse.c.INS.registerInverse(this.s, this.G);
        if (this.n == 1) {
            if (this.m) {
                this.L = (ThumbImageView) this.z.findViewById(R.id.thumbnail);
            } else {
                this.s.getLayoutInflater().inflate(R.layout.camera_thumbnail, this.y);
                this.L = (ThumbImageView) this.y.findViewById(R.id.thumbnail);
            }
            this.L.setOnClickListener(this);
            this.L.a(BitmapFactory.decodeResource(this.s.getResources(), R.drawable.thumbnail_bg_normal), 0, false);
            this.L.setVisibility(0);
            this.o = this.L.getLayoutParams().width;
        } else {
            com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
            if (aVar != null) {
                aVar.f();
            }
            if (this.E == null) {
                this.E = (ShutterButton) this.s.getLayoutInflater().inflate(R.layout.view_stub_camera_from_other_app_close_btn, this.y).findViewById(R.id.camera_from_other_app_close_btn);
            }
            this.E.setOnShutterButtonListener(this);
            this.E.setVisibility(0);
            this.E.setCameraUIListener(this.v);
            if (this.n == 3) {
                cVar.a("button_color_inside_red");
                this.F.setButtonTypeAndInvalidate(cVar);
                this.F.requestFocus();
            }
        }
        ar();
        this.Z = (e) this.s.findViewById(R.id.video_clip_view);
    }

    public void d() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT)) {
            if (this.Y == null) {
                this.Y = (RotateImageView) this.s.getLayoutInflater().inflate(R.layout.view_load_video_button, (ViewGroup) this.s.findViewById(R.id.camera)).findViewById(R.id.load_video_button);
                this.Y.setOnClickListener(this);
                this.Y.setVisibility(4);
            }
            if (this.J == null) {
                this.J = (ShutterButton) this.s.getLayoutInflater().inflate(R.layout.view_double_exposure_revert_button, this.y).findViewById(R.id.revert_button);
                this.J.setOnClickListener(this);
                this.J.setVisibility(4);
                this.J.setCameraUIListener(this.v);
            }
            if (this.K == null) {
                this.K = (ShutterButton) this.s.getLayoutInflater().inflate(R.layout.view_double_exposure_cancel_button, this.y).findViewById(R.id.cancel_button);
                this.K.setOnClickListener(this);
                this.K.setVisibility(4);
                this.K.setCameraUIListener(this.v);
            }
        }
    }

    public void a(int i2, String str, boolean z2) {
        List<Integer> list;
        this.i = false;
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.i();
        }
        if (Util.J() != this.l) {
            this.l = Util.J();
            aq();
        }
        if (com.oppo.camera.f.a.c(i2)) {
            list = this.T.b();
        } else {
            list = this.T.c();
        }
        int a2 = com.oppo.camera.ui.menu.b.d.a(str);
        int i3 = -1;
        int i4 = 0;
        while (true) {
            if (i4 >= list.size()) {
                break;
            } else if (list.get(i4).intValue() == a2) {
                i3 = i4;
                break;
            } else {
                i4++;
            }
        }
        this.U = list;
        c cVar = this.S;
        if (cVar != null) {
            cVar.a(list, i3);
        }
        if (!z2 || this.k || !this.v.B()) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
        }
        d(this.v.ab());
        if (ai()) {
            this.L.a(Util.a((Context) this.s, (int) R.drawable.thumbnail_bg_normal), 0, false);
        }
        if (!com.oppo.camera.entry.b.a(this.n)) {
            AsyncTask<Void, Void, e> asyncTask = this.q;
            if (asyncTask != null) {
                asyncTask.cancel(true);
                this.q = null;
            }
            this.q = new a((e.c) null, false, !ai(), true, (C0100b) null).execute(new Void[0]);
        }
    }

    public void d(boolean z2) {
        if (this.G != null) {
            int i2 = this.ae ? R.drawable.btn_switch_camera_with_bg : R.drawable.btn_switch_camera_selector;
            if (z2) {
                i2 = R.drawable.btn_switch_camera_microscope_selector;
            }
            this.G.setImageDrawable(this.s.getDrawable(i2));
        }
    }

    public void e(boolean z2) {
        ShutterButton shutterButton = this.G;
        if (shutterButton != null) {
            shutterButton.setSelected(z2);
        }
    }

    public void e() {
        c(true, true);
        if (!this.v.aI()) {
            if (this.v.g("key_support_share_edit_thumb")) {
                ae();
            }
            ShutterButton shutterButton = this.J;
            if (shutterButton != null) {
                shutterButton.setVisibility(4);
            }
            ShutterButton shutterButton2 = this.K;
            if (shutterButton2 != null) {
                shutterButton2.setVisibility(4);
            }
        }
    }

    public void c(boolean z2, boolean z3) {
        if (!this.v.aI() || !z3 || !ay()) {
            if (z2) {
                Util.a((View) this.Y, 4, (Animation.AnimationListener) null, 300);
            } else {
                this.Y.setVisibility(4);
            }
        } else if (z2) {
            Util.a((View) this.Y, 0, (Animation.AnimationListener) null, 300);
        } else {
            this.Y.setVisibility(0);
        }
    }

    public void a(int i2) {
        this.V = i2;
    }

    public void f() {
        this.w = (RelativeLayout) this.s.findViewById(R.id.control_panel_layout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Util.w());
        layoutParams.addRule(12);
        this.w.setLayoutParams(layoutParams);
        this.y = (RelativeLayout) this.s.findViewById(R.id.control_panel_button_layout);
        this.m = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SHARE_EDIT_SUPPORT);
        if (this.m) {
            this.z = (RelativeLayout) View.inflate(this.s, R.layout.share_and_edit_layout, (ViewGroup) null);
            this.O = new com.oppo.camera.ui.menu.shareedit.a(this.z, this, this.s, this.t, new a.b() {
                public void a() {
                    b.this.v.av();
                }
            }, this.v);
            this.y.post(new Runnable() {
                public void run() {
                    if (b.this.O != null) {
                        b.this.O.b();
                    }
                }
            });
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, Util.x());
        layoutParams2.addRule(10);
        layoutParams2.topMargin = av();
        this.y.setLayoutParams(layoutParams2);
    }

    private void aq() {
        RelativeLayout relativeLayout = this.y;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.topMargin = av();
            this.y.setLayoutParams(layoutParams);
        }
        c cVar = this.S;
        if (cVar != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) cVar.getLayoutParams();
            layoutParams2.topMargin = this.s.getResources().getDimensionPixelSize(R.dimen.head_line_margin_top);
            this.S.setLayoutParams(layoutParams2);
        }
        RelativeLayout relativeLayout2 = this.A;
        if (relativeLayout2 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
            layoutParams3.topMargin = av();
            this.A.setLayoutParams(layoutParams3);
        }
    }

    public void g() {
        c cVar = this.S;
        if (cVar != null) {
            cVar.a(4, true, false);
        }
    }

    public void d(boolean z2, boolean z3) {
        c cVar = this.S;
        if (cVar != null && z2) {
            if (z3) {
                cVar.a(0, true, false);
            } else {
                b(true);
            }
        }
    }

    public void f(boolean z2) {
        ab();
        if (z2) {
            a(true);
            i(8);
            e(8);
            f(8);
            return;
        }
        a(false);
        ThumbImageView thumbImageView = this.L;
        if (thumbImageView != null) {
            thumbImageView.setVisibility(8);
        }
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.setVisibility(8);
        }
        ShutterButton shutterButton = this.G;
        if (shutterButton != null) {
            shutterButton.setVisibility(8);
        }
    }

    public void g(boolean z2) {
        ab();
        if (z2) {
            a(true);
            i(8);
            f(8);
            return;
        }
        a(false);
        ThumbImageView thumbImageView = this.L;
        if (thumbImageView != null) {
            thumbImageView.setVisibility(8);
        }
        ShutterButton shutterButton = this.G;
        if (shutterButton != null) {
            shutterButton.setVisibility(8);
        }
    }

    public void a(boolean z2, boolean z3, boolean z4) {
        ShutterButton shutterButton;
        ThumbImageView thumbImageView;
        if (z2) {
            if (!z4 && !z3) {
                i(0);
            }
            e(0);
            if (this.v.g("pref_support_switch_camera") && !z4 && !z3) {
                f(0);
                return;
            }
            return;
        }
        if (!z3 && (thumbImageView = this.L) != null) {
            thumbImageView.setVisibility(0);
        }
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.setVisibility(0);
        }
        if (this.v.g("pref_support_switch_camera") && !z3 && (shutterButton = this.G) != null) {
            shutterButton.setVisibility(0);
        }
    }

    public void e(boolean z2, boolean z3) {
        a(z2, z3, false);
    }

    public void h() {
        f(true, true);
        g(true, true);
        h(true, true);
    }

    public void i() {
        this.j = true;
        ShutterButton shutterButton = this.G;
        if (shutterButton != null) {
            shutterButton.setAlpha(1.0f);
        }
        c cVar = this.S;
        if (cVar != null) {
            cVar.onResume();
        }
    }

    public void a(c cVar, boolean z2) {
        com.oppo.camera.e.a("CameraControlUI", "onPause");
        this.j = false;
        this.i = true;
        this.f = false;
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.j();
        }
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.b();
        }
        ShutterButton shutterButton = this.E;
        if (shutterButton != null) {
            shutterButton.clearAnimation();
        }
        AsyncTask<Void, Void, e> asyncTask = this.q;
        if (asyncTask != null) {
            asyncTask.cancel(false);
            this.q = null;
        }
        i(true, false);
        RelativeLayout relativeLayout = this.w;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
            this.w.setAlpha(1.0f);
        }
        c cVar2 = this.S;
        if (cVar2 != null) {
            cVar2.onPause();
        }
        ab();
        b(cVar, z2);
        s();
        MainShutterButton mainShutterButton2 = this.F;
        if (mainShutterButton2 != null && mainShutterButton2.getShutterButtonInfo() == null) {
            com.oppo.camera.e.e("CameraControlUI", "onPause, null == currentButtonInfo");
        }
    }

    public void h(boolean z2) {
        com.oppo.camera.e.a("CameraControlUI", "setPhotoEncrypted, isPhotoEncrypted: " + z2);
        this.g = z2;
    }

    public void j() {
        if (this.L != null && this.g) {
            this.L.a(BitmapFactory.decodeResource(this.s.getResources(), R.drawable.thumbnail_bg_normal), 0, false);
        }
    }

    public void k() {
        com.oppo.camera.e.a("CameraControlUI", "onDestroy");
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.a();
        }
        Bitmap bitmap = this.r;
        if (bitmap != null) {
            bitmap.recycle();
            this.r = null;
        }
        ThumbImageView thumbImageView = this.L;
        if (thumbImageView != null) {
            thumbImageView.a((Bitmap) null, 0, false);
            this.L.a();
            this.L = null;
        }
        e eVar = this.M;
        if (eVar != null) {
            eVar.h();
            this.M = null;
        }
        c cVar = this.S;
        if (cVar != null) {
            cVar.h();
        }
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.a();
            this.O = null;
        }
        at();
        this.s = null;
        this.F = null;
        this.E = null;
        this.u = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.N = null;
        this.v = null;
        this.d = false;
        this.P = null;
        this.Q = null;
        this.ab = null;
        this.aa = null;
    }

    public void l() {
        c cVar = this.S;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void m() {
        c cVar = this.S;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void i(boolean z2) {
        c cVar = this.S;
        if (cVar != null) {
            cVar.a(z2);
        }
    }

    public boolean n() {
        c cVar = this.S;
        if (cVar != null) {
            return cVar.g();
        }
        return false;
    }

    private void ar() {
        com.oppo.camera.e.a("CameraControlUI", "initHeadline");
        if (this.S == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Util.B());
            layoutParams.addRule(14);
            layoutParams.addRule(10);
            layoutParams.topMargin = this.s.getResources().getDimensionPixelSize(R.dimen.head_line_margin_top);
            this.S = new c(this.s);
            this.S.setLayoutParams(layoutParams);
            this.S.a(Util.E(), Util.B(), (c.e) this);
            this.T.a(this.n, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PORTRAIT), CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT));
            this.T.a();
            this.w.addView(this.S.getHeadlineBackground(), layoutParams);
            this.w.addView(this.S);
            if (!this.j) {
                this.S.setVisibility(4);
            }
            com.oppo.camera.e.a("CameraControlUI", "initHeadline X");
        }
    }

    public MainShutterButton o() {
        return this.F;
    }

    public ThumbImageView p() {
        return this.L;
    }

    public void a(String str) {
        ShutterButton shutterButton = this.G;
        if (shutterButton != null) {
            shutterButton.setContentDescription(str);
        }
    }

    public void j(boolean z2) {
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.setLongClickable(z2);
        }
    }

    public e q() {
        return this.M;
    }

    public int r() {
        return this.o;
    }

    public void b(int i2) {
        this.n = i2;
        this.d = i2 == 3;
    }

    public void c(int i2) {
        int i3;
        com.oppo.camera.ui.f fVar;
        ShutterButton shutterButton = this.I;
        if (shutterButton != null) {
            shutterButton.a(i2, true);
        }
        ShutterButton shutterButton2 = this.G;
        if (shutterButton2 != null) {
            shutterButton2.a(i2, true);
        }
        if (!(this.L == null || (fVar = this.v) == null || fVar.ay())) {
            this.L.a(i2, true);
        }
        RotateImageView rotateImageView = this.B;
        if (rotateImageView != null) {
            rotateImageView.a(i2, true);
        }
        RotateImageView rotateImageView2 = this.C;
        if (rotateImageView2 != null) {
            rotateImageView2.a(i2, true);
        }
        RotateImageView rotateImageView3 = this.D;
        if (rotateImageView3 != null) {
            rotateImageView3.a(i2, true);
        }
        if (this.E != null && (3 == (i3 = this.n) || 2 == i3)) {
            this.E.a(i2, true);
        }
        ShutterButton shutterButton3 = this.H;
        if (shutterButton3 != null) {
            shutterButton3.a(i2, true);
        }
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.a(i2, true);
        }
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.a(i2, true);
        }
        ShutterButton shutterButton4 = this.J;
        if (shutterButton4 != null) {
            shutterButton4.a(i2, true);
        }
        ShutterButton shutterButton5 = this.K;
        if (shutterButton5 != null) {
            shutterButton5.a(i2, true);
        }
        RotateImageView rotateImageView4 = this.Y;
        if (rotateImageView4 != null) {
            rotateImageView4.a(i2, true);
        }
    }

    public void a(a aVar) {
        this.u = aVar;
    }

    public void b(String str) {
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.setContentDescription(str);
        }
    }

    public void b(c cVar) {
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.setButtonTypeAndInvalidate(cVar);
        }
    }

    public void b(c cVar, boolean z2) {
        com.oppo.camera.e.a("CameraControlUI", "resetShutterButton");
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            if (this.n == 3) {
                this.F.setButtonTypeAndInvalidate(new c(1, "button_color_inside_red"));
            } else {
                if (cVar != null) {
                    mainShutterButton.setButtonTypeAndInvalidate(cVar);
                }
                if (!this.i) {
                    this.F.setVisibility(0);
                } else if (this.n == 2) {
                    this.F.setEnabled(true);
                    this.F.setClickable(true);
                    this.F.setAlpha(1.0f);
                }
            }
            if (this.F.isPressed()) {
                this.F.setPressed(false);
            }
            this.F.setLongClickable(z2);
        }
    }

    public void s() {
        ShutterButton shutterButton = this.G;
        if (shutterButton != null) {
            shutterButton.setScaleX(1.0f);
            this.G.setScaleY(1.0f);
            this.G.setAlpha(1.0f);
        }
    }

    public void a(f fVar) {
        this.N = fVar;
    }

    public void f(boolean z2, boolean z3) {
        com.oppo.camera.e.a("CameraControlUI", "enableCameraShutterButton, enable: " + z2 + ", ashed: " + z3);
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            mainShutterButton.setEnabled(z2);
            this.F.setClickable(z2);
            this.F.setLongClickable(z2 && this.v.an());
            if (z2) {
                this.F.setAlpha(1.0f);
            } else if (z3) {
                this.F.setAlpha(0.5f);
            } else if (!z3) {
                this.F.setAlpha(1.0f);
            }
        }
    }

    public boolean t() {
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            return mainShutterButton.isEnabled();
        }
        return false;
    }

    public void g(boolean z2, boolean z3) {
        ShutterButton shutterButton;
        com.oppo.camera.e.a("CameraControlUI", "enableSwitchCameraButton, enable: " + z2);
        if ((!z2 || this.v.g("pref_support_switch_camera")) && (shutterButton = this.G) != null) {
            shutterButton.setEnabled(z2);
            this.G.setClickable(z2);
            if (z2) {
                this.G.setAlpha(1.0f);
            } else if (z3) {
                this.G.setAlpha(0.5f);
            } else if (!z3) {
                this.G.setAlpha(1.0f);
            }
        }
    }

    public void h(boolean z2, boolean z3) {
        com.oppo.camera.e.a("CameraControlUI", "enableThumbView(), enable: " + z2 + ", ashed: " + z3);
        ThumbImageView thumbImageView = this.L;
        if (thumbImageView != null) {
            thumbImageView.setEnabled(z2);
            this.L.setClickable(z2);
            if (z2) {
                this.L.setAlpha(1.0f);
            } else if (z3) {
                this.L.setAlpha(com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.s.hashCode()) ? 0.3f : 0.5f);
            } else if (!z3) {
                this.L.setAlpha(1.0f);
            }
        }
    }

    public void u() {
        if (this.ac) {
            b(1, true);
        }
    }

    public void v() {
        if (this.ad) {
            j(Color.argb(0, 0, 0, 0));
        }
    }

    public void w() {
        this.ac = false;
        this.ad = false;
    }

    public void x() {
        f(0);
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.f();
        }
        this.L.setVisibility(4);
        a(0, (Animation.AnimationListener) null);
        this.Y.setVisibility(4);
        j(Color.argb(0, 0, 0, 0));
        this.ac = true;
        this.ad = true;
        this.ae = true;
        d(false);
    }

    public void y() {
        a(4, (Animation.AnimationListener) null);
        this.ac = false;
        this.ad = false;
    }

    public void z() {
        a(0, (Animation.AnimationListener) null);
        g(0);
        ad();
        this.L.setVisibility(4);
        this.G.setVisibility(4);
        this.Y.setVisibility(4);
        j(Color.argb(0, 0, 0, 0));
    }

    public void A() {
        q(true);
        a(4, (Animation.AnimationListener) null);
        g(4);
        a(true, false, false);
        c(true, true);
        b(1, true);
        this.ac = false;
        this.ad = false;
        this.ae = false;
        d(false);
    }

    public void B() {
        this.J.setVisibility(4);
        this.K.setVisibility(4);
        c(false, false);
        this.ae = false;
        d(false);
    }

    public void C() {
        this.J.setVisibility(4);
        ae();
        a(true, false, false);
        c(true, true);
        this.K.setVisibility(4);
        b(1, true);
        this.ae = false;
        d(false);
    }

    public void D() {
        this.K.setVisibility(4);
        this.G.setVisibility(0);
        j(Color.argb(0, 0, 0, 0));
        this.ae = true;
        d(false);
    }

    public void k(boolean z2) {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.b(z2);
        }
    }

    public void i(boolean z2, boolean z3) {
        f(z2, z3);
        g(z2, z3);
        h(z2, z3);
    }

    public void d(int i2) {
        com.oppo.camera.e.a("CameraControlUI", "setCloseFromOtherAppButtonVisibility(), visibility: " + i2);
        if (i2 == 0) {
            Util.a((View) this.E);
        } else {
            Util.b((View) this.E);
        }
    }

    public void l(boolean z2) {
        ShutterButton shutterButton = this.E;
        if (shutterButton != null) {
            shutterButton.setEnabled(z2);
        }
    }

    public void e(int i2) {
        com.oppo.camera.e.a("CameraControlUI", "setCameraShutterButtonVisibilityWithAnimation, visibility: " + i2);
        Util.a((View) this.F, i2, (Animation.AnimationListener) null, 300);
    }

    public void f(int i2) {
        com.oppo.camera.e.a("CameraControlUI", "setSwitchCameraButtonVisibilityWithAnimation, visibility: " + i2);
        ShutterButton shutterButton = this.G;
        if (shutterButton != null) {
            Util.a((View) shutterButton, i2, (Animation.AnimationListener) null, 300);
        }
    }

    public void a(int i2, Animation.AnimationListener animationListener) {
        ShutterButton shutterButton = this.J;
        if (shutterButton != null) {
            Util.a((View) shutterButton, i2, animationListener, 300);
        }
    }

    public void g(int i2) {
        ShutterButton shutterButton = this.K;
        if (shutterButton != null) {
            Util.a((View) shutterButton, i2, (Animation.AnimationListener) null, 300);
        }
    }

    public void h(int i2) {
        com.oppo.camera.e.a("CameraControlUI", "setSwitchCameraButtonVisibility, visibility: " + i2);
        ShutterButton shutterButton = this.G;
        if (shutterButton != null) {
            shutterButton.setVisibility(i2);
        }
    }

    public void i(final int i2) {
        com.oppo.camera.e.a("CameraControlUI", "setThumbViewVisibilityWithAnimation, visibility: " + i2);
        if (this.L != null) {
            com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
            boolean z2 = false;
            if (!(aVar == null || i2 == 0)) {
                aVar.a(false, false);
            }
            boolean z3 = this.L.getVisibility() == 0;
            if (i2 == 0) {
                z2 = true;
            }
            if (z3 != z2) {
                this.L.setVisibility(i2);
            }
            Util.a((View) this.L, i2, (Animation.AnimationListener) new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (b.this.O != null && i2 != 0) {
                        b.this.O.d();
                    }
                }
            }, 300);
        }
    }

    public void a(int i2, boolean z2) {
        RelativeLayout relativeLayout = this.w;
        if (relativeLayout == null) {
            return;
        }
        if (i2 != 0) {
            Util.a(relativeLayout, com.oppo.camera.ui.d.a(this.s, 3), 400, AnimationUtils.loadInterpolator(this.s, R.anim.zoom_interpolator_out), (Animator.AnimatorListener) null);
        } else if (z2) {
            a((byte) 1, true);
        } else if (this.d) {
            a((byte) 2, true);
        }
    }

    private void as() {
        if (this.w != null && this.A == null) {
            this.s.getLayoutInflater().inflate(R.layout.review_control, this.w);
            this.A = (RelativeLayout) this.s.findViewById(R.id.review_control_layout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Util.x());
            layoutParams.topMargin = av();
            layoutParams.addRule(10);
            this.A.setLayoutParams(layoutParams);
            this.B = (RotateImageView) this.s.findViewById(R.id.done_button);
            this.B.setOnClickListener(this);
            this.C = (RotateImageView) this.s.findViewById(R.id.btn_retake);
            this.C.setOnClickListener(this);
            this.D = (RotateImageView) this.s.findViewById(R.id.btn_play);
            this.D.setOnClickListener(this);
        }
    }

    private void at() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2 = this.w;
        if (relativeLayout2 != null && (relativeLayout = this.A) != null) {
            relativeLayout2.removeView(relativeLayout);
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
        }
    }

    public void E() {
        as();
        Util.b((View) this.F);
        f(8);
        Util.a((View) this.C);
        Util.a((View) this.B);
        Util.b((View) this.E);
        f(false, true);
        TextView textView = this.Q;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void F() {
        Util.b((View) this.C);
        Util.b((View) this.B);
        Util.a((View) this.F);
        if (this.v.g("pref_support_switch_camera")) {
            f(0);
        }
        Util.a((View) this.E);
        f(true, true);
        g(true, true);
        TextView textView = this.Q;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void G() {
        as();
        Util.b((View) this.F);
        Util.a((View) this.C);
        Util.a((View) this.B);
        Util.a((View) this.D);
        Util.b((View) this.E);
        Util.b((View) this.G);
        f(false, true);
        g(false, true);
        TextView textView = this.P;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.k = true;
    }

    public void H() {
        Util.b((View) this.B);
        Util.b((View) this.C);
        Util.b((View) this.D);
        Util.a((View) this.F);
        Util.a((View) this.E);
        f(true, true);
        g(true, true);
        f(0);
        this.k = false;
    }

    public void a(ShutterButton shutterButton, boolean z2) {
        a aVar = this.u;
        if (aVar != null) {
            aVar.b(z2);
        }
    }

    public void a(ShutterButton shutterButton) {
        if (shutterButton == null) {
            com.oppo.camera.e.a("CameraControlUI", "onShutterButtonClick, ShutterButton is null.");
            return;
        }
        if (com.oppo.camera.ui.menu.f.a()) {
            com.oppo.camera.ui.menu.f.d();
            com.oppo.camera.e.a("CameraControlUI", "onShutterButtonClick, camera menu is popup....");
        }
        if (this.u != null) {
            int id = shutterButton.getId();
            if (id == R.id.camera_from_other_app_close_btn) {
                int i2 = this.n;
                if (i2 == 2 || i2 == 3) {
                    com.oppo.camera.e.a("CameraControlUI", "onShutterButtonClick, camera_from_other_app_close_btn");
                    this.s.finish();
                }
            } else if (id == R.id.shutter_button) {
                if (this.n == 3) {
                    this.u.k();
                } else {
                    this.u.h();
                }
            }
        }
    }

    public void b(ShutterButton shutterButton) {
        if (com.oppo.camera.ui.menu.f.a()) {
            com.oppo.camera.ui.menu.f.d();
        }
        if (this.u != null && shutterButton.getId() == R.id.shutter_button) {
            this.u.i();
        }
    }

    public void c(ShutterButton shutterButton) {
        if (this.u != null && shutterButton.getId() == R.id.shutter_button) {
            this.u.j();
        }
    }

    public void m(boolean z2) {
        com.oppo.camera.ui.f fVar;
        com.oppo.camera.e.e("CameraControlUI", "startVideoRecording()");
        if (this.H == null) {
            this.H = (ShutterButton) this.s.getLayoutInflater().inflate(R.layout.view_stub_recording_cap_button, this.y).findViewById(R.id.recording_cap_button);
            this.H.setOnClickListener(this);
            this.H.setVisibility(4);
            this.H.setCameraUIListener(this.v);
            com.oppo.camera.ui.inverse.c.INS.registerInverse(this.s, this.H);
        }
        if (this.I == null) {
            this.I = (ShutterButton) this.s.getLayoutInflater().inflate(R.layout.view_stub_video_pause_resume, this.y).findViewById(R.id.video_pause_resume);
            this.I.setOnClickListener(this);
            this.I.setVisibility(4);
            this.I.setCameraUIListener(this.v);
            com.oppo.camera.ui.inverse.c.INS.registerInverse(this.s, this.I);
        }
        if (1 == this.n) {
            h(false, true);
            com.oppo.camera.ui.f fVar2 = this.v;
            if (fVar2 != null && fVar2.g("pref_support_recording_capture")) {
                Util.a((View) this.H);
            }
            com.oppo.camera.ui.f fVar3 = this.v;
            if (fVar3 == null || !fVar3.ay()) {
                com.oppo.camera.ui.f fVar4 = this.v;
                if (fVar4 == null || !fVar4.aI()) {
                    Util.b((View) this.L);
                } else {
                    i(4);
                }
            } else {
                Util.b((View) this.L, 200);
            }
            com.oppo.camera.ui.f fVar5 = this.v;
            if (fVar5 != null && !fVar5.M() && !this.v.N()) {
                a(4, true);
            }
        }
        if (z2 && this.I != null && (fVar = this.v) != null && !fVar.ay()) {
            this.I.setImageResource(R.drawable.btn_tk_video_record_pause);
            this.e = false;
            Util.a((View) this.I);
        }
        f(8);
    }

    public void j(boolean z2, boolean z3) {
        com.oppo.camera.ui.f fVar;
        com.oppo.camera.ui.f fVar2 = this.v;
        if (fVar2 != null && !fVar2.ay()) {
            Util.b((View) this.I);
            Util.b((View) this.H);
        }
        if (this.n == 1) {
            if (!z2 && (fVar = this.v) != null) {
                if (fVar != null && !z3 && fVar.g("pref_support_switch_camera")) {
                    f(0);
                }
                com.oppo.camera.ui.f fVar3 = this.v;
                if (fVar3 != null && fVar3.ay()) {
                    Util.a((View) this.L, 200);
                } else if (!z3) {
                    Util.a((View) this.L);
                }
            }
            if (!z3) {
                a(0, true);
            }
        }
    }

    public void J() {
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null && mainShutterButton.isClickable()) {
            this.F.performClick();
        }
    }

    public void K() {
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null && mainShutterButton.isClickable()) {
            this.F.performLongClick();
        }
    }

    public void L() {
        ShutterButton shutterButton = this.G;
        if (shutterButton != null && shutterButton.isClickable() && this.G.isEnabled()) {
            this.G.performClick();
        }
    }

    public void onClick(View view) {
        if (this.i) {
            com.oppo.camera.e.a("CameraControlUI", "onClick, Activity is paused, so return!");
            return;
        }
        switch (view.getId()) {
            case R.id.btn_play:
                com.oppo.camera.e.a("CameraControlUI", "onClick, btn_play");
                a aVar = this.u;
                if (aVar != null) {
                    aVar.e();
                    return;
                }
                return;
            case R.id.btn_retake:
                com.oppo.camera.e.a("CameraControlUI", "onClick, btn_retake");
                if (this.n == 3) {
                    this.F.setButtonTypeAndInvalidate(new c(1, "button_color_inside_red"));
                    a aVar2 = this.u;
                    if (aVar2 != null) {
                        aVar2.d();
                        return;
                    }
                    return;
                }
                a aVar3 = this.u;
                if (aVar3 != null) {
                    aVar3.b();
                    return;
                }
                return;
            case R.id.cancel_button:
                this.u.g();
                return;
            case R.id.done_button:
                com.oppo.camera.e.a("CameraControlUI", "onClick, done_button");
                a aVar4 = this.u;
                if (aVar4 != null) {
                    int i2 = this.n;
                    if (i2 == 2) {
                        aVar4.a();
                        return;
                    } else if (i2 == 3) {
                        aVar4.c();
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case R.id.load_video_button:
                this.u.a(false);
                return;
            case R.id.recording_cap_button:
                this.u.l();
                return;
            case R.id.revert_button:
                a aVar5 = this.u;
                if (aVar5 != null) {
                    aVar5.f();
                    return;
                }
                return;
            case R.id.thumbnail:
                com.oppo.camera.e.a("CameraControlUI", "onClick, thumbnail");
                f fVar = this.N;
                if (fVar != null) {
                    fVar.a(this.M);
                    return;
                }
                return;
            case R.id.video_pause_resume:
                com.oppo.camera.e.a("CameraControlUI", "onClick, video_pause_resume");
                au();
                return;
            default:
                com.oppo.camera.e.a("CameraControlUI", "onClick, default");
                return;
        }
    }

    public void M() {
        this.F.e();
    }

    private void au() {
        com.oppo.camera.e.a("CameraControlUI", "onVideoPauseResumeClicked, mbVideoRecordingPaused: " + this.e);
        if (this.I == null) {
            return;
        }
        if (this.u == null) {
            com.oppo.camera.e.a("CameraControlUI", "onVideoPauseResumeClicked, mCameraControlButtonListener is null.");
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.p < 1000) {
            com.oppo.camera.e.a("CameraControlUI", "onVideoPauseResumeClicked, onVideoPauseResumeClicked time less than 1000ms");
            return;
        }
        this.p = uptimeMillis;
        if (this.e) {
            if (this.u.q()) {
                if (2 != this.F.getButtonType() || !"button_shape_dial_rotate".equals(this.F.getRingShape())) {
                    com.oppo.camera.ui.f fVar = this.v;
                    if (fVar != null && fVar.aI()) {
                        this.F.f();
                    }
                } else {
                    this.F.h();
                }
                this.I.setImageResource(R.drawable.btn_tk_video_record_pause);
                this.e = false;
            }
        } else if (this.u.p()) {
            if (2 != this.F.getButtonType() || !"button_shape_dial_rotate".equals(this.F.getRingShape())) {
                com.oppo.camera.ui.f fVar2 = this.v;
                if (fVar2 != null && fVar2.aI()) {
                    this.F.g();
                }
            } else {
                this.F.e();
            }
            this.I.setImageResource(R.drawable.btn_tk_video_record_resume);
            this.e = true;
        }
    }

    public void a(e eVar, int i2) {
        AsyncTask<Void, Void, e> asyncTask = this.q;
        if (asyncTask != null && (asyncTask instanceof a) && ((a) asyncTask).a()) {
            this.q.cancel(true);
            this.q = null;
        }
        this.X = eVar;
        this.L.a(eVar.g(), i2, false);
    }

    public void a(e eVar, boolean z2) {
        ThumbImageView thumbImageView;
        com.oppo.camera.ui.menu.shareedit.a aVar;
        com.oppo.camera.e.a("CameraControlUI", "updateThumbnailView, isAnimate: " + z2 + ", thumbnail: " + eVar);
        AsyncTask<Void, Void, e> asyncTask = this.q;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.q = null;
        }
        if (!this.i) {
            com.oppo.camera.e.a("CameraCapturePerformance.updateThumbnailView,isAnimate:" + z2);
            this.M = eVar;
            com.oppo.camera.ui.menu.shareedit.a aVar2 = this.O;
            if (aVar2 != null) {
                aVar2.a(this.M);
            }
            com.oppo.camera.ui.f fVar = this.v;
            if (fVar != null) {
                fVar.i(true);
            }
            e eVar2 = this.X;
            if (eVar2 == null || this.M == null || ((eVar2.a() != this.M.a() && this.X.f() < this.M.f()) || this.M.a() == 0)) {
                v(z2);
            } else if (z2 && (aVar = this.O) != null) {
                aVar.b(eVar);
            }
            com.oppo.camera.ui.f fVar2 = this.v;
            if (!(fVar2 == null || !fVar2.b() || (thumbImageView = this.L) == null)) {
                thumbImageView.setVisibility(4);
            }
            if (this.f) {
                com.oppo.camera.e.e("CameraControlUI", "CameraTest Thumbnail Updated");
            } else {
                com.oppo.camera.e.a("CameraControlUI", "updateThumbnailView, mbFirstCallHasExcuted: " + this.f + ", mCurThumbnail: " + this.M);
            }
            if (!(this.f || this.M == null || this.N == null)) {
                this.f = true;
                z.a aVar3 = new z.a();
                aVar3.c = this.M.d();
                aVar3.i = this.M.e();
                aVar3.n = this.M.f();
                aVar3.C = false;
                aVar3.D = true;
                this.N.a(aVar3);
            }
            b(this.M);
            com.oppo.camera.e.b("CameraCapturePerformance.updateThumbnailView,isAnimate:" + z2);
        }
    }

    public void a(e eVar) {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.b(eVar);
        }
    }

    public void b(e eVar) {
        this.M = eVar;
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.a(this.M);
        }
        com.oppo.camera.ui.f fVar = this.v;
        if (fVar != null) {
            fVar.i(true);
        }
        if (!this.f && this.M != null && this.N != null) {
            this.f = true;
            z.a aVar2 = new z.a();
            aVar2.c = this.M.d();
            aVar2.i = this.M.e();
            aVar2.n = this.M.f();
            aVar2.C = false;
            aVar2.D = true;
            this.N.a(aVar2);
        }
    }

    private void v(boolean z2) {
        com.oppo.camera.ui.menu.shareedit.a aVar;
        com.oppo.camera.e.a("CameraControlUI", "updateThumbnailView, isAnimate: " + z2);
        com.oppo.camera.e.a("CameraCapturePerformance.updateThumbnailView,isAnimate:" + z2);
        if (this.L != null && !this.i) {
            e eVar = this.M;
            boolean z3 = false;
            if (eVar != null) {
                Bitmap g2 = eVar.g();
                Uri d2 = this.M.d();
                this.L.setContentDescription(this.s.getResources().getString(R.string.camera_description_review_thumbnail));
                if (!(g2 == null || d2 == null || !d2.toString().startsWith("content://media/external/video"))) {
                    this.L.setContentDescription(this.s.getResources().getString(R.string.camera_description_current_video_thumbnail));
                }
                if (g2 == null || (this.g && !this.h)) {
                    com.oppo.camera.e.a("CameraControlUI", "updateThumbnailView, use normal bitmap: " + g2);
                    Bitmap decodeResource = BitmapFactory.decodeResource(this.s.getResources(), R.drawable.thumbnail_bg_normal);
                    this.M.f3918a = true;
                    this.L.a(decodeResource, 0, false);
                } else {
                    this.M.f3918a = false;
                    ThumbImageView thumbImageView = this.L;
                    if (g2 == null) {
                        z3 = true;
                    }
                    thumbImageView.a(g2, z2 ? 1 : 0, z3);
                }
            } else {
                com.oppo.camera.e.a("CameraControlUI", "updateThumbnailView, mCurThumbnail is null");
                this.L.a(BitmapFactory.decodeResource(this.s.getResources(), R.drawable.thumbnail_bg_normal), 0, false);
            }
            if (z2 && (aVar = this.O) != null) {
                aVar.b(this.M);
            }
        }
        com.oppo.camera.e.b("CameraCapturePerformance.updateThumbnailView,isAnimate:" + z2);
    }

    public void n(boolean z2) {
        this.h = z2;
    }

    public void N() {
        com.oppo.camera.e.a("CameraControlUI", "initThumbnail()");
        if (this.n != 1) {
            return;
        }
        if (this.N.a()) {
            a((e.c) null, false);
        } else {
            a((e) null, false);
        }
    }

    public boolean O() {
        e eVar = this.M;
        return eVar != null && Util.a(eVar.d(), this.s.getContentResolver());
    }

    public void a(e.c cVar, boolean z2) {
        this.M = g.a(this.s.getContentResolver());
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.a(this.M);
        }
        com.oppo.camera.ui.f fVar = this.v;
        if (fVar != null) {
            fVar.i(true);
        }
        com.oppo.camera.e.a("CameraControlUI", "updateThumbnail, mCurThumbnail: " + this.M);
        e eVar = this.M;
        if (eVar == null || !Util.a(eVar.d(), this.s.getContentResolver())) {
            a(cVar, z2, (C0100b) null);
        } else {
            v(z2);
        }
        com.oppo.camera.perf.a.b("video_save");
    }

    public void a(e.c cVar, boolean z2, C0100b bVar) {
        com.oppo.camera.e.a("CameraControlUI", "updateThumbnailFromContentResolver");
        AsyncTask<Void, Void, e> asyncTask = this.q;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.q = null;
        }
        this.q = new a(cVar, z2, true, false, bVar).execute(new Void[0]);
    }

    public void b(int i2, boolean z2) {
        com.oppo.camera.e.a("CameraControlUI", "updateControlPanelBgColor, previewType: " + i2 + ", needAnimation: " + z2);
        if (3 == i2 || 4 == i2) {
            a((byte) 2, z2);
        } else if (i2 == 0 || 2 == i2) {
            a((byte) 3, z2);
        } else if (-1 != i2) {
            a((byte) 1, z2);
        }
    }

    public void o(boolean z2) {
        if (this.w != null) {
            int color2 = this.s.getColor(R.color.beauty3d_guide_background);
            if (z2) {
                Util.a(this.w, color2, 200, (Interpolator) null, (Animator.AnimatorListener) null);
            } else {
                this.w.setBackgroundColor(color2);
            }
        }
    }

    public void j(int i2) {
        RelativeLayout relativeLayout = this.w;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(i2);
        }
    }

    public void a(byte b2, boolean z2) {
        com.oppo.camera.e.a("CameraControlUI", "updateControlPanelBgColor, bgType: " + b2 + ", needAnimation: " + z2);
        if (this.w != null) {
            com.oppo.camera.ui.f fVar = this.v;
            if (fVar != null && fVar.ay()) {
                b2 = 2;
            }
            int a2 = com.oppo.camera.ui.d.a(this.s, 3);
            if (b2 == 1) {
                a2 = com.oppo.camera.ui.d.a(this.s, 1);
            } else if (b2 == 2) {
                a2 = com.oppo.camera.ui.d.a(this.s, 3);
            } else if (b2 == 3) {
                a2 = this.s.getColor(R.color.background_color);
            }
            if (z2) {
                Util.a(this.w, a2, 200, (Interpolator) null, (Animator.AnimatorListener) null);
            } else {
                this.w.setBackgroundColor(a2);
            }
        }
    }

    public int P() {
        RelativeLayout relativeLayout = this.w;
        if (relativeLayout != null) {
            return relativeLayout.getTop();
        }
        return Util.D();
    }

    public void a(d dVar) {
        this.R = dVar;
    }

    public int Q() {
        return Util.w();
    }

    public RelativeLayout R() {
        return this.w;
    }

    public int S() {
        MainShutterButton mainShutterButton = this.F;
        if (mainShutterButton != null) {
            return mainShutterButton.getButtonType();
        }
        return 1;
    }

    public void a(int i2, String str) {
        List<Integer> list;
        if (com.oppo.camera.f.a.c(i2)) {
            list = this.T.b();
        } else {
            list = this.T.c();
        }
        int a2 = com.oppo.camera.ui.menu.b.d.a(str);
        boolean contains = list.contains(Integer.valueOf(a2));
        int indexOf = list.indexOf(Integer.valueOf(a2));
        this.U = list;
        c cVar = this.S;
        if (cVar == null) {
            return;
        }
        if (contains) {
            cVar.a(list, indexOf);
        } else {
            cVar.a(list);
        }
    }

    public boolean T() {
        c cVar = this.S;
        return cVar != null && cVar.d();
    }

    public void p(boolean z2) {
        c cVar = this.S;
        if (cVar != null) {
            cVar.setMultiFinger(z2);
        }
    }

    public void k(int i2) {
        this.F.setShutterButtonTime(i2);
    }

    private int av() {
        return this.s.getResources().getDimensionPixelSize(R.dimen.control_panel_margin_top);
    }

    public void l(int i2) {
        String a2 = com.oppo.camera.ui.menu.b.d.a(this.U.get(i2).intValue());
        d dVar = this.R;
        if (dVar != null) {
            dVar.a(a2);
        }
    }

    public boolean m(int i2) {
        String a2 = com.oppo.camera.ui.menu.b.d.a(this.U.get(i2).intValue());
        com.oppo.camera.ui.f fVar = this.v;
        if (fVar != null) {
            return fVar.h(a2);
        }
        return false;
    }

    public boolean U() {
        com.oppo.camera.ui.f fVar = this.v;
        if (fVar != null) {
            return fVar.y();
        }
        return false;
    }

    public boolean V() {
        com.oppo.camera.ui.f fVar = this.v;
        if (fVar != null) {
            return fVar.z();
        }
        return false;
    }

    public boolean W() {
        com.oppo.camera.ui.f fVar = this.v;
        if (fVar != null) {
            return fVar.A();
        }
        return false;
    }

    public boolean X() {
        com.oppo.camera.ui.f fVar = this.v;
        if (fVar != null) {
            return fVar.C();
        }
        return false;
    }

    public void Y() {
        if (this.aa == null) {
            aw();
        }
        this.aa.a((h) new com.a.a.e() {
            public void a(f fVar) {
                double c = fVar.c();
                float a2 = (float) l.a(c, 0.0d, 1.0d, 1.0d, 0.8999999761581421d);
                float a3 = (float) l.a(c, 0.0d, 1.0d, 1.0d, 0.6000000238418579d);
                if (b.this.G != null) {
                    b.this.G.setScaleX(a2);
                    b.this.G.setScaleY(a2);
                    b.this.G.setAlpha(a3);
                }
            }
        }).a(0.0d).b(1.0d);
    }

    public void Z() {
        if (this.ab == null) {
            ax();
        }
        this.ab.a((h) new com.a.a.e() {
            public void a(f fVar) {
                double c = fVar.c();
                float a2 = (float) l.a(c, 0.0d, 1.0d, 0.8999999761581421d, 1.0d);
                float a3 = (float) l.a(c, 0.0d, 1.0d, 0.6000000238418579d, 1.0d);
                if (b.this.G != null) {
                    b.this.G.setScaleX(a2);
                    b.this.G.setScaleY(a2);
                    b.this.G.setAlpha(a3);
                }
            }
        }).a(0.0d).b(1.0d);
    }

    private void aw() {
        this.aa = j.c().b().a(g.b(5.0d, 10.0d));
    }

    private void ax() {
        this.ab = j.c().b().a(g.b(5.0d, 10.0d));
    }

    public void a(int... iArr) {
        c cVar = this.S;
        if (cVar != null) {
            cVar.a(iArr);
        }
    }

    public void b(int... iArr) {
        c cVar = this.S;
        if (cVar != null) {
            cVar.b(iArr);
        }
    }

    public boolean aa() {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        return aVar != null && aVar.h();
    }

    public void ab() {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.a(true, true);
        }
    }

    public void ac() {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void ad() {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null && 1 == this.n) {
            aVar.f();
        }
    }

    public void ae() {
        if (this.O != null && 1 == this.n) {
            com.oppo.camera.ui.widget.e eVar = this.Z;
            if (eVar == null || !eVar.d()) {
                this.O.g();
            }
        }
    }

    public void q(boolean z2) {
        if (this.O != null && 1 == this.n) {
            com.oppo.camera.ui.widget.e eVar = this.Z;
            if (eVar == null || !eVar.d()) {
                this.O.a(z2);
            }
        }
    }

    public void af() {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null && 1 == this.n) {
            aVar.c();
        }
    }

    public void n(int i2) {
        this.v.g(i2);
    }

    public void ag() {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.b(this.M);
        }
    }

    public boolean ah() {
        return this.v.E();
    }

    public boolean ai() {
        return this.v.aw().m();
    }

    public void aj() {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void r(boolean z2) {
        com.oppo.camera.ui.menu.shareedit.a aVar = this.O;
        if (aVar != null) {
            aVar.c(z2);
        }
    }

    public void s(boolean z2) {
        if (this.x == null && z2) {
            this.x = this.s.getLayoutInflater().inflate(R.layout.view_stub_more_mode_mask, this.w).findViewById(R.id.more_mode_mask);
        }
        View view = this.x;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    /* compiled from: CameraControlUI */
    private class a extends AsyncTask<Void, Void, e> {

        /* renamed from: b  reason: collision with root package name */
        private e f3914b = null;
        private e.c c = null;
        private boolean d = false;
        private boolean e;
        private boolean f = false;
        private C0100b g;

        public a(e.c cVar, boolean z, boolean z2, boolean z3, C0100b bVar) {
            this.c = cVar;
            this.d = z;
            this.e = z2;
            this.f = z3;
            this.g = bVar;
        }

        public boolean a() {
            return this.f;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public e doInBackground(Void... voidArr) {
            com.oppo.camera.e.a("CameraControlUI", "doInBackground");
            if (isCancelled() || b.this.i || b.this.W == null) {
                com.oppo.camera.e.e("CameraControlUI", "doInBackground, isCancelled: " + isCancelled() + ", mbPaused: " + b.this.i + ", mContentResolver: " + b.this.W);
                return null;
            }
            if (this.f3914b == null && this.e) {
                e eVar = new e();
                eVar.a(this.c);
                boolean z = "on".equals(z.r) && z.d();
                int a2 = e.a(b.this.W, eVar, z);
                if (z.d() && Util.K() && a2 == 0) {
                    a2 = e.a(b.this.W, eVar, !z);
                }
                com.oppo.camera.e.a("CameraControlUI", "doInBackground, code: " + a2);
                if (a2 != 0) {
                    if (a2 == 1) {
                        this.f3914b = eVar;
                    } else if (a2 == 2) {
                        cancel(true);
                    }
                }
            }
            if (b.this.N != null) {
                b.this.N.a(this.e);
            }
            return this.f3914b;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(e eVar) {
            C0100b bVar;
            com.oppo.camera.e.a("CameraControlUI", "LoadThumbnailTask, onPostExecute, thumbnail: " + eVar + ", cancel: " + isCancelled());
            if (!isCancelled() && !b.this.i) {
                if (this.e) {
                    if (b.this.N.a()) {
                        b.this.a(eVar, this.d);
                    } else {
                        b.this.a((e) null, false);
                    }
                    e eVar2 = this.f3914b;
                    if (eVar2 != null && (bVar = this.g) != null) {
                        bVar.a(eVar2);
                        return;
                    }
                    return;
                }
                b.this.N();
            }
        }
    }

    public boolean ak() {
        return this.S.a();
    }

    public RelativeLayout al() {
        return this.y;
    }

    public RelativeLayout am() {
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        return this.y;
    }

    public ShutterButton an() {
        return this.G;
    }

    public boolean ao() {
        com.oppo.camera.ui.f fVar = this.v;
        return fVar != null && fVar.au();
    }

    public boolean ap() {
        return this.e;
    }

    public void t(boolean z2) {
        a aVar = this.u;
        if (aVar != null) {
            aVar.a(z2);
        }
    }

    public void a(com.oppo.camera.ui.widget.e eVar) {
        this.Z = eVar;
    }

    private boolean ay() {
        return Util.z(this.s);
    }
}
