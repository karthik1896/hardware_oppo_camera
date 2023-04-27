package com.oppo.camera.ui.menu.setting;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.j.u;
import com.oppo.camera.k;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.setting.down.DrawerLayout;
import com.oppo.camera.ui.menu.setting.down.a;
import com.oppo.camera.ui.menu.setting.down.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CameraDrawerSettingUI */
public class f extends p implements DrawerLayout.b {
    /* access modifiers changed from: private */
    public DrawerLayout k;
    private AnimatorSet l;

    public f(Activity activity, k kVar, com.oppo.camera.ui.f fVar, boolean z) {
        super(activity, kVar, fVar, z);
        this.k = null;
        this.l = null;
        this.k = (DrawerLayout) this.d.findViewById(R.id.oppo_slide_downward);
        this.k.setOnDrawerListener(this);
    }

    public void a() {
        e.a("CameraDrawerSettingUI", "initializeCameraSettingMenu, mPreferenceOptionGroup: " + this.h);
        if (this.h != null) {
            this.g = (CameraSettingMenuPanel) this.d.findViewById(R.id.oppo_subsetting_bar);
            this.g.a(this.e, this.f, this.h, this.i, true);
        }
        if (this.f != null) {
            this.f.ao();
        }
    }

    public void a(int i) {
        e.b("CameraDrawerSettingUI", "setCameraDrawerSettingOpenAndClose, isOpen: " + i);
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            drawerLayout.setOpenAndClose(i == 0);
        }
    }

    public boolean b() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            return drawerLayout.e();
        }
        return false;
    }

    public void c() {
        if (this.f != null) {
            this.f.l("3");
        }
    }

    public void d() {
        k();
        if (!h()) {
            e.b("CameraDrawerSettingUI", "onArrowClick, can't response arrow click, so return");
            return;
        }
        if (this.e != null) {
            this.e.edit().putString("pref_subsetting_key", x() ? "off" : "on").apply();
        }
        if (this.f != null) {
            this.f.l("1");
        }
    }

    public void e() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            drawerLayout.f();
            k();
        }
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.l.removeAllListeners();
        }
        super.e();
    }

    public void f() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            drawerLayout.a();
        }
        super.f();
    }

    public void g() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            drawerLayout.g();
        }
        super.g();
    }

    public void a(boolean z) {
        if (this.e != null) {
            String str = "off";
            String string = this.e.getString("pref_subsetting_key", str);
            e.b("CameraDrawerSettingUI", "onShowAndHide, value: " + string + ", isOpen: " + z);
            if ("on".equals(string) != z) {
                SharedPreferences.Editor edit = this.e.edit();
                if (z) {
                    str = "on";
                }
                edit.putString("pref_subsetting_key", str).apply();
            }
            if (z) {
                this.e.edit().putBoolean("key_drawer_show_guide_animation", false).apply();
            }
        }
    }

    public void a(float f) {
        if (this.d != null) {
            c.INS.setMaskAlpha(this.d, f);
            if (1.0f > f) {
                k();
            }
        }
    }

    public boolean h() {
        if (this.f == null) {
            return true;
        }
        if (2 == this.f.g() || q()) {
            return false;
        }
        return true;
    }

    public void a(boolean z, boolean z2) {
        if (this.k != null) {
            e.b("CameraDrawerSettingUI", "enableCameraSettingMenu, enable: " + z);
            this.k.setEnabled(z);
        }
    }

    public void b(boolean z) {
        if (this.k != null) {
            e.b("CameraDrawerSettingUI", "hideCameraSettingMenu, isEnabled: " + z);
            this.k.setRollVisibility(4);
            this.k.setEnabled(z);
        }
    }

    public void i() {
        if (this.k != null) {
            e.b("CameraDrawerSettingUI", "showCameraSettingMenu");
            this.k.setRollVisibility(0);
            this.k.setEnabled(true);
        }
    }

    public void j() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            drawerLayout.b();
        }
    }

    public void k() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            drawerLayout.c();
        }
    }

    public boolean l() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            return drawerLayout.h();
        }
        return false;
    }

    public boolean m() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            return drawerLayout.i();
        }
        return false;
    }

    public boolean n() {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            return drawerLayout.getEnableTouch();
        }
        return false;
    }

    public void o() {
        if (!q()) {
            super.o();
            DrawerLayout drawerLayout = this.k;
            if (drawerLayout != null) {
                drawerLayout.getDrawerScrollLayout().getArrowView().setVisibility(p() ? 0 : 4);
                this.k.requestLayout();
            }
        }
    }

    public boolean p() {
        boolean z;
        CopyOnWriteArrayList<CameraMenuOption> y = y();
        if (y != null) {
            Iterator<CameraMenuOption> it = y.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (a(it.next().a())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        e.b("CameraDrawerSettingUI", "willSubMenuShow: " + z);
        return z;
    }

    public boolean q() {
        AnimatorSet animatorSet = this.l;
        return animatorSet != null && animatorSet.isRunning();
    }

    public boolean a(Runnable runnable) {
        if (this.d == null || this.k == null || this.g == null) {
            return false;
        }
        final b drawerScrollLayout = this.k.getDrawerScrollLayout();
        final a arrowView = drawerScrollLayout.getArrowView();
        final int dimension = (int) this.d.getResources().getDimension(R.dimen.drawer_layout_arrow_height);
        int dimension2 = ((int) this.d.getResources().getDimension(R.dimen.drawer_layout_space)) + ((int) this.d.getResources().getDimension(R.dimen.drawer_layout_arrow_height));
        int a2 = a(this.g);
        if (a2 == 0) {
            this.g.setPendingDrawerGuideAni(new Runnable(dimension2, drawerScrollLayout, runnable, dimension) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ b f$2;
                private final /* synthetic */ Runnable f$3;
                private final /* synthetic */ int f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    f.this.a(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
            return true;
        }
        final int i = a2 + dimension2;
        if (arrowView.getMeasuredHeight() == 0) {
            final Runnable runnable2 = runnable;
            arrowView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (arrowView.getMeasuredHeight() != 0) {
                        drawerScrollLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        if (!f.this.j) {
                            f.this.a(drawerScrollLayout, runnable2, dimension, i);
                        }
                    }
                }
            });
        } else {
            a(drawerScrollLayout, runnable, dimension, i);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i, b bVar, Runnable runnable, int i2) {
        e.b("CameraDrawerSettingUI", "showDrawerSettingGuideAni, after drawer item initialized, mbPaused: " + this.j);
        if (!this.j) {
            a(bVar, runnable, i2, i + a(this.g));
        }
    }

    private int a(CameraSettingMenuPanel cameraSettingMenuPanel) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < cameraSettingMenuPanel.getChildCount(); i3++) {
            View childAt = cameraSettingMenuPanel.getChildAt(i3);
            if (childAt.getVisibility() == 0 && childAt.getMeasuredHeight() > 0) {
                i += childAt.getMeasuredHeight() + ((int) this.d.getResources().getDimension(R.dimen.drawer_layout_space));
                i2++;
            }
            if (i2 == 2) {
                break;
            }
        }
        return i;
    }

    public void r() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void c(boolean z) {
        DrawerLayout drawerLayout = this.k;
        if (drawerLayout != null) {
            drawerLayout.setEnableTouch(z);
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar, final Runnable runnable, int i, int i2) {
        e.b("CameraDrawerSettingUI", "realShowDrawerSettingGuideAni, topY: " + i + ", totalDistance: " + i2);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setStartDelay(117);
        ofInt.setDuration(733);
        ofInt.setInterpolator(AnimationUtils.loadInterpolator(this.d, R.anim.guide_drawer_setting_down_interpolator));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), valueAnimator.getAnimatedFraction());
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{i2, i - 1});
        ofInt2.setStartDelay(117);
        ofInt2.setDuration(417);
        ofInt2.setInterpolator(AnimationUtils.loadInterpolator(this.d, R.anim.guide_drawer_setting_down_interpolator));
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), 1.0f - valueAnimator.getAnimatedFraction());
            }
        });
        int dimension = (int) this.d.getResources().getDimension(R.dimen.guide_drawer_arrow_ani_down);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(new int[]{0, dimension});
        ofInt3.setDuration(250);
        ofInt3.setInterpolator(AnimationUtils.loadInterpolator(this.d, R.anim.guide_drawer_arrow_down_interpolator));
        ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ValueAnimator ofInt4 = ValueAnimator.ofInt(new int[]{dimension, 1});
        ofInt4.setDuration(250);
        ofInt4.setInterpolator(AnimationUtils.loadInterpolator(this.d, R.anim.guide_drawer_arrow_up_interpolator));
        ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.l = new AnimatorSet();
        this.l.removeAllListeners();
        this.l.playSequentially(new Animator[]{ofInt, ofInt2, ofInt3, ofInt4});
        this.l.addListener(new u() {
            private void a(boolean z) {
                if (f.this.k != null) {
                    f.this.k.setEnabled(z);
                }
            }

            public void onAnimationStart(Animator animator) {
                e.b("CameraDrawerSettingUI", "realShowDrawerSettingGuideAni, onAnimationStart");
                a(false);
            }

            public void onAnimationEnd(Animator animator) {
                e.b("CameraDrawerSettingUI", "realShowDrawerSettingGuideAni, onAnimationEnd");
                a(true);
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }

            public void onAnimationCancel(Animator animator) {
                e.b("CameraDrawerSettingUI", "realShowDrawerSettingGuideAni, onAnimationCancel");
                a(true);
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        this.l.start();
    }
}
