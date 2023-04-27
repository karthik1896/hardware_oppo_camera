package com.oppo.camera.ui.menu.levelcontrol;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.OppoNumSeekBar;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.setting.t;
import com.oppo.camera.util.Util;

/* compiled from: BlurMenu */
public class a extends t {
    private Activity e = null;
    private boolean f = false;
    private boolean g = false;
    private int h = 0;
    private int i = 0;
    private PathInterpolator j = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private RelativeLayout k = null;
    private View l = null;
    private LinearLayout m = null;
    private OppoNumSeekBar n = null;
    /* access modifiers changed from: private */
    public C0103a o = null;
    private AnimatorSet p = null;
    private int q = 0;
    private OppoNumSeekBar.a r = new OppoNumSeekBar.a() {
        public void a(OppoNumSeekBar oppoNumSeekBar, int i) {
        }

        public void a(OppoNumSeekBar oppoNumSeekBar, int i, boolean z) {
            a.this.o.a(i, false);
        }

        public void b(OppoNumSeekBar oppoNumSeekBar, int i) {
            a.this.o.a(i, true);
        }

        public boolean a() {
            return a.this.o.c();
        }
    };

    /* renamed from: com.oppo.camera.ui.menu.levelcontrol.a$a  reason: collision with other inner class name */
    /* compiled from: BlurMenu */
    public interface C0103a {
        void a(int i, boolean z);

        void a(boolean z, boolean z2);

        boolean a();

        void b(boolean z, boolean z2);

        boolean b();

        boolean c();

        void d();

        int e();

        boolean f();

        boolean g();

        boolean h();

        boolean i();
    }

    public boolean d() {
        return true;
    }

    public a(Activity activity, C0103a aVar) {
        super(activity);
        this.e = activity;
        this.o = aVar;
    }

    public void setBlurType(int i2) {
        this.i = i2;
    }

    public int getBlurType() {
        return this.i;
    }

    public boolean a() {
        return this.i == 1;
    }

    public void a(String str, boolean z) {
        if (!this.o.a()) {
            e.a("BlurMenu", "showMenuPanel, return cannotExpandMenu");
            return;
        }
        a(true);
        super.a(str, z);
    }

    public void a(boolean z, boolean z2) {
        if (!g()) {
            a(z, true, z2, true);
        }
    }

    public void a(boolean z) {
        this.f = true;
        if (this.m == null) {
            i();
        }
        if (this.m.getParent() == null) {
            if (z) {
                l();
            } else {
                RelativeLayout relativeLayout = this.k;
                relativeLayout.addView(this.l, relativeLayout.indexOfChild(relativeLayout.findViewById(R.id.control_panel_layout)));
                this.k.addView(this.m);
            }
            this.o.d();
        }
        if (!this.o.b() && !this.g && !a()) {
            this.o.b(true, false);
        }
        int e2 = this.o.e();
        if (this.o.f()) {
            if (e2 == 0 && !this.g) {
                this.o.a(60, false);
                e2 = 60;
            }
            this.h = 0;
        } else if (this.o.g()) {
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.n.b(this.h).a(100).d(60).c(e2).postInvalidate();
        e.a("BlurMenu", "show, index: " + e2);
    }

    public boolean b() {
        return this.f;
    }

    public boolean c() {
        return this.o.b() && this.o.e() > 0;
    }

    private void i() {
        Resources resources = this.e.getApplicationContext().getResources();
        this.q = Util.w();
        this.l = new LinearLayout(this.e);
        this.l.setId(R.id.blur_bg);
        this.k = (RelativeLayout) this.e.findViewById(R.id.camera);
        this.m = (LinearLayout) this.e.getLayoutInflater().inflate(R.layout.blur_menu, (ViewGroup) null);
        this.n = (OppoNumSeekBar) this.m.findViewById(R.id.video_blur_seek_bar);
        c.INS.registerInverse(this.e, this.n);
        this.n.setOnProgressChangedListener(this.r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.q);
        layoutParams.addRule(12);
        this.l.setBackgroundColor(this.e.getResources().getColor(R.color.blur_bg_color));
        this.l.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.blur_menu_height));
        layoutParams2.addRule(6, R.id.blur_bg);
        this.m.setLayoutParams(layoutParams2);
        this.m.setAlpha(0.0f);
    }

    private void l() {
        RelativeLayout relativeLayout = this.k;
        relativeLayout.addView(this.l, relativeLayout.indexOfChild(relativeLayout.findViewById(R.id.control_panel_layout)));
        this.k.addView(this.m);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.l, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(this.j);
        ofFloat.setDuration(300);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.m, "alpha", new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(this.j);
        ofFloat2.setDuration(300);
        this.p = new AnimatorSet();
        this.p.play(ofFloat).with(ofFloat2);
        this.p.start();
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f = false;
        if (this.o.e() == 0) {
            if (!this.o.h() || !this.o.i()) {
                this.o.b(false, false);
            } else {
                this.g = true;
            }
        }
        if (!z2) {
            m();
            this.o.a(z3, z4);
            super.a(z, z3);
            return;
        }
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout == null) {
            return;
        }
        if (relativeLayout.getParent() != null || this.m.getParent() != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.l, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.setInterpolator(this.j);
            ofFloat.setDuration(190);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.m, "alpha", new float[]{1.0f, 0.0f});
            ofFloat2.setInterpolator(this.j);
            ofFloat2.setDuration(190);
            this.p = new AnimatorSet();
            this.p.play(ofFloat).with(ofFloat2);
            this.p.start();
            this.p.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    a.this.m();
                }
            });
            this.o.a(z3, z4);
            super.a(z, z3);
        }
    }

    public void e() {
        if (this.g) {
            if (this.o.f()) {
                a("pref_video_blur_menu", false);
            } else if (this.o.g()) {
                a("pref_tilt_shift_blur_menu", false);
            }
            this.g = false;
        }
    }

    public void setVideoRecordingHideMenu(boolean z) {
        this.g = z;
    }

    public boolean f() {
        return this.g;
    }

    public void a(int i2) {
        this.o.a(i2, false);
        OppoNumSeekBar oppoNumSeekBar = this.n;
        if (oppoNumSeekBar != null) {
            oppoNumSeekBar.b(this.h).a(100).d(60).c(i2).postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        LinearLayout linearLayout;
        View view;
        RelativeLayout relativeLayout = this.k;
        if (!(relativeLayout == null || (view = this.l) == null)) {
            relativeLayout.removeView(view);
            this.l = null;
        }
        RelativeLayout relativeLayout2 = this.k;
        if (relativeLayout2 != null && (linearLayout = this.m) != null) {
            relativeLayout2.removeView(linearLayout);
            this.m = null;
        }
    }

    public boolean g() {
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            return animatorSet.isRunning();
        }
        return false;
    }

    public boolean h() {
        return this.f;
    }
}
