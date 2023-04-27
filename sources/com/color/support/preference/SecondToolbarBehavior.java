package com.color.support.preference;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import color.support.design.widget.ColorAppBarLayout;
import color.support.v7.appcompat.R;

public class SecondToolbarBehavior extends CoordinatorLayout.b<ColorAppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public int f1980a;

    /* renamed from: b  reason: collision with root package name */
    private View f1981b;
    private View c;
    private View d;
    private int e;
    private int f;
    private int g;
    private int[] h = new int[2];
    private int i;
    private ViewGroup.LayoutParams j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private float r;
    private float s;
    private Resources t;
    private boolean u;

    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    public SecondToolbarBehavior() {
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.t = context.getResources();
        this.k = this.t.getDimensionPixelOffset(R.dimen.preference_divider_margin_horizontal) * 2;
        this.n = this.t.getDimensionPixelOffset(R.dimen.preference_line_alpha_range_change_offset);
        this.q = this.t.getDimensionPixelOffset(R.dimen.preference_divider_width_change_offset);
        this.u = this.t.getBoolean(R.bool.is_dialog_preference_immersive);
    }

    /* renamed from: a */
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, ColorAppBarLayout colorAppBarLayout, View view, View view2, int i2, int i3) {
        boolean z = (i2 & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= colorAppBarLayout.getHeight();
        if (!this.u && z) {
            if (this.l <= 0) {
                this.l = colorAppBarLayout.getMeasuredHeight();
                this.c = view2;
                this.f1981b = colorAppBarLayout.findViewById(R.id.divider_line);
                this.f1980a = this.f1981b.getWidth();
                this.j = this.f1981b.getLayoutParams();
                this.i = colorAppBarLayout.getMeasuredWidth();
                int i4 = this.l;
                this.m = i4 - this.n;
                this.p = i4 - this.t.getDimensionPixelOffset(R.dimen.preference_divider_width_start_count_offset);
                this.o = this.p - this.q;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                view2.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                    public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                        SecondToolbarBehavior.this.a();
                    }
                });
            } else if (view2 instanceof AbsListView) {
                ((AbsListView) view2).setOnScrollListener(this);
            }
        }
        return false;
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        a();
    }

    /* access modifiers changed from: private */
    public void a() {
        this.d = null;
        View view = this.c;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= viewGroup.getChildCount()) {
                        break;
                    } else if (viewGroup.getChildAt(i2).getVisibility() == 0) {
                        this.d = viewGroup.getChildAt(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (this.d == null) {
            this.d = this.c;
        }
        this.d.getLocationOnScreen(this.h);
        this.e = this.h[1];
        this.f = 0;
        int i3 = this.e;
        if (i3 < this.m) {
            this.f = this.n;
        } else {
            int i4 = this.l;
            if (i3 > i4) {
                this.f = 0;
            } else {
                this.f = i4 - i3;
            }
        }
        this.g = this.f;
        if (this.r <= 1.0f) {
            this.r = ((float) Math.abs(this.g)) / ((float) this.n);
            this.f1981b.setAlpha(this.r);
        }
        int i5 = this.e;
        if (i5 < this.o) {
            this.f = this.q;
        } else {
            int i6 = this.p;
            if (i5 > i6) {
                this.f = 0;
            } else {
                this.f = i6 - i5;
            }
        }
        this.g = this.f;
        this.s = ((float) Math.abs(this.g)) / ((float) this.q);
        ViewGroup.LayoutParams layoutParams = this.j;
        layoutParams.width = (int) (((float) this.f1980a) + (((float) this.k) * this.s));
        this.f1981b.setLayoutParams(layoutParams);
    }
}
