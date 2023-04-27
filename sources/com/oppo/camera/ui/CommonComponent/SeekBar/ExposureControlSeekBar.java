package com.oppo.camera.ui.CommonComponent.SeekBar;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

public class ExposureControlSeekBar extends View {
    private static final int BAR_WIDTH = 3;
    public static final float DEFAULT_PROGRESS = 0.5f;
    private static final int DRAWABLE_GAP = 8;
    private static final int EXPOSURE_ANIMATION_DURATION = 250;
    public static final int MAX_VALUE = 100;
    public static final String TAG = "ExposureControlSeekBar";
    private Drawable mBottomDrawable;
    private Context mContext;
    private int mExporebarHeight;
    private Paint mLinePaint;
    private Path mLinePath;
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    private int mOrientation;
    private float mValue;
    private float mXCoordinate;
    private boolean mbShowBar;

    public interface OnSeekBarChangeListener {
        void onOrientationChange(int i);

        void onProgressChange(float f);

        void onProgressMoveChanged(float f);
    }

    public ExposureControlSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ExposureControlSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExposureControlSeekBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ExposureControlSeekBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.mValue = 0.0f;
        this.mContext = null;
        this.mBottomDrawable = null;
        this.mOnSeekBarChangeListener = null;
        this.mXCoordinate = -1.0f;
        this.mbShowBar = false;
        this.mExporebarHeight = 0;
        this.mOrientation = 0;
        this.mLinePaint = null;
        this.mLinePath = null;
        this.mContext = context;
        Resources resources = this.mContext.getResources();
        this.mExporebarHeight = resources.getDimensionPixelSize(R.dimen.exporebar_height);
        initProgressBar();
        this.mLinePaint = new Paint();
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth(3.0f);
        this.mLinePaint.setPathEffect(new DashPathEffect(new float[]{(float) resources.getDimensionPixelSize(R.dimen.focus_view_exposurebar_dash_width), (float) resources.getDimensionPixelSize(R.dimen.focus_view_exposurebar_dash_gap)}, 0.0f));
        this.mLinePaint.setColor(Util.s(context));
        this.mLinePath = new Path();
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        this.mOnSeekBarChangeListener = onSeekBarChangeListener;
    }

    @TargetApi(16)
    private void initProgressBar() {
        this.mBottomDrawable = Util.b(getContext(), (int) R.drawable.exposure_control_bar_bottom);
        setProgress(50.0f);
    }

    public float getValue() {
        return this.mValue;
    }

    private void setProgress(float f) {
        this.mValue = f;
        if (getHeight() != 0) {
            this.mXCoordinate = ((float) (this.mExporebarHeight - (this.mBottomDrawable.getIntrinsicWidth() / 2))) - ((f / 100.0f) * ((float) (this.mExporebarHeight - this.mBottomDrawable.getIntrinsicWidth())));
            refreshProgress();
        }
    }

    private void drawButton(Canvas canvas) {
        int i = this.mOrientation;
        if (i != 0) {
            if (i == 90) {
                canvas.rotate(-90.0f, (float) ((int) this.mXCoordinate), (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                Drawable drawable = this.mBottomDrawable;
                drawable.setBounds(((int) this.mXCoordinate) - (drawable.getIntrinsicWidth() / 2), 0, ((int) this.mXCoordinate) + (this.mBottomDrawable.getIntrinsicWidth() / 2), this.mBottomDrawable.getIntrinsicWidth());
            } else if (i != 180) {
                if (i == 270) {
                    canvas.rotate(90.0f, (float) (this.mExporebarHeight - ((int) this.mXCoordinate)), (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                    Drawable drawable2 = this.mBottomDrawable;
                    drawable2.setBounds((this.mExporebarHeight - ((int) this.mXCoordinate)) - (drawable2.getIntrinsicWidth() / 2), 0, (this.mExporebarHeight - ((int) this.mXCoordinate)) + (this.mBottomDrawable.getIntrinsicWidth() / 2), this.mBottomDrawable.getIntrinsicWidth());
                }
            }
            this.mBottomDrawable.draw(canvas);
        }
        Drawable drawable3 = this.mBottomDrawable;
        drawable3.setBounds(0, ((int) this.mXCoordinate) - (drawable3.getIntrinsicWidth() / 2), this.mBottomDrawable.getIntrinsicWidth(), ((int) this.mXCoordinate) + (this.mBottomDrawable.getIntrinsicWidth() / 2));
        this.mBottomDrawable.draw(canvas);
    }

    private void drawUnFilled(Canvas canvas) {
        this.mLinePath.reset();
        int i = this.mOrientation;
        if (i != 0) {
            if (i == 90) {
                this.mLinePath.moveTo(0.0f, (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                this.mLinePath.lineTo((float) ((((int) this.mXCoordinate) - (this.mBottomDrawable.getIntrinsicHeight() / 2)) - 8), (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                canvas.drawPath(this.mLinePath, this.mLinePaint);
                return;
            } else if (i != 180) {
                if (i == 270) {
                    int intrinsicHeight = (this.mExporebarHeight - ((int) this.mXCoordinate)) + (this.mBottomDrawable.getIntrinsicHeight() / 2) + 8;
                    int i2 = this.mExporebarHeight;
                    if (intrinsicHeight > i2) {
                        intrinsicHeight = i2;
                    }
                    this.mLinePath.moveTo((float) this.mExporebarHeight, (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                    this.mLinePath.lineTo((float) intrinsicHeight, (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                    canvas.drawPath(this.mLinePath, this.mLinePaint);
                    return;
                }
                return;
            }
        }
        this.mLinePath.moveTo((float) (this.mBottomDrawable.getIntrinsicWidth() / 2), 0.0f);
        this.mLinePath.lineTo((float) (this.mBottomDrawable.getIntrinsicWidth() / 2), (float) ((((int) this.mXCoordinate) - (this.mBottomDrawable.getIntrinsicHeight() / 2)) - 8));
        canvas.drawPath(this.mLinePath, this.mLinePaint);
    }

    private void drawFilled(Canvas canvas) {
        this.mLinePath.reset();
        int i = this.mOrientation;
        if (i != 0) {
            if (i == 90) {
                int intrinsicHeight = ((int) this.mXCoordinate) + (this.mBottomDrawable.getIntrinsicHeight() / 2) + 8;
                int i2 = this.mExporebarHeight;
                if (intrinsicHeight > i2) {
                    intrinsicHeight = i2;
                }
                this.mLinePath.moveTo((float) getHeight(), (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                this.mLinePath.lineTo((float) intrinsicHeight, (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                canvas.drawPath(this.mLinePath, this.mLinePaint);
                return;
            } else if (i != 180) {
                if (i == 270) {
                    this.mLinePath.moveTo(0.0f, (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                    this.mLinePath.lineTo((float) (((this.mExporebarHeight - ((int) this.mXCoordinate)) - (this.mBottomDrawable.getIntrinsicHeight() / 2)) - 8), (float) (this.mBottomDrawable.getIntrinsicWidth() / 2));
                    canvas.drawPath(this.mLinePath, this.mLinePaint);
                    return;
                }
                return;
            }
        }
        this.mLinePath.moveTo((float) (this.mBottomDrawable.getIntrinsicWidth() / 2), (float) getHeight());
        this.mLinePath.lineTo((float) (this.mBottomDrawable.getIntrinsicWidth() / 2), (float) (((int) this.mXCoordinate) + (this.mBottomDrawable.getIntrinsicHeight() / 2) + 8));
        canvas.drawPath(this.mLinePath, this.mLinePaint);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.mXCoordinate < 0.0f) {
            setProgress(50.0f);
        }
        if (this.mbShowBar) {
            drawUnFilled(canvas);
            drawFilled(canvas);
        }
        drawButton(canvas);
        canvas.restore();
    }

    private void clamp(int i, int i2) {
        float f = (float) i2;
        if (this.mXCoordinate > f) {
            this.mXCoordinate = f;
        }
        float f2 = (float) i;
        if (this.mXCoordinate < f2) {
            this.mXCoordinate = f2;
        }
    }

    public void setMoveProgress(float f) {
        float f2 = this.mValue + f;
        float f3 = 0.0f;
        if (f2 >= 0.0f) {
            f3 = f2;
        }
        if (f3 > 100.0f) {
            f3 = 100.0f;
        }
        setProgress(f3);
        this.mOnSeekBarChangeListener.onProgressMoveChanged(f3);
    }

    public void resetProgress() {
        setProgress(50.0f);
    }

    private void refreshProgress() {
        clamp(this.mBottomDrawable.getIntrinsicWidth() / 2, this.mExporebarHeight - (this.mBottomDrawable.getIntrinsicWidth() / 2));
        OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChange(this.mValue / 100.0f);
        }
        invalidate();
    }

    public void setBarVisibility(boolean z) {
        this.mbShowBar = z;
        invalidate();
    }

    public void setOrientation(int i, boolean z) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onOrientationChange(this.mOrientation);
            }
        }
    }

    public void show() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(250);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.start();
    }
}
