package com.color.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import color.support.v7.appcompat.R;
import com.color.support.d.l;

public class ColorRoundImageView extends ImageView {
    private Drawable A;
    private Bitmap B;
    private float C;
    private int D;
    private Paint E;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f2100a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f2101b;
    private int c;
    private Context d;
    private boolean e;
    private boolean f;
    private int g;
    private RectF h;
    private RectF i;
    private Drawable j;
    private Drawable k;
    private Bitmap l;
    private int m;
    private int n;
    private int o;
    private int p;
    private BitmapShader q;
    private int r;
    private int s;
    private int t;
    private Paint u;
    private Paint v;
    private Matrix w;
    private BitmapShader x;
    private int y;
    private float z;

    public ColorRoundImageView(Context context) {
        super(context);
        this.f2100a = new RectF();
        this.f2101b = new RectF();
        this.w = new Matrix();
        this.d = context;
        this.u = new Paint();
        this.u.setAntiAlias(true);
        c();
        this.v = new Paint();
        this.v.setAntiAlias(true);
        this.v.setColor(getResources().getColor(R.color.color_roundimageview_outcircle_color));
        this.v.setStrokeWidth(1.0f);
        this.v.setStyle(Paint.Style.STROKE);
        this.c = 0;
        this.y = getResources().getDimensionPixelSize(R.dimen.color_roundimageview_default_radius);
        setupShader(getDrawable());
    }

    private void c() {
        this.E = new Paint();
        this.E.setStrokeWidth(2.0f);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setAntiAlias(true);
        this.E.setColor(getResources().getColor(R.color.color_border));
    }

