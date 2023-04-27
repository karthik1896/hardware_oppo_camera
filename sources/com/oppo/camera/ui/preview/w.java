package com.oppo.camera.ui.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.math.BigDecimal;
import java.util.ArrayList;

/* compiled from: ZoomArcSeekBar */
public class w extends y {
    private static float aU = 0.5f;
    private int aV = 0;
    private int aW = 0;
    private int aX = 0;
    private Paint aY = null;
    private Paint aZ = null;
    private Paint ba = null;
    private int bb = 0;
    private int bc = 0;
    private int bd = 0;
    private int be = 0;
    private int bf = 0;
    private int bg = 0;
    private TextPaint bh = null;
    private int bi = 0;
    private RectF bj = null;
    private SweepGradient bk = null;
    private int[] bl = null;
    private float[] bm = null;
    private int bn = 0;
    private int bo = 0;
    private int bp = 0;
    private int bq = 0;
    private int br = 0;
    private float bs = 0.0f;
    private float bt = 0.0f;
    private float bu = 0.0f;
    private float bv = 0.0f;
    private Paint bw = null;
    private Paint bx = null;

    public int getType() {
        return 1;
    }

    public w(Context context) {
        super(context);
        i();
    }

    public void a(float f, float f2, float f3, ArrayList<Float> arrayList, ArrayList<Float> arrayList2) {
        if (Float.compare(f3, arrayList.get(arrayList.size() - 1).floatValue()) > 0) {
            arrayList.add(Float.valueOf(f3));
        }
        super.a(f, f2, f3, arrayList, arrayList2);
    }

