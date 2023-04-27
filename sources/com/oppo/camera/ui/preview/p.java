package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.color.support.widget.j;
import com.oppo.camera.R;
import com.oppo.camera.aps.ApsAdapterConstant;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.ui.preview.AISceneView;
import com.oppo.camera.ui.preview.a;
import com.oppo.camera.util.Util;

/* compiled from: PIAISceneUI */
public class p extends a {
    /* access modifiers changed from: private */
    public RelativeLayout d = null;
    private AISceneView e = null;
    /* access modifiers changed from: private */
    public j f = null;
    private a g = null;
    /* access modifiers changed from: private */
    public a.C0106a h = null;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    /* access modifiers changed from: private */
    public int m = 0;
    /* access modifiers changed from: private */
    public int n = 0;
    private int o = 67108863;
    private boolean p = false;
    private int q = 0;
    /* access modifiers changed from: private */
    public Handler r = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                e.c("PIAISceneUI", "mHandler, handleMessage: 1");
                if (p.this.n == 0) {
                    p.this.r.removeMessages(ApsAdapterConstant.LOG_INTERVAL);
                    p.this.h();
                }
            }
        }
    };

    private int a(int i2, int i3, boolean z) {
        return z ? (1 << (i2 - 1)) | i3 : (~(1 << (i2 - 1))) & i3;
    }

    public p(Activity activity, ViewGroup viewGroup, k kVar) {
        this.f4352a = activity;
        this.f4353b = viewGroup;
        this.c = kVar;
        this.i = this.f4352a.getResources().getDimensionPixelSize(R.dimen.pi_ai_scene_margin);
        this.j = this.f4352a.getResources().getDimensionPixelSize(R.dimen.pi_ai_scene_hint_bg_shadow_width);
        this.k = (int) (((double) Util.E()) * 1.3333333333333333d);
        this.l = Util.E();
        this.q = this.f4352a.getResources().getDimensionPixelSize(R.dimen.toast_margin_top);
    }

    private void k() {
        if (this.d == null && this.f4353b != null) {
            this.f4352a.getLayoutInflater().inflate(R.layout.pi_ai_scene_layout, this.f4353b);
            this.d = (RelativeLayout) this.f4352a.findViewById(R.id.ai_scene_layout);
            this.e = (AISceneView) this.d.findViewById(R.id.ai_scene_text);
            this.e.setAISceneViewListener(new AISceneView.a() {
                public void a() {
                    e.b("PIAISceneUI", "mAISceneTextView, aiSceneViewActionUp");
                    p.this.m();
                }

                public boolean b() {
                    if (p.this.h != null) {
                        return p.this.h.a();
                    }
                    return false;
                }
            });
        }
    }

    public void g() {
        l();
        if (!(this.d == null || this.f4353b == null)) {
            this.f4353b.removeView(this.d);
            this.d = null;
            this.e = null;
        }
        j jVar = this.f;
        if (jVar != null && jVar.isShowing()) {
            this.f.dismiss();
            this.f = null;
            b(true, false);
        }
        this.n = 0;
    }

    public void a(int i2, int i3, int i4) {
        this.n = i2;
        f(i3);
        if (!e(i2)) {
            if (this.n != 0) {
                k();
            }
            if (this.d != null) {
                a a2 = a(i2, i4);
                if (-1 == a2.a()) {
                    h();
                    return;
                }
                this.e.setText(a2.a());
                d(i3);
                l();
                n();
            }
        } else if (i()) {
            h();
        }
    }

    private Size a(View view) {
        if (view == null) {
            return new Size(0, 0);
        }
        view.measure(Util.E(), Util.E());
        return new Size(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void a(a.C0106a aVar) {
        this.h = aVar;
    }

    public void a(boolean z) {
        this.p = z;
        boolean c = !z ? c(this.n) : false;
        AISceneView aISceneView = this.e;
        if (aISceneView != null) {
            aISceneView.setAISceneFunctionEnabled(c);
            this.e.invalidate();
        }
        a.C0106a aVar = this.h;
        if (aVar != null) {
            aVar.a(this.n, c, false);
        }
    }

    private void l() {
        AISceneView aISceneView = this.e;
        if (aISceneView != null) {
            aISceneView.a();
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        e.c("PIAISceneUI", "dealClickAIScene");
        boolean c = c(this.n);
        b(this.n, !c);
        this.e.setAISceneFunctionEnabled(!c);
        this.h.a(this.n, !c, true);
    }

    public void a(int i2, boolean z) {
        this.o = a(i2, this.o, z);
    }

    private boolean e(int i2) {
        return ((this.o >> (i2 - 1)) & 1) == 0;
    }

    private void b(int i2, boolean z) {
        int a2 = a(i2, e(), z);
        e.a("PIAISceneUI", "setAISceneEnableStatus, scene: " + i2 + ", enabled: " + z + ", status: " + Integer.toBinaryString(a2));
        this.c.edit().putInt("oppo.camera.ai_scene_enable_list", a2).apply();
    }

    public void d() {
        this.c.edit().remove("oppo.camera.ai_scene_enable_list").apply();
    }

    public boolean c(int i2) {
        if (i2 == 0) {
            return (this.c == null || this.f4352a == null || !"on".equals(this.c.getString("pref_camera_pi_ai_mode_key", this.f4352a.getString(R.string.camera_pi_ai_default_value)))) ? false : true;
        }
        if (((e() >> (i2 - 1)) & 1) > 0) {
            return true;
        }
        return false;
    }

    public int e() {
        if (this.p) {
            return 0;
        }
        return this.c.getInt("oppo.camera.ai_scene_enable_list", 67108863) & this.o;
    }

    public void h() {
        Handler handler = this.r;
        if (handler == null || !handler.hasMessages(1)) {
            l();
            o();
        }
    }

    public void d(int i2) {
        if (this.d != null && this.e != null) {
            f(i2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            Size a2 = a((View) this.e);
            Size size = new Size(0, 0);
            if (!b(4 == this.n)) {
                p();
                b(4 == this.n, true);
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
            this.d.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredWidth = this.d.getMeasuredWidth();
            int measuredHeight = this.d.getMeasuredHeight();
            this.d.layout(0, 0, measuredWidth, measuredHeight);
            if (i2 == 90) {
                layoutParams.addRule(11);
                layoutParams.rightMargin = (((this.l - measuredHeight) - measuredWidth) + a2.getHeight()) / 2;
                layoutParams.topMargin = ((((measuredWidth - measuredHeight) / 2) + this.i) - this.j) + Util.v() + this.q;
            } else if (i2 == 180) {
                layoutParams.addRule(9);
                layoutParams.leftMargin = this.i - this.j;
                layoutParams.topMargin = (((this.k - a2.getHeight()) / 2) - size.getHeight()) + Util.v() + this.q;
            } else if (i2 != 270) {
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.i - this.j;
                layoutParams.topMargin = ((this.k - a2.getHeight()) / 2) + Util.v() + this.q;
            } else {
                layoutParams.addRule(9);
                layoutParams.leftMargin = (((this.l - measuredHeight) - measuredWidth) + a2.getHeight()) / 2;
                layoutParams.topMargin = ((((measuredWidth - measuredHeight) / 2) + this.i) - this.j) + Util.v() + this.q;
            }
            this.e.setZ(999.0f);
            this.d.setLayoutParams(layoutParams);
            this.d.setRotation((float) (-this.m));
        }
    }

    private a a(int i2, int i3) {
        if (this.g == null) {
            this.g = new a();
        }
        switch (i2) {
            case 1:
                this.g.a(R.string.camera_ai_scn_beach);
                break;
            case 2:
                this.g.a(R.string.camera_ai_scn_bluesky);
                break;
            case 3:
                this.g.a(R.string.camera_ai_scn_cat);
                break;
            case 4:
                this.g.a(R.string.camera_ai_scn_text);
                break;
            case 5:
                this.g.a(R.string.camera_ai_scn_dog);
                break;
            case 6:
                this.g.a(R.string.camera_ai_scn_firework);
                break;
            case 7:
                this.g.a(R.string.camera_ai_scn_gourmet);
                break;
            case 8:
                this.g.a(R.string.camera_ai_scn_grass);
                break;
            case 9:
                this.g.a(R.string.camera_ai_scn_indoor);
                break;
            case 10:
                this.g.a(R.string.camera_ai_scn_infant);
                break;
            case 11:
                this.g.a(R.string.camera_ai_scn_landscape);
                break;
            case 12:
                e.b("PIAISceneUI", "getDataByAIScene, subCode: " + i3);
                this.g.a(R.string.camera_ai_scn_night);
                break;
            case 13:
                this.g.a(R.string.camera_ai_scn_snow);
                break;
            case 14:
                this.g.a(R.string.camera_ai_scn_spotlight);
                break;
            case 15:
                this.g.a(R.string.camera_ai_scn_sunset);
                break;
            case 16:
                this.g.a(R.string.camera_ai_scn_portrait);
                break;
            case 17:
                this.g.a(R.string.camera_ai_scn_multi_portrait);
                break;
            case 18:
                this.g.a(R.string.camera_ai_scn_microspur);
                break;
            case 19:
                this.g.a(R.string.camera_ai_scn_backlight);
                break;
            case 20:
                this.g.a(R.string.camera_ai_scn_purecolor);
                break;
            case 21:
                this.g.a(R.string.camera_ai_scn_moire);
                break;
            case 22:
                this.g.a(R.string.camera_ai_scn_flower);
                break;
            case 23:
                this.g.a(R.string.camera_ai_scn_plant);
                break;
            case 24:
                this.g.a(R.string.camera_ai_scn_birds);
                break;
            case 25:
                this.g.a(R.string.camera_ai_scn_architecture);
                break;
            default:
                this.g.a(-1);
                break;
        }
        return this.g;
    }

    private void f(int i2) {
        this.m = i2;
    }

    /* access modifiers changed from: private */
    public void g(int i2) {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() != i2) {
                this.d.setVisibility(i2);
            }
            if (8 == i2) {
                q();
            }
        }
    }

    private void n() {
        AISceneView aISceneView;
        if (this.d != null && (aISceneView = this.e) != null) {
            aISceneView.a((Animator.AnimatorListener) new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    p.this.g(0);
                }
            }, c(this.n));
        }
    }

    private void o() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null && this.e != null && relativeLayout.getVisibility() == 0) {
            this.e.a(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    p.this.g(8);
                }

                public void onAnimationCancel(Animator animator) {
                    p.this.g(8);
                }
            });
        }
    }

    public boolean i() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout == null) {
            return false;
        }
        return relativeLayout.isShown();
    }

    public RelativeLayout f() {
        return this.d;
    }

    public void a(MotionEvent motionEvent) {
        if (1 == motionEvent.getAction()) {
            this.r.removeMessages(1);
            if (this.n == 0) {
                h();
            }
        }
    }

    private boolean b(boolean z) {
        if (this.c == null) {
            return true;
        }
        return z ? this.c.getBoolean("key_ai_scene_first_text_hints", false) : this.c.getBoolean("key_ai_scene_first_hints", false);
    }

    private void b(boolean z, boolean z2) {
        if (this.c == null) {
            return;
        }
        if (z) {
            this.c.edit().putBoolean("key_ai_scene_first_text_hints", z2).apply();
            this.c.edit().putBoolean("key_ai_scene_first_hints", z2).apply();
            return;
        }
        this.c.edit().putBoolean("key_ai_scene_first_hints", z2).apply();
    }

    private void p() {
        this.r.post(new Runnable() {
            public void run() {
                if (p.this.d == null) {
                    return;
                }
                if (p.this.m == 0 || 180 == p.this.m) {
                    p pVar = p.this;
                    j unused = pVar.f = new j(pVar.f4352a);
                    p.this.f.a(true);
                    p.this.f.setFocusable(false);
                    p.this.f.a((CharSequence) p.this.f4352a.getString(R.string.camera_ai_scene_first_hint));
                    p.this.f.a((View) p.this.d);
                }
            }
        });
    }

    private void q() {
        j jVar = this.f;
        if (jVar != null && jVar.isShowing()) {
            this.f.dismiss();
            this.f = null;
        }
    }

    /* compiled from: PIAISceneUI */
    private class a {

        /* renamed from: b  reason: collision with root package name */
        private int f4554b;

        private a() {
            this.f4554b = -1;
        }

        public void a(int i) {
            this.f4554b = i;
        }

        public int a() {
            return this.f4554b;
        }
    }
}
