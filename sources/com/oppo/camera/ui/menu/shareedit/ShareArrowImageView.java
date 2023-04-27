package com.oppo.camera.ui.menu.shareedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.ui.inverse.InverseImageView;
import com.oppo.camera.util.Util;

public class ShareArrowImageView extends InverseImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f4272a = Util.f().getResources().getDimensionPixelSize(R.dimen.arrow_anim_height);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f4273b = null;
    private long c = 0;
    private PathInterpolator d = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private PathInterpolator e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private float f = 0.0f;
    private int g = 0;

    public ShareArrowImageView(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public ShareArrowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public ShareArrowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.f4273b = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 3 && ShareArrowImageView.this.getVisibility() == 0) {
                    ShareArrowImageView.this.a();
                    ShareArrowImageView.this.f4273b.sendEmptyMessageDelayed(3, 33);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void a() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.c;
        if (0 < currentAnimationTimeMillis && 433 > currentAnimationTimeMillis) {
            float f2 = ((float) (currentAnimationTimeMillis - 0)) / 433.0f;
            this.g = (int) ((1.0f - this.d.getInterpolation(f2)) * ((float) this.f4272a));
            this.f = this.e.getInterpolation(f2);
            invalidate();
        } else if (433 < currentAnimationTimeMillis && 1250 > currentAnimationTimeMillis) {
        } else {
            if (1250 < currentAnimationTimeMillis && 1367 > currentAnimationTimeMillis) {
                this.f = this.e.getInterpolation(1.0f - (((float) (currentAnimationTimeMillis - 1250)) / 117.0f));
                if (0.2f > this.f) {
                    this.f = 0.0f;
                }
                invalidate();
            } else if (1367 < currentAnimationTimeMillis && 1517 > currentAnimationTimeMillis) {
            } else {
                if (1517 < currentAnimationTimeMillis && 1834 > currentAnimationTimeMillis) {
                    float f3 = ((float) (currentAnimationTimeMillis - 1517)) / 317.0f;
                    this.g = (int) ((1.0f - this.d.getInterpolation(f3)) * ((float) this.f4272a));
                    this.f = this.e.getInterpolation(f3);
                    invalidate();
                } else if ((1834 >= currentAnimationTimeMillis || 2734 <= currentAnimationTimeMillis) && 2734 < currentAnimationTimeMillis && 2851 > currentAnimationTimeMillis) {
                    this.f = this.e.getInterpolation(1.0f - (((float) (currentAnimationTimeMillis - 2734)) / 117.0f));
                    if (0.2f > this.f) {
                        this.f = 0.0f;
                    }
                    invalidate();
                }
            }
        }
    }

    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if ((visibility != i || b()) && i == 0) {
            this.g = 0;
            this.f = 0.0f;
            this.c = AnimationUtils.currentAnimationTimeMillis();
            this.f4273b.sendEmptyMessageDelayed(3, 33);
        }
    }

    private boolean b() {
        return 0 != this.c && AnimationUtils.currentAnimationTimeMillis() - this.c > 2851;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.right - bounds.left;
            int i2 = bounds.bottom - bounds.top;
            if (i != 0 && i2 != 0) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int paddingRight = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                int width = (getWidth() - paddingLeft) - paddingRight;
                int height = (getHeight() - paddingTop) - paddingBottom;
                int saveCount = canvas.getSaveCount();
                canvas.translate((float) (paddingLeft + (width / 2)), (float) (paddingTop + (height / 2)));
                canvas.translate((float) ((-i) / 2), (float) ((-i2) / 2));
                canvas.translate(0.0f, (float) this.g);
                drawable.setAlpha((int) (this.f * 255.0f));
                drawable.draw(canvas);
                canvas.restoreToCount(saveCount);
            }
        }
    }
}
