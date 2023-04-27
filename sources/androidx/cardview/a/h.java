package androidx.cardview.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;

/* compiled from: RoundRectDrawableWithShadow */
class h extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    static a f511a;

    /* renamed from: b  reason: collision with root package name */
    private static final double f512b = Math.cos(Math.toRadians(45.0d));
    private final int c;
    private Paint d;
    private Paint e;
    private Paint f;
    private final RectF g;
    private float h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private ColorStateList m;
    private boolean n = true;
    private final int o;
    private final int p;
    private boolean q = true;
    private boolean r = false;

    /* compiled from: RoundRectDrawableWithShadow */
    interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public int getOpacity() {
        return -3;
    }

    h(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.o = resources.getColor(R.color.cardview_shadow_start_color);
        this.p = resources.getColor(R.color.cardview_shadow_end_color);
        this.c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.d = new Paint(5);
        b(colorStateList);
        this.e = new Paint(5);
        this.e.setStyle(Paint.Style.FILL);
        this.h = (float) ((int) (f2 + 0.5f));
        this.g = new RectF();
        this.f = new Paint(this.e);
        this.f.setAntiAlias(false);
        a(f3, f4);
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private int d(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    public void setAlpha(int i2) {
        this.d.setAlpha(i2);
        this.e.setAlpha(i2);
        this.f.setAlpha(i2);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    private void a(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 >= 0.0f) {
            float d2 = (float) d(f2);
            float d3 = (float) d(f3);
            if (d2 > d3) {
                if (!this.r) {
                    this.r = true;
                }
                d2 = d3;
            }
            if (this.l != d2 || this.j != d3) {
                this.l = d2;
                this.j = d3;
                this.k = (float) ((int) ((d2 * 1.5f) + ((float) this.c) + 0.5f));
                this.n = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.j, this.h, this.q));
        int ceil2 = (int) Math.ceil((double) b(this.j, this.h, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float a(float f2, float f3, boolean z) {
        return z ? (float) (((double) (f2 * 1.5f)) + ((1.0d - f512b) * ((double) f3))) : f2 * 1.5f;
    }

    static float b(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - f512b) * ((double) f3))) : f2;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.d.getColor() == colorForState) {
            return false;
        }
        this.d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (f2 >= 0.0f) {
            float f3 = (float) ((int) (f2 + 0.5f));
            if (this.h != f3) {
                this.h = f3;
                this.n = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
    }

    public void draw(Canvas canvas) {
        if (this.n) {
            b(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.l / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.l) / 2.0f);
        f511a.a(canvas, this.g, this.h, this.d);
    }

    private void a(Canvas canvas) {
        float f2 = this.h;
        float f3 = (-f2) - this.k;
        float f4 = f2 + ((float) this.c) + (this.l / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.g.width() - f5 > 0.0f;
        boolean z2 = this.g.height() - f5 > 0.0f;
        int save = canvas.save();
        canvas.translate(this.g.left + f4, this.g.top + f4);
        canvas.drawPath(this.i, this.e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.g.width() - f5, -this.h, this.f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.g.right - f4, this.g.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.g.width() - f5, (-this.h) + this.k, this.f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.g.left + f4, this.g.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.g.height() - f5, -this.h, this.f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.g.right - f4, this.g.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.g.height() - f5, -this.h, this.f);
        }
        canvas.restoreToCount(save4);
    }

    private void g() {
        float f2 = this.h;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.k;
        rectF2.inset(-f3, -f3);
        Path path = this.i;
        if (path == null) {
            this.i = new Path();
        } else {
            path.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(-this.h, 0.0f);
        this.i.rLineTo(-this.k, 0.0f);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        float f4 = this.h;
        float f5 = this.k;
        Paint paint = this.e;
        float f6 = f4 + f5;
        int i2 = this.o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.p}, new float[]{0.0f, f4 / (f4 + f5), 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f;
        float f7 = this.h;
        float f8 = this.k;
        int i3 = this.o;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i3, i3, this.p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f.setAntiAlias(false);
    }

    private void b(Rect rect) {
        float f2 = this.j * 1.5f;
        this.g.set(((float) rect.left) + this.j, ((float) rect.top) + f2, ((float) rect.right) - this.j, ((float) rect.bottom) - f2);
        g();
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        a(f2, this.j);
    }

    /* access modifiers changed from: package-private */
    public void c(float f2) {
        a(this.l, f2);
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        float f2 = this.j;
        return (Math.max(f2, this.h + ((float) this.c) + (f2 / 2.0f)) * 2.0f) + ((this.j + ((float) this.c)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public float e() {
        float f2 = this.j;
        return (Math.max(f2, this.h + ((float) this.c) + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.j * 1.5f) + ((float) this.c)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.m;
    }
}
