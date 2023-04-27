package com.oppo.camera.ui.CommonComponent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

public class SlideBar extends View {
    public static final int CENTER_ALIGN = 2;
    private static final float FIRST_CONTROL_POINT_X = 0.0f;
    private static final float FIRST_CONTROL_POINT_Y = 0.0f;
    private static final int FLING_VELOCITY_THRESHOLD = 1000;
    public static final int LEFT_ALIGN = 1;
    private static final int SECOND = 1000;
    private static final float SECOND_CONTROL_POINT_X = 0.58f;
    private static final float SECOND_CONTROL_POINT_Y = 1.0f;
    private static final String TAG = "ScaleBar";
    private static final int TEN_SMALL_SCALE_BETWEEN_BIG_SCALE = 15;
    private static final int VALUE_INT_TWO = 2;
    private static int sBigScaleAlpha = 255;
    private static int sBigScaleColor = 0;
    private static int sPointerAutoColor = 0;
    private static int sPointerScaleColor = 0;
    private static int sSmallScaleAlpha = ((int) (((double) sBigScaleAlpha) * 0.5d));
    private int mAlign = 1;
    private int mBigLineWidthRatio = 6;
    private int mBigScaleStrokeWidth = 0;
    private int mCenterIndex = 0;
    private int mCenterY = 0;
    private int mCenterYOffsetRatio = 4;
    private Context mContext = null;
    private int mCountBetweenBigScale = 15;
    private int mCurrentIndex = 0;
    private float mDownX = 0.0f;
    private FlingRunnable mFlingRunnable = null;
    private int mLayoutWidth = 0;
    private int mLevelNum = 0;
    private int mMaxFlingVelocity = 0;
    private Paint mPaint = null;
    private int mScaleHeight = 0;
    private int mScaleMargin = 30;
    private int mScalePointerHeight = 0;
    private int mScalePointerX = 0;
    /* access modifiers changed from: private */
    public SlideBarValueChangeListener mSlideBarValueChangeListener = null;
    private int mSmallScaleStrokeWidth = 0;
    private int mStartDistanceX = 0;
    private VelocityTracker mVelocityTracker = null;
    private boolean mbAuto = false;
    private boolean mbFilm = false;
    private boolean mbInitIndex = false;
    private boolean mbInitScalePointerX = false;
    private boolean mbValid = true;

    public interface SlideBarValueChangeListener {
        void onActionUp();

        void onBarMoving();

        void onBarScrolling(boolean z);

        void onValueChange(int i);
    }

    public boolean needChangeValue() {
        return false;
    }

    public SlideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public SlideBar(Context context, int i) {
        super(context);
        this.mLevelNum = i;
        this.mContext = context;
        init();
    }

    public SlideBar(Context context, int i, boolean z) {
        super(context);
        this.mLevelNum = i;
        this.mContext = context;
        this.mbFilm = z;
        init();
    }

