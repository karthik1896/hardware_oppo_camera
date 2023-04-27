package com.oppo.camera.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.color.support.widget.seekbar.ColorSeekBar;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.lang.reflect.Field;

public class OppoNumSeekBar extends FrameLayout implements com.oppo.camera.ui.inverse.a {
    protected boolean A;
    protected boolean B;
    protected Rect C;
    protected ColorSeekBar D;
    protected float E;
    protected float F;
    protected float G;
    protected float H;
    protected Paint I;
    /* access modifiers changed from: private */
    public int J;
    private long K;
    private float L;
    private float M;
    private int N;
    private int O;
    private int P;
    /* access modifiers changed from: private */
    public a Q;
    private float R;
    private float S;

    /* renamed from: a  reason: collision with root package name */
    protected int f3794a;

    /* renamed from: b  reason: collision with root package name */
    protected int f3795b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected int o;
    protected int p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected float w;
    protected float x;
    protected boolean y;
    protected boolean z;

    public interface a {
        void a(OppoNumSeekBar oppoNumSeekBar, int i);

        void a(OppoNumSeekBar oppoNumSeekBar, int i, boolean z);

        boolean a();

        void b(OppoNumSeekBar oppoNumSeekBar, int i);
    }

    public OppoNumSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public OppoNumSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OppoNumSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3794a = 0;
        this.f3795b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = null;
        this.D = null;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.I = null;
        this.J = 0;
        this.K = 0;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = null;
        this.R = 0.0f;
        this.S = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OppoNumSeekBar, i2, 0);
        this.g = obtainStyledAttributes.getInt(6, 0);
        this.h = obtainStyledAttributes.getInt(5, 100);
        this.J = obtainStyledAttributes.getInt(7, this.g);
        this.f3794a = obtainStyledAttributes.getDimensionPixelSize(42, (int) getResources().getDimension(R.dimen.num_seekbar_track_size));
        this.f3795b = obtainStyledAttributes.getDimensionPixelSize(9, (int) getResources().getDimension(R.dimen.num_seekbar_second_track_size));
        this.n = obtainStyledAttributes.getDimensionPixelSize(26, (int) getResources().getDimension(R.dimen.num_seekbar_thumb_radius_on_dragging));
        this.f = obtainStyledAttributes.getDimensionPixelSize(25, getResources().getDimensionPixelSize(R.dimen.num_seekbar_thumb_radius));
        this.q = obtainStyledAttributes.getDimensionPixelSize(28, getResources().getDimensionPixelSize(R.dimen.num_seekbar_thumb_shadow_radius));
        this.c = obtainStyledAttributes.getDimensionPixelSize(12, (int) getResources().getDimension(R.dimen.num_seekbar_section_radius));
        this.d = obtainStyledAttributes.getDimensionPixelSize(10, (int) getResources().getDimension(R.dimen.num_seekbar_section_click_radius));
        this.k = obtainStyledAttributes.getColor(40, context.getColor(R.color.camera_white));
        this.l = obtainStyledAttributes.getColor(41, context.getColor(R.color.face_beauty_seekbar_track_color_inverse));
        this.j = obtainStyledAttributes.getColor(8, Util.s(getContext()));
        this.i = obtainStyledAttributes.getColor(11, context.getColor(R.color.camera_white));
        this.r = obtainStyledAttributes.getDimensionPixelSize(38, (int) context.getApplicationContext().getResources().getDimension(R.dimen.num_seekbar_thumb_text_size));
        this.e = this.j;
        this.s = obtainStyledAttributes.getColor(30, this.k);
        this.t = obtainStyledAttributes.getColor(31, context.getColor(R.color.inverse_text_color));
        this.K = (long) obtainStyledAttributes.getInteger(0, 200);
        this.m = obtainStyledAttributes.getInteger(13, 0);
        this.u = obtainStyledAttributes.getResourceId(39, 0);
        this.A = obtainStyledAttributes.getBoolean(29, false);
        this.N = obtainStyledAttributes.getDimensionPixelSize(33, 0);
        this.O = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.P = obtainStyledAttributes.getDimensionPixelSize(14, 0);
        this.o = obtainStyledAttributes.getDimensionPixelSize(21, getResources().getDimensionPixelSize(R.dimen.num_seekbar_thumb_circle_stroke_width));
        this.p = obtainStyledAttributes.getDimensionPixelSize(21, getResources().getDimensionPixelSize(R.dimen.num_seekbar_thumb_circle_stroke_width_on_dragging));
        obtainStyledAttributes.recycle();
        this.I = new Paint();
        this.I.setAntiAlias(true);
        this.I.setStrokeCap(Paint.Cap.ROUND);
        this.I.setTextAlign(Paint.Align.LEFT);
        this.I.setColor(this.s);
        this.I.setTextSize((float) this.r);
        a(this.I);
        this.C = new Rect();
        d();
        c();
    }

    /* access modifiers changed from: protected */
    public void a(Paint paint) {
        String b2 = b(paint);
        this.E = paint.measureText("-");
        this.F = paint.measureText(b2);
        this.G = paint.measureText(b2 + b2);
        this.H = paint.measureText(b2 + b2 + b2);
    }

    private String b(Paint paint) {
        float f2 = 0.0f;
        String str = null;
        for (int i2 = 0; i2 < 10; i2++) {
            String j2 = Util.j(i2);
            float measureText = paint.measureText(j2);
            if (measureText > f2) {
                str = j2;
                f2 = measureText;
            }
        }
        return str;
    }

    private void c() {
        setClipChildren(false);
        setClipToPadding(false);
        this.k = getResources().getColor(R.color.camera_white, getContext().getTheme());
        this.l = getResources().getColor(R.color.face_beauty_seekbar_track_color_inverse, getContext().getTheme());
        this.s = this.k;
        this.t = getResources().getColor(R.color.inverse_text_color, getContext().getTheme());
        this.N = (int) getResources().getDimension(R.dimen.blur_seekbar_thumb_text_padding_seek_bar);
        a(LayoutInflater.from(getContext()).inflate(R.layout.color_seekbar_layout, this, true));
    }

    private void a(View view) {
        this.D = (ColorSeekBar) view.findViewById(R.id.color_seek_bar);
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (int) getResources().getDimension(R.dimen.num_seekbar_height);
        this.D.setLayoutParams(layoutParams);
        this.D.setMax(1000);
        this.D.setOnSeekBarChangeListener(new ColorSeekBar.b() {
            public void a(ColorSeekBar colorSeekBar, int i, boolean z) {
                OppoNumSeekBar oppoNumSeekBar = OppoNumSeekBar.this;
                int unused = oppoNumSeekBar.J = oppoNumSeekBar.f(i);
                if (OppoNumSeekBar.this.Q != null) {
                    a a2 = OppoNumSeekBar.this.Q;
                    OppoNumSeekBar oppoNumSeekBar2 = OppoNumSeekBar.this;
                    a2.a(oppoNumSeekBar2, oppoNumSeekBar2.J, z);
                }
                OppoNumSeekBar.this.postInvalidate();
            }

            public void a(ColorSeekBar colorSeekBar) {
                if (OppoNumSeekBar.this.Q != null) {
                    OppoNumSeekBar oppoNumSeekBar = OppoNumSeekBar.this;
                    oppoNumSeekBar.z = true;
                    a a2 = oppoNumSeekBar.Q;
                    OppoNumSeekBar oppoNumSeekBar2 = OppoNumSeekBar.this;
                    a2.a(oppoNumSeekBar2, oppoNumSeekBar2.f(colorSeekBar.getProgress()));
                }
            }

            public void b(ColorSeekBar colorSeekBar) {
                if (OppoNumSeekBar.this.Q != null) {
                    OppoNumSeekBar oppoNumSeekBar = OppoNumSeekBar.this;
                    oppoNumSeekBar.z = false;
                    a a2 = oppoNumSeekBar.Q;
                    OppoNumSeekBar oppoNumSeekBar2 = OppoNumSeekBar.this;
                    a2.b(oppoNumSeekBar2, oppoNumSeekBar2.f(colorSeekBar.getProgress()));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public int f(int i2) {
        return this.g + Math.round((this.L * ((float) i2)) / ((float) this.D.getMax()));
    }

    private void d() {
        if (this.g == this.h) {
            this.g = 0;
            this.h = 100;
        }
        int i2 = this.g;
        int i3 = this.h;
        if (i2 > i3) {
            this.h = i2;
            this.g = i3;
        }
        int i4 = this.J;
        int i5 = this.g;
        if (i4 < i5) {
            this.J = i5;
        }
        int i6 = this.J;
        int i7 = this.h;
        if (i6 > i7) {
            this.J = i7;
        }
        int i8 = this.f3795b;
        int i9 = this.f3794a;
        if (i8 < i9) {
            this.f3795b = i9 + ((int) getResources().getDimension(R.dimen.num_seekbar_height_distance));
        }
        int i10 = this.f;
        int i11 = this.f3795b;
        if (i10 <= i11) {
            this.f = i11 + ((int) getResources().getDimension(R.dimen.num_seekbar_height_distance));
        }
        this.L = (float) (this.h - this.g);
        c(this.J);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.I.getTextBounds("0123456789", 0, 10, this.C);
        String minText = getMinText();
        this.I.getTextBounds(minText, 0, minText.length(), this.C);
        this.R = (((float) getPaddingLeft()) + Math.max((float) this.n, ((float) this.C.width()) / 2.0f)) - this.w;
        String maxText = getMaxText();
        this.I.getTextBounds(maxText, 0, maxText.length(), this.C);
        this.S = ((float) (getMeasuredWidth() - getPaddingRight())) - Math.max((float) this.n, ((float) this.C.width()) / 2.0f);
        int i4 = this.O;
        if (i4 != 0 && ((float) i4) > this.R) {
            this.R = (float) i4;
        }
        if (this.P != 0 && ((float) (getMeasuredWidth() - this.P)) < this.S) {
            this.S = (float) (getMeasuredWidth() - this.P);
        }
        this.M = this.S - this.R;
    }

    /* access modifiers changed from: protected */
    public int getYTop() {
        return getPaddingTop() + (getHeight() / 2);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        a(canvas, (float) getYTop());
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2) {
        float f3;
        Paint paint = this.I;
        paint.setColor(this.B ? this.t : this.s);
        boolean z2 = false;
        paint.getTextBounds("0123456789", 0, 10, this.C);
        int progress = getProgress();
        String str = null;
        if (1 == getLayoutDirection()) {
            z2 = true;
        }
        if (this.u != 0) {
            String string = getContext().getString(this.u);
            if (z2) {
                str = " " + string.replaceAll("[d%٪ ]", "");
            } else {
                str = string.replaceAll("[d%٪ ]", "").trim() + " ";
            }
        }
        if (str == null) {
            f3 = 0.0f;
        } else {
            f3 = paint.measureText(str);
        }
        float e2 = e(progress);
        float measureText = paint.measureText("%");
        float e3 = e(100) + f3 + measureText;
        float f4 = this.x;
        if (this.A) {
            f4 = (((float) ((getWidth() - getPaddingStart()) - getPaddingEnd())) - e3) / 2.0f;
            f2 = (f2 - ((float) this.N)) - ((float) getPaddingTop());
        }
        float a2 = a(paint, f2, this.C);
        if (z2) {
            float paddingEnd = f4 + ((float) getPaddingEnd());
            if (str != null) {
                canvas.drawText(str, (((float) getWidth()) - paddingEnd) - f3, a2, this.I);
            }
            canvas.drawText(Util.j(progress), ((((float) getWidth()) - paddingEnd) - f3) - e2, a2, this.I);
            canvas.drawText("%", (((((float) getWidth()) - paddingEnd) - f3) - e2) - measureText, a2, this.I);
            return;
        }
        float paddingStart = f4 + ((float) getPaddingStart());
        if (str != null) {
            canvas.drawText(str, paddingStart, a2, this.I);
        }
        float f5 = paddingStart + f3;
        canvas.drawText(Util.j(progress), f5, a2, this.I);
        canvas.drawText("%", f5 + e2, a2, this.I);
    }

    /* access modifiers changed from: protected */
    public float a(Paint paint, float f2, Rect rect) {
        return f2 - ((float) rect.height());
    }

    public void a() {
        animate().setDuration(this.K).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                OppoNumSeekBar oppoNumSeekBar = OppoNumSeekBar.this;
                oppoNumSeekBar.z = false;
                oppoNumSeekBar.y = false;
                oppoNumSeekBar.invalidate();
                if (OppoNumSeekBar.this.Q != null) {
                    a a2 = OppoNumSeekBar.this.Q;
                    OppoNumSeekBar oppoNumSeekBar2 = OppoNumSeekBar.this;
                    a2.a(oppoNumSeekBar2, oppoNumSeekBar2.getProgress(), true);
                }
            }

            public void onAnimationCancel(Animator animator) {
                OppoNumSeekBar oppoNumSeekBar = OppoNumSeekBar.this;
                oppoNumSeekBar.z = false;
                oppoNumSeekBar.y = false;
                oppoNumSeekBar.invalidate();
            }
        }).start();
        a aVar = this.Q;
        if (aVar != null) {
            aVar.b(this, getProgress());
        }
    }

    private String getMinText() {
        return Util.j(-50);
    }

    private String getMaxText() {
        return Util.j(this.h);
    }

    public float getMin() {
        return (float) this.g;
    }

    public OppoNumSeekBar a(int i2) {
        this.h = i2;
        this.L = (float) (this.h - this.g);
        return this;
    }

    public OppoNumSeekBar b(int i2) {
        this.g = i2;
        this.L = (float) (this.h - this.g);
        return this;
    }

    public float getMax() {
        return (float) this.h;
    }

    public OppoNumSeekBar c(int i2) {
        if (this.J != i2) {
            this.J = i2;
            a aVar = this.Q;
            if (aVar != null) {
                aVar.a(this, getProgress(), false);
            }
        }
        if (!this.z) {
            this.x = ((this.M / this.L) * ((float) (this.J - this.g))) + this.R;
        }
        ColorSeekBar colorSeekBar = this.D;
        if (!(colorSeekBar == null || 0.0f == this.L)) {
            colorSeekBar.setProgress((int) (((float) ((this.J - this.g) * colorSeekBar.getMax())) / this.L));
        }
        return this;
    }

    public int getProgress() {
        return this.J;
    }

    public void setOnProgressChangedListener(a aVar) {
        this.Q = aVar;
    }

    public boolean b() {
        return this.z;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", (float) this.J);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.J = bundle.getInt("progress");
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            c(this.J);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public OppoNumSeekBar d(int i2) {
        this.m = i2;
        return this;
    }

    public void setInverseColor(boolean z2) {
        this.B = z2;
        Paint paint = this.I;
        if (paint != null) {
            paint.setColor(z2 ? this.t : this.s);
        }
        a("mBackgroundColor", (Object) getResources().getColorStateList(this.B ? R.color.face_beauty_seekbar_track_color_inverse : R.color.face_beauty_seekbar_track_color, getContext().getTheme()));
        invalidate();
    }

    /* access modifiers changed from: protected */
    public float e(int i2) {
        if (i2 < 0) {
            return this.E + e(Math.abs(getProgress()));
        }
        if (i2 < 10) {
            return this.F;
        }
        if (i2 < 100) {
            return this.G;
        }
        return this.H;
    }

    /* access modifiers changed from: protected */
    public void a(String str, Object obj) {
        try {
            Field declaredField = this.D.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(this.D, obj);
        } catch (Exception e2) {
            e.d("OppoNumSeekBar", "reflectSomethingNeed, something may be wrong: " + e2);
        }
    }

    public void invalidate() {
        super.invalidate();
        ColorSeekBar colorSeekBar = this.D;
        if (colorSeekBar != null) {
            colorSeekBar.invalidate();
        }
    }

    public void postInvalidate() {
        super.postInvalidate();
        ColorSeekBar colorSeekBar = this.D;
        if (colorSeekBar != null) {
            colorSeekBar.postInvalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.Q;
        if (aVar == null || aVar.a()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
