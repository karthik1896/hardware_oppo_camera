package com.color.support.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.g.t;
import com.color.support.widget.ColorMaxHeightDraggableVerticalLinearLayout;

/* compiled from: ColorPanelAdjustResizeHelper */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f1862a = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f1863b = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
    private boolean c = false;
    private boolean d = false;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private boolean i = false;
    private View j = null;
    private int k = 0;
    private boolean l = false;
    private View m = null;
    private int n = -1;
    private ValueAnimator o;

    public void a(ColorMaxHeightDraggableVerticalLinearLayout colorMaxHeightDraggableVerticalLinearLayout, boolean z, int i2) {
        if (colorMaxHeightDraggableVerticalLinearLayout == null) {
            return;
        }
        if (this.d != z || this.f != i2) {
            if (a()) {
                colorMaxHeightDraggableVerticalLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(colorMaxHeightDraggableVerticalLinearLayout.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(colorMaxHeightDraggableVerticalLinearLayout.getMaxHeight(), Integer.MIN_VALUE));
            }
            a((ViewGroup) colorMaxHeightDraggableVerticalLinearLayout);
            if (z) {
                int i3 = this.f;
                if (i3 == 0 || i3 == i2) {
                    this.i = false;
                    this.e = colorMaxHeightDraggableVerticalLinearLayout.getMeasuredHeight();
                    this.f = i2;
                    int i4 = this.e;
                    int i5 = this.f;
                    this.h = i4 + i5;
                    this.g = i5;
                    a(colorMaxHeightDraggableVerticalLinearLayout, true);
                } else {
                    this.i = true;
                    if (this.d) {
                        this.e = colorMaxHeightDraggableVerticalLinearLayout.getMeasuredHeight() - i2;
                        this.g = i2 - this.f;
                    } else {
                        this.e = colorMaxHeightDraggableVerticalLinearLayout.getMeasuredHeight();
                        this.g = i2;
                    }
                    this.f = i2;
                    a(colorMaxHeightDraggableVerticalLinearLayout, true);
                }
            } else if (!this.c) {
                this.i = false;
                this.f = i2;
                this.g = this.f;
                a(colorMaxHeightDraggableVerticalLinearLayout, false);
            }
            this.c = false;
            this.d = z;
        }
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            View findFocus = viewGroup.findFocus();
            this.j = findFocus;
            if (findFocus != null) {
                this.k = 0;
                this.l = false;
                this.m = null;
                if (b(findFocus)) {
                    this.l = true;
                    this.m = findFocus;
                }
                this.k = a(findFocus) + findFocus.getTop();
                View view = (View) findFocus.getParent();
                while (view != null && view != viewGroup.getParent()) {
                    if (b(view)) {
                        this.l = true;
                        this.m = view;
                    }
                    this.k += view.getTop();
                    view = (View) view.getParent();
                }
            }
        }
    }

    private void a(ColorMaxHeightDraggableVerticalLinearLayout colorMaxHeightDraggableVerticalLinearLayout, Boolean bool) {
        int i2;
        float f2;
        float f3;
        View view;
        if (colorMaxHeightDraggableVerticalLinearLayout != null && (i2 = this.g) != 0) {
            int i3 = 1;
            if (this.f == i2 && !bool.booleanValue()) {
                i3 = -1;
            }
            int maxHeight = colorMaxHeightDraggableVerticalLinearLayout.getMaxHeight();
            int i4 = (this.e - this.k) - (this.d ? this.f : 0);
            if (this.l && maxHeight != 0) {
                int i5 = i3 * this.g;
                if (bool.booleanValue()) {
                    f3 = Math.abs((((float) i5) * 120.0f) / ((float) maxHeight)) + 300.0f;
                } else {
                    f3 = Math.abs((((float) i5) * 50.0f) / ((float) maxHeight)) + 200.0f;
                }
                View view2 = this.m;
                if (view2 != null) {
                    View view3 = (View) view2.getParent();
                    this.n = view3.getPaddingBottom();
                    view = view3;
                } else {
                    this.n = -1;
                    view = colorMaxHeightDraggableVerticalLinearLayout;
                }
                a(view, i5, (long) f3);
            } else if (this.d == bool.booleanValue() || i4 < this.f) {
                int i6 = i3 * this.g;
                if (bool.booleanValue()) {
                    f2 = Math.abs((((float) i6) * 120.0f) / ((float) maxHeight)) + 300.0f;
                } else {
                    f2 = Math.abs((((float) i6) * 50.0f) / ((float) maxHeight)) + 200.0f;
                }
                a((View) colorMaxHeightDraggableVerticalLinearLayout, i6, (long) f2);
            }
        }
    }

    private void a(View view, int i2, long j2) {
        if (i2 != 0 && view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int max = Math.max(0, view.getPaddingBottom());
            final int max2 = Math.max(0, i2 + max);
            this.o = ValueAnimator.ofInt(new int[]{max, max2});
            this.o.setDuration(j2);
            if (max < max2) {
                this.o.setInterpolator(f1862a);
            } else {
                this.o.setInterpolator(f1863b);
            }
            final View view2 = view;
            final int i3 = paddingLeft;
            final int i4 = paddingTop;
            final int i5 = paddingRight;
            this.o.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    view2.setPadding(i3, i4, i5, max2);
                }
            });
            this.o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    View view = view2;
                    if (view != null && view.isAttachedToWindow()) {
                        view2.setPadding(i3, i4, i5, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            this.o.start();
        }
    }

    private int a(View view) {
        if (view == null || view.getVisibility() == 8) {
            return 0;
        }
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    private boolean b(View view) {
        return (view instanceof ScrollView) || (view instanceof AbsListView) || (view instanceof t);
    }

    public void a(boolean z) {
        this.c = z;
    }

    private View b() {
        View view = this.m;
        if (view != null) {
            return (View) view.getParent();
        }
        return null;
    }

    public void a(ColorMaxHeightDraggableVerticalLinearLayout colorMaxHeightDraggableVerticalLinearLayout) {
        if (this.l) {
            View b2 = b();
            if (b2 != null && this.n >= 0) {
                b2.setPadding(0, 0, 0, 0);
            }
        } else if (colorMaxHeightDraggableVerticalLinearLayout != null) {
            colorMaxHeightDraggableVerticalLinearLayout.setPadding(0, 0, 0, 0);
        }
    }

    public boolean a() {
        ValueAnimator valueAnimator = this.o;
        boolean z = false;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.o.cancel();
                z = true;
            }
            this.o = null;
        }
        return z;
    }
}