    private void i() {
        Resources resources = this.w.getResources();
        this.aV = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_unfold_anim_radius_between_distance);
        this.aW = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
        this.k = (float) resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_circle_center_y);
        this.bt = (float) resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_focus_center_y);
        this.bu = (float) resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_icon_y);
        this.br = resources.getDimensionPixelSize(R.dimen.num_seekbar_section_radius);
        this.bb = resources.getColor(R.color.zoom_arc_seekbar_bg_color);
        this.aY = new Paint();
        this.aY.setAntiAlias(true);
        this.aY.setStyle(Paint.Style.FILL);
        this.aY.setColor(this.bb);
        this.be = this.aY.getAlpha();
        this.aX = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_stroke_width);
        this.bc = resources.getColor(R.color.zoom_arc_seekbar_bg_stroke_color);
        this.aZ = new Paint();
        this.aZ.setAntiAlias(true);
        this.aZ.setStyle(Paint.Style.STROKE);
        this.aZ.setStrokeWidth((float) this.aX);
        this.aZ.setColor(this.bc);
        this.bd = this.aZ.getAlpha();
        this.ba = new Paint();
        this.ba.setAntiAlias(true);
        this.ba.setStyle(Paint.Style.STROKE);
        this.ba.setStrokeWidth((float) this.aX);
        this.bi = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_marker_arc_radius);
        int i = this.bc;
        this.bl = new int[]{Color.parseColor("#00FFFFFF"), i, i, Color.parseColor("#00FFFFFF")};
        this.bm = getSweepGradientPositions();
        this.bk = new SweepGradient(this.j, (float) this.aW, this.bl, this.bm);
        this.z = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_circle_radius_pressed);
        this.H = resources.getColor(R.color.zoom_arc_seekbar_indicator_circle_color);
        this.bn = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_circle_stroke_width);
        this.bo = resources.getColor(R.color.zoom_arc_seekbar_indicator_circle_stroke_color);
        this.ar = new Paint();
        this.ar.setAntiAlias(true);
        this.ar.setStyle(Paint.Style.FILL);
        this.ar.setColor(this.H);
        this.S = this.ar.getAlpha();
        this.bx = new Paint();
        this.bx.setAntiAlias(true);
        this.bx.setStyle(Paint.Style.STROKE);
        this.bx.setStrokeWidth((float) this.bn);
        this.bx.setColor(this.bo);
        this.az = new TextPaint(1);
        this.N = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_text_size);
        this.az.setTextSize((float) this.N);
        this.az.setColor(-1);
        this.az.setTextAlign(Paint.Align.CENTER);
        this.az.setTypeface(Util.j(this.w));
        this.bh = new TextPaint(1);
        this.bf = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_mark_text_size);
        this.bh.setTextSize((float) this.bf);
        this.bh.setColor(-1);
        this.bh.setTextAlign(Paint.Align.CENTER);
        this.bh.setTypeface(Util.j(this.w));
        this.bg = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_marker_center_margin_top);
        Paint.FontMetrics fontMetrics = this.az.getFontMetrics();
        this.bs = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom;
        this.bp = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_line_width);
        this.bq = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_line_height);
        this.bv = (float) ((this.aW - (this.bq / 2)) - resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_line_padding_top));
        this.bw = new Paint(1);
    }

    public int getLayoutHeight() {
        return this.x.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_height);
    }

    private void h(float f) {
        j(f);
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas) {
        float interpolation = this.g >= 0.4f ? 1.0f - this.e.getInterpolation(1.0f - ((this.g - 0.4f) / 0.6f)) : 0.0f;
        h(interpolation);
        if (this.g > 0.0f) {
            a(canvas, interpolation);
            if (this.aI == null || this.aH == null) {
                d();
            }
            this.aI.drawPaint(this.ay);
            this.aH.drawPaint(this.ay);
            if (interpolation > aU) {
                a(this.aI, this.ah, interpolation);
            }
            this.aI.drawBitmap(this.aF, 0.0f, 0.0f, this.ax);
            canvas.drawBitmap(this.aG, 0.0f, 0.0f, this.ax);
        }
        a(canvas, this.ah, this.aj, 1.0f - this.e.getInterpolation(1.0f - this.g));
        super.c(canvas);
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas) {
        float interpolation = this.f.getInterpolation(this.g);
        h(interpolation);
        if (this.g < 1.0f) {
            a(canvas, interpolation);
            if (this.aI == null || this.aH == null) {
                d();
            }
            this.aI.drawPaint(this.ay);
            this.aH.drawPaint(this.ay);
            if (interpolation > aU) {
                a(this.aI, this.ah, interpolation);
            }
            this.aI.drawBitmap(this.aF, 0.0f, 0.0f, this.ax);
            canvas.drawBitmap(this.aG, 0.0f, 0.0f, this.ax);
        }
        a(canvas, this.ah, this.aj, interpolation);
        super.b(canvas);
    }

    private void a(Canvas canvas, String str, Drawable drawable, float f) {
        float f2;
        Canvas canvas2 = canvas;
        float f3 = 1.0f - (0.82f * f);
        float alpha = (1.0f - f) * getAlpha();
        float f4 = ((float) this.y) + (((float) (this.z - this.y)) * this.T);
        this.aq.setTextSize((((float) this.F) + (((float) (this.G - this.F)) * this.T)) * f3);
        this.aq.setAlpha((int) (((float) Color.alpha(-1)) * alpha));
        this.as.setAlpha((int) (((float) Color.alpha(this.at)) * alpha));
        this.au.setAlpha((int) (((float) Color.alpha(this.av)) * alpha));
        a(canvas, this.j, this.k - (((float) this.I) * f), str, drawable, f4 * f3, f3 * 1.0f, (int) (255.0f * alpha));
        int size = this.aB.size();
        if (this.J + 1 + 3 < this.aB.size()) {
            size = this.J + 1 + 3;
        }
        c(Float.compare(alpha, 1.0f) == 0);
        this.aw.setAlpha((int) (((float) Color.alpha(-1)) * alpha));
        float totleAngle = (getTotleAngle() * this.h) + 90.0f;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.V; i++) {
            float b2 = b(i);
            if (a(b2)) {
                if (1 == getLayoutDirection()) {
                    b2 = 1.0f - b2;
                    f2 = getTotleAngle();
                } else {
                    f2 = getTotleAngle();
                }
                arrayList.add(Float.valueOf(totleAngle - (b2 * f2)));
            }
        }
        for (int i2 = this.J > 3 ? this.J - 3 : 0; i2 < size; i2++) {
            if (i2 != this.J) {
                if (arrayList.size() == 0) {
                    canvas.drawCircle(a(i2, this.J), this.k, (float) this.C, this.aw);
                } else {
                    double floatValue = (double) ((Float) arrayList.get(1 == getLayoutDirection() ? (size - 1) - i2 : i2)).floatValue();
                    float f5 = this.bv;
                    int i3 = this.aV;
                    float f6 = (f5 - ((float) i3)) + ((float) i3);
                    float cos = this.j + (((float) Math.cos(Math.toRadians(floatValue))) * f6);
                    float sin = ((float) this.aW) - (f6 * ((float) Math.sin(Math.toRadians(floatValue))));
                    float a2 = a(i2, this.J);
                    canvas.drawCircle(a2 + ((cos - a2) * f), this.k + ((sin - this.k) * f), (float) this.C, this.aw);
                }
            }
        }
    }

    public void f(Canvas canvas) {
        a(canvas, 1.0f);
        if (this.aI == null || this.aH == null) {
            d();
        }
        this.aI.drawPaint(this.ay);
        this.aH.drawPaint(this.ay);
        a(this.aI, this.ah, 1.0f);
        this.aI.drawBitmap(this.aF, 0.0f, 0.0f, this.ax);
        canvas.drawBitmap(this.aG, 0.0f, 0.0f, this.ax);
    }

    private void a(Canvas canvas, String str, float f) {
        boolean z;
        float f2;
        int i;
        int i2;
        float f3;
        float f4;
        float f5;
        Canvas canvas2 = canvas;
        float f6 = f;
        float totleAngle = (getTotleAngle() * this.h) + 90.0f;
        if (TextUtils.isEmpty(str)) {
            e.e("ZoomArcSeekBar", "drawIndicatorLines, text is null");
            return;
        }
        float f7 = this.bv;
        int i3 = this.aV;
        float f8 = (f7 - ((float) i3)) + (((float) i3) * f6);
        int i4 = 0;
        while (i4 < this.V) {
            float b2 = b(i4);
            boolean a2 = a(b2);
            float floatValue = new BigDecimal((double) b(b2)).setScale(2, 4).floatValue();
            if ((Float.compare(floatValue, 10.0f) >= 0 || 1.0E-5f < Math.abs(floatValue % 1.0f)) && (Float.compare(floatValue, 10.0f) <= 0 || 1.0E-5f < Math.abs(floatValue % 10.0f))) {
                z = false;
            } else {
                z = true;
            }
            if (1 == getLayoutDirection()) {
                f2 = getTotleAngle();
                b2 = 1.0f - b2;
            } else {
                f2 = getTotleAngle();
            }
            float f9 = totleAngle - (f2 * b2);
            double d = (double) f9;
            float f10 = totleAngle;
            float cos = (float) Math.cos(Math.toRadians(d));
            float sin = (float) Math.sin(Math.toRadians(d));
            float f11 = this.j + (f8 * cos);
            float f12 = ((float) this.aW) - (f8 * sin);
            this.bw.setStrokeWidth((float) this.bq);
            int i5 = this.bp;
            float f13 = f11 - ((((float) i5) * 1.0f) / 2.0f);
            float f14 = ((((float) i5) * 1.0f) / 2.0f) + f11;
            if (a2) {
                this.bw.setColor(-1);
                i = i4;
            } else if (z) {
                i = i4;
                this.bw.setColor(this.w.getColor(R.color.color_white_with_50_percent_transparency));
            } else {
                i = i4;
                this.bw.setColor(this.w.getColor(R.color.color_white_with_15_percent_transparency));
            }
            int i6 = i(f9);
            if (Float.compare(f6, 1.0f) <= 0) {
                i6 = (int) (((float) i6) * f6);
            }
            int i7 = i6;
            this.bw.setAlpha(i7);
            int save = canvas.save();
            float f15 = 90.0f - f9;
            canvas2.rotate(f15, f11, f12);
            if (Float.compare(floatValue, 1.0f) >= 0 || a2 || !this.ag) {
                i2 = i7;
                f3 = f15;
                f4 = floatValue;
                canvas.drawLine(f13, f12, f14, f12, this.bw);
            } else {
                canvas2.drawCircle((f13 + f14) / 2.0f, (f12 + f12) / 2.0f, (float) (this.br / 2), this.bw);
                f4 = floatValue;
                i2 = i7;
                f3 = f15;
            }
            canvas2.restoreToCount(save);
            if (a2) {
                String str2 = this.aJ.format((double) d(f4)) + "X";
                Drawable drawable = null;
                if (Float.compare(f4, 1.0f) < 0) {
                    drawable = this.w.getResources().getDrawable(R.drawable.mark_zoom_ultra_wide_angle);
                }
                Drawable drawable2 = drawable;
                int save2 = canvas.save();
                this.bh.getTextBounds(str2, 0, str2.length(), new Rect());
                float f16 = (f8 - ((float) (this.bq / 2))) - ((float) this.bg);
                float f17 = this.j + (cos * f16);
                float f18 = ((float) this.aW) - (f16 * sin);
                canvas2.rotate(f3, f17, f18);
                canvas2.rotate((float) (-this.P), f17, f18);
                f5 = f;
                if (Float.compare(f5, 1.0f) <= 0) {
                    this.bh.setAlpha((int) (255.0f * f5));
                } else {
                    this.bh.setAlpha(255);
                }
                if (drawable2 != null) {
                    drawable2.setAlpha(i2);
                    a(canvas, drawable2, f17, f18, 1.0f, 255);
                } else {
                    int dimensionPixelSize = this.x.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_marker_text_y_offset);
                    this.bh.setAlpha(i2);
                    canvas2.drawText(str2, f17, f18 + ((float) dimensionPixelSize), this.bh);
                }
                canvas2.restoreToCount(save2);
            } else {
                f5 = f;
            }
            i4 = i + 1;
            f6 = f5;
            totleAngle = f10;
        }
        float f19 = f6;
        int save3 = canvas.save();
        float f20 = this.bu;
        int i8 = this.aV;
        Drawable drawable3 = this.x.getDrawable(R.drawable.zoom_indicator);
        a(canvas, drawable3, this.j, ((f20 + ((float) i8)) - (((float) i8) * f19)) + ((float) (drawable3.getIntrinsicHeight() / 2)), 1.0f, 255);
        canvas2.restoreToCount(save3);
    }

    private float[] getSweepGradientPositions() {
        return new float[]{0.575f, 0.60833335f, 0.89166665f, 0.925f};
    }

    private int i(float f) {
        float f2;
        float f3;
        int alpha = this.bw.getAlpha();
        if (f < 39.0f || f > 141.0f) {
            if (f >= 27.0f && f <= 39.0f) {
                f2 = (((float) alpha) * 1.0f) / 12.0f;
                f3 = f - 27.0f;
            } else if (f < 141.0f || f > 153.0f) {
                alpha = 0;
            } else {
                f2 = (((float) alpha) * 1.0f) / -12.0f;
                f3 = (f + 27.0f) - 180.0f;
            }
            alpha = (int) (f2 * f3);
        }
        if (alpha >= 0) {
            return alpha;
        }
        return 0;
    }

    private void a(Canvas canvas, float f) {
        canvas.clipRect(new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), Region.Op.INTERSECT);
        float f2 = ((float) this.aW) - (((float) this.aV) * (1.0f - f));
        canvas.drawCircle(this.j, (float) this.aW, f2 - ((float) this.aX), this.aY);
        canvas.drawCircle(this.j, (float) this.aW, f2 - (((float) this.aX) * 0.5f), this.aZ);
    }

    /* access modifiers changed from: protected */
    public boolean a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (0.0f > y || y > ((float) measuredHeight)) {
            return true;
        }
        int i = measuredWidth / 2;
        if (Math.pow((double) Math.abs(x - ((float) i)), 2.0d) + Math.pow(Math.abs(((double) y) - (Math.sqrt(Math.pow((double) this.aW, 2.0d) - Math.pow((double) i, 2.0d)) + ((double) measuredHeight))), 2.0d) < Math.pow((double) this.aW, 2.0d)) {
            return true;
        }
        return false;
    }

    private void j(float f) {
        if (f > 1.0f || f < 0.0f) {
            this.aY.setColor(this.bb);
            this.aZ.setColor(this.bc);
            this.ba.setColor(this.bc);
            return;
        }
        this.aY.setColor(-16777216);
        this.aY.setAlpha((int) (((float) this.be) * f));
        this.aZ.setColor(-1);
        this.aZ.setAlpha((int) (((float) this.bd) * f));
        this.ba.setColor(-1);
        this.ba.setAlpha((int) (((float) this.bd) * f));
    }

    public float a(float f, VelocityTracker velocityTracker) {
        float min = Math.min(Math.max(this.u + (((this.v - this.u) / ((float) (this.t - this.s))) * (((float) Math.abs((int) velocityTracker.getXVelocity())) - ((float) this.s))), this.u), this.v);
        if (Math.abs(f) <= ((float) this.r) && min > this.u * 2.0f) {
            min /= 2.0f;
        }
        return (-f) * min;
    }
}
