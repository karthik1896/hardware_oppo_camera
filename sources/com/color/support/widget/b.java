package com.color.support.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.g.c;
import java.util.Locale;

/* compiled from: ColorCutoutDrawable */
public class b extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f2159a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final RectF f2160b;
    private int c;

    public b() {
        d();
        this.f2160b = new RectF();
    }

    private void d() {
        this.f2159a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f2159a.setColor(-1);
        this.f2159a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public boolean a() {
        return !this.f2160b.isEmpty();
    }

    public RectF b() {
        return this.f2160b;
    }

    public void a(float f, float f2, float f3, float f4) {
        if (f != this.f2160b.left || f2 != this.f2160b.top || f3 != this.f2160b.right || f4 != this.f2160b.bottom) {
            this.f2160b.set(f, f2, f3, f4);
            invalidateSelf();
        }
    }

    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public void c() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void draw(Canvas canvas) {
        a(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f2160b, this.f2159a);
        c(canvas);
    }

    private void a(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (a(callback)) {
            ((View) callback).setLayerType(2, (Paint) null);
        } else {
            b(canvas);
        }
    }

    private void b(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
            return;
        }
        this.c = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
    }

    private void c(Canvas canvas) {
        if (!a(getCallback())) {
            canvas.restoreToCount(this.c);
        }
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }

    /* compiled from: ColorCutoutDrawable */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final boolean f2161a = (Build.VERSION.SDK_INT < 18);

        /* renamed from: b  reason: collision with root package name */
        private static final Paint f2162b = null;
        private float A;
        private float B;
        private float C;
        private float D;
        private int[] E;
        private boolean F;
        private final TextPaint G;
        private final TextPaint H;
        private Interpolator I;
        private Interpolator J;
        private final View c;
        private boolean d;
        private float e;
        private final Rect f;
        private final Rect g;
        private final RectF h;
        private int i = 16;
        private int j = 16;
        private float k = 30.0f;
        private float l = 30.0f;
        private ColorStateList m;
        private ColorStateList n;
        private float o;
        private float p;
        private float q;
        private float r;
        private float s;
        private float t;
        private CharSequence u;
        private CharSequence v;
        private boolean w;
        private boolean x;
        private Bitmap y;
        private Paint z;

        private float a(float f2, float f3, float f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }

        private static float b(float f2, float f3, float f4) {
            return f2 + (f4 * (f3 - f2));
        }

        static {
            Paint paint = f2162b;
            if (paint != null) {
                paint.setAntiAlias(true);
                f2162b.setColor(-65281);
            }
        }

        public a(View view) {
            this.c = view;
            this.G = new TextPaint(129);
            this.H = new TextPaint(this.G);
            this.g = new Rect();
            this.f = new Rect();
            this.h = new RectF();
        }

        public void a(Interpolator interpolator) {
            this.J = interpolator;
            m();
        }

        public void b(Interpolator interpolator) {
            this.I = interpolator;
            m();
        }

        public void a(float f2) {
            if (this.k != f2) {
                this.k = f2;
                m();
            }
        }

        public void a(ColorStateList colorStateList) {
            if (this.n != colorStateList) {
                this.n = colorStateList;
                m();
            }
        }

        public void b(ColorStateList colorStateList) {
            if (this.m != colorStateList) {
                this.m = colorStateList;
                m();
            }
        }

        public Rect a() {
            return this.f;
        }

        public void a(int i2, int i3, int i4, int i5) {
            if (!a(this.f, i2, i3, i4, i5)) {
                this.f.set(i2, i3, i4, i5);
                this.F = true;
                q();
                Log.d("ColorCollapseTextHelper", "setExpandedBounds: " + this.f);
            }
        }

        public Rect b() {
            return this.g;
        }

        public void b(int i2, int i3, int i4, int i5) {
            if (!a(this.g, i2, i3, i4, i5)) {
                this.g.set(i2, i3, i4, i5);
                this.F = true;
                q();
                Log.d("ColorCollapseTextHelper", "setCollapsedBounds: " + this.g);
            }
        }

        public float c() {
            if (this.u == null) {
                return 0.0f;
            }
            a(this.H);
            TextPaint textPaint = this.H;
            CharSequence charSequence = this.u;
            return textPaint.measureText(charSequence, 0, charSequence.length());
        }

        public float d() {
            a(this.H);
            if (Locale.getDefault().getLanguage().equals("my")) {
                return (-this.H.ascent()) * 1.3f;
            }
            return -this.H.ascent();
        }

        public float e() {
            a(this.H);
            float descent = this.H.descent() - this.H.ascent();
            return Locale.getDefault().getLanguage().equals("my") ? descent * 1.3f : descent;
        }

        public void a(RectF rectF) {
            float f2;
            boolean b2 = b(this.u);
            if (!b2) {
                f2 = (float) this.g.left;
            } else {
                f2 = ((float) this.g.right) - c();
            }
            rectF.left = f2;
            rectF.top = (float) this.g.top;
            rectF.right = !b2 ? rectF.left + c() : (float) this.g.right;
            rectF.bottom = ((float) this.g.top) + d();
        }

        private void a(TextPaint textPaint) {
            textPaint.setTextSize(this.l);
        }

        private void q() {
            this.d = this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0;
        }

        public int f() {
            return this.i;
        }

        public void a(int i2) {
            if (this.i != i2) {
                this.i = i2;
                m();
            }
        }

        public int g() {
            return this.j;
        }

        public void b(int i2) {
            if (this.j != i2) {
                this.j = i2;
                m();
            }
        }

        public void a(int i2, ColorStateList colorStateList) {
            this.n = colorStateList;
            this.l = (float) i2;
            m();
        }

        public void a(Typeface typeface) {
            com.color.support.d.b.a((Paint) this.G, true);
            com.color.support.d.b.a((Paint) this.H, true);
            m();
        }

        public float h() {
            return this.e;
        }

        public void b(float f2) {
            float a2 = a(f2, 0.0f, 1.0f);
            if (a2 != this.e) {
                this.e = a2;
                r();
            }
        }

        public final boolean a(int[] iArr) {
            this.E = iArr;
            if (!i()) {
                return false;
            }
            m();
            return true;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = r1.m;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean i() {
            /*
                r1 = this;
                android.content.res.ColorStateList r0 = r1.n
                if (r0 == 0) goto L_0x000a
                boolean r0 = r0.isStateful()
                if (r0 != 0) goto L_0x0014
            L_0x000a:
                android.content.res.ColorStateList r0 = r1.m
                if (r0 == 0) goto L_0x0016
                boolean r0 = r0.isStateful()
                if (r0 == 0) goto L_0x0016
            L_0x0014:
                r0 = 1
                goto L_0x0017
            L_0x0016:
                r0 = 0
            L_0x0017:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.b.a.i():boolean");
        }

        public float j() {
            return this.e;
        }

        /* access modifiers changed from: package-private */
        public float k() {
            return this.k;
        }

        private void r() {
            c(this.e);
        }

        private void c(float f2) {
            d(f2);
            this.s = a(this.q, this.r, f2, this.I);
            this.t = a(this.o, this.p, f2, this.I);
            e(a(this.k, this.l, f2, this.J));
            if (this.n != this.m) {
                this.G.setColor(a(s(), l(), f2));
            } else {
                this.G.setColor(l());
            }
            this.c.postInvalidate();
        }

        private int s() {
            int[] iArr = this.E;
            if (iArr != null) {
                return this.m.getColorForState(iArr, 0);
            }
            return this.m.getDefaultColor();
        }

        public int l() {
            int[] iArr = this.E;
            if (iArr != null) {
                return this.n.getColorForState(iArr, 0);
            }
            return this.n.getDefaultColor();
        }

        private void t() {
            float f2 = this.D;
            f(this.l);
            CharSequence charSequence = this.v;
            float f3 = 0.0f;
            float measureText = charSequence != null ? this.G.measureText(charSequence, 0, charSequence.length()) : 0.0f;
            int a2 = c.a(this.j, this.w ? 1 : 0);
            int i2 = a2 & 112;
            if (i2 != 48) {
                if (i2 != 80) {
                    this.p = ((float) this.g.centerY()) + (((this.G.descent() - this.G.ascent()) / 2.0f) - this.G.descent());
                } else {
                    this.p = (float) this.g.bottom;
                }
            } else if (Locale.getDefault().getLanguage().equals("my")) {
                this.p = ((float) this.g.top) - (this.G.ascent() * 1.3f);
            } else {
                this.p = ((float) this.g.top) - this.G.ascent();
            }
            int i3 = a2 & 8388615;
            if (i3 == 1) {
                this.r = ((float) this.g.centerX()) - (measureText / 2.0f);
            } else if (i3 != 5) {
                this.r = (float) this.g.left;
            } else {
                this.r = ((float) this.g.right) - measureText;
            }
            f(this.k);
            CharSequence charSequence2 = this.v;
            if (charSequence2 != null) {
                f3 = this.G.measureText(charSequence2, 0, charSequence2.length());
            }
            int a3 = c.a(this.i, this.w ? 1 : 0);
            int i4 = a3 & 112;
            if (i4 == 48) {
                this.o = ((float) this.f.top) - this.G.ascent();
            } else if (i4 != 80) {
                this.o = ((float) this.f.centerY()) + (((this.G.descent() - this.G.ascent()) / 2.0f) - this.G.descent());
            } else {
                this.o = (float) this.f.bottom;
            }
            int i5 = a3 & 8388615;
            if (i5 == 1) {
                this.q = ((float) this.f.centerX()) - (f3 / 2.0f);
            } else if (i5 != 5) {
                this.q = (float) this.f.left;
            } else {
                this.q = ((float) this.f.right) - f3;
            }
            v();
            e(f2);
        }

        private void d(float f2) {
            this.h.left = a((float) this.f.left, (float) this.g.left, f2, this.I);
            this.h.top = a(this.o, this.p, f2, this.I);
            this.h.right = a((float) this.f.right, (float) this.g.right, f2, this.I);
            this.h.bottom = a((float) this.f.bottom, (float) this.g.bottom, f2, this.I);
        }

        public void a(Canvas canvas) {
            float f2;
            int save = canvas.save();
            if (this.v != null && this.d) {
                float f3 = this.s;
                float f4 = this.t;
                boolean z2 = this.x && this.y != null;
                if (z2) {
                    f2 = this.A * this.C;
                    float f5 = this.B;
                } else {
                    f2 = this.G.ascent() * this.C;
                    this.G.descent();
                    float f6 = this.C;
                }
                if (z2) {
                    f4 += f2;
                }
                float f7 = f4;
                float f8 = this.C;
                if (f8 != 1.0f) {
                    canvas.scale(f8, f8, f3, f7);
                }
                if (z2) {
                    canvas.drawBitmap(this.y, f3, f7, this.z);
                } else {
                    CharSequence charSequence = this.v;
                    canvas.drawText(charSequence, 0, charSequence.length(), f3, f7, this.G);
                }
            }
            canvas.restoreToCount(save);
        }

        private boolean b(CharSequence charSequence) {
            return w();
        }

        private void e(float f2) {
            f(f2);
            this.x = f2161a && this.C != 1.0f;
            if (this.x) {
                u();
            }
            this.c.postInvalidate();
        }

        private void f(float f2) {
            float f3;
            boolean z2;
            if (this.u != null) {
                float width = (float) this.g.width();
                float width2 = (float) this.f.width();
                if (a(f2, this.l)) {
                    float f4 = this.l;
                    this.C = 1.0f;
                    f3 = f4;
                } else {
                    f3 = this.k;
                    if (a(f2, f3)) {
                        this.C = 1.0f;
                    } else {
                        this.C = f2 / this.k;
                    }
                    float f5 = this.l / this.k;
                    width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                }
                boolean z3 = true;
                if (width > 0.0f) {
                    z2 = this.D != f3 || this.F;
                    this.D = f3;
                    this.F = false;
                } else {
                    z2 = false;
                }
                if (this.v == null || z2) {
                    this.G.setTextSize(this.D);
                    TextPaint textPaint = this.G;
                    if (this.C == 1.0f) {
                        z3 = false;
                    }
                    textPaint.setLinearText(z3);
                    CharSequence ellipsize = TextUtils.ellipsize(this.u, this.G, width, TextUtils.TruncateAt.END);
                    if (!TextUtils.equals(ellipsize, this.v)) {
                        this.v = ellipsize;
                    }
                }
                this.w = w();
            }
        }

        private void u() {
            if (this.y == null && !this.f.isEmpty() && !TextUtils.isEmpty(this.v)) {
                c(0.0f);
                this.A = this.G.ascent();
                this.B = this.G.descent();
                TextPaint textPaint = this.G;
                CharSequence charSequence = this.v;
                int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
                int round2 = Math.round(this.B - this.A);
                if (round > 0 && round2 > 0) {
                    this.y = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(this.y);
                    CharSequence charSequence2 = this.v;
                    canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) round2) - this.G.descent(), this.G);
                    if (this.z == null) {
                        this.z = new Paint(3);
                    }
                }
            }
        }

        public void m() {
            if (this.c.getHeight() > 0 && this.c.getWidth() > 0) {
                t();
                r();
            }
        }

        public void a(CharSequence charSequence) {
            if (charSequence == null || !charSequence.equals(this.u)) {
                this.u = charSequence;
                this.v = null;
                v();
                m();
            }
        }

        /* access modifiers changed from: package-private */
        public CharSequence n() {
            return this.u;
        }

        private void v() {
            Bitmap bitmap = this.y;
            if (bitmap != null) {
                bitmap.recycle();
                this.y = null;
            }
        }

        private static boolean a(float f2, float f3) {
            return Math.abs(f2 - f3) < 0.001f;
        }

        /* access modifiers changed from: package-private */
        public ColorStateList o() {
            return this.m;
        }

        public ColorStateList p() {
            return this.n;
        }

        private static int a(int i2, int i3, float f2) {
            float f3 = 1.0f - f2;
            return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
        }

        private static float a(float f2, float f3, float f4, Interpolator interpolator) {
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            return b(f2, f3, f4);
        }

        private static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
            return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
        }

        private boolean w() {
            if (Build.VERSION.SDK_INT <= 16 || this.c.getLayoutDirection() != 1) {
                return false;
            }
            return true;
        }
    }
}
