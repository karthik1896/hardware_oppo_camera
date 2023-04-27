package com.oppo.camera.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.oppo.camera.R;
import java.lang.reflect.Array;

/* compiled from: HistogramView */
public class j extends View {
    private Interpolator A;

    /* renamed from: a  reason: collision with root package name */
    private final String f4032a;

    /* renamed from: b  reason: collision with root package name */
    private float f4033b;
    private float c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private float j;
    private float k;
    private float[][] l;
    private float[] m;
    private float[] n;
    private float[] o;
    private float p;
    private Bitmap q;
    private Paint r;
    private Paint s;
    private Paint t;
    private Paint u;
    private Paint v;
    private Paint w;
    private Paint x;
    private Paint y;
    private Paint z;

    public j(Context context) {
        this(context, (AttributeSet) null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4032a = "HistogramView";
        this.f4033b = 0.0f;
        this.c = 0.0f;
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = (float[][]) Array.newInstance(float.class, new int[]{256, 3});
        this.m = new float[256];
        this.n = new float[256];
        this.o = new float[256];
        this.p = 0.0f;
        this.q = null;
        this.r = new Paint();
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        setBackgroundResource(R.drawable.film_histogram_bg);
        a();
        this.A = AnimationUtils.loadInterpolator(getContext(), R.anim.accelerate_decelerate_path_interpolator);
    }

    private void a() {
        this.r.setFlags(1);
        this.r.setColor(-16777216);
        this.r.setAlpha(0);
        this.s = new Paint();
        this.s.setColor(getResources().getColor(R.color.histogram_red));
        this.s.setStyle(Paint.Style.FILL);
        this.t = new Paint();
        this.t.setColor(getResources().getColor(R.color.histogram_green));
        this.t.setStyle(Paint.Style.FILL);
        this.u = new Paint();
        this.u.setColor(getResources().getColor(R.color.histogram_blue));
        this.u.setStyle(Paint.Style.FILL);
        this.v = new Paint();
        this.v.setColor(getResources().getColor(R.color.histogram_rg_overlay_yellow));
        this.v.setStyle(Paint.Style.FILL);
        this.w = new Paint();
        this.w.setColor(getResources().getColor(R.color.histogram_gb_overlay_cyan));
        this.w.setStyle(Paint.Style.FILL);
        this.x = new Paint();
        this.x.setColor(getResources().getColor(R.color.histogram_rb_overlay_megenta));
        this.x.setStyle(Paint.Style.FILL);
        this.y = new Paint();
        this.y.setColor(-1);
        this.y.setStyle(Paint.Style.FILL);
        this.z = new Paint();
        this.z.setAntiAlias(true);
        this.z.setColor(getResources().getColor(R.color.histogram_bg_line_color));
        this.z.setStyle(Paint.Style.FILL);
        this.z.setStrokeWidth((float) getResources().getDimensionPixelSize(R.dimen.histogram_bg_line_width));
    }

    public void a(float[] fArr, float[] fArr2, float[] fArr3, float f2) {
        this.m = fArr;
        this.n = fArr2;
        this.o = fArr3;
        this.p = f2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.q = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
        this.j = (float) i2;
        this.k = (float) i3;
        super.onSizeChanged(i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.r);
            float f2 = this.j / 256.0f;
            float f3 = this.k / (this.p * 4.0f);
            int i2 = 0;
            while (i2 < 256) {
                int i3 = i2 < 2 ? i2 + 2 : i2 > 253 ? i2 - 2 : i2;
                float a2 = a(this.m, i3);
                float a3 = a(this.n, i3);
                float a4 = a(this.o, i3);
                float[][] fArr = this.l;
                fArr[i2][0] = a2 * f3;
                fArr[i2][1] = a3 * f3;
                fArr[i2][2] = a4 * f3;
                float f4 = fArr[i2][0];
                float f5 = this.k;
                if (f4 > f5) {
                    fArr[i2][0] = f5;
                }
                float[][] fArr2 = this.l;
                float f6 = fArr2[i2][1];
                float f7 = this.k;
                if (f6 > f7) {
                    fArr2[i2][1] = f7;
                }
                float[][] fArr3 = this.l;
                float f8 = fArr3[i2][2];
                float f9 = this.k;
                if (f8 > f9) {
                    fArr3[i2][2] = f9;
                }
                float f10 = f2 * ((float) i2);
                a(canvas, f10, this.k, f10 + f2, this.l[i2]);
                i2++;
            }
        }
        for (int i4 = 1; i4 < 6; i4++) {
            float f11 = this.k;
            float f12 = (float) i4;
            canvas.drawLine(0.0f, (f11 / 6.0f) * f12, this.j, (f11 / 6.0f) * f12, this.z);
        }
    }

