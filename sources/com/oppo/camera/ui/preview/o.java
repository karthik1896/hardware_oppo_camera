package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.ui.menu.OppoTextView;
import com.oppo.camera.ui.preview.a;
import com.oppo.camera.util.Util;

/* compiled from: NormalAISceneUI */
public class o extends a {
    /* access modifiers changed from: private */
    public RelativeLayout d = null;
    private OppoTextView e = null;
    private ImageView f = null;
    private OppoTextView g = null;
    private ImageView h = null;
    private a i = null;
    private AnimatorSet j = null;
    private ObjectAnimator k = null;
    /* access modifiers changed from: private */
    public a.C0106a l = null;
    private View.OnLayoutChangeListener m = null;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private boolean u = false;
    private int v = 0;

    public o(Activity activity, ViewGroup viewGroup, k kVar) {
        this.f4352a = activity;
        this.f4353b = viewGroup;
        this.c = kVar;
        this.n = this.f4352a.getResources().getDimensionPixelSize(R.dimen.camera_hint_margin);
        this.q = (int) (((double) Util.E()) * 1.3333333333333333d);
        this.v = this.f4352a.getResources().getDimensionPixelSize(R.dimen.toast_margin_top);
    }

    private void k() {
        if (this.d == null && this.f4353b != null) {
            this.f4352a.getLayoutInflater().inflate(R.layout.ai_scene_layout, this.f4353b);
            this.d = (RelativeLayout) this.f4352a.findViewById(R.id.ai_scene_layout);
            this.e = (OppoTextView) this.d.findViewById(R.id.ai_scene_text);
            this.f = (ImageView) this.d.findViewById(R.id.ai_scene_second_divide);
            this.g = (OppoTextView) this.d.findViewById(R.id.ai_scene_right_text);
            this.h = (ImageView) this.d.findViewById(R.id.ai_scene_close);
            if (this.j == null) {
                this.j = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d, View.SCALE_X, new float[]{0.0f, 1.0f});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.d, View.SCALE_Y, new float[]{0.0f, 1.0f});
                this.j.setInterpolator(new PathInterpolator(0.35f, 2.0f, 0.0f, 1.0f));
                this.j.setDuration(240);
                this.j.play(ofFloat).with(ofFloat2);
                this.j.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        if (o.this.d != null) {
                            o.this.d.setAlpha(1.0f);
                            o.this.f(0);
                        }
                    }
                });
            }
            if (this.k == null) {
                this.k = ObjectAnimator.ofFloat(this.d, View.ALPHA, new float[]{1.0f, 0.0f});
                this.k.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
                this.k.setDuration(240);
                this.k.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        o.this.f(8);
                    }
                });
            }
            ImageView imageView = this.h;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        e.b("NormalAISceneUI", "mAISceneCloseView, onClick, code: " + view.getTag());
                        if (o.this.l != null) {
                            o.this.l.a(((Integer) view.getTag()).intValue());
                        }
                    }
                });
            }
            o();
        }
    }

    public void g() {
        l();
        if (!(this.d == null || this.f4353b == null)) {
            this.f4353b.removeView(this.d);
            this.d = null;
            this.e = null;
        }
        this.j = null;
        this.k = null;
        this.u = false;
        this.s = 0;
        this.t = 0;
    }

    public void a(int i2, int i3, int i4) {
        this.s = i2;
        this.t = i4;
        e(i3);
        if (!this.u) {
            k();
            if (this.d != null) {
                a a2 = a(i2, i4);
                if (a2.a() == -1) {
                    l();
                    n();
                    return;
                }
                this.e.setText(a2.a());
                if (a2.c()) {
                    this.g.setText(a2.b());
                    this.f.setVisibility(0);
                    this.g.setVisibility(0);
                } else {
                    this.g.setVisibility(8);
                    this.f.setVisibility(8);
                }
                if (a2.d()) {
                    this.h.setTag(Integer.valueOf(i2));
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                }
                d(i3);
                l();
                m();
            }
        }
    }

    private int a(View view) {
        if (view == null) {
            return 0;
        }
        view.measure(Util.E(), Util.E());
        return view.getWidth();
    }

    public void a(a.C0106a aVar) {
        this.l = aVar;
    }

    private void l() {
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.k.cancel();
        }
        AnimatorSet animatorSet = this.j;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.j.cancel();
        }
    }

    public void h() {
        if (this.d != null) {
            l();
            n();
        }
    }

    public void d(int i2) {
        if (this.d != null) {
            e(i2);
            if (!this.u) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
                this.d.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = this.d.getMeasuredWidth();
                int measuredHeight = this.d.getMeasuredHeight();
                this.d.layout(0, 0, measuredWidth, measuredHeight);
                if (this.o > 0) {
                    int i3 = this.v;
                }
                if (i2 == 90) {
                    layoutParams.addRule(9);
                    layoutParams.addRule(10);
                    layoutParams.leftMargin = (this.n + (measuredHeight / 2)) - (measuredWidth / 2);
                    layoutParams.topMargin = (((this.q - measuredHeight) - this.o) / 2) + Util.v();
                } else if (i2 != 270) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = Util.v() + this.n + this.p + this.v;
                    layoutParams.rightMargin = ((Util.E() - measuredWidth) - this.o) / 2;
                } else {
                    layoutParams.addRule(11);
                    layoutParams.addRule(10);
                    layoutParams.rightMargin = (this.n + (measuredHeight / 2)) - (measuredWidth / 2);
                    layoutParams.topMargin = (((this.q - measuredHeight) + this.o) / 2) + Util.v();
                }
                this.d.setZ(999.0f);
                this.d.setLayoutParams(layoutParams);
                this.d.setRotation((float) (-this.r));
            }
        }
    }

    private a a(int i2, int i3) {
        if (this.i == null) {
            this.i = new a();
        }
        this.i.b(-1);
        this.i.a(false);
        this.i.b(false);
        switch (i2) {
            case 1:
                this.i.a((int) R.string.camera_ai_scn_beach);
                break;
            case 2:
                this.i.a((int) R.string.camera_ai_scn_bluesky);
                break;
            case 3:
                this.i.a((int) R.string.camera_ai_scn_cat);
                break;
            case 4:
                this.i.a((int) R.string.camera_ai_scn_text);
                break;
            case 5:
                this.i.a((int) R.string.camera_ai_scn_dog);
                break;
            case 6:
                this.i.a((int) R.string.camera_ai_scn_firework);
                break;
            case 7:
                this.i.a((int) R.string.camera_ai_scn_gourmet);
                break;
            case 8:
                this.i.a((int) R.string.camera_ai_scn_grass);
                break;
            case 9:
                this.i.a((int) R.string.camera_ai_scn_indoor);
                break;
            case 10:
                this.i.a((int) R.string.camera_ai_scn_infant);
                break;
            case 11:
                this.i.a((int) R.string.camera_ai_scn_landscape);
                break;
            case 12:
                e.b("NormalAISceneUI", "getDataByAIScene, subCode: " + i3);
                this.i.a((int) R.string.camera_ai_scn_night);
                if (i3 != 1) {
                    if (i3 == 2) {
                        this.i.b(-1);
                        this.i.a(false);
                        this.i.b(true);
                        break;
                    }
                } else {
                    this.i.b((int) R.string.camera_ai_scn_night_capture_tips);
                    this.i.a(true);
                    this.i.b(true);
                    break;
                }
                break;
            case 13:
                this.i.a((int) R.string.camera_ai_scn_snow);
                break;
            case 14:
                this.i.a((int) R.string.camera_ai_scn_spotlight);
                break;
            case 15:
                this.i.a((int) R.string.camera_ai_scn_sunset);
                break;
            case 16:
                this.i.a((int) R.string.camera_ai_scn_portrait);
                break;
            case 17:
                this.i.a((int) R.string.camera_ai_scn_multi_portrait);
                break;
            case 18:
                this.i.a((int) R.string.camera_ai_scn_microspur);
                break;
            case 19:
                this.i.a((int) R.string.camera_ai_scn_backlight);
                break;
            case 20:
                this.i.a((int) R.string.camera_ai_scn_purecolor);
                break;
            case 21:
                this.i.a((int) R.string.camera_ai_scn_moire);
                break;
            case 22:
                this.i.a((int) R.string.camera_ai_scn_flower);
                break;
            case 23:
                this.i.a((int) R.string.camera_ai_scn_plant);
                break;
            case 24:
                this.i.a((int) R.string.camera_ai_scn_birds);
                break;
            case 25:
                this.i.a((int) R.string.camera_ai_scn_architecture);
                break;
            default:
                this.i.a(-1);
                break;
        }
        return this.i;
    }

    private void e(int i2) {
        if (i2 == 180) {
            this.r = 0;
        } else {
            this.r = i2;
        }
    }

    public void b(int i2) {
        if (i2 != this.o) {
            this.o = i2;
            d(this.r);
        }
    }

    public void a(boolean z, boolean z2) {
        this.u = z;
        k();
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout == null) {
            return;
        }
        if (this.u) {
            if (relativeLayout.getVisibility() == 0) {
                f(8);
            }
        } else if (z2 && relativeLayout.getVisibility() != 0) {
            a(this.s, this.r, this.t);
        }
    }

    /* access modifiers changed from: private */
    public void f(int i2) {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() != i2) {
                this.d.setVisibility(i2);
            }
            a.C0106a aVar = this.l;
            if (aVar == null) {
                return;
            }
            if (i2 != 0) {
                aVar.b(0);
            } else {
                aVar.b(b());
            }
        }
    }

    public int b() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return 0;
        }
        return a((View) this.d);
    }

    private void m() {
        AnimatorSet animatorSet = this.j;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    private void n() {
        if (this.k != null && this.d.getVisibility() == 0) {
            this.k.start();
        }
    }

    public void a(View.OnLayoutChangeListener onLayoutChangeListener) {
        this.m = onLayoutChangeListener;
        o();
    }

    private void o() {
        View.OnLayoutChangeListener onLayoutChangeListener;
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null && (onLayoutChangeListener = this.m) != null) {
            relativeLayout.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    public boolean c() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void a(int i2) {
        this.p = i2;
    }

    public int a() {
        return this.n;
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

    /* compiled from: NormalAISceneUI */
    private class a {

        /* renamed from: b  reason: collision with root package name */
        private int f4547b;
        private int c;
        private boolean d;
        private boolean e;

        private a() {
            this.f4547b = -1;
            this.c = -1;
            this.d = false;
            this.e = false;
        }

        public void a(int i) {
            this.f4547b = i;
        }

        public void b(int i) {
            this.c = i;
        }

        public void a(boolean z) {
            this.d = z;
        }

        public void b(boolean z) {
            this.e = z;
        }

        public int a() {
            return this.f4547b;
        }

        public int b() {
            return this.c;
        }

        public boolean c() {
            return this.d;
        }

        public boolean d() {
            return this.e;
        }
    }
}
