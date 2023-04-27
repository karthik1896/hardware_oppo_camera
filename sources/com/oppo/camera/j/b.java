package com.oppo.camera.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.ui.control.ShutterButton;
import com.oppo.camera.ui.control.ThumbImageView;
import com.oppo.camera.ui.modepanel.f;
import com.oppo.camera.util.Util;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FilmAnimatorUtil */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3346a = false;

    /* renamed from: b  reason: collision with root package name */
    private static RelativeLayout.LayoutParams f3347b;
    private static ValueAnimator.AnimatorUpdateListener c;
    private static List<AnimatorSet> d = new CopyOnWriteArrayList();

    public static boolean a() {
        return f3346a;
    }

    public static void a(boolean z) {
        f3346a = z;
    }

    public static void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        c = animatorUpdateListener;
    }

    public static void a(final View view, int i, boolean z) {
        Drawable background;
        if (view != null) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_item_move_x);
            final boolean z2 = view.getVisibility() == 0;
            int i2 = z2 ? dimensionPixelSize * i : 0;
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200);
            animatorSet.setInterpolator(AnimationUtils.loadInterpolator(view.getContext(), R.anim.accelerate_decelerate_path_interpolator));
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) i2})});
            if (i != 0) {
                float f = view.isEnabled() ? 1.0f : 0.5f;
                float[] fArr = new float[2];
                fArr[0] = z2 ? 0.0f : f;
                if (!z2) {
                    f = 0.0f;
                }
                fArr[1] = f;
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "alpha", fArr)});
            }
            if (i == 0 && (background = view.getBackground()) != null) {
                int[] iArr = new int[2];
                int i3 = 255;
                iArr[0] = z ? 0 : 255;
                if (!z) {
                    i3 = 0;
                }
                iArr[1] = i3;
                ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(background, view) {
                    private final /* synthetic */ Drawable f$0;
                    private final /* synthetic */ View f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        b.a(this.f$0, this.f$1, valueAnimator);
                    }
                });
                animatorSet.playTogether(new Animator[]{ofInt});
            }
            animatorSet.addListener(new u() {
                public void onAnimationStart(Animator animator) {
                    if (!z2) {
                        view.setVisibility(0);
                    }
                    view.setTag(true);
                }

                public void onAnimationEnd(Animator animator) {
                    if (!z2) {
                        view.setVisibility(8);
                    }
                    view.setTag(false);
                }

                public void onAnimationCancel(Animator animator) {
                    if (!z2) {
                        view.setVisibility(8);
                    }
                    view.setTag(false);
                }
            });
            animatorSet.start();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Drawable drawable, View view, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (drawable != null) {
            drawable.setAlpha(intValue);
            view.setBackground(drawable);
        }
    }

    public static void a(l lVar, View view) {
        if (lVar != null) {
            int dimensionPixelSize = lVar.getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_move_x);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(lVar, "scaleX", new float[]{0.9f, 1.0f});
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(lVar, "alpha", new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) dimensionPixelSize, 0.0f}), ofFloat});
            animatorSet.setDuration(200);
            animatorSet.setInterpolator(AnimationUtils.loadInterpolator(lVar.getContext(), R.anim.accelerate_decelerate_path_interpolator));
            animatorSet.start();
        }
    }

    public static void b(final l lVar, View view) {
        if (lVar != null) {
            int dimensionPixelSize = lVar.getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_move_x);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(lVar, "scaleX", new float[]{1.0f, 0.9f});
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(lVar, "alpha", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) dimensionPixelSize}), ofFloat});
            animatorSet.setDuration(200);
            animatorSet.setInterpolator(AnimationUtils.loadInterpolator(lVar.getContext(), R.anim.accelerate_decelerate_path_interpolator));
            animatorSet.addListener(new u() {
                public void onAnimationEnd(Animator animator) {
                    lVar.setVisibility(8);
                }

                public void onAnimationCancel(Animator animator) {
                    lVar.setVisibility(8);
                }
            });
            animatorSet.start();
        }
    }

    public static void a(ViewGroup viewGroup, ShutterButton shutterButton, ThumbImageView thumbImageView, RelativeLayout relativeLayout, f fVar, ShutterButton shutterButton2, View view, View view2, View view3) {
        ShutterButton shutterButton3 = shutterButton;
        f fVar2 = fVar;
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(viewGroup.getContext(), R.anim.accelerate_decelerate_path_interpolator);
        Interpolator loadInterpolator2 = AnimationUtils.loadInterpolator(viewGroup.getContext(), R.anim.movie_enter_exit_path_interpolator);
        if (shutterButton3 != null) {
            Resources resources = shutterButton.getResources();
            int w = Util.w();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.control_panel_button_height);
            int dimensionPixelSize = (((dimensionPixelOffset / 2) + ((w - resources.getDimensionPixelSize(R.dimen.control_panel_margin_top)) - dimensionPixelOffset)) - (resources.getDimensionPixelSize(R.dimen.movie_mode_params_bottom) + Util.aj())) - (resources.getDimensionPixelSize(R.dimen.movie_mode_params_item_height) / 2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(440);
            animatorSet.setInterpolator(loadInterpolator);
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(shutterButton, "translationX", new float[]{(float) (-shutterButton.getResources().getDimensionPixelSize(R.dimen.movie_mode_shutter_move_x))}), ObjectAnimator.ofFloat(shutterButton, "translationY", new float[]{(float) dimensionPixelSize})});
            animatorSet.start();
            if (fVar2 != null) {
                ValueAnimator duration = ValueAnimator.ofInt(new int[]{255, 0}).setDuration(80);
                duration.setInterpolator(loadInterpolator);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        b.a(f.this, valueAnimator);
                    }
                });
                ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(180);
                duration2.setInterpolator(loadInterpolator2);
                ValueAnimator duration3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(180);
                duration3.setInterpolator(loadInterpolator2);
                duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(thumbImageView, shutterButton2, duration3, view, view2, view3, viewGroup, relativeLayout) {
                    private final /* synthetic */ ThumbImageView f$1;
                    private final /* synthetic */ ShutterButton f$2;
                    private final /* synthetic */ ValueAnimator f$3;
                    private final /* synthetic */ View f$4;
                    private final /* synthetic */ View f$5;
                    private final /* synthetic */ View f$6;
                    private final /* synthetic */ ViewGroup f$7;
                    private final /* synthetic */ RelativeLayout f$8;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                        this.f$5 = r6;
                        this.f$6 = r7;
                        this.f$7 = r8;
                        this.f$8 = r9;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        b.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), f.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8);
                    }
                });
                ThumbImageView thumbImageView2 = thumbImageView;
                duration3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view, view2, view3) {
                    private final /* synthetic */ View f$1;
                    private final /* synthetic */ View f$2;
                    private final /* synthetic */ View f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        b.a(ThumbImageView.this, this.f$1, this.f$2, this.f$3, valueAnimator);
                    }
                });
                duration2.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(f fVar, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        fVar.e(intValue);
        if (intValue == 0) {
            fVar.e(255);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(ThumbImageView thumbImageView, View view, View view2, View view3, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        a((View) thumbImageView, floatValue);
        a(view, floatValue);
        a(view2, floatValue);
        a(view3, floatValue);
    }

    /* access modifiers changed from: private */
    public static void a(float f, f fVar, ThumbImageView thumbImageView, ShutterButton shutterButton, ValueAnimator valueAnimator, View view, View view2, View view3, ViewGroup viewGroup, RelativeLayout relativeLayout) {
        fVar.a(f);
        thumbImageView.setAlpha(f);
        shutterButton.setAlpha(f);
        if (0.0f == f) {
            viewGroup.setLayoutDirection(0);
            fVar.b(false);
            fVar.a(1.0f);
            valueAnimator.start();
            a(view, 0);
            a(view2, 0);
            a(view3, 0);
            a((View) shutterButton, 8);
            a((View) shutterButton, 1.0f);
            a(viewGroup, thumbImageView, relativeLayout);
        }
    }

    private static void a(ViewGroup viewGroup, ThumbImageView thumbImageView, RelativeLayout relativeLayout) {
        if (viewGroup.indexOfChild(thumbImageView) < 0) {
            f3347b = (RelativeLayout.LayoutParams) thumbImageView.getLayoutParams();
            relativeLayout.removeView(thumbImageView);
            viewGroup.addView(thumbImageView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = thumbImageView.getResources().getDimensionPixelSize(R.dimen.movie_mode_thumbnail_width);
            layoutParams.height = thumbImageView.getResources().getDimensionPixelSize(R.dimen.movie_mode_thumbnail_height);
            layoutParams.topMargin = viewGroup.getResources().getDimensionPixelSize(R.dimen.movie_mode_thumbnail_top);
            layoutParams.leftMargin = viewGroup.getResources().getDimensionPixelSize(R.dimen.movie_mode_thumbnail_left);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR)) {
                layoutParams.topMargin += thumbImageView.getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
            }
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            thumbImageView.setLayoutParams(layoutParams);
            thumbImageView.b(thumbImageView.getResources().getDimensionPixelSize(R.dimen.movie_thumbnail_round_corner_radius), true);
            thumbImageView.setRotation(90.0f);
        }
    }

    public static void a(ViewGroup viewGroup, ShutterButton shutterButton, ThumbImageView thumbImageView, RelativeLayout relativeLayout, View view, View view2, View view3) {
        ShutterButton shutterButton2 = shutterButton;
        ThumbImageView thumbImageView2 = thumbImageView;
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(viewGroup.getContext(), R.anim.accelerate_decelerate_path_interpolator);
        Interpolator loadInterpolator2 = AnimationUtils.loadInterpolator(viewGroup.getContext(), R.anim.movie_enter_exit_path_interpolator);
        if (shutterButton2 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(440);
            animatorSet.setInterpolator(loadInterpolator);
            float f = (float) 0;
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(shutterButton, "translationX", new float[]{f}), ObjectAnimator.ofFloat(shutterButton, "translationY", new float[]{f})});
            animatorSet.start();
        }
        RelativeLayout relativeLayout2 = relativeLayout;
        if (relativeLayout.indexOfChild(thumbImageView) < 0 && thumbImageView2 != null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(180);
            duration.setInterpolator(loadInterpolator2);
            ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(180);
            duration.setInterpolator(loadInterpolator2);
            duration2.setInterpolator(loadInterpolator2);
            duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view, view2, view3, viewGroup, relativeLayout, duration) {
                private final /* synthetic */ View f$1;
                private final /* synthetic */ View f$2;
                private final /* synthetic */ View f$3;
                private final /* synthetic */ ViewGroup f$4;
                private final /* synthetic */ RelativeLayout f$5;
                private final /* synthetic */ ValueAnimator f$6;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), ThumbImageView.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
                }
            });
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b.a(ThumbImageView.this, valueAnimator);
                }
            });
            duration2.start();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(ThumbImageView thumbImageView, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        a((View) thumbImageView, floatValue);
        if (1.0f == floatValue) {
            a((View) thumbImageView, 0);
            if (f3346a) {
                a(false);
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = c;
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(valueAnimator);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void a(float f, ThumbImageView thumbImageView, View view, View view2, View view3, ViewGroup viewGroup, RelativeLayout relativeLayout, ValueAnimator valueAnimator) {
        a((View) thumbImageView, f);
        a(view, f);
        a(view2, f);
        a(view3, f);
        if (0.0f == f) {
            if (relativeLayout.indexOfChild(thumbImageView) < 0) {
                viewGroup.removeView(thumbImageView);
                relativeLayout.addView(thumbImageView);
            }
            viewGroup.setLayoutDirection(3);
            thumbImageView.setLayoutParams(f3347b);
            thumbImageView.setPadding(0, 0, 0, 0);
            thumbImageView.b(thumbImageView.getResources().getDimensionPixelSize(R.dimen.thumbnail_round_corner_radius), false);
            thumbImageView.setRotation(0.0f);
            valueAnimator.start();
            a(view, 8);
            a(view2, 8);
            a(view3, 8);
            a(view, 1.0f);
            a(view2, 1.0f);
            a(view3, 1.0f);
            viewGroup.removeView(view2);
        }
    }

    private static void a(View view, float f) {
        if (view != null) {
            view.setAlpha(f);
        }
    }

    private static void a(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
