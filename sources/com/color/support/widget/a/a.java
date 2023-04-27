package com.color.support.widget.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: ColorRoundDrawable */
public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private Paint f2155a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f2156b;
    /* access modifiers changed from: private */
    public boolean c;
    private RectF d;
    private Path e;
    private Path f;
    private C0058a g;
    private PorterDuffColorFilter h;
    private PorterDuffColorFilter i;

    private static int a(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    public int getOpacity() {
        return -3;
    }

    public a() {
        this(new C0058a());
    }

    public a(C0058a aVar) {
        this.f2155a = new Paint(1);
        this.f2156b = new Paint(1);
        this.d = new RectF();
        this.e = new Path();
        this.f = new Path();
        this.g = aVar;
        this.f2155a.setStyle(Paint.Style.FILL);
        this.f2156b.setStyle(Paint.Style.STROKE);
    }

    public void draw(Canvas canvas) {
        this.f2155a.setColorFilter(this.h);
        int alpha = this.f2155a.getAlpha();
        this.f2155a.setAlpha(a(alpha, this.g.h));
        this.f2156b.setStrokeWidth(this.g.g);
        this.f2156b.setColorFilter(this.i);
        int alpha2 = this.f2156b.getAlpha();
        this.f2156b.setAlpha(a(alpha2, this.g.h));
        if (this.c) {
            e();
            f();
            this.c = false;
        }
        if (c()) {
            canvas.drawPath(this.e, this.f2155a);
        }
        if (d()) {
            canvas.drawPath(this.f, this.f2156b);
        }
        this.f2155a.setAlpha(alpha);
        this.f2156b.setAlpha(alpha2);
    }

    private boolean c() {
        Paint paint = this.f2155a;
        return ((paint == null || paint.getColor() == 0) && this.h == null) ? false : true;
    }

    private boolean d() {
        Paint paint = this.f2156b;
        return ((paint == null || paint.getStrokeWidth() <= 0.0f || this.f2156b.getColor() == 0) && this.i == null) ? false : true;
    }

    private void e() {
        this.f = b.a(this.f, a(), this.g.i);
    }

    private void f() {
        this.e = b.a(this.e, a(), this.g.i);
    }

    /* access modifiers changed from: protected */
    public RectF a() {
        this.d.set(getBounds());
        return this.d;
    }

    public void setAlpha(int i2) {
        if (this.g.h != i2) {
            this.g.h = i2;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.g.f2157a != colorFilter) {
            this.g.f2157a = colorFilter;
            invalidateSelf();
        }
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        C0058a aVar = this.g;
        aVar.e = colorStateList;
        this.i = a(colorStateList, aVar.f);
        this.h = this.i;
        b();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        C0058a aVar = this.g;
        aVar.f = mode;
        this.i = a(aVar.e, mode);
        this.h = this.i;
        b();
    }

    public void a(float f2) {
        this.g.i = f2;
    }

    public void a(ColorStateList colorStateList) {
        if (this.g.f2158b != colorStateList) {
            this.g.f2158b = colorStateList;
            onStateChange(getState());
        }
    }

    public void a(int i2) {
        a(ColorStateList.valueOf(i2));
    }

    public void b() {
        this.c = false;
        super.invalidateSelf();
    }

    public void invalidateSelf() {
        this.c = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        return super.isStateful() || (this.g.e != null && this.g.e.isStateful()) || ((this.g.d != null && this.g.d.isStateful()) || ((this.g.c != null && this.g.c.isStateful()) || (this.g.f2158b != null && this.g.f2158b.isStateful())));
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean a2 = a(iArr);
        if (a2) {
            invalidateSelf();
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.c = true;
        super.onBoundsChange(rect);
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private boolean a(int[] iArr) {
        boolean z;
        int color2;
        int colorForState;
        int color3;
        int colorForState2;
        if (this.g.f2158b == null || (color3 = this.f2155a.getColor()) == (colorForState2 = this.g.f2158b.getColorForState(iArr, color3))) {
            z = false;
        } else {
            this.f2155a.setColor(colorForState2);
            z = true;
        }
        if (this.g.c == null || (color2 = this.f2156b.getColor()) == (colorForState = this.g.c.getColorForState(iArr, color2))) {
            return z;
        }
        this.f2156b.setColor(colorForState);
        return true;
    }

    public Drawable.ConstantState getConstantState() {
        return this.g;
    }

    public Drawable mutate() {
        this.g = new C0058a(this.g);
        return this;
    }

    /* renamed from: com.color.support.widget.a.a$a  reason: collision with other inner class name */
    /* compiled from: ColorRoundDrawable */
    static final class C0058a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public ColorFilter f2157a = null;

        /* renamed from: b  reason: collision with root package name */
        public ColorStateList f2158b = null;
        public ColorStateList c = null;
        public ColorStateList d = null;
        public ColorStateList e = null;
        public PorterDuff.Mode f = PorterDuff.Mode.SRC_IN;
        public float g;
        public int h = 255;
        public float i;

        public int getChangingConfigurations() {
            return 0;
        }

        public C0058a() {
        }

        public C0058a(C0058a aVar) {
            this.f2157a = aVar.f2157a;
            this.f2158b = aVar.f2158b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.g = aVar.g;
            this.i = aVar.i;
        }

        public Drawable newDrawable() {
            a aVar = new a(this);
            boolean unused = aVar.c = true;
            return aVar;
        }
    }
}
