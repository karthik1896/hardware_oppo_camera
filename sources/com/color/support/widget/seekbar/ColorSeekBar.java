package com.color.support.widget.seekbar;

import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.g.v;
import color.support.v7.appcompat.R;
import com.a.a.f;
import com.a.a.g;
import com.a.a.h;
import com.a.a.j;
import com.color.support.d.d;
import com.color.support.d.n;
import com.oppo.exif.OppoExifTag;
import java.util.List;

public class ColorSeekBar extends View {
    private static final int DAMPING_DISTANCE = 20;
    private static final int DIRECTION_180 = 180;
    private static final int DIRECTION_360 = 360;
    private static final int DIRECTION_90 = 90;
    public static final int MOVE_BY_DEFAULT = 0;
    public static final int MOVE_BY_FINGER = 1;
    private static final int TOUCH_ANIM_DURATION = 150;
    private final String TAG;
    private a mAccessibilityEventSender;
    private ValueAnimator mAnimator;
    private ColorStateList mBackgroundColor;
    private int mBackgroundHighlightColor;
    private float mBackgroundRadius;
    private RectF mBackgroundRect;
    private int mCurBackgroundColor;
    /* access modifiers changed from: private */
    public float mCurBackgroundRadius;
    /* access modifiers changed from: private */
    public float mCurProgressRadius;
    /* access modifiers changed from: private */
    public float mCurThumbInRadius;
    /* access modifiers changed from: private */
    public float mCurThumbOutRadius;
    /* access modifiers changed from: private */
    public int mCurThumbShadowRadius;
    private c mExploreByTouchHelper;
    /* access modifiers changed from: private */
    public float mFastMoveScaleOffsetX;
    private final f mFastMoveSpring;
    private g mFastMoveSpringConfig;
    private boolean mIsDragging;
    private boolean mIsStartFromMiddle;
    private float mLastX;
    private AccessibilityManager mManager;
    /* access modifiers changed from: private */
    public int mMax;
    private int mMoveType;
    private b mOnSeekBarChangeListener;
    private Paint mPaint;
    /* access modifiers changed from: private */
    public int mProgress;
    private ColorStateList mProgressColor;
    private float mProgressRadius;
    private RectF mProgressRect;
    private float mProgressScaleRadius;
    private int mSecondaryProgress;
    private ColorStateList mSecondaryProgressColor;
    private RectF mSecondaryProgressRect;
    private final com.a.a.b mSpringSystem;
    private boolean mStartDragging;
    private RectF mTempRect;
    private ColorStateList mThumbColor;
    /* access modifiers changed from: private */
    public float mThumbInRadius;
    /* access modifiers changed from: private */
    public float mThumbOutRadius;
    /* access modifiers changed from: private */
    public float mThumbScaleInRadius;
    /* access modifiers changed from: private */
    public float mThumbScaleOutRadius;
    private int mThumbShadowColor;
    private int mThumbShadowRadius;
    private AnimatorSet mTouchAnimator;
    private float mTouchDownX;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public interface b {
        void a(ColorSeekBar colorSeekBar);

        void a(ColorSeekBar colorSeekBar, int i, boolean z);

        void b(ColorSeekBar colorSeekBar);
    }

