package com.oppo.camera.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

public class OppoNumAISeekBar extends OppoNumSeekBar {
    private int J;
    private int K;
    private int L;
    private int M;
    private float N;
    private boolean O;
    private String P;

    public OppoNumAISeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public OppoNumAISeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OppoNumAISeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = false;
        this.P = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OppoNumSeekBar, i, 0);
        this.k = obtainStyledAttributes.getColor(40, context.getColor(R.color.face_beauty_seekbar_track_color));
        this.i = obtainStyledAttributes.getColor(11, context.getColor(R.color.camera_white));
        this.n = obtainStyledAttributes.getDimensionPixelSize(26, getResources().getDimensionPixelSize(R.dimen.num_seekbar_ai_thumb_radius_on_dragging));
        this.v = obtainStyledAttributes.getDimensionPixelSize(26, getResources().getDimensionPixelSize(R.dimen.num_seekbar_ai_thumb_radius_cut_back));
        this.J = obtainStyledAttributes.getColor(35, context.getColor(R.color.num_seekbar_thumb_text_shadow_color));
        this.M = obtainStyledAttributes.getDimensionPixelSize(34, getResources().getDimensionPixelSize(R.dimen.num_seekbar_text_shadow_blur));
        this.K = obtainStyledAttributes.getDimensionPixelSize(36, getResources().getDimensionPixelSize(R.dimen.num_seekbar_text_shadow_offset_x));
        this.L = obtainStyledAttributes.getDimensionPixelSize(37, getResources().getDimensionPixelSize(R.dimen.num_seekbar_text_shadow_offset_y));
        this.P = obtainStyledAttributes.getResources().getString(R.string.camera_ai_beauty_seekbar_text);
        obtainStyledAttributes.recycle();
        this.w = 22.0f;
        this.A = true;
        this.I.setShadowLayer((float) this.M, (float) this.K, (float) this.L, this.J);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Paint.FontMetrics fontMetrics = this.I.getFontMetrics();
        this.N = fontMetrics.descent - fontMetrics.ascent;
    }

    /* access modifiers changed from: protected */
    public float a(Paint paint, float f, Rect rect) {
        Paint.FontMetrics fontMetrics = this.I.getFontMetrics();
        return ((float) getPaddingTop()) + (this.N / 2.0f) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f) {
        String str;
        float f2;
        int progress = getProgress();
        if (!this.O) {
            str = this.P + " ";
        } else {
            str = null;
        }
        boolean z = true;
        if (1 != getLayoutDirection()) {
            z = false;
        }
        if (this.u != 0) {
            String string = getContext().getString(this.u);
            if (z) {
                str = " " + string.replaceAll("[d%٪ ]", "");
            } else {
                str = string.replaceAll("[d%٪ ]", "").trim() + " ";
            }
        }
        if (str == null) {
            f2 = 0.0f;
        } else {
            f2 = this.I.measureText(str);
        }
        float e = e(progress);
        float measureText = this.I.measureText("%");
        int i = this.O ? 10 : 100;
        float a2 = a(this.I, f, this.C);
        float width = (float) ((ViewGroup) getParent()).getWidth();
        float e2 = (width - ((e(i) + f2) + measureText)) / 2.0f;
        if (this.O) {
            e2 += (float) Util.a(getContext(), 1.0f);
        }
        if (z) {
            if (str != null) {
                canvas.drawText(str, (width - e2) - f2, a2, this.I);
            }
            float f3 = ((width - e2) - f2) - e;
            canvas.drawText(Util.j(progress), f3, a2, this.I);
            canvas.drawText("%", f3 - measureText, a2, this.I);
            return;
        }
        if (str != null) {
            canvas.drawText(str, e2, a2, this.I);
        }
        float f4 = e2 + f2;
        canvas.drawText(Util.j(progress), f4, a2, this.I);
        canvas.drawText("%", f4 + e, a2, this.I);
    }

    public void setFrontStyle(boolean z) {
        this.O = z;
    }

    public void setInverseColor(boolean z) {
        this.B = z;
        a("mBackgroundColor", (Object) getResources().getColorStateList(this.B ? R.color.face_beauty_seekbar_track_color_inverse : R.color.face_beauty_seekbar_track_color, getContext().getTheme()));
        invalidate();
    }
}
