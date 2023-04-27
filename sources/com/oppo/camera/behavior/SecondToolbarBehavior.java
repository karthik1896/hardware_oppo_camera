package com.oppo.camera.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import color.support.design.widget.ColorAppBarLayout;
import com.oppo.camera.R;

public class SecondToolbarBehavior extends CoordinatorLayout.b<ColorAppBarLayout> implements AbsListView.OnScrollListener {
    private View mChild;
    private int mCurrentOffset;
    private View mDivider;
    private int mDividerAlphaChangeEndY;
    private int mDividerAlphaChangeOffset;
    private float mDividerAlphaRange;
    private int mDividerInitWidth;
    private ViewGroup.LayoutParams mDividerParams;
    private int mDividerWidthChangeEndY;
    private int mDividerWidthChangeInitY;
    private int mDividerWidthChangeOffset;
    private float mDividerWidthRange;
    private int mListFirstChildInitY;
    private int[] mLocation = new int[2];
    private int mLocationY;
    private int mMarginLeftRight;
    private int mMaxWidth;
    private int mNewOffset;
    private Resources mResources;
    private View mScrollView;

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public SecondToolbarBehavior() {
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mResources = context.getResources();
        this.mMarginLeftRight = this.mResources.getDimensionPixelOffset(R.dimen.common_margin) * 2;
        this.mDividerAlphaChangeOffset = this.mResources.getDimensionPixelOffset(R.dimen.line_alpha_range_change_offset);
        this.mDividerWidthChangeOffset = this.mResources.getDimensionPixelOffset(R.dimen.divider_width_change_offset);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, ColorAppBarLayout colorAppBarLayout, View view, View view2, int i, int i2) {
        if ((i & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= colorAppBarLayout.getHeight()) {
            if (this.mListFirstChildInitY <= 0) {
                this.mListFirstChildInitY = colorAppBarLayout.getMeasuredHeight();
                this.mScrollView = view2;
                this.mDivider = colorAppBarLayout.findViewById(R.id.divider_line);
                this.mDividerInitWidth = this.mDivider.getWidth();
                this.mDividerParams = this.mDivider.getLayoutParams();
                this.mMaxWidth = colorAppBarLayout.getMeasuredWidth();
                this.mDividerAlphaChangeEndY = this.mListFirstChildInitY - this.mDividerAlphaChangeOffset;
                this.mDividerWidthChangeInitY = this.mListFirstChildInitY - this.mResources.getDimensionPixelOffset(R.dimen.divider_width_start_count_offset);
                this.mDividerWidthChangeEndY = this.mDividerWidthChangeInitY - this.mDividerWidthChangeOffset;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                view2.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                    public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                        SecondToolbarBehavior.this.onListScroll();
                    }
                });
            } else if (view2 instanceof AbsListView) {
                ((AbsListView) view2).setOnScrollListener(this);
            }
        }
        return false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        onListScroll();
    }

    /* access modifiers changed from: private */
    public void onListScroll() {
        this.mChild = null;
        View view = this.mScrollView;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i = 0;
                while (true) {
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    } else if (viewGroup.getChildAt(i).getVisibility() == 0) {
                        this.mChild = viewGroup.getChildAt(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (this.mChild == null) {
            this.mChild = this.mScrollView;
        }
        this.mChild.getLocationOnScreen(this.mLocation);
        this.mLocationY = this.mLocation[1];
        this.mNewOffset = 0;
        int i2 = this.mLocationY;
        if (i2 < this.mDividerAlphaChangeEndY) {
            this.mNewOffset = this.mDividerAlphaChangeOffset;
        } else {
            int i3 = this.mListFirstChildInitY;
            if (i2 > i3) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i3 - i2;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        if (this.mDividerAlphaRange <= 1.0f) {
            this.mDividerAlphaRange = ((float) Math.abs(this.mCurrentOffset)) / ((float) this.mDividerAlphaChangeOffset);
            this.mDivider.setAlpha(this.mDividerAlphaRange);
        }
        int i4 = this.mLocationY;
        if (i4 < this.mDividerWidthChangeEndY) {
            this.mNewOffset = this.mDividerWidthChangeOffset;
        } else {
            int i5 = this.mDividerWidthChangeInitY;
            if (i4 > i5) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i5 - i4;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        this.mDividerWidthRange = ((float) Math.abs(this.mCurrentOffset)) / ((float) this.mDividerWidthChangeOffset);
        ViewGroup.LayoutParams layoutParams = this.mDividerParams;
        layoutParams.width = (int) (((float) this.mDividerInitWidth) + (((float) this.mMarginLeftRight) * this.mDividerWidthRange));
        this.mDivider.setLayoutParams(layoutParams);
    }
}