    public ColorSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorSeekBarStyle);
    }

    public ColorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = getClass().getSimpleName();
        this.mTouchSlop = 0;
        this.mProgress = 0;
        this.mSecondaryProgress = 0;
        this.mMax = 100;
        this.mIsDragging = false;
        this.mStartDragging = false;
        this.mBackgroundRect = new RectF();
        this.mProgressRect = new RectF();
        this.mSecondaryProgressRect = new RectF();
        this.mTempRect = new RectF();
        this.mTouchAnimator = new AnimatorSet();
        this.mSpringSystem = j.c();
        this.mFastMoveSpring = this.mSpringSystem.b();
        this.mFastMoveSpringConfig = g.a(500.0d, 30.0d);
        this.mIsStartFromMiddle = false;
        d.a(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorSeekBar, i, 0);
        this.mThumbColor = obtainStyledAttributes.getColorStateList(R.styleable.ColorSeekBar_colorSeekBarThumbColor);
        this.mThumbInRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSeekBar_colorSeekBarThumbInRadius, (int) dpToPx(4.0f));
        this.mThumbScaleInRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSeekBar_colorSeekBarThumbInScaleRadius, (int) dpToPx(3.67f));
        this.mThumbOutRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSeekBar_colorSeekBarThumbOutRadius, (int) dpToPx(6.0f));
        this.mThumbScaleOutRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSeekBar_colorSeekBarThumbOutScaleRadius, (int) dpToPx(7.0f));
        this.mProgressScaleRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSeekBar_colorSeekBarProgressScaleRadius, (int) dpToPx(2.0f));
        if (Build.VERSION.SDK_INT >= 23) {
            this.mProgressColor = obtainStyledAttributes.getColorStateList(R.styleable.ColorSeekBar_colorSeekBarProgressColor);
        } else {
            this.mProgressColor = n.a(com.color.support.d.c.a(context, R.attr.colorTintControlNormal, 0), getResources().getColor(R.color.color_seekbar_progress_color_disabled));
        }
        this.mProgressRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSeekBar_colorSeekBarProgressRadius, (int) dpToPx(1.0f));
        this.mBackgroundColor = obtainStyledAttributes.getColorStateList(R.styleable.ColorSeekBar_colorSeekBarBackgroundColor);
        this.mBackgroundRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSeekBar_colorSeekBarBackgroundRadius, (int) dpToPx(1.0f));
        this.mSecondaryProgressColor = obtainStyledAttributes.getColorStateList(R.styleable.ColorSeekBar_colorSeekBarSecondaryProgressColor);
        this.mBackgroundHighlightColor = obtainStyledAttributes.getColor(R.styleable.ColorSeekBar_colorSeekBarBackgroundHighlightColor, getResources().getColor(R.color.color_seekbar_background_highlight_color));
        this.mThumbShadowColor = obtainStyledAttributes.getColor(R.styleable.ColorSeekBar_colorSeekBarThumbShadowColor, getResources().getColor(R.color.color_seekbar_thumb_shadow_color));
        this.mThumbShadowRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ColorSeekBar_colorSeekBarThumbShadowRadius, (int) dpToPx(14.0f));
        obtainStyledAttributes.recycle();
        initView();
        ensureThumb();
        initAnimation();
    }

    private void ensureThumb() {
        this.mCurProgressRadius = this.mProgressRadius;
        this.mCurThumbInRadius = this.mThumbInRadius;
        this.mCurThumbOutRadius = this.mThumbOutRadius;
        this.mCurBackgroundRadius = this.mBackgroundRadius;
        this.mCurThumbShadowRadius = 0;
    }

    private void initView() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mExploreByTouchHelper = new c(this);
        v.a((View) this, (androidx.core.g.a) this.mExploreByTouchHelper);
        if (Build.VERSION.SDK_INT >= 16) {
            v.b((View) this, 1);
        }
        this.mExploreByTouchHelper.invalidateRoot();
        this.mManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
    }

    private void initAnimation() {
        this.mFastMoveSpring.a(this.mFastMoveSpringConfig);
        this.mFastMoveSpring.a((h) new h() {
            public void b(f fVar) {
            }

            public void c(f fVar) {
            }

            public void d(f fVar) {
            }

            public void a(f fVar) {
                if (((double) ColorSeekBar.this.mFastMoveScaleOffsetX) != fVar.d()) {
                    float unused = ColorSeekBar.this.mFastMoveScaleOffsetX = (float) fVar.c();
                    ColorSeekBar.this.invalidate();
                }
            }
        });
        this.mTouchAnimator.setInterpolator(androidx.core.g.b.b.a(0.3f, 0.0f, 0.1f, 1.0f));
        float f = this.mBackgroundRadius;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f * 2.0f});
        ofFloat.setDuration(115);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = ColorSeekBar.this.mCurBackgroundRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float unused2 = ColorSeekBar.this.mCurProgressRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ColorSeekBar colorSeekBar = ColorSeekBar.this;
                float unused3 = colorSeekBar.mCurThumbInRadius = colorSeekBar.mThumbInRadius + (((ColorSeekBar.this.mThumbInRadius * 1.417f) - ColorSeekBar.this.mThumbInRadius) * animatedFraction);
                ColorSeekBar colorSeekBar2 = ColorSeekBar.this;
                float unused4 = colorSeekBar2.mCurThumbOutRadius = colorSeekBar2.mThumbOutRadius + (animatedFraction * ((ColorSeekBar.this.mThumbOutRadius * 1.722f) - ColorSeekBar.this.mThumbOutRadius));
                ColorSeekBar.this.invalidate();
            }
        });
        float f2 = this.mBackgroundRadius;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{2.0f * f2, f2});
        ofFloat2.setStartDelay(115);
        ofFloat2.setDuration(87);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                ColorSeekBar colorSeekBar = ColorSeekBar.this;
                float f = 1.0f - animatedFraction;
                float unused = colorSeekBar.mCurThumbInRadius = colorSeekBar.mThumbScaleInRadius + (((ColorSeekBar.this.mThumbInRadius * 1.417f) - ColorSeekBar.this.mThumbScaleInRadius) * f);
                ColorSeekBar colorSeekBar2 = ColorSeekBar.this;
                float unused2 = colorSeekBar2.mCurThumbOutRadius = colorSeekBar2.mThumbScaleOutRadius + (f * ((ColorSeekBar.this.mThumbOutRadius * 1.722f) - ColorSeekBar.this.mThumbScaleOutRadius));
                ColorSeekBar.this.invalidate();
            }
        });
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.mThumbShadowRadius});
        ofInt.setDuration(202);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = ColorSeekBar.this.mCurThumbShadowRadius = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.mTouchAnimator.play(ofFloat).with(ofFloat2).with(ofInt);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        initAnimation();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int round = Math.round((float) (this.mThumbShadowRadius * 2)) + getPaddingTop() + getPaddingBottom();
        if (1073741824 != mode || size < round) {
            size = round;
        }
        setMeasuredDimension(size2, size);
    }

    private int getStart() {
        return getPaddingLeft();
    }

    private int getEnd() {
        return getPaddingRight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Canvas canvas2 = canvas;
        this.mPaint.setColor(a.a((View) this, this.mBackgroundColor));
        float start = ((float) (getStart() + this.mThumbShadowRadius)) - this.mBackgroundRadius;
        float width = ((float) ((getWidth() - getEnd()) - this.mThumbShadowRadius)) + this.mBackgroundRadius;
        float width2 = (float) (((getWidth() - getEnd()) - (this.mThumbShadowRadius * 2)) - getStart());
        this.mBackgroundRect.set(start, ((float) (getHeight() >> 1)) - this.mCurBackgroundRadius, width, ((float) (getHeight() >> 1)) + this.mCurBackgroundRadius);
        RectF rectF = this.mBackgroundRect;
        float f6 = this.mCurBackgroundRadius;
        canvas2.drawRoundRect(rectF, f6, f6, this.mPaint);
        if (this.mIsStartFromMiddle) {
            if (isLayoutRtl()) {
                float width3 = ((float) getWidth()) / 2.0f;
                int i = this.mMax;
                f2 = width3 - (((((float) this.mProgress) - (((float) i) / 2.0f)) * width2) / ((float) i));
                f = f2;
                f3 = width3;
                f5 = f3;
                f4 = f;
            } else {
                f4 = ((float) getWidth()) / 2.0f;
                int i2 = this.mMax;
                f5 = f4 + (((((float) this.mProgress) - (((float) i2) / 2.0f)) * width2) / ((float) i2));
                f3 = f5;
                f = f3;
                f2 = f4;
            }
        } else if (isLayoutRtl()) {
            f4 = ((float) (getStart() + this.mThumbShadowRadius)) + width2;
            int i3 = this.mMax;
            f5 = f4 - ((((float) this.mSecondaryProgress) * width2) / ((float) i3));
            f2 = f4;
            f3 = f4 - ((((float) this.mProgress) * width2) / ((float) i3));
            f = f3;
        } else {
            float start2 = (float) (getStart() + this.mThumbShadowRadius);
            int i4 = this.mMax;
            f3 = start2;
            f2 = ((((float) this.mProgress) * width2) / ((float) i4)) + start2;
            f = f2;
            f4 = start2 + ((((float) this.mSecondaryProgress) * width2) / ((float) i4));
            f5 = f3;
        }
        this.mPaint.setColor(a.a(this, this.mSecondaryProgressColor, a.c));
        this.mSecondaryProgressRect.set(f5, this.mBackgroundRect.top, f4, this.mBackgroundRect.bottom);
        canvas2.drawRect(this.mSecondaryProgressRect, this.mPaint);
        if (!this.mIsStartFromMiddle) {
            if (isLayoutRtl()) {
                this.mTempRect.set(width - (this.mBackgroundRadius * 2.0f), this.mBackgroundRect.top, width, this.mBackgroundRect.bottom);
                canvas.drawArc(this.mTempRect, -90.0f, 180.0f, true, this.mPaint);
                if (this.mSecondaryProgress == this.mMax) {
                    this.mTempRect.set(start, this.mBackgroundRect.top, (this.mBackgroundRadius * 2.0f) + start, this.mBackgroundRect.bottom);
                    canvas.drawArc(this.mTempRect, 90.0f, 180.0f, true, this.mPaint);
                }
            } else {
                this.mTempRect.set(start, this.mBackgroundRect.top, (this.mBackgroundRadius * 2.0f) + start, this.mBackgroundRect.bottom);
                canvas.drawArc(this.mTempRect, 90.0f, 180.0f, true, this.mPaint);
                if (this.mSecondaryProgress == this.mMax) {
                    this.mTempRect.set(width - (this.mBackgroundRadius * 2.0f), this.mBackgroundRect.top, width, this.mBackgroundRect.bottom);
                    canvas.drawArc(this.mTempRect, -90.0f, 180.0f, true, this.mPaint);
                }
            }
        }
        this.mPaint.setColor(a.a(this, this.mProgressColor, a.f2275b));
        this.mProgressRect.set(f3, ((float) (getHeight() >> 1)) - this.mCurProgressRadius, f2, ((float) (getHeight() >> 1)) + this.mCurProgressRadius);
        canvas2.drawRect(this.mProgressRect, this.mPaint);
        if (!this.mIsStartFromMiddle) {
            if (isLayoutRtl()) {
                this.mTempRect.set((width - this.mBackgroundRadius) - this.mCurProgressRadius, this.mProgressRect.top, (width - this.mBackgroundRadius) + this.mCurProgressRadius, this.mProgressRect.bottom);
                canvas.drawArc(this.mTempRect, -90.0f, 180.0f, true, this.mPaint);
            } else {
                this.mTempRect.set(f3 - this.mCurProgressRadius, this.mProgressRect.top, f3 + this.mCurProgressRadius, this.mProgressRect.bottom);
                canvas.drawArc(this.mTempRect, 90.0f, 180.0f, true, this.mPaint);
            }
        } else if (isLayoutRtl()) {
            this.mTempRect.set(f3 - this.mCurProgressRadius, this.mProgressRect.top, f3 + this.mCurProgressRadius, this.mProgressRect.bottom);
            canvas.drawArc(this.mTempRect, -90.0f, 360.0f, true, this.mPaint);
        } else {
            this.mTempRect.set(f2 - this.mCurProgressRadius, this.mProgressRect.top, f2 + this.mCurProgressRadius, this.mProgressRect.bottom);
            canvas.drawArc(this.mTempRect, 90.0f, 360.0f, true, this.mPaint);
        }
        int i5 = this.mCurThumbShadowRadius;
        float f7 = f - ((float) i5);
        float f8 = ((float) i5) + f;
        float f9 = this.mCurThumbInRadius;
        float f10 = f - f9;
        float f11 = f9 + f;
        float f12 = this.mCurThumbOutRadius;
        float f13 = f - f12;
        float f14 = f + f12;
        float f15 = this.mFastMoveScaleOffsetX;
        float f16 = this.mThumbScaleInRadius * 2.0f * 2.0f * f15;
        if (f15 > 0.0f) {
            f7 -= f16;
            f10 -= f16;
            f13 -= f16;
        } else {
            f8 -= f16;
            f11 -= f16;
            f14 -= f16;
        }
        float f17 = f11;
        float f18 = f10;
        float f19 = f13;
        this.mPaint.setColor(this.mThumbShadowColor);
        float height = (float) ((getHeight() >> 1) - this.mCurThumbShadowRadius);
        int i6 = this.mCurThumbShadowRadius;
        canvas.drawRoundRect(f7, height, f8, (float) ((getHeight() >> 1) + i6), (float) i6, (float) i6, this.mPaint);
        this.mPaint.setColor(a.a(this, this.mProgressColor, a.f2275b));
        float f20 = this.mCurThumbOutRadius;
        canvas.drawRoundRect(f19, ((float) (getHeight() >> 1)) - this.mCurThumbOutRadius, f14, ((float) (getHeight() >> 1)) + f20, f20, f20, this.mPaint);
        this.mPaint.setColor(a.a(this, this.mThumbColor, -1));
        float f21 = this.mCurThumbInRadius;
        canvas.drawRoundRect(f18, ((float) (getHeight() >> 1)) - this.mCurThumbInRadius, f17, ((float) (getHeight() >> 1)) + f21, f21, f21, this.mPaint);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r0 != 3) goto L_0x00d4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r6.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x00b9
            if (r0 == r2) goto L_0x0094
            r3 = 2
            if (r0 == r3) goto L_0x0019
            r3 = 3
            if (r0 == r3) goto L_0x0094
            goto L_0x00d4
        L_0x0019:
            android.view.VelocityTracker r0 = r5.mVelocityTracker
            r0.addMovement(r6)
            int r0 = r5.getWidth()
            int r4 = r5.getEnd()
            int r0 = r0 - r4
            int r4 = r5.mThumbShadowRadius
            int r4 = r4 * r3
            int r0 = r0 - r4
            int r3 = r5.getStart()
            int r0 = r0 - r3
            float r0 = (float) r0
            int r3 = r5.mProgress
            float r3 = (float) r3
            float r3 = r3 * r0
            int r4 = r5.mMax
            float r4 = (float) r4
            float r3 = r3 / r4
            boolean r4 = r5.mIsStartFromMiddle
            if (r4 == 0) goto L_0x0057
            r4 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r4
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0057
            float r0 = r6.getX()
            float r3 = r5.mLastX
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            r3 = 1101004800(0x41a00000, float:20.0)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0057
            goto L_0x00d4
        L_0x0057:
            boolean r0 = r5.mIsDragging
            if (r0 == 0) goto L_0x006e
            boolean r0 = r5.mStartDragging
            if (r0 == 0) goto L_0x006e
            int r0 = r5.mMoveType
            if (r0 == 0) goto L_0x006a
            if (r0 == r2) goto L_0x0066
            goto L_0x00d4
        L_0x0066:
            r5.trackTouchEventByFinger(r6)
            goto L_0x00d4
        L_0x006a:
            r5.trackTouchEvent(r6)
            goto L_0x00d4
        L_0x006e:
            boolean r0 = com.color.support.widget.seekbar.a.a((android.view.MotionEvent) r6, (android.view.View) r5)
            if (r0 != 0) goto L_0x0075
            return r1
        L_0x0075:
            float r0 = r6.getX()
            float r1 = r5.mTouchDownX
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r3 = r5.mTouchSlop
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x00d4
            r5.startDrag(r6)
            r5.invalidateProgress(r6)
            r5.touchAnim()
            r5.mLastX = r0
            goto L_0x00d4
        L_0x0094:
            com.a.a.f r0 = r5.mFastMoveSpring
            r3 = 0
            r0.b(r3)
            boolean r0 = r5.mIsDragging
            if (r0 == 0) goto L_0x00a6
            r5.onStopTrackingTouch()
            r5.setPressed(r1)
            goto L_0x00b5
        L_0x00a6:
            boolean r0 = com.color.support.widget.seekbar.a.a((android.view.MotionEvent) r6, (android.view.View) r5)
            if (r0 == 0) goto L_0x00b5
            r5.onStartTrackingTouch()
            r5.invalidateProgress(r6)
            r5.onStopTrackingTouch()
        L_0x00b5:
            r5.releaseAnim()
            goto L_0x00d4
        L_0x00b9:
            r5.mIsDragging = r1
            r5.mStartDragging = r1
            float r0 = r6.getX()
            r5.mTouchDownX = r0
            float r0 = r6.getX()
            r5.mLastX = r0
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r5.mVelocityTracker = r0
            android.view.VelocityTracker r0 = r5.mVelocityTracker
            r0.addMovement(r6)
        L_0x00d4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.seekbar.ColorSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void invalidateProgress(MotionEvent motionEvent) {
        b bVar;
        int i = this.mProgress;
        float width = (float) (((getWidth() - getEnd()) - (this.mThumbShadowRadius * 2)) - getStart());
        if (isLayoutRtl()) {
            int i2 = this.mMax;
            this.mProgress = i2 - Math.round((((float) i2) * ((motionEvent.getX() - ((float) getStart())) - this.mProgressScaleRadius)) / width);
        } else {
            this.mProgress = Math.round((((float) this.mMax) * ((motionEvent.getX() - ((float) getStart())) - this.mProgressScaleRadius)) / width);
        }
        this.mProgress = getProgressLimit(this.mProgress);
        int i3 = this.mProgress;
        if (!(i == i3 || (bVar = this.mOnSeekBarChangeListener) == null)) {
            bVar.a(this, i3, true);
        }
        invalidate();
    }

    private void startDrag(MotionEvent motionEvent) {
        setPressed(true);
        onStartTrackingTouch();
        attemptClaimDrag();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mStartDragging = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trackTouchEventByFinger(android.view.MotionEvent r6) {
        /*
            r5 = this;
            float r0 = r6.getX()
            int r0 = java.lang.Math.round(r0)
            float r6 = r6.getY()
            java.lang.Math.round(r6)
            int r6 = r5.getWidth()
            int r1 = r5.getEnd()
            int r1 = r6 - r1
            float r1 = (float) r1
            float r2 = r5.mProgressScaleRadius
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 * r3
            float r1 = r1 - r2
            int r2 = r5.getStart()
            float r2 = (float) r2
            float r1 = r1 - r2
            int r1 = java.lang.Math.round(r1)
            boolean r2 = r5.isLayoutRtl()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r2 == 0) goto L_0x004a
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            if (r0 <= r6) goto L_0x003b
            goto L_0x0050
        L_0x003b:
            int r6 = r5.getPaddingLeft()
            if (r0 >= r6) goto L_0x0042
            goto L_0x0064
        L_0x0042:
            int r6 = r1 - r0
            int r2 = r5.getPaddingLeft()
            int r6 = r6 + r2
            goto L_0x0060
        L_0x004a:
            int r2 = r5.getPaddingLeft()
            if (r0 >= r2) goto L_0x0052
        L_0x0050:
            r3 = r4
            goto L_0x0064
        L_0x0052:
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            if (r0 <= r6) goto L_0x005a
            goto L_0x0064
        L_0x005a:
            int r6 = r5.getPaddingLeft()
            int r6 = r0 - r6
        L_0x0060:
            float r6 = (float) r6
            float r1 = (float) r1
            float r3 = r6 / r1
        L_0x0064:
            int r6 = r5.getMax()
            float r6 = (float) r6
            float r3 = r3 * r6
            float r4 = r4 + r3
            int r6 = r5.mProgress
            int r1 = java.lang.Math.round(r4)
            int r1 = r5.getProgressLimit(r1)
            r5.mProgress = r1
            r5.invalidate()
            int r1 = r5.mProgress
            if (r6 == r1) goto L_0x0089
            float r6 = (float) r0
            r5.mLastX = r6
            com.color.support.widget.seekbar.ColorSeekBar$b r6 = r5.mOnSeekBarChangeListener
            if (r6 == 0) goto L_0x0089
            r0 = 1
            r6.a(r5, r1, r0)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.seekbar.ColorSeekBar.trackTouchEventByFinger(android.view.MotionEvent):void");
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float f = x - this.mLastX;
        if (isLayoutRtl()) {
            f = -f;
        }
        int progressLimit = getProgressLimit(this.mProgress + Math.round((f / ((float) (((getWidth() - getEnd()) - (this.mThumbShadowRadius * 2)) - getStart()))) * ((float) this.mMax)));
        int i = this.mProgress;
        this.mProgress = progressLimit;
        invalidate();
        int i2 = this.mProgress;
        if (i != i2) {
            this.mLastX = x;
            b bVar = this.mOnSeekBarChangeListener;
            if (bVar != null) {
                bVar.a(this, i2, true);
            }
        }
        this.mVelocityTracker.computeCurrentVelocity(100);
        startFastMoveAnimation(this.mVelocityTracker.getXVelocity());
    }

    private void startFastMoveAnimation(float f) {
        if (f >= 95.0f) {
            this.mFastMoveSpring.b(1.0d);
        } else if (f <= -95.0f) {
            this.mFastMoveSpring.b(-1.0d);
        } else {
            this.mFastMoveSpring.b(0.0d);
        }
    }

    private void attemptClaimDrag() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).requestDisallowInterceptTouchEvent(true);
        }
    }

    private float dpToPx(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private int getProgressLimit(int i) {
        return Math.max(0, Math.min(i, this.mMax));
    }

    /* access modifiers changed from: package-private */
    public void onStartTrackingTouch() {
        this.mIsDragging = true;
        this.mStartDragging = true;
        b bVar = this.mOnSeekBarChangeListener;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    private void touchAnim() {
        if (this.mTouchAnimator.isRunning()) {
            this.mTouchAnimator.cancel();
        }
        this.mTouchAnimator.start();
    }

    private void releaseAnim() {
        if (this.mAnimator == null) {
            this.mAnimator = new ValueAnimator();
        }
        this.mTouchAnimator.cancel();
        this.mAnimator.cancel();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("radiusIn", new float[]{this.mCurThumbInRadius, this.mThumbInRadius});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("radiusOut", new float[]{this.mCurThumbOutRadius, this.mThumbOutRadius});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("progress", new float[]{this.mCurProgressRadius, this.mProgressRadius});
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("thumbShadowRadius", new int[]{this.mCurThumbShadowRadius, 0});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("backgroundRadius", new float[]{this.mCurBackgroundRadius, this.mBackgroundRadius});
        this.mAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofInt, ofFloat4});
        this.mAnimator.setDuration(120);
        if (Build.VERSION.SDK_INT > 21) {
            this.mAnimator.setInterpolator(androidx.core.g.b.b.a(0.0f, 0.0f, 0.2f, 1.0f));
        }
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = ColorSeekBar.this.mCurProgressRadius = ((Float) valueAnimator.getAnimatedValue("progress")).floatValue();
                float unused2 = ColorSeekBar.this.mCurThumbInRadius = ((Float) valueAnimator.getAnimatedValue("radiusIn")).floatValue();
                float unused3 = ColorSeekBar.this.mCurThumbOutRadius = ((Float) valueAnimator.getAnimatedValue("radiusOut")).floatValue();
                int unused4 = ColorSeekBar.this.mCurThumbShadowRadius = ((Integer) valueAnimator.getAnimatedValue("thumbShadowRadius")).intValue();
                float unused5 = ColorSeekBar.this.mCurBackgroundRadius = ((Float) valueAnimator.getAnimatedValue("backgroundRadius")).floatValue();
                ColorSeekBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    /* access modifiers changed from: package-private */
    public void onStopTrackingTouch() {
        this.mIsDragging = false;
        this.mStartDragging = false;
        b bVar = this.mOnSeekBarChangeListener;
        if (bVar != null) {
            bVar.b(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a aVar = this.mAccessibilityEventSender;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        super.onDetachedFromWindow();
    }

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorSeekBar f2271a;

        public void run() {
            if (Build.VERSION.SDK_INT >= 16) {
                ColorSeekBar colorSeekBar = this.f2271a;
                colorSeekBar.announceForAccessibility(this.f2271a.mProgress + "");
            }
        }
    }

    private final class c extends androidx.customview.a.a {

        /* renamed from: b  reason: collision with root package name */
        private Rect f2273b = new Rect();

        public c(View view) {
            super(view);
        }

        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.g.a.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (ColorSeekBar.this.isEnabled()) {
                int progress = ColorSeekBar.this.getProgress();
                if (progress > 0) {
                    dVar.a((int) OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION);
                }
                if (progress < ColorSeekBar.this.getMax()) {
                    dVar.a(4096);
                }
            }
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f, float f2) {
            return (f < 0.0f || f > ((float) ColorSeekBar.this.getWidth()) || f2 < 0.0f || f2 > ((float) ColorSeekBar.this.getHeight())) ? -1 : 0;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 0; i < 1; i++) {
                list.add(Integer.valueOf(i));
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(getClass().getSimpleName());
            accessibilityEvent.setItemCount(ColorSeekBar.this.mMax);
            accessibilityEvent.setCurrentItemIndex(ColorSeekBar.this.mProgress);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i, androidx.core.g.a.d dVar) {
            dVar.e((CharSequence) ColorSeekBar.this.mProgress + "");
            dVar.b((CharSequence) ColorSeekBar.class.getName());
            dVar.b(a(i));
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            sendEventForVirtualView(i, 4);
            return false;
        }

        private Rect a(int i) {
            Rect rect = this.f2273b;
            rect.left = 0;
            rect.top = 0;
            rect.right = ColorSeekBar.this.getWidth();
            rect.bottom = ColorSeekBar.this.getHeight();
            return rect;
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.mExploreByTouchHelper.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
    }

    public void setProgress(int i) {
        b bVar;
        if (i >= 0) {
            int i2 = this.mProgress;
            this.mProgress = Math.max(0, Math.min(i, this.mMax));
            int i3 = this.mProgress;
            if (!(i2 == i3 || (bVar = this.mOnSeekBarChangeListener) == null)) {
                bVar.a(this, i3, false);
            }
            invalidate();
        }
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getMax() {
        return this.mMax;
    }

    public void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.mMax) {
            this.mMax = i;
            if (this.mProgress > i) {
                this.mProgress = i;
            }
        }
        invalidate();
    }

    public void setOnSeekBarChangeListener(b bVar) {
        this.mOnSeekBarChangeListener = bVar;
    }

    public void setSecondaryProgress(int i) {
        if (i >= 0) {
            this.mSecondaryProgress = Math.max(0, Math.min(i, this.mMax));
            invalidate();
        }
    }

    public int getSecondaryProgress() {
        return this.mSecondaryProgress;
    }

    public boolean isLayoutRtl() {
        if (Build.VERSION.SDK_INT <= 16 || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    public void setMoveType(int i) {
        this.mMoveType = i;
    }

    public void setStartFromMiddle(boolean z) {
        this.mIsStartFromMiddle = z;
    }
}
