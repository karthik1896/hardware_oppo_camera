package com.oppo.camera.b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

/* compiled from: ZoomAnimationListener */
public class b implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2773a = false;

    /* renamed from: b  reason: collision with root package name */
    private View f2774b = null;
    private View c = null;

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    public b(boolean z, View view, View view2) {
        this.f2773a = z;
        this.f2774b = view;
        this.c = view2;
    }

    public void onAnimationEnd(Animation animation) {
        a(180);
    }

    public void a(int i) {
        View view = this.f2774b;
        if (view != null) {
            Util.a(view, this.f2773a ? 0 : 4, (Animation.AnimationListener) null, (long) i, 0, AnimationUtils.loadInterpolator(this.f2774b.getContext(), R.anim.face_point_scale_interpolator2));
        }
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }
}
