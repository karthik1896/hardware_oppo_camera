package com.oppo.camera.j;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.oppo.camera.R;
import com.oppo.camera.j.h;
import com.oppo.camera.j.m;
import com.oppo.camera.ui.CommonComponent.SlideBar;
import com.oppo.camera.util.Util;
import java.util.List;

/* compiled from: FilmParamsContainer */
public class l extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f3370a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public h f3371b = null;
    /* access modifiers changed from: private */
    public m c = null;
    private j d = null;
    /* access modifiers changed from: private */
    public int e = 0;
    /* access modifiers changed from: private */
    public int f = 0;
    /* access modifiers changed from: private */
    public boolean g = false;
    private ValueAnimator h = null;
    private ValueAnimator i = null;

    public l(Context context) {
        super(context);
        e();
    }

    private void e() {
        this.e = getResources().getDimensionPixelSize(R.dimen.movie_mode_params_min_width);
        this.f = getResources().getDimensionPixelSize(R.dimen.movie_mode_params_max_width);
        this.f3370a = getResources().getDimensionPixelSize(R.dimen.movie_params_slide_translation);
        setBackgroundResource(R.drawable.movie_mode_params_container_bg);
        setOrientation(1);
        setGravity(80);
        this.c = new m(getContext());
        this.c.setId(R.id.movie_slide_bar_id);
        this.c.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_bar_click_height));
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_margin_right);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_margin_left);
        addView(this.c, layoutParams);
        this.f3371b = new h(getContext());
        addView(this.f3371b, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_height)));
        f();
    }

    private void f() {
        this.h = ValueAnimator.ofInt(new int[]{this.e, this.f});
        this.h.setDuration(330);
        this.h.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.accelerate_decelerate_path_interpolator));
        this.h.addUpdateListener(new b());
        this.i = ValueAnimator.ofInt(new int[]{this.f, this.e});
        this.i.setDuration(330);
        this.i.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.accelerate_decelerate_path_interpolator));
        this.i.addUpdateListener(new a());
    }

    public View a(int i2) {
        if (i2 < this.f3371b.getChildCount()) {
            return this.f3371b.getChildAt(i2);
        }
        return null;
    }

    public void setSlideAdapter(j jVar) {
        this.d = jVar;
    }

    public void a(List<k> list, int i2) {
        if (this.d != null && list != null && list.size() == this.d.getCount()) {
            this.d.a(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i2 == i3) {
                    this.d.a(i3, this.c, this);
                    return;
                }
            }
        }
    }

    public void setSlideSelected(int i2) {
        m mVar = this.c;
        if (mVar != null && this.d != null && !this.g) {
            int i3 = 0;
            if (mVar.getVisibility() != 0) {
                final Interpolator loadInterpolator = AnimationUtils.loadInterpolator(getContext(), R.anim.movie_hide_slide_path_interpolator);
                this.g = true;
                this.f3371b.setEnabled(false);
                this.h.start();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationY", new float[]{(float) this.f3370a, 0.0f});
                ofFloat.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.accelerate_decelerate_path_interpolator));
                ofFloat.setDuration(250);
                ofFloat.setStartDelay(50);
                ofFloat.start();
                ofFloat.addListener(new u() {
                    public void onAnimationStart(Animator animator) {
                        Util.a((View) l.this.c, 0, (Animation.AnimationListener) null, 250, 0, loadInterpolator);
                    }
                });
            }
            k a2 = this.d.getItem(i2);
            m mVar2 = this.c;
            if (!a2.e()) {
                i3 = 8;
            }
            mVar2.a(i3, a2.c());
            this.d.a(i2, this.c, this);
        }
    }

    public void a(boolean z) {
        m mVar = this.c;
        if (mVar != null && 8 != mVar.getVisibility()) {
            if (this.g || !z) {
                m mVar2 = this.c;
                if (mVar2 != null && !this.g) {
                    mVar2.setVisibility(8);
                    this.g = false;
                    this.f3371b.setEnabled(true);
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = this.e;
                        setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                }
                return;
            }
            Interpolator loadInterpolator = AnimationUtils.loadInterpolator(getContext(), R.anim.movie_hide_slide_path_interpolator);
            this.g = true;
            this.f3371b.setEnabled(false);
            this.i.start();
            Util.a((View) this.c, 8, (Animation.AnimationListener) null, 150, 0, loadInterpolator);
        }
    }

    public boolean a() {
        return this.g;
    }

    public j getSlideAdapter() {
        return this.d;
    }

    public int getSlidePosition() {
        m mVar = this.c;
        if (mVar != null) {
            return mVar.getCurrentSlideIndex();
        }
        return -1;
    }

    public void b(boolean z) {
        a(z);
        h hVar = this.f3371b;
        if (hVar != null) {
            b.b(this, hVar);
        }
    }

    public void b() {
        setVisibility(0);
        h hVar = this.f3371b;
        if (hVar != null) {
            b.a(this, (View) hVar);
        }
    }

    public boolean c() {
        return getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getMeasuredWidth() > 0) {
            setPivotX(0.0f);
            setPivotY((float) getMeasuredHeight());
        }
    }

    public void a(BaseAdapter baseAdapter, h.a aVar) {
        h hVar = this.f3371b;
        if (hVar != null) {
            hVar.setAdapter(baseAdapter);
            this.f3371b.setOnItemClickListener(aVar);
        }
    }

    public h getFilmModeBarLayout() {
        return this.f3371b;
    }

    public void setSlideBarValueChangeListener(SlideBar.SlideBarValueChangeListener slideBarValueChangeListener) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.setSlideBarValueChangeListener(slideBarValueChangeListener);
        }
    }

    public void setSlideBarAutoListener(m.a aVar) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.setSlideBarAutoListener(aVar);
        }
    }

    public boolean b(int i2) {
        m mVar = this.c;
        return mVar != null && mVar.a(i2);
    }

    public void d() {
        h hVar = this.f3371b;
        if (hVar != null) {
            hVar.a();
        }
    }

    /* compiled from: FilmParamsContainer */
    private class b implements ValueAnimator.AnimatorUpdateListener {
        private b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = l.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = intValue;
                l.this.setLayoutParams(layoutParams);
            }
            if (intValue == l.this.f) {
                l.this.f3371b.setEnabled(true);
                boolean unused = l.this.g = false;
            }
        }
    }

    /* compiled from: FilmParamsContainer */
    private class a implements ValueAnimator.AnimatorUpdateListener {
        private a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = l.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = intValue;
                l.this.setLayoutParams(layoutParams);
            }
            if (intValue == l.this.e) {
                l.this.f3371b.setEnabled(true);
                boolean unused = l.this.g = false;
            }
        }
    }
}