    private void init() {
        if (this.mLevelNum <= 0) {
            this.mbValid = false;
            return;
        }
        this.mbValid = true;
        Resources resources = this.mContext.getResources();
        this.mBigScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        this.mSmallScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_small_scale_stroke_width);
        this.mScaleMargin = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_margin);
        this.mScaleHeight = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height);
        this.mCenterY = (resources.getDimensionPixelSize(R.dimen.movie_mode_slide_bar_click_height) / 2) - (this.mScaleHeight / this.mCenterYOffsetRatio);
        this.mScalePointerHeight = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_pointer_height);
        this.mBigScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        this.mSmallScaleStrokeWidth = resources.getDimensionPixelSize(R.dimen.professional_mode_scale_bar_small_scale_stroke_width);
        sBigScaleColor = this.mContext.getColor(R.color.camera_white);
        sPointerScaleColor = resources.getColor(R.color.pointer_scale_color);
        sPointerAutoColor = Util.s(getContext());
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(sBigScaleColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth((float) this.mSmallScaleStrokeWidth);
        ViewConfiguration.get(this.mContext);
        this.mMaxFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        int i = this.mLevelNum;
        this.mCenterIndex = i % 2 == 0 ? (i / 2) - 1 : i / 2;
        if (this.mCenterIndex < 0) {
            this.mCenterIndex = 0;
        }
    }

    public void setCurrentIndex(int i) {
        if (i >= 0 && i < this.mLevelNum) {
            this.mCurrentIndex = i;
        }
    }

    public void setLevelNum(int i) {
        e.a(TAG, "setLevelNum, levelNum: " + i);
        this.mLevelNum = i;
        if (this.mbValid) {
            int i2 = this.mLevelNum;
            this.mCenterIndex = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
            return;
        }
        init();
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public void setSlideBarValueChangeListener(SlideBarValueChangeListener slideBarValueChangeListener) {
        this.mSlideBarValueChangeListener = slideBarValueChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (this.mbValid) {
            if (1 == getLayoutDirection()) {
                canvas.scale(-1.0f, 1.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
            } else {
                Canvas canvas2 = canvas;
            }
            this.mPaint.setColor(sBigScaleColor);
            int i3 = this.mCenterY;
            int i4 = (this.mScaleHeight / 2) + i3;
            int i5 = this.mAlign == 2 ? this.mCenterIndex % this.mCountBetweenBigScale : 0;
            for (int i6 = 0; i6 < this.mLevelNum; i6++) {
                float max = ((float) Math.max((this.mLayoutWidth / 2) - ((Math.abs(this.mCurrentIndex - i6) + 1) * this.mScaleMargin), 0)) / ((float) (this.mLayoutWidth / 2));
                if (i6 % this.mCountBetweenBigScale == i5) {
                    this.mPaint.setStrokeWidth((float) this.mSmallScaleStrokeWidth);
                    this.mPaint.setAlpha((int) (((float) sBigScaleAlpha) * max));
                } else {
                    this.mPaint.setStrokeWidth((float) this.mSmallScaleStrokeWidth);
                    this.mPaint.setAlpha((int) (((float) sSmallScaleAlpha) * max));
                }
                int i7 = this.mStartDistanceX;
                int i8 = this.mScaleMargin;
                canvas.drawLine((float) ((i8 * i6) + i7), (float) i4, (float) (i7 + (i8 * i6)), (float) i3, this.mPaint);
            }
            if (!this.mbFilm) {
                int i9 = this.mCenterY;
                int i10 = this.mScaleHeight;
                i = (i10 / 2) + i9;
                i2 = (i9 + (i10 / 2)) - i10;
            } else {
                int i11 = this.mCenterY;
                int i12 = this.mScaleHeight;
                int i13 = this.mBigLineWidthRatio;
                int i14 = i11 - (i12 / i13);
                i2 = i11 + (i12 / 2) + (i12 / i13);
                i = i14;
            }
            if (this.mbAuto) {
                this.mPaint.setColor(sPointerAutoColor);
            } else {
                this.mPaint.setColor(sPointerScaleColor);
            }
            this.mPaint.setAlpha(sBigScaleAlpha);
            this.mPaint.setStrokeWidth((float) this.mBigScaleStrokeWidth);
            int i15 = this.mScalePointerX;
            canvas.drawLine((float) i15, (float) i, (float) i15, (float) i2, this.mPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownX = motionEvent.getX();
            this.mVelocityTracker = VelocityTracker.obtain();
            FlingRunnable flingRunnable = this.mFlingRunnable;
            if (flingRunnable != null) {
                flingRunnable.cancelFling();
                this.mFlingRunnable = null;
            }
        } else if (action == 1) {
            float f = 0.0f;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
                f = this.mVelocityTracker.getXVelocity();
                this.mVelocityTracker.clear();
            }
            if (1000.0f <= Math.abs(f)) {
                if (1 == getLayoutDirection()) {
                    f = -f;
                }
                this.mFlingRunnable = new FlingRunnable(f);
                post(this.mFlingRunnable);
            } else {
                scrollNearbyScale();
                SlideBarValueChangeListener slideBarValueChangeListener = this.mSlideBarValueChangeListener;
                if (slideBarValueChangeListener != null) {
                    slideBarValueChangeListener.onActionUp();
                }
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.mDownX;
            this.mDownX = motionEvent.getX();
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (1 == getLayoutDirection()) {
                onMove(-x);
            } else {
                onMove(x);
            }
        } else if (action == 3) {
            VelocityTracker velocityTracker3 = this.mVelocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.mVelocityTracker = null;
            }
            scrollNearbyScale();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void scrollNearbyScale() {
        int i = this.mStartDistanceX % this.mScaleMargin;
        if (i != 0) {
            int abs = Math.abs(i);
            int i2 = this.mScaleMargin;
            if (abs < i2 / 2) {
                this.mStartDistanceX -= i;
            } else if (i > 0) {
                this.mStartDistanceX = (this.mStartDistanceX - i) + i2;
            } else {
                this.mStartDistanceX = (this.mStartDistanceX - i) - i2;
            }
            updateIndex();
            postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public void onMove(float f) {
        if (!this.mbValid) {
            e.e(TAG, "onMove return, is not valid");
            return;
        }
        this.mStartDistanceX += (int) f;
        int i = this.mStartDistanceX;
        int i2 = this.mScalePointerX;
        if (i >= i2) {
            this.mStartDistanceX = i2;
        } else {
            int i3 = this.mScaleMargin;
            int i4 = this.mLevelNum;
            if (i + ((i4 - 1) * i3) <= i2) {
                this.mStartDistanceX = i2 - (i3 * (i4 - 1));
            }
        }
        updateIndex();
        invalidate();
    }

    private void updateIndex() {
        if (this.mLevelNum != 0) {
            int abs = Math.abs((this.mScalePointerX - this.mStartDistanceX) / this.mScaleMargin) % this.mLevelNum;
            SlideBarValueChangeListener slideBarValueChangeListener = this.mSlideBarValueChangeListener;
            if (!(slideBarValueChangeListener == null || abs == this.mCurrentIndex)) {
                slideBarValueChangeListener.onBarMoving();
                this.mSlideBarValueChangeListener.onValueChange(abs);
            }
            setCurrentIndex(abs);
        }
    }

    public void sliderRight() {
        onMove((float) this.mScaleMargin);
    }

    public void sliderLeft() {
        onMove((float) (-this.mScaleMargin));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mLayoutWidth <= 0) {
            this.mLayoutWidth = getMeasuredWidth();
            int i3 = this.mLayoutWidth / 2;
            this.mScalePointerX = i3 - (i3 % this.mScaleMargin);
            this.mbInitScalePointerX = true;
            if (!this.mbInitIndex) {
                this.mStartDistanceX = 0;
            }
            int i4 = this.mCurrentIndex;
            if (i4 >= 0) {
                initDataIndex(i4);
            }
        }
    }

    public void scrollTo(int i) {
        if (i >= 0 && i < this.mLevelNum) {
            this.mStartDistanceX = this.mScalePointerX - (this.mScaleMargin * i);
            invalidate();
        }
    }

    public void initDataIndex(int i) {
        if (i >= 0 && i < this.mLevelNum) {
            this.mCurrentIndex = i;
            if (this.mbInitScalePointerX) {
                this.mStartDistanceX = this.mScalePointerX - (this.mScaleMargin * i);
                this.mbInitIndex = true;
                invalidate();
            }
        }
    }

    public void setAuto(boolean z) {
        this.mbAuto = z;
        invalidate();
    }

    public void setAlign(int i) {
        if (1 == i || 2 == i) {
            this.mAlign = i;
        }
    }

    private class FlingInterpolator extends PathInterpolator {
        FlingInterpolator() {
            super(0.0f, 0.0f, SlideBar.SECOND_CONTROL_POINT_X, 1.0f);
        }
    }

    private class FlingRunnable implements Runnable {
        private static final int DEFAULT_DURATION = 400;
        private int mDuration = 400;
        private float mDurationReciprocal;
        private int mFrameDuration = 16;
        private Interpolator mInterpolator = new FlingInterpolator();
        private float mLastX;
        private float mMagicVelocityPx = 0.15f;
        private long mStartTime;
        private float mTotalDistance;
        private float mVelocityX;
        private boolean mbFinish = false;

        public FlingRunnable(float f) {
            if (SlideBar.this.mSlideBarValueChangeListener != null) {
                SlideBar.this.mSlideBarValueChangeListener.onBarScrolling(!this.mbFinish);
            }
            this.mLastX = 0.0f;
            int i = this.mDuration;
            this.mDurationReciprocal = 1.0f / ((float) i);
            this.mVelocityX = f;
            this.mTotalDistance = ((((float) i) * this.mVelocityX) / 1000.0f) * this.mMagicVelocityPx;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        }

        public void cancelFling() {
            this.mbFinish = true;
            if (SlideBar.this.mSlideBarValueChangeListener != null) {
                SlideBar.this.mSlideBarValueChangeListener.onBarScrolling(true ^ this.mbFinish);
            }
        }

        public void run() {
            if (!this.mbFinish) {
                int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
                float interpolation = this.mInterpolator.getInterpolation(((float) currentAnimationTimeMillis) * this.mDurationReciprocal);
                float f = (interpolation - this.mLastX) * this.mTotalDistance;
                this.mLastX = interpolation;
                int i = this.mDuration;
                if (currentAnimationTimeMillis < i) {
                    SlideBar.this.onMove(f);
                    SlideBar.this.postDelayed(this, (long) this.mFrameDuration);
                } else if (currentAnimationTimeMillis >= i) {
                    this.mLastX = 0.0f;
                    SlideBar.this.scrollNearbyScale();
                    this.mbFinish = true;
                    if (SlideBar.this.mSlideBarValueChangeListener != null) {
                        SlideBar.this.mSlideBarValueChangeListener.onBarScrolling(true ^ this.mbFinish);
                    }
                }
            }
        }
    }
}