    private float a(float[] fArr, int i2) {
        return ((((fArr[i2 - 2] + fArr[i2 - 1]) + fArr[i2]) + fArr[i2 + 1]) + fArr[i2 + 2]) / 5.0f;
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float[] fArr) {
        boolean z2;
        if (fArr[0] > fArr[1]) {
            z2 = fArr[0] > fArr[2] ? fArr[1] <= fArr[2] : true;
        } else if (fArr[0] > fArr[2]) {
            z2 = true;
        } else {
            z2 = fArr[1] > fArr[2] ? true : true;
        }
        if (!z2) {
            canvas.drawRect(f2, f3 - fArr[2], f4, f3, this.y);
            canvas.drawRect(f2, f3 - fArr[1], f4, f3 - fArr[2], this.v);
            canvas.drawRect(f2, f3 - fArr[0], f4, f3 - fArr[1], this.s);
        } else if (z2) {
            canvas.drawRect(f2, f3 - fArr[1], f4, f3, this.y);
            canvas.drawRect(f2, f3 - fArr[2], f4, f3 - fArr[1], this.x);
            canvas.drawRect(f2, f3 - fArr[0], f4, f3 - fArr[2], this.s);
        } else if (z2) {
            canvas.drawRect(f2, f3 - fArr[0], f4, f3, this.y);
            canvas.drawRect(f2, f3 - fArr[1], f4, f3 - fArr[0], this.w);
            canvas.drawRect(f2, f3 - fArr[2], f4, f3 - fArr[1], this.u);
        } else if (z2) {
            canvas.drawRect(f2, f3 - fArr[1], f4, f3, this.y);
            canvas.drawRect(f2, f3 - fArr[0], f4, f3 - fArr[1], this.x);
            canvas.drawRect(f2, f3 - fArr[2], f4, f3 - fArr[0], this.u);
        } else if (z2) {
            canvas.drawRect(f2, f3 - fArr[0], f4, f3, this.y);
            canvas.drawRect(f2, f3 - fArr[2], f4, f3 - fArr[0], this.w);
            canvas.drawRect(f2, f3 - fArr[1], f4, f3 - fArr[2], this.t);
        } else if (z2) {
            canvas.drawRect(f2, f3 - fArr[2], f4, f3, this.y);
            canvas.drawRect(f2, f3 - fArr[0], f4, f3 - fArr[2], this.v);
            canvas.drawRect(f2, f3 - fArr[1], f4, f3 - fArr[0], this.t);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.d = false;
                this.f4033b = rawX;
                this.c = rawY;
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    int[] iArr = new int[2];
                    viewGroup.getLocationInWindow(iArr);
                    this.f = viewGroup.getMeasuredHeight();
                    this.e = viewGroup.getMeasuredWidth();
                    this.g = iArr[0];
                }
            } else if (action != 1) {
                if (action == 2 && rawX >= 0.0f && rawX <= ((float) this.e)) {
                    int i2 = this.g;
                    if (rawY >= ((float) i2) && rawY <= ((float) (this.f + i2))) {
                        float f2 = rawX - this.f4033b;
                        float f3 = rawY - this.c;
                        if (!this.d) {
                            if (Math.sqrt((double) ((f2 * f2) + (f3 * f3))) < 2.0d) {
                                this.d = false;
                            } else {
                                this.d = true;
                            }
                        }
                        float x2 = f2 + getX();
                        float y2 = getY() + f3;
                        float width = (float) (this.e - getWidth());
                        float height = (float) (this.f - getHeight());
                        if (x2 < 0.0f) {
                            x2 = 0.0f;
                        } else if (x2 > width) {
                            x2 = width;
                        }
                        if (y2 < 0.0f) {
                            y2 = 0.0f;
                        } else if (y2 > height) {
                            y2 = height;
                        }
                        setX(x2);
                        setY(y2);
                        this.f4033b = rawX;
                        this.c = rawY;
                    }
                }
            } else if (this.h && this.d) {
                if (this.f4033b <= ((float) (this.e / 2))) {
                    animate().setInterpolator(this.A).setDuration(500).x(0.0f).start();
                } else {
                    animate().setInterpolator(this.A).setDuration(500).x((float) (this.e - getWidth())).start();
                }
            }
        }
        boolean z2 = this.d;
        return z2 ? z2 : super.onTouchEvent(motionEvent);
    }
}
