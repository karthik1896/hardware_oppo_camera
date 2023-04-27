package com.oppo.camera.ui.menu.levelcontrol;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

/* compiled from: SwitchFilterMenu */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private a f4152a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4153b;
    private ObjectAnimator c;
    private ObjectAnimator d;
    /* access modifiers changed from: private */
    public Handler e;

    /* compiled from: SwitchFilterMenu */
    public interface a {
        void a(int i);

        String b(int i);
    }

    public void a() {
        e.a("SwitchFilterMenu", "cancelAnimator");
        if (this.e.hasMessages(1)) {
            this.e.removeMessages(1);
            this.f4153b.setAlpha(0.0f);
        }
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.d.cancel();
            this.f4153b.setAlpha(0.0f);
        }
        ObjectAnimator objectAnimator2 = this.c;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.c.cancel();
        }
    }

    public void b() {
        e.a("SwitchFilterMenu", "slideToPreviousFilter");
        a(2, ((float) (-Util.E())) / 2.0f, 0.0f);
    }

    public void c() {
        e.a("SwitchFilterMenu", "slideToNextFilter");
        a(1, ((float) Util.E()) / 2.0f, 0.0f);
    }

    private void a(int i, float f, float f2) {
        String b2;
        e.a("SwitchFilterMenu", "switchFilterAnimator, direction: " + i + ", startTranslationX: " + f + ", endTranslationX: " + f2);
        a();
        a aVar = this.f4152a;
        if (!(aVar == null || (b2 = aVar.b(i)) == null)) {
            this.f4153b.setText(b2);
        }
        TextView textView = this.f4153b;
        if (!(textView == null || textView.getVisibility() == 0)) {
            this.f4153b.setVisibility(0);
        }
        a aVar2 = this.f4152a;
        if (aVar2 != null) {
            aVar2.a(i);
        }
        TextView textView2 = this.f4153b;
        if (textView2 != null) {
            textView2.setAlpha(1.0f);
        }
        this.c = ObjectAnimator.ofFloat(this.f4153b, View.TRANSLATION_X, new float[]{f, f2});
        this.c.setDuration(150);
        this.c.setInterpolator(new AccelerateDecelerateInterpolator());
        this.c.addListener(new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animator) {
                e.a("SwitchFilterMenu", "switchFilterAnimator, onAnimationStart");
            }

            public void onAnimationEnd(Animator animator) {
                e.a("SwitchFilterMenu", "switchFilterAnimator, onAnimationEnd");
                if (k.this.e != null) {
                    k.this.e.removeMessages(1);
                    k.this.e.sendEmptyMessageDelayed(1, 1000);
                }
            }

            public void onAnimationCancel(Animator animator) {
                e.a("SwitchFilterMenu", "switchFilterAnimator, onAnimationCancel");
            }

            public void onAnimationRepeat(Animator animator) {
                e.a("SwitchFilterMenu", "switchFilterAnimator, onAnimationRepeat");
            }
        });
        this.c.start();
    }
}