    public ColorRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2100a = new RectF();
        this.f2101b = new RectF();
        this.w = new Matrix();
        this.d = context;
        this.u = new Paint();
        this.u.setAntiAlias(true);
        this.u.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        c();
        this.v = new Paint();
        this.v.setAntiAlias(true);
        this.v.setStrokeWidth(2.0f);
        this.v.setStyle(Paint.Style.STROKE);
        this.k = context.getResources().getDrawable(R.drawable.color_round_image_view_shadow);
        this.m = this.k.getIntrinsicWidth();
        this.n = this.k.getIntrinsicHeight();
        this.o = (int) context.getResources().getDimension(R.dimen.color_roundimageView_src_width);
        this.p = this.o;
        this.v.setColor(getResources().getColor(R.color.color_roundimageview_outcircle_color));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorRoundImageView);
        this.g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorRoundImageView_colorBorderRadius, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.c = obtainStyledAttributes.getInt(R.styleable.ColorRoundImageView_colorType, 0);
        this.e = obtainStyledAttributes.getBoolean(R.styleable.ColorRoundImageView_colorHasBorder, false);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.ColorRoundImageView_colorHasDefaultPic, true);
        a();
        setupShader(getDrawable());
        obtainStyledAttributes.recycle();
    }

    public ColorRoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2100a = new RectF();
        this.f2101b = new RectF();
        a();
    }

    public void a() {
        this.f2101b.set(0.0f, 0.0f, (float) this.m, (float) this.n);
        this.t = this.m - this.o;
        this.f2100a.set(this.f2101b);
        RectF rectF = this.f2100a;
        int i2 = this.t;
        rectF.inset((float) (i2 / 2), (float) (i2 / 2));
    }

    public void setHasBorder(boolean z2) {
        this.e = z2;
    }

    public void setHasDefaultPic(boolean z2) {
        this.f = z2;
    }

    public void setBorderRectRadius(int i2) {
        this.g = i2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.C = 1.0f;
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            int i2 = this.c;
            if (i2 == 0) {
                this.D = Math.min(bitmap.getWidth(), this.B.getHeight());
                this.C = (((float) this.y) * 1.0f) / ((float) this.D);
            } else if (i2 == 1) {
                this.C = Math.max((((float) getWidth()) * 1.0f) / ((float) this.B.getWidth()), (((float) getHeight()) * 1.0f) / ((float) this.B.getHeight()));
            } else if (i2 == 2) {
                this.C = Math.max((((float) getWidth()) * 1.0f) / ((float) this.m), (((float) getHeight()) * 1.0f) / ((float) this.n));
                this.w.reset();
                Matrix matrix = this.w;
                float f2 = this.C;
                matrix.setScale(f2, f2);
                this.q.setLocalMatrix(this.w);
                this.u.setShader(this.q);
                canvas.drawRect(this.h, this.u);
                return;
            }
            Matrix matrix2 = this.w;
            float f3 = this.C;
            matrix2.setScale(f3, f3);
            BitmapShader bitmapShader = this.x;
            if (bitmapShader != null) {
                bitmapShader.setLocalMatrix(this.w);
                this.u.setShader(this.x);
            }
        }
        int i3 = this.c;
        if (i3 == 0) {
            if (this.e) {
                float f4 = this.z;
                canvas.drawCircle(f4, f4, f4, this.u);
                float f5 = this.z;
                canvas.drawCircle(f5, f5, f5 - 0.5f, this.v);
                return;
            }
            float f6 = this.z;
            canvas.drawCircle(f6, f6, f6, this.u);
        } else if (i3 == 1) {
            if (this.h == null) {
                this.h = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            }
            if (this.i == null) {
                this.i = new RectF(1.0f, 1.0f, ((float) getWidth()) - 1.0f, ((float) getHeight()) - 1.0f);
            }
            if (this.e) {
                canvas.drawPath(l.a().a(this.h, (float) this.g), this.u);
                canvas.drawPath(l.a().a(this.i, ((float) this.g) - 1.0f), this.v);
                return;
            }
            canvas.drawPath(l.a().a(this.h, (float) this.g), this.u);
        }
    }

    public Bitmap b() {
        d();
        this.q = new BitmapShader(this.B, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.q.setLocalMatrix(this.w);
        this.u.setShader(this.q);
        Bitmap createBitmap = Bitmap.createBitmap(this.m, this.n, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.g = this.o / 2;
        canvas.drawPath(l.a().a(this.f2100a, (float) this.g), this.u);
        this.k.setBounds(0, 0, this.m, this.n);
        this.k.draw(canvas);
        return createBitmap;
    }

    private void d() {
        this.w.reset();
        float f2 = (float) ((((double) this.o) * 1.0d) / ((double) this.r));
        float f3 = (float) ((((double) this.p) * 1.0d) / ((double) this.s));
        if (f2 <= 1.0f) {
            f2 = 1.0f;
        }
        if (f3 <= 1.0f) {
            f3 = 1.0f;
        }
        float max = Math.max(f2, f3);
        this.w.setScale(max, max);
        Matrix matrix = this.w;
        int i2 = this.t;
        matrix.postTranslate((float) (((int) (((((float) this.o) - (((float) this.r) * max)) * 0.5f) + 0.5f)) + (i2 / 2)), (float) (((int) (((((float) this.p) - (((float) this.s) * max)) * 0.5f) + 0.5f)) + (i2 / 2)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = this.c;
        if (i6 == 1 || i6 == 2) {
            this.h = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.i = new RectF(1.0f, 1.0f, ((float) getWidth()) - 1.0f, ((float) getHeight()) - 1.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.c == 0) {
            int min = Math.min(getMeasuredHeight(), getMeasuredWidth());
            if (min == 0) {
                min = this.y;
            }
            this.y = min;
            int i4 = this.y;
            this.z = ((float) i4) / 2.0f;
            setMeasuredDimension(i4, i4);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        setupShader(drawable);
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        setupShader(this.d.getResources().getDrawable(i2));
    }

    private void setupShader(Drawable drawable) {
        this.A = getDrawable();
        Drawable drawable2 = this.A;
        if (drawable2 == null || drawable == null) {
            if (this.j == null && this.f) {
                this.A = getResources().getDrawable(R.drawable.color_ic_contact_picture);
                this.j = getResources().getDrawable(R.drawable.color_ic_contact_picture);
            } else {
                return;
            }
        } else if (drawable2 != drawable) {
            this.A = drawable;
        }
        this.r = this.A.getIntrinsicWidth();
        this.s = this.A.getIntrinsicHeight();
        this.B = a(this.A);
        if (this.c == 2) {
            this.l = b();
            this.q = new BitmapShader(this.l, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        }
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            this.x = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        }
    }

    private Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public void setType(int i2) {
        if (this.c != i2) {
            this.c = i2;
            invalidate();
        }
    }
}
