package com.color.support.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import color.support.v7.appcompat.R;

public class StatementBehavior extends CoordinatorLayout.b {

    /* renamed from: a  reason: collision with root package name */
    public int f2009a;

    /* renamed from: b  reason: collision with root package name */
    private View f2010b;
    private View c;
    private View d;
    private int e;
    private int f;
    private int g;
    private int[] h = new int[2];
    private ViewGroup.LayoutParams i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private float q;
    private float r;
    private Resources s;

    public StatementBehavior() {
    }

    public StatementBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.s = context.getResources();
        this.j = this.s.getDimensionPixelOffset(R.dimen.preference_divider_margin_horizontal) * 2;
        this.m = this.s.getDimensionPixelOffset(R.dimen.preference_line_alpha_range_change_offset);
        this.p = this.s.getDimensionPixelOffset(R.dimen.preference_divider_width_change_offset);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
        if (this.k <= 0) {
            view.getLocationOnScreen(this.h);
            this.k = this.h[1];
            this.c = view3;
            this.f2010b = view.findViewById(R.id.divider_line);
            this.f2009a = this.f2010b.getWidth();
            this.i = this.f2010b.getLayoutParams();
            int i4 = this.k;
            this.l = i4 - this.m;
            this.o = i4 - this.s.getDimensionPixelOffset(R.dimen.preference_divider_width_start_count_offset);
            this.n = this.o - this.p;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        view3.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                StatementBehavior.this.a();
            }
        });
        return false;
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
        if (i3 < this.l) {
            this.f = this.m;
        } else {
            int i4 = this.k;
            if (i3 > i4) {
                this.f = 0;
            } else {
                this.f = i4 - i3;
            }
        }
        this.g = this.f;
        if (this.q <= 1.0f) {
            this.q = ((float) Math.abs(this.g)) / ((float) this.m);
            this.f2010b.setAlpha(this.q);
        }
        int i5 = this.e;
        if (i5 < this.n) {
            this.f = this.p;
        } else {
            int i6 = this.o;
            if (i5 > i6) {
                this.f = 0;
            } else {
                this.f = i6 - i5;
            }
        }
        this.g = this.f;
        this.r = ((float) Math.abs(this.g)) / ((float) this.p);
        ViewGroup.LayoutParams layoutParams = this.i;
        layoutParams.width = (int) (((float) this.f2009a) - (((float) this.j) * (1.0f - this.r)));
        this.f2010b.setLayoutParams(layoutParams);
    }
}
